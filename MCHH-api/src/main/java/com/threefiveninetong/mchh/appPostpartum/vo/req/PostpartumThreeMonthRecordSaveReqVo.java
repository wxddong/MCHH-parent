package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期三月龄记录
 * @author zhanght
 */
public class PostpartumThreeMonthRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	@NotEmpty(field="户外活动时间")
	private String outdoorsDuration;
	
	@NotEmpty(field="喂养方式")
	@EqualsAny(field="喂养方式",values={"0","1","2"})
	private String feedingMode;
	
	@NotEmpty(field="吃奶情况")
	@EqualsAny(field="吃奶情况",values={"0","1"})
	private String feedingSituation;
	
	@NotEmpty(field="经常和宝宝说话")
	@EqualsAny(field="经常和宝宝说话",values={"0","1"})
	private String talkBaby;
	
	@NotEmpty(field="继续补充维生素")
	@EqualsAny(field="继续补充维生素",values={"0","1"})
	private String vSupplement;
	
	@NotEmpty(field="大声音反应")
	@EqualsAny(field="大声音反应",values={"0","1"})
	private String loudReaction;
	
	@NotEmpty(field="逗引时微笑")
	@EqualsAny(field="逗引时微笑",values={"0","1"})
	private String teasingSmile;
	
	@NotEmpty(field="注视或追视")
	@EqualsAny(field="注视或追视",values={"0","1"})
	private String gazeTracking;
	
	@NotEmpty(field="俯卧抬头")
	@EqualsAny(field="俯卧抬头",values={"0","1"})
	private String riseProne;
	
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
