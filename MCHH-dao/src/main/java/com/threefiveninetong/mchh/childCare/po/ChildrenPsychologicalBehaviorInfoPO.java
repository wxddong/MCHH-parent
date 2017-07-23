/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPsychologicalBehaviorInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:05 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: ChildrenPsychologicalBehaviorInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
public class ChildrenPsychologicalBehaviorInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 健康检查表ID **/ 
	private String healthExaId;
	
    /** 0：否，1：是 **/ 
	private String clothesOffMove;
	
    /** 0：否，1：是 **/ 
	private String bellActivityDecrease;
	
    /** 0：否，1：是 **/ 
	private String actionSymmetric;
	
    /** 0：否，1：是 **/ 
	private String carefulFaceObject;
	

	/**
	 * 构造 
	 */
	public ChildrenPsychologicalBehaviorInfoPO() {
	}
	
	public ChildrenPsychologicalBehaviorInfoPO( String id,  String healthExaId, String clothesOffMove, String bellActivityDecrease, String actionSymmetric, String carefulFaceObject) {
				this.healthExaId = healthExaId;
				this.clothesOffMove = clothesOffMove;
				this.bellActivityDecrease = bellActivityDecrease;
				this.actionSymmetric = actionSymmetric;
				this.carefulFaceObject = carefulFaceObject;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHealthExaId() {
		return healthExaId;
	}

	public void setHealthExaId(String healthExaId) {
		this.healthExaId = healthExaId;
	}
	public String getClothesOffMove() {
		return clothesOffMove;
	}

	public void setClothesOffMove(String clothesOffMove) {
		this.clothesOffMove = clothesOffMove;
	}
	public String getBellActivityDecrease() {
		return bellActivityDecrease;
	}

	public void setBellActivityDecrease(String bellActivityDecrease) {
		this.bellActivityDecrease = bellActivityDecrease;
	}
	public String getActionSymmetric() {
		return actionSymmetric;
	}

	public void setActionSymmetric(String actionSymmetric) {
		this.actionSymmetric = actionSymmetric;
	}
	public String getCarefulFaceObject() {
		return carefulFaceObject;
	}

	public void setCarefulFaceObject(String carefulFaceObject) {
		this.carefulFaceObject = carefulFaceObject;
	}

}