/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumReferralInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.postpartum.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.postpartum.po.PostpartumReferralInfoPO;

/**
 * @ClassName: PostpartumReferralInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
public interface PostpartumReferralInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumReferralInfo 
	 */
	public PostpartumReferralInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PostpartumReferralInfoPO> 
	 */
	public List<PostpartumReferralInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PostpartumReferralInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PostpartumReferralInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PostpartumReferralInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据产后检查表id查询产后转诊信息
	 * wangxd 2016.9.9
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumReferralInfoPO getPostpartumReferralByPostpartumExaId(String postpartumExaId);

}