/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationWeightRecordService.java 
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

import com.threefiveninetong.mchh.appPremarital.dao.AppPreparationWeightRecordDao;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationWeightRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPreparationWeightRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPreparationWeightRecordService {

	private static final Logger log =Logger.getLogger(AppPreparationWeightRecordService.class);
	
	@Resource
	private  AppPreparationWeightRecordDao  appPreparationWeightRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPreparationWeightRecord 
	 */
	public AppPreparationWeightRecordPO find(Serializable id){
		return appPreparationWeightRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPreparationWeightRecordPO> 
	 */
	public List<AppPreparationWeightRecordPO> findAll(){
		return appPreparationWeightRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPreparationWeightRecordPO po) throws Exception{
		
			if( po != null )
				 appPreparationWeightRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPreparationWeightRecordPO po) throws Exception{

			if( po != null )
				 appPreparationWeightRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPreparationWeightRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPreparationWeightRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPreparationWeightRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPreparationWeightRecordPO> list = appPreparationWeightRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过mbrId查询最新的一条备孕期体重信息
	 * @param mbrId
	 * @return
	 */
	public AppPreparationWeightRecordPO findAppPreparationWeightRecordInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppPreparationWeightRecordPO> list = this.appPreparationWeightRecordDao.findAppPreparationWeightRecordListByConditon(map);
		if (!CollectionUtil.isNullOrEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 通过mbrId查询备孕期体重信息
	 * @param mbrId
	 * @return
	 */
	public List<AppPreparationWeightRecordPO> findAppPreparationWeightRecordListByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 30);
		return this.appPreparationWeightRecordDao.findAppPreparationWeightRecordListByConditon(map);
	}
}