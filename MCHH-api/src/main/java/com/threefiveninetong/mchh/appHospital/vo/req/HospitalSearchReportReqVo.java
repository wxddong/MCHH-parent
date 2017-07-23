package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BasePageReqVo;

/**
 * 查询会员的医院检查报告
 * @author zhanght
 */
public class HospitalSearchReportReqVo extends BasePageReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
