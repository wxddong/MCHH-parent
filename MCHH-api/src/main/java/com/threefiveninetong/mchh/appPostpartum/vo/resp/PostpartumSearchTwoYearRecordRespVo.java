package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期两岁龄记录
 * @author zhanght
 */
public class PostpartumSearchTwoYearRecordRespVo extends BaseVo {
	
	//每天吃乳量
	private String milkAmount = "";
	
	//每天吃肉次数
	private String meatAmount = "";
	
	//饭后会漱口
	private String gargle = "";
	
	//每天吃蔬菜
	private String eatVegetables = "";
	
	//教孩子握笔画画
	private String teachWobiDraw = "";
	
	//会说三个物品
	private String sayThreeGoods = "";
	
	//按吩咐做简单事
	private String doSimpleThings = "";
	
	//用勺吃饭
	private String spoonMeal = "";
	
	//扶栏上楼梯
	private String holdClimbStairs = "";

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
