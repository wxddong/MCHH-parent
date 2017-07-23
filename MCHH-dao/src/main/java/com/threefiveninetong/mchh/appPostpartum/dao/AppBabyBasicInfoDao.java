/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppBabyBasicInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appPostpartum.po.AppBabyBasicInfoPO;

/**
 * @ClassName: AppBabyBasicInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppBabyBasicInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppBabyBasicInfo 
	 */
	public AppBabyBasicInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppBabyBasicInfoPO> 
	 */
	public List<AppBabyBasicInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppBabyBasicInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppBabyBasicInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppBabyBasicInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询宝宝基础信息
	 */
	public List<AppBabyBasicInfoPO> findAppBabyBasicListByConditon(Map<String,Object> map);
}