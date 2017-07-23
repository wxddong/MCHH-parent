/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppActivationService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appStatis.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appStatis.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appStatis.dao.AppActivationDao;
import com.threefiveninetong.mchh.appStatis.po.AppActivationPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppActivationService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppActivationService {

	private static final Logger log =Logger.getLogger(AppActivationService.class);
	
	@Resource
	private  AppActivationDao  appActivationDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppActivation 
	 */
	public AppActivationPO find(Serializable id){
		return appActivationDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppActivationPO> 
	 */
	public List<AppActivationPO> findAll(){
		return appActivationDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppActivationPO po) throws Exception{
		
			if( po != null )
				 appActivationDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppActivationPO po) throws Exception{

			if( po != null )
				 appActivationDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appActivationDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appActivationDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppActivationPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppActivationPO> list = appActivationDao.listForPage(conds);
		page.setList(list);
	}

	/**
     * 通过设备号查找激活
     * 
     * @param id
     * @return Activation
     */
    public AppActivationPO findByEquipmentNo(String equipmentNo) {
    	return this.appActivationDao.findByEquipmentNo(equipmentNo);
    }
}