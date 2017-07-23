/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstMotherhoodInfoVO.java  
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
 * @ClassName: FirstMotherhoodInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public class FirstMotherhoodInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String examinationId;
	
    /** 孕周周数 **/ 
	private String pregnancyWeeks;
	
    /** 孕周天数 **/ 
	private String pregnancyDays;
	
	/** 末次月经 **/ 
	private Date lastMenses;
	
	/**预产期**/
	private Date predictDate;
	
    /** 孕次 **/ 
	private String pregnancyNum;
	
    /** 产次 **/ 
	private String bearNum;
	
    /** 阴道分娩次数 **/ 
	private String eutociaNum;
	
    /** 剖宫产次数 **/ 
	private String cesareanNum;
	
    /** 早产次数 **/ 
	private String prebearNum;
	
    /** 自然流产次数 **/ 
	private String naturalAbortionNum;
	
    /** 人流次数 **/ 
	private String inducedAbortionNum;
	
    /** 药流次数 **/ 
	private String drugAbortionNum;
	
    /** 宫外孕次数 **/ 
	private String exfetationNum;
	
    /** 中孕引产次数 **/ 
	private String inducelabourNum;
	
    /** 流产次数 **/ 
	private String abortionNum;
	
    /** 死胎次数 **/ 
	private String deadfetusNum;
	
    /** 死产次数 **/ 
	private String stillbirthNum;
	
    /** 新生儿死亡次数 **/ 
	private String newbornDieNum;
	
    /** 出生缺陷儿次数 **/ 
	private String defectNum;
	
    /** 产后出血次数 **/ 
	private String bleedingNum;
	
    /** 双胎次数 **/ 
	private String twinsNum;
	
    /** 畸形次数 **/ 
	private String deformityNum;
	
    /** 0：无
            1：心脏病
            2：肾脏疾病
            3：肝脏疾病
            4：高血压
            5：贫血
            6：糖尿病
            7：其它
            多个使用;号分隔 **/ 
	private String history;
	
    /** 既往史为其他（7）时填写 **/ 
	private String historyOthers;
	
    /** 0：无
            1：遗传性疾病史
            2：精神疾病史
            3：其它
            多个使用;号分隔 **/ 
	private String famHistory;
	
	 /** 家族史有遗传性疾病史（1）时填写 **/ 
	private String heredityRelation;
	
	 /** 家族史有精神疾病史（2）时填写 **/ 
	private String mentalRelation;
	
    /** 家族史为其他（3）时填写 **/ 
	private String famHistoryOthers;
	
    /** 0：无
            1：吸烟
            2：饮酒
            3：服用药物
            4：接触有毒有害物质
            5：接触放射线
            6：其它
            多个使用;号分隔 **/ 
	private String perHistory;
	
    /** 个人史为其他（6）时填写 **/ 
	private String perHistoryOthers;
	
    /** 0：无，1：有 **/ 
	private String operation;
	
    /** 妇科手术史为有（1）时填写 **/ 
	private String operationRemark;
	
    /** 0：无，1：有 **/ 
	private String allergy;
	
    /** 药物过敏史为有（1）时填写 **/ 
	private String allergyRemark;
	

	/**
	 * 构造 
	 */
	public FirstMotherhoodInfoVO() {
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
	public String getPregnancyWeeks() {
		return pregnancyWeeks;
	}

	public void setPregnancyWeeks(String pregnancyWeeks) {
		this.pregnancyWeeks = pregnancyWeeks;
	}
	public String getPregnancyDays() {
		return pregnancyDays;
	}

	public void setPregnancyDays(String pregnancyDays) {
		this.pregnancyDays = pregnancyDays;
	}
	public Date getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(Date lastMenses) {
		this.lastMenses = lastMenses;
	}
	
	public Date getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}

	public String getPregnancyNum() {
		return pregnancyNum;
	}

	public void setPregnancyNum(String pregnancyNum) {
		this.pregnancyNum = pregnancyNum;
	}
	public String getBearNum() {
		return bearNum;
	}

	public void setBearNum(String bearNum) {
		this.bearNum = bearNum;
	}
	public String getEutociaNum() {
		return eutociaNum;
	}

	public void setEutociaNum(String eutociaNum) {
		this.eutociaNum = eutociaNum;
	}
	public String getCesareanNum() {
		return cesareanNum;
	}

	public void setCesareanNum(String cesareanNum) {
		this.cesareanNum = cesareanNum;
	}
	public String getPrebearNum() {
		return prebearNum;
	}

	public void setPrebearNum(String prebearNum) {
		this.prebearNum = prebearNum;
	}
	public String getNaturalAbortionNum() {
		return naturalAbortionNum;
	}

	public void setNaturalAbortionNum(String naturalAbortionNum) {
		this.naturalAbortionNum = naturalAbortionNum;
	}
	public String getInducedAbortionNum() {
		return inducedAbortionNum;
	}

	public void setInducedAbortionNum(String inducedAbortionNum) {
		this.inducedAbortionNum = inducedAbortionNum;
	}
	public String getDrugAbortionNum() {
		return drugAbortionNum;
	}

	public void setDrugAbortionNum(String drugAbortionNum) {
		this.drugAbortionNum = drugAbortionNum;
	}
	public String getExfetationNum() {
		return exfetationNum;
	}

	public void setExfetationNum(String exfetationNum) {
		this.exfetationNum = exfetationNum;
	}
	public String getInducelabourNum() {
		return inducelabourNum;
	}

	public void setInducelabourNum(String inducelabourNum) {
		this.inducelabourNum = inducelabourNum;
	}
	public String getAbortionNum() {
		return abortionNum;
	}

	public void setAbortionNum(String abortionNum) {
		this.abortionNum = abortionNum;
	}
	public String getDeadfetusNum() {
		return deadfetusNum;
	}

	public void setDeadfetusNum(String deadfetusNum) {
		this.deadfetusNum = deadfetusNum;
	}
	public String getStillbirthNum() {
		return stillbirthNum;
	}

	public void setStillbirthNum(String stillbirthNum) {
		this.stillbirthNum = stillbirthNum;
	}
	public String getNewbornDieNum() {
		return newbornDieNum;
	}

	public void setNewbornDieNum(String newbornDieNum) {
		this.newbornDieNum = newbornDieNum;
	}
	public String getDefectNum() {
		return defectNum;
	}

	public void setDefectNum(String defectNum) {
		this.defectNum = defectNum;
	}
	public String getBleedingNum() {
		return bleedingNum;
	}

	public void setBleedingNum(String bleedingNum) {
		this.bleedingNum = bleedingNum;
	}
	public String getTwinsNum() {
		return twinsNum;
	}

	public void setTwinsNum(String twinsNum) {
		this.twinsNum = twinsNum;
	}
	public String getDeformityNum() {
		return deformityNum;
	}

	public void setDeformityNum(String deformityNum) {
		this.deformityNum = deformityNum;
	}
	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	public String getHistoryOthers() {
		return historyOthers;
	}

	public void setHistoryOthers(String historyOthers) {
		this.historyOthers = historyOthers;
	}
	public String getFamHistory() {
		return famHistory;
	}

	public void setFamHistory(String famHistory) {
		this.famHistory = famHistory;
	}
	
	public String getHeredityRelation() {
		return heredityRelation;
	}

	public void setHeredityRelation(String heredityRelation) {
		this.heredityRelation = heredityRelation;
	}

	public String getMentalRelation() {
		return mentalRelation;
	}

	public void setMentalRelation(String mentalRelation) {
		this.mentalRelation = mentalRelation;
	}

	public String getFamHistoryOthers() {
		return famHistoryOthers;
	}

	public void setFamHistoryOthers(String famHistoryOthers) {
		this.famHistoryOthers = famHistoryOthers;
	}
	public String getPerHistory() {
		return perHistory;
	}

	public void setPerHistory(String perHistory) {
		this.perHistory = perHistory;
	}
	public String getPerHistoryOthers() {
		return perHistoryOthers;
	}

	public void setPerHistoryOthers(String perHistoryOthers) {
		this.perHistoryOthers = perHistoryOthers;
	}
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperationRemark() {
		return operationRemark;
	}

	public void setOperationRemark(String operationRemark) {
		this.operationRemark = operationRemark;
	}
	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public String getAllergyRemark() {
		return allergyRemark;
	}

	public void setAllergyRemark(String allergyRemark) {
		this.allergyRemark = allergyRemark;
	}

}