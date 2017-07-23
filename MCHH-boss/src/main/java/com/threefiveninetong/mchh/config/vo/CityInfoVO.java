/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: CityInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.vo;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;


/**
 * @ClassName: CityInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
public class CityInfoVO {

	/** 主键ID **/ 
	private String id;
	
	private String provinceId;
	
	/** 省份 **/ 
	private ProvinceInfoVO provinceInfoVO;
	
    /** 外部流水号 **/ 
	private String name;
	
    /** 名称全拼 **/ 
	private String nameSpell;
	
    /** 打头字母 **/ 
	private String firstLetter;
	
    /** 删除标识 **/ 
	private String deleteSign;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 排序号 **/ 
	private Integer sortNum;
	
    /** 编号 **/ 
	private String number;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public CityInfoVO() {
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public ProvinceInfoVO getProvinceInfoVO() {
		return provinceInfoVO;
	}

	public void setProvinceInfoVO(ProvinceInfoVO provinceInfoVO) {
		this.provinceInfoVO = provinceInfoVO;
	}

	 public String getProvinceId() {
			return provinceId;
		}



	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
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
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}