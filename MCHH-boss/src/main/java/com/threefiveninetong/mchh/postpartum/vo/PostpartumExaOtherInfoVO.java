/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaOtherInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 14:39:17 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: PostpartumExaOtherInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 14:39:17 
 */
public class PostpartumExaOtherInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String posChecklistId;
	
    /** 0：正常，1：异常 **/ 
	private String vulva;
	
    /** 外阴为异常（1）时填写 **/ 
	private String vulvaRemark;
	
    /** 0：正常，1：异常 **/ 
	private String vagina;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String vaginaRemark;
	
    /** 0：正常，1：异常 **/ 
	private String cervical;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String cervicalRemark;
	
    /** 其他信息 **/ 
	private String other;
	

	/**
	 * 构造 
	 */
	public PostpartumExaOtherInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosChecklistId() {
		return posChecklistId;
	}

	public void setPosChecklistId(String posChecklistId) {
		this.posChecklistId = posChecklistId;
	}
	public String getVulva() {
		return vulva;
	}

	public void setVulva(String vulva) {
		this.vulva = vulva;
	}
	public String getVulvaRemark() {
		return vulvaRemark;
	}

	public void setVulvaRemark(String vulvaRemark) {
		this.vulvaRemark = vulvaRemark;
	}
	public String getVagina() {
		return vagina;
	}

	public void setVagina(String vagina) {
		this.vagina = vagina;
	}
	public String getVaginaRemark() {
		return vaginaRemark;
	}

	public void setVaginaRemark(String vaginaRemark) {
		this.vaginaRemark = vaginaRemark;
	}
	public String getCervical() {
		return cervical;
	}

	public void setCervical(String cervical) {
		this.cervical = cervical;
	}
	public String getCervicalRemark() {
		return cervicalRemark;
	}

	public void setCervicalRemark(String cervicalRemark) {
		this.cervicalRemark = cervicalRemark;
	}
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}