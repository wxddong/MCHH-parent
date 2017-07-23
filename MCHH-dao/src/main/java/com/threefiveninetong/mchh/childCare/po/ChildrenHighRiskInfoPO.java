/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:05 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: ChildrenHighRiskInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
public class ChildrenHighRiskInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 健康检查表ID **/ 
	private String healthExaId;
	
    /** 0：继续监护，1：正常随访，2：儿童死亡 **/ 
	private String lapseTo;
	
    /** 高危总分值 **/ 
	private String score;
	
    /** 本次检查结果 **/ 
	private String result;
	
    /** 诊断结果 **/ 
	private String diaResult;
	
    /** 监护及指导意见 **/ 
	private String guidance;
	

	/**
	 * 构造 
	 */
	public ChildrenHighRiskInfoPO() {
	}
	
	public ChildrenHighRiskInfoPO( String id,  String healthExaId, String lapseTo, String score, String result, String diaResult, String guidance) {
				this.healthExaId = healthExaId;
				this.lapseTo = lapseTo;
				this.score = score;
				this.result = result;
				this.diaResult = diaResult;
				this.guidance = guidance;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHealthExaId() {
		return healthExaId;
	}

	public void setHealthExaId(String healthExaId) {
		this.healthExaId = healthExaId;
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
	public String getGuidance() {
		return guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

}