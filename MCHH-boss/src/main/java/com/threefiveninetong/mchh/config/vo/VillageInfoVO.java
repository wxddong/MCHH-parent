/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: VillageInfoVO.java  
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
 * @ClassName: VillageInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public class VillageInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 乡镇ID **/ 
	private String townshipId;
	private TownshipInfoVO townshipInfoVO;
	
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
	public VillageInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public TownshipInfoVO getTownshipInfoVO() {
		return townshipInfoVO;
	}

	public void setTownshipInfoVO(TownshipInfoVO townshipInfoVO) {
		this.townshipInfoVO = townshipInfoVO;
	}

	public String getName() {
		return name;
	}
	
	

	public String getTownshipId() {
		return townshipId;
	}

	public void setTownshipId(String townshipId) {
		this.townshipId = townshipId;
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