/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMoodRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appMember.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appMember.dao.AppMoodRecordDao;
import com.threefiveninetong.mchh.appMember.po.AppMoodRecordPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppMoodRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppMoodRecordService {

	private static final Logger log =Logger.getLogger(AppMoodRecordService.class);
	
	@Resource
	private  AppMoodRecordDao  appMoodRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMoodRecord 
	 */
	public AppMoodRecordPO find(Serializable id){
		return appMoodRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppMoodRecordPO> 
	 */
	public List<AppMoodRecordPO> findAll(){
		return appMoodRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMoodRecordPO po) throws Exception{
		
			if( po != null )
				 appMoodRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppMoodRecordPO po) throws Exception{

			if( po != null )
				 appMoodRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appMoodRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appMoodRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppMoodRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMoodRecordPO> list = appMoodRecordDao.listForPage(conds);
		page.setList(list);
	}


}