package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 删除心情语录信息
 * @author zhanght
 */
public class MemberMoodRecordDeleteReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户")
	private String memberId;
	
	@NotEmpty(field="语录ID")
	private String moodId;

	public String getMemberId() {
		return memberId;
	}

	public String getMoodId() {
		return moodId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMoodId(String moodId) {
		this.moodId = moodId;
	}
}
