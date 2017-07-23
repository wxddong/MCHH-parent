/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMemberService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appMember.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:43 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.appMember.dao.AppMemberDao;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

/**
 * @ClassName: AppMemberService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:43 
 */
@Service
public class AppMemberService {

	private static final Logger log =Logger.getLogger(AppMemberService.class);
	
	@Resource
	private  AppMemberDao  appMemberDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMember 
	 */
	public AppMemberPO find(Serializable id){
		return appMemberDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppMemberPO> 
	 */
	public List<AppMemberPO> findAll(){
		return appMemberDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMemberPO po) throws Exception{
		
			if( po != null )
				 appMemberDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppMemberPO po) throws Exception{

			if( po != null )
				 appMemberDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appMemberDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appMemberDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppMemberPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMemberPO> list = appMemberDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public AppMemberPO findMbrInfoByUserName(String userName) {
		return this.appMemberDao.findMbrInfoByUserName(userName);
	}
	
	/**
	 * 更新最后登录时间
	 * @param mbrId
	 */
	public void updateLoginTime(String mbrId) {
		this.appMemberDao.updateLoginTime(mbrId);
	}

	/**
	 * 更新用户所处阶段
	 * @param map
	 */
	public void updateCurrentStage(String mbrId,String currentStage,String parId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mbrId", mbrId);
		map.put("currentStage", currentStage);
		if (!StringUtil.isNullOrBlank(parId)) 
			map.put("parId", parId);
		this.appMemberDao.updateCurrentStage(map);
	}

	/**
	 * 查询会员的详细信息
	 * @param memberId
	 * @return
	 */
	public AppMemberPO searchMemberBasicInfo(String memberId) {
		return appMemberDao.find(memberId);
	}

	/**
	 * 修改会员基本信息
	 * @param mbrInfo
	 */
	public void updateMember(AppMemberPO mbrInfo) {
		// TODO Auto-generated method stub
		this.appMemberDao.updateMember(mbrInfo);
	}

	/**
	 * 修改会员状态
	 * @param appMember
	 * @throws Exception
	 */
	public void updateStatus(AppMemberPO appMember) throws Exception {
		// TODO Auto-generated method stub
		if (appMember != null) {
			appMemberDao.updateStatus(appMember);
		}
	}

	/**
	 * 会员信息列表
	 * @param reqs
	 * @param page
	 */
	public void getAll(Map<String, Object> conds, Page<AppMemberPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppMemberPO> list = appMemberDao.getAll(conds);
		page.setList(list);
	}

	/**
	 * 停用前验证
	 * @param split
	 * @return
	 */
	@Transactional
	public int getAppMemberBymemberIds(String[] memberIds) {
		for (String memberId : memberIds) {
			int count = appMemberDao.getAppMemberBymemberId(memberId);
			if (count != 0)
                return count;
		}
		return 0;
	}

	/**
	 * 批量停用
	 * @param split
	 */
	@Transactional
	public void changeStatus(String[] memberIds) {
		// TODO Auto-generated method stub
		appMemberDao.changeStatus(memberIds);
	}


}