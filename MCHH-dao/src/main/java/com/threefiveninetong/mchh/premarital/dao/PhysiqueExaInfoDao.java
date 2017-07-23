/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PhysiqueExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.PhysiqueExaInfoPO;

/**
 * @ClassName: PhysiqueExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
public interface PhysiqueExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PhysiqueExaInfo 
	 */
	public PhysiqueExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PhysiqueExaInfoPO> 
	 */
	public List<PhysiqueExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PhysiqueExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PhysiqueExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PhysiqueExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据婚检id获取体格检查信息
	 * @param premaritalId
	 * @return
	 */
	public PhysiqueExaInfoPO getPhysiqueByPremaritalId(String premaritalId);

	/**
	 * 修改
	 * @param physiqueExaInfoPO
	 */
	public void edit(PhysiqueExaInfoPO physiqueExaInfoPO);

}