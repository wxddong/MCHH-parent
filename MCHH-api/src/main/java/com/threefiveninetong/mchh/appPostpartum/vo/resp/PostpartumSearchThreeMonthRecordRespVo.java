package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期三月龄记录
 * @author zhanght
 */
public class PostpartumSearchThreeMonthRecordRespVo extends BaseVo {
	
	//户外活动时间
	private String outdoorsDuration = "";
	
	//喂养方式
	private String feedingMode = "";
	
	//吃奶情况
	private String feedingSituation = "";
	
	//经常和宝宝说话
	private String talkBaby = "";
	
	//继续补充维生素
	private String vSupplement = "";
	
	//大声音反应
	private String loudReaction = "";
	
	//逗引时微笑
	private String teasingSmile = "";
	
	//注视或追视
	private String gazeTracking = "";
	
	//俯卧抬头
	private String riseProne = "";

	public String getOutdoorsDuration() {
		return outdoorsDuration;
	}

	public void setOutdoorsDuration(String outdoorsDuration) {
		this.outdoorsDuration = outdoorsDuration;
	}

	public String getFeedingMode() {
		return feedingMode;
	}

	public void setFeedingMode(String feedingMode) {
		this.feedingMode = feedingMode;
	}

	public String getFeedingSituation() {
		return feedingSituation;
	}

	public void setFeedingSituation(String feedingSituation) {
		this.feedingSituation = feedingSituation;
	}

	public String getTalkBaby() {
		return talkBaby;
	}

	public void setTalkBaby(String talkBaby) {
		this.talkBaby = talkBaby;
	}

	public String getvSupplement() {
		return vSupplement;
	}

	public void setvSupplement(String vSupplement) {
		this.vSupplement = vSupplement;
	}

	public String getLoudReaction() {
		return loudReaction;
	}

	public void setLoudReaction(String loudReaction) {
		this.loudReaction = loudReaction;
	}

	public String getTeasingSmile() {
		return teasingSmile;
	}

	public void setTeasingSmile(String teasingSmile) {
		this.teasingSmile = teasingSmile;
	}

	public String getGazeTracking() {
		return gazeTracking;
	}

	public void setGazeTracking(String gazeTracking) {
		this.gazeTracking = gazeTracking;
	}

	public String getRiseProne() {
		return riseProne;
	}

	public void setRiseProne(String riseProne) {
		this.riseProne = riseProne;
	}
}
