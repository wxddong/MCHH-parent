/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskTermVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:05 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ChildrenHighRiskTermvo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
public class ChildrenHighRiskTermVO {

	/** 主键ID **/ 
	private String id;
	
    /** 高危专案管理表ID **/ 
	private String highRiskId;
	
    /** 高危项ID **/ 
	private String termId;
	
    /** 高危项 **/ 
	private String highRisk;
	
    /** 高危值 **/ 
	private String score;
	
    /** 0：未矫正，1：已矫正 **/ 
	private String correct;
	
    /** 高危所属类别 **/ 
	private String category;
	
    /** 多个使用;号分割 **/ 
	private Date correctionTime;
	

	/**
	 * 构造 
	 */
	public ChildrenHighRiskTermVO() {
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
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCorrectionTime() {
		return correctionTime;
	}

	public void setCorrectionTime(Date correctionTime) {
		this.correctionTime = correctionTime;
	}

}