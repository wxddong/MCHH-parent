/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ProvinceInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;

/**
 * @ClassName: ProvinceInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public interface ProvinceInfoDao{
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 * wangxd 2016.08.22
	 */
	public List<ProvinceInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 添加
	 * @param PO
	 * wangxd 2016.8.23
	 */
	public void addProvinceInfo(ProvinceInfoPO PO);
	
	/**
	 * 修改 
	 * wangxd 2016.8.23
	 * @param po 
	 */
	public void update(ProvinceInfoPO po);

	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ProvinceInfo 
	 */
	public ProvinceInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ProvinceInfoPO> 
	 */
	public List<ProvinceInfoPO> findAll();

	
	

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * wangxd 2016.8.26
	 * @param provinceId
	 * @return
	 */
	public int getCityCountByProvinceId(String provinceId);

	/**
	 * wangxd 2016.8.26
	 * @param provinceIds
	 */
	public void delProvinceInfo(Serializable[] provinceIds);

	public List<String> findAllSortNum();

	public ProvinceInfoPO getByName(String name);


	


}