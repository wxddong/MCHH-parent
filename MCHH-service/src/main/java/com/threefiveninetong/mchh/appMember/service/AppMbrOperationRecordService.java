/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrOperationRecordService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appMember.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.appMember.dao.AppMbrOperationRecordDao;
import com.threefiveninetong.mchh.appMember.po.AppMbrOperationRecordPO;
import com.threefiveninetong.mchh.util.DictionaryForApi.MbrOptType;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

/**
 * @ClassName: AppMbrOperationRecordService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppMbrOperationRecordService {

	private static final Logger log =Logger.getLogger(AppMbrOperationRecordService.class);
	
	@Resource
	private  AppMbrOperationRecordDao  appMbrOperationRecordDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMbrOperationRecord 
	 */
	public AppMbrOperationRecordPO find(Serializable id){
		return appMbrOperationRecordDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppMbrOperationRecordPO> 
	 */
	public List<AppMbrOperationRecordPO> findAll(){
		return appMbrOperationRecordDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMbrOperationRecordPO po) throws Exception{
		
			if( po != null )
				 appMbrOperationRecordDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppMbrOperationRecordPO po) throws Exception{

			if( po != null )
				 appMbrOperationRecordDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appMbrOperationRecordDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appMbrOperationRecordDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppMbrOperationRecordPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMbrOperationRecordPO> list = appMbrOperationRecordDao.listForPage(conds);
		page.setList(list);
	}

	@Transactional
	public void createMbrOptRecByType(String mbrId,String mbrName,String remark,MbrOptType type) {
		AppMbrOperationRecordPO optRecInfo = new AppMbrOperationRecordPO();
		optRecInfo.setId(IdUtil.uuid());
		optRecInfo.setMbrId(mbrId);
		optRecInfo.setOrnType(type.getValue());
		optRecInfo.setOrnTime(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append(mbrName+type.name());
		if(!StringUtil.isNullOrBlank(remark))
			sb.append(":"+remark);
		appMbrOperationRecordDao.create(optRecInfo);
	}
	/**
	 * 操作日志列表
	 * @param reqs
	 * @param page
	 */
	public void getAll(Map<String, Object> conds, Page<AppMbrOperationRecordPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMbrOperationRecordPO> list = appMbrOperationRecordDao.getAll(conds);
		page.setList(list);
	}
}