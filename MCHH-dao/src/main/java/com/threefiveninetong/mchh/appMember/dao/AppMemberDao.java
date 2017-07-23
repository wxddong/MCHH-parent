/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMemberDao.java 
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appMember.dao 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:06 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.threefiveninetong.mchh.appMember.po.AppMemberPO;

/**
 * @ClassName: AppMemberDao 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:06 
 */
public interface AppMemberDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppMember 
	 */
	public AppMemberPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<AppMemberPO> 
	 */
	public List<AppMemberPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppMemberPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(AppMemberPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<AppMemberPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 通过用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public AppMemberPO findMbrInfoByUserName(@Param(value = "userName") String userName);
	
	/**
	 * 更新最后登录时间
	 * @param mbrId
	 */
	public void updateLoginTime(@Param(value = "mbrId") String mbrId);

	/**
	 * 更新用户所处阶段
	 * @param map
	 */
	public void updateCurrentStage(Map<String,Object> map);

	/**
	 * 修改会员基本信息
	 * @param mbrInfo
	 */
	public void updateMember(AppMemberPO mbrInfo);

	/**
	 * 修改会员状态
	 * @param appMember
	 */
	public void updateStatus(AppMemberPO appMember);

	/**
	 * 会员信息列表
	 * @param conds
	 * @return
	 */
	public List<AppMemberPO> getAll(Map<String, Object> conds);

	/**
	 * 停用前验证
	 * @param memberId
	 * @return
	 */
	public int getAppMemberBymemberId(String memberId);

	/**
	 * 停用
	 * @param memberIds
	 */
	public void changeStatus(Serializable[] memberIds);

}