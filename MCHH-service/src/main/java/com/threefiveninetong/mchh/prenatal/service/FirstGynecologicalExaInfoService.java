/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstGynecologicalExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.prenatal.po.FirstGynecologicalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.FirstGynecologicalExaInfoDao;

/**
 * @ClassName: FirstGynecologicalExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Service
public class FirstGynecologicalExaInfoService {

	private static final Logger log =Logger.getLogger(FirstGynecologicalExaInfoService.class);
	
	@Resource
	private  FirstGynecologicalExaInfoDao  firstGynecologicalExaInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return FirstGynecologicalExaInfo 
	 */
	public FirstGynecologicalExaInfoPO find(Serializable id){
		return firstGynecologicalExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<FirstGynecologicalExaInfoPO> 
	 */
	public List<FirstGynecologicalExaInfoPO> findAll(){
		return firstGynecologicalExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(FirstGynecologicalExaInfoPO po) throws Exception{
		
			if( po != null )
				 firstGynecologicalExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(FirstGynecologicalExaInfoPO po) throws Exception{

			if( po != null )
				 firstGynecologicalExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 firstGynecologicalExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		firstGynecologicalExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<FirstGynecologicalExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<FirstGynecologicalExaInfoPO> list = firstGynecologicalExaInfoDao.listForPage(conds);
		page.setList(list);
	}


}