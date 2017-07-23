/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: HighRiskInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public class HighRiskInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String examinationId;
	
    /** 0：继续监护，1：正常随访，2：结束分娩 **/ 
	private String lapseTo;
	
	/** 高危分值 **/ 
	private String score;
	
    /** 本次检查结果 **/ 
	private String result;
	
	/** 本次检查结果 **/ 
	private String diaResult;
	
    /** 治疗医嘱及矫治方案 **/ 
	private String scheme;
	

	/**
	 * 构造 
	 */
	public HighRiskInfoVO() {
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
	public String getLapseTo() {
		return lapseTo;
	}

	public void setLapseTo(String lapseTo) {
		this.lapseTo = lapseTo;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getDiaResult() {
		return diaResult;
	}

	public void setDiaResult(String diaResult) {
		this.diaResult = diaResult;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

}