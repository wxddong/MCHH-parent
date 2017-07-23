/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppSchoolCurriculumInfoPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appHospital.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppSchoolCurriculumInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppSchoolCurriculumInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 医院信息ID **/ 
	private String hospitalId;
	
    /** 开课日期 **/ 
	private Date startDate;
	
    /** 课程开始时间 **/ 
	private Date startTime;
	
    /** 课程结束时间 **/ 
	private Date endTime;
	
    /** 课题 **/ 
	private String topic;
	
    /** 课程内容 **/ 
	private String courseContent;
	
    /** 主讲人 **/ 
	private String speaker;
	
    /** 创建时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppSchoolCurriculumInfoPO() {
	}
	
	public AppSchoolCurriculumInfoPO( String id,  String hospitalId, Date startDate, Date startTime, Date endTime, String topic, String courseContent, String speaker, Date createTime, Date updateTime) {
				this.hospitalId = hospitalId;
				this.startDate = startDate;
				this.startTime = startTime;
				this.endTime = endTime;
				this.topic = topic;
				this.courseContent = courseContent;
				this.speaker = speaker;
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

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}
	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
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