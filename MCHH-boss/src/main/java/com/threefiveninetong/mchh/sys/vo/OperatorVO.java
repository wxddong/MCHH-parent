package com.threefiveninetong.mchh.sys.vo;

import java.util.Date;

/**
 * 
 * @author xuyh
 * @date 2013-7-16上午11:19:37
 * @description 操作员视图对象
 */
public class OperatorVO {
	private String id;
	private String loginName;// 登录名
	private String password;// 密码
	private String realName;// 真实姓名
	private int flag;// 是否可用
	private String phone;// 固定电话
	private String mobile;// 手机号
	private String email;// 电子邮件
	private String address;// 地址
	private String remark;// 备注
	private Date lastLogin;// 最后登录时间
	private Date lastPwd;// 最后修改密码时间
	private String conf;// 配置信息
	private String depId;// 所属部门标识
	private String department;// 所属部门名称

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getLastPwd() {
		return lastPwd;
	}

	public void setLastPwd(Date lastPwd) {
		this.lastPwd = lastPwd;
	}

	public String getConf() {
		return conf;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
