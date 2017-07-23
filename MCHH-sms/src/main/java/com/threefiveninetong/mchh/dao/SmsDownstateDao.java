/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsDownstateDao.java 
 * @Prject: MCHH-dao
 * @Package: cn.com.devsource.MCHH.sms.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-01-28 18:10:50 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.po.SmsDownstatePO;

/**
 * @ClassName: SmsDownstateDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:50 
 */
public interface SmsDownstateDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsDownstate 
	 */
	public SmsDownstatePO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsDownstatePO> 
	 */
	public List<SmsDownstatePO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SmsDownstatePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsDownstatePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<SmsDownstatePO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}