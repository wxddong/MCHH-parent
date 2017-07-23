/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingTwoYearSixRecordPO.java
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
 * @ClassName: AppParentingTwoYearSixRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingTwoYearSixRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 说出身体部位数 **/ 
	private String bodyPartsNum;
	
    /** 出牙数量 **/ 
	private String teethNum;
	
    /** 0：否，1：是 **/ 
	private String picky;
	
    /** 是否挑食为是（1）的时候填写 **/ 
	private String doNotLike;
	
    /** 0：无，1：有 **/ 
	private String lookPicture;
	
    /** 0：无，1：有 **/ 
	private String sayPhrase;
	
    /** 0：无，1：有 **/ 
	private String singleInterest;
	
    /** 0：无，1：有 **/ 
	private String signalToilet;
	
    /** 0：否，1：是 **/ 
	private String run;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingTwoYearSixRecordPO() {
	}
	
	public AppParentingTwoYearSixRecordPO( String id,  String parId, String bodyPartsNum, String teethNum, String picky, String doNotLike, String lookPicture, String sayPhrase, String singleInterest, String signalToilet, String run, Date createTime, Date updateTime) {
				this.parId = parId;
				this.bodyPartsNum = bodyPartsNum;
				this.teethNum = teethNum;
				this.picky = picky;
				this.doNotLike = doNotLike;
				this.lookPicture = lookPicture;
				this.sayPhrase = sayPhrase;
				this.singleInterest = singleInterest;
				this.signalToilet = signalToilet;
				this.run = run;
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
	public String getBodyPartsNum() {
		return bodyPartsNum;
	}

	public void setBodyPartsNum(String bodyPartsNum) {
		this.bodyPartsNum = bodyPartsNum;
	}
	public String getTeethNum() {
		return teethNum;
	}

	public void setTeethNum(String teethNum) {
		this.teethNum = teethNum;
	}
	public String getPicky() {
		return picky;
	}

	public void setPicky(String picky) {
		this.picky = picky;
	}
	public String getDoNotLike() {
		return doNotLike;
	}

	public void setDoNotLike(String doNotLike) {
		this.doNotLike = doNotLike;
	}
	public String getLookPicture() {
		return lookPicture;
	}

	public void setLookPicture(String lookPicture) {
		this.lookPicture = lookPicture;
	}
	public String getSayPhrase() {
		return sayPhrase;
	}

	public void setSayPhrase(String sayPhrase) {
		this.sayPhrase = sayPhrase;
	}
	public String getSingleInterest() {
		return singleInterest;
	}

	public void setSingleInterest(String singleInterest) {
		this.singleInterest = singleInterest;
	}
	public String getSignalToilet() {
		return signalToilet;
	}

	public void setSignalToilet(String signalToilet) {
		this.signalToilet = signalToilet;
	}
	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
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