/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenLastStatusInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 15:57:51 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ChildrenLastStatusInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 15:57:51 
 */
public class ChildrenLastStatusInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 档案ID **/ 
	private String archivesId;
	
    /** 0：妊娠中，1：已分娩，2：已结案 **/ 
	private String pregnantState;
	
    /** 结案原因， **/ 
	private String closingReason;
	
    /** 结案日期 **/ 
	private Date closingDate;
	
    /** 0：否，1：是，默认为0 **/ 
	private String riskSign;
	
    /** 转诊标识，0：未转诊，1：孕检转诊，2：分娩转诊，3：产后转诊 **/ 
	private String referralSign;
	
    /** 最新转出医院ID **/ 
	private String outHospitalId;
	
    /** 最新转入医院ID **/ 
	private String inHospitalId;
	
    /** 最新转诊时间 **/ 
	private Date referralTime;
	
    /** 第一次筛查出高危的时间 **/ 
	private Date screeningDate;
	
    /** 0：未发放，1：已发放 **/ 
	private String grantSign;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public ChildrenLastStatusInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}
	public String getPregnantState() {
		return pregnantState;
	}

	public void setPregnantState(String pregnantState) {
		this.pregnantState = pregnantState;
	}
	public String getClosingReason() {
		return closingReason;
	}

	public void setClosingReason(String closingReason) {
		this.closingReason = closingReason;
	}
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	public String getRiskSign() {
		return riskSign;
	}

	public void setRiskSign(String riskSign) {
		this.riskSign = riskSign;
	}
	public String getReferralSign() {
		return referralSign;
	}

	public void setReferralSign(String referralSign) {
		this.referralSign = referralSign;
	}
	public String getOutHospitalId() {
		return outHospitalId;
	}

	public void setOutHospitalId(String outHospitalId) {
		this.outHospitalId = outHospitalId;
	}
	public String getInHospitalId() {
		return inHospitalId;
	}

	public void setInHospitalId(String inHospitalId) {
		this.inHospitalId = inHospitalId;
	}
	public Date getReferralTime() {
		return referralTime;
	}

	public void setReferralTime(Date referralTime) {
		this.referralTime = referralTime;
	}
	public Date getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(Date screeningDate) {
		this.screeningDate = screeningDate;
	}
	public String getGrantSign() {
		return grantSign;
	}

	public void setGrantSign(String grantSign) {
		this.grantSign = grantSign;
	}
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}