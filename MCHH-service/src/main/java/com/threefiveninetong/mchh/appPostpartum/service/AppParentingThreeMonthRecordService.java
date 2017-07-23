/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingThreeMonthRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingThreeMonthRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingThreeMonthRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingThreeMonthRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:46 
 */
@Service
public class AppParentingThreeMonthRecordService {

	private static final Logger log =Logger.getLogger(AppParentingThreeMonthRecordService.class);
	
	@Resource
	private  AppParentingThreeMonthRecordDao  appParentingThreeMonthRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingThreeMonthRecord 
	 */
	public AppParentingThreeMonthRecordPO find(Serializable id){
		return appParentingThreeMonthRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingThreeMonthRecordPO> 
	 */
	public List<AppParentingThreeMonthRecordPO> findAll(){
		return appParentingThreeMonthRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingThreeMonthRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingThreeMonthRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingThreeMonthRecordPO po) throws Exception{

			if( po != null )
				 appParentingThreeMonthRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingThreeMonthRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingThreeMonthRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingThreeMonthRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingThreeMonthRecordPO> list = appParentingThreeMonthRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照ParId条件查询育儿期三月龄记录表一条信息
	 * @param map
	 * @return
	 */
	public AppParentingThreeMonthRecordPO findAppParentingThreeMonthRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingThreeMonthRecordPO> list = this.appParentingThreeMonthRecordDao.findAppParentingThreeMonthRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}