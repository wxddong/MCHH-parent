package com.threefiveninetong.mchh.postpartum.dto;

import java.util.Date;

public class HistoryCheckVO {
	//检查id
	private String checkId;
	//检查类型  0为产前检查  1为产后检查
	private String type;
	//检查日期
	private Date checkDate;
	//孕周
	private String pregnancyWeeks;
	//主诉
	private String chiefComplaint;
	//血压高值
	private String bloodHi;
	//血压低值
	private String bloodLow;
	//体重
	private String weight;
	//宫高
	private String uterusHight;
	//腹围
	private String abdomen;
	//胎方位
	private String fetusPosition;
	//胎心率
	private String heartRate;
	//先露
	private String present;
	//浮肿
	private String edema;
	//血红蛋白
	private String hemoglobin;
	//尿蛋白
	private String proteinuria;
	//血糖 
	private String bloodGlucose;
	//唐筛   0.未检查  1.无异常  2.有异常
	private String tangSyndrome;
	//NT  0.未检查  1.无异常  2.有异常
	private String NT;
	//四维    0.未检查  1.无异常  2.有异常
	private String fourDimensional;
	//B超     0.未检查  1.无异常  2.有异常
	private String bScan;
	//NST   0.未检查  1.无异常  2.有异常
	private String NST;
	//其他（肝功、肾功、免疫）(包含以下所有的肝功、肾功和免疫)
	private String others;
	//1. 肝功
	//①血清谷丙转氨酶
	private String sgpt;
	//②血清谷草转氨酶
	private String sgot;
	//③白蛋白
	private String albumin;
	//④总胆红素
	private String totalBilirubin;
	//⑤综合胆红素
	private String dbil;
	//2. 肾功
	//①血清肌酐
	private String scr;
	//②血尿素氮
	private String bun;
	//3. 免疫
	private String immune;
	//高危评分
	private String score;
	//高危因素   （高危项拼接成的字符串）
	private String highRisk;
	//分类   0.未见异常   1.异常
	private String evaluate;
	//转诊 0.无  1.有
	private String referral;
	//下次随访日期
	private Date nextFollowingDate;
	//产检检查单位
	private String hospital;
	//随访医生
	private String doctorName;
	//指导
	private String guidance;
	//产后检查类型
	private String postCheckType;
	
	public String getPostCheckType() {
		return postCheckType;
	}
	public void setPostCheckType(String postCheckType) {
		this.postCheckType = postCheckType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public String getPregnancyWeeks() {
		return pregnancyWeeks;
	}
	public void setPregnancyWeeks(String pregnancyWeeks) {
		this.pregnancyWeeks = pregnancyWeeks;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public String getBloodHi() {
		return bloodHi;
	}
	public void setBloodHi(String bloodHi) {
		this.bloodHi = bloodHi;
	}
	public String getBloodLow() {
		return bloodLow;
	}
	public void setBloodLow(String bloodLow) {
		this.bloodLow = bloodLow;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getUterusHight() {
		return uterusHight;
	}
	public void setUterusHight(String uterusHight) {
		this.uterusHight = uterusHight;
	}
	public String getAbdomen() {
		return abdomen;
	}
	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}
	public String getFetusPosition() {
		return fetusPosition;
	}
	public void setFetusPosition(String fetusPosition) {
		this.fetusPosition = fetusPosition;
	}
	public String getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getEdema() {
		return edema;
	}
	public void setEdema(String edema) {
		this.edema = edema;
	}
	public String getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getProteinuria() {
		return proteinuria;
	}
	public void setProteinuria(String proteinuria) {
		this.proteinuria = proteinuria;
	}
	public String getBloodGlucose() {
		return bloodGlucose;
	}
	public void setBloodGlucose(String bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getTangSyndrome() {
		return tangSyndrome;
	}
	public void setTangSyndrome(String tangSyndrome) {
		this.tangSyndrome = tangSyndrome;
	}
	public String getNT() {
		return NT;
	}
	public void setNT(String nT) {
		NT = nT;
	}
	public String getFourDimensional() {
		return fourDimensional;
	}
	public void setFourDimensional(String fourDimensional) {
		this.fourDimensional = fourDimensional;
	}
	public String getbScan() {
		return bScan;
	}
	public void setbScan(String bScan) {
		this.bScan = bScan;
	}
	public String getNST() {
		return NST;
	}
	public void setNST(String nST) {
		NST = nST;
	}
	public String getSgpt() {
		return sgpt;
	}
	public void setSgpt(String sgpt) {
		this.sgpt = sgpt;
	}
	public String getSgot() {
		return sgot;
	}
	public void setSgot(String sgot) {
		this.sgot = sgot;
	}
	public String getAlbumin() {
		return albumin;
	}
	public void setAlbumin(String albumin) {
		this.albumin = albumin;
	}
	public String getTotalBilirubin() {
		return totalBilirubin;
	}
	public void setTotalBilirubin(String totalBilirubin) {
		this.totalBilirubin = totalBilirubin;
	}
	public String getDbil() {
		return dbil;
	}
	public void setDbil(String dbil) {
		this.dbil = dbil;
	}
	public String getScr() {
		return scr;
	}
	public void setScr(String scr) {
		this.scr = scr;
	}
	public String getBun() {
		return bun;
	}
	public void setBun(String bun) {
		this.bun = bun;
	}
	public String getImmune() {
		return immune;
	}
	public void setImmune(String immune) {
		this.immune = immune;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getHighRisk() {
		return highRisk;
	}
	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
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
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getGuidance() {
		return guidance;
	}
	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}
}
