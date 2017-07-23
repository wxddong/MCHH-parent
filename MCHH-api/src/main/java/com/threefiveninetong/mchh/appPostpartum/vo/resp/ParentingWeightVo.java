package com.threefiveninetong.mchh.appPostpartum.vo.resp;

/**
 * 育儿期体重
 * @author zhanght
 */
public class ParentingWeightVo {
	
	//孕前BMI
	private String prenatalBmi;
	
	//体重
	private String weight;
	
	//身高
	private String height;
	
	//BMI指数
	private String bmi;
	
	//记录时间
	private String createTime;

	public String getPrenatalBmi() {
		return prenatalBmi;
	}

	public String getWeight() {
		return weight;
	}

	public String getHeight() {
		return height;
	}

	public String getBmi() {
		return bmi;
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

	public void setHeight(String height) {
		this.height = height;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
