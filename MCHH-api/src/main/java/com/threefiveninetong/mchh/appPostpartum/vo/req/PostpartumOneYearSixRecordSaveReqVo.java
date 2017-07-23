package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期一岁六月龄记录
 * @author zhanght
 */
public class PostpartumOneYearSixRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//独立行走时间
	private String ownWalkTime;
	
	//自己拿勺吃饭 0-否  1-是
	private String ownSpoon;
	
	//自己拿杯喝水 0-否  1-是
	private String ownGalss;
	
	//经常与宝宝玩 0-否  1-是
	private String oftenPlay;
	
	//有意识叫爸爸妈妈 0-否  1-是
	private String consciousCall;
	
	//按要求指人或物 0-否  1-是
	private String requirementFinger;
	 
	//与人有目光交流 0-否  1-是
	private String eyeContact;
	
	//会独立行走  0-否  1-是
	private String ownWalk;
	
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

	public String getOwnWalkTime() {
		return ownWalkTime;
	}

	public void setOwnWalkTime(String ownWalkTime) {
		this.ownWalkTime = ownWalkTime;
	}

	public String getOwnSpoon() {
		return ownSpoon;
	}

	public void setOwnSpoon(String ownSpoon) {
		this.ownSpoon = ownSpoon;
	}

	public String getOwnGalss() {
		return ownGalss;
	}

	public void setOwnGalss(String ownGalss) {
		this.ownGalss = ownGalss;
	}

	public String getOftenPlay() {
		return oftenPlay;
	}

	public void setOftenPlay(String oftenPlay) {
		this.oftenPlay = oftenPlay;
	}

	public String getConsciousCall() {
		return consciousCall;
	}

	public void setConsciousCall(String consciousCall) {
		this.consciousCall = consciousCall;
	}

	public String getRequirementFinger() {
		return requirementFinger;
	}

	public void setRequirementFinger(String requirementFinger) {
		this.requirementFinger = requirementFinger;
	}

	public String getEyeContact() {
		return eyeContact;
	}

	public void setEyeContact(String eyeContact) {
		this.eyeContact = eyeContact;
	}

	public String getOwnWalk() {
		return ownWalk;
	}

	public void setOwnWalk(String ownWalk) {
		this.ownWalk = ownWalk;
	}
}
