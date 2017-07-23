package com.threefiveninetong.mchh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import com.threefiveninetong.mchh.core.exception.AppException;


import com.threefiveninetong.mchh.po.SmsSendedFailPO;

public interface SmsSendedFailService {

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSendedfail 
	 */
	public SmsSendedFailPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsSendedfailPO> 
	 */
	public List<SmsSendedFailPO> findAll();

	/**
	 * 创建 
	 * @param po
	 */
	public void create(SmsSendedFailPO po) throws AppException;

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsSendedFailPO po) throws AppException;

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);

	/**
	 * 批量插入发送失败的数据
	 * @param faillist
	 */
	public void createList(List<SmsSendedFailPO> faillist);



}