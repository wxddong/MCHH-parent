/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationTemperatureRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPremarital.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPremarital.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPremarital.dao.AppPreparationTemperatureRecordDao;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationTemperatureRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPreparationTemperatureRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPreparationTemperatureRecordService {

	private static final Logger log =Logger.getLogger(AppPreparationTemperatureRecordService.class);
	
	@Resource
	private  AppPreparationTemperatureRecordDao  appPreparationTemperatureRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPreparationTemperatureRecord 
	 */
	public AppPreparationTemperatureRecordPO find(Serializable id){
		return appPreparationTemperatureRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPreparationTemperatureRecordPO> 
	 */
	public List<AppPreparationTemperatureRecordPO> findAll(){
		return appPreparationTemperatureRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPreparationTemperatureRecordPO po) throws Exception{
		
			if( po != null )
				 appPreparationTemperatureRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPreparationTemperatureRecordPO po) throws Exception{

			if( po != null )
				 appPreparationTemperatureRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPreparationTemperatureRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPreparationTemperatureRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPreparationTemperatureRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPreparationTemperatureRecordPO> list = appPreparationTemperatureRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过mbrId查询最近一条备孕期体温信息
	 * @param mbrId
	 * @return
	 */
	public AppPreparationTemperatureRecordPO findAppPreparationTemperatureRecordInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppPreparationTemperatureRecordPO> list = this.appPreparationTemperatureRecordDao.findAppPreparationTemperatureRecordListByCondition(map);
		if (!CollectionUtil.isNullOrEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 通过mbrId查询最近30条备孕期体温信息集合
	 * @param mbrId
	 * @return
	 */
	public List<AppPreparationTemperatureRecordPO> findAppPreparationTemperatureRecordListByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 30);
		return this.appPreparationTemperatureRecordDao.findAppPreparationTemperatureRecordListByCondition(map);
	}
}