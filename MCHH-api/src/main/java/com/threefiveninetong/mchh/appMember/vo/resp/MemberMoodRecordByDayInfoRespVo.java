package com.threefiveninetong.mchh.appMember.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 会员查询一天的心情语录信息响应参数 
 * @author zhanght
 */
public class MemberMoodRecordByDayInfoRespVo extends BaseVo {
	
	//心情语录列表
	private List<MoodRecordVo> moodRecordList;

	public List<MoodRecordVo> getMoodRecordList() {
		return moodRecordList;
	}

	public void setMoodRecordList(List<MoodRecordVo> moodRecordList) {
		this.moodRecordList = moodRecordList;
	}
}
