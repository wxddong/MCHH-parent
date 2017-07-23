package com.threefiveninetong.mchh.childbirth.po;

import java.io.Serializable;
import java.util.Date;

public class SelectChildBaby implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String source; 
	
	private String babyName;
	
	private String babySex;
	
	private String childBirthId;
	
	private String basicId;
	
	private String deliveryType;
	
	private String birthArchivesId;
	
	private Date birthDate;
	
	private String archivesId;
	
	private String name;
	
	private String archivesCode;
	
	private String education;
	
	private String occupation;
	
	private String workUnit;
	
	private String idNo;
	
	private Date birthday;
	
	private String telephone;
	
	private String manName;
	
	private String manIdNo;
	
	private String manEducation;
	
	private String manOccupation;
	
	private String manWorkUnit;
	
	private Date manBirthday;
	
	private String manTele;

	public SelectChildBaby() {
	}

	public SelectChildBaby(String babyName, String babySex, String childBirthId, String basicId, String birthArchivesId,
			Date birthDate, String archivesId, String name, String archivesCode, String education, String occupation,
			String workUnit, String idNo, Date birthday, String telephone, String manName, String manIdNo,
			String manEducation, String manOccupation, String manWorkUnit, Date manBirthday, String manTele) {
		super();
		this.babyName = babyName;
		this.babySex = babySex;
		this.childBirthId = childBirthId;
		this.basicId = basicId;
		this.birthArchivesId = birthArchivesId;
		this.birthDate = birthDate;
		this.archivesId = archivesId;
		this.name = name;
		this.archivesCode = archivesCode;
		this.education = education;
		this.occupation = occupation;
		this.workUnit = workUnit;
		this.idNo = idNo;
		this.birthday = birthday;
		this.telephone = telephone;
		this.manName = manName;
		this.manIdNo = manIdNo;
		this.manEducation = manEducation;
		this.manOccupation = manOccupation;
		this.manWorkUnit = manWorkUnit;
		this.manBirthday = manBirthday;
		this.manTele = manTele;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	public String getBabySex() {
		return babySex;
	}

	public void setBabySex(String babySex) {
		this.babySex = babySex;
	}

	public String getChildBirthId() {
		return childBirthId;
	}

	public void setChildBirthId(String childBirthId) {
		this.childBirthId = childBirthId;
	}

	public String getBasicId() {
		return basicId;
	}

	public void setBasicId(String basicId) {
		this.basicId = basicId;
	}

	public String getBirthArchivesId() {
		return birthArchivesId;
	}

	public void setBirthArchivesId(String birthArchivesId) {
		this.birthArchivesId = birthArchivesId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getManEducation() {
		return manEducation;
	}

	public void setManEducation(String manEducation) {
		this.manEducation = manEducation;
	}

	public String getManOccupation() {
		return manOccupation;
	}

	public void setManOccupation(String manOccupation) {
		this.manOccupation = manOccupation;
	}

	public String getManWorkUnit() {
		return manWorkUnit;
	}

	public void setManWorkUnit(String manWorkUnit) {
		this.manWorkUnit = manWorkUnit;
	}

	public Date getManBirthday() {
		return manBirthday;
	}

	public void setManBirthday(Date manBirthday) {
		this.manBirthday = manBirthday;
	}

	public String getManTele() {
		return manTele;
	}

	public void setManTele(String manTele) {
		this.manTele = manTele;
	}
	
	
}
