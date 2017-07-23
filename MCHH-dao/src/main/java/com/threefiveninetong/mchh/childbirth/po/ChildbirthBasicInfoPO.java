/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBasicInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childbirth.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 19:16:50 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.sys.po.OperatorPO;




/**
 * @ClassName: ChildbirthBasicInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 19:16:50 
 */
public class ChildbirthBasicInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 生育档案ID **/ 
	private String birthArchivesId;
	
    /** 录入医生ID **/ 
	private String doctorId;
	
    /** 分娩日期 **/ 
	private Date birthDate;
	
    /** 住院号 **/ 
	private String hospitalCode;
	
    /** 出院日期 **/ 
	private Date leaveDate;
	
    /** 末次月经 **/ 
	private Date lastMenses;
	
    /** 孕周周 **/ 
	private String gestationalWeek;
	
    /** 孕周天 **/ 
	private String gestationalDay;
	
    /** 孕次 **/ 
	private String pregnancyNum;
	
    /** 产次 **/ 
	private String bearNum;
	
    /** 孕产保健次数 **/ 
	private String healthcareNum;
	
    /** 家族史为其他（3）时填写 **/ 
	private String famHistoryOthers;
	
    /** 0：否，1：是 **/ 
	private String checkHepatitis;
	
    /** 0：阴性，1：阳性 **/ 
	private String antigenHepatitis;
	
    /** 0：否，1：是 **/ 
	private String checkSyphilis;
	
    /** 0：否，1：是 **/ 
	private String infectedSyphilis;
	
    /** 0：否，1：是 **/ 
	private String checkAids;
	
    /** 0：否，1：是 **/ 
	private String infectedAids;
	
    /** 0：否，1：是 **/ 
	private String checkHemoglobin;
	
    /** 0：否，1：是 **/ 
	private String anemia;
	
    /** 0：无
            1：遗传性疾病史
            2：精神疾病史
            3：其它
            多个使用;号分隔 **/ 
	private String famHistory;
	
    /** 0：否，1：是 **/ 
	private String relativesMating;
	
    /** 家族遗传病 **/ 
	private String geneticIll;
	
	/** 编辑状态 **/ 
	private String editStatus;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	/** 0:非正常数据，1：正常数据 **/ 
	private String normalSign;
	
	private OperatorPO operatorPO;
	
	private ChildbirthReferralInfoPO childbirthReferralInfoPO;
	
	public ChildbirthReferralInfoPO getChildbirthReferralInfoPO() {
		return childbirthReferralInfoPO;
	}

	public void setChildbirthReferralInfoPO(ChildbirthReferralInfoPO childbirthReferralInfoPO) {
		this.childbirthReferralInfoPO = childbirthReferralInfoPO;
	}

	public OperatorPO getOperatorPO() {
		return operatorPO;
	}

	public void setOperatorPO(OperatorPO operatorPO) {
		this.operatorPO = operatorPO;
	}

	/**
	 * 构造 
	 */
	public ChildbirthBasicInfoPO() {
	}
	
	public ChildbirthBasicInfoPO( String id,  String birthArchivesId, String doctorId, Date birthDate, String hospitalCode, Date leaveDate, Date lastMenses, String gestationalWeek, String gestationalDay, String pregnancyNum, String bearNum, String healthcareNum, String famHistoryOthers, String checkHepatitis, String antigenHepatitis, String checkSyphilis, String infectedSyphilis, String checkAids, String infectedAids, String checkHemoglobin, String anemia, String famHistory, String relativesMating, String geneticIll, String editStatus,Date creatTime, Date updateTime,String normalSign) {
				this.birthArchivesId = birthArchivesId;
				this.doctorId = doctorId;
				this.birthDate = birthDate;
				this.hospitalCode = hospitalCode;
				this.leaveDate = leaveDate;
				this.lastMenses = lastMenses;
				this.gestationalWeek = gestationalWeek;
				this.gestationalDay = gestationalDay;
				this.pregnancyNum = pregnancyNum;
				this.bearNum = bearNum;
				this.healthcareNum = healthcareNum;
				this.famHistoryOthers = famHistoryOthers;
				this.checkHepatitis = checkHepatitis;
				this.antigenHepatitis = antigenHepatitis;
				this.checkSyphilis = checkSyphilis;
				this.infectedSyphilis = infectedSyphilis;
				this.checkAids = checkAids;
				this.infectedAids = infectedAids;
				this.checkHemoglobin = checkHemoglobin;
				this.anemia = anemia;
				this.famHistory = famHistory;
				this.relativesMating = relativesMating;
				this.geneticIll = geneticIll;
				this.editStatus=editStatus;
				this.creatTime = creatTime;
				this.updateTime = updateTime;
				this.normalSign=normalSign;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirthArchivesId() {
		return birthArchivesId;
	}

	public void setBirthArchivesId(String birthArchivesId) {
		this.birthArchivesId = birthArchivesId;
	}
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Date getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(Date lastMenses) {
		this.lastMenses = lastMenses;
	}
	public String getGestationalWeek() {
		return gestationalWeek;
	}

	public void setGestationalWeek(String gestationalWeek) {
		this.gestationalWeek = gestationalWeek;
	}
	public String getGestationalDay() {
		return gestationalDay;
	}

	public void setGestationalDay(String gestationalDay) {
		this.gestationalDay = gestationalDay;
	}
	public String getPregnancyNum() {
		return pregnancyNum;
	}

	public void setPregnancyNum(String pregnancyNum) {
		this.pregnancyNum = pregnancyNum;
	}
	public String getBearNum() {
		return bearNum;
	}

	public void setBearNum(String bearNum) {
		this.bearNum = bearNum;
	}
	public String getHealthcareNum() {
		return healthcareNum;
	}

	public void setHealthcareNum(String healthcareNum) {
		this.healthcareNum = healthcareNum;
	}
	public String getFamHistoryOthers() {
		return famHistoryOthers;
	}

	public void setFamHistoryOthers(String famHistoryOthers) {
		this.famHistoryOthers = famHistoryOthers;
	}
	public String getCheckHepatitis() {
		return checkHepatitis;
	}

	public void setCheckHepatitis(String checkHepatitis) {
		this.checkHepatitis = checkHepatitis;
	}
	public String getAntigenHepatitis() {
		return antigenHepatitis;
	}

	public void setAntigenHepatitis(String antigenHepatitis) {
		this.antigenHepatitis = antigenHepatitis;
	}
	public String getCheckSyphilis() {
		return checkSyphilis;
	}

	public void setCheckSyphilis(String checkSyphilis) {
		this.checkSyphilis = checkSyphilis;
	}
	public String getInfectedSyphilis() {
		return infectedSyphilis;
	}

	public void setInfectedSyphilis(String infectedSyphilis) {
		this.infectedSyphilis = infectedSyphilis;
	}
	public String getCheckAids() {
		return checkAids;
	}

	public void setCheckAids(String checkAids) {
		this.checkAids = checkAids;
	}
	public String getInfectedAids() {
		return infectedAids;
	}

	public void setInfectedAids(String infectedAids) {
		this.infectedAids = infectedAids;
	}
	public String getCheckHemoglobin() {
		return checkHemoglobin;
	}

	public void setCheckHemoglobin(String checkHemoglobin) {
		this.checkHemoglobin = checkHemoglobin;
	}
	public String getAnemia() {
		return anemia;
	}

	public void setAnemia(String anemia) {
		this.anemia = anemia;
	}
	public String getFamHistory() {
		return famHistory;
	}

	public void setFamHistory(String famHistory) {
		this.famHistory = famHistory;
	}
	public String getRelativesMating() {
		return relativesMating;
	}

	public void setRelativesMating(String relativesMating) {
		this.relativesMating = relativesMating;
	}
	public String getGeneticIll() {
		return geneticIll;
	}

	public void setGeneticIll(String geneticIll) {
		this.geneticIll = geneticIll;
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

	public String getNormalSign() {
		return normalSign;
	}

	public void setNormalSign(String normalSign) {
		this.normalSign = normalSign;
	}

}