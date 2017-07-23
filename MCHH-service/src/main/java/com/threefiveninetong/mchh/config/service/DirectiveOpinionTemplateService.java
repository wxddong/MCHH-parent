/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DirectiveOpinionTemplateService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
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


import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.dao.DirectiveOpinionTemplateDao;

/**
 * @ClassName: DirectiveOpinionTemplateService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@Service
public class DirectiveOpinionTemplateService {

	private static final Logger log =Logger.getLogger(DirectiveOpinionTemplateService.class);
	
	@Resource
	private  DirectiveOpinionTemplateDao  directiveOpinionTemplateDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return DirectiveOpinionTemplate 
	 */
	public DirectiveOpinionTemplatePO find(Serializable id){
		return directiveOpinionTemplateDao.find(id);	
	}
	/**
	 * 查找单个 
	 * @param modularType 
	 * @return DirectiveOpinionTemplate 
	 */
	public List<DirectiveOpinionTemplatePO> findByTgd(Map<String, Object> conds){
		return directiveOpinionTemplateDao.findByTgd(conds);	
	}

	/**
	 * 查找所有 
	 * @return List<DirectiveOpinionTemplatePO> 
	 */
	public List<DirectiveOpinionTemplatePO> findAll(){
		return directiveOpinionTemplateDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(DirectiveOpinionTemplatePO po) throws Exception{
		
			if( po != null )
				 directiveOpinionTemplateDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(DirectiveOpinionTemplatePO po) throws Exception{

			if( po != null )
				 directiveOpinionTemplateDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 directiveOpinionTemplateDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		directiveOpinionTemplateDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<DirectiveOpinionTemplatePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		String modularType =(String) conds.get("modularType");
		String useSign =(String) conds.get("useSign");
		String tgd =(String) conds.get("tgd");
		if((modularType !=null&&modularType !="") ||(tgd!=null&&tgd!="") ||(useSign !=null&&useSign !="")){
			List<DirectiveOpinionTemplatePO> list = directiveOpinionTemplateDao.listForPageTGD(conds);
			page.setList(list);
		}
		
		if((modularType ==null||modularType =="") &&(tgd==null||tgd=="") &&(useSign ==null||useSign =="")){
		List<DirectiveOpinionTemplatePO> list = directiveOpinionTemplateDao.listForPage(conds);
		page.setList(list);
		
		}
	}
	
	//孕产保健指导列表
	public void listForPageMaternal(Map<String, Object> conds, Page<DirectiveOpinionTemplatePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<DirectiveOpinionTemplatePO> list = directiveOpinionTemplateDao.listForPageMaternal(conds);
		page.setList(list);
	}
	//高危妊娠保健指导列表
	
	public void listForPagePregancy(Map<String, Object> conds, Page<DirectiveOpinionTemplatePO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<DirectiveOpinionTemplatePO> list = directiveOpinionTemplateDao.listForPagePregancy(conds);
		page.setList(list);
	}
	
	
	//儿童保健指导列表
	
		public void listForPageBaby(Map<String, Object> conds, Page<DirectiveOpinionTemplatePO> page) {
			page.setEntityOrField(true);
			conds.put("page", page);
			List<DirectiveOpinionTemplatePO> list = directiveOpinionTemplateDao.listForPageBaby(conds);
			page.setList(list);
		}
		
		/**
		 * 高危儿童保健指导列表
		 * @param directiveOpinionTemplatePO
		 * @return
		 * @author wangbj
		 */
		
			public void listForPageBabyHightRisk(Map<String, Object> conds, Page<DirectiveOpinionTemplatePO> page) {
				page.setEntityOrField(true);
				conds.put("page", page);
				List<DirectiveOpinionTemplatePO> list = directiveOpinionTemplateDao.listForPageBabyHightRisk(conds);
				page.setList(list);
			}	
		

	/**
	 * 通过孕周返回保健指导意见
	 * @param directiveOpinionTemplatePO
	 * @return
	 * @author yanwk
	 */
	public DirectiveOpinionTemplatePO getDirectByWeek(DirectiveOpinionTemplatePO directiveOpinionTemplatePO) {
		
		return directiveOpinionTemplateDao.getDirectByWeek(directiveOpinionTemplatePO);
	}

	/**
	 * 获取女性指导意见
	 * @return
	 */
	public DirectiveOpinionTemplatePO getWoman() {
		// TODO Auto-generated method stub
		return directiveOpinionTemplateDao.getWoman();
	}

	/**
	 * 获取男性指导意见
	 * @return
	 */
	public DirectiveOpinionTemplatePO getMan() {
		// TODO Auto-generated method stub
		return directiveOpinionTemplateDao.getMan();
	}

	/**
	 * 获取高危指导意见
	 * @param directiveOpinionTemplatePO
	 * @return
	 * @author yanwk
	 */
	public DirectiveOpinionTemplatePO getHighRiskGude(DirectiveOpinionTemplatePO directiveOpinionTemplatePO) {
		return directiveOpinionTemplateDao.getHighRiskGude(directiveOpinionTemplatePO);
	}

	/**
	 * 获取 出院3到7天产后访视的指导意见
	 * wangxd 2016.11.01
	 * @return
	 */
	public DirectiveOpinionTemplatePO get3To7Guidance() {
		return directiveOpinionTemplateDao.get3To7Guidance();
	}

	/**
	 * 获取产后42天的健康检查的指导意见
	 * wangxd 2016.11.01
	 * @return
	 */
	public DirectiveOpinionTemplatePO get42Guidance() {
		return directiveOpinionTemplateDao.get42Guidance();
	}
	
	/**
	 * 根据特殊疾病id获取指导意见信息
	 * @param tgd
	 * @return
	 */
	public DirectiveOpinionTemplatePO getDirectByTgd(String tgd) {
		// TODO Auto-generated method stub
		return directiveOpinionTemplateDao.getDirectByTgd(tgd);
	}
	

}