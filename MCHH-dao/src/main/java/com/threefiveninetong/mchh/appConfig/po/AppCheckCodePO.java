/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppCheckCodePO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appConfig.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppCheckCodePO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppCheckCodePO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 手机号 **/ 
	private String phone;
	
    /** 验证码 **/ 
	private String checkCode;
	
    /** 获取时间 **/ 
	private Date getTime;
	
    /** 0:无效，1：有效 **/ 
	private String status;
	
    /** 0:注册;1:修改密码 **/ 
	private String type;
	

	/**
	 * 构造 
	 */
	public AppCheckCodePO() {
	}
	
	public AppCheckCodePO( String id,  String phone, String checkCode, Date getTime, String status, String type) {
				this.phone = phone;
				this.checkCode = checkCode;
				this.getTime = getTime;
				this.status = status;
				this.type = type;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public Date getGetTime() {
		return getTime;
	}

	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}