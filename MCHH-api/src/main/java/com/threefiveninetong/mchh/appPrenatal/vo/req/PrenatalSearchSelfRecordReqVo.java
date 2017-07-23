package com.threefiveninetong.mchh.appPrenatal.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询会员孕产期其他信息记录
 * @author zhanght
 */
public class PrenatalSearchSelfRecordReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="孕期阶段")
	@EqualsAny(field="孕期阶段",values={"0","1","2"})
	private String period;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
}
