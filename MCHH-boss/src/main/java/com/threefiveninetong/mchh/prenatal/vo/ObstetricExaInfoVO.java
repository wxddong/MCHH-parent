/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ObstetricExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ObstetricExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
public class ObstetricExaInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String examinationId;
	
    /** 体重 **/ 
	private String weight;
	
    /** 血压高值 **/ 
	private String bloodHi;
	
    /** 血压低值 **/ 
	private String bloodLow;
	
    /** 宫底高度 **/ 
	private String uterusHight;
	
    /** 腹围 **/ 
	private String abdomen;
	
    /** 胎位 **/ 
	private String fetusPosition;
	
    /** 胎心率 **/ 
	private String heartRate;
	

	/**
	 * 构造 
	 */
	public ObstetricExaInfoVO() {
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
	public String getUterusHight() {
		return uterusHight;
	}

	public void setUterusHight(String uterusHight) {
		this.uterusHight = uterusHight;
	}
	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}
	public String getFetusPosition() {
		return fetusPosition;
	}

	public void setFetusPosition(String fetusPosition) {
		this.fetusPosition = fetusPosition;
	}
	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

}