/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumReferralInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @ClassName: PostpartumReferralInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
public class PostpartumReferralInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产后访视表ID **/ 
	private String posId;
	
    /** 0：无，1：有 **/ 
	private String referral;
	
    /** 原因 **/ 
	private String referralReason;
	
    /** 机构 **/ 
	private String mechanism;
	
    /** 科室 **/ 
	private String department;
	private String departmentName;
	
    /** 下次随访日期 **/ 
	private Date nextFollowingDate;
	
    /** 0：否，1：是 **/ 
	private String orderCheck;
	
    /** 0：未使用，1：使用 **/ 
	private String healthHandbook;
	

	/**
	 * 构造 
	 */
	public PostpartumReferralInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}
	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}
	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
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

	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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