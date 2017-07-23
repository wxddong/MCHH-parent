package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPostpartum.vo.req.EarlyStageDetailsVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期新生儿早期记录
 * @author zhanght
 */
public class PostpartumSearchEarlyStageRecordRespVo extends BaseVo {
	
	//新生儿疾病筛查 0-无  1-有
	private String diseaseScreening = "";
	
	//新生儿听力筛查 0-无  1-有
	private String hearingScreening = "";
	
	//新生儿早期记录详情信息列表
	private List<EarlyStageDetailsVo> earlyStageDetailsList;

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

	public List<EarlyStageDetailsVo> getEarlyStageDetailsList() {
		return earlyStageDetailsList;
	}

	public void setEarlyStageDetailsList(
			List<EarlyStageDetailsVo> earlyStageDetailsList) {
		this.earlyStageDetailsList = earlyStageDetailsList;
	}
}
