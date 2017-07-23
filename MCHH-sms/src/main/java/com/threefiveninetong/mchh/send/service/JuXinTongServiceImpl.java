package com.threefiveninetong.mchh.send.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.send.support.JuXinTongSingletonClient;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.SendingControlUtil;
import com.threefiveninetong.mchh.send.vo.SendResultVo;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.core.util.DateUtil;
import com.threefiveninetong.mchh.core.util.PropertyUtil;
@Service("JX")
public class JuXinTongServiceImpl implements BaseService {

	Logger log= LoggerFactory.getLogger(JuXinTongServiceImpl.class);
	@Override
	public BaseVoExp SendSms(BaseVoExp vo){
		try {
			SmsSendingPO po=vo.getSendingPo();
			po.setContent(SendingControlUtil.cutSmsContent(po.getContent(),true));
			String[] phoneNums=SendingControlUtil.ConverToManyPhone(po.getReceiver(), vo.getMaxSendNum(),InitDictionary.JUXINTONG_REGEX);
			if(phoneNums!=null){
		    for (int i = 0; i < phoneNums.length; i++) {
		    log.info("聚信通发送短信："+"  ;发送短信内容："+po.getContent()+"  ；手机号："+ArrayUtils.toString(phoneNums[i]));
		    List<SendResultVo> result=JuXinTongSingletonClient.getClient().SendSms(phoneNums[i],po.getContent());
			if(result!=null&&result.size()>0){
				String[][] phoneAndIds=new String[result.size()][2];
				for (int j = 0; j < result.size(); j++) {
					SendResultVo rvo=result.get(j);
					log.info("聚信通返回结果："+rvo.getStatusCode()+";返回错误消息："+rvo.getMessage()+"  ;发送短信内容："+po.getContent()+"  ；手机号："+rvo.getPhone()+"  ;downId:"+rvo.getMasDownId());
				    vo.setStatusCode(rvo.getStatusCode());
				    vo.setMessage(rvo.getMessage());
				    phoneAndIds[j][0]=rvo.getPhone().trim();
				    phoneAndIds[j][1]=rvo.getMasDownId().trim();
				}
				 vo.addPhoneAndDownIds(phoneAndIds);
			}
		    Thread.sleep(2000);;//没执行一次睡眠2秒钟
		    }
			}
		} catch (Exception e) {
			vo.setStatusCode(InitDictionary.EXCEPTIONID);
		    vo.setMessage(InitDictionary.EXCEPTIONMSG);
			e.printStackTrace();
		}
		return vo;//
	}

	@Override
	public double getBalance(){
		try {
			return  Double.valueOf(JuXinTongSingletonClient.getClient().getBalance());
		} catch (Exception e) {
			e.printStackTrace();
			return InitDictionary.EXCEPTIONBALANCE;
		}
	}

	@Override
	public List<SmsDownstatePO> controlReport(Object obj){
		List<SmsDownstatePO> downList=null; 
		try {
			// 182100574681406261520193860596|18210057468|0
//			返回-1：用户名不存在,-2密码错误,-3系统异常，-4无未取状态
			String statusReport = JuXinTongSingletonClient.getClient()
			.controlReport();
			if(statusReport!=null&&!statusReport.contains("-")){
				String[] reports=statusReport.split("\\s");
				if(reports!=null&&reports.length>0){
					downList=new ArrayList<SmsDownstatePO>();
					for (int i = 0; i <reports.length; i++) {
						String[] reportOne =reports[i].split("\\|");
						if(reportOne!=null&&reportOne.length==3){
						SmsDownstatePO masDeliver=new SmsDownstatePO();
						masDeliver.setMasdownmsgid(reportOne[0]);
	    				masDeliver.setPlatformCode(PropertyUtil
	    						.getProperty().getString("JUXINMARK"));// ("GuoDuDelever");
	    				if("0".equals(reportOne[2])){
	    					masDeliver.setDownstate("0");
	    				}else{
	    					log.error("聚信通返回非正常状态：   "+reports[i]);	
	    					masDeliver.setDownstate("1");
	    				}
	    				masDeliver.setIsresend("0");
	    				masDeliver.setReceivetime(DateUtil.addDay(new Date(), 1));//聚信通反应速度慢，一律不补发
	    				masDeliver.setPhone(reportOne[1]);
	    				masDeliver.setCreatetime(new Date());
	    				downList.add(masDeliver);
						}
					}
				}
				
			}
			return downList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void warnSms() {

	}

	@Override
	public void controlReceive(Object obj) {
	}
    
	
	
}
