/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: TownshipInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.config.dao.TownshipInfoDao;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: TownshipInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Service
public class TownshipInfoService {

	private static final Logger log =Logger.getLogger(TownshipInfoService.class);
	
	@Resource
	private  TownshipInfoDao  townshipInfoDao;
	
	/**
	 * wangxd 2016.8.24
	 * @param conds
	 * @param page
	 */
	@Transactional
	public void listForPage(Map<String, Object> conds, Page<TownshipInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<TownshipInfoPO> list = townshipInfoDao.listForPage(conds);
		page.setList(list);
	}
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return TownshipInfo 
	 */
	@Transactional
	public TownshipInfoPO find(Serializable id){
		return townshipInfoDao.find(id);	
	}
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return TownshipInfo 
	 */
	@Transactional
	public TownshipInfoPO findByName(String name){
		return townshipInfoDao.findByName(name);	
	}
	
	
	
	

	/**
	 * 查找所有 
	 * @return List<TownshipInfoPO> 
	 */
	@Transactional
	public List<TownshipInfoPO> findAll(){
		return townshipInfoDao.findAll();	
	}
	
	/**
	 * 查找所有乡通过区县id 
	 * @return List<TownshipInfoPO> 
	 */
	@Transactional
	public List<TownshipInfoPO> findAllByCountyId(String countyId ){
		return townshipInfoDao.findAllByCountyId(countyId);	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(TownshipInfoPO po) throws Exception{
		
			if( po != null )
				 townshipInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(TownshipInfoPO po) throws Exception{

			if( po != null )
				 townshipInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 townshipInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		townshipInfoDao.deletes(id);
	}
	
	
	
	@Transactional
	public List<TownshipInfoPO> getTownshipByCountyId(String countyId) {
		return townshipInfoDao.getTownshipByCountyId(countyId);
	}

	/**
	 * 添加
	 * wangxd 2016.8.26
	 * @param po
	 */
	@Transactional
	public void addTownshipInfo(TownshipInfoPO po) {
		if( po != null ){
			//设置uuid 、删除状态、 创建时间、 最后修改时间 、全拼  、首字母
			po.setId(IdUtil.uuid());
			po.setCreatTime(new Date());
			po.setUpdateTime(new Date());
			po.setDeleteSign("1");
			townshipInfoDao.addTownshipInfo(po);
		}
		
	}


	/**
	 * TOWNSHIP_INFO 修改
	 * wangxd 2016.8.26
	 * @param townshipInfoPO
	 */
	@Transactional
	public void updateTownshipInfo(TownshipInfoPO po) {
		if( po != null )
			po.setUpdateTime(new Date());
		townshipInfoDao.updateTownshipInfo(po);

		
	}

	/**
	 * 查看村庄是否含有村
	 * wangxd 2016.8.26
	 * @param split
	 * @return
	 */
	@Transactional
	public int getVillageCountByTownIds(String[] townIds) {
		 for (String townId : townIds) {
	            int count = townshipInfoDao.getVillageCountByTownId(townId);
	            if (count != 0)
	                return count;
	        }
	      return 0;
	}


	/**
	 * 2016.8.26
	 * @param townIds
	 */
	@Transactional
	public void delTownshipInfo(String[] townIds) {
		townshipInfoDao.delTownshipInfo(townIds);
	}


	public List<String> findAllSortNum() {
		return townshipInfoDao.findAllSortNum();
	}


	public List<TownshipInfoPO> findAlls(String parentId) {
		return townshipInfoDao.findAlls(parentId);
	}


	public TownshipInfoPO getByName(String name) {
		return townshipInfoDao.getByName(name);
	}




}