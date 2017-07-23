package com.threefiveninetong.mchh.reportForm.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.archives.service.ArchivesInfoService;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.MarriageRegistrationDataService;
import com.threefiveninetong.mchh.premarital.dao.PremaritalExaInfoDao;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.premarital.po.SpecialDiseaseInfoPO;
import com.threefiveninetong.mchh.premarital.service.InspectionResultService;
import com.threefiveninetong.mchh.premarital.service.PremaritalExaInfoService;
import com.threefiveninetong.mchh.premarital.service.SpecialDiseaseInfoService;
import com.threefiveninetong.mchh.reportForm.po.MaternalHealthcareConditionPO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalCheckPO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalHealthCarePO;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.Page;

@Service
public class ReportFormService {
	
	@Resource
	private  SpecialDiseaseInfoService  specialDiseaseInfoService;
	
	@Resource
	private  MarriageRegistrationDataService  marriageRegistrationDataService;
	
	@Resource
	private DistrictAndCountyInfoService districtAndCountyInfoService;
	
	@Resource
	private  PremaritalExaInfoService  premaritalExaInfoService;
	
	@Resource
	private  InspectionResultService  inspectionResultService;
	
	@Resource
	private ArchivesInfoService archivesInfoService;
	
	
	@Resource
	private  BirthArchivesInfoService  birthArchivesInfoService;
	
	@Resource
	private	PremaritalExaInfoDao premaritalExaInfoDao;
	
	public void listForPage3(Map<String, Object> conds, Page<MaternalHealthcareConditionPO> page) {
		page.setEntityOrField(true);
		conds.put("page", page);
		//①根据镇平县查询对象
//		DistrictAndCountyInfoPO countyPO = districtAndCountyInfoService.getByName("镇平县");
//		List<MaternalHealthcareConditionPO> list = null;
//		list = premaritalExaInfoDao.listForPage3(conds);
		
		List<MaternalHealthcareConditionPO> list = new ArrayList();
		MaternalHealthcareConditionPO maternalHealthcareConditionPO = new MaternalHealthcareConditionPO("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70");
		list.add(maternalHealthcareConditionPO);
		page.setTotal(list.size());
		page.setList(list);
		
	}
	
	public void listForPage2(Map<String, Object> conds, Page<PremaritalCheckPO> page) {
			
		page.setEntityOrField(true);
		conds.put("page", page);
		List<PremaritalCheckPO> list = premaritalExaInfoDao.listForPage2(conds);
		if(list!=null && list.size()>0){
			for (PremaritalCheckPO premaritalCheckPO : list) {
				//根据生日计算年龄
				Date birthday = premaritalCheckPO.getBirthday();
				if(birthday!=null){
					Integer age = DateUtils.getAgeByBirthday(birthday);
					premaritalCheckPO.setAge(age.toString());
				}
				//根据档案id拼拼出家庭地址（如果是男拼男性地址 如果是女 拼女性地址）
				String sex = premaritalCheckPO.getSex();
				String archivesId = premaritalCheckPO.getArchivesId();
				if("0".equals(sex)){
					String homeAddress = premaritalExaInfoDao.getWomanAddressByArchivesId(archivesId);
					premaritalCheckPO.setHomeAddress(homeAddress);
				}
				if("1".equals(sex)){
					String homeAddress = premaritalExaInfoDao.getManAddressByArchivesId(archivesId);
					premaritalCheckPO.setHomeAddress(homeAddress);
				}
				//根据检出疾病id查询检出疾病的名称（检出疾病的id为逗号分隔的字符串，需先分隔再查询）
				//指定传染病
				String infectiousDis = premaritalCheckPO.getInfectiousDis();
				String dises = "";
				if(infectiousDis!=null && infectiousDis!=""){
					String[] split = infectiousDis.split(",");
					for (String disId : split) {
						String disName = specialDiseaseInfoService.getDisNameById(disId);
						dises=dises+disName+",";
					}
				}
				//严重遗传病
				String geneticDis = premaritalCheckPO.getGeneticDis();
				if(geneticDis!=null && geneticDis!=""){
					String[] split = geneticDis.split(",");
					for (String disId : split) {
						String disName = specialDiseaseInfoService.getDisNameById(disId);
						dises=dises+disName+",";
					}
				}
				//精神病
				String mentalDis = premaritalCheckPO.getMentalDis();
				if(mentalDis!=null && mentalDis!=""){
					String[] split = mentalDis.split(",");
					for (String disId : split) {
						String disName = specialDiseaseInfoService.getDisNameById(disId);
						dises=dises+disName+",";
					}
				}
				//生殖系统疾病
				String reproductiveDis = premaritalCheckPO.getReproductiveDis();
				if(reproductiveDis!=null && reproductiveDis!=""){
					String[] split = reproductiveDis.split(",");
					for (String disId : split) {
						String disName = specialDiseaseInfoService.getDisNameById(disId);
						dises=dises+disName+",";
					}
				}
				//内科疾病
				String medicalDis = premaritalCheckPO.getMedicalDis();
				if(medicalDis!=null && medicalDis!=""){
					String[] split = medicalDis.split(",");
					for (String disId : split) {
						String disName = specialDiseaseInfoService.getDisNameById(disId);
						dises=dises+disName+",";
					}
				}
				premaritalCheckPO.setDises(dises);
			}
		}
		page.setList(list);
		
	}
	
	public void listForPage(Map<String, Object> conds, Page<PremaritalHealthCarePO> page) {
		
		page.setEntityOrField(true);
		conds.put("page", page);
		NumberFormat formatter = new DecimalFormat("#0.00");
		//查询结婚登记人数date1
		//①根据镇平县查询对象
		DistrictAndCountyInfoPO countyPO = districtAndCountyInfoService.getByName("镇平县");
		List<PremaritalHealthCarePO> list = null;
		if(countyPO!=null){
			String countyId = countyPO.getId();
			conds.put("countyId", countyId);
			list = marriageRegistrationDataService.listForPage(conds);
			for (PremaritalHealthCarePO premaritalHealthCarePO : list) {
				//查询婚前检查人数date2 
				List<PremaritalExaInfoPO> premaritalExaList = premaritalExaInfoService.allPremaritalExa(conds);
				if(premaritalExaList!=null){
					Integer size = premaritalExaList.size();
					String date2 = size.toString();
					premaritalHealthCarePO.setDate2(date2);
					
//					date3
					double size1 = size;
					String marryNum = premaritalHealthCarePO.getDate1();
					int parseInt = Integer.parseInt(marryNum);
					double totalNum = parseInt;
					if(size!=0 && totalNum!=0){
						double rate = size1/totalNum*100;
						String date3 = formatter.format(rate)+"%";
						premaritalHealthCarePO.setDate3(date3);
					}else{
						premaritalHealthCarePO.setDate3("0");
					}
			}
			//date4
			Integer date4 = premaritalExaInfoService.findAllAsk(conds);
			premaritalHealthCarePO.setDate4(date4.toString());
			//date5
			double num = date4;
			String marryNum = premaritalHealthCarePO.getDate1();
			int parseInt = Integer.parseInt(marryNum);
			double totalNum = parseInt;
			if(num!=0&&parseInt!=0){
				double rate = num/totalNum*100;
				String date5 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate5(date5);
			}else{
				premaritalHealthCarePO.setDate5("0");
			}
			//date6
			Integer date6 = premaritalExaInfoService.disNum(conds);
			premaritalHealthCarePO.setDate6(date6.toString());
			//date7
			String date2 = premaritalHealthCarePO.getDate2();
			double date6d = date6;
			double date2d = Integer.parseInt(date2);
			if(date2d!=0&&date6!=0){
				double rate = date6d/date2d*100;
				String date7 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate7(date7);
			}else{
				premaritalHealthCarePO.setDate7("0");
			}
			//date8
			conds.put("dis", "infectious");
			Integer date8 = premaritalExaInfoService.disNum(conds);
			premaritalHealthCarePO.setDate8(date8.toString());
			//date9
			double date8d = date8;
			if(date6d!=0&&date8d!=0){
				double rate = date8d/date6d*100;
				String date9 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate9(date9);
			}else{
				premaritalHealthCarePO.setDate9("0");
			}
			//date10
			//县查出所有的有疾病的人 封装近特殊疾病信息表中
			int date10 = 0;
			List<SpecialDiseaseInfoPO> specialDiseaseInfoList = specialDiseaseInfoService.sexDisNum(conds);
			if(specialDiseaseInfoList!=null&&specialDiseaseInfoList.size()>0){
				//取出指定传染病字段（是以；隔开的字符串,字符串为id）
				for (SpecialDiseaseInfoPO specialDiseaseInfoPO : specialDiseaseInfoList) {
					String infectiousDis = specialDiseaseInfoPO.getInfectiousDis();
					//将指定传染病字符串以；分割，将分割后的字符串封装进数组中
					String[] split = infectiousDis.split(",");
					//遍历list集合，若有 ‘淋病(性病）’ ‘梅毒（性病）’ ‘尖锐湿疣（性病）’ ‘艾滋病（性病）’其中一种的就结束遍历 得性病的人数加1
					for (String disId : split) {
						//根据字符串id查询特殊疾病名称
						String disName = specialDiseaseInfoService.getDisNameById(disId);
						if("淋病（性病）".equals(disName)){
							date10++;
							break; 
						}
						if("梅毒（性病）".equals(disName)){
							date10++;
							break; 
						}
						if("尖锐湿疣（性病）".equals(disName)){
							date10++;
							break; 
						}
						if("艾滋病（性病）".equals(disName)){
							date10++;
							break; 
						}
					}
				}
			}
			
			premaritalHealthCarePO.setDate10(date10+"");
			//date11
			double date10d = date10;
			if(date6d!=0&&date10d!=0){
				double rate = date10d/date6d*100;
				String date11 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate11(date11);
			}else{
				premaritalHealthCarePO.setDate11("0");
			}
			//date12
			conds.put("dis", "genetic");
			Integer date12 = premaritalExaInfoService.disNum(conds);
			premaritalHealthCarePO.setDate12(date12.toString());
			//date13
			double date12d = date12;
			if(date6d!=0&&date12d!=0){
				double rate = date12d/date6d*100;
				String date13 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate13(date13);
			}else{
				premaritalHealthCarePO.setDate13("0");
			}
			//date14
			conds.put("dis", "mental");
			Integer date14 = premaritalExaInfoService.disNum(conds);
			premaritalHealthCarePO.setDate14(date14.toString());
			//date15
			double date14d = date14;
			if(date6d!=0&&date14d!=0){
				double rate = date14d/date6d*100;
				String date15 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate15(date15);
			}else{
				premaritalHealthCarePO.setDate15("0");
			}
			//date16
			conds.put("dis", "reproductive");
			Integer date16 = premaritalExaInfoService.disNum(conds);
			premaritalHealthCarePO.setDate16(date16.toString());
			//date17
			double date16d = date16;
			if(date6d!=0&&date16d!=0){
				double rate = date16d/date6d*100;
				String date17 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate17(date17);
			}else{
				premaritalHealthCarePO.setDate17("0");
			}
			//date18
			conds.put("dis", "medical");
			Integer date18 = premaritalExaInfoService.disNum(conds); 	
			premaritalHealthCarePO.setDate18(date18.toString());
			//date19
			double date18d = date18;
			if(date6d!=0&&date18d!=0){
				double rate = date18d/date6d*100;
				String date19 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate19(date19);
			}else{
				premaritalHealthCarePO.setDate19("0");
			}
			//date20
			int date20 = premaritalExaInfoService.adviceNum(conds);
			premaritalHealthCarePO.setDate20(date20+"");
			//date21
			double date20d = date20;
			if(date2d!=0&&date20d!=0){
				double rate = date20d/date2d*100;
				String date21 = formatter.format(rate)+"%";
				premaritalHealthCarePO.setDate21(date21);
			}else{
				premaritalHealthCarePO.setDate21("0");
			}
		
		}
		
	}
	page.setList(list);
		
	}

	


}
