/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPhysiqueExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childCare.po.ChildrenPhysiqueExaInfoPO;

/**
 * @ClassName: ChildrenPhysiqueExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:03 
 */
public interface ChildrenPhysiqueExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenPhysiqueExaInfo 
	 */
	public ChildrenPhysiqueExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenPhysiqueExaInfoPO> 
	 */
	public List<ChildrenPhysiqueExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenPhysiqueExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenPhysiqueExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenPhysiqueExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}