package com.threefiveninetong.mchh.appMember.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;
/**
 * 注册响应信息
 * @author zhanght
 */
public class MemberRegisterRespVo extends BaseVo {
	
	//会员ID
	private String memberId = "";

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
