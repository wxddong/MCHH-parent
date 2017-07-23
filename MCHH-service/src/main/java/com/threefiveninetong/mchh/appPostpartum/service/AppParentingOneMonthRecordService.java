/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingOneMonthRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingOneMonthRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneMonthRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingOneMonthRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:46 
 */
@Service
public class AppParentingOneMonthRecordService {

	private static final Logger log =Logger.getLogger(AppParentingOneMonthRecordService.class);
	
	@Resource
	private  AppParentingOneMonthRecordDao  appParentingOneMonthRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingOneMonthRecord 
	 */
	public AppParentingOneMonthRecordPO find(Serializable id){
		return appParentingOneMonthRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingOneMonthRecordPO> 
	 */
	public List<AppParentingOneMonthRecordPO> findAll(){
		return appParentingOneMonthRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingOneMonthRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingOneMonthRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingOneMonthRecordPO po) throws Exception{

			if( po != null )
				 appParentingOneMonthRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingOneMonthRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingOneMonthRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingOneMonthRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingOneMonthRecordPO> list = appParentingOneMonthRecordDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 通过parId查询育儿期一月龄记录表一条信息
	 * @param map
	 * @return
	 */
	public AppParentingOneMonthRecordPO findAppParentingOneMonthRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingOneMonthRecordPO> list = this.appParentingOneMonthRecordDao.findAppParentingOneMonthRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}