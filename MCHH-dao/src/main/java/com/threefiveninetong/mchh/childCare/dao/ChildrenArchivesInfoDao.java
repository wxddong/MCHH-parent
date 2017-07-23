/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenArchivesInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 15:57:49 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childCare.po.ChildrenArchivesInfoPO;

/**
 * @ClassName: ChildrenArchivesInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 15:57:49 
 */
public interface ChildrenArchivesInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenArchivesInfo 
	 */
	public ChildrenArchivesInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenArchivesInfoPO> 
	 */
	public List<ChildrenArchivesInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenArchivesInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenArchivesInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenArchivesInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 生成档案号专用
	 * @param code
	 * @return
	 * @author ywk
	 */
	public int getCountCode(String code);

	/**
	 * 删除档案信息
	 * @param archivesId
	 * @author ywk
	 */
	public void delArchivesById(String archivesId);

}