/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingTwoYearRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppParentingTwoYearRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingTwoYearRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 每天吃乳量 **/ 
	private String milkAmount;
	
    /** 每天吃肉次数 **/ 
	private String meatAmount;
	
    /** 0：否，1：是 **/ 
	private String gargle;
	
    /** 0：否，1：是 **/ 
	private String eatVegetables;
	
    /** 0：否，1：是 **/ 
	private String teachWobiDraw;
	
    /** 0：否，1：是 **/ 
	private String sayThreeGoods;
	
    /** 0：否，1：是 **/ 
	private String doSimpleThings;
	
    /** 0：否，1：是 **/ 
	private String spoonMeal;
	
    /** 0：否，1：是 **/ 
	private String holdClimbStairs;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingTwoYearRecordPO() {
	}
	
	public AppParentingTwoYearRecordPO( String id,  String parId, String milkAmount, String meatAmount, String gargle, String eatVegetables, String teachWobiDraw, String sayThreeGoods, String doSimpleThings, String spoonMeal, String holdClimbStairs, Date createTime, Date updateTime) {
				this.parId = parId;
				this.milkAmount = milkAmount;
				this.meatAmount = meatAmount;
				this.gargle = gargle;
				this.eatVegetables = eatVegetables;
				this.teachWobiDraw = teachWobiDraw;
				this.sayThreeGoods = sayThreeGoods;
				this.doSimpleThings = doSimpleThings;
				this.spoonMeal = spoonMeal;
				this.holdClimbStairs = holdClimbStairs;
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

	public String getParId() {
		return parId;
	}

	public void setParId(String parId) {
		this.parId = parId;
	}
	public String getMilkAmount() {
		return milkAmount;
	}

	public void setMilkAmount(String milkAmount) {
		this.milkAmount = milkAmount;
	}
	public String getMeatAmount() {
		return meatAmount;
	}

	public void setMeatAmount(String meatAmount) {
		this.meatAmount = meatAmount;
	}
	public String getGargle() {
		return gargle;
	}

	public void setGargle(String gargle) {
		this.gargle = gargle;
	}
	public String getEatVegetables() {
		return eatVegetables;
	}

	public void setEatVegetables(String eatVegetables) {
		this.eatVegetables = eatVegetables;
	}
	public String getTeachWobiDraw() {
		return teachWobiDraw;
	}

	public void setTeachWobiDraw(String teachWobiDraw) {
		this.teachWobiDraw = teachWobiDraw;
	}
	public String getSayThreeGoods() {
		return sayThreeGoods;
	}

	public void setSayThreeGoods(String sayThreeGoods) {
		this.sayThreeGoods = sayThreeGoods;
	}
	public String getDoSimpleThings() {
		return doSimpleThings;
	}

	public void setDoSimpleThings(String doSimpleThings) {
		this.doSimpleThings = doSimpleThings;
	}
	public String getSpoonMeal() {
		return spoonMeal;
	}

	public void setSpoonMeal(String spoonMeal) {
		this.spoonMeal = spoonMeal;
	}
	public String getHoldClimbStairs() {
		return holdClimbStairs;
	}

	public void setHoldClimbStairs(String holdClimbStairs) {
		this.holdClimbStairs = holdClimbStairs;
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