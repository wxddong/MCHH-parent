package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 会员注册请求
 * @author zhanght
 */
public class MemberRegisterReqVo extends BaseReqVo {
	
	//用户账号
	@NotEmpty(field="账户")
	private String userName;
	
	//密码
	@NotEmpty(field="密码")
	private String password;
	
	//推荐码
	private String inviteCode;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
}
