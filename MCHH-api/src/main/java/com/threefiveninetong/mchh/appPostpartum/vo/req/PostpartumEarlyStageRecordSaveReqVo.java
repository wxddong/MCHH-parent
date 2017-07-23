package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期新生儿早期记录
 * @author zhanght
 */
public class PostpartumEarlyStageRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	@NotEmpty(field="新生儿疾病筛查")
	@EqualsAny(field="新生儿疾病筛查",values={"0","1"})
	private String diseaseScreening;
	
	@NotEmpty(field="新生儿听力筛查")
	@EqualsAny(field="新生儿听力筛查",values={"0","1"})
	private String hearingScreening;
	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	//新生儿早期记录详情信息
	private EarlyStageDetailsVo earlyStageDetails;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public String getDiseaseScreening() {
		return diseaseScreening;
	}

	public void setDiseaseScreening(String diseaseScreening) {
		this.diseaseScreening = diseaseScreening;
	}

	public String getHearingScreening() {
		return hearingScreening;
	}

	public void setHearingScreening(String hearingScreening) {
		this.hearingScreening = hearingScreening;
	}

	public EarlyStageDetailsVo getEarlyStageDetails() {
		return earlyStageDetails;
	}

	public void setEarlyStageDetails(EarlyStageDetailsVo earlyStageDetails) {
		this.earlyStageDetails = earlyStageDetails;
	} 
}
