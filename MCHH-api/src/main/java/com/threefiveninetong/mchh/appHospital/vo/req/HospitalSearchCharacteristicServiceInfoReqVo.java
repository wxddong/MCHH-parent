package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询医院特色服务信息
 * @author zhanght
 */
public class HospitalSearchCharacteristicServiceInfoReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="医院信息ID")
	private String hospitalId;

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
