/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppVersionForcedUpdateDao.java 
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

import com.threefiveninetong.mchh.appConfig.po.AppVersionForcedUpdatePO;

/**
 * @ClassName: AppVersionForcedUpdateDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppVersionForcedUpdateDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppVersionForcedUpdate 
	 */
	public AppVersionForcedUpdatePO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppVersionForcedUpdatePO> 
	 */
	public List<AppVersionForcedUpdatePO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppVersionForcedUpdatePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppVersionForcedUpdatePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppVersionForcedUpdatePO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
     * 通过版本号、渠道、设备类型查找
     */
    public AppVersionForcedUpdatePO findByCode(@Param(value = "versionCode") String versionCode, @Param(value = "channelNO") String channelNO);

}