package com.threefiveninetong.mchh.send.util;

import java.util.HashMap;
import java.util.Map;

public class ManDaoDictionary {
	
	public static String SUCCESS="0";
	String RegisterUrl="http://sdk.entinfo.cn/webservice.asmx/Register";
	public static final Map<String,String> ManDaoErrorMap=new HashMap<String,String>();
	///返回-1：用户名不存在,-2密码错误,-3余额不足，-4系统异常 ，-5通道id错误 ，-9下发异常，-10接口异常，-70调用异常
	static{
		ManDaoErrorMap.put("-2","帐号/密码不正确");
		ManDaoErrorMap.put("-4","余额不足");
		ManDaoErrorMap.put("0","成功");
		ManDaoErrorMap.put("-5","数据格式错误 ");
		ManDaoErrorMap.put("-6","参数有误 ");
		ManDaoErrorMap.put("-7","权限受限 ");
		ManDaoErrorMap.put("-8","流量控制错误 ");
		ManDaoErrorMap.put("-9","扩展码权限错误 ");
		ManDaoErrorMap.put("-10","单字节不能超过1000个字符 ");
		ManDaoErrorMap.put("-11","内部数据库错误 ");
		ManDaoErrorMap.put("-12","序列号状态错误 ");
		ManDaoErrorMap.put("-14","服务器写文件失败");
		ManDaoErrorMap.put("-17","没有权限");
		ManDaoErrorMap.put("-19","禁止同时使用多个接口地址");
		ManDaoErrorMap.put("-20","相同手机号，相同内容重复提交");
		ManDaoErrorMap.put("-22","Ip鉴权失败");
		ManDaoErrorMap.put("-23","缓存无此序列号信息");
		ManDaoErrorMap.put("-601","序列号为空，参数错误");
		ManDaoErrorMap.put("-602","序列号格式错误，参数错误");
		ManDaoErrorMap.put("-603","密码为空，参数错误");
		ManDaoErrorMap.put("-604","手机号码为空");
		ManDaoErrorMap.put("-605","内容为空");
		ManDaoErrorMap.put("-606","ext长度大于9");
		ManDaoErrorMap.put("-607","扩展码非数字");
		ManDaoErrorMap.put("-608","定时时间非日期格式");
		ManDaoErrorMap.put("-609","rrid长度大于18");
		ManDaoErrorMap.put("-610","rrid非数字");
		ManDaoErrorMap.put("-611","内容编码不符合规范");
		ManDaoErrorMap.put("-623","手机个数与内容个数不匹配");
		ManDaoErrorMap.put("-624","扩展个数与手机个数数");
		ManDaoErrorMap.put("-644","Rrid个数与手机号个数不一致	");
	}
}
