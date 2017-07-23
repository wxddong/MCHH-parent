/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppAdvertisingDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appConfig.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-11-02 10:45:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appConfig.po.AppAdvertisingPO;

/**
 * @ClassName: AppAdvertisingDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:03 
 */
public interface AppAdvertisingDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppAdvertising 
	 */
	public AppAdvertisingPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppAdvertisingPO> 
	 */
	public List<AppAdvertisingPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppAdvertisingPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppAdvertisingPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppAdvertisingPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
     * 查找启动的广告图片
     * @return Advertising
     */
    public AppAdvertisingPO findStartUp();
}