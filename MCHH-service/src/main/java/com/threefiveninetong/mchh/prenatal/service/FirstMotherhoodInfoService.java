/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstMotherhoodInfoService.java 
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


import com.threefiveninetong.mchh.prenatal.po.FirstMotherhoodInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.FirstMotherhoodInfoDao;

/**
 * @ClassName: FirstMotherhoodInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Service
public class FirstMotherhoodInfoService {

	private static final Logger log =Logger.getLogger(FirstMotherhoodInfoService.class);
	
	@Resource
	private  FirstMotherhoodInfoDao  firstMotherhoodInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return FirstMotherhoodInfo 
	 */
	public FirstMotherhoodInfoPO find(Serializable id){
		return firstMotherhoodInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<FirstMotherhoodInfoPO> 
	 */
	public List<FirstMotherhoodInfoPO> findAll(){
		return firstMotherhoodInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(FirstMotherhoodInfoPO po) throws Exception{
		
			if( po != null )
				 firstMotherhoodInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(FirstMotherhoodInfoPO po) throws Exception{

			if( po != null )
				 firstMotherhoodInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 firstMotherhoodInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		firstMotherhoodInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<FirstMotherhoodInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<FirstMotherhoodInfoPO> list = firstMotherhoodInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过产检id获取第一次产检的孕妇信息
	 * @param firstPreantalExaId
	 * @return
	 * @author yanwk
	 */
	public FirstMotherhoodInfoPO getFirstMotherhoodByPreantalExaId(String firstPreantalExaId) {
		return firstMotherhoodInfoDao.getFirstMotherhoodByPreantalExaId(firstPreantalExaId);
	}


}