package com.threefiveninetong.mchh.util;

public class LenderdatePwdVo {
	private String name;
	private String pwd;
	private String salt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return name + salt;
	}
}
