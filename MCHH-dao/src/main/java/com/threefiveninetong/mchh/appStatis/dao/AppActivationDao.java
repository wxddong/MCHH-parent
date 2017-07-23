/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppActivationDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appStatis.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appStatis.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.threefiveninetong.mchh.appStatis.po.AppActivationPO;

/**
 * @ClassName: AppActivationDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
public interface AppActivationDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppActivation 
	 */
	public AppActivationPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppActivationPO> 
	 */
	public List<AppActivationPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppActivationPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppActivationPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppActivationPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
     * 通过设备号查找激活
     * 
     * @param id
     * @return Activation
     */
    public AppActivationPO findByEquipmentNo(@Param(value = "equipmentNo") String equipmentNo);

}