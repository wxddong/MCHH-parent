package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期一岁龄记录
 * @author zhanght
 */
public class PostpartumOneYearRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//每天吃饭次数
	private String mealNum;
	
	//出牙数
	private String toothNum;
	
	//吃饭情况  0-不好  1-好
	private String mealSituation;
	
	//是否继续母乳  0-否  1-是
	private String breastMilk;
	
	//呼唤名字有反应  0-否  1-是
	private String nameReaction;
	
	//模仿再见欢迎  0-否  1-是
	private String imitate;
	
	//会捏小物品  0-否  1-是
	private String pinchThing;
	
	//会扶物站立  0-否  1-是
	private String standingUp;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

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
