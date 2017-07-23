/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalExaInfoPO.java
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

import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;




/**
 * @ClassName: PremaritalExaInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
public class PremaritalExaInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
	/** 年龄**/ 
	private Integer age;
	
    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String address;

	/** 档案ID **/ 
	private String archivesId;
	
    /** 0：男，1：女 **/ 
	private String sex;
	
    /** 检查医生ID **/ 
	private String doctorId;
	
	/** 婚检状态 **/ 
	private String premaritalStatus;
	
	
	/** 编辑状态 **/ 
	private String editStatus;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	private OperatorPO operatorPO;
	
	private ArchivesInfoPO archivesInfoPO;
	
	private PremaritalReferralInfoPO premaritalReferralInfoPO;
	
	private InspectionResultPO inspectionResultPO;

	private HealthInfoPO healthInfoPO;
	
	private BirthArchivesInfoPO birthArchivesInfoPO;
	
	private DepartmentPO departmentPO;
	
	private DistrictAndCountyInfoPO districtAndCountyInfoPO;

	public DepartmentPO getDepartmentPO() {
		return departmentPO;
	}

	public void setDepartmentPO(DepartmentPO departmentPO) {
		this.departmentPO = departmentPO;
	}

	public DistrictAndCountyInfoPO getDistrictAndCountyInfoPO() {
		return districtAndCountyInfoPO;
	}

	public void setDistrictAndCountyInfoPO(DistrictAndCountyInfoPO districtAndCountyInfoPO) {
		this.districtAndCountyInfoPO = districtAndCountyInfoPO;
	}

	public OperatorPO getOperatorPO() {
		return operatorPO;
	}

	public void setOperatorPO(OperatorPO operatorPO) {
		this.operatorPO = operatorPO;
	}

	public ArchivesInfoPO getArchivesInfoPO() {
		return archivesInfoPO;
	}

	public void setArchivesInfoPO(ArchivesInfoPO archivesInfoPO) {
		this.archivesInfoPO = archivesInfoPO;
	}

	public PremaritalReferralInfoPO getPremaritalReferralInfoPO() {
		return premaritalReferralInfoPO;
	}

	public void setPremaritalReferralInfoPO(PremaritalReferralInfoPO premaritalReferralInfoPO) {
		this.premaritalReferralInfoPO = premaritalReferralInfoPO;
	}

	public InspectionResultPO getInspectionResultPO() {
		return inspectionResultPO;
	}

	public void setInspectionResultPO(InspectionResultPO inspectionResultPO) {
		this.inspectionResultPO = inspectionResultPO;
	}

	public HealthInfoPO getHealthInfoPO() {
		return healthInfoPO;
	}

	public void setHealthInfoPO(HealthInfoPO healthInfoPO) {
		this.healthInfoPO = healthInfoPO;
	}

	public BirthArchivesInfoPO getBirthArchivesInfoPO() {
		return birthArchivesInfoPO;
	}

	public void setBirthArchivesInfoPO(BirthArchivesInfoPO birthArchivesInfoPO) {
		this.birthArchivesInfoPO = birthArchivesInfoPO;
	}

	/**
	 * 构造 
	 */
	public PremaritalExaInfoPO() {
	}
	
	public PremaritalExaInfoPO( String id,  String archivesId, String sex, String doctorId,String premaritalStatus,String editStatus,Date creatTime, Date updateTime) {
				this.archivesId = archivesId;
				this.sex = sex;
				this.doctorId = doctorId;
				this.premaritalStatus = premaritalStatus;
				this.editStatus = editStatus;
				this.creatTime = creatTime;
				this.updateTime = updateTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArchivesId() {
		return archivesId;
	}

	public void setArchivesId(String archivesId) {
		this.archivesId = archivesId;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getPremaritalStatus() {
		return premaritalStatus;
	}

	public void setPremaritalStatus(String premaritalStatus) {
		this.premaritalStatus = premaritalStatus;
	}

	public String getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(String editStatus) {
		this.editStatus = editStatus;
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