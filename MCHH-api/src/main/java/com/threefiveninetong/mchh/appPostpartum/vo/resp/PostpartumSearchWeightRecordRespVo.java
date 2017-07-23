package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期妈妈的体重记录
 * @author zhanght
 */
public class PostpartumSearchWeightRecordRespVo extends BaseVo {
	
	private List<ParentingWeightVo> parentingWeightList;

	public List<ParentingWeightVo> getParentingWeightList() {
		return parentingWeightList;
	}

	public void setParentingWeightList(List<ParentingWeightVo> parentingWeightList) {
		this.parentingWeightList = parentingWeightList;
	}
}
