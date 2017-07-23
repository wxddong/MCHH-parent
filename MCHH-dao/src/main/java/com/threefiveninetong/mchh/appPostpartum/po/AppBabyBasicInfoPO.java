/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppBabyBasicInfoPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppBabyBasicInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppBabyBasicInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 末次月经 **/ 
	private Date birthday;
	
    /** 宝宝姓名 **/ 
	private String name;
	
    /** 宝宝性别 **/ 
	private String sex;
	
    /** 出生时间 **/ 
	private Date birthTime;
	
    /** 身长 **/ 
	private String length;
	
    /** 体重 **/ 
	private String weight;
	
    /** 出生孕周 **/ 
	private String birthGesWeeks;
	
    /** 出生地点 **/ 
	private String birthPlace;
	
    /** 接生机构 **/ 
	private String deliveryMec;
	
    /** 0：未结案，1：已结案 **/ 
	private String status;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppBabyBasicInfoPO() {
	}
	
	public AppBabyBasicInfoPO( String id,  String mbrId, Date birthday, String name, String sex, Date birthTime, String length, String weight, String birthGesWeeks, String birthPlace, String deliveryMec, String status, Date createTime, Date updateTime) {
				this.mbrId = mbrId;
				this.birthday = birthday;
				this.name = name;
				this.sex = sex;
				this.birthTime = birthTime;
				this.length = length;
				this.weight = weight;
				this.birthGesWeeks = birthGesWeeks;
				this.birthPlace = birthPlace;
				this.deliveryMec = deliveryMec;
				this.status = status;
				this.createTime = createTime;
				this.updateTime = updateTime;
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
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBirthGesWeeks() {
		return birthGesWeeks;
	}

	public void setBirthGesWeeks(String birthGesWeeks) {
		this.birthGesWeeks = birthGesWeeks;
	}
	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getDeliveryMec() {
		return deliveryMec;
	}

	public void setDeliveryMec(String deliveryMec) {
		this.deliveryMec = deliveryMec;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}