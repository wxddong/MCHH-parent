/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaDetailedInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.postpartum.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
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


import com.threefiveninetong.mchh.postpartum.po.PostpartumExaDetailedInfoPO;
import com.threefiveninetong.mchh.postpartum.dao.PostpartumExaDetailedInfoDao;

/**
 * @ClassName: PostpartumExaDetailedInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
@Service
public class PostpartumExaDetailedInfoService {

	private static final Logger log =Logger.getLogger(PostpartumExaDetailedInfoService.class);
	
	@Resource
	private  PostpartumExaDetailedInfoDao  postpartumExaDetailedInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumExaDetailedInfo 
	 */
	public PostpartumExaDetailedInfoPO find(Serializable id){
		return postpartumExaDetailedInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PostpartumExaDetailedInfoPO> 
	 */
	public List<PostpartumExaDetailedInfoPO> findAll(){
		return postpartumExaDetailedInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(PostpartumExaDetailedInfoPO po) throws Exception{
		
			if( po != null )
				 postpartumExaDetailedInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(PostpartumExaDetailedInfoPO po) throws Exception{

			if( po != null )
				 postpartumExaDetailedInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 postpartumExaDetailedInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		postpartumExaDetailedInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PostpartumExaDetailedInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PostpartumExaDetailedInfoPO> list = postpartumExaDetailedInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据产后检查的id获取产后检查详细信息表
	 * wangxd 2016.9.9
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumExaDetailedInfoPO getPostpartumExaDetailByPostpartumExaId(String postpartumExaId) {
		return postpartumExaDetailedInfoDao.getPostpartumExaDetailByPostpartumExaId(postpartumExaId);
	}


}