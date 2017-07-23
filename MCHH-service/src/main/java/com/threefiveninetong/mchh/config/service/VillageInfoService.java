/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: VillageInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.dao.VillageInfoDao;

/**
 * @ClassName: VillageInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Service
public class VillageInfoService {

	private static final Logger log =Logger.getLogger(VillageInfoService.class);
	
	@Resource
	private  VillageInfoDao  villageInfoDao;
	

	/**
	 * wangxd 2016.8.24
	 * @param conds
	 * @param page
	 */
	@Transactional
	public void listForPage(Map<String, Object> conds, Page<VillageInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<VillageInfoPO> list = villageInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 查找单个 
	 * @param id 
	 * @return VillageInfo 
	 */
	@Transactional
	public VillageInfoPO find(Serializable id){
		return villageInfoDao.find(id);	
	}
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return VillageInfo 
	 */
	@Transactional
	public VillageInfoPO findByName(String name){
		return villageInfoDao.findByName(name);	
	}

	
	/**
	 * 查找所有 
	 * @return List<VillageInfoPO> 
	 */
	@Transactional
	public List<VillageInfoPO> findAll(){
		return villageInfoDao.findAll();	
	}
	
	/**
	 * 查找所有 
	 * @return List<VillageInfoPO> 
	 */
	@Transactional
	public List<VillageInfoPO> findAllByVillage(String towId){
		return villageInfoDao.findAllByVillage(towId);	
	}
	
	

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(VillageInfoPO po) throws Exception{
		
			if( po != null )
				 villageInfoDao.create(po);
	}
	
	/* 添加
	 * wangxd 2016.8.26
	 */
	@Transactional
	public void addVillageInfo(VillageInfoPO po) {
		
		if( po != null ){
			//设置uuid 、删除状态、 创建时间、 最后修改时间 、全拼  、首字母
			po.setId(IdUtil.uuid());
			po.setCreatTime(new Date());
			po.setUpdateTime(new Date());
			po.setDeleteSign("1");
			villageInfoDao.addVillageInfo(po);
		}
	}
	
	/**
	 * 修改
	 * wangxd 2016.8.26
	 * @param villageInfoPO
	 */
	@Transactional
	public void updateVillageInfo(VillageInfoPO po) {
		if( po != null )
			po.setUpdateTime(new Date());
		villageInfoDao.updateTownshipInfo(po);
		
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(VillageInfoPO po) throws Exception{

			if( po != null )
				 villageInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 villageInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		villageInfoDao.deletes(id);
	}
	
	

	@Transactional
	public List<VillageInfoPO> getTownshipByCountyId(String townshipId) {
		return villageInfoDao.getTownshipByCountyId(townshipId);
	}

	/**
	 * 删除
	 * wangxd 2016.8.26
	 */
	@Transactional
	public void delVillageInfo(String[] villageIds) {
		
		villageInfoDao.dedelVillageInfo(villageIds);
	}

	public List<String> findAllSortNum() {
		return villageInfoDao.findAllSortNum();
	}

	public List<VillageInfoPO> findAlls(String parentId) {
		return villageInfoDao.findAlls(parentId);
	}

	public VillageInfoPO getByName(String name) {
		return villageInfoDao.getByName(name);
	}



	


}