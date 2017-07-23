/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppVersionDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appConfig.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.threefiveninetong.mchh.appConfig.po.AppVersionPO;

/**
 * @ClassName: AppVersionDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppVersionDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppVersion 
	 */
	public AppVersionPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppVersionPO> 
	 */
	public List<AppVersionPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppVersionPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppVersionPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppVersionPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
     * 查询最新的版本信息
     * 
     */
    public AppVersionPO findNewestByEquType(@Param(value="channelCode") String channelCode);

}