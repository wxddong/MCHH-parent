package com.threefiveninetong.mchh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import com.threefiveninetong.mchh.core.exception.AppException;


import com.threefiveninetong.mchh.po.SmsReceivedPO;

public interface SmsReceivedService {

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsReceived 
	 */
	public SmsReceivedPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsReceivedPO> 
	 */
	public List<SmsReceivedPO> findAll();

	/**
	 * 创建 
	 * @param po
	 */
	public void create(SmsReceivedPO po) throws AppException;

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsReceivedPO po) throws AppException;

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);



}