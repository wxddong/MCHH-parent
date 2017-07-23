/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrFeedbackService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appMember.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:43 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.expression.OperatorOverloader;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appMember.dao.AppMbrFeedbackDao;
import com.threefiveninetong.mchh.appMember.po.AppMbrFeedbackPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppMbrFeedbackService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:43 
 */
@Service
public class AppMbrFeedbackService {

	private static final Logger log =Logger.getLogger(AppMbrFeedbackService.class);
	
	@Resource
	private  AppMbrFeedbackDao  appMbrFeedbackDao;
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMbrFeedback 
	 */
	public AppMbrFeedbackPO find(Serializable id){
		return appMbrFeedbackDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppMbrFeedbackPO> 
	 */
	public List<AppMbrFeedbackPO> findAll(){
		return appMbrFeedbackDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMbrFeedbackPO po) throws Exception{
		
			if( po != null )
				 appMbrFeedbackDao.create(po);
			
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppMbrFeedbackPO po) throws Exception{

			if( po != null )
				 appMbrFeedbackDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appMbrFeedbackDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appMbrFeedbackDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppMbrFeedbackPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMbrFeedbackPO> list = appMbrFeedbackDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 意见反馈列表
	 * @param reqs
	 * @param page
	 */
	public void getAll(Map<String, Object> conds, Page<AppMbrFeedbackPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMbrFeedbackPO> list = appMbrFeedbackDao.getAll(conds);
		
		page.setList(list);
	}

	/**
	 * 修改意见反馈状态
	 * @param mbrId
	 */
	public void updateStatus(String mbrId) throws Exception {
		// TODO Auto-generated method stub
		if (mbrId != null) {
			appMbrFeedbackDao.updateStatus(mbrId);
		}
	}

	/**
	 * 根据id查询意见反馈信息
	 * @param feedId
	 * @return
	 */
	public AppMbrFeedbackPO findById(String feedId) {
		// TODO Auto-generated method stub
		return appMbrFeedbackDao.findById(feedId);
	}

	/**
	 * 处理意见反馈
	 * @param feedBack
	 */
	public void updateFeedBack(AppMbrFeedbackPO feedBack) throws Exception {
		if (feedBack != null) {
			appMbrFeedbackDao.updateFeedBack(feedBack);
		}
		
	}

}