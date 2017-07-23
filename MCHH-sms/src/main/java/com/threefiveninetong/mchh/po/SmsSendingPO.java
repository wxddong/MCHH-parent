/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsSendingPO.java
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
 * @ClassName: SmsSendingPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:51 
 */
public class SmsSendingPO implements Serializable  ,Cloneable{

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 短信发送者(手机号码) **/ 
	private String sender;
	
    /** 短信接收者(手机号码)，可能多个 **/ 
	private String receiver;
	
    /** 短信内容 **/ 
	private String content;
	
    /** 短信的创建时间 **/ 
	private Date createtime;
	
    /** 短信类型 0.补发短信,1.提醒 **/ 
	private String smstype;
	
    /** 发送级别，系统按级别高低的优先级进行发送，1为最高级别 **/ 
	private String sendlevel;
	
    /**自定义平台编码，如：YM **/ 
	private String platformCode;
	
    /** 0未读;1已读 **/ 
	private String state;
	
    /** 渠道 **/ 
	private String channel;
	

	/**
	 * 构造 
	 */
	public SmsSendingPO() {
	}
	
	public SmsSendingPO( String id,  String sender,   String receiver,   String content,   Date createtime,   String smstype,   String sendlevel,   String platformCode,   String state,   String channel ) {
				this.sender = sender;
				this.receiver = receiver;
				this.content = content;
				this.createtime = createtime;
				this.smstype = smstype;
				this.sendlevel = sendlevel;
				this.platformCode = platformCode;
				this.state = state;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public SmsSendingPO clone(){
		// TODO Auto-generated method stub
		try {
			return (SmsSendingPO) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}