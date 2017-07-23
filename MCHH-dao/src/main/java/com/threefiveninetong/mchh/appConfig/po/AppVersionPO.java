/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppVersionPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appConfig.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppVersionPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppVersionPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 名称(如：V1.0) **/ 
	private String version;
	
    /** 版本号(如：1) **/ 
	private String versionCode;
	
    /** 0:IOS; 1:安卓 **/ 
	private String equipmentType;
	
    /** 描述对应版本的更新内容 **/ 
	private String description;
	
    /** 渠道号 **/ 
	private String channelCode;
	
    /** 更新下载的URL **/ 
	private String downloadUrl;
	
    /** 生效时间 **/ 
	private Date bigenTime;
	

	/**
	 * 构造 
	 */
	public AppVersionPO() {
	}
	
	public AppVersionPO( String id,  String version, String versionCode, String equipmentType, String description, String channelCode, String downloadUrl, Date bigenTime) {
				this.version = version;
				this.versionCode = versionCode;
				this.equipmentType = equipmentType;
				this.description = description;
				this.channelCode = channelCode;
				this.downloadUrl = downloadUrl;
				this.bigenTime = bigenTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public Date getBigenTime() {
		return bigenTime;
	}

	public void setBigenTime(Date bigenTime) {
		this.bigenTime = bigenTime;
	}

}