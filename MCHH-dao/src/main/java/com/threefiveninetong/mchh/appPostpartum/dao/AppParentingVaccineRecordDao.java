/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingVaccineRecordDao.java 
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

import com.threefiveninetong.mchh.appPostpartum.po.AppParentingVaccineRecordPO;

/**
 * @ClassName: AppParentingVaccineRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingVaccineRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingVaccineRecord 
	 */
	public AppParentingVaccineRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingVaccineRecordPO> 
	 */
	public List<AppParentingVaccineRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingVaccineRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingVaccineRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingVaccineRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询宝宝疫苗接种记录
	 * @param map
	 * @return
	 */
	public List<AppParentingVaccineRecordPO> findAppParentingVaccineRecordListByCondition(Map<String,Object> map);

}