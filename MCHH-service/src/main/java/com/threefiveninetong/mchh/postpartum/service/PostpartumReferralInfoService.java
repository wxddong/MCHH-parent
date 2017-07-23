/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumReferralInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.postpartum.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.postpartum.po.PostpartumReferralInfoPO;
import com.threefiveninetong.mchh.postpartum.dao.PostpartumReferralInfoDao;

/**
 * @ClassName: PostpartumReferralInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
@Service
public class PostpartumReferralInfoService {

	private static final Logger log =Logger.getLogger(PostpartumReferralInfoService.class);
	
	@Resource
	private  PostpartumReferralInfoDao  postpartumReferralInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumReferralInfo 
	 */
	public PostpartumReferralInfoPO find(Serializable id){
		return postpartumReferralInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PostpartumReferralInfoPO> 
	 */
	public List<PostpartumReferralInfoPO> findAll(){
		return postpartumReferralInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(PostpartumReferralInfoPO po) throws Exception{
		
			if( po != null )
				 postpartumReferralInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(PostpartumReferralInfoPO po) throws Exception{

			if( po != null )
				 postpartumReferralInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 postpartumReferralInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		postpartumReferralInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PostpartumReferralInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PostpartumReferralInfoPO> list = postpartumReferralInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据产后检查表id查询产后转诊信息
	 * wangxd 2016.9.9
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumReferralInfoPO getPostpartumReferralByPostpartumExaId(String postpartumExaId) {
		return postpartumReferralInfoDao.getPostpartumReferralByPostpartumExaId(postpartumExaId);
	}


}