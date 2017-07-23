/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingBabyGrowRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingBabyGrowRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyGrowRecordPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingBabyGrowRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppParentingBabyGrowRecordService {

	private static final Logger log =Logger.getLogger(AppParentingBabyGrowRecordService.class);
	
	@Resource
	private  AppParentingBabyGrowRecordDao  appParentingBabyGrowRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingBabyGrowRecord 
	 */
	public AppParentingBabyGrowRecordPO find(Serializable id){
		return appParentingBabyGrowRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingBabyGrowRecordPO> 
	 */
	public List<AppParentingBabyGrowRecordPO> findAll(){
		return appParentingBabyGrowRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingBabyGrowRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingBabyGrowRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingBabyGrowRecordPO po) throws Exception{

			if( po != null )
				 appParentingBabyGrowRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingBabyGrowRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingBabyGrowRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingBabyGrowRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingBabyGrowRecordPO> list = appParentingBabyGrowRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过parId查询宝宝生产记录信息
	 * @param map
	 * @return
	 */
	public List<AppParentingBabyGrowRecordPO> findAppParentingBabyGrowRecordListByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		return this.appParentingBabyGrowRecordDao.findAppParentingBabyGrowRecordListByCondition(map);
	}
}