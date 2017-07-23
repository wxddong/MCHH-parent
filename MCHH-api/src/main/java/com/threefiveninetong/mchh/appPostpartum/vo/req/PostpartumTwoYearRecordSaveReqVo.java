package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期两岁龄记录
 * @author zhanght
 */
public class PostpartumTwoYearRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//每天吃乳量
	private String milkAmount;
	
	//每天吃肉次数
	private String meatAmount;
	
	//饭后会漱口 0-否  1-是
	private String gargle;
	
	//每天吃蔬菜 0-否  1-是
	private String eatVegetables;
	
	//教孩子握笔画画 0-否  1-是
	private String teachWobiDraw;
	
	//会说三个物品 0-否  1-是
	private String sayThreeGoods;
	
	//按吩咐做简单事 0-否  1-是
	private String doSimpleThings;
	
	//用勺吃饭 0-否  1-是
	private String spoonMeal;
	
	//扶栏上楼梯  0-否  1-是
	private String holdClimbStairs;
	
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
}
