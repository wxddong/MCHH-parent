/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneYearRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingOneYearRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingOneYearRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:46 
 */
@Service
public class AppParentingOneYearRecordService {

	private static final Logger log =Logger.getLogger(AppParentingOneYearRecordService.class);
	
	@Resource
	private  AppParentingOneYearRecordDao  appParentingOneYearRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingOneYearRecord 
	 */
	public AppParentingOneYearRecordPO find(Serializable id){
		return appParentingOneYearRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingOneYearRecordPO> 
	 */
	public List<AppParentingOneYearRecordPO> findAll(){
		return appParentingOneYearRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingOneYearRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingOneYearRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingOneYearRecordPO po) throws Exception{

			if( po != null )
				 appParentingOneYearRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingOneYearRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingOneYearRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingOneYearRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingOneYearRecordPO> list = appParentingOneYearRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照parId条件查询育儿期一岁龄一条记录
	 * @param map
	 * @return
	 */
	public AppParentingOneYearRecordPO findAppParentingOneYearRecordInfoByParId(String parId) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingOneYearRecordPO> list = this.appParentingOneYearRecordDao.findAppParentingOneYearRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}