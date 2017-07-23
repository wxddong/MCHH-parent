/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalReferralInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.PremaritalReferralInfoPO;

/**
 * @ClassName: PremaritalReferralInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
public interface PremaritalReferralInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PremaritalReferralInfo 
	 */
	public PremaritalReferralInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PremaritalReferralInfoPO> 
	 */
	public List<PremaritalReferralInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PremaritalReferralInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PremaritalReferralInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PremaritalReferralInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 根据婚检id获取转诊信息
	 * @param premaritalId
	 * @return
	 */
	public PremaritalReferralInfoPO getPreReferralByPremaritalId(String premaritalId);

	/**
	 * 修改
	 * @param premaritalReferralInfoPO
	 */
	public void edit(PremaritalReferralInfoPO premaritalReferralInfoPO);

}