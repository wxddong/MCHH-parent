/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingSixYearRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingSixYearRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixYearRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingSixYearRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:05 
 */
@Service
public class AppParentingSixYearRecordService {

	private static final Logger log =Logger.getLogger(AppParentingSixYearRecordService.class);
	
	@Resource
	private  AppParentingSixYearRecordDao  appParentingSixYearRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingSixYearRecord 
	 */
	public AppParentingSixYearRecordPO find(Serializable id){
		return appParentingSixYearRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingSixYearRecordPO> 
	 */
	public List<AppParentingSixYearRecordPO> findAll(){
		return appParentingSixYearRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingSixYearRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingSixYearRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingSixYearRecordPO po) throws Exception{

			if( po != null )
				 appParentingSixYearRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingSixYearRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingSixYearRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingSixYearRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingSixYearRecordPO> list = appParentingSixYearRecordDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 按照parId查询育儿期六岁一条记录
	 * @param map
	 * @return
	 */
	public AppParentingSixYearRecordPO findAppParentingSixYearRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingSixYearRecordPO> list = this.appParentingSixYearRecordDao.findAppParentingSixYearRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}