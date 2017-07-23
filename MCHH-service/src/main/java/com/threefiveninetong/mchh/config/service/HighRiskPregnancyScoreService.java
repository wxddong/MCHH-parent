/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskPregnancyScoreService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;
import com.threefiveninetong.mchh.config.dao.HighRiskPregnancyScoreDao;

/**
 * @ClassName: HighRiskPregnancyScoreService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Service
public class HighRiskPregnancyScoreService {

	private static final Logger log =Logger.getLogger(HighRiskPregnancyScoreService.class);
	
	@Resource
	private  HighRiskPregnancyScoreDao  highRiskPregnancyScoreDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return HighRiskPregnancyScore 
	 */
	public HighRiskPregnancyScorePO find(Serializable id){
		return highRiskPregnancyScoreDao.find(id);	
	}
	
	

	/**
	 * 查找单个 
	 * @param name 
	 * @return HighRiskPregnancyScore 
	 */
	public HighRiskPregnancyScorePO getHighRiskPregnancyScorePOByname(String name){
		return highRiskPregnancyScoreDao.getHighRiskPregnancyScorePOByname(name);	
	}
	
	/**
	 * 查找单个 
	 * @param name 
	 * @return HighRiskPregnancyScore 
	 */
	public HighRiskPregnancyScorePO findHighRiskPregnancyScorePOByname(String name){
		return highRiskPregnancyScoreDao.findHighRiskPregnancyScorePOByname(name);	
	}
	
	

	/**
	 * 查找所有 孕妇指导
	 * @return List<HighRiskPregnancyScorePO> 
	 */
	public List<HighRiskPregnancyScorePO> findAll(){
		return highRiskPregnancyScoreDao.findAll();	
	}
	
	
	
	/**
	 * 查找所有高危婴儿指导
	 * @return List<HighRiskPregnancyScorePO> 
	 */
	public List<HighRiskPregnancyScorePO> findAllBaby(){
		return highRiskPregnancyScoreDao.findAllBaby();	
	}
	
	
	
	

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HighRiskPregnancyScorePO po) throws Exception{
		
			if( po != null )
				 highRiskPregnancyScoreDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(HighRiskPregnancyScorePO po) throws Exception{

			if( po != null )
				 highRiskPregnancyScoreDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 highRiskPregnancyScoreDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		highRiskPregnancyScoreDao.deletes(id);
	}
	
	/**
	 * 查询列表 
	 * 高危孕妇
	 * @param id
	 *  
	 */
	public void listForPage(Map<String, Object> conds, Page<HighRiskPregnancyScorePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HighRiskPregnancyScorePO> list = highRiskPregnancyScoreDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 查询列表 
	 * 高危儿童
	 * @param id
	 *  
	 */
	public void listForPageBaby(Map<String, Object> conds, Page<HighRiskPregnancyScorePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HighRiskPregnancyScorePO> list = highRiskPregnancyScoreDao.listForPageBaby(conds);
		page.setList(list);
	}
	
	
	
	

	/**
	 * 查出所有高危项
	 * @return
	 * @author yanwk
	 */
	public List<HighRiskPregnancyScorePO> selectAll() {
		return highRiskPregnancyScoreDao.selectAll();
	}


}