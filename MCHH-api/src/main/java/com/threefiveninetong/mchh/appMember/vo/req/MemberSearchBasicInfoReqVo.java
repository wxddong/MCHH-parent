package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询会员的详细信息
 * @author zhanght
 */
public class MemberSearchBasicInfoReqVo extends BaseVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
