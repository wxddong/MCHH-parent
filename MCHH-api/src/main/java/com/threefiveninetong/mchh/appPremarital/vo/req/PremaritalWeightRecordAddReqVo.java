package com.threefiveninetong.mchh.appPremarital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加备孕期体重记录
 * @author zhanght
 */
public class PremaritalWeightRecordAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="体重")
	private String weight;
	
	@NotEmpty(field="身高")
	private String height;
	
	@NotEmpty(field="BMI指数")
	private String bmi;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
}
