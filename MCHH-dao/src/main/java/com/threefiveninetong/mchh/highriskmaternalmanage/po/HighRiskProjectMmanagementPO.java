package com.threefiveninetong.mchh.highriskmaternalmanage.po;

import java.util.Date;

public class HighRiskProjectMmanagementPO {

	//产前检查id
	private String preExaId;
	
	//末次月经
	private Date lastMenses;
	
	//检查时的孕周（根据末次月经计算）
	private int weeks;
	
	//检查日期
	private Date checkDate;
	
	//高危因素(固态因素和动态因素)
	//1动态因素
	private String moveRisk;
	
	//2静态因素
	private String staticRisk;
	
	//高危评分
	private int score;
	
	//本次检查结果
	private String result;
	
	//指导意见
	private String guidance;
	
	//预约时间
	private Date orderDate;
	
	//转归(存储的是数字 0：继续监护 1：正常随访 2：结束分娩)
	private String lapseToNo;
	private String lapseTo;
	
	//分娩日期
	private Date birthDate;
	
	//分娩地点
	private String childbirthPlace;
	
	//分娩方式
	private String deliveryType;
	
	//转出医院
	private String outHospitalName;
	
	//转入医院
	private String inHospitalName;
	
	//随访医生
	private String doctorName;
	public String getPreExaId() {
		return preExaId;
	}

	public void setPreExaId(String preExaId) {
		this.preExaId = preExaId;
	}

	
	public String getLapseToNo() {
		return lapseToNo;
	}

	public void setLapseToNo(String lapseToNo) {
		this.lapseToNo = lapseToNo;
	}

	public Date getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(Date lastMenses) {
		this.lastMenses = lastMenses;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getMoveRisk() {
		return moveRisk;
	}

	public void setMoveRisk(String moveRisk) {
		this.moveRisk = moveRisk;
	}

	public String getStaticRisk() {
		return staticRisk;
	}

	public void setStaticRisk(String staticRisk) {
		this.staticRisk = staticRisk;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getLapseTo() {
		return lapseTo;
	}

	public void setLapseTo(String lapseTo) {
		this.lapseTo = lapseTo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getChildbirthPlace() {
		return childbirthPlace;
	}

	public void setChildbirthPlace(String childbirthPlace) {
		this.childbirthPlace = childbirthPlace;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getOutHospitalName() {
		return outHospitalName;
	}

	public void setOutHospitalName(String outHospitalName) {
		this.outHospitalName = outHospitalName;
	}

	public String getInHospitalName() {
		return inHospitalName;
	}

	public void setInHospitalName(String inHospitalName) {
		this.inHospitalName = inHospitalName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
