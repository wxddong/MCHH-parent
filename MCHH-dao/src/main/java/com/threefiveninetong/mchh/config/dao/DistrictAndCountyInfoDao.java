/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DistrictAndCountyInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;

/**
 * @ClassName: DistrictAndCountyInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
public interface DistrictAndCountyInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return DistrictAndCountyInfo 
	 */
	public DistrictAndCountyInfoPO findByName(String name);
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return DistrictAndCountyInfo 
	 */
	public DistrictAndCountyInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<DistrictAndCountyInfoPO> 
	 */
	public List<DistrictAndCountyInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(DistrictAndCountyInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(DistrictAndCountyInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<DistrictAndCountyInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过城市id获取市下边所有的区县
	 * @param cityId
	 * @return
	 * @author yanwk
	 */
	public List<DistrictAndCountyInfoPO> getDistrictandcountyByCityId(String cityId);

	/**
	 * 2016.8.25 wangxd
	 * @param districtAndCountyInfoPO
	 */
	public void addCounty(DistrictAndCountyInfoPO po);

	/**
	 * 2016.8.25 wangxd
	 * @param countyId
	 * @return
	 */
	public int getTownCountByCountyId(String countyId);

	/**
	 * 2016.8.25 wangxd
	 * @param countyIds
	 */
	public void delDistrictAndCountyInfo(Serializable[] countyIds);

	public List<String> findAllSortNum();
	
	public List<DistrictAndCountyInfoPO> queryXianName();

	public DistrictAndCountyInfoPO getByName(String name);

}