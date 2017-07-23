/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PhysiqueExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
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


import com.threefiveninetong.mchh.premarital.po.PhysiqueExaInfoPO;
import com.threefiveninetong.mchh.premarital.dao.PhysiqueExaInfoDao;

/**
 * @ClassName: PhysiqueExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
@Service
public class PhysiqueExaInfoService {

	private static final Logger log =Logger.getLogger(PhysiqueExaInfoService.class);
	
	@Resource
	private  PhysiqueExaInfoDao  physiqueExaInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PhysiqueExaInfo 
	 */
	public PhysiqueExaInfoPO find(Serializable id){
		return physiqueExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PhysiqueExaInfoPO> 
	 */
	public List<PhysiqueExaInfoPO> findAll(){
		return physiqueExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PhysiqueExaInfoPO po) throws Exception{
		
			if( po != null )
				 physiqueExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PhysiqueExaInfoPO po) throws Exception{

			if( po != null )
				 physiqueExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 physiqueExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		physiqueExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PhysiqueExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PhysiqueExaInfoPO> list = physiqueExaInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据婚检id获取体格检查信息
	 * @param premaritalId
	 * @return
	 */
	public PhysiqueExaInfoPO getPhysiqueByPremaritalId(String premaritalId) {
		// TODO Auto-generated method stub
		return physiqueExaInfoDao.getPhysiqueByPremaritalId(premaritalId);
	}

	/**
	 * 修改
	 * @param physiqueExaInfoPO
	 * @throws Exception
	 */
	public void edit(PhysiqueExaInfoPO physiqueExaInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if (physiqueExaInfoPO != null) {
			physiqueExaInfoDao.edit(physiqueExaInfoPO);
		}
	}


}