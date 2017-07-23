package com.threefiveninetong.mchh.appMember.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPremarital.vo.resp.ExpertGuidanceVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询专家指导信息
 * @author zhanght
 */
public class MemberSearchExpertGuidanceRespVo extends BaseVo {
	
	private List<ExpertGuidanceVo> expertGuidanceList;

	public List<ExpertGuidanceVo> getExpertGuidanceList() {
		return expertGuidanceList;
	}

	public void setExpertGuidanceList(List<ExpertGuidanceVo> expertGuidanceList) {
		this.expertGuidanceList = expertGuidanceList;
	}
}
