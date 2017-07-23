/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppActivationPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appStatis.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appStatis.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppActivationPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
public class AppActivationPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** ios为自生成编码，android为（设备号） **/ 
	private String equipmentNo;
	
    /** 渠道 **/ 
	private String channelCode;
	
    /** 手机号(注册、登陆必填) **/ 
	private String phone;
	
    /** 设备型号，如小米5s **/ 
	private String equipmentModel;
	
    /** 设备系统版本 **/ 
	private String equipmentSysVersion;
	
    /** 访问类型 0:激活（安装未注册）; 1:注册;2:登陆 **/ 
	private String visitcountType;
	
    /** 版本号 **/ 
	private String version;
	
    /** 添加时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppActivationPO() {
	}
	
	public AppActivationPO( String id,  String equipmentNo, String channelCode, String phone, String equipmentModel, String equipmentSysVersion, String visitcountType, String version, Date createTime) {
				this.equipmentNo = equipmentNo;
				this.channelCode = channelCode;
				this.phone = phone;
				this.equipmentModel = equipmentModel;
				this.equipmentSysVersion = equipmentSysVersion;
				this.visitcountType = visitcountType;
				this.version = version;
				this.createTime = createTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	public String getEquipmentSysVersion() {
		return equipmentSysVersion;
	}

	public void setEquipmentSysVersion(String equipmentSysVersion) {
		this.equipmentSysVersion = equipmentSysVersion;
	}
	public String getVisitcountType() {
		return visitcountType;
	}

	public void setVisitcountType(String visitcountType) {
		this.visitcountType = visitcountType;
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}