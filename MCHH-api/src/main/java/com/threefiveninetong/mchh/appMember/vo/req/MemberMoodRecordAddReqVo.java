package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加心情语录请求参数 
 * @author zhanght
 */
public class MemberMoodRecordAddReqVo extends BaseReqVo {
	
	//会员ID
	@NotEmpty(field="账户")
	private String memberId;
	
	//内容
	@NotEmpty(field="内容")
	private String content;
	
	//阶段类型
	@NotEmpty(field="阶段类型")
	@EqualsAny(values={"0","1","2"},field="阶段类型")
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
