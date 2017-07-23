/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: TownshipInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.po;

import java.io.Serializable;
import java.util.Date;






/**
 * @ClassName: TownshipInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public class TownshipInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 区县ID **/ 
	private String countyId;
	private DistrictAndCountyInfoPO countyInfoPO;
	
    /** 外部流水号 **/ 
	private String name;
	
    /** 名称全拼 **/ 
	private String nameSpell;
	
    /** 打头字母 **/ 
	private String firstLetter;
	
    /** 删除标识 **/ 
	private String deleteSign;
	
    /** 排序号 **/ 
	private Integer sortNum;
	
    /** 编号 **/ 
	private String number;
	
    /** 人口总数 **/ 
	private String populationNum;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public TownshipInfoPO() {
	}
	
	
	
	public TownshipInfoPO(String id, DistrictAndCountyInfoPO countyInfoPO, String name, String nameSpell,
			String firstLetter, String deleteSign, Integer sortNum, String number, String populationNum, Date creatTime,
			Date updateTime) {
		super();
		this.id = id;
		this.countyInfoPO = countyInfoPO;
		this.name = name;
		this.nameSpell = nameSpell;
		this.firstLetter = firstLetter;
		this.deleteSign = deleteSign;
		this.sortNum = sortNum;
		this.number = number;
		this.populationNum = populationNum;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
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



	public DistrictAndCountyInfoPO getCountyInfoPO() {
		return countyInfoPO;
	}

	public void setCountyInfoPO(DistrictAndCountyInfoPO countyInfoPO) {
		this.countyInfoPO = countyInfoPO;
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
	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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