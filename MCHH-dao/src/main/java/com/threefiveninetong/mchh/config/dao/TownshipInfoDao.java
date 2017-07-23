/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: TownshipInfoDao.java 
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

import com.threefiveninetong.mchh.config.po.TownshipInfoPO;

/**
 * @ClassName: TownshipInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public interface TownshipInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return TownshipInfo 
	 */
	public TownshipInfoPO find(Serializable id);

	
	/**
	 * 查找单个 
	 * @param id 
	 * @return TownshipInfo 
	 */
	public TownshipInfoPO findByName(String name);
	
	
	/**
	 * 查找所有 
	 * @return List<TownshipInfoPO> 
	 */
	public List<TownshipInfoPO> findAll();
	
	
	/**
	 * 查找所有县下面所有的乡 
	 * @return List<TownshipInfoPO> 
	 */
	public List<TownshipInfoPO> findAllByCountyId(String countyId);
	
	
	

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(TownshipInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(TownshipInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<TownshipInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 通过县id查出下边所有的乡镇
	 * @param countyId
	 * @return
	 */
	public List<TownshipInfoPO> getTownshipByCountyId(String countyId);

	/**
	 * 添加
	 * wangxd 2016.8.26
	 * @param po
	 */
	public void addTownshipInfo(TownshipInfoPO po);

	/**
	 * 修改
	 * wangxd 2016.8.26
	 * @param po
	 * @param po
	 */
	public void updateTownshipInfo(TownshipInfoPO po);

	/**
	 * 查询街道含有的村庄数
	 * 2016.8.26
	 * @param townIds
	 * @return
	 */
	public int getVillageCountByTownId(String townId);

	/**
	 * 删除街道乡
	 * @param townIds
	 */
	public void delTownshipInfo(Serializable[] townIds);

	/**
	 * 查询乡名称
	 * @return
	 */
	public List<TownshipInfoPO> queryXiangName();

	public List<String> findAllSortNum();


	public List<TownshipInfoPO> findAlls(String parentId);


	public TownshipInfoPO getByName(String name);
}