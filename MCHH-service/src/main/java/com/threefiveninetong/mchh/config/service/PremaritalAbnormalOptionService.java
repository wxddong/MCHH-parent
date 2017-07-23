/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalAbnormalOptionService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
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


import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.dao.PremaritalAbnormalOptionDao;

/**
 * @ClassName: PremaritalAbnormalOptionService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Service
public class PremaritalAbnormalOptionService {

	private static final Logger log =Logger.getLogger(PremaritalAbnormalOptionService.class);
	
	@Resource
	private  PremaritalAbnormalOptionDao  premaritalAbnormalOptionDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PremaritalAbnormalOption 
	 */
	public PremaritalAbnormalOptionPO find(Serializable id){
		return premaritalAbnormalOptionDao.find(id);	
	}
	
	

	/**
	 * 查找单个 
	 * @param name 
	 * @return PremaritalAbnormalOption 
	 */
	public PremaritalAbnormalOptionPO getPremaritalAbnormalOptionVOByname(Map<String,Object> map){
		return premaritalAbnormalOptionDao.getPremaritalAbnormalOptionVOByname(map);	
	}
	
	/**
	 * 查找所有 
	 * @return List<PremaritalAbnormalOptionPO> 
	 */
	public List<PremaritalAbnormalOptionPO> findAll(){
		return premaritalAbnormalOptionDao.findAll();	
	}
	
	
	/**
	 * 查找所有 
	 * @return List<PremaritalAbnormalOptionPO> 
	 */
	public List<PremaritalAbnormalOptionPO> findAllToDerective(){
		return premaritalAbnormalOptionDao.findAllToDerective();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PremaritalAbnormalOptionPO po) throws Exception{
		
			if( po != null )
				 premaritalAbnormalOptionDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PremaritalAbnormalOptionPO po) throws Exception{

			if( po != null )
				 premaritalAbnormalOptionDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 premaritalAbnormalOptionDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		premaritalAbnormalOptionDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PremaritalAbnormalOptionPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PremaritalAbnormalOptionPO> list = premaritalAbnormalOptionDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 获取指定传染病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm1() {
		// TODO Auto-generated method stub
		return premaritalAbnormalOptionDao.getExcTerm1();
	}

	/**
	 * 严重遗传病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm2() {
		// TODO Auto-generated method stub
		return premaritalAbnormalOptionDao.getExcTerm2();
	}

	/**
	 * 精神病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm3() {
		// TODO Auto-generated method stub
		return premaritalAbnormalOptionDao.getExcTerm3();
	}

	/**
	 * 男性生殖系统疾病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm4() {
		// TODO Auto-generated method stub
		return premaritalAbnormalOptionDao.getExcTerm4();
	}

	/**
	 * 女性生殖系统疾病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm5() {
		// TODO Auto-generated method stub
		return premaritalAbnormalOptionDao.getExcTerm5();
	}
	
	/**
	 * 内科疾病
	 * @return
	 */
	public List<PremaritalAbnormalOptionPO> getExcTerm6() {
		// TODO Auto-generated method stub
		return premaritalAbnormalOptionDao.getExcTerm6();
	}



	public List<PremaritalAbnormalOptionPO> getByType(String type) {
		return premaritalAbnormalOptionDao.getByType(type);
	}

}