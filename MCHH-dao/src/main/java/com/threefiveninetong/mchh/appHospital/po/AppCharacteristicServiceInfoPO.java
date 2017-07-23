/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppCharacteristicServiceInfoPO.java
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
 * @ClassName: AppCharacteristicServiceInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppCharacteristicServiceInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 医院信息ID **/ 
	private String hospitalId;
	
    /** 名称 **/ 
	private String name;
	
    /** 小图片URL **/ 
	private String smallImageUrl;
	
    /** 大图片URL **/ 
	private String bigImageUrl;
	
    /** 内容介绍 **/ 
	private String content;
	
    /** 创建时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
    /** 0：无效； 1：有效 **/ 
	private String status;
	
    /** 排序号 **/ 
	private int sortNum;
	

	/**
	 * 构造 
	 */
	public AppCharacteristicServiceInfoPO() {
	}
	
	public AppCharacteristicServiceInfoPO( String id,  String hospitalId, String name, String smallImageUrl, String bigImageUrl, String content, Date createTime, Date updateTime, String status, int sortNum) {
				this.hospitalId = hospitalId;
				this.name = name;
				this.smallImageUrl = smallImageUrl;
				this.bigImageUrl = bigImageUrl;
				this.content = content;
				this.createTime = createTime;
				this.updateTime = updateTime;
				this.status = status;
				this.sortNum = sortNum;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

}