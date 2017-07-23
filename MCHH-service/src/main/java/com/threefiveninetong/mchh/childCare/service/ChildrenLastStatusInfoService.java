/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenLastStatusInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:02 
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


import com.threefiveninetong.mchh.childCare.po.ChildrenLastStatusInfoPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenLastStatusInfoDao;

/**
 * @ClassName: ChildrenLastStatusInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:02 
 */
@Service
public class ChildrenLastStatusInfoService {

	private static final Logger log =Logger.getLogger(ChildrenLastStatusInfoService.class);
	
	@Resource
	private  ChildrenLastStatusInfoDao  childrenLastStatusInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenLastStatusInfo 
	 */
	public ChildrenLastStatusInfoPO find(Serializable id){
		return childrenLastStatusInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenLastStatusInfoPO> 
	 */
	public List<ChildrenLastStatusInfoPO> findAll(){
		return childrenLastStatusInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenLastStatusInfoPO po) throws Exception{
		
			if( po != null )
				 childrenLastStatusInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenLastStatusInfoPO po) throws Exception{

			if( po != null )
				 childrenLastStatusInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenLastStatusInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenLastStatusInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenLastStatusInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenLastStatusInfoPO> list = childrenLastStatusInfoDao.listForPage(conds);
		page.setList(list);
	}


}