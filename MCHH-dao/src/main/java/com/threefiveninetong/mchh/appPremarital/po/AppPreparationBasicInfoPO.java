/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationBasicInfoPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPremarital.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPremarital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppPreparationBasicInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppPreparationBasicInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 最后一次月经开始的日期 **/ 
	private Date lastMenses;
	
    /** 月经开始日期到结束日期天数
             **/ 
	private String period;
	
    /** 间隔天数 **/ 
	private String menstrualCycle;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
    /** 0：未结案，1：结案 **/ 
	private String status;
	

	/**
	 * 构造 
	 */
	public AppPreparationBasicInfoPO() {
	}
	
	public AppPreparationBasicInfoPO( String id,  String mbrId, Date lastMenses, String period, String menstrualCycle, Date createTime, Date updateTime, String status) {
				this.mbrId = mbrId;
				this.lastMenses = lastMenses;
				this.period = period;
				this.menstrualCycle = menstrualCycle;
				this.createTime = createTime;
				this.updateTime = updateTime;
				this.status = status;
						this.id = id;
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
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	public String getMenstrualCycle() {
		return menstrualCycle;
	}

	public void setMenstrualCycle(String menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}