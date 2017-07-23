/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneMonthRecordPO.java
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
 * @ClassName: AppParentingOneMonthRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingOneMonthRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 脐带脱离时间 **/ 
	private Date umbilicalTime;
	
    /** 皮肤黄染消退时间 **/ 
	private Date jaundiceFadeTime;
	
    /** 0：母乳，1：混合，2：奶粉 **/ 
	private String feedingMode;
	
    /** 0：不好，1：不好 **/ 
	private String feedingSituation;
	
    /** 0：无，1：有 **/ 
	private String frightCry;
	
    /** 0：否，1：是 **/ 
	private String crying;
	
    /** 0：否，1：是 **/ 
	private String vSupplement;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingOneMonthRecordPO() {
	}
	
	public AppParentingOneMonthRecordPO( String id,  String parId, Date umbilicalTime, Date jaundiceFadeTime, String feedingMode, String feedingSituation, String frightCry, String crying, String vSupplement, Date createTime, Date updateTime) {
				this.parId = parId;
				this.umbilicalTime = umbilicalTime;
				this.jaundiceFadeTime = jaundiceFadeTime;
				this.feedingMode = feedingMode;
				this.feedingSituation = feedingSituation;
				this.frightCry = frightCry;
				this.crying = crying;
				this.vSupplement = vSupplement;
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
	public Date getUmbilicalTime() {
		return umbilicalTime;
	}

	public void setUmbilicalTime(Date umbilicalTime) {
		this.umbilicalTime = umbilicalTime;
	}
	public Date getJaundiceFadeTime() {
		return jaundiceFadeTime;
	}

	public void setJaundiceFadeTime(Date jaundiceFadeTime) {
		this.jaundiceFadeTime = jaundiceFadeTime;
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
	public String getFrightCry() {
		return frightCry;
	}

	public void setFrightCry(String frightCry) {
		this.frightCry = frightCry;
	}
	public String getCrying() {
		return crying;
	}

	public void setCrying(String crying) {
		this.crying = crying;
	}
	public String getVSupplement() {
		return vSupplement;
	}

	public void setVSupplement(String vSupplement) {
		this.vSupplement = vSupplement;
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