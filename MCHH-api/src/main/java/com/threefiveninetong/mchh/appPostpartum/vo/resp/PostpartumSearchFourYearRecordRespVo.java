package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期四岁龄记录
 * @author zhanght
 */
public class PostpartumSearchFourYearRecordRespVo extends BaseVo {
	
	//幼儿园
	private String kindergarten = "";
	
	//剪东西
	private String cutSomething = "";
	
	//独立上厕所
	private String independentToilet = "";
	
	//讲故事
	private String tellingStories = "";
	
	//户外活动
	private String outdoorActivityTime = "";
	
	//看视频
	private String watchVideoTime = "";
	
	//说形容词句子
	private String saidAdjectiveSentence = "";
	
	//按要求等待
	private String requirementWait = "";
	
	//独立穿衣
	private String independentDress = "";
	
	//单脚站立
	private String singleFootStand = "";

	public String getKindergarten() {
		return kindergarten;
	}

	public String getCutSomething() {
		return cutSomething;
	}

	public String getIndependentToilet() {
		return independentToilet;
	}

	public String getTellingStories() {
		return tellingStories;
	}

	public String getOutdoorActivityTime() {
		return outdoorActivityTime;
	}

	public String getWatchVideoTime() {
		return watchVideoTime;
	}

	public String getSaidAdjectiveSentence() {
		return saidAdjectiveSentence;
	}

	public String getRequirementWait() {
		return requirementWait;
	}

	public String getIndependentDress() {
		return independentDress;
	}

	public String getSingleFootStand() {
		return singleFootStand;
	}

	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}

	public void setCutSomething(String cutSomething) {
		this.cutSomething = cutSomething;
	}

	public void setIndependentToilet(String independentToilet) {
		this.independentToilet = independentToilet;
	}

	public void setTellingStories(String tellingStories) {
		this.tellingStories = tellingStories;
	}

	public void setOutdoorActivityTime(String outdoorActivityTime) {
		this.outdoorActivityTime = outdoorActivityTime;
	}

	public void setWatchVideoTime(String watchVideoTime) {
		this.watchVideoTime = watchVideoTime;
	}

	public void setSaidAdjectiveSentence(String saidAdjectiveSentence) {
		this.saidAdjectiveSentence = saidAdjectiveSentence;
	}

	public void setRequirementWait(String requirementWait) {
		this.requirementWait = requirementWait;
	}

	public void setIndependentDress(String independentDress) {
		this.independentDress = independentDress;
	}

	public void setSingleFootStand(String singleFootStand) {
		this.singleFootStand = singleFootStand;
	}
}
