//package com.threefiveninetong.mchh.send.service;
//
//import java.io.ByteArrayInputStream;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.threefiveninetong.mchh.send.vo.base.BaseService;
//import com.threefiveninetong.mchh.send.vo.base.BaseVo;
//import com.threefiveninetong.mchh.send.vo.base.InitDictionary;
//import com.threefiveninetong.mchh.send.support.GuoDuSingletonClient;
//import com.threefiveninetong.mchh.send.util.GuoduDictionary;
//import com.threefiveninetong.mchh.send.util.SendingControlUtil;
//import com.threefiveninetong.mchh.send.vo.GuoDuSendSmsvo;
//import com.threefiveninetong.mchh.po.SmsSendingPO;
//import com.threefiveninetong.mchh.core.exception.AppException;
//
//@Service("GD")
//public class GuoDuServiceImpl implements  BaseService{
//
//	Logger log=LoggerFactory.getLogger(GuoDuServiceImpl.class);
//
//	/**
//	 * 国都发送短信类
//	 * @param phone
//	 * @param content
//	 * @return
//	 * @throws Exception
//	 */
//	public BaseVo SendSms(SmsSendingPO po,BaseVo vo){
//		try {
//			String[] phoneNums=SendingControlUtil.ConverToManyPhone(po.getReceiver(), vo.getMaxSendNum(),InitDictionary.GUODU_REGEX);
//			if(phoneNums!=null){
//		    for (int i = 0; i < phoneNums.length; i++) {
//			String result=GuoDuSingletonClient.getClient().SendSms(phoneNums[i],po.getContent());
//			GuoDuSendSmsvo gdvo=getCode(result);
//		    log.info("国都返回结果为"+gdvo.getCode()+"  发送短信内容："+po.getContent()+"  手机号："+phoneNums[i]);
//			 if(gdvo!=null){
//				 if("03".equals(gdvo.getCode())){
//					 vo.setErrorCode(BaseVo.Success);
//				 }else{
//					 vo.setErrorCode(gdvo.getCode());
//				 }
//				 vo.setErrorMsg(gdvo.getDescription());
//				 vo.setMasDownId(gdvo.getSmsId());
//			 }
//			    Thread.sleep(2000);;//没执行一次睡眠2秒钟
//		    }
//		    }
//		} catch (Exception e) {
//			vo.setErrorCode(InitDictionary.EXCEPTIONID);
//		    vo.setErrorMsg(InitDictionary.EXCEPTIONMSG);
//			e.printStackTrace();
//		}
//		 return vo;
//	}
//	
//
//	/**
//	 * 获取国都短信剩余条数
//	 * @return
//	 */
//	public  double getBalance(){
////		<?xml version="1.0" encoding="GBK"?><resRoot><rcode>27</rcode></resRoot>
//		try {
//			return GuoDuSingletonClient.getClient().getBalance();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return InitDictionary.EXCEPTIONBALANCE;
//		}
//	}
//	/**z
//	 * 修改密码
//	 * @throws Exception
//	 */
//	public void MotifyPassword()throws Exception{
//		GuoDuSingletonClient.getClient().MotifyPassword();
//	}
//
//	@Override
//	public void warnSms() {
//		// TODO Auto-generated method stub
//		
//	}
//	/**
//	 * 国都发送短息帮助类
//	 * @param result
//	 * @return
//	 * @throws Exception
//	 */
//	public static  GuoDuSendSmsvo getCode(String result) throws Exception{
//		GuoDuSendSmsvo codeMap=null;
//		String code=null;
//		String smsid=null;
//		String value=null;
//		if(result!=null&&!"".equals(result)){
//		codeMap	=new GuoDuSendSmsvo();
//		SAXReader sax=new SAXReader();
//		ByteArrayInputStream by=new ByteArrayInputStream(result.getBytes());
//		Document doc = null;
//		try {
//			doc=sax.read(by);
//			Element ele=doc.getRootElement();
//			Element codeele=ele.element("code");
//			Element id=(Element) ele.selectSingleNode("message/msgid");    
//			if(id!=null){
//				smsid=id.getText();
//			}
//			if(codeele!=null)
//			code=codeele.getText();
//		} catch (DocumentException e) {
//			e.printStackTrace();
//			throw new AppException(e.getMessage());
//		}
//	
//		if(code!=null){
//			value=GuoduDictionary.errorMap.get("A"+code);
//		}
//		if(value==null){
//			value=GuoduDictionary.errorNOU;	
//		}
//		codeMap.setCode(code);
//		codeMap.setDescription(value);
//		codeMap.setSmsId(smsid);
//		}//if结束
//		return codeMap;
//	}
//
//
//	@Override
//	public void controlReceive(Object obj) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public Object controlReport(Object obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
