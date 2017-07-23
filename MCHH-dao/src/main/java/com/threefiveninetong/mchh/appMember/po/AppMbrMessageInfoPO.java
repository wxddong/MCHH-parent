/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrMessageInfoPO.java
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
 * @ClassName: AppMbrMessageInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppMbrMessageInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 医院信息ID **/ 
	private String hospitalId;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 消息标题 **/ 
	private String title;
	
    /** 消息内容 **/ 
	private String content;
	
    /** 收到时间 **/ 
	private Date receiveTime;
	
    /** 0：医院通知，1：系统通知 **/ 
	private String type;
	
	/** 0-备孕期  1-孕产期  2-育儿期*/
	private String classification;
	

	/**
	 * 构造 
	 */
	public AppMbrMessageInfoPO() {
	}
	
	public AppMbrMessageInfoPO( String id,  String hospitalId, String mbrId, String title, String content, Date receiveTime, String type,String classification) {
				this.hospitalId = hospitalId;
				this.mbrId = mbrId;
				this.title = title;
				this.content = content;
				this.receiveTime = receiveTime;
				this.type = type;
						this.id = id;
						this.classification = classification;
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
	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}