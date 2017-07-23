/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingThreeMonthRecordPO.java
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
 * @ClassName: AppParentingThreeMonthRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingThreeMonthRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 户外活动时间 **/ 
	private Date outdoorsDuration;
	
    /** 0：非母乳，1：母乳,2：混合喂养 **/ 
	private String feedingMode;
	
    /** 0：不好，1：好 **/ 
	private String feedingSituation;
	
    /** 0：否，1：是 **/ 
	private String talkBaby;
	
    /** 0：否，1：是 **/ 
	private String vSupplement;
	
    /** 0：否，1：是 **/ 
	private String loudReaction;
	
    /** 0：否，1：是 **/ 
	private String teasingSmile;
	
    /** 0：否，1：是 **/ 
	private String gazeTracking;
	
    /** 0：否，1：是 **/ 
	private String riseProne;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingThreeMonthRecordPO() {
	}
	
	public AppParentingThreeMonthRecordPO( String id,  String parId, Date outdoorsDuration, String feedingMode, String feedingSituation, String talkBaby, String vSupplement, String loudReaction, String teasingSmile, String gazeTracking, String riseProne, Date createTime, Date updateTime) {
				this.parId = parId;
				this.outdoorsDuration = outdoorsDuration;
				this.feedingMode = feedingMode;
				this.feedingSituation = feedingSituation;
				this.talkBaby = talkBaby;
				this.vSupplement = vSupplement;
				this.loudReaction = loudReaction;
				this.teasingSmile = teasingSmile;
				this.gazeTracking = gazeTracking;
				this.riseProne = riseProne;
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
	public Date getOutdoorsDuration() {
		return outdoorsDuration;
	}

	public void setOutdoorsDuration(Date outdoorsDuration) {
		this.outdoorsDuration = outdoorsDuration;
	}
	public String getFeedingMode() {
		return feedingMode;
	}

	public void setFeedingMode(String feedingMode) {
		this.feedingMode = feedingMode;
	}
	public String getFeedingSituation() {
		return feedingSituation;
	}

	public void setFeedingSituation(String feedingSituation) {
		this.feedingSituation = feedingSituation;
	}
	public String getTalkBaby() {
		return talkBaby;
	}

	public void setTalkBaby(String talkBaby) {
		this.talkBaby = talkBaby;
	}
	public String getVSupplement() {
		return vSupplement;
	}

	public void setVSupplement(String vSupplement) {
		this.vSupplement = vSupplement;
	}
	public String getLoudReaction() {
		return loudReaction;
	}

	public void setLoudReaction(String loudReaction) {
		this.loudReaction = loudReaction;
	}
	public String getTeasingSmile() {
		return teasingSmile;
	}

	public void setTeasingSmile(String teasingSmile) {
		this.teasingSmile = teasingSmile;
	}
	public String getGazeTracking() {
		return gazeTracking;
	}

	public void setGazeTracking(String gazeTracking) {
		this.gazeTracking = gazeTracking;
	}
	public String getRiseProne() {
		return riseProne;
	}

	public void setRiseProne(String riseProne) {
		this.riseProne = riseProne;
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