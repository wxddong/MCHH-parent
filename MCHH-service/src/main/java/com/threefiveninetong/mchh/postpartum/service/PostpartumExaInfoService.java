/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.postpartum.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.service;

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

import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.postpartum.dao.PostpartumExaInfoDao;
import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.dto.PostHistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaDetailedInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaOtherInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumReferralInfoPO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: PostpartumExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
@Service
public class PostpartumExaInfoService {

	private static final Logger log =Logger.getLogger(PostpartumExaInfoService.class);
	
	@Resource
	private  PostpartumExaInfoDao  postpartumExaInfoDao;
	@Resource
	private BirthArchivesInfoService birthArchivesInfoService;
	@Resource
	private  PostpartumExaDetailedInfoService  postpartumExaDetailedInfoService;
	@Resource
	private  PostpartumExaOtherInfoService  postpartumExaOtherInfoService;
	@Resource
	private  PostpartumReferralInfoService  postpartumReferralInfoService;
	@Value("${doctorAdmin.id}")
	private String doctorAdminId;
	
	
	public String getDoctorAdminId(){
		return doctorAdminId;
	}

	/**
	 * 查找单个 
	 * @param id 
	 * @return PostpartumExaInfo 
	 */
	public PostpartumExaInfoPO find(Serializable id){
		return postpartumExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PostpartumExaInfoPO> 
	 */
	public List<PostpartumExaInfoPO> findAll(){
		return postpartumExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	@Transactional
	public void create(PostpartumExaInfoPO po) throws Exception{
		
			if( po != null ){
				if(po.getCreatTime()==null){
					po.setCreatTime(new Date());
					po.setNormalSign("1");
				}else{
					po.setNormalSign("0");
				}
				
				po.setUpdateTime(new Date());
				postpartumExaInfoDao.create(po);
			}
			
				
	}

	/**
	 * 修改 
	 * @param po
	 */
	@Transactional
	public void update(PostpartumExaInfoPO po) throws Exception{
			if( po != null )
				 postpartumExaInfoDao.update(po);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void delete(Serializable id) throws Exception{
		 postpartumExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	@Transactional
	public void deletes(Serializable[] id) throws Exception{
		postpartumExaInfoDao.deletes(id);
	}
	
	
	public void listForPage(Map<String, Object> conds, Page<PostpartumExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PostpartumExaInfoPO> list = postpartumExaInfoDao.listForPage(conds);
		page.setList(list);
	}

	/**
	 * 根据生育id获取产后检查的历史记录信息
	 * wangxd 2016.9.6
	 * @param birthArchivesId
	 * @return
	 */
	public List<PostHistoryCheckVO> getPostpartumHistoryChecks(String birthArchivesId) {
		List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoDao.getPostpartumHistoryChecks(birthArchivesId);
		if(postpartumHistoryChecks!=null && postpartumHistoryChecks.size()!=0 ){
			for (PostHistoryCheckVO postHistoryCheckVO : postpartumHistoryChecks) {
				String type = postHistoryCheckVO.getType();
				String resultSign = postHistoryCheckVO.getResultSign();
				if("0".equals(type)){
					if("0".equals(resultSign)){
						postHistoryCheckVO.setResult("未见异常");
					}
					if("1".equals(resultSign)){
						postHistoryCheckVO.setResult("异常");
					}
				}
				if("1".equals(type)){
					if("0".equals(resultSign)){
						postHistoryCheckVO.setResult("已恢复");
					}
					if("1".equals(resultSign)){
						postHistoryCheckVO.setResult("未恢复");
					}
				}
				String vulavaSign = postHistoryCheckVO.getVulavaSign();
				if("0".equals(vulavaSign)){
					postHistoryCheckVO.setVulava("未见异常");
				}
				if("1".equals(vulavaSign)){
					postHistoryCheckVO.setVulava("异常");
				}
				String vaginaSign = postHistoryCheckVO.getVaginaSign();
				if("0".equals(vaginaSign)){
					postHistoryCheckVO.setVagina("未见异常");
				}
				if("1".equals(vaginaSign)){
					postHistoryCheckVO.setVagina("异常");
				}
				String cervicalSign = postHistoryCheckVO.getCervicalSign();
				if("0".equals(cervicalSign)){
					postHistoryCheckVO.setCervical("未见异常");
				}
				if("1".equals(cervicalSign)){
					postHistoryCheckVO.setCervical("异常");
				}
				String breastSign = postHistoryCheckVO.getBreastSign();
				if("0".equals(breastSign)){
					postHistoryCheckVO.setBreast("未见异常");
				}
				if("1".equals(breastSign)){
					postHistoryCheckVO.setBreast("异常");
				}
				String uterusSign = postHistoryCheckVO.getUterusSign();
				if("0".equals(uterusSign)){
					postHistoryCheckVO.setUterus("未见异常");
				}
				if("1".equals(uterusSign)){
					postHistoryCheckVO.setUterus("异常");
				}
				String lochiaSign = postHistoryCheckVO.getLochiaSign();
				if("0".equals(lochiaSign)){
					postHistoryCheckVO.setLochia("未见异常");
				}
				if("1".equals(lochiaSign)){
					postHistoryCheckVO.setLochia("异常");
				}
				String woundSign = postHistoryCheckVO.getWoundSign();
				if("0".equals(woundSign)){
					postHistoryCheckVO.setWound("未见异常");
				}
				if("1".equals(woundSign)){
					postHistoryCheckVO.setWound("异常");
				}
				String referralSign = postHistoryCheckVO.getReferralSign();
				if("0".equals(referralSign)){
					postHistoryCheckVO.setReferral("-");
				}
				if("1".equals(referralSign)){
					postHistoryCheckVO.setReferral("转诊");
				}
			}
		}
		return postpartumHistoryChecks;
	}
	/**
	 * 根据生育id获取产后检查的历史记录信息
	 * wangxd 2016.9.6
	 * @param birthArchivesId
	 * @return
	 */
	public List<HistoryCheckVO> getPostHistoryChecks(String birthArchivesId) {
		List<HistoryCheckVO> historyCheckVOs = postpartumExaInfoDao.getPostHistoryChecks(birthArchivesId);
		if(historyCheckVOs!=null && historyCheckVOs.size()!=0 ){
			for (HistoryCheckVO historyCheckVO : historyCheckVOs) {
				historyCheckVO.setType("1");
			}
		}
		return historyCheckVOs;
	}

	/**
	 * 查询产后检查的主表信息
	 * wangxd 2016.9.8
	 * @param birthArchivesId
	 * @return
	 */
	public PostpartumExaInfoPO findPostpartumExa(String postpartumExaId) {
		return postpartumExaInfoDao.findPostpartumExa(postpartumExaId);
	}

	/**
	 * 根据生育id查询最新的完成添加的主信息表
	 * wangxd 2016.9.14
	 * @param postpartumExaId
	 * @return
	 */
	public PostpartumExaInfoPO findLatestPostpartumExa(String birthArchivesId) {
		return postpartumExaInfoDao.findLatestPostpartumExa(birthArchivesId);
	}

	/**
	 * 保存出院3-7天访视/42天健康检查
	 * @param postpartumExaInfoPO
	 * @param postpartumExaDetailedInfoPO
	 * @param postpartumExaOtherInfoPO
	 * @param postpartumReferralInfoPO
	 * @param closeCase
	 * @param save
	 * @throws Exception 
	 */
	@Transactional
	public void save(PostpartumExaInfoPO postpartumExaInfoPO, PostpartumExaDetailedInfoPO postpartumExaDetailedInfoPO,
			PostpartumExaOtherInfoPO postpartumExaOtherInfoPO, PostpartumReferralInfoPO postpartumReferralInfoPO,String birthArchivesId,
			String closeCase, String save,String depId) throws Exception {
		//如果要转诊的话，在生育档案表的数据库中插入一条转诊标识记录为3（产后转诊）
		if("1".equals(postpartumReferralInfoPO.getReferral())&&"1".equals(save)){
			BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
			birthArchivesInfoPO.setId(birthArchivesId);
			birthArchivesInfoPO.setReferralSign("3");
			//插入转诊时间
			birthArchivesInfoPO.setReferralTime(new Date());;
			//插入转入医院id(从前台传入的机构id)
			birthArchivesInfoPO.setInHospitalId(postpartumReferralInfoPO.getMechanism());
			//插入转出医院id(本院id，根据检查医生id获取)
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoPO.setUpdateTime(new Date());
			
			birthArchivesInfoService.updateReferralSign(birthArchivesInfoPO);
		}
		//如果closeCase为1就去结案
		if("1".equals(closeCase)&&"1".equals(save)){
			Map map =new HashMap();
			map.put("birthArchivesId", birthArchivesId);
			map.put("closeCaseReason", "0");
			birthArchivesInfoService.toCloseCase(map);
		}
		if(!"1".equals(closeCase)){
			//修改生育档案的生育状态为已分娩
			birthArchivesInfoService.toChangeStatue(birthArchivesId);
		}
			
			create(postpartumExaInfoPO);
			postpartumExaDetailedInfoService.create(postpartumExaDetailedInfoPO);
			postpartumExaOtherInfoService.create(postpartumExaOtherInfoPO);
			postpartumReferralInfoService.create(postpartumReferralInfoPO);
	}

	/**
	 * 编辑出院3-7天访视/42天健康检查后的修改
	 * @param postpartumExaInfoPO
	 * @param postpartumExaDetailedInfoPO
	 * @param postpartumExaOtherInfoPO
	 * @param postpartumReferralInfoPO
	 * @throws Exception 
	 */
	@Transactional
	public void update(PostpartumExaInfoPO postpartumExaInfoPO, PostpartumExaDetailedInfoPO postpartumExaDetailedInfoPO,
			PostpartumExaOtherInfoPO postpartumExaOtherInfoPO, PostpartumReferralInfoPO postpartumReferralInfoPO,String depId,String birthArchivesId,String closeCase,String save) throws Exception {
		//获取转诊标识  看是否转真  转诊的话修改档案表
		String referral = postpartumReferralInfoPO.getReferral();
		if("1".equals(referral)&&"1".equals(save)){
			BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
			birthArchivesInfoPO.setId(birthArchivesId);
			birthArchivesInfoPO.setReferralSign("3");
			//插入转诊时间
			birthArchivesInfoPO.setReferralTime(new Date());;
			//插入转入医院id(从前台传入的机构id)
			birthArchivesInfoPO.setInHospitalId(postpartumReferralInfoPO.getMechanism());
			//插入转出医院id(本院id，根据检查医生id获取)
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoPO.setUpdateTime(new Date());
			
			birthArchivesInfoService.updateReferralSign(birthArchivesInfoPO);
		}
		//如果closeCase为1就去结案
		if("1".equals(closeCase)&&"1".equals(save)){
			Map map =new HashMap();
			map.put("birthArchivesId", birthArchivesId);
			map.put("closeCaseReason", "0");
			birthArchivesInfoService.toCloseCase(map);
		}
		postpartumExaInfoPO.setUpdateTime(new Date());
		update(postpartumExaInfoPO);
		postpartumExaDetailedInfoService.update(postpartumExaDetailedInfoPO);
		postpartumExaOtherInfoService.update(postpartumExaOtherInfoPO);
		postpartumReferralInfoService.update(postpartumReferralInfoPO);
	}

	/**
	 * 通过生育id查找到所有的3-7天的检查记录
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public List<PostpartumExaInfoPO> getPost3To7ExaByBirthId(String birthArchivesId) {
		return postpartumExaInfoDao.getPost3To7ExaByBirthId(birthArchivesId);
	}

	/**
	 * 通过生育id查找到所有的42天的检查记录
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public List<PostpartumExaInfoPO> getPost42ExaByBirthId(String birthArchivesId) {
		return postpartumExaInfoDao.getPost42ExaByBirthId(birthArchivesId);
	}

	//当没有分娩信息而进入产后访视的时候，将生育档案的孕检状态改为已分娩
	@Transactional
	public void updateState(String birthArchivesId) {
		postpartumExaInfoDao.updateState(birthArchivesId);
		
	}

	public String getMechanismById(String mechanismId) {
		return postpartumExaInfoDao.getMechanismById(mechanismId);
	}

	


}