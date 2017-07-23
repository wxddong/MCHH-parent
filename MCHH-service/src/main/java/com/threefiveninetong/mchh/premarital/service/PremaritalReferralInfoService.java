/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalReferralInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.premarital.po.PremaritalReferralInfoPO;
import com.threefiveninetong.mchh.premarital.dao.PremaritalReferralInfoDao;

/**
 * @ClassName: PremaritalReferralInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@Service
public class PremaritalReferralInfoService {

	private static final Logger log =Logger.getLogger(PremaritalReferralInfoService.class);
	
	@Resource
	private  PremaritalReferralInfoDao  premaritalReferralInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PremaritalReferralInfo 
	 */
	public PremaritalReferralInfoPO find(Serializable id){
		return premaritalReferralInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PremaritalReferralInfoPO> 
	 */
	public List<PremaritalReferralInfoPO> findAll(){
		return premaritalReferralInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PremaritalReferralInfoPO po) throws Exception{
		
			if( po != null )
				 premaritalReferralInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PremaritalReferralInfoPO po) throws Exception{

			if( po != null )
				 premaritalReferralInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 premaritalReferralInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		premaritalReferralInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PremaritalReferralInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PremaritalReferralInfoPO> list = premaritalReferralInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据婚检id获取转诊信息
	 * @param premaritalId
	 * @return
	 */
	public PremaritalReferralInfoPO getPreReferralByPremaritalId(String premaritalId) {
		// TODO Auto-generated method stub
		return premaritalReferralInfoDao.getPreReferralByPremaritalId(premaritalId);
	}

	/**
	 * 修改
	 * @param premaritalReferralInfoPO
	 * @throws Exception
	 */
	public void edit(PremaritalReferralInfoPO premaritalReferralInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if (premaritalReferralInfoPO != null) {
			premaritalReferralInfoDao.edit(premaritalReferralInfoPO);
		}
	}


}