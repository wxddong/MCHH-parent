package com.threefiveninetong.mchh.achievements.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.achievements.dao.AchievementsDao;
import com.threefiveninetong.mchh.achievements.po.BasicPublicHealthFeedbackStatisticsPO;
import com.threefiveninetong.mchh.achievements.po.CountyAchievementsPO;
import com.threefiveninetong.mchh.achievements.po.DoctorAchievementsPO;
import com.threefiveninetong.mchh.reportForm.po.MaternalHealthcareConditionPO;
import com.threefiveninetong.mchh.util.Page;

@Service
public class AchievementsService {
	
	@Resource
	private AchievementsDao achievementsDao;
	/**
	 * 医生绩效管理列表
	 * wangxd 2016.9.23
	 * @param conds
	 * @param page
	 */
	public void doctorListForPage(Map<String, Object> conds, Page<DoctorAchievementsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<DoctorAchievementsPO> list = achievementsDao.doctorListForPage(conds);
		if(list!=null&&list.size()>0){
			for (DoctorAchievementsPO doctorAchievementsPO : list) {
				//获取医生的id查询其他的数据
				String doctorId = doctorAchievementsPO.getDoctorId();
				conds.put("doctorId", doctorId);
				//孕13周检查人次
				int days13max = 13*7;
				conds.remove("minDay");
				conds.put("maxDay", days13max);
				int before13Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setBefore13Num(before13Num);
				//孕16-20周检查人次
				int days16to20min = 15*7+6;
				int days16to20max = 20*7;
				conds.put("minDay", days16to20min);
				conds.put("maxDay", days16to20max);
				int at16to20Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt16to20Num(at16to20Num);
				//孕21-24周检查人次
				int days21to24min = 20*7+6;
				int days21to24max = 24*7;
				conds.put("minDay", days21to24min);
				conds.put("maxDay", days21to24max);
				int at21to24Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt21to24Num(at21to24Num);
				//孕28-36周检查人次
				int days28to36min = 27*7+6;
				int days28to36max = 36*7;
				conds.put("minDay", days28to36min);
				conds.put("maxDay", days28to36max);
				int at28to36Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt28to36Num(at28to36Num);
				//孕37-40周检查人次
				int days37to40min = 36*7+6;
				int days37to40max = 40*7;
				conds.put("minDay", days37to40min);
				conds.put("maxDay", days37to40max);
				int at37to40Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt37to40Num(at37to40Num);
				//出院后3-7天检查人次
				int post3to7Num = achievementsDao.getPost3to7Num(conds);
				doctorAchievementsPO.setPost3to7Num(post3to7Num);
				//出院后42天检查人次
				int post42Num = achievementsDao.getPost42Num(conds);
				doctorAchievementsPO.setPost42Num(post42Num);
				//血常规检查人数
				String itemsBlood = "se.HEMOGLOBIN IS NOT NULL OR se.LEUCOCYTE IS NOT NULL OR se.PLATELET IS NOT NULL";
				conds.put("items",itemsBlood);
				int bloodNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setBloodNum(bloodNum);
				//尿常规检查人数
				String itemsUrine = "se.PROTEINURIA is not null OR se.URINE_SUGAR is not null OR se.KETONE is not NULL OR se.URINE_BLOOD is not NULL";
				conds.put("items",itemsUrine);
				int urineNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setUrineNum(urineNum);
				//血型检查人数
				String itemsBloodType = "se.BLOOD_TYPE is not null OR se.BLOOD_TYPE_RH is not null OR se.BLOOD_GLUCOSE is not NULL ";
				conds.put("items",itemsBloodType);
				int bloodTypeNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setBloodTypeNum(bloodTypeNum);
				//肝功能检查人数
				String itemsLiver = "se.SGPT is not null OR se.SGOT is not null OR se.ALBUMIN is not NULL OR se.TOTAL_BILIRUBIN is not null OR se.DBIL is not NULL";
				conds.put("items",itemsLiver);
				int liverNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setLiverNum(liverNum);
				//肾功能检查人数
				String itemsKidney = "se.SCR is not null OR se.BUN is not null";
				conds.put("items",itemsKidney);
				int kidneyNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setKidneyNum(kidneyNum);
				//乙肝表抗检查人数
				String itemsHepatitisB = "se.HBSAG is not null OR se.HBSAB is not null OR se.HBCAB is not null OR se.HBEAB is not null OR se.HBEAG is not NULL";
				conds.put("items",itemsHepatitisB);
				int hepatitisBNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setHepatitisBNum(hepatitisBNum);
				//梅毒检查人数
				String itemsSyphilis = "se.SYPHILIS_SEROLOGY is not null";
				conds.put("items",itemsSyphilis);
				int syphilisNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setSyphilisNum(syphilisNum);
				//艾滋病检查人数
				String itemsAids = "se.HIVAB is not null";
				conds.put("items",itemsAids);
				int aidsNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setAidsNum(aidsNum);
				//产检两次以后的血红蛋白检查人数
				int hemoglobinNum = achievementsDao.getHemoglobinNum1(conds);
				doctorAchievementsPO.setHemoglobinNum(hemoglobinNum);
				//产检两次以后尿蛋白检查人数
				int  urineProteinNum = achievementsDao.getUrineProteinNum1(conds);
				doctorAchievementsPO.setUrineProteinNum(urineProteinNum);
				//结案产妇电子录入数
				int actualCloseNum = achievementsDao.getActualCloseNum1(conds);
				doctorAchievementsPO.setActualCloseNum(actualCloseNum);
			}
		}
		page.setList(list);
		}
	
	/**
	 * 县级绩效管理列表
	 * wangxd 2016.9.21
	 * @param conds
	 * @param page
	 */
	public void countyListForPage(Map<String, Object> conds, Page<CountyAchievementsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		List<CountyAchievementsPO> list = achievementsDao.countyListForPage(conds);
		if(list!=null&&list.size()>0){
			for (CountyAchievementsPO countyAchievementsPO : list) {
				//获取医院的id,根据医院id进行查询相关数据然后赋值
				String departmentId = countyAchievementsPO.getDepartmentId();
				conds.put("departmentId", departmentId);
				//1.实际结案产妇数
				int actualCloseNum = achievementsDao.getActualCloseNum(conds);
				countyAchievementsPO.setActualCloseNum(actualCloseNum);
				
				NumberFormat formatter = new DecimalFormat("#0.00");
				//2.产前健康检查人数
				int preGreat0Num = achievementsDao.getPreGreat0Num(conds);
				countyAchievementsPO.setPreGreat0Num(preGreat0Num);
				//产前健康管理率
				int shouldCloseNum = countyAchievementsPO.getShouldCloseNum();
				double shouldCloseNum1 = shouldCloseNum;
				double preGreat0Num1 = preGreat0Num;
				if(preGreat0Num!=0 && shouldCloseNum1!=0){
					double preManageRate = preGreat0Num1/shouldCloseNum1*100;
					String preManageRate1 = formatter.format(preManageRate)+"%";
					countyAchievementsPO.setPreManageRate(preManageRate1);
				}else{
					countyAchievementsPO.setPreManageRate("0");
				}
				
				
				//3.查询早孕建卡数
				int earlyCardNum = achievementsDao.getearlyCardNum(conds);
				countyAchievementsPO.setEarlyCardNum(earlyCardNum);
				
				//早孕健康率
				double earlyCardNum1 = earlyCardNum;
				if(earlyCardNum!=0 && shouldCloseNum1!=0 ){
					double earlyRate = earlyCardNum1/shouldCloseNum1*100;
					String earlyRate1 = formatter.format(earlyRate)+"%";
					countyAchievementsPO.setEarlyRate(earlyRate1);
				}else{
					countyAchievementsPO.setEarlyRate("0");
				}
				//4.系统管理人数
				int sysManagementPersonsNum = achievementsDao.getSysManagementPersonsNum(conds);
				countyAchievementsPO.setSysManagementPersonsNum(sysManagementPersonsNum);
				//系统管理率
				if(sysManagementPersonsNum!=0 && shouldCloseNum1!=0){
					double sysManagementPersonsNum1 = sysManagementPersonsNum;
					double sysManagementRate = sysManagementPersonsNum1/shouldCloseNum1*100;
					String sysManagementRate1 = formatter.format(sysManagementRate)+"%";
					countyAchievementsPO.setSysManagementRate(sysManagementRate1);
				}else{
					countyAchievementsPO.setSysManagementRate("0");
				}
				
				
				//5.产后访视人数
				int postGreat0Num = achievementsDao.getPostGreat0Num(conds);
				countyAchievementsPO.setPostGreat0Num(postGreat0Num);
				//产后随访率
				if(postGreat0Num!=0 && shouldCloseNum1!=0){
					double postGreat0Num1=postGreat0Num;
					double postRate = postGreat0Num1/shouldCloseNum1*100;
					String postRate1 = formatter.format(postRate)+"%";
					countyAchievementsPO.setPostRate(postRate1);
				}else{
					countyAchievementsPO.setPostRate("0");
				}
				
				//6.血常规检验人数
				int bloodNum = achievementsDao.getBloodNum(conds);
				countyAchievementsPO.setBloodNum(bloodNum);
				//7.尿常规检查人数
				int urineNum = achievementsDao.getUrineNum(conds);
				countyAchievementsPO.setUrineNum(urineNum);
				//8.血型检查人数
				int bloodTypeNum = achievementsDao.getBloodTypeNum(conds);
				countyAchievementsPO.setBloodTypeNum(bloodTypeNum);
				//9.肝功检查人数
				int liverNum = achievementsDao.getLiverNum(conds);
				countyAchievementsPO.setLiverNum(liverNum);
				//10.肾功检查人数
				int kidneyNum = achievementsDao.getKidneyNum(conds);
				countyAchievementsPO.setKidneyNum(kidneyNum);
				//11.乙肝表抗检查人数
				int hepatitisBNum = achievementsDao.getHepatitisBNum(conds);
				countyAchievementsPO.setHepatitisBNum(hepatitisBNum);
				//12.梅毒检查人数
				int syphilisNum = achievementsDao.getSyphilisNum(conds);
				countyAchievementsPO.setSyphilisNum(syphilisNum);
				//13.艾滋病检查人数
				int aidsNum = achievementsDao.getAidsNum(conds);
				countyAchievementsPO.setAidsNum(aidsNum);
				//14.产前检查两次以后血红蛋白的检查人数
				int hemoglobinNum = achievementsDao.getHemoglobinNum(conds);
				countyAchievementsPO.setHemoglobinNum(hemoglobinNum);
				//15.产前检查两次以后白蛋白的检查人数
				int urineProteinNum = achievementsDao.getUrineProteinNum(conds);
				countyAchievementsPO.setUrineProteinNum(urineProteinNum);
			}
		}
		page.setList(list);
		
	}
	
	
	/**
	 * 县级绩效管理列表的导出
	 * wangxd 2016.10.05
	 * @param conds
	 * @param page
	 */
	public List<CountyAchievementsPO> countyListForExport(Map<String, Object> conds) {
		
		//根据医疗机构作为查询条件传入sql
		String countyMechanism = (String) conds.get("countyMechanism");
		String townMechanism =  (String) conds.get("townMechanism");
		String villageMechanism =  (String) conds.get("villageMechanism");
		if(villageMechanism!=null && villageMechanism!=""){
			String home = "AND a.HOME_VILLAGE_ID='"+villageMechanism+"'";
			conds.put("home", home);
		}else if(townMechanism!=null && townMechanism!=""){
			String home = "AND a.HOME_TOWNSHIP_ID='"+townMechanism+"'";
			conds.put("home", home);
		}else if(countyMechanism!=null && countyMechanism!=""){
			String home = "AND a.HOME_COUNTY_ID='"+countyMechanism+"'";
			conds.put("home", home);
		}
		
		List<CountyAchievementsPO> list = achievementsDao.countyListForPage(conds);
		if(list!=null&&list.size()>0){
			for (CountyAchievementsPO countyAchievementsPO : list) {
				//获取医院的id,根据医院id进行查询相关数据然后赋值
				String departmentId = countyAchievementsPO.getDepartmentId();
				conds.put("departmentId", departmentId);
				//1.实际结案产妇数
				int actualCloseNum = achievementsDao.getActualCloseNum(conds);
				countyAchievementsPO.setActualCloseNum(actualCloseNum);
				
				NumberFormat formatter = new DecimalFormat("#0.00");
				//2.产前健康检查人数
				int preGreat0Num = achievementsDao.getPreGreat0Num(conds);
				countyAchievementsPO.setPreGreat0Num(preGreat0Num);
				//产前健康管理率
				int shouldCloseNum = countyAchievementsPO.getShouldCloseNum();
				double shouldCloseNum1 = shouldCloseNum;
				double preGreat0Num1 = preGreat0Num;
				if(preGreat0Num!=0 && shouldCloseNum1!=0){
					double preManageRate = preGreat0Num1/shouldCloseNum1*100;
					String preManageRate1 = formatter.format(preManageRate)+"%";
					countyAchievementsPO.setPreManageRate(preManageRate1);
				}else{
					countyAchievementsPO.setPreManageRate("0");
				}
				
				
				//3.查询早孕建卡数
				int earlyCardNum = achievementsDao.getearlyCardNum(conds);
				countyAchievementsPO.setEarlyCardNum(earlyCardNum);
				
				//早孕健康率
				double earlyCardNum1 = earlyCardNum;
				if(earlyCardNum!=0 && shouldCloseNum1!=0 ){
					double earlyRate = earlyCardNum1/shouldCloseNum1*100;
					String earlyRate1 = formatter.format(earlyRate)+"%";
					countyAchievementsPO.setEarlyRate(earlyRate1);
				}else{
					countyAchievementsPO.setEarlyRate("0");
				}
				//4.系统管理人数
				int sysManagementPersonsNum = achievementsDao.getSysManagementPersonsNum(conds);
				countyAchievementsPO.setSysManagementPersonsNum(sysManagementPersonsNum);
				//系统管理率
				if(sysManagementPersonsNum!=0 && shouldCloseNum1!=0){
					double sysManagementPersonsNum1 = sysManagementPersonsNum;
					double sysManagementRate = sysManagementPersonsNum1/shouldCloseNum1*100;
					String sysManagementRate1 = formatter.format(sysManagementRate)+"%";
					countyAchievementsPO.setSysManagementRate(sysManagementRate1);
				}else{
					countyAchievementsPO.setSysManagementRate("0");
				}
				
				
				//5.产后访视人数
				int postGreat0Num = achievementsDao.getPostGreat0Num(conds);
				countyAchievementsPO.setPostGreat0Num(postGreat0Num);
				//产后随访率
				if(postGreat0Num!=0 && shouldCloseNum1!=0){
					double postGreat0Num1=postGreat0Num;
					double postRate = postGreat0Num1/shouldCloseNum1*100;
					String postRate1 = formatter.format(postRate)+"%";
					countyAchievementsPO.setPostRate(postRate1);
				}else{
					countyAchievementsPO.setPostRate("0");
				}
				
				//6.血常规检验人数
				int bloodNum = achievementsDao.getBloodNum(conds);
				countyAchievementsPO.setBloodNum(bloodNum);
				//7.尿常规检查人数
				int urineNum = achievementsDao.getUrineNum(conds);
				countyAchievementsPO.setUrineNum(urineNum);
				//8.血型检查人数
				int bloodTypeNum = achievementsDao.getBloodTypeNum(conds);
				countyAchievementsPO.setBloodTypeNum(bloodTypeNum);
				//9.肝功检查人数
				int liverNum = achievementsDao.getLiverNum(conds);
				countyAchievementsPO.setLiverNum(liverNum);
				//10.肾功检查人数
				int kidneyNum = achievementsDao.getKidneyNum(conds);
				countyAchievementsPO.setKidneyNum(kidneyNum);
				//11.乙肝表抗检查人数
				int hepatitisBNum = achievementsDao.getHepatitisBNum(conds);
				countyAchievementsPO.setHepatitisBNum(hepatitisBNum);
				//12.梅毒检查人数
				int syphilisNum = achievementsDao.getSyphilisNum(conds);
				countyAchievementsPO.setSyphilisNum(syphilisNum);
				//13.艾滋病检查人数
				int aidsNum = achievementsDao.getAidsNum(conds);
				countyAchievementsPO.setAidsNum(aidsNum);
				//14.产前检查两次以后血红蛋白的检查人数
				int hemoglobinNum = achievementsDao.getHemoglobinNum(conds);
				countyAchievementsPO.setHemoglobinNum(hemoglobinNum);
				//15.产前检查两次以后白蛋白的检查人数
				int urineProteinNum = achievementsDao.getUrineProteinNum(conds);
				countyAchievementsPO.setUrineProteinNum(urineProteinNum);
			}
		}
				return list;
	}
	
	
	/**
	 * 医生绩效管理列表的导出
	 * wangxd 2016.10.05
	 * @param conds
	 * @param page
	 */
	public List<DoctorAchievementsPO> doctorListForExport(Map<String, Object> conds) {
		
		//根据医疗机构作为查询条件传入sql
		String countyMechanism = (String) conds.get("countyMechanism");
		String townMechanism =  (String) conds.get("townMechanism");
		String villageMechanism =  (String) conds.get("villageMechanism");
		if(villageMechanism!=null && villageMechanism!=""){
			String home = "AND a.HOME_VILLAGE_ID='"+villageMechanism+"'";
			conds.put("home", home);
		}else if(townMechanism!=null && townMechanism!=""){
			String home = "AND a.HOME_TOWNSHIP_ID='"+townMechanism+"'";
			conds.put("home", home);
		}else if(countyMechanism!=null && countyMechanism!=""){
			String home = "AND a.HOME_COUNTY_ID='"+countyMechanism+"'";
			conds.put("home", home);
		}
		
		List<DoctorAchievementsPO> list = achievementsDao.doctorListForPage(conds);
		if(list!=null&&list.size()>0){
			for (DoctorAchievementsPO doctorAchievementsPO : list) {
				//获取医生的id查询其他的数据
				String doctorId = doctorAchievementsPO.getDoctorId();
				conds.put("doctorId", doctorId);
				//孕13周检查人次
				int days13max = 13*7;
				conds.remove("minDay");
				conds.put("maxDay", days13max);
				int before13Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setBefore13Num(before13Num);
				//孕16-20周检查人次
				int days16to20min = 15*7+6;
				int days16to20max = 20*7;
				conds.put("minDay", days16to20min);
				conds.put("maxDay", days16to20max);
				int at16to20Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt16to20Num(at16to20Num);
				//孕21-24周检查人次
				int days21to24min = 20*7+6;
				int days21to24max = 24*7;
				conds.put("minDay", days21to24min);
				conds.put("maxDay", days21to24max);
				int at21to24Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt21to24Num(at21to24Num);
				//孕28-36周检查人次
				int days28to36min = 27*7+6;
				int days28to36max = 36*7;
				conds.put("minDay", days28to36min);
				conds.put("maxDay", days28to36max);
				int at28to36Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt28to36Num(at28to36Num);
				//孕37-40周检查人次
				int days37to40min = 36*7+6;
				int days37to40max = 40*7;
				conds.put("minDay", days37to40min);
				conds.put("maxDay", days37to40max);
				int at37to40Num = achievementsDao.getPreExaNum(conds);
				doctorAchievementsPO.setAt37to40Num(at37to40Num);
				//出院后3-7天检查人次
				int post3to7Num = achievementsDao.getPost3to7Num(conds);
				doctorAchievementsPO.setPost3to7Num(post3to7Num);
				//出院后42天检查人次
				int post42Num = achievementsDao.getPost42Num(conds);
				doctorAchievementsPO.setPost42Num(post42Num);
				//血常规检查人数
				String itemsBlood = "se.HEMOGLOBIN IS NOT NULL OR se.LEUCOCYTE IS NOT NULL OR se.PLATELET IS NOT NULL";
				conds.put("items",itemsBlood);
				int bloodNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setBloodNum(bloodNum);
				//尿常规检查人数
				String itemsUrine = "se.PROTEINURIA is not null OR se.URINE_SUGAR is not null OR se.KETONE is not NULL OR se.URINE_BLOOD is not NULL";
				conds.put("items",itemsUrine);
				int urineNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setUrineNum(urineNum);
				//血型检查人数
				String itemsBloodType = "se.BLOOD_TYPE is not null OR se.BLOOD_TYPE_RH is not null OR se.BLOOD_GLUCOSE is not NULL ";
				conds.put("items",itemsBloodType);
				int bloodTypeNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setBloodTypeNum(bloodTypeNum);
				//肝功能检查人数
				String itemsLiver = "se.SGPT is not null OR se.SGOT is not null OR se.ALBUMIN is not NULL OR se.TOTAL_BILIRUBIN is not null OR se.DBIL is not NULL";
				conds.put("items",itemsLiver);
				int liverNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setLiverNum(liverNum);
				//肾功能检查人数
				String itemsKidney = "se.SCR is not null OR se.BUN is not null";
				conds.put("items",itemsKidney);
				int kidneyNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setKidneyNum(kidneyNum);
				//乙肝表抗检查人数
				String itemsHepatitisB = "se.HBSAG is not null OR se.HBSAB is not null OR se.HBCAB is not null OR se.HBEAB is not null OR se.HBEAG is not NULL";
				conds.put("items",itemsHepatitisB);
				int hepatitisBNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setHepatitisBNum(hepatitisBNum);
				//梅毒检查人数
				String itemsSyphilis = "se.SYPHILIS_SEROLOGY is not null";
				conds.put("items",itemsSyphilis);
				int syphilisNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setSyphilisNum(syphilisNum);
				//艾滋病检查人数
				String itemsAids = "se.HIVAB is not null";
				conds.put("items",itemsAids);
				int aidsNum = achievementsDao.getItemsCheckNum(conds);
				doctorAchievementsPO.setAidsNum(aidsNum);
				//产检两次以后的血红蛋白检查人数
				int hemoglobinNum = achievementsDao.getHemoglobinNum1(conds);
				doctorAchievementsPO.setHemoglobinNum(hemoglobinNum);
				//产检两次以后尿蛋白检查人数
				int  urineProteinNum = achievementsDao.getUrineProteinNum1(conds);
				doctorAchievementsPO.setUrineProteinNum(urineProteinNum);
				//结案产妇电子录入数
				int actualCloseNum = achievementsDao.getActualCloseNum1(conds);
				doctorAchievementsPO.setActualCloseNum(actualCloseNum);
			}
		}
		return list;
		}

	public void basicPublicHealthListForPage(Map<String, Object> conds,
			Page<BasicPublicHealthFeedbackStatisticsPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		
		List<BasicPublicHealthFeedbackStatisticsPO> list = new ArrayList();
		BasicPublicHealthFeedbackStatisticsPO basicPublicHealthFeedbackStatisticsPO = new BasicPublicHealthFeedbackStatisticsPO("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23");
		list.add(basicPublicHealthFeedbackStatisticsPO);
		page.setTotal(list.size());
		page.setList(list);
	}
	
	
	
}
