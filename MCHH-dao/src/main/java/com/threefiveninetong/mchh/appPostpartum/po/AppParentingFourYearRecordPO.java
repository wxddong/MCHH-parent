/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingFourYearRecordPO.java
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
 * @ClassName: AppParentingFourYearRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:10 
 */
public class AppParentingFourYearRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：未入，1：日托，2：月托 **/ 
	private String kindergarten;
	
    /** 0：否，1：是 **/ 
	private String cutSomething;
	
    /** 0：否，1：是 **/ 
	private String independentToilet;
	
    /** 0：否，1：是 **/ 
	private String tellingStories;
	
    /** 户外活动 **/ 
	private String outdoorActivityTime;
	
    /** 看视频 **/ 
	private String watchVideoTime;
	
    /** 0：否，1：是 **/ 
	private String saidAdjectiveSentence;
	
    /** 0：否，1：是 **/ 
	private String requirementWait;
	
    /** 0：否，1：是 **/ 
	private String independentDress;
	
    /** 0：否，1：是 **/ 
	private String singleFootStand;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingFourYearRecordPO() {
	}
	
	public AppParentingFourYearRecordPO( String id,  String parId, String kindergarten, String cutSomething, String independentToilet, String tellingStories, String outdoorActivityTime, String watchVideoTime, String saidAdjectiveSentence, String requirementWait, String independentDress, String singleFootStand, Date createTime, Date updateTime) {
				this.parId = parId;
				this.kindergarten = kindergarten;
				this.cutSomething = cutSomething;
				this.independentToilet = independentToilet;
				this.tellingStories = tellingStories;
				this.outdoorActivityTime = outdoorActivityTime;
				this.watchVideoTime = watchVideoTime;
				this.saidAdjectiveSentence = saidAdjectiveSentence;
				this.requirementWait = requirementWait;
				this.independentDress = independentDress;
				this.singleFootStand = singleFootStand;
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
	public String getCutSomething() {
		return cutSomething;
	}

	public void setCutSomething(String cutSomething) {
		this.cutSomething = cutSomething;
	}
	public String getIndependentToilet() {
		return independentToilet;
	}

	public void setIndependentToilet(String independentToilet) {
		this.independentToilet = independentToilet;
	}
	public String getTellingStories() {
		return tellingStories;
	}

	public void setTellingStories(String tellingStories) {
		this.tellingStories = tellingStories;
	}
	public String getOutdoorActivityTime() {
		return outdoorActivityTime;
	}

	public void setOutdoorActivityTime(String outdoorActivityTime) {
		this.outdoorActivityTime = outdoorActivityTime;
	}
	public String getWatchVideoTime() {
		return watchVideoTime;
	}

	public void setWatchVideoTime(String watchVideoTime) {
		this.watchVideoTime = watchVideoTime;
	}
	public String getSaidAdjectiveSentence() {
		return saidAdjectiveSentence;
	}

	public void setSaidAdjectiveSentence(String saidAdjectiveSentence) {
		this.saidAdjectiveSentence = saidAdjectiveSentence;
	}
	public String getRequirementWait() {
		return requirementWait;
	}

	public void setRequirementWait(String requirementWait) {
		this.requirementWait = requirementWait;
	}
	public String getIndependentDress() {
		return independentDress;
	}

	public void setIndependentDress(String independentDress) {
		this.independentDress = independentDress;
	}
	public String getSingleFootStand() {
		return singleFootStand;
	}

	public void setSingleFootStand(String singleFootStand) {
		this.singleFootStand = singleFootStand;
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