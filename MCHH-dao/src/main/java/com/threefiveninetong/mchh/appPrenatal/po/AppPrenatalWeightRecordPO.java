/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalWeightRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppPrenatalWeightRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public class AppPrenatalWeightRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 孕前BMI **/ 
	private String prenatalBmi;
	
    /** 体重 **/ 
	private String weight;
	
    /** 本周增重 **/ 
	private String weightGain;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppPrenatalWeightRecordPO() {
	}
	
	public AppPrenatalWeightRecordPO( String id,  String mbrId, String prenatalBmi, String weight, String weightGain, Date createTime) {
				this.mbrId = mbrId;
				this.prenatalBmi = prenatalBmi;
				this.weight = weight;
				this.weightGain = weightGain;
				this.createTime = createTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getPrenatalBmi() {
		return prenatalBmi;
	}

	public void setPrenatalBmi(String prenatalBmi) {
		this.prenatalBmi = prenatalBmi;
	}
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeightGain() {
		return weightGain;
	}

	public void setWeightGain(String weightGain) {
		this.weightGain = weightGain;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}