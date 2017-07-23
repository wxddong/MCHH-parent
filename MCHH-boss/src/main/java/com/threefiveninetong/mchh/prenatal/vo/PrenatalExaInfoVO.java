/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:40 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: PrenatalExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:40 
 */
public class PrenatalExaInfoVO {

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
	
	/**
	 * 构造 
	 */
	public PrenatalExaInfoVO() {
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