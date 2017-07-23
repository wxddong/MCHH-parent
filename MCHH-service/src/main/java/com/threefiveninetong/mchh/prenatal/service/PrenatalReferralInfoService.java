/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalReferralInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:17 
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


import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.PrenatalReferralInfoDao;

/**
 * @ClassName: PrenatalReferralInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:17 
 */
@Service
public class PrenatalReferralInfoService {

	private static final Logger log =Logger.getLogger(PrenatalReferralInfoService.class);
	
	@Resource
	private  PrenatalReferralInfoDao  prenatalReferralInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PrenatalReferralInfo 
	 */
	public PrenatalReferralInfoPO find(Serializable id){
		return prenatalReferralInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PrenatalReferralInfoPO> 
	 */
	public List<PrenatalReferralInfoPO> findAll(){
		return prenatalReferralInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PrenatalReferralInfoPO po) throws Exception{
		
			if( po != null )
				 prenatalReferralInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PrenatalReferralInfoPO po) throws Exception{

			if( po != null )
				 prenatalReferralInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 prenatalReferralInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		prenatalReferralInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PrenatalReferralInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PrenatalReferralInfoPO> list = prenatalReferralInfoDao.listForPage(conds);
		page.setList(list);
	}


}