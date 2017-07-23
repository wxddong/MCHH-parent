/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SpecialDiseaseInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-10-20 17:23:54 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.premarital.po.SpecialDiseaseInfoPO;
import com.threefiveninetong.mchh.premarital.dao.SpecialDiseaseInfoDao;

/**
 * @ClassName: SpecialDiseaseInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-10-20 17:23:54 
 */
@Service
public class SpecialDiseaseInfoService {

	private static final Logger log =Logger.getLogger(SpecialDiseaseInfoService.class);
	
	@Resource
	private  SpecialDiseaseInfoDao  specialDiseaseInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SpecialDiseaseInfo 
	 */
	public SpecialDiseaseInfoPO find(Serializable id){
		return specialDiseaseInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SpecialDiseaseInfoPO> 
	 */
	public List<SpecialDiseaseInfoPO> findAll(){
		return specialDiseaseInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(SpecialDiseaseInfoPO po) throws Exception{
		
			if( po != null )
				 specialDiseaseInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(SpecialDiseaseInfoPO po) throws Exception{

			if( po != null )
				 specialDiseaseInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 specialDiseaseInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		specialDiseaseInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<SpecialDiseaseInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<SpecialDiseaseInfoPO> list = specialDiseaseInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据检查结果id获取特殊疾病信息
	 * @param resultId
	 * @return
	 */
	public SpecialDiseaseInfoPO getSpecialById(String resultId) {
		// TODO Auto-generated method stub
		return specialDiseaseInfoDao.getSpecialById(resultId);
	}

	/**
	 * 保存特殊疾病项的修改
	 * @param specialDiseaseInfoPO
	 */
	public void updateByResultId(SpecialDiseaseInfoPO specialDiseaseInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if( specialDiseaseInfoPO != null )
			 specialDiseaseInfoDao.updateByResultId(specialDiseaseInfoPO);
	}

	/**
	 * wangxd 2016.11.10
	 * 查找所有拥有特殊疾病的对象
	 * @param conds
	 * @return
	 */
	public List<SpecialDiseaseInfoPO> sexDisNum(Map<String, Object> conds) {
		return specialDiseaseInfoDao.sexDisNum(conds);
	}

	/**
	 * wangxd 2016.11.10
	 * 根据特殊疾病的id 获取特殊疾病的名称
	 * @param disId
	 * @return
	 */
	public String getDisNameById(String disId) {
		return specialDiseaseInfoDao.getDisNameById(disId);
	}


}