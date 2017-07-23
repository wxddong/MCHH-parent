package com.threefiveninetong.mchh.appPremarital.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询备孕期其他信息 
 * @author zhanght
 */
public class PremaritalSearchOtherInfoRespVo extends BaseVo {
	
	//爸爸结婚年龄
	private String dadAge = "";
	
	//妈妈结婚年龄
	private String momAge = "";
	
	//计划怀孕时间
	private String planTime = "";
	
	//备孕爸爸检查状况
	private String dadHealthy = "";
	
	//备孕妈妈检查状况
	private String momHealthy = "";
	
	//备孕爸爸检查状况备注
	private String dadHealthyRemark = "";
	
	//备孕妈妈检查状况备注
	private String momHealthyRemark = "";

	public String getDadAge() {
		return dadAge;
	}

	public void setDadAge(String dadAge) {
		this.dadAge = dadAge;
	}

	public String getMomAge() {
		return momAge;
	}

	public void setMomAge(String momAge) {
		this.momAge = momAge;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getDadHealthy() {
		return dadHealthy;
	}

	public void setDadHealthy(String dadHealthy) {
		this.dadHealthy = dadHealthy;
	}

	public String getMomHealthy() {
		return momHealthy;
	}

	public void setMomHealthy(String momHealthy) {
		this.momHealthy = momHealthy;
	}

	public String getDadHealthyRemark() {
		return dadHealthyRemark;
	}

	public void setDadHealthyRemark(String dadHealthyRemark) {
		this.dadHealthyRemark = dadHealthyRemark;
	}

	public String getMomHealthyRemark() {
		return momHealthyRemark;
	}

	public void setMomHealthyRemark(String momHealthyRemark) {
		this.momHealthyRemark = momHealthyRemark;
	}
}
