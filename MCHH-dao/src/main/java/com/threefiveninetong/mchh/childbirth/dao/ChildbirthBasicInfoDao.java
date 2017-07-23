/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBasicInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.childbirth.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 19:16:50 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;

/**
 * @ClassName: ChildbirthBasicInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 19:16:50 
 */
public interface ChildbirthBasicInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthBasicInfo 
	 */
	public ChildbirthBasicInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildbirthBasicInfoPO> 
	 */
	public List<ChildbirthBasicInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthBasicInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildbirthBasicInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildbirthBasicInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * wangxd 2016.8.31
	 * 根据生育档案的id查询分娩信息
	 * @return
	 */
	public ChildbirthBasicInfoPO getChildbirthBasicByBirthArchivesId(String birthArchivesId);

	/**
	 * wangbj 2016.8.31
	 * 根据生育档案的id查询分娩信息  查询保存状态的信息
	 * @return
	 */
	public ChildbirthBasicInfoPO SaveChildbirthBasicByBirthArchivesId(String birthArchivesId);

	
}


