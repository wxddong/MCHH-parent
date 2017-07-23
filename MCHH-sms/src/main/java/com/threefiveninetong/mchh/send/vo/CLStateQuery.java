package com.threefiveninetong.mchh.send.vo;

public class CLStateQuery implements java.io.Serializable{
	public String errCode;
	public String errMsg;
	public CLStatusInfo[] statusInfo;
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
	public CLStatusInfo[] getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(CLStatusInfo[] statusInfo) {
		this.statusInfo = statusInfo;
	}
	public String getServerTime() {
		return serverTime;
	}
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
}
