/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalBasicInfoService.java 
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

import com.threefiveninetong.mchh.appPrenatal.dao.AppPrenatalBasicInfoDao;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalBasicInfoPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPrenatalBasicInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPrenatalBasicInfoService {

	private static final Logger log =Logger.getLogger(AppPrenatalBasicInfoService.class);
	
	@Resource
	private  AppPrenatalBasicInfoDao  appPrenatalBasicInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalBasicInfo 
	 */
	public AppPrenatalBasicInfoPO find(Serializable id){
		return appPrenatalBasicInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPrenatalBasicInfoPO> 
	 */
	public List<AppPrenatalBasicInfoPO> findAll(){
		return appPrenatalBasicInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalBasicInfoPO po) throws Exception{
		
			if( po != null )
				 appPrenatalBasicInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPrenatalBasicInfoPO po) throws Exception{

			if( po != null )
				 appPrenatalBasicInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPrenatalBasicInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPrenatalBasicInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPrenatalBasicInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPrenatalBasicInfoPO> list = appPrenatalBasicInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MbrId查询孕产期未结案一条基本信息
	 * @param map
	 * @return
	 */
	public AppPrenatalBasicInfoPO findAppPrenatalBasicInfoByMbrId(String mbrId,String status) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("status", status);
		map.put("num", 1);
		List<AppPrenatalBasicInfoPO> list = this.appPrenatalBasicInfoDao.findAppPrenatalBasicListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}