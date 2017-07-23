/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ShortMessageTemplateDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.config.dto.SmsScreenTempVo;
import com.threefiveninetong.mchh.config.po.ShortMessageTemplatePO;

/**
 * @ClassName: ShortMessageTemplateDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
public interface ShortMessageTemplateDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return ShortMessageTemplate 
	 */
	public ShortMessageTemplatePO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<ShortMessageTemplatePO> 
	 * 预约检查短信
	 */
	public List<ShortMessageTemplatePO> findAll();
	
	
	
	/**
	 * 查找所有 
	 * @return List<ShortMessageTemplatePO> 
	 * 高危短信检查
	 */
	public List<ShortMessageTemplatePO> findAllHight();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ShortMessageTemplatePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ShortMessageTemplatePO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 * 高危检查短信
	 */
	public List<ShortMessageTemplatePO> listForPageHight(Map<String, Object> conds);
	
	
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 * 预约检查短信
	 */
	public List<ShortMessageTemplatePO> listForPage(Map<String, Object> conds);
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);
	
	/**
	 * 查找所有可用的短信模板
	 * @return List<ShortMessageTemplatePO> 
	 */
	public List<ShortMessageTemplatePO> findAlluse();

	/**
	 * 根据预约随访时间和孕周的开始、结束天数筛选
	 * @return
	 */
	public List<SmsScreenTempVo> screenByFollowingDate(Map<String, Object> conds);
	
	/**
	 * 根据预约随访时间和高危项筛选
	 * @return
	 */
	public List<SmsScreenTempVo> screenByHighRisk(Map<String, Object> conds);
	
	/**
	 * 查询已结案的并且发送过短信的生育档案
	 * @return
	 */
	public List<SmsScreenTempVo> getCloseCase();
}