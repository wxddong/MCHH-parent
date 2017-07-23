package com.threefiveninetong.mchh.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.exception.AppException;


import com.threefiveninetong.mchh.po.SmsReceivedPO;
import com.threefiveninetong.mchh.dao.SmsReceivedDao;
import com.threefiveninetong.mchh.service.SmsReceivedService;

@Service
public class SmsReceivedServiceImpl implements SmsReceivedService {

	private static final Logger log = LoggerFactory.getLogger(SmsReceivedServiceImpl.class);
	
	@Resource
	private  SmsReceivedDao  smsReceivedDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsReceived 
	 */
	public SmsReceivedPO find(Serializable id){
		return smsReceivedDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SmsReceivedPO> 
	 */
	public List<SmsReceivedPO> findAll(){
		return smsReceivedDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(rollbackFor={Exception.class})
	public void create(SmsReceivedPO po) throws AppException{
		try{
			if( po != null )
				 smsReceivedDao.create(po);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}	
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional(rollbackFor={Exception.class})
	public void update(SmsReceivedPO po) throws AppException {
		try{
			if( po != null )
				 smsReceivedDao.update(po);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}	
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id){
		 smsReceivedDao.delete(id);
	}



}