/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppIosPushDevicetokenPO.java
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
 * @ClassName: AppIosPushDevicetokenPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
public class AppIosPushDevicetokenPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** IOS自生成令牌 **/ 
	private String equipmentNo;
	
    /** iphone推送令牌 **/ 
	private String devicetoken;
	
    /** 添加时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
    /** 访问统计表ID **/ 
	private String activationId;
	

	/**
	 * 构造 
	 */
	public AppIosPushDevicetokenPO() {
	}
	
	public AppIosPushDevicetokenPO( String id,  String equipmentNo, String devicetoken, Date createTime, Date updateTime, String activationId) {
				this.equipmentNo = equipmentNo;
				this.devicetoken = devicetoken;
				this.createTime = createTime;
				this.updateTime = updateTime;
				this.activationId = activationId;
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
	public String getDevicetoken() {
		return devicetoken;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
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
	public String getActivationId() {
		return activationId;
	}

	public void setActivationId(String activationId) {
		this.activationId = activationId;
	}

}