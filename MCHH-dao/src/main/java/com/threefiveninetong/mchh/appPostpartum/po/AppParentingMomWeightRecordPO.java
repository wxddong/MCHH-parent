/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingMomWeightRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppParentingMomWeightRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingMomWeightRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 孕前BMI **/ 
	private String preBmi;
	
    /** 体重 **/ 
	private String weight;
	
    /** 身高 **/ 
	private String height;
	
    /** BMI **/ 
	private String bmi;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppParentingMomWeightRecordPO() {
	}
	
	public AppParentingMomWeightRecordPO( String id,  String mbrId, String preBmi, String weight, String height, String bmi, Date createTime) {
				this.mbrId = mbrId;
				this.preBmi = preBmi;
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
	public String getPreBmi() {
		return preBmi;
	}

	public void setPreBmi(String preBmi) {
		this.preBmi = preBmi;
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