package com.threefiveninetong.mchh.send.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.send.support.ChunLinSingletonClient;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.SendingControlUtil;
import com.threefiveninetong.mchh.send.vo.CLQueryMoney;
import com.threefiveninetong.mchh.send.vo.CLSendMsgResult;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;


@Service("CL")
public class ChunLinServiceImpl implements BaseService{

	@Override
	public BaseVoExp SendSms(BaseVoExp vo){
		SmsSendingPO po=vo.getSendingPo();
		po.setContent(SendingControlUtil.cutSmsContent(po.getContent(),false));
		try {
			String[] phoneNums=SendingControlUtil.ConverToManyPhone(po.getReceiver(), vo.getMaxSendNum(),InitDictionary.CHUNLIN_REGEX);
			if(phoneNums!=null){
		    for (int i = 0; i < phoneNums.length; i++) {
		    	CLSendMsgResult cls=ChunLinSingletonClient.getClient().SendSms(phoneNums[i],po.getContent());
				if(cls!=null){
					vo.setStatusCode(cls.getErrCode());
					vo.setMessage(cls.getErrMsg());
					if(cls.getIds()!=null&&cls.getIds().length>0){
						String[][]phoneAndDownIds=new String[cls.getIds().length][2];
						String[] phones=phoneNums[i].split(InitDictionary.CHUNLIN_REGEX);
					    for (int j = 0; j < cls.getIds().length; j++) {
					    	phoneAndDownIds[j][0]=phones[j];
					    	phoneAndDownIds[j][1]=cls.getIds()[j];
						}
					    vo.addPhoneAndDownIds(phoneAndDownIds);
					}
				}
				Thread.sleep(2000);//没执行一次睡眠2秒钟
			}
			}
		} catch (Exception e) {
			vo.setStatusCode(InitDictionary.EXCEPTIONID);
		    vo.setMessage(InitDictionary.EXCEPTIONMSG);
			e.printStackTrace();
		}
		return vo;
		
		
	}


	@Override
	public double getBalance(){
		try {
			CLQueryMoney clr=ChunLinSingletonClient.getClient().getBalance();
			if(clr!=null&&"0".equals(clr.getErrCode())){
				return Double.valueOf(clr.getCount1()!=null?clr.getCount1():"0")+Double.valueOf(clr.getCount2()!=null?clr.getCount2():"0");
			}
			return InitDictionary.EXCEPTIONBALANCE;
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
