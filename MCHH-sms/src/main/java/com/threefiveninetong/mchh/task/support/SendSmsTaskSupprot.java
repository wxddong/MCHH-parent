package com.threefiveninetong.mchh.task.support;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.po.SmsSendedPO;
import com.threefiveninetong.mchh.po.SmsSendedFailPO;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.service.SmsSendedService;
import com.threefiveninetong.mchh.service.SmsSendedFailService;
import com.threefiveninetong.mchh.service.SmsSendingService;
import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;
import com.threefiveninetong.mchh.core.util.IdUtil;
import com.threefiveninetong.mchh.core.util.StringUtil;

@Service("sendSms")
public class SendSmsTaskSupprot {

	Logger smslog= LoggerFactory.getLogger(SendSmsTaskSupprot.class);
	@Resource
	private SmsSendingService smsSendingService;
	
	@Resource
	private SmsSendedFailService smsSendedFailService;
	
	@Resource
	private SmsSendedService smsSendedService;
	
	
	public void SendSms(){
		//查询所有要发的短信，并且将其状态置为1，已发送状态
		List<SmsSendingPO>  smsSendingPOList=smsSendingService.updateAndfindAll();
		
		List<SmsSendedPO> successlist=new ArrayList<SmsSendedPO>();//所有的成功发送短信短信
		List<SmsSendedFailPO> faillist=new ArrayList<SmsSendedFailPO>();//所有的失败发送短信
		
	/*	Map<String,List<SmsSendingPO>> phoneMap=getPhoneMap(polist);//为了解决易美10分钟内发送三条的问题
        if(phoneMap!=null&&phoneMap.size()>0){
         Iterator<Entry<String, List<SmsSendingPO>>> it= phoneMap.entrySet().iterator();
   		   while(it.hasNext()){
   			   Entry<String, List<SmsSendingPO>> entry=  it.next();
   			   List<SmsSendingPO> list=entry.getValue();
   			   int pro=0;//初始级别为0
   			   for (int i = 0; i < list.size(); i++) {
   				   this.SendSms(list.get(i),successlist,faillist,pro);   
   				   if((i+1)%3==0){
   					pro++;   
   				   }
   				
   			 }
   		   }*/
        	
		if(smsSendingPOList!=null&&smsSendingPOList.size()>0){
			for (int i = 0; i < smsSendingPOList.size(); i++) {
				this.SendSms(smsSendingPOList.get(i),successlist,faillist);
			}
			//存储发送成功的数据
			smsSendedService.createList(successlist);
			//存储发送失败的数据，并且记录原因
			smsSendedFailService.createList(faillist);
			//删除sendding表中的已发送过的数据
			if((null!=successlist&&successlist.size()>=1)||(null!=faillist&&faillist.size()>=1)){
				smsSendingService.delete(smsSendingPOList);
			}
		}else{
//			System.out.println("无短信发送！");
		}
	}
	
	
	
	/**
	 * 
	 * @param po
	 * @param successlist
	 * @param failelist
	 * @param pro  级别   为0的时候，默认发送，1的时候由2号平台发送，2往后的时候如果三个可用平台就选用第三个，没有的话，就选用第2个
	 */
	private void SendSms(SmsSendingPO smsSendingPO,List<SmsSendedPO> successlist,List<SmsSendedFailPO> failelist){
		String platformCode="";//自定义平台编码，如：YM
		BaseVoExp baseVoExp=new BaseVoExp();
		if(InitDictionary.NOT_ALLOW_PHONE.contains(smsSendingPO.getReceiver())){//不发送的手机号，即黑名单
			return ;
		}
		smsSendingPO.setContent(smsSendingPO.getContent().trim());//对短信内容进行去空串处理
		smsSendingPO.setReceiver(smsSendingPO.getReceiver().trim());//对短信接收的手机号进行去空串处理
		if(null!=smsSendingPO.getPlatformCode()&&!smsSendingPO.getPlatformCode().equals("")&&!smsSendingPO.getPlatformCode().equals("*")){
			SmsConfigPO smsConfigPO=InitDictionary.getSmsPlateMap().get(smsSendingPO.getPlatformCode().trim());
			if(smsConfigPO!=null){
//				 if(po.getReceiver().equals("15010001180") || po.getReceiver().equals("18611329999")){//加入特殊限制，如果为特殊手机号，则直接用漫道发送 add by ccc
//					 plate = InitDictionary.getSmsPlateMap().get("MD");
//			    	 smslong.info(plate.getName()+"专属特殊限制，直接用漫道发送1：手机号"+po.getReceiver()+" ,内容："+po.getContent());
//			     }
//				 if(po.getContent().contains("VIP")){//VIP用漫道
//					 plate = InitDictionary.getSmsPlateMap().get("MD");
//			    	 smslong.info(plate.getName()+"专属特殊限制，VIP直接用漫道发送1：手机号"+po.getReceiver()+" ,内容："+po.getContent());
//				 }
				 smslog.info(smsConfigPO.getName()+"专属发送************：手机号"+smsSendingPO.getReceiver()+" ,内容："+smsSendingPO.getContent());
				 platformCode=smsConfigPO.getPlatformCode().trim();
				 baseVoExp.setSource(platformCode);//发送短信的平台，自定义平台编码
				 baseVoExp.setSendingPo(smsSendingPO);
				 baseVoExp.setMaxSendNum((int)smsConfigPO.getMaxSendNum());//设置群发短信最大发送量
				 
			     BaseService baseService=ApplicationContextUtil.getBean(platformCode);
			     baseService.SendSms(baseVoExp);
			     
		    	  if(BaseVoExp.Success.equals(baseVoExp.getStatusCode())){
			  		 smslog.info(smsConfigPO.getName()+"专属发送成功：手机号"+smsSendingPO.getReceiver()+" ,内容："+smsSendingPO.getContent());
			  		 successlist.add(convertSuccessSened(baseVoExp));
			  	 }else{
			  		smslog.error(smsConfigPO.getName()+"专属发送失败：手机号"+smsSendingPO.getReceiver()+" ,内容："+smsSendingPO.getContent());
			  		baseVoExp.setFailNum(baseVoExp.getFailNum()+1);
			  		failelist.add(convertFaileFail(baseVoExp)); 
			  	 }
				return ;
			}
		}
		for (int j = 0; j < InitDictionary.getSmsPlate().size(); j++) {
//			j=jumpSendSms(pro,InitDictionary.getSmsPlate().size());
			 SmsConfigPO smsConfigPO=InitDictionary.getSmsPlate().get(j);
//			 if(po.getReceiver().equals("15010001180") || po.getReceiver().equals("18611329999")){//加入特殊限制，如果为特殊手机号，则直接用漫道发送 add by ccc
//				 plate = InitDictionary.getSmsPlateMap().get("MD");
//		    	 smslong.info(plate.getName()+"专属特殊限制，直接用漫道发送2：手机号"+po.getReceiver()+" ,内容："+po.getContent());
//		     }
//			 if(po.getContent().contains("VIP")){//VIP用漫道
//				 plate = InitDictionary.getSmsPlateMap().get("MD");
//		    	 smslong.info(plate.getName()+"专属特殊限制，VIP直接用漫道发送2：手机号"+po.getReceiver()+" ,内容："+po.getContent());
//			 }
			 platformCode=smsConfigPO.getPlatformCode().trim();
//		     smslong.info("跳跃式发送开始"+j+"平台名称"+code);
			 baseVoExp.setSource(platformCode);//设置短信的来源
			 baseVoExp.setSendingPo(smsSendingPO);  
			 baseVoExp.setMaxSendNum((int)smsConfigPO.getMaxSendNum());//设置群发短信最大发送量
		     BaseService baseService=ApplicationContextUtil.getBean(platformCode);//创建对应的短信平台服务
		    
		     boolean isSending=filterSms(smsConfigPO,smsSendingPO);//是否符合发送条件
		     if(!isSending){
		    	 continue;
		     }
		     baseService.SendSms(baseVoExp);
	    	 if(BaseVoExp.Success.equals(baseVoExp.getStatusCode())){
		  		 smslog.info(smsConfigPO.getName()+"发送成功：手机号"+smsSendingPO.getReceiver()+" ,内容："+smsSendingPO.getContent());
		  		 successlist.add(convertSuccessSened(baseVoExp));
		  		 break;
		  	 }else{
		  		 smslog.info(smsConfigPO.getName()+"发送失败：手机号"+smsSendingPO.getReceiver()+" ,内容："+smsSendingPO.getContent());
		  		 baseVoExp.setFailNum(baseVoExp.getFailNum()+1);
		  		 failelist.add(convertFaileFail(baseVoExp)); 
		  		 continue;
		  	 }
	   }
	}
	
	    /**
	     * 将发送成功的senddingpo数据转换为sended表po
	     */
	    private SmsSendedPO convertSuccessSened(BaseVoExp vo){

		  	SmsSendedPO smsSendedPO=new SmsSendedPO();
		  	smsSendedPO.setId(IdUtil.uuid());
	    	smsSendedPO.setPlatformCode(vo.getSource());
	    	smsSendedPO.setContent(vo.getSendingPo().getContent());//短信内容
	    	smsSendedPO.setCreatetime(vo.getSendingPo().getCreatetime());//短信创建时间
	    	smsSendedPO.setSendtime(new Date());
	    	smsSendedPO.setEnterpriseid(vo.getPhoneAndDownIds()[0][1]);//平台返回的短信ID
//		    smsSendedPO.setDownstate(vo.getState()!=null?vo.getState():"0");//下行信息状态
	    	smsSendedPO.setReceiver(vo.getSendingPo().getReceiver());//接收人
	    	smsSendedPO.setSender(vo.getSource());//发送者
	    	smsSendedPO.setSmstype(vo.getSendingPo().getSmstype());//短信类型
	    	smsSendedPO.setSendlevel(vo.getSendingPo().getSendlevel());//短信级别
	    	smsSendedPO.setChannel(vo.getSendingPo().getChannel());//渠道
	    	smsSendedPO.setPlatformCode(vo.getSource());//发送的短信平台
	    	return smsSendedPO;
	    }
	
	    /*
	     * 将发送失败senddingpo数据转换为fail表po
	     */
	    private SmsSendedFailPO convertFaileFail(BaseVoExp vo){
	    	SmsSendedFailPO smsSendedFailPO=new SmsSendedFailPO();
	    	smsSendedFailPO.setId(IdUtil.uuid());
	    	smsSendedFailPO.setPlatformCode(vo.getSource());//发送短信的平台编码
	    	smsSendedFailPO.setContent(vo.getSendingPo().getContent());//短信内容
	    	smsSendedFailPO.setSendtime(new Date());//短信发送时间
	    	smsSendedFailPO.setCreatetime(vo.getSendingPo().getCreatetime());//短信创建时间
	    	smsSendedFailPO.setReceiver(vo.getSendingPo().getReceiver());//短信接收手机号列表
	    	smsSendedFailPO.setSender(vo.getSource());//短信发者，自定义平台编码
	    	smsSendedFailPO.setSmstype(vo.getSendingPo().getSmstype());//短信类似
	    	smsSendedFailPO.setSendlevel(vo.getSendingPo().getSendlevel());//短信级别
	    	smsSendedFailPO.setDescription(vo.getStatusCode()+";"+vo.getMessage());//描述，失败的错误描述
	    	smsSendedFailPO.setChannel(vo.getSendingPo().getChannel());
	    	return smsSendedFailPO;
	    }
	    
	    /**
	     * 对短信做过滤，处理签名
	     * @param plate
	     * @param po
	     * @return
	     */
	    private boolean filterSms(SmsConfigPO plate,SmsSendingPO po){
	    	 String accessPhoneNum=plate.getPhoneAcceped();//可接受的电话号码
		     String accessSmsType=plate.getSmsType();//可接受的短信类型
		     String channel=plate.getChannel();//可接受的渠道
		     String exChannel=plate.getExcludeChannel();//不可接受的渠道
		     String exSmsType=plate.getExcludeSmsType();//不可接受的短信类型
		     
		     if(!StringUtil.isNull(accessSmsType)&&!accessSmsType.equals("*")){
		    	 if(!accessSmsType.contains(po.getSmstype()+"")){
		    		 smslog.info(plate.getName()+"，限定,该短信类型不匹配当前平台,短信类型："+po.getSmstype());
		    		return false;
		    	 }
		     }
		     if(!StringUtil.isNull(exSmsType)){
		    	 if(exSmsType.contains(po.getSmstype()+"")){
		    		 smslog.info(plate.getName()+"，限定,该短信类型不匹配当前平台,短信类型："+po.getSmstype());
		    			return false;
		    	 }
		     }
		     if(!StringUtil.isNull(accessPhoneNum)&&!accessPhoneNum.equals("*")){
		    	 if(!accessPhoneNum.contains(po.getReceiver().substring(0,3))){
		    		 smslog.info(plate.getName()+"，限定,该手机号码不匹配当前平台,手机号为："+po.getReceiver());
		    			return false;
		    	 }
		     }
		     if(!StringUtil.isNull(channel)&&!StringUtil.isNull(po.getChannel())){
		    	 if(!channel.contains(po.getChannel())){
		    		 smslog.info(plate.getName()+"，限定,该渠道不匹配当前平台,渠道号号为："+po.getChannel());
		    			return false;
		    	 }
		     }
		     if(!StringUtil.isNull(exChannel)&&!StringUtil.isNull(po.getChannel())){
		    	 if(exChannel.contains(po.getChannel())){
		    		 smslog.info(plate.getName()+"，限定,该渠道不匹配当前平台,渠道号号为："+po.getChannel());
		    			return false;
		    	 }
		     }
		 	return true;
	    	
	    }
	   
	    /**
	     * 转换手机号   
	     * @param polist
	     * @return  如<13673990286,list>格式
	     * 方便统计同一个手机号要发送多少条短信
	     */
//	    public static   Map<String,List<SmsSendingPO>> getPhoneMap(List<SmsSendingPO>  polist){
//			   Map<String,List<SmsSendingPO>> map=null;
//			   if(polist!=null&&polist.size()>0){
//				   map=new HashMap<String,List<SmsSendingPO>>();
//				   for (int j = 0; j< polist.size(); j++) {
//					   SmsSendingPO po= polist.get(j);
//					   String[] nums=po .getReceiver().split("\\D");
//					   for (int i = 0; i < nums.length; i++) {
//						   if(map.get(nums[i])!=null){
//							   List<SmsSendingPO> list=map.get(nums[i]);
//							   SmsSendingPO npo=new SmsSendingPO();
//							   npo=po.clone();
//							   npo.setReceiver(nums[i]);
//							   System.out.println("转换:手机号"+nums[i]+"对象为："+npo.toString());
//							   list.add(npo);
//						   }else{
//							   List<SmsSendingPO> list=new ArrayList<SmsSendingPO>();
//							   SmsSendingPO npo=new SmsSendingPO();
//							   npo=po.clone();
//							   npo.setReceiver(nums[i]);
//							   System.out.println("新建转换:手机号"+nums[i]+"对象为："+npo.toString());
//							   list.add(npo);
//							   map.put(nums[i],list);
//						   }
//					  }
//				  }
//				   
//			   }
//			   return map;
//			   
//		   }
//	    
//	    public  int jumpSendSms(int pro,int size){
//	    	if(pro>=size){
//	    		pro=(pro-size)%(size-1);
//	    		pro++;
//	    	}
//	    	return pro;
//	    	
//	    }
}
