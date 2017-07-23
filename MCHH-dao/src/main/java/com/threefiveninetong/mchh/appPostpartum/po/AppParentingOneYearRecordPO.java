/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneYearRecordPO.java
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
 * @ClassName: AppParentingOneYearRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingOneYearRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 每天吃饭次数 **/ 
	private String mealNum;
	
    /** 出牙数 **/ 
	private String toothNum;
	
    /** 0：不好，1：好 **/ 
	private String mealSituation;
	
    /** 0：否，1：是 **/ 
	private String breastMilk;
	
    /** 0：否，1：是 **/ 
	private String nameReaction;
	
    /** 0：否，1：是 **/ 
	private String imitate;
	
    /** 0：否，1：是 **/ 
	private String pinchThing;
	
    /** 0：否，1：是 **/ 
	private String standingUp;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingOneYearRecordPO() {
	}
	
	public AppParentingOneYearRecordPO( String id,  String parId, String mealNum, String toothNum, String mealSituation, String breastMilk, String nameReaction, String imitate, String pinchThing, String standingUp, Date createTime, Date updateTime) {
				this.parId = parId;
				this.mealNum = mealNum;
				this.toothNum = toothNum;
				this.mealSituation = mealSituation;
				this.breastMilk = breastMilk;
				this.nameReaction = nameReaction;
				this.imitate = imitate;
				this.pinchThing = pinchThing;
				this.standingUp = standingUp;
				this.createTime = createTime;
				this.updateTime = updateTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParId() {
		return parId;
	}

	public void setParId(String parId) {
		this.parId = parId;
	}
	public String getMealNum() {
		return mealNum;
	}

	public void setMealNum(String mealNum) {
		this.mealNum = mealNum;
	}
	public String getToothNum() {
		return toothNum;
	}

	public void setToothNum(String toothNum) {
		this.toothNum = toothNum;
	}
	public String getMealSituation() {
		return mealSituation;
	}

	public void setMealSituation(String mealSituation) {
		this.mealSituation = mealSituation;
	}
	public String getBreastMilk() {
		return breastMilk;
	}

	public void setBreastMilk(String breastMilk) {
		this.breastMilk = breastMilk;
	}
	public String getNameReaction() {
		return nameReaction;
	}

	public void setNameReaction(String nameReaction) {
		this.nameReaction = nameReaction;
	}
	public String getImitate() {
		return imitate;
	}

	public void setImitate(String imitate) {
		this.imitate = imitate;
	}
	public String getPinchThing() {
		return pinchThing;
	}

	public void setPinchThing(String pinchThing) {
		this.pinchThing = pinchThing;
	}
	public String getStandingUp() {
		return standingUp;
	}

	public void setStandingUp(String standingUp) {
		this.standingUp = standingUp;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}