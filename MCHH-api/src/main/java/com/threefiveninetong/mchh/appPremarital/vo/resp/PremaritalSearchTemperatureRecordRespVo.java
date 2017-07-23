package com.threefiveninetong.mchh.appPremarital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询备孕期体温记录
 * @author zhanght
 */
public class PremaritalSearchTemperatureRecordRespVo extends BaseVo {
	
	//体温信息列表
	private List<TemperatureVo> temperatureList;

	public List<TemperatureVo> getTemperatureList() {
		return temperatureList;
	}

	public void setTemperatureList(List<TemperatureVo> temperatureList) {
		this.temperatureList = temperatureList;
	}
}
