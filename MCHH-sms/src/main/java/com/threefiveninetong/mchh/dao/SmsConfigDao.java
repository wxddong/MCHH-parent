/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SmsConfigDao.java
 * @Prject: MCHH-dao
 * @Package: cn.com.devsource.MCHH.sms.dao
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:49
 * @version: V1.0
 */
package com.threefiveninetong.mchh.dao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.po.SmsConfigPO;


/**
 * @ClassName: SmsConfigDao
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-01-28 18:10:49
 */
public interface SmsConfigDao{

	/**
	 * 查找单个
	 * @param id
	 * @return SmsConfig
	 */
	public SmsConfigPO find(Serializable id);

	/**
	 * 查找所有
	 * @return List<SmsConfigPO>
	 */
	public List<SmsConfigPO> findAll();

	/**
	 * 创建
	 * @param po
	 */
	public void create(SmsConfigPO po);

	/**
	 * 修改
	 * @param po
	 */
	public void update(SmsConfigPO po);

	/**
	 * 删除
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有
	 * 注此方法后台用
	 */
	public List<SmsConfigPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除
	 * @param id
	 */
	public void deletes(Serializable[] id);

	public void updateSort(Map<String, Object> map);

	public void updateByParams(Map<String, Object> map);

}