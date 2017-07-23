/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstMotherhoodInfoDao.java 
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


import com.threefiveninetong.mchh.prenatal.po.FirstMotherhoodInfoPO;

/**
 * @ClassName: FirstMotherhoodInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public interface FirstMotherhoodInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return FirstMotherhoodInfo 
	 */
	public FirstMotherhoodInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<FirstMotherhoodInfoPO> 
	 */
	public List<FirstMotherhoodInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(FirstMotherhoodInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(FirstMotherhoodInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<FirstMotherhoodInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过产检id获取第一次产检的孕妇信息
	 * @param firstPreantalExaId
	 * @return
	 * @author yanwk
	 */
	public FirstMotherhoodInfoPO getFirstMotherhoodByPreantalExaId(String firstPreantalExaId);
	
	/**
	 * 通过生育档案ID，查询第一次产前检查的预产信息
	 * @param birthArchivesId
	 * @return
	 */
	public FirstMotherhoodInfoPO getFirstMotherhoodByBirthArchivesId(String birthArchivesId);

	/**
	 * 修改编辑
	 * @param firstMotherhoodInfoPO
	 * @author yanwk
	 */
	public void edit(FirstMotherhoodInfoPO firstMotherhoodInfoPO);

}