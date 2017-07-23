/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: VillageInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.config.po.VillageInfoPO;

/**
 * @ClassName: VillageInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public interface VillageInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return VillageInfo 
	 */
	public VillageInfoPO find(Serializable id);

	
	/**
	 * 查找单个 
	 * @param id 
	 * @return VillageInfo 
	 */
	public VillageInfoPO findByName(String name);
	
	
	/**
	 * 查找所有 
	 * @return List<VillageInfoPO> 
	 */
	public List<VillageInfoPO> findAll();
	
	/**
	 * 查找所有 
	 * @return List<VillageInfoPO> 
	 */
	public List<VillageInfoPO> findAllByVillage(Serializable id);
	
	

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(VillageInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(VillageInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * wangxd 2016.8.24
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<VillageInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过区县id查找所有乡镇
	 * @author yanwk
	 */
	public List<VillageInfoPO> getTownshipByCountyId(String townshipId);

	/**
	 * wangxd 2016.8.26
	 * @param po
	 */
	public void addVillageInfo(VillageInfoPO po);

	/**
	 * wangxd 2016.8.26
	 * @param po
	 */
	public void updateTownshipInfo(VillageInfoPO po);

	/**
	 * 删除
	 * wangxd 2016.8.26
	 * @param villageIds
	 */
	public void dedelVillageInfo(Serializable[] id);
	
	/**
	 * 查询村名称
	 * @return
	 */
	public List<VillageInfoPO> queryCunName();

	public List<String> findAllSortNum();


	public List<VillageInfoPO> findAlls(String parentId);


	public VillageInfoPO getByName(String name);

}