/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingTwoYearRecordDao.java 
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


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearRecordPO;

/**
 * @ClassName: AppParentingTwoYearRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingTwoYearRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingTwoYearRecord 
	 */
	public AppParentingTwoYearRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingTwoYearRecordPO> 
	 */
	public List<AppParentingTwoYearRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingTwoYearRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingTwoYearRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingTwoYearRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 条件查询育儿期两岁龄记录表
	 * @param map
	 * @return
	 */
	public List<AppParentingTwoYearRecordPO> findAppParentingTwoYearRecordListByCondition(Map<String,Object> map);
}