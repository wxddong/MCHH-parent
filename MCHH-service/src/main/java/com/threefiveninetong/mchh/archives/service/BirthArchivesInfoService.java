/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: BirthArchivesInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.archives.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:42 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.archives.dao.BirthArchivesInfoDao;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: BirthArchivesInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:42 
 */
@Service
public class BirthArchivesInfoService {

	private static final Logger log =Logger.getLogger(BirthArchivesInfoService.class);
	
	@Resource
	private  BirthArchivesInfoDao  birthArchivesInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return BirthArchivesInfo 
	 */
	public BirthArchivesInfoPO find(Serializable id){
		return birthArchivesInfoDao.find(id);	
	}
	
	
	/**
	 * 查找单个 通过
	 * 通过档案id
	 * @param id 
	 * @return BirthArchivesInfo 
	 * wangbj
	 */
	public BirthArchivesInfoPO findbirth(Serializable id){
		return birthArchivesInfoDao.findbirth(id);	
	}

	/**
	 * 查找所有 
	 * @return List<BirthArchivesInfoPO> 
	 */
	public List<BirthArchivesInfoPO> findAll(){
		return birthArchivesInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(BirthArchivesInfoPO po) throws Exception{
		
			if( po != null )
				 birthArchivesInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(BirthArchivesInfoPO po) throws Exception{

			if( po != null )
				 birthArchivesInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 birthArchivesInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		birthArchivesInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<BirthArchivesInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<BirthArchivesInfoPO> list = birthArchivesInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * wangxd 2016.8.30
	 * 通过档案id获取生育档案的信息 用来获取转诊状态
	 * @param id
	 * @return
	 */
	public BirthArchivesInfoPO getBirthArchivesByArchivesId(String archivesId) {
		return birthArchivesInfoDao.getBirthArchivesByArchivesId(archivesId);
	}

	/**
	 * 修改生育状态为“分娩中”
	 * @param birthArchivesInfoPO
	 */
	@Transactional
	public void updateStatus(BirthArchivesInfoPO birthArchivesInfoPO) {
		birthArchivesInfoDao.updateStatus(birthArchivesInfoPO);
	}
	/**
	 * wangxd 修改转诊标识
	 * @param birthArchivesInfoPO
	 */
	@Transactional
	public void updateReferralSign(BirthArchivesInfoPO birthArchivesInfoPO) {
		birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
	}
	/**
	 * 通过档案id和分娩状态查询生育档案信息
	 * @param birthArchives 里面存的是档案id和分娩状态
	 * @return
	 * @author yanwk
	 */
	public BirthArchivesInfoPO getBirthArchivesByArchivesIdAndState(BirthArchivesInfoPO birthArchives) {
		return birthArchivesInfoDao.getBirthArchivesByArchivesIdAndState(birthArchives);
	}
	/**
	 * 获取最近的生育档案信息
	 * @param archivesId
	 * @return
	 * @author yanwk
	 */
	public BirthArchivesInfoPO getNearBirthArchivesByArchivesId(String archivesId) {
		return birthArchivesInfoDao.getNearBirthArchivesByArchivesId(archivesId);
	}

	/**
	 * 产后结案，修改生育档案表中孕检状态为结案 添加结案原因和结案时间
	 * wangxd 2016.9.9
	 * @param birthArchivesId
	 * @param closeCaseReason
	 */
	@Transactional
	public void toCloseCase(Map map) {
		Date closeCaseTime = new Date();
		map.put("closeCaseTime", closeCaseTime);
		birthArchivesInfoDao.toCloseCase(map);
	}


	/**
	 * 孕产妇管理删除修改生育档案的删除状态
	 * @param birthArchivesId
	 * @author yanwk
	 */
	public void delBirthArchivesByBirthId(String birthArchivesId) {
		birthArchivesInfoDao.delBirthArchivesByBirthId(birthArchivesId);
	}

	/**
	 * 产妇数合计
	 * @return
	 */
	public Integer getTotal() {
		// TODO Auto-generated method stub
		return birthArchivesInfoDao.getTotal();
	}

	/**
	 * 非农业户籍人数
	 * @return
	 */
	public Integer getNoAgriculture() {
		// TODO Auto-generated method stub
		return birthArchivesInfoDao.getNoAgriculture();
	}

	/**
	 * 农业户籍人数
	 * @return
	 */
	public Integer getAgriculture() {
		// TODO Auto-generated method stub
		return birthArchivesInfoDao.getAgriculture();
	}

	/**
	 * 修改生育档案信息
	 * @param birthArchivesInfoPO
	 * @author yanwk
	 */
	@Transactional
	public void saveBirthArchivesUpdate(BirthArchivesInfoPO birthArchivesInfoPO) {
		birthArchivesInfoDao.saveBirthArchivesUpdate(birthArchivesInfoPO);
	}


	public void saveBirthArchivesToUpdate(BirthArchivesInfoPO birthArchivesInfoPO) {
		birthArchivesInfoDao.saveBirthArchivesToUpdate(birthArchivesInfoPO);
	}

	/**
	 * 当完成产后访视进行保存时将生育表的生育状态改为已分娩
	 * @param birthArchivesId
	 */
	public void toChangeStatue(String birthArchivesId) {
		birthArchivesInfoDao.toChangeStatue(birthArchivesId);
	}

}