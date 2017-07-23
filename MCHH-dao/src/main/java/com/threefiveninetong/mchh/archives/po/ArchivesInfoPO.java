/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ArchivesInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.archives.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;




/**
 * @ClassName: ArchivesInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
public class ArchivesInfoPO implements Serializable {

	private InspectionResultPO inspectionResultPO;
	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
	private PremaritalExaInfoPO premaritalExaInfoPO;
	
	private OperatorPO operatorPO;
	
	private DepartmentPO departmentPO;
	
	private ProvinceInfoPO provinceInfoPO;
	
	private CityInfoPO cityInfoPO;
	
	private String address;
	
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ProvinceInfoPO getProvinceInfoPO() {
		return provinceInfoPO;
	}

	public void setProvinceInfoPO(ProvinceInfoPO provinceInfoPO) {
		this.provinceInfoPO = provinceInfoPO;
	}

	public CityInfoPO getCityInfoPO() {
		return cityInfoPO;
	}

	public void setCityInfoPO(CityInfoPO cityInfoPO) {
		this.cityInfoPO = cityInfoPO;
	}

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
	
    /** 0：中国，1外国 **/ 
	private String international;
	
    /** 联系电话 **/ 
	private String telephone;
	
    /** 身份证号 **/ 
	private String idNo;
	
    /** 民族 **/ 
	private String nation;
	
    /** 出生日期 **/ 
	private Date birthday;
	/** 年龄**/ 
	private Integer age;
    /** 0：本地，1：外地 **/ 
	private String householdType;
	
    /** 0：务农，1：非农 **/ 
	private String accountType;
	
    /** 职业 **/ 
	private String occupation;
	
    /** 0：小学
            1：初中
            2：高中
            3：中专
            4：大专
            5：本科
            6：硕士
            7：博士
            8：博士后 **/ 
	private String education;
	
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
	
    /** 工作单位 **/ 
	private String workUnit;
	
    /** 紧急电话 **/ 
	private String urgentCall;
	
    /** 男方姓名 **/ 
	private String manName;
	
    /** 男方身份证号 **/ 
	private String manIdNo;
	
    /** 男方联系电话 **/ 
	private String manTele;
	
    /** 男方国籍 **/ 
	private String manInte;
	
    /** 男方性别 **/ 
	private String manSex;
	
    /** 男方出生日期 **/ 
	private Date manBirthday;
	
    /** 男方户口省ID **/ 
	private String manAccProvinceId;
	
    /** 男方户口市ID **/ 
	private String manAccCityId;
	
    /** 男方户口县ID **/ 
	private String manAccCountyId;
	
    /** 男方户口乡ID **/ 
	private String manAccTownshipId;
	
    /** 男方户口村ID **/ 
	private String manAccVillageId;
	
    /** 男方户口具体地址 **/ 
	private String manAccAddress;
	
    /** 男方家庭省ID **/ 
	private String manHomeProvinceId;
	
    /** 男方家庭市ID **/ 
	private String manHomeCityId;
	
    /** 男方家庭县ID **/ 
	private String manHomeCountyId;
	
    /** 男方家庭乡ID **/ 
	private String manHomeTownshipId;
	
    /** 男方家庭村ID **/ 
	private String manHomeVillageId;
	
    /** 男方家庭具体地址 **/ 
	private String manHomeAddress;
	
    /** 男方工作单位 **/ 
	private String manWorkUnit;
	
    /** 男方紧急电话 **/ 
	private String manUrgentCall;
	
    /** 民族 **/ 
	private String manNation;
	
    /** 0：本地，1：外地 **/ 
	private String manHouType;
	
    /** 0：务农，1：非农 **/ 
	private String manAccType;
	
    /** 职业 **/ 
	private String manOccupation;
	
    /** 0：小学
            1：初中
            2：高中
            3：中专
            4：大专
            5：本科
            6：硕士
            7：博士
            8：博士后 **/ 
	private String manEducation;
	
    /** 删除标识 **/ 
	private String deltetSign;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	/** 末次月经**/ 
	private String lastmenstrual;

	/**
	 * 构造 
	 */
	public ArchivesInfoPO() {
	}
	
	public InspectionResultPO getInspectionResultPO() {
		return inspectionResultPO;
	}

	public void setInspectionResultPO(InspectionResultPO inspectionResultPO) {
		this.inspectionResultPO = inspectionResultPO;
	}

	public ArchivesInfoPO( String id,  String archivesCode, String hospitalId, String doctorId, String name, String sex, String international, String telephone, String idNo, String nation, Date birthday, String householdType, String accountType, String occupation, String education, String accProvinceId, String accCityId, String accCountyId, String accTownshipId, String accVillageId, String accAddress, String homeProvinceId, String homeCityId, String homeCountyId, String homeTownshipId, String homeVillageId, String homeAddress, String workUnit, String urgentCall, String manName, String manIdNo, String manTele, String manInte, String manSex, Date manBirthday, String manAccProvinceId, String manAccCityId, String manAccCountyId, String manAccTownshipId, String manAccVillageId, String manAccAddress, String manHomeProvinceId, String manHomeCityId, String manHomeCountyId, String manHomeTownshipId, String manHomeVillageId, String manHomeAddress,String manWorkUnit,String  manUrgentCall, String manNation, String manHouType, String manAccType, String manOccupation, String manEducation, String deltetSign, Date creatTime, Date updateTime) {
				this.archivesCode = archivesCode;
				this.hospitalId = hospitalId;
				this.doctorId = doctorId;
				this.name = name;
				this.sex = sex;
				this.international = international;
				this.telephone = telephone;
				this.idNo = idNo;
				this.nation = nation;
				this.birthday = birthday;
				this.householdType = householdType;
				this.accountType = accountType;
				this.occupation = occupation;
				this.education = education;
				this.accProvinceId = accProvinceId;
				this.accCityId = accCityId;
				this.accCountyId = accCountyId;
				this.accTownshipId = accTownshipId;
				this.accVillageId = accVillageId;
				this.accAddress = accAddress;
				this.homeProvinceId = homeProvinceId;
				this.homeCityId = homeCityId;
				this.homeCountyId = homeCountyId;
				this.homeTownshipId = homeTownshipId;
				this.homeVillageId = homeVillageId;
				this.homeAddress = homeAddress;
				this.workUnit = workUnit;
				this.urgentCall = urgentCall;
				this.manName = manName;
				this.manIdNo = manIdNo;
				this.manTele = manTele;
				this.manInte = manInte;
				this.manSex = manSex;
				this.manBirthday = manBirthday;
				this.manAccProvinceId = manAccProvinceId;
				this.manAccCityId = manAccCityId;
				this.manAccCountyId = manAccCountyId;
				this.manAccTownshipId = manAccTownshipId;
				this.manAccVillageId = manAccVillageId;
				this.manAccAddress = manAccAddress;
				this.manHomeProvinceId = manHomeProvinceId;
				this.manHomeCityId = manHomeCityId;
				this.manHomeCountyId = manHomeCountyId;
				this.manHomeTownshipId = manHomeTownshipId;
				this.manHomeVillageId = manHomeVillageId;
				this.manHomeAddress = manHomeAddress;
				this.manWorkUnit = manWorkUnit;
				this.manUrgentCall = manUrgentCall;
				this.manNation = manNation;
				this.manHouType = manHouType;
				this.manAccType = manAccType;
				this.manOccupation = manOccupation;
				this.manEducation = manEducation;
				this.deltetSign = deltetSign;
				this.creatTime = creatTime;
				this.updateTime = updateTime;
						this.id = id;
			}
	
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public DepartmentPO getDepartmentPO() {
		return departmentPO;
	}

	public void setDepartmentPO(DepartmentPO departmentPO) {
		this.departmentPO = departmentPO;
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
	public String getInternational() {
		return international;
	}

	public void setInternational(String international) {
		this.international = international;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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
	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	public String getUrgentCall() {
		return urgentCall;
	}

	public void setUrgentCall(String urgentCall) {
		this.urgentCall = urgentCall;
	}
	public String getManName() {
		return manName;
	}

	public void setManName(String manName) {
		this.manName = manName;
	}
	public String getManIdNo() {
		return manIdNo;
	}

	public void setManIdNo(String manIdNo) {
		this.manIdNo = manIdNo;
	}
	public String getManTele() {
		return manTele;
	}

	public void setManTele(String manTele) {
		this.manTele = manTele;
	}
	public String getManInte() {
		return manInte;
	}

	public void setManInte(String manInte) {
		this.manInte = manInte;
	}
	public String getManSex() {
		return manSex;
	}

	public void setManSex(String manSex) {
		this.manSex = manSex;
	}
	public Date getManBirthday() {
		return manBirthday;
	}

	public void setManBirthday(Date manBirthday) {
		this.manBirthday = manBirthday;
	}
	public String getManAccProvinceId() {
		return manAccProvinceId;
	}

	public void setManAccProvinceId(String manAccProvinceId) {
		this.manAccProvinceId = manAccProvinceId;
	}
	public String getManAccCityId() {
		return manAccCityId;
	}

	public void setManAccCityId(String manAccCityId) {
		this.manAccCityId = manAccCityId;
	}
	public String getManAccCountyId() {
		return manAccCountyId;
	}

	public void setManAccCountyId(String manAccCountyId) {
		this.manAccCountyId = manAccCountyId;
	}
	public String getManAccTownshipId() {
		return manAccTownshipId;
	}

	public void setManAccTownshipId(String manAccTownshipId) {
		this.manAccTownshipId = manAccTownshipId;
	}
	public String getManAccVillageId() {
		return manAccVillageId;
	}

	public void setManAccVillageId(String manAccVillageId) {
		this.manAccVillageId = manAccVillageId;
	}
	public String getManAccAddress() {
		return manAccAddress;
	}

	public void setManAccAddress(String manAccAddress) {
		this.manAccAddress = manAccAddress;
	}
	public String getManHomeProvinceId() {
		return manHomeProvinceId;
	}

	public void setManHomeProvinceId(String manHomeProvinceId) {
		this.manHomeProvinceId = manHomeProvinceId;
	}
	public String getManHomeCityId() {
		return manHomeCityId;
	}

	public void setManHomeCityId(String manHomeCityId) {
		this.manHomeCityId = manHomeCityId;
	}
	public String getManHomeCountyId() {
		return manHomeCountyId;
	}

	public void setManHomeCountyId(String manHomeCountyId) {
		this.manHomeCountyId = manHomeCountyId;
	}
	public String getManHomeTownshipId() {
		return manHomeTownshipId;
	}

	public void setManHomeTownshipId(String manHomeTownshipId) {
		this.manHomeTownshipId = manHomeTownshipId;
	}
	public String getManHomeVillageId() {
		return manHomeVillageId;
	}

	public void setManHomeVillageId(String manHomeVillageId) {
		this.manHomeVillageId = manHomeVillageId;
	}
	public String getManHomeAddress() {
		return manHomeAddress;
	}

	public void setManHomeAddress(String manHomeAddress) {
		this.manHomeAddress = manHomeAddress;
	}
	public String getManNation() {
		return manNation;
	}

	public void setManNation(String manNation) {
		this.manNation = manNation;
	}
	public String getManHouType() {
		return manHouType;
	}

	public void setManHouType(String manHouType) {
		this.manHouType = manHouType;
	}
	public String getManAccType() {
		return manAccType;
	}

	public void setManAccType(String manAccType) {
		this.manAccType = manAccType;
	}
	public String getManOccupation() {
		return manOccupation;
	}

	public void setManOccupation(String manOccupation) {
		this.manOccupation = manOccupation;
	}
	public String getManEducation() {
		return manEducation;
	}

	public void setManEducation(String manEducation) {
		this.manEducation = manEducation;
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

	public PremaritalExaInfoPO getPremaritalExaInfoPO() {
		return premaritalExaInfoPO;
	}

	public void setPremaritalExaInfoPO(PremaritalExaInfoPO premaritalExaInfoPO) {
		this.premaritalExaInfoPO = premaritalExaInfoPO;
	}

	public OperatorPO getOperatorPO() {
		return operatorPO;
	}

	public void setOperatorPO(OperatorPO operatorPO) {
		this.operatorPO = operatorPO;
	}

	public String getLastmenstrual() {
		return lastmenstrual;
	}

	public void setLastmenstrual(String lastmenstrual) {
		this.lastmenstrual = lastmenstrual;
	}

	public String getManWorkUnit() {
		return manWorkUnit;
	}

	public void setManWorkUnit(String manWorkUnit) {
		this.manWorkUnit = manWorkUnit;
	}

	public String getManUrgentCall() {
		return manUrgentCall;
	}

	public void setManUrgentCall(String manUrgentCall) {
		this.manUrgentCall = manUrgentCall;
	}

}