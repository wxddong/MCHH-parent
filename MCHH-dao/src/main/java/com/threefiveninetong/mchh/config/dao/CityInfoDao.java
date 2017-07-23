/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: CityInfoDao.java 
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


import com.threefiveninetong.mchh.config.po.CityInfoPO;

/**
 * @ClassName: CityInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
public interface CityInfoDao{
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 * wangxd 2016.8.23
	 */
	public List<CityInfoPO> listForPage(Map<String, Object> conds);
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return CityInfo 
	 */
	public CityInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<CityInfoPO> 
	 */
	public List<CityInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void addCityInfo(CityInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(CityInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	public List<CityInfoPO> getCityByProvinceId(String provinceId);

	/**
	 * wangxd 2016.8.26
	 * @param cityId
	 * @return
	 */
	public int getCountyCountBycityId(String cityId);


	/**
	 * wangxd 2016.8.26
	 * @param cityIds
	 */
	public void delCityInfo(Serializable[] cityIds);

	/**
	 * 查询县名称
	 * @return
	 */
	public List<CityInfoPO> queryCountyName();


	public List<String> findAllSortNum();


	public CityInfoPO getByName(String name);
}