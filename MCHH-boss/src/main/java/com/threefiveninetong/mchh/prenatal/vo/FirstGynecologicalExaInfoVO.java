/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstGynecologicalExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: FirstGynecologicalExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public class FirstGynecologicalExaInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String examinationId;
	
    /** 0：未见异常
            1：异常 **/ 
	private String outerVulva;
	
    /** 外阴为异常（1）时填写 **/ 
	private String outerVulvaRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String vagina;
	
    /** 阴道为异常（1）时填写 **/ 
	private String vaginaRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String uterus;
	
    /** 子宫为异常（1）时填写 **/ 
	private String uterusRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String uterineNeck;
	
    /** 宫颈为异常（1）时填写 **/ 
	private String uterineNeckRemark;
	
    /** 0：未见异常
            1：异常 **/ 
	private String appendix;
	
    /** 附件为异常（1）时填写 **/ 
	private String appendixRemark;
	

	/**
	 * 构造 
	 */
	public FirstGynecologicalExaInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}
	public String getOuterVulva() {
		return outerVulva;
	}

	public void setOuterVulva(String outerVulva) {
		this.outerVulva = outerVulva;
	}
	public String getOuterVulvaRemark() {
		return outerVulvaRemark;
	}

	public void setOuterVulvaRemark(String outerVulvaRemark) {
		this.outerVulvaRemark = outerVulvaRemark;
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
	public String getUterus() {
		return uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}
	public String getUterusRemark() {
		return uterusRemark;
	}

	public void setUterusRemark(String uterusRemark) {
		this.uterusRemark = uterusRemark;
	}
	public String getUterineNeck() {
		return uterineNeck;
	}

	public void setUterineNeck(String uterineNeck) {
		this.uterineNeck = uterineNeck;
	}
	public String getUterineNeckRemark() {
		return uterineNeckRemark;
	}

	public void setUterineNeckRemark(String uterineNeckRemark) {
		this.uterineNeckRemark = uterineNeckRemark;
	}
	public String getAppendix() {
		return appendix;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
	public String getAppendixRemark() {
		return appendixRemark;
	}

	public void setAppendixRemark(String appendixRemark) {
		this.appendixRemark = appendixRemark;
	}

}