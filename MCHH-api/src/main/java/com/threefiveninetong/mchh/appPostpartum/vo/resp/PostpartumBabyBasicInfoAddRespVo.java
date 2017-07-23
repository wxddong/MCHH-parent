package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPostpartum.vo.req.BabyVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 添加宝宝基础信息响应
 * @author zhanght
 */
public class PostpartumBabyBasicInfoAddRespVo extends BaseVo {
	
	public List<BabyVo> babyList;

	public List<BabyVo> getBabyList() {
		return babyList;
	}

	public void setBabyList(List<BabyVo> babyList) {
		this.babyList = babyList;
	}
}
