/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: BirthArchivesInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.archives.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:42 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;

/**
 * @ClassName: BirthArchivesInfoPO
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:42
 */
public class BirthArchivesInfoPO implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;

	/** 主键ID **/
	private String id;

	/** 档案ID **/
	private String archivesId;
	
	/** 建档医院ID **/
	private String hospitalId;

	/** 0：未发放，1：已发放 **/
	private String grantSign;

	/** 0：表示未发放 **/
	private String frantNum;
	
	/** 末次月经 **/ 
	private Date lastMenses;
	
	/**预产期**/
	private Date predictDate;

	/** 0：妊娠中，1：已分娩，2：转诊，3：已结案 **/
	private String pregnantState;

	/** 结案原因 **/
	private String closingReason;

	/** 结案日期 **/
	private Date closingDate;

	/** 高危标识 **/
	private String riskSign;

	/** 转诊标识 **/
	private String referralSign;
	
	/** 转出医院ID **/
	private String outHospitalId;
	
	/** 转入医院ID **/
	private String inHospitalId;
	
	/** 转诊时间 **/
	private Date referralTime;

	/** 创建时间 **/
	private Date creatTime;

	/** 最后修改时间 **/
	private Date updateTime;
	
	/**第一次筛查出高危项的日期**/
	private Date screeningDate;
	
    /** 删除标识 **/ 
	private String deltetSign;
	

	private ArchivesInfoPO archivesInfoPO;

	private ChildbirthBasicInfoPO childbirthBasicInfoPO;
	
	private PostpartumExaInfoPO postpartumExaInfoPO;
	
	public PostpartumExaInfoPO getPostpartumExaInfoPO() {
		return postpartumExaInfoPO;
	}

	public void setPostpartumExaInfoPO(PostpartumExaInfoPO postpartumExaInfoPO) {
		this.postpartumExaInfoPO = postpartumExaInfoPO;
	}

	public ChildbirthBasicInfoPO getChildbirthBasicInfoPO() {
		return childbirthBasicInfoPO;
	}

	public void setChildbirthBasicInfoPO(ChildbirthBasicInfoPO childbirthBasicInfoPO) {
		this.childbirthBasicInfoPO = childbirthBasicInfoPO;
	}

	/**
	 * 构造
	 */
	public BirthArchivesInfoPO() {
	}

	public ArchivesInfoPO getArchivesInfoPO() {
		return archivesInfoPO;
	}

	public void setArchivesInfoPO(ArchivesInfoPO archivesInfoPO) {
		this.archivesInfoPO = archivesInfoPO;
	}

	public BirthArchivesInfoPO(String id, String archivesId,String hospitalId,String grantSign, String frantNum, Date lastMenses,Date predictDate,String pregnantState,
			String closingReason, Date closingDate, String riskSign, String referralSign,String outHospitalId,String inHospitalId,Date referralTime, Date creatTime,
			Date updateTime,String deltetSign) {
		this.archivesId = archivesId;
		this.hospitalId=hospitalId;
		this.grantSign = grantSign; 
		this.frantNum = frantNum;
		this.lastMenses=lastMenses;
		this.predictDate=predictDate;
		this.pregnantState = pregnantState;
		this.closingReason = closingReason;
		this.closingDate = closingDate;
		this.riskSign = riskSign;
		this.referralSign = referralSign;
		this.outHospitalId=outHospitalId;
		this.inHospitalId=inHospitalId;
		this.referralTime=referralTime;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		this.deltetSign=deltetSign;
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

	public String getGrantSign() {
		return grantSign;
	}

	public void setGrantSign(String grantSign) {
		this.grantSign = grantSign;
	}

	public String getFrantNum() {
		return frantNum;
	}

	public void setFrantNum(String frantNum) {
		this.frantNum = frantNum;
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

	public String getPregnantState() {
		return pregnantState;
	}

	public void setPregnantState(String pregnantState) {
		this.pregnantState = pregnantState;
	}

	public String getClosingReason() {
		return closingReason;
	}

	public void setClosingReason(String closingReason) {
		this.closingReason = closingReason;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getRiskSign() {
		return riskSign;
	}

	public void setRiskSign(String riskSign) {
		this.riskSign = riskSign;
	}

	public String getReferralSign() {
		return referralSign;
	}

	public void setReferralSign(String referralSign) {
		this.referralSign = referralSign;
	}

	public String getOutHospitalId() {
		return outHospitalId;
	}

	public void setOutHospitalId(String outHospitalId) {
		this.outHospitalId = outHospitalId;
	}

	public String getInHospitalId() {
		return inHospitalId;
	}

	public void setInHospitalId(String inHospitalId) {
		this.inHospitalId = inHospitalId;
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

	public Date getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(Date screeningDate) {
		this.screeningDate = screeningDate;
	}
	
	
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Date getReferralTime() {
		return referralTime;
	}

	public void setReferralTime(Date referralTime) {
		this.referralTime = referralTime;
	}

	public String getDeltetSign() {
		return deltetSign;
	}

	public void setDeltetSign(String deltetSign) {
		this.deltetSign = deltetSign;
	}

	public void saveBirthArchivesToUpdate(BirthArchivesInfoPO birthArchivesInfoPO) {
		// TODO Auto-generated method stub
		
	}

	
}