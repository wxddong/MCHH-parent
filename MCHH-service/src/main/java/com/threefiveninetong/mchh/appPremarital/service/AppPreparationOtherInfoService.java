/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPreparationOtherInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPremarital.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPremarital.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPremarital.dao.AppPreparationOtherInfoDao;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationOtherInfoPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPreparationOtherInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPreparationOtherInfoService {

	private static final Logger log =Logger.getLogger(AppPreparationOtherInfoService.class);
	
	@Resource
	private  AppPreparationOtherInfoDao  appPreparationOtherInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPreparationOtherInfo 
	 */
	public AppPreparationOtherInfoPO find(Serializable id){
		return appPreparationOtherInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPreparationOtherInfoPO> 
	 */
	public List<AppPreparationOtherInfoPO> findAll(){
		return appPreparationOtherInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPreparationOtherInfoPO po) throws Exception{
		
			if( po != null )
				 appPreparationOtherInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPreparationOtherInfoPO po) throws Exception{

			if( po != null )
				 appPreparationOtherInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPreparationOtherInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPreparationOtherInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPreparationOtherInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPreparationOtherInfoPO> list = appPreparationOtherInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过MbrId查询备孕期一条其他信息
	 * @param mbrId
	 * @return
	 */
	public AppPreparationOtherInfoPO findAppPreparationOtherInfoByMbrId(String mbrId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("num", 1);
		List<AppPreparationOtherInfoPO> list = this.appPreparationOtherInfoDao.findAppPreparationOtherListByCondition(map);
		if (!CollectionUtil.isNullOrEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}