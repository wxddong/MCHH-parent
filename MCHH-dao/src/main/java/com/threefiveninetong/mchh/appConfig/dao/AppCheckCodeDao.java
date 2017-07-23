/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppCheckCodeDao.java 
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


import com.threefiveninetong.mchh.appConfig.po.AppCheckCodePO;

/**
 * @ClassName: AppCheckCodeDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppCheckCodeDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppCheckCode 
	 */
	public AppCheckCodePO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppCheckCodePO> 
	 */
	public List<AppCheckCodePO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppCheckCodePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppCheckCodePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppCheckCodePO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}