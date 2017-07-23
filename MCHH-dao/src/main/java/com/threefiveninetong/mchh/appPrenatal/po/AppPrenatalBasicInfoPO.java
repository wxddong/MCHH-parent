/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalBasicInfoPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppPrenatalBasicInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public class AppPrenatalBasicInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 最后一次月经开始的日期 **/ 
	private Date lastMenses;
	
    /** 预产期 **/ 
	private Date predictDate;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 0：未结案，1：已结案 **/ 
	private String status;
	
	/** 最后修改时间*/
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppPrenatalBasicInfoPO() {
	}
	
	public AppPrenatalBasicInfoPO( String id,  String mbrId, Date lastMenses, Date predictDate, Date createTime, String status,Date updateTime) {
				this.mbrId = mbrId;
				this.lastMenses = lastMenses;
				this.predictDate = predictDate;
				this.createTime = createTime;
				this.status = status;
						this.id = id;
						this.updateTime = updateTime;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public Date getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(Date lastMenses) {
		this.lastMenses = lastMenses;
	}
	public Date getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}