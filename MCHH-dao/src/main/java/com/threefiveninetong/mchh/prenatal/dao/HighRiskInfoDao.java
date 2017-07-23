/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;

/**
 * @ClassName: HighRiskInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public interface HighRiskInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return HighRiskInfo 
	 */
	public HighRiskInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<HighRiskInfoPO> 
	 */
	public List<HighRiskInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HighRiskInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(HighRiskInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<HighRiskInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * wangxd 2016.9.6
	 * 根据产前检查的id获取高危管理列表
	 * @param firstId
	 * @return
	 */
	public HighRiskInfoPO getHighRiskByprenatalExaId(String firstId);
	
	/**
	 * 保存产检id到高位表
	 * @param highRiskInfoPO
	 * @author yanwk
	 */
	public void savePrenatalExaId(HighRiskInfoPO highRiskInfoPO);

	/**
	 * 修改高危管理表
	 * @param editHighRisk
	 */
	public void editHighRisk(HighRiskInfoPO editHighRisk);

}