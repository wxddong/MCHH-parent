package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期三岁龄记录
 * @author zhanght
 */
public class PostpartumSearchThreeYearRecordRespVo extends BaseVo {
	
	//幼儿园
	private String kindergarten = "";
	
	//咀嚼习惯
	private String chewingHabit = "";
	
	//睡前刷牙
	private String sleepBrushTooth = "";
	
	//饭前洗手
	private String mealWashHand = "";
	
	//看东西眯眼
	private String squinting = "";
	
	//说自己名字
	private String ownName = "";
	
	//假想游戏
	private String pretendPlay = "";
	
	//模仿画圆
	private String imitateDrawCircle = "";
	
	//双脚跳
	private String doubleJump = "";

	public String getKindergarten() {
		return kindergarten;
	}

	public String getChewingHabit() {
		return chewingHabit;
	}

	public String getSleepBrushTooth() {
		return sleepBrushTooth;
	}

	public String getMealWashHand() {
		return mealWashHand;
	}

	public String getSquinting() {
		return squinting;
	}

	public String getOwnName() {
		return ownName;
	}

	public String getPretendPlay() {
		return pretendPlay;
	}

	public String getImitateDrawCircle() {
		return imitateDrawCircle;
	}

	public String getDoubleJump() {
		return doubleJump;
	}

	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}

	public void setChewingHabit(String chewingHabit) {
		this.chewingHabit = chewingHabit;
	}

	public void setSleepBrushTooth(String sleepBrushTooth) {
		this.sleepBrushTooth = sleepBrushTooth;
	}

	public void setMealWashHand(String mealWashHand) {
		this.mealWashHand = mealWashHand;
	}

	public void setSquinting(String squinting) {
		this.squinting = squinting;
	}

	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}

	public void setPretendPlay(String pretendPlay) {
		this.pretendPlay = pretendPlay;
	}

	public void setImitateDrawCircle(String imitateDrawCircle) {
		this.imitateDrawCircle = imitateDrawCircle;
	}

	public void setDoubleJump(String doubleJump) {
		this.doubleJump = doubleJump;
	}
}
