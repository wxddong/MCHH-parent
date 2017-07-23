/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:05 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskInfoPO;

/**
 * @ClassName: ChildrenHighRiskInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
public interface ChildrenHighRiskInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenHighRiskInfo 
	 */
	public ChildrenHighRiskInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenHighRiskInfoPO> 
	 */
	public List<ChildrenHighRiskInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenHighRiskInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenHighRiskInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenHighRiskInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}