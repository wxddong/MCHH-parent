/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.postpartum.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 13:47:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.dto.PostHistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;

/**
 * @ClassName: PostpartumExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 13:47:41 
 */
public interface PostpartumExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumExaInfo 
	 */
	public PostpartumExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PostpartumExaInfoPO> 
	 */
	public List<PostpartumExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PostpartumExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PostpartumExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PostpartumExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据生育档案id获取产后检查的历史记录
	 * wangxd 2016.9.6
	 * @param birthArchivesId
	 * @return
	 */
	public List<PostHistoryCheckVO> getPostpartumHistoryChecks(String birthArchivesId);
	/**
	 * 根据生育档案id获取产后检查的历史记录
	 * wangxd 2016.9.6
	 * @param birthArchivesId
	 * @return
	 */
	public List<HistoryCheckVO> getPostHistoryChecks(String birthArchivesId);

	/**
	 * 查找产后检查后的主表信息
	 * wangxd 2016.9.8
	 * @param birthArchivesId
	 * @return
	 */
	public PostpartumExaInfoPO findPostpartumExa(String postpartumExaId);

	/**
	 * 根据生育id查询最新的产后检查主表信息
	 * wangxd 2016.9.14
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumExaInfoPO findLatestPostpartumExa(String birthArchivesId);

	/**
	 * 通过生育id查找到所有的42天的检查记录
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public List<PostpartumExaInfoPO> getPost42ExaByBirthId(String birthArchivesId);

	/**
	 * 通过生育id查找到所有的3-7天的检查记录
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public List<PostpartumExaInfoPO> getPost3To7ExaByBirthId(String birthArchivesId);

	public void updateState(String birthArchivesId);

	public String getMechanismById(String mechanismId);

	/**
	 * 通过生育档案id获取产后最新的访视记录
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public PostpartumExaInfoPO getPostExaByBirthId(String id);

}