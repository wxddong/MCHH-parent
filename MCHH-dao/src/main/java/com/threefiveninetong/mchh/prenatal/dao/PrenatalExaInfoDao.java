/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalExaInfoDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:40 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;

/**
 * @ClassName: PrenatalExaInfoDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:40 
 */
public interface PrenatalExaInfoDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PrenatalExaInfo 
	 */
	public PrenatalExaInfoPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<PrenatalExaInfoPO> 
	 */
	public List<PrenatalExaInfoPO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PrenatalExaInfoPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PrenatalExaInfoPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PrenatalExaInfoPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过生育档案id查出第一次产前检查表信息
	 * @param birthArchivesId
	 * @return
	 */
	public PrenatalExaInfoPO getPrenatalExaByBirthArchivesId(String birthArchivesId);

	/**
	 * 通过生育id查询产检记录
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public int countPrenatalByBirthId(String brithArchivesId);

	/**
	 * 获取第一次产检的Id
	 * wangxd 2016.9.5
	 * @return
	 */
	public String getFirstId(String birthArchivesId);

	/**
	 * 获取第一次产检的历史信息记录
	 * wangxd 2016.9.5
	 * @param firstId
	 * @return
	 */
	public HistoryCheckVO getFirstHistoryCheck(String firstId);

	/**
	 * 获取第2-N次产检的历史信息记录
	 * wangxd 2016.9.6
	 * @param firstId
	 * @return
	 */
	public List<HistoryCheckVO> getSecondOrMoreHistoryChecks(@Param(value="firstId")String firstId,@Param(value="birthArchivesId")String birthArchivesId);

	/**
	 * 修改编辑
	 * @param prenatalExaInfoPO
	 * @author yanwk
	 */
	public void edit(PrenatalExaInfoPO prenatalExaInfoPO);

	/**
	 * 获取最新的产检信息
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public PrenatalExaInfoPO getNewestPrenatal(String birthArchivesId);

	/**
	 * 获取所有的产检数据个数通过生育id
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public int countByBirthId(String birthArchivesId);

	/**
	 * 获取最近的一条检查记录不区分保存还是编辑
	 * @param birthArchivesId
	 * @return
	 */
	public PrenatalExaInfoPO getNewPrenatalByBirthArchivesId(String birthArchivesId);

	/**
	 * 孕产妇管理页查询所执行的方法
	 * @param conds
	 * @return
	 * @author yanwk
	 */
	public List<PrenatalExaInfoPO> queryListForPage(Map<String, Object> conds);

	/**
	 * 获取本次生育的所有产检
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public List<PrenatalExaInfoPO> getThisBirthPrenatalByBirthId(String id);

	/**
	 * 获取所有正常的数据个数
	 * @param birthArchivesId
	 * @return
	 * @author ywk
	 */
	public int getNumByNomal(String birthArchivesId);

	/**
	 * 获取所有产检数据
	 * @param birthArchivesId
	 * @return
	 * @author ywk
	 */
	public List<PrenatalExaInfoPO> getAllPrenatalByBirthId(String birthArchivesId);

}