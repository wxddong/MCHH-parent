package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BasePageReqVo;

/**
 * 会员查询心情语录信息
 * @author zhanght
 */
public class MemberMoodRecordListReqVo extends BasePageReqVo {
	
	//会员ID
	@NotEmpty(field="会员ID")
	private String memberId;
	
	//阶段类型
	@NotEmpty(field="阶段类型")
	@EqualsAny(field="阶段类型",values={"0","1","2","3"})
	private String type;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
