/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingThreeYearRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingThreeYearRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingThreeYearRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingThreeYearRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:05 
 */
@Service
public class AppParentingThreeYearRecordService {

	private static final Logger log =Logger.getLogger(AppParentingThreeYearRecordService.class);
	
	@Resource
	private  AppParentingThreeYearRecordDao  appParentingThreeYearRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingThreeYearRecord 
	 */
	public AppParentingThreeYearRecordPO find(Serializable id){
		return appParentingThreeYearRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingThreeYearRecordPO> 
	 */
	public List<AppParentingThreeYearRecordPO> findAll(){
		return appParentingThreeYearRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingThreeYearRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingThreeYearRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingThreeYearRecordPO po) throws Exception{

			if( po != null )
				 appParentingThreeYearRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingThreeYearRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingThreeYearRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingThreeYearRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingThreeYearRecordPO> list = appParentingThreeYearRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照ParId查询育儿期三岁记录表一条信息
	 * @param map
	 * @return
	 */
	public AppParentingThreeYearRecordPO findAppParentingThreeYearRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingThreeYearRecordPO> list = this.appParentingThreeYearRecordDao.findAppParentingThreeYearRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}