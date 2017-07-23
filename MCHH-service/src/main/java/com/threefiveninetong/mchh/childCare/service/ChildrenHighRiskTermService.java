/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskTermService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:05 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskTermPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenHighRiskTermDao;

/**
 * @ClassName: ChildrenHighRiskTermService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
@Service
public class ChildrenHighRiskTermService {

	private static final Logger log =Logger.getLogger(ChildrenHighRiskTermService.class);
	
	@Resource
	private  ChildrenHighRiskTermDao  childrenHighRiskTermDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenHighRiskTerm 
	 */
	public ChildrenHighRiskTermPO find(Serializable id){
		return childrenHighRiskTermDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenHighRiskTermPO> 
	 */
	public List<ChildrenHighRiskTermPO> findAll(){
		return childrenHighRiskTermDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenHighRiskTermPO po) throws Exception{
		
			if( po != null )
				 childrenHighRiskTermDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenHighRiskTermPO po) throws Exception{

			if( po != null )
				 childrenHighRiskTermDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenHighRiskTermDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenHighRiskTermDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenHighRiskTermPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenHighRiskTermPO> list = childrenHighRiskTermDao.listForPage(conds);
		page.setList(list);
	}


}