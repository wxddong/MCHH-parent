package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询医院孕妇学校课程信息
 * @author zhanght
 */
public class HospitalSearchSchoolCurriculumInfo2ReqVo extends BaseReqVo {
	
	@NotEmpty(field="医院ID")
	private String hospitalId;
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="日期")
	private String date;

	public String getHospitalId() {
		return hospitalId;
	}

	public String getDate() {
		return date;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
