/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppAffiliatedHospitalInfoPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appHospital.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.appMember.po.AppMemberPO;




/**
 * @ClassName: AppAffiliatedHospitalInfoPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public class AppAffiliatedHospitalInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 医院信息ID **/ 
	private String hospitalId;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 就诊号 **/ 
	private String treatmentNo;
	
    /** 身份证号 **/ 
	private String idNo;
	
    /** 档案编号 **/ 
	private String archivesCode;
	
    /** 医院名称 **/ 
	private String hospitalName;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	/**
	 * 会员信息
	 */
	private AppMemberPO appMemberPO;
	
	/**
	 * 医院信息
	 */
	private AppHospitalInfoPO appHospitalInfoPO;
	

	public AppMemberPO getAppMemberPO() {
		return appMemberPO;
	}

	public void setAppMemberPO(AppMemberPO appMemberPO) {
		this.appMemberPO = appMemberPO;
	}

	public AppHospitalInfoPO getAppHospitalInfoPO() {
		return appHospitalInfoPO;
	}

	public void setAppHospitalInfoPO(AppHospitalInfoPO appHospitalInfoPO) {
		this.appHospitalInfoPO = appHospitalInfoPO;
	}

	/**
	 * 构造 
	 */
	public AppAffiliatedHospitalInfoPO() {
	}
	
	public AppAffiliatedHospitalInfoPO( String id,  String hospitalId, String mbrId, String treatmentNo, String idNo, String archivesCode, String hospitalName, Date createTime, Date updateTime) {
				this.hospitalId = hospitalId;
				this.mbrId = mbrId;
				this.treatmentNo = treatmentNo;
				this.idNo = idNo;
				this.archivesCode = archivesCode;
				this.hospitalName = hospitalName;
				this.createTime = createTime;
				this.updateTime = updateTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getTreatmentNo() {
		return treatmentNo;
	}

	public void setTreatmentNo(String treatmentNo) {
		this.treatmentNo = treatmentNo;
	}
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}