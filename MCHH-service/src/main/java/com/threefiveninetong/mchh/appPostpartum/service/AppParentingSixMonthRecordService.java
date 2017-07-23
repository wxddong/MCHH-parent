/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingSixMonthRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingSixMonthRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixMonthRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingSixMonthRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:46 
 */
@Service
public class AppParentingSixMonthRecordService {

	private static final Logger log =Logger.getLogger(AppParentingSixMonthRecordService.class);
	
	@Resource
	private  AppParentingSixMonthRecordDao  appParentingSixMonthRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingSixMonthRecord 
	 */
	public AppParentingSixMonthRecordPO find(Serializable id){
		return appParentingSixMonthRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingSixMonthRecordPO> 
	 */
	public List<AppParentingSixMonthRecordPO> findAll(){
		return appParentingSixMonthRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingSixMonthRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingSixMonthRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingSixMonthRecordPO po) throws Exception{

			if( po != null )
				 appParentingSixMonthRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingSixMonthRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingSixMonthRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingSixMonthRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingSixMonthRecordPO> list = appParentingSixMonthRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过parId查询育儿期六月龄记录表一条信息
	 * @param map
	 * @return
	 */
	public AppParentingSixMonthRecordPO findAppParentingSixMonthRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingSixMonthRecordPO> list = this.appParentingSixMonthRecordDao.findAppParentingSixMonthRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}