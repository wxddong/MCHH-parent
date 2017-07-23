/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: InspectionResultPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:02 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: InspectionResultPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:02 
 */
public class InspectionResultPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 婚检表ID **/ 
	private String marriageTaId;
	
    /** 0：未见异常，1：异常情况 **/ 
	private String checkResult;
	
    /** 多个使用;号分隔 **/ 
	private String excTerm;
	
    /** 其他异常 **/ 
	private String otherExc;
	
    /** 疾病诊断 **/ 
	private String diseaseDiagnosis;
	
    /** 0：未发现医学上不宜结婚的情形
            1：建议暂缓结婚
            2：建议不宜生育
            3：建议不宜结婚
            4：建议采取医学措施，尊重受检者意愿 **/ 
	private String medicalAdvice;
	
    /** 婚前卫生咨询 **/ 
	private String maritalConsultation;
	
    /** 0：接受指导意见
            1：不接受指导意见，知情后选择结婚，后果自己承担 **/ 
	private String consultativeResults;
	
    /** 出具《婚前医学检查证明》日期 **/ 
	private Date issuedByDate;
	

	/**
	 * 构造 
	 */
	public InspectionResultPO() {
	}
	
	public InspectionResultPO( String id,  String marriageTaId, String checkResult, String excTerm, String otherExc, String diseaseDiagnosis, String medicalAdvice, String maritalConsultation, String consultativeResults, Date issuedByDate) {
				this.marriageTaId = marriageTaId;
				this.checkResult = checkResult;
				this.excTerm = excTerm;
				this.otherExc = otherExc;
				this.diseaseDiagnosis = diseaseDiagnosis;
				this.medicalAdvice = medicalAdvice;
				this.maritalConsultation = maritalConsultation;
				this.consultativeResults = consultativeResults;
				this.issuedByDate = issuedByDate;
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
	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getExcTerm() {
		return excTerm;
	}

	public void setExcTerm(String excTerm) {
		this.excTerm = excTerm;
	}
	public String getOtherExc() {
		return otherExc;
	}

	public void setOtherExc(String otherExc) {
		this.otherExc = otherExc;
	}
	public String getDiseaseDiagnosis() {
		return diseaseDiagnosis;
	}

	public void setDiseaseDiagnosis(String diseaseDiagnosis) {
		this.diseaseDiagnosis = diseaseDiagnosis;
	}
	public String getMedicalAdvice() {
		return medicalAdvice;
	}

	public void setMedicalAdvice(String medicalAdvice) {
		this.medicalAdvice = medicalAdvice;
	}
	public String getMaritalConsultation() {
		return maritalConsultation;
	}

	public void setMaritalConsultation(String maritalConsultation) {
		this.maritalConsultation = maritalConsultation;
	}
	public String getConsultativeResults() {
		return consultativeResults;
	}

	public void setConsultativeResults(String consultativeResults) {
		this.consultativeResults = consultativeResults;
	}
	public Date getIssuedByDate() {
		return issuedByDate;
	}

	public void setIssuedByDate(Date issuedByDate) {
		this.issuedByDate = issuedByDate;
	}

}