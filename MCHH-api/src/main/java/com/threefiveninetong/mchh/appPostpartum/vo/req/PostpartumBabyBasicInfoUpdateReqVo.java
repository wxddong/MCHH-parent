package com.threefiveninetong.mchh.appPostpartum.vo.req;

import javax.validation.Valid;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 修改育儿期宝宝基础信息
 * @author zhanght
 */
public class PostpartumBabyBasicInfoUpdateReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@Valid
	private BabyVo babyInfo;

	public BabyVo getBabyInfo() {
		return babyInfo;
	}

	public void setBabyInfo(BabyVo babyInfo) {
		this.babyInfo = babyInfo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
