/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: LaboratorySpecialInsInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
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


import com.threefiveninetong.mchh.premarital.po.LaboratorySpecialInsInfoPO;
import com.threefiveninetong.mchh.premarital.dao.LaboratorySpecialInsInfoDao;

/**
 * @ClassName: LaboratorySpecialInsInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@Service
public class LaboratorySpecialInsInfoService {

	private static final Logger log =Logger.getLogger(LaboratorySpecialInsInfoService.class);
	
	@Resource
	private  LaboratorySpecialInsInfoDao  laboratorySpecialInsInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return LaboratorySpecialInsInfo 
	 */
	public LaboratorySpecialInsInfoPO find(Serializable id){
		return laboratorySpecialInsInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<LaboratorySpecialInsInfoPO> 
	 */
	public List<LaboratorySpecialInsInfoPO> findAll(){
		return laboratorySpecialInsInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(LaboratorySpecialInsInfoPO po) throws Exception{
		
			if( po != null )
				 laboratorySpecialInsInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(LaboratorySpecialInsInfoPO po) throws Exception{

			if( po != null )
				 laboratorySpecialInsInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 laboratorySpecialInsInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		laboratorySpecialInsInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<LaboratorySpecialInsInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<LaboratorySpecialInsInfoPO> list = laboratorySpecialInsInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据婚检id获取实验室检查信息
	 * @param premaritalId
	 * @return
	 */
	public LaboratorySpecialInsInfoPO getLaboratoryByPremaritalId(String premaritalId) {
		// TODO Auto-generated method stub
		return laboratorySpecialInsInfoDao.getLaboratoryByPremaritalId(premaritalId);
	}

	/**
	 * 修改
	 * @param laboratorySpecialInsInfoPO
	 * @throws Exception
	 */
	public void edit(LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if (laboratorySpecialInsInfoPO != null) {
			laboratorySpecialInsInfoDao.edit(laboratorySpecialInsInfoPO);
		}
	}


}