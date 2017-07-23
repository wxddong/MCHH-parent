/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsSendingDao.java 
 * @Prject: MCHH-dao
 * @Package: cn.com.devsource.MCHH.sms.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-01-28 18:10:51 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.po.SmsSendingPO;

/**
 * @ClassName: SmsSendingDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:51 
 */
public interface SmsSendingDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSending 
	 */
	public SmsSendingPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsSendingPO> 
	 */
	public List<SmsSendingPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SmsSendingPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsSendingPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<SmsSendingPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过ids修改
	 * @param po 
	 */
	public void updateByIds(Map map);
	/**
	 * 通过ids删除
	 * @param po 
	 */
	public void deleteByIds(Map map);
}