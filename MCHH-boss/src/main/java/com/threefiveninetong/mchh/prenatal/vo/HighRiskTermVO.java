/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskTermVO.java  
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
 * @ClassName: HighRiskTermvo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public class HighRiskTermVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String highRiskId;
	
	/** 高危项ID **/ 
	private String termId;
	
    /** 本次检查结果 **/ 
	private String highRisk;
	
    /** 高危值 **/ 
	private String score;
	
    /** 治疗医嘱及矫治方案 **/ 
	private String correct;
	
    /** 0：动态因素，1：固定因素 **/ 
	private String status;
	
    /** 多个使用;号分割 **/ 
	private String correctionTime;
	

	/**
	 * 构造 
	 */
	public HighRiskTermVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHighRiskId() {
		return highRiskId;
	}

	public void setHighRiskId(String highRiskId) {
		this.highRiskId = highRiskId;
	}

	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getHighRisk() {
		return highRisk;
	}

	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
	}
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getCorrectionTime() {
		return correctionTime;
	}

	public void setCorrectionTime(String correctionTime) {
		this.correctionTime = correctionTime;
	}

}