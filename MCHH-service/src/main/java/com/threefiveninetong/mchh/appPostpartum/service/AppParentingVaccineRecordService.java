/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingVaccineRecordService.java 
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

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingVaccineRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingVaccineRecordPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingVaccineRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppParentingVaccineRecordService {

	private static final Logger log =Logger.getLogger(AppParentingVaccineRecordService.class);
	
	@Resource
	private  AppParentingVaccineRecordDao  appParentingVaccineRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingVaccineRecord 
	 */
	public AppParentingVaccineRecordPO find(Serializable id){
		return appParentingVaccineRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingVaccineRecordPO> 
	 */
	public List<AppParentingVaccineRecordPO> findAll(){
		return appParentingVaccineRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingVaccineRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingVaccineRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingVaccineRecordPO po) throws Exception{

			if( po != null )
				 appParentingVaccineRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingVaccineRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingVaccineRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingVaccineRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingVaccineRecordPO> list = appParentingVaccineRecordDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 通过parId查询宝宝疫苗接种信息
	 * @param parId
	 * @return
	 */
	public List<AppParentingVaccineRecordPO> findAppParentingVaccineRecordListByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		return this.appParentingVaccineRecordDao.findAppParentingVaccineRecordListByCondition(map);
	}
}