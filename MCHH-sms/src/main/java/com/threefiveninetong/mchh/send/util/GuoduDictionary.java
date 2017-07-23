package com.threefiveninetong.mchh.send.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GuoduDictionary {
	
	//一级平台	public  final static String sendingUrl="http://221.179.180.158:9002/QxtSms/QxtFirewall";
//		public  final static String sendingUrl="http://218.241.67.233:9002/QxtSms/QxtFirewall";
//		public  final static String  QueryAvUrl="http://221.179.180.158:9002/QxtSms/surplus";
//		public  final static String  motifyPasswordUrl="http://221.179.180.158:9002/QxtSms/QxtSetOperPass";
		
		public  final static String sendingUrl="http://218.241.67.233:9001/QxtSms/QxtFirewall";
		public  final static String  QueryAvUrl="http://221.179.180.158:9001/QxtSms/surplus";
		public  final static String  motifyPasswordUrl="http://221.179.180.158:9001/QxtSms/QxtSetOperPass";
	//二级平台	public  final static String sendingUrl="http://221.179.180.158:9000/QxtSms/QxtFirewall";
//		public  final static String  QueryAvUrl="http://221.179.180.158:9000/QxtSms/surplus";
//		public  final static String  motifyPasswordUrl="http://221.179.180.158:9000/QxtSms/QxtSetOperPass";
		
		public static  String curSendDate="";
		public static final Integer CLERROR_NUMBER=-1111;
//		public static final Boolean whoFirst=true;//发送短信的谁先发送，true：国都先发送，false春霖先发送
//		public static final  String OperID="bjlcd";//一级
//		public static final  String OperPass="123456";//一及密码
		
//		public static final  String OperID="bjlcd1";//二级
//		public static final  String OperPass="lcd2012#";//二期密码
		
		public static final  String OperID="bjlcd2";//9001对应账户
		public static final  String OperPass="liu1113";//9001对应密码
		
		public static final  String AppendID="88";//
		public static final  String ContentType="8";//
		public static final  String errorNOU="未知的错误";//
		public static final  String tuisongSmsType="666";//
		//===============短信发送错误集锦
		public static final String GD_sender="106575011413344351";
		
		
		public static final String GUODUSEND="GUODUSending";
		public static final String GUODUFIND="GUODUFind";
		public static final String GUODURECEIVE="GUODUReceive";
		public static final String GUODUBALANCE="GUODUBalance";
		public static final String SECONDSENDING="GUODUSECOND";
		public static final String SECONDSENDINGEXCEPTION="SECONDEXCEPTION";
		public static final String SECONDSENDINGLOG="DELIVERLOG";
		public static final String SECONDLOGEXCEPTION="DELIVERLOGEXCEPTION";
		public static final Map<String,String> errorMap=new HashMap<String,String>();
		public static final String PHONEGENERATOR="111";
		public static final String PHONESUCESS="113";
		public static final boolean PHONEFIRST=true;
		
		static{
			errorMap.put("A00","批量短信提交成功（批量短信待审批）");            
			errorMap.put("A01","批量短信提交成功（批量短信跳过审批环节）");         
			errorMap.put("A03","单条短信提交成功");                     
			errorMap.put("A04","用户名错误");                        
			errorMap.put("A05","密码错误");                         
			errorMap.put("A06","剩余条数不足");                       
			errorMap.put("A07"," 信息内容中含有限制词(违禁词)");             
			errorMap.put("A08","信息内容为黑内容");                     
			errorMap.put("A09","该用户的该内容 受同天内内容不能重复发 限制");       
			errorMap.put("A10"," 批量下限不足");                      
			errorMap.put("A97","短信参数有误");                       
			errorMap.put("A98","防火墙无法处理这种短信");   
			errorMap.put("A-9999","查寻余额时短信密码不正确或者其他问题");  
			
			
		}
		//===============短信查询余额错误集锦	
		
		public static void main(String[] args) {
			Set<String> tt=errorMap.keySet();
			
			
		}
}
