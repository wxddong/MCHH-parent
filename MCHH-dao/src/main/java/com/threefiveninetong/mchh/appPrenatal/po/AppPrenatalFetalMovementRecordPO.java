/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalFetalMovementRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppPrenatalFetalMovementRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public class AppPrenatalFetalMovementRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 胎动次数 **/ 
	private String moveNum;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppPrenatalFetalMovementRecordPO() {
	}
	
	public AppPrenatalFetalMovementRecordPO( String id,  String mbrId, String moveNum, Date createTime) {
				this.mbrId = mbrId;
				this.moveNum = moveNum;
				this.createTime = createTime;
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
	public String getMoveNum() {
		return moveNum;
	}

	public void setMoveNum(String moveNum) {
		this.moveNum = moveNum;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}