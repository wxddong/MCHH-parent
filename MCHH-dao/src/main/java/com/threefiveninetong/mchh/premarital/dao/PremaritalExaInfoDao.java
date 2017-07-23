/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.reportForm.po.MaternalHealthcareConditionPO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalCheckPO;

/**
 * @ClassName: PremaritalExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
public interface PremaritalExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PremaritalExaInfo 
	 */
	public PremaritalExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PremaritalExaInfoPO> 
	 */
	public List<PremaritalExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PremaritalExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PremaritalExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PremaritalExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 查询婚检页面客户基本信息
	 * @param conds
	 * @return
	 */
	public List<PremaritalExaInfoPO> findById(Map<String, Object> conds);

	/**
	 * 根据档案id获取婚检信息
	 * @param archivesId
	 * @return
	 */
	public PremaritalExaInfoPO getPremaritalByArchivesId(String archivesId);

	/**
	 * 根据档案id获取男性婚检信息
	 * @param archivesId
	 * @return
	 */
	public PremaritalExaInfoPO findPremaritalByArchivesId(String archivesId);

	/**
	 * 根据档案id获取女性婚检信息
	 * @param archivesId
	 * @return
	 */
	public PremaritalExaInfoPO findWomanPremaritalByArchivesId(String archId);

	/**
	 * 删除女性
	 * @param premaritalExaInfoPO
	 */
	public void delWoman(PremaritalExaInfoPO premaritalExaInfoPO);

	/**
	 * 删除男性
	 * @param premaritalExaInfo
	 */
	public void delMan(PremaritalExaInfoPO premaritalExaInfo);

	/**
	 * 综合管理
	 * @param conds
	 * @return
	 */
	public List<PremaritalExaInfoPO> getAll(Map<String, Object> conds);

	/**
	 * 
	 * @param premaritalId
	 * @return
	 */
	public PremaritalExaInfoPO getById(String premaritalId);

	public List<PremaritalExaInfoPO> allPremaritalExa(Map<String, Object> conds);

	public int findAllAsk(Map<String, Object> conds);

	public Integer disNum(Map<String, Object> conds);

	public int adviceNum(Map<String, Object> conds);

	public List<PremaritalCheckPO> listForPage2(Map<String, Object> conds);

	public String getWomanAddressByArchivesId(String archivesId);

	public String getManAddressByArchivesId(String archivesId);

	public List<MaternalHealthcareConditionPO> listForPage3(Map<String, Object> conds);

}