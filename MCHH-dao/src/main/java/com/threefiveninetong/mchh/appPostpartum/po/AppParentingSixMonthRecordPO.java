/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingSixMonthRecordPO.java
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
 * @ClassName: AppParentingSixMonthRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingSixMonthRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 添加辅食时间 **/ 
	private Date addFoodTime;
	
    /** 会翻身时间 **/ 
	private Date turnOverTime;
	
    /** 为宝宝准备的玩具的件数 **/ 
	private String toysNum;
	
    /** 0：否，1：是 **/ 
	private String babyPlay;
	
    /** 0：否，1：是 **/ 
	private String soundLaugh;
	
    /** 0：否，1：是 **/ 
	private String handGrab;
	
    /** 0：否，1：是 **/ 
	private String clenchFist;
	
    /** 0：否，1：是 **/ 
	private String sit;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingSixMonthRecordPO() {
	}
	
	public AppParentingSixMonthRecordPO( String id,  String parId, Date addFoodTime, Date turnOverTime, String toysNum, String babyPlay, String soundLaugh, String handGrab, String clenchFist, String sit, Date createTime, Date updateTime) {
				this.parId = parId;
				this.addFoodTime = addFoodTime;
				this.turnOverTime = turnOverTime;
				this.toysNum = toysNum;
				this.babyPlay = babyPlay;
				this.soundLaugh = soundLaugh;
				this.handGrab = handGrab;
				this.clenchFist = clenchFist;
				this.sit = sit;
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
	public Date getAddFoodTime() {
		return addFoodTime;
	}

	public void setAddFoodTime(Date addFoodTime) {
		this.addFoodTime = addFoodTime;
	}
	public Date getTurnOverTime() {
		return turnOverTime;
	}

	public void setTurnOverTime(Date turnOverTime) {
		this.turnOverTime = turnOverTime;
	}
	public String getToysNum() {
		return toysNum;
	}

	public void setToysNum(String toysNum) {
		this.toysNum = toysNum;
	}
	public String getBabyPlay() {
		return babyPlay;
	}

	public void setBabyPlay(String babyPlay) {
		this.babyPlay = babyPlay;
	}
	public String getSoundLaugh() {
		return soundLaugh;
	}

	public void setSoundLaugh(String soundLaugh) {
		this.soundLaugh = soundLaugh;
	}
	public String getHandGrab() {
		return handGrab;
	}

	public void setHandGrab(String handGrab) {
		this.handGrab = handGrab;
	}
	public String getClenchFist() {
		return clenchFist;
	}

	public void setClenchFist(String clenchFist) {
		this.clenchFist = clenchFist;
	}
	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
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