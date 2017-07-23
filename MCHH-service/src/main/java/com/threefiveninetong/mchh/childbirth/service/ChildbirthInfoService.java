/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 20:03:48 
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


import com.threefiveninetong.mchh.childbirth.po.ChildbirthInfoPO;
import com.threefiveninetong.mchh.childbirth.dao.ChildbirthInfoDao;

/**
 * @ClassName: ChildbirthInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 20:03:48 
 */
@Service
public class ChildbirthInfoService {

	private static final Logger log =Logger.getLogger(ChildbirthInfoService.class);
	
	@Resource
	private  ChildbirthInfoDao  childbirthInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthInfo 
	 */
	public ChildbirthInfoPO find(Serializable id){
		return childbirthInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildbirthInfoPO> 
	 */
	public List<ChildbirthInfoPO> findAll(){
		return childbirthInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthInfoPO po) throws Exception{
		
			if( po != null )
				 childbirthInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildbirthInfoPO po) throws Exception{

			if( po != null )
				 childbirthInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childbirthInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childbirthInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildbirthInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildbirthInfoPO> list = childbirthInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据分娩基本信息id获取到分娩信息表数据
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public ChildbirthInfoPO getChildbirthByBasicId(String id) {
		return childbirthInfoDao.getChildbirthByBasicId(id);
	}


}