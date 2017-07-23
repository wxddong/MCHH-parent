package com.threefiveninetong.mchh.appPostpartum.vo.req;

/**
 * 新生儿早期记录详情信息
 * @author zhanght
 */
public class EarlyStageDetailsVo {
	
	//出生天数
	private String birthDays;
	
	//喂养方式 ： 0-非母乳  1-母乳  2-混合
	private String feedingMode;
	
	//吃奶次数
	private String milkNum;
	
	//小便次数
	private String urineNum;
	
	//大便次数
	private String shitNum;
	
	//体重
	private String weight;
	
	//皮肤黄染
	private String jaundice;
	
	//记录时间
	private String createTime;

	public String getBirthDays() {
		return birthDays;
	}

	public void setBirthDays(String birthDays) {
		this.birthDays = birthDays;
	}

	public String getFeedingMode() {
		return feedingMode;
	}

	public void setFeedingMode(String feedingMode) {
		this.feedingMode = feedingMode;
	}

	public String getMilkNum() {
		return milkNum;
	}

	public void setMilkNum(String milkNum) {
		this.milkNum = milkNum;
	}

	public String getUrineNum() {
		return urineNum;
	}

	public void setUrineNum(String urineNum) {
		this.urineNum = urineNum;
	}

	public String getShitNum() {
		return shitNum;
	}

	public void setShitNum(String shitNum) {
		this.shitNum = shitNum;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getJaundice() {
		return jaundice;
	}

	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
