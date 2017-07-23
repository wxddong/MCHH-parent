package com.threefiveninetong.mchh.appPostpartum.vo.req;

import java.util.List;

import javax.validation.Valid;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加育儿期宝宝基础信息
 * @author zhanght
 */
public class PostpartumBabyBasicInfoAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	//宝宝基础信息
	@Valid
	private List<BabyVo> babyList;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<BabyVo> getBabyList() {
		return babyList;
	}

	public void setBabyList(List<BabyVo> babyList) {
		this.babyList = babyList;
	}
}
