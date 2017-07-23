/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: InspectionResultDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:02 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;

/**
 * @ClassName: InspectionResultDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:02 
 */
public interface InspectionResultDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return InspectionResult 
	 */
	public InspectionResultPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<InspectionResultPO> 
	 */
	public List<InspectionResultPO> findAll();
	
	/**
	 * 查找所有得病的人数 
	 * @return List<InspectionResultPO> 
	 */
	public List<InspectionResultPO> findAllIll();
	
	/**
	 * 查找所有进行过咨询的人数 
	 * @return List<InspectionResultPO> 
	 */
	public List<InspectionResultPO> findAllAsk();
	
	
	
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void create(InspectionResultPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(InspectionResultPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<InspectionResultPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据婚检id获取检查结果信息
	 * @param premaritalId
	 * @return
	 */
	public InspectionResultPO getInspectionByPremaritalId(String premaritalId);

	/**
	 * 修改
	 * @param inspectionResultPO
	 */
	public void edit(InspectionResultPO inspectionResultPO);

}