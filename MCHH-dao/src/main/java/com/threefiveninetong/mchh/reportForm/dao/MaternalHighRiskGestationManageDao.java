package com.threefiveninetong.mchh.reportForm.dao;

import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.reportForm.po.MaternalHighRiskGestationManagePO;

public interface MaternalHighRiskGestationManageDao {

	/**
	 * 高危妊娠管理统计列表查询
	 * @param conds
	 * @return 
	 */
	List<MaternalHighRiskGestationManagePO> listForPage(Map<String, Object> conds);

	int getMaternalManageNum(Map<String, Object> conds);

	int getTurnOnNum(Map<String, Object> conds);

}
