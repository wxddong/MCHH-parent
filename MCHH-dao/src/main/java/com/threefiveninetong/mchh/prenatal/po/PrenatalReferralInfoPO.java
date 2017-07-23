/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalReferralInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:17 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: PrenatalReferralInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:17 
 */
public class PrenatalReferralInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 检查表ID **/ 
	private String preId;
	
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
	
    /** 叶酸发放数 **/ 
	private String folateNum;
	

	/**
	 * 构造 
	 */
	public PrenatalReferralInfoPO() {
	}
	
	public PrenatalReferralInfoPO( String id,  String preId, String referral, String reason, String mechanism, String department, Date nextFollowingDate, String orderCheck, String healthHandbook, String folateNum) {
				this.preId = preId;
				this.referral = referral;
				this.reason = reason;
				this.mechanism = mechanism;
				this.department = department;
				this.nextFollowingDate = nextFollowingDate;
				this.orderCheck = orderCheck;
				this.healthHandbook = healthHandbook;
				this.folateNum = folateNum;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPreId() {
		return preId;
	}

	public void setPreId(String preId) {
		this.preId = preId;
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
	public String getFolateNum() {
		return folateNum;
	}

	public void setFolateNum(String folateNum) {
		this.folateNum = folateNum;
	}

}