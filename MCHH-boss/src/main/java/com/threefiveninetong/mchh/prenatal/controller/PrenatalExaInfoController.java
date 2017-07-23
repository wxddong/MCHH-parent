/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalExaInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:40 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.ArchivesInfoService;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.archives.vo.ArchivesInfoVO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBabyInfoPO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBabyInfoService;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBasicInfoService;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthInfoService;
import com.threefiveninetong.mchh.config.service.CityInfoService;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaInfoService;
import com.threefiveninetong.mchh.prenatal.po.FirstGynecologicalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.FirstMotherhoodInfoPO;
import com.threefiveninetong.mchh.prenatal.po.FirstPhysicalBloodStethoscopyInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;
import com.threefiveninetong.mchh.prenatal.po.SupplementaryExamInfoPO;
import com.threefiveninetong.mchh.prenatal.service.FirstGynecologicalExaInfoService;
import com.threefiveninetong.mchh.prenatal.service.FirstMotherhoodInfoService;
import com.threefiveninetong.mchh.prenatal.service.FirstPhysicalBloodStethoscopyInfoService;
import com.threefiveninetong.mchh.prenatal.service.HighRiskInfoService;
import com.threefiveninetong.mchh.prenatal.service.HighRiskTermService;
import com.threefiveninetong.mchh.prenatal.service.PrenatalExaInfoService;
import com.threefiveninetong.mchh.prenatal.vo.FirstGynecologicalExaInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.FirstMotherhoodInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.FirstPhysicalBloodStethoscopyInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.HighRiskInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.ObstetricExaInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.PrenatalExaInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.PrenatalReferralInfoVO;
import com.threefiveninetong.mchh.prenatal.vo.SupplementaryExamInfoVO;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.po.RolePO;
import com.threefiveninetong.mchh.sys.service.DepartmentService;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.service.RoleService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: PrenatalExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:40 
 */
@Controller
@RequestMapping("/prenatal")
public class PrenatalExaInfoController {

	private static final Logger log =Logger.getLogger(PrenatalExaInfoController.class);
	
	@Resource
	private  PrenatalExaInfoService  prenatalExaInfoService;
	
	@Resource
	private OperatorService operatorService;
	
	@Resource
	private BirthArchivesInfoService birthArchivesInfoService;
	
	@Resource
	private ArchivesInfoService archivesInfoService;
	
	@Resource
	private FirstMotherhoodInfoService firstMotherhoodInfoService;
	
	@Resource
	private FirstGynecologicalExaInfoService firstGynecologicalExaInfoService;
	
	@Resource
	private FirstPhysicalBloodStethoscopyInfoService firstPhysicalBloodStethoscopyInfoService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private ProvinceInfoService provinceInfoService;
	
	@Resource
	private CityInfoService cityInfoService;
	
	@Resource
	private DistrictAndCountyInfoService districtAndCountyInfoService;
	
	@Resource
	private TownshipInfoService townshipInfoService;
	
	@Resource
	private VillageInfoService villageInfoService;
	
	@Resource
	private PostpartumExaInfoService postpartumExaInfoService;
	
	@Resource
	private ChildbirthBasicInfoService childbirthBasicInfoService;
	
	@Resource
	private ChildbirthBabyInfoService childbirthBabyInfoService;
	
	@Resource
	private ChildbirthInfoService childbirthInfoService;
	
	@Resource
	private HighRiskInfoService highRiskInfoService;
	
	@Resource
	private HighRiskTermService highRiskTermService;
	
	/**
	 * 补随访（补2到N次随访）
	 * @param birthArchivesId
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/suppleSecondToNPrenatal",method=RequestMethod.GET)
	public ModelAndView suppleSecondToNPrenatal(@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session){
		ModelAndView mv = new ModelAndView();
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.find(birthArchivesId);
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(birthArchivesInfoPO.getArchivesId());
		String time = DateUtil.dateToString(new Date(), DateStyle.YYYY_MM_DD_CN);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		Date birthday = archivesInfoPO.getBirthday();
		if(birthday != null){
			
			int age = DateUtils.getAgeByBirthday(birthday);
			mv.addObject("age", age);
		}
		
		Date manBirthday = archivesInfoPO.getManBirthday();
		if(manBirthday != null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			mv.addObject("manAge", manAge);
		}else{
			mv.addObject("manAge", null);
		}
		
		String birth = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYY_MM_DD_CN);
		List<DepartmentPO> depts = departmentService.getAllDepartment();
		mv.addObject("depts", depts);
		List<RolePO> roles = roleService.getAll();
		int count = prenatalExaInfoService.countPrenatalByBirthId(birthArchivesInfoPO.getId());
		//count>0则证明为第二次产检或者第N次产检
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthArchivesInfoPO.getId());
		//FirstMotherhoodInfoPO firstMotherhoodInfoPO = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalExaInfoPO.getId());
		Date lastMenses = birthArchivesInfoPO.getLastMenses();
		//Date lastMenses = firstMotherhoodInfoPO.getLastMenses();
		Date expectedDate = null;
		if(lastMenses != null ){
			
			int week = DateUtils.getWeekByLastMenses(lastMenses);
			expectedDate = DateUtils.expectedDate(lastMenses);
			Date nextCheckDate = DateUtils.getNextCheckDate(lastMenses);
			String nextCheck = DateUtils.dateToString(nextCheckDate,"yyyyMMdd");
			mv.addObject("nextCheck",nextCheck);
			mv.addObject("lastMenses", lastMenses);
			mv.addObject("expectedDate", expectedDate);
			mv.addObject("week", week);
		}else {
			mv.addObject("lastMenses", null);
			mv.addObject("expectedDate", null);
			mv.addObject("week", null);
			mv.addObject("nextCheck",null);
		}
		
		String riskSign = birthArchivesInfoPO.getRiskSign();
		String correct = "-1";
		if("1".equals(riskSign)){
			HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
			if(highRiskInfoPO != null){
				List<HighRiskTermPO> list = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
				int correctCount = highRiskTermService.getCountByHighRiskIdAndState(highRiskInfoPO.getId());
				if(list.size() > 0 && correctCount > 0){
					//上一次产检高危有未校正
					correct = "1";
				}else if(list.size() > 0 && correctCount == 0){
					//上一次高危但是全部矫正
					correct = "0";
				}else {
					correct = "2";
				}
			}else{
				//上一次不是高危但是曾经是高危
				correct = "3";
			}
		}
		mv.addObject("correctCount", correct);
		
		mv.addObject("count",(count+1));
		//mv.addObject("firstMotherhood", firstMotherhoodInfoPO);
		mv.setViewName("/prenatal/secend_n_prenatal_exa");
		//获取历史检查记录的列表用于历史检查记录的回显
		List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
		//获取第一次产前检查对应的历史检查记录
		HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchivesInfoPO.getId());
		if(firstHistoryCheck != null){
			historyChecks.add(firstHistoryCheck);
		}
		//获取第2-N次检查对应的历史检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesInfoPO.getId());
		if(secondOrMoreHistoryChecks != null && secondOrMoreHistoryChecks.size() > 0){
			historyChecks.addAll(secondOrMoreHistoryChecks);
		}
		mv.addObject("historyChecks", historyChecks);
		
		mv.addObject("depts", depts);
		mv.addObject("birthArchives", birthArchivesInfoPO);
		mv.addObject("roles", roles);
		mv.addObject("birth", birth);
		mv.addObject("nomal", "0");
		mv.addObject("archives", archivesInfoPO);
		mv.addObject("time", time);
		mv.addObject("operator",operator2);
		return mv;
	}
	
	/**
	 * 补卡（补第一次产前随访）
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/suppleFirstPrenatal",method=RequestMethod.GET)
	public ModelAndView suppleFirstPrenatal(@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session){
		ModelAndView mv = new ModelAndView();
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.find(birthArchivesId);
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(birthArchivesInfoPO.getArchivesId());
		String time = DateUtil.dateToString(new Date(), DateStyle.YYYY_MM_DD_CN);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		Date lastMenses = birthArchivesInfoPO.getLastMenses();
		if(lastMenses != null){
			int w = DateUtils.getWeekByLastMenses(lastMenses);
			int d = DateUtils.getDayByLastMenses(lastMenses);
			mv.addObject("w", w);
			mv.addObject("d", d);
		}
		Date birthday = archivesInfoPO.getBirthday();
		if(birthday != null){
			
			int age = DateUtils.getAgeByBirthday(birthday);
			mv.addObject("age", age);
		}
		
		Date manBirthday = archivesInfoPO.getManBirthday();
		if(manBirthday != null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			mv.addObject("manAge", manAge);
		}else{
			mv.addObject("manAge", null);
		}
		
		String birth = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYY_MM_DD_CN);
		List<DepartmentPO> depts = departmentService.getAllDepartment();
		mv.addObject("depts", depts);
		List<RolePO> roles = roleService.getAll();
		
		mv.setViewName("/prenatal/first_prenatal_exa");
		mv.addObject("birthArchives", birthArchivesInfoPO);
		mv.addObject("roles", roles);
		mv.addObject("birth", birth);
		mv.addObject("nomal", "0");
		mv.addObject("archives", archivesInfoPO);
		mv.addObject("time", time);
		mv.addObject("operator",operator2);
		return mv;
	}
	
	/**
	 * 孕产妇管理页保存修改的数据
	 * @param archivesInfoVO
	 * @param birth
	 * @param manBirth
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/affirmPrenatalSaveUpdate",method=RequestMethod.POST)
	public ModelAndView affirmPrenatalSaveUpdate(ArchivesInfoPO archivesInfoPO,
									@RequestParam("birth")String birth,
									@RequestParam("manBirth")String manBirth,
									@RequestParam(value="grantSign",required=false)String grantSign,
									@RequestParam(value="frantNum",required=false)String frantNum,
									@RequestParam(value="lastMenses",required=false,defaultValue="")String last,
									@RequestParam(value="predictDate",required=false,defaultValue="")String predict,
									HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		//ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
		Date birthday = DateUtil.stringToDate(birth);
		Date manBirthday = DateUtil.stringToDate(manBirth);
		ArchivesInfoPO archives = archivesInfoService.find(archivesInfoPO.getId());
		archivesInfoPO.setBirthday(birthday);
		archivesInfoPO.setManBirthday(manBirthday);
		archivesInfoPO.setUpdateTime(new Date());
		archivesInfoPO.setCreatTime(archives.getCreatTime());
		try {
			//BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			archivesInfoService.savePrenatalUpdate(archivesInfoPO);
		} catch (Exception e) {
		}
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.getNearBirthArchivesByArchivesId(archivesInfoPO.getId());
		String pregnantState = birthArchivesInfoPO.getPregnantState();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		BirthArchivesInfoPO birthArchives = new BirthArchivesInfoPO();
		if(("2").equals(pregnantState)){
			
			birthArchives.setArchivesId(archivesInfoPO.getId());
			birthArchives.setHospitalId(operator2.getDepId());
			birthArchives.setCreatTime(new Date());
			birthArchives.setDeltetSign("1");
			birthArchives.setId(IdUtil.uuid());
			birthArchives.setUpdateTime(new Date());
			birthArchives.setRiskSign("0");
			birthArchives.setReferralSign("0");
			birthArchives.setPregnantState("0");
			birthArchives.setGrantSign(grantSign);
			birthArchives.setFrantNum(frantNum);
			int w = 0;
			int d = 0;
			if(last != "" && last != null){
				Date lastMenses = DateUtil.stringToDate(last);
				birthArchives.setLastMenses(lastMenses);
				w = DateUtils.getWeekByLastMenses(lastMenses);
				d = DateUtils.getDayByLastMenses(lastMenses);
			}
			if(predict != "" && predict != null){
				Date predictDate = DateUtil.stringToDate(predict);
				birthArchives.setPredictDate(predictDate);
			}
			try {
				birthArchivesInfoService.create(birthArchives);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String time = DateUtil.dateToString(new Date(), DateStyle.YYYY_MM_DD_CN);
			int age = DateUtils.getAgeByBirthday(birthday);
			mv.addObject("age", age);
			if(manBirthday != null){
				int manAge = DateUtils.getAgeByBirthday(manBirthday);
				mv.addObject("manAge", manAge);
			}else{
				mv.addObject("manAge", null);
			}
			//String level = departmentService.queryQyByName(operator2.getDepartment());
			
			List<DepartmentPO> depts = departmentService.getAllDepartment();
			mv.addObject("depts", depts);
			
			List<RolePO> roles = roleService.getAll();
			if(w != 0){
				
				if(w < 13 && w > 0){
					PrenatalExaInfoPO prenatal = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchives.getId());
					if(prenatal != null){
						FirstMotherhoodInfoPO firstMoth = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatal.getId());
						if(firstMoth != null){
							int count = prenatalExaInfoService.countPrenatalByBirthId(birthArchives.getId());
							
							//count>0则证明为第二次产检或者第N次产检
							PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthArchives.getId());
							//FirstMotherhoodInfoPO firstMotherhoodInfoPO = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalExaInfoPO.getId());
							Date lastMenses = birthArchives.getLastMenses();
							//Date lastMenses = firstMotherhoodInfoPO.getLastMenses();
							Date expectedDate = null;
							if(lastMenses != null ){
								
								int week = DateUtils.getWeekByLastMenses(lastMenses);
								expectedDate = DateUtils.expectedDate(lastMenses);
								Date nextCheckDate = DateUtils.getNextCheckDate(lastMenses);
								String nextCheck = DateUtils.dateToString(nextCheckDate,"yyyy-MM-dd");
								mv.addObject("nextCheck",nextCheck);
								mv.addObject("lastMenses", lastMenses);
								mv.addObject("expectedDate", expectedDate);
								mv.addObject("week", week);
							}else {
								mv.addObject("lastMenses", null);
								mv.addObject("expectedDate", null);
								mv.addObject("week", null);
								mv.addObject("nextCheck",null);
							}
							
							String riskSign = birthArchives.getRiskSign();
							String correct = "-1";
							if("1".equals(riskSign)){
								HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
								if(highRiskInfoPO != null){
									List<HighRiskTermPO> list = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
									int correctCount = highRiskTermService.getCountByHighRiskIdAndState(highRiskInfoPO.getId());
									if(list.size() > 0 && correctCount > 0){
										//上一次产检高危有未校正
										correct = "1";
									}else if(list.size() > 0 && correctCount == 0){
										//上一次高危但是全部矫正
										correct = "0";
									}else {
										correct = "2";
									}
								}else{
									//上一次不是高危但是曾经是高危
									correct = "3";
								}
							}
							mv.addObject("correctCount", correct);
							
							mv.addObject("count",(count+1));
							//mv.addObject("firstMotherhood", firstMotherhoodInfoPO);
							mv.setViewName("/prenatal/secend_n_prenatal_exa");
							//获取历史检查记录的列表用于历史检查记录的回显
							List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
							//获取第一次产前检查对应的历史检查记录
							HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchives.getId());
							if(firstHistoryCheck!=null){
								historyChecks.add(firstHistoryCheck);
							}
							//获取第2-N次检查对应的历史检查记录
							List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchives.getId());
							if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
								historyChecks.addAll(secondOrMoreHistoryChecks);
							}
							mv.addObject("historyChecks", historyChecks);
						}else{
							
							mv.setViewName("/prenatal/first_prenatal_exa");
						}
					}else{
						
						mv.setViewName("/prenatal/first_prenatal_exa");
					}
				}else if(w >= 13){
					int count = prenatalExaInfoService.countPrenatalByBirthId(birthArchives.getId());
					//count>0则证明为第二次产检或者第N次产检
					PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthArchives.getId());
					//FirstMotherhoodInfoPO firstMotherhoodInfoPO = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalExaInfoPO.getId());
					Date lastMenses = birthArchives.getLastMenses();
					//Date lastMenses = firstMotherhoodInfoPO.getLastMenses();
					Date expectedDate = null;
					if(lastMenses != null ){
						
						int week = DateUtils.getWeekByLastMenses(lastMenses);
						expectedDate = DateUtils.expectedDate(lastMenses);
						Date nextCheckDate = DateUtils.getNextCheckDate(lastMenses);
						String nextCheck = DateUtils.dateToString(nextCheckDate,"yyyy-MM-dd");
						mv.addObject("nextCheck",nextCheck);
						mv.addObject("lastMenses", lastMenses);
						mv.addObject("expectedDate", expectedDate);
						mv.addObject("week", week);
					}else {
						mv.addObject("lastMenses", null);
						mv.addObject("expectedDate", null);
						mv.addObject("week", null);
						mv.addObject("nextCheck",null);
					}
					
					String riskSign = birthArchives.getRiskSign();
					String correct = "-1";
					if("1".equals(riskSign)){
						HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
						if(highRiskInfoPO != null){
							List<HighRiskTermPO> list = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
							int correctCount = highRiskTermService.getCountByHighRiskIdAndState(highRiskInfoPO.getId());
							if(list.size() > 0 && correctCount > 0){
								//上一次产检高危有未校正
								correct = "1";
							}else if(list.size() > 0 && correctCount == 0){
								//上一次高危但是全部矫正
								correct = "0";
							}else {
								correct = "2";
							}
						}else{
							//上一次不是高危但是曾经是高危
							correct = "3";
						}
					}
					mv.addObject("correctCount", correct);
					
					
					mv.addObject("count",(count+1));
					//mv.addObject("firstMotherhood", firstMotherhoodInfoPO);
					mv.setViewName("/prenatal/secend_n_prenatal_exa");
					//获取历史检查记录的列表用于历史检查记录的回显
					List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
					//获取第一次产前检查对应的历史检查记录
					HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchives.getId());
					if(firstHistoryCheck!=null){
						historyChecks.add(firstHistoryCheck);
					}
					//获取第2-N次检查对应的历史检查记录
					List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchives.getId());
					if(secondOrMoreHistoryChecks != null && secondOrMoreHistoryChecks.size() > 0){
						historyChecks.addAll(secondOrMoreHistoryChecks);
					}
					mv.addObject("historyChecks", historyChecks);
				}
				
			}else{
			
				if(pregnantState == null){
					
					mv.setViewName("/prenatal/first_prenatal_exa");
				}else if(("0").equals(pregnantState)){
					int count = prenatalExaInfoService.countPrenatalByBirthId(birthArchives.getId());
					if(count == 0){
						mv.setViewName("/prenatal/first_prenatal_exa");
					}
					if(count > 0){
						//count>0则证明为第二次产检或者第N次产检
						PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthArchives.getId());
						//FirstMotherhoodInfoPO firstMotherhoodInfoPO = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalExaInfoPO.getId());
						Date lastMenses = birthArchives.getLastMenses();
						//Date lastMenses = firstMotherhoodInfoPO.getLastMenses();
						Date expectedDate = null;
						if(lastMenses != null ){
							
							int week = DateUtils.getWeekByLastMenses(lastMenses);
							expectedDate = DateUtils.expectedDate(lastMenses);
							Date nextCheckDate = DateUtils.getNextCheckDate(lastMenses);
							String nextCheck = DateUtils.dateToString(nextCheckDate,"yyyy-MM-dd");
							mv.addObject("nextCheck",nextCheck);
							mv.addObject("lastMenses", lastMenses);
							mv.addObject("expectedDate", expectedDate);
							mv.addObject("week", week);
						}else {
							mv.addObject("lastMenses", null);
							mv.addObject("expectedDate", null);
							mv.addObject("week", null);
							mv.addObject("nextCheck",null);
						}
						
						String riskSign = birthArchives.getRiskSign();
						String correct = "-1";
						if("1".equals(riskSign)){
							HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
							if(highRiskInfoPO != null){
								List<HighRiskTermPO> list = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
								int correctCount = highRiskTermService.getCountByHighRiskIdAndState(highRiskInfoPO.getId());
								if(list.size() > 0 && correctCount > 0){
									//上一次产检高危有未校正
									correct = "1";
								}else if(list.size() > 0 && correctCount == 0){
									//上一次高危但是全部矫正
									correct = "0";
								}else {
									correct = "2";
								}
							}else{
								//上一次不是高危但是曾经是高危
								correct = "3";
							}
						}
						mv.addObject("correctCount", correct);
						
						mv.addObject("count",(count+1));
						//mv.addObject("firstMotherhood", firstMotherhoodInfoPO);
						mv.setViewName("/prenatal/secend_n_prenatal_exa");
						//获取历史检查记录的列表用于历史检查记录的回显
						List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
						//获取第一次产前检查对应的历史检查记录
						HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchives.getId());
						if(firstHistoryCheck!=null){
							historyChecks.add(firstHistoryCheck);
						}
						//获取第2-N次检查对应的历史检查记录
						List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchives.getId());
						if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
							historyChecks.addAll(secondOrMoreHistoryChecks);
						}
						mv.addObject("historyChecks", historyChecks);
					}
				}
			}
			mv.addObject("nomal", "1");
			mv.addObject("w", w);
			mv.addObject("d", d);
			mv.addObject("birthArchives", birthArchives);
			mv.addObject("roles", roles);
			mv.addObject("birth", birth);
			archives = archivesInfoService.find(archivesInfoPO.getId());
			mv.addObject("archives", archives);
			mv.addObject("time", time);
			mv.addObject("operator",operator2);
			//mv.setViewName("/prenatal/first_prenatal_exa");
			
		}else{
			mv.setViewName("/prenatal/prenatal_list");
			String adminId = prenatalExaInfoService.getAdminId();
			String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
			//OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			mv.addObject("adminId", adminId);
			mv.addObject("doctorAdminId", doctorAdminId);
			mv.addObject("doctorId", operator.getId());
			mv.addObject("depId", operator.getDepId());
		}
		
		return mv;
	}
	
	/**
	 * 增加产检页面跳转
	 * @param archivesId
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/affirmPrenatalArchives",method=RequestMethod.GET)
	public ModelAndView affirmPrenatalArchives(@RequestParam("archivesId")String archivesId,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(archivesId);
		if (archivesInfoPO != null) {
			mv.addObject("archives", archivesInfoPO);
		}
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		if (operatorPO != null) {
			mv.addObject("operatorPO", operatorPO);
		}
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		if (department != null) {
			mv.addObject("department", department);
		}
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			mv.addObject("age", age);
		}else{
			mv.addObject("age", null);
		}
		
		if(archivesInfoPO.getManBirthday() != null){
			int manAge = DateUtils.getAgeByBirthday(archivesInfoPO.getManBirthday());
			mv.addObject("manAge", manAge);
		}else{
			mv.addObject("manAge", null);
		}
		
		mv.addObject("accProvince", provinceInfoService.find(archivesInfoPO.getAccProvinceId()));
		mv.addObject("accCity", cityInfoService.find(archivesInfoPO.getAccCityId()));
		mv.addObject("accCounty", districtAndCountyInfoService.find(archivesInfoPO.getAccCountyId()));
		mv.addObject("accTownship", townshipInfoService.find(archivesInfoPO.getAccTownshipId()));
		mv.addObject("accVillage", villageInfoService.find(archivesInfoPO.getAccVillageId()));
		
		mv.addObject("homeProvince", provinceInfoService.find(archivesInfoPO.getHomeProvinceId()));
		mv.addObject("homeCity", cityInfoService.find(archivesInfoPO.getHomeCityId()));
		mv.addObject("homeCounty", districtAndCountyInfoService.find(archivesInfoPO.getHomeCountyId()));
		mv.addObject("homeTownship", townshipInfoService.find(archivesInfoPO.getHomeTownshipId()));
		mv.addObject("homeVillage", villageInfoService.find(archivesInfoPO.getHomeVillageId()));
		
		if(archivesInfoPO.getManAccProvinceId() != null){
			mv.addObject("manAccProvince", provinceInfoService.find(archivesInfoPO.getManAccProvinceId()));
		}
		if(archivesInfoPO.getManAccCityId() != null){
			mv.addObject("manAccCity", cityInfoService.find(archivesInfoPO.getManAccCityId()));
		}
		if(archivesInfoPO.getManAccCountyId() != null){
			mv.addObject("manAccCount", districtAndCountyInfoService.find(archivesInfoPO.getManAccCountyId()));
		}
		if(archivesInfoPO.getManAccVillageId() != null){
			mv.addObject("manAccTown", townshipInfoService.find(archivesInfoPO.getManAccTownshipId()));
		}
		if(archivesInfoPO.getManAccVillageId() != null){
			mv.addObject("manAccVill", villageInfoService.find(archivesInfoPO.getManAccVillageId()));
		}
		if(archivesInfoPO.getManHomeProvinceId() != null){
			mv.addObject("manHomeProvince", provinceInfoService.find(archivesInfoPO.getManHomeProvinceId()));
		}
		if(archivesInfoPO.getManHomeCityId() != null){
			mv.addObject("manHomeCity", cityInfoService.find(archivesInfoPO.getManHomeCityId()));
		}
		if(archivesInfoPO.getManHomeCountyId() != null){
			mv.addObject("manHomeCount", districtAndCountyInfoService.find(archivesInfoPO.getManHomeCountyId()));
		}
		if(archivesInfoPO.getManHomeTownshipId() != null){
			mv.addObject("manHomeTown", townshipInfoService.find(archivesInfoPO.getManHomeTownshipId()));
		}
		if(archivesInfoPO.getManHomeVillageId() != null){
			mv.addObject("manHomeVill", villageInfoService.find(archivesInfoPO.getManHomeVillageId()));
		}
		
		mv.setViewName("/prenatal/add_prenatal_archives");
		
		return mv;
	}
	
	/**
	 * 增加产检※不用了※
	 * @param archivesId
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/increasePrenatal",method=RequestMethod.GET)
	public ModelAndView increasePrenatal(@RequestParam("archivesId")String archivesId,HttpSession session){
		
		ModelAndView  mv = new ModelAndView();
		
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.getNearBirthArchivesByArchivesId(archivesId);
		String pregnantState = birthArchivesInfoPO.getPregnantState();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(archivesId);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		if(("2").equals(pregnantState)){
			
			BirthArchivesInfoPO birthArchives = new BirthArchivesInfoPO();
			birthArchives.setArchivesId(archivesId);
			birthArchives.setHospitalId(operator2.getDepId());
			birthArchives.setCreatTime(new Date());
			birthArchives.setDeltetSign("1");
			birthArchives.setId(IdUtil.uuid());
			birthArchives.setUpdateTime(new Date());
			birthArchives.setRiskSign("0");
			birthArchives.setReferralSign("0");
			birthArchives.setPregnantState("0");
			
			try {
				birthArchivesInfoService.create(birthArchives);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String time = DateUtil.dateToString(new Date(), DateStyle.YYYY_MM_DD_CN);
			Date birthday = archivesInfoPO.getBirthday();
			int age = DateUtils.getAgeByBirthday(birthday);
			mv.addObject("age", age);
			Date manBirthday = archivesInfoPO.getManBirthday();
			if(manBirthday != null){
				int manAge = DateUtils.getAgeByBirthday(manBirthday);
				mv.addObject("manAge", manAge);
			}else{
				mv.addObject("manAge", null);
			}
			String birth = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYY_MM_DD_CN);
			//String level = departmentService.queryQyByName(operator2.getDepartment());
			
			List<DepartmentPO> depts = departmentService.getAllDepartment();
			mv.addObject("depts", depts);
			
			List<RolePO> roles = roleService.getAll();
			
			mv.addObject("birthArchives", birthArchives);
			mv.addObject("roles", roles);
			mv.addObject("birth", birth);
			
			mv.addObject("archives", archivesInfoPO);
			mv.addObject("time", time);
			mv.addObject("operator",operator2);
			mv.setViewName("/prenatal/first_prenatal_exa");
		}else{
			mv.setViewName("/prenatal/prenatal_list");
			String adminId = prenatalExaInfoService.getAdminId();
			String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
			//OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			mv.addObject("adminId", adminId);
			mv.addObject("doctorAdminId", doctorAdminId);
			mv.addObject("doctorId", operator.getId());
			mv.addObject("depId", operator.getDepId());
		}
		
		return mv;
	}
	
	/**
	 * 孕产妇管理页进入产检判断当前产检数据是保存还是完成来进入对应的产检页面
	 * @param pranatalId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/selectTo1Or2",method=RequestMethod.GET)
	public ModelAndView selectTo1Or2(@RequestParam("prenatalId")String prenatalId){
		
		ModelAndView mv = new ModelAndView();
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.find(prenatalId);
		int count = prenatalExaInfoService.countByBirthId(prenatalExaInfoPO.getBirthArchivesId());
		FirstMotherhoodInfoPO firstMoth = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalId);
		if(firstMoth != null){
			//第一次
			Map<String, Object> map = prenatalExaInfoService.firstPrenatalPreview(prenatalId);
			PrenatalExaInfoPO prenatal = (PrenatalExaInfoPO) map.get("prenatalExa");
			OperatorPO operatorPO = operatorService.getOperatorById(prenatal.getDoctorId());
			BirthArchivesInfoPO birthArchives = (BirthArchivesInfoPO) map.get("birthArchives");
			Date predictDate = birthArchives.getPredictDate();
			//String level = departmentService.queryQyByName(operatorPO.getDepartment());
			List<DepartmentPO> depts = departmentService.getAllDepartment();
			mv.addObject("depts", depts);
			List<RolePO> roles = roleService.getAll();
			mv.setViewName("/prenatal/first_prenatal_list_edit");
			map.put("expectedDate", predictDate);
			mv.addObject("map", map);
			mv.addObject("operatorPO", operatorPO);
			mv.addObject("roles", roles);
		}
		if(firstMoth == null){
			//2到N次
			Map<String, Object> map = prenatalExaInfoService.prenatalPreview2ToN(prenatalId);
			PrenatalExaInfoPO prenatal = (PrenatalExaInfoPO) map.get("prenatal");
			OperatorPO operatorPO = operatorService.getOperatorById(prenatal.getDoctorId());
			BirthArchivesInfoPO birthArchives = (BirthArchivesInfoPO) map.get("birthArchives");
			//Date predictDate = birthArchives.getPredictDate();
			//String level = departmentService.queryQyByName(operatorPO.getDepartment());
			List<DepartmentPO> depts = departmentService.getAllDepartment();
			List<RolePO> roles = roleService.getAll();
			mv.addObject("roles", roles);
			mv.addObject("depts", depts);
			mv.setViewName("/prenatal/secend_n_prenatal_list_edit");
			//map.put("expectedDate", predictDate);
			mv.addObject("map", map);
			mv.addObject("operatorPO", operatorPO);
			mv.addObject("count",count);
			//获取历史检查记录的列表用于历史检查记录的回显
			List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
			//获取第一次产前检查对应的历史检查记录
			HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchives.getId());
			if(firstHistoryCheck!=null){
				historyChecks.add(firstHistoryCheck);
			}
			//获取第2-N次检查对应的历史检查记录
			List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchives.getId());
			if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
				historyChecks.addAll(secondOrMoreHistoryChecks);
			}
			mv.addObject("historyChecks", historyChecks);
		}
		return mv;
	}
	
	/**
	 * 孕产妇管理历史检查记录-已结案
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/prenatalOverHistory",method=RequestMethod.GET)
	public ModelAndView prenatalOverHistory(@RequestParam("birthArchivesId")String birthArchivesId){
		
		ModelAndView mv = new ModelAndView();
		
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.find(birthArchivesId);
		
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(birthArchivesInfoPO.getArchivesId());
		ChildbirthBasicInfoPO childbirthBasicInfoPO = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
		
		if(childbirthBasicInfoPO != null){
			
			ChildbirthInfoPO childbirthInfoPO = childbirthInfoService.getChildbirthByBasicId(childbirthBasicInfoPO.getId());
			if(childbirthInfoPO != null){
				List<ChildbirthBabyInfoPO> childbirthBabys = childbirthBabyInfoService.getBabyInfoByChildbirthId(childbirthInfoPO.getId());
				mv.addObject("childbirthBabys", childbirthBabys);
			}
		}
		
		
		List<PostpartumExaInfoPO> post3To7Exas = postpartumExaInfoService.getPost3To7ExaByBirthId(birthArchivesId);
		List<PostpartumExaInfoPO> post42Exas = postpartumExaInfoService.getPost42ExaByBirthId(birthArchivesId);
		
		mv.addObject("post3to7Size", post3To7Exas.size());
		mv.addObject("post42Size", post42Exas.size());
		
		if(birthArchivesInfoPO.getLastMenses()!= null){
			int week = DateUtils.getWeekByLastMenses(birthArchivesInfoPO.getLastMenses());
			mv.addObject("week", week);
		}else{
			mv.addObject("week", null);
		}
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			mv.addObject("age", age);
		}else{
			mv.addObject("age", null);
		}
		if(archivesInfoPO.getManBirthday() != null){
			int manAge = DateUtils.getAgeByBirthday(archivesInfoPO.getManBirthday());
			mv.addObject("manAge", manAge);
		}else{
			mv.addObject("manAge", null);
		}
		
		//获取历史检查记录的列表用于历史检查记录的回显
		List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
		//获取第一次产前检查对应的历史检查记录
		HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchivesId);
		if(firstHistoryCheck!=null){
			historyChecks.add(firstHistoryCheck);
		}
		//获取第2-N次检查对应的历史检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesId);
		if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
			historyChecks.addAll(secondOrMoreHistoryChecks);
		}
		//获取出院3-7天和产后检查对应的历史检查记录
		/*List<HistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostHistoryChecks(birthArchivesId);
		historyChecks.addAll(postpartumHistoryChecks);*/
		mv.addObject("post3To7Exas", post3To7Exas);
		mv.addObject("post42Exas", post42Exas);
		mv.addObject("childbirthBasic", childbirthBasicInfoPO);
		
		mv.addObject("historyChecks", historyChecks);
		mv.addObject("birthArchives", birthArchivesInfoPO);
		mv.addObject("archives", archivesInfoPO);
		mv.setViewName("/prenatal/prenatal_over_history");
		return mv;
	}
	
	/**
	 * 孕产妇管理历史检查记录-已分娩
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/prenatalChildbirthHistory",method=RequestMethod.GET)
	public ModelAndView prenatalChildbirthHistory(@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.find(birthArchivesId);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(birthArchivesInfoPO.getArchivesId());
		List<PrenatalExaInfoPO> prenatalList = prenatalExaInfoService.getAllPrenatalByBirthId(birthArchivesId);
		String nn = "0";
		for (PrenatalExaInfoPO prenatalExaInfoPO : prenatalList) {
			FirstMotherhoodInfoPO f = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalExaInfoPO.getId());
			if(f != null){
				nn = "1";
			}
		}
		mv.addObject("nn", nn);
		PrenatalExaInfoPO prenatal = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchivesId);
		String nomal = "";
		if(prenatal != null){
			FirstMotherhoodInfoPO firstMoth = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatal.getId());
			if(firstMoth == null){
				nomal = "0";
				
			}
		}else{
			nomal = "-1";
		}
		mv.addObject("nomal", nomal);
		ChildbirthBasicInfoPO childbirthBasicInfoPO = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesInfoPO.getId());
		String nomal1 = "";
		String nomal2 = "";
		if(childbirthBasicInfoPO != null){
			ChildbirthInfoPO childbirthInfoPO = childbirthInfoService.getChildbirthByBasicId(childbirthBasicInfoPO.getId());
			Date birthDate = childbirthBasicInfoPO.getBirthDate();
			if(birthDate != null){
				long day = DateUtils.subtractDate(birthDate, new Date());
				if(day > 42l){
					nomal2 = "2";
				}
			}
			
			if(childbirthInfoPO != null){
				List<ChildbirthBabyInfoPO> childbirthBabys = childbirthBabyInfoService.getBabyInfoByChildbirthId(childbirthInfoPO.getId());
				mv.addObject("childbirthBabys", childbirthBabys);
				
			}
		}else{
			nomal1 = "1";
		}
		mv.addObject("nomal1", nomal1);
		
		List<PostpartumExaInfoPO> post3To7 = postpartumExaInfoService.getPost3To7ExaByBirthId(birthArchivesId);
		List<PostpartumExaInfoPO> post42 = postpartumExaInfoService.getPost42ExaByBirthId(birthArchivesId);
		if(childbirthBasicInfoPO == null){
			if(post3To7.size() == 0 && post42.size() > 0){
				nomal2 = "2";
			}
			if(post3To7.size() > 0 && post42.size() == 0){
				Date creatTime = post3To7.get(0).getCreatTime();
				long day = DateUtils.subtractDate(creatTime, new Date());
				if(day > 35l){
					nomal2 = "2";
				}
			}
		}
		mv.addObject("nomal2", nomal2);
		if(birthArchivesInfoPO.getLastMenses() != null){
			
			int week = DateUtils.getWeekByLastMenses(birthArchivesInfoPO.getLastMenses());
			mv.addObject("week", week);
		}else{
			mv.addObject("week", null);
		}
		int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
		mv.addObject("age", age);
		if(archivesInfoPO.getManBirthday() != null){
			int manAge = DateUtils.getAgeByBirthday(archivesInfoPO.getManBirthday());
			mv.addObject("manAge", manAge);
		}else{
			mv.addObject("manAge", null);
		}
		//获取历史检查记录的列表用于历史检查记录的回显
		List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
		//获取第一次产前检查对应的历史检查记录
		HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchivesId);
		if(firstHistoryCheck!=null){
			historyChecks.add(firstHistoryCheck);
		}
		//获取第2-N次检查对应的历史检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesId);
		if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
			historyChecks.addAll(secondOrMoreHistoryChecks);
		}
		//获取出院3-7天和产后检查对应的历史检查记录
		/*List<HistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostHistoryChecks(birthArchivesId);
		historyChecks.addAll(postpartumHistoryChecks);*/
		mv.addObject("post3To7Exas", post3To7);
		mv.addObject("post42Exas", post42);
		
		mv.addObject("post3to7Size", post3To7.size());
		mv.addObject("post42Size", post42.size());
		mv.addObject("childbirthBasic", childbirthBasicInfoPO);
		mv.addObject("historyChecks", historyChecks);
		mv.addObject("birthArchives", birthArchivesInfoPO);
		mv.addObject("archives", archivesInfoPO);
		mv.addObject("operator", operator);
		mv.setViewName("/prenatal/prenatal_childbirth_history");
		return mv;
	}
	
	/**
	 * 孕产妇管理历史检查记录-妊娠中
	 * @param birthArchivesId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/prenatalGestationHistory",method=RequestMethod.GET)
	public ModelAndView prenatalGestationHistory(@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.find(birthArchivesId);
		
		PrenatalExaInfoPO prenatal = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchivesId);
		String nomal = "";
		if(prenatal != null){
			FirstMotherhoodInfoPO firstMoth = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatal.getId());
			if(firstMoth != null){
				nomal = "1";
			}else{
				nomal = "0";
			}
		}else{
			nomal = "2";
		}
		mv.addObject("nomal", nomal);
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(birthArchivesInfoPO.getArchivesId());
		
		if(birthArchivesInfoPO.getLastMenses() != null){
			
			int week = DateUtils.getWeekByLastMenses(birthArchivesInfoPO.getLastMenses());
			mv.addObject("week", week);
		}
		
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			mv.addObject("age", age);
		}
		int manAge = 0;
		if(archivesInfoPO.getManBirthday() != null){
			manAge = DateUtils.getAgeByBirthday(archivesInfoPO.getManBirthday());
		}
		mv.addObject("manAge", manAge);
		//获取历史检查记录的列表用于历史检查记录的回显
		List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
		//获取第一次产前检查对应的历史检查记录
		HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchivesId);
		if(firstHistoryCheck!=null){
			historyChecks.add(firstHistoryCheck);
		}
		//获取第2-N次检查对应的历史检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesId);
		if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
			historyChecks.addAll(secondOrMoreHistoryChecks);
		}
		mv.addObject("historyChecks", historyChecks);
		mv.addObject("birthArchives", birthArchivesInfoPO);
		mv.addObject("archives", archivesInfoPO);
		mv.addObject("operator", operator);
		mv.setViewName("/prenatal/prenatal_gestation_history");
		return mv;
	}
	
	/**
	 * 孕产妇管理删除
	 * @param archivesId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/prenatalDelArchives")
	public ModelAndView prenatalDelArchives(@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		//archivesInfoService.prenatalDelArchivesById(archivesId);
		birthArchivesInfoService.delBirthArchivesByBirthId(birthArchivesId);
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		return mv;
	}
	
	/**
	 * 孕产妇管理页保存修改的数据
	 * @param archivesInfoVO
	 * @param birth
	 * @param manBirth
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/saveUpdate",method=RequestMethod.POST)
	public ModelAndView saveUpdate(ArchivesInfoVO archivesInfoVO,
									@RequestParam("birthday")String birth,
									@RequestParam("manBirthday")String manBirth,
									@RequestParam(value="lastMenses",required=false,defaultValue="")String last,
									@RequestParam(value="predictDate",required=false,defaultValue="")String predict,
									@RequestParam(value="cteatDate",required=false,defaultValue="")String creatDate,
									@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
		Date birthday = DateUtil.stringToDate(birth);
		Date manBirthday = DateUtil.stringToDate(manBirth);
		
		ArchivesInfoPO find = archivesInfoService.find(archivesInfoVO.getId());
		
		Date creat = find.getCreatTime();
		String creatStr = DateUtil.dateToString(creat, DateStyle.YYYYMMDD);
		if(creatDate != null){
			if(!creatDate.equals(creatStr)){
				Date creatTime = DateUtil.stringToDate(creatDate);
				BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
				if(last != "" && last != null){
					Date lastMenses = DateUtil.stringToDate(last);
					birthArchivesInfoPO.setLastMenses(lastMenses);
				}
				if(predict != "" && predict != null){
					Date predictDate = DateUtil.stringToDate(predict);
					birthArchivesInfoPO.setPredictDate(predictDate);
				}
				birthArchivesInfoPO.setId(birthArchivesId);
				birthArchivesInfoPO.setCreatTime(creatTime);
				birthArchivesInfoPO.setUpdateTime(new Date());
				birthArchivesInfoService.saveBirthArchivesUpdate(birthArchivesInfoPO);
			}else{
				BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
				if(last != "" && last != null){
					Date lastMenses = DateUtil.stringToDate(last);
					birthArchivesInfoPO.setLastMenses(lastMenses);
				}
				if(predict != "" && predict != null){
					Date predictDate = DateUtil.stringToDate(predict);
					birthArchivesInfoPO.setPredictDate(predictDate);
				}
				birthArchivesInfoPO.setId(birthArchivesId);
				birthArchivesInfoPO.setUpdateTime(new Date());
				birthArchivesInfoService.saveBirthArchivesToUpdate(birthArchivesInfoPO);
			}
			
		}
		
		Date creatTime = DateUtil.stringToDate(creatDate);
		archivesInfoVO.setCreatTime(creatTime);
		archivesInfoVO.setUpdateTime(new Date());
		
		archivesInfoVO.setBirthday(birthday);
		archivesInfoVO.setManBirthday(manBirthday);
		
		try {
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			archivesInfoService.savePrenatalUpdate(archivesInfoPO);
			
		} catch (Exception e) {
		}
		
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		return mv;
	}
	
	/**
	 * 孕产妇管理修改页面传参
	 * @param id
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/toUpdate",method=RequestMethod.GET)
	public ModelAndView toUpdate(@RequestParam("id")String id,@RequestParam("birthId")String birthId){
		ModelAndView mv = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(id);
		if (archivesInfoPO != null) {
			mv.addObject("archives", archivesInfoPO);
		}
		//获取最新的生育档案信息
		BirthArchivesInfoPO birthArchives = birthArchivesInfoService.find(birthId);
		mv.addObject("birthArchives", birthArchives);
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		if (operatorPO != null) {
			mv.addObject("operatorPO", operatorPO);
		}
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		if (department != null) {
			mv.addObject("department", department);
		}
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			mv.addObject("age", age);
		}else{
			mv.addObject("age", null);
		}
		int manAge = 0;
		if(archivesInfoPO.getManBirthday() != null){
			manAge = DateUtils.getAgeByBirthday(archivesInfoPO.getManBirthday());
		}
		mv.addObject("manAge", manAge);
		
		mv.addObject("accProvince", provinceInfoService.find(archivesInfoPO.getAccProvinceId()));
		mv.addObject("accCity", cityInfoService.find(archivesInfoPO.getAccCityId()));
		mv.addObject("accCounty", districtAndCountyInfoService.find(archivesInfoPO.getAccCountyId()));
		mv.addObject("accTownship", townshipInfoService.find(archivesInfoPO.getAccTownshipId()));
		mv.addObject("accVillage", villageInfoService.find(archivesInfoPO.getAccVillageId()));
		
		mv.addObject("homeProvince", provinceInfoService.find(archivesInfoPO.getHomeProvinceId()));
		mv.addObject("homeCity", cityInfoService.find(archivesInfoPO.getHomeCityId()));
		mv.addObject("homeCounty", districtAndCountyInfoService.find(archivesInfoPO.getHomeCountyId()));
		mv.addObject("homeTownship", townshipInfoService.find(archivesInfoPO.getHomeTownshipId()));
		mv.addObject("homeVillage", villageInfoService.find(archivesInfoPO.getHomeVillageId()));
		
		if(archivesInfoPO.getManAccProvinceId() != null){
			mv.addObject("manAccProvince", provinceInfoService.find(archivesInfoPO.getManAccProvinceId()));
		}
		if(archivesInfoPO.getManAccCityId() != null){
			mv.addObject("manAccCity", cityInfoService.find(archivesInfoPO.getManAccCityId()));
		}
		if(archivesInfoPO.getManAccCountyId() != null){
			mv.addObject("manAccCount", districtAndCountyInfoService.find(archivesInfoPO.getManAccCountyId()));
		}
		if(archivesInfoPO.getManAccVillageId() != null){
			mv.addObject("manAccTown", townshipInfoService.find(archivesInfoPO.getManAccTownshipId()));
		}
		if(archivesInfoPO.getManAccVillageId() != null){
			mv.addObject("manAccVill", villageInfoService.find(archivesInfoPO.getManAccVillageId()));
		}
		if(archivesInfoPO.getManHomeProvinceId() != null){
			mv.addObject("manHomeProvince", provinceInfoService.find(archivesInfoPO.getManHomeProvinceId()));
		}
		if(archivesInfoPO.getManHomeCityId() != null){
			mv.addObject("manHomeCity", cityInfoService.find(archivesInfoPO.getManHomeCityId()));
		}
		if(archivesInfoPO.getManHomeCountyId() != null){
			mv.addObject("manHomeCount", districtAndCountyInfoService.find(archivesInfoPO.getManHomeCountyId()));
		}
		if(archivesInfoPO.getManHomeVillageId() != null){
			mv.addObject("manHomeTown", townshipInfoService.find(archivesInfoPO.getManHomeTownshipId()));
		}
		if(archivesInfoPO.getManHomeVillageId() != null){
			mv.addObject("manHomeVill", villageInfoService.find(archivesInfoPO.getManHomeVillageId()));
		}
		
		mv.setViewName("/prenatal/prenatal_list_update");
		return mv;
	}
	
	/**
	 * 孕产妇管理详情弹窗
	 * @param id
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam("id")String id,@RequestParam("birthId")String birthId) {
		ModelAndView mv = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(id);
		if (archivesInfoPO != null) {
			mv.addObject("archives", archivesInfoPO);
		}
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		if (operatorPO != null) {
			mv.addObject("operatorPO", operatorPO);
		}
		
		BirthArchivesInfoPO birthArchives = birthArchivesInfoService.find(birthId);
		mv.addObject("birthArchives", birthArchives);
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		if (department != null) {
			mv.addObject("department", department);
		}
		if(archivesInfoPO.getBirthday() != null){
			
			int age = DateUtils.getAgeByBirthday(archivesInfoPO.getBirthday());
			mv.addObject("age", age);
		}else{
			mv.addObject("age", null);
		}
		int manAge = 0;
		if(archivesInfoPO.getManBirthday() != null){
			manAge = DateUtils.getAgeByBirthday(archivesInfoPO.getManBirthday());
		}
		mv.addObject("manAge", manAge);
		
		try{
		//户口地址
		String accAddress = provinceInfoService.find(archivesInfoPO.getAccProvinceId()).getName()+"省 "+
							cityInfoService.find(archivesInfoPO.getAccCityId()).getName()+"市 "+
							districtAndCountyInfoService.find(archivesInfoPO.getAccCountyId()).getName()+"县(区) "+
							townshipInfoService.find(archivesInfoPO.getAccTownshipId()).getName()+"乡(街道) "+
							villageInfoService.find(archivesInfoPO.getAccVillageId()).getName()+"村(号) "+
							archivesInfoPO.getAccAddress();
		mv.addObject("accAddress", accAddress);
		}catch (Exception e) {
		}
		
		try{
		//家庭地址
		String homeAddress = provinceInfoService.find(archivesInfoPO.getHomeProvinceId()).getName()+"省 "+
							cityInfoService.find(archivesInfoPO.getHomeCityId()).getName()+"市 "+
							districtAndCountyInfoService.find(archivesInfoPO.getHomeCountyId()).getName()+"县(区) "+
							townshipInfoService.find(archivesInfoPO.getHomeTownshipId()).getName()+"乡(街道) "+
							villageInfoService.find(archivesInfoPO.getHomeVillageId()).getName()+"村(号) "+
							archivesInfoPO.getHomeAddress();
		mv.addObject("homeAddress", homeAddress);
		}catch (Exception e) {
		}
		try{
		//男性户口地址
		String manAccAdd = provinceInfoService.find(archivesInfoPO.getManAccProvinceId()).getName()+"省 "+
							cityInfoService.find(archivesInfoPO.getManAccCityId()).getName()+"市 "+
							districtAndCountyInfoService.find(archivesInfoPO.getManAccCountyId()).getName()+"县(区) "+
							townshipInfoService.find(archivesInfoPO.getManAccTownshipId()).getName()+"乡(街道) "+
							villageInfoService.find(archivesInfoPO.getManAccVillageId()).getName()+"村(号) "+
							archivesInfoPO.getManAccAddress();
		mv.addObject("manAccAdd", manAccAdd);
		}catch (Exception e) {
		}
		try{
		//男性家庭地址
		String manHomeAdd = provinceInfoService.find(archivesInfoPO.getManHomeProvinceId()).getName()+"省 "+
							cityInfoService.find(archivesInfoPO.getManHomeCityId()).getName()+"市 "+
							districtAndCountyInfoService.find(archivesInfoPO.getManHomeCountyId()).getName()+"县(区) "+
							townshipInfoService.find(archivesInfoPO.getManHomeTownshipId()).getName()+"乡(街道) "+
							villageInfoService.find(archivesInfoPO.getManHomeVillageId()).getName()+"村(号) "+
							archivesInfoPO.getManHomeAddress();
		
		mv.addObject("manHomeAdd", manHomeAdd);
		}catch (Exception e) {
		}
		mv.setViewName("/prenatal/prenatal_list_detail");
		return mv;
	}
	
	
	/**
	 * 第一次产检详情编辑保存
	 * @param prenatalId
	 * @param archivesCode
	 * @param last
	 * @param next
	 * @param highRiskId
	 * @param firstMotherhoodInfoVO
	 * @param firstPhysicalBloodStethoscopyInfoVO
	 * @param firstGynecologicalExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 * @author yanwk 
	 */
	@RequestMapping(value="/listEditFirstPrenatalExa",method=RequestMethod.POST)
	public ModelAndView listEditFirstPrenatal(@RequestParam("prenatalId")String prenatalId,
			@RequestParam("archivesCode")String archivesCode,
			@RequestParam(value="lastMenses",required=false,defaultValue="")String last,
			@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
			@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
			@RequestParam(value="checkDate",required= false,defaultValue="")String checkDate,
			FirstMotherhoodInfoVO firstMotherhoodInfoVO,
			FirstPhysicalBloodStethoscopyInfoVO firstPhysicalBloodStethoscopyInfoVO,
			FirstGynecologicalExaInfoVO firstGynecologicalExaInfoVO,
			SupplementaryExamInfoVO supplementaryExamInfoVO,
			PrenatalExaInfoVO prenatalExaInfoVO,
			PrenatalReferralInfoVO prenatalReferralInfoVO,
			HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		
		PrenatalExaInfoPO find = prenatalExaInfoService.find(prenatalId);
		Date createTime = find.getCreatTime();
		if(checkDate != null && checkDate != ""){
			Date create = DateUtil.stringToDate(checkDate);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		
		if(last != ""&& last != null){
			Date lastMenses = DateUtil.stringToDate(last);
			firstMotherhoodInfoVO.setLastMenses(lastMenses);
		}
		if(next != ""&& next != null){
			Date nextFollowingDate = DateUtil.stringToDate(next);
			prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
		}
		
		FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
		FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO = new FirstPhysicalBloodStethoscopyInfoPO();
		FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = new FirstGynecologicalExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setId(prenatalId);
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("0");
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		
		try {
			BeanUtils.copyProperties(firstMotherhoodInfoPO, firstMotherhoodInfoVO);
			BeanUtils.copyProperties(firstPhysicalBloodStethoscopyInfoPO, firstPhysicalBloodStethoscopyInfoVO);
			BeanUtils.copyProperties(firstGynecologicalExaInfoPO, firstGynecologicalExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalExaInfoService.editFirstPrenatal(archivesCode,
					firstMotherhoodInfoPO,
					firstPhysicalBloodStethoscopyInfoPO,
					firstGynecologicalExaInfoPO,
					supplementaryExamInfoPO,
					prenatalExaInfoPO,
					prenatalReferralInfoPO,
					highRiskId,operator.getDepId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		//OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		return mv;
	}
	/**
	 * 第一次产检详情编辑完成
	 * @param prenatalId
	 * @param archivesCode
	 * @param last
	 * @param next
	 * @param highRiskId
	 * @param firstMotherhoodInfoVO
	 * @param firstPhysicalBloodStethoscopyInfoVO
	 * @param firstGynecologicalExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 * @author yanwk 
	 */
	@RequestMapping(value="/editFirstExa",method=RequestMethod.POST)
	public ModelAndView editFirstPrenatal(@RequestParam("prenatalId")String prenatalId,
										@RequestParam("archivesCode")String archivesCode,
										@RequestParam(value="lastMenses",required=false,defaultValue="")String last,
										@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
										@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
										@RequestParam(value="checkDate",required= false,defaultValue="")String checkDate,
										FirstMotherhoodInfoVO firstMotherhoodInfoVO,
										FirstPhysicalBloodStethoscopyInfoVO firstPhysicalBloodStethoscopyInfoVO,
										FirstGynecologicalExaInfoVO firstGynecologicalExaInfoVO,
										SupplementaryExamInfoVO supplementaryExamInfoVO,
										PrenatalExaInfoVO prenatalExaInfoVO,
										PrenatalReferralInfoVO prenatalReferralInfoVO,
										HttpSession session){
							
			ModelAndView mv = new ModelAndView();
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
				String evaluateRemark = (String) session.getAttribute("evaluateRemark");
				prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
			}
			session.removeAttribute("evaluateRemark");
			PrenatalExaInfoPO find = prenatalExaInfoService.find(prenatalId);
			Date createTime = find.getCreatTime();
			if(checkDate != null && checkDate != ""){
				Date create = DateUtil.stringToDate(checkDate);
				createTime.setYear(create.getYear());
				createTime.setMonth(create.getMonth());
				createTime.setDate(create.getDate());
			}
			if(last != ""&& last != null){
				Date lastMenses = DateUtil.stringToDate(last);
				firstMotherhoodInfoVO.setLastMenses(lastMenses);
			}
			if(next != ""&& next != null){
				Date nextFollowingDate = DateUtil.stringToDate(next);
				prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
			}
			
			FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
			FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO = new FirstPhysicalBloodStethoscopyInfoPO();
			FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = new FirstGynecologicalExaInfoPO();
			SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
			PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
			prenatalExaInfoVO.setId(prenatalId);
			prenatalExaInfoVO.setCreatTime(createTime);
			prenatalExaInfoVO.setUpdateTime(new Date());
			prenatalExaInfoVO.setDoctorId(operator.getId());
			prenatalExaInfoVO.setEditStatus("1");
			PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
			
			try {
			BeanUtils.copyProperties(firstMotherhoodInfoPO, firstMotherhoodInfoVO);
			BeanUtils.copyProperties(firstPhysicalBloodStethoscopyInfoPO, firstPhysicalBloodStethoscopyInfoVO);
			BeanUtils.copyProperties(firstGynecologicalExaInfoPO, firstGynecologicalExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalExaInfoService.editFirstPrenatal(archivesCode,
									firstMotherhoodInfoPO,
									firstPhysicalBloodStethoscopyInfoPO,
									firstGynecologicalExaInfoPO,
									supplementaryExamInfoPO,
									prenatalExaInfoPO,
									prenatalReferralInfoPO,
									highRiskId,operator.getId());
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			mv.setViewName("/prenatal/prenatal_list");
			String adminId = prenatalExaInfoService.getAdminId();
			String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
			//OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			mv.addObject("adminId", adminId);
			mv.addObject("doctorAdminId", doctorAdminId);
			mv.addObject("doctorId", operator.getId());
			mv.addObject("depId", operator.getDepId());
			return mv;
	}
	
	/**
	 * 2到N次产前随访编辑保存
	 * @param prenatalId
	 * @param archivesCode
	 * @param next
	 * @param highRiskId
	 * @param obstertrivcExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/listEditPrenatal2ToN",method=RequestMethod.POST)
	public ModelAndView listEdit2ToNPrenatal(@RequestParam("prenatalId")String prenatalId,
			@RequestParam("archivesCode")String archivesCode,
			@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
			@RequestParam(value="checkTime",required=false,defaultValue="")String checkTime,
			@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
			ObstetricExaInfoVO obstertrivcExaInfoVO,
			SupplementaryExamInfoVO supplementaryExamInfoVO,
			PrenatalExaInfoVO prenatalExaInfoVO,
			PrenatalReferralInfoVO prenatalReferralInfoVO,
			HttpSession session){
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		PrenatalExaInfoPO find = prenatalExaInfoService.find(prenatalId);
		Date createTime = find.getCreatTime();
		if(checkTime != null && checkTime != ""){
			Date create = DateUtil.stringToDate(checkTime);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		
		ObstetricExaInfoPO obstetricExaInfoPO = new ObstetricExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setId(prenatalId);
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("0");
		if(next != null && next != ""){
			Date nextFollowingDate = DateUtil.stringToDate(next);
			prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
		}
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		
		try {
			BeanUtils.copyProperties(obstetricExaInfoPO, obstertrivcExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalExaInfoService.edit2ToNPrenatal(archivesCode,
					obstetricExaInfoPO,
					supplementaryExamInfoPO,
					prenatalExaInfoPO,
					prenatalReferralInfoPO,
					highRiskId,operator.getDepId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		mv.setViewName("prenatal/prenatal_list");
		
		return mv;
		
	}
	/**
	 * 2到N次产前随访编辑完成
	 * @param prenatalId
	 * @param archivesCode
	 * @param next
	 * @param highRiskId
	 * @param obstertrivcExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/editPrenatal2ToN",method=RequestMethod.POST)
	public ModelAndView edit2ToNPrenatal(@RequestParam("prenatalId")String prenatalId,
										@RequestParam("archivesCode")String archivesCode,
										@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
										@RequestParam(value="checkTime",required=false,defaultValue="")String checkTime,
										@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
										ObstetricExaInfoVO obstertrivcExaInfoVO,
										SupplementaryExamInfoVO supplementaryExamInfoVO,
										PrenatalExaInfoVO prenatalExaInfoVO,
										PrenatalReferralInfoVO prenatalReferralInfoVO,
										HttpSession session){
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		
		PrenatalExaInfoPO find = prenatalExaInfoService.find(prenatalId);
		Date createTime = find.getCreatTime();
		if(checkTime != null && checkTime != ""){
			Date create = DateUtil.stringToDate(checkTime);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		
		ObstetricExaInfoPO obstetricExaInfoPO = new ObstetricExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setId(prenatalId);
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("1");
		if(next != null && next != ""){
			Date nextFollowingDate = DateUtil.stringToDate(next);
			prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
		}
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		
		try {
		BeanUtils.copyProperties(obstetricExaInfoPO, obstertrivcExaInfoVO);
		BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
		BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
		BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
		prenatalExaInfoService.edit2ToNPrenatal(archivesCode,
								obstetricExaInfoPO,
								supplementaryExamInfoPO,
								prenatalExaInfoPO,
								prenatalReferralInfoPO,
								highRiskId,operator.getDepId());
		} catch (Exception e) {
		e.printStackTrace();
		} 
		mv.setViewName("prenatal/prenatal_list");
		
		return mv;
										
	}
	
	/**
	 * 2到n次产前随访编辑页面
	 * @param prenatalId
	 * @param count
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/2ToNPrenatalEdit",method=RequestMethod.GET)
	public ModelAndView edit2ToNPrenatalView(@RequestParam("prenatalId")String prenatalId,@RequestParam("count")String count,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> map = prenatalExaInfoService.prenatalPreview2ToN(prenatalId);
		PrenatalExaInfoPO prenatal = (PrenatalExaInfoPO) map.get("prenatal");
		OperatorPO operatorPO = operatorService.getOperatorById(prenatal.getDoctorId());
		BirthArchivesInfoPO birthArchives = (BirthArchivesInfoPO) map.get("birthArchives");
		//Date predictDate = birthArchives.getPredictDate();
		//String level = departmentService.queryQyByName(operatorPO.getDepartment());
		List<DepartmentPO> depts = departmentService.getAllDepartment();
		mv.addObject("depts", depts);
		List<RolePO> roles = roleService.getAll();
		mv.addObject("roles", roles);
		mv.setViewName("/prenatal/secend_n_prenatal_edit");
		//map.put("expectedDate", predictDate);
		mv.addObject("map", map);
		mv.addObject("operatorPO", operatorPO);
		mv.addObject("count",count);
		//获取历史检查记录的列表用于历史检查记录的回显
		List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
		//获取第一次产前检查对应的历史检查记录
		HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birthArchives.getId());
		if(firstHistoryCheck!=null){
			historyChecks.add(firstHistoryCheck);
		}
		//获取第2-N次检查对应的历史检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchives.getId());
		if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
			historyChecks.addAll(secondOrMoreHistoryChecks);
		}
		mv.addObject("historyChecks", historyChecks);
		
		return mv;
	}
	
	/**
	 * 第一次产前随访编辑跳转带参数
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/firstPrenatalEdit",method=RequestMethod.GET)
	public ModelAndView editFirstPrenatalView(@RequestParam("prenatalId")String prenatalId,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
//		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
//		mv.addObject("operator", operator);
		
		Map<String, Object> map = prenatalExaInfoService.firstPrenatalPreview(prenatalId);
		PrenatalExaInfoPO prenatal = (PrenatalExaInfoPO) map.get("prenatalExa");
		OperatorPO operatorPO = operatorService.getOperatorById(prenatal.getDoctorId());
		BirthArchivesInfoPO birthArchives = (BirthArchivesInfoPO) map.get("birthArchives");
		Date predictDate = birthArchives.getPredictDate();
		//String level = departmentService.queryQyByName(operatorPO.getDepartment());
		List<DepartmentPO> depts = departmentService.getAllDepartment();
		mv.addObject("depts", depts);
		PrenatalReferralInfoPO prenatalReferralInfoPO = (PrenatalReferralInfoPO) map.get("prenatalReferral");
		//String referralSign = birthArchivesInfoPO.getReferralSign();
		String referral = prenatalReferralInfoPO.getReferral();
		if("1".equals(referral)){
			String mechanism = prenatalReferralInfoPO.getMechanism();
			DepartmentPO departmentPO = departmentService.getDepartmentById(mechanism);
			String department = prenatalReferralInfoPO.getDepartment();
			RolePO rolePO = roleService.getRoleById(department);
			mv.addObject("departmentPO", departmentPO);
			mv.addObject("rolePO", rolePO);
			
		}
		
		List<RolePO> roles = roleService.getAll();
		mv.setViewName("/prenatal/first_prenatal_edit");
		map.put("expectedDate", predictDate);
		mv.addObject("map", map);
		mv.addObject("operatorPO", operatorPO);
		mv.addObject("roles", roles);
		return mv;
	}
	
	/**
	 * 产检详情
	 * @param prenatalId
	 * @param archivesId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/prenatalExaDetails",method=RequestMethod.GET)
	public ModelAndView firstPrenatalDetails(@RequestParam("prenatalId")String prenatalId,
											 @RequestParam("count")String count,HttpSession session){
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("operator", operator);
		FirstMotherhoodInfoPO po = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalId);
		if(po != null){
			
			Map<String, Object> map = prenatalExaInfoService.firstPrenatalPreview(prenatalId);
			ArchivesInfoPO archivesInfoPO = (ArchivesInfoPO) map.get("archives");
			PrenatalExaInfoPO prenatalExaInfoPO = (PrenatalExaInfoPO)map.get("prenatalExa");
			String doctorId = prenatalExaInfoPO.getDoctorId();
			
			OperatorPO operatorPO = operatorService.getOperatorById(doctorId);
			
			BirthArchivesInfoPO birthArchives = (BirthArchivesInfoPO) map.get("birthArchives");
			Date predictDate = birthArchives.getPredictDate();
			
			PrenatalReferralInfoPO prenatalReferralInfoPO = (PrenatalReferralInfoPO) map.get("prenatalReferral");
			//String referralSign = birthArchivesInfoPO.getReferralSign();
			String referral = prenatalReferralInfoPO.getReferral();
			if("1".equals(referral)){
				String mechanism = prenatalReferralInfoPO.getMechanism();
				DepartmentPO departmentPO = departmentService.getDepartmentById(mechanism);
				String department = prenatalReferralInfoPO.getDepartment();
				RolePO rolePO = roleService.getRoleById(department);
				mv.addObject("departmentPO", departmentPO);
				mv.addObject("rolePO", rolePO);
				
			}
			String adminId = prenatalExaInfoService.getAdminId();
			String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
			mv.addObject("adminId", adminId);
			mv.addObject("doctorAdminId", doctorAdminId);
			mv.setViewName("/prenatal/first_prenatal_details");
			map.put("expectedDate", predictDate);
			mv.addObject("map", map);
			mv.addObject("operatorPO", operatorPO);
		}else {
			Map<String, Object> map = prenatalExaInfoService.prenatalPreview2ToN(prenatalId);
			ArchivesInfoPO archivesInfoPO = (ArchivesInfoPO) map.get("archives");
			PrenatalExaInfoPO prenatalExaInfoPO = (PrenatalExaInfoPO)map.get("prenatal");
			String doctorId = prenatalExaInfoPO.getDoctorId();
			
			OperatorPO operatorPO = operatorService.getOperatorById(doctorId);
			BirthArchivesInfoPO birthArchives = (BirthArchivesInfoPO) map.get("birthArchives");
			Date predictDate = birthArchives.getPredictDate();
			
			PrenatalReferralInfoPO prenatalReferralInfoPO = (PrenatalReferralInfoPO) map.get("prenatalReferral");
			//String referralSign = birthArchivesInfoPO.getReferralSign();
			String referral = prenatalReferralInfoPO.getReferral();
			if("1".equals(referral)){
				String mechanism = prenatalReferralInfoPO.getMechanism();
				DepartmentPO departmentPO = departmentService.getDepartmentById(mechanism);
				String department = prenatalReferralInfoPO.getDepartment();
				RolePO rolePO = roleService.getRoleById(department);
				mv.addObject("departmentPO", departmentPO);
				mv.addObject("rolePO", rolePO);
				
			}
			String adminId = prenatalExaInfoService.getAdminId();
			String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
			mv.addObject("adminId", adminId);
			mv.addObject("doctorAdminId", doctorAdminId);
			mv.setViewName("/prenatal/secend_n_prenatal_details");
			map.put("expectedDate", predictDate);
			mv.addObject("map", map);
			mv.addObject("operatorPO", operatorPO);
			mv.addObject("count",count);
		}
		return mv;
	}
	
	/**
	 * 产期结案
	 * @param birthArchivesId
	 * @param closingReason
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/closeExa",method=RequestMethod.POST)
	public ModelAndView closeExa(@RequestParam("birthId")String birthArchivesId,@RequestParam("closingReason")String closingReason,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = new HashMap<>();
		map.put("birthArchivesId", birthArchivesId);
		map.put("closeCaseReason", closingReason);
		birthArchivesInfoService.toCloseCase(map);
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		return mv;
	}
	
	/**
	 * 2到N次产前随访打印预览页面
	 * @param prenatalId
	 * @param count
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/2ToNPrintPreview",method=RequestMethod.GET)
	public ModelAndView prenatalPreview2ToN(@RequestParam("prenatalId")String prenatalId,@RequestParam("count")String count,@RequestParam(value="go",required=false,defaultValue="0")String go){
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> map = prenatalExaInfoService.prenatalPreview2ToN(prenatalId);
		PrenatalReferralInfoPO prenatalReferralInfoPO = (PrenatalReferralInfoPO) map.get("prenatalReferral");
		if(prenatalReferralInfoPO != null){
			DepartmentPO departmentPO = departmentService.getDepartmentById(prenatalReferralInfoPO.getMechanism());
			if(departmentPO != null){
				mv.addObject("department",departmentPO);
			}
			RolePO rolePO = roleService.getRoleById(prenatalReferralInfoPO.getDepartment());
			if(rolePO != null){
				mv.addObject("role", rolePO);
			}
		}
		PrenatalExaInfoPO find = prenatalExaInfoService.find(prenatalId);
		int num = prenatalExaInfoService.getNumByNomal(find.getBirthArchivesId());
		
		mv.addObject("map", map);
		mv.addObject("go", go);
		mv.addObject("count", count);
		mv.addObject("num", num);
		mv.setViewName("/prenatal/2ToN_prenatalExa_preview");
		
		return mv;
	}
	
	/**
	 * 第一次打印预览页面传参
	 * @param prenatalId
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/printPreview",method=RequestMethod.GET)
	public ModelAndView firstPrenatalPreview(@RequestParam("prenatalId")String prenatalId,@RequestParam(value="go",required=false,defaultValue="0")String go){
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> map = prenatalExaInfoService.firstPrenatalPreview(prenatalId);
		PrenatalReferralInfoPO prenatalReferralInfoPO = (PrenatalReferralInfoPO) map.get("prenatalReferral");
		if(prenatalReferralInfoPO != null){
			DepartmentPO departmentPO = departmentService.getDepartmentById(prenatalReferralInfoPO.getMechanism());
			if(departmentPO != null){
				mv.addObject("department",departmentPO);
			}
			RolePO rolePO = roleService.getRoleById(prenatalReferralInfoPO.getDepartment());
			if(rolePO != null){
				mv.addObject("role", rolePO);
			}
		}
		mv.addObject("map", map);
		mv.addObject("go", go);
		mv.setViewName("/prenatal/first_prenatal_exa_preview");
		return mv;
	}
	/**
	 * 完成第2~N次产前随访
	 * @param archivesCode
	 * @param ct
	 * @param next
	 * @param highRiskId
	 * @param obstertrivcExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/finishPrenatal2ToN",method=RequestMethod.POST)
	public Model finishPrenatalExa2ToN(@RequestParam("archivesCode")String archivesCode,
										@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
										@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
										@RequestParam(value="checkTime",required=false,defaultValue="")String checkTime,
										@RequestParam(value="nomal")String nomal,
										ObstetricExaInfoVO obstertrivcExaInfoVO,
										SupplementaryExamInfoVO supplementaryExamInfoVO,
										PrenatalExaInfoVO prenatalExaInfoVO,
										PrenatalReferralInfoVO prenatalReferralInfoVO,
										HttpSession session){
		Model model = new Model();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		
		Date createTime = new Date();
		if(checkTime != "" && checkTime != null){
			Date create = DateUtil.stringToDate(checkTime);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		ObstetricExaInfoPO obstetricExaInfoPO = new ObstetricExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("1");
		prenatalExaInfoVO.setNormalSign(nomal);
		if(next != null && next != ""){
			Date nextFollowingDate = DateUtil.stringToDate(next);
			prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
		}
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		
		String prenatalId = null;
		try {
			BeanUtils.copyProperties(obstetricExaInfoPO, obstertrivcExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			if("1".equals(nomal)){
				prenatalId = prenatalExaInfoService.prenatalExa2ToN(archivesCode,
																	obstetricExaInfoPO,
																	supplementaryExamInfoPO,
																	prenatalExaInfoPO,
																	prenatalReferralInfoPO,
																	highRiskId,operator.getDepId());
			}else if("0".equals(nomal)){
				prenatalId = prenatalExaInfoService.prenatalExaNomal2ToN(archivesCode,
																	obstetricExaInfoPO,
																	supplementaryExamInfoPO,
																	prenatalExaInfoPO,
																	prenatalReferralInfoPO,
																	highRiskId,operator.getDepId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		model.set("prenatalId", prenatalId);
		
		return model;
	}
	
	/**
	 * 2到N次产前随访数据保存
	 * @param archivesCode
	 * @param ct
	 * @param last
	 * @param next
	 * @param highRiskId
	 * @param obstertrivcExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/addPrenatal2ToN",method=RequestMethod.POST)
	public ModelAndView prenatalExa2ToN(@RequestParam("archivesCode")String archivesCode,
										@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
										@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
										@RequestParam(value="nomal")String nomal,
										@RequestParam(value="checkTime",required=false,defaultValue="")String checkDate,
										ObstetricExaInfoVO obstertrivcExaInfoVO,
										SupplementaryExamInfoVO supplementaryExamInfoVO,
										PrenatalExaInfoVO prenatalExaInfoVO,
										PrenatalReferralInfoVO prenatalReferralInfoVO,
										HttpSession session){
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		
		Date createTime = new Date();
		if(checkDate != "" && checkDate != null){
			Date create = DateUtil.stringToDate(checkDate);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		
		ObstetricExaInfoPO obstetricExaInfoPO = new ObstetricExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("0");
		prenatalExaInfoVO.setNormalSign(nomal);
		if(next != "" && next != null){
			Date nextFollowingDate = DateUtil.stringToDate(next);
			prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
		}
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		
		
		try {
			BeanUtils.copyProperties(obstetricExaInfoPO, obstertrivcExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalExaInfoService.prenatalExa2ToN(archivesCode,
													obstetricExaInfoPO,
													supplementaryExamInfoPO,
													prenatalExaInfoPO,
													prenatalReferralInfoPO,
													highRiskId,operator.getDepId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		//OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		return mv;
	}
	
	/**
	 * 修改页面保存专案管理高危项信息
	 * @param highRiskInfoVO
	 * @param request
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/editProjectManager",method=RequestMethod.POST)
	public Model editProjectManager(@RequestParam("highRiskInfoId")String highRiskInfoId,HighRiskInfoVO highRiskInfoVO,HttpServletRequest request){
		
		Model model = new Model();
		Map<String, Object> params = WebUtils.getParametersStartingWith(request, "correct");
		
		if(highRiskInfoId != ""&&highRiskInfoId != null){
			highRiskInfoVO.setId(highRiskInfoId);
			try {
				HighRiskInfoPO editHighRisk = new HighRiskInfoPO();
				BeanUtils.copyProperties(editHighRisk, highRiskInfoVO);
				prenatalExaInfoService.editProjectManager(editHighRisk,params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.set("highRiskId", null);
		}
		else{
			
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			String highRiskId = null;
			
			try {
				BeanUtils.copyProperties(highRiskInfoPO, highRiskInfoVO);
				highRiskId = prenatalExaInfoService.saveProjectManager(highRiskInfoPO,params);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.set("highRiskId", highRiskId);
		}
		
		return model;
	}
	/**
	 * 专案管理保存高危项信息
	 * @param highRiskInfoVO
	 * @param request
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/saveProjectManager",method=RequestMethod.POST)
	public Model saveProjectManager(HighRiskInfoVO highRiskInfoVO,HttpServletRequest request){
		Model model = new Model();
		Map<String, Object> params = WebUtils.getParametersStartingWith(request, "correct");
		
		HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
		String highRiskId = null;
		
		try {
			BeanUtils.copyProperties(highRiskInfoPO, highRiskInfoVO);
			highRiskId = prenatalExaInfoService.saveProjectManager(highRiskInfoPO,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.set("highRiskId", highRiskId);
		
		return model;
	}
	
	
	/**
	 * 通过末次月经算预产期
	 * @param lastDate
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/birthDate",method=RequestMethod.GET)
	public Model getBirthDate(@RequestParam("lastDate")String lastDate){
		Model model = new Model();
		
		Date date2 = DateUtil.stringToDate(lastDate);
		if(date2!=null){
			Date expectedDate = DateUtils.expectedDate(date2);
			String date = DateUtils.dateToString(expectedDate,"yyyyMMdd");
			Date nextCheckDate = DateUtils.getNextCheckDate(date2);
			String nextCheck = DateUtils.dateToString(nextCheckDate,"yyyyMMdd");
			model.set("birthDate", date);
			model.set("nextCheck", nextCheck);
		}
		
		return model;
	}
	
	/**
	 * * 保存第一次产检
	 * @param archivesCode
	 * @param ct
	 * @param last
	 * @param next
	 * @param highRiskId
	 * @param firstMotherhoodInfoVO
	 * @param firstPhysicalBloodStethoscopyInfoVO
	 * @param firstGynecologicalExaInfoVO
	 * @param supplementaryExamInfoVO
	 * @param prenatalExaInfoVO
	 * @param prenatalReferralInfoVO
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/addPrenatal",method=RequestMethod.POST)
	public ModelAndView addPrenatalExa(@RequestParam("archivesCode")String archivesCode,
										@RequestParam(value="lastMenses",required=false,defaultValue="")String last,
										@RequestParam(value="nextFollowingDate",required=false,defaultValue="")String next,
										@RequestParam("birthArchiveId")String birthArchivesId,
										@RequestParam(value="highRiskId",required=false,defaultValue="")String highRiskId,
										@RequestParam(value="nomal")String nomal,
										@RequestParam(value="checkDate",required= false,defaultValue="")String checkDate,
										FirstMotherhoodInfoVO firstMotherhoodInfoVO,
										FirstPhysicalBloodStethoscopyInfoVO firstPhysicalBloodStethoscopyInfoVO,
										FirstGynecologicalExaInfoVO firstGynecologicalExaInfoVO,
										SupplementaryExamInfoVO supplementaryExamInfoVO,
										PrenatalExaInfoVO prenatalExaInfoVO,
										PrenatalReferralInfoVO prenatalReferralInfoVO,
										HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		Date createTime = new Date();
		if(checkDate != "" && checkDate != null){
			Date create = DateUtil.stringToDate(checkDate);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		
		if(last != ""&& last != null){
			Date lastMenses = DateUtil.stringToDate(last);
			firstMotherhoodInfoVO.setLastMenses(lastMenses);
		}
		if(next != ""&& next != null){
			Date nextFollowingDate = DateUtil.stringToDate(next);
			prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
		}
		
		FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
		FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO = new FirstPhysicalBloodStethoscopyInfoPO();
		FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = new FirstGynecologicalExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("0");
		prenatalExaInfoVO.setNormalSign(nomal);
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		
		try {
			BeanUtils.copyProperties(firstMotherhoodInfoPO, firstMotherhoodInfoVO);
			BeanUtils.copyProperties(firstPhysicalBloodStethoscopyInfoPO, firstPhysicalBloodStethoscopyInfoVO);
			BeanUtils.copyProperties(firstGynecologicalExaInfoPO, firstGynecologicalExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalExaInfoService.firstPrenatalExa(archivesCode,birthArchivesId,
													firstMotherhoodInfoPO,
													firstPhysicalBloodStethoscopyInfoPO,
													firstGynecologicalExaInfoPO,
													supplementaryExamInfoPO,
													prenatalExaInfoPO,
													prenatalReferralInfoPO,
													highRiskId,operator.getDepId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		//OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		return mv;
	}
	
	/**
	 * 完成第一次产检
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/finishFirstExa",method=RequestMethod.POST)
	public Model finishPrenatalExa(@RequestParam("archivesCode")String archivesCode,
								   @RequestParam("ct")String ct,
								   @RequestParam(value="nomal")String nomal,
								   @RequestParam(value="lastMenses")String last,
								   @RequestParam(value="nextFollowingDate")String next,
								   @RequestParam("birthArchiveId")String birthArchivesId,
								   @RequestParam(value="highRiskId",required=true,defaultValue="")String highRiskId,
								   @RequestParam(value="checkDate",required= false,defaultValue="")String checkDate,
								   FirstMotherhoodInfoVO firstMotherhoodInfoVO,
								   FirstPhysicalBloodStethoscopyInfoVO firstPhysicalBloodStethoscopyInfoVO,
								   FirstGynecologicalExaInfoVO firstGynecologicalExaInfoVO,
								   SupplementaryExamInfoVO supplementaryExamInfoVO,
								   PrenatalExaInfoVO prenatalExaInfoVO,
								   PrenatalReferralInfoVO prenatalReferralInfoVO,
								   HttpSession session){
					
		Model model = new Model();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(prenatalExaInfoVO.getEvaluate() != null && "1".equals(prenatalExaInfoVO.getEvaluate())){
			String evaluateRemark = (String) session.getAttribute("evaluateRemark");
			prenatalExaInfoVO.setEvaluateRemark(evaluateRemark);
		}
		session.removeAttribute("evaluateRemark");
		Date createTime = new Date();
		if(checkDate != "" && checkDate != null){
			Date create = DateUtil.stringToDate(checkDate);
			createTime.setYear(create.getYear());
			createTime.setMonth(create.getMonth());
			createTime.setDate(create.getDate());
		}
		if(last != ""&& last != null){
			//Date lastMenses = DateUtil.stringToDate(last);
			SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
			
			try {
				Date lastMenses = formate.parse(last);
				firstMotherhoodInfoVO.setLastMenses(lastMenses);
				if(next != ""&& next != null){
					Date nextFollowingDate = formate.parse(next);
					prenatalReferralInfoVO.setNextFollowingDate(nextFollowingDate);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
		FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO = new FirstPhysicalBloodStethoscopyInfoPO();
		FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = new FirstGynecologicalExaInfoPO();
		SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
		PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
		prenatalExaInfoVO.setCreatTime(createTime);
		prenatalExaInfoVO.setUpdateTime(new Date());
		prenatalExaInfoVO.setDoctorId(operator.getId());
		prenatalExaInfoVO.setEditStatus("1");
		prenatalExaInfoVO.setNormalSign(nomal);
		PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
		String prenatalId = null;
		try {
			BeanUtils.copyProperties(firstMotherhoodInfoPO, firstMotherhoodInfoVO);
			BeanUtils.copyProperties(firstPhysicalBloodStethoscopyInfoPO, firstPhysicalBloodStethoscopyInfoVO);
			BeanUtils.copyProperties(firstGynecologicalExaInfoPO, firstGynecologicalExaInfoVO);
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			if("1".equals(nomal)){
				prenatalId = prenatalExaInfoService.firstPrenatalExa(archivesCode,birthArchivesId,
						firstMotherhoodInfoPO,
						firstPhysicalBloodStethoscopyInfoPO,
						firstGynecologicalExaInfoPO,
						supplementaryExamInfoPO,
						prenatalExaInfoPO,
						prenatalReferralInfoPO,
						highRiskId,operator.getDepId());
			}else if("0".equals(nomal)){
				prenatalId = prenatalExaInfoService.nomalFirstPrenatalExa(archivesCode,birthArchivesId,
						firstMotherhoodInfoPO,
						firstPhysicalBloodStethoscopyInfoPO,
						firstGynecologicalExaInfoPO,
						supplementaryExamInfoPO,
						prenatalExaInfoPO,
						prenatalReferralInfoPO,
						highRiskId,operator.getDepId());
			}
		} catch (Exception e) {
		e.printStackTrace();
		} 
		model.set("prenatalId", prenatalId);
		return model;
	}
	
	/**
	 * 孕产新建档案页面跳转
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/prenatalNewArchives",method=RequestMethod.GET)
	public ModelAndView prenatalNewArchives(HttpSession session){
		
		log.debug("request page:/premarital/new_archives");
		
		ModelAndView mav = new ModelAndView();
		
		String time = DateUtil.dateToString(new Date(), DateStyle.YYYY_MM_DD_CN);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		mav.setViewName("/prenatal/prenatal_archives");
		mav.addObject("time", time);
		mav.addObject("operator",operator2);
		return mav;
	}
	
	/**
	 * 新建查询页面跳转
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/new_select",method=RequestMethod.GET)
	public ModelAndView newSelect(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/prenatal/new_select");
		return mv;
	}

    /**
	 * PRENATAL_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listPrenatalExaInfoView(HttpSession session) {
		log.debug("request page: /sysset/prenatalExaInfo/prenatalExaInfo_list");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		
		return mv;
	}
	/**
	 * PRENATAL_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPrenatalExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<PrenatalExaInfoPO> page) {
		log.debug("request data: listPrenatalExaInfo");
		Model model = new Model();
		try {
			prenatalExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * PRENATAL_EXA_INFO 添加
	 * 
	 * @param prenatalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPrenatalExaInfoActoin(PrenatalExaInfoVO prenatalExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			prenatalExaInfoService.create(prenatalExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PRENATAL_EXA_INFO 修改
	 * 
	 * @param prenatalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePrenatalExaInfoActoin(PrenatalExaInfoVO prenatalExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PrenatalExaInfoPO prenatalExaInfoPO = new PrenatalExaInfoPO();
			BeanUtils.copyProperties(prenatalExaInfoPO, prenatalExaInfoVO);
			prenatalExaInfoService.update(prenatalExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PRENATAL_EXA_INFO 删除
	 * 
	 * @param prenatalExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPrenatalExaInfoAction(@RequestParam("prenatalExaInfoIds") String prenatalExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			prenatalExaInfoService.deletes(prenatalExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}