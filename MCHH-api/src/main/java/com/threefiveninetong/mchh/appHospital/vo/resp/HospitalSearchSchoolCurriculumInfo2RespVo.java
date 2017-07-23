package com.threefiveninetong.mchh.appHospital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询医院孕妇学校课程信息
 * @author zhanght
 */
public class HospitalSearchSchoolCurriculumInfo2RespVo extends BaseVo {
	
	//课程信息列表
	private List<CurriculumVo> curriculumList;

	public List<CurriculumVo> getCurriculumList() {
		return curriculumList;
	}

	public void setCurriculumList(List<CurriculumVo> curriculumList) {
		this.curriculumList = curriculumList;
	}
}
