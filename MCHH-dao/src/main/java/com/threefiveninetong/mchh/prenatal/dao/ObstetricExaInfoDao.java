/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ObstetricExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;

/**
 * @ClassName: ObstetricExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
public interface ObstetricExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ObstetricExaInfo 
	 */
	public ObstetricExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ObstetricExaInfoPO> 
	 */
	public List<ObstetricExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ObstetricExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ObstetricExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ObstetricExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过产检id获取产科检查信息
	 * @param prenatalId
	 * @return
	 */
	public ObstetricExaInfoPO getobstetricExaByPrenatalId(String prenatalId);

	/**
	 * 修改编辑
	 * @param obstetricExaInfoPO
	 * @author yanwk
	 */
	public void edit(ObstetricExaInfoPO obstetricExaInfoPO);

	public ObstetricExaInfoPO getObstetricExaInfo(String firstId);

}