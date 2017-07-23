package com.threefiveninetong.mchh.send.vo.devsource;

public class OverageReturnsms extends BaseReturnsms{

	private String payinfo;
	private String overage;
	private String sendTotal;
	
	public String getPayinfo() {
		return payinfo;
	}
	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}
	public String getOverage() {
		return overage;
	}
	public void setOverage(String overage) {
		this.overage = overage;
	}
	public String getSendTotal() {
		return sendTotal;
	}
	public void setSendTotal(String sendTotal) {
		this.sendTotal = sendTotal;
	}
	
}
