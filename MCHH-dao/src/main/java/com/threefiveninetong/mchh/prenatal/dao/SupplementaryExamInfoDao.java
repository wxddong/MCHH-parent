/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SupplementaryExamInfoDao.java 
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


import com.threefiveninetong.mchh.prenatal.po.SupplementaryExamInfoPO;

/**
 * @ClassName: SupplementaryExamInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
public interface SupplementaryExamInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return SupplementaryExamInfo 
	 */
	public SupplementaryExamInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SupplementaryExamInfoPO> 
	 */
	public List<SupplementaryExamInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SupplementaryExamInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SupplementaryExamInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<SupplementaryExamInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过第一检查产检表id获取第一次检查辅助检查表信息
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	public SupplementaryExamInfoPO getSupplemetnaryExamByPrenatalId(String prenatalId);

	/**
	 * 删除记录通过产检id
	 * @param examinationId
	 * @author yanwk
	 */
	public void deleteByPrenatalId(String examinationId);

}