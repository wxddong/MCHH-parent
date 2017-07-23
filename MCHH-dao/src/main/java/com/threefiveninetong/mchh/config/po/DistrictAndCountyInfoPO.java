/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DistrictAndCountyInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.po;

import java.io.Serializable;
import java.util.Date;






/**
 * @ClassName: DistrictAndCountyInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
public class DistrictAndCountyInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 市区ID **/
	private String cityId;
	private CityInfoPO cityInfoPO;
	
    /** 外部流水号 **/ 
	private String name;
	
    /** 名称全拼 **/ 
	private String nameSpell;
	
    /** 打头字母 **/ 
	private String firstLetter;
	
    /** 删除标识 **/ 
	private String deleteSign;
	
    /** 编号 **/ 
	private String number;
	
    /** 排序号 **/ 
	private Integer sortNum;
	
    /** 人口总数 **/ 
	private String populationNum;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	
	private Date updateTime;
	/**是否有效**/
	/** 0：无效，1：有效 **/ 
	
	private String isvalid;
	/** 统计日期初始期 **/ 
	
	private Date statisticnow;
	
	 /** 统计日期截至期 **/ 
	private Date statisticfur;
	/**
	 * 构造 
	 */
	public DistrictAndCountyInfoPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public DistrictAndCountyInfoPO(String id, String cityId, CityInfoPO cityInfoPO, String name, String nameSpell,
			String firstLetter, String deleteSign, String number, Integer sortNum, String populationNum, Date creatTime,
			Date updateTime, String isvalid, Date statisticnow, Date statisticfur) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.cityInfoPO = cityInfoPO;
		this.name = name;
		this.nameSpell = nameSpell;
		this.firstLetter = firstLetter;
		this.deleteSign = deleteSign;
		this.number = number;
		this.sortNum = sortNum;
		this.populationNum = populationNum;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		this.isvalid = isvalid;
		this.statisticnow = statisticnow;
		this.statisticfur = statisticfur;
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


	public String getIsvalid() {
		return isvalid;
	}



	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}



	public String getId() {
		return id;
	}

	

	public void setId(String id) {
		this.id = id;
	}

	
	
	public String getCityId() {
		return cityId;
	}



	public void setCityId(String cityId) {
		this.cityId = cityId;
	}



	public CityInfoPO getCityInfoPO() {
		return cityInfoPO;
	}



	public void setCityInfoPO(CityInfoPO cityInfoPO) {
		this.cityInfoPO = cityInfoPO;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNameSpell() {
		return nameSpell;
	}

	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}
	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}
	public String getDeleteSign() {
		return deleteSign;
	}

	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public String getPopulationNum() {
		return populationNum;
	}

	public void setPopulationNum(String populationNum) {
		this.populationNum = populationNum;
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

}