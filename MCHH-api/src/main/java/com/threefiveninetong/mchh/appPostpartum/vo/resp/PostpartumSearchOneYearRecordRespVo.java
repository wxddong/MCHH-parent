package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期一岁龄记录
 * @author zhanght
 */
public class PostpartumSearchOneYearRecordRespVo extends BaseVo {
	
	//每天吃饭次数
	private String mealNum = "";
	
	//出牙数
	private String toothNum = "";
	
	//吃饭情况
	private String mealSituation = "";
	
	//是否继续母乳
	private String breastMilk = "";
	
	//呼唤名字有反应
	private String nameReaction = "";
	
	//模仿再见欢迎
	private String imitate = "";
	
	//会捏小物品
	private String pinchThing = "";
	
	//会扶物站立
	private String standingUp = "";

	public String getMealNum() {
		return mealNum;
	}

	public void setMealNum(String mealNum) {
		this.mealNum = mealNum;
	}

	public String getToothNum() {
		return toothNum;
	}

	public void setToothNum(String toothNum) {
		this.toothNum = toothNum;
	}

	public String getMealSituation() {
		return mealSituation;
	}

	public void setMealSituation(String mealSituation) {
		this.mealSituation = mealSituation;
	}

	public String getBreastMilk() {
		return breastMilk;
	}

	public void setBreastMilk(String breastMilk) {
		this.breastMilk = breastMilk;
	}

	public String getNameReaction() {
		return nameReaction;
	}

	public void setNameReaction(String nameReaction) {
		this.nameReaction = nameReaction;
	}

	public String getImitate() {
		return imitate;
	}

	public void setImitate(String imitate) {
		this.imitate = imitate;
	}

	public String getPinchThing() {
		return pinchThing;
	}

	public void setPinchThing(String pinchThing) {
		this.pinchThing = pinchThing;
	}

	public String getStandingUp() {
		return standingUp;
	}

	public void setStandingUp(String standingUp) {
		this.standingUp = standingUp;
	}
}
