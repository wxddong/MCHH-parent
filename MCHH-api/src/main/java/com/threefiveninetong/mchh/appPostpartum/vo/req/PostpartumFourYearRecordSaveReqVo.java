package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期四岁龄记录
 * @author zhanght
 */
public class PostpartumFourYearRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//幼儿园
	private String kindergarten;
	
	//剪东西
	private String cutSomething;
	
	//独立上厕所
	private String independentToilet;
	
	//讲故事
	private String tellingStories;
	
	//户外活动
	private String outdoorActivityTime;
	
	//看视频
	private String watchVideoTime;
	
	//说形容词句子
	private String saidAdjectiveSentence;
	
	//按要求等待
	private String requirementWait;
	
	//独立穿衣
	private String independentDress;
	
	//单脚站立
	private String singleFootStand;
	

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

	public String getCutSomething() {
		return cutSomething;
	}

	public void setCutSomething(String cutSomething) {
		this.cutSomething = cutSomething;
	}

	public String getIndependentToilet() {
		return independentToilet;
	}

	public void setIndependentToilet(String independentToilet) {
		this.independentToilet = independentToilet;
	}

	public String getTellingStories() {
		return tellingStories;
	}

	public void setTellingStories(String tellingStories) {
		this.tellingStories = tellingStories;
	}

	public String getOutdoorActivityTime() {
		return outdoorActivityTime;
	}

	public void setOutdoorActivityTime(String outdoorActivityTime) {
		this.outdoorActivityTime = outdoorActivityTime;
	}

	public String getWatchVideoTime() {
		return watchVideoTime;
	}

	public void setWatchVideoTime(String watchVideoTime) {
		this.watchVideoTime = watchVideoTime;
	}

	public String getSaidAdjectiveSentence() {
		return saidAdjectiveSentence;
	}

	public void setSaidAdjectiveSentence(String saidAdjectiveSentence) {
		this.saidAdjectiveSentence = saidAdjectiveSentence;
	}

	public String getRequirementWait() {
		return requirementWait;
	}

	public void setRequirementWait(String requirementWait) {
		this.requirementWait = requirementWait;
	}

	public String getIndependentDress() {
		return independentDress;
	}

	public void setIndependentDress(String independentDress) {
		this.independentDress = independentDress;
	}

	public String getSingleFootStand() {
		return singleFootStand;
	}

	public void setSingleFootStand(String singleFootStand) {
		this.singleFootStand = singleFootStand;
	}
}
