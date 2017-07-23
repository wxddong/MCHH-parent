/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ArchivesInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.archives.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;

/**
 * @ClassName: ArchivesInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
public interface ArchivesInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ArchivesInfo 
	 */
	public ArchivesInfoPO find(Serializable id);
	
	
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return ArchivesInfo 
	 * wangbj
	 */
	public ArchivesInfoPO findlian(Serializable id);
	
	

	/**
	 * 查找所有 
	 * @return List<ArchivesInfoPO> 
	 */
	public List<ArchivesInfoPO> findAll();
	/**
	 * 查找某地区所有 
	 * @return List<ArchivesInfoPO> 
	 */
	public List<ArchivesInfoPO> findAllByCountyId(Serializable id);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ArchivesInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ArchivesInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<ArchivesInfoPO> listForPage(Map<String, Object> conds);
	/**
	 * 查找所有用于病检报表 
	 * 注此方法后台用
	 */
	public List<ArchivesInfoPO> listForPageCheck(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过档案号查询档案
	 * @param archivesCode
	 * @return
	 */
	public ArchivesInfoPO getArchivesByArchivesCode(String archivesCode);

	/**
	 * 补全男性档案信息
	 * @param archivesInfoPO
	 */
	public void replenishManArchives(ArchivesInfoPO archivesInfoPO);

	/**
	 * 通过身份证号查询档案信息
	 * @param idNum
	 * @return
	 */
	public ArchivesInfoPO getArchivesByIdNum(String idNum);

	/**
	 * 男性婚检管理
	 * @param conds
	 * @return
	 */
	public List<ArchivesInfoPO> manListForPage(Map<String, Object> conds);


	/**
	 * 修改女性
	 * @param archivesInfoPO
	 */
	public void updateWoman(ArchivesInfoPO archivesInfoPO);
	
	/**
	 * 修改男性
	 * @param archivesInfoPO
	 */
	public void updateMan(ArchivesInfoPO archivesInfoPO);


	/**
	 * 孕产妇管理修改
	 * @param archivesInfoPO
	 * @author yanwk
	 */
	public void savePrenatalUpdate(ArchivesInfoPO archivesInfoPO);


	/**
	 * 删除档案(修改删除状态为删除)
	 * @param archivesId
	 * @author yanwk
	 */
	public void prenatalDelArchivesById(String archivesId);


	/**
	 * 获取当前地区档案编号个数
	 * @param code
	 * @return
	 */
	public int getCountCode(String code);

}