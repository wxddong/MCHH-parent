/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPsychologicalBehaviorInfoService.java 
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


import com.threefiveninetong.mchh.childCare.po.ChildrenPsychologicalBehaviorInfoPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenPsychologicalBehaviorInfoDao;

/**
 * @ClassName: ChildrenPsychologicalBehaviorInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
@Service
public class ChildrenPsychologicalBehaviorInfoService {

	private static final Logger log =Logger.getLogger(ChildrenPsychologicalBehaviorInfoService.class);
	
	@Resource
	private  ChildrenPsychologicalBehaviorInfoDao  childrenPsychologicalBehaviorInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenPsychologicalBehaviorInfo 
	 */
	public ChildrenPsychologicalBehaviorInfoPO find(Serializable id){
		return childrenPsychologicalBehaviorInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenPsychologicalBehaviorInfoPO> 
	 */
	public List<ChildrenPsychologicalBehaviorInfoPO> findAll(){
		return childrenPsychologicalBehaviorInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenPsychologicalBehaviorInfoPO po) throws Exception{
		
			if( po != null )
				 childrenPsychologicalBehaviorInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenPsychologicalBehaviorInfoPO po) throws Exception{

			if( po != null )
				 childrenPsychologicalBehaviorInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenPsychologicalBehaviorInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenPsychologicalBehaviorInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenPsychologicalBehaviorInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenPsychologicalBehaviorInfoPO> list = childrenPsychologicalBehaviorInfoDao.listForPage(conds);
		page.setList(list);
	}


}