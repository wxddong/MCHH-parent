/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingBabyDentitionRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appPostpartum.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appPostpartum.dao.AppParentingBabyDentitionRecordDao;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyDentitionRecordPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppParentingBabyDentitionRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
@Service
public class AppParentingBabyDentitionRecordService {

	private static final Logger log =Logger.getLogger(AppParentingBabyDentitionRecordService.class);
	
	@Resource
	private  AppParentingBabyDentitionRecordDao  appParentingBabyDentitionRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppParentingBabyDentitionRecord 
	 */
	public AppParentingBabyDentitionRecordPO find(Serializable id){
		return appParentingBabyDentitionRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppParentingBabyDentitionRecordPO> 
	 */
	public List<AppParentingBabyDentitionRecordPO> findAll(){
		return appParentingBabyDentitionRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppParentingBabyDentitionRecordPO po) throws Exception{
		
			if( po != null )
				 appParentingBabyDentitionRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppParentingBabyDentitionRecordPO po) throws Exception{

			if( po != null )
				 appParentingBabyDentitionRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appParentingBabyDentitionRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appParentingBabyDentitionRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppParentingBabyDentitionRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppParentingBabyDentitionRecordPO> list = appParentingBabyDentitionRecordDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过ParId和位置查询宝宝牙齿生长信息
	 * @param map
	 * @return
	 */
	public AppParentingBabyDentitionRecordPO findAppParentingBabyDentitionRecordInfoByParIdAndPos(String parId,String position) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		List<String> positionList = new ArrayList<String>();
		positionList.add(position);
		map.put("positionList", positionList);
		map.put("num", 1);
		List<AppParentingBabyDentitionRecordPO> list = this.appParentingBabyDentitionRecordDao.findAppParentingBabyDentitionRecordListByCondition(map);
		return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
	}
	
	/**
	 * 通过ParId查询宝宝牙齿生长信息
	 * @param map
	 * @return
	 */
	public List<AppParentingBabyDentitionRecordPO> findAppParentingBabyDentitionRecordListByParId(String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("parId", parId);
		return this.appParentingBabyDentitionRecordDao.findAppParentingBabyDentitionRecordListByCondition(map);
	}
}