package com.threefiveninetong.mchh.highriskmaternalmanage.po;

import java.util.Date;

public class HighRiskMaternalManagePO {
	
	//档案创建时间
	private Date creatTime;
	
	//档案编号
	private String archivesCode;
	
	//姓名
	private String name;
	
	//年龄（根据出生日期算）
	private int age;
	//出生日期(用来计算年龄)
	private Date birthday;
	
	//末次月经
	private Date lastMenses;
	
	//孕周（根据末次月经计算）
	private int weeks;
	
	//预产期
	private Date predictDate;
	
	//筛查日期
	private Date checkDate;
	
	//高危因素
	private String highRisk;
	
	//高危评分
	private int score;
	
	//转出医院
	private String outHospitalName;
	
	//转入医院
	private String inHospitalName;
	
	//接诊医生
	private String doctorName;
	
	//转归(存储的是数字 0：继续监护 1：正常随访 2：结束分娩)
	private String lapseToNo;
	private String lapseTo; 
	
	//分娩日期
	private Date birthDate;
	
	//分娩地点
	private String childbirthPlace;
	
	//分娩方式
	private String deliveryType;
	
	//诊断结果
	private String diaResult;
	
	//家庭住址(全：根据省、市、县、乡、村、详细地址拼接而成)
	private String address;
	//1.省
	private String provinceName;
	//1.市
	private String cityName;
	//3.县
	private String countyName;
	//4.乡
	private String townshipName;
	//5.村
	private String villageName;
	//6.详细地址
	private String detailAddress;
	
	//第一次筛查出高危的日期
	private Date screeningDate;
	
	//联系电话
	private String telephone;
	
	//档案id
	private String archivesId;
	
	//生育id
	private String birthArchivesId;
	
	//产检id
	private String preExaId;
	

	
	public String getLapseToNo() {
		return lapseToNo;
	}

	public void setLapseToNo(String lapseToNo) {
		this.lapseToNo = lapseToNo;
	}

	public String getPreExaId() {
		return preExaId;
	}

	public void setPreExaId(String preExaId) {
		this.preExaId = preExaId;
	}

	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}

	public String getBirthArchivesId() {
		return birthArchivesId;
	}

	public void setBirthArchivesId(String birthArchivesId) {
		this.birthArchivesId = birthArchivesId;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public Date getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getHighRisk() {
		return highRisk;
	}

	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public String getDiaResult() {
		return diaResult;
	}

	public void setDiaResult(String diaResult) {
		this.diaResult = diaResult;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getTownshipName() {
		return townshipName;
	}

	public void setTownshipName(String townshipName) {
		this.townshipName = townshipName;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(Date screeningDate) {
		this.screeningDate = screeningDate;
	}
	
	
}
