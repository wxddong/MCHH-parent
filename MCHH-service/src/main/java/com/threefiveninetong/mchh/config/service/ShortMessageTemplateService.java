/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ShortMessageTemplateService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.config.po.ShortMessageTemplatePO;
import com.threefiveninetong.mchh.config.dao.ShortMessageTemplateDao;

/**
 * @ClassName: ShortMessageTemplateService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Service
public class ShortMessageTemplateService {

	private static final Logger log =Logger.getLogger(ShortMessageTemplateService.class);
	
	@Resource
	private  ShortMessageTemplateDao  shortMessageTemplateDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return ShortMessageTemplate 
	 */
	public ShortMessageTemplatePO find(Serializable id){
		return shortMessageTemplateDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ShortMessageTemplatePO>
	 * 预约检查短信 
	 */
	public List<ShortMessageTemplatePO> findAll(){
		return shortMessageTemplateDao.findAll();	
	}
	
	
	/**
	 * 查找所有 
	 * @return List<ShortMessageTemplatePO> 
	 * 高危检查短信
	 */
	public List<ShortMessageTemplatePO> findAllHight(){
		return shortMessageTemplateDao.findAllHight();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ShortMessageTemplatePO po) throws Exception{
		
			if( po != null )
				 shortMessageTemplateDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ShortMessageTemplatePO po) throws Exception{

			if( po != null )
				 shortMessageTemplateDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 shortMessageTemplateDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		shortMessageTemplateDao.deletes(id);
	}
	/**
	 * 查找所有进行分页 
	 * 注此方法后台用
	 * 预约检查短信
	 */
	
	public void listForPage(Map<String, Object> conds, Page<ShortMessageTemplatePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ShortMessageTemplatePO> list = shortMessageTemplateDao.listForPage(conds);
		page.setList(list);
	}
	/**
	 * 查找所有进行分页 
	 * 注此方法后台用
	 * 高危检查短信
	 */
	
	public void listForPageHight(Map<String, Object> conds, Page<ShortMessageTemplatePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ShortMessageTemplatePO> list = shortMessageTemplateDao.listForPageHight(conds);
		page.setList(list);
	}


}