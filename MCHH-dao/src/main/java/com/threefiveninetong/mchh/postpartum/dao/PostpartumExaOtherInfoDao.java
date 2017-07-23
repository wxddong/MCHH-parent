/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaOtherInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.postpartum.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 13:47:42 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.postpartum.po.PostpartumExaOtherInfoPO;

/**
 * @ClassName: PostpartumExaOtherInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 13:47:42 
 */
public interface PostpartumExaOtherInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumExaOtherInfo 
	 */
	public PostpartumExaOtherInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PostpartumExaOtherInfoPO> 
	 */
	public List<PostpartumExaOtherInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PostpartumExaOtherInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PostpartumExaOtherInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PostpartumExaOtherInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据产后检查的id获取产后检查产后检查其他表中的信息
	 * wangxd 2016.9.9
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumExaOtherInfoPO getPostpartumExaOtherByPostpartumExaId(String postpartumExaId);

}