/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBabyInfoDao.java 
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


import com.threefiveninetong.mchh.childbirth.po.ChildbirthBabyInfoPO;
import com.threefiveninetong.mchh.childbirth.po.SelectChildBaby;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ChildbirthBabyInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:04 
 */
public interface ChildbirthBabyInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthBabyInfo 
	 */
	public ChildbirthBabyInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ChildbirthBabyInfoPO> 
	 */
	public List<ChildbirthBabyInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthBabyInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ChildbirthBabyInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ChildbirthBabyInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过分娩信息表id获取到分娩婴儿信息
	 * @param id
	 * @return
	 */
	public List<ChildbirthBabyInfoPO> getBabyInfoByChildbirthId(String id);

	/**
	 * 查询妈妈信息
	 * @param reqs
	 * @param page
	 * @author ywk
	 */
	public List<SelectChildBaby> selectChildBirth(Map<String, Object> reqs);

}