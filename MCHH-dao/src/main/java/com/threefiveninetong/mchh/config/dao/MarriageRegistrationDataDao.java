/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: MarriageRegistrationDataDao.java 
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

import com.threefiveninetong.mchh.config.po.MarriageRegistrationDataPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalHealthCarePO;

/**
 * @ClassName: MarriageRegistrationDataDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public interface MarriageRegistrationDataDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return MarriageRegistrationData 
	 */
	public MarriageRegistrationDataPO find(Serializable id);
	
	
	/**
	 * 查找单个 通过区县id
	 * @param cityid 
	 * @return MarriageRegistrationData 
	 */
	public List<MarriageRegistrationDataPO> listForPage(Map<String, Object> conds);
	/**
	 * 查找所有 
	 * @return List<MarriageRegistrationDataPO> 
	 */
	public List<MarriageRegistrationDataPO> findAll();
	
	
	/**
	 * 查找所有的县区 
	 * @return List<MarriageRegistrationDataPO> 
	 */
	public List<ProvinceInfoPO> findCounty();
	
	
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void create(MarriageRegistrationDataPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(MarriageRegistrationDataPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PremaritalHealthCarePO> listForPage1(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}