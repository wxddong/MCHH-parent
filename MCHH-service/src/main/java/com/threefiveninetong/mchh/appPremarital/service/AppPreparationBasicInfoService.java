/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationBasicInfoService.java 
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

import com.threefiveninetong.mchh.appPremarital.dao.AppPreparationBasicInfoDao;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationBasicInfoPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi.ClosedStatus;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPreparationBasicInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPreparationBasicInfoService {

	private static final Logger log =Logger.getLogger(AppPreparationBasicInfoService.class);
	
	@Resource
	private  AppPreparationBasicInfoDao  appPreparationBasicInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPreparationBasicInfo 
	 */
	public AppPreparationBasicInfoPO find(Serializable id){
		return appPreparationBasicInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPreparationBasicInfoPO> 
	 */
	public List<AppPreparationBasicInfoPO> findAll(){
		return appPreparationBasicInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPreparationBasicInfoPO po) throws Exception{
		
			if( po != null )
				 appPreparationBasicInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPreparationBasicInfoPO po) throws Exception{

			if( po != null )
				 appPreparationBasicInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPreparationBasicInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPreparationBasicInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPreparationBasicInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPreparationBasicInfoPO> list = appPreparationBasicInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MbrId查询最后一条备孕期基本信息
	 * @param map
	 * @return
	 */
	public AppPreparationBasicInfoPO findAppPreparationBasicInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("status", ClosedStatus.未结案.getValue());
		map.put("num", 1);
		List<AppPreparationBasicInfoPO> list = this.appPreparationBasicInfoDao.findAppPreparationBasicListByConditon(map);
		if (!CollectionUtil.isNullOrEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}