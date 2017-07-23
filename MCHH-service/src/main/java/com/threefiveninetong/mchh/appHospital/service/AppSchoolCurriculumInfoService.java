/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppSchoolCurriculumInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appHospital.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appHospital.dao.AppSchoolCurriculumInfoDao;
import com.threefiveninetong.mchh.appHospital.po.AppSchoolCurriculumInfoPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppSchoolCurriculumInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppSchoolCurriculumInfoService {

	private static final Logger log =Logger.getLogger(AppSchoolCurriculumInfoService.class);
	
	@Resource
	private  AppSchoolCurriculumInfoDao  appSchoolCurriculumInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppSchoolCurriculumInfo 
	 */
	public AppSchoolCurriculumInfoPO find(Serializable id){
		return appSchoolCurriculumInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppSchoolCurriculumInfoPO> 
	 */
	public List<AppSchoolCurriculumInfoPO> findAll(){
		return appSchoolCurriculumInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppSchoolCurriculumInfoPO po) throws Exception{
		
			if( po != null )
				 appSchoolCurriculumInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppSchoolCurriculumInfoPO po) throws Exception{

			if( po != null )
				 appSchoolCurriculumInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appSchoolCurriculumInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appSchoolCurriculumInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppSchoolCurriculumInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppSchoolCurriculumInfoPO> list = appSchoolCurriculumInfoDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 按月分组查询所有课程月份毫秒信息集合
	 * @return
	 */
	public List<String> findMonthMillisecondList(String hospitalId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hospitalId", hospitalId);
		return this.appSchoolCurriculumInfoDao.findMonthMillisecondList(map);
	}

	/**
	 * 通过hospitalId查询医院孕妇学校课程信息表
	 * @param map
	 * @return
	 */
	public List<AppSchoolCurriculumInfoPO> findAppSchoolCurriculumListByHospitalId(String hospitalId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hospitalId", hospitalId);
		return this.appSchoolCurriculumInfoDao.findAppSchoolCurriculumListByCondition(map);
	}
	
	/**
	 * 通过hospitalId和月份查询医院孕妇学校课程信息表
	 * @param map
	 * @return
	 */
	public List<AppSchoolCurriculumInfoPO> findAppSchoolCurriculumListByHospitalIdAndMonth(String hospitalId,String monthTime) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hospitalId", hospitalId);
		map.put("monthTime", monthTime);
		return this.appSchoolCurriculumInfoDao.findAppSchoolCurriculumListByCondition(map);
	}

	/**
	 * 孕妇学校列表
	 * @param reqs
	 * @param page
	 */
	public void getAll(Map<String, Object> conds, Page<AppSchoolCurriculumInfoPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppSchoolCurriculumInfoPO> list = appSchoolCurriculumInfoDao.getAll(conds);
		page.setList(list);
	}
}