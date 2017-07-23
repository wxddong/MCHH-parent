package com.threefiveninetong.mchh.appPostpartum.vo.resp;

/**
 * 宝宝生长信息
 * @author zhanght
 */
public class BabyGrowVo {
	
	//体重
	private String weight;
	
	//身高
	private String height;
	
	//记录时间
	private String createTime;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
