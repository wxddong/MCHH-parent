package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;
/**
 * 意见反馈请求参数
 * @author zhanght
 */
public class MemberFeedbackReqVo extends BaseReqVo {
	
	//会员ID
	private String memberId;
	
	@NotEmpty(field="反馈内容")
	private String content;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
