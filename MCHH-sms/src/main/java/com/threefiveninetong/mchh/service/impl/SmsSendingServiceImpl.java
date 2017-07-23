package com.threefiveninetong.mchh.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.exception.AppException;
import com.threefiveninetong.mchh.core.util.IdUtil;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.dao.SmsSendingDao;
import com.threefiveninetong.mchh.service.SmsSendingService;

@Service
public class SmsSendingServiceImpl implements SmsSendingService {

	private static final Logger log = LoggerFactory.getLogger(SmsSendingServiceImpl.class);
	
	@Resource
	private  SmsSendingDao  smsSendingDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return SmsSending 
	 */
	public SmsSendingPO find(Serializable id){
		return smsSendingDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<SmsSendingPO> 
	 */
	@Transactional(rollbackFor={Exception.class})
	public List<SmsSendingPO> updateAndfindAll(){
		int idMaxs=800;//in中数据超过1000条就会报错，这里限制到800更新一次，效率上面不会影响
		int start=0;//起始位置
		List<SmsSendingPO> smsSendingPOList=null;
		try {
			smsSendingPOList = smsSendingDao.findAll();	
			Map<String,String[]> sqlMap=null;
			if(smsSendingPOList!=null&&smsSendingPOList.size()>0){
				List<String []> SendIngids=this.convert2sqlList(smsSendingPOList,idMaxs,start);
				for (int i = 0; i < SendIngids.size(); i++) {
					sqlMap=new HashMap<String, String[]>();
					sqlMap.put("sendids", SendIngids.get(i));
					smsSendingDao.updateByIds(sqlMap);//修改短信读取状态
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}
		return smsSendingPOList;
		
	}

	private List<String[]> convert2sqlList(List<SmsSendingPO> smsSendingPOList, int idMaxs,int start) {
  		List<String[]> arrays=new ArrayList<String[]>();
  		if((smsSendingPOList.size()-start)>idMaxs){
  			String[] ids=new String[idMaxs];
  			    int next=0;
            	for (int i = start; i <start+idMaxs; i++) {
            		ids[next]=smsSendingPOList.get(i).getId();
            		next++;
				}
            	List<String[]> newarrays=convert2sqlList(smsSendingPOList,idMaxs,start+idMaxs);
            	arrays.add(ids);
            	arrays.addAll(newarrays);
         }else{
        	 String[] ids=new String[smsSendingPOList.size()-start];
        	    int next=0;
            	for (int i = start; i <smsSendingPOList.size(); i++) {
            		ids[next]=smsSendingPOList.get(i).getId();
            		next++;
				}
            	arrays.add(ids);
         }
		return arrays;
	}
	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional(rollbackFor={Exception.class})
	public void create(SmsSendingPO po) throws AppException{
		try{
			if( po != null ){
				 smsSendingDao.create(po);
			}
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
	public void update(SmsSendingPO po) throws AppException {
		try{
			if( po != null )
				 smsSendingDao.update(po);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}	
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(List<SmsSendingPO> polist){
		int idMaxs=800;//in中数据超过1000条就会报错，这里限制到800更新一次，效率上面不会影响
		int start=0;//起始位置
		Map<String,String[]> sqlMap=null;
		if(polist!=null&&polist.size()>0){
			try {
				List<String []> SendIngids=this.convert2sqlList(polist,idMaxs,start);
				for (int i = 0; i < SendIngids.size(); i++) {
					sqlMap=new HashMap<String, String[]>();
					sqlMap.put("sendids", SendIngids.get(i));
					 smsSendingDao.deleteByIds(sqlMap);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new AppException("err.test.001");
			}
		}
		
	}

	@Override
	public void createList(List<SmsSendingPO> polist) {
		try{
			if( polist != null &&polist.size()>0){
				for (int i = 0; i < polist.size(); i++) {
					smsSendingDao.create(polist.get(i));
				}
			}
		}catch(Exception e){
			log.error(e.getMessage());
			throw new AppException("err.test.001");
		}	
		
	}

	/*
	 * 手机号和短信内容创建短信
	 * @see com.threefiveninetong.mchh.service.SmsSendingService#createByPhoneAndContent(java.lang.String, java.lang.String)
	 */
	@Override
	public void createByPhoneAndContent(String telephoneList, String content,String smsType) throws AppException {
		// TODO Auto-generated method stub
    	SmsSendingPO smsSendingPO=new SmsSendingPO();
    	smsSendingPO.setId(IdUtil.uuid());//id
    	smsSendingPO.setState("0");
    	smsSendingPO.setContent(content);//短信内容
    	smsSendingPO.setCreatetime(new Date());//短信创建时间
    	smsSendingPO.setReceiver(telephoneList);//接收短信的手机号列表
    	smsSendingPO.setSendlevel("1");
    	smsSendingPO.setSmstype(smsType);
    	smsSendingPO.setPlatformCode("*");
    	smsSendingDao.create(smsSendingPO);
	}
}