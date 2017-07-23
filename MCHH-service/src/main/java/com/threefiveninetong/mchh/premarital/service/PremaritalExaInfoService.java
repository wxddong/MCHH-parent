/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.premarital.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.premarital.dao.PremaritalExaInfoDao;

/**
 * @ClassName: PremaritalExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
@Service
public class PremaritalExaInfoService {

	private static final Logger log =Logger.getLogger(PremaritalExaInfoService.class);
	
	@Resource
	private  PremaritalExaInfoDao  premaritalExaInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PremaritalExaInfo 
	 */
	public PremaritalExaInfoPO find(Serializable id){
		return premaritalExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PremaritalExaInfoPO> 
	 */
	public List<PremaritalExaInfoPO> findAll(){
		return premaritalExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PremaritalExaInfoPO po) throws Exception{
		
			if( po != null )
				 premaritalExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PremaritalExaInfoPO po) throws Exception{

			if( po != null )
				 premaritalExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 premaritalExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		premaritalExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PremaritalExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PremaritalExaInfoPO> list = premaritalExaInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 婚检页面客户基本信息
	 * @param conds
	 * @param page
	 */
	public void findById(Map<String, Object> conds, Page<PremaritalExaInfoPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PremaritalExaInfoPO> list = premaritalExaInfoDao.findById(conds);
		page.setList(list);
	}

	/**
	 * 根据档案id获取婚检信息
	 * @param archivesId
	 * @return
	 */
	public PremaritalExaInfoPO getPremaritalByArchivesId(String archivesId) {
		// TODO Auto-generated method stub
		return premaritalExaInfoDao.getPremaritalByArchivesId(archivesId);
	}


	/**
	 * 根据档案id获取男性婚检信息
	 * @param archivesId
	 * @return
	 */
	public PremaritalExaInfoPO findPremaritalByArchivesId(String archivesId) {
		// TODO Auto-generated method stub
		return premaritalExaInfoDao.findPremaritalByArchivesId(archivesId);
	}

	/**
	 * 根据档案id获取女性婚检信息
	 * @param archivesId
	 * @return
	 */
	public PremaritalExaInfoPO findWomanPremaritalByArchivesId(String archId) {
		// TODO Auto-generated method stub
		return premaritalExaInfoDao.findWomanPremaritalByArchivesId(archId);
	}

	public void delWoman(PremaritalExaInfoPO premaritalExaInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if (premaritalExaInfoPO != null) {
			premaritalExaInfoDao.delWoman(premaritalExaInfoPO);
		}
	}

	public void delMan(PremaritalExaInfoPO premaritalExaInfo) throws Exception{
		// TODO Auto-generated method stub
		if (premaritalExaInfo != null) {
			premaritalExaInfoDao.delMan(premaritalExaInfo);
		}
	}

	/**
	 * 综合管理
	 * @param conds
	 * @param page
	 */
	public void getAll(Map<String, Object> conds, Page<PremaritalExaInfoPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		String countyMechanism = (String) conds.get("countyMechanism");
		String townMechanism = (String) conds.get("townMechanism");
		String villageMechanism = (String) conds.get("villageMechanism");
		if(villageMechanism!=null && villageMechanism != ""){
			conds.put("departmentId", villageMechanism);
		}else if(townMechanism!=null && townMechanism != ""){
			if (villageMechanism == null && villageMechanism == "") {
				conds.put("departmentId", townMechanism);
			}
		}else if(countyMechanism!=null && countyMechanism != ""){
			if (townMechanism == null && townMechanism == "") {
				if (villageMechanism == null && villageMechanism == "") {
					conds.put("departmentId", countyMechanism);
				}
				
			}
		}
		
		//手册发放
		String grantSign = String.valueOf(conds.get("grantSign"));
		if("0".equals(grantSign)){
			conds.put("grantSign1", "0");
		}else{
			conds.put("grantSign1", null);
		}
		if("1".equals(grantSign)){
			conds.put("grantSign2", "1");
			conds.put("sex", "0");
		}else{
			conds.put("grantSign2", null);
		}
		
		//叶酸发放
		String frantNum = String.valueOf(conds.get("frantNum"));
		if("0".equals(frantNum)){
			conds.put("frantNum1", "0");
		}
		if("-1".equals(frantNum)){
			conds.put("frantNum2", "-1");
		}
		
		
		List<PremaritalExaInfoPO> list = premaritalExaInfoDao.getAll(conds);
		
		
		
		//根据姓名查询列表信息
		if (conds.get("name") != "" && conds.get("name") != null) {
			
			if(("1").equals(list.get(0).getSex())){
				list.remove(0);
			}
			if(("1").equals(list.get(1).getSex())){
				list.remove(1);
			}
		}
		
		//根据身份证号查询列表信息
		if (conds.get("idNo") != "" && conds.get("idNo") != null) {
			
			if(("1").equals(list.get(0).getSex())){
				list.remove(0);
			}
			if(("1").equals(list.get(1).getSex())){
				list.remove(1);
			}
		}
		
		for (PremaritalExaInfoPO premaritalExaInfoPO : list) {
			
			if (premaritalExaInfoPO != null) {
				
				String sex = premaritalExaInfoPO.getSex();
				//Date createTime = premaritalExaInfoPO.getCreatTime();
				
				//String createTime = DateUtil.dateToString(premaritalExaInfoPO.getCreatTime(), DateStyle.YYYY_MM_DD);
				String manName = premaritalExaInfoPO.getArchivesInfoPO().getManName();
				String manIdNo = premaritalExaInfoPO.getArchivesInfoPO().getManIdNo();
				String manTele = premaritalExaInfoPO.getArchivesInfoPO().getManTele();
				String name = premaritalExaInfoPO.getArchivesInfoPO().getName();
				String telephone = premaritalExaInfoPO.getArchivesInfoPO().getTelephone();
				
				if (("1").equals(sex)) {
					premaritalExaInfoPO.getArchivesInfoPO().setName(manName);
					premaritalExaInfoPO.getArchivesInfoPO().setIdNo(manIdNo);
					premaritalExaInfoPO.getArchivesInfoPO().setTelephone(manTele);
					premaritalExaInfoPO.getArchivesInfoPO().setManName(name);
					premaritalExaInfoPO.getArchivesInfoPO().setManTele(telephone);
					premaritalExaInfoPO.getBirthArchivesInfoPO().setGrantSign("-2");
					premaritalExaInfoPO.getBirthArchivesInfoPO().setFrantNum("-2");
				}
				if (("0").equals(sex)) {
					String grant = premaritalExaInfoPO.getBirthArchivesInfoPO().getGrantSign();
					String frant = premaritalExaInfoPO.getBirthArchivesInfoPO().getFrantNum();
					if (grant == null || grant == "") {
						premaritalExaInfoPO.getBirthArchivesInfoPO().setGrantSign("0");
					}
					if (frant == null || frant == "") {
						premaritalExaInfoPO.getBirthArchivesInfoPO().setFrantNum("0");
					}
				}
			}
		}
		
		/*if (conds.get("grantSign") == "1") {
			for (PremaritalExaInfoPO premaritalExaInfoPO : list) {
				
				if (("1").equals(premaritalExaInfoPO.getBirthArchivesInfoPO().getGrantSign())) {
					list.add(premaritalExaInfoPO);
				}
				if (!("1").equals(premaritalExaInfoPO.getBirthArchivesInfoPO().getGrantSign())) {
					list.remove(premaritalExaInfoPO);
				}
				if (("1").equals(premaritalExaInfoPO.getSex())) {
					list.remove(premaritalExaInfoPO);
				}
			}
		}
		if (conds.get("grantSign") == "0") {
			for (PremaritalExaInfoPO premaritalExaInfoPO : list) {
				
				if (("0").equals(premaritalExaInfoPO.getBirthArchivesInfoPO().getGrantSign())) {
					list.add(premaritalExaInfoPO);
				}
				if (!("0").equals(premaritalExaInfoPO.getBirthArchivesInfoPO().getGrantSign())) {
					list.remove(premaritalExaInfoPO);
				}
			}
		}*/
		page.setList(list);
	}

	public PremaritalExaInfoPO getById(String premaritalId) {
		return premaritalExaInfoDao.getById(premaritalId);
	}

	/**
	 * wangxd 2016.11.9
	 * 查询所有的婚前检查
	 * @param conds 
	 * @return
	 */
	public List<PremaritalExaInfoPO> allPremaritalExa(Map<String, Object> conds) {
		return premaritalExaInfoDao.allPremaritalExa(conds);
	}

	/**
	 * wangxd 2016.11.9
	 * 查询所有的婚前检查卫生咨询人数
	 * @param conds 
	 * @return
	 */
	public int findAllAsk(Map<String, Object> conds) {
		return premaritalExaInfoDao.findAllAsk(conds);
	}

	/**
	 * wangxd 2016.11.9
	 * 查询所有的婚前检查患疾病的人数
	 * @param conds 
	 * @return
	 */
	public Integer disNum(Map<String, Object> conds) {
		return premaritalExaInfoDao.disNum(conds);
	}

	public int adviceNum(Map<String, Object> conds) {
		return premaritalExaInfoDao.adviceNum(conds);
	}
	
}