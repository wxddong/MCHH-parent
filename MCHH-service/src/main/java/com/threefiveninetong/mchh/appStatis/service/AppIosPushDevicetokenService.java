/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppIosPushDevicetokenService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appStatis.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appStatis.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appStatis.dao.AppIosPushDevicetokenDao;
import com.threefiveninetong.mchh.appStatis.po.AppIosPushDevicetokenPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppIosPushDevicetokenService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppIosPushDevicetokenService {

	private static final Logger log =Logger.getLogger(AppIosPushDevicetokenService.class);
	
	@Resource
	private  AppIosPushDevicetokenDao  appIosPushDevicetokenDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppIosPushDevicetoken 
	 */
	public AppIosPushDevicetokenPO find(Serializable id){
		return appIosPushDevicetokenDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppIosPushDevicetokenPO> 
	 */
	public List<AppIosPushDevicetokenPO> findAll(){
		return appIosPushDevicetokenDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppIosPushDevicetokenPO po) throws Exception{
		
			if( po != null )
				 appIosPushDevicetokenDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppIosPushDevicetokenPO po) throws Exception{

			if( po != null )
				 appIosPushDevicetokenDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appIosPushDevicetokenDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appIosPushDevicetokenDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppIosPushDevicetokenPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppIosPushDevicetokenPO> list = appIosPushDevicetokenDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过设备号查询Devicetoken信息
	 * @param map
	 * @return
	 */
	public List<AppIosPushDevicetokenPO> findDevicetokenListByEquipmentNo(String equipmentNo) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("equipmentNo", equipmentNo);
		return this.appIosPushDevicetokenDao.findDevicetokenListByCondition(map);
	}
}