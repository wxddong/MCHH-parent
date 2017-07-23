/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalLectureRecordPO.java
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
 * @ClassName: AppPrenatalLectureRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public class AppPrenatalLectureRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 课目 **/ 
	private String subjects;
	
    /** 内容 **/ 
	private String content;
	
    /** 听课时间 **/ 
	private Date lectureTime;
	
    /** 备注 **/ 
	private String remark;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppPrenatalLectureRecordPO() {
	}
	
	public AppPrenatalLectureRecordPO( String id,  String mbrId, String subjects, String content, Date lectureTime, String remark, Date createTime) {
				this.mbrId = mbrId;
				this.subjects = subjects;
				this.content = content;
				this.lectureTime = lectureTime;
				this.remark = remark;
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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Date getLectureTime() {
		return lectureTime;
	}

	public void setLectureTime(Date lectureTime) {
		this.lectureTime = lectureTime;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
}