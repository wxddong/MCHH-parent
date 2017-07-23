package com.threefiveninetong.mchh.appPrenatal.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询会员孕产期其他信息记录
 * @author zhanght
 */
public class PrenatalSearchSelfRecordRespVo extends BaseVo {
	
	//末次月经
	private String lastMenses = "";
	
	//预产期
	private String predictDate = "";
	
	//首次胎动日期
	private String firstMoveDate = "";
	
	//B超检查日期
	private String bExaDate = "";
	
	//是否每天数胎动
	private String testMoveSign = "";
	
	//体重增长范围
	private String growthRange = "";
	
	//高危标识
	private String riskSign = "";
	
	//高危具体情况
	private String riskRemark = "";
	
	//特殊情况
	private List<String> specialList;

	public String getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(String lastMenses) {
		this.lastMenses = lastMenses;
	}

	public String getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
	}

	public String getFirstMoveDate() {
		return firstMoveDate;
	}

	public void setFirstMoveDate(String firstMoveDate) {
		this.firstMoveDate = firstMoveDate;
	}

	public String getbExaDate() {
		return bExaDate;
	}

	public void setbExaDate(String bExaDate) {
		this.bExaDate = bExaDate;
	}

	public String getTestMoveSign() {
		return testMoveSign;
	}

	public void setTestMoveSign(String testMoveSign) {
		this.testMoveSign = testMoveSign;
	}

	public String getGrowthRange() {
		return growthRange;
	}

	public void setGrowthRange(String growthRange) {
		this.growthRange = growthRange;
	}

	public String getRiskSign() {
		return riskSign;
	}

	public void setRiskSign(String riskSign) {
		this.riskSign = riskSign;
	}

	public String getRiskRemark() {
		return riskRemark;
	}

	public void setRiskRemark(String riskRemark) {
		this.riskRemark = riskRemark;
	}

	public List<String> getSpecialList() {
		return specialList;
	}

	public void setSpecialList(List<String> specialList) {
		this.specialList = specialList;
	}
}
