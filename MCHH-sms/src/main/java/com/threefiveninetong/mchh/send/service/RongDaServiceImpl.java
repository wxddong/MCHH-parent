package com.threefiveninetong.mchh.send.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.send.support.RongDaSingletonClient;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.SendingControlUtil;
import com.threefiveninetong.mchh.send.vo.SendResultVo;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;

@Service("RD")
public class RongDaServiceImpl implements BaseService{
	Logger log= LoggerFactory.getLogger(RongDaServiceImpl.class);
	@Override
	public BaseVoExp SendSms(BaseVoExp vo){
		    try {
		    	SmsSendingPO po=vo.getSendingPo();
				po.setContent(SendingControlUtil.cutSmsContent(po.getContent(),false));
		    	String[] phoneNums=SendingControlUtil.ConverToManyPhone(po.getReceiver(), vo.getMaxSendNum(),InitDictionary.RONGDA_REGEX);
				if(phoneNums!=null){
			    for (int i = 0; i < phoneNums.length; i++) {
			    SendResultVo result=RongDaSingletonClient.getClient().SendSms(phoneNums[i],po.getContent());
				log.info("容大返回结果："+result.getStatusCode()+";返回错误消息："+result.getMessage()+"  ;发送短信内容："+po.getContent()+"  ；手机号："+po.getReceiver()+"  ;downId:"+result.getMasDownId());
			    vo.setStatusCode(result.getStatusCode());
			    vo.setMessage(result.getMessage());
			    String[] phones=phoneNums[i].split(InitDictionary.RONGDA_REGEX);
			    String[][]phoneAndDownIds=new String[phones.length][2];
			    for (int j = 0; j < phones.length; j++) {
			    	phoneAndDownIds[j][0]=phones[j];
			    	phoneAndDownIds[j][1]=result.getMasDownId();
				}
				    vo.addPhoneAndDownIds(phoneAndDownIds);
			    Thread.sleep(2000);
			    }
			    }
			} catch (Exception e) {
				vo.setStatusCode(InitDictionary.EXCEPTIONID);
			    vo.setStatusCode(InitDictionary.EXCEPTIONMSG);
				e.printStackTrace();
			}
			return vo;
		    
	}

	@Override
	public double getBalance(){
		  try {
			  String balance=RongDaSingletonClient.getClient().getBalance();
			  return Double.valueOf(balance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return InitDictionary.EXCEPTIONBALANCE;
		}
	}

	@Override
	public void controlReceive(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SmsDownstatePO> controlReport(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void warnSms() {
		// TODO Auto-generated method stub
		
	}

}
