/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: CityInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
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

import com.threefiveninetong.mchh.config.dao.CityInfoDao;
import com.threefiveninetong.mchh.config.dao.ProvinceInfoDao;
import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: CityInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
@Service
public class CityInfoService {

	private static final Logger log =Logger.getLogger(CityInfoService.class);
	
	@Resource
	private  CityInfoDao  cityInfoDao;
	private  ProvinceInfoDao  provinceInfoDao;
	
	
	/**
	 * 分页查询
	 * @param conds
	 * @param page
	 */
	@Transactional
	public void listForPage(Map<String, Object> conds, Page<CityInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<CityInfoPO> list = cityInfoDao.listForPage(conds);
		page.setList(list);
	}
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return CityInfo 
	 */
	@Transactional
	public CityInfoPO find(Serializable id){
		return cityInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<CityInfoPO> 
	 */
	@Transactional
	public List<CityInfoPO> findAll(){
		return cityInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * wangxd 2016.8.24
	 * @param po 
	 */
	@Transactional
	public void addCityInfo(CityInfoPO po) throws Exception{
		
			if( po != null ){
				//设置uuid 、删除状态、 创建时间、 最后修改时间 、全拼  、首字母
				po.setId(IdUtil.uuid());
				po.setCreatTime(new Date());
				po.setUpdateTime(new Date());
				po.setDeleteSign("1");
				cityInfoDao.addCityInfo(po);
			}
				
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(CityInfoPO po) throws Exception{

			if( po != null ){
				//设置修改时间 全拼 首字母
				po.setUpdateTime(new Date());
				cityInfoDao.update(po);
			}
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 cityInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		cityInfoDao.deletes(id);
	}

	/**
	 * 查询省下的所有市区
	 */
	@Transactional
	public List<CityInfoPO> getCityByProvinceId(String provinceId) {
		
		return cityInfoDao.getCityByProvinceId(provinceId);
	}


	/**
	 * wangxd 2016.8.26
	 * @param split
	 * @return
	 */
	@Transactional
	public int getCountyCountBycityIds(String[] cityIds) {
		 for (String cityId : cityIds) {
	            int count = cityInfoDao.getCountyCountBycityId(cityId);
	            if (count != 0)
	                return count;
	        }
	      return 0;
	}


	/**
	 * wangxd 2016.8.26
	 * @param split
	 */
	@Transactional
	public void delCityInfo(String[] cityIds) {
		cityInfoDao.delCityInfo(cityIds);
	}


	public List<String> findAllSortNum() {
		return cityInfoDao.findAllSortNum();
	}


	public CityInfoPO getByName(String name) {
		return cityInfoDao.getByName(name);
	}

}