/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaOtherInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.postpartum.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 13:47:42 
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


import com.threefiveninetong.mchh.postpartum.po.PostpartumExaOtherInfoPO;
import com.threefiveninetong.mchh.postpartum.dao.PostpartumExaOtherInfoDao;

/**
 * @ClassName: PostpartumExaOtherInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 13:47:42 
 */
@Service
public class PostpartumExaOtherInfoService {

	private static final Logger log =Logger.getLogger(PostpartumExaOtherInfoService.class);
	
	@Resource
	private  PostpartumExaOtherInfoDao  postpartumExaOtherInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumExaOtherInfo 
	 */
	public PostpartumExaOtherInfoPO find(Serializable id){
		return postpartumExaOtherInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PostpartumExaOtherInfoPO> 
	 */
	public List<PostpartumExaOtherInfoPO> findAll(){
		return postpartumExaOtherInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(PostpartumExaOtherInfoPO po) throws Exception{
		
			if( po != null )
				 postpartumExaOtherInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(PostpartumExaOtherInfoPO po) throws Exception{

			if( po != null )
				 postpartumExaOtherInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 postpartumExaOtherInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		postpartumExaOtherInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PostpartumExaOtherInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PostpartumExaOtherInfoPO> list = postpartumExaOtherInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据产后检查的id获取产后检查产后检查其他表中的信息
	 * wangxd 2016.9.9
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumExaOtherInfoPO getPostpartumExaOtherByPostpartumExaId(String postpartumExaId) {
		return postpartumExaOtherInfoDao.getPostpartumExaOtherByPostpartumExaId(postpartumExaId);
	}


}