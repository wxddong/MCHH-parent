/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalWeightRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPrenatal.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPrenatal.dao.AppPrenatalWeightRecordDao;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalWeightRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPrenatalWeightRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPrenatalWeightRecordService {

	private static final Logger log =Logger.getLogger(AppPrenatalWeightRecordService.class);
	
	@Resource
	private  AppPrenatalWeightRecordDao  appPrenatalWeightRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalWeightRecord 
	 */
	public AppPrenatalWeightRecordPO find(Serializable id){
		return appPrenatalWeightRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPrenatalWeightRecordPO> 
	 */
	public List<AppPrenatalWeightRecordPO> findAll(){
		return appPrenatalWeightRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalWeightRecordPO po) throws Exception{
		
			if( po != null )
				 appPrenatalWeightRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPrenatalWeightRecordPO po) throws Exception{

			if( po != null )
				 appPrenatalWeightRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPrenatalWeightRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPrenatalWeightRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPrenatalWeightRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPrenatalWeightRecordPO> list = appPrenatalWeightRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MbrId查询最近孕产期体重一条信息
	 * @param map
	 * @return
	 */
	public AppPrenatalWeightRecordPO findAppPrenatalWeightRecordInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppPrenatalWeightRecordPO> list = this.appPrenatalWeightRecordDao.findAppPrenatalWeightRecordListByConditon(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
	
	/**
	 * 通过MbrId查询最近孕产期体重信息
	 * @param map
	 * @return
	 */
	public List<AppPrenatalWeightRecordPO> findAppPrenatalWeightRecordListByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 30);
		return this.appPrenatalWeightRecordDao.findAppPrenatalWeightRecordListByConditon(map);
	}
}