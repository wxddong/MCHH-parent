/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childbirth.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:04 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childbirth.po.ChildbirthInfoPO;

/**
 * @ClassName: ChildbirthInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:04 
 */
public interface ChildbirthInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthInfo 
	 */
	public ChildbirthInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildbirthInfoPO> 
	 */
	public List<ChildbirthInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildbirthInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildbirthInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据分娩基本信息id获取到分娩信息表数据
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public ChildbirthInfoPO getChildbirthByBasicId(String id);

}