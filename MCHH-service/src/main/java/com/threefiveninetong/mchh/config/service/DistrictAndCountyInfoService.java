/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DistrictAndCountyInfoService.java 
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

import com.threefiveninetong.mchh.config.dao.DistrictAndCountyInfoDao;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: DistrictAndCountyInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
@Service
public class DistrictAndCountyInfoService {

	private static final Logger log =Logger.getLogger(DistrictAndCountyInfoService.class);
	
	@Resource
	private  DistrictAndCountyInfoDao  districtAndCountyInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return DistrictAndCountyInfo 
	 */
	@Transactional
	public DistrictAndCountyInfoPO find(Serializable id){
		return districtAndCountyInfoDao.find(id);	
	}
	
	
	
	/**
	 * 查找单个 
	 * @param name 
	 * @return DistrictAndCountyInfo 
	 */
	@Transactional
	public DistrictAndCountyInfoPO findByName(String name){
		return districtAndCountyInfoDao.findByName(name);	
	}
	/**
	 * 查找所有 
	 * @return List<DistrictAndCountyInfoPO> 
	 */
	@Transactional
	public List<DistrictAndCountyInfoPO> findAll(){
		return districtAndCountyInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(DistrictAndCountyInfoPO po) throws Exception{
		
			if( po != null )
				 districtAndCountyInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(DistrictAndCountyInfoPO po) throws Exception{

			if( po != null )
				po.setUpdateTime(new Date());
				 districtAndCountyInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 districtAndCountyInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		districtAndCountyInfoDao.deletes(id);
	}
	
	@Transactional
	public void listForPage(Map<String, Object> conds, Page<DistrictAndCountyInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<DistrictAndCountyInfoPO> list = districtAndCountyInfoDao.listForPage(conds);
		page.setList(list);
	}

	@Transactional
	public List<DistrictAndCountyInfoPO> getDistrictandcountyByCityId(String cityId) {
		return districtAndCountyInfoDao.getDistrictandcountyByCityId(cityId);
	}

	/**
	 * 添加
	 * 2016.8.25 wangxd
	 * @param districtAndCountyInfoPO
	 */
	@Transactional
	public void addCounty(DistrictAndCountyInfoPO po) {
		if( po != null ){
			//设置uuid 、删除状态、 创建时间、 最后修改时间 、全拼  、首字母
			po.setId(IdUtil.uuid());
			po.setCreatTime(new Date());
			po.setUpdateTime(new Date());
			po.setDeleteSign("1");
			districtAndCountyInfoDao.addCounty(po);
		}
	}

	/**
	 * 查看县庄是否含有乡镇
	 * wangxd 2016.8.26
	 * @param split
	 * @return
	 */
	@Transactional
	public int getTownCountByCountyIds(String[] countyIds) {
		 for (String countyId : countyIds) {
	            int count = districtAndCountyInfoDao.getTownCountByCountyId(countyId);
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
	public void delDistrictAndCountyInfo(String[] countyIds) {
		districtAndCountyInfoDao.delDistrictAndCountyInfo(countyIds);
	}

	public List<String> findAllSortNum() {
		return districtAndCountyInfoDao.findAllSortNum();
	}



	public DistrictAndCountyInfoPO getByName(String name) {
		return districtAndCountyInfoDao.getByName(name);
	}


}