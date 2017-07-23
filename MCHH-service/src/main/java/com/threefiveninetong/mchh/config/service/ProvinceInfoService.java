/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ProvinceInfoService.java 
 * @Prject: MCHH-service
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
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.config.dao.ProvinceInfoDao;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;


/**
 * @ClassName: ProvinceInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Service
public class ProvinceInfoService {

	private static final Logger log =Logger.getLogger(ProvinceInfoService.class);
	
	@Resource
	private  ProvinceInfoDao  provinceInfoDao;
	
	
	
	/**
	 * wangxd 2016.08.22
	 * @param conds
	 * @param page
	 */
	@Transactional(readOnly=true)
	public void listForPage(Map<String, Object> conds, Page<ProvinceInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ProvinceInfoPO> list = provinceInfoDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
	 * 添加  
	 * wangxd 2016.8.23
	 * @param provinceInfoVO
	 * @return
	 */
	@Transactional
	public ProvinceInfoPO addProvinceInfo(ProvinceInfoPO provinceInfoPO) {
		//设置uuid 、删除状态、 创建时间、 最后修改时间 、全拼  、首字母
		provinceInfoPO.setId(IdUtil.uuid());
		provinceInfoPO.setCreatTime(new Date());
		provinceInfoPO.setUpdateTime(new Date());
		provinceInfoPO.setDeleteSign("1");
		provinceInfoDao.addProvinceInfo(provinceInfoPO);
		return provinceInfoPO;
	}
	
	/**
	 * 修改  
	 * wangxd 2016.8.23
	 * @param po
	 */
	@Transactional
	public void update(ProvinceInfoPO po) throws Exception{
			if( po != null ){
				//设置修改时间
				po.setUpdateTime(new Date());
				 provinceInfoDao.update(po);
			}
				
				

	}
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ProvinceInfo 
	 */
	@Transactional
	public ProvinceInfoPO find(Serializable id){
		return provinceInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ProvinceInfoPO> 
	 */
	@Transactional
	public List<ProvinceInfoPO> findAll(){
		return provinceInfoDao.findAll();	
	}




	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 provinceInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		provinceInfoDao.deletes(id);
	}

	/**
	 * wangxd 2016.8.26
	 * @param provinceIds
	 * @return
	 */
	@Transactional
	public int getCityCountByProvinceIds(String[] provinceIds) {
		for (String provinceId : provinceIds) {
            int count = provinceInfoDao.getCityCountByProvinceId(provinceId);
            if (count != 0)
                return count;
        }
      return 0;
	}

	/**
	 * 单个删除以及批量删除
	 * wangxd 2016.8.26
	 * @param split
	 */
	@Transactional
	public void delProvinceInfo(String[] provinceIds) {
		
		provinceInfoDao.delProvinceInfo(provinceIds);
	}

	public List<String> findAllSortNum() {
		return provinceInfoDao.findAllSortNum();
	}

	public ProvinceInfoPO getByName(String name) {
		return provinceInfoDao.getByName(name);
	}


	
	
}