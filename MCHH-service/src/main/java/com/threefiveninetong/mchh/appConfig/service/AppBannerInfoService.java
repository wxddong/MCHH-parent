/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppBannerInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appConfig.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.dao.AppBannerInfoDao;
import com.threefiveninetong.mchh.appConfig.po.AppBannerInfoPO;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppBannerInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppBannerInfoService {

	private static final Logger log =Logger.getLogger(AppBannerInfoService.class);
	
	@Resource
	private  AppBannerInfoDao  appBannerInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppBannerInfo 
	 */
	public AppBannerInfoPO find(Serializable id){
		return appBannerInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppBannerInfoPO> 
	 */
	public List<AppBannerInfoPO> findAll(){
		return appBannerInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppBannerInfoPO po) throws Exception{
		
			if( po != null )
				 appBannerInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppBannerInfoPO po) throws Exception{

			if( po != null )
				 appBannerInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appBannerInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appBannerInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppBannerInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppBannerInfoPO> list = appBannerInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 查询各个阶段有效的Banner图数据
	 * @param map
	 * @return
	 */
	public List<AppBannerInfoPO> findAppBannerListForType(String type) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> typeList = new ArrayList<String>();
		typeList.add(type);
		map.put("typeList", typeList);
		map.put("effective", "effective");
		map.put("status", EffectStatus.有效.getValue());
		map.put("num", 4);
		return this.appBannerInfoDao.findAppBannerListByCondition(map);
	}
}