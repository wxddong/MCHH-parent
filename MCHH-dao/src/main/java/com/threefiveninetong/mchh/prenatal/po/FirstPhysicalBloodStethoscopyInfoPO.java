/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstPhysicalBloodStethoscopyInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: FirstPhysicalBloodStethoscopyInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public class FirstPhysicalBloodStethoscopyInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String examinationId;
	
    /** 身高 **/ 
	private String height;
	
    /** 体重 **/ 
	private String weight;
	
    /** 血压高值 **/ 
	private String bloodHi;
	
    /** 血压低值 **/ 
	private String bloodLow;
	
    /** 0：未见异常
            1：异常 **/ 
	private String heart;
	
    /** 心脏为异常（1）时填写 **/ 
	private String heartRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String lung;
	
    /** 肺部为异常（1）时填写 **/ 
	private String lungRemark;
	

	/**
	 * 构造 
	 */
	public FirstPhysicalBloodStethoscopyInfoPO() {
	}
	
	public FirstPhysicalBloodStethoscopyInfoPO( String id,  String examinationId, String height, String weight, String bloodHi, String bloodLow, String heart, String heartRemark, String lung, String lungRemark) {
				this.examinationId = examinationId;
				this.height = height;
				this.weight = weight;
				this.bloodHi = bloodHi;
				this.bloodLow = bloodLow;
				this.heart = heart;
				this.heartRemark = heartRemark;
				this.lung = lung;
				this.lungRemark = lungRemark;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBloodHi() {
		return bloodHi;
	}

	public void setBloodHi(String bloodHi) {
		this.bloodHi = bloodHi;
	}
	public String getBloodLow() {
		return bloodLow;
	}

	public void setBloodLow(String bloodLow) {
		this.bloodLow = bloodLow;
	}
	public String getHeart() {
		return heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}
	public String getHeartRemark() {
		return heartRemark;
	}

	public void setHeartRemark(String heartRemark) {
		this.heartRemark = heartRemark;
	}
	public String getLung() {
		return lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}
	public String getLungRemark() {
		return lungRemark;
	}

	public void setLungRemark(String lungRemark) {
		this.lungRemark = lungRemark;
	}

}