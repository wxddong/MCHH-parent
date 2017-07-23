/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppVersionService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appConfig.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.dao.AppVersionDao;
import com.threefiveninetong.mchh.appConfig.po.AppVersionPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppVersionService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppVersionService {

	private static final Logger log =Logger.getLogger(AppVersionService.class);
	
	@Resource
	private  AppVersionDao  appVersionDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppVersion 
	 */
	public AppVersionPO find(Serializable id){
		return appVersionDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppVersionPO> 
	 */
	public List<AppVersionPO> findAll(){
		return appVersionDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppVersionPO po) throws Exception{
		
			if( po != null )
				 appVersionDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppVersionPO po) throws Exception{

			if( po != null )
				 appVersionDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appVersionDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appVersionDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppVersionPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppVersionPO> list = appVersionDao.listForPage(conds);
		page.setList(list);
	}

	/**
     * 查询最新的版本信息
     * 
     */
    public AppVersionPO findNewestByEquType(String channelCode) {
    	return this.appVersionDao.findNewestByEquType(channelCode);
    }
}