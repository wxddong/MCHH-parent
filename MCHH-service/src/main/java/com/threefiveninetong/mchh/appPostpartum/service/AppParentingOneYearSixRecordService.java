/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneYearSixRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPostpartum.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:46 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingOneYearSixRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearSixRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingOneYearSixRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:46 
 */
@Service
public class AppParentingOneYearSixRecordService {

	private static final Logger log =Logger.getLogger(AppParentingOneYearSixRecordService.class);
	
	@Resource
	private  AppParentingOneYearSixRecordDao  appParentingOneYearSixRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingOneYearSixRecord 
	 */
	public AppParentingOneYearSixRecordPO find(Serializable id){
		return appParentingOneYearSixRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingOneYearSixRecordPO> 
	 */
	public List<AppParentingOneYearSixRecordPO> findAll(){
		return appParentingOneYearSixRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingOneYearSixRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingOneYearSixRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingOneYearSixRecordPO po) throws Exception{

			if( po != null )
				 appParentingOneYearSixRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingOneYearSixRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingOneYearSixRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingOneYearSixRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingOneYearSixRecordPO> list = appParentingOneYearSixRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照parId查询月育儿期一岁六月龄一条记录
	 * @param map
	 * @return
	 */
	public AppParentingOneYearSixRecordPO findAppParentingOneYearSixRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingOneYearSixRecordPO> list = this.appParentingOneYearSixRecordDao.findAppParentingOneYearSixRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}