package com.threefiveninetong.mchh.appPostpartum.vo.req;

import java.util.List;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存宝宝牙齿生长请求信息 
 * @author zhanght
 */
public class PostpartumBabyDentitionRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	private List<BabyToochGrowVo> babyToochGrowList;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public List<BabyToochGrowVo> getBabyToochGrowList() {
		return babyToochGrowList;
	}

	public void setBabyToochGrowList(List<BabyToochGrowVo> babyToochGrowList) {
		this.babyToochGrowList = babyToochGrowList;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
