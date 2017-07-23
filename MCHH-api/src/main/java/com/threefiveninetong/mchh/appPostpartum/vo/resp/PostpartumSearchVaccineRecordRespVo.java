package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期宝宝疫苗接种记录--响应
 * @author zhanght
 */
public class PostpartumSearchVaccineRecordRespVo extends BaseVo {
	
	private List<String> vaccineList;

	public List<String> getVaccineList() {
		return vaccineList;
	}

	public void setVaccineList(List<String> vaccineList) {
		this.vaccineList = vaccineList;
	}
}
