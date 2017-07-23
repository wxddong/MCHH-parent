/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppActivationStatisticsDao.java 
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


import com.threefiveninetong.mchh.appStatis.po.AppActivationStatisticsPO;

/**
 * @ClassName: AppActivationStatisticsDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
public interface AppActivationStatisticsDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppActivationStatistics 
	 */
	public AppActivationStatisticsPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppActivationStatisticsPO> 
	 */
	public List<AppActivationStatisticsPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppActivationStatisticsPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppActivationStatisticsPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppActivationStatisticsPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}