/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: BirthArchivesInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.archives.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:42 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;

/**
 * @ClassName: BirthArchivesInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:42 
 */
public interface BirthArchivesInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return BirthArchivesInfo 
	 */
	public BirthArchivesInfoPO find(Serializable id);
	
	
	
	/**
	 * 查找单个 
	 * 通过档案id
	 * @param id 
	 * @return BirthArchivesInfo
	 * wangbj 
	 */
	public BirthArchivesInfoPO findbirth(Serializable id);
	/**
	 * 查找所有 
	 * @return List<BirthArchivesInfoPO> 
	 */
	public List<BirthArchivesInfoPO> findAll();
	
	
	
	/**
	 * 查找某地区所有 
	 * @return List<ArchivesInfoPO> 
	 */
	public List<BirthArchivesInfoPO> findAllByCountyId();
	
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void create(BirthArchivesInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(BirthArchivesInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<BirthArchivesInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过档案Id获取生育档案表信息
	 * @param archivesId
	 * @return
	 */
	public BirthArchivesInfoPO getBirthArchivesByArchivesId(String archivesId);

	/**
	 * 修改生育表状态
	 * @param id
	 * @param pregantState
	 */
	public void updateStatus(BirthArchivesInfoPO birthArchivesInfoPO);

	/**
	 * 获取生育表通过档案ID和产检状态
	 * @param birthArchivesInfoPO1
	 * @return
	 * @author yanwk
	 */
	public BirthArchivesInfoPO getBirthArchivesByArchivesIdAndState(BirthArchivesInfoPO birthArchivesInfoPO1);

	/**
	 * 修改转诊标识
	 * @param birthArchivesInfoPO1
	 * @author yanwk
	 */
	public void updateReferralSign(BirthArchivesInfoPO birthArchivesInfoPO);

	/**
	 * 获取最近的生育档案信息通过档案id
	 * @param archivesId
	 * @return
	 * @author yanwk
	 */
	public BirthArchivesInfoPO getNearBirthArchivesByArchivesId(String archivesId);

	/**
	 * 产后结案，修改生育档案表中孕检状态为结案 添加结案原因和结案时间
	 * wangxd 2016.9.9
	 * @param birthArchivesId
	 * @param closeCaseReason
	 */
	public void toCloseCase(Map map);

	/**
	 * 查询未结案的生育档案
	 * @return
	 */
	public List<BirthArchivesInfoPO> getNoCloseCase();

	/**
	 * 保存末次月经和预产期
	 * @param birthArchivesInfoPO1
	 * @author yanwk
	 */
	public void saveLastMensesAndPredictDate(BirthArchivesInfoPO birthArchivesInfoPO1);


	/**
	 * 修改高危标识和第一次出现高危的筛查时间
	 * @param birthArchivesInfoPO
	 * @author yanwk
	 */
	public void updateRiskSign(BirthArchivesInfoPO birthArchivesInfoPO);


	/**
	 * 孕产妇管理删除修改生育档案的删除状态
	 * @param birthArchivesId
	 * @author yanwk
	 */
	public void delBirthArchivesByBirthId(String birthArchivesId);


	/**
	 * 产妇数合计
	 * @return
	 */
	public Integer getTotal();


	/**
	 * 非农业户籍人数
	 * @return
	 */
	public Integer getNoAgriculture();


	/**
	 * 农业户籍人数
	 * @return
	 */
	public Integer getAgriculture();



	public Date getLastMensesByBirthArchivesId(String birthArchivesId);


	/**
	 * 修改生育档案信息不带创建时间
	 * @param birthArchivesInfoPO
	 * @author yanwk
	 */
	public void saveBirthArchivesToUpdate(BirthArchivesInfoPO birthArchivesInfoPO);


	/**
	 * 修改生育档案信息带创建时间
	 * @param birthArchivesInfoPO
	 * @author yanwk
	 */
	public void saveBirthArchivesUpdate(BirthArchivesInfoPO birthArchivesInfoPO);


	
	public void toChangeStatue(String birthArchivesId);
}