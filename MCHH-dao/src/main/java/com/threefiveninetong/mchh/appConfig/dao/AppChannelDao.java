/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppChannelDao.java 
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

import com.threefiveninetong.mchh.appConfig.po.AppChannelPO;

/**
 * @ClassName: AppChannelDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppChannelDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppChannel 
	 */
	public AppChannelPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppChannelPO> 
	 */
	public List<AppChannelPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppChannelPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppChannelPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppChannelPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
     * 根据渠道查找
     * 
     * @param id
     * @return Chanel
     */
    public AppChannelPO findBychannelNO(@Param(value = "channelNO") String channelNO);

}