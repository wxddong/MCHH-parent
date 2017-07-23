package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期一月龄记录 -- 响应
 * @author zhanght
 */
public class PostpartumSearchOneMonthRecordRespVo extends BaseVo {
	
	//脐带脱离时间 
	private String umbilicalTime = "";
	
	//皮肤黄染消退时间
	private String jaundiceFadeTime = "";
	
	//喂养方式
	private String feedingMode = "";
	
	//吃奶情况
	private String feedingSituation = "";
	
	//受惊哭泣
	private String frightCry = "";
	
	//哭闹不易安慰
	private String crying = "";
	
	//补充维生素
	private String vSupplement = "";

	public String getUmbilicalTime() {
		return umbilicalTime;
	}

	public void setUmbilicalTime(String umbilicalTime) {
		this.umbilicalTime = umbilicalTime;
	}

	public String getJaundiceFadeTime() {
		return jaundiceFadeTime;
	}

	public void setJaundiceFadeTime(String jaundiceFadeTime) {
		this.jaundiceFadeTime = jaundiceFadeTime;
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

	public String getFrightCry() {
		return frightCry;
	}

	public void setFrightCry(String frightCry) {
		this.frightCry = frightCry;
	}

	public String getCrying() {
		return crying;
	}

	public void setCrying(String crying) {
		this.crying = crying;
	}

	public String getvSupplement() {
		return vSupplement;
	}

	public void setvSupplement(String vSupplement) {
		this.vSupplement = vSupplement;
	}
}
