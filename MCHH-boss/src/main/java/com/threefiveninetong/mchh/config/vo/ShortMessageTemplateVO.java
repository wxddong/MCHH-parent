/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ShortMessageTemplateVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-09-14 17:57:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ShortMessageTemplatevo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-09-14 17:57:09 
 */
public class ShortMessageTemplateVO {

	/** 主键ID **/ 
	private String id;
	
    /** 短信类型，0：预约检查，1：高危检查 **/ 
	private String messType;
	
    /** 0：孕12周以前
            1：孕13-16周
            2：孕17-20周
            3：孕21-24周
            4：孕25-28周
            5：孕29-30周
            6：孕31-32周
            7：孕33-34周
            8：孕35-36周
            9：孕37周
            10：孕38周
            11：孕39周
            12：心脏病
             **/ 
	private String sendCrowd;
	
    /** 短信内容 **/ 
	private String content;
	
    /** 0：提前3天 **/ 
	private String sendTime;
	
    /** 0：可用，1：不可用 **/ 
	private String useSign;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public ShortMessageTemplateVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessType() {
		return messType;
	}

	public void setMessType(String messType) {
		this.messType = messType;
	}
	public String getSendCrowd() {
		return sendCrowd;
	}

	public void setSendCrowd(String sendCrowd) {
		this.sendCrowd = sendCrowd;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getUseSign() {
		return useSign;
	}

	public void setUseSign(String useSign) {
		this.useSign = useSign;
	}
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}