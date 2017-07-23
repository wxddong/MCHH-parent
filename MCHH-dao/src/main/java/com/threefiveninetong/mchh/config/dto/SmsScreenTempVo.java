package com.threefiveninetong.mchh.config.dto;

import java.util.Date;

public class SmsScreenTempVo {
	//产前检查ID
	private String id;
	
	//产前检查表中的生育档案ID
	private String birthArchivesId;
	
	//孕妇档案预留电话
	private String telephone;
	
	//是否预约下次产检0：否，1;是
	private String orderCheck;
	
	//下次预约时间
	private Date nextFollowingDate;
	
	//末次月经
	private Date lastMenses;
	
	//高危项串
	private String highRisk;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOrderCheck() {
		return orderCheck;
	}

	public void setOrderCheck(String orderCheck) {
		this.orderCheck = orderCheck;
	}

	public Date getNextFollowingDate() {
		return nextFollowingDate;
	}

	public void setNextFollowingDate(Date nextFollowingDate) {
		this.nextFollowingDate = nextFollowingDate;
	}

	public Date getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(Date lastMenses) {
		this.lastMenses = lastMenses;
	}

	public String getHighRisk() {
		return highRisk;
	}

	public void setHighRisk(String highRisk) {
		this.highRisk = highRisk;
	}

}
