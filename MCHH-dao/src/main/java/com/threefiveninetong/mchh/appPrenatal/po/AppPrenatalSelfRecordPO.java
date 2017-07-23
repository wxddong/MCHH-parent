/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalSelfRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppPrenatalSelfRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public class AppPrenatalSelfRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 会员ID **/ 
	private String mbrId;
	
    /** 末次月经 **/ 
	private Date lastMenses;
	
    /** 预产期 **/ 
	private Date predictDate;
	
    /** 首次胎动日期 **/ 
	private Date firstMoveDate;
	
    /** B超检查日期 **/ 
	private Date bExaDate;
	
    /** 0：否，1：是 **/ 
	private String testMoveSign;
	
    /** 0：超重 1：正常 2：不足 **/ 
	private String growthRange;
	
    /** 0：否，1：是，默认为0 **/ 
	private String riskSign;
	
    /** 高危标识为1（是）才填写 **/ 
	private String riskRemark;
	
    /** 0：孕1-3月，1：孕4-7月，2：孕8-10月 **/ 
	private String period;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppPrenatalSelfRecordPO() {
	}
	
	public AppPrenatalSelfRecordPO( String id,  String mbrId, Date lastMenses, Date predictDate, Date firstMoveDate, Date bExaDate, String testMoveSign, String growthRange, String riskSign, String riskRemark, String period, Date createTime, Date updateTime) {
				this.mbrId = mbrId;
				this.lastMenses = lastMenses;
				this.predictDate = predictDate;
				this.firstMoveDate = firstMoveDate;
				this.bExaDate = bExaDate;
				this.testMoveSign = testMoveSign;
				this.growthRange = growthRange;
				this.riskSign = riskSign;
				this.riskRemark = riskRemark;
				this.period = period;
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

	public String getMbrId() {
		return mbrId;
	}

	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
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
	public Date getFirstMoveDate() {
		return firstMoveDate;
	}

	public void setFirstMoveDate(Date firstMoveDate) {
		this.firstMoveDate = firstMoveDate;
	}
	public Date getBExaDate() {
		return bExaDate;
	}

	public void setBExaDate(Date bExaDate) {
		this.bExaDate = bExaDate;
	}
	public String getTestMoveSign() {
		return testMoveSign;
	}

	public void setTestMoveSign(String testMoveSign) {
		this.testMoveSign = testMoveSign;
	}
	public String getGrowthRange() {
		return growthRange;
	}

	public void setGrowthRange(String growthRange) {
		this.growthRange = growthRange;
	}
	public String getRiskSign() {
		return riskSign;
	}

	public void setRiskSign(String riskSign) {
		this.riskSign = riskSign;
	}
	public String getRiskRemark() {
		return riskRemark;
	}

	public void setRiskRemark(String riskRemark) {
		this.riskRemark = riskRemark;
	}
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
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