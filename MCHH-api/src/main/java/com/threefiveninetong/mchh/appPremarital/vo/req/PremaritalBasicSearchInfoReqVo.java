package com.threefiveninetong.mchh.appPremarital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询备孕期基础信息
 * @author zhanght
 */
public class PremaritalBasicSearchInfoReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}	
