/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ObstetricExaInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: ObstetricExaInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
public class ObstetricExaInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
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
	public ObstetricExaInfoPO() {
	}
	
	public ObstetricExaInfoPO( String id,  String examinationId, String weight, String bloodHi, String bloodLow, String uterusHight, String abdomen, String fetusPosition, String heartRate) {
				this.examinationId = examinationId;
				this.weight = weight;
				this.bloodHi = bloodHi;
				this.bloodLow = bloodLow;
				this.uterusHight = uterusHight;
				this.abdomen = abdomen;
				this.fetusPosition = fetusPosition;
				this.heartRate = heartRate;
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