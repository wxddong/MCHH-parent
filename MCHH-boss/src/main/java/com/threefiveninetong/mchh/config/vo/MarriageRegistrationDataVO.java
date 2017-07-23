/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: MarriageRegistrationDataVO.java  
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
 * @ClassName: MarriageRegistrationDatavo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public class MarriageRegistrationDataVO {

	/** 主键ID **/ 
	private String id;
	
    /** 区县ID **/ 
	private String countyId;
	/** 区县名称 **/ 
	private String name;
    /** 结婚登记总数 **/ 
	private String marryNum;
	
    /** 数据来源 **/ 
	private String sources;
	
    /** 统计日期初始期 **/ 
	private Date statisticnow;

	 /** 统计日期截至期 **/ 
	private Date statisticfur;
	

	/** 0：无效，1：有效 **/ 
	private String isvalid;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public MarriageRegistrationDataVO() {
	}
	  public Date getStatisticnow() {
			return statisticnow;
		}

		public void setStatisticnow(Date statisticnow) {
			this.statisticnow = statisticnow;
		}

		public Date getStatisticfur() {
			return statisticfur;
		}

		public void setStatisticfur(Date statisticfur) {
			this.statisticfur = statisticfur;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	public String getMarryNum() {
		return marryNum;
	}

	public void setMarryNum(String marryNum) {
		this.marryNum = marryNum;
	}
	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
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
	public MarriageRegistrationDataVO(String id, String countyId, String name, String marryNum, String sources,
			Date statisticnow, Date statisticfur, String isvalid, Date creatTime, Date updateTime) {
		super();
		this.id = id;
		this.countyId = countyId;
		this.name = name;
		this.marryNum = marryNum;
		this.sources = sources;
		this.statisticnow = statisticnow;
		this.statisticfur = statisticfur;
		this.isvalid = isvalid;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
	}

}