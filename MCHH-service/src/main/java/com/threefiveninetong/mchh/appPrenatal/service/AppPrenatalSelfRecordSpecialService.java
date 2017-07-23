/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalSelfRecordSpecialService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPrenatal.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPrenatal.dao.AppPrenatalSelfRecordSpecialDao;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordSpecialPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppPrenatalSelfRecordSpecialService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppPrenatalSelfRecordSpecialService {

	private static final Logger log =Logger.getLogger(AppPrenatalSelfRecordSpecialService.class);
	
	@Resource
	private  AppPrenatalSelfRecordSpecialDao  appPrenatalSelfRecordSpecialDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppPrenatalSelfRecordSpecial 
	 */
	public AppPrenatalSelfRecordSpecialPO find(Serializable id){
		return appPrenatalSelfRecordSpecialDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppPrenatalSelfRecordSpecialPO> 
	 */
	public List<AppPrenatalSelfRecordSpecialPO> findAll(){
		return appPrenatalSelfRecordSpecialDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppPrenatalSelfRecordSpecialPO po) throws Exception{
		
			if( po != null )
				 appPrenatalSelfRecordSpecialDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppPrenatalSelfRecordSpecialPO po) throws Exception{

			if( po != null )
				 appPrenatalSelfRecordSpecialDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appPrenatalSelfRecordSpecialDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appPrenatalSelfRecordSpecialDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppPrenatalSelfRecordSpecialPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppPrenatalSelfRecordSpecialPO> list = appPrenatalSelfRecordSpecialDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 按照关联ID查询孕产期自我特殊记录信息
	 * @param map
	 * @return
	 */
	public List<AppPrenatalSelfRecordSpecialPO> findAppPrenatalSelfRecordSpecialListByFatId(String fatId,String sign) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fatId", fatId);
		map.put("sign", sign);
		return this.appPrenatalSelfRecordSpecialDao.findAppPrenatalSelfRecordSpecialListByCondition(map);
	}
	
	/**
	 * 通过fatId修改Sign状态
	 * @param fatId
	 */
	public void updateSign(String fatId) {
		this.appPrenatalSelfRecordSpecialDao.updateSign(fatId);
	}
}