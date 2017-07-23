/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalWeightRecordDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalWeightRecordPO;

/**
 * @ClassName: AppPrenatalWeightRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public interface AppPrenatalWeightRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalWeightRecord 
	 */
	public AppPrenatalWeightRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppPrenatalWeightRecordPO> 
	 */
	public List<AppPrenatalWeightRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalWeightRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppPrenatalWeightRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppPrenatalWeightRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询孕产期体重信息
	 * @param map
	 * @return
	 */
	public List<AppPrenatalWeightRecordPO> findAppPrenatalWeightRecordListByConditon(Map<String,Object> map);

}