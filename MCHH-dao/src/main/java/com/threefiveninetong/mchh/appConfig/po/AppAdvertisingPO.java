/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppAdvertisingPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appConfig.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-11-02 10:45:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: AppAdvertisingPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:03 
 */
public class AppAdvertisingPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 名称 **/ 
	private String title;
	
    /** 广告内容 **/ 
	private String content;
	
    /** 广告图片 **/ 
	private String imageUrl;
	
    /** 生效时间 **/ 
	private Date bigenTime;
	
    /** 失效时间 **/ 
	private Date endTime;
	
    /** 创建时间 **/ 
	private Date createTime;
	
    /** 0:有效;1:无效 **/ 
	private String status;
	
    /** 0:启动页;1:广告 **/ 
	private String type;
	

	/**
	 * 构造 
	 */
	public AppAdvertisingPO() {
	}
	
	public AppAdvertisingPO( String id,  String title, String content, String imageUrl, Date bigenTime, Date endTime, Date createTime, String status, String type) {
				this.title = title;
				this.content = content;
				this.imageUrl = imageUrl;
				this.bigenTime = bigenTime;
				this.endTime = endTime;
				this.createTime = createTime;
				this.status = status;
				this.type = type;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getBigenTime() {
		return bigenTime;
	}

	public void setBigenTime(Date bigenTime) {
		this.bigenTime = bigenTime;
	}
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}