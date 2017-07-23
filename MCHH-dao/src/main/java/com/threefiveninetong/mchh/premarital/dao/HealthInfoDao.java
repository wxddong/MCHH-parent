/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HealthInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.HealthInfoPO;

/**
 * @ClassName: HealthInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
public interface HealthInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return HealthInfo 
	 */
	public HealthInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<HealthInfoPO> 
	 */
	public List<HealthInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HealthInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(HealthInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<HealthInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据婚检id获取健康状况信息
	 * @param premaritalId
	 * @return
	 */
	public HealthInfoPO getHealthByPremaritalId(String premaritalId);

	/**
	 * 修改婚检
	 * @param po
	 */
	public void edit(HealthInfoPO po);

}