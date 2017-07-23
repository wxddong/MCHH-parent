/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEarlyStageDetailsPO.java
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
 * @ClassName: AppParentingEarlyStageDetailsPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingEarlyStageDetailsPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String earlyId;
	
    /** 出生天数 **/ 
	private String birthDays;
	
    /** 0：非母乳，1：母乳，2：混合喂养 **/ 
	private String feedingMode;
	
    /** 吃奶次数 **/ 
	private String milkNum;
	
    /** 小便次数 **/ 
	private String urineNum;
	
    /** 大便次数 **/ 
	private String shitNum;
	
    /** 体重 **/ 
	private String weight;
	
    /** 0：否，1：是 **/ 
	private String jaundice;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppParentingEarlyStageDetailsPO() {
	}
	
	public AppParentingEarlyStageDetailsPO( String id,  String earlyId, String birthDays, String feedingMode, String milkNum, String urineNum, String shitNum, String weight, String jaundice, Date createTime) {
				this.earlyId = earlyId;
				this.birthDays = birthDays;
				this.feedingMode = feedingMode;
				this.milkNum = milkNum;
				this.urineNum = urineNum;
				this.shitNum = shitNum;
				this.weight = weight;
				this.jaundice = jaundice;
				this.createTime = createTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEarlyId() {
		return earlyId;
	}

	public void setEarlyId(String earlyId) {
		this.earlyId = earlyId;
	}
	public String getBirthDays() {
		return birthDays;
	}

	public void setBirthDays(String birthDays) {
		this.birthDays = birthDays;
	}
	public String getFeedingMode() {
		return feedingMode;
	}

	public void setFeedingMode(String feedingMode) {
		this.feedingMode = feedingMode;
	}
	public String getMilkNum() {
		return milkNum;
	}

	public void setMilkNum(String milkNum) {
		this.milkNum = milkNum;
	}
	public String getUrineNum() {
		return urineNum;
	}

	public void setUrineNum(String urineNum) {
		this.urineNum = urineNum;
	}
	public String getShitNum() {
		return shitNum;
	}

	public void setShitNum(String shitNum) {
		this.shitNum = shitNum;
	}
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getJaundice() {
		return jaundice;
	}

	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}