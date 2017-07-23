/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBabyInfoPO.java
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
 * @ClassName: ChildbirthBabyInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:04 
 */
public class ChildbirthBabyInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 分娩表ID **/ 
	private String childbirthId;
	
    /** 胎位 **/ 
	private String fetusPosition;
	
    /** 分娩时间 **/ 
	private String deliveryHour;
	
    /** 分娩时间 **/ 
	private String deliveryMinute;
	
    /** 引产 **/ 
	private String inducelabour;
	
    /** 分娩方式 **/ 
	private String deliveryType;
	
    /** 剖宫产指征 **/ 
	private String cesareanIdicatio;
	
    /** 婴儿姓名 **/ 
	private String babyName;
	
    /** 0：男，1：女 **/ 
	private String babySex;
	
    /** 健康情况 **/ 
	private String health;
	
    /** 健康情况备注 **/ 
	private String healthRemark;
	
    /** 胎儿畸形 **/ 
	private String fetalAnomaly;
	
    /** 畸形部位 **/ 
	private String abnormalPosition;
	
    /** 畸形名称 **/ 
	private String abnormalName;
	
    /** 1分钟评分 **/ 
	private String oneMinScore;
	
    /** 5分钟评分 **/ 
	private String fiveMinScore;
	
    /** 出生体重 **/ 
	private String bornWeight;
	
    /** 身长 **/ 
	private String bodyLenght;
	
    /** 0：卡介苗
            1：乙肝疫苗
            2：早吸吮
            多个使用;号分隔
             **/ 
	private String vaccine;
	
    /** 胎儿死亡 **/ 
	private String fetusDie;
	
    /** 接生者 **/ 
	private String midwife;
	

	/**
	 * 构造 
	 */
	public ChildbirthBabyInfoPO() {
	}
	
	public ChildbirthBabyInfoPO( String id,  String childbirthId, String fetusPosition, String deliveryHour, String deliveryMinute, String inducelabour, String deliveryType, String cesareanIdicatio, String babyName, String babySex, String health, String healthRemark, String fetalAnomaly, String abnormalPosition, String abnormalName, String oneMinScore, String fiveMinScore, String bornWeight, String bodyLenght, String vaccine, String fetusDie, String midwife) {
				this.childbirthId = childbirthId;
				this.fetusPosition = fetusPosition;
				this.deliveryHour = deliveryHour;
				this.deliveryMinute = deliveryMinute;
				this.inducelabour = inducelabour;
				this.deliveryType = deliveryType;
				this.cesareanIdicatio = cesareanIdicatio;
				this.babyName = babyName;
				this.babySex = babySex;
				this.health = health;
				this.healthRemark = healthRemark;
				this.fetalAnomaly = fetalAnomaly;
				this.abnormalPosition = abnormalPosition;
				this.abnormalName = abnormalName;
				this.oneMinScore = oneMinScore;
				this.fiveMinScore = fiveMinScore;
				this.bornWeight = bornWeight;
				this.bodyLenght = bodyLenght;
				this.vaccine = vaccine;
				this.fetusDie = fetusDie;
				this.midwife = midwife;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChildbirthId() {
		return childbirthId;
	}

	public void setChildbirthId(String childbirthId) {
		this.childbirthId = childbirthId;
	}
	public String getFetusPosition() {
		return fetusPosition;
	}

	public void setFetusPosition(String fetusPosition) {
		this.fetusPosition = fetusPosition;
	}
	public String getDeliveryHour() {
		return deliveryHour;
	}

	public void setDeliveryHour(String deliveryHour) {
		this.deliveryHour = deliveryHour;
	}
	public String getDeliveryMinute() {
		return deliveryMinute;
	}

	public void setDeliveryMinute(String deliveryMinute) {
		this.deliveryMinute = deliveryMinute;
	}
	public String getInducelabour() {
		return inducelabour;
	}

	public void setInducelabour(String inducelabour) {
		this.inducelabour = inducelabour;
	}
	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getCesareanIdicatio() {
		return cesareanIdicatio;
	}

	public void setCesareanIdicatio(String cesareanIdicatio) {
		this.cesareanIdicatio = cesareanIdicatio;
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
	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}
	public String getHealthRemark() {
		return healthRemark;
	}

	public void setHealthRemark(String healthRemark) {
		this.healthRemark = healthRemark;
	}
	public String getFetalAnomaly() {
		return fetalAnomaly;
	}

	public void setFetalAnomaly(String fetalAnomaly) {
		this.fetalAnomaly = fetalAnomaly;
	}
	public String getAbnormalPosition() {
		return abnormalPosition;
	}

	public void setAbnormalPosition(String abnormalPosition) {
		this.abnormalPosition = abnormalPosition;
	}
	public String getAbnormalName() {
		return abnormalName;
	}

	public void setAbnormalName(String abnormalName) {
		this.abnormalName = abnormalName;
	}
	public String getOneMinScore() {
		return oneMinScore;
	}

	public void setOneMinScore(String oneMinScore) {
		this.oneMinScore = oneMinScore;
	}
	public String getFiveMinScore() {
		return fiveMinScore;
	}

	public void setFiveMinScore(String fiveMinScore) {
		this.fiveMinScore = fiveMinScore;
	}
	public String getBornWeight() {
		return bornWeight;
	}

	public void setBornWeight(String bornWeight) {
		this.bornWeight = bornWeight;
	}
	public String getBodyLenght() {
		return bodyLenght;
	}

	public void setBodyLenght(String bodyLenght) {
		this.bodyLenght = bodyLenght;
	}
	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public String getFetusDie() {
		return fetusDie;
	}

	public void setFetusDie(String fetusDie) {
		this.fetusDie = fetusDie;
	}
	public String getMidwife() {
		return midwife;
	}

	public void setMidwife(String midwife) {
		this.midwife = midwife;
	}

}