package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期三岁龄记录
 * @author zhanght
 */
public class PostpartumThreeYearRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//幼儿园0：未入  1：日托 2：全托
	private String kindergarten;
	 
	//咀嚼习惯 0-否 1-是
	private String chewingHabit;
	
	//睡前刷牙 0-否 1-是
	private String sleepBrushTooth;
	
	//饭前洗手 0-否 1-是
	private String mealWashHand;
	
	//看东西眯眼 0-否 1-是
	private String squinting;
	
	//说自己名字 0-否 1-是
	private String ownName;
	
	//假想游戏 0-否 1-是
	private String pretendPlay;
	
	//模仿画圆 0-否 1-是
	private String imitateDrawCircle;
	
	//双脚跳 0-否 1-是
	private String doubleJump;
	

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

	public String getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}

	public String getChewingHabit() {
		return chewingHabit;
	}

	public void setChewingHabit(String chewingHabit) {
		this.chewingHabit = chewingHabit;
	}

	public String getSleepBrushTooth() {
		return sleepBrushTooth;
	}

	public void setSleepBrushTooth(String sleepBrushTooth) {
		this.sleepBrushTooth = sleepBrushTooth;
	}

	public String getMealWashHand() {
		return mealWashHand;
	}

	public void setMealWashHand(String mealWashHand) {
		this.mealWashHand = mealWashHand;
	}

	public String getSquinting() {
		return squinting;
	}

	public void setSquinting(String squinting) {
		this.squinting = squinting;
	}

	public String getOwnName() {
		return ownName;
	}

	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}

	public String getPretendPlay() {
		return pretendPlay;
	}

	public void setPretendPlay(String pretendPlay) {
		this.pretendPlay = pretendPlay;
	}

	public String getImitateDrawCircle() {
		return imitateDrawCircle;
	}

	public void setImitateDrawCircle(String imitateDrawCircle) {
		this.imitateDrawCircle = imitateDrawCircle;
	}

	public String getDoubleJump() {
		return doubleJump;
	}

	public void setDoubleJump(String doubleJump) {
		this.doubleJump = doubleJump;
	}
}
