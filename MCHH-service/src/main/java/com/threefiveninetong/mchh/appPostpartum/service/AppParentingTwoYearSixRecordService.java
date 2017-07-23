/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingTwoYearSixRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPostpartum.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-11-02 10:45:05 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingTwoYearSixRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearSixRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingTwoYearSixRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:05 
 */
@Service
public class AppParentingTwoYearSixRecordService {

	private static final Logger log =Logger.getLogger(AppParentingTwoYearSixRecordService.class);
	
	@Resource
	private  AppParentingTwoYearSixRecordDao  appParentingTwoYearSixRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingTwoYearSixRecord 
	 */
	public AppParentingTwoYearSixRecordPO find(Serializable id){
		return appParentingTwoYearSixRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingTwoYearSixRecordPO> 
	 */
	public List<AppParentingTwoYearSixRecordPO> findAll(){
		return appParentingTwoYearSixRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingTwoYearSixRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingTwoYearSixRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingTwoYearSixRecordPO po) throws Exception{

			if( po != null )
				 appParentingTwoYearSixRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingTwoYearSixRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingTwoYearSixRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingTwoYearSixRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingTwoYearSixRecordPO> list = appParentingTwoYearSixRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 条件查询育儿期两岁六月龄记录表
	 * @param map
	 * @return
	 */
	public AppParentingTwoYearSixRecordPO findAppParentingTwoYearSixRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingTwoYearSixRecordPO> list = this.appParentingTwoYearSixRecordDao.findAppParentingTwoYearSixRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}