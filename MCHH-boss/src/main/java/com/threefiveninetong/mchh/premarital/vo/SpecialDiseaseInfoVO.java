/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SpecialDiseaseInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-10-20 17:23:54 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: SpecialDiseaseInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-10-20 17:23:54 
 */
public class SpecialDiseaseInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 婚检表ID **/ 
	private String resultId;
	
    /** 多个使用;号分隔 **/ 
	private String infectiousDis;
	
    /** 多个使用;号分隔 **/ 
	private String geneticDis;
	
    /** 多个使用;号分隔 **/ 
	private String mentalDis;
	
    /** 多个使用;号分隔 **/ 
	private String reproductiveDis;
	
    /** 多个使用;号分隔 **/ 
	private String medicalDis;
	

	/**
	 * 构造 
	 */
	public SpecialDiseaseInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public String getInfectiousDis() {
		return infectiousDis;
	}

	public void setInfectiousDis(String infectiousDis) {
		this.infectiousDis = infectiousDis;
	}
	public String getGeneticDis() {
		return geneticDis;
	}

	public void setGeneticDis(String geneticDis) {
		this.geneticDis = geneticDis;
	}
	public String getMentalDis() {
		return mentalDis;
	}

	public void setMentalDis(String mentalDis) {
		this.mentalDis = mentalDis;
	}
	public String getReproductiveDis() {
		return reproductiveDis;
	}

	public void setReproductiveDis(String reproductiveDis) {
		this.reproductiveDis = reproductiveDis;
	}
	public String getMedicalDis() {
		return medicalDis;
	}

	public void setMedicalDis(String medicalDis) {
		this.medicalDis = medicalDis;
	}

}