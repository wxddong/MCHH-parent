package com.threefiveninetong.mchh.appPremarital.vo.req;

import com.threefiveninetong.mchh.core.vo.BaseReqVo;
/**
 * 查询备孕期首页相关信息请求参数
 * @author zhanght
 */
public class PremaritalSearchFirstPageInfoReqVo extends BaseReqVo {
	
	//会员ID
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
