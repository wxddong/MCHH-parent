package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询专家指导信息 
 * @author zhanght
 */
public class MemberSearchExpertGuidanceReqVo extends BaseReqVo {
	
	@NotEmpty(field="阶段标示")
	@EqualsAny(field="阶段标示",values={"0","1","2","3"})
	private String classification;

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
}
