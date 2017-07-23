/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: VillageInfoPO.java
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
 * @ClassName: VillageInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public class VillageInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 乡镇ID **/ 
	private String townshipId;
	private TownshipInfoPO townshipInfoPO;
	
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
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public VillageInfoPO() {
	}
	
	
	
	public VillageInfoPO(String id, TownshipInfoPO townshipInfoPO, String name, String nameSpell, String firstLetter,
			String deleteSign, String number, Integer sortNum, Date creatTime, Date updateTime) {
		super();
		this.id = id;
		this.townshipInfoPO = townshipInfoPO;
		this.name = name;
		this.nameSpell = nameSpell;
		this.firstLetter = firstLetter;
		this.deleteSign = deleteSign;
		this.number = number;
		this.sortNum = sortNum;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getTownshipId() {
		return townshipId;
	}



	public void setTownshipId(String townshipId) {
		this.townshipId = townshipId;
	}



	public TownshipInfoPO getTownshipInfoPO() {
		return townshipInfoPO;
	}



	public void setTownshipInfoPO(TownshipInfoPO townshipInfoPO) {
		this.townshipInfoPO = townshipInfoPO;
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