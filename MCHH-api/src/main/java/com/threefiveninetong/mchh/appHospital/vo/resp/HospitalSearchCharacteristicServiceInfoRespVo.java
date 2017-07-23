package com.threefiveninetong.mchh.appHospital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询医院特色服务信息
 * @author zhanght
 */
public class HospitalSearchCharacteristicServiceInfoRespVo extends BaseVo {
	
	//特色服务信息列表
	private List<CharacteristicServiceVo> characteristicServiceList;

	public List<CharacteristicServiceVo> getCharacteristicServiceList() {
		return characteristicServiceList;
	}

	public void setCharacteristicServiceList(
			List<CharacteristicServiceVo> characteristicServiceList) {
		this.characteristicServiceList = characteristicServiceList;
	}
}
