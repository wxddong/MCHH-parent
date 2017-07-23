/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMoodRecordPO.java
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
 * @ClassName: AppMoodRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppMoodRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 语录内容 **/ 
	private String content;
	
    /** 0：备孕期，1：孕产期，2：育儿期 **/ 
	private String type;
	
    /** 记录时间 **/ 
	private Date createTime;
	
	/** 修改时间*/
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppMoodRecordPO() {
	}
	
	public AppMoodRecordPO( String id,  String mbrId, String content, String type, Date createTime,Date updateTime) {
				this.mbrId = mbrId;
				this.content = content;
				this.type = type;
				this.createTime = createTime;
						this.id = id;
						this.updateTime = updateTime;
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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}