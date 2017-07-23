package com.threefiveninetong.mchh.appPostpartum.vo.req;

/**
 * 宝宝牙齿信息
 * @author zhanght
 */
public class BabyToochGrowVo {
	
	//牙齿ID
	private String babyToochGrowId;
	
	//牙齿位置
	private String position;
	
	//出牙日期
	private String toothingDate;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getToothingDate() {
		return toothingDate;
	}

	public void setToothingDate(String toothingDate) {
		this.toothingDate = toothingDate;
	}

	public String getBabyToochGrowId() {
		return babyToochGrowId;
	}

	public void setBabyToochGrowId(String babyToochGrowId) {
		this.babyToochGrowId = babyToochGrowId;
	}
}
