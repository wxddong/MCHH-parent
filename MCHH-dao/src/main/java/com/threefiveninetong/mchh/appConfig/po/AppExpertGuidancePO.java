/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppExpertGuidancePO.java
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
 * @ClassName: AppExpertGuidancePO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppExpertGuidancePO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 标题 **/ 
	private String title;
	
    /** 内容 **/ 
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
	
    /** 0：营养，1：运动，2：排卵期，3：膳食 **/ 
	private String type;
	
    /** 0：备孕期，1：孕产期，2：育儿期 **/ 
	private String classification;
	
    /** 创建时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppExpertGuidancePO() {
	}
	
	public AppExpertGuidancePO( String id,  String title, String content, String smallImageUrl, String bigImageUrl, Date bigenTime, Date endTime, String status, String type, String classification, Date createTime, Date updateTime) {
				this.title = title;
				this.content = content;
				this.smallImageUrl = smallImageUrl;
				this.bigImageUrl = bigImageUrl;
				this.bigenTime = bigenTime;
				this.endTime = endTime;
				this.status = status;
				this.type = type;
				this.classification = classification;
				this.createTime = createTime;
				this.updateTime = updateTime;
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