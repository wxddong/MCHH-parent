package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询宝宝生长响应信息
 * @author zhanght
 */
public class PostpartumSearchBabyGrowRecordRespVo extends BaseVo {
	
	//宝宝生长信息列表
	public List<BabyGrowVo> babyGrowList;

	public List<BabyGrowVo> getBabyGrowList() {
		return babyGrowList;
	}

	public void setBabyGrowList(List<BabyGrowVo> babyGrowList) {
		this.babyGrowList = babyGrowList;
	}
}
