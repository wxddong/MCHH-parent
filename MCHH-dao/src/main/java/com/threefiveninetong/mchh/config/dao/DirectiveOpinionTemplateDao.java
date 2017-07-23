/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DirectiveOpinionTemplateDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;

/**
 * @ClassName: DirectiveOpinionTemplateDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
public interface DirectiveOpinionTemplateDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return DirectiveOpinionTemplate 
	 */
	public DirectiveOpinionTemplatePO find(Serializable id);
	/**
	 * 查找单个 
	 * @param modularType 
	 * @return DirectiveOpinionTemplate 
	 */
	public List<DirectiveOpinionTemplatePO> findByTgd(Map<String, Object> conds);
	
	/**
	 * 查找所有 
	 * @return List<DirectiveOpinionTemplatePO> 
	 */
	public List<DirectiveOpinionTemplatePO> findAll();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(DirectiveOpinionTemplatePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(DirectiveOpinionTemplatePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 婚前保健指导
	 * 注此方法后台用
	 */
	public List<DirectiveOpinionTemplatePO> listForPage(Map<String, Object> conds);
	
	
	
	/**
	 * 查找所有 
	 * 婚前保健指导          带查询条件的
	 * 注此方法后台用
	 */
	public List<DirectiveOpinionTemplatePO> listForPageTGD(Map<String, Object> conds);
	
	
	/**
	 * 查找所有
	 * 孕产保健指导 
	 * 注此方法后台用
	 */
	public List<DirectiveOpinionTemplatePO> listForPageMaternal(Map<String, Object> conds);
	/**
	 * 查找所有
	 * 高危妊娠保健指导 
	 * 注此方法后台用
	 */
	public List<DirectiveOpinionTemplatePO> listForPagePregancy(Map<String, Object> conds);
	
	/**
	 * 查找所有
	 * 儿童保健指导 
	 * 注此方法后台用
	 * @author wangbj
	 */
	public List<DirectiveOpinionTemplatePO> listForPageBaby(Map<String, Object> conds);
	
	/**
	 * 查找所有
	 * 高危儿童保健指导 
	 * 注此方法后台用
	 * @author wangbj
	 */
	public List<DirectiveOpinionTemplatePO> listForPageBabyHightRisk(Map<String, Object> conds);
	
	
	/**
	 * 组删除 listForPageBaby
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 通过孕周返回保健指导意见
	 * @param directiveOpinionTemplatePO
	 * @author yanwk
	 */
	public DirectiveOpinionTemplatePO getDirectByWeek(DirectiveOpinionTemplatePO directiveOpinionTemplatePO);

	/**
	 * 获取女性指导意见
	 * @return
	 */
	public DirectiveOpinionTemplatePO getWoman();

	/**
	 * 获取男性指导意见
	 * @return
	 */
	public DirectiveOpinionTemplatePO getMan();

	/**
	 * 获取高危指导意见
	 * @param directiveOpinionTemplatePO
	 * @return
	 * @author yanwk
	 */
	public DirectiveOpinionTemplatePO getHighRiskGude(DirectiveOpinionTemplatePO directiveOpinionTemplatePO);

	public DirectiveOpinionTemplatePO get3To7Guidance();

	public DirectiveOpinionTemplatePO get42Guidance();
	
	/**
	 * 根据特殊疾病id获取指导意见信息
	 * @param tgd
	 * @return
	 */
	public DirectiveOpinionTemplatePO getDirectByTgd(String tgd);

}