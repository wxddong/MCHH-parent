package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPostpartum.vo.req.BabyVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期宝宝信息列表
 * @author zhanght
 */
public class PostpartumSearchBabyListRespVo extends BaseVo {
	
	//宝宝信息列表
	private List<BabyVo> babyList;

	public List<BabyVo> getBabyList() {
		return babyList;
	}

	public void setBabyList(List<BabyVo> babyList) {
		this.babyList = babyList;
	}
}
