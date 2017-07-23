/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenLastStatusInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childCare.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 15:57:51 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childCare.po.ChildrenLastStatusInfoPO;

/**
 * @ClassName: ChildrenLastStatusInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 15:57:51 
 */
public interface ChildrenLastStatusInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenLastStatusInfo 
	 */
	public ChildrenLastStatusInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildrenLastStatusInfoPO> 
	 */
	public List<ChildrenLastStatusInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenLastStatusInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildrenLastStatusInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildrenLastStatusInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 修改最后修改时间
	 * @param date
	 * @author ywk
	 */
	public void updateCreatTime(ChildrenLastStatusInfoPO po);

}