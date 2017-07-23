/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEarlyStageRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPostpartum.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingEarlyStageRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEarlyStageRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingEarlyStageRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppParentingEarlyStageRecordService {

	private static final Logger log =Logger.getLogger(AppParentingEarlyStageRecordService.class);
	
	@Resource
	private  AppParentingEarlyStageRecordDao  appParentingEarlyStageRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingEarlyStageRecord 
	 */
	public AppParentingEarlyStageRecordPO find(Serializable id){
		return appParentingEarlyStageRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingEarlyStageRecordPO> 
	 */
	public List<AppParentingEarlyStageRecordPO> findAll(){
		return appParentingEarlyStageRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingEarlyStageRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingEarlyStageRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingEarlyStageRecordPO po) throws Exception{

			if( po != null )
				 appParentingEarlyStageRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingEarlyStageRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingEarlyStageRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingEarlyStageRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingEarlyStageRecordPO> list = appParentingEarlyStageRecordDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 通过ParId查询最近一条育儿期宝宝早期记录
	 * @param parId
	 * @return
	 */
	public AppParentingEarlyStageRecordPO findAppParentingEarlyStageRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		List<AppParentingEarlyStageRecordPO> list = this.appParentingEarlyStageRecordDao.findAppParentingEarlyStageRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}