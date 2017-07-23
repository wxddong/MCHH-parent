/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppIosPushDevicetokenDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appStatis.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appStatis.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appStatis.po.AppIosPushDevicetokenPO;

/**
 * @ClassName: AppIosPushDevicetokenDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
public interface AppIosPushDevicetokenDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppIosPushDevicetoken 
	 */
	public AppIosPushDevicetokenPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppIosPushDevicetokenPO> 
	 */
	public List<AppIosPushDevicetokenPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppIosPushDevicetokenPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppIosPushDevicetokenPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppIosPushDevicetokenPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询IOS推送信息
	 * @param map
	 * @return
	 */
	public List<AppIosPushDevicetokenPO> findDevicetokenListByCondition(Map<String,Object> map);
}