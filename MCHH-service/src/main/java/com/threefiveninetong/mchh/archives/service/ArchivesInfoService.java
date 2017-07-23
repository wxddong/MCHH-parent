/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ArchivesInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.archives.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.archives.dao.ArchivesInfoDao;
import com.threefiveninetong.mchh.archives.dao.BirthArchivesInfoDao;
import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.childbirth.dao.ChildbirthBasicInfoDao;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
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
import com.threefiveninetong.mchh.postpartum.dao.PostpartumExaInfoDao;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;
import com.threefiveninetong.mchh.premarital.dao.PremaritalExaInfoDao;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.PrenatalExaInfoDao;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ArchivesInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Service
public class ArchivesInfoService {

	private static final Logger log =Logger.getLogger(ArchivesInfoService.class);
	
	@Resource
	private  ArchivesInfoDao  archivesInfoDao;
	
	@Resource
	private BirthArchivesInfoDao birthArchivesInfoDao;
	
	@Resource
	private PremaritalExaInfoDao premaritalExaInfoDao;
	
	@Resource
	private TownshipInfoDao townshipInfoDao;
	
	@Resource
	private VillageInfoDao villageInfoDao;
	
	@Resource
	private PrenatalExaInfoDao prenatalExaInfoDao;
	
	@Value("${doctorAdmin.id}")
	private String adminId;
	
	@Value("${admin.id}")
	private String admId;
	
	@Resource
	private ProvinceInfoDao provinceInfoDao;
	
	@Resource
	private CityInfoDao cityInfoDao;
	
	@Resource
	private DistrictAndCountyInfoDao districtAndCountyInfoDao;
	
	@Resource
	private ChildbirthBasicInfoDao childbirthBasicInfoDao;
	
	@Resource
	private PostpartumExaInfoDao postpartumExaInfoDao;
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return ArchivesInfo 
	 */
	public ArchivesInfoPO find(Serializable id){
		return archivesInfoDao.find(id);	
	}
	
	
	
	/**
	 * 查找单个 
	 * 查询出末次月经 
	 * @param id 
	 * @return ArchivesInfo 
	 * wangbj
	 */
	public ArchivesInfoPO findlian(Serializable id){
		return archivesInfoDao.findlian(id);	
	}

	/**
	 * 查找所有 
	 * @return List<ArchivesInfoPO> 
	 */
	public List<ArchivesInfoPO> findAll(){
		return archivesInfoDao.findAll();	
	}
	
	
	/**
	 * 查找某地区所有 
	 * @return List<ArchivesInfoPO> 
	 */
	public List<ArchivesInfoPO> findAllByCountyId(Serializable id){
		return archivesInfoDao.findAllByCountyId(id);	
	}
	
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void create(ArchivesInfoPO po) throws Exception{
		
			if( po != null )
				 archivesInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(ArchivesInfoPO po) throws Exception{

			if( po != null )
				 archivesInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 archivesInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		archivesInfoDao.deletes(id);
	}
	
	public String getAdminId(){
		return adminId;
	}
	
	public String getAdmId(){
		return admId;
	}
	
	public void listForPage(Map<String, Object> conds, Page<ArchivesInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ArchivesInfoPO> list = archivesInfoDao.listForPage(conds);
		page.setList(list);
	}
	
	
	/**
	 * 查找所有用于病检报表 
	 * 注此方法后台用
	 */
	public void listForPageCheck(Map<String, Object> conds,Page<ArchivesInfoPO> page){
		
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ArchivesInfoPO> list = archivesInfoDao.listForPageCheck(conds);
		
		page.setList(list);
	}

	/**
	 * 生成档案号方法
	 * @param archivesInfoPO
	 * @return
	 * @author yanwk
	 */
	@SuppressWarnings("deprecation")
	public String getArchivesCode(ArchivesInfoPO archivesInfoPO){
		String archivesCode = "";
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		String homeCityId = archivesInfoPO.getHomeCityId();
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		String townshipId = archivesInfoPO.getHomeTownshipId();
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		
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
		int count = archivesInfoDao.getCountCode(code);
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
	 * 女性建档，返回档案号，并在婚检表和孕检表中各插入一条数据
	 * @param map
	 * @return
	 * @author yanwk
	 */
	@Transactional
	public Map<String,Object> womanBuildArchices(ArchivesInfoPO archivesInfoPO,BirthArchivesInfoPO birthArchivesInfoPO) {
		
		archivesInfoPO.setDeltetSign("1");
		archivesInfoPO.setId(IdUtil.uuid());
		archivesInfoPO.setUpdateTime(archivesInfoPO.getCreatTime());
		archivesInfoPO.setArchivesCode(getArchivesCode(archivesInfoPO));
		archivesInfoDao.create(archivesInfoPO);
		
		birthArchivesInfoPO.setId(IdUtil.uuid());
		birthArchivesInfoPO.setCreatTime(archivesInfoPO.getCreatTime());
		birthArchivesInfoPO.setUpdateTime(birthArchivesInfoPO.getCreatTime());
		birthArchivesInfoPO.setArchivesId(archivesInfoPO.getId());
		birthArchivesInfoPO.setRiskSign("0");
		birthArchivesInfoPO.setReferralSign("0");
		birthArchivesInfoPO.setDeltetSign("1");
		birthArchivesInfoPO.setHospitalId(archivesInfoPO.getHospitalId());
		birthArchivesInfoDao.create(birthArchivesInfoPO);
		

		PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
		premaritalExaInfoPO.setId(IdUtil.uuid());
		premaritalExaInfoPO.setArchivesId(archivesInfoPO.getId());
		premaritalExaInfoPO.setSex(archivesInfoPO.getSex());
		premaritalExaInfoPO.setDoctorId(archivesInfoPO.getDoctorId());
		premaritalExaInfoPO.setPremaritalStatus("0");
		premaritalExaInfoPO.setCreatTime(archivesInfoPO.getCreatTime());
		premaritalExaInfoPO.setUpdateTime(archivesInfoPO.getCreatTime());
		premaritalExaInfoDao.create(premaritalExaInfoPO);
		Map<String,Object> map = new HashMap<>();
		map.put("premId", premaritalExaInfoPO.getId());
		map.put("archives", archivesInfoPO);
		return map;
	}

	/**
	 * 通过档案号查找档案
	 * @param archivesCode
	 * @return
	 * @author yanwk
	 */
	public ArchivesInfoPO getArchivesByArchivesCode(String archivesCode) {
		
		return archivesInfoDao.getArchivesByArchivesCode(archivesCode);
	}
	
	/**
	 * 根据档案编号获取档案信息
	 * @param archivesCode
	 * @return
	 */
	public ArchivesInfoPO findArchivesByArchivesCode(String archivesCode) {
		
		return archivesInfoDao.getArchivesByArchivesCode(archivesCode);
	}
	
	/**
	 * 补全男性的档案信息
	 * @param archivesInfoPO
	 */
	@Transactional
	public void replenishManArchives(ArchivesInfoPO archivesInfoPO) {
		archivesInfoDao.replenishManArchives(archivesInfoPO);
		
		PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
		premaritalExaInfoPO.setId(IdUtil.uuid());
		premaritalExaInfoPO.setArchivesId(archivesInfoPO.getId());
		premaritalExaInfoPO.setSex(archivesInfoPO.getSex());
		premaritalExaInfoPO.setDoctorId(archivesInfoPO.getDoctorId());
		premaritalExaInfoPO.setPremaritalStatus("0");
		premaritalExaInfoPO.setCreatTime(archivesInfoPO.getCreatTime());
		premaritalExaInfoPO.setUpdateTime(archivesInfoPO.getCreatTime());
		premaritalExaInfoDao.create(premaritalExaInfoPO);
	}

	/**
	 * 根据身份证号或者档案号查询档案和产检信息
	 * @param idOrCode
	 * @return
	 */
	public Map<String, Object> getArchivesOrPrenatalExal(String idOrCode) {
		
		Map<String, Object> map = new HashMap<>();
		
		int length = idOrCode.length();
		ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
		
		if(length == 18){
			String idNum = idOrCode;
			archivesInfoPO = archivesInfoDao.getArchivesByIdNum(idNum);
			
			
		}else if(length == 19){
			String archivesCode = idOrCode;
			archivesInfoPO = archivesInfoDao.getArchivesByArchivesCode(archivesCode);
			
		} else{
			archivesInfoPO = null;
		}
		
		map.put("archives", archivesInfoPO);
		
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		ChildbirthBasicInfoPO childbirthBasicInfoPO = null;
		PostpartumExaInfoPO postpartumExaInfoPO = null;
		BirthArchivesInfoPO birthArchivesInfoPO = null;
		if(archivesInfoPO != null){
			birthArchivesInfoPO = birthArchivesInfoDao.getBirthArchivesByArchivesId(archivesInfoPO.getId());
			Date manBirthday = archivesInfoPO.getManBirthday();
			String manAccPro = archivesInfoPO.getManAccProvinceId();
			String manAccCity = archivesInfoPO.getManAccCityId();
			if(manBirthday == null || manAccPro == null || manAccCity == null|| birthArchivesInfoPO.getLastMenses() == null || birthArchivesInfoPO.getPredictDate() == null){
				map.put("isAll", "1");
			}else {
				map.put("isAll", "0");
			}
			
			if(birthArchivesInfoPO != null){
				
				//获取最近的一条检查记录不区分是保存还是编辑
				prenatalExaInfoPO = prenatalExaInfoDao.getNewPrenatalByBirthArchivesId(birthArchivesInfoPO.getId());
				childbirthBasicInfoPO = childbirthBasicInfoDao.getChildbirthBasicByBirthArchivesId(birthArchivesInfoPO.getId());
				postpartumExaInfoPO = postpartumExaInfoDao.getPostExaByBirthId(birthArchivesInfoPO.getId());
			}else{
				prenatalExaInfoPO = null;
			}
		}
		map.put("birthArchives", birthArchivesInfoPO);
		map.put("prenatalExa", prenatalExaInfoPO);
		map.put("childbirthBasicInfoPO", childbirthBasicInfoPO);
		map.put("postpartumExaInfoPO", postpartumExaInfoPO);
		
		return map;
	}

	/**
	 * 孕检建档
	 * @param archivesInfoPO
	 * @param birthArchivesInfoPO
	 * @return
	 */
	@Transactional
	public ArchivesInfoPO prenatalNewArchives(ArchivesInfoPO archivesInfoPO, BirthArchivesInfoPO birthArchivesInfoPO) {
		
		archivesInfoPO.setDeltetSign("1");
		archivesInfoPO.setId(IdUtil.uuid());
		archivesInfoPO.setUpdateTime(archivesInfoPO.getCreatTime());
		archivesInfoPO.setArchivesCode(getArchivesCode(archivesInfoPO));
		archivesInfoDao.create(archivesInfoPO);
		
		birthArchivesInfoPO.setId(IdUtil.uuid());
		birthArchivesInfoPO.setCreatTime(archivesInfoPO.getCreatTime());
		birthArchivesInfoPO.setUpdateTime(birthArchivesInfoPO.getCreatTime());
		birthArchivesInfoPO.setArchivesId(archivesInfoPO.getId());
		birthArchivesInfoPO.setRiskSign("0");
		birthArchivesInfoPO.setReferralSign("0");
		birthArchivesInfoPO.setDeltetSign("1");
		birthArchivesInfoPO.setHospitalId(archivesInfoPO.getHospitalId());
		birthArchivesInfoDao.create(birthArchivesInfoPO);
		
		return archivesInfoPO;
	}

	/**
	 * 男性婚检管理
	 * @param conds
	 * @param page
	 */
	public void manListForPage(Map<String, Object> conds, Page<ArchivesInfoPO> page) {
		// TODO Auto-generated method stub
		page.setEntityOrField(true);
		conds.put("page", page);
		List<ArchivesInfoPO> list = archivesInfoDao.manListForPage(conds);
		page.setList(list);
	}


	/**
	 * 修改女性
	 * @param archivesInfoPO
	 * @throws Exception
	 */
	@Transactional
	public void updateWoman(ArchivesInfoPO archivesInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if (archivesInfoPO != null) {
			archivesInfoDao.updateWoman(archivesInfoPO);
		}
	}
	
	/**
	 * 修改男性
	 * @param archivesInfoPO
	 * @throws Exception
	 */
	public void updateMan(ArchivesInfoPO archivesInfoPO) throws Exception{
		// TODO Auto-generated method stub
		if (archivesInfoPO != null) {
			archivesInfoDao.updateMan(archivesInfoPO);
		}
	}


	/**
	 * 孕产妇管理修改
	 * @param archivesInfoPO
	 * @author yanwk
	 * @param birthArchivesInfoPO 
	 */
	@Transactional
	public void savePrenatalUpdate(ArchivesInfoPO archivesInfoPO) {
		if(archivesInfoPO != null){
			archivesInfoDao.savePrenatalUpdate(archivesInfoPO);
		}
		
	}


	/**
	 * 删除档案(修改删除状态为删除)
	 * @param archivesId
	 * @author yanwk
	 */
	@Transactional
	public void prenatalDelArchivesById(String archivesId) {
		archivesInfoDao.prenatalDelArchivesById(archivesId);
	}

}