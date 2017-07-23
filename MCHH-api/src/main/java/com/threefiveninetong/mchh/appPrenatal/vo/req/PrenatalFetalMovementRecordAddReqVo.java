package com.threefiveninetong.mchh.appPrenatal.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加孕产期胎动记录
 * @author zhanght
 */
public class PrenatalFetalMovementRecordAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="胎动次数")
	private String moveNum;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMoveNum() {
		return moveNum;
	}

	public void setMoveNum(String moveNum) {
		this.moveNum = moveNum;
	}
}
