/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingMomWeightRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingMomWeightRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingMomWeightRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingMomWeightRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppParentingMomWeightRecordService {

	private static final Logger log =Logger.getLogger(AppParentingMomWeightRecordService.class);
	
	@Resource
	private  AppParentingMomWeightRecordDao  appParentingMomWeightRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingMomWeightRecord 
	 */
	public AppParentingMomWeightRecordPO find(Serializable id){
		return appParentingMomWeightRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingMomWeightRecordPO> 
	 */
	public List<AppParentingMomWeightRecordPO> findAll(){
		return appParentingMomWeightRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingMomWeightRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingMomWeightRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingMomWeightRecordPO po) throws Exception{

			if( po != null )
				 appParentingMomWeightRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingMomWeightRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingMomWeightRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingMomWeightRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingMomWeightRecordPO> list = appParentingMomWeightRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MbrId查询育儿期一条妈妈体重信息
	 * @param mbrId
	 * @return
	 */
	public AppParentingMomWeightRecordPO findAppParentingMomWeightRecordInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppParentingMomWeightRecordPO> list = this.appParentingMomWeightRecordDao.findAppParentingMomWeightRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
	
	/**
	 * 通过MbrId查询育儿期妈妈体重信息
	 * @param mbrId
	 * @return
	 */
	public List<AppParentingMomWeightRecordPO> findAppParentingMomWeightRecordListByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		return this.appParentingMomWeightRecordDao.findAppParentingMomWeightRecordListByCondition(map);
	}
}