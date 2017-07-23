/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppVersionForcedUpdatePO.java
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
 * @ClassName: AppVersionForcedUpdatePO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppVersionForcedUpdatePO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 版本 **/ 
	private String version;
	
    /** 0：IOS；1：安卓 **/ 
	private String equipmentType;
	
    /** 版本号 **/ 
	private String versionCode;
	
    /** 渠道 **/ 
	private String channelCode;
	
    /** 0：启用；1：不启用 **/ 
	private String statue;
	
    /** 生效时间 **/ 
	private Date bigenTime;
	
    /** 创建时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppVersionForcedUpdatePO() {
	}
	
	public AppVersionForcedUpdatePO( String id,  String version, String equipmentType, String versionCode, String channelCode, String statue, Date bigenTime, Date createTime) {
				this.version = version;
				this.equipmentType = equipmentType;
				this.versionCode = versionCode;
				this.channelCode = channelCode;
				this.statue = statue;
				this.bigenTime = bigenTime;
				this.createTime = createTime;
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
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}
	public Date getBigenTime() {
		return bigenTime;
	}

	public void setBigenTime(Date bigenTime) {
		this.bigenTime = bigenTime;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}