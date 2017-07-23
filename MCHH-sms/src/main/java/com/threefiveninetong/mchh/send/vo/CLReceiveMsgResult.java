package com.threefiveninetong.mchh.send.vo;

public class CLReceiveMsgResult implements java.io.Serializable{

	public String errCode;
	public String errMsg;
	public String serverTime;
	public CLReserviceSMS[] smses;
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
	public String getServerTime() {
		return serverTime;
	}
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	public CLReserviceSMS[] getSmses() {
		return smses;
	}
	public void setSmses(CLReserviceSMS[] smses) {
		this.smses = smses;
	}
	
	
	
	
}
