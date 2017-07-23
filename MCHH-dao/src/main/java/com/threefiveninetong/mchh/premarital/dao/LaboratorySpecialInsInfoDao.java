/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: LaboratorySpecialInsInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.LaboratorySpecialInsInfoPO;

/**
 * @ClassName: LaboratorySpecialInsInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
public interface LaboratorySpecialInsInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return LaboratorySpecialInsInfo 
	 */
	public LaboratorySpecialInsInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<LaboratorySpecialInsInfoPO> 
	 */
	public List<LaboratorySpecialInsInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(LaboratorySpecialInsInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(LaboratorySpecialInsInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<LaboratorySpecialInsInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据婚检id获取实验室检查信息
	 * @param premaritalId
	 * @return
	 */
	public LaboratorySpecialInsInfoPO getLaboratoryByPremaritalId(String premaritalId);

	/**
	 * 修改
	 * @param laboratorySpecialInsInfoPO
	 */
	public void edit(LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO);

}