/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppActivationStatisticsPO.java
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
 * @ClassName: AppActivationStatisticsPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
public class AppActivationStatisticsPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private int id;
	
    /** 渠道 **/ 
	private String channelNo;
	
    /** 添加时间 **/ 
	private Date createDate;
	
    /** 激活数量 **/ 
	private int activationNumber;
	
    /** 注册数量 **/ 
	private int registerNumber;
	
    /** 累计激活数 **/ 
	private int activationCount;
	
    /** 累计注册数 **/ 
	private int registerCount;
	

	/**
	 * 构造 
	 */
	public AppActivationStatisticsPO() {
	}
	
	public AppActivationStatisticsPO( int id,  String channelNo, Date createDate, int activationNumber, int registerNumber, int activationCount, int registerCount) {
				this.channelNo = channelNo;
				this.createDate = createDate;
				this.activationNumber = activationNumber;
				this.registerNumber = registerNumber;
				this.activationCount = activationCount;
				this.registerCount = registerCount;
						this.id = id;
			}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getActivationNumber() {
		return activationNumber;
	}

	public void setActivationNumber(int activationNumber) {
		this.activationNumber = activationNumber;
	}
	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}
	public int getActivationCount() {
		return activationCount;
	}

	public void setActivationCount(int activationCount) {
		this.activationCount = activationCount;
	}
	public int getRegisterCount() {
		return registerCount;
	}

	public void setRegisterCount(int registerCount) {
		this.registerCount = registerCount;
	}

}