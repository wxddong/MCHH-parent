package com.threefiveninetong.mchh.highriskmaternalmanage.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskMaternalManagePO;
import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskProjectMmanagementPO;

public interface HighRiskProjectMmanagementDao {

	
	/**
	 * 高危孕产妇管理个人专案管理列表
	 * wangxd 2016.9.20
	 * @param conds
	 * @return
	 */
	List<HighRiskProjectMmanagementPO> listForPage(Map<String, Object> conds);

	/**
	 * 根据产前检查id获取高危的动态因素和静态因素
	 * wangxd 2016.9.20
	 * @param preExaId
	 * @return
	 */
	Map<String,String> getRiskByPreExaId(String preExaId);

	/**
	 * 获取基本信息放在map里
	 * wangxd 2016.9.20
	 * @param birthArchiveId
	 * @return
	 */
	Map<String, Object> getMessageByPreExaId(String birthArchiveId);

}
