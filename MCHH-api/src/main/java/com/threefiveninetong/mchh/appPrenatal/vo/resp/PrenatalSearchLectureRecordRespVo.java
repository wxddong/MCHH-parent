package com.threefiveninetong.mchh.appPrenatal.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询孕产期妈妈听课记录
 * @author zhanght
 */
public class PrenatalSearchLectureRecordRespVo extends BaseVo {
	
	//听课历史记录列表
	private List<LectureRecordVo> lectureRecordList;

	public List<LectureRecordVo> getLectureRecordList() {
		return lectureRecordList;
	}

	public void setLectureRecordList(List<LectureRecordVo> lectureRecordList) {
		this.lectureRecordList = lectureRecordList;
	}
}
