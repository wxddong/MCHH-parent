/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenArchivesInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.childCare.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:00 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.childCare.dao.ChildrenArchivesInfoDao;
import com.threefiveninetong.mchh.childCare.dao.ChildrenLastStatusInfoDao;
import com.threefiveninetong.mchh.childCare.po.ChildrenArchivesInfoPO;
import com.threefiveninetong.mchh.childCare.po.ChildrenLastStatusInfoPO;
import com.threefiveninetong.mchh.config.dao.CityInfoDao;
import com.threefiveninetong.mchh.config.dao.DistrictAndCountyInfoDao;
import com.threefiveninetong.mchh.config.dao.ProvinceInfoDao;
import com.threefiveninetong.mchh.config.dao.TownshipInfoDao;
import com.threefiveninetong.mchh.config.dao.VillageInfoDao;
import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ChildrenArchivesInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:00 
 */
@Service
public class ChildrenArchivesInfoService {

	private static final Logger log =Logger.getLogger(ChildrenArchivesInfoService.class);
	
	@Resource
	private  ChildrenArchivesInfoDao  childrenArchivesInfoDao;
	
	@Resource
	private ChildrenLastStatusInfoDao childrenLastStatusInfoDao;
	
	@Resource
	private ProvinceInfoDao provinceInfoDao;
	
	@Resource
	private CityInfoDao cityInfoDao;
	
	@Resource
	private TownshipInfoDao townshipInfoDao;
	
	@Resource
	private DistrictAndCountyInfoDao districtAndCountyInfoDao;
	
	@Resource
	private VillageInfoDao villageInfoDao;
	/**
	 * 查找单个 
	 * @param id 
	 * @return ChildrenArchivesInfo 
	 */
	public ChildrenArchivesInfoPO find(Serializable id){
		return childrenArchivesInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ChildrenArchivesInfoPO> 
	 */
	public List<ChildrenArchivesInfoPO> findAll(){
		return childrenArchivesInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ChildrenArchivesInfoPO po) throws Exception{
		
			if( po != null )
				 childrenArchivesInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ChildrenArchivesInfoPO po) throws Exception{

			if( po != null )
				 childrenArchivesInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 childrenArchivesInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		childrenArchivesInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<ChildrenArchivesInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ChildrenArchivesInfoPO> list = childrenArchivesInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 生成档案号方法
	 * @param childrenArchivesInfoPO
	 * @return
	 * @author ywk
	 */
	@SuppressWarnings("deprecation")
	public String getArchivesCode(ChildrenArchivesInfoPO childrenArchivesInfoPO){
		String archivesCode = "";
		String homeProvinceId = childrenArchivesInfoPO.getHomeProvinceId();
		String homeCityId = childrenArchivesInfoPO.getHomeCityId();
		String homeCountyId = childrenArchivesInfoPO.getHomeCountyId();
		String townshipId = childrenArchivesInfoPO.getHomeTownshipId();
		String homeVillageId = childrenArchivesInfoPO.getHomeVillageId();
		
		ProvinceInfoPO provinceInfoPO = provinceInfoDao.find(homeProvinceId);
		CityInfoPO cityInfoPO = cityInfoDao.find(homeCityId);
		DistrictAndCountyInfoPO districtAndCountyInfoPO = districtAndCountyInfoDao.find(homeCountyId);
		TownshipInfoPO townshipInfoPO = townshipInfoDao.find(townshipId);
		VillageInfoPO villageInfoPO = villageInfoDao.find(homeVillageId);
		
		archivesCode = provinceInfoPO.getNumber()+cityInfoPO.getNumber()+districtAndCountyInfoPO.getNumber();
		archivesCode += townshipInfoPO.getNumber();
		archivesCode += villageInfoPO.getNumber();
		//archivesCode += "110";
		String code = "%"+archivesCode+"%";
		int count = childrenArchivesInfoDao.getCountCode(code);
		String year = new Date().getYear()+"";
		year = year.substring(1);
		archivesCode += year;
		
		String fiveAuto = (count+1)+"";
		int length = fiveAuto.length();
		if(length == 1){
			archivesCode += "0000"+fiveAuto;
		}else if(length == 2){
			archivesCode += "000"+fiveAuto;
		}else if(length == 3){
			archivesCode += "00"+fiveAuto;
		}else if(length == 4){
			archivesCode += "0"+fiveAuto;
		}else if(length == 5){
			archivesCode += fiveAuto;
		}
		
		return archivesCode;
	}
	
	/**
	 * 儿童建档返回档案信息
	 * @param childrenArchivesInfoPO
	 * @param grantSign
	 * @return
	 * @author ywk
	 */
	@Transactional
	public ChildrenArchivesInfoPO bulidArchives(ChildrenArchivesInfoPO childrenArchivesInfoPO, String grantSign) {
		childrenArchivesInfoPO.setId(IdUtil.uuid());
		childrenArchivesInfoPO.setCreatTime(new Date());
		childrenArchivesInfoPO.setUpdateTime(new Date());
		childrenArchivesInfoPO.setDeltetSign("1");
		
		childrenArchivesInfoPO.setArchivesCode(getArchivesCode(childrenArchivesInfoPO));
		
		ChildrenLastStatusInfoPO childrenLastStatusInfoPO = new ChildrenLastStatusInfoPO();
		childrenLastStatusInfoPO.setId(IdUtil.uuid());
		childrenLastStatusInfoPO.setCreatTime(new Date());
		childrenLastStatusInfoPO.setUpdateTime(new Date());
		childrenLastStatusInfoPO.setGrantSign(grantSign);
		childrenLastStatusInfoPO.setReferralSign("0");
		childrenLastStatusInfoPO.setRiskSign("0");
		childrenLastStatusInfoPO.setPregnantState("0");
		childrenLastStatusInfoPO.setArchivesId(childrenArchivesInfoPO.getId());
		
		childrenArchivesInfoDao.create(childrenArchivesInfoPO);
		childrenLastStatusInfoDao.create(childrenLastStatusInfoPO);
		return childrenArchivesInfoPO;
	}

	public void saveUpdateArchives(ChildrenArchivesInfoPO childrenArchivesInfoPO) {
		childrenArchivesInfoPO.setUpdateTime(new Date());
		childrenArchivesInfoDao.update(childrenArchivesInfoPO);
		ChildrenLastStatusInfoPO childrenLastStatusInfoPO = new ChildrenLastStatusInfoPO();
		childrenLastStatusInfoPO.setArchivesId(childrenArchivesInfoPO.getId());
		childrenLastStatusInfoPO.setUpdateTime(new Date());
		childrenLastStatusInfoDao.updateCreatTime(childrenLastStatusInfoPO);
	}

	/**
	 * 删除档案信息
	 * @param archivesId
	 * @author ywk
	 */
	public void delArchives(String archivesId) {
		childrenArchivesInfoDao.delArchivesById(archivesId);
	}


}