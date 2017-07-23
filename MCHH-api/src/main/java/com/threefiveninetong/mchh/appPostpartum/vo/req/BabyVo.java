package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;

/**
 * 育儿期儿童信息
 * @author zhanght
 */
public class BabyVo {
	
	//宝宝基础信息ID 
	private String babyInfoId;
	
	//宝宝生日
	@NotEmpty(field="宝宝生日")
	private String birthday;
	
	//宝宝姓名
	@NotEmpty(field="宝宝姓名")
	private String name;
	
	//宝宝性别
	@NotEmpty(field="宝宝性别")
	@EqualsAny(field="宝宝性别",values={"0","1"})
	private String sex;
	
	//出生时间
	private String birthTime;
	
	//身高
	private String height;
	
	//体重
	private String weight;
	
	//出生孕周
	private String birthGesWeeks;
	
	//出生地点
	private String birthPlace;
	
	//接生机构
	private String deliveryMec;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBirthGesWeeks() {
		return birthGesWeeks;
	}

	public void setBirthGesWeeks(String birthGesWeeks) {
		this.birthGesWeeks = birthGesWeeks;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getDeliveryMec() {
		return deliveryMec;
	}

	public void setDeliveryMec(String deliveryMec) {
		this.deliveryMec = deliveryMec;
	}
}
