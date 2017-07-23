/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenArchivesInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 15:57:49 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ChildrenArchivesInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 15:57:49 
 */
public class ChildrenArchivesInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 档案编号 **/ 
	private String archivesCode;
	
    /** 手机号 **/ 
	private String hospitalId;
	
    /** 建档医生ID **/ 
	private String doctorId;
	
    /** 姓名 **/ 
	private String name;
	
    /** 0：女，1：男 **/ 
	private String sex;
	
    /** 出生日期 **/ 
	private Date birthday;
	
    /** 身份证号 **/ 
	private String idNo;
	
    /** 出生孕周 **/ 
	private String gestationalWeek;
	
    /** 0：单胎，1：多胎，2：双胎 **/ 
	private String fetusNum;
	
    /** 第几胎 **/ 
	private String whichFetus;
	
    /** 第几产 **/ 
	private String whichBirth;
	
	/** 分娩方式 0：顺产  1：剖宫产 **/ 
	private String deliveryType;
	
    /** 0：顺产
            1：胎头吸引
            2：产钳
            3：刨宫产
            4：臀位
            5：双多胎
            6：其他
             **/ 
	private String birthCondition;
	
    /** 出生情况详述 **/ 
	private String conditionRemark;
	
    /** 出生体重 **/ 
	private String weight;
	
    /** 出生身长 **/ 
	private String height;
	
    /** 0：无，1：有 **/ 
	private String asphyxia;
	
	/** Apgar评分 0:1分钟  1：5分钟   2：不详**/ 
	private String apgarScore;
	
    /** Apgar备注 **/ 
	private String apgarRemark;
	
    /** 0：无，1：有 **/ 
	private String newbornDisease;
	
    /** 新生儿疾病详述 **/ 
	private String diseaseRemark;
	
    /** 0：糖尿病，1：妊娠期高血压，2：其他 **/ 
	private String pregnancySickness;
	
    /** 母亲妊娠期患病情况详述 **/ 
	private String sicknessRemark;
	
    /** 0：无，1：有 **/ 
	private String anomaly;
	
    /** 是否有畸形详述 **/ 
	private String anomalyRemark;
	
    /** 0：镇平县妇幼保健院，1：其他 **/ 
	private String institutions;
	
    /** 助产机构其他 **/ 
	private String institutionsRemark;
	
    /** 出院日期 **/ 
	private Date dischargeDate;
	
    /** 户口省ID **/ 
	private String accProvinceId;
	
    /** 户口市ID **/ 
	private String accCityId;
	
    /** 户口县ID **/ 
	private String accCountyId;
	
    /** 户口乡ID **/ 
	private String accTownshipId;
	
    /** 户口村ID **/ 
	private String accVillageId;
	
    /** 户口具体地址 **/ 
	private String accAddress;
	
    /** 家庭省ID **/ 
	private String homeProvinceId;
	
    /** 家庭市ID **/ 
	private String homeCityId;
	
    /** 家庭县ID **/ 
	private String homeCountyId;
	
    /** 家庭乡ID **/ 
	private String homeTownshipId;
	
    /** 家庭村ID **/ 
	private String homeVillageId;
	
    /** 家庭具体地址 **/ 
	private String homeAddress;
	
    /** 妈妈姓名 **/ 
	private String momName;
	
    /** 0：小学
            1：初中
            2：高中
            3：中专
            4：大专
            5：本科
            6：研究生
            7：博士
            8：其他 
            9：无**/ 
	private String momEducation;
	
    /** 妈妈职业
     * 0：农民
	    1：工人
	    2：经商
	    3：干部
	    4：军人
	    5：科技
	    6：医药
	    7：其他
	    8：不详
    **/ 
	private String momOccupation;
	
    /** 妈妈工作单位 **/ 
	private String momWorkUnit;
	
    /** 妈妈身份证号 **/ 
	private String momIdNo;
	
    /** 妈妈出生日期 **/ 
	private Date momBirthday;
	
    /** 妈妈联系电话 **/ 
	private String momTele;
	
    /** 妈妈健康状况
            0：健康
            1：慢性病
            2：传染病
             **/ 
	private String momHealth;
	
    /** 妈妈慢性病备注 **/ 
	private String momChronicRemark;
	
    /** 妈妈传染病备注 **/ 
	private String momInfectiousRemark;
	
    /** 妈妈家族史
            0：无特殊
            1：先天性疾病
            2：遗传性疾病 **/ 
	private String momFamHistory;
	
    /** 妈妈先天性疾病备注 **/ 
	private String momCongenitalRemark;
	
    /** 妈妈遗传性疾病备注 **/ 
	private String momHereditaryRemark;
	
    /** 爸爸姓名 **/ 
	private String dadName;
	
    /** 0：小学
            1：初中
            2：高中
            3：中专
            4：大专
            5：本科
            6：硕士
            7：博士
            8：博士后 **/ 
	private String dadEducation;
	
    /** 爸爸职业 **/ 
	private String dadOccupation;
	
    /** 爸爸工作单位 **/ 
	private String dadWorkUnit;
	
    /** 爸爸身份证号 **/ 
	private String dadIdNo;
	
    /** 爸爸出生日期 **/ 
	private Date dadBirthday;
	
    /** 爸爸联系电话 **/ 
	private String dadTele;
	
    /** 0：未发放，1：已发放 **/ 
	private String grantSign;
	
    /** 爸爸慢性病备注 **/ 
	private String babChronicRemark;
	
    /** 爸爸传染病备注 **/ 
	private String babInfectiousRemark;
	
    /** 爸爸健康状况 **/ 
	private String babHealth;
	
    /** 爸爸先天性疾病备注 **/ 
	private String babCongenitalRemark;
	
    /** 爸爸遗传性疾病备注 **/ 
	private String babHereditaryRemark;
	
    /** 爸爸家族史 **/ 
	private String babFamHistory;
	
    /** 删除标识 0 ：已删除 1：未删除 **/ 
	private String deltetSign;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public ChildrenArchivesInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getGestationalWeek() {
		return gestationalWeek;
	}

	public void setGestationalWeek(String gestationalWeek) {
		this.gestationalWeek = gestationalWeek;
	}
	public String getFetusNum() {
		return fetusNum;
	}

	public void setFetusNum(String fetusNum) {
		this.fetusNum = fetusNum;
	}
	public String getWhichFetus() {
		return whichFetus;
	}

	public void setWhichFetus(String whichFetus) {
		this.whichFetus = whichFetus;
	}
	public String getWhichBirth() {
		return whichBirth;
	}

	public void setWhichBirth(String whichBirth) {
		this.whichBirth = whichBirth;
	}
	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getBirthCondition() {
		return birthCondition;
	}

	public void setBirthCondition(String birthCondition) {
		this.birthCondition = birthCondition;
	}
	public String getConditionRemark() {
		return conditionRemark;
	}

	public void setConditionRemark(String conditionRemark) {
		this.conditionRemark = conditionRemark;
	}
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	public String getAsphyxia() {
		return asphyxia;
	}

	public void setAsphyxia(String asphyxia) {
		this.asphyxia = asphyxia;
	}
	public String getApgarScore() {
		return apgarScore;
	}

	public void setApgarScore(String apgarScore) {
		this.apgarScore = apgarScore;
	}
	public String getApgarRemark() {
		return apgarRemark;
	}

	public void setApgarRemark(String apgarRemark) {
		this.apgarRemark = apgarRemark;
	}
	public String getNewbornDisease() {
		return newbornDisease;
	}

	public void setNewbornDisease(String newbornDisease) {
		this.newbornDisease = newbornDisease;
	}
	public String getDiseaseRemark() {
		return diseaseRemark;
	}

	public void setDiseaseRemark(String diseaseRemark) {
		this.diseaseRemark = diseaseRemark;
	}
	public String getPregnancySickness() {
		return pregnancySickness;
	}

	public void setPregnancySickness(String pregnancySickness) {
		this.pregnancySickness = pregnancySickness;
	}
	public String getSicknessRemark() {
		return sicknessRemark;
	}

	public void setSicknessRemark(String sicknessRemark) {
		this.sicknessRemark = sicknessRemark;
	}
	public String getAnomaly() {
		return anomaly;
	}

	public void setAnomaly(String anomaly) {
		this.anomaly = anomaly;
	}
	public String getAnomalyRemark() {
		return anomalyRemark;
	}

	public void setAnomalyRemark(String anomalyRemark) {
		this.anomalyRemark = anomalyRemark;
	}
	public String getInstitutions() {
		return institutions;
	}

	public void setInstitutions(String institutions) {
		this.institutions = institutions;
	}
	public String getInstitutionsRemark() {
		return institutionsRemark;
	}

	public void setInstitutionsRemark(String institutionsRemark) {
		this.institutionsRemark = institutionsRemark;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getAccProvinceId() {
		return accProvinceId;
	}

	public void setAccProvinceId(String accProvinceId) {
		this.accProvinceId = accProvinceId;
	}
	public String getAccCityId() {
		return accCityId;
	}

	public void setAccCityId(String accCityId) {
		this.accCityId = accCityId;
	}
	public String getAccCountyId() {
		return accCountyId;
	}

	public void setAccCountyId(String accCountyId) {
		this.accCountyId = accCountyId;
	}
	public String getAccTownshipId() {
		return accTownshipId;
	}

	public void setAccTownshipId(String accTownshipId) {
		this.accTownshipId = accTownshipId;
	}
	public String getAccVillageId() {
		return accVillageId;
	}

	public void setAccVillageId(String accVillageId) {
		this.accVillageId = accVillageId;
	}
	public String getAccAddress() {
		return accAddress;
	}

	public void setAccAddress(String accAddress) {
		this.accAddress = accAddress;
	}
	public String getHomeProvinceId() {
		return homeProvinceId;
	}

	public void setHomeProvinceId(String homeProvinceId) {
		this.homeProvinceId = homeProvinceId;
	}
	public String getHomeCityId() {
		return homeCityId;
	}

	public void setHomeCityId(String homeCityId) {
		this.homeCityId = homeCityId;
	}
	public String getHomeCountyId() {
		return homeCountyId;
	}

	public void setHomeCountyId(String homeCountyId) {
		this.homeCountyId = homeCountyId;
	}
	public String getHomeTownshipId() {
		return homeTownshipId;
	}

	public void setHomeTownshipId(String homeTownshipId) {
		this.homeTownshipId = homeTownshipId;
	}
	public String getHomeVillageId() {
		return homeVillageId;
	}

	public void setHomeVillageId(String homeVillageId) {
		this.homeVillageId = homeVillageId;
	}
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getMomName() {
		return momName;
	}

	public void setMomName(String momName) {
		this.momName = momName;
	}
	public String getMomEducation() {
		return momEducation;
	}

	public void setMomEducation(String momEducation) {
		this.momEducation = momEducation;
	}
	public String getMomOccupation() {
		return momOccupation;
	}

	public void setMomOccupation(String momOccupation) {
		this.momOccupation = momOccupation;
	}
	public String getMomWorkUnit() {
		return momWorkUnit;
	}

	public void setMomWorkUnit(String momWorkUnit) {
		this.momWorkUnit = momWorkUnit;
	}
	public String getMomIdNo() {
		return momIdNo;
	}

	public void setMomIdNo(String momIdNo) {
		this.momIdNo = momIdNo;
	}
	public Date getMomBirthday() {
		return momBirthday;
	}

	public void setMomBirthday(Date momBirthday) {
		this.momBirthday = momBirthday;
	}
	public String getMomTele() {
		return momTele;
	}

	public void setMomTele(String momTele) {
		this.momTele = momTele;
	}
	public String getMomHealth() {
		return momHealth;
	}

	public void setMomHealth(String momHealth) {
		this.momHealth = momHealth;
	}
	public String getMomChronicRemark() {
		return momChronicRemark;
	}

	public void setMomChronicRemark(String momChronicRemark) {
		this.momChronicRemark = momChronicRemark;
	}
	public String getMomInfectiousRemark() {
		return momInfectiousRemark;
	}

	public void setMomInfectiousRemark(String momInfectiousRemark) {
		this.momInfectiousRemark = momInfectiousRemark;
	}
	public String getMomFamHistory() {
		return momFamHistory;
	}

	public void setMomFamHistory(String momFamHistory) {
		this.momFamHistory = momFamHistory;
	}
	public String getMomCongenitalRemark() {
		return momCongenitalRemark;
	}

	public void setMomCongenitalRemark(String momCongenitalRemark) {
		this.momCongenitalRemark = momCongenitalRemark;
	}
	public String getMomHereditaryRemark() {
		return momHereditaryRemark;
	}

	public void setMomHereditaryRemark(String momHereditaryRemark) {
		this.momHereditaryRemark = momHereditaryRemark;
	}
	public String getDadName() {
		return dadName;
	}

	public void setDadName(String dadName) {
		this.dadName = dadName;
	}
	public String getDadEducation() {
		return dadEducation;
	}

	public void setDadEducation(String dadEducation) {
		this.dadEducation = dadEducation;
	}
	public String getDadOccupation() {
		return dadOccupation;
	}

	public void setDadOccupation(String dadOccupation) {
		this.dadOccupation = dadOccupation;
	}
	public String getDadWorkUnit() {
		return dadWorkUnit;
	}

	public void setDadWorkUnit(String dadWorkUnit) {
		this.dadWorkUnit = dadWorkUnit;
	}
	public String getDadIdNo() {
		return dadIdNo;
	}

	public void setDadIdNo(String dadIdNo) {
		this.dadIdNo = dadIdNo;
	}
	public Date getDadBirthday() {
		return dadBirthday;
	}

	public void setDadBirthday(Date dadBirthday) {
		this.dadBirthday = dadBirthday;
	}
	public String getDadTele() {
		return dadTele;
	}

	public void setDadTele(String dadTele) {
		this.dadTele = dadTele;
	}
	public String getGrantSign() {
		return grantSign;
	}

	public void setGrantSign(String grantSign) {
		this.grantSign = grantSign;
	}
	public String getBabChronicRemark() {
		return babChronicRemark;
	}

	public void setBabChronicRemark(String babChronicRemark) {
		this.babChronicRemark = babChronicRemark;
	}
	public String getBabInfectiousRemark() {
		return babInfectiousRemark;
	}

	public void setBabInfectiousRemark(String babInfectiousRemark) {
		this.babInfectiousRemark = babInfectiousRemark;
	}
	public String getBabHealth() {
		return babHealth;
	}

	public void setBabHealth(String babHealth) {
		this.babHealth = babHealth;
	}
	public String getBabCongenitalRemark() {
		return babCongenitalRemark;
	}

	public void setBabCongenitalRemark(String babCongenitalRemark) {
		this.babCongenitalRemark = babCongenitalRemark;
	}
	public String getBabHereditaryRemark() {
		return babHereditaryRemark;
	}

	public void setBabHereditaryRemark(String babHereditaryRemark) {
		this.babHereditaryRemark = babHereditaryRemark;
	}
	public String getBabFamHistory() {
		return babFamHistory;
	}

	public void setBabFamHistory(String babFamHistory) {
		this.babFamHistory = babFamHistory;
	}
	public String getDeltetSign() {
		return deltetSign;
	}

	public void setDeltetSign(String deltetSign) {
		this.deltetSign = deltetSign;
	}
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}