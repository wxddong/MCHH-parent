package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期一月龄记录
 * @author zhanght
 */
public class PostpartumOneMonthRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	@NotEmpty(field="脐带脱离时间")
	private String umbilicalTime;
	
	@NotEmpty(field="皮肤黄染消退时间")
	private String jaundiceFadeTime;
	
	@NotEmpty(field="喂养方式")
	@EqualsAny(field="喂养方式",values={"0","1","2"})
	private String feedingMode;
	
	@NotEmpty(field="吃奶情况")
	@EqualsAny(field="吃奶情况",values={"0","1"})
	private String feedingSituation;
	
	@NotEmpty(field="受惊哭泣")
	@EqualsAny(field="受惊哭泣",values={"0","1"})
	private String frightCry;
	
	@NotEmpty(field="哭闹不易安慰")
	@EqualsAny(field="哭闹不易安慰",values={"0","1"})
	private String crying;
	
	@NotEmpty(field="补充维生素")
	@EqualsAny(field="补充维生素",values={"0","1"})
	private String vSupplement;
	
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
