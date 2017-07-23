/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: InspectionResultService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
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


import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;
import com.threefiveninetong.mchh.premarital.dao.InspectionResultDao;

/**
 * @ClassName: InspectionResultService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
@Service
public class InspectionResultService {

	private static final Logger log =Logger.getLogger(InspectionResultService.class);
	
	@Resource
	private  InspectionResultDao  inspectionResultDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return InspectionResult 
	 */
	public InspectionResultPO find(Serializable id){
		return inspectionResultDao.find(id);	
	}

	
	
	
	/**
	 * 查找所有 
	 * @return List<InspectionResultPO> 
	 */
	public List<InspectionResultPO> findAll(){
		return inspectionResultDao.findAll();	
	}

	/**
	 * 查找所有 得病的人
	 * @return List<InspectionResultPO> 
	 */
	public List<InspectionResultPO> findAllIll(){
		return inspectionResultDao.findAllIll();	
	}
	
	/**
	 * 查找所有 进行过咨询的人
	 * @return List<InspectionResultPO> 
	 */
	public List<InspectionResultPO> findAllAsk(){
		return inspectionResultDao.findAllAsk();	
	}
	
	
	

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(InspectionResultPO po) throws Exception{
		
			if( po != null )
				 inspectionResultDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(InspectionResultPO po) throws Exception{

			if( po != null )
				 inspectionResultDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 inspectionResultDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		inspectionResultDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<InspectionResultPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<InspectionResultPO> list = inspectionResultDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据婚检id获取检查结果信息
	 * @param premaritalId
	 * @return
	 */
	public InspectionResultPO getInspectionByPremaritalId(String premaritalId) {
		// TODO Auto-generated method stub
		return inspectionResultDao.getInspectionByPremaritalId(premaritalId);
	}

	/**
	 * 修改
	 * @param inspectionResultPO
	 */
	public void edit(InspectionResultPO inspectionResultPO) throws Exception{
		// TODO Auto-generated method stub
		if (inspectionResultPO != null) {
			inspectionResultDao.edit(inspectionResultPO);
		}
	}


}