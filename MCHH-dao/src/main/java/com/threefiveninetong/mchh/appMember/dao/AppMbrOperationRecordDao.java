/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrOperationRecordDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appMember.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appMember.po.AppMbrOperationRecordPO;

/**
 * @ClassName: AppMbrOperationRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppMbrOperationRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMbrOperationRecord 
	 */
	public AppMbrOperationRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppMbrOperationRecordPO> 
	 */
	public List<AppMbrOperationRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMbrOperationRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppMbrOperationRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppMbrOperationRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 操作日志列表
	 * @param conds
	 * @return
	 */
	public List<AppMbrOperationRecordPO> getAll(Map<String, Object> conds);

}