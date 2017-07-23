package com.threefiveninetong.mchh.appPremarital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存备孕期其他信息
 * @author zhanght
 */
public class PremaritalOtherInfoSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="爸爸结婚年龄")
	private String dadAge;
	
	@NotEmpty(field="妈妈结婚年龄")
	private String momAge;
	
	@NotEmpty(field="计划怀孕时间")
	private String planTime;
	
	@NotEmpty(field="备孕爸爸检查状况")
	@EqualsAny(field="备孕爸爸检查状况",values={"0","1"})
	private String dadHealthy;
	
	@NotEmpty(field="备孕妈妈检查状况")
	@EqualsAny(field="备孕妈妈检查状况",values={"0","1"})
	private String momHealthy;
	
	//备孕爸爸检查状况备注
	private String dadHealthyRemark;
	
	//备孕妈妈检查状况备注
	private String momHealthyRemark;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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
