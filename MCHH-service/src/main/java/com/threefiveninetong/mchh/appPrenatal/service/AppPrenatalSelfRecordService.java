/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalSelfRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPrenatal.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPrenatal.dao.AppPrenatalSelfRecordDao;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPrenatalSelfRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPrenatalSelfRecordService {

	private static final Logger log =Logger.getLogger(AppPrenatalSelfRecordService.class);
	
	@Resource
	private  AppPrenatalSelfRecordDao  appPrenatalSelfRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalSelfRecord 
	 */
	public AppPrenatalSelfRecordPO find(Serializable id){
		return appPrenatalSelfRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPrenatalSelfRecordPO> 
	 */
	public List<AppPrenatalSelfRecordPO> findAll(){
		return appPrenatalSelfRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalSelfRecordPO po) throws Exception{
		
			if( po != null )
				 appPrenatalSelfRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPrenatalSelfRecordPO po) throws Exception{

			if( po != null )
				 appPrenatalSelfRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPrenatalSelfRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPrenatalSelfRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPrenatalSelfRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPrenatalSelfRecordPO> list = appPrenatalSelfRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MBrId查询孕产期最近一条自我情况信息
	 * @param map
	 * @return
	 */
	public AppPrenatalSelfRecordPO findAppPrenatalSelfRecordInfoByMbrId(String mbrId,String period) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("period", period);
		map.put("num", 1);
		List<AppPrenatalSelfRecordPO>  list = this.appPrenatalSelfRecordDao.findAppPrenatalSelfRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
}