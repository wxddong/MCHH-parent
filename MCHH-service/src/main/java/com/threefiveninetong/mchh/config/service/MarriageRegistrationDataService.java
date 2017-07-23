/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: MarriageRegistrationDataService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.config.dao.MarriageRegistrationDataDao;
import com.threefiveninetong.mchh.config.po.MarriageRegistrationDataPO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalHealthCarePO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: MarriageRegistrationDataService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Service
public class MarriageRegistrationDataService {

	private static final Logger log =Logger.getLogger(MarriageRegistrationDataService.class);
	
	@Resource
	private  MarriageRegistrationDataDao  marriageRegistrationDataDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return MarriageRegistrationData 
	 */
	public MarriageRegistrationDataPO find(Serializable id){
		return marriageRegistrationDataDao.find(id);	
	}
	
	
	
	/**
	 * 查找单个 通过区县id
	 * @param cityId 
	 * @return MarriageRegistrationData 
	 */
	public List<PremaritalHealthCarePO> listForPage(Map<String, Object> conds){
		return marriageRegistrationDataDao.listForPage1(conds);	
	}
	/**
	 * 查找所有 
	 * @return List<MarriageRegistrationDataPO> 
	 */
	public List<MarriageRegistrationDataPO> findAll(){
		return marriageRegistrationDataDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(MarriageRegistrationDataPO po) throws Exception{
		
			if( po != null )
				 marriageRegistrationDataDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(MarriageRegistrationDataPO po) throws Exception{

			if( po != null )
				 marriageRegistrationDataDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 marriageRegistrationDataDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		marriageRegistrationDataDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<MarriageRegistrationDataPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<MarriageRegistrationDataPO> list = marriageRegistrationDataDao.listForPage(conds);
		page.setList(list);
	}


}