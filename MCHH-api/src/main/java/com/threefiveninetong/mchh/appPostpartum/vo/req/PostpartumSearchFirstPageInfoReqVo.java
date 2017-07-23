package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询育儿期首页相关信息接口
 * @author zhanght
 */
public class PostpartumSearchFirstPageInfoReqVo extends BaseReqVo {
	
	private String babyInfoId;
	
	private String memberId;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
