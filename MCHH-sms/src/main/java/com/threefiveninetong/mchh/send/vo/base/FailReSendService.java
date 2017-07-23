package com.threefiveninetong.mchh.send.vo.base;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendedPO;
import com.threefiveninetong.mchh.po.SmsSendedFailPO;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.service.SmsDownstateService;
import com.threefiveninetong.mchh.service.SmsSendedService;
import com.threefiveninetong.mchh.service.SmsSendedFailService;
import com.threefiveninetong.mchh.task.support.DownSmsTaskSupprot;
import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;
import com.threefiveninetong.mchh.core.util.DateUtil;
/**
 * 
 * 失败后重新补发的类
 * @author liyg
 * 
 */
public abstract class FailReSendService {
	
	 Logger smslong= LoggerFactory.getLogger(FailReSendService.class);
	@Resource
	protected SmsSendedService smsSendedServiceImpl;
	
	@Resource
	protected SmsSendedFailService SmsSendedfailServiceImpl;
	
	@Resource
	protected SmsSendedFailService smsSendedfailServiceImpl;
	
	@Resource
	protected SmsDownstateService smsDownstateServiceImpl;
	
	public abstract void updateSmsTypeAndSendSecond(SmsDownstatePO masDeliver);
	
	/**
	 * 补发具体流程
	 * @param masDeliver
	 */
	protected void operateMas(SmsDownstatePO masDeliver) {
		if (!"0".equals(masDeliver.getDownstate())){
			int minute=DateUtil.getMinutes(masDeliver.getCreatetime(), masDeliver.getReceivetime());//超时不在补发
			if(minute>30){//如果超过30分钟，不再补发
				smslong.info("补发收到时间超过30分钟，不再补发："+masDeliver.getPlatformCode()+"平台；下行id"+masDeliver.getMasdownmsgid());
				return ;
			}
			SmsConfigPO plate=InitDictionary.getSmsPlateMap().get(masDeliver.getPlatformCode());
			BaseService baseCo=ApplicationContextUtil.getBean(plate.getFailCode().trim());
			smslong.info("进入补发状态："+masDeliver.getPlatformCode()+"平台；下行id"+masDeliver.getMasdownmsgid());
			Map<String,Object> map=new HashMap<String,Object>(); 
			map.put("sender",masDeliver.getPlatformCode());
			map.put("masdownmsgid",masDeliver.getMasdownmsgid().trim());
			if(masDeliver.getPhone().length()==13){
				masDeliver.setPhone(masDeliver.getPhone().substring(2));
			}
			map.put("receiver",masDeliver.getPhone());
			List<SmsSendedPO> polist=smsSendedServiceImpl.findByContidions(map);
		    if(polist!=null&&polist.size()>0){
		    	for (int i = 0; i < polist.size(); i++) {
		    		SmsSendedPO btsfSend=polist.get(i);
		    		if(!InitDictionary.NOT_ALLOW_SMSTYPE.contains(btsfSend.getSmstype()+"")){
		    		if(btsfSend!=null&&Integer.valueOf(btsfSend.getDownstate())<Integer.valueOf(plate.getFailnum())){
		    		btsfSend.setDownstate((Integer.valueOf(btsfSend.getDownstate())+1)+"");
		    		try {
						SmsSendingPO po =new SmsSendingPO();
						po.setContent(btsfSend.getContent());
						po.setReceiver(btsfSend.getReceiver());
						po.setSmstype(btsfSend.getSmstype());
						po.setChannel(btsfSend.getChannel());
						btsfSend.setSender(plate.getFailCode().trim());
						boolean isSending=filterSms(InitDictionary.getSmsPlateMap().get(plate.getFailCode().trim()),po);
						if(isSending){
							continue;
						}
						BaseVoExp vo=new BaseVoExp();
						vo.setMaxSendNum((int)plate.getMaxSendNum());//设置群发短信最大发送量
						vo.setSendingPo(po);
			    		baseCo.SendSms(vo);
						btsfSend.setMasdownmsgid(vo.getPhoneAndDownIds()[0][1]);
						smslong.info("进入"+plate.getName()+"发送失败补发信息：补发平台名称"+InitDictionary.getSmsPlateMap().get(plate.getFailCode().trim()).getName()+"：手机号"+po.getReceiver()+",内容："+po.getContent()+";失败次数"+btsfSend.getDownstate());
					} catch (Exception e) {
						smslong.error(plate.getFailCode()+"平台补发短信异常，跳过数据库"+"：手机号"+btsfSend.getReceiver()+",内容："+btsfSend.getContent());
						smslong.error(e.getMessage());
						e.printStackTrace();
					}
					smsSendedServiceImpl.updateList(polist);
				}else{
					SmsSendedFailPO po=new SmsSendedFailPO();
					po.setPlatformCode(btsfSend.getPlatformCode());
					po.setContent(btsfSend.getContent());
					po.setSender(btsfSend.getSender());
					po.setReceiver(btsfSend.getReceiver());
					po.setSmstype(btsfSend.getSmstype());
					po.setCreatetime(btsfSend.getCreatetime());
					po.setCreatetime(new Date());
					po.setDescription(plate.getFailnum()+"次发送失败");
					po.setSmstype(btsfSend.getSmstype());
					po.setSendlevel(btsfSend.getSendlevel());
					smsSendedServiceImpl.delete(btsfSend.getId());
					smsSendedfailServiceImpl.create(po);
				  }
		    	}
				}
		    }
		}
	}	 
	 /**
     * 对短信做过滤
     * @param plate
     * @param po
     * @return
     */
    private boolean filterSms(SmsConfigPO plate,SmsSendingPO po){
    	 String accessPhoneNum=plate.getPhoneAcceped();//可接受的电话号码
	     String accessSmsType=plate.getSmsType();//可接受的短信类型
	     String channel=plate.getChannel();//可接受的渠道
	     String exChannel=plate.getExcludeChannel();//不可接受的渠道
//	     String exPhone=plate.getExcludePhone();//手机黑名单,等以后完善，暂时先不做
	     String exSmsType=plate.getExcludeSmsType();//不可接受的短信类型
	     if(!StringUtils.isEmpty(accessSmsType)&&!accessSmsType.equals("*")){
	    	 if(!accessSmsType.contains(po.getSmstype()+"")){
	    		 smslong.info(plate.getName()+"，隆畅达限定,该短信类型不匹配当前平台,短信类型："+po.getSmstype());
	    		return false;
	    	 }
	     }
	     if(!StringUtils.isEmpty(accessPhoneNum)&&!accessPhoneNum.equals("*")){
	    	 if(!accessPhoneNum.contains(po.getReceiver().substring(0,3))){
	    		 smslong.info(plate.getName()+"，隆畅达限定,该手机号码不匹配当前平台,手机号为："+po.getReceiver());
	    			return false;
	    	 }
	     }
	     if(!StringUtils.isEmpty(channel)&&!StringUtils.isEmpty(po.getChannel())){
	    	 if(!channel.contains(po.getChannel())){
	    		 smslong.info(plate.getName()+"，隆畅达限定,该渠道不匹配当前平台,渠道号号为："+po.getChannel());
	    			return false;
	    	 }
	     }
	     if(!StringUtils.isEmpty(exChannel)&&!StringUtils.isEmpty(po.getChannel())){
	    	 if(exChannel.contains(po.getChannel())){
	    		 smslong.info(plate.getName()+"，隆畅达限定,该渠道不匹配当前平台,渠道号号为："+po.getChannel());
	    			return false;
	    	 }
	     }
	     if(!StringUtils.isEmpty(exSmsType)){
	    	 if(exSmsType.contains(po.getSmstype()+"")){
	    		 smslong.info(plate.getName()+"，隆畅达限定,该短信类型不匹配当前平台,短信类型："+po.getSmstype());
	    			return false;
	    	 }
	     }
	 	return true;
    	
    }
	
	
	
	
	

}
