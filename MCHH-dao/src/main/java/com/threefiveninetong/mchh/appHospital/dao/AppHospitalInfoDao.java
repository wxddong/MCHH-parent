/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppHospitalInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appHospital.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appHospital.po.AppHospitalInfoPO;

/**
 * @ClassName: AppHospitalInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public interface AppHospitalInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppHospitalInfo 
	 */
	public AppHospitalInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppHospitalInfoPO> 
	 */
	public List<AppHospitalInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppHospitalInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppHospitalInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppHospitalInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}