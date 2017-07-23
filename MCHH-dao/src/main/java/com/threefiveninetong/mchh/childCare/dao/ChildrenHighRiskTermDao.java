/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskTermDao.java 
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


import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskTermPO;

/**
 * @ClassName: ChildrenHighRiskTermDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
public interface ChildrenHighRiskTermDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenHighRiskTerm 
	 */
	public ChildrenHighRiskTermPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenHighRiskTermPO> 
	 */
	public List<ChildrenHighRiskTermPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenHighRiskTermPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenHighRiskTermPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenHighRiskTermPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}