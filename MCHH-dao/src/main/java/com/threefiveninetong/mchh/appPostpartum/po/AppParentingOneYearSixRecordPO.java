/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneYearSixRecordPO.java
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
 * @ClassName: AppParentingOneYearSixRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingOneYearSixRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 独立行走时间 **/ 
	private Date ownWalkTime;
	
    /** 0：无，1：有 **/ 
	private String ownSpoon;
	
    /** 0：否，1：是 **/ 
	private String ownGalss;
	
    /** 0：否，1：是 **/ 
	private String oftenPlay;
	
    /** 0：否，1：是 **/ 
	private String consciousCall;
	
    /** 0：否，1：是 **/ 
	private String requirementFinger;
	
    /** 0：否，1：是 **/ 
	private String eyeContact;
	
    /** 0：否，1：是 **/ 
	private String ownWalk;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingOneYearSixRecordPO() {
	}
	
	public AppParentingOneYearSixRecordPO( String id,  String parId, Date ownWalkTime, String ownSpoon, String ownGalss, String oftenPlay, String consciousCall, String requirementFinger, String eyeContact, String ownWalk, Date createTime, Date updateTime) {
				this.parId = parId;
				this.ownWalkTime = ownWalkTime;
				this.ownSpoon = ownSpoon;
				this.ownGalss = ownGalss;
				this.oftenPlay = oftenPlay;
				this.consciousCall = consciousCall;
				this.requirementFinger = requirementFinger;
				this.eyeContact = eyeContact;
				this.ownWalk = ownWalk;
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
	public Date getOwnWalkTime() {
		return ownWalkTime;
	}

	public void setOwnWalkTime(Date ownWalkTime) {
		this.ownWalkTime = ownWalkTime;
	}
	public String getOwnSpoon() {
		return ownSpoon;
	}

	public void setOwnSpoon(String ownSpoon) {
		this.ownSpoon = ownSpoon;
	}
	public String getOwnGalss() {
		return ownGalss;
	}

	public void setOwnGalss(String ownGalss) {
		this.ownGalss = ownGalss;
	}
	public String getOftenPlay() {
		return oftenPlay;
	}

	public void setOftenPlay(String oftenPlay) {
		this.oftenPlay = oftenPlay;
	}
	public String getConsciousCall() {
		return consciousCall;
	}

	public void setConsciousCall(String consciousCall) {
		this.consciousCall = consciousCall;
	}
	public String getRequirementFinger() {
		return requirementFinger;
	}

	public void setRequirementFinger(String requirementFinger) {
		this.requirementFinger = requirementFinger;
	}
	public String getEyeContact() {
		return eyeContact;
	}

	public void setEyeContact(String eyeContact) {
		this.eyeContact = eyeContact;
	}
	public String getOwnWalk() {
		return ownWalk;
	}

	public void setOwnWalk(String ownWalk) {
		this.ownWalk = ownWalk;
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