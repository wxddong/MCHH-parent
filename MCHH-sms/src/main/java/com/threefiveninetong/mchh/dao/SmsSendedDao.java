/**
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsSendedDao.java
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


import com.threefiveninetong.mchh.po.SmsSendedPO;

/**
 * @ClassName: SmsSendedDao
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:51
 */
public interface SmsSendedDao{

	/**
	 * 查找单个
	 * @param id
	 * @return SmsSended
	 */
	public SmsSendedPO find(Serializable id);

	/**
	 * 查找所有
	 * @return List<SmsSendedPO>
	 */
	public List<SmsSendedPO> findAll();

	/**
	 * 创建
	 * @param po
	 */
	public void create(SmsSendedPO po);

	/**
	 * 修改
	 * @param po
	 */
	public void update(SmsSendedPO po);

	/**
	 * 删除
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有
	 * 注此方法后台用
	 */
	public List<SmsSendedPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除
	 * @param id
	 */
	public void deletes(Serializable[] id);

	/**
	 * 按照条件查询
	 * @param consMap
	 * @return
	 */
	public List<SmsSendedPO> findByContidions(Map consMap);
}