package com.threefiveninetong.mchh.appPrenatal.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 修改孕产期基础信息 
 * @author zhanght
 */
public class PrenatalBasicInfoUpdateReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="孕产期基础ID")
	private String prenatalBasicId;
	
	@NotEmpty(field="预产期")
	private String predictDate;
	
	//末次月经
	private String lastMenses;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPredictDate() {
		return predictDate;
	}

	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
	}

	public String getLastMenses() {
		return lastMenses;
	}

	public void setLastMenses(String lastMenses) {
		this.lastMenses = lastMenses;
	}

	public String getPrenatalBasicId() {
		return prenatalBasicId;
	}

	public void setPrenatalBasicId(String prenatalBasicId) {
		this.prenatalBasicId = prenatalBasicId;
	}
}
