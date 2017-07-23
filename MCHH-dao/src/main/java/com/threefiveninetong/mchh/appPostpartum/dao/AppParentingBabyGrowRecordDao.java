/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingBabyGrowRecordDao.java 
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


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyGrowRecordPO;

/**
 * @ClassName: AppParentingBabyGrowRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingBabyGrowRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingBabyGrowRecord 
	 */
	public AppParentingBabyGrowRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingBabyGrowRecordPO> 
	 */
	public List<AppParentingBabyGrowRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingBabyGrowRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingBabyGrowRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingBabyGrowRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询宝宝生产记录信息
	 * @param map
	 * @return
	 */
	public List<AppParentingBabyGrowRecordPO> findAppParentingBabyGrowRecordListByCondition(Map<String,Object> map);

}