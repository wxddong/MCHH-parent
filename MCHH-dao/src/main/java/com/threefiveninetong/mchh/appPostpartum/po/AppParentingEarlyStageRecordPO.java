/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEarlyStageRecordPO.java
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
 * @ClassName: AppParentingEarlyStageRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingEarlyStageRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：无，1：有 **/ 
	private String diseaseScreening;
	
    /** 0：无，1：有 **/ 
	private String hearingScreening;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingEarlyStageRecordPO() {
	}
	
	public AppParentingEarlyStageRecordPO( String id,  String parId, String diseaseScreening, String hearingScreening, Date createTime, Date updateTime) {
				this.parId = parId;
				this.diseaseScreening = diseaseScreening;
				this.hearingScreening = hearingScreening;
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
	public String getDiseaseScreening() {
		return diseaseScreening;
	}

	public void setDiseaseScreening(String diseaseScreening) {
		this.diseaseScreening = diseaseScreening;
	}
	public String getHearingScreening() {
		return hearingScreening;
	}

	public void setHearingScreening(String hearingScreening) {
		this.hearingScreening = hearingScreening;
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