/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumReferralInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.postpartum.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;




/**
 * @ClassName: PostpartumReferralInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
public class PostpartumReferralInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
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
	public PostpartumReferralInfoPO() {
	}
	
	public PostpartumReferralInfoPO( String id,  String posId, String referral, String referralReason, String mechanism, String department, Date nextFollowingDate, String orderCheck, String healthHandbook) {
				this.posId = posId;
				this.referral = referral;
				this.referralReason = referralReason;
				this.mechanism = mechanism;
				this.department = department;
				this.nextFollowingDate = nextFollowingDate;
				this.orderCheck = orderCheck;
				this.healthHandbook = healthHandbook;
						this.id = id;
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
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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