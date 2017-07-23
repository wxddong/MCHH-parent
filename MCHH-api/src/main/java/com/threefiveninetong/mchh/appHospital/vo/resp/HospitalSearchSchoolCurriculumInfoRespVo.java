package com.threefiveninetong.mchh.appHospital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询医院孕妇学校课程时间列表
 * @author zhanght
 */
public class HospitalSearchSchoolCurriculumInfoRespVo extends BaseVo {
	
	//课程信息列表
	private List<String> curriculumList;

	public List<String> getCurriculumList() {
		return curriculumList;
	}

	public void setCurriculumList(List<String> curriculumList) {
		this.curriculumList = curriculumList;
	}
}
