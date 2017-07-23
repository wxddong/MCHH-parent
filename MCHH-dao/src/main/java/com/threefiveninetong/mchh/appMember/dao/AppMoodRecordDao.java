/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMoodRecordDao.java 
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


import com.threefiveninetong.mchh.appMember.po.AppMoodRecordPO;

/**
 * @ClassName: AppMoodRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppMoodRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMoodRecord 
	 */
	public AppMoodRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppMoodRecordPO> 
	 */
	public List<AppMoodRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMoodRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppMoodRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppMoodRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

}