package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;
/**
 * 会员登录请求 
 * @author zhanght
 */
public class MemberLoginReqVo extends BaseReqVo {
	
	//账户
	@NotEmpty(field="账户")
	private String userName;
	
	//密码
	@NotEmpty(field="密码")
	private String password;

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
}
