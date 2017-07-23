package com.threefiveninetong.mchh.appPremarital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询备孕期首页响应信息
 * @author zhanght
 */
public class PremaritalSearchFirstPageInfoRespVo extends BaseVo {
	
	//备孕期基本信息ID
	private String premaritalBasicId = "";
	
	//末次月经
	private String lastMenses = "";
	
	//经期
	private String period = "";
	
	//周期
	private String menstrualCycle = "";
	
	//最新通知标题
	private String title = "";
	
	//最新通知内容
	private String content = "";
	
	//最新通知收到时间
	private String receiveTime = "";
	
	//上一次体重
	private String weight = "";
	
	//上一次体温
	private String temperature = "";
	
	//专家健康指导列表
	private List<ExpertGuidanceVo> expertGuidanceList;
	
	//Banner图信息
	private List<BannerImageInfoVo> bannerImageList;

	public String getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(String lastMenses) {
		this.lastMenses = lastMenses;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getMenstrualCycle() {
		return menstrualCycle;
	}

	public void setMenstrualCycle(String menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
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

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
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

	public String getPremaritalBasicId() {
		return premaritalBasicId;
	}

	public void setPremaritalBasicId(String premaritalBasicId) {
		this.premaritalBasicId = premaritalBasicId;
	}
}
