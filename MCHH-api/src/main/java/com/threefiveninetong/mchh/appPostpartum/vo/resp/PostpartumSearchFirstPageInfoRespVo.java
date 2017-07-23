package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPremarital.vo.resp.BannerImageInfoVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.ExpertGuidanceVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期首页响应信息
 * @author zhanght
 */
public class PostpartumSearchFirstPageInfoRespVo extends BaseVo {
	
	//出生天数
	private String birthDays = "";
	
	//最新通知标题
	private String title = "";
	
	//最新通知内容
	private String content = "";
	
	//最新通知收到时间
	private String receiveTime = "";
	
	//妈妈上一次体重
	private String momWeight = "";
	
	//宝宝上一次体重
	private String babyWeight = "";
	
	//宝宝上一次身高
	private String babyHeight = "";
	
	//孕前BMI
	private String prenatalBmi = "";
	
	//专家健康指导列表
	private List<ExpertGuidanceVo> expertGuidanceList;
	
	//Banner图列表
	private List<BannerImageInfoVo> bannerImageList;

	public String getBirthDays() {
		return birthDays;
	}

	public void setBirthDays(String birthDays) {
		this.birthDays = birthDays;
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

	public String getMomWeight() {
		return momWeight;
	}

	public void setMomWeight(String momWeight) {
		this.momWeight = momWeight;
	}

	public String getBabyWeight() {
		return babyWeight;
	}

	public void setBabyWeight(String babyWeight) {
		this.babyWeight = babyWeight;
	}

	public String getBabyHeight() {
		return babyHeight;
	}

	public void setBabyHeight(String babyHeight) {
		this.babyHeight = babyHeight;
	}

	public String getPrenatalBmi() {
		return prenatalBmi;
	}

	public void setPrenatalBmi(String prenatalBmi) {
		this.prenatalBmi = prenatalBmi;
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
}
