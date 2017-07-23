package com.threefiveninetong.mchh.postpartum.dto;

import java.util.Date;

public class PostHistoryCheckVO {
	
	//检查id
	private String checkId;
	
	//检查日期
	private Date checkDate;
	
	//产检单位
	private String checkHospital;
	
	//随访医生
	private String checkDoctor;
	
	//类型(0为出院3-7天检查，1为产后42天健康检查)
	private String type;
	
	//结果
	private String resultSign;
	private String result;
	
	
	//指导意见
	private String guidance;
	
	//外阴
	private String vulavaSign;
	private String vulava;
	
	//阴道
	private String vaginaSign;
	private String vagina;
	
	//宫颈
	private String cervicalSign;
	private String cervical;
	
	//体温
	private String bodyTemperature;
	
	//血压（由血压低值和血压高值拼接而成）
	private String blood;
	
	//一般健康状况
	private String health;
	
	//一般心理状况
	private String psychological;
	
	//乳房
	private String breastSign;
	private String breast;
	
	//子宫
	private String uterusSign;
	private String uterus;
	
	//恶露
	private String lochiaSign;
	private String lochia;
	
	//伤口
	private String woundSign;
	private String wound;
	
	//转诊标号（0为——，1为转诊）
	private String referralSign;
	private String referral;
	
	//下次随访日期
	private Date nextFollowingDate;
	

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResultSign() {
		return resultSign;
	}

	public void setResultSign(String resultSign) {
		this.resultSign = resultSign;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGuidance() {
		return guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

	public String getVulavaSign() {
		return vulavaSign;
	}

	public void setVulavaSign(String vulavaSign) {
		this.vulavaSign = vulavaSign;
	}

	public String getVulava() {
		return vulava;
	}

	public void setVulava(String vulava) {
		this.vulava = vulava;
	}

	public String getVaginaSign() {
		return vaginaSign;
	}

	public void setVaginaSign(String vaginaSign) {
		this.vaginaSign = vaginaSign;
	}

	public String getVagina() {
		return vagina;
	}

	public void setVagina(String vagina) {
		this.vagina = vagina;
	}

	public String getCervicalSign() {
		return cervicalSign;
	}

	public void setCervicalSign(String cervicalSign) {
		this.cervicalSign = cervicalSign;
	}

	public String getCervical() {
		return cervical;
	}

	public void setCervical(String cervical) {
		this.cervical = cervical;
	}

	public String getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getPsychological() {
		return psychological;
	}

	public void setPsychological(String psychological) {
		this.psychological = psychological;
	}

	public String getBreastSign() {
		return breastSign;
	}

	public void setBreastSign(String breastSign) {
		this.breastSign = breastSign;
	}

	public String getBreast() {
		return breast;
	}

	public void setBreast(String breast) {
		this.breast = breast;
	}

	public String getUterusSign() {
		return uterusSign;
	}

	public void setUterusSign(String uterusSign) {
		this.uterusSign = uterusSign;
	}

	public String getUterus() {
		return uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}

	public String getLochiaSign() {
		return lochiaSign;
	}

	public void setLochiaSign(String lochiaSign) {
		this.lochiaSign = lochiaSign;
	}

	public String getLochia() {
		return lochia;
	}

	public void setLochia(String lochia) {
		this.lochia = lochia;
	}

	public String getWoundSign() {
		return woundSign;
	}

	public void setWoundSign(String woundSign) {
		this.woundSign = woundSign;
	}

	public String getWound() {
		return wound;
	}

	public void setWound(String wound) {
		this.wound = wound;
	}

	public String getReferralSign() {
		return referralSign;
	}

	public void setReferralSign(String referralSign) {
		this.referralSign = referralSign;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	public Date getNextFollowingDate() {
		return nextFollowingDate;
	}

	public void setNextFollowingDate(Date nextFollowingDate) {
		this.nextFollowingDate = nextFollowingDate;
	}

	public String getCheckHospital() {
		return checkHospital;
	}

	public void setCheckHospital(String checkHospital) {
		this.checkHospital = checkHospital;
	}

	public String getCheckDoctor() {
		return checkDoctor;
	}

	public void setCheckDoctor(String checkDoctor) {
		this.checkDoctor = checkDoctor;
	}
	
	
	
}
