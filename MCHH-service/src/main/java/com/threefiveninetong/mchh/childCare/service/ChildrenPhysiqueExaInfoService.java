/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPhysiqueExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.childCare.po.ChildrenPhysiqueExaInfoPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenPhysiqueExaInfoDao;

/**
 * @ClassName: ChildrenPhysiqueExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:03 
 */
@Service
public class ChildrenPhysiqueExaInfoService {

	private static final Logger log =Logger.getLogger(ChildrenPhysiqueExaInfoService.class);
	
	@Resource
	private  ChildrenPhysiqueExaInfoDao  childrenPhysiqueExaInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenPhysiqueExaInfo 
	 */
	public ChildrenPhysiqueExaInfoPO find(Serializable id){
		return childrenPhysiqueExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenPhysiqueExaInfoPO> 
	 */
	public List<ChildrenPhysiqueExaInfoPO> findAll(){
		return childrenPhysiqueExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenPhysiqueExaInfoPO po) throws Exception{
		
			if( po != null )
				 childrenPhysiqueExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenPhysiqueExaInfoPO po) throws Exception{

			if( po != null )
				 childrenPhysiqueExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenPhysiqueExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenPhysiqueExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenPhysiqueExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenPhysiqueExaInfoPO> list = childrenPhysiqueExaInfoDao.listForPage(conds);
		page.setList(list);
	}


}