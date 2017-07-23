/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PopulationDataVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: PopulationDatavo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public class PopulationDataVO {

	/** 主键ID **/ 
	private String id;
	
    /** 区县ID **/ 
	private String countyId;
	
    /** 乡ID **/ 
	private String towId;
	
	/** 村ID **/ 
	private String villageId;
	
    /** 结婚登记总数 **/ 
	private String marryNum;
	
    /** 0：无效，1：有效 **/ 
	private String isvalid;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
    /** 统计日期 **/ 
	private Date statisticalDate;
	
	/**统计日期结束时间**/
	private Date statisticalDateEnd;
	
	
	

	/**
	 * 构造 
	 */
	public PopulationDataVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	public String getTowId() {
		return towId;
	}

	public void setTowId(String towId) {
		this.towId = towId;
	}
	
	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}

	public String getMarryNum() {
		return marryNum;
	}

	public void setMarryNum(String marryNum) {
		this.marryNum = marryNum;
	}
	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getStatisticalDate() {
		return statisticalDate;
	}

	public void setStatisticalDate(Date statisticalDate) {
		this.statisticalDate = statisticalDate;
	}

	public Date getStatisticalDateEnd() {
		return statisticalDateEnd;
	}

	public void setStatisticalDateEnd(Date statisticalDateEnd) {
		this.statisticalDateEnd = statisticalDateEnd;
	}

}