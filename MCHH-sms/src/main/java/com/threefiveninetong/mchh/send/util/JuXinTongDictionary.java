package com.threefiveninetong.mchh.send.util;

import java.util.HashMap;
import java.util.Map;



public class JuXinTongDictionary {
	
	public static String SENDING_URL="http://116.90.87.221/qxt_jtd/sendSmsUTF8.jsp";
	public static String BALANCE_URL="http://116.90.87.221/qxt_jtd/getBalance";
	public static String REPORT_URL="http://116.90.87.221/qxt_jtd/getReport";
	public static String name="lcdkj";
	public static String pwd="lcd#2014";
	public static String smsId="2";
//	static String uuid="";
	
	public static final Map<String,String> JuXinTongErrorMap=new HashMap<String,String>();
	///返回-1：用户名不存在,-2密码错误,-3余额不足，-4系统异常 ，-5通道id错误 ，-9下发异常，-10接口异常，-70调用异常
	static{
		JuXinTongErrorMap.put("-2","密码错误");
		JuXinTongErrorMap.put("-1","用户名不存在");
		JuXinTongErrorMap.put("0","成功");
		JuXinTongErrorMap.put("-3","余额不足");
		JuXinTongErrorMap.put("-4","系统异常 ");
		JuXinTongErrorMap.put("-5","通道id错误 ");
		JuXinTongErrorMap.put("-9","下发异常");
		JuXinTongErrorMap.put("-10","接口异常");
		JuXinTongErrorMap.put("-70","调用异常");
	}
}
