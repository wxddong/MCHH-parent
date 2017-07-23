/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalReferralInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;




/**
 * @ClassName: PremaritalReferralInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
public class PremaritalReferralInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 婚检表ID **/ 
	private String marriageTaId;
	
    /** 0：无，1：有 **/ 
	private String referral;
	
    /** 转诊原因 **/ 
	private String reason;
	
    /** 转诊机构 **/ 
	private String mechanism;
	
    /** 预约复诊日期 **/ 
	private Date appointmentDate;
	
    /** 转诊日期 **/ 
	private Date referralDate;
	
    /** 预约医生 **/ 
	private String doctorAppointments;
	

	private DepartmentPO departmentPO;
	
	private OperatorPO operatorPO;
	
	public OperatorPO getOperatorPO() {
		return operatorPO;
	}

	public void setOperatorPO(OperatorPO operatorPO) {
		this.operatorPO = operatorPO;
	}

	public DepartmentPO getDepartmentPO() {
		return departmentPO;
	}

	public void setDepartmentPO(DepartmentPO departmentPO) {
		this.departmentPO = departmentPO;
	}

	/**
	 * 构造 
	 */
	public PremaritalReferralInfoPO() {
	}
	
	public PremaritalReferralInfoPO( String id,  String marriageTaId, String referral, String reason, String mechanism, Date appointmentDate, Date referralDate, String doctorAppointments) {
				this.marriageTaId = marriageTaId;
				this.referral = referral;
				this.reason = reason;
				this.mechanism = mechanism;
				this.appointmentDate = appointmentDate;
				this.referralDate = referralDate;
				this.doctorAppointments = doctorAppointments;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarriageTaId() {
		return marriageTaId;
	}

	public void setMarriageTaId(String marriageTaId) {
		this.marriageTaId = marriageTaId;
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
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Date getReferralDate() {
		return referralDate;
	}

	public void setReferralDate(Date referralDate) {
		this.referralDate = referralDate;
	}
	public String getDoctorAppointments() {
		return doctorAppointments;
	}

	public void setDoctorAppointments(String doctorAppointments) {
		this.doctorAppointments = doctorAppointments;
	}

}