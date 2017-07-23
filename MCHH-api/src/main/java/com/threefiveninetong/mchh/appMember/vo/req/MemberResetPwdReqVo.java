package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 会员修改密码请求参数
 * @author zhanght
 */
public class MemberResetPwdReqVo extends BaseReqVo {
	
	//会员账户
	@NotEmpty(field="账户ID")
	private String memberId;
	
	//原密码
	@NotEmpty(field="原密码")
	private String oldPwd;
	
	//新密码
	@NotEmpty(field="新密码")
	private String newPwd;

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
