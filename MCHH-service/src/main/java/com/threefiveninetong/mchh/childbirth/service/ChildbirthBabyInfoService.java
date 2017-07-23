/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBabyInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 20:03:49 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.childbirth.po.ChildbirthBabyInfoPO;
import com.threefiveninetong.mchh.childbirth.po.SelectChildBaby;
import com.threefiveninetong.mchh.childbirth.dao.ChildbirthBabyInfoDao;

/**
 * @ClassName: ChildbirthBabyInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 20:03:49 
 */
@Service
public class ChildbirthBabyInfoService {

	private static final Logger log =Logger.getLogger(ChildbirthBabyInfoService.class);
	
	@Resource
	private  ChildbirthBabyInfoDao  childbirthBabyInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthBabyInfo 
	 */
	public ChildbirthBabyInfoPO find(Serializable id){
		return childbirthBabyInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildbirthBabyInfoPO> 
	 */
	public List<ChildbirthBabyInfoPO> findAll(){
		return childbirthBabyInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthBabyInfoPO po) throws Exception{
		
			if( po != null )
				 childbirthBabyInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildbirthBabyInfoPO po) throws Exception{

			if( po != null )
				 childbirthBabyInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childbirthBabyInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childbirthBabyInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildbirthBabyInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildbirthBabyInfoPO> list = childbirthBabyInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 通过分娩信息表id获取到分娩婴儿信息
	 * @param id
	 * @return
	 */
	public List<ChildbirthBabyInfoPO> getBabyInfoByChildbirthId(String id) {
		return childbirthBabyInfoDao.getBabyInfoByChildbirthId(id);
	}

	/**
	 * 查询妈妈信息
	 * @param reqs
	 * @param page
	 * @author ywk
	 */
	public void selectChildBirth(Map<String, Object> conds, Page<SelectChildBaby> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		String babyName = String.valueOf(conds.get("childName"));
		if(babyName != null && !"".equals(babyName) && !"null".equals(babyName)){
			babyName = "%"+babyName+"%";
			conds.put("childName", babyName);
		}
		String name = String.valueOf(conds.get("name"));
		if(name != null && !"".equals(name) && !"null".equals(name)){
			name = "%"+name+"%";
			conds.put("name", name);
		}
		String time = String.valueOf(conds.get("endTime"));
		if(time != null && !"null".equals(time)){
			conds.put("endTime", DateUtil.addDay(time, 1));
		}
		List<SelectChildBaby> list = childbirthBabyInfoDao.selectChildBirth(conds);
		for (SelectChildBaby selectChildBaby : list) {
			selectChildBaby.setSource("分娩登记");
		}
		page.setList(list);
	}

}