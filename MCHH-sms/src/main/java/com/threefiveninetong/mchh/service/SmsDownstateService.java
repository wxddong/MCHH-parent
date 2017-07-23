package com.threefiveninetong.mchh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import com.threefiveninetong.mchh.core.exception.AppException;

import com.threefiveninetong.mchh.po.SmsDownstatePO;

public interface SmsDownstateService {

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsDownstate 
	 */
	public SmsDownstatePO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsDownstatePO> 
	 */
	public List<SmsDownstatePO> findAll();

	/**
	 * 创建 
	 * @param po
	 */
	public void create(SmsDownstatePO po) throws AppException;

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsDownstatePO po) throws AppException;

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);



}