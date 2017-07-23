/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingThreeYearRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:10 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppParentingThreeYearRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:10 
 */
public class AppParentingThreeYearRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：未入，1：日托，2：全托 **/ 
	private String kindergarten;
	
    /** 0：无，1：有 **/ 
	private String chewingHabit;
	
    /** 0：无，1：有 **/ 
	private String sleepBrushTeeth;
	
    /** 0：否，1：是 **/ 
	private String mealWashHand;
	
    /** 0：否，1：是 **/ 
	private String squinting;
	
    /** 0：否，1：是 **/ 
	private String ownName;
	
    /** 0：否，1：是 **/ 
	private String pretendPlay;
	
    /** 0：否，1：是 **/ 
	private String imitateDrawCircle;
	
    /** 0：否，1：是 **/ 
	private String doubleJump;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingThreeYearRecordPO() {
	}
	
	public AppParentingThreeYearRecordPO( String id,  String parId, String kindergarten, String chewingHabit, String sleepBrushTeeth, String mealWashHand, String squinting, String ownName, String pretendPlay, String imitateDrawCircle, String doubleJump, Date createTime, Date updateTime) {
				this.parId = parId;
				this.kindergarten = kindergarten;
				this.chewingHabit = chewingHabit;
				this.sleepBrushTeeth = sleepBrushTeeth;
				this.mealWashHand = mealWashHand;
				this.squinting = squinting;
				this.ownName = ownName;
				this.pretendPlay = pretendPlay;
				this.imitateDrawCircle = imitateDrawCircle;
				this.doubleJump = doubleJump;
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
	public String getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}
	public String getSleepBrushTeeth() {
		return sleepBrushTeeth;
	}

	public void setSleepBrushTeeth(String sleepBrushTeeth) {
		this.sleepBrushTeeth = sleepBrushTeeth;
	}
	public String getMealWashHand() {
		return mealWashHand;
	}

	public void setMealWashHand(String mealWashHand) {
		this.mealWashHand = mealWashHand;
	}
	public String getSquinting() {
		return squinting;
	}

	public void setSquinting(String squinting) {
		this.squinting = squinting;
	}
	public String getOwnName() {
		return ownName;
	}

	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}
	public String getPretendPlay() {
		return pretendPlay;
	}

	public void setPretendPlay(String pretendPlay) {
		this.pretendPlay = pretendPlay;
	}
	public String getImitateDrawCircle() {
		return imitateDrawCircle;
	}

	public void setImitateDrawCircle(String imitateDrawCircle) {
		this.imitateDrawCircle = imitateDrawCircle;
	}
	public String getDoubleJump() {
		return doubleJump;
	}

	public void setDoubleJump(String doubleJump) {
		this.doubleJump = doubleJump;
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

	public String getChewingHabit() {
		return chewingHabit;
	}

	public void setChewingHabit(String chewingHabit) {
		this.chewingHabit = chewingHabit;
	}
}