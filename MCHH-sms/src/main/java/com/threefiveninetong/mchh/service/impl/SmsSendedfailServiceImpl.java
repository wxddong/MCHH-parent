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


import com.threefiveninetong.mchh.po.SmsSendedPO;
import com.threefiveninetong.mchh.po.SmsSendedFailPO;
import com.threefiveninetong.mchh.dao.SmsSendedFailDao;
import com.threefiveninetong.mchh.service.SmsSendedFailService;

@Service
public class SmsSendedfailServiceImpl implements SmsSendedFailService {

	private static final Logger log = LoggerFactory.getLogger(SmsSendedfailServiceImpl.class);
	
	@Resource
	private  SmsSendedFailDao  smsSendedFailDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSendedfail 
	 */
	public SmsSendedFailPO find(Serializable id){
		return smsSendedFailDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SmsSendedfailPO> 
	 */
	public List<SmsSendedFailPO> findAll(){
		return smsSendedFailDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(rollbackFor={Exception.class})
	public void create(SmsSendedFailPO po) throws AppException{
		try{
			if( po != null )
				smsSendedFailDao.create(po);
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
	public void update(SmsSendedFailPO po) throws AppException {
		try{
			if( po != null )
				smsSendedFailDao.update(po);
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
		smsSendedFailDao.delete(id);
	}

	@Override
	public void createList(List<SmsSendedFailPO> faillist) {
      	try{
            if(faillist!=null){
         	   for (int i = 0; i < faillist.size(); i++) {
         		  SmsSendedFailPO po= faillist.get(i);
         		   if( po != null )
         			  smsSendedFailDao.create(po);
 			}
           } 
 		}catch(Exception e){
 			log.error(e.getMessage());
 			throw new AppException("err.test.001");
 		}	
		
	}



}