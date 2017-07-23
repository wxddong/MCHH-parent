/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrOperationRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appMember.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppMbrOperationRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppMbrOperationRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 操作时间 **/ 
	private Date ornTime;
	
    /** 0：修改密码；1：更新会员信息
             **/ 
	private String ornType;
	
    /** 备注信息 **/ 
	private String remark;
	

	/**
	 * 构造 
	 */
	public AppMbrOperationRecordPO() {
	}
	
	public AppMbrOperationRecordPO( String id,  String mbrId, Date ornTime, String ornType, String remark) {
				this.mbrId = mbrId;
				this.ornTime = ornTime;
				this.ornType = ornType;
				this.remark = remark;
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
	public Date getOrnTime() {
		return ornTime;
	}

	public void setOrnTime(Date ornTime) {
		this.ornTime = ornTime;
	}
	public String getOrnType() {
		return ornType;
	}

	public void setOrnType(String ornType) {
		this.ornType = ornType;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}