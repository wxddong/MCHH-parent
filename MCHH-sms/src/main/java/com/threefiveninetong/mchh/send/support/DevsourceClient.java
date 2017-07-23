package com.threefiveninetong.mchh.send.support;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.threefiveninetong.mchh.send.vo.devsource.OverageReturnsms;
import com.threefiveninetong.mchh.send.vo.devsource.SendReturnsms;
import com.threefiveninetong.mchh.send.vo.devsource.XstreamObjResultByXML;
import com.threefiveninetong.mchh.core.util.HttpUtil;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

public class DevsourceClient {

	Logger log = LoggerFactory.getLogger(DevsourceClient.class);
	/*
	 * webservice服务器定义
	 */
	private String serviceUrl = "";

	private String userId = "";//企业ID

	private String account = "";//账户号

	private String password = "";//密码

	/*
	 * 构造函数
	 */
	public DevsourceClient(String serviceUrl, String userId,String account, String password)
			throws UnsupportedEncodingException {
		this.serviceUrl = serviceUrl;
		this.userId = userId;
		this.account = account;
		this.password = password;
	}

	/**
	 * 发送短信
	 * @param telephoneList
	 * @param content
	 * @return
	 */
	public SendReturnsms sendSMS(String telephoneList,String content){
		 Map<String, Object> params = new HashMap<String, Object>();
		String result="";
		String num=String.valueOf(telephoneList.split(",").length);//短信
		params.put("action","send");//发送任务命令,设置为固定的:send
		params.put("userid",userId);//企业id
		params.put("account",account);//发送用户帐号
		params.put("password",password);//发送帐号密码
		params.put("mobile",telephoneList);//全部被叫号码
		params.put("content",content);//发送内容
		params.put("sendTime","");//定时发送时间,为空表示立即发送，定时发送格式2010-10-24 09:08:10
		params.put("taskName","快乐校园业务短信");//任务名称,本次任务 描述100个字以内  可以为空
		params.put("checkcontent","0");//是否检查内容包含非法关键字,当设置为1时表示需要检查，默认0为不检查
		params.put("mobilenumber",num);//本次提交的手机号码数量
		params.put("countnumber",num);//本次提交的号码总数量
		params.put("telephonenumber","0");//本次提交的小灵通或座机号码数数量
		SendReturnsms sendReturnsms=null;
		try {
			result = HttpUtil.doPost(serviceUrl, params);
			log.info("短信内容："+content+"，接收手机号："+telephoneList+"，调用发送接口返回结果："+result);
			sendReturnsms=XstreamObjResultByXML.getSendReturnsmsByXML(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendReturnsms;
	}

	/**
	 * 查询余额
	 * @return
	 * @throws RemoteException
	 */
	public OverageReturnsms getBalance() throws RemoteException {
		Map<String, Object> params = new HashMap<String, Object>();
		String result="";
		params.put("action","overage");//发送任务命令,设置为固定的:send
		params.put("userid",userId);//企业id
		params.put("account",account);//发送用户帐号
		params.put("password",password);//发送帐号密码
		OverageReturnsms overageReturnsms=null;
		try {
			result = HttpUtil.doPost(serviceUrl, params);
			log.info("调用查询短信余额接口返回结果："+result);
			overageReturnsms=XstreamObjResultByXML.getOverageReturnsmsByXML(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return overageReturnsms;
	}

	
}
