package com.threefiveninetong.mchh.appPrenatal.vo.resp;

/**
 * 孕产期体重记录
 * @author zhanght
 */
public class PrenatalWeightVo {
	
	//孕前BMI
	private String prenatalBmi;
	
	//体重
	private String weight;
	
	//本周增重
	private String weightGain;
	
	//记录时间
	private String createTime;

	public String getPrenatalBmi() {
		return prenatalBmi;
	}

	public String getWeight() {
		return weight;
	}

	public String getWeightGain() {
		return weightGain;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setPrenatalBmi(String prenatalBmi) {
		this.prenatalBmi = prenatalBmi;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setWeightGain(String weightGain) {
		this.weightGain = weightGain;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
