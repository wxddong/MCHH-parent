/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthReferralInfoDao.java 
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


import com.threefiveninetong.mchh.childbirth.po.ChildbirthReferralInfoPO;

/**
 * @ClassName: ChildbirthReferralInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:04 
 */
public interface ChildbirthReferralInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthReferralInfo 
	 */
	public ChildbirthReferralInfoPO find(Serializable id);
	
	
	/**
	 * 查找单个 分娩转诊信息通过分娩信息id
	 * @param id 
	 * @return ChildbirthReferralInfo 
	 */
	public ChildbirthReferralInfoPO findByChildBirthInfoId(Serializable id);
	
	
	/**
	 * 查找单个 分娩转诊信息通过分娩信息id 只查询下次访视日期....
	 * @param id 
	 * @return ChildbirthReferralInfo 
	 */
	public ChildbirthReferralInfoPO findByChildBirthId(Serializable id);
	
	
	

	/**
	 * 查找所有 
	 * @return List<ChildbirthReferralInfoPO> 
	 */
	public List<ChildbirthReferralInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthReferralInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildbirthReferralInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildbirthReferralInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}