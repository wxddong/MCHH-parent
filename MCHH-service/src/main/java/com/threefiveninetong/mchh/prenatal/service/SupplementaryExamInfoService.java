/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SupplementaryExamInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
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


import com.threefiveninetong.mchh.prenatal.po.SupplementaryExamInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.SupplementaryExamInfoDao;

/**
 * @ClassName: SupplementaryExamInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
@Service
public class SupplementaryExamInfoService {

	private static final Logger log =Logger.getLogger(SupplementaryExamInfoService.class);
	
	@Resource
	private  SupplementaryExamInfoDao  supplementaryExamInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SupplementaryExamInfo 
	 */
	public SupplementaryExamInfoPO find(Serializable id){
		return supplementaryExamInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SupplementaryExamInfoPO> 
	 */
	public List<SupplementaryExamInfoPO> findAll(){
		return supplementaryExamInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SupplementaryExamInfoPO po) throws Exception{
		
			if( po != null )
				 supplementaryExamInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(SupplementaryExamInfoPO po) throws Exception{

			if( po != null )
				 supplementaryExamInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 supplementaryExamInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		supplementaryExamInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<SupplementaryExamInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<SupplementaryExamInfoPO> list = supplementaryExamInfoDao.listForPage(conds);
		page.setList(list);
	}


}