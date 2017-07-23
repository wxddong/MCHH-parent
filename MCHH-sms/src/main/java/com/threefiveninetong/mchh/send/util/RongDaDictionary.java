package com.threefiveninetong.mchh.send.util;

import java.util.HashMap;
import java.util.Map;

public class RongDaDictionary {

	
	public static String SENDING_URL="http://116.213.72.20/SMSHttpService/send.aspx";
	
	
	public static String BALANCE_URL="http://116.213.72.20/SMSHttpService/Balance.aspx";
	
	public static String USER_NAME="lcdkj";
	
	public static String USER_PWD="lcdkj";
	                         
	public static String EXT_CODE="329";
	
	public static final Map<String,String> RongErrorMap=new HashMap<String,String>();
	
	static{
		RongErrorMap.put("-2","提交的号码中包含不符合格式的手机号码");
		RongErrorMap.put("-1","数据保存失败");
		RongErrorMap.put("0","成功");
		RongErrorMap.put("1001","用户名或密码错误");
		RongErrorMap.put("1002","余额不足");
		RongErrorMap.put("1003","参数错误，请输入完整的参数 ");
		RongErrorMap.put("1004","其他错误");
		RongErrorMap.put("1005","预约时间格式不正确");
	}
}
