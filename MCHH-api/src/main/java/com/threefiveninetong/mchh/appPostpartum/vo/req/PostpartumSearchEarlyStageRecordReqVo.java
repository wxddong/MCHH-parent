package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;
import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 查询育儿期新生儿早期记录
 * @author zhanght
 */
public class PostpartumSearchEarlyStageRecordReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;

	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	@NotEmpty(field="操作类型")
	@EqualsAny(field="操作类型",values={"0","1"})
	private String type;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
