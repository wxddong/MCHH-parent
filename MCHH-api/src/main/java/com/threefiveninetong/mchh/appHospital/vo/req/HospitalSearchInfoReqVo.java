package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询医院详情信息
 * @author zhanght
 */
public class HospitalSearchInfoReqVo extends BaseReqVo {
	
	@NotEmpty(field="医院ID")
	private String hospitalId;

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
}
