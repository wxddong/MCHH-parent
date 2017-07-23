/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppExpertGuidanceService.java 
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
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.appConfig.dao.AppExpertGuidanceDao;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

/**
 * @ClassName: AppExpertGuidanceService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppExpertGuidanceService {

	private static final Logger log =Logger.getLogger(AppExpertGuidanceService.class);
	
	@Resource
	private  AppExpertGuidanceDao  appExpertGuidanceDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppExpertGuidance 
	 */
	public AppExpertGuidancePO find(Serializable id){
		return appExpertGuidanceDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppExpertGuidancePO> 
	 */
	public List<AppExpertGuidancePO> findAll(){
		return appExpertGuidanceDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppExpertGuidancePO po) throws Exception{
		
			if( po != null )
				 appExpertGuidanceDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppExpertGuidancePO po) throws Exception{

			if( po != null )
				 appExpertGuidanceDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appExpertGuidanceDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appExpertGuidanceDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppExpertGuidancePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppExpertGuidancePO> list = appExpertGuidanceDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 查询各个阶段专家指导意见信息
	 * @param map
	 * @return
	 */
	public List<AppExpertGuidancePO> findAppExpertGuidanceListByClassification(String type) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> classificationList = new ArrayList<String>();
		classificationList.add(type);
		map.put("classificationList", classificationList);
		map.put("effective", "effective");
		map.put("status", EffectStatus.有效.getValue());
		return this.appExpertGuidanceDao.findAppExpertGuidanceListByCondition(map);
	}

}