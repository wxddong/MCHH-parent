/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppChannelService.java 
 * @Prject: MyUniversity-service
 * @Package: com.threefiveninetong.mchh.appConfig.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:44 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appConfig.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.dao.AppChannelDao;
import com.threefiveninetong.mchh.appConfig.po.AppChannelPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: AppChannelService 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:44 
 */
@Service
public class AppChannelService {

	private static final Logger log =Logger.getLogger(AppChannelService.class);
	
	@Resource
	private  AppChannelDao  appChannelDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return AppChannel 
	 */
	public AppChannelPO find(Serializable id){
		return appChannelDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<AppChannelPO> 
	 */
	public List<AppChannelPO> findAll(){
		return appChannelDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(AppChannelPO po) throws Exception{
		
			if( po != null )
				 appChannelDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(AppChannelPO po) throws Exception{

			if( po != null )
				 appChannelDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 appChannelDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		appChannelDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<AppChannelPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<AppChannelPO> list = appChannelDao.listForPage(conds);
		page.setList(list);
	}
	
	/**
     * 根据渠道查找
     * @return Chanel
     */
    public AppChannelPO findBychannelNO(String channelNO) {
    	return this.appChannelDao.findBychannelNO(channelNO);
    }

}