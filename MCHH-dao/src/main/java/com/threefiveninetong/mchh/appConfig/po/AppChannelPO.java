/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppChannelPO.java
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
 * @ClassName: AppChannelPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppChannelPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 渠道号 **/ 
	private String channelCode;
	
    /** 渠道名 **/ 
	private String channelName;
	
    /** 0:IOS 1:安卓 **/ 
	private String equipmentType;
	
    /** 创建时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppChannelPO() {
	}
	
	public AppChannelPO( String id,  String channelCode, String channelName, String equipmentType, Date createTime) {
				this.channelCode = channelCode;
				this.channelName = channelName;
				this.equipmentType = equipmentType;
				this.createTime = createTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}