package com.threefiveninetong.mchh.maternalhealthcarestatistics.po;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MaternalHealthCareStatisticsPO {
	//生育id
	private String birthArchivesId;
	//将档日期
	private Date creatDate;
	//档案编号
	private String archivesCode;
	//姓名
	private String name;
	//年龄（根据出生日期计算）
	private int age;
	//出生日期
	private Date birthday;
	//末次月经
	private Date lastMenses;
	//预产期
	private Date predictDate;
	//建卡孕周（根据预产期计算）
	private int weeks;
	//孕13周六天前随访时间和预约时间
	private Date oneCheckDate;
	private Date oneOrderDate;
	//14-15周随访次数和预约时间
	private int twoCheckTimes;
	private Date twoOrderDate;
	//16-20
	private int threeCheckTimes;
	private Date threeOrderDate;
	//21-24
	private int fourCheckTimes;
	private Date fourOrderDate;
	//25-27
	private int fiveCheckTimes;
	private Date fiveOrderDate;
	//28-36
	private int sixCheckTimes;
	private Date sixOrderDate;
	//37-40
	private int sevenCheckTimes;
	private Date sevenOrderDate;
	//产后3-7天检查次数和预约时间
	private int post3to7Times;
	private Date post3to7Date;
	//产后42天检查次数
	private int post42Times;
	//结案时间
	private Date closeDate;
	//高危因素
	private String highRisk;
	//分娩时间
	private Date birthDate;
	//分娩地点
	private String childbirthPlace;
	//家庭住址
	private String address;
	private String provinceName;
	private String cityName;
	private String countyName;
	private String townshipName;
	private String villageName;
	private String detailAddress;
	//联系电话
	private String telephone;
	
	public String getBirthArchivesId() {
		return birthArchivesId;
	}
	public void setBirthArchivesId(String birthArchivesId) {
		this.birthArchivesId = birthArchivesId;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
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
	public Date getPredictDate() {
		return predictDate;
	}
	public void setPredictDate(Date predictDate) {
		this.predictDate = predictDate;
	}
	public int getWeeks() {
		return weeks;
	}
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	public Date getOneCheckDate() {
		return oneCheckDate;
	}
	public void setOneCheckDate(Date oneCheckDate) {
		this.oneCheckDate = oneCheckDate;
	}
	public Date getOneOrderDate() {
		return oneOrderDate;
	}
	public void setOneOrderDate(Date oneOrderDate) {
		this.oneOrderDate = oneOrderDate;
	}
	public int getTwoCheckTimes() {
		return twoCheckTimes;
	}
	public void setTwoCheckTimes(int twoCheckTimes) {
		this.twoCheckTimes = twoCheckTimes;
	}
	public Date getTwoOrderDate() {
		return twoOrderDate;
	}
	public void setTwoOrderDate(Date twoOrderDate) {
		this.twoOrderDate = twoOrderDate;
	}
	public int getThreeCheckTimes() {
		return threeCheckTimes;
	}
	public void setThreeCheckTimes(int threeCheckTimes) {
		this.threeCheckTimes = threeCheckTimes;
	}
	public Date getThreeOrderDate() {
		return threeOrderDate;
	}
	public void setThreeOrderDate(Date threeOrderDate) {
		this.threeOrderDate = threeOrderDate;
	}
	public int getFourCheckTimes() {
		return fourCheckTimes;
	}
	public void setFourCheckTimes(int fourCheckTimes) {
		this.fourCheckTimes = fourCheckTimes;
	}
	public Date getFourOrderDate() {
		return fourOrderDate;
	}
	public void setFourOrderDate(Date fourOrderDate) {
		this.fourOrderDate = fourOrderDate;
	}
	public int getFiveCheckTimes() {
		return fiveCheckTimes;
	}
	public void setFiveCheckTimes(int fiveCheckTimes) {
		this.fiveCheckTimes = fiveCheckTimes;
	}
	public Date getFiveOrderDate() {
		return fiveOrderDate;
	}
	public void setFiveOrderDate(Date fiveOrderDate) {
		this.fiveOrderDate = fiveOrderDate;
	}
	public int getSixCheckTimes() {
		return sixCheckTimes;
	}
	public void setSixCheckTimes(int sixCheckTimes) {
		this.sixCheckTimes = sixCheckTimes;
	}
	public Date getSixOrderDate() {
		return sixOrderDate;
	}
	public void setSixOrderDate(Date sixOrderDate) {
		this.sixOrderDate = sixOrderDate;
	}
	public int getSevenCheckTimes() {
		return sevenCheckTimes;
	}
	public void setSevenCheckTimes(int sevenCheckTimes) {
		this.sevenCheckTimes = sevenCheckTimes;
	}
	public Date getSevenOrderDate() {
		return sevenOrderDate;
	}
	public void setSevenOrderDate(Date sevenOrderDate) {
		this.sevenOrderDate = sevenOrderDate;
	}

	public int getPost3to7Times() {
		return post3to7Times;
	}
	public void setPost3to7Times(int post3to7Times) {
		this.post3to7Times = post3to7Times;
	}
	public Date getPost3to7Date() {
		return post3to7Date;
	}
	public void setPost3to7Date(Date post3to7Date) {
		this.post3to7Date = post3to7Date;
	}
	public int getPost42Times() {
		return post42Times;
	}
	public void setPost42Times(int post42Times) {
		this.post42Times = post42Times;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getHighRisk() {
		return highRisk;
	}
	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
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
	
		
	
}
