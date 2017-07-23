/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingFiveYearRecordDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:10 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFiveYearRecordPO;

/**
 * @ClassName: AppParentingFiveYearRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:10 
 */
public interface AppParentingFiveYearRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingFiveYearRecord 
	 */
	public AppParentingFiveYearRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingFiveYearRecordPO> 
	 */
	public List<AppParentingFiveYearRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingFiveYearRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingFiveYearRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingFiveYearRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询育儿期五岁记录表
	 * @param map
	 * @return
	 */
	public List<AppParentingFiveYearRecordPO> findAppParentingFiveYearRecordListByConditon(Map<String,Object> map);
}