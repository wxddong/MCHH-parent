/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenReferralInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:04 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: ChildrenReferralInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:04 
 */
public class ChildrenReferralInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 健康检查表ID **/ 
	private String healthExaId;
	
    /** 0：无，1：有 **/ 
	private String referral;
	
    /** 原因 **/ 
	private String reason;
	
    /** 机构 **/ 
	private String mechanism;
	
    /** 科室 **/ 
	private String department;
	
    /** 下次随访日期 **/ 
	private Date followingDate;
	
    /** 下次随访地点 **/ 
	private String followingAdress;
	
    /** 0：否，1：是 **/ 
	private String orderCheck;
	
    /** 0：未使用，1：使用 **/ 
	private String healthHandbook;
	

	/**
	 * 构造 
	 */
	public ChildrenReferralInfoPO() {
	}
	
	public ChildrenReferralInfoPO( String id,  String healthExaId, String referral, String reason, String mechanism, String department, Date followingDate, String followingAdress, String orderCheck, String healthHandbook) {
				this.healthExaId = healthExaId;
				this.referral = referral;
				this.reason = reason;
				this.mechanism = mechanism;
				this.department = department;
				this.followingDate = followingDate;
				this.followingAdress = followingAdress;
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

	public String getHealthExaId() {
		return healthExaId;
	}

	public void setHealthExaId(String healthExaId) {
		this.healthExaId = healthExaId;
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
	public Date getFollowingDate() {
		return followingDate;
	}

	public void setFollowingDate(Date followingDate) {
		this.followingDate = followingDate;
	}
	public String getFollowingAdress() {
		return followingAdress;
	}

	public void setFollowingAdress(String followingAdress) {
		this.followingAdress = followingAdress;
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