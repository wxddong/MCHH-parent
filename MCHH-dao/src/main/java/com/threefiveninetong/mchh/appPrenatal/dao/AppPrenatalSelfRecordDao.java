/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalSelfRecordDao.java 
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

import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordPO;

/**
 * @ClassName: AppPrenatalSelfRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public interface AppPrenatalSelfRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalSelfRecord 
	 */
	public AppPrenatalSelfRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppPrenatalSelfRecordPO> 
	 */
	public List<AppPrenatalSelfRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalSelfRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppPrenatalSelfRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppPrenatalSelfRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询孕产期自我情况信息
	 * @param map
	 * @return
	 */
	public List<AppPrenatalSelfRecordPO> findAppPrenatalSelfRecordListByCondition(Map<String,Object> map);

}