/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMbrFeedbackDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appMember.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:07 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.appMember.po.AppMbrFeedbackPO;

/**
 * @ClassName: AppMbrFeedbackDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:07 
 */
public interface AppMbrFeedbackDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMbrFeedback 
	 */
	public AppMbrFeedbackPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppMbrFeedbackPO> 
	 */
	public List<AppMbrFeedbackPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMbrFeedbackPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppMbrFeedbackPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppMbrFeedbackPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 意见反馈列表
	 * @param conds
	 * @return
	 */
	public List<AppMbrFeedbackPO> getAll(Map<String, Object> conds);

	/**
	 * 修改意见反馈状态
	 * @param mbrId
	 */
	public void updateStatus(String mbrId);

	/**
	 * 根据id查询意见反馈信息
	 * @param feedId
	 * @return
	 */
	public AppMbrFeedbackPO findById(String feedId);

	/**
	 * 处理意见反馈
	 * @param feedBack
	 */
	public void updateFeedBack(AppMbrFeedbackPO feedBack);

}