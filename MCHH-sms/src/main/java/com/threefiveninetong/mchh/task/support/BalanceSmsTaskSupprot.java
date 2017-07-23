package com.threefiveninetong.mchh.task.support;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.service.SmsConfigService;
import com.threefiveninetong.mchh.service.SmsSendingService;
import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;
import com.threefiveninetong.mchh.core.util.DateUtil;
import com.threefiveninetong.mchh.core.util.MailUtils;

@Service("balanceSms")
public class BalanceSmsTaskSupprot {
	@Resource
	private SmsSendingService smsSendingService;
	
	@Resource
	private SmsConfigService smsConfigService;
	
	Logger log= LoggerFactory.getLogger(BalanceSmsTaskSupprot.class);
	
	public void getBalance() {
		String platformCode="";//自定义平台编码
		BaseVoExp baseVoExp=new BaseVoExp();
		for (int j = 0; j < InitDictionary.getSmsPlate().size(); j++) {
			 Map<String,Object> map=new HashMap<String,Object>();
			 
			 SmsConfigPO smsConfigPO=InitDictionary.getSmsPlate().get(j);
			 platformCode=smsConfigPO.getPlatformCode().trim();//自定义平台编码
			 baseVoExp.setSource(platformCode);//设置短信的来源
			 
			 log.info("读取短信余额配置时相应平台信息："+smsConfigPO.toString());
			 
			 double notiyBalace=Double.valueOf(smsConfigPO.getBalanceNotify());//当短信余额低于多少的时候，及时通知需要通知的人
			 
		     BaseService baseService=ApplicationContextUtil.getBean(platformCode);
		     double balance=baseService.getBalance();//调用相关接口查询短信余额
		     
		     if(InitDictionary.EXCEPTIONBALANCE==balance){
            	log.error(smsConfigPO.getName()+"获取短信余额出错，请检查相关代码"); 
             }else{
            	 map.put("id",smsConfigPO.getId());
            	 
            	 if(balance!=InitDictionary.NOBALANCE){//判断短信平台是否提供该接口
            		 map.put("balance","截止到："+DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss")+"，"+smsConfigPO.getName().trim()+"短信余额："+balance+"条");
	            	 log.info(smsConfigPO.getName()+"剩余短信条数为："+balance);
	            	 
	            	 if(balance < notiyBalace){//判断是否报警，小于报警界限，报警
	
	            		 this.sendWarn(smsConfigPO,balance);
	            		
	            	 }
            	 }else{//未提供余额查询接口
            		 map.put("balance","该平台没有获取余额接口");
            	 }
            	 
            	 smsConfigService.updateByParams(map);
             }   
	   }
	}
	
	/**
	 * 短信余额不足，发报警（短信或邮件）
	 * @param smsConfigPOList //短信平台列表（空）
	 * @param smsConfigPO //当前短信平台
	 * @param balace 短信余额
	 */
	private void sendWarn(SmsConfigPO smsConfigPO,double balace) {
		String notifyer=smsConfigPO.getNotifyer();//格式如 李三:159468734/王五:153397422/赵四:dingjianhua@devsource.com.cn
		
		if(StringUtils.isNotEmpty(notifyer)&&StringUtils.contains(notifyer,":")){//报警人列表
			String[] notiyers=notifyer.split("/");
			if(notiyers!=null&&notiyers.length>0){
				for (int i = 0; i < notiyers.length; i++) {
					String[] onePeople=notiyers[i].split(":");
					if(onePeople!=null&&onePeople.length==2){//读取所有的通知人信息
						String content=onePeople[0]+"您好，"+"短信余额为："+balace+
						"，请注意充值。"; 
						if(onePeople[1].contains("@")){//发报警邮件
							MailUtils.sendMail(onePeople[1], content);
						}else{//发报警短信
							smsSendingService.createByPhoneAndContent(onePeople[1],content,"110");
						}

						log.info("发送短信余额不足报警信息内容："+content);
					}
				}
			}
        	
         }
	}
}
