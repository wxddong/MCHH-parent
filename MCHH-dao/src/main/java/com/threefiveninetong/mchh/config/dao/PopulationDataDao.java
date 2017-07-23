/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PopulationDataDao.java 
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


import com.threefiveninetong.mchh.config.po.PopulationDataPO;

/**
 * @ClassName: PopulationDataDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public interface PopulationDataDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PopulationData 
	 */
	public PopulationDataPO findPopulation(Serializable id);
	
	
	/**
	 * 查找单个 县
	 * @param id 
	 * @return PopulationData 
	 */
	public PopulationDataPO findCountry(Serializable id);
	
	
	
	/**
	 * 查找单个 乡
	 * @param id 
	 * @return PopulationData 
	 */
	public PopulationDataPO findtow(Serializable id);
	
	
	
	/**
	 * 查找单个村
	 * @param id 
	 * @return PopulationData 
	 */
	public PopulationDataPO findVill(Serializable id);


	/**
	 * 查找所有 
	 * @return List<PopulationDataPO> 
	 */
	public List<PopulationDataPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PopulationDataPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PopulationDataPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PopulationDataPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 查找所有
	 * 查询县，乡 
	 * 注此方法后台用
	 */
	public List<PopulationDataPO> DistictlistForPage(Map<String, Object> conds);
	
	
	/**
	 * 查找所有
	 * 查询县，乡，镇 
	 * 注此方法后台用
	 */
	public List<PopulationDataPO> villlistForPage(Map<String, Object> conds);
	
	
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}