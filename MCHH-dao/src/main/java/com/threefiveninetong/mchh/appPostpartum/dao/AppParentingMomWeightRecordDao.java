/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingMomWeightRecordDao.java 
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

import com.threefiveninetong.mchh.appPostpartum.po.AppParentingMomWeightRecordPO;

/**
 * @ClassName: AppParentingMomWeightRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingMomWeightRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingMomWeightRecord 
	 */
	public AppParentingMomWeightRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingMomWeightRecordPO> 
	 */
	public List<AppParentingMomWeightRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingMomWeightRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingMomWeightRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingMomWeightRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询育儿期妈妈体重信息
	 * @param map
	 * @return
	 */
	public List<AppParentingMomWeightRecordPO> findAppParentingMomWeightRecordListByCondition(Map<String,Object> map);

}