package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询医院首页展示信息
 * @author zhanght
 */
public class HospitalSearchFirstPageInfoReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
