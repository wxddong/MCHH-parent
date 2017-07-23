/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalSelfRecordSpecialDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordSpecialPO;

/**
 * @ClassName: AppPrenatalSelfRecordSpecialDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public interface AppPrenatalSelfRecordSpecialDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalSelfRecordSpecial 
	 */
	public AppPrenatalSelfRecordSpecialPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppPrenatalSelfRecordSpecialPO> 
	 */
	public List<AppPrenatalSelfRecordSpecialPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalSelfRecordSpecialPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppPrenatalSelfRecordSpecialPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppPrenatalSelfRecordSpecialPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询孕产期自我特殊记录信息
	 * @param map
	 * @return
	 */
	public List<AppPrenatalSelfRecordSpecialPO> findAppPrenatalSelfRecordSpecialListByCondition(Map<String,Object> map);
	
	/**
	 * 通过fatId修改Sign状态
	 * @param fatId
	 */
	public void updateSign(@Param(value = "fatId") String fatId);

}