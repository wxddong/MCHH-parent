/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaDetailedInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: PostpartumExaDetailedInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
public class PostpartumExaDetailedInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String posChecklistId;
	
    /** 体温 **/ 
	private String bodyTemperature;
	
    /** 血压高值 **/ 
	private String bloodHi;
	
    /** 血压低值 **/ 
	private String bloodLow;
	
    /** 一般健康状况 **/ 
	private String health;
	
    /** 一般心理状况 **/ 
	private String psychological;
	
    /** 0：未见异常
            1：异常 **/ 
	private String breast;
	
    /** 乳房为异常（1）时填写 **/ 
	private String breastRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String lochia;
	
    /** 恶露为异常（1）时填写 **/ 
	private String lochiaRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String uterus;
	
    /** 子宫为异常（1）时填写 **/ 
	private String uterusRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String wound;
	
    /** 伤口为异常（1）时填写 **/ 
	private String woundRemark;
	

	/**
	 * 构造 
	 */
	public PostpartumExaDetailedInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosChecklistId() {
		return posChecklistId;
	}

	public void setPosChecklistId(String posChecklistId) {
		this.posChecklistId = posChecklistId;
	}
	public String getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
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
	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}
	public String getPsychological() {
		return psychological;
	}

	public void setPsychological(String psychological) {
		this.psychological = psychological;
	}
	public String getBreast() {
		return breast;
	}

	public void setBreast(String breast) {
		this.breast = breast;
	}
	public String getBreastRemark() {
		return breastRemark;
	}

	public void setBreastRemark(String breastRemark) {
		this.breastRemark = breastRemark;
	}
	public String getLochia() {
		return lochia;
	}

	public void setLochia(String lochia) {
		this.lochia = lochia;
	}
	public String getLochiaRemark() {
		return lochiaRemark;
	}

	public void setLochiaRemark(String lochiaRemark) {
		this.lochiaRemark = lochiaRemark;
	}
	public String getUterus() {
		return uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}
	public String getUterusRemark() {
		return uterusRemark;
	}

	public void setUterusRemark(String uterusRemark) {
		this.uterusRemark = uterusRemark;
	}
	public String getWound() {
		return wound;
	}

	public void setWound(String wound) {
		this.wound = wound;
	}
	public String getWoundRemark() {
		return woundRemark;
	}

	public void setWoundRemark(String woundRemark) {
		this.woundRemark = woundRemark;
	}

}