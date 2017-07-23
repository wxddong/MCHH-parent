/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingFiveYearRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingFiveYearRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFiveYearRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingFiveYearRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-11-02 10:45:05 
 */
@Service
public class AppParentingFiveYearRecordService {

	private static final Logger log =Logger.getLogger(AppParentingFiveYearRecordService.class);
	
	@Resource
	private  AppParentingFiveYearRecordDao  appParentingFiveYearRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingFiveYearRecord 
	 */
	public AppParentingFiveYearRecordPO find(Serializable id){
		return appParentingFiveYearRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingFiveYearRecordPO> 
	 */
	public List<AppParentingFiveYearRecordPO> findAll(){
		return appParentingFiveYearRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingFiveYearRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingFiveYearRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingFiveYearRecordPO po) throws Exception{

			if( po != null )
				 appParentingFiveYearRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingFiveYearRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingFiveYearRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingFiveYearRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingFiveYearRecordPO> list = appParentingFiveYearRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照parId查询育儿期五岁一条信息
	 * @param map
	 * @return
	 */
	public AppParentingFiveYearRecordPO findAppParentingFiveYearRecordInfoByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		map.put("num", 1);
		List<AppParentingFiveYearRecordPO> list = this.appParentingFiveYearRecordDao.findAppParentingFiveYearRecordListByConditon(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}