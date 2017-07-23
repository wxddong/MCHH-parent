/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneYearSixRecordDao.java 
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


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearSixRecordPO;

/**
 * @ClassName: AppParentingOneYearSixRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingOneYearSixRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingOneYearSixRecord 
	 */
	public AppParentingOneYearSixRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingOneYearSixRecordPO> 
	 */
	public List<AppParentingOneYearSixRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingOneYearSixRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingOneYearSixRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingOneYearSixRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询月育儿期一岁六月龄记录表
	 * @param map
	 * @return
	 */
	public List<AppParentingOneYearSixRecordPO> findAppParentingOneYearSixRecordListByCondition(Map<String,Object> map);

}