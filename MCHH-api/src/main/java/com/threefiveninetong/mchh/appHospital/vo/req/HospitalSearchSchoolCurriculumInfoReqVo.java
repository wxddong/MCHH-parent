package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询医院孕妇学校课程时间列表
 * @author zhanght
 */
public class HospitalSearchSchoolCurriculumInfoReqVo extends BaseReqVo {
	
	@NotEmpty(field="医院ID")
	private String hospitalId;
	
	@NotEmpty(field="会员ID")
	private String memberId;

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
