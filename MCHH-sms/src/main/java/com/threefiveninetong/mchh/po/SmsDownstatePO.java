/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsDownstatePO.java
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
 * @ClassName: SmsDownstatePO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:50 
 */
public class SmsDownstatePO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 下行信息ID **/ 
	private String masdownmsgid;
	
    /** 短信平台编码 **/ 
	private String platformCode;
	
    /** 下行状态，0成功，其他失败 **/ 
	private String downstate;
	
    /** 发送报告显示发送失败时是否重新发送 0：未重新发送，1：已重新发送 **/ 
	private String isresend;
	
    /** 下行信息的接受时间 **/ 
	private Date receivetime;
	
    /** 手机号码 **/ 
	private String phone;
	
    /** 短信内容 **/ 
	private String content;

	/** 创建时间(插入表中时间) **/ 
	private Date createtime;
	/**
	 * 构造 
	 */
	public SmsDownstatePO() {
	}
	
	public SmsDownstatePO( String id,  String masdownmsgid,   String platformCode,   String downstate,   String isresend,   Date receivetime,   String phone,   String content,Date createtime ) {
				this.masdownmsgid = masdownmsgid;
				this.platformCode = platformCode;
				this.downstate = downstate;
				this.isresend = isresend;
				this.receivetime = receivetime;
				this.phone = phone;
				this.content = content;
						this.id = id;
						this.createtime=createtime;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMasdownmsgid() {
		return masdownmsgid;
	}

	public void setMasdownmsgid(String masdownmsgid) {
		this.masdownmsgid = masdownmsgid;
	}
	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getDownstate() {
		return downstate;
	}

	public void setDownstate(String downstate) {
		this.downstate = downstate;
	}
	public String getIsresend() {
		return isresend;
	}

	public void setIsresend(String isresend) {
		this.isresend = isresend;
	}
	public Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	
}