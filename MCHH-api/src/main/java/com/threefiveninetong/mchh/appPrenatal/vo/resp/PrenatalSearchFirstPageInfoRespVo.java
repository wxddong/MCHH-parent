package com.threefiveninetong.mchh.appPrenatal.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPremarital.vo.resp.BannerImageInfoVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.ExpertGuidanceVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询孕产期首页信息
 * @author zhanght
 */
public class PrenatalSearchFirstPageInfoRespVo extends BaseVo {
	
	//基本信息ID
	private String prenatalBasicId = "";

	//预产期
	private String predictDate = "";
	
	//末次月经
	private String lastMenses = "";
	
	//当前孕周
	private String gestationalWeeks = "";
	
	//最新通知标题
	private String title = "";
	
	//最新通知内容
	private String content = "";
	
	//最新通知收到时间
	private String receiveTime = "";
	
	//上一次体重
	private String weight = "";
	
	//孕前BMI
	private String prenatalBmi = "";
	
	//上一次胎动
	private String moveNum = "";
	
	//专家健康指导列表
	private List<ExpertGuidanceVo> expertGuidanceList;
	
	//孕产期Banner图
	private List<BannerImageInfoVo> bannerImageList;

	public String getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
	}

	public String getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(String lastMenses) {
		this.lastMenses = lastMenses;
	}

	public String getGestationalWeeks() {
		return gestationalWeeks;
	}

	public void setGestationalWeeks(String gestationalWeeks) {
		this.gestationalWeeks = gestationalWeeks;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPrenatalBmi() {
		return prenatalBmi;
	}

	public void setPrenatalBmi(String prenatalBmi) {
		this.prenatalBmi = prenatalBmi;
	}

	public String getMoveNum() {
		return moveNum;
	}

	public void setMoveNum(String moveNum) {
		this.moveNum = moveNum;
	}

	public List<ExpertGuidanceVo> getExpertGuidanceList() {
		return expertGuidanceList;
	}

	public void setExpertGuidanceList(List<ExpertGuidanceVo> expertGuidanceList) {
		this.expertGuidanceList = expertGuidanceList;
	}

	public List<BannerImageInfoVo> getBannerImageList() {
		return bannerImageList;
	}

	public void setBannerImageList(List<BannerImageInfoVo> bannerImageList) {
		this.bannerImageList = bannerImageList;
	}

	public String getPrenatalBasicId() {
		return prenatalBasicId;
	}

	public void setPrenatalBasicId(String prenatalBasicId) {
		this.prenatalBasicId = prenatalBasicId;
	}
}
