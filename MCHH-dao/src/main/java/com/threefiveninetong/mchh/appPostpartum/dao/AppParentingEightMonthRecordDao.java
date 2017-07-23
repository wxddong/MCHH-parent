/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEightMonthRecordDao.java 
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


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEightMonthRecordPO;

/**
 * @ClassName: AppParentingEightMonthRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingEightMonthRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingEightMonthRecord 
	 */
	public AppParentingEightMonthRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingEightMonthRecordPO> 
	 */
	public List<AppParentingEightMonthRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingEightMonthRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingEightMonthRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingEightMonthRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询育儿期八月龄记录表信息
	 * @param map
	 * @return
	 */
	public List<AppParentingEightMonthRecordPO> findAppParentingEightMonthRecordListByCondition(Map<String,Object> map);

}