package com.threefiveninetong.mchh.appHospital.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询医院详情信息
 * @author zhanght
 */
public class HospitalSearchInfoRespVo extends BaseVo{
	
	//医院信息ID
	private String hospitalId = "";
	
	//医院名称
	private String hospitalName = "";
	
	//咨询电话
	private String telephone = "";
	
	//大图片URL
	private String bigImageUrl = "";
	
	//简介
	private String brief = "";

	public String getHospitalId() {
		return hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public String getBrief() {
		return brief;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
}	
