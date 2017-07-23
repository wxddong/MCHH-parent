/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsSendedFailPO.java
 * @Prject: MCHH-dao
 * @Package: cn.com.devsource.MCHH.sms.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-01-28 18:10:51 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: SmsSendedFailPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:51 
 */
public class SmsSendedFailPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 短信发送者(手机号码) **/ 
	private String sender;
	
    /** 短信接收者(手机号码) **/ 
	private String receiver;
	
    /** 短信内容 **/ 
	private String content;
	
    /** 短信创建时间 **/ 
	private Date createtime;
	
    /** 短信类型 **/ 
	private String smstype;
	
    /** 短信发送时间 **/ 
	private Date sendtime;
	
    /** 发送级别，系统按级别高低的优先级进行发送，1为最高级别 **/ 
	private String sendlevel;
	
    /** 自定义平台编码，如：YM **/ 
	private String platformCode;
	
    /** 错误描述 **/ 
	private String description;
	
    /** 渠道 **/ 
	private String channel;
	

	/**
	 * 构造 
	 */
	public SmsSendedFailPO() {
	}
	
	public SmsSendedFailPO( String id,  String sender,   String receiver,   String content,   Date createtime,   String smstype,   Date sendtime,   String sendlevel,   String platformCode,   String description,   String channel ) {
				this.sender = sender;
				this.receiver = receiver;
				this.content = content;
				this.createtime = createtime;
				this.smstype = smstype;
				this.sendtime = sendtime;
				this.sendlevel = sendlevel;
				this.platformCode = platformCode;
				this.description = description;
				this.channel = channel;
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
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getSmstype() {
		return smstype;
	}

	public void setSmstype(String smstype) {
		this.smstype = smstype;
	}
	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getSendlevel() {
		return sendlevel;
	}

	public void setSendlevel(String sendlevel) {
		this.sendlevel = sendlevel;
	}
	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}