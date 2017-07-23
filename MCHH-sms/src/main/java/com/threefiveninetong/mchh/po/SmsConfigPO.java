/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsConfigPO.java
 * @Prject: MCHH-dao
 * @Package: cn.com.devsource.MCHH.sms.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-01-28 18:10:49 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.po;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;




/**
 * @ClassName: SmsConfigPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:49 
 */
public class SmsConfigPO implements Serializable, Comparator<SmsConfigPO> {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 平台的名称 **/ 
	private String name;
	
    /** 平台可接受的短信类型，入123,345,342默认为* **/ 
	private String smsType;
	
    /** 平台可接受的手机号码，以什么开头的比如182,159,默认为* **/ 
	private String phoneAcceped;
	
    /** 是否启用0不启用，1启用 **/ 
	private String isUse;
	
    /** 操作人 **/ 
	private String operator;
	
    /** 操作时间 **/ 
	private Date updateTime;
	
    /** 剩余多少条报警，短信剩余多少条通知 **/ 
	private String balanceNotify;
	
    /** 通知人姓名及电话号码,如 李三:159468734/王五:153397422/ **/ 
	private String notifyer;
	
    /** 下行状态通知发送失败后,再发多少次 **/ 
	private String failnum;
	
    /** 平台给客户发短信的号码 **/ 
	private String sendPhoneNum;
	
    /** 平台的账号信息：用户名 **/ 
	private String plateId;
	
    /** 平台的账号信息：密码 **/ 
	private String platePwd;
	
    /** 自定义平台编码，在代码里面用到  易美YM,国都GD,春霖CL **/ 
	private String platformCode;
	
    /** 下行状态通知发送失败后，由哪个平台发送(自定义平台编码，在代码里面用到，易美YM,国都GD,春霖CL) **/ 
	private String failCode;
	
    /** 发送短信的优先级别1,2,3,4不可以重复 **/ 
	private String priority;
	
    /** 群发时最大支持量 **/ 
	private int maxSendNum;
	
    /** 平台不可可接受的短信类型，入123,345,342默认为空 **/ 
	private String excludeSmsType;
	
    /** 短信余额，加上更新时间 **/ 
	private String balance;
	
    /** 可接受渠道 **/ 
	private String channel;
	
    /** 不可接受渠道 **/ 
	private String excludeChannel;
	

	/**
	 * 构造 
	 */
	public SmsConfigPO() {
	}
	
	public SmsConfigPO( String id,  String name,   String smsType,   String phoneAcceped,   String isUse,   String operator,   Date updateTime,   String balanceNotify,String notifyer,String failnum,String sendPhoneNum,   String plateId,   String platePwd,   String platformCode,   String failCode,   String priority,   int maxSendNum,   String excludeSmsType,   String balance,   String channel,   String excludeChannel ) {
				this.name = name;
				this.smsType = smsType;
				this.phoneAcceped = phoneAcceped;
				this.isUse = isUse;
				this.operator = operator;
				this.updateTime = updateTime;
				this.balanceNotify = balanceNotify;
				this.notifyer = notifyer;
				this.failnum = failnum;
				this.sendPhoneNum = sendPhoneNum;
				this.plateId = plateId;
				this.platePwd = platePwd;
				this.platformCode = platformCode;
				this.failCode = failCode;
				this.priority = priority;
				this.maxSendNum = maxSendNum;
				this.excludeSmsType = excludeSmsType;
				this.balance = balance;
				this.channel = channel;
				this.excludeChannel = excludeChannel;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	public String getPhoneAcceped() {
		return phoneAcceped;
	}

	public void setPhoneAcceped(String phoneAcceped) {
		this.phoneAcceped = phoneAcceped;
	}
	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getBalanceNotify() {
		return balanceNotify;
	}

	public void setBalanceNotify(String balanceNotify) {
		this.balanceNotify = balanceNotify;
	}
	public String getNotifyer() {
		return notifyer;
	}

	public void setNotifyer(String notifyer) {
		this.notifyer = notifyer;
	}
	public String getFailnum() {
		return failnum;
	}

	public void setFailnum(String failnum) {
		this.failnum = failnum;
	}
	public String getSendPhoneNum() {
		return sendPhoneNum;
	}

	public void setSendPhoneNum(String sendPhoneNum) {
		this.sendPhoneNum = sendPhoneNum;
	}
	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}
	public String getPlatePwd() {
		return platePwd;
	}

	public void setPlatePwd(String platePwd) {
		this.platePwd = platePwd;
	}
	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getFailCode() {
		return failCode;
	}

	public void setFailCode(String failCode) {
		this.failCode = failCode;
	}
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getMaxSendNum() {
		return maxSendNum;
	}

	public void setMaxSendNum(int maxSendNum) {
		this.maxSendNum = maxSendNum;
	}
	public String getExcludeSmsType() {
		return excludeSmsType;
	}

	public void setExcludeSmsType(String excludeSmsType) {
		this.excludeSmsType = excludeSmsType;
	}
	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getExcludeChannel() {
		return excludeChannel;
	}

	public void setExcludeChannel(String excludeChannel) {
		this.excludeChannel = excludeChannel;
	}
	@Override
	public int compare(SmsConfigPO o1, SmsConfigPO o2) {
		if(Integer.valueOf(o1.getPriority())>Integer.valueOf(o2.getPriority())){
			return 1;
		}else{
			return -1;
		}
	}


	@Override
	public String toString() {
		return "SmsConfigPO [id=" + id + ", name=" + name + ", smsType="
				+ smsType + ", phoneAcceped=" + phoneAcceped + ", isUse="
				+ isUse + ", operator=" + operator + ", updateTime="
				+ updateTime + ", balanceNotify=" + balanceNotify
				+ ", notifyer=" + notifyer + ", failnum=" + failnum
				+ ", sendPhoneNum=" + sendPhoneNum + ", plateId=" + plateId
				+ ", platePwd=" + platePwd + ", platformCode=" + platformCode
				+ ", failCode=" + failCode + ", priority=" + priority
				+ ", maxSendNum=" + maxSendNum + ", excludeSmsType="
				+ excludeSmsType 
				+ ", balance=" + balance + ", channel=" + channel
				+ ", excludeChannel=" + excludeChannel + "]";
	}
}