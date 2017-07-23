/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskTermService.java 
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


import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.dao.HighRiskTermDao;

/**
 * @ClassName: HighRiskTermService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@Service
public class HighRiskTermService {

	private static final Logger log =Logger.getLogger(HighRiskTermService.class);
	
	@Resource
	private  HighRiskTermDao  highRiskTermDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return HighRiskTerm 
	 */
	public HighRiskTermPO find(Serializable id){
		return highRiskTermDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<HighRiskTermPO> 
	 */
	public List<HighRiskTermPO> findAll(){
		return highRiskTermDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HighRiskTermPO po) throws Exception{
		
			if( po != null )
				 highRiskTermDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(HighRiskTermPO po) throws Exception{

			if( po != null )
				 highRiskTermDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 highRiskTermDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		highRiskTermDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<HighRiskTermPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HighRiskTermPO> list = highRiskTermDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 获取本次产检专案管理的所有未校正高危项
	 * @param highRiskId
	 * @return
	 * @author yanwk
	 */
	public List<HighRiskTermPO> getAllTermByhighRiskId(String highRiskId) {
		return highRiskTermDao.getAllTermByhighRiskId(highRiskId);
	}

	/**
	 * 获取本次产检专案管理的所有高危项
	 * @param highRiskId
	 * @return
	 * @author yanwk
	 */
	public List<HighRiskTermPO> getThisHighRiskTermByHighRiskId(String highRiskId) {
		return highRiskTermDao.getThisHighRiskTermByHighRiskId(highRiskId);
	}

	/**
	 * 通过高危专案表id和已矫正状态获取高危项个数
	 * @param highRiskId
	 * @return
	 * @author yanwk
	 */
	public int getCountByHighRiskIdAndState(String highRiskId){
		return highRiskTermDao.getCountByHighRiskIdAndState(highRiskId);
	}

}