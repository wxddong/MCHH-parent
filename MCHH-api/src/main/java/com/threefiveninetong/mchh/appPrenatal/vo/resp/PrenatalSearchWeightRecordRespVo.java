package com.threefiveninetong.mchh.appPrenatal.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询孕产期妈妈的体重记录
 * @author zhanght
 */
public class PrenatalSearchWeightRecordRespVo extends BaseVo {
	
	//体重历史记录列表
	private List<PrenatalWeightVo> prenatalWeightList;

	public List<PrenatalWeightVo> getPrenatalWeightList() {
		return prenatalWeightList;
	}

	public void setPrenatalWeightList(List<PrenatalWeightVo> prenatalWeightList) {
		this.prenatalWeightList = prenatalWeightList;
	}
}
