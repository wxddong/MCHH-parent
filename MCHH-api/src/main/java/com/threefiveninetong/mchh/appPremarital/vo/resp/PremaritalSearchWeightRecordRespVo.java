package com.threefiveninetong.mchh.appPremarital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询备孕期妈妈的体重记录
 * @author zhanght
 */
public class PremaritalSearchWeightRecordRespVo extends BaseVo {
	
	//体重历史记录列表
	private List<PreparationWeightVo> preparationWeightList;

	public List<PreparationWeightVo> getPreparationWeightList() {
		return preparationWeightList;
	}

	public void setPreparationWeightList(
			List<PreparationWeightVo> preparationWeightList) {
		this.preparationWeightList = preparationWeightList;
	}
}
