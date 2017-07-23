package com.threefiveninetong.mchh.appPremarital.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询备孕期基础信息
 * @author zhanght
 */
public class PremaritalBasicSearchInfoRespVo extends BaseVo {
	
	//0-进入基础信息页面   1-进入首页
	private String status = "";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
