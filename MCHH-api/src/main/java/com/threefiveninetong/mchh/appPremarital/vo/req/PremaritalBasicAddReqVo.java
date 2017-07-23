package com.threefiveninetong.mchh.appPremarital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加备孕期基础请求信息
 * @author zhanght
 */
public class PremaritalBasicAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="末次月经时间")
	private String lastMenses;
	
	@NotEmpty(field="经期")
	private String period;
	
	@NotEmpty(field="周期")
	private String menstrualCycle;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(String lastMenses) {
		this.lastMenses = lastMenses;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getMenstrualCycle() {
		return menstrualCycle;
	}

	public void setMenstrualCycle(String menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}
}
