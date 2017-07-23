//package com.threefiveninetong.mchh.send.support;
//
//import java.io.ByteArrayInputStream;
//import java.net.URLEncoder;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//
//import com.threefiveninetong.mchh.send.vo.base.InitDictionary;
//import com.threefiveninetong.mchh.send.util.GuoduDictionary;
//import com.threefiveninetong.mchh.core.exception.AppException;
//import com.threefiveninetong.mchh.core.util.SendurlUtil;
//
//
//public class GuoDuClient {
//
//	private String OperID;
//	private String OperPass;
//	
//	public GuoDuClient(String OperID,String OperPass){
//		this.OperID=OperID;
//		this.OperPass=OperPass;
//	}
//	
//	/**
//	 * 国都发送短信类
//	 * @param phone
//	 * @param content
//	 * @return
//	 * @throws Exception
//	 */
//	public String SendSms(String phone,String content) throws Exception{
//		 StringBuffer sb=new StringBuffer();
//	        sb.append("OperID="+OperID);
//	        sb.append("&OperPass="+OperPass);
//	        sb.append("&SendTime=");
//	        sb.append("&ValidTime=");
//	        sb.append("&AppendID="+GuoduDictionary.AppendID);
//	        sb.append("&DesMobile="+phone);
//	        content=URLEncoder.encode(content,InitDictionary.GDCHARSET);
//	        sb.append("&Content="+content);
//	        sb.append("&ContentType="+GuoduDictionary.ContentType);
//	     String rusult=SendurlUtil.postSendUrl(GuoduDictionary.sendingUrl,sb.toString(),InitDictionary.GDCHARSET);
//	     return rusult;
//	}
//
//
//	/**
//	 * 获取国都短信剩余条数
//	 * @return
//	 */
//	public  double getBalance()throws Exception{
//		 double num=0;
//		 StringBuffer sb=new StringBuffer();
//	        sb.append("OperID="+OperID);
//	        sb.append("&OperPass="+OperPass);
//	     String result=   SendurlUtil.postSendUrl(GuoduDictionary.QueryAvUrl,sb.toString(),InitDictionary.GDCHARSET);
//	     if(result!=null&&!"".equals(result)){
//		 		SAXReader sax=new SAXReader();
//		 		ByteArrayInputStream by=new ByteArrayInputStream(result.getBytes());
//		 		Document doc = null;
//		 		try {
//		 			doc=sax.read(by);
//		 			Element ele=doc.getRootElement();
//		 			Element codeele=ele.element("rcode");
//		 			if(codeele!=null){
//		 				num=codeele.getText()!=null?Double.valueOf(codeele.getText()):InitDictionary.EXCEPTIONBALANCE;
//		 			}else{
//		 				num=InitDictionary.EXCEPTIONBALANCE;
//		 			}
//
//		 		} catch (DocumentException e) {
//		 			e.printStackTrace();
//		 			throw new AppException(e.getMessage(),e);
//		 		}
//		 		
//		     }else{
//		    	 num=InitDictionary.EXCEPTIONBALANCE;
//		     }
//	     
//	     
//	     
//	     
//	     return num;
//	}
//	/**
//	 * 修改密码
//	 * @throws Exception
//	 */
//	public void MotifyPassword()throws Exception{
//		StringBuffer sb=new StringBuffer();
//		  	sb.append("OperID="+OperID);
//	        sb.append("&OperPass="+OperPass);//旧密码
//	        sb.append("&OperPassNew=ssssss");//新密码
//	 String rusult=   SendurlUtil.postSendUrl(GuoduDictionary.motifyPasswordUrl,sb.toString(),InitDictionary.GDCHARSET);
//}
//	
//	public void controlReport() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public void controlReceive() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public void warnSms() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
