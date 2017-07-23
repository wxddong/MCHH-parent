/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaDetailedInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.postpartum.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.postpartum.po.PostpartumExaDetailedInfoPO;

/**
 * @ClassName: PostpartumExaDetailedInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
public interface PostpartumExaDetailedInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumExaDetailedInfo 
	 */
	public PostpartumExaDetailedInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PostpartumExaDetailedInfoPO> 
	 */
	public List<PostpartumExaDetailedInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PostpartumExaDetailedInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PostpartumExaDetailedInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PostpartumExaDetailedInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	

	/**
	 * 根据产后检查的id获取产后检查详细信息表
	 * wangxd 2016.9.9
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumExaDetailedInfoPO getPostpartumExaDetailByPostpartumExaId(String postpartumExaId);

}