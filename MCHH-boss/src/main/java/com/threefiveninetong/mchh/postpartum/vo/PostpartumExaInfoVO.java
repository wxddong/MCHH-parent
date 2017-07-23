/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 13:47:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: PostpartumExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 13:47:41 
 */
public class PostpartumExaInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 生育档案ID **/ 
	private String birthArchivesId;
	
    /** 检查医生ID **/ 
	private String doctorId;
	
    /** 0：未见异常/已恢复，1：异常/未恢复 **/ 
	private String result;
	
    /** 异常/未恢复原因，类型为产后42天检查（1）时填写
            0：产褥感染，1：晚期产后出血，2：产褥期抑郁症，3：其他 **/ 
	private String reason;
	
    /** 结果为异常/未恢复（原因为：其他）（1）时填写 **/ 
	private String remark;
	
    /** 保健指导 **/ 
	private String guidance;
	
    /** 0：出院3-7天访视，1：产后42天检查 **/ 
	private String type;
	
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
	public PostpartumExaInfoVO() {
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
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGuidance() {
		return guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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