/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskInfoService.java 
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


import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskInfoPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenHighRiskInfoDao;

/**
 * @ClassName: ChildrenHighRiskInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:05 
 */
@Service
public class ChildrenHighRiskInfoService {

	private static final Logger log =Logger.getLogger(ChildrenHighRiskInfoService.class);
	
	@Resource
	private  ChildrenHighRiskInfoDao  childrenHighRiskInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenHighRiskInfo 
	 */
	public ChildrenHighRiskInfoPO find(Serializable id){
		return childrenHighRiskInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenHighRiskInfoPO> 
	 */
	public List<ChildrenHighRiskInfoPO> findAll(){
		return childrenHighRiskInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenHighRiskInfoPO po) throws Exception{
		
			if( po != null )
				 childrenHighRiskInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenHighRiskInfoPO po) throws Exception{

			if( po != null )
				 childrenHighRiskInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenHighRiskInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenHighRiskInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenHighRiskInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenHighRiskInfoPO> list = childrenHighRiskInfoDao.listForPage(conds);
		page.setList(list);
	}


}