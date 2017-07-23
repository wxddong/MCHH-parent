/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingSixMonthRecordDao.java 
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

import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixMonthRecordPO;

/**
 * @ClassName: AppParentingSixMonthRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingSixMonthRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingSixMonthRecord 
	 */
	public AppParentingSixMonthRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingSixMonthRecordPO> 
	 */
	public List<AppParentingSixMonthRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingSixMonthRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingSixMonthRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingSixMonthRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询育儿期六月龄记录表信息
	 * @param map
	 * @return
	 */
	public List<AppParentingSixMonthRecordPO> findAppParentingSixMonthRecordListByCondition(Map<String,Object> map);
}