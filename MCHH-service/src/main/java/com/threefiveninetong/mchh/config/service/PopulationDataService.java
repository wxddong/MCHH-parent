/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PopulationDataService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.config.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.service;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.util.Page;


import com.threefiveninetong.mchh.config.po.PopulationDataPO;
import com.threefiveninetong.mchh.config.dao.PopulationDataDao;

/**
 * @ClassName: PopulationDataService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Service
public class PopulationDataService {

	private static final Logger log =Logger.getLogger(PopulationDataService.class);
	
	@Resource
	private  PopulationDataDao  populationDataDao;
	

	/**
	 * 查找单个 
	 * @param id 
	 * @return PopulationData 
	 */
	public PopulationDataPO find(Serializable id){
		PopulationDataPO find = populationDataDao.findPopulation(id);
		String countyId = find.getCountyId();
		String towId = find.getTowId();
		String villageId = find.getVillageId();
		
		if((towId ==null || towId.equals(""))&&(villageId ==null || villageId.equals(""))){
			return populationDataDao.findCountry(id);
			
		}
		//查询乡
		if((countyId !=null && countyId !="")&&(towId !=null && towId !="")&& (villageId ==null || villageId.equals(""))  ){
			return populationDataDao.findtow(id);
			
		}
		//查询村
		if((countyId !=null && countyId !="")&& (towId !=null && towId !="")&&(villageId !=null && villageId !="") ){
			return populationDataDao.findVill(id);
			
		}
		return populationDataDao.findCountry(id);
	}

	/**
	 * 查找所有 
	 * @return List<PopulationDataPO> 
	 */
	public List<PopulationDataPO> findAll(){
		return populationDataDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PopulationDataPO po) throws Exception{
		
			if( po != null )
				 populationDataDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PopulationDataPO po) throws Exception{

			if( po != null )
				 populationDataDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 populationDataDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		populationDataDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PopulationDataPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PopulationDataPO> list = populationDataDao.listForPage(conds);
		page.setList(list);
	}
	/**
	 *查询县，乡，镇 
	 *wangbj 
	 **/
	public void DistictlistForPage(Map<String, Object> conds, Page<PopulationDataPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		String countyId =(String) conds.get("countyId");
		String towId =(String) conds.get("towId");
		String villageId =(String) conds.get("villageId");
		//查询县
		if((towId ==null || towId =="")&&(villageId ==null || villageId =="")  ){
			List<PopulationDataPO> list = populationDataDao.listForPage(conds);
			page.setList(list);
		}
		//查询乡
		if((countyId !=null && countyId !="")&&(towId !=null && towId !="")&& (villageId ==null || villageId =="")  ){
			List<PopulationDataPO> list = populationDataDao.DistictlistForPage(conds);
			page.setList(list);
		}
		//查询村
		if((countyId !=null && countyId !="")&& (towId !=null && towId !="")&&(villageId !=null && villageId !="") ){
			List<PopulationDataPO> list = populationDataDao.villlistForPage(conds);
			page.setList(list);
		}
		
	}
	
	


}