/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalAbnormalOptionDao.java 
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.dao 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;

/**
 * @ClassName: PremaritalAbnormalOptionDao 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public interface PremaritalAbnormalOptionDao{

	/**
	 * 查找单个 
	 * @param id 
	 * @return PremaritalAbnormalOption 
	 */
	public PremaritalAbnormalOptionPO find(Serializable id);
	
	/**
	 * 查找单个 
	 * @param name 
	 * @return PremaritalAbnormalOption 
	 */
	public PremaritalAbnormalOptionPO getPremaritalAbnormalOptionVOByname(Map<String,Object> map);
	
	/**
	 * 查找所有 
	 * @return List<PremaritalAbnormalOptionPO> 
	 */
	public List<PremaritalAbnormalOptionPO> findAll();
	
	
	/**
	 * 查找所有 
	 * @return List<PremaritalAbnormalOptionPO> 
	 */
	public List<PremaritalAbnormalOptionPO> findAllToDerective();

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PremaritalAbnormalOptionPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(PremaritalAbnormalOptionPO po);

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);
	
	/**
	 * 查找所有 
	 * 注此方法后台用
	 */
	public List<PremaritalAbnormalOptionPO> listForPage(Map<String, Object> conds);
	
	/**
	 * 组删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id);

	/**
	 * 指定传染病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm1();

	/**
	 * 严重遗传病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm2();

	/**
	 * 精神病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm3();
	
	/**
	 * 男性生殖系统疾病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm4();
	
	/**
	 * 女性生殖系统疾病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm5();
	
	/**
	 * 内科疾病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm6();

	public List<PremaritalAbnormalOptionPO> getByType(String type);

}