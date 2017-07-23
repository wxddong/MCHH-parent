/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrMessageInfoService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appMember.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:43 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appMember.dao.AppMbrMessageInfoDao;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

/**
 * @ClassName: AppMbrMessageInfoService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:43 
 */
@Service
public class AppMbrMessageInfoService {

	private static final Logger log =Logger.getLogger(AppMbrMessageInfoService.class);
	
	@Resource
	private  AppMbrMessageInfoDao  appMbrMessageInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMbrMessageInfo 
	 */
	public AppMbrMessageInfoPO find(Serializable id){
		return appMbrMessageInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppMbrMessageInfoPO> 
	 */
	public List<AppMbrMessageInfoPO> findAll(){
		return appMbrMessageInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMbrMessageInfoPO po) throws Exception{
		
			if( po != null )
				 appMbrMessageInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppMbrMessageInfoPO po) throws Exception{

			if( po != null )
				 appMbrMessageInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appMbrMessageInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appMbrMessageInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppMbrMessageInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMbrMessageInfoPO> list = appMbrMessageInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 查询某会员最新的一条消息
	 * @param mbrId
	 * @param type
	 * @param classification
	 * @return
	 */
	public AppMbrMessageInfoPO findAppMbrMessageListByCondition(String hospitalId,String mbrId,String type,String classification) {
		if (!StringUtil.isNullOrBlank(hospitalId) && !StringUtil.isNullOrBlank(mbrId)) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("mbrId", mbrId);
			map.put("hospitalId", hospitalId);
			if (!StringUtil.isNullOrBlank(type)) {
				map.put("type", type);
			}
			if (!StringUtil.isNullOrBlank(classification)) {
				List<String> classificationList = new ArrayList<String>();
				classificationList.add(classification);
				map.put("classificationList", classificationList);
			}
			map.put("num", 1);
			List<AppMbrMessageInfoPO> list = this.appMbrMessageInfoDao.findAppMbrMessageListByCondition(map);
			return !CollectionUtil.isNullOrEmpty(list)?list.get(0):null;
		}
		return null;
	}
}