/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppBabyBasicInfoService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppBabyBasicInfoDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppBabyBasicInfoPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppBabyBasicInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppBabyBasicInfoService {

	private static final Logger log =Logger.getLogger(AppBabyBasicInfoService.class);
	
	@Resource
	private  AppBabyBasicInfoDao  appBabyBasicInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppBabyBasicInfo 
	 */
	public AppBabyBasicInfoPO find(Serializable id){
		return appBabyBasicInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppBabyBasicInfoPO> 
	 */
	public List<AppBabyBasicInfoPO> findAll(){
		return appBabyBasicInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppBabyBasicInfoPO po) throws Exception{
		
			if( po != null )
				 appBabyBasicInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppBabyBasicInfoPO po) throws Exception{

			if( po != null )
				 appBabyBasicInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appBabyBasicInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appBabyBasicInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppBabyBasicInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppBabyBasicInfoPO> list = appBabyBasicInfoDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 按照MBRId查询宝宝基础信息
	 * @param mbrId
	 * @param status
	 * @return
	 */
	public List<AppBabyBasicInfoPO> findAppBabyBasicListByMbrId(String mbrId,String status) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("status", status);
		return this.appBabyBasicInfoDao.findAppBabyBasicListByConditon(map);
	}
}