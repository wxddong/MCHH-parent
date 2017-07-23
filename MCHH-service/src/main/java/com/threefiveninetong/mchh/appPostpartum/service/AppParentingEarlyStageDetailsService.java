/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEarlyStageDetailsService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingEarlyStageDetailsDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEarlyStageDetailsPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingEarlyStageDetailsService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppParentingEarlyStageDetailsService {

	private static final Logger log =Logger.getLogger(AppParentingEarlyStageDetailsService.class);
	
	@Resource
	private  AppParentingEarlyStageDetailsDao  appParentingEarlyStageDetailsDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingEarlyStageDetails 
	 */
	public AppParentingEarlyStageDetailsPO find(Serializable id){
		return appParentingEarlyStageDetailsDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingEarlyStageDetailsPO> 
	 */
	public List<AppParentingEarlyStageDetailsPO> findAll(){
		return appParentingEarlyStageDetailsDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingEarlyStageDetailsPO po) throws Exception{
		
			if( po != null )
				 appParentingEarlyStageDetailsDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingEarlyStageDetailsPO po) throws Exception{

			if( po != null )
				 appParentingEarlyStageDetailsDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingEarlyStageDetailsDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingEarlyStageDetailsDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingEarlyStageDetailsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingEarlyStageDetailsPO> list = appParentingEarlyStageDetailsDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过EARLY_ID查询新生儿早期记录详情表信息
	 * @param map
	 * @return
	 */
	public List<AppParentingEarlyStageDetailsPO> findAppParentingEarlyStageDetailsListByEarlyId(String earlyId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("earlyId", earlyId);
		return this.appParentingEarlyStageDetailsDao.findAppParentingEarlyStageDetailsListByCondition(map);
	}
}