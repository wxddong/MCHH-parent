package com.threefiveninetong.mchh.send.vo;

public class CLSendMsgResult implements java.io.Serializable{
//	<?xml version="1.0" encoding="utf-8"?>
//	<result>
//	<err_code>0</err_code>
//	<err_msg>�����ɹ���</err_msg>
//	<sms_count>1</sms_count>
/*******���ͺ󷵻صĲ�ѯ ID �� ���Ϊ����ֻ�� �� �򷵻ض�� id �� �м��� , �ָ�*********/
//	<tick_ids>5406731</tick_ids>
//	<remain_count>33296</remain_count>
//	<server_time>2012-06-27 17:05:12</server_time>
//	</result>
	public String errCode;
	public String errMsg;
	public String smsCount;
	public String[] ids;
	public String remainCount;
	public String serverTime;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(String smsCount) {
		this.smsCount = smsCount;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getRemainCount() {
		return remainCount;
	}
	public void setRemainCount(String remainCount) {
		this.remainCount = remainCount;
	}
	public String getServerTime() {
		return serverTime;
	}
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	
	
	
	
}
