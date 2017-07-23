/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalFetalMovementRecordService.java 
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

import com.threefiveninetong.mchh.appPrenatal.dao.AppPrenatalFetalMovementRecordDao;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalFetalMovementRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPrenatalFetalMovementRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPrenatalFetalMovementRecordService {

	private static final Logger log =Logger.getLogger(AppPrenatalFetalMovementRecordService.class);
	
	@Resource
	private  AppPrenatalFetalMovementRecordDao  appPrenatalFetalMovementRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalFetalMovementRecord 
	 */
	public AppPrenatalFetalMovementRecordPO find(Serializable id){
		return appPrenatalFetalMovementRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPrenatalFetalMovementRecordPO> 
	 */
	public List<AppPrenatalFetalMovementRecordPO> findAll(){
		return appPrenatalFetalMovementRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalFetalMovementRecordPO po) throws Exception{
		
			if( po != null )
				 appPrenatalFetalMovementRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPrenatalFetalMovementRecordPO po) throws Exception{

			if( po != null )
				 appPrenatalFetalMovementRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPrenatalFetalMovementRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPrenatalFetalMovementRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPrenatalFetalMovementRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPrenatalFetalMovementRecordPO> list = appPrenatalFetalMovementRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MBRID查询孕产期最近一条胎动信息
	 * @param mbrId
	 * @return
	 */
	public AppPrenatalFetalMovementRecordPO findAppPrenatalFetalMovementRecordInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppPrenatalFetalMovementRecordPO> list = this.appPrenatalFetalMovementRecordDao.findAppPrenatalFetalMovementRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
	
	/**
	 * 通过MBRID查询孕产期胎动信息
	 * @param mbrId
	 * @return
	 */
	public List<AppPrenatalFetalMovementRecordPO> findAppPrenatalFetalMovementRecordListByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 30);
		return this.appPrenatalFetalMovementRecordDao.findAppPrenatalFetalMovementRecordListByCondition(map);
	}
}