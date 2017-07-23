package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appPostpartum.vo.req.BabyToochGrowVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询宝宝牙齿生长响应信息
 * @author zhanght
 */
public class PostpartumSearchBabyDentitionRecordRespVo extends BaseVo {
	
	private List<BabyToochGrowVo> babyToochGrowList;

	public List<BabyToochGrowVo> getBabyToochGrowList() {
		return babyToochGrowList;
	}

	public void setBabyToochGrowList(List<BabyToochGrowVo> babyToochGrowList) {
		this.babyToochGrowList = babyToochGrowList;
	}
}
