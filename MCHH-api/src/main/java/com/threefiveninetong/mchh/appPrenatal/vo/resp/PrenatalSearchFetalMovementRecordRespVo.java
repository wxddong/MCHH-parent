package com.threefiveninetong.mchh.appPrenatal.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询孕产期胎动记录
 * @author zhanght
 */
public class PrenatalSearchFetalMovementRecordRespVo extends BaseVo {
	
	//胎动历史纪录列表
	private List<FetalMovementVo> fetalMovementList;

	public List<FetalMovementVo> getFetalMovementList() {
		return fetalMovementList;
	}

	public void setFetalMovementList(List<FetalMovementVo> fetalMovementList) {
		this.fetalMovementList = fetalMovementList;
	}
}
