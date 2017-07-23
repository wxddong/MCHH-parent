package com.threefiveninetong.mchh.appPrenatal.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加孕产期体重记录
 * @author zhanght
 */
public class PrenatalWeightRecordAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="孕前BMI")
	private String prenatalBmi;
	
	@NotEmpty(field="体重")
	private String weight;
	
	@NotEmpty(field="本周增重")
	private String weightGain;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPrenatalBmi() {
		return prenatalBmi;
	}

	public void setPrenatalBmi(String prenatalBmi) {
		this.prenatalBmi = prenatalBmi;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightGain() {
		return weightGain;
	}

	public void setWeightGain(String weightGain) {
		this.weightGain = weightGain;
	}
}
