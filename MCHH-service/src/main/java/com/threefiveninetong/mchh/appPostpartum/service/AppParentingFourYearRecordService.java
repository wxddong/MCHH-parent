/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingFourYearRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPostpartum.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-11-02 10:45:05 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingFourYearRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFourYearRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingFourYearRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:05 
 */
@Service
public class AppParentingFourYearRecordService {

	private static final Logger log =Logger.getLogger(AppParentingFourYearRecordService.class);
	
	@Resource
	private  AppParentingFourYearRecordDao  appParentingFourYearRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingFourYearRecord 
	 */
	public AppParentingFourYearRecordPO find(Serializable id){
		return appParentingFourYearRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingFourYearRecordPO> 
	 */
	public List<AppParentingFourYearRecordPO> findAll(){
		return appParentingFourYearRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingFourYearRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingFourYearRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingFourYearRecordPO po) throws Exception{

			if( po != null )
				 appParentingFourYearRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingFourYearRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingFourYearRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingFourYearRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingFourYearRecordPO> list = appParentingFourYearRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过parId查询育儿期四岁记录一条信息
	 * @param map
	 * @return
	 */
	public AppParentingFourYearRecordPO findAppParentingFourYearRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingFourYearRecordPO> list = this.appParentingFourYearRecordDao.findAppParentingFourYearRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}