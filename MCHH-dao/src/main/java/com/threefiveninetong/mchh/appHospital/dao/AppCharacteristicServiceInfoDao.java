/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppCharacteristicServiceInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appHospital.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appHospital.po.AppCharacteristicServiceInfoPO;

/**
 * @ClassName: AppCharacteristicServiceInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public interface AppCharacteristicServiceInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppCharacteristicServiceInfo 
	 */
	public AppCharacteristicServiceInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppCharacteristicServiceInfoPO> 
	 */
	public List<AppCharacteristicServiceInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppCharacteristicServiceInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppCharacteristicServiceInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppCharacteristicServiceInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询医院特色服务项目信息
	 * @param map
	 * @return
	 */
	public List<AppCharacteristicServiceInfoPO> findAppCharacteristicServiceListByCondition(Map<String,Object> map);

	/**
	 * 特色服务列表
	 * @param conds
	 * @return
	 */
	public List<AppCharacteristicServiceInfoPO> getAll(Map<String, Object> conds);

	/**
	 * 停用前验证
	 * @param serviceId
	 * @return
	 */
	public int getAppServiceByserviceId(String serviceId);

	/**
	 * 批量删除
	 * @param serviceIds
	 */
	public void changeStatus(Serializable[] serviceIds);

}