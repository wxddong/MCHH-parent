/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childbirth.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:04 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: ChildbirthInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:04 
 */
public class ChildbirthInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 分娩基本信息表ID **/ 
	private String basicId;
	
    /** 分娩地点，医院ID或填写的文本 **/ 
	private String childbirthPlace;
	
    /** 第一产程小时 **/ 
	private String firstHour;
	
    /** 第二产程小时 **/ 
	private String secondHour;
	
    /** 第三产程小时 **/ 
	private String thirdHour;
	
    /** 总产程小时 **/ 
	private String totalHour;
	
    /** 第一产程分钟 **/ 
	private String firstMinute;
	
    /** 第二产程分钟 **/ 
	private String secondMinute;
	
    /** 第三产程分钟 **/ 
	private String thirdMinute;
	
    /** 总产程分钟 **/ 
	private String totalMinute;
	
    /** 胎盘 **/ 
	private String placenta;
	
    /** 会阴侧切 **/ 
	private String perineumCut;
	
    /** 伤裂程度 **/ 
	private String injuryDegree;
	
    /** 产时出血量 **/ 
	private String bearBleeding;
	
    /** 产后2小时 **/ 
	private String afterbearTwo;
	
    /** 总出血量 **/ 
	private String totalBleeding;
	
    /** 羊水性状 **/ 
	private String amnioticFluidTrait;
	
	/** 羊水性状备注 **/ 
	private String amnioticFluidRemark;
	
    /** 羊水量 **/ 
	private String amnioticFluidAmount;
	
    /** 胎数 **/ 
	private String fetalNum;
	
    /** 产妇 **/ 
	private String puerpera;
	
    /** 产妇死亡原因 **/ 
	private String puerperaDieReason;
	
    /** 婴儿 **/ 
	private String baby;
	

	/**
	 * 构造 
	 */
	public ChildbirthInfoPO() {
	}
	
	public ChildbirthInfoPO( String id,  String basicId, String childbirthPlace, String firstHour, String secondHour, String thirdHour, String totalHour, String firstMinute, String secondMinute, String thirdMinute, String totalMinute, String placenta, String perineumCut, String injuryDegree, String bearBleeding, String afterbearTwo, String totalBleeding, String amnioticFluidTrait,String amnioticFluidRemark,String amnioticFluidAmount, String fetalNum, String puerpera, String puerperaDieReason, String baby) {
				this.basicId = basicId;
				this.childbirthPlace = childbirthPlace;
				this.firstHour = firstHour;
				this.secondHour = secondHour;
				this.thirdHour = thirdHour;
				this.totalHour = totalHour;
				this.firstMinute = firstMinute;
				this.secondMinute = secondMinute;
				this.thirdMinute = thirdMinute;
				this.totalMinute = totalMinute;
				this.placenta = placenta;
				this.perineumCut = perineumCut;
				this.injuryDegree = injuryDegree;
				this.bearBleeding = bearBleeding;
				this.afterbearTwo = afterbearTwo;
				this.totalBleeding = totalBleeding;
				this.amnioticFluidTrait = amnioticFluidTrait;
				this.amnioticFluidRemark=amnioticFluidRemark;
				this.amnioticFluidAmount = amnioticFluidAmount;
				this.fetalNum = fetalNum;
				this.puerpera = puerpera;
				this.puerperaDieReason = puerperaDieReason;
				this.baby = baby;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBasicId() {
		return basicId;
	}

	public void setBasicId(String basicId) {
		this.basicId = basicId;
	}
	public String getChildbirthPlace() {
		return childbirthPlace;
	}

	public void setChildbirthPlace(String childbirthPlace) {
		this.childbirthPlace = childbirthPlace;
	}
	public String getFirstHour() {
		return firstHour;
	}

	public void setFirstHour(String firstHour) {
		this.firstHour = firstHour;
	}
	public String getSecondHour() {
		return secondHour;
	}

	public void setSecondHour(String secondHour) {
		this.secondHour = secondHour;
	}
	public String getThirdHour() {
		return thirdHour;
	}

	public void setThirdHour(String thirdHour) {
		this.thirdHour = thirdHour;
	}
	public String getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(String totalHour) {
		this.totalHour = totalHour;
	}
	public String getFirstMinute() {
		return firstMinute;
	}

	public void setFirstMinute(String firstMinute) {
		this.firstMinute = firstMinute;
	}
	public String getSecondMinute() {
		return secondMinute;
	}

	public void setSecondMinute(String secondMinute) {
		this.secondMinute = secondMinute;
	}
	public String getThirdMinute() {
		return thirdMinute;
	}

	public void setThirdMinute(String thirdMinute) {
		this.thirdMinute = thirdMinute;
	}
	public String getTotalMinute() {
		return totalMinute;
	}

	public void setTotalMinute(String totalMinute) {
		this.totalMinute = totalMinute;
	}
	public String getPlacenta() {
		return placenta;
	}

	public void setPlacenta(String placenta) {
		this.placenta = placenta;
	}
	public String getPerineumCut() {
		return perineumCut;
	}

	public void setPerineumCut(String perineumCut) {
		this.perineumCut = perineumCut;
	}
	public String getInjuryDegree() {
		return injuryDegree;
	}

	public void setInjuryDegree(String injuryDegree) {
		this.injuryDegree = injuryDegree;
	}
	public String getBearBleeding() {
		return bearBleeding;
	}

	public void setBearBleeding(String bearBleeding) {
		this.bearBleeding = bearBleeding;
	}
	public String getAfterbearTwo() {
		return afterbearTwo;
	}

	public void setAfterbearTwo(String afterbearTwo) {
		this.afterbearTwo = afterbearTwo;
	}
	public String getTotalBleeding() {
		return totalBleeding;
	}

	public void setTotalBleeding(String totalBleeding) {
		this.totalBleeding = totalBleeding;
	}
	public String getAmnioticFluidTrait() {
		return amnioticFluidTrait;
	}

	public void setAmnioticFluidTrait(String amnioticFluidTrait) {
		this.amnioticFluidTrait = amnioticFluidTrait;
	}
	
	public String getAmnioticFluidRemark() {
		return amnioticFluidRemark;
	}

	public void setAmnioticFluidRemark(String amnioticFluidRemark) {
		this.amnioticFluidRemark = amnioticFluidRemark;
	}

	public String getAmnioticFluidAmount() {
		return amnioticFluidAmount;
	}

	public void setAmnioticFluidAmount(String amnioticFluidAmount) {
		this.amnioticFluidAmount = amnioticFluidAmount;
	}
	public String getFetalNum() {
		return fetalNum;
	}

	public void setFetalNum(String fetalNum) {
		this.fetalNum = fetalNum;
	}
	public String getPuerpera() {
		return puerpera;
	}

	public void setPuerpera(String puerpera) {
		this.puerpera = puerpera;
	}
	public String getPuerperaDieReason() {
		return puerperaDieReason;
	}

	public void setPuerperaDieReason(String puerperaDieReason) {
		this.puerperaDieReason = puerperaDieReason;
	}
	public String getBaby() {
		return baby;
	}

	public void setBaby(String baby) {
		this.baby = baby;
	}

}