/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
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


import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.HighRiskInfoDao;

/**
 * @ClassName: HighRiskInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@Service
public class HighRiskInfoService {

	private static final Logger log =Logger.getLogger(HighRiskInfoService.class);
	
	@Resource
	private  HighRiskInfoDao  highRiskInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return HighRiskInfo 
	 */
	public HighRiskInfoPO find(Serializable id){
		return highRiskInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<HighRiskInfoPO> 
	 */
	public List<HighRiskInfoPO> findAll(){
		return highRiskInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(HighRiskInfoPO po) throws Exception{
		
			if( po != null )
				 highRiskInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(HighRiskInfoPO po) throws Exception{

			if( po != null )
				 highRiskInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 highRiskInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		highRiskInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<HighRiskInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<HighRiskInfoPO> list = highRiskInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据产检id获取高危专案管理表
	 * @param id
	 * @return
	 */
	public HighRiskInfoPO getHighRiskByPrenatalId(String id) {
		return highRiskInfoDao.getHighRiskByprenatalExaId(id);
	}

}