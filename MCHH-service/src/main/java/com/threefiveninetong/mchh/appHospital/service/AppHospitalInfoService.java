/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppHospitalInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appHospital.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appHospital.dao.AppHospitalInfoDao;
import com.threefiveninetong.mchh.appHospital.po.AppHospitalInfoPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppHospitalInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppHospitalInfoService {

	private static final Logger log =Logger.getLogger(AppHospitalInfoService.class);
	
	@Resource
	private  AppHospitalInfoDao  appHospitalInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppHospitalInfo 
	 */
	public AppHospitalInfoPO find(Serializable id){
		return appHospitalInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppHospitalInfoPO> 
	 */
	public List<AppHospitalInfoPO> findAll(){
		return appHospitalInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppHospitalInfoPO po) throws Exception{
		
			if( po != null )
				 appHospitalInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppHospitalInfoPO po) throws Exception{

			if( po != null )
				 appHospitalInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appHospitalInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appHospitalInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppHospitalInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppHospitalInfoPO> list = appHospitalInfoDao.listForPage(conds);
		page.setList(list);
	}


}