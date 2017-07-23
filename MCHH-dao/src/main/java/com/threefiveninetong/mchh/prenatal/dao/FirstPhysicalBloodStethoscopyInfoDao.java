/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstPhysicalBloodStethoscopyInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.prenatal.po.FirstPhysicalBloodStethoscopyInfoPO;

/**
 * @ClassName: FirstPhysicalBloodStethoscopyInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
public interface FirstPhysicalBloodStethoscopyInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return FirstPhysicalBloodStethoscopyInfo 
	 */
	public FirstPhysicalBloodStethoscopyInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<FirstPhysicalBloodStethoscopyInfoPO> 
	 */
	public List<FirstPhysicalBloodStethoscopyInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(FirstPhysicalBloodStethoscopyInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(FirstPhysicalBloodStethoscopyInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<FirstPhysicalBloodStethoscopyInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过第一次产检id获取第一次产检基本信息
	 * @param prenatalId
	 * @return
	 */
	public FirstPhysicalBloodStethoscopyInfoPO getPhysicalBloodByPrenatalId(String prenatalId);

	/**
	 * 修改编辑
	 * @param firstPhysicalBloodStethoscopyInfoPO
	 */
	public void edit(FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO);

}