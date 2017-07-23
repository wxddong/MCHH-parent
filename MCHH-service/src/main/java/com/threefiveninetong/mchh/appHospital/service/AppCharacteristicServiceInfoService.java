/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppCharacteristicServiceInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appHospital.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appHospital.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.appHospital.dao.AppCharacteristicServiceInfoDao;
import com.threefiveninetong.mchh.appHospital.po.AppCharacteristicServiceInfoPO;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppCharacteristicServiceInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppCharacteristicServiceInfoService {

	private static final Logger log =Logger.getLogger(AppCharacteristicServiceInfoService.class);
	
	@Resource
	private  AppCharacteristicServiceInfoDao  appCharacteristicServiceInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppCharacteristicServiceInfo 
	 */
	public AppCharacteristicServiceInfoPO find(Serializable id){
		return appCharacteristicServiceInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppCharacteristicServiceInfoPO> 
	 */
	public List<AppCharacteristicServiceInfoPO> findAll(){
		return appCharacteristicServiceInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppCharacteristicServiceInfoPO po) throws Exception{
		
			if( po != null )
				 appCharacteristicServiceInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppCharacteristicServiceInfoPO po) throws Exception{

			if( po != null )
				 appCharacteristicServiceInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appCharacteristicServiceInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appCharacteristicServiceInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppCharacteristicServiceInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppCharacteristicServiceInfoPO> list = appCharacteristicServiceInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过hospitalId查询医院特色服务项目信息
	 * @param map
	 * @return
	 */
	public List<AppCharacteristicServiceInfoPO> findAppCharacteristicServiceListByHospitalId(String hospitalId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hospitalId", hospitalId);
		map.put("status", EffectStatus.有效.getValue());
		return this.appCharacteristicServiceInfoDao.findAppCharacteristicServiceListByCondition(map);
	}

	/**
	 * 特色服务列表
	 * @param reqs
	 * @param page
	 */
	public void getAll(Map<String, Object> conds, Page<AppCharacteristicServiceInfoPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppCharacteristicServiceInfoPO> list = appCharacteristicServiceInfoDao.getAll(conds);
		page.setList(list);
	}

	/**
	 * 停用前验证
	 * @param split
	 * @return
	 */
	@Transactional
	public int getAppServiceByserviceIds(String[] serviceIds) {
		
		for (String serviceId : serviceIds) {
			int count = appCharacteristicServiceInfoDao.getAppServiceByserviceId(serviceId);
			if (count != 0)
                return count;
		}
		
		return 0;
	}

	/**
	 * 删除
	 * @param split
	 */
	@Transactional
	public void changeStatus(String[] serviceIds) {
		// TODO Auto-generated method stub
		appCharacteristicServiceInfoDao.changeStatus(serviceIds);
	}

}