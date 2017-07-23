package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期六月龄记录
 * @author zhanght
 */
public class PostpartumSixMonthRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//添加辅食时间
	private String addFoodTime;
	
	//翻身时间
	private String turnOverTime;
	
	//准备玩具
	private String toysNum;
	
	//经常陪宝宝玩 0-否  1-是
	private String babyPlay;
	
	//发声或笑 0-否  1-是
	private String soundLaugh;
	
	//伸手抓物 0-否  1-是
	private String handGrab;
	
	//紧握拳 0-否  1-是
	private String clenchFist;
	
	//扶坐 0-否  1-是
	private String sit;
	
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

	public String getAddFoodTime() {
		return addFoodTime;
	}

	public void setAddFoodTime(String addFoodTime) {
		this.addFoodTime = addFoodTime;
	}

	public String getTurnOverTime() {
		return turnOverTime;
	}

	public void setTurnOverTime(String turnOverTime) {
		this.turnOverTime = turnOverTime;
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
}
