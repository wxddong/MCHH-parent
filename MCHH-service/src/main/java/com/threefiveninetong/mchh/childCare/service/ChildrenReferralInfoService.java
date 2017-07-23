/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenReferralInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:04 
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


import com.threefiveninetong.mchh.childCare.po.ChildrenReferralInfoPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenReferralInfoDao;

/**
 * @ClassName: ChildrenReferralInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:04 
 */
@Service
public class ChildrenReferralInfoService {

	private static final Logger log =Logger.getLogger(ChildrenReferralInfoService.class);
	
	@Resource
	private  ChildrenReferralInfoDao  childrenReferralInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenReferralInfo 
	 */
	public ChildrenReferralInfoPO find(Serializable id){
		return childrenReferralInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenReferralInfoPO> 
	 */
	public List<ChildrenReferralInfoPO> findAll(){
		return childrenReferralInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenReferralInfoPO po) throws Exception{
		
			if( po != null )
				 childrenReferralInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenReferralInfoPO po) throws Exception{

			if( po != null )
				 childrenReferralInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenReferralInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenReferralInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenReferralInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenReferralInfoPO> list = childrenReferralInfoDao.listForPage(conds);
		page.setList(list);
	}


}