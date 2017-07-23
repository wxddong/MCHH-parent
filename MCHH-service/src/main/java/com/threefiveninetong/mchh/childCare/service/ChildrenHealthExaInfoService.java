/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHealthExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:02 
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


import com.threefiveninetong.mchh.childCare.po.ChildrenHealthExaInfoPO;
import com.threefiveninetong.mchh.childCare.dao.ChildrenHealthExaInfoDao;

/**
 * @ClassName: ChildrenHealthExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:02 
 */
@Service
public class ChildrenHealthExaInfoService {

	private static final Logger log =Logger.getLogger(ChildrenHealthExaInfoService.class);
	
	@Resource
	private  ChildrenHealthExaInfoDao  childrenHealthExaInfoDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenHealthExaInfo 
	 */
	public ChildrenHealthExaInfoPO find(Serializable id){
		return childrenHealthExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenHealthExaInfoPO> 
	 */
	public List<ChildrenHealthExaInfoPO> findAll(){
		return childrenHealthExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenHealthExaInfoPO po) throws Exception{
		
			if( po != null )
				 childrenHealthExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenHealthExaInfoPO po) throws Exception{

			if( po != null )
				 childrenHealthExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenHealthExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenHealthExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenHealthExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenHealthExaInfoPO> list = childrenHealthExaInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 查询所有的检查记录通过档案Id不区分保存还是完成
	 * @param archivesId
	 * @return
	 * @author ywk
	 */
	public List<ChildrenHealthExaInfoPO> getAllExaByArchivesId(String archivesId) {
		return childrenHealthExaInfoDao.getAllExaByArchivesId(archivesId);
	}


}