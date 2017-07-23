/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskPregnancyScorePO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: HighRiskPregnancyScorePO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public class HighRiskPregnancyScorePO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 名称 **/ 
	private String name;
	
    /** 分数 **/ 
	private String score;
	
    /** 0：动态因素，1：固定因素 **/ 
	private String status;
	
    /** 备注描述 **/ 
	private String remark;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	/**
	 * 0：孕产妇，1：儿童
	 */
	private String type;
	
	
	private String selected;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	/**
	 * 构造 
	 */
	public HighRiskPregnancyScorePO() {
	}
	
	public HighRiskPregnancyScorePO( String id,  String name, String score, String status, String remark, Date creatTime, Date updateTime,String type) {
				this.name = name;
				this.score = score;
				this.status = status;
				this.remark = remark;
				this.creatTime = creatTime;
				this.updateTime = updateTime;
				this.type=type;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}