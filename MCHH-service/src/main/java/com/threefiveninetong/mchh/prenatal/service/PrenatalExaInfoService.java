/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalExaInfoService.java 
 * @Prject: MCHH-service
 * @Package: com.threefiveninetong.mchh.prenatal.service 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:40 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.service;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.archives.dao.ArchivesInfoDao;
import com.threefiveninetong.mchh.archives.dao.BirthArchivesInfoDao;
import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.config.dao.HighRiskPregnancyScoreDao;
import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;
import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;
import com.threefiveninetong.mchh.prenatal.dao.FirstGynecologicalExaInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.FirstMotherhoodInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.FirstPhysicalBloodStethoscopyInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.HighRiskInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.HighRiskTermDao;
import com.threefiveninetong.mchh.prenatal.dao.ObstetricExaInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.PrenatalExaInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.PrenatalReferralInfoDao;
import com.threefiveninetong.mchh.prenatal.dao.SupplementaryExamInfoDao;
import com.threefiveninetong.mchh.prenatal.po.FirstGynecologicalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.FirstMotherhoodInfoPO;
import com.threefiveninetong.mchh.prenatal.po.FirstPhysicalBloodStethoscopyInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;
import com.threefiveninetong.mchh.prenatal.po.SupplementaryExamInfoPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;


/**
 * @ClassName: PrenatalExaInfoService 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:40 
 */
@Service
public class PrenatalExaInfoService {

	private static final Logger log =Logger.getLogger(PrenatalExaInfoService.class);
	
	@Resource
	private  PrenatalExaInfoDao  prenatalExaInfoDao;
	

	@Resource
	private  HighRiskInfoDao  highRiskInfoDao;
	
	@Resource
	private  HighRiskTermDao  highRiskTermDao;

	@Value("${admin.id}")
	private String adminId;
	
	@Value("${doctorAdmin.id}")
	private String doctorAdminId;

	@Resource
	private FirstMotherhoodInfoDao firstMotherhoodInfoDao;
	
	@Resource
	private FirstPhysicalBloodStethoscopyInfoDao firstPhysicalBloodStethoscopyInfoDao;
	
	@Resource
	private FirstGynecologicalExaInfoDao firstGynecologicalExaInfoDao;
	
	@Resource
	private SupplementaryExamInfoDao supplementaryExamInfoDao;
	
	@Resource
	private PrenatalReferralInfoDao prenatalReferralInfoDao;
	
	@Resource
	private ArchivesInfoDao archivesInfoDao;
	
	@Resource
	private BirthArchivesInfoDao birthArchivesInfoDao;
	
	@Resource
	private HighRiskPregnancyScoreDao highRiskPregnancyScoreDao;
	
	@Resource
	private ObstetricExaInfoDao obstetricExaInfoDao;
	
	/**
	 * 查找单个 
	 * @param id 
	 * @return PrenatalExaInfo 
	 */
	public PrenatalExaInfoPO find(Serializable id){
		return prenatalExaInfoDao.find(id);	
	}

	/**
	 * 查找所有 
	 * @return List<PrenatalExaInfoPO> 
	 */
	public List<PrenatalExaInfoPO> findAll(){
		return prenatalExaInfoDao.findAll();	
	}

	/**
	 * 创建 
	 * @param po 
	 */
	public void create(PrenatalExaInfoPO po) throws Exception{
		
			if( po != null )
				 prenatalExaInfoDao.create(po);
	}

	/**
	 * 修改 
	 * @param po
	 */
	public void update(PrenatalExaInfoPO po) throws Exception{

			if( po != null )
				 prenatalExaInfoDao.update(po);

	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable id) throws Exception{
		 prenatalExaInfoDao.delete(id);
	}

	/**
	 * 删除 
	 * @param id 
	 */
	public void deletes(Serializable[] id) throws Exception{
		prenatalExaInfoDao.deletes(id);
	}
	
	
	/**
	 * 导出数据专用
	 * @param conds
	 * @return
	 * @author yanwk
	 */
	public List<PrenatalExaInfoPO> getListByMap(Map<String, Object> conds){
		
		String endTime = String.valueOf(conds.get("endTime"));
		conds.put("endTime", DateUtil.addDay(endTime, 1));// 将截止日期增加一天，增加查询的精确度
		String endCheckTime = String.valueOf(conds.get("endCheckTime"));
		conds.put("endCheckTime", DateUtil.addDay(endCheckTime, 1));// 将截止日期增加一天，增加查询的精确度
		String endNextTime = String.valueOf(conds.get("endNextTime"));
		conds.put("endNextTime", DateUtil.addDay(endNextTime, 1));// 将截止日期增加一天，增加查询的精确度

		/*String name = String.valueOf(conds.get("name"));
		try {
			name = new String(name.getBytes("UTF-8"),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		
		List<PrenatalExaInfoPO> list = new ArrayList<>();
		if(conds.get("name") != null && conds.get("name") != ""){
			conds.put("name", "%"+conds.get("name")+"%");
		}
		
		if("-1".equals(conds.get("prenstate"))){
			conds.put("prenstate", null);
		}
		if("-1".equals(conds.get("birthState"))){
			conds.put("birthState", null);
		}
		if("-1".equals(conds.get("closeReasion"))){
			conds.put("closeReasion", null);
		}
		if("-1".equals(conds.get("closeState"))){
			conds.put("closeState", null);
		}
		if(conds.get("closeState") != null && conds.get("closeState")!= ""){
			if("1".equals(conds.get("closeState"))){
				
				conds.put("closeReasion", null);
				conds.put("closeState1", "2");
			}else if("2".equals(conds.get("closeState"))){
				conds.put("birthState", "2");
				//conds.put("closeState2", "2");
			}else{
				conds.put("birthState", null);
				conds.put("closeReasion", null);
			}
		}
		
		if(conds.get("villageMechanism") != null && conds.get("villageMechanism") != ""){
			conds.put("hospotilId", conds.get("villageMechanism"));
			
		}else if(conds.get("townMechanism")!= null && conds.get("townMechanism") != ""){
			conds.put("hospotilId", conds.get("townMechanism"));
		}else if(conds.get("countyMechanism")!= null && conds.get("countyMechanism") != ""){
			conds.put("hospotilId", conds.get("countyMechanism"));
		}else{
			conds.put("hospotilId", null);
		}
		
		if("0".equals(conds.get("prenstate"))){
			conds.put("prenataState", "0");
		}else if("1".equals(conds.get("prenstate"))){
			conds.put("prenataState", "1");
		}else if("2".equals(conds.get("prenstate"))){
			conds.put("leave", "1");
		}else if("3".equals(conds.get("prenstate"))){
			conds.put("post", "1");
		}
		
		if("1".equals(conds.get("sign"))){
			list = prenatalExaInfoDao.queryListForPage(conds);
		}else if(conds.get("sign") == null){
			
			list = prenatalExaInfoDao.listForPage(conds);
		}
		
		for (PrenatalExaInfoPO prenatalExaInfoPO : list) {
			
			ChildbirthBasicInfoPO childBasic = prenatalExaInfoPO.getBirthArchivesInfoPO().getChildbirthBasicInfoPO();
			
			PostpartumExaInfoPO postExa = prenatalExaInfoPO.getBirthArchivesInfoPO().getPostpartumExaInfoPO();
			
if(childBasic != null && childBasic.getChildbirthReferralInfoPO() != null){
				
				if(postExa!= null && postExa.getPostpartumReferralInfoPO() != null){
					if(prenatalExaInfoPO.getPrenatalReferralInfoPO() == null){
						PrenatalReferralInfoPO p = new PrenatalReferralInfoPO();
						p.setNextFollowingDate(postExa.getPostpartumReferralInfoPO().getNextFollowingDate());
						prenatalExaInfoPO.setPrenatalReferralInfoPO(p);
					}else{
						prenatalExaInfoPO.getPrenatalReferralInfoPO().setNextFollowingDate(postExa.getPostpartumReferralInfoPO().getNextFollowingDate());
					}
				} else {
					if(prenatalExaInfoPO.getPrenatalReferralInfoPO() == null){
						PrenatalReferralInfoPO p = new PrenatalReferralInfoPO();
						p.setNextFollowingDate(childBasic.getChildbirthReferralInfoPO().getNextFollowingDate());
						prenatalExaInfoPO.setPrenatalReferralInfoPO(p);
					}else{
						prenatalExaInfoPO.getPrenatalReferralInfoPO().setNextFollowingDate(childBasic.getChildbirthReferralInfoPO().getNextFollowingDate());
					}
				}
				if(childBasic.getLeaveDate() == null){
					prenatalExaInfoPO.getBirthArchivesInfoPO().getChildbirthBasicInfoPO().setLeaveDate(null);
				}
			}else{
				ChildbirthBasicInfoPO basicInfoPO = new ChildbirthBasicInfoPO();
				basicInfoPO.setLeaveDate(null);
				prenatalExaInfoPO.getBirthArchivesInfoPO().setChildbirthBasicInfoPO(basicInfoPO);
			}
			
			if(childBasic != null &&childBasic.getCreatTime() != null){
				if(postExa != null && postExa.getCreatTime() != null){
					prenatalExaInfoPO.setCreatTime(postExa.getCreatTime());
				}else{
					prenatalExaInfoPO.setCreatTime(childBasic.getCreatTime());
				}
			}
			
			if(childBasic != null && childBasic.getOperatorPO() != null){
				if(postExa != null && postExa.getOperatorPO() != null){
					prenatalExaInfoPO.getOperatorPO().setRealName(postExa.getOperatorPO().getRealName());
				}else{
					prenatalExaInfoPO.getOperatorPO().setRealName(childBasic.getOperatorPO().getRealName());
				}
			}
			
			/*if(prenatalExaInfoPO.getCreatTime() == null ){
				prenatalExaInfoPO.setCreatTime(prenatalExaInfoPO.getBirthArchivesInfoPO().getArchivesInfoPO().getCreatTime());
			}*/
			/*if(prenatalExaInfoPO.getOperatorPO() == null){
				OperatorPO op = new OperatorPO();
				op.setRealName(prenatalExaInfoPO.getBirthArchivesInfoPO().getArchivesInfoPO().getOperatorPO().getRealName());
				prenatalExaInfoPO.setOperatorPO(op);
			}*/
		}
		
		
		return list;
	}
	/**
	 * 权限相关
	 * @return
	 * @author yanwk
	 */
	public String getAdminId(){
		return adminId;
	}
	/**
	 * 权限相关
	 * @return
	 * @author yanwk
	 */
	public String getDoctorAdminId(){
		return doctorAdminId;
	}
	/**
	 * 孕产妇管理查询
	 * @param conds
	 * @param page
	 * @author yanwk
	 */
	public void listForPage(Map<String, Object> conds, Page<PrenatalExaInfoPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		
		String endTime = String.valueOf(conds.get("endTime"));
		conds.put("endTime", DateUtil.addDay(endTime, 1));// 将截止日期增加一天，增加查询的精确度
		String endCheckTime = String.valueOf(conds.get("endCheckTime"));
		conds.put("endCheckTime", DateUtil.addDay(endCheckTime, 1));// 将截止日期增加一天，增加查询的精确度
		String endNextTime = String.valueOf(conds.get("endNextTime"));
		conds.put("endNextTime", DateUtil.addDay(endNextTime, 1));// 将截止日期增加一天，增加查询的精确度
		
		if(conds.get("name") != null && conds.get("name") != ""){
			conds.put("name", "%"+conds.get("name")+"%");
		}
		
		if("-1".equals(conds.get("prenstate"))){
			conds.put("prenstate", null);
		}
		if("-1".equals(conds.get("birthState"))){
			conds.put("birthState", null);
		}
		if("-1".equals(conds.get("closeReasion"))){
			conds.put("closeReasion", null);
		}
		if("-1".equals(conds.get("closeState"))){
			conds.put("closeState", null);
		}
		if(conds.get("closeState") != null && conds.get("closeState")!= ""){
			if("1".equals(conds.get("closeState"))){
				
				conds.put("closeReasion", null);
				conds.put("closeState1", "2");
			}else if("2".equals(conds.get("closeState"))){
				conds.put("birthState", "2");
				//conds.put("closeState2", "2");
			}else{
				conds.put("birthState", null);
				conds.put("closeReasion", null);
			}
		}
		
		if(conds.get("villageMechanism") != null && conds.get("villageMechanism") != ""){
			conds.put("hospotilId", conds.get("villageMechanism"));
			
		}else if(conds.get("townMechanism")!= null && conds.get("townMechanism") != ""){
			conds.put("hospotilId", conds.get("townMechanism"));
		}else if(conds.get("countyMechanism")!= null && conds.get("countyMechanism") != ""){
			conds.put("hospotilId", conds.get("countyMechanism"));
		}else{
			conds.put("hospotilId", null);
		}
		
		if("0".equals(conds.get("prenstate"))){
			conds.put("prenataState", "0");
		}else if("1".equals(conds.get("prenstate"))){
			conds.put("prenataState", "1");
		}else if("2".equals(conds.get("prenstate"))){
			conds.put("leave", "1");
		}else if("3".equals(conds.get("prenstate"))){
			conds.put("post", "1");
		}
		
		List<PrenatalExaInfoPO> list = new ArrayList<>();
 		if("1".equals(conds.get("sign"))){
			list = prenatalExaInfoDao.queryListForPage(conds);
		}else if(conds.get("sign") == null){
			
			list = prenatalExaInfoDao.listForPage(conds);
		}
		
		for (PrenatalExaInfoPO prenatalExaInfoPO : list) {
			
			ChildbirthBasicInfoPO childBasic = prenatalExaInfoPO.getBirthArchivesInfoPO().getChildbirthBasicInfoPO();
			
			PostpartumExaInfoPO postExa = prenatalExaInfoPO.getBirthArchivesInfoPO().getPostpartumExaInfoPO();
			
			if(childBasic != null && childBasic.getChildbirthReferralInfoPO() != null){
				
				if(postExa!= null && postExa.getPostpartumReferralInfoPO() != null){
					if(prenatalExaInfoPO.getPrenatalReferralInfoPO() == null){
						PrenatalReferralInfoPO p = new PrenatalReferralInfoPO();
						p.setNextFollowingDate(postExa.getPostpartumReferralInfoPO().getNextFollowingDate());
						prenatalExaInfoPO.setPrenatalReferralInfoPO(p);
					}else{
						prenatalExaInfoPO.getPrenatalReferralInfoPO().setNextFollowingDate(postExa.getPostpartumReferralInfoPO().getNextFollowingDate());
					}
				} else {
					if(prenatalExaInfoPO.getPrenatalReferralInfoPO() == null){
						PrenatalReferralInfoPO p = new PrenatalReferralInfoPO();
						p.setNextFollowingDate(childBasic.getChildbirthReferralInfoPO().getNextFollowingDate());
						prenatalExaInfoPO.setPrenatalReferralInfoPO(p);
					}else{
						prenatalExaInfoPO.getPrenatalReferralInfoPO().setNextFollowingDate(childBasic.getChildbirthReferralInfoPO().getNextFollowingDate());
					}
				}
				if(childBasic.getLeaveDate() == null){
					prenatalExaInfoPO.getBirthArchivesInfoPO().getChildbirthBasicInfoPO().setLeaveDate(null);
				}
			}else{
				ChildbirthBasicInfoPO basicInfoPO = new ChildbirthBasicInfoPO();
				basicInfoPO.setLeaveDate(null);
				prenatalExaInfoPO.getBirthArchivesInfoPO().setChildbirthBasicInfoPO(basicInfoPO);
			}
			
			if(childBasic != null &&childBasic.getCreatTime() != null){
				if(postExa != null && postExa.getCreatTime() != null){
					prenatalExaInfoPO.setCreatTime(postExa.getCreatTime());
				}else{
					prenatalExaInfoPO.setCreatTime(childBasic.getCreatTime());
				}
			}
			
			if(childBasic != null && childBasic.getOperatorPO() != null){
				if(postExa != null && postExa.getOperatorPO() != null){
					OperatorPO operatorPO = new OperatorPO();
					operatorPO.setRealName(postExa.getOperatorPO().getRealName());
					prenatalExaInfoPO.setOperatorPO(operatorPO);
					//prenatalExaInfoPO.getOperatorPO().setRealName(postExa.getOperatorPO().getRealName());
				}else{
					OperatorPO operatorPO = new OperatorPO();
					operatorPO.setRealName(childBasic.getOperatorPO().getRealName());
					prenatalExaInfoPO.setOperatorPO(operatorPO);
					//prenatalExaInfoPO.getOperatorPO().setRealName(childBasic.getOperatorPO().getRealName());
				}
			}
			
			/*if(prenatalExaInfoPO.getCreatTime() == null ){
				prenatalExaInfoPO.setCreatTime(prenatalExaInfoPO.getBirthArchivesInfoPO().getArchivesInfoPO().getCreatTime());
			}
			if(prenatalExaInfoPO.getOperatorPO() == null){
				OperatorPO op = new OperatorPO();
				op.setRealName(prenatalExaInfoPO.getBirthArchivesInfoPO().getArchivesInfoPO().getOperatorPO().getRealName());
				prenatalExaInfoPO.setOperatorPO(op);
			}*/
		}

		
		page.setList(list);
	}


	/**
	 * wangxd 2016.9.5
	 * 获取第一次产检历史检查记录的数据用于历史检查记录列表的显示
	 * @return
	 */
	public HistoryCheckVO getFirstHistoryCheck(String birthArchivesId) {
		//先获取第一次产检的产检id
		String firstId = prenatalExaInfoDao.getFirstId(birthArchivesId);
		HistoryCheckVO firstHistoryCheck = null;
		//若第一次检查不为空的情况下区查询
		if(firstId!=null){
			//根据第一次产检的id获取第一次产检信息赋值给历史检查记录的VO
			firstHistoryCheck = prenatalExaInfoDao.getFirstHistoryCheck(firstId);
			firstHistoryCheck.setType("0");
			
			if("-1".equals(firstHistoryCheck.getBloodGlucose())){
				firstHistoryCheck.setBloodGlucose("未检查");
			}
			//获取第一次检查的体重和血压高低值，如果体重 和血压值为空的话 则不是第一次访视，直接进的第二次访视
			if(firstHistoryCheck.getBloodHi()==null || "".equals(firstHistoryCheck.getBloodHi().trim())||firstHistoryCheck.getBloodLow()==null||"".equals(firstHistoryCheck.getBloodLow().trim())||firstHistoryCheck.getWeight()==null||"".equals(firstHistoryCheck.getWeight().trim())){
				//区第2~N次随访表理查询血压和体重  还有宫高 腹围 胎位 胎心率
				ObstetricExaInfoPO obstetricExaInfoPO = obstetricExaInfoDao.getObstetricExaInfo(firstId);
				firstHistoryCheck.setBloodHi(obstetricExaInfoPO.getBloodHi());
				firstHistoryCheck.setBloodLow(obstetricExaInfoPO.getBloodLow());
				firstHistoryCheck.setWeight(obstetricExaInfoPO.getWeight());
				firstHistoryCheck.setUterusHight(obstetricExaInfoPO.getUterusHight());
				firstHistoryCheck.setAbdomen(obstetricExaInfoPO.getAbdomen());
				firstHistoryCheck.setFetusPosition(obstetricExaInfoPO.getFetusPosition());
				firstHistoryCheck.setHeartRate(obstetricExaInfoPO.getHeartRate());
			}
			
			//根据第一次产检的id得到高危管理表
			HighRiskInfoPO highRiskInfoPO = highRiskInfoDao.getHighRiskByprenatalExaId(firstId);
			if(highRiskInfoPO!=null){
				//获取高危值赋值给第一次产检记录
				firstHistoryCheck.setScore(highRiskInfoPO.getScore());
				//根据高危管理的id查找高危因素的集合，并且拼接为字符串，赋值给第一次检查记录的高危因素
				String highRiskId = highRiskInfoPO.getId();
				List<String> items = highRiskTermDao.getItemsByHighRiskId(highRiskId);	
				//将高危项集合转化为字符串赋值给高危因素
				firstHistoryCheck.setHighRisk(StringUtil.listToString(items));
			}
			//获取末次月经算出预产期
			Date lastMenses = birthArchivesInfoDao.getLastMensesByBirthArchivesId(birthArchivesId);
			Date checkDate = firstHistoryCheck.getCheckDate();
			if(lastMenses!=null && checkDate!=null){
				int weeks = DateUtils.getWeekByLastMenses(lastMenses,checkDate);
				String pregnancyWeeks =weeks+"";
				firstHistoryCheck.setPregnancyWeeks(pregnancyWeeks);
			}
			//将所有的肝功、肾功、免疫取出放入List<String>中然后将其转化为以逗号隔开的字符串再赋值给第一次检查历史记录的others
			List<String> otherList = new ArrayList<String>();
			if(firstHistoryCheck.getSgpt() != null && firstHistoryCheck.getSgpt() != ""){
				if("-1".equals(firstHistoryCheck.getSgpt())){
					firstHistoryCheck.setSgpt("未检查");
				}
				otherList.add("血清谷丙转氨酶:"+firstHistoryCheck.getSgpt());
			}
			if(firstHistoryCheck.getSgot() != null && firstHistoryCheck.getSgot() != "" ){
				if("-1".equals(firstHistoryCheck.getSgot())){
					firstHistoryCheck.setSgot("未检查");
				}
				otherList.add("血清谷草转氨酶:"+firstHistoryCheck.getSgot());
			}
			if(firstHistoryCheck.getAlbumin() != null && firstHistoryCheck.getAlbumin() != ""){
				if("-1".equals(firstHistoryCheck.getAlbumin())){
					firstHistoryCheck.setAlbumin("未检查");
				}
				otherList.add("白蛋白:"+firstHistoryCheck.getAlbumin());
			}
			if(firstHistoryCheck.getTotalBilirubin() != null && firstHistoryCheck.getTotalBilirubin() != ""){
				if("-1".equals(firstHistoryCheck.getTotalBilirubin())){
					firstHistoryCheck.setTotalBilirubin("未检查");
				}
				otherList.add("总胆红素:"+firstHistoryCheck.getTotalBilirubin());
			}
			if(firstHistoryCheck.getDbil() != null && firstHistoryCheck.getDbil() != ""){
				if("-1".equals(firstHistoryCheck.getDbil())){
					firstHistoryCheck.setDbil("未检查");
				}
				otherList.add("综合胆红素:"+firstHistoryCheck.getDbil());
			}
			if(firstHistoryCheck.getScr() != null && firstHistoryCheck.getScr() != ""){
				if("-1".equals(firstHistoryCheck.getScr())){
					firstHistoryCheck.setScr("未检查");
				}
				otherList.add("血清肌酐:"+firstHistoryCheck.getScr());
			}
			if(firstHistoryCheck.getBun() != null && firstHistoryCheck.getBun() != ""){
				if("-1".equals(firstHistoryCheck.getBun())){
					firstHistoryCheck.setBun("未检查");
				}
				otherList.add("血尿素氮:"+firstHistoryCheck.getBun());
			}
			if(firstHistoryCheck.getImmune() != null && firstHistoryCheck.getImmune() != ""){
				otherList.add("免疫:"+firstHistoryCheck.getImmune());
			}
			String others = StringUtil.listToString(otherList);
			firstHistoryCheck.setOthers(others);
		}
		
		return firstHistoryCheck;
	}


	
	/**
	 * 第一次产检保存数据
	 * @param archivesCode
	 * @param firstMotherhoodInfoPO
	 * @param firstPhysicalBloodStethoscopyInfoPO
	 * @param firstGynecologicalExaInfoPO
	 * @param supplementaryExamInfoPO
	 * @param prenatalExaInfoPO
	 * @param prenatalReferralInfoPO
	 * @author yanwk
	 */
	@Transactional
	public String firstPrenatalExa(String archivesCode, String birthArchivesId,
								FirstMotherhoodInfoPO firstMotherhoodInfoPO,
								FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO,
								FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO, 
								SupplementaryExamInfoPO supplementaryExamInfoPO,
								PrenatalExaInfoPO prenatalExaInfoPO,
								PrenatalReferralInfoPO prenatalReferralInfoPO,
								String highRiskId,
								String depId) {
		ArchivesInfoPO archivesInfoPO = archivesInfoDao.getArchivesByArchivesCode(archivesCode);
		String pregnantState = "0";
		BirthArchivesInfoPO birthArchivesInfoPO1 = new BirthArchivesInfoPO();
		birthArchivesInfoPO1.setArchivesId(archivesInfoPO.getId());
		birthArchivesInfoPO1.setPregnantState(pregnantState);
		birthArchivesInfoPO1.setId(birthArchivesId);
		//Date lastMenses = firstMotherhoodInfoPO.getLastMenses();
		birthArchivesInfoPO1.setUpdateTime(new Date());
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoDao.getBirthArchivesByArchivesIdAndState(birthArchivesInfoPO1);
		String evaluate = prenatalExaInfoPO.getEvaluate();
		if(("1").equals(evaluate)){
			if(("0").equals(birthArchivesInfoPO.getRiskSign())){
				//修改生育档案表高危标识为“1”，修改第一次出现高危的筛查时间
				birthArchivesInfoPO.setRiskSign("1");
				birthArchivesInfoPO.setScreeningDate(new Date());
				birthArchivesInfoDao.updateRiskSign(birthArchivesInfoPO);
			}
		}
		
		//如果是转诊的话修改生育档案表的转诊状态为孕检转诊
		if("1".equals(prenatalExaInfoPO.getEditStatus())){
			if("1".equals(prenatalReferralInfoPO.getReferral())){
				birthArchivesInfoPO.setReferralSign("1");
				birthArchivesInfoPO.setReferralTime(new Date());
				birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
				birthArchivesInfoPO.setOutHospitalId(depId);
				birthArchivesInfoPO.setUpdateTime(new Date());
				birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
			}
		}
		prenatalExaInfoPO.setBirthArchivesId(birthArchivesInfoPO.getId());
		prenatalExaInfoPO.setId(IdUtil.uuid());
		
		firstMotherhoodInfoPO.setId(IdUtil.uuid());
		firstMotherhoodInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		
		firstPhysicalBloodStethoscopyInfoPO.setId(IdUtil.uuid());
		firstPhysicalBloodStethoscopyInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		firstGynecologicalExaInfoPO.setId(IdUtil.uuid());
		firstGynecologicalExaInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		supplementaryExamInfoPO.setId(IdUtil.uuid());
		supplementaryExamInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		prenatalReferralInfoPO.setId(IdUtil.uuid());
		prenatalReferralInfoPO.setPreId(prenatalExaInfoPO.getId());
		
		firstMotherhoodInfoDao.create(firstMotherhoodInfoPO);
		firstPhysicalBloodStethoscopyInfoDao.create(firstPhysicalBloodStethoscopyInfoPO);
		firstGynecologicalExaInfoDao.create(firstGynecologicalExaInfoPO);
		supplementaryExamInfoDao.create(supplementaryExamInfoPO);
		prenatalExaInfoDao.create(prenatalExaInfoPO);
		prenatalReferralInfoDao.create(prenatalReferralInfoPO);
		
		if(!("").equals(highRiskId) && highRiskId != null){
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			
			highRiskInfoPO.setExaminationId(prenatalExaInfoPO.getId());
			highRiskInfoPO.setId(highRiskId);
			
			highRiskInfoDao.savePrenatalExaId(highRiskInfoPO);
			
		}
		return prenatalExaInfoPO.getId();
	}

	/**
	 * 保存专案管理高危项并返回Id
	 * @param highRiskInfoPO
	 * @param params
	 * @return
	 * @author yanwk
	 */
	@Transactional
	public String saveProjectManager(HighRiskInfoPO highRiskInfoPO, Map<String, Object> params) {
		
		highRiskInfoPO.setId(IdUtil.uuid());
		
		Set<Entry<String,Object>> entrySet = params.entrySet();
		int score = 0;
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			if(key.startsWith("_")){
				String correct = (String) params.get(key.substring(1));
				String id = (String) params.get(key);
				HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreDao.find(id);
				
				HighRiskTermPO highRiskTermPO = new HighRiskTermPO();
				highRiskTermPO.setId(IdUtil.uuid());
				highRiskTermPO.setHighRisk(highRiskPregnancyScorePO.getName());
				highRiskTermPO.setTermId(highRiskPregnancyScorePO.getId());
				highRiskTermPO.setHighRiskId(highRiskInfoPO.getId());
				if("1".equals(correct)){
					
					Date date = new Date();
					highRiskTermPO.setCorrectionTime(date);
					highRiskTermPO.setCorrect("1");
				}else if("0".equals(correct)){
					highRiskTermPO.setCorrect(correct);
					score += Integer.parseInt(highRiskPregnancyScorePO.getScore());
				}
				highRiskTermPO.setStatus(highRiskPregnancyScorePO.getStatus());
				highRiskTermPO.setScore(highRiskPregnancyScorePO.getScore());
				
				highRiskTermDao.create(highRiskTermPO);
			}
			
		}
		
		highRiskInfoPO.setScore(score+"");
		
		highRiskInfoDao.create(highRiskInfoPO);
		
		return highRiskInfoPO.getId();
	}

	/**
	 * 通过生育表id查产检表共有几条数据来判断是第几次产检
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public int countPrenatalByBirthId(String id) {
		return prenatalExaInfoDao.countPrenatalByBirthId(id);
	}


	/**
	 * 获取第2-N次产前检查记录的信息，用于历史检查记录列表的显示
	 * @param birthArchivesId
	 * @return
	 */
	public List<HistoryCheckVO> getSecondOrMoreHistoryChecks(String birthArchivesId) {
		//先获取第一次产检的产检id
		String firstId = prenatalExaInfoDao.getFirstId(birthArchivesId);
		//根据第一次产检的id和生育档案id获取id不是第一次产检的所有产前检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = null;
		if(firstId!=null){
			secondOrMoreHistoryChecks = prenatalExaInfoDao.getSecondOrMoreHistoryChecks(firstId,birthArchivesId);
			if(secondOrMoreHistoryChecks !=null && secondOrMoreHistoryChecks.size()!=0){
				for (HistoryCheckVO historyCheckVO : secondOrMoreHistoryChecks) {
					historyCheckVO.setType("0");
					//获取产检的id
					String checkId = historyCheckVO.getCheckId();
					//根据第一次产检的id得到高危管理表
					HighRiskInfoPO highRiskInfo = highRiskInfoDao.getHighRiskByprenatalExaId(checkId);
					if(highRiskInfo!=null){
						//获取高危值赋值给产检记录
						historyCheckVO.setScore(highRiskInfo.getScore());
						//根据高危管理的id查找高危因素的集合，并且拼接为字符串，赋值给第一次检查记录的高危因素
						String highRiskId = highRiskInfo.getId();
						List<String> items = highRiskTermDao.getItemsByHighRiskId(highRiskId);	
						//将高危项集合转化为字符串赋值给高危因素
						historyCheckVO.setHighRisk(StringUtil.listToString(items));
					}
					
					//获取末次月经算出预产期
					Date lastMenses = birthArchivesInfoDao.getLastMensesByBirthArchivesId(birthArchivesId);
					Date checkDate = historyCheckVO.getCheckDate();
					if(lastMenses!=null && checkDate!=null){
						int weeks = DateUtils.getWeekByLastMenses(lastMenses,checkDate);
						String pregnancyWeeks =weeks+"";
						historyCheckVO.setPregnancyWeeks(pregnancyWeeks);
					}
					
					if("-1".equals(historyCheckVO.getBloodGlucose())){
						historyCheckVO.setBloodGlucose("未检查");
					}
					
					//将所有的肝功、肾功、免疫取出放入List<String>中然后将其转化为以逗号隔开的字符串再赋值给第一次检查历史记录的others
					List<String> otherList = new ArrayList<String>();
					if(historyCheckVO.getSgpt() != null && historyCheckVO.getSgpt() != ""){
						if("-1".equals(historyCheckVO.getSgpt())){
							historyCheckVO.setSgpt("未检查");
						}
						otherList.add("血清谷丙转氨酶:"+historyCheckVO.getSgpt());
					}
					if(historyCheckVO.getSgot() != null && historyCheckVO.getSgot() != "" ){
						if("-1".equals(historyCheckVO.getSgot())){
							historyCheckVO.setSgot("未检查");
						}
						otherList.add("血清谷草转氨酶:"+historyCheckVO.getSgot());
					}
					if(historyCheckVO.getAlbumin() != null && historyCheckVO.getAlbumin() != ""){
						if("-1".equals(historyCheckVO.getAlbumin())){
							historyCheckVO.setAlbumin("未检查");
						}
						otherList.add("白蛋白:"+historyCheckVO.getAlbumin());
					}
					if(historyCheckVO.getTotalBilirubin() != null && historyCheckVO.getTotalBilirubin() != ""){
						if("-1".equals(historyCheckVO.getTotalBilirubin())){
							historyCheckVO.setTotalBilirubin("未检查");
						}
						otherList.add("总胆红素:"+historyCheckVO.getTotalBilirubin());
					}
					if(historyCheckVO.getDbil() != null && historyCheckVO.getDbil() != ""){
						if("-1".equals(historyCheckVO.getDbil())){
							historyCheckVO.setDbil("未检查");
						}
						otherList.add("综合胆红素:"+historyCheckVO.getDbil());
					}
					if(historyCheckVO.getScr() != null && historyCheckVO.getScr() != ""){
						if("-1".equals(historyCheckVO.getScr())){
							historyCheckVO.setScr("未检查");
						}
						otherList.add("血清肌酐:"+historyCheckVO.getScr());
					}
					if(historyCheckVO.getBun() != null && historyCheckVO.getBun() != ""){
						if("-1".equals(historyCheckVO.getBun())){
							historyCheckVO.setBun("未检查");
						}
						otherList.add("血尿素氮:"+historyCheckVO.getBun());
					}
					if(historyCheckVO.getImmune() != null && historyCheckVO.getImmune() != ""){
						otherList.add("免疫:"+historyCheckVO.getImmune());
					}
					String others = StringUtil.listToString(otherList);
					historyCheckVO.setOthers(others);
				}
			}
		}
		
		
		
		return secondOrMoreHistoryChecks;
	}

	/**
	 * 获取第一次产检信息
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public PrenatalExaInfoPO getPrenatalExaByBirthArchivesId(String birthArchivesId) {
		return prenatalExaInfoDao.getPrenatalExaByBirthArchivesId(birthArchivesId);
	}

	/**
	 * 获取第一次产前检查Id
	 * @param id
	 * @return
	 */
	public String getFirstPrenatalExaId(String id) {
		return prenatalExaInfoDao.getFirstId(id);
	}

	/**
	 * 2~N次产前随访保存
	 * @param archivesCode
	 * @param obstetricExaInfoPO
	 * @param supplementaryExamInfoPO
	 * @param prenatalExaInfoPO
	 * @param prenatalReferralInfoPO
	 * @param highRiskId
	 * @author yanwk
	 */
	@Transactional
	public String prenatalExa2ToN(String archivesCode, ObstetricExaInfoPO obstetricExaInfoPO,
			SupplementaryExamInfoPO supplementaryExamInfoPO, PrenatalExaInfoPO prenatalExaInfoPO,
			PrenatalReferralInfoPO prenatalReferralInfoPO, String highRiskId,String depId) {
		ArchivesInfoPO archivesInfoPO = archivesInfoDao.getArchivesByArchivesCode(archivesCode);
		String pregnantState = "0";
		BirthArchivesInfoPO birthArchivesInfoPO1 = new BirthArchivesInfoPO();
		birthArchivesInfoPO1.setArchivesId(archivesInfoPO.getId());
		birthArchivesInfoPO1.setPregnantState(pregnantState);
		
		//通过档案id和妊娠状态是妊娠中（状态pregnatState=0）找到生育档案
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoDao.getBirthArchivesByArchivesIdAndState(birthArchivesInfoPO1);
		
		String evaluate = prenatalExaInfoPO.getEvaluate();
		if(("1").equals(evaluate)){
			if(("0").equals(birthArchivesInfoPO.getRiskSign())){
				//修改生育档案表高危标识为“1”，修改第一次出现高危的筛查时间
				birthArchivesInfoPO.setRiskSign("1");
				birthArchivesInfoPO.setScreeningDate(new Date());
				birthArchivesInfoDao.updateRiskSign(birthArchivesInfoPO);
			}
		}
		//如果是转诊的话修改生育档案表的转诊状态、转诊时间、转出医院、转入医院
		if("1".equals(prenatalExaInfoPO.getEditStatus())){
			if("1".equals(prenatalReferralInfoPO.getReferral())){
				birthArchivesInfoPO.setReferralSign("1");
				birthArchivesInfoPO.setReferralTime(new Date());
				birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
				birthArchivesInfoPO.setOutHospitalId(depId);
				birthArchivesInfoPO.setUpdateTime(new Date());
				birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
			}
		}
		/*if("1".equals(prenatalReferralInfoPO.getReferral())){
			birthArchivesInfoPO.setReferralSign("1");
			birthArchivesInfoPO.setReferralTime(new Date());
			birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoPO.setUpdateTime(new Date());
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}*/
		prenatalExaInfoPO.setBirthArchivesId(birthArchivesInfoPO.getId());
		prenatalExaInfoPO.setId(IdUtil.uuid());
		
		obstetricExaInfoPO.setId(IdUtil.uuid());
		obstetricExaInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		
		supplementaryExamInfoPO.setId(IdUtil.uuid());
		supplementaryExamInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		prenatalReferralInfoPO.setId(IdUtil.uuid());
		prenatalReferralInfoPO.setPreId(prenatalExaInfoPO.getId());
		
		obstetricExaInfoDao.create(obstetricExaInfoPO);
		supplementaryExamInfoDao.create(supplementaryExamInfoPO);
		prenatalExaInfoDao.create(prenatalExaInfoPO);
		prenatalReferralInfoDao.create(prenatalReferralInfoPO);
		
		if(!("").equals(highRiskId) && highRiskId != null){
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			
			highRiskInfoPO.setExaminationId(prenatalExaInfoPO.getId());
			highRiskInfoPO.setId(highRiskId);
			
			highRiskInfoDao.savePrenatalExaId(highRiskInfoPO);
			
		}
		
		return prenatalExaInfoPO.getId();
		
	}

	
	/**
	 * 通过产检id查询出第一次产检的所有信息
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	public Map<String, Object> firstPrenatalPreview(String prenatalId) {
		Map<String, Object> map = new HashMap<>();
		
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoDao.find(prenatalId);
		
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoDao.find(prenatalExaInfoPO.getBirthArchivesId());
		ArchivesInfoPO archivesInfoPO = archivesInfoDao.find(birthArchivesInfoPO.getArchivesId());
		
		FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = firstGynecologicalExaInfoDao.getGynecologByPrenatalId(prenatalId);
		FirstMotherhoodInfoPO firstMotherhoodInfoPO = firstMotherhoodInfoDao.getFirstMotherhoodByPreantalExaId(prenatalId);
		FirstPhysicalBloodStethoscopyInfoPO bloodStethoscopyInfoPO = firstPhysicalBloodStethoscopyInfoDao.getPhysicalBloodByPrenatalId(prenatalId);
		SupplementaryExamInfoPO supplementaryExamInfoPO = supplementaryExamInfoDao.getSupplemetnaryExamByPrenatalId(prenatalId);
		PrenatalReferralInfoPO prenatalReferralInfoPO = prenatalReferralInfoDao.getPrenatalReferralByPrenatalId(prenatalId);
		
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			map.put("age", age);
		}else{
			map.put("age", null);
		}
		Date manBirthday = archivesInfoPO.getManBirthday();
		
		
		if(manBirthday != null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			map.put("manAge", manAge);
		}else {
			map.put("manAge", null);
		}
		
		Date lastMenses = birthArchivesInfoPO.getLastMenses();
		Date predictDate = birthArchivesInfoPO.getPredictDate();
		Date checkTime = prenatalExaInfoPO.getCreatTime();
		if(lastMenses != null && checkTime != null){
			int week = DateUtils.getWeekByLastMenses(lastMenses, checkTime);
			map.put("week", week);
		}else if(lastMenses != null){
			int week = DateUtils.getWeekByLastMenses(lastMenses);
			map.put("week", week);
		}else {
			map.put("week", null);
		}
		Date expectedDate = predictDate;
		map.put("expectedDate", expectedDate);
		//既往史
		if(firstMotherhoodInfoPO != null){
			String history = firstMotherhoodInfoPO.getHistory();
			List<String> historys = new ArrayList<>();
			if(history != null && history.length() > 1){
				for (int i = 0; i < history.split(",").length; i++) {
					historys.add(history.split(",")[i]);
				}
			}else{
				historys.add(history);
			}
			map.put("historys", historys);
			
			//家庭史
			String famHistory = firstMotherhoodInfoPO.getFamHistory();
			List<String> famHistorys = new ArrayList<>();
			if(famHistory != null && famHistory.length() > 1){
				for (int i = 0; i < famHistory.split(",").length; i++) {
					famHistorys.add(famHistory.split(",")[i]);
				}
			}else{
				famHistorys.add(famHistory);
			}
			map.put("famHistorys", famHistorys);
			
			//个人史
			String perHistory = firstMotherhoodInfoPO.getPerHistory();
			List<String> perHistorys = new ArrayList<>();
			if(perHistory != null && perHistory.length() >1){
				for (int i = 0; i < perHistory.split(",").length; i++) {
					perHistorys.add(perHistory.split(",")[i]);
				}
			}else{
				perHistorys.add(perHistory);
			}
			map.put("perHistorys", perHistorys);
		}
		if(supplementaryExamInfoPO != null){
			//阴道分泌物
			String vaginalFluid = supplementaryExamInfoPO.getVaginalFluid();
			List<String> vaginalFluids = new ArrayList<>();
			if(vaginalFluid != null && vaginalFluid.length()>1){
				for (int i = 0; i < vaginalFluid.split(",").length; i++) {
					vaginalFluids.add(vaginalFluid.split(",")[i]);
				}
			}else{
				vaginalFluids.add(vaginalFluid);
			}
			map.put("vaginalFluids", vaginalFluids);
		}
		if(bloodStethoscopyInfoPO != null){
			String height =bloodStethoscopyInfoPO.getHeight();
			String weight = bloodStethoscopyInfoPO.getWeight();
			if(height != "" && height != null && weight != "" && weight != null){
				
				double h = Double.parseDouble(height)/100.0;
				double w = Double.parseDouble(weight);
				double b = w/(h*h);
				DecimalFormat df = new DecimalFormat("######0.00"); 
				
				//体质指数
				String bmi = "";
				if(b <= 24 && b >= 18){
					bmi = df.format(b)+" 正常体质";
				}
				if(b <= 28 && b > 24){
					bmi = df.format(b)+" 偏重体质";
				}
				if(b > 28){
					bmi = df.format(b)+" 肥胖体质";
				}
				if(b < 18){
					bmi = df.format(b)+" 偏瘦体质";
				}
				map.put("bmi", bmi);
			}
		}
		String evaluate = prenatalExaInfoPO.getEvaluate();
		//String evaluateRemark = prenatalExaInfoPO.getEvaluateRemark();
		if("1".equals(evaluate)){
			HighRiskInfoPO highRiskInfoPO = highRiskInfoDao.getHighRiskByprenatalExaId(prenatalId);
			if(highRiskInfoPO != null){
				List<String> list = highRiskTermDao.getItemsByHighRiskId(highRiskInfoPO.getId());
				map.put("highRisk", highRiskInfoPO);
				map.put("list", list);
				int count = highRiskTermDao.getCountByHighRiskIdAndState(highRiskInfoPO.getId());
				if(list.size() > 0 && count > 0){
					map.put("correctCount", "1");
				}else if(list.size() > 0 && count == 0){
					map.put("correctCount", "0");
				}else{
					map.put("correctCount", "-1");
				}
				List<HighRiskTermPO> allList = highRiskTermDao.getThisHighRiskTermByHighRiskId(highRiskInfoPO.getId());
				//已矫正的
				String nomalList = "";
				//未矫正的
				String malList = "未矫正：";
				for (HighRiskTermPO highRiskTermPO : allList) {
					String corr = highRiskTermPO.getCorrect();
					if("0".equals(corr)){
						malList += highRiskTermPO.getHighRisk() +"；";
					}
					if("1".equals(corr)){
						nomalList += highRiskTermPO.getHighRisk()+"；";
					}
				}
				if(!"".equals(nomalList) && nomalList != null){
					nomalList = "已矫正（"+nomalList +"）";
				}
				if("未矫正：".equals(malList)){
					malList = "未矫正：无";
				}
				map.put("nomalList", nomalList);
				map.put("malList", malList);
			}
		}
		
		map.put("birthArchives", birthArchivesInfoPO);
		map.put("supplemetnaryExam", supplementaryExamInfoPO);
		map.put("prenatalReferral", prenatalReferralInfoPO);
		map.put("gynecologcal", firstGynecologicalExaInfoPO);
		map.put("motherhood", firstMotherhoodInfoPO);
		map.put("bloodStethos", bloodStethoscopyInfoPO);
		map.put("prenatalExa", prenatalExaInfoPO);
		map.put("archives", archivesInfoPO);
		map.put("time", new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
		return map;
	}

	/**
	 * 2到N次的打印预览信息通过此次的产检id
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	public Map<String, Object> prenatalPreview2ToN(String prenatalId) {
		Map<String, Object> map = new HashMap<>();
		
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoDao.find(prenatalId);
		
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoDao.find(prenatalExaInfoPO.getBirthArchivesId());
		ArchivesInfoPO archivesInfoPO = archivesInfoDao.find(birthArchivesInfoPO.getArchivesId());
		
		ObstetricExaInfoPO obstetricExaInfoPO = obstetricExaInfoDao.getobstetricExaByPrenatalId(prenatalId);
		SupplementaryExamInfoPO supplementaryExamInfoPO = supplementaryExamInfoDao.getSupplemetnaryExamByPrenatalId(prenatalId);
		PrenatalReferralInfoPO prenatalReferralInfoPO = prenatalReferralInfoDao.getPrenatalReferralByPrenatalId(prenatalId);
		
		String fetusPosition = obstetricExaInfoPO.getFetusPosition();
		String heartRate = obstetricExaInfoPO.getHeartRate();
		if(fetusPosition != null && fetusPosition != ""){
			boolean b = fetusPosition.contains(",");
			if(b){
				String[] fets = fetusPosition.split(",");
				for (int i = 0; i < fets.length; i++) {
					
					map.put("fetus"+i, fets[i]);
				}
				map.put("len", fets.length);
			}else{
				map.put("fetus0", fetusPosition);
				map.put("len", 1);
			}
		}
		if(heartRate != null && heartRate != ""){
			boolean b = heartRate.contains(",");
			if(b){
				String[] hearts = heartRate.split(",");
				for (int i = 0; i < hearts.length; i++) {
					
					map.put("heart"+i, hearts[i]);
				}
			}else{
				map.put("heart0", heartRate);
			}
		}
		
		//获取第一次检查的记录
		PrenatalExaInfoPO firstprenatalExa = prenatalExaInfoDao.getPrenatalExaByBirthArchivesId(birthArchivesInfoPO.getId());
		FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
		if(firstprenatalExa != null){
			firstMotherhoodInfoPO = firstMotherhoodInfoDao.getFirstMotherhoodByPreantalExaId(firstprenatalExa.getId());
			SupplementaryExamInfoPO firstSupplementaryExamInfoPO = supplementaryExamInfoDao.getSupplemetnaryExamByPrenatalId(firstprenatalExa.getId());
			FirstPhysicalBloodStethoscopyInfoPO firstPhysical = firstPhysicalBloodStethoscopyInfoDao.getPhysicalBloodByPrenatalId(firstprenatalExa.getId());
			if(firstPhysical != null){
				String height = firstPhysical.getHeight();
				map.put("height", height);
			}
			String bloodType = firstSupplementaryExamInfoPO.getBloodType();
			map.put("bloodType", bloodType);
		}
		Date lastMenses = birthArchivesInfoPO.getLastMenses();
		Date predictDate = birthArchivesInfoPO.getPredictDate();
		Date expectedDate = predictDate;
		map.put("expectedDate", expectedDate);
		Date checkTime = prenatalExaInfoPO.getCreatTime();
		if(lastMenses != null && checkTime != null){
			int week = DateUtils.getWeekByLastMenses(lastMenses, checkTime);
			map.put("week", week);
		}else if(lastMenses != null){
			int week = DateUtils.getWeekByLastMenses(lastMenses);
			map.put("week", week);
		}else{
			//map.put("expectedDate", null);
			map.put("week", null);
		}
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			map.put("age",age);
		}else{
			map.put("age",null);
		}
		Date manBirthday = archivesInfoPO.getManBirthday();
		if(manBirthday != null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			map.put("manAge", manAge);
		}else{
			map.put("manAge", null);
		}
		
		
		//String evaluate = prenatalExaInfoPO.getEvaluate();
		//String evaluateRemark = prenatalExaInfoPO.getEvaluateRemark();
		List<PrenatalExaInfoPO> prenatalList = prenatalExaInfoDao.getThisBirthPrenatalByBirthId(birthArchivesInfoPO.getId());
		
		if(prenatalList.size() > 1){
			PrenatalExaInfoPO prenatal = prenatalList.get(1);
			if(prenatal != null){
				
				HighRiskInfoPO highRisk = highRiskInfoDao.getHighRiskByprenatalExaId(prenatal.getId());
				if(highRisk != null){
					
					List<String> list = highRiskTermDao.getItemsByHighRiskId(highRisk.getId());
//					map.put("highRisk", highRisk);
//					map.put("list", list);
					int count = highRiskTermDao.getCountByHighRiskIdAndState(highRisk.getId());
					if(list.size() > 0 && count > 0){
						map.put("correct", "1");
					}else if(list.size() > 0 && count == 0){
						map.put("correct", "0");
					}else{
						map.put("correct", "-1");
					}
				}
			}
		}
		
		HighRiskInfoPO highRiskInfoPO = highRiskInfoDao.getHighRiskByprenatalExaId(prenatalId);
		if(highRiskInfoPO != null){
			
			List<String> list = highRiskTermDao.getItemsByHighRiskId(highRiskInfoPO.getId());
			map.put("highRisk", highRiskInfoPO);
			map.put("list", list);
			int count = highRiskTermDao.getCountByHighRiskIdAndState(highRiskInfoPO.getId());
			if(list.size() > 0 && count > 0){
				map.put("correctCount", "1");
			}else if(list.size() > 0 && count == 0){
				map.put("correctCount", "0");
			}else{
				map.put("correctCount", "-1");
			}
			List<HighRiskTermPO> allList = highRiskTermDao.getThisHighRiskTermByHighRiskId(highRiskInfoPO.getId());
			//已矫正的
			String nomalList = "";
			//未矫正的
			String malList = "未矫正：";
			for (HighRiskTermPO highRiskTermPO : allList) {
				String corr = highRiskTermPO.getCorrect();
				if("0".equals(corr)){
					malList += highRiskTermPO.getHighRisk() +"；";
				}
				if("1".equals(corr)){
					nomalList += highRiskTermPO.getHighRisk()+"；";
				}
			}
			if(!"".equals(nomalList) && nomalList != null){
				nomalList = "已矫正（"+nomalList +"）";
			}
			if("未矫正：".equals(malList)){
				malList = "未矫正：无";
			}
			map.put("nomalList", nomalList);
			map.put("malList", malList);
		}
		
		map.put("birthArchives", birthArchivesInfoPO);
		
		map.put("motherhood", firstMotherhoodInfoPO);
		map.put("obstetricExa", obstetricExaInfoPO);
		map.put("supplemetnaryExam", supplementaryExamInfoPO);
		map.put("prenatalReferral", prenatalReferralInfoPO);
		map.put("prenatal", prenatalExaInfoPO);
		
		map.put("archives", archivesInfoPO);
		map.put("time", new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
		return map;
	}

	/**
	 * 第一次产检详情编辑
	 * @param archivesCode
	 * @param firstMotherhoodInfoPO
	 * @param firstPhysicalBloodStethoscopyInfoPO
	 * @param firstGynecologicalExaInfoPO
	 * @param supplementaryExamInfoPO
	 * @param prenatalExaInfoPO
	 * @param prenatalReferralInfoPO
	 * @param highRiskId
	 */
	@Transactional
	public void editFirstPrenatal(String archivesCode, 
								  FirstMotherhoodInfoPO firstMotherhoodInfoPO,
								  FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO,
								  FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO, 
								  SupplementaryExamInfoPO supplementaryExamInfoPO,
								  PrenatalExaInfoPO prenatalExaInfoPO, 
								  PrenatalReferralInfoPO prenatalReferralInfoPO, 
								  String highRiskId,String depId) {
		firstMotherhoodInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		Date predictDate = DateUtils.expectedDate(firstMotherhoodInfoPO.getLastMenses());
		firstMotherhoodInfoPO.setPredictDate(predictDate);
		firstMotherhoodInfoDao.edit(firstMotherhoodInfoPO);
		
		firstPhysicalBloodStethoscopyInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		firstPhysicalBloodStethoscopyInfoDao.edit(firstPhysicalBloodStethoscopyInfoPO);
		
		firstGynecologicalExaInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		firstGynecologicalExaInfoDao.edit(firstGynecologicalExaInfoPO);
		
		supplementaryExamInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		supplementaryExamInfoPO.setId(IdUtil.uuid());
		supplementaryExamInfoDao.deleteByPrenatalId(prenatalExaInfoPO.getId());
		supplementaryExamInfoDao.create(supplementaryExamInfoPO);
		
		prenatalExaInfoPO.setUpdateTime(new Date());
		prenatalExaInfoDao.edit(prenatalExaInfoPO);
		
		prenatalReferralInfoPO.setPreId(prenatalExaInfoPO.getId());
		prenatalReferralInfoDao.edit(prenatalReferralInfoPO);
		
		if(!("").equals(highRiskId) && highRiskId != null){
			
			HighRiskInfoPO highRiskInfoPO = highRiskInfoDao.find(highRiskId);
			if(highRiskInfoPO != null && highRiskInfoPO.getId() == null){
				highRiskInfoPO.setExaminationId(prenatalExaInfoPO.getId());
				highRiskInfoDao.savePrenatalExaId(highRiskInfoPO);
			}
		}
		PrenatalExaInfoPO find = prenatalExaInfoDao.find(prenatalExaInfoPO.getId());
		//BirthArchivesInfoPO birthArchives = birthArchivesInfoDao.find(find.getBirthArchivesId());
		BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
		birthArchivesInfoPO.setId(find.getBirthArchivesId());
		if("1".equals(prenatalReferralInfoPO.getReferral())){
			birthArchivesInfoPO.setReferralSign("1");
			birthArchivesInfoPO.setReferralTime(new Date());
			birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}/*else if("0".equals(prenatalReferralInfoPO.getReferral())){
			
			birthArchivesInfoPO.setReferralSign("0");
			birthArchivesInfoPO.setReferralTime(null);
			birthArchivesInfoPO.setInHospitalId(null);
			birthArchivesInfoPO.setOutHospitalId(null);
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}*/
	}

	/**
	 * 2到N次产检详情编辑
	 * @param archivesCode
	 * @param obstetricExaInfoPO
	 * @param supplementaryExamInfoPO
	 * @param prenatalExaInfoPO
	 * @param prenatalReferralInfoPO
	 * @param highRiskId
	 * @author yanwk
	 */
	@Transactional
	public void edit2ToNPrenatal(String archivesCode, 
								 ObstetricExaInfoPO obstetricExaInfoPO,
								 SupplementaryExamInfoPO supplementaryExamInfoPO, 
								 PrenatalExaInfoPO prenatalExaInfoPO,
								 PrenatalReferralInfoPO prenatalReferralInfoPO, 
								 String highRiskId,String depId) {
		obstetricExaInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		obstetricExaInfoDao.edit(obstetricExaInfoPO);
		
		supplementaryExamInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		supplementaryExamInfoPO.setId(IdUtil.uuid());
		supplementaryExamInfoDao.deleteByPrenatalId(prenatalExaInfoPO.getId());
		supplementaryExamInfoDao.create(supplementaryExamInfoPO);
		
		prenatalExaInfoPO.setUpdateTime(new Date());
		prenatalExaInfoDao.edit(prenatalExaInfoPO);
		
		prenatalReferralInfoPO.setPreId(prenatalExaInfoPO.getId());
		prenatalReferralInfoDao.edit(prenatalReferralInfoPO);
		
		if(!("").equals(highRiskId) && highRiskId != null){
			
			HighRiskInfoPO highRiskInfoPO = highRiskInfoDao.find(highRiskId);
			if(highRiskInfoPO != null && highRiskInfoPO.getId() == null){
				highRiskInfoPO.setExaminationId(prenatalExaInfoPO.getId());
				highRiskInfoDao.savePrenatalExaId(highRiskInfoPO);
			}
		}
		PrenatalExaInfoPO find = prenatalExaInfoDao.find(prenatalExaInfoPO.getId());
		BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
		birthArchivesInfoPO.setId(find.getBirthArchivesId());
		if("1".equals(prenatalReferralInfoPO.getReferral())){
			birthArchivesInfoPO.setReferralSign("1");
			birthArchivesInfoPO.setReferralTime(new Date());
			birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}/*else if("0".equals(prenatalReferralInfoPO.getReferral())){
			birthArchivesInfoPO.setReferralSign("0");
			birthArchivesInfoPO.setReferralTime(null);
			birthArchivesInfoPO.setInHospitalId(null);
			birthArchivesInfoPO.setOutHospitalId(null);
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}*/
	}

	/**
	 * 获取最新的产检信息
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public PrenatalExaInfoPO getNewestPrenatal(String birthArchivesId) {
		return prenatalExaInfoDao.getNewestPrenatal(birthArchivesId);
	}

	/**
	 * 修改页面专案管理保存高危项
	 * @param editHighRisk
	 * @param params
	 */
	@Transactional
	public void editProjectManager(HighRiskInfoPO editHighRisk, Map<String, Object> params) {
		
		highRiskTermDao.removeByHighRiskId(editHighRisk.getId());
		Set<Entry<String,Object>> entrySet = params.entrySet();
		int score = 0;
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			if(key.startsWith("_")){
				String correct = (String) params.get(key.substring(1));
				String id = (String) params.get(key);
				HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreDao.find(id);
				
				score += Integer.parseInt(highRiskPregnancyScorePO.getScore());
				
				HighRiskTermPO highRiskTermPO = new HighRiskTermPO();
				highRiskTermPO.setId(IdUtil.uuid());
				highRiskTermPO.setHighRisk(highRiskPregnancyScorePO.getName());
				highRiskTermPO.setTermId(highRiskPregnancyScorePO.getId());
				highRiskTermPO.setHighRiskId(editHighRisk.getId());
				if("1".equals(correct)){
					
					Date date = new Date();
					highRiskTermPO.setCorrectionTime(date);
					highRiskTermPO.setCorrect("1");
				}else if("0".equals(correct)){
					highRiskTermPO.setCorrect(correct);
				}
				highRiskTermPO.setStatus(highRiskPregnancyScorePO.getStatus());
				highRiskTermPO.setScore(highRiskPregnancyScorePO.getScore());
				
				highRiskTermDao.create(highRiskTermPO);
			}
		}
		
		editHighRisk.setScore(score+"");
		highRiskInfoDao.editHighRisk(editHighRisk);
	}
	
	/**
	 * 获取所有的产检数据个数通过生育id
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	public int countByBirthId(String birthArchivesId) {
		
		return prenatalExaInfoDao.countByBirthId(birthArchivesId);
	}

	/**
	 * 获取所有正常的数据个数
	 * @param birthArchivesId
	 * @return
	 * @author ywk
	 */
	public int getNumByNomal(String birthArchivesId) {
		return prenatalExaInfoDao.getNumByNomal(birthArchivesId);
	}

	/**
	 * 获取所有产检数据
	 * @param birthArchivesId
	 * @return
	 * @author ywk
	 */
	public List<PrenatalExaInfoPO> getAllPrenatalByBirthId(String birthArchivesId) {
		return prenatalExaInfoDao.getAllPrenatalByBirthId(birthArchivesId);
	}

	/**
	 * 2到N次不正常数据保存
	 * @param archivesCode
	 * @param obstetricExaInfoPO
	 * @param supplementaryExamInfoPO
	 * @param prenatalExaInfoPO
	 * @param prenatalReferralInfoPO
	 * @param highRiskId
	 * @param depId
	 * @return
	 */
	public String prenatalExaNomal2ToN(String archivesCode, ObstetricExaInfoPO obstetricExaInfoPO,
			SupplementaryExamInfoPO supplementaryExamInfoPO, PrenatalExaInfoPO prenatalExaInfoPO,
			PrenatalReferralInfoPO prenatalReferralInfoPO, String highRiskId, String depId) {
		//ArchivesInfoPO archivesInfoPO = archivesInfoDao.getArchivesByArchivesCode(archivesCode);
		
		ArchivesInfoPO archives = archivesInfoDao.getArchivesByArchivesCode(archivesCode);
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoDao.getBirthArchivesByArchivesId(archives.getId());
		
		String evaluate = prenatalExaInfoPO.getEvaluate();
		if(("1").equals(evaluate)){
			if(("0").equals(birthArchivesInfoPO.getRiskSign())){
				//修改生育档案表高危标识为“1”，修改第一次出现高危的筛查时间
				birthArchivesInfoPO.setRiskSign("1");
				birthArchivesInfoPO.setScreeningDate(new Date());
				birthArchivesInfoDao.updateRiskSign(birthArchivesInfoPO);
			}
		}
		//如果是转诊的话修改生育档案表的转诊状态、转诊时间、转出医院、转入医院
		if("1".equals(prenatalReferralInfoPO.getReferral())){
			birthArchivesInfoPO.setReferralSign("1");
			birthArchivesInfoPO.setReferralTime(new Date());
			birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoPO.setUpdateTime(new Date());
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}
		prenatalExaInfoPO.setBirthArchivesId(birthArchivesInfoPO.getId());
		prenatalExaInfoPO.setId(IdUtil.uuid());
		
		obstetricExaInfoPO.setId(IdUtil.uuid());
		obstetricExaInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		
		supplementaryExamInfoPO.setId(IdUtil.uuid());
		supplementaryExamInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		prenatalReferralInfoPO.setId(IdUtil.uuid());
		prenatalReferralInfoPO.setPreId(prenatalExaInfoPO.getId());
		
		obstetricExaInfoDao.create(obstetricExaInfoPO);
		supplementaryExamInfoDao.create(supplementaryExamInfoPO);
		prenatalExaInfoDao.create(prenatalExaInfoPO);
		prenatalReferralInfoDao.create(prenatalReferralInfoPO);
		
		if(!("").equals(highRiskId) && highRiskId != null){
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			
			highRiskInfoPO.setExaminationId(prenatalExaInfoPO.getId());
			highRiskInfoPO.setId(highRiskId);
			
			highRiskInfoDao.savePrenatalExaId(highRiskInfoPO);
			
		}
		
		return prenatalExaInfoPO.getId();
	}

	public String nomalFirstPrenatalExa(String archivesCode, String birthArchivesId,
			FirstMotherhoodInfoPO firstMotherhoodInfoPO,
			FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO,
			FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO, SupplementaryExamInfoPO supplementaryExamInfoPO,
			PrenatalExaInfoPO prenatalExaInfoPO, PrenatalReferralInfoPO prenatalReferralInfoPO, String highRiskId,
			String depId) {
		ArchivesInfoPO archivesInfoPO = archivesInfoDao.getArchivesByArchivesCode(archivesCode);
		
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoDao.getBirthArchivesByArchivesId(archivesInfoPO.getId());
		String evaluate = prenatalExaInfoPO.getEvaluate();
		if(("1").equals(evaluate)){
			if(("0").equals(birthArchivesInfoPO.getRiskSign())){
				//修改生育档案表高危标识为“1”，修改第一次出现高危的筛查时间
				birthArchivesInfoPO.setRiskSign("1");
				birthArchivesInfoPO.setScreeningDate(new Date());
				birthArchivesInfoDao.updateRiskSign(birthArchivesInfoPO);
			}
		}
		
		//如果是转诊的话修改生育档案表的转诊状态为孕检转诊
		if("1".equals(prenatalReferralInfoPO.getReferral())){
			birthArchivesInfoPO.setReferralSign("1");
			birthArchivesInfoPO.setReferralTime(new Date());
			birthArchivesInfoPO.setInHospitalId(prenatalReferralInfoPO.getDepartment());
			birthArchivesInfoPO.setOutHospitalId(depId);
			birthArchivesInfoDao.updateReferralSign(birthArchivesInfoPO);
		}
		prenatalExaInfoPO.setBirthArchivesId(birthArchivesInfoPO.getId());
		prenatalExaInfoPO.setId(IdUtil.uuid());
		
		firstMotherhoodInfoPO.setId(IdUtil.uuid());
		firstMotherhoodInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		
		firstPhysicalBloodStethoscopyInfoPO.setId(IdUtil.uuid());
		firstPhysicalBloodStethoscopyInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		firstGynecologicalExaInfoPO.setId(IdUtil.uuid());
		firstGynecologicalExaInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		supplementaryExamInfoPO.setId(IdUtil.uuid());
		supplementaryExamInfoPO.setExaminationId(prenatalExaInfoPO.getId());
		prenatalReferralInfoPO.setId(IdUtil.uuid());
		prenatalReferralInfoPO.setPreId(prenatalExaInfoPO.getId());
		
		firstMotherhoodInfoDao.create(firstMotherhoodInfoPO);
		firstPhysicalBloodStethoscopyInfoDao.create(firstPhysicalBloodStethoscopyInfoPO);
		firstGynecologicalExaInfoDao.create(firstGynecologicalExaInfoPO);
		supplementaryExamInfoDao.create(supplementaryExamInfoPO);
		prenatalExaInfoDao.create(prenatalExaInfoPO);
		prenatalReferralInfoDao.create(prenatalReferralInfoPO);
		
		if(!("").equals(highRiskId) && highRiskId != null){
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			
			highRiskInfoPO.setExaminationId(prenatalExaInfoPO.getId());
			highRiskInfoPO.setId(highRiskId);
			
			highRiskInfoDao.savePrenatalExaId(highRiskInfoPO);
			
		}
		return prenatalExaInfoPO.getId();
	}

}