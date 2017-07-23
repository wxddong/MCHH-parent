/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthReferralInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childbirth.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:04 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ChildbirthReferralInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:04 
 */
public class ChildbirthReferralInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 分娩基本信息表ID **/ 
	private String basicId;
	
    /** 0：无，1：有 **/ 
	private String referral;
	
    /** 原因 **/ 
	private String reason;
	
    /** 机构 **/ 
	private String mechanism;
	
    /** 科室 **/ 
	private String department;
	
    /** 下次随访日期 **/ 
	private Date nextFollowingDate;
	
    /** 0：否，1：是 **/ 
	private String orderCheck;
	
    /** 0：未使用，1：使用 **/ 
	private String healthHandbook;
	

	/**
	 * 构造 
	 */
	public ChildbirthReferralInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBasicId() {
		return basicId;
	}

	public void setBasicId(String basicId) {
		this.basicId = basicId;
	}
	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMechanism() {
		return mechanism;
	}

	public void setMechanism(String mechanism) {
		this.mechanism = mechanism;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getNextFollowingDate() {
		return nextFollowingDate;
	}

	public void setNextFollowingDate(Date nextFollowingDate) {
		this.nextFollowingDate = nextFollowingDate;
	}
	public String getOrderCheck() {
		return orderCheck;
	}

	public void setOrderCheck(String orderCheck) {
		this.orderCheck = orderCheck;
	}
	public String getHealthHandbook() {
		return healthHandbook;
	}

	public void setHealthHandbook(String healthHandbook) {
		this.healthHandbook = healthHandbook;
	}

}