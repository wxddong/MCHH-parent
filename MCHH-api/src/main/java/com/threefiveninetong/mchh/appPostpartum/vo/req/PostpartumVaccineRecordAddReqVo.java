package com.threefiveninetong.mchh.appPostpartum.vo.req;

import java.util.List;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.validation.annotation.NotNull;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加育儿期宝宝疫苗接种记录 --请求
 * @author zhanght
 */
public class PostpartumVaccineRecordAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	@NotNull(field="宝宝疫苗列表")
	private List<String> vaccineList;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public List<String> getVaccineList() {
		return vaccineList;
	}

	public void setVaccineList(List<String> vaccineList) {
		this.vaccineList = vaccineList;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
