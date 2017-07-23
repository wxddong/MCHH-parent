package com.threefiveninetong.mchh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.core.exception.AppException;

public interface SmsConfigService {

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsConfig 
	 */
	public SmsConfigPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsConfigPO> 
	 */
	public List<SmsConfigPO> findAll();

	/**
	 * 创建 
	 * @param po
	 */
	public void create(SmsConfigPO po) throws AppException;

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsConfigPO po) throws AppException;

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);


	public void updateByParams(Map<String, Object> map);



}