/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEightMonthRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingEightMonthRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEightMonthRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingEightMonthRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:46 
 */
@Service
public class AppParentingEightMonthRecordService {

	private static final Logger log =Logger.getLogger(AppParentingEightMonthRecordService.class);
	
	@Resource
	private  AppParentingEightMonthRecordDao  appParentingEightMonthRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingEightMonthRecord 
	 */
	public AppParentingEightMonthRecordPO find(Serializable id){
		return appParentingEightMonthRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingEightMonthRecordPO> 
	 */
	public List<AppParentingEightMonthRecordPO> findAll(){
		return appParentingEightMonthRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingEightMonthRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingEightMonthRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingEightMonthRecordPO po) throws Exception{

			if( po != null )
				 appParentingEightMonthRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingEightMonthRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingEightMonthRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingEightMonthRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingEightMonthRecordPO> list = appParentingEightMonthRecordDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 通过ParId查询育儿期八月龄记录表一条信息
	 * @param map
	 * @return
	 */
	public AppParentingEightMonthRecordPO findAppParentingEightMonthRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingEightMonthRecordPO> list = this.appParentingEightMonthRecordDao.findAppParentingEightMonthRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}