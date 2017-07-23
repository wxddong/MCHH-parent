/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppVersionForcedUpdateService.java 
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

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.dao.AppVersionForcedUpdateDao;
import com.threefiveninetong.mchh.appConfig.po.AppVersionForcedUpdatePO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppVersionForcedUpdateService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppVersionForcedUpdateService {

	private static final Logger log =Logger.getLogger(AppVersionForcedUpdateService.class);
	
	@Resource
	private  AppVersionForcedUpdateDao  appVersionForcedUpdateDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppVersionForcedUpdate 
	 */
	public AppVersionForcedUpdatePO find(Serializable id){
		return appVersionForcedUpdateDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppVersionForcedUpdatePO> 
	 */
	public List<AppVersionForcedUpdatePO> findAll(){
		return appVersionForcedUpdateDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppVersionForcedUpdatePO po) throws Exception{
		
			if( po != null )
				 appVersionForcedUpdateDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppVersionForcedUpdatePO po) throws Exception{

			if( po != null )
				 appVersionForcedUpdateDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appVersionForcedUpdateDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appVersionForcedUpdateDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppVersionForcedUpdatePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppVersionForcedUpdatePO> list = appVersionForcedUpdateDao.listForPage(conds);
		page.setList(list);
	}

	/**
     * 通过版本号、渠道、设备类型查找
     */
    public AppVersionForcedUpdatePO findByCode(String versionCode, String channelNO) {
    	return this.appVersionForcedUpdateDao.findByCode(versionCode, channelNO);
    }
}