/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppHospitalInfoPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appHospital.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppHospitalInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppHospitalInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 医院名称 **/ 
	private String hospitalName;
	
    /** 咨询电话 **/ 
	private String telephone;
	
    /** 小图片URL **/ 
	private String smallImageUrl;
	
    /** 大图片URL **/ 
	private String bigImageUrl;
	
    /** 简介 **/ 
	private String brief;
	
    /** 创建时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppHospitalInfoPO() {
	}
	
	public AppHospitalInfoPO( String id,  String hospitalName, String telephone, String smallImageUrl, String bigImageUrl, String brief, Date createTime, Date updateTime) {
				this.hospitalName = hospitalName;
				this.telephone = telephone;
				this.smallImageUrl = smallImageUrl;
				this.bigImageUrl = bigImageUrl;
				this.brief = brief;
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
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