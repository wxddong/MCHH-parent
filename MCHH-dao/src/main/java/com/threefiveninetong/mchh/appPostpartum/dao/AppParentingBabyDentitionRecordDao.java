/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingBabyDentitionRecordDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyDentitionRecordPO;

/**
 * @ClassName: AppParentingBabyDentitionRecordDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public interface AppParentingBabyDentitionRecordDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingBabyDentitionRecord 
	 */
	public AppParentingBabyDentitionRecordPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppParentingBabyDentitionRecordPO> 
	 */
	public List<AppParentingBabyDentitionRecordPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingBabyDentitionRecordPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppParentingBabyDentitionRecordPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppParentingBabyDentitionRecordPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询宝宝牙齿生长信息
	 * @param map
	 * @return
	 */
	public List<AppParentingBabyDentitionRecordPO> findAppParentingBabyDentitionRecordListByCondition(Map<String,Object> map);
}