/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthReferralInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.childbirth.po.ChildbirthReferralInfoPO;
import com.threefiveninetong.mchh.childbirth.dao.ChildbirthReferralInfoDao;

/**
 * @ClassName: ChildbirthReferralInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
@Service
public class ChildbirthReferralInfoService {

	private static final Logger log =Logger.getLogger(ChildbirthReferralInfoService.class);
	
	@Resource
	private  ChildbirthReferralInfoDao  childbirthReferralInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthReferralInfo 
	 */
	public ChildbirthReferralInfoPO find(Serializable id){
		return childbirthReferralInfoDao.find(id);	
	}
	
	
	/**
	 * 查找单个 分娩转诊信息通过分娩信息id
	 * @param id 
	 * @return ChildbirthReferralInfo 
	 */
	public ChildbirthReferralInfoPO findByChildBirthInfoId(String id){
		return childbirthReferralInfoDao.findByChildBirthInfoId(id);	
	}
	
	
	
	
	/**
	 * 查找单个 分娩转诊信息通过分娩信息id
	 * @param id 
	 * @return ChildbirthReferralInfo 
	 */
	public ChildbirthReferralInfoPO findByChildBirthId(String id){
		return childbirthReferralInfoDao.findByChildBirthId(id);	
	}
	
	

	/**
	 * 查找所有 
	 * @return List<ChildbirthReferralInfoPO> 
	 */
	public List<ChildbirthReferralInfoPO> findAll(){
		return childbirthReferralInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthReferralInfoPO po) throws Exception{
		
			if( po != null )
				 childbirthReferralInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildbirthReferralInfoPO po) throws Exception{

			if( po != null )
				 childbirthReferralInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childbirthReferralInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childbirthReferralInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildbirthReferralInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildbirthReferralInfoPO> list = childbirthReferralInfoDao.listForPage(conds);
		page.setList(list);
	}


}