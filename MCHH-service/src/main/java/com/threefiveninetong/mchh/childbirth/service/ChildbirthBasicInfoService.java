/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBasicInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childbirth.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:05 
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
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.dao.ChildbirthBasicInfoDao;

/**
 * @ClassName: ChildbirthBasicInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:05 
 */
@Service
public class ChildbirthBasicInfoService {

	private static final Logger log =Logger.getLogger(ChildbirthBasicInfoService.class);
	
	@Resource
	private  ChildbirthBasicInfoDao  childbirthBasicInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildbirthBasicInfo 
	 */
	public ChildbirthBasicInfoPO find(Serializable id){
		return childbirthBasicInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildbirthBasicInfoPO> 
	 */
	public List<ChildbirthBasicInfoPO> findAll(){
		return childbirthBasicInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildbirthBasicInfoPO po) throws Exception{
		
			if( po != null )
				 childbirthBasicInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildbirthBasicInfoPO po) throws Exception{

			if( po != null )
				 childbirthBasicInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childbirthBasicInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childbirthBasicInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildbirthBasicInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildbirthBasicInfoPO> list = childbirthBasicInfoDao.listForPage(conds);
		page.setList(list);
	}


	/**
	 * wangxd 2016.8.31
	 * 根据生育档案的id查询分娩信息
	 * @return
	 */
	public ChildbirthBasicInfoPO getChildbirthBasicByBirthArchivesId(String birthArchivesId) {
		return childbirthBasicInfoDao.getChildbirthBasicByBirthArchivesId(birthArchivesId);
	}
	
	
	
	/**
	 * wangbj 2016.8.31
	 * 根据生育档案的id查询分娩信息   查询保存状态的信息
	 * @return
	 */
	public ChildbirthBasicInfoPO SaveChildbirthBasicByBirthArchivesId(String birthArchivesId) {
		return childbirthBasicInfoDao.SaveChildbirthBasicByBirthArchivesId(birthArchivesId);
	}

	


}