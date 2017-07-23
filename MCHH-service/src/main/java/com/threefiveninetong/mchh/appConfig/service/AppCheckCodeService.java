/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppCheckCodeService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appConfig.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.dao.AppCheckCodeDao;
import com.threefiveninetong.mchh.appConfig.po.AppCheckCodePO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppCheckCodeService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppCheckCodeService {

	private static final Logger log =Logger.getLogger(AppCheckCodeService.class);
	
	@Resource
	private  AppCheckCodeDao  appCheckCodeDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppCheckCode 
	 */
	public AppCheckCodePO find(Serializable id){
		return appCheckCodeDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppCheckCodePO> 
	 */
	public List<AppCheckCodePO> findAll(){
		return appCheckCodeDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppCheckCodePO po) throws Exception{
		
			if( po != null )
				 appCheckCodeDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppCheckCodePO po) throws Exception{

			if( po != null )
				 appCheckCodeDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appCheckCodeDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appCheckCodeDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppCheckCodePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppCheckCodePO> list = appCheckCodeDao.listForPage(conds);
		page.setList(list);
	}


}