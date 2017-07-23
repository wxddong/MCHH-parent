/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskPregnancyScoreDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;

/**
 * @ClassName: HighRiskPregnancyScoreDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public interface HighRiskPregnancyScoreDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return HighRiskPregnancyScore 
	 */
	public HighRiskPregnancyScorePO find(Serializable id);

	/**
	 * 查找单个 
	 * @param name 
	 * @return HighRiskPregnancyScore 
	 */
	public HighRiskPregnancyScorePO getHighRiskPregnancyScorePOByname(String name);

	/**
	 * 查找单个 
	 * @param name 
	 * @return HighRiskPregnancyScore 
	 */
	public HighRiskPregnancyScorePO findHighRiskPregnancyScorePOByname(String name);
	
	
	/**
	 * 查找所有 
	 * @return List<HighRiskPregnancyScorePO> 
	 */
	public List<HighRiskPregnancyScorePO> findAll();
	
	/**
	 * 查找所有婴儿高危 
	 * @return List<HighRiskPregnancyScorePO> 
	 */
	public List<HighRiskPregnancyScorePO> findAllBaby();
	
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HighRiskPregnancyScorePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(HighRiskPregnancyScorePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有
	 * 孕妇 
	 * 注此方法后台用
	 */
	public List<HighRiskPregnancyScorePO> listForPage(Map<String, Object> conds);
	
	/**
	 * 查找所有
	 * 儿童 
	 * 注此方法后台用
	 */
	public List<HighRiskPregnancyScorePO> listForPageBaby(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 查出所有高危数据
	 * @return
	 * @author yanwk
	 */
	public List<HighRiskPregnancyScorePO> selectAll();

}