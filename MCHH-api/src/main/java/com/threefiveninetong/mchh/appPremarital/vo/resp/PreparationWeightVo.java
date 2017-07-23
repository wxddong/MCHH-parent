package com.threefiveninetong.mchh.appPremarital.vo.resp;

/**
 * 体重记录
 * @author zhanght
 */
public class PreparationWeightVo {
	
	//体重
	private String weight;
	
	//身高
	private String height;
	
	//BMI
	private String bmi;
	
	//记录时间
	private String createTime;

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
