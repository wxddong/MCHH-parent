package com.threefiveninetong.mchh.appMember.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 会员查询一天的心情语录信息
 * @author zhanght
 */
public class MemberMoodRecordByDayInfoReqVo extends BaseReqVo {
	
	//会员ID
	@NotEmpty(field="会员ID")
	private String memberId;
	
	//阶段类型
	@NotEmpty(field="阶段类型")
	@EqualsAny(field="阶段类型",values={"0","1","2","3"})
	private String type;
	
	//日期
	@NotEmpty(field="日期")
	private String date;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
