package com.threefiveninetong.mchh.appPrenatal.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 添加孕产期基础信息 响应信息
 * @author zhanght
 */
public class PrenatalBasicInfoAddRespVo extends BaseVo {
	
	//基本信息ID
	private String prenatalBasicId = "";

	public String getPrenatalBasicId() {
		return prenatalBasicId;
	}

	public void setPrenatalBasicId(String prenatalBasicId) {
		this.prenatalBasicId = prenatalBasicId;
	}
}	
