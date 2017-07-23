package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期基础响应信息
 * @author zhanght
 */
public class PostpartumSearchBabyBasicInfoRespVo extends BaseVo {
	
	//0-进入基础页面    1-进入首页
	private String status = "";
	
	//育儿期上次操作的儿童ID
	private String parId = "";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParId() {
		return parId;
	}

	public void setParId(String parId) {
		this.parId = parId;
	}
}
