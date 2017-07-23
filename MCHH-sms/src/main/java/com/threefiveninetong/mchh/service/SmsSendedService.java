package com.threefiveninetong.mchh.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import com.threefiveninetong.mchh.core.exception.AppException;


import com.threefiveninetong.mchh.po.SmsSendedPO;

public interface SmsSendedService {

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSended 
	 */
	public SmsSendedPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsSendedPO> 
	 */
	public List<SmsSendedPO> findAll();

	/**
	 * 创建 
	 * @param po
	 */
	public void create(SmsSendedPO po) throws AppException;

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsSendedPO po) throws AppException;

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id);

	/**
	 * 批量插入成功发送的数据
	 * @param successlist
	 */
	public void createList(List<SmsSendedPO> successlist);

	
	/**
	 * 查找所有 
	 * @return List<SmsSendedPO> 
	 */
	public List<SmsSendedPO> findByContidions(Map consMap);

	public void updateList(List<SmsSendedPO> sendedlist);


}