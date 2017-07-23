/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppAffiliatedHospitalInfoDao.java 
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


import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;

/**
 * @ClassName: AppAffiliatedHospitalInfoDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:08 
 */
public interface AppAffiliatedHospitalInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppAffiliatedHospitalInfo 
	 */
	public AppAffiliatedHospitalInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppAffiliatedHospitalInfoPO> 
	 */
	public List<AppAffiliatedHospitalInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppAffiliatedHospitalInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppAffiliatedHospitalInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppAffiliatedHospitalInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 条件查询会员关联医院表信息
	 * @param map
	 * @return
	 */
	public List<AppAffiliatedHospitalInfoPO> findAppAffiliatedHospitalListByCondition(Map<String,Object> map);

	/**
	 * 根据id查询信息
	 * @param memberId
	 * @return
	 */
	public int getAffiliatedHospitalBymemberId(String memberId);

}