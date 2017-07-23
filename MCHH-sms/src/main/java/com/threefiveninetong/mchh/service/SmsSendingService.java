package com.threefiveninetong.mchh.service;

import java.io.Serializable;
import java.util.List;

import com.threefiveninetong.mchh.core.exception.AppException;


import com.threefiveninetong.mchh.po.SmsSendingPO;

public interface SmsSendingService {

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSending 
	 */
	public SmsSendingPO find(Serializable id);

	/**
	 * 查找所有 
	 * @return List<SmsSendingPO> 
	 */
	public List<SmsSendingPO> updateAndfindAll();

	/**
	 * 创建 
	 * @param po
	 */
	public void create(SmsSendingPO po) throws AppException;

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(SmsSendingPO po) throws AppException;

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(List<SmsSendingPO> polist);

	/**
	 * 批量添加
	 * @param polist
	 */
	public void createList(List<SmsSendingPO> polist);


	/**
	 * 根据手机号和短信内容创建短信
	 * @param po
	 */
	public void createByPhoneAndContent(String telephoneList,String content,String smsType) throws AppException;
}