/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenReferralInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:04 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childCare.po.ChildrenReferralInfoPO;

/**
 * @ClassName: ChildrenReferralInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:04 
 */
public interface ChildrenReferralInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenReferralInfo 
	 */
	public ChildrenReferralInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenReferralInfoPO> 
	 */
	public List<ChildrenReferralInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenReferralInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenReferralInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenReferralInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}