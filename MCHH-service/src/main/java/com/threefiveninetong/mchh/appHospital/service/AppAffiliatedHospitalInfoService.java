/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppAffiliatedHospitalInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appHospital.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.appHospital.dao.AppAffiliatedHospitalInfoDao;
import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppAffiliatedHospitalInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppAffiliatedHospitalInfoService {

	private static final Logger log =Logger.getLogger(AppAffiliatedHospitalInfoService.class);
	
	@Resource
	private  AppAffiliatedHospitalInfoDao  appAffiliatedHospitalInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppAffiliatedHospitalInfo 
	 */
	public AppAffiliatedHospitalInfoPO find(Serializable id){
		return appAffiliatedHospitalInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppAffiliatedHospitalInfoPO> 
	 */
	public List<AppAffiliatedHospitalInfoPO> findAll(){
		return appAffiliatedHospitalInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppAffiliatedHospitalInfoPO po) throws Exception{
		
			if( po != null )
				 appAffiliatedHospitalInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppAffiliatedHospitalInfoPO po) throws Exception{

			if( po != null )
				 appAffiliatedHospitalInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appAffiliatedHospitalInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appAffiliatedHospitalInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppAffiliatedHospitalInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppAffiliatedHospitalInfoPO> list = appAffiliatedHospitalInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过hopitalId和mbrId查询会员关联医院表信息
	 * @param map
	 * @return
	 */
	public AppAffiliatedHospitalInfoPO findAppAffiliatedHospitalInfoByHIdAndMbrId(String hospitalId,String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hospitalId", hospitalId);
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppAffiliatedHospitalInfoPO> list = this.appAffiliatedHospitalInfoDao.findAppAffiliatedHospitalListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
	
	/**
	 * 通过mbrId查询会员关联医院表最近一条信息
	 * @param map
	 * @return
	 */
	public AppAffiliatedHospitalInfoPO findAppAffiliatedHospitalInfoByMbrId(String mbrId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppAffiliatedHospitalInfoPO> list = this.appAffiliatedHospitalInfoDao.findAppAffiliatedHospitalListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}

	/**
	 * 
	 * @param split
	 * @return
	 */
	@Transactional
	public int getAffiliatedHospitalBymemberIds(String[] memberIds) {
		for (String memberId : memberIds) {
			int count = appAffiliatedHospitalInfoDao.getAffiliatedHospitalBymemberId(memberId);
			if (count != 0)
                return count;
		}
		return 0;
	}


}