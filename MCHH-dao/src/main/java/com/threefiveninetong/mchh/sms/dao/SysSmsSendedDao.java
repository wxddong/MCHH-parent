/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SysSmsSendedDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.sms.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-09-18 15:36:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.sms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.threefiveninetong.mchh.sms.po.SysSmsSendedPO;

/**
 * @ClassName: SysSmsSendedDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-09-18 15:36:09 
 */
public interface SysSmsSendedDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return SysSmsSended 
	 */
	public SysSmsSendedPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SysSmsSendedPO> 
	 */
	public List<SysSmsSendedPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SysSmsSendedPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SysSmsSendedPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<SysSmsSendedPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 根据手机号和短信类型查询 
	 * @param telephone 手机号
	 * @param smsType 短信类型
	 * @return SysSmsSended 
	 */
	public List<SysSmsSendedPO> findByPhoneAndType(@Param("telephone") String telephone,@Param("smsType") String smsType);
	
	/**
	 * 根据接受手机号删除 
	 * @param id 
	 */
	public void deleteByTel(String telephone);
	

}