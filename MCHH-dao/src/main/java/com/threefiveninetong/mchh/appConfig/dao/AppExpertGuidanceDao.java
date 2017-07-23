/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppExpertGuidanceDao.java 
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


import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;

/**
 * @ClassName: AppExpertGuidanceDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppExpertGuidanceDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppExpertGuidance 
	 */
	public AppExpertGuidancePO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppExpertGuidancePO> 
	 */
	public List<AppExpertGuidancePO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppExpertGuidancePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppExpertGuidancePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppExpertGuidancePO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	 
	/**
	 * 条件查询专家指导意见
	 * @param map
	 * @return
	 */
	public List<AppExpertGuidancePO> findAppExpertGuidanceListByCondition(Map<String,Object> map);

}