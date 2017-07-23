/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEarlyStageDetailsDao.java 
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


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEarlyStageDetailsPO;

/**
 * @ClassName: AppParentingEarlyStageDetailsDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingEarlyStageDetailsDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingEarlyStageDetails 
	 */
	public AppParentingEarlyStageDetailsPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingEarlyStageDetailsPO> 
	 */
	public List<AppParentingEarlyStageDetailsPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingEarlyStageDetailsPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingEarlyStageDetailsPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingEarlyStageDetailsPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询新生儿早期记录详情表信息
	 * @param map
	 * @return
	 */
	public List<AppParentingEarlyStageDetailsPO> findAppParentingEarlyStageDetailsListByCondition(Map<String,Object> map);

}