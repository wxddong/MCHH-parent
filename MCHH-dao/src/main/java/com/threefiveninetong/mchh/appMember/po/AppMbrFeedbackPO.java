/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrFeedbackPO.java
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

import com.threefiveninetong.mchh.sys.po.OperatorPO;




/**
 * @ClassName: AppMbrFeedbackPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public class AppMbrFeedbackPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 标题 **/ 
	private String title;
	
    /** 意见反馈内容 **/ 
	private String content;
	
    /** 添加时间 **/ 
	private Date createTime;
	
    /** 处理人 **/ 
	private String opnName;
	
    /** 状态0:未处理;1:已处理 **/ 
	private String status;
	
    /** 处理内容 **/ 
	private String opnRemark;
	
    /** 处理时间 **/ 
	private Date opnTime;

	/**
	 * 会员信息
	 */
	private AppMemberPO appMemberPO;
	
	/**
	 * 医生信息
	 */
	private OperatorPO operatorPO;

	public OperatorPO getOperatorPO() {
		return operatorPO;
	}

	public void setOperatorPO(OperatorPO operatorPO) {
		this.operatorPO = operatorPO;
	}

	/**
	 * 构造 
	 */
	public AppMbrFeedbackPO() {
	}
	
	public AppMemberPO getAppMemberPO() {
		return appMemberPO;
	}

	public void setAppMemberPO(AppMemberPO appMemberPO) {
		this.appMemberPO = appMemberPO;
	}

	public AppMbrFeedbackPO( String id,  String mbrId, String title, String content, Date createTime, String opnName, String status, String opnRemark, Date opnTime) {
				this.mbrId = mbrId;
				this.title = title;
				this.content = content;
				this.createTime = createTime;
				this.opnName = opnName;
				this.status = status;
				this.opnRemark = opnRemark;
				this.opnTime = opnTime;
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
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOpnName() {
		return opnName;
	}

	public void setOpnName(String opnName) {
		this.opnName = opnName;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getOpnRemark() {
		return opnRemark;
	}

	public void setOpnRemark(String opnRemark) {
		this.opnRemark = opnRemark;
	}
	public Date getOpnTime() {
		return opnTime;
	}

	public void setOpnTime(Date opnTime) {
		this.opnTime = opnTime;
	}

}