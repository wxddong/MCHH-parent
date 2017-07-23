/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationBasicInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPremarital.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPremarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appPremarital.po.AppPreparationBasicInfoPO;

/**
 * @ClassName: AppPreparationBasicInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public interface AppPreparationBasicInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPreparationBasicInfo 
	 */
	public AppPreparationBasicInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppPreparationBasicInfoPO> 
	 */
	public List<AppPreparationBasicInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPreparationBasicInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppPreparationBasicInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppPreparationBasicInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询备孕期基本信息
	 * @param map
	 * @return
	 */
	public List<AppPreparationBasicInfoPO> findAppPreparationBasicListByConditon(Map<String,Object> map);

}