/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalReferralInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:17 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;

/**
 * @ClassName: PrenatalReferralInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:17 
 */
public interface PrenatalReferralInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PrenatalReferralInfo 
	 */
	public PrenatalReferralInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PrenatalReferralInfoPO> 
	 */
	public List<PrenatalReferralInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PrenatalReferralInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PrenatalReferralInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PrenatalReferralInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过产检id获取转诊信息
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	public PrenatalReferralInfoPO getPrenatalReferralByPrenatalId(String prenatalId);

	/**
	 * 修改编辑
	 * @param prenatalReferralInfoPO
	 * @author yanwk
	 */
	public void edit(PrenatalReferralInfoPO prenatalReferralInfoPO);

}