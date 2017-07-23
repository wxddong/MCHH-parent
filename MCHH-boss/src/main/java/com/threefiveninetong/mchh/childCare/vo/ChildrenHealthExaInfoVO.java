/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHealthExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:02 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ChildrenHealthExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:02 
 */
public class ChildrenHealthExaInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 档案ID **/ 
	private String archivesId;
	
    /** 检查医院ID **/ 
	private String hospitalId;
	
    /** 编辑状态，0：保存，1：完成 **/ 
	private String editStatus;
	
    /** 删除标识 0 ：删除 1：不删除 **/ 
	private String deltetSign;
	
    /** 保健指导 **/ 
	private String guidance;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
    /** 0：非正常数据，1：正常数据 **/ 
	private String normalSign;
	
    /** 0：新生儿，1：1岁以内，2：1岁到2岁，3：3岁到6岁 **/ 
	private String stageSign;
	

	/**
	 * 构造 
	 */
	public ChildrenHealthExaInfoVO() {
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
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(String editStatus) {
		this.editStatus = editStatus;
	}
	public String getDeltetSign() {
		return deltetSign;
	}

	public void setDeltetSign(String deltetSign) {
		this.deltetSign = deltetSign;
	}
	public String getGuidance() {
		return guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
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
	public String getStageSign() {
		return stageSign;
	}

	public void setStageSign(String stageSign) {
		this.stageSign = stageSign;
	}

}