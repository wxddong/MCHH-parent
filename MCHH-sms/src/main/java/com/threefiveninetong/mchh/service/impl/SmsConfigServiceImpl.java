package com.threefiveninetong.mchh.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.dao.SmsConfigDao;
import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.service.SmsConfigService;
import com.threefiveninetong.mchh.core.exception.AppException;

@Service
public class SmsConfigServiceImpl implements SmsConfigService {

	private static final Logger log =LoggerFactory.getLogger(SmsConfigServiceImpl.class);
	
	@Resource
	private  SmsConfigDao  smsConfigDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsConfig 
	 */
	public SmsConfigPO find(Serializable id){
		return smsConfigDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SmsConfigPO> 
	 */
	public List<SmsConfigPO> findAll(){
		return smsConfigDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(rollbackFor={Exception.class})
	public void create(SmsConfigPO po) throws AppException{
		try{
			if( po != null )
				 smsConfigDao.create(po);
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
	public void update(SmsConfigPO po) throws AppException {
		try{
			if( po != null )
				 smsConfigDao.update(po);
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
		 smsConfigDao.delete(id);
	}

	@Override
	public void updateByParams(Map<String, Object> map) {
		try{
			if( map != null )
				smsConfigDao.updateByParams(map);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}
		
	}


}