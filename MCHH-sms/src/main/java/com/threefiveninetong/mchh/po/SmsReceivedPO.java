/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsReceivedPO.java
 * @Prject: MCHH-dao
 * @Package: cn.com.devsource.MCHH.sms.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-01-28 18:10:50 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: SmsReceivedPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:50 
 */
public class SmsReceivedPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 短信发送者（号码） **/ 
	private String sender;
	
    /** 短信内容 **/ 
	private String content;
	
    /** 短信发送时间 **/ 
	private Date sendtime;
	
    /** 自定义平台编码，如：YM **/ 
	private String platformCode;
	
    /** 是否处理过（0表示未处理，1表示处理） **/ 
	private String isdealed;
	
    /** 处理人员（责任人） **/ 
	private String dealman;
	
    /** 处理时间 **/ 
	private Date dealtime;
	
    /** 春霖最小的id标识(0：标识最小，1：标识普通) **/ 
	private String clidmark;
	
    /** 春霖的id **/ 
	private String clid;
	

	/**
	 * 构造 
	 */
	public SmsReceivedPO() {
	}
	
	public SmsReceivedPO( String id,  String sender,   String content,   Date sendtime,   String platformCode,   String isdealed,   String dealman,   Date dealtime,   String clidmark,   String clid ) {
				this.sender = sender;
				this.content = content;
				this.sendtime = sendtime;
				this.platformCode = platformCode;
				this.isdealed = isdealed;
				this.dealman = dealman;
				this.dealtime = dealtime;
				this.clidmark = clidmark;
				this.clid = clid;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getIsdealed() {
		return isdealed;
	}

	public void setIsdealed(String isdealed) {
		this.isdealed = isdealed;
	}
	public String getDealman() {
		return dealman;
	}

	public void setDealman(String dealman) {
		this.dealman = dealman;
	}
	public Date getDealtime() {
		return dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}
	public String getClidmark() {
		return clidmark;
	}

	public void setClidmark(String clidmark) {
		this.clidmark = clidmark;
	}
	public String getClid() {
		return clid;
	}

	public void setClid(String clid) {
		this.clid = clid;
	}

}