/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationTemperatureRecordDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPremarital.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPremarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appPremarital.po.AppPreparationTemperatureRecordPO;

/**
 * @ClassName: AppPreparationTemperatureRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public interface AppPreparationTemperatureRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPreparationTemperatureRecord 
	 */
	public AppPreparationTemperatureRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppPreparationTemperatureRecordPO> 
	 */
	public List<AppPreparationTemperatureRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPreparationTemperatureRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppPreparationTemperatureRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppPreparationTemperatureRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	
	/**
	 * 条件查询备孕期体温信息
	 * @param map
	 * @return
	 */
	public List<AppPreparationTemperatureRecordPO> findAppPreparationTemperatureRecordListByCondition(Map<String,Object> map);
}