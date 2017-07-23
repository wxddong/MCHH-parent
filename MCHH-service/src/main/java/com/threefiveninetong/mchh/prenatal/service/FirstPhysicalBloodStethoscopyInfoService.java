/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstPhysicalBloodStethoscopyInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.prenatal.po.FirstPhysicalBloodStethoscopyInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.FirstPhysicalBloodStethoscopyInfoDao;

/**
 * @ClassName: FirstPhysicalBloodStethoscopyInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@Service
public class FirstPhysicalBloodStethoscopyInfoService {

	private static final Logger log =Logger.getLogger(FirstPhysicalBloodStethoscopyInfoService.class);
	
	@Resource
	private  FirstPhysicalBloodStethoscopyInfoDao  firstPhysicalBloodStethoscopyInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return FirstPhysicalBloodStethoscopyInfo 
	 */
	public FirstPhysicalBloodStethoscopyInfoPO find(Serializable id){
		return firstPhysicalBloodStethoscopyInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<FirstPhysicalBloodStethoscopyInfoPO> 
	 */
	public List<FirstPhysicalBloodStethoscopyInfoPO> findAll(){
		return firstPhysicalBloodStethoscopyInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(FirstPhysicalBloodStethoscopyInfoPO po) throws Exception{
		
			if( po != null )
				 firstPhysicalBloodStethoscopyInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(FirstPhysicalBloodStethoscopyInfoPO po) throws Exception{

			if( po != null )
				 firstPhysicalBloodStethoscopyInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 firstPhysicalBloodStethoscopyInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		firstPhysicalBloodStethoscopyInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<FirstPhysicalBloodStethoscopyInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<FirstPhysicalBloodStethoscopyInfoPO> list = firstPhysicalBloodStethoscopyInfoDao.listForPage(conds);
		page.setList(list);
	}


}