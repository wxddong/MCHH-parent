/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HealthInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: HealthInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
public class HealthInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 婚检表ID **/ 
	private String marriageTaId;
	
    /** 0：无，1：表，2：堂，3：其他 **/ 
	private String kinship;
	
    /** 血缘关系为其他（0）时填写 **/ 
	private String otherRelationships;
	
    /** 0：无
            1：心脏病
            2：肺结核
            3：肝脏病
            4：泌尿生殖系统疾病
            5：糖尿病
            6：高血压
            7：精神病
            8：性病
            9：癫痫
            10：甲亢
            11：先天疾患
            12：其他
            多种疾病使用;号分隔
             **/ 
	private String medicalHistory;
	
    /** 既往病史为其他（12）时填写 **/ 
	private String medicalOther;
	
    /** 0：无，1：有 **/ 
	private String surgeryHistory;
	
    /** 手术史为有（1）时填写 **/ 
	private String operation;
	
    /** 手术史其他 **/ 
	private String operationOther;
	
    /** 0：无，1：有 **/ 
	private String hpi;
	
    /** 现病史为有（1）时必填 **/ 
	private String caseInformation;
	
    /** 月经初潮年龄，女性填写 **/ 
	private String menarcheAge;
	
    /** 经期，女性填写 **/ 
	private String menstrualPeriod;
	
    /** 周期，女性填写 **/ 
	private String cycle;
	
    /** 0：多，1：中，2：少，女性填写 **/ 
	private String amount;
	
    /** 0：无，1：有，女性填写 **/ 
	private String dysmenorrhea;
	
    /** 末次月经，女性填写 **/ 
	private String lastMenstrualPeriod;
	
    /** 0：备孕，1：正常，2：现孕，3：已分娩，女性填写 **/ 
	private String whetherPregnant;
	
    /** 0：无，1：有 **/ 
	private String marriedHistory;
	
    /** 既往婚史有（1）时才填,0：丧偶，1：离异 **/ 
	private String marriageStatus;
	
    /** 足月，女性填写 **/ 
	private String amontNumber;
	
    /** 足月为其他时才填，女性填写 **/ 
	private String amontNumberOther;
	
    /** 早产，女性填写 **/ 
	private String pretermDeliveryNum;
	
    /** 早产为其他时才填，女性填写 **/ 
	private String pretermDeliveryOther;
	
    /** 流产，女性填写 **/ 
	private String abortionNumber;
	
    /** 流产为其他时才填，女性填写 **/ 
	private String abortionOther;
	
    /** 子女 **/ 
	private String childrenNumber;
	
    /** 子女为其他时才填 **/ 
	private String childrenOther;
	
    /** 0：无
            1：盲
            2：聋
            3：哑
            4：精神病
            5：先天性智力低下
            6：先天性心脏病
            7：血友病
            8：糖尿病
            9：其它
            多种使用;号分隔 **/ 
	private String geneticHistory;
	
	/**遗传家族史备注，遗传家族史为其他时填写**/
	private String geneticHistoryRemark;
	
    /** 遗传患者于本人关系 **/ 
	private String patientRelationship;
	
    /** 0：无，1：有 **/ 
	private String relativesMating;
	
    /** 家族近亲婚配有（1）时才填 **/ 
	private String relativesMatingRemark;
	

	/**
	 * 构造 
	 */
	public HealthInfoPO() {
	}
	
	public HealthInfoPO( String id,  String marriageTaId, String kinship, String otherRelationships, String medicalHistory, String medicalOther, String surgeryHistory, String operation, String operationOther, String hpi, String caseInformation, String menarcheAge, String menstrualPeriod, String cycle, String amount, String dysmenorrhea, String lastMenstrualPeriod, String whetherPregnant, String marriedHistory, String marriageStatus, String amontNumber, String amontNumberOther, String pretermDeliveryNum, String pretermDeliveryOther, String abortionNumber, String abortionOther, String childrenNumber, String childrenOther, String geneticHistory, String geneticHistoryRemark,String patientRelationship, String relativesMating, String relativesMatingRemark) {
				this.marriageTaId = marriageTaId;
				this.kinship = kinship;
				this.otherRelationships = otherRelationships;
				this.medicalHistory = medicalHistory;
				this.medicalOther = medicalOther;
				this.surgeryHistory = surgeryHistory;
				this.operation = operation;
				this.operationOther = operationOther;
				this.hpi = hpi;
				this.caseInformation = caseInformation;
				this.menarcheAge = menarcheAge;
				this.menstrualPeriod = menstrualPeriod;
				this.cycle = cycle;
				this.amount = amount;
				this.dysmenorrhea = dysmenorrhea;
				this.lastMenstrualPeriod = lastMenstrualPeriod;
				this.whetherPregnant = whetherPregnant;
				this.marriedHistory = marriedHistory;
				this.marriageStatus = marriageStatus;
				this.amontNumber = amontNumber;
				this.amontNumberOther = amontNumberOther;
				this.pretermDeliveryNum = pretermDeliveryNum;
				this.pretermDeliveryOther = pretermDeliveryOther;
				this.abortionNumber = abortionNumber;
				this.abortionOther = abortionOther;
				this.childrenNumber = childrenNumber;
				this.childrenOther = childrenOther;
				this.geneticHistory = geneticHistory;
				this.geneticHistoryRemark=geneticHistoryRemark;
				this.patientRelationship = patientRelationship;
				this.relativesMating = relativesMating;
				this.relativesMatingRemark = relativesMatingRemark;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarriageTaId() {
		return marriageTaId;
	}

	public void setMarriageTaId(String marriageTaId) {
		this.marriageTaId = marriageTaId;
	}
	public String getKinship() {
		return kinship;
	}

	public void setKinship(String kinship) {
		this.kinship = kinship;
	}
	public String getOtherRelationships() {
		return otherRelationships;
	}

	public void setOtherRelationships(String otherRelationships) {
		this.otherRelationships = otherRelationships;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public String getMedicalOther() {
		return medicalOther;
	}

	public void setMedicalOther(String medicalOther) {
		this.medicalOther = medicalOther;
	}
	public String getSurgeryHistory() {
		return surgeryHistory;
	}

	public void setSurgeryHistory(String surgeryHistory) {
		this.surgeryHistory = surgeryHistory;
	}
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperationOther() {
		return operationOther;
	}

	public void setOperationOther(String operationOther) {
		this.operationOther = operationOther;
	}
	public String getHpi() {
		return hpi;
	}

	public void setHpi(String hpi) {
		this.hpi = hpi;
	}
	public String getCaseInformation() {
		return caseInformation;
	}

	public void setCaseInformation(String caseInformation) {
		this.caseInformation = caseInformation;
	}
	public String getMenarcheAge() {
		return menarcheAge;
	}

	public void setMenarcheAge(String menarcheAge) {
		this.menarcheAge = menarcheAge;
	}
	public String getMenstrualPeriod() {
		return menstrualPeriod;
	}

	public void setMenstrualPeriod(String menstrualPeriod) {
		this.menstrualPeriod = menstrualPeriod;
	}
	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDysmenorrhea() {
		return dysmenorrhea;
	}

	public void setDysmenorrhea(String dysmenorrhea) {
		this.dysmenorrhea = dysmenorrhea;
	}
	public String getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}

	public void setLastMenstrualPeriod(String lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}
	public String getWhetherPregnant() {
		return whetherPregnant;
	}

	public void setWhetherPregnant(String whetherPregnant) {
		this.whetherPregnant = whetherPregnant;
	}
	public String getMarriedHistory() {
		return marriedHistory;
	}

	public void setMarriedHistory(String marriedHistory) {
		this.marriedHistory = marriedHistory;
	}
	public String getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public String getAmontNumber() {
		return amontNumber;
	}

	public void setAmontNumber(String amontNumber) {
		this.amontNumber = amontNumber;
	}
	public String getAmontNumberOther() {
		return amontNumberOther;
	}

	public void setAmontNumberOther(String amontNumberOther) {
		this.amontNumberOther = amontNumberOther;
	}
	public String getPretermDeliveryNum() {
		return pretermDeliveryNum;
	}

	public void setPretermDeliveryNum(String pretermDeliveryNum) {
		this.pretermDeliveryNum = pretermDeliveryNum;
	}
	public String getPretermDeliveryOther() {
		return pretermDeliveryOther;
	}

	public void setPretermDeliveryOther(String pretermDeliveryOther) {
		this.pretermDeliveryOther = pretermDeliveryOther;
	}
	public String getAbortionNumber() {
		return abortionNumber;
	}

	public void setAbortionNumber(String abortionNumber) {
		this.abortionNumber = abortionNumber;
	}
	public String getAbortionOther() {
		return abortionOther;
	}

	public void setAbortionOther(String abortionOther) {
		this.abortionOther = abortionOther;
	}
	public String getChildrenNumber() {
		return childrenNumber;
	}

	public void setChildrenNumber(String childrenNumber) {
		this.childrenNumber = childrenNumber;
	}
	public String getChildrenOther() {
		return childrenOther;
	}

	public void setChildrenOther(String childrenOther) {
		this.childrenOther = childrenOther;
	}
	public String getGeneticHistory() {
		return geneticHistory;
	}

	public void setGeneticHistory(String geneticHistory) {
		this.geneticHistory = geneticHistory;
	}
	public String getPatientRelationship() {
		return patientRelationship;
	}

	public void setPatientRelationship(String patientRelationship) {
		this.patientRelationship = patientRelationship;
	}
	public String getRelativesMating() {
		return relativesMating;
	}

	public void setRelativesMating(String relativesMating) {
		this.relativesMating = relativesMating;
	}
	public String getRelativesMatingRemark() {
		return relativesMatingRemark;
	}

	public void setRelativesMatingRemark(String relativesMatingRemark) {
		this.relativesMatingRemark = relativesMatingRemark;
	}

	public String getGeneticHistoryRemark() {
		return geneticHistoryRemark;
	}

	public void setGeneticHistoryRemark(String geneticHistoryRemark) {
		this.geneticHistoryRemark = geneticHistoryRemark;
	}

}