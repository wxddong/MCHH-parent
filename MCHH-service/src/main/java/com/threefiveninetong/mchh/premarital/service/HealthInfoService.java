/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HealthInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.premarital.po.HealthInfoPO;
import com.threefiveninetong.mchh.premarital.dao.HealthInfoDao;

/**
 * @ClassName: HealthInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
@Service
public class HealthInfoService {

	private static final Logger log =Logger.getLogger(HealthInfoService.class);
	
	@Resource
	private  HealthInfoDao  healthInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return HealthInfo 
	 */
	public HealthInfoPO find(Serializable id){
		return healthInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<HealthInfoPO> 
	 */
	public List<HealthInfoPO> findAll(){
		return healthInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HealthInfoPO po) throws Exception{
		
			if( po != null )
				 healthInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(HealthInfoPO po) throws Exception{

			if( po != null )
				 healthInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 healthInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		healthInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<HealthInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HealthInfoPO> list = healthInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据婚检id获取健康状况信息
	 * @param premaritalId
	 * @return
	 */
	public HealthInfoPO getHealthByPremaritalId(String premaritalId) {
		// TODO Auto-generated method stub
		return healthInfoDao.getHealthByPremaritalId(premaritalId);
	}

	public void edit(HealthInfoPO po) throws Exception{
		// TODO Auto-generated method stub
		if ( po != null) {
			healthInfoDao.edit(po);
		}
	}


}