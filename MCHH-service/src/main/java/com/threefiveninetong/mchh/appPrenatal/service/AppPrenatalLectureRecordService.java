/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalLectureRecordService.java 
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

import com.threefiveninetong.mchh.appPrenatal.dao.AppPrenatalLectureRecordDao;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalLectureRecordPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPrenatalLectureRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPrenatalLectureRecordService {

	private static final Logger log =Logger.getLogger(AppPrenatalLectureRecordService.class);
	
	@Resource
	private  AppPrenatalLectureRecordDao  appPrenatalLectureRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalLectureRecord 
	 */
	public AppPrenatalLectureRecordPO find(Serializable id){
		return appPrenatalLectureRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPrenatalLectureRecordPO> 
	 */
	public List<AppPrenatalLectureRecordPO> findAll(){
		return appPrenatalLectureRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalLectureRecordPO po) throws Exception{
		
			if( po != null )
				 appPrenatalLectureRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPrenatalLectureRecordPO po) throws Exception{

			if( po != null )
				 appPrenatalLectureRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPrenatalLectureRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPrenatalLectureRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPrenatalLectureRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPrenatalLectureRecordPO> list = appPrenatalLectureRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过Mbrid查询孕产期听课记录
	 * @param map
	 * @return
	 */
	public List<AppPrenatalLectureRecordPO> findAppPrenatalLectureRecordListByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		return this.appPrenatalLectureRecordDao.findAppPrenatalLectureRecordListByCondition(map);
	}
}