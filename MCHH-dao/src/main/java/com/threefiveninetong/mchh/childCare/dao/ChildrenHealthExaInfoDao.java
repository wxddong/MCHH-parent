/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHealthExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:02 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childCare.po.ChildrenHealthExaInfoPO;

/**
 * @ClassName: ChildrenHealthExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:02 
 */
public interface ChildrenHealthExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenHealthExaInfo 
	 */
	public ChildrenHealthExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenHealthExaInfoPO> 
	 */
	public List<ChildrenHealthExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenHealthExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenHealthExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenHealthExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 查询所有的检查记录通过档案Id不区分保存还是完成
	 * @param archivesId
	 * @return
	 * @author ywk
	 */
	public List<ChildrenHealthExaInfoPO> getAllExaByArchivesId(String archivesId);

}