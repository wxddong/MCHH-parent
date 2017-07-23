/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppActivationStatisticsService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appStatis.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appStatis.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appStatis.dao.AppActivationStatisticsDao;
import com.threefiveninetong.mchh.appStatis.po.AppActivationStatisticsPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppActivationStatisticsService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppActivationStatisticsService {

	private static final Logger log =Logger.getLogger(AppActivationStatisticsService.class);
	
	@Resource
	private  AppActivationStatisticsDao  appActivationStatisticsDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppActivationStatistics 
	 */
	public AppActivationStatisticsPO find(Serializable id){
		return appActivationStatisticsDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppActivationStatisticsPO> 
	 */
	public List<AppActivationStatisticsPO> findAll(){
		return appActivationStatisticsDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppActivationStatisticsPO po) throws Exception{
		
			if( po != null )
				 appActivationStatisticsDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppActivationStatisticsPO po) throws Exception{

			if( po != null )
				 appActivationStatisticsDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appActivationStatisticsDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appActivationStatisticsDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppActivationStatisticsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppActivationStatisticsPO> list = appActivationStatisticsDao.listForPage(conds);
		page.setList(list);
	}


}