package com.threefiveninetong.mchh.appPremarital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加备孕期体温记录
 * @author zhanght
 */
public class PremaritalTemperatureRecordAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="体温")
	private String temperature;
	
	@NotEmpty(field="是否经期")
	@EqualsAny(field="是否经期",values={"0","1"})
	private String periodSign;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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
}
