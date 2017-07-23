/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstGynecologicalExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.prenatal.po.FirstGynecologicalExaInfoPO;

/**
 * @ClassName: FirstGynecologicalExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public interface FirstGynecologicalExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return FirstGynecologicalExaInfo 
	 */
	public FirstGynecologicalExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<FirstGynecologicalExaInfoPO> 
	 */
	public List<FirstGynecologicalExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(FirstGynecologicalExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(FirstGynecologicalExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<FirstGynecologicalExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过产检id查询妇科检查信息
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	public FirstGynecologicalExaInfoPO getGynecologByPrenatalId(String prenatalId);

	/**
	 * 修改编辑
	 * @param firstGynecologicalExaInfoPO
	 */
	public void edit(FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO);

}