/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ObstetricExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
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


import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.ObstetricExaInfoDao;

/**
 * @ClassName: ObstetricExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
@Service
public class ObstetricExaInfoService {

	private static final Logger log =Logger.getLogger(ObstetricExaInfoService.class);
	
	@Resource
	private  ObstetricExaInfoDao  obstetricExaInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ObstetricExaInfo 
	 */
	public ObstetricExaInfoPO find(Serializable id){
		return obstetricExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ObstetricExaInfoPO> 
	 */
	public List<ObstetricExaInfoPO> findAll(){
		return obstetricExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ObstetricExaInfoPO po) throws Exception{
		
			if( po != null )
				 obstetricExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ObstetricExaInfoPO po) throws Exception{

			if( po != null )
				 obstetricExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 obstetricExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		obstetricExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ObstetricExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ObstetricExaInfoPO> list = obstetricExaInfoDao.listForPage(conds);
		page.setList(list);
	}


}