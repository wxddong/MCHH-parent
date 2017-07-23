/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalExaInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:40 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;




/**
 * @ClassName: PrenatalExaInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:40 
 */
public class PrenatalExaInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 生育档案ID **/ 
	private String birthArchivesId;
	
    /** 检查医生ID **/ 
	private String doctorId;
	
    /** 0：未见异常，1：异常 **/ 
	private String evaluate;
	
    /** 总体评估为异常（1）时填写，高危项ID串，使用;号分隔 **/ 
	private String evaluateRemark;
	
    /** 主诉 **/ 
	private String chiefComplaint;
	
    /** 保健指导 **/ 
	private String guidance;
	
	/** 编辑状态 **/ 
	private String editStatus;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	/** 0:非正常数据，1：正常数据 **/ 
	private String normalSign;
	
	private BirthArchivesInfoPO birthArchivesInfoPO;
	
	private PrenatalReferralInfoPO prenatalReferralInfoPO;
	
	private OperatorPO operatorPO;
	
	private Date checkTime;
	
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public BirthArchivesInfoPO getBirthArchivesInfoPO() {
		return birthArchivesInfoPO;
	}

	public void setBirthArchivesInfoPO(BirthArchivesInfoPO birthArchivesInfoPO) {
		this.birthArchivesInfoPO = birthArchivesInfoPO;
	}

	public PrenatalReferralInfoPO getPrenatalReferralInfoPO() {
		return prenatalReferralInfoPO;
	}

	public void setPrenatalReferralInfoPO(PrenatalReferralInfoPO prenatalReferralInfoPO) {
		this.prenatalReferralInfoPO = prenatalReferralInfoPO;
	}

	public OperatorPO getOperatorPO() {
		return operatorPO;
	}

	public void setOperatorPO(OperatorPO operatorPO) {
		this.operatorPO = operatorPO;
	}

	/**
	 * 构造 
	 */
	public PrenatalExaInfoPO() {
	}
	
	public PrenatalExaInfoPO( String id,  String birthArchivesId, String doctorId, String evaluate, String evaluateRemark, String chiefComplaint, String guidance,String editStatus,Date creatTime, Date updateTime,String normalSign) {
				this.birthArchivesId = birthArchivesId;
				this.doctorId = doctorId;
				this.evaluate = evaluate;
				this.evaluateRemark = evaluateRemark;
				this.chiefComplaint = chiefComplaint;
				this.guidance = guidance;
				this.editStatus = editStatus;
				this.creatTime = creatTime;
				this.updateTime = updateTime;
				this.normalSign=normalSign;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirthArchivesId() {
		return birthArchivesId;
	}

	public void setBirthArchivesId(String birthArchivesId) {
		this.birthArchivesId = birthArchivesId;
	}
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getEvaluateRemark() {
		return evaluateRemark;
	}

	public void setEvaluateRemark(String evaluateRemark) {
		this.evaluateRemark = evaluateRemark;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public String getGuidance() {
		return guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

	public String getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(String editStatus) {
		this.editStatus = editStatus;
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

	public String getNormalSign() {
		return normalSign;
	}

	public void setNormalSign(String normalSign) {
		this.normalSign = normalSign;
	}

	
}