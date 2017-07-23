/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskTermDao.java 
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


import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;

/**
 * @ClassName: HighRiskTermDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public interface HighRiskTermDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return HighRiskTerm 
	 */
	public HighRiskTermPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<HighRiskTermPO> 
	 */
	public List<HighRiskTermPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HighRiskTermPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(HighRiskTermPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<HighRiskTermPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * wangxd 2016.9.6
	 * 根据高危项管理id获取所有的高危项
	 * @param highRiskId
	 * @return
	 */
	public List<String> getItemsByHighRiskId(String highRiskId);

	/**
	 * 获取本次产检专案管理的所有未校正高危项
	 * @param highRiskId
	 * @return
	 * @author yanwk
	 */
	public List<HighRiskTermPO> getAllTermByhighRiskId(String highRiskId);

	/**
	 * 获取本次产检专案管理的所有高危项
	 * @param highRiskId
	 * @return
	 * @author yanwk
	 */
	public List<HighRiskTermPO> getThisHighRiskTermByHighRiskId(String highRiskId);

	/**
	 * 修改重新保存高危项
	 * @param highRiskId
	 */
	public void removeByHighRiskId(String highRiskId);

	/**
	 * 通过高危专案表id和已矫正状态获取高危项个数
	 * @param highRiskId
	 * @return
	 * @author yanwk
	 */
	public int getCountByHighRiskIdAndState(String highRiskId);

}