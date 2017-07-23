/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingTwoYearRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingTwoYearRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingTwoYearRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:05 
 */
@Service
public class AppParentingTwoYearRecordService {

	private static final Logger log =Logger.getLogger(AppParentingTwoYearRecordService.class);
	
	@Resource
	private  AppParentingTwoYearRecordDao  appParentingTwoYearRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingTwoYearRecord 
	 */
	public AppParentingTwoYearRecordPO find(Serializable id){
		return appParentingTwoYearRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingTwoYearRecordPO> 
	 */
	public List<AppParentingTwoYearRecordPO> findAll(){
		return appParentingTwoYearRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingTwoYearRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingTwoYearRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingTwoYearRecordPO po) throws Exception{

			if( po != null )
				 appParentingTwoYearRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingTwoYearRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingTwoYearRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingTwoYearRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingTwoYearRecordPO> list = appParentingTwoYearRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照ParId查询育儿期两岁龄记录表一条信息
	 * @param map
	 * @return
	 */
	public AppParentingTwoYearRecordPO findAppParentingTwoYearRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingTwoYearRecordPO> list = this.appParentingTwoYearRecordDao.findAppParentingTwoYearRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}