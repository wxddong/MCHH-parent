package com.threefiveninetong.mchh.highriskmaternalmanage.dao;

import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskMaternalManagePO;

public interface HighRiskMaternalManageDao {

	/**
	 * 高危孕产妇管理分页列表
	 * @param conds
	 * @return
	 */
	List<HighRiskMaternalManagePO> listForPage(Map<String, Object> conds);

	int getIncreaseNumToday(String depId);

	int getInNumToday(String depId);

	int getOutNumToday(String depId);

	int getTotalNum(String depId);

	String getAllPeopleNum(String depId);

}
