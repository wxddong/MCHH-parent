package com.threefiveninetong.mchh.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.exception.AppException;


import com.threefiveninetong.mchh.po.SmsSendedPO;
import com.threefiveninetong.mchh.dao.SmsSendedDao;
import com.threefiveninetong.mchh.service.SmsSendedService;

@Service
public class SmsSendedServiceImpl implements SmsSendedService {

	private static final Logger log = LoggerFactory.getLogger(SmsSendedServiceImpl.class);
	
	@Resource
	private  SmsSendedDao  smsSendedDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSended 
	 */
	public SmsSendedPO find(Serializable id){
		return smsSendedDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SmsSendedPO> 
	 */
	public List<SmsSendedPO> findAll(){
		return smsSendedDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(rollbackFor={Exception.class})
	public void create(SmsSendedPO po) throws AppException{
		try{
			if( po != null )
				 smsSendedDao.create(po);
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
	public void update(SmsSendedPO po) throws AppException {
		try{
			if( po != null )
				 smsSendedDao.update(po);
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
		 smsSendedDao.delete(id);
	}

	@Override
	public void createList(List<SmsSendedPO> successlist) {
      	try{
           if(successlist!=null){
        	   for (int i = 0; i < successlist.size(); i++) {
        		   SmsSendedPO po= successlist.get(i);
        		   if( po != null )
      				 smsSendedDao.create(po);
			}
          } 
		}catch(Exception e){
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}	

}

	@Override
	public List<SmsSendedPO> findByContidions(Map consMap) {
		return smsSendedDao.findByContidions(consMap);	
	}

	@Override
	public void updateList(List<SmsSendedPO> successlist) {
	  	try{
	           if(successlist!=null){
	        	   for (int i = 0; i < successlist.size(); i++) {
	        		   SmsSendedPO po= successlist.get(i);
	        		   if( po != null )
	      				 smsSendedDao.update(po);
				}
	          } 
			}catch(Exception e){
				log.error(e.getMessage());
				throw new AppException("err.test.001");
			}	
		
	}		



}