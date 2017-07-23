/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationTemperatureRecordPO.java
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
 * @ClassName: AppPreparationTemperatureRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppPreparationTemperatureRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 体温 **/ 
	private String temperature;
	
    /** 0：非经期，1：经期 **/ 
	private String periodSign;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppPreparationTemperatureRecordPO() {
	}
	
	public AppPreparationTemperatureRecordPO( String id,  String mbrId, String temperature, String periodSign, Date createTime) {
				this.mbrId = mbrId;
				this.temperature = temperature;
				this.periodSign = periodSign;
				this.createTime = createTime;
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
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPeriodSign() {
		return periodSign;
	}

	public void setPeriodSign(String periodSign) {
		this.periodSign = periodSign;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}