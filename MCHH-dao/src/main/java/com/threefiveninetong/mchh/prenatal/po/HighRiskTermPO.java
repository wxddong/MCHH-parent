/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskTermPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: HighRiskTermPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public class HighRiskTermPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
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
	private Date correctionTime;
	

	/**
	 * 构造 
	 */
	public HighRiskTermPO() {
	}
	
	public HighRiskTermPO( String id,  String highRiskId,String termId, String highRisk, String score, String correct, String status, Date correctionTime) {
				this.highRiskId = highRiskId;
				this.termId=termId;
				this.highRisk = highRisk;
				this.score = score;
				this.correct = correct;
				this.status = status;
				this.correctionTime = correctionTime;
						this.id = id;
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

	public Date getCorrectionTime() {
		return correctionTime;
	}

	public void setCorrectionTime(Date correctionTime) {
		this.correctionTime = correctionTime;
	}
	
}