/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationOtherInfoPO.java
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
 * @ClassName: AppPreparationOtherInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppPreparationOtherInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 爸爸结婚年龄 **/ 
	private String dadAge;
	
    /** 妈妈结婚年龄 **/ 
	private String momAge;
	
    /** 计划怀孕时间 **/ 
	private Date planTime;
	
    /** 0：疾病，1：健康 **/ 
	private String dadHealthy;
	
    /** 0：疾病，1：健康 **/ 
	private String momHealthy;
	
    /** 备孕爸爸检查状况为0时填写 **/ 
	private String dadHealthyRemark;
	
    /** 备孕妈妈检查状况为0时填写 **/ 
	private String momHealthyRemark;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppPreparationOtherInfoPO() {
	}
	
	public AppPreparationOtherInfoPO( String id,  String mbrId, String dadAge, String momAge, Date planTime, String dadHealthy, String momHealthy, String dadHealthyRemark, String momHealthyRemark, Date createTime, Date updateTime) {
				this.mbrId = mbrId;
				this.dadAge = dadAge;
				this.momAge = momAge;
				this.planTime = planTime;
				this.dadHealthy = dadHealthy;
				this.momHealthy = momHealthy;
				this.dadHealthyRemark = dadHealthyRemark;
				this.momHealthyRemark = momHealthyRemark;
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
	public String getDadAge() {
		return dadAge;
	}

	public void setDadAge(String dadAge) {
		this.dadAge = dadAge;
	}
	public String getMomAge() {
		return momAge;
	}

	public void setMomAge(String momAge) {
		this.momAge = momAge;
	}
	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}
	public String getDadHealthy() {
		return dadHealthy;
	}

	public void setDadHealthy(String dadHealthy) {
		this.dadHealthy = dadHealthy;
	}
	public String getMomHealthy() {
		return momHealthy;
	}

	public void setMomHealthy(String momHealthy) {
		this.momHealthy = momHealthy;
	}
	public String getDadHealthyRemark() {
		return dadHealthyRemark;
	}

	public void setDadHealthyRemark(String dadHealthyRemark) {
		this.dadHealthyRemark = dadHealthyRemark;
	}
	public String getMomHealthyRemark() {
		return momHealthyRemark;
	}

	public void setMomHealthyRemark(String momHealthyRemark) {
		this.momHealthyRemark = momHealthyRemark;
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