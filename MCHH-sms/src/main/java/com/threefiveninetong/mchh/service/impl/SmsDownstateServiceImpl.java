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

import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.dao.SmsDownstateDao;
import com.threefiveninetong.mchh.service.SmsDownstateService;

@Service
public class SmsDownstateServiceImpl implements SmsDownstateService {

	private static final Logger log = LoggerFactory.getLogger(SmsDownstateServiceImpl.class);
	
	@Resource
	private  SmsDownstateDao  smsDownstateDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsDownstate 
	 */
	public SmsDownstatePO find(Serializable id){
		return smsDownstateDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SmsDownstatePO> 
	 */
	public List<SmsDownstatePO> findAll(){
		return smsDownstateDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(rollbackFor={Exception.class})
	public void create(SmsDownstatePO po) throws AppException{
		try{
			if( po != null )
				 smsDownstateDao.create(po);
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
	public void update(SmsDownstatePO po) throws AppException {
		try{
			if( po != null )
				 smsDownstateDao.update(po);
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
		 smsDownstateDao.delete(id);
	}



}