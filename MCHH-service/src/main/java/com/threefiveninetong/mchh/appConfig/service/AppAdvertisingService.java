/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppAdvertisingService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appConfig.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-11-02 10:45:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.dao.AppAdvertisingDao;
import com.threefiveninetong.mchh.appConfig.po.AppAdvertisingPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppAdvertisingService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:03 
 */
@Service
public class AppAdvertisingService {

	private static final Logger log =Logger.getLogger(AppAdvertisingService.class);
	
	@Resource
	private  AppAdvertisingDao  appAdvertisingDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppAdvertising 
	 */
	public AppAdvertisingPO find(Serializable id){
		return appAdvertisingDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppAdvertisingPO> 
	 */
	public List<AppAdvertisingPO> findAll(){
		return appAdvertisingDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppAdvertisingPO po) throws Exception{
		
			if( po != null )
				 appAdvertisingDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppAdvertisingPO po) throws Exception{

			if( po != null )
				 appAdvertisingDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appAdvertisingDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appAdvertisingDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppAdvertisingPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppAdvertisingPO> list = appAdvertisingDao.listForPage(conds);
		page.setList(list);
	}

	/**
     * 查找启动的广告图片
     * @return Advertising
     */
    public AppAdvertisingPO findStartUp() {
    	return this.appAdvertisingDao.findStartUp();
    }
}