/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppBannerInfoPO.java
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
 * @ClassName: AppBannerInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppBannerInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 名称 **/ 
	private String title;
	
    /** 广告内容 **/ 
	private String content;
	
    /** 小图片URL **/ 
	private String smallImageUrl;
	
    /** 大图片URL **/ 
	private String bigImageUrl;
	
    /** 生效时间 **/ 
	private Date bigenTime;
	
    /** 失效时间 **/ 
	private Date endTime;
	
    /** 0:无效;1:有效 **/ 
	private String status;
	
    /** 创建时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
    /** 0：备孕期，1：孕产期，2：育儿期 **/ 
	private String type;
	

	/**
	 * 构造 
	 */
	public AppBannerInfoPO() {
	}
	
	public AppBannerInfoPO( String id,  String title, String content, String smallImageUrl, String bigImageUrl, Date bigenTime, Date endTime, String status, Date createTime, Date updateTime, String type) {
				this.title = title;
				this.content = content;
				this.smallImageUrl = smallImageUrl;
				this.bigImageUrl = bigImageUrl;
				this.bigenTime = bigenTime;
				this.endTime = endTime;
				this.status = status;
				this.createTime = createTime;
				this.updateTime = updateTime;
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
	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}