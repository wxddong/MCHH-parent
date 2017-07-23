/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SpecialDiseaseInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-10-20 17:23:54 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.SpecialDiseaseInfoPO;

/**
 * @ClassName: SpecialDiseaseInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-10-20 17:23:54 
 */
public interface SpecialDiseaseInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return SpecialDiseaseInfo 
	 */
	public SpecialDiseaseInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SpecialDiseaseInfoPO> 
	 */
	public List<SpecialDiseaseInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SpecialDiseaseInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SpecialDiseaseInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<SpecialDiseaseInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据检查结果id获取特殊疾病信息
	 * @param resultId
	 * @return
	 */
	public SpecialDiseaseInfoPO getSpecialById(String resultId);

	/**
	 * 保存特殊疾病项的修改
	 * @param specialDiseaseInfoPO
	 */
	public void updateByResultId(SpecialDiseaseInfoPO specialDiseaseInfoPO);

	public List<SpecialDiseaseInfoPO> sexDisNum(Map<String, Object> conds);

	public String getDisNameById(String disId);

}