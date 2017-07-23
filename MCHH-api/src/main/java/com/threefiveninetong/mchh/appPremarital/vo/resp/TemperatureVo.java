package com.threefiveninetong.mchh.appPremarital.vo.resp;

/**
 * 体温信息
 * @author zhanght
 */
public class TemperatureVo {
	
	//体温
	private String temperature;
	
	//是否经期
	private String periodSign;
	
	//记录时间
	private String createTime;

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPeriodSign() {
		return periodSign;
	}

	public void setPeriodSign(String periodSign) {
		this.periodSign = periodSign;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
