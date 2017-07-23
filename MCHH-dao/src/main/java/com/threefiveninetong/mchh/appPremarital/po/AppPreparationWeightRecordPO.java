/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationWeightRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPremarital.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPremarital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppPreparationWeightRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppPreparationWeightRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 体重 **/ 
	private String weight;
	
    /** 身高 **/ 
	private String height;
	
    /** BMI指数 **/ 
	private String bmi;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppPreparationWeightRecordPO() {
	}
	
	public AppPreparationWeightRecordPO( String id,  String mbrId, String weight, String height, String bmi, Date createTime) {
				this.mbrId = mbrId;
				this.weight = weight;
				this.height = height;
				this.bmi = bmi;
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
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}