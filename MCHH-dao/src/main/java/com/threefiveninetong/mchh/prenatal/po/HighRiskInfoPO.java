/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskInfoPO.java
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
 * @ClassName: HighRiskInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public class HighRiskInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
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
	
	/** 诊断结果 **/ 
	private String diaResult;
	
    /** 治疗医嘱及矫治方案 **/ 
	private String scheme;
	

	/**
	 * 构造 
	 */
	public HighRiskInfoPO() {
	}
	
	public HighRiskInfoPO( String id,  String examinationId, String lapseTo, String score, String result,String diaResult, String scheme) {
				this.examinationId = examinationId;
				this.lapseTo = lapseTo;
				this.score = score;
				this.result = result;
				this.diaResult = diaResult;
				this.scheme = scheme;
						this.id = id;
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