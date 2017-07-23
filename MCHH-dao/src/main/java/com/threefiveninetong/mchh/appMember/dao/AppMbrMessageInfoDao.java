/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrMessageInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appMember.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;

/**
 * @ClassName: AppMbrMessageInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppMbrMessageInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMbrMessageInfo 
	 */
	public AppMbrMessageInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppMbrMessageInfoPO> 
	 */
	public List<AppMbrMessageInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMbrMessageInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppMbrMessageInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppMbrMessageInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询通知信息
	 * @param map
	 * @return
	 */
	public List<AppMbrMessageInfoPO> findAppMbrMessageListByCondition(Map<String,Object> map);
}