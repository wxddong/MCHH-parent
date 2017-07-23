package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期六月龄记录
 * @author zhanght
 */
public class PostpartumSearchSixMonthRecordRespVo extends BaseVo {
	
	//添加辅食时间
	private String addFoodTime = "";
	
	//翻身时间
	private String turnOverTime = "";
	
	//准备玩具
	private String toysNum = "";
	
	//经常陪宝宝玩
	private String babyPlay = "";
	
	//发声或笑
	private String soundLaugh = "";
	
	//伸手抓物
	private String handGrab = "";
	
	//紧握拳
	private String clenchFist = "";
	
	//扶坐
	private String sit = "";

	public String getAddFoodTime() {
		return addFoodTime;
	}

	public void setAddFoodTime(String addFoodTime) {
		this.addFoodTime = addFoodTime;
	}

	public String getToysNum() {
		return toysNum;
	}

	public void setToysNum(String toysNum) {
		this.toysNum = toysNum;
	}

	public String getBabyPlay() {
		return babyPlay;
	}

	public void setBabyPlay(String babyPlay) {
		this.babyPlay = babyPlay;
	}

	public String getSoundLaugh() {
		return soundLaugh;
	}

	public void setSoundLaugh(String soundLaugh) {
		this.soundLaugh = soundLaugh;
	}

	public String getHandGrab() {
		return handGrab;
	}

	public void setHandGrab(String handGrab) {
		this.handGrab = handGrab;
	}

	public String getClenchFist() {
		return clenchFist;
	}

	public void setClenchFist(String clenchFist) {
		this.clenchFist = clenchFist;
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public String getTurnOverTime() {
		return turnOverTime;
	}

	public void setTurnOverTime(String turnOverTime) {
		this.turnOverTime = turnOverTime;
	}
}
