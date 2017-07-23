/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppSchoolCurriculumInfoDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appHospital.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:08 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.appHospital.po.AppSchoolCurriculumInfoPO;

/**
 * @ClassName: AppSchoolCurriculumInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public interface AppSchoolCurriculumInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppSchoolCurriculumInfo 
	 */
	public AppSchoolCurriculumInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppSchoolCurriculumInfoPO> 
	 */
	public List<AppSchoolCurriculumInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppSchoolCurriculumInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppSchoolCurriculumInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppSchoolCurriculumInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 按月分组查询所有课程月份毫秒信息集合
	 * @return
	 */
	public List<String> findMonthMillisecondList(Map<String,Object> map);
	
	/**
	 * 条件查询医院孕妇学校课程信息表
	 * @param map
	 * @return
	 */
	public List<AppSchoolCurriculumInfoPO> findAppSchoolCurriculumListByCondition(Map<String,Object> map);

	/**
	 * 孕妇学校列表
	 * @param conds
	 * @return
	 */
	public List<AppSchoolCurriculumInfoPO> getAll(Map<String, Object> conds);

}