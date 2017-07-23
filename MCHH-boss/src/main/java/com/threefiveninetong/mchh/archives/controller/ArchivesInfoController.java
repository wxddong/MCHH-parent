/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ArchivesInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.archives.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.controller;



import java.lang.ProcessBuilder.Redirect;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.ArchivesInfoService;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.archives.vo.ArchivesInfoVO;
import com.threefiveninetong.mchh.archives.vo.BirthArchivesInfoVO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBabyInfoPO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthInfoPO;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthReferralInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBabyInfoService;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBasicInfoService;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthInfoService;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthReferralInfoService;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthBabyInfoVO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthBasicInfoVO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthInfoVO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthReferralInfoVO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.dto.PostHistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumReferralInfoPO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaInfoService;
import com.threefiveninetong.mchh.postpartum.service.PostpartumReferralInfoService;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumReferralInfoVO;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.premarital.service.PremaritalExaInfoService;
import com.threefiveninetong.mchh.premarital.vo.PremaritalExaInfoVO;
import com.threefiveninetong.mchh.prenatal.po.FirstMotherhoodInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.service.FirstMotherhoodInfoService;
import com.threefiveninetong.mchh.prenatal.service.HighRiskInfoService;
import com.threefiveninetong.mchh.prenatal.service.HighRiskTermService;
import com.threefiveninetong.mchh.prenatal.service.PrenatalExaInfoService;
import com.threefiveninetong.mchh.prenatal.vo.PrenatalExaInfoVO;
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
 * @ClassName: ArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Controller
@RequestMapping("/archivesinfo")
public class ArchivesInfoController {

	private static final Logger log =Logger.getLogger(ArchivesInfoController.class);
	
	//private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Resource
	private ArchivesInfoService archivesInfoService;
	
	@Resource
	private OperatorService operatorService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private BirthArchivesInfoService birthArchivesInfoService;
	
	@Resource
	private PrenatalExaInfoService prenatalExaInfoService;
	
	@Resource
	private FirstMotherhoodInfoService firstMotherhoodInfoService;
	 
	@Resource
	private  ChildbirthBasicInfoService  childbirthBasicInfoService;
	
	@Resource
	private  ChildbirthInfoService  childbirthInfoService;
	
	@Resource
	private  ChildbirthBabyInfoService  childbirthBabyInfoService;
	
	@Resource
	private  ChildbirthReferralInfoService  childbirthReferralInfoService;
	
	@Resource
	private  PremaritalExaInfoService  premaritalExaInfoService;
	
	@Resource
	private  PostpartumExaInfoService  postpartumExaInfoService;
	
	@Resource
	private HighRiskInfoService highRiskInfoService;
	
	@Resource
	private HighRiskTermService highRiskTermService;
	
	@Value("${admin.id}")
	private String adminId;
	
	
	@ResponseBody
	@RequestMapping(value="/archivesIsAll",method=RequestMethod.GET)
	public Model archivesIsAll(@RequestParam("archivesId")String archivesId){
		Model model = new Model();
		
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(archivesId);
		
		Date manBirthday = archivesInfoPO.getManBirthday();
		String manAccPro = archivesInfoPO.getManAccProvinceId();
		String manAccCity = archivesInfoPO.getManAccCityId();
		BirthArchivesInfoPO birthArchives = birthArchivesInfoService.getBirthArchivesByArchivesId(archivesId);
		if(manBirthday == null || manAccPro == null || manAccCity == null || birthArchives.getLastMenses() == null || birthArchives.getPredictDate() == null){
			model.set("isAll", "1");
		}else {
			model.set("isAll", "0");
		}
		
		return model;
	}
	
	/**
		 * ARCHIVES_INFO 列表视图
		 * @return
		 * 传入档案的id
		 * 分娩登记添加  页面
		 * wangbj
		 */
		@RequestMapping(value = "/listChildbirth", method = RequestMethod.GET)
		public ModelAndView listArchivesInfoChildbirth(HttpSession session,@RequestParam Map<String, Object> reqs,HttpServletRequest request) throws ParseException {
			log.debug("request page: /sysset/archivesInfo/archivesInfo_list");
			
			ModelAndView modle = new ModelAndView(
					
					
					"prenatal/childbirth_add", reqs);
			
			
			String id =(String) reqs.get("id");
			String Sign =(String) reqs.get("Sign");
			//String Sign="1";
			
			modle.addObject("Sign", Sign);
			
			//查询检查医生
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
			
			modle.addObject("operator2", operator2);
			
			
			
			//查询档案通过档案id
			
			ArchivesInfoPO arc = archivesInfoService.find(id);
			
			
			//查询生育档案
			BirthArchivesInfoPO birthArchives= birthArchivesInfoService.getBirthArchivesByArchivesId(id);
			//获取生育档案的id
			String birarchid = birthArchives.getId();
			//查询分勉基本信息 通过生育档案id
			ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.SaveChildbirthBasicByBirthArchivesId(birarchid);
			
			if(childbirthBasic !=null){
				
				ModelAndView modleview = new ModelAndView(
						
						
						"forward:/archivesinfo/updateNoteView?archiveId="+id);
				
				return modleview;
				
			}
			
			
			
			modle.addObject("childbirthBasic", childbirthBasic);
			//获得建党医生的id
			String doctorId = arc.getDoctorId();
			modle.addObject("doctorId", doctorId);
			List<DepartmentPO> list = departmentService.getAllDepartment();
			modle.addObject("list", list);
			
			//查询生育档案 通过档案id
			BirthArchivesInfoPO birthArchivesByArchivesId = birthArchivesInfoService.getBirthArchivesByArchivesId(id);
							if(birthArchivesByArchivesId !=null){
									//获得生育档案的id
									String birthArchivesId = birthArchivesByArchivesId.getId();
									//获得高危标示
									String riskSign = birthArchivesByArchivesId.getRiskSign();
									
									modle.addObject("riskSign", riskSign);
									//查询所有的分娩医院地点
									
									List<ChildbirthInfoPO> placeList = childbirthInfoService.findAll();
									modle.addObject("placeList", placeList);
									
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
									modle.addObject("historyChecks", historyChecks);
									
									//获取出院3-7天和产后检查对应的历史检查记录
									List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostpartumHistoryChecks(birthArchivesId);
									modle.addObject("postpartumHistoryChecks", postpartumHistoryChecks);
									
									
							
							//获得科室类别
							List<RolePO> roleList = roleService.getAll();
							modle.addObject("roleList", roleList);
							//得到女人的末次月经
							Date lastmen = birthArchivesByArchivesId.getLastMenses();
							
							Date birthday = arc.getBirthday();
							Date manBirthday = arc.getManBirthday();
							
							if(lastmen !=null){
							modle.addObject("lastMenses", lastmen);
							//得到孕周
							int weekByLastMenses = DateUtils.getWeekByLastMenses(lastmen);
							//得到孕天
							int dayByLastMenses = DateUtils.getDayByLastMenses(lastmen);
							
							//得到孕产期
							Date endOfDate = DateUtils.expectedDate(lastmen);
							
							
							modle.addObject("weekByLastMenses", weekByLastMenses);
							modle.addObject("dayByLastMenses", dayByLastMenses);
							modle.addObject("endOfDate", endOfDate);
							}
							
							//获取产前检查信息
							PrenatalExaInfoPO prenatal = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchivesId);
								if(prenatal !=null){
									String prenatalId = prenatal.getId();
									//查询孕次，保健次数
									FirstMotherhoodInfoPO firstMother = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatalId);
									if(firstMother!=null){
										//获得孕次
										String prebearNum = firstMother.getPrebearNum();
										//获得产次
										String bearNum = firstMother.getBearNum();
										modle.addObject("prebearNum", prebearNum);
										modle.addObject("bearNum", bearNum);
									}
									//获得孕产保健次数
									int countBy = prenatalExaInfoService.countByBirthId(birthArchivesId);
									modle.addObject("countBy", countBy);
									
								}
								
								
								
								if(birthday !=null){
								int age = DateUtils.getAgeByBirthday(birthday);
								modle.addObject("age", age);
								}
								if(manBirthday !=null){
								//得到男人的年龄
								int manAge = DateUtils.getAgeByBirthday(manBirthday);
								modle.addObject("manAge", manAge);
								}
								//modle.addObject("operator", operator);
								modle.addObject("ArchivesInfoPO", arc);
								
								modle.addObject("birthArchives", birthArchivesByArchivesId);
								
							}
							//modle.addObject("operator", operator);
							modle.addObject("ArchivesInfoPO", arc);
							
							
							return modle;
		}
		
		
		
		
		
		/**
		 * 分娩  结案  
		 * @param id
		 * @param session
		 * @return
		 * @author wangbj
		 */
		@RequestMapping(value = "/endNote", method = RequestMethod.POST)
		public ModelAndView endArchives(@RequestParam Map<String, Object> reqs,BirthArchivesInfoVO birthArchivesVO){
			String archId =(String)reqs.get("archiId");
			
			
			BirthArchivesInfoPO birthArchives = birthArchivesInfoService.getBirthArchivesByArchivesId(archId);
			birthArchives.setPregnantState("2");
			birthArchives.setClosingDate(new Date());
			birthArchives.setClosingReason(birthArchivesVO.getClosingReason());
			try {
				birthArchivesInfoService.update(birthArchives);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ModelAndView model = new ModelAndView( "prenatal/prenatal_list");
			
			return model;
		}
		
		
		
		
		/**
		 * 分娩  专案  
		 * @param id
		 * @param session
		 * @return
		 * @author wangbj
		 */
		@ResponseBody
		@RequestMapping(value = "/specialNote", method = RequestMethod.GET)
		public Model specialArchives(@RequestParam Map<String, Object> reqs){
			String archId =(String)reqs.get("archiveId");
			
			
			Model model = new Model();
			//查询生育当案
			BirthArchivesInfoPO birthArchives = birthArchivesInfoService.getBirthArchivesByArchivesId(archId);
			//获得生育档案
			String birthid = birthArchives.getId();
			//获取产前检查表
			PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthid);
			//获取产前检查的id
			String preid = prenatalExaInfoPO.getId();
			//获取高危信息
			HighRiskInfoPO highRisk = highRiskInfoService.getHighRiskByPrenatalId(preid);
			//获取高危信息id
			if(highRisk !=null){
			String hightRiskId = highRisk.getId();
			
			
			//获取高危项的信息
			List<HighRiskTermPO> allTerm= highRiskTermService.getAllTermByhighRiskId(hightRiskId);
			List<HighRiskTermPO> listHigh = new ArrayList<HighRiskTermPO>();
			for(int i=0;i<allTerm.size();i++){
				HighRiskTermPO highRiskTermPO = allTerm.get(i);
				String correct = highRiskTermPO.getCorrect();
				if(correct.equals("0")){
					listHigh.add(highRiskTermPO);
					model.setList(listHigh);
				}
				
			}
			
			}
			try {
				birthArchivesInfoService.update(birthArchives);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return model;
		}
		
		/**
		 * 分娩登记  添加
		 * @param id
		 * @param session
		 * @return
		 * @author wangbj
		 */
		
		@RequestMapping(value = "/addNote", method = RequestMethod.POST)
		public ModelAndView addArchivesInfo(@RequestParam Map<String, Object> reqs,
											@RequestParam("archiId")String archivesId,
											
											ArchivesInfoPO archivesInfoPO,
											BirthArchivesInfoVO birthArchivesInfoVO,
											ChildbirthBasicInfoVO childbirthBasicInfoVO,
											ChildbirthInfoVO childbirthInfoVO,
											ChildbirthBabyInfoVO childbirthBabyInfoVO,
											ChildbirthReferralInfoVO childbirthReferralInfoVO,
											HttpServletRequest request,
											HttpSession session) {
			ModelAndView model = new ModelAndView("prenatal/prenatal_list");
			
			try {
				log.debug("request page: /sysset/archivesInfo/addNote");
				//获取编辑状态 为 (保存，完成)
				OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
				String adminId = prenatalExaInfoService.getAdminId();
				String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
				model.addObject("adminId", adminId);
				model.addObject("doctorAdminId", doctorAdminId);
				model.addObject("doctorId", operator.getId());
				model.addObject("depId", operator.getDepId());
				String operatorId = operator.getId();
				String editStatus =(String) reqs.get("editStatus");
				//点完成时
				if(editStatus.equals("1")){
				//获得档案id(chid)
				String chid=archivesId;
				//创建生育档案信息
				BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
				String id2 = birthArchivesInfoPO.getId();
				//创建女人分娩基本信息的id(id)
				String id =IdUtil.uuid();
				String birthDate =(String) reqs.get("birthDate");
				String leaveDate =(String) reqs.get("leaveDate");
				
 				SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
				if(birthDate !=null){
				Date date = formate.parse(birthDate);
				childbirthBasicInfoVO.setBirthDate(date);
				}
				if(leaveDate !=null){
				Date leave = formate.parse(leaveDate);
				childbirthBasicInfoVO.setLeaveDate(leave);
				}
				String BasicCreateTime =(String) reqs.get("BasicCreateTime");
				if(BasicCreateTime !=null){
					Date createTime = formate.parse(BasicCreateTime);
					childbirthBasicInfoVO.setCreatTime(createTime);
					childbirthBasicInfoVO.setUpdateTime(new Date());
					childbirthBasicInfoVO.setNormalSign("0");
				}
				if(BasicCreateTime==null||BasicCreateTime==""){
					childbirthBasicInfoVO.setCreatTime(new Date());
					childbirthBasicInfoVO.setUpdateTime(new Date());
					childbirthBasicInfoVO.setNormalSign("1");
				}
				
				ChildbirthBasicInfoPO childbirthBasicInfoPO = new ChildbirthBasicInfoPO();
				
				
				childbirthBasicInfoVO.setId(id);
				childbirthBasicInfoVO.setDoctorId(operatorId);
				childbirthBasicInfoVO.setCreatTime(new Date());
				childbirthBasicInfoVO.setUpdateTime(new Date());
				childbirthBasicInfoVO.setEditStatus(editStatus);
				childbirthBasicInfoVO.setBirthArchivesId(id2);
				BeanUtils.copyProperties(childbirthBasicInfoPO, childbirthBasicInfoVO);
				childbirthBasicInfoService.create(childbirthBasicInfoPO);
				
				
				//创建分娩信息
				//创建分娩信息的id(cid)
				String cid =IdUtil.uuid();
				ChildbirthInfoPO childbirthInfoPO = new ChildbirthInfoPO();
				childbirthInfoVO.setId(cid);
				childbirthInfoVO.setBasicId(id);
				
				//获得分娩地点
				String childbirthPlace = childbirthInfoVO.getChildbirthPlace();
				String[] split = childbirthPlace.split(",");
				childbirthInfoVO.setChildbirthPlace(split[0]);	
				BeanUtils.copyProperties(childbirthInfoPO, childbirthInfoVO);
				childbirthInfoService.create(childbirthInfoPO);
				
				
				//创建转诊信息
				//创建转诊信息的id(did)
				
				
				String did =IdUtil.uuid();
				String referral = childbirthReferralInfoVO.getReferral();
				
				/*//当转诊标识为1，确认转诊时
				if(referral.equals("1")){
					String idde =(String) reqs.get("department");
					String mechanism =(String) reqs.get("mechanism");
					
		
					//将转诊标识设置为分娩转诊
					birthArchivesInfoPO.setReferralSign("2");
					birthArchivesInfoPO.setPredictDate(new Date());
					birthArchivesInfoPO.setOutHospitalId(idde);
					birthArchivesInfoPO.setDeltetSign("1");
					birthArchivesInfoPO.setPregnantState("1");
					
					birthArchivesInfoService.update(birthArchivesInfoPO);
				childbirthReferralInfoVO.setId(did);
				childbirthReferralInfoVO.setBasicId(id);
				ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
				BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
				childbirthReferralInfoService.create(childbirthReferralInfoPO);
				}*/
				//当没有转诊时
				if(referral.equals("0")){
					
					
					birthArchivesInfoPO.setReferralSign("0");
					birthArchivesInfoPO.setPredictDate(new Date());
					
					birthArchivesInfoPO.setDeltetSign("1");
					birthArchivesInfoPO.setPregnantState("1");
					
					birthArchivesInfoService.update(birthArchivesInfoPO);
					
					
					childbirthReferralInfoVO.setId(did);
					childbirthReferralInfoVO.setBasicId(id);
					ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
					BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
					childbirthReferralInfoService.create(childbirthReferralInfoPO);
					
					
				}
				
				
				
				//当转诊标识为1，确认转诊时
				if(referral.equals("1")){
					String idde =(String) reqs.get("department");
					String mechanism =(String) reqs.get("mechanism");
					
		
					//将转诊标识设置为分娩转诊
					birthArchivesInfoPO.setReferralSign("2");
					birthArchivesInfoPO.setPredictDate(new Date());
					birthArchivesInfoPO.setOutHospitalId(idde);
					birthArchivesInfoPO.setDeltetSign("1");
					birthArchivesInfoPO.setPregnantState("1");
					
					
					birthArchivesInfoService.update(birthArchivesInfoPO);
				childbirthReferralInfoVO.setId(did);
				childbirthReferralInfoVO.setBasicId(id);
				ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
				BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
				childbirthReferralInfoService.create(childbirthReferralInfoPO);
				}
				
				
				
				
				
				//创建分娩婴儿信息
				String bid =IdUtil.uuid();
				ChildbirthBabyInfoPO childbirthBabyInfoPO = new ChildbirthBabyInfoPO();
				childbirthBabyInfoVO.setId(bid);
				childbirthBabyInfoVO.setChildbirthId(cid);
				BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
				childbirthBabyInfoService.create(childbirthBabyInfoPO);
				
				
				
				//创建第一个婴儿信息
				String babyName1 =(String) reqs.get("babyName1");
				String deliveryType1 =(String) reqs.get("deliveryType1");
				if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
				String uid=IdUtil.uuid();
				String fetusPosition =(String) reqs.get("fetusPosition1");
				String deliveryHour =(String) reqs.get("deliveryHour1");
				String deliveryMinute =(String) reqs.get("deliveryMinute1");
				String inducelabour =(String) reqs.get("inducelabour1");
				String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
				String babySex =(String) reqs.get("babySex1");
				String health =(String) reqs.get("health1");
				String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
				String abnormalPosition =(String) reqs.get("abnormalPosition1");
				String abnormalName =(String) reqs.get("abnormalName1");
				String oneMinScore =(String) reqs.get("oneMinScore1");
				String fiveMinScore =(String) reqs.get("fiveMinScore1");
				String bornWeight =(String) reqs.get("bornWeight1");
				//String vaccine=vaccine1;
				
				String vaccine =(String) reqs.get("babyVaccine1");
				String fetusDie =(String) reqs.get("fetusDie1");
				String midwife =(String) reqs.get("midwife1");
				ChildbirthBabyInfoPO childbirthBabyInfoPO1 = new ChildbirthBabyInfoPO();
				childbirthBabyInfoPO1.setFetusPosition(fetusPosition);
				childbirthBabyInfoPO1.setBabyName(babyName1);
				childbirthBabyInfoPO1.setAbnormalName(abnormalName);
				childbirthBabyInfoPO1.setAbnormalPosition(abnormalPosition);
				childbirthBabyInfoPO1.setBabySex(babySex);
				childbirthBabyInfoPO1.setBodyLenght(bornWeight);
				childbirthBabyInfoPO1.setBornWeight(bornWeight);
				childbirthBabyInfoPO1.setCesareanIdicatio(cesareanIdicatio);
				childbirthBabyInfoPO1.setDeliveryHour(deliveryHour);
				childbirthBabyInfoPO1.setDeliveryMinute(deliveryMinute);
				childbirthBabyInfoPO1.setDeliveryType(deliveryType1);
				childbirthBabyInfoPO1.setFetalAnomaly(fetalAnomaly);
				childbirthBabyInfoPO1.setFetusDie(fetusDie);
				childbirthBabyInfoPO1.setFetusPosition(fetusPosition);
				childbirthBabyInfoPO1.setFiveMinScore(fiveMinScore);
				childbirthBabyInfoPO1.setHealth(health);
				childbirthBabyInfoPO1.setId(uid);
				childbirthBabyInfoPO1.setChildbirthId(cid);
				childbirthBabyInfoPO1.setInducelabour(inducelabour);
				childbirthBabyInfoPO1.setMidwife(midwife);
				childbirthBabyInfoPO1.setOneMinScore(oneMinScore);
				childbirthBabyInfoPO1.setVaccine(vaccine);
				childbirthBabyInfoService.create(childbirthBabyInfoPO1);
				}
				
				//创建第二个婴儿信息
				String babyName2 =(String) reqs.get("babyName2");
				String deliveryType2 =(String) reqs.get("deliveryType2");
				if(deliveryType2 !=null && deliveryType2 !="" &&babyName2!=null &&babyName2!="") {
				String wid=IdUtil.uuid();
				String fetusPosition2 =(String) reqs.get("fetusPosition2");
				String deliveryHour2 =(String) reqs.get("deliveryHour2");
				String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
				String inducelabour2 =(String) reqs.get("inducelabour2");
				String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
				String babySex2 =(String) reqs.get("babySex2");
				String health2 =(String) reqs.get("health2");
				String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
				String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
				String abnormalName2 =(String) reqs.get("abnormalName2");
				String oneMinScore2 =(String) reqs.get("oneMinScore2");
				String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
				String bornWeight2 =(String) reqs.get("bornWeight2");
				String vaccine2 =(String) reqs.get("babyVaccine2");
				String fetusDie2 =(String) reqs.get("fetusDie2");
				String midwife2 =(String) reqs.get("midwife2");
				ChildbirthBabyInfoPO childbirthBabyInfoPO2 = new ChildbirthBabyInfoPO();
				childbirthBabyInfoPO2.setFetusPosition(fetusPosition2);
				childbirthBabyInfoPO2.setBabyName(babyName2);
				childbirthBabyInfoPO2.setAbnormalName(abnormalName2);
				childbirthBabyInfoPO2.setAbnormalPosition(abnormalPosition2);
				childbirthBabyInfoPO2.setBabySex(babySex2);
				childbirthBabyInfoPO2.setBodyLenght(bornWeight2);
				childbirthBabyInfoPO2.setBornWeight(bornWeight2);
				childbirthBabyInfoPO2.setCesareanIdicatio(cesareanIdicatio2);
				childbirthBabyInfoPO2.setDeliveryHour(deliveryHour2);
				childbirthBabyInfoPO2.setDeliveryMinute(deliveryMinute2);
				childbirthBabyInfoPO2.setDeliveryType(deliveryType2);
				childbirthBabyInfoPO2.setFetalAnomaly(fetalAnomaly2);
				childbirthBabyInfoPO2.setFetusDie(fetusDie2);
				childbirthBabyInfoPO2.setFetusPosition(fetusPosition2);
				childbirthBabyInfoPO2.setFiveMinScore(fiveMinScore2);
				childbirthBabyInfoPO2.setHealth(health2);
				childbirthBabyInfoPO2.setId(wid);
				childbirthBabyInfoPO2.setChildbirthId(cid);
				childbirthBabyInfoPO2.setInducelabour(inducelabour2);
				childbirthBabyInfoPO2.setMidwife(midwife2);
				childbirthBabyInfoPO2.setOneMinScore(oneMinScore2);
				childbirthBabyInfoPO2.setVaccine(vaccine2);
				childbirthBabyInfoService.create(childbirthBabyInfoPO2);
				}
				
				
				String babyName3 =(String) reqs.get("babyName3");
				String deliveryType3 =(String) reqs.get("deliveryType3");
				if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
				String sid=IdUtil.uuid();
				String fetusPosition3 =(String) reqs.get("fetusPosition3");
				String deliveryHour3 =(String) reqs.get("deliveryHour3");
				String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
				String inducelabour3 =(String) reqs.get("inducelabour3");
				String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
				String babySex3 =(String) reqs.get("babySex3");
				String health3 =(String) reqs.get("health3");
				String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
				String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
				String abnormalName3 =(String) reqs.get("abnormalName3");
				String oneMinScore3 =(String) reqs.get("oneMinScore3");
				String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
				String bornWeight3 =(String) reqs.get("bornWeight3");
				String vaccine3 =(String) reqs.get("babyVaccine3");
				String fetusDie3 =(String) reqs.get("fetusDie3");
				String midwife3 =(String) reqs.get("midwife3");
				ChildbirthBabyInfoPO childbirthBabyInfoPO3 = new ChildbirthBabyInfoPO();
				childbirthBabyInfoPO3.setFetusPosition(fetusPosition3);
				childbirthBabyInfoPO3.setBabyName(babyName3);
				childbirthBabyInfoPO3.setAbnormalName(abnormalName3);
				childbirthBabyInfoPO3.setAbnormalPosition(abnormalPosition3);
				childbirthBabyInfoPO3.setBabySex(babySex3);
				childbirthBabyInfoPO3.setBodyLenght(bornWeight3);
				childbirthBabyInfoPO3.setBornWeight(bornWeight3);
				childbirthBabyInfoPO3.setCesareanIdicatio(cesareanIdicatio3);
				childbirthBabyInfoPO3.setDeliveryHour(deliveryHour3);
				childbirthBabyInfoPO3.setDeliveryMinute(deliveryMinute3);
				childbirthBabyInfoPO3.setDeliveryType(deliveryType3);
				childbirthBabyInfoPO3.setFetalAnomaly(fetalAnomaly3);
				childbirthBabyInfoPO3.setFetusDie(fetusDie3);
				childbirthBabyInfoPO3.setFetusPosition(fetusPosition3);
				childbirthBabyInfoPO3.setFiveMinScore(fiveMinScore3);
				childbirthBabyInfoPO3.setHealth(health3);
				childbirthBabyInfoPO3.setId(sid);
				childbirthBabyInfoPO3.setChildbirthId(cid);
				childbirthBabyInfoPO3.setInducelabour(inducelabour3);
				childbirthBabyInfoPO3.setMidwife(midwife3);
				childbirthBabyInfoPO3.setOneMinScore(oneMinScore3);
				childbirthBabyInfoPO3.setVaccine(vaccine3);
				childbirthBabyInfoService.create(childbirthBabyInfoPO3);
				
				}
				
				
				
				String babyName4 =(String) reqs.get("babyName4");
				String deliveryType4 =(String) reqs.get("deliveryType4");
				if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
				String rid=IdUtil.uuid();
				String fetusPosition4 =(String) reqs.get("fetusPosition4");
				String deliveryHour4 =(String) reqs.get("deliveryHour4");
				String inducelabour4 =(String) reqs.get("inducelabour4");
				String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
				String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
				String babySex4 =(String) reqs.get("babySex4");
				String health4 =(String) reqs.get("health4");
				String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
				String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
				String abnormalName4 =(String) reqs.get("abnormalName4");
				String oneMinScore4 =(String) reqs.get("oneMinScore4");
				String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
				String bornWeight4 =(String) reqs.get("bornWeight4");
				String vaccine4 =(String) reqs.get("babyVaccine4");
				String fetusDie4 =(String) reqs.get("fetusDie4");
				String midwife4 =(String) reqs.get("midwife4");
				ChildbirthBabyInfoPO childbirthBabyInfoPO4 = new ChildbirthBabyInfoPO();
				childbirthBabyInfoPO4.setFetusPosition(fetusPosition4);
				childbirthBabyInfoPO4.setBabyName(babyName4);
				childbirthBabyInfoPO4.setAbnormalName(abnormalName4);
				childbirthBabyInfoPO4.setAbnormalPosition(abnormalPosition4);
				childbirthBabyInfoPO4.setBabySex(babySex4);
				childbirthBabyInfoPO4.setBodyLenght(bornWeight4);
				childbirthBabyInfoPO4.setBornWeight(bornWeight4);
				childbirthBabyInfoPO4.setCesareanIdicatio(cesareanIdicatio4);
				childbirthBabyInfoPO4.setDeliveryHour(deliveryHour4);
				childbirthBabyInfoPO4.setDeliveryMinute(deliveryMinute4);
				childbirthBabyInfoPO4.setDeliveryType(deliveryType4);
				childbirthBabyInfoPO4.setFetalAnomaly(fetalAnomaly4);
				childbirthBabyInfoPO4.setFetusDie(fetusDie4);
				childbirthBabyInfoPO4.setFetusPosition(fetusPosition4);
				childbirthBabyInfoPO4.setFiveMinScore(fiveMinScore4);
				childbirthBabyInfoPO4.setHealth(health4);
				childbirthBabyInfoPO4.setId(rid);
				childbirthBabyInfoPO4.setChildbirthId(cid);
				childbirthBabyInfoPO4.setInducelabour(inducelabour4);
				childbirthBabyInfoPO4.setMidwife(midwife4);
				childbirthBabyInfoPO4.setOneMinScore(oneMinScore4);
				childbirthBabyInfoPO4.setVaccine(vaccine4);
				childbirthBabyInfoService.create(childbirthBabyInfoPO4);
				}
				
				
				
				String babyName5 =(String) reqs.get("babyName5");
				String deliveryType5 =(String) reqs.get("deliveryType5");
				if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!=""){
				String yid=IdUtil.uuid();
				String fetusPosition5 =(String) reqs.get("fetusPosition5");
				String deliveryHour5 =(String) reqs.get("deliveryHour5");
				String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
				String inducelabour5 =(String) reqs.get("inducelabour5");
				String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
				String babySex5 =(String) reqs.get("babySex5");
				String health5 =(String) reqs.get("health5");
				String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
				String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
				String abnormalName5 =(String) reqs.get("abnormalName5");
				String oneMinScore5 =(String) reqs.get("oneMinScore5");
				String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
				String bornWeight5 =(String) reqs.get("bornWeight5");
				String vaccine5 =(String) reqs.get("babyVaccine5");
				String fetusDie5 =(String) reqs.get("fetusDie5");
				String midwife5 =(String) reqs.get("midwife5");
				ChildbirthBabyInfoPO childbirthBabyInfoPO5 = new ChildbirthBabyInfoPO();
				childbirthBabyInfoPO5.setFetusPosition(fetusPosition5);
				childbirthBabyInfoPO5.setBabyName(babyName5);
				childbirthBabyInfoPO5.setAbnormalName(abnormalName5);
				childbirthBabyInfoPO5.setAbnormalPosition(abnormalPosition5);
				childbirthBabyInfoPO5.setBabySex(babySex5);
				childbirthBabyInfoPO5.setBodyLenght(bornWeight5);
				childbirthBabyInfoPO5.setBornWeight(bornWeight5);
				childbirthBabyInfoPO5.setCesareanIdicatio(cesareanIdicatio5);
				childbirthBabyInfoPO5.setDeliveryHour(deliveryHour5);
				childbirthBabyInfoPO5.setDeliveryMinute(deliveryMinute5);
				childbirthBabyInfoPO5.setDeliveryType(deliveryType5);
				childbirthBabyInfoPO5.setFetalAnomaly(fetalAnomaly5);
				childbirthBabyInfoPO5.setFetusDie(fetusDie5);
				childbirthBabyInfoPO5.setFetusPosition(fetusPosition5);
				childbirthBabyInfoPO5.setFiveMinScore(fiveMinScore5);
				childbirthBabyInfoPO5.setHealth(health5);
				childbirthBabyInfoPO5.setId(yid);
				childbirthBabyInfoPO5.setChildbirthId(cid);
				childbirthBabyInfoPO5.setInducelabour(inducelabour5);
				childbirthBabyInfoPO5.setMidwife(midwife5);
				childbirthBabyInfoPO5.setOneMinScore(oneMinScore5);
				childbirthBabyInfoPO5.setVaccine(vaccine5);
				childbirthBabyInfoService.create(childbirthBabyInfoPO5);
				}
				String babyName6 =(String) reqs.get("babyName6");
				String deliveryType6 =(String) reqs.get("deliveryType6");
				if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!=""){
				String fid=IdUtil.uuid();
				String fetusPosition6 =(String) reqs.get("fetusPosition6");
				String deliveryHour6 =(String) reqs.get("deliveryHour6");
				String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
				String inducelabour6 =(String) reqs.get("inducelabour6");
				String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
				String babySex6 =(String) reqs.get("babySex6");
				String health6 =(String) reqs.get("health6");
				String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
				String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
				String abnormalName6 =(String) reqs.get("abnormalName6");
				String oneMinScore6 =(String) reqs.get("oneMinScore6");
				String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
				String bornWeight6 =(String) reqs.get("bornWeight6");
				String vaccine6 =(String) reqs.get("babyVaccine6");
				String fetusDie6 =(String) reqs.get("fetusDie6");
				String midwife6 =(String) reqs.get("midwife6");
				ChildbirthBabyInfoPO childbirthBabyInfoPO6 = new ChildbirthBabyInfoPO();
				childbirthBabyInfoPO6.setFetusPosition(fetusPosition6);
				childbirthBabyInfoPO6.setBabyName(babyName6);
				childbirthBabyInfoPO6.setAbnormalName(abnormalName6);
				childbirthBabyInfoPO6.setAbnormalPosition(abnormalPosition6);
				childbirthBabyInfoPO6.setBabySex(babySex6);
				childbirthBabyInfoPO6.setBodyLenght(bornWeight6);
				childbirthBabyInfoPO6.setBornWeight(bornWeight6);
				childbirthBabyInfoPO6.setCesareanIdicatio(cesareanIdicatio6);
				childbirthBabyInfoPO6.setDeliveryHour(deliveryHour6);
				childbirthBabyInfoPO6.setDeliveryMinute(deliveryMinute6);
				childbirthBabyInfoPO6.setDeliveryType(deliveryType6);
				childbirthBabyInfoPO6.setFetalAnomaly(fetalAnomaly6);
				childbirthBabyInfoPO6.setFetusDie(fetusDie6);
				childbirthBabyInfoPO6.setFetusPosition(fetusPosition6);
				childbirthBabyInfoPO6.setFiveMinScore(fiveMinScore6);
				childbirthBabyInfoPO6.setHealth(health6);
				childbirthBabyInfoPO6.setId(fid);
				childbirthBabyInfoPO6.setChildbirthId(cid);
				childbirthBabyInfoPO6.setInducelabour(inducelabour6);
				childbirthBabyInfoPO6.setMidwife(midwife6);
				childbirthBabyInfoPO6.setOneMinScore(oneMinScore6);
				childbirthBabyInfoPO6.setVaccine(vaccine6);
				childbirthBabyInfoService.create(childbirthBabyInfoPO6);
				
				}
				
				//查询高危信息
				
				String highRiskId =(String) reqs.get("highRiskId");
				
				if(highRiskId !=null &&highRiskId !=""){
				
				HighRiskInfoPO highRiskInfoPO = highRiskInfoService.find(highRiskId);
				
				PrenatalExaInfoPO prenatalExa = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(id2);
				
				String prenatalExaid = prenatalExa.getId();
				
				highRiskInfoPO.setExaminationId(prenatalExaid);
				
				highRiskInfoService.update(highRiskInfoPO);
				}
				
				}
				//保存
				if(editStatus.equals("0")){
					String chid=archivesId;
					
					//创建生育档案信息
					BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
					
					String id2 = birthArchivesInfoPO.getId();
					
					
					
					
					
					//创建分娩基本信息的id(id)
					String id =IdUtil.uuid();
					String birthDate =(String) reqs.get("birthDate");
					String leaveDate =(String) reqs.get("leaveDate");
					
	 				SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
					if(birthDate !=null){
					Date date = formate.parse(birthDate);
					childbirthBasicInfoVO.setBirthDate(date);
					}
					if(leaveDate !=null){
					Date leave = formate.parse(leaveDate);
					childbirthBasicInfoVO.setLeaveDate(leave);
					}
					
					String BasicCreateTime =(String) reqs.get("BasicCreateTime");
					//创建时间
					if(BasicCreateTime !=null){
						Date createTime = formate.parse(BasicCreateTime);
						childbirthBasicInfoVO.setCreatTime(createTime);
						childbirthBasicInfoVO.setUpdateTime(new Date());
						childbirthBasicInfoVO.setNormalSign("0");
					}
					if(BasicCreateTime==null||BasicCreateTime==""){
						childbirthBasicInfoVO.setCreatTime(new Date());
						childbirthBasicInfoVO.setUpdateTime(new Date());
						childbirthBasicInfoVO.setNormalSign("1");
					}
					
					ChildbirthBasicInfoPO childbirthBasicInfoPO = new ChildbirthBasicInfoPO();
					
					
					childbirthBasicInfoVO.setId(id);
					childbirthBasicInfoVO.setDoctorId(operatorId);
					childbirthBasicInfoVO.setEditStatus(editStatus);
					childbirthBasicInfoVO.setBirthArchivesId(id2);
					BeanUtils.copyProperties(childbirthBasicInfoPO, childbirthBasicInfoVO);
					childbirthBasicInfoService.create(childbirthBasicInfoPO);
					
					
					
					//创建分娩信息
					//创建分娩信息的id(cid)
					String cid =IdUtil.uuid();
					ChildbirthInfoPO childbirthInfoPO = new ChildbirthInfoPO();
					childbirthInfoVO.setId(cid);
					childbirthInfoVO.setBasicId(id);
					
					//获得分娩地点
					String childbirthPlace = childbirthInfoVO.getChildbirthPlace();
					
					if(childbirthPlace != null && childbirthPlace!=""){
						String[] split = childbirthPlace.split(",");
								childbirthInfoVO.setChildbirthPlace(split[0]);
							
					}
					BeanUtils.copyProperties(childbirthInfoPO, childbirthInfoVO);
					childbirthInfoService.create(childbirthInfoPO);
					
					
					//创建转诊信息
					//创建转诊信息的id(did)
					
					
					String did =IdUtil.uuid();
					String referral = childbirthReferralInfoVO.getReferral();
					if(referral !=null){
					//当转诊标识为1，确认转诊时
					if(referral.equals("1")){
						String idde =(String) reqs.get("department");
						String mechanism =(String) reqs.get("mechanism");
						
			
						//将转诊标识设置为分娩转诊
						birthArchivesInfoPO.setReferralSign("2");
						birthArchivesInfoPO.setPredictDate(new Date());
						birthArchivesInfoPO.setOutHospitalId(idde);
						birthArchivesInfoPO.setDeltetSign("1");
						birthArchivesInfoPO.setPregnantState("0");
						
						
						birthArchivesInfoService.update(birthArchivesInfoPO);
					childbirthReferralInfoVO.setId(did);
					childbirthReferralInfoVO.setBasicId(id);
					ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
					BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
					childbirthReferralInfoService.create(childbirthReferralInfoPO);
					}
					//当没有转诊时
					if(referral.equals("0")){
						
						
						birthArchivesInfoPO.setReferralSign("0");
						
						birthArchivesInfoPO.setDeltetSign("1");
						birthArchivesInfoPO.setPregnantState("0");
						
						birthArchivesInfoService.update(birthArchivesInfoPO);
						
						
						
						childbirthReferralInfoVO.setId(did);
						childbirthReferralInfoVO.setBasicId(id);
						ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
						BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
						childbirthReferralInfoService.create(childbirthReferralInfoPO);
						
						}
					}
					//创建分娩婴儿信息
					String bid =IdUtil.uuid();
					ChildbirthBabyInfoPO childbirthBabyInfoPO = new ChildbirthBabyInfoPO();
					childbirthBabyInfoVO.setId(bid);
					childbirthBabyInfoVO.setChildbirthId(cid);
					BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
					childbirthBabyInfoService.create(childbirthBabyInfoPO);
					
					
					
					//创建第一个婴儿信息
					String babyName1 =(String) reqs.get("babyName1");
					String deliveryType1 =(String) reqs.get("deliveryType1");
					if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
					String uid=IdUtil.uuid();
					String fetusPosition =(String) reqs.get("fetusPosition1");
					String deliveryHour =(String) reqs.get("deliveryHour1");
					String deliveryMinute =(String) reqs.get("deliveryMinute1");
					String inducelabour =(String) reqs.get("inducelabour1");
					String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
					String babySex =(String) reqs.get("babySex1");
					String health =(String) reqs.get("health1");
					String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
					String abnormalPosition =(String) reqs.get("abnormalPosition1");
					String abnormalName =(String) reqs.get("abnormalName1");
					String oneMinScore =(String) reqs.get("oneMinScore1");
					String fiveMinScore =(String) reqs.get("fiveMinScore1");
					String bornWeight =(String) reqs.get("bornWeight1");
					String vaccine =(String) reqs.get("babyVaccine1");
					String fetusDie =(String) reqs.get("fetusDie1");
					
					
					
					String midwife =(String) reqs.get("midwife1");
					ChildbirthBabyInfoPO childbirthBabyInfoPO1 = new ChildbirthBabyInfoPO();
					childbirthBabyInfoPO1.setFetusPosition(fetusPosition);
					childbirthBabyInfoPO1.setBabyName(babyName1);
					childbirthBabyInfoPO1.setAbnormalName(abnormalName);
					childbirthBabyInfoPO1.setAbnormalPosition(abnormalPosition);
					childbirthBabyInfoPO1.setBabySex(babySex);
					childbirthBabyInfoPO1.setBodyLenght(bornWeight);
					childbirthBabyInfoPO1.setBornWeight(bornWeight);
					childbirthBabyInfoPO1.setCesareanIdicatio(cesareanIdicatio);
					childbirthBabyInfoPO1.setDeliveryHour(deliveryHour);
					childbirthBabyInfoPO1.setDeliveryMinute(deliveryMinute);
					childbirthBabyInfoPO1.setDeliveryType(deliveryType1);
					childbirthBabyInfoPO1.setFetalAnomaly(fetalAnomaly);
					childbirthBabyInfoPO1.setFetusDie(fetusDie);
					childbirthBabyInfoPO1.setFetusPosition(fetusPosition);
					childbirthBabyInfoPO1.setFiveMinScore(fiveMinScore);
					childbirthBabyInfoPO1.setHealth(health);
					childbirthBabyInfoPO1.setId(uid);
					childbirthBabyInfoPO1.setChildbirthId(cid);
					childbirthBabyInfoPO1.setInducelabour(inducelabour);
					childbirthBabyInfoPO1.setMidwife(midwife);
					childbirthBabyInfoPO1.setOneMinScore(oneMinScore);
					childbirthBabyInfoPO1.setVaccine(vaccine);
					childbirthBabyInfoService.create(childbirthBabyInfoPO1);
					}
					
					//创建第二个婴儿信息
					String babyName2 =(String) reqs.get("babyName2");
					String deliveryType2 =(String) reqs.get("deliveryType2");
					if(deliveryType2 !=null && deliveryType2 !="" &&babyName2!=null &&babyName2!="") {
					String wid=IdUtil.uuid();
					String fetusPosition2 =(String) reqs.get("fetusPosition2");
					String deliveryHour2 =(String) reqs.get("deliveryHour2");
					String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
					String inducelabour2 =(String) reqs.get("inducelabour2");
					String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
					String babySex2 =(String) reqs.get("babySex2");
					String health2 =(String) reqs.get("health2");
					String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
					String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
					String abnormalName2 =(String) reqs.get("abnormalName2");
					String oneMinScore2 =(String) reqs.get("oneMinScore2");
					String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
					String bornWeight2 =(String) reqs.get("bornWeight2");
					String vaccine2 =(String) reqs.get("babyVaccine2");
					String fetusDie2 =(String) reqs.get("fetusDie2");
					String midwife2 =(String) reqs.get("midwife2");
					ChildbirthBabyInfoPO childbirthBabyInfoPO2 = new ChildbirthBabyInfoPO();
					childbirthBabyInfoPO2.setFetusPosition(fetusPosition2);
					childbirthBabyInfoPO2.setBabyName(babyName2);
					childbirthBabyInfoPO2.setAbnormalName(abnormalName2);
					childbirthBabyInfoPO2.setAbnormalPosition(abnormalPosition2);
					childbirthBabyInfoPO2.setBabySex(babySex2);
					childbirthBabyInfoPO2.setBodyLenght(bornWeight2);
					childbirthBabyInfoPO2.setBornWeight(bornWeight2);
					childbirthBabyInfoPO2.setCesareanIdicatio(cesareanIdicatio2);
					childbirthBabyInfoPO2.setDeliveryHour(deliveryHour2);
					childbirthBabyInfoPO2.setDeliveryMinute(deliveryMinute2);
					childbirthBabyInfoPO2.setDeliveryType(deliveryType2);
					childbirthBabyInfoPO2.setFetalAnomaly(fetalAnomaly2);
					childbirthBabyInfoPO2.setFetusDie(fetusDie2);
					childbirthBabyInfoPO2.setFetusPosition(fetusPosition2);
					childbirthBabyInfoPO2.setFiveMinScore(fiveMinScore2);
					childbirthBabyInfoPO2.setHealth(health2);
					childbirthBabyInfoPO2.setId(wid);
					childbirthBabyInfoPO2.setChildbirthId(cid);
					childbirthBabyInfoPO2.setInducelabour(inducelabour2);
					childbirthBabyInfoPO2.setMidwife(midwife2);
					childbirthBabyInfoPO2.setOneMinScore(oneMinScore2);
					childbirthBabyInfoPO2.setVaccine(vaccine2);
					childbirthBabyInfoService.create(childbirthBabyInfoPO2);
					}
					
					
					String babyName3 =(String) reqs.get("babyName3");
					String deliveryType3 =(String) reqs.get("deliveryType3");
					if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
					String sid=IdUtil.uuid();
					String fetusPosition3 =(String) reqs.get("fetusPosition3");
					String deliveryHour3 =(String) reqs.get("deliveryHour3");
					String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
					String inducelabour3 =(String) reqs.get("inducelabour3");
					String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
					String babySex3 =(String) reqs.get("babySex3");
					String health3 =(String) reqs.get("health3");
					String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
					String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
					String abnormalName3 =(String) reqs.get("abnormalName3");
					String oneMinScore3 =(String) reqs.get("oneMinScore3");
					String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
					String bornWeight3 =(String) reqs.get("bornWeight3");
					String vaccine3 =(String) reqs.get("babyVaccine3");
					String fetusDie3 =(String) reqs.get("fetusDie3");
					String midwife3 =(String) reqs.get("midwife3");
					ChildbirthBabyInfoPO childbirthBabyInfoPO3 = new ChildbirthBabyInfoPO();
					childbirthBabyInfoPO3.setFetusPosition(fetusPosition3);
					childbirthBabyInfoPO3.setBabyName(babyName3);
					childbirthBabyInfoPO3.setAbnormalName(abnormalName3);
					childbirthBabyInfoPO3.setAbnormalPosition(abnormalPosition3);
					childbirthBabyInfoPO3.setBabySex(babySex3);
					childbirthBabyInfoPO3.setBodyLenght(bornWeight3);
					childbirthBabyInfoPO3.setBornWeight(bornWeight3);
					childbirthBabyInfoPO3.setCesareanIdicatio(cesareanIdicatio3);
					childbirthBabyInfoPO3.setDeliveryHour(deliveryHour3);
					childbirthBabyInfoPO3.setDeliveryMinute(deliveryMinute3);
					childbirthBabyInfoPO3.setDeliveryType(deliveryType3);
					childbirthBabyInfoPO3.setFetalAnomaly(fetalAnomaly3);
					childbirthBabyInfoPO3.setFetusDie(fetusDie3);
					childbirthBabyInfoPO3.setFetusPosition(fetusPosition3);
					childbirthBabyInfoPO3.setFiveMinScore(fiveMinScore3);
					childbirthBabyInfoPO3.setHealth(health3);
					childbirthBabyInfoPO3.setId(sid);
					childbirthBabyInfoPO3.setChildbirthId(cid);
					childbirthBabyInfoPO3.setInducelabour(inducelabour3);
					childbirthBabyInfoPO3.setMidwife(midwife3);
					childbirthBabyInfoPO3.setOneMinScore(oneMinScore3);
					childbirthBabyInfoPO3.setVaccine(vaccine3);
					childbirthBabyInfoService.create(childbirthBabyInfoPO3);
					
					}
					
					
					
					String babyName4 =(String) reqs.get("babyName4");
					String deliveryType4 =(String) reqs.get("deliveryType4");
					if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
					String rid=IdUtil.uuid();
					String fetusPosition4 =(String) reqs.get("fetusPosition4");
					String deliveryHour4 =(String) reqs.get("deliveryHour4");
					String inducelabour4 =(String) reqs.get("inducelabour4");
					String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
					String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
					String babySex4 =(String) reqs.get("babySex4");
					String health4 =(String) reqs.get("health4");
					String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
					String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
					String abnormalName4 =(String) reqs.get("abnormalName4");
					String oneMinScore4 =(String) reqs.get("oneMinScore4");
					String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
					String bornWeight4 =(String) reqs.get("bornWeight4");
					String vaccine4 =(String) reqs.get("babyVaccine4");
					String fetusDie4 =(String) reqs.get("fetusDie4");
					String midwife4 =(String) reqs.get("midwife4");
					ChildbirthBabyInfoPO childbirthBabyInfoPO4 = new ChildbirthBabyInfoPO();
					childbirthBabyInfoPO4.setFetusPosition(fetusPosition4);
					childbirthBabyInfoPO4.setBabyName(babyName4);
					childbirthBabyInfoPO4.setAbnormalName(abnormalName4);
					childbirthBabyInfoPO4.setAbnormalPosition(abnormalPosition4);
					childbirthBabyInfoPO4.setBabySex(babySex4);
					childbirthBabyInfoPO4.setBodyLenght(bornWeight4);
					childbirthBabyInfoPO4.setBornWeight(bornWeight4);
					childbirthBabyInfoPO4.setCesareanIdicatio(cesareanIdicatio4);
					childbirthBabyInfoPO4.setDeliveryHour(deliveryHour4);
					childbirthBabyInfoPO4.setDeliveryMinute(deliveryMinute4);
					childbirthBabyInfoPO4.setDeliveryType(deliveryType4);
					childbirthBabyInfoPO4.setFetalAnomaly(fetalAnomaly4);
					childbirthBabyInfoPO4.setFetusDie(fetusDie4);
					childbirthBabyInfoPO4.setFetusPosition(fetusPosition4);
					childbirthBabyInfoPO4.setFiveMinScore(fiveMinScore4);
					childbirthBabyInfoPO4.setHealth(health4);
					childbirthBabyInfoPO4.setId(rid);
					childbirthBabyInfoPO4.setChildbirthId(cid);
					childbirthBabyInfoPO4.setInducelabour(inducelabour4);
					childbirthBabyInfoPO4.setMidwife(midwife4);
					childbirthBabyInfoPO4.setOneMinScore(oneMinScore4);
					childbirthBabyInfoPO4.setVaccine(vaccine4);
					childbirthBabyInfoService.create(childbirthBabyInfoPO4);
					}
					
					
					
					String babyName5 =(String) reqs.get("babyName5");
					String deliveryType5 =(String) reqs.get("deliveryType5");
					if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!=""){
					String yid=IdUtil.uuid();
					String fetusPosition5 =(String) reqs.get("fetusPosition5");
					String deliveryHour5 =(String) reqs.get("deliveryHour5");
					String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
					String inducelabour5 =(String) reqs.get("inducelabour5");
					String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
					String babySex5 =(String) reqs.get("babySex5");
					String health5 =(String) reqs.get("health5");
					String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
					String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
					String abnormalName5 =(String) reqs.get("abnormalName5");
					String oneMinScore5 =(String) reqs.get("oneMinScore5");
					String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
					String bornWeight5 =(String) reqs.get("bornWeight5");
					String vaccine5 =(String) reqs.get("babyVaccine5");
					String fetusDie5 =(String) reqs.get("fetusDie5");
					String midwife5 =(String) reqs.get("midwife5");
					ChildbirthBabyInfoPO childbirthBabyInfoPO5 = new ChildbirthBabyInfoPO();
					childbirthBabyInfoPO5.setFetusPosition(fetusPosition5);
					childbirthBabyInfoPO5.setBabyName(babyName5);
					childbirthBabyInfoPO5.setAbnormalName(abnormalName5);
					childbirthBabyInfoPO5.setAbnormalPosition(abnormalPosition5);
					childbirthBabyInfoPO5.setBabySex(babySex5);
					childbirthBabyInfoPO5.setBodyLenght(bornWeight5);
					childbirthBabyInfoPO5.setBornWeight(bornWeight5);
					childbirthBabyInfoPO5.setCesareanIdicatio(cesareanIdicatio5);
					childbirthBabyInfoPO5.setDeliveryHour(deliveryHour5);
					childbirthBabyInfoPO5.setDeliveryMinute(deliveryMinute5);
					childbirthBabyInfoPO5.setDeliveryType(deliveryType5);
					childbirthBabyInfoPO5.setFetalAnomaly(fetalAnomaly5);
					childbirthBabyInfoPO5.setFetusDie(fetusDie5);
					childbirthBabyInfoPO5.setFetusPosition(fetusPosition5);
					childbirthBabyInfoPO5.setFiveMinScore(fiveMinScore5);
					childbirthBabyInfoPO5.setHealth(health5);
					childbirthBabyInfoPO5.setId(yid);
					childbirthBabyInfoPO5.setChildbirthId(cid);
					childbirthBabyInfoPO5.setInducelabour(inducelabour5);
					childbirthBabyInfoPO5.setMidwife(midwife5);
					childbirthBabyInfoPO5.setOneMinScore(oneMinScore5);
					childbirthBabyInfoPO5.setVaccine(vaccine5);
					childbirthBabyInfoService.create(childbirthBabyInfoPO5);
					}
					String babyName6 =(String) reqs.get("babyName6");
					String deliveryType6 =(String) reqs.get("deliveryType6");
					if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!=""){
					String fid=IdUtil.uuid();
					String fetusPosition6 =(String) reqs.get("fetusPosition6");
					String deliveryHour6 =(String) reqs.get("deliveryHour6");
					String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
					String inducelabour6 =(String) reqs.get("inducelabour6");
					String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
					String babySex6 =(String) reqs.get("babySex6");
					String health6 =(String) reqs.get("health6");
					String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
					String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
					String abnormalName6 =(String) reqs.get("abnormalName6");
					String oneMinScore6 =(String) reqs.get("oneMinScore6");
					String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
					String bornWeight6 =(String) reqs.get("bornWeight6");
					String vaccine6 =(String) reqs.get("babyVaccine6");
					String fetusDie6 =(String) reqs.get("fetusDie6");
					String midwife6 =(String) reqs.get("midwife6");
					ChildbirthBabyInfoPO childbirthBabyInfoPO6 = new ChildbirthBabyInfoPO();
					childbirthBabyInfoPO6.setFetusPosition(fetusPosition6);
					childbirthBabyInfoPO6.setBabyName(babyName6);
					childbirthBabyInfoPO6.setAbnormalName(abnormalName6);
					childbirthBabyInfoPO6.setAbnormalPosition(abnormalPosition6);
					childbirthBabyInfoPO6.setBabySex(babySex6);
					childbirthBabyInfoPO6.setBodyLenght(bornWeight6);
					childbirthBabyInfoPO6.setBornWeight(bornWeight6);
					childbirthBabyInfoPO6.setCesareanIdicatio(cesareanIdicatio6);
					childbirthBabyInfoPO6.setDeliveryHour(deliveryHour6);
					childbirthBabyInfoPO6.setDeliveryMinute(deliveryMinute6);
					childbirthBabyInfoPO6.setDeliveryType(deliveryType6);
					childbirthBabyInfoPO6.setFetalAnomaly(fetalAnomaly6);
					childbirthBabyInfoPO6.setFetusDie(fetusDie6);
					childbirthBabyInfoPO6.setFetusPosition(fetusPosition6);
					childbirthBabyInfoPO6.setFiveMinScore(fiveMinScore6);
					childbirthBabyInfoPO6.setHealth(health6);
					childbirthBabyInfoPO6.setId(fid);
					childbirthBabyInfoPO6.setChildbirthId(cid);
					childbirthBabyInfoPO6.setInducelabour(inducelabour6);
					childbirthBabyInfoPO6.setMidwife(midwife6);
					childbirthBabyInfoPO6.setOneMinScore(oneMinScore6);
					childbirthBabyInfoPO6.setVaccine(vaccine6);
					childbirthBabyInfoService.create(childbirthBabyInfoPO6);
					
					
					
					//查询高危信息
					
					String highRiskId =(String) reqs.get("highRiskId");
					if(highRiskId !=null &&highRiskId !=""){
					HighRiskInfoPO highRiskInfoPO = highRiskInfoService.find(highRiskId);
					
					PrenatalExaInfoPO prenatalExa = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(id2);
					
					String prenatalExaid = prenatalExa.getId();
					
					highRiskInfoPO.setExaminationId(prenatalExaid);
					
					highRiskInfoService.update(highRiskInfoPO);
					}
					}
					
					
				}
			
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			return model;
		
	}
	/**
	 * 进入产检  
	 * @param id
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/comePrenatalExa",method=RequestMethod.GET)
	public ModelAndView comePrenatalExa(@RequestParam("id")String id,HttpSession session){
		
		ModelAndView mv = new ModelAndView();
		
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(id);
		BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.getNearBirthArchivesByArchivesId(archivesInfoPO.getId());
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
		//String level = departmentService.queryQyByName(operator2.getDepartment());
		List<DepartmentPO> depts = departmentService.getAllDepartment();
		mv.addObject("depts", depts);
		List<RolePO> roles = roleService.getAll();
		
		String pregnantState = birthArchivesInfoPO.getPregnantState();
		if(pregnantState == null || "".equals(pregnantState)){
			birthArchivesInfoPO.setPregnantState("0");
			birthArchivesInfoService.updateStatus(birthArchivesInfoPO);
		}
		Date lastMenses2 = birthArchivesInfoPO.getLastMenses();
		int w = 0;
		int d = 0;
		if(lastMenses2 != null){
			w = DateUtils.getWeekByLastMenses(lastMenses2);
			d = DateUtils.getDayByLastMenses(lastMenses2);
		}
		mv.addObject("w", w);
		mv.addObject("d", d);
		if(w != 0){
			
			if(w < 13 && w > 0){
				PrenatalExaInfoPO prenatal = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchivesInfoPO.getId());
				if(prenatal != null){
					FirstMotherhoodInfoPO firstMoth = firstMotherhoodInfoService.getFirstMotherhoodByPreantalExaId(prenatal.getId());
					if(firstMoth != null){
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
						if(firstHistoryCheck!=null){
							historyChecks.add(firstHistoryCheck);
						}
						//获取第2-N次检查对应的历史检查记录
						List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesInfoPO.getId());
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
				
				String riskSign = birthArchivesInfoPO.getRiskSign();
				String correct = "-1";
				if("1".equals(riskSign)){
					HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
					if(highRiskInfoPO != null){
						List<HighRiskTermPO> list = highRiskTermService.getThisHighRiskTermByHighRiskId(highRiskInfoPO.getId());
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
				if(firstHistoryCheck!=null){
					historyChecks.add(firstHistoryCheck);
				}
				//获取第2-N次检查对应的历史检查记录
				List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesInfoPO.getId());
				if(secondOrMoreHistoryChecks != null && secondOrMoreHistoryChecks.size() > 0){
					historyChecks.addAll(secondOrMoreHistoryChecks);
				}
				mv.addObject("historyChecks", historyChecks);
			}
			
		}else{
		
			if(pregnantState == null){
				
				mv.setViewName("/prenatal/first_prenatal_exa");
			}else if(("0").equals(pregnantState)){
				int count = prenatalExaInfoService.countPrenatalByBirthId(birthArchivesInfoPO.getId());
				if(count == 0){
					mv.setViewName("/prenatal/first_prenatal_exa");
				}
				if(count > 0){
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
					if(firstHistoryCheck!=null){
						historyChecks.add(firstHistoryCheck);
					}
					//获取第2-N次检查对应的历史检查记录
					List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birthArchivesInfoPO.getId());
					if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
						historyChecks.addAll(secondOrMoreHistoryChecks);
					}
					mv.addObject("historyChecks", historyChecks);
				}
			}
		}
		mv.addObject("birthArchives", birthArchivesInfoPO);
		mv.addObject("roles", roles);
		mv.addObject("birth", birth);
		mv.addObject("nomal", "1");
		mv.addObject("archives", archivesInfoPO);
		mv.addObject("time", time);
		mv.addObject("operator",operator2);
		
		return mv;
	}
	
	/**
	 * 孕检建档返回档案号
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/prenatalArchives",method=RequestMethod.POST)
	public Model prenatalNewArchives(ArchivesInfoVO archivesInfoVO, 
									@RequestParam(value="frantNum",required=false,defaultValue="")String frantNum,
									@RequestParam(value="grantSign",required=false,defaultValue="")String grantSign,
									@RequestParam(value="birthday")String birth,
									@RequestParam(value="manBirthday")String manBirth,
									@RequestParam(value="lastMenses",required=false,defaultValue="")String last,
									@RequestParam(value="predictDate",required=false,defaultValue="")String predict,
									HttpSession session){
		Model model = new Model();
		ArchivesInfoPO archives = new ArchivesInfoPO();
		try {
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			Date createTime = new Date();
			SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
			Date parse = formate.parse(birth);
			//Date birthday = DateUtil.stringToDate(birth);
			//Date stringToDate = DateUtil.stringToDate(birth);
			//Date manBirthday = DateUtil.stringToDate(manBirth);
			Date manBirthday = formate.parse(manBirth);
			archivesInfoVO.setHospitalId(operator.getDepId());
			archivesInfoVO.setCreatTime(createTime);
			archivesInfoVO.setDoctorId(operator.getId());
			archivesInfoVO.setBirthday(parse);
			archivesInfoVO.setManBirthday(manBirthday);
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			
			BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
			if(frantNum == ""){
				frantNum = null;
			}
			if(grantSign == ""){
				grantSign = null;
			}
			if(last != "" && last != null && last.length() == 8){
				Date lastMenses = DateUtil.stringToDate(last);
				birthArchivesInfoPO.setLastMenses(lastMenses);
			}
			if(predict != "" && predict != null&& predict.length() == 8){
				Date predictDate = DateUtil.stringToDate(predict);
				birthArchivesInfoPO.setPredictDate(predictDate);
			}
			birthArchivesInfoPO.setFrantNum(frantNum);
			birthArchivesInfoPO.setGrantSign(grantSign);
			archives = archivesInfoService.prenatalNewArchives(archivesInfoPO,birthArchivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.set("archives", archives);
		
		return model;
	}
	
	/**
	 * 通过身份证号或者档案号查询档案信息
	 * @return
	 * @param idOrCode
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/selectArchivesByIdOrCode",method=RequestMethod.GET)
	public Model getArchivesByIdNumOrPrenatalExal(@RequestParam("idOrCode") String idOrCode){
		
		Model model = new Model();
		Map<String, Object> map = archivesInfoService.getArchivesOrPrenatalExal(idOrCode); 
		
		model.set("map", map);
		return model;
	}
	
	/**
	 * 男性建档 补全女性的档案信息
	 * @param archivesInfoVO
	 * @param ct
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/man",method=RequestMethod.POST)
	public Model replenishManArchives(ArchivesInfoVO archivesInfoVO, 
									  @RequestParam("createTime")String ct,
									  @RequestParam("birthday")String birth,
									  HttpSession session){
		
		Model model = new Model();
		model.set("msg", true);
		try {
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			Date createTime = new Date();
			Date birthday = DateUtil.stringToDate(birth);
			archivesInfoVO.setHospitalId(operator.getDepId());
			archivesInfoVO.setCreatTime(createTime);
			archivesInfoVO.setDoctorId(operator.getId());
			archivesInfoVO.setBirthday(birthday);
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			
			archivesInfoService.replenishManArchives(archivesInfoPO);
			model.set("archives", archivesInfoVO);
		}catch(Exception e){
			e.printStackTrace();
			model.set("msg", false);
		}
		
		return model;
	}
	/**
	 * 通过档案号返回对象补全对方的信息
	 * @param archivesCode
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/selectWoman",method=RequestMethod.GET)
	public Model getArchivesByArchivesCode(@RequestParam("archivesCode")String archivesCode){
		
		Model model = new Model();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.getArchivesByArchivesCode(archivesCode);
		model.set("archivesInfoPO", archivesInfoPO);
		return model;
	}
	
	
	/**
	 * 女性建档并返回档案号
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/woman",method=RequestMethod.POST)
	public Model womanBuildArchives(ArchivesInfoVO archivesInfoVO, 
									@RequestParam(value="frantNum",required=false,defaultValue="")String frantNum,
									@RequestParam(value="grantSign",required=false,defaultValue="")String grantSign,
									@RequestParam("birthday")String birth,
									HttpSession session){
		
		Model model = new Model();
		Map<String ,Object> map = null;
		try {
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			Date createTime = new Date();
			Date birthday = DateUtil.stringToDate(birth);
			archivesInfoVO.setHospitalId(operator.getDepId());
			archivesInfoVO.setCreatTime(createTime);
			archivesInfoVO.setDoctorId(operator.getId());
			archivesInfoVO.setBirthday(birthday);
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			
			BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
			if(frantNum == ""){
				frantNum = null;
			}
			if(grantSign == ""){
				grantSign = null;
			}
			birthArchivesInfoPO.setFrantNum(frantNum);
			birthArchivesInfoPO.setGrantSign(grantSign);
			map = archivesInfoService.womanBuildArchices(archivesInfoPO,birthArchivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.set("map", map);
		return model;
	}

    /**
     * 女性婚检管理页面
	 * ARCHIVES_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listArchivesInfoView(HttpSession session) {
		log.debug("request page: /sysset/archivesInfo/archivesInfo_list");
		ModelAndView mav = new ModelAndView("inspect/premarital_list");
		
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String doctId = operator.getId();
		String admin = archivesInfoService.getAdminId();
		String admId = archivesInfoService.getAdmId();
		mav.addObject("doctId",doctId);
		mav.addObject("adminId",admin);
		mav.addObject("admId",admId);
		return mav;
	}
	/**
	 * 女性婚检管理列表
	 * ARCHIVES_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listArchivesInfoActoin(@RequestParam Map<String, Object> reqs, Page<ArchivesInfoPO> page,
										HttpSession session) {
		log.debug("request data: listArchivesInfo");
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			
			archivesInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		
		return model;
	}
	
	/**
	 * 医生
	 * @param reqs
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doctor")
	public Model doctorAction() {
		Model model = new Model();
		
		List<OperatorPO> findAll= operatorService.findAll();
		
		if (findAll != null) {
			
			model.set("list", findAll);
		}
		
		return model;
	}
	
	/**
     * 男性婚检管理页面
	 * ARCHIVES_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/manList", method = RequestMethod.GET)
	public ModelAndView manListArchivesInfoView(HttpSession session) {
		log.debug("request page: /sysset/archivesInfo/archivesInfo_list");
		ModelAndView mav = new ModelAndView("inspect/premarital_manList");
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String doctId = operator.getId();
		String admin = archivesInfoService.getAdminId();
		String admId = archivesInfoService.getAdmId();
		mav.addObject("admId",admId);
		mav.addObject("doctId",doctId);
		mav.addObject("adminId",admin);
		
		return mav;
	}

	/**
	 * 男性婚检管理列表
	 * ARCHIVES_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manList", method = RequestMethod.POST)
	public Model manListArchivesInfoActoin(@RequestParam Map<String, Object> reqs, Page<ArchivesInfoPO> page) {
		log.debug("request data: listArchivesInfo");
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			archivesInfoService.manListForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * ARCHIVES_INFO 添加
	 * 
	 * @param archivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addArchivesInfoActoin(ArchivesInfoVO archivesInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			archivesInfoService.create(archivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * ARCHIVES_INFO 修改
	 * 
	 * @param archivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateArchivesInfoActoin(ArchivesInfoVO archivesInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			archivesInfoService.update(archivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * ARCHIVES_INFO 女性修改
	 * 
	 * @param archivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateWoman", method = RequestMethod.POST)
	public ModelAndView updateWoman(ArchivesInfoVO archivesInfoVO,
									@RequestParam("archivesCode")String archivesCode,
									@RequestParam("birthday")String birth) {
		ModelAndView mav = new ModelAndView();
		try {
			
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			//archivesInfoPO.setId(archivesId);
			archivesInfoVO.setArchivesCode(archivesCode);
			Date birthday = DateUtil.stringToDate(birth,DateStyle.YYYYMMDD);
			archivesInfoVO.setBirthday(birthday);
			Date updateTime = new Date();
			archivesInfoVO.setUpdateTime(updateTime);
			
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			archivesInfoService.updateWoman(archivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//model.set("msg", "false");
		}
		mav.setViewName("/inspect/premarital_list");
		return mav;
	}
	
	/**
	 * ARCHIVES_INFO 男性修改
	 * 
	 * @param archivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateMan", method = RequestMethod.POST)
	public ModelAndView updateMan(ArchivesInfoVO archivesInfoVO,
									@RequestParam("archivesCode")String archivesCode,
									@RequestParam("manBirthday")String birth) {
		ModelAndView mav = new ModelAndView();
		try {
			
			ArchivesInfoPO archivesInfoPO = new ArchivesInfoPO();
			//archivesInfoPO.setId(archivesId);
			archivesInfoVO.setArchivesCode(archivesCode);
			Date manBirthday = DateUtil.stringToDate(birth,DateStyle.YYYYMMDD);
			//archivesInfoPO.setBirthday(manBirthday);
			archivesInfoVO.setManBirthday(manBirthday);
			Date updateTime = new Date();
			archivesInfoVO.setUpdateTime(updateTime);
			
			BeanUtils.copyProperties(archivesInfoPO, archivesInfoVO);
			archivesInfoService.updateMan(archivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//model.set("msg", "false");
		}
		mav.setViewName("/inspect/premarital_manList");
		return mav;
	}


	/**
	 * ARCHIVES_INFO 删除
	 * 
	 * @param archivesInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delArchivesInfoAction(@RequestParam("archivesInfoIds") String archivesInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			archivesInfoService.deletes(archivesInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 删除女性
	 * @param id
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/delWoman",method=RequestMethod.GET)
	public ModelAndView delWoman(@RequestParam("id")String archivesId){
		
		ModelAndView mv = new ModelAndView();
		
		try {
			//根据档案id获取婚检信息
			//String archivesId = archivesInfoVO.getId();
			PremaritalExaInfoPO premaritalExaInfo = premaritalExaInfoService.findWomanPremaritalByArchivesId(archivesId);
			
			premaritalExaInfo.setEditStatus("2");
			
			Date updateTime = new Date();
			
			premaritalExaInfo.setUpdateTime(updateTime);
			
			premaritalExaInfoService.delWoman(premaritalExaInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("/inspect/premarital_list");
		
		return mv;
	}

	/**
	 * 删除男性
	 * @param id
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/delMan",method=RequestMethod.GET)
	public ModelAndView delMan(@RequestParam("id")String archivesId){
		
		ModelAndView mv = new ModelAndView();
		
		try {
			//根据档案id获取婚检信息
			//String archivesId = archivesInfoVO.getId();
			PremaritalExaInfoPO premaritalExaInfo = premaritalExaInfoService.findPremaritalByArchivesId(archivesId);
			
			premaritalExaInfo.setEditStatus("2");
			
			Date updateTime = new Date();
			
			premaritalExaInfo.setUpdateTime(updateTime);
			
			premaritalExaInfoService.delMan(premaritalExaInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("/inspect/premarital_manList");
		
		return mv;
	}
	
	/**
	 * ARCHIVES_INFO 列表视图
	 * @return
	 * 分娩登记页面
	 * wangbj
	 */
	@RequestMapping(value = "/listArchives", method = RequestMethod.GET)
	public ModelAndView listArchivesInfo(HttpSession session,@RequestParam Map<String, Object> reqs,
																Map<String, Object> cons
																) throws ParseException {
		log.debug("request page: /sysset/archivesInfo/archivesInfo_list");
		ModelAndView modle = new ModelAndView(
				
				
				"prenatal/childbirth_list", reqs);
		//获取档案id
		String id=(String)reqs.get("id");
		//String id="36A36BD7DBDA41338EEC07049F54D935";
		
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		modle.addObject("operator2", operator2);
		
		//查询档案信息
		ArchivesInfoPO find = archivesInfoService.find(id);
		
		//获取档案的出生日期
		Date birthday = find.getBirthday();
		if(birthday !=null){
			String womenbirthday = DateUtil.dateToString(birthday, DateStyle.YYYYMMDD);
			modle.addObject("womenbirthday", womenbirthday);
			int age = DateUtils.getAgeByBirthday(birthday);
			modle.addObject("age", age);
		}
		
		
		//获取档案的男人出生日期
		Date Manbirthday = find.getManBirthday();
		if(Manbirthday !=null){
			String menbirthday = DateUtil.dateToString(Manbirthday, DateStyle.YYYYMMDD);
			modle.addObject("menbirthday", menbirthday);
			
			//得到男人的年龄
			int manAge = DateUtils.getAgeByBirthday(Manbirthday);
			//modle.addObject("operator", operator);
			
			modle.addObject("manAge", manAge);
			
		}
		
		//查询生育档案信息
		BirthArchivesInfoPO birthArchivesByArchivesId2 = birthArchivesInfoService.getBirthArchivesByArchivesId(id);
		//查询末次月经
		Date lastMenses = birthArchivesByArchivesId2.getLastMenses();
		if(lastMenses !=null){
		String lastmenstrual = DateUtil.dateToString(lastMenses, DateStyle.YYYYMMDD);
		modle.addObject("lastmenstrual", lastmenstrual);
		int weekByLastMenses = DateUtils.getWeekByLastMenses(lastMenses);
		//得到孕产期
		Date endOfDate = DateUtils.expectedDate(lastMenses);
		
		
		modle.addObject("weekByLastMenses", weekByLastMenses);
		modle.addObject("endOfDate", endOfDate);
		modle.addObject("weekByLastMenses", weekByLastMenses);
		}
		
		
		//获得生育档案的id
		String birtharchid = birthArchivesByArchivesId2.getId();
		
		
		modle.addObject("birthArchives", birthArchivesByArchivesId2);
		
		//查询个人基本信息 通过生育档案id
		ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birtharchid);
		if(childbirthBasic !=null){
		String id2 = childbirthBasic.getId();
		
		//获得分娩日期
		Date birthDate = childbirthBasic.getBirthDate();
		
		if(birthDate!=null){
			String birthWODate = DateUtil.dateToString(birthDate, DateStyle.YYYYMMDD);
			modle.addObject("birthWODate", birthWODate);
		}
		
		//查询分娩信息 通过基本信息的id
		
		ChildbirthInfoPO childbirth = childbirthInfoService.getChildbirthByBasicId(id2);
		String id3 = childbirth.getId();
		//查询分娩婴儿情况 通过分娩信息的id
		
		List<ChildbirthBabyInfoPO> babyInfo = childbirthBabyInfoService.getBabyInfoByChildbirthId(id3);
		//查看几个婴儿
		int size = babyInfo.size();
		for(int i=0;i<babyInfo.size();i++){
			ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
			modle.addObject("childbirthBabyInfoPO"+i+"", childbirthBabyInfoPO);
		}
		
		
		
		//拆分所打的疫苗
		for(int i=0;i<babyInfo.size();i++){
			ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
			String vaccine = childbirthBabyInfoPO.getVaccine();
			List<String> list= new ArrayList<String>();
			if(vaccine != null ){
			String[] split = vaccine.split(",");
			
				for(int j=0;j<split.length;j++){
					list.add(split[j]);
					
				}
				
				modle.addObject("list"+i+"", list);
			}
		}
		
		//查询分娩转诊信息 通过基本信息的id
		
		ChildbirthReferralInfoPO findBy = childbirthReferralInfoService.findByChildBirthInfoId(id2);
		
		
		if(findBy!=null){
			//获得部门的id
			String departmentId = findBy.getDepartment();
			DepartmentPO departmentById = departmentService.getDepartmentById(departmentId);
			modle.addObject("departmentById", departmentById);
			//获得转诊机构的id
			
			String mechanismId = findBy.getMechanism();
			RolePO roleBy = roleService.getRoleById(mechanismId);
			modle.addObject("roleBy", roleBy);
			modle.addObject("findBy", findBy);
		
		}
		
		
		
		if(findBy==null){
			ChildbirthReferralInfoPO ChildbirthReferral = childbirthReferralInfoService.findByChildBirthId(id2);
			
			modle.addObject("findBy", ChildbirthReferral);
		}
		
		

		//获取历史检查记录的列表用于历史检查记录的回显
		List<HistoryCheckVO> historyChecks = new ArrayList<HistoryCheckVO>();
		//获取第一次产前检查对应的历史检查记录
		HistoryCheckVO firstHistoryCheck = prenatalExaInfoService.getFirstHistoryCheck(birtharchid);
		if(firstHistoryCheck!=null){
			historyChecks.add(firstHistoryCheck);
		}
		//获取第2-N次检查对应的历史检查记录
		List<HistoryCheckVO> secondOrMoreHistoryChecks = prenatalExaInfoService.getSecondOrMoreHistoryChecks(birtharchid);
		if(secondOrMoreHistoryChecks!=null && secondOrMoreHistoryChecks.size()>0){
			historyChecks.addAll(secondOrMoreHistoryChecks);
		}
		modle.addObject("historyChecks", historyChecks);
		
		//获取出院3-7天和产后检查对应的历史检查记录
		List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostpartumHistoryChecks(birtharchid);
		modle.addObject("postpartumHistoryChecks", postpartumHistoryChecks);
		
		
		String hosId=find.getHospitalId();
		//查询部门信息
		DepartmentPO department = departmentService.getDepartmentById(hosId);
		
		//获得科室类别
		List<RolePO> roleList = roleService.getAll();
		modle.addObject("roleList", roleList);
	
		modle.addObject("department", department);
		modle.addObject("historyChecks", historyChecks);
		modle.addObject("find", find);
		modle.addObject("childbirthBasic", childbirthBasic);
		modle.addObject("childbirth", childbirth);
		modle.addObject("babyInfo", babyInfo);
		modle.addObject("size", size);
		}
		return modle;
		
	}
	/*分娩登记修改页面
	 * 传入档案id
	 * wangbj
	 */
	@RequestMapping(value = "/updateNoteView", method = RequestMethod.GET)
	public ModelAndView updateArchivesInfoView(@RequestParam Map<String, Object> reqs,
												@RequestParam("archiveId") String archivesId,
												HttpSession session) {
		
		ModelAndView modle = new ModelAndView("prenatal/childbirth_update", reqs);
		try {
			
			
			//获得档案id(chid)
			String id=archivesId;
			//
			//查询档案信息
			ArchivesInfoPO ArchivesInfoPO = archivesInfoService.find(id);
			
			//查询生育档案信息 通过生育档案id
			BirthArchivesInfoPO birthArchivesByArchivesId2 = birthArchivesInfoService.getBirthArchivesByArchivesId(id);
			//获得检查医生
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
			
			modle.addObject("operator2", operator2);
			modle.addObject("birthArchives", birthArchivesByArchivesId2);
			
			
			/*//查询生育档案 通过档案id
			BirthArchivesInfoPO birthArchivesByArchivesId = birthArchivesInfoService.getBirthArchivesByArchivesId(id);*/
			
			//获得高危标示
			String riskSign = birthArchivesByArchivesId2.getRiskSign();
			
			modle.addObject("riskSign", riskSign);
			
			
			//获得生育档案的id
			String birthArchivesId = birthArchivesByArchivesId2.getId();
			
			//查询个人基本信息 通过生育档案id
			ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
			//查询个人基本信息 通过生育档案id   查询保存状态的
			ChildbirthBasicInfoPO saveChildbirthBasic = childbirthBasicInfoService.SaveChildbirthBasicByBirthArchivesId(birthArchivesId);
			
			
			if(saveChildbirthBasic !=null){
				
				
				
				modle.addObject("operator2", operator2);
				modle.addObject("birthArchives", birthArchivesByArchivesId2);
				
				
				String id2 = saveChildbirthBasic.getId();
				//查询分娩信息 通过基本信息的id
				
				ChildbirthInfoPO childbirth = childbirthInfoService.getChildbirthByBasicId(id2);
				String id3 = childbirth.getId();
				
				//查询所有的分娩医院地点
				
				List<ChildbirthInfoPO> placeList = childbirthInfoService.findAll();
				modle.addObject("placeList", placeList);
				//查询分娩婴儿情况 通过分娩信息的id
				List<ChildbirthBabyInfoPO> babyInfo = childbirthBabyInfoService.getBabyInfoByChildbirthId(id3);
				//查看几个婴儿
				int size = babyInfo.size();
				for(int i=0;i<babyInfo.size();i++){
					ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
					modle.addObject("childbirthBabyInfoPO"+i+"", childbirthBabyInfoPO);
				}
				//拆分所打的疫苗
				for(int i=0;i<babyInfo.size();i++){
					ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
					String vaccine = childbirthBabyInfoPO.getVaccine();
					if(vaccine !=null &&vaccine !=""){
					List<String> list= new ArrayList<String>();
					String[] split = vaccine.split(",");
						for(int j=0;j<split.length;j++){
							list.add(split[j]);
						}
						modle.addObject("list"+i+"", list);
					}
				}
				
				//查询分娩转诊信息 通过基本信息的id
				
				ChildbirthReferralInfoPO findBy = childbirthReferralInfoService.findByChildBirthInfoId(id2);
				if(findBy !=null){
						modle.addObject("findBy", findBy);
						//获得部门的id
						String departmentId = findBy.getDepartment();
						DepartmentPO departmentById = departmentService.getDepartmentById(departmentId);
						//获得转诊机构的id
						String mechanismId = findBy.getMechanism();
						RolePO roleBy = roleService.getRoleById(mechanismId);
						modle.addObject("roleBy", roleBy);
						modle.addObject("department", departmentById);
						List<DepartmentPO> list = departmentService.getAllDepartment();
						modle.addObject("departlist", list);
					
					
						
				}	
					
				if(findBy==null){
					ChildbirthReferralInfoPO findByChildBirth = childbirthReferralInfoService.findByChildBirthId(id2);
					modle.addObject("findBy", findByChildBirth);
					String department = operator2.getDepartment();
					List<DepartmentPO> hospitals = departmentService.getAllDepartment();
					modle.addObject("departlist", hospitals);
					
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
				modle.addObject("historyChecks", historyChecks);
				
				//获取出院3-7天和产后检查对应的历史检查记录
				List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostpartumHistoryChecks(birthArchivesId);
				modle.addObject("postpartumHistoryChecks", postpartumHistoryChecks);
				
				
				//获得科室类别
				List<RolePO> roleList = roleService.getAll();
				modle.addObject("roleList", roleList);
				//得到女人的末次月经
				Date lastmen = birthArchivesByArchivesId2.getLastMenses();
				Date birthday = ArchivesInfoPO.getBirthday();
				Date manBirthday = ArchivesInfoPO.getManBirthday();
				
				if(lastmen !=null){
				int weekByLastMenses = DateUtils.getWeekByLastMenses(lastmen);
				//得到孕产期
				Date endOfDate = DateUtils.expectedDate(lastmen);
				
				
				modle.addObject("weekByLastMenses", weekByLastMenses);
				modle.addObject("endOfDate", endOfDate);
				modle.addObject("weekByLastMenses", weekByLastMenses);
				}
				
				if(birthday !=null){
					int age = DateUtils.getAgeByBirthday(birthday);
					modle.addObject("age", age);
				}
				if(manBirthday !=null){
				
				//得到男人的年龄
				int manAge = DateUtils.getAgeByBirthday(manBirthday);
				modle.addObject("manAge", manAge);
				}
				
				
				
				modle.addObject("historyChecks", historyChecks);
				modle.addObject("ArchivesInfoPO", ArchivesInfoPO);
				modle.addObject("childbirthBasic", saveChildbirthBasic);
				modle.addObject("childbirth", childbirth);
				modle.addObject("babyInfo", babyInfo);
				
				modle.addObject("size", size);
				
				
				
				
				return modle;
				
				
			}
			
			String id2 = childbirthBasic.getId();
			//查询分娩信息 通过基本信息的id
			
			ChildbirthInfoPO childbirth = childbirthInfoService.getChildbirthByBasicId(id2);
			String id3 = childbirth.getId();
			
			//查询所有的分娩医院地点
			
			List<ChildbirthInfoPO> placeList = childbirthInfoService.findAll();
			modle.addObject("placeList", placeList);
			
			//查询分娩婴儿情况 通过分娩信息的id
			
			List<ChildbirthBabyInfoPO> babyInfo = childbirthBabyInfoService.getBabyInfoByChildbirthId(id3);
			//查看几个婴儿
			int size = babyInfo.size();
			for(int i=0;i<babyInfo.size();i++){
				ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
				modle.addObject("childbirthBabyInfoPO"+i+"", childbirthBabyInfoPO);
			}
			
			
			
			//拆分所打的疫苗
			for(int i=0;i<babyInfo.size();i++){
				ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
				String vaccine = childbirthBabyInfoPO.getVaccine();
				if(vaccine !=null &&vaccine !=""){
				List<String> list= new ArrayList<String>();
				String[] split = vaccine.split(",");
					for(int j=0;j<split.length;j++){
					
						
						list.add(split[j]);
						
					}
					modle.addObject("list"+i+"", list);
				}
			}
			
			//查询分娩转诊信息 通过基本信息的id
			
			ChildbirthReferralInfoPO findBy = childbirthReferralInfoService.findByChildBirthInfoId(id2);
			if(findBy !=null){
				
					//获得部门的id
					String departmentId = findBy.getDepartment();
					DepartmentPO departmentById = departmentService.getDepartmentById(departmentId);
					modle.addObject("departmentById", departmentById);
					//获得转诊机构的id
					
					String mechanismId = findBy.getMechanism();
					RolePO roleBy = roleService.getRoleById(mechanismId);
					modle.addObject("roleBy", roleBy);
					modle.addObject("department", departmentById);
					List<DepartmentPO> hospitals = departmentService.getAllDepartment();
					modle.addObject("departlist", hospitals);
			
				
			}
			
			if(findBy==null){
				
				
				ChildbirthReferralInfoPO findByChildBirth = childbirthReferralInfoService.findByChildBirthId(id2);
				modle.addObject("findBy", findByChildBirth);
				
				//从session中获取当前医院的名称，根据部门名称确定部门等级（0是县医院，1乡医院，2是村医院），然后查询上级部门的医院显示在下拉列表中
				String department = operator2.getDepartment();
				List<DepartmentPO> hospitals = departmentService.getAllDepartment();
				modle.addObject("departlist", hospitals);
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
			modle.addObject("historyChecks", historyChecks);
			
			//获取出院3-7天和产后检查对应的历史检查记录
			List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostpartumHistoryChecks(birthArchivesId);
			modle.addObject("postpartumHistoryChecks", postpartumHistoryChecks);
			
			//获得科室类别
			List<RolePO> roleList = roleService.getAll();
			modle.addObject("roleList", roleList);
			//得到女人的末次月经
			Date lastmen = birthArchivesByArchivesId2.getLastMenses();
			Date birthday = ArchivesInfoPO.getBirthday();
			Date manBirthday = ArchivesInfoPO.getManBirthday();
			
			if(lastmen !=null){
			int weekByLastMenses = DateUtils.getWeekByLastMenses(lastmen);
			//得到孕产期
			Date endOfDate = DateUtils.expectedDate(lastmen);
			
			
			modle.addObject("weekByLastMenses", weekByLastMenses);
			modle.addObject("endOfDate", endOfDate);
			modle.addObject("weekByLastMenses", weekByLastMenses);
			}
			
			if(birthday !=null){
				int age = DateUtils.getAgeByBirthday(birthday);
				modle.addObject("age", age);
			}
			if(manBirthday !=null){
			
			//得到男人的年龄
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			modle.addObject("manAge", manAge);
			}
			
			
			
			modle.addObject("historyChecks", historyChecks);
			modle.addObject("ArchivesInfoPO", ArchivesInfoPO);
			modle.addObject("childbirthBasic", childbirthBasic);
			modle.addObject("childbirth", childbirth);
			modle.addObject("babyInfo", babyInfo);
			modle.addObject("findBy", findBy);
			modle.addObject("size", size);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return modle;
	}
	
	/**
	 * 分娩登记 修改
	 * @param id
	 * @param session
	 * @return
	 * @author wangbj
	 */
	
	@RequestMapping(value = "/updateBirth", method = RequestMethod.POST)
	public ModelAndView updateArchivesInfo(@RequestParam Map<String, Object> reqs,
											ArchivesInfoVO archivesInfoVO,
											ChildbirthBasicInfoVO childbirthBasicInfoVO,
											ChildbirthInfoVO childbirthInfoVO,
											ChildbirthBabyInfoVO childbirthBabyInfoVO,
											ChildbirthReferralInfoVO childbirthReferralInfoVO,
											HttpSession session) {
		
		ModelAndView model = new ModelAndView("prenatal/prenatal_list");
		try {
			//获取编辑状态 为 (保存，完成)
			String editStatus =(String) reqs.get("editStatus");
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			String adminId = prenatalExaInfoService.getAdminId();
			String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
			model.addObject("adminId", adminId);
			model.addObject("doctorAdminId", doctorAdminId);
			model.addObject("doctorId", operator.getId());
			model.addObject("depId", operator.getDepId());
			String operatorId = operator.getId();
			//String editStatus =(String) reqs.get("editStatus");
			
			//点击保存
			if(editStatus.equals("0")){
				//获得档案id(chid)
				String chid=(String)reqs.get("acrid");
				
				
				
				//查询生育档案 通过档案id
				BirthArchivesInfoPO birthArchivesByArchivesId = birthArchivesInfoService.getBirthArchivesByArchivesId(chid);
				
				//获得生育档案的id
				String birthArchivesId = birthArchivesByArchivesId.getId();
				
				
				
				//查询高危信息
				
				String highRiskId =(String) reqs.get("highRiskId");
				if(highRiskId !=null && highRiskId !=""){
				
				HighRiskInfoPO highRiskInfoPO = highRiskInfoService.find(highRiskId);
				
				PrenatalExaInfoPO prenatalExa = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchivesId);
				
				String prenatalExaid = prenatalExa.getId();
				
				highRiskInfoPO.setExaminationId(prenatalExaid);
				
				highRiskInfoService.update(highRiskInfoPO);

				}
				
				
				
				//查询个人基本信息通过生育档案id(完成状态的)
				ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId); 
				if(childbirthBasic==null){
					//查询个人基本信息通过生育档案id(保存状态的)
					ChildbirthBasicInfoPO saveChildbirthBasic = childbirthBasicInfoService.SaveChildbirthBasicByBirthArchivesId(birthArchivesId);
					if(saveChildbirthBasic==null){
						String Basicid = IdUtil.uuid();
						childbirthBasicInfoVO.setId(Basicid);
						childbirthBasicInfoVO.setBirthArchivesId(birthArchivesId);
						ChildbirthBasicInfoPO childbirthBasicInfoPO= new ChildbirthBasicInfoPO();
						BeanUtils.copyProperties(childbirthBasicInfoPO, childbirthBasicInfoVO);
						childbirthBasicInfoService.create(childbirthBasicInfoPO);
						
					}
					
					//获取基本信息的id
					String id2 = saveChildbirthBasic.getId();
					
			
					String birthDate =(String) reqs.get("birthDate");
					String leaveDate =(String) reqs.get("leaveDate");
					String BasicCreateTime =(String) reqs.get("BasicCreateTime");
					SimpleDateFormat formate= new SimpleDateFormat("yyyyMMdd");
					
					if(BasicCreateTime !=null){
						Date createTime = formate.parse(BasicCreateTime);
						childbirthBasicInfoVO.setCreatTime(createTime);
						childbirthBasicInfoVO.setUpdateTime(new Date());
						childbirthBasicInfoVO.setNormalSign("0");
					}
					if(BasicCreateTime==null||BasicCreateTime==""){
						childbirthBasicInfoVO.setCreatTime(new Date());
						childbirthBasicInfoVO.setUpdateTime(new Date());
						childbirthBasicInfoVO.setNormalSign("1");
					}
					
					
					Date date = formate.parse(birthDate);
					Date leave = formate.parse(leaveDate);
					childbirthBasicInfoVO.setId(id2);
					childbirthBasicInfoVO.setBirthDate(date);
					childbirthBasicInfoVO.setLeaveDate(leave);
					childbirthBasicInfoVO.setEditStatus("0");
					childbirthBasicInfoVO.setBirthArchivesId(birthArchivesId);
					childbirthBasicInfoVO.setUpdateTime(new Date());
					BeanUtils.copyProperties(saveChildbirthBasic, childbirthBasicInfoVO);
					childbirthBasicInfoService.update(saveChildbirthBasic);
					
					
					//查询分娩信息通过基本信息的id
					ChildbirthInfoPO childbirthByBasicId = childbirthInfoService.getChildbirthByBasicId(id2);
					if(childbirthByBasicId==null){
						String Childbirthid = IdUtil.uuid();
						childbirthInfoVO.setId(Childbirthid);
						childbirthInfoVO.setBasicId(id2);
						ChildbirthInfoPO childbirthInfoPO = new ChildbirthInfoPO();
						BeanUtils.copyProperties(childbirthInfoPO, childbirthInfoVO);
						childbirthInfoService.create(childbirthInfoPO);
						
					}
					//获得分娩信息的id
					String childbirthid = childbirthByBasicId.getId();
					childbirthInfoVO.setId(childbirthid);
					childbirthInfoVO.setBasicId(id2);
					//获得分娩地点
					String childbirthPlace = childbirthInfoVO.getChildbirthPlace();
					String[] split = childbirthPlace.split(",");
					childbirthInfoVO.setChildbirthPlace(split[0]);
					
					BeanUtils.copyProperties(childbirthByBasicId, childbirthInfoVO);
					childbirthInfoService.update(childbirthByBasicId);
					
					
					//获取转诊信息通过分娩信息的id
					ChildbirthReferralInfoPO ChildbirthReferral = childbirthReferralInfoService.findByChildBirthInfoId(id2); 
					
					//获取转诊信息的id
						if(ChildbirthReferral !=null){
						String ReferralId = ChildbirthReferral.getId();
						
						
						String referral = childbirthReferralInfoVO.getReferral();
						//当转诊标识为1，确认转诊时
						if(referral.equals("1")){
							String idde =(String) reqs.get("department");
							String mechanism =(String) reqs.get("mechanism");
							
							//将转诊标识设置为分娩转诊
							birthArchivesByArchivesId.setReferralSign("2");
							
							birthArchivesByArchivesId.setInHospitalId(idde);
							birthArchivesByArchivesId.setDeltetSign("1");
							birthArchivesByArchivesId.setPregnantState("0");
							birthArchivesByArchivesId.setUpdateTime(new Date());
							birthArchivesInfoService.update(birthArchivesByArchivesId);
							childbirthReferralInfoVO.setId(ReferralId);
							childbirthReferralInfoVO.setBasicId(id2);
							
						BeanUtils.copyProperties(ChildbirthReferral, childbirthReferralInfoVO);
						childbirthReferralInfoService.update(ChildbirthReferral);
						}
					
					//当没有转诊时
							if(referral.equals("0")){
								
								BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
								birthArchivesInfoPO.setReferralSign("0");
								birthArchivesInfoPO.setDeltetSign("1");
								birthArchivesInfoPO.setPregnantState("0");
								birthArchivesInfoService.update(birthArchivesInfoPO);
								
							}
					}
						if(ChildbirthReferral ==null){
							String ReferralId = IdUtil.uuid();
							
							String referral = childbirthReferralInfoVO.getReferral();
							//当转诊标识为1，确认转诊时
							if(referral.equals("1")){
								String idde =(String) reqs.get("department");
								String mechanism =(String) reqs.get("mechanism");
								
								//将转诊标识设置为分娩转诊
								birthArchivesByArchivesId.setReferralSign("2");
								birthArchivesByArchivesId.setPredictDate(new Date());
								birthArchivesByArchivesId.setInHospitalId(idde);
								birthArchivesByArchivesId.setDeltetSign("1");
								
								birthArchivesByArchivesId.setPregnantState("0");
								
								
								birthArchivesInfoService.update(birthArchivesByArchivesId);
							ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
							childbirthReferralInfoVO.setId(ReferralId);
							childbirthReferralInfoVO.setBasicId(id2);
							BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
							childbirthReferralInfoService.create(childbirthReferralInfoPO);
							}
						
						//当没有转诊时
								if(referral.equals("0")){
									
									BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
									birthArchivesInfoPO.setReferralSign("0");
									birthArchivesByArchivesId.setDeltetSign("1");
									
									birthArchivesByArchivesId.setPregnantState("0");
									
									
									birthArchivesInfoService.update(birthArchivesByArchivesId);
									
									
								}
						}
					//获取分娩婴儿信息 通过分娩信息id
					List<ChildbirthBabyInfoPO> babyInfo= childbirthBabyInfoService.getBabyInfoByChildbirthId(childbirthid);
					if(babyInfo.size() !=0){
						
						String acrid0 =(String) reqs.get("acrid0");
						String acrid1 =(String) reqs.get("acrid1");
						String acrid2 =(String) reqs.get("acrid2");
						String acrid3 =(String) reqs.get("acrid3");
						String acrid4 =(String) reqs.get("acrid4");
						String acrid5 =(String) reqs.get("acrid5");
						String acrid6 =(String) reqs.get("acrid6");
						
						
						//获得婴儿的名字
						String babyName0 =(String) reqs.get("babyName");
						String babyName1 =(String) reqs.get("babyName1");
						String babyName2 =(String) reqs.get("babyName2");
						String babyName3 =(String) reqs.get("babyName3");
						String babyName4 =(String) reqs.get("babyName4");
						String babyName5 =(String) reqs.get("babyName5");
						String babyName6 =(String) reqs.get("babyName6");
						
						for(int i=0;i<babyInfo.size();i++){
							ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);

							//获得婴儿的id
							String childbirthBabyId= childbirthBabyInfoPO.getId();
							
							
							
								if(childbirthBabyId.equals(acrid0)){
								
								
								//修改第一个婴儿信息
								String deliveryType0 =(String) reqs.get("deliveryType");
								
								if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
								
									childbirthBabyInfoVO.setId(childbirthBabyInfoPO.getId());
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
								
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
								
							
							
							
							if(childbirthBabyId.equals(acrid1)){
								
								
								//修改第一个婴儿信息
								String deliveryType1 =(String) reqs.get("deliveryType1");
								
								if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition =(String) reqs.get("fetusPosition1");
								String deliveryHour =(String) reqs.get("deliveryHour1");
								String deliveryMinute =(String) reqs.get("deliveryMinute1");
								String inducelabour =(String) reqs.get("inducelabour1");
								String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
								String babySex =(String) reqs.get("babySex1");
								String health =(String) reqs.get("health1");
								String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
								String abnormalPosition =(String) reqs.get("abnormalPosition1");
								String abnormalName =(String) reqs.get("abnormalName1");
								String oneMinScore =(String) reqs.get("oneMinScore1");
								String fiveMinScore =(String) reqs.get("fiveMinScore1");
								String bornWeight =(String) reqs.get("bornWeight1");
								String vaccine =(String) reqs.get("babyVaccine1");
								String fetusDie =(String) reqs.get("fetusDie1");
								String midwife =(String) reqs.get("midwife1");
								
								childbirthBabyInfoVO.setFetusPosition(fetusPosition);
								childbirthBabyInfoVO.setBabyName(babyName1);
								childbirthBabyInfoVO.setAbnormalName(abnormalName);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
								childbirthBabyInfoVO.setBabySex(babySex);
								childbirthBabyInfoVO.setBodyLenght(bornWeight);
								childbirthBabyInfoVO.setBornWeight(bornWeight);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
								childbirthBabyInfoVO.setDeliveryType(deliveryType1);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
								childbirthBabyInfoVO.setFetusDie(fetusDie);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
								childbirthBabyInfoVO.setHealth(health);
								childbirthBabyInfoVO.setId(acrid1);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour);
								childbirthBabyInfoVO.setMidwife(midwife);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore);
								childbirthBabyInfoVO.setVaccine(vaccine);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
							
							if(childbirthBabyId.equals(acrid2)){
								
								
								//修改第二个婴儿信息
								String deliveryType2 =(String) reqs.get("deliveryType2");
								
								if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition2 =(String) reqs.get("fetusPosition2");
								String deliveryHour2 =(String) reqs.get("deliveryHour2");
								String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
								String inducelabour2 =(String) reqs.get("inducelabour2");
								String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
								String babySex2 =(String) reqs.get("babySex2");
								String health2 =(String) reqs.get("health2");
								String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
								String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
								String abnormalName2 =(String) reqs.get("abnormalName2");
								String oneMinScore2 =(String) reqs.get("oneMinScore2");
								String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
								String bornWeight2 =(String) reqs.get("bornWeight2");
								String vaccine2 =(String) reqs.get("babyVaccine2");
								String fetusDie2 =(String) reqs.get("fetusDie2");
								String midwife2 =(String) reqs.get("midwife2");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
								childbirthBabyInfoVO.setBabyName(babyName2);
								childbirthBabyInfoVO.setAbnormalName(abnormalName2);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
								childbirthBabyInfoVO.setBabySex(babySex2);
								childbirthBabyInfoVO.setBodyLenght(bornWeight2);
								childbirthBabyInfoVO.setBornWeight(bornWeight2);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
								childbirthBabyInfoVO.setDeliveryType(deliveryType2);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
								childbirthBabyInfoVO.setFetusDie(fetusDie2);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
								childbirthBabyInfoVO.setHealth(health2);
								childbirthBabyInfoVO.setId(acrid2);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour2);
								childbirthBabyInfoVO.setMidwife(midwife2);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
								childbirthBabyInfoVO.setVaccine(vaccine2);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
							
						
								if(childbirthBabyId.equals(acrid3)){
								
								
								//修改第三个婴儿信息
								String deliveryType3 =(String) reqs.get("deliveryType3");
								
								if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition3 =(String) reqs.get("fetusPosition3");
								String deliveryHour3 =(String) reqs.get("deliveryHour3");
								String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
								String inducelabour3 =(String) reqs.get("inducelabour3");
								String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
								String babySex3 =(String) reqs.get("babySex3");
								String health3 =(String) reqs.get("health3");
								String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
								String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
								String abnormalName3 =(String) reqs.get("abnormalName3");
								String oneMinScore3 =(String) reqs.get("oneMinScore3");
								String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
								String bornWeight3 =(String) reqs.get("bornWeight3");
								String vaccine3 =(String) reqs.get("babyVaccine3");
								String fetusDie3 =(String) reqs.get("fetusDie3");
								String midwife3 =(String) reqs.get("midwife3");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
								childbirthBabyInfoVO.setBabyName(babyName3);
								childbirthBabyInfoVO.setAbnormalName(abnormalName3);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
								childbirthBabyInfoVO.setBabySex(babySex3);
								childbirthBabyInfoVO.setBodyLenght(bornWeight3);
								childbirthBabyInfoVO.setBornWeight(bornWeight3);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
								childbirthBabyInfoVO.setDeliveryType(deliveryType3);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
								childbirthBabyInfoVO.setFetusDie(fetusDie3);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
								childbirthBabyInfoVO.setHealth(health3);
								childbirthBabyInfoVO.setId(acrid3);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour3);
								childbirthBabyInfoVO.setMidwife(midwife3);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
								childbirthBabyInfoVO.setVaccine(vaccine3);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
								
								if(childbirthBabyId.equals(acrid4)){
									
									
									//修改第四个婴儿信息
									String deliveryType4 =(String) reqs.get("deliveryType4");
									
									if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
									
									String id3 = childbirthBabyInfoPO.getId();
									String fetusPosition4 =(String) reqs.get("fetusPosition4");
									String deliveryHour4 =(String) reqs.get("deliveryHour4");
									String inducelabour4 =(String) reqs.get("inducelabour4");
									String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
									String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
									String babySex4 =(String) reqs.get("babySex4");
									String health4 =(String) reqs.get("health4");
									String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
									String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
									String abnormalName4 =(String) reqs.get("abnormalName4");
									String oneMinScore4 =(String) reqs.get("oneMinScore4");
									String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
									String bornWeight4 =(String) reqs.get("bornWeight4");
									String vaccine4 =(String) reqs.get("babyVaccine4");
									String fetusDie4 =(String) reqs.get("fetusDie4");
									String midwife4 =(String) reqs.get("midwife4");
							
									childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
									childbirthBabyInfoVO.setBabyName(babyName4);
									childbirthBabyInfoVO.setAbnormalName(abnormalName4);
									childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
									childbirthBabyInfoVO.setBabySex(babySex4);
									childbirthBabyInfoVO.setBodyLenght(bornWeight4);
									childbirthBabyInfoVO.setBornWeight(bornWeight4);
									childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
									childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
									childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
									childbirthBabyInfoVO.setDeliveryType(deliveryType4);
									childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
									childbirthBabyInfoVO.setFetusDie(fetusDie4);
									childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
									childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
									childbirthBabyInfoVO.setHealth(health4);
									childbirthBabyInfoVO.setId(acrid4);
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
									childbirthBabyInfoVO.setInducelabour(inducelabour4);
									childbirthBabyInfoVO.setMidwife(midwife4);
									childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
									childbirthBabyInfoVO.setVaccine(vaccine4);
									BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
									childbirthBabyInfoService.update(childbirthBabyInfoPO);
									}
								}
								
									if(childbirthBabyId.equals(acrid5)){
									
									
									//修改第五个婴儿信息
									String deliveryType5 =(String) reqs.get("deliveryType5");
									
									if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
									
									String id3 = childbirthBabyInfoPO.getId();
									String fetusPosition5 =(String) reqs.get("fetusPosition5");
									String deliveryHour5 =(String) reqs.get("deliveryHour5");
									String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
									String inducelabour5 =(String) reqs.get("inducelabour5");
									String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
									String babySex5 =(String) reqs.get("babySex5");
									String health5 =(String) reqs.get("health5");
									String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
									String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
									String abnormalName5 =(String) reqs.get("abnormalName5");
									String oneMinScore5 =(String) reqs.get("oneMinScore5");
									String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
									String bornWeight5 =(String) reqs.get("bornWeight5");
									String vaccine5 =(String) reqs.get("babyVaccine5");
									String fetusDie5 =(String) reqs.get("fetusDie5");
									String midwife5 =(String) reqs.get("midwife5");
							
									childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
									childbirthBabyInfoVO.setBabyName(babyName5);
									childbirthBabyInfoVO.setAbnormalName(abnormalName5);
									childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
									childbirthBabyInfoVO.setBabySex(babySex5);
									childbirthBabyInfoVO.setBodyLenght(bornWeight5);
									childbirthBabyInfoVO.setBornWeight(bornWeight5);
									childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
									childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
									childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
									childbirthBabyInfoVO.setDeliveryType(deliveryType5);
									childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
									childbirthBabyInfoVO.setFetusDie(fetusDie5);
									childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
									childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
									childbirthBabyInfoVO.setHealth(health5);
									childbirthBabyInfoVO.setId(acrid5);
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
									childbirthBabyInfoVO.setInducelabour(inducelabour5);
									childbirthBabyInfoVO.setMidwife(midwife5);
									childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
									childbirthBabyInfoVO.setVaccine(vaccine5);
									BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
									childbirthBabyInfoService.update(childbirthBabyInfoPO);
									}
								}
									
									
									
									
									
									if(childbirthBabyId.equals(acrid6)){
										
										
										//修改第五个婴儿信息
										String deliveryType6 =(String) reqs.get("deliveryType6");
										
										if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
										
										String id3 = childbirthBabyInfoPO.getId();
										String fetusPosition6 =(String) reqs.get("fetusPosition6");
										String deliveryHour6 =(String) reqs.get("deliveryHour6");
										String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
										String inducelabour6 =(String) reqs.get("inducelabour6");
										String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
										String babySex6 =(String) reqs.get("babySex6");
										String health6 =(String) reqs.get("health6");
										String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
										String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
										String abnormalName6 =(String) reqs.get("abnormalName6");
										String oneMinScore6 =(String) reqs.get("oneMinScore6");
										String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
										String bornWeight6=(String) reqs.get("bornWeight6");
										String vaccine6 =(String) reqs.get("babyVaccine6");
										String fetusDie6 =(String) reqs.get("fetusDie6");
										String midwife6 =(String) reqs.get("midwife6");
								
										childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
										childbirthBabyInfoVO.setBabyName(babyName6);
										childbirthBabyInfoVO.setAbnormalName(abnormalName6);
										childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
										childbirthBabyInfoVO.setBabySex(babySex6);
										childbirthBabyInfoVO.setBodyLenght(bornWeight6);
										childbirthBabyInfoVO.setBornWeight(bornWeight6);
										childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
										childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
										childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
										childbirthBabyInfoVO.setDeliveryType(deliveryType6);
										childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
										childbirthBabyInfoVO.setFetusDie(fetusDie6);
										childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
										childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
										childbirthBabyInfoVO.setHealth(health6);
										childbirthBabyInfoVO.setId(acrid6);
										childbirthBabyInfoVO.setChildbirthId(childbirthid);
										childbirthBabyInfoVO.setInducelabour(inducelabour6);
										childbirthBabyInfoVO.setMidwife(midwife6);
										childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
										childbirthBabyInfoVO.setVaccine(vaccine6);
										BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
										childbirthBabyInfoService.update(childbirthBabyInfoPO);
										}
									}
									
											
								}
						
						ChildbirthBabyInfoPO childbirthBaby=new ChildbirthBabyInfoPO();
						if(acrid0==null||acrid0==""){
							//修改第一个婴儿信息
							String deliveryType0 =(String) reqs.get("deliveryType");
							if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
							String id=IdUtil.uuid();
							childbirthBabyInfoVO.setId(id);	
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid1==null ||acrid1==""){
							//修改第一个婴儿信息
							String deliveryType1 =(String) reqs.get("deliveryType1");
							
							if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition =(String) reqs.get("fetusPosition1");
							String deliveryHour =(String) reqs.get("deliveryHour1");
							String deliveryMinute =(String) reqs.get("deliveryMinute1");
							String inducelabour =(String) reqs.get("inducelabour1");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
							String babySex =(String) reqs.get("babySex1");
							String health =(String) reqs.get("health1");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
							String abnormalPosition =(String) reqs.get("abnormalPosition1");
							String abnormalName =(String) reqs.get("abnormalName1");
							String oneMinScore =(String) reqs.get("oneMinScore1");
							String fiveMinScore =(String) reqs.get("fiveMinScore1");
							String bornWeight =(String) reqs.get("bornWeight1");
							String vaccine =(String) reqs.get("babyVaccine1");
							String fetusDie =(String) reqs.get("fetusDie1");
							String midwife =(String) reqs.get("midwife1");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName1);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType1);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid2==null||acrid2==""){
							//修改第二个婴儿信息
							String deliveryType2 =(String) reqs.get("deliveryType2");
							
							if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition2 =(String) reqs.get("fetusPosition2");
							String deliveryHour2 =(String) reqs.get("deliveryHour2");
							String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
							String inducelabour2 =(String) reqs.get("inducelabour2");
							String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
							String babySex2 =(String) reqs.get("babySex2");
							String health2 =(String) reqs.get("health2");
							String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
							String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
							String abnormalName2 =(String) reqs.get("abnormalName2");
							String oneMinScore2 =(String) reqs.get("oneMinScore2");
							String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
							String bornWeight2 =(String) reqs.get("bornWeight2");
							String vaccine2 =(String) reqs.get("babyVaccine2");
							String fetusDie2 =(String) reqs.get("fetusDie2");
							String midwife2 =(String) reqs.get("midwife2");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setBabyName(babyName2);
							childbirthBabyInfoVO.setAbnormalName(abnormalName2);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
							childbirthBabyInfoVO.setBabySex(babySex2);
							childbirthBabyInfoVO.setBodyLenght(bornWeight2);
							childbirthBabyInfoVO.setBornWeight(bornWeight2);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
							childbirthBabyInfoVO.setDeliveryType(deliveryType2);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
							childbirthBabyInfoVO.setFetusDie(fetusDie2);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
							childbirthBabyInfoVO.setHealth(health2);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour2);
							childbirthBabyInfoVO.setMidwife(midwife2);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
							childbirthBabyInfoVO.setVaccine(vaccine2);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						
						if(acrid3==null||acrid3==""){
							//修改第三个婴儿信息
							String deliveryType3 =(String) reqs.get("deliveryType3");
							
							if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition3 =(String) reqs.get("fetusPosition3");
							String deliveryHour3 =(String) reqs.get("deliveryHour3");
							String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
							String inducelabour3 =(String) reqs.get("inducelabour3");
							String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
							String babySex3 =(String) reqs.get("babySex3");
							String health3 =(String) reqs.get("health3");
							String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
							String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
							String abnormalName3 =(String) reqs.get("abnormalName3");
							String oneMinScore3 =(String) reqs.get("oneMinScore3");
							String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
							String bornWeight3 =(String) reqs.get("bornWeight3");
							String vaccine3 =(String) reqs.get("babyVaccine3");
							String fetusDie3 =(String) reqs.get("fetusDie3");
							String midwife3 =(String) reqs.get("midwife3");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setBabyName(babyName3);
							childbirthBabyInfoVO.setAbnormalName(abnormalName3);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
							childbirthBabyInfoVO.setBabySex(babySex3);
							childbirthBabyInfoVO.setBodyLenght(bornWeight3);
							childbirthBabyInfoVO.setBornWeight(bornWeight3);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
							childbirthBabyInfoVO.setDeliveryType(deliveryType3);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
							childbirthBabyInfoVO.setFetusDie(fetusDie3);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
							childbirthBabyInfoVO.setHealth(health3);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour3);
							childbirthBabyInfoVO.setMidwife(midwife3);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
							childbirthBabyInfoVO.setVaccine(vaccine3);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							
							}
						}
						if(acrid4==null||acrid4==""){
							//修改第四个婴儿信息
							String deliveryType4 =(String) reqs.get("deliveryType4");
							
							if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition4 =(String) reqs.get("fetusPosition4");
							String deliveryHour4 =(String) reqs.get("deliveryHour4");
							String inducelabour4 =(String) reqs.get("inducelabour4");
							String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
							String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
							String babySex4 =(String) reqs.get("babySex4");
							String health4 =(String) reqs.get("health4");
							String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
							String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
							String abnormalName4 =(String) reqs.get("abnormalName4");
							String oneMinScore4 =(String) reqs.get("oneMinScore4");
							String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
							String bornWeight4 =(String) reqs.get("bornWeight4");
							String vaccine4 =(String) reqs.get("babyVaccine4");
							String fetusDie4 =(String) reqs.get("fetusDie4");
							String midwife4 =(String) reqs.get("midwife4");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setBabyName(babyName4);
							childbirthBabyInfoVO.setAbnormalName(abnormalName4);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
							childbirthBabyInfoVO.setBabySex(babySex4);
							childbirthBabyInfoVO.setBodyLenght(bornWeight4);
							childbirthBabyInfoVO.setBornWeight(bornWeight4);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
							childbirthBabyInfoVO.setDeliveryType(deliveryType4);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
							childbirthBabyInfoVO.setFetusDie(fetusDie4);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
							childbirthBabyInfoVO.setHealth(health4);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour4);
							childbirthBabyInfoVO.setMidwife(midwife4);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
							childbirthBabyInfoVO.setVaccine(vaccine4);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid5==null||acrid5==""){
							//修改第五个婴儿信息
							String deliveryType5 =(String) reqs.get("deliveryType5");
							
							if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition5 =(String) reqs.get("fetusPosition5");
							String deliveryHour5 =(String) reqs.get("deliveryHour5");
							String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
							String inducelabour5 =(String) reqs.get("inducelabour5");
							String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
							String babySex5 =(String) reqs.get("babySex5");
							String health5 =(String) reqs.get("health5");
							String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
							String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
							String abnormalName5 =(String) reqs.get("abnormalName5");
							String oneMinScore5 =(String) reqs.get("oneMinScore5");
							String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
							String bornWeight5 =(String) reqs.get("bornWeight5");
							String vaccine5 =(String) reqs.get("babyVaccine5");
							String fetusDie5 =(String) reqs.get("fetusDie5");
							String midwife5 =(String) reqs.get("midwife5");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setBabyName(babyName5);
							childbirthBabyInfoVO.setAbnormalName(abnormalName5);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
							childbirthBabyInfoVO.setBabySex(babySex5);
							childbirthBabyInfoVO.setBodyLenght(bornWeight5);
							childbirthBabyInfoVO.setBornWeight(bornWeight5);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
							childbirthBabyInfoVO.setDeliveryType(deliveryType5);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
							childbirthBabyInfoVO.setFetusDie(fetusDie5);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
							childbirthBabyInfoVO.setHealth(health5);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour5);
							childbirthBabyInfoVO.setMidwife(midwife5);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
							childbirthBabyInfoVO.setVaccine(vaccine5);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid6==null||acrid6==""){
							//修改第五个婴儿信息
							String deliveryType6 =(String) reqs.get("deliveryType6");
							
							if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition6 =(String) reqs.get("fetusPosition6");
							String deliveryHour6 =(String) reqs.get("deliveryHour6");
							String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
							String inducelabour6 =(String) reqs.get("inducelabour6");
							String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
							String babySex6 =(String) reqs.get("babySex6");
							String health6 =(String) reqs.get("health6");
							String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
							String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
							String abnormalName6 =(String) reqs.get("abnormalName6");
							String oneMinScore6 =(String) reqs.get("oneMinScore6");
							String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
							String bornWeight6=(String) reqs.get("bornWeight6");
							String vaccine6 =(String) reqs.get("babyVaccine6");
							String fetusDie6 =(String) reqs.get("fetusDie6");
							String midwife6 =(String) reqs.get("midwife6");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setBabyName(babyName6);
							childbirthBabyInfoVO.setAbnormalName(abnormalName6);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
							childbirthBabyInfoVO.setBabySex(babySex6);
							childbirthBabyInfoVO.setBodyLenght(bornWeight6);
							childbirthBabyInfoVO.setBornWeight(bornWeight6);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
							childbirthBabyInfoVO.setDeliveryType(deliveryType6);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
							childbirthBabyInfoVO.setFetusDie(fetusDie6);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
							childbirthBabyInfoVO.setHealth(health6);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour6);
							childbirthBabyInfoVO.setMidwife(midwife6);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
							childbirthBabyInfoVO.setVaccine(vaccine6);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
					}
					
					if(babyInfo.size() ==0){
						String acrid0 =(String) reqs.get("acrid0");
						String acrid1 =(String) reqs.get("acrid1");
						String acrid2 =(String) reqs.get("acrid2");
						String acrid3 =(String) reqs.get("acrid3");
						String acrid4 =(String) reqs.get("acrid4");
						String acrid5 =(String) reqs.get("acrid5");
						String acrid6 =(String) reqs.get("acrid6");
						
						
						//获得婴儿的名字
						String babyName0 =(String) reqs.get("babyName");
						String babyName1 =(String) reqs.get("babyName1");
						String babyName2 =(String) reqs.get("babyName2");
						String babyName3 =(String) reqs.get("babyName3");
						String babyName4 =(String) reqs.get("babyName4");
						String babyName5 =(String) reqs.get("babyName5");
						String babyName6 =(String) reqs.get("babyName6");
						
						ChildbirthBabyInfoPO childbirthBabyInfoPO= new ChildbirthBabyInfoPO();
						
						if(acrid0==null||acrid0==""){
							//修改第一个婴儿信息
							String deliveryType0 =(String) reqs.get("deliveryType");
							
							if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
							String id=IdUtil.uuid();
							childbirthBabyInfoVO.setId(id);	
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid1==null ||acrid1==""){
							//修改第一个婴儿信息
							String deliveryType1 =(String) reqs.get("deliveryType1");
							
							if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition =(String) reqs.get("fetusPosition1");
							String deliveryHour =(String) reqs.get("deliveryHour1");
							String deliveryMinute =(String) reqs.get("deliveryMinute1");
							String inducelabour =(String) reqs.get("inducelabour1");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
							String babySex =(String) reqs.get("babySex1");
							String health =(String) reqs.get("health1");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
							String abnormalPosition =(String) reqs.get("abnormalPosition1");
							String abnormalName =(String) reqs.get("abnormalName1");
							String oneMinScore =(String) reqs.get("oneMinScore1");
							String fiveMinScore =(String) reqs.get("fiveMinScore1");
							String bornWeight =(String) reqs.get("bornWeight1");
							String vaccine =(String) reqs.get("babyVaccine1");
							String fetusDie =(String) reqs.get("fetusDie1");
							String midwife =(String) reqs.get("midwife1");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName1);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType1);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid2==null||acrid2==""){
							//修改第二个婴儿信息
							String deliveryType2 =(String) reqs.get("deliveryType2");
							
							if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition2 =(String) reqs.get("fetusPosition2");
							String deliveryHour2 =(String) reqs.get("deliveryHour2");
							String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
							String inducelabour2 =(String) reqs.get("inducelabour2");
							String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
							String babySex2 =(String) reqs.get("babySex2");
							String health2 =(String) reqs.get("health2");
							String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
							String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
							String abnormalName2 =(String) reqs.get("abnormalName2");
							String oneMinScore2 =(String) reqs.get("oneMinScore2");
							String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
							String bornWeight2 =(String) reqs.get("bornWeight2");
							String vaccine2 =(String) reqs.get("babyVaccine2");
							String fetusDie2 =(String) reqs.get("fetusDie2");
							String midwife2 =(String) reqs.get("midwife2");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setBabyName(babyName2);
							childbirthBabyInfoVO.setAbnormalName(abnormalName2);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
							childbirthBabyInfoVO.setBabySex(babySex2);
							childbirthBabyInfoVO.setBodyLenght(bornWeight2);
							childbirthBabyInfoVO.setBornWeight(bornWeight2);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
							childbirthBabyInfoVO.setDeliveryType(deliveryType2);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
							childbirthBabyInfoVO.setFetusDie(fetusDie2);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
							childbirthBabyInfoVO.setHealth(health2);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour2);
							childbirthBabyInfoVO.setMidwife(midwife2);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
							childbirthBabyInfoVO.setVaccine(vaccine2);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						
						if(acrid3==null||acrid3==""){
							//修改第三个婴儿信息
							String deliveryType3 =(String) reqs.get("deliveryType3");
							
							if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition3 =(String) reqs.get("fetusPosition3");
							String deliveryHour3 =(String) reqs.get("deliveryHour3");
							String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
							String inducelabour3 =(String) reqs.get("inducelabour3");
							String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
							String babySex3 =(String) reqs.get("babySex3");
							String health3 =(String) reqs.get("health3");
							String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
							String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
							String abnormalName3 =(String) reqs.get("abnormalName3");
							String oneMinScore3 =(String) reqs.get("oneMinScore3");
							String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
							String bornWeight3 =(String) reqs.get("bornWeight3");
							String vaccine3 =(String) reqs.get("babyVaccine3");
							String fetusDie3 =(String) reqs.get("fetusDie3");
							String midwife3 =(String) reqs.get("midwife3");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setBabyName(babyName3);
							childbirthBabyInfoVO.setAbnormalName(abnormalName3);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
							childbirthBabyInfoVO.setBabySex(babySex3);
							childbirthBabyInfoVO.setBodyLenght(bornWeight3);
							childbirthBabyInfoVO.setBornWeight(bornWeight3);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
							childbirthBabyInfoVO.setDeliveryType(deliveryType3);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
							childbirthBabyInfoVO.setFetusDie(fetusDie3);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
							childbirthBabyInfoVO.setHealth(health3);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour3);
							childbirthBabyInfoVO.setMidwife(midwife3);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
							childbirthBabyInfoVO.setVaccine(vaccine3);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							
							}
						}
						if(acrid4==null||acrid4==""){
							//修改第四个婴儿信息
							String deliveryType4 =(String) reqs.get("deliveryType4");
							
							if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition4 =(String) reqs.get("fetusPosition4");
							String deliveryHour4 =(String) reqs.get("deliveryHour4");
							String inducelabour4 =(String) reqs.get("inducelabour4");
							String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
							String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
							String babySex4 =(String) reqs.get("babySex4");
							String health4 =(String) reqs.get("health4");
							String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
							String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
							String abnormalName4 =(String) reqs.get("abnormalName4");
							String oneMinScore4 =(String) reqs.get("oneMinScore4");
							String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
							String bornWeight4 =(String) reqs.get("bornWeight4");
							String vaccine4 =(String) reqs.get("babyVaccine4");
							String fetusDie4 =(String) reqs.get("fetusDie4");
							String midwife4 =(String) reqs.get("midwife4");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setBabyName(babyName4);
							childbirthBabyInfoVO.setAbnormalName(abnormalName4);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
							childbirthBabyInfoVO.setBabySex(babySex4);
							childbirthBabyInfoVO.setBodyLenght(bornWeight4);
							childbirthBabyInfoVO.setBornWeight(bornWeight4);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
							childbirthBabyInfoVO.setDeliveryType(deliveryType4);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
							childbirthBabyInfoVO.setFetusDie(fetusDie4);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
							childbirthBabyInfoVO.setHealth(health4);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour4);
							childbirthBabyInfoVO.setMidwife(midwife4);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
							childbirthBabyInfoVO.setVaccine(vaccine4);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid5==null||acrid5==""){
							//修改第五个婴儿信息
							String deliveryType5 =(String) reqs.get("deliveryType5");
							
							if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition5 =(String) reqs.get("fetusPosition5");
							String deliveryHour5 =(String) reqs.get("deliveryHour5");
							String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
							String inducelabour5 =(String) reqs.get("inducelabour5");
							String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
							String babySex5 =(String) reqs.get("babySex5");
							String health5 =(String) reqs.get("health5");
							String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
							String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
							String abnormalName5 =(String) reqs.get("abnormalName5");
							String oneMinScore5 =(String) reqs.get("oneMinScore5");
							String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
							String bornWeight5 =(String) reqs.get("bornWeight5");
							String vaccine5 =(String) reqs.get("babyVaccine5");
							String fetusDie5 =(String) reqs.get("fetusDie5");
							String midwife5 =(String) reqs.get("midwife5");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setBabyName(babyName5);
							childbirthBabyInfoVO.setAbnormalName(abnormalName5);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
							childbirthBabyInfoVO.setBabySex(babySex5);
							childbirthBabyInfoVO.setBodyLenght(bornWeight5);
							childbirthBabyInfoVO.setBornWeight(bornWeight5);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
							childbirthBabyInfoVO.setDeliveryType(deliveryType5);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
							childbirthBabyInfoVO.setFetusDie(fetusDie5);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
							childbirthBabyInfoVO.setHealth(health5);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour5);
							childbirthBabyInfoVO.setMidwife(midwife5);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
							childbirthBabyInfoVO.setVaccine(vaccine5);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid6==null||acrid6==""){
							//修改第五个婴儿信息
							String deliveryType6 =(String) reqs.get("deliveryType6");
							
							if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition6 =(String) reqs.get("fetusPosition6");
							String deliveryHour6 =(String) reqs.get("deliveryHour6");
							String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
							String inducelabour6 =(String) reqs.get("inducelabour6");
							String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
							String babySex6 =(String) reqs.get("babySex6");
							String health6 =(String) reqs.get("health6");
							String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
							String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
							String abnormalName6 =(String) reqs.get("abnormalName6");
							String oneMinScore6 =(String) reqs.get("oneMinScore6");
							String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
							String bornWeight6=(String) reqs.get("bornWeight6");
							String vaccine6 =(String) reqs.get("babyVaccine6");
							String fetusDie6 =(String) reqs.get("fetusDie6");
							String midwife6 =(String) reqs.get("midwife6");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setBabyName(babyName6);
							childbirthBabyInfoVO.setAbnormalName(abnormalName6);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
							childbirthBabyInfoVO.setBabySex(babySex6);
							childbirthBabyInfoVO.setBodyLenght(bornWeight6);
							childbirthBabyInfoVO.setBornWeight(bornWeight6);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
							childbirthBabyInfoVO.setDeliveryType(deliveryType6);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
							childbirthBabyInfoVO.setFetusDie(fetusDie6);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
							childbirthBabyInfoVO.setHealth(health6);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour6);
							childbirthBabyInfoVO.setMidwife(midwife6);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
							childbirthBabyInfoVO.setVaccine(vaccine6);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}	
						
						
					}
					
					
					//ModelAndView model = new ModelAndView("prenatal/prenatal_list");
					return model;
				}
				
				//获取基本信息的id
				String id2 = childbirthBasic.getId();
				
		
				String birthDate =(String) reqs.get("birthDate");
				String leaveDate =(String) reqs.get("leaveDate");
				String BasicCreateTime =(String) reqs.get("BasicCreateTime");
				SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
				
				if(BasicCreateTime !=null){
					Date createTime = formate.parse(BasicCreateTime);
					childbirthBasicInfoVO.setCreatTime(createTime);
					childbirthBasicInfoVO.setUpdateTime(new Date());
					childbirthBasicInfoVO.setNormalSign("0");
				}
				if(BasicCreateTime==null||BasicCreateTime==""){
					childbirthBasicInfoVO.setCreatTime(new Date());
					childbirthBasicInfoVO.setUpdateTime(new Date());
					childbirthBasicInfoVO.setNormalSign("1");
				}
				Date date = formate.parse(birthDate);
				Date leave = formate.parse(leaveDate);
				childbirthBasicInfoVO.setId(id2);
				childbirthBasicInfoVO.setBirthDate(date);
				childbirthBasicInfoVO.setLeaveDate(leave);
				childbirthBasicInfoVO.setEditStatus("0");
				childbirthBasicInfoVO.setBirthArchivesId(birthArchivesId);
				BeanUtils.copyProperties(childbirthBasic, childbirthBasicInfoVO);
				childbirthBasicInfoService.update(childbirthBasic);
				
				
				//查询分娩信息通过基本信息的id
				ChildbirthInfoPO childbirthByBasicId = childbirthInfoService.getChildbirthByBasicId(id2);
				//获得分娩信息的id
				String childbirthid = childbirthByBasicId.getId();
				
				//获得分娩地点
				String childbirthPlace = childbirthInfoVO.getChildbirthPlace();
				String[] split = childbirthPlace.split(",");
				childbirthInfoVO.setChildbirthPlace(split[0]);
				
				childbirthInfoVO.setId(childbirthid);
				childbirthInfoVO.setBasicId(id2);
				BeanUtils.copyProperties(childbirthByBasicId, childbirthInfoVO);
				childbirthInfoService.update(childbirthByBasicId);
				
				
				//获取转诊信息通过分娩信息的id
				ChildbirthReferralInfoPO ChildbirthReferral = childbirthReferralInfoService.findByChildBirthInfoId(childbirthid); 
				
				//获取转诊信息的id
					if(ChildbirthReferral !=null){
					String ReferralId = ChildbirthReferral.getId();
					
					
					String referral = childbirthReferralInfoVO.getReferral();
					//当转诊标识为1，确认转诊时
					if(referral.equals("1")){
						String idde =(String) reqs.get("department");
						String mechanism =(String) reqs.get("mechanism");
						
						//将转诊标识设置为分娩转诊
						birthArchivesByArchivesId.setReferralSign("2");
						birthArchivesByArchivesId.setInHospitalId(idde);
						birthArchivesByArchivesId.setDeltetSign("1");
						birthArchivesByArchivesId.setPregnantState("1");
						
						birthArchivesInfoService.update(birthArchivesByArchivesId);
						childbirthReferralInfoVO.setId(ReferralId);
						childbirthReferralInfoVO.setBasicId(id2);
					BeanUtils.copyProperties(ChildbirthReferral, childbirthReferralInfoVO);
					childbirthReferralInfoService.update(ChildbirthReferral);
					}
				
				//当没有转诊时
						if(referral.equals("0")){
							
							birthArchivesByArchivesId.setReferralSign("2");
							birthArchivesByArchivesId.setDeltetSign("1");
							birthArchivesByArchivesId.setPregnantState("1");
							
							birthArchivesInfoService.update(birthArchivesByArchivesId);
							
						}
				}
					if(ChildbirthReferral ==null){
						String ReferralId = IdUtil.uuid();
						
						String referral = childbirthReferralInfoVO.getReferral();
						//当转诊标识为1，确认转诊时
						if(referral.equals("1")){
							String idde =(String) reqs.get("department");
							String mechanism =(String) reqs.get("mechanism");
							
							//将转诊标识设置为分娩转诊
							birthArchivesByArchivesId.setReferralSign("2");
							birthArchivesByArchivesId.setInHospitalId(idde);
							birthArchivesByArchivesId.setDeltetSign("1");
							birthArchivesByArchivesId.setPregnantState("1");
							
							birthArchivesInfoService.update(birthArchivesByArchivesId);
						ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
						childbirthReferralInfoVO.setId(ReferralId);
						childbirthReferralInfoVO.setBasicId(id2);
						BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
						childbirthReferralInfoService.create(childbirthReferralInfoPO);
						}
					
					//当没有转诊时
							if(referral.equals("0")){
								
								BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
								birthArchivesInfoPO.setReferralSign("0");
								birthArchivesByArchivesId.setDeltetSign("1");
								birthArchivesByArchivesId.setPregnantState("1");
							}
					}
				//获取分娩婴儿信息 通过分娩信息id
				List<ChildbirthBabyInfoPO> babyInfo= childbirthBabyInfoService.getBabyInfoByChildbirthId(childbirthid);
				if(babyInfo.size() !=0){
					
					String acrid0 =(String) reqs.get("acrid0");
					String acrid1 =(String) reqs.get("acrid1");
					String acrid2 =(String) reqs.get("acrid2");
					String acrid3 =(String) reqs.get("acrid3");
					String acrid4 =(String) reqs.get("acrid4");
					String acrid5 =(String) reqs.get("acrid5");
					String acrid6 =(String) reqs.get("acrid6");
					
					
					//获得婴儿的名字
					String babyName0 =(String) reqs.get("babyName");
					String babyName1 =(String) reqs.get("babyName1");
					String babyName2 =(String) reqs.get("babyName2");
					String babyName3 =(String) reqs.get("babyName3");
					String babyName4 =(String) reqs.get("babyName4");
					String babyName5 =(String) reqs.get("babyName5");
					String babyName6 =(String) reqs.get("babyName6");
					
					for(int i=0;i<babyInfo.size();i++){
						ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);

						
						//获得婴儿的id
						String childbirthBabyId= childbirthBabyInfoPO.getId();
						
						if(childbirthBabyId.equals(acrid0)){
							
							
							//修改第一个婴儿信息
							String deliveryType0 =(String) reqs.get("deliveryType");
							
							if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition =(String) reqs.get("fetusPosition");
							String deliveryHour =(String) reqs.get("deliveryHour");
							String deliveryMinute =(String) reqs.get("deliveryMinute");
							String inducelabour =(String) reqs.get("inducelabour");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio");
							String babySex =(String) reqs.get("babySex");
							String health =(String) reqs.get("health");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly");
							String abnormalPosition =(String) reqs.get("abnormalPosition");
							String abnormalName =(String) reqs.get("abnormalName");
							String oneMinScore =(String) reqs.get("oneMinScore");
							String fiveMinScore =(String) reqs.get("fiveMinScore");
							String bornWeight =(String) reqs.get("bornWeight");
							//String vaccine =(String) reqs.get("vaccine");
							String fetusDie =(String) reqs.get("fetusDie");
							String midwife =(String) reqs.get("midwife");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName0);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType0);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							//childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
						
						
						
						
						
						
						if(childbirthBabyId.equals(acrid1)){
							
							
							//修改第一个婴儿信息
							String deliveryType1 =(String) reqs.get("deliveryType1");
							
							if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition =(String) reqs.get("fetusPosition1");
							String deliveryHour =(String) reqs.get("deliveryHour1");
							String deliveryMinute =(String) reqs.get("deliveryMinute1");
							String inducelabour =(String) reqs.get("inducelabour1");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
							String babySex =(String) reqs.get("babySex1");
							String health =(String) reqs.get("health1");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
							String abnormalPosition =(String) reqs.get("abnormalPosition1");
							String abnormalName =(String) reqs.get("abnormalName1");
							String oneMinScore =(String) reqs.get("oneMinScore1");
							String fiveMinScore =(String) reqs.get("fiveMinScore1");
							String bornWeight =(String) reqs.get("bornWeight1");
							String vaccine =(String) reqs.get("babyVaccine1");
							String fetusDie =(String) reqs.get("fetusDie1");
							String midwife =(String) reqs.get("midwife1");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName1);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType1);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(acrid1);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
						if(childbirthBabyId.equals(acrid2)){
							
							
							//修改第二个婴儿信息
							String deliveryType2 =(String) reqs.get("deliveryType2");
							
							if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition2 =(String) reqs.get("fetusPosition2");
							String deliveryHour2 =(String) reqs.get("deliveryHour2");
							String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
							String inducelabour2 =(String) reqs.get("inducelabour2");
							String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
							String babySex2 =(String) reqs.get("babySex2");
							String health2 =(String) reqs.get("health2");
							String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
							String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
							String abnormalName2 =(String) reqs.get("abnormalName2");
							String oneMinScore2 =(String) reqs.get("oneMinScore2");
							String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
							String bornWeight2 =(String) reqs.get("bornWeight2");
							String vaccine2 =(String) reqs.get("babyVaccine2");
							String fetusDie2 =(String) reqs.get("fetusDie2");
							String midwife2 =(String) reqs.get("midwife2");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setBabyName(babyName2);
							childbirthBabyInfoVO.setAbnormalName(abnormalName2);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
							childbirthBabyInfoVO.setBabySex(babySex2);
							childbirthBabyInfoVO.setBodyLenght(bornWeight2);
							childbirthBabyInfoVO.setBornWeight(bornWeight2);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
							childbirthBabyInfoVO.setDeliveryType(deliveryType2);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
							childbirthBabyInfoVO.setFetusDie(fetusDie2);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
							childbirthBabyInfoVO.setHealth(health2);
							childbirthBabyInfoVO.setId(acrid2);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour2);
							childbirthBabyInfoVO.setMidwife(midwife2);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
							childbirthBabyInfoVO.setVaccine(vaccine2);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
					
									
									
									
									
							if(childbirthBabyId.equals(acrid3)){
							
							
							//修改第三个婴儿信息
							String deliveryType3 =(String) reqs.get("deliveryType3");
							
							if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition3 =(String) reqs.get("fetusPosition3");
							String deliveryHour3 =(String) reqs.get("deliveryHour3");
							String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
							String inducelabour3 =(String) reqs.get("inducelabour3");
							String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
							String babySex3 =(String) reqs.get("babySex3");
							String health3 =(String) reqs.get("health3");
							String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
							String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
							String abnormalName3 =(String) reqs.get("abnormalName3");
							String oneMinScore3 =(String) reqs.get("oneMinScore3");
							String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
							String bornWeight3 =(String) reqs.get("bornWeight3");
							String vaccine3 =(String) reqs.get("babyVaccine3");
							String fetusDie3 =(String) reqs.get("fetusDie3");
							String midwife3 =(String) reqs.get("midwife3");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setBabyName(babyName3);
							childbirthBabyInfoVO.setAbnormalName(abnormalName3);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
							childbirthBabyInfoVO.setBabySex(babySex3);
							childbirthBabyInfoVO.setBodyLenght(bornWeight3);
							childbirthBabyInfoVO.setBornWeight(bornWeight3);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
							childbirthBabyInfoVO.setDeliveryType(deliveryType3);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
							childbirthBabyInfoVO.setFetusDie(fetusDie3);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
							childbirthBabyInfoVO.setHealth(health3);
							childbirthBabyInfoVO.setId(acrid3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour3);
							childbirthBabyInfoVO.setMidwife(midwife3);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
							childbirthBabyInfoVO.setVaccine(vaccine3);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
							if(childbirthBabyId.equals(acrid4)){
								
								
								//修改第四个婴儿信息
								String deliveryType4 =(String) reqs.get("deliveryType4");
								
								if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition4 =(String) reqs.get("fetusPosition4");
								String deliveryHour4 =(String) reqs.get("deliveryHour4");
								String inducelabour4 =(String) reqs.get("inducelabour4");
								String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
								String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
								String babySex4 =(String) reqs.get("babySex4");
								String health4 =(String) reqs.get("health4");
								String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
								String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
								String abnormalName4 =(String) reqs.get("abnormalName4");
								String oneMinScore4 =(String) reqs.get("oneMinScore4");
								String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
								String bornWeight4 =(String) reqs.get("bornWeight4");
								String vaccine4 =(String) reqs.get("babyVaccine4");
								String fetusDie4 =(String) reqs.get("fetusDie4");
								String midwife4 =(String) reqs.get("midwife4");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
								childbirthBabyInfoVO.setBabyName(babyName4);
								childbirthBabyInfoVO.setAbnormalName(abnormalName4);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
								childbirthBabyInfoVO.setBabySex(babySex4);
								childbirthBabyInfoVO.setBodyLenght(bornWeight4);
								childbirthBabyInfoVO.setBornWeight(bornWeight4);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
								childbirthBabyInfoVO.setDeliveryType(deliveryType4);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
								childbirthBabyInfoVO.setFetusDie(fetusDie4);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
								childbirthBabyInfoVO.setHealth(health4);
								childbirthBabyInfoVO.setId(acrid4);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour4);
								childbirthBabyInfoVO.setMidwife(midwife4);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
								childbirthBabyInfoVO.setVaccine(vaccine4);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}			
								if(childbirthBabyId.equals(acrid5)){
								
								
								//修改第五个婴儿信息
								String deliveryType5 =(String) reqs.get("deliveryType5");
								
								if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition5 =(String) reqs.get("fetusPosition5");
								String deliveryHour5 =(String) reqs.get("deliveryHour5");
								String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
								String inducelabour5 =(String) reqs.get("inducelabour5");
								String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
								String babySex5 =(String) reqs.get("babySex5");
								String health5 =(String) reqs.get("health5");
								String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
								String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
								String abnormalName5 =(String) reqs.get("abnormalName5");
								String oneMinScore5 =(String) reqs.get("oneMinScore5");
								String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
								String bornWeight5 =(String) reqs.get("bornWeight5");
								String vaccine5 =(String) reqs.get("babyVaccine5");
								String fetusDie5 =(String) reqs.get("fetusDie5");
								String midwife5 =(String) reqs.get("midwife5");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
								childbirthBabyInfoVO.setBabyName(babyName5);
								childbirthBabyInfoVO.setAbnormalName(abnormalName5);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
								childbirthBabyInfoVO.setBabySex(babySex5);
								childbirthBabyInfoVO.setBodyLenght(bornWeight5);
								childbirthBabyInfoVO.setBornWeight(bornWeight5);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
								childbirthBabyInfoVO.setDeliveryType(deliveryType5);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
								childbirthBabyInfoVO.setFetusDie(fetusDie5);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
								childbirthBabyInfoVO.setHealth(health5);
								childbirthBabyInfoVO.setId(acrid5);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour5);
								childbirthBabyInfoVO.setMidwife(midwife5);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
								childbirthBabyInfoVO.setVaccine(vaccine5);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}	
								
								if(childbirthBabyId.equals(acrid6)){
									
									
									//修改第五个婴儿信息
									String deliveryType6 =(String) reqs.get("deliveryType6");
									
									if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
									
									
									String fetusPosition6 =(String) reqs.get("fetusPosition6");
									String deliveryHour6 =(String) reqs.get("deliveryHour6");
									String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
									String inducelabour6 =(String) reqs.get("inducelabour6");
									String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
									String babySex6 =(String) reqs.get("babySex6");
									String health6 =(String) reqs.get("health6");
									String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
									String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
									String abnormalName6 =(String) reqs.get("abnormalName6");
									String oneMinScore6 =(String) reqs.get("oneMinScore6");
									String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
									String bornWeight6 =(String) reqs.get("bornWeight6");
									String vaccine6 =(String) reqs.get("babyVaccine6");
									String fetusDie6 =(String) reqs.get("fetusDie6");
									String midwife6 =(String) reqs.get("midwife6");
							
									childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
									childbirthBabyInfoVO.setBabyName(babyName6);
									childbirthBabyInfoVO.setAbnormalName(abnormalName6);
									childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
									childbirthBabyInfoVO.setBabySex(babySex6);
									childbirthBabyInfoVO.setBodyLenght(bornWeight6);
									childbirthBabyInfoVO.setBornWeight(bornWeight6);
									childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
									childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
									childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
									childbirthBabyInfoVO.setDeliveryType(deliveryType6);
									childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
									childbirthBabyInfoVO.setFetusDie(fetusDie6);
									childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
									childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
									childbirthBabyInfoVO.setHealth(health6);
									childbirthBabyInfoVO.setId(acrid6);
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
									childbirthBabyInfoVO.setInducelabour(inducelabour6);
									childbirthBabyInfoVO.setMidwife(midwife6);
									childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
									childbirthBabyInfoVO.setVaccine(vaccine6);
									BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
									childbirthBabyInfoService.update(childbirthBabyInfoPO);
									}
								}
							}
					
					ChildbirthBabyInfoPO childbirthBaby=new ChildbirthBabyInfoPO();
					if(acrid0==null||acrid0==""){
						//修改第一个婴儿信息
						String deliveryType0 =(String) reqs.get("deliveryType");
						if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
						String id=IdUtil.uuid();
						childbirthBabyInfoVO.setId(id);	
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid1==null ||acrid1==""){
						//修改第一个婴儿信息
						String deliveryType1 =(String) reqs.get("deliveryType1");
						
						if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition =(String) reqs.get("fetusPosition1");
						String deliveryHour =(String) reqs.get("deliveryHour1");
						String deliveryMinute =(String) reqs.get("deliveryMinute1");
						String inducelabour =(String) reqs.get("inducelabour1");
						String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
						String babySex =(String) reqs.get("babySex1");
						String health =(String) reqs.get("health1");
						String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
						String abnormalPosition =(String) reqs.get("abnormalPosition1");
						String abnormalName =(String) reqs.get("abnormalName1");
						String oneMinScore =(String) reqs.get("oneMinScore1");
						String fiveMinScore =(String) reqs.get("fiveMinScore1");
						String bornWeight =(String) reqs.get("bornWeight1");
						String vaccine =(String) reqs.get("babyVaccine1");
						String fetusDie =(String) reqs.get("fetusDie1");
						String midwife =(String) reqs.get("midwife1");
						
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setBabyName(babyName1);
						childbirthBabyInfoVO.setAbnormalName(abnormalName);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
						childbirthBabyInfoVO.setBabySex(babySex);
						childbirthBabyInfoVO.setBodyLenght(bornWeight);
						childbirthBabyInfoVO.setBornWeight(bornWeight);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
						childbirthBabyInfoVO.setDeliveryType(deliveryType1);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
						childbirthBabyInfoVO.setFetusDie(fetusDie);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
						childbirthBabyInfoVO.setHealth(health);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour);
						childbirthBabyInfoVO.setMidwife(midwife);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore);
						childbirthBabyInfoVO.setVaccine(vaccine);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid2==null||acrid2==""){
						//修改第二个婴儿信息
						String deliveryType2 =(String) reqs.get("deliveryType2");
						
						if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition2 =(String) reqs.get("fetusPosition2");
						String deliveryHour2 =(String) reqs.get("deliveryHour2");
						String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
						String inducelabour2 =(String) reqs.get("inducelabour2");
						String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
						String babySex2 =(String) reqs.get("babySex2");
						String health2 =(String) reqs.get("health2");
						String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
						String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
						String abnormalName2 =(String) reqs.get("abnormalName2");
						String oneMinScore2 =(String) reqs.get("oneMinScore2");
						String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
						String bornWeight2 =(String) reqs.get("bornWeight2");
						String vaccine2 =(String) reqs.get("babyVaccine2");
						String fetusDie2 =(String) reqs.get("fetusDie2");
						String midwife2 =(String) reqs.get("midwife2");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setBabyName(babyName2);
						childbirthBabyInfoVO.setAbnormalName(abnormalName2);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
						childbirthBabyInfoVO.setBabySex(babySex2);
						childbirthBabyInfoVO.setBodyLenght(bornWeight2);
						childbirthBabyInfoVO.setBornWeight(bornWeight2);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
						childbirthBabyInfoVO.setDeliveryType(deliveryType2);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
						childbirthBabyInfoVO.setFetusDie(fetusDie2);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
						childbirthBabyInfoVO.setHealth(health2);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour2);
						childbirthBabyInfoVO.setMidwife(midwife2);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
						childbirthBabyInfoVO.setVaccine(vaccine2);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					
					if(acrid3==null||acrid3==""){
						//修改第三个婴儿信息
						String deliveryType3 =(String) reqs.get("deliveryType3");
						
						if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition3 =(String) reqs.get("fetusPosition3");
						String deliveryHour3 =(String) reqs.get("deliveryHour3");
						String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
						String inducelabour3 =(String) reqs.get("inducelabour3");
						String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
						String babySex3 =(String) reqs.get("babySex3");
						String health3 =(String) reqs.get("health3");
						String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
						String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
						String abnormalName3 =(String) reqs.get("abnormalName3");
						String oneMinScore3 =(String) reqs.get("oneMinScore3");
						String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
						String bornWeight3 =(String) reqs.get("bornWeight3");
						String vaccine3 =(String) reqs.get("babyVaccine3");
						String fetusDie3 =(String) reqs.get("fetusDie3");
						String midwife3 =(String) reqs.get("midwife3");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setBabyName(babyName3);
						childbirthBabyInfoVO.setAbnormalName(abnormalName3);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
						childbirthBabyInfoVO.setBabySex(babySex3);
						childbirthBabyInfoVO.setBodyLenght(bornWeight3);
						childbirthBabyInfoVO.setBornWeight(bornWeight3);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
						childbirthBabyInfoVO.setDeliveryType(deliveryType3);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
						childbirthBabyInfoVO.setFetusDie(fetusDie3);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
						childbirthBabyInfoVO.setHealth(health3);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour3);
						childbirthBabyInfoVO.setMidwife(midwife3);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
						childbirthBabyInfoVO.setVaccine(vaccine3);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						
						}
					}
					if(acrid4==null||acrid4==""){
						//修改第四个婴儿信息
						String deliveryType4 =(String) reqs.get("deliveryType4");
						
						if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition4 =(String) reqs.get("fetusPosition4");
						String deliveryHour4 =(String) reqs.get("deliveryHour4");
						String inducelabour4 =(String) reqs.get("inducelabour4");
						String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
						String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
						String babySex4 =(String) reqs.get("babySex4");
						String health4 =(String) reqs.get("health4");
						String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
						String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
						String abnormalName4 =(String) reqs.get("abnormalName4");
						String oneMinScore4 =(String) reqs.get("oneMinScore4");
						String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
						String bornWeight4 =(String) reqs.get("bornWeight4");
						String vaccine4 =(String) reqs.get("babyVaccine4");
						String fetusDie4 =(String) reqs.get("fetusDie4");
						String midwife4 =(String) reqs.get("midwife4");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setBabyName(babyName4);
						childbirthBabyInfoVO.setAbnormalName(abnormalName4);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
						childbirthBabyInfoVO.setBabySex(babySex4);
						childbirthBabyInfoVO.setBodyLenght(bornWeight4);
						childbirthBabyInfoVO.setBornWeight(bornWeight4);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
						childbirthBabyInfoVO.setDeliveryType(deliveryType4);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
						childbirthBabyInfoVO.setFetusDie(fetusDie4);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
						childbirthBabyInfoVO.setHealth(health4);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour4);
						childbirthBabyInfoVO.setMidwife(midwife4);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
						childbirthBabyInfoVO.setVaccine(vaccine4);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid5==null||acrid5==""){
						//修改第五个婴儿信息
						String deliveryType5 =(String) reqs.get("deliveryType5");
						
						if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition5 =(String) reqs.get("fetusPosition5");
						String deliveryHour5 =(String) reqs.get("deliveryHour5");
						String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
						String inducelabour5 =(String) reqs.get("inducelabour5");
						String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
						String babySex5 =(String) reqs.get("babySex5");
						String health5 =(String) reqs.get("health5");
						String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
						String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
						String abnormalName5 =(String) reqs.get("abnormalName5");
						String oneMinScore5 =(String) reqs.get("oneMinScore5");
						String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
						String bornWeight5 =(String) reqs.get("bornWeight5");
						String vaccine5 =(String) reqs.get("babyVaccine5");
						String fetusDie5 =(String) reqs.get("fetusDie5");
						String midwife5 =(String) reqs.get("midwife5");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setBabyName(babyName5);
						childbirthBabyInfoVO.setAbnormalName(abnormalName5);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
						childbirthBabyInfoVO.setBabySex(babySex5);
						childbirthBabyInfoVO.setBodyLenght(bornWeight5);
						childbirthBabyInfoVO.setBornWeight(bornWeight5);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
						childbirthBabyInfoVO.setDeliveryType(deliveryType5);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
						childbirthBabyInfoVO.setFetusDie(fetusDie5);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
						childbirthBabyInfoVO.setHealth(health5);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour5);
						childbirthBabyInfoVO.setMidwife(midwife5);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
						childbirthBabyInfoVO.setVaccine(vaccine5);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid6==null||acrid6==""){
						//修改第五个婴儿信息
						String deliveryType6 =(String) reqs.get("deliveryType6");
						
						if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition6 =(String) reqs.get("fetusPosition6");
						String deliveryHour6 =(String) reqs.get("deliveryHour6");
						String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
						String inducelabour6 =(String) reqs.get("inducelabour6");
						String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
						String babySex6 =(String) reqs.get("babySex6");
						String health6 =(String) reqs.get("health6");
						String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
						String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
						String abnormalName6 =(String) reqs.get("abnormalName6");
						String oneMinScore6 =(String) reqs.get("oneMinScore6");
						String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
						String bornWeight6=(String) reqs.get("bornWeight6");
						String vaccine6 =(String) reqs.get("babyVaccine6");
						String fetusDie6 =(String) reqs.get("fetusDie6");
						String midwife6 =(String) reqs.get("midwife6");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setBabyName(babyName6);
						childbirthBabyInfoVO.setAbnormalName(abnormalName6);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
						childbirthBabyInfoVO.setBabySex(babySex6);
						childbirthBabyInfoVO.setBodyLenght(bornWeight6);
						childbirthBabyInfoVO.setBornWeight(bornWeight6);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
						childbirthBabyInfoVO.setDeliveryType(deliveryType6);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
						childbirthBabyInfoVO.setFetusDie(fetusDie6);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
						childbirthBabyInfoVO.setHealth(health6);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour6);
						childbirthBabyInfoVO.setMidwife(midwife6);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
						childbirthBabyInfoVO.setVaccine(vaccine6);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
				}
				
				
				if(babyInfo.size() ==0){
					String acrid0 =(String) reqs.get("acrid0");
					String acrid1 =(String) reqs.get("acrid1");
					String acrid2 =(String) reqs.get("acrid2");
					String acrid3 =(String) reqs.get("acrid3");
					String acrid4 =(String) reqs.get("acrid4");
					String acrid5 =(String) reqs.get("acrid5");
					String acrid6 =(String) reqs.get("acrid6");
					
					
					//获得婴儿的名字
					String babyName0 =(String) reqs.get("babyName");
					String babyName1 =(String) reqs.get("babyName1");
					String babyName2 =(String) reqs.get("babyName2");
					String babyName3 =(String) reqs.get("babyName3");
					String babyName4 =(String) reqs.get("babyName4");
					String babyName5 =(String) reqs.get("babyName5");
					String babyName6 =(String) reqs.get("babyName6");
					
					ChildbirthBabyInfoPO childbirthBabyInfoPO= new ChildbirthBabyInfoPO();
					
					if(acrid0==null||acrid0==""){
						//修改第一个婴儿信息
						String deliveryType0 =(String) reqs.get("deliveryType");
						
						if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
						String id=IdUtil.uuid();
						childbirthBabyInfoVO.setId(id);	
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid1==null ||acrid1==""){
						//修改第一个婴儿信息
						String deliveryType1 =(String) reqs.get("deliveryType1");
						
						if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition =(String) reqs.get("fetusPosition1");
						String deliveryHour =(String) reqs.get("deliveryHour1");
						String deliveryMinute =(String) reqs.get("deliveryMinute1");
						String inducelabour =(String) reqs.get("inducelabour1");
						String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
						String babySex =(String) reqs.get("babySex1");
						String health =(String) reqs.get("health1");
						String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
						String abnormalPosition =(String) reqs.get("abnormalPosition1");
						String abnormalName =(String) reqs.get("abnormalName1");
						String oneMinScore =(String) reqs.get("oneMinScore1");
						String fiveMinScore =(String) reqs.get("fiveMinScore1");
						String bornWeight =(String) reqs.get("bornWeight1");
						String vaccine =(String) reqs.get("babyVaccine1");
						String fetusDie =(String) reqs.get("fetusDie1");
						String midwife =(String) reqs.get("midwife1");
						
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setBabyName(babyName1);
						childbirthBabyInfoVO.setAbnormalName(abnormalName);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
						childbirthBabyInfoVO.setBabySex(babySex);
						childbirthBabyInfoVO.setBodyLenght(bornWeight);
						childbirthBabyInfoVO.setBornWeight(bornWeight);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
						childbirthBabyInfoVO.setDeliveryType(deliveryType1);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
						childbirthBabyInfoVO.setFetusDie(fetusDie);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
						childbirthBabyInfoVO.setHealth(health);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour);
						childbirthBabyInfoVO.setMidwife(midwife);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore);
						childbirthBabyInfoVO.setVaccine(vaccine);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid2==null||acrid2==""){
						//修改第二个婴儿信息
						String deliveryType2 =(String) reqs.get("deliveryType2");
						
						if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition2 =(String) reqs.get("fetusPosition2");
						String deliveryHour2 =(String) reqs.get("deliveryHour2");
						String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
						String inducelabour2 =(String) reqs.get("inducelabour2");
						String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
						String babySex2 =(String) reqs.get("babySex2");
						String health2 =(String) reqs.get("health2");
						String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
						String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
						String abnormalName2 =(String) reqs.get("abnormalName2");
						String oneMinScore2 =(String) reqs.get("oneMinScore2");
						String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
						String bornWeight2 =(String) reqs.get("bornWeight2");
						String vaccine2 =(String) reqs.get("babyVaccine2");
						String fetusDie2 =(String) reqs.get("fetusDie2");
						String midwife2 =(String) reqs.get("midwife2");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setBabyName(babyName2);
						childbirthBabyInfoVO.setAbnormalName(abnormalName2);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
						childbirthBabyInfoVO.setBabySex(babySex2);
						childbirthBabyInfoVO.setBodyLenght(bornWeight2);
						childbirthBabyInfoVO.setBornWeight(bornWeight2);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
						childbirthBabyInfoVO.setDeliveryType(deliveryType2);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
						childbirthBabyInfoVO.setFetusDie(fetusDie2);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
						childbirthBabyInfoVO.setHealth(health2);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour2);
						childbirthBabyInfoVO.setMidwife(midwife2);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
						childbirthBabyInfoVO.setVaccine(vaccine2);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					
					if(acrid3==null||acrid3==""){
						//修改第三个婴儿信息
						String deliveryType3 =(String) reqs.get("deliveryType3");
						
						if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition3 =(String) reqs.get("fetusPosition3");
						String deliveryHour3 =(String) reqs.get("deliveryHour3");
						String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
						String inducelabour3 =(String) reqs.get("inducelabour3");
						String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
						String babySex3 =(String) reqs.get("babySex3");
						String health3 =(String) reqs.get("health3");
						String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
						String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
						String abnormalName3 =(String) reqs.get("abnormalName3");
						String oneMinScore3 =(String) reqs.get("oneMinScore3");
						String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
						String bornWeight3 =(String) reqs.get("bornWeight3");
						String vaccine3 =(String) reqs.get("babyVaccine3");
						String fetusDie3 =(String) reqs.get("fetusDie3");
						String midwife3 =(String) reqs.get("midwife3");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setBabyName(babyName3);
						childbirthBabyInfoVO.setAbnormalName(abnormalName3);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
						childbirthBabyInfoVO.setBabySex(babySex3);
						childbirthBabyInfoVO.setBodyLenght(bornWeight3);
						childbirthBabyInfoVO.setBornWeight(bornWeight3);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
						childbirthBabyInfoVO.setDeliveryType(deliveryType3);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
						childbirthBabyInfoVO.setFetusDie(fetusDie3);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
						childbirthBabyInfoVO.setHealth(health3);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour3);
						childbirthBabyInfoVO.setMidwife(midwife3);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
						childbirthBabyInfoVO.setVaccine(vaccine3);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						
						}
					}
					if(acrid4==null||acrid4==""){
						//修改第四个婴儿信息
						String deliveryType4 =(String) reqs.get("deliveryType4");
						
						if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition4 =(String) reqs.get("fetusPosition4");
						String deliveryHour4 =(String) reqs.get("deliveryHour4");
						String inducelabour4 =(String) reqs.get("inducelabour4");
						String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
						String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
						String babySex4 =(String) reqs.get("babySex4");
						String health4 =(String) reqs.get("health4");
						String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
						String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
						String abnormalName4 =(String) reqs.get("abnormalName4");
						String oneMinScore4 =(String) reqs.get("oneMinScore4");
						String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
						String bornWeight4 =(String) reqs.get("bornWeight4");
						String vaccine4 =(String) reqs.get("babyVaccine4");
						String fetusDie4 =(String) reqs.get("fetusDie4");
						String midwife4 =(String) reqs.get("midwife4");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setBabyName(babyName4);
						childbirthBabyInfoVO.setAbnormalName(abnormalName4);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
						childbirthBabyInfoVO.setBabySex(babySex4);
						childbirthBabyInfoVO.setBodyLenght(bornWeight4);
						childbirthBabyInfoVO.setBornWeight(bornWeight4);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
						childbirthBabyInfoVO.setDeliveryType(deliveryType4);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
						childbirthBabyInfoVO.setFetusDie(fetusDie4);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
						childbirthBabyInfoVO.setHealth(health4);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour4);
						childbirthBabyInfoVO.setMidwife(midwife4);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
						childbirthBabyInfoVO.setVaccine(vaccine4);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid5==null||acrid5==""){
						//修改第五个婴儿信息
						String deliveryType5 =(String) reqs.get("deliveryType5");
						
						if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition5 =(String) reqs.get("fetusPosition5");
						String deliveryHour5 =(String) reqs.get("deliveryHour5");
						String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
						String inducelabour5 =(String) reqs.get("inducelabour5");
						String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
						String babySex5 =(String) reqs.get("babySex5");
						String health5 =(String) reqs.get("health5");
						String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
						String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
						String abnormalName5 =(String) reqs.get("abnormalName5");
						String oneMinScore5 =(String) reqs.get("oneMinScore5");
						String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
						String bornWeight5 =(String) reqs.get("bornWeight5");
						String vaccine5 =(String) reqs.get("babyVaccine5");
						String fetusDie5 =(String) reqs.get("fetusDie5");
						String midwife5 =(String) reqs.get("midwife5");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setBabyName(babyName5);
						childbirthBabyInfoVO.setAbnormalName(abnormalName5);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
						childbirthBabyInfoVO.setBabySex(babySex5);
						childbirthBabyInfoVO.setBodyLenght(bornWeight5);
						childbirthBabyInfoVO.setBornWeight(bornWeight5);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
						childbirthBabyInfoVO.setDeliveryType(deliveryType5);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
						childbirthBabyInfoVO.setFetusDie(fetusDie5);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
						childbirthBabyInfoVO.setHealth(health5);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour5);
						childbirthBabyInfoVO.setMidwife(midwife5);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
						childbirthBabyInfoVO.setVaccine(vaccine5);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid6==null||acrid6==""){
						//修改第五个婴儿信息
						String deliveryType6 =(String) reqs.get("deliveryType6");
						
						if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition6 =(String) reqs.get("fetusPosition6");
						String deliveryHour6 =(String) reqs.get("deliveryHour6");
						String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
						String inducelabour6 =(String) reqs.get("inducelabour6");
						String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
						String babySex6 =(String) reqs.get("babySex6");
						String health6 =(String) reqs.get("health6");
						String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
						String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
						String abnormalName6 =(String) reqs.get("abnormalName6");
						String oneMinScore6 =(String) reqs.get("oneMinScore6");
						String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
						String bornWeight6=(String) reqs.get("bornWeight6");
						String vaccine6 =(String) reqs.get("babyVaccine6");
						String fetusDie6 =(String) reqs.get("fetusDie6");
						String midwife6 =(String) reqs.get("midwife6");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setBabyName(babyName6);
						childbirthBabyInfoVO.setAbnormalName(abnormalName6);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
						childbirthBabyInfoVO.setBabySex(babySex6);
						childbirthBabyInfoVO.setBodyLenght(bornWeight6);
						childbirthBabyInfoVO.setBornWeight(bornWeight6);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
						childbirthBabyInfoVO.setDeliveryType(deliveryType6);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
						childbirthBabyInfoVO.setFetusDie(fetusDie6);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
						childbirthBabyInfoVO.setHealth(health6);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour6);
						childbirthBabyInfoVO.setMidwife(midwife6);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
						childbirthBabyInfoVO.setVaccine(vaccine6);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}	
					
					
				}
				//ModelAndView model = new ModelAndView("prenatal/prenatal_list");
				return model;
			}
			
			//点击完成
			if(editStatus.equals("1")){
				
				String chid=(String)reqs.get("acrid");
				
				
				
				//查询生育档案 通过档案id
				BirthArchivesInfoPO birthArchivesByArchivesId = birthArchivesInfoService.getBirthArchivesByArchivesId(chid);
				
				//获得生育档案的id
				String birthArchivesId = birthArchivesByArchivesId.getId();
				
				
				
				//查询高危信息
				
				String highRiskId =(String) reqs.get("highRiskId");
				if(highRiskId !=null &&highRiskId !=""){
				
				HighRiskInfoPO highRiskInfoPO = highRiskInfoService.find(highRiskId);
				
				PrenatalExaInfoPO prenatalExa = prenatalExaInfoService.getPrenatalExaByBirthArchivesId(birthArchivesId);
				
				String prenatalExaid = prenatalExa.getId();
				
				highRiskInfoPO.setExaminationId(prenatalExaid);
				
				highRiskInfoService.update(highRiskInfoPO);

				}
				
				
				
				//查询个人基本信息通过生育档案id
				ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId); 
				if(childbirthBasic==null){
					ChildbirthBasicInfoPO saveChildbirthBasic = childbirthBasicInfoService.SaveChildbirthBasicByBirthArchivesId(birthArchivesId);
					if(saveChildbirthBasic==null){
						String ChildbirthBasicid = IdUtil.uuid();
						childbirthBasicInfoVO.setId(ChildbirthBasicid);
						childbirthBasicInfoVO.setBirthArchivesId(birthArchivesId);
						ChildbirthBasicInfoPO childbirthBasicInfoPO= new ChildbirthBasicInfoPO();
						BeanUtils.copyProperties(childbirthBasicInfoPO, childbirthBasicInfoVO);
						childbirthBasicInfoService.create(childbirthBasicInfoPO);
					}
					//获取基本信息的id
					String id2 = saveChildbirthBasic.getId();
					
			
					String birthDate =(String) reqs.get("birthDate");
					String leaveDate =(String) reqs.get("leaveDate");
					String BasicCreateTime =(String) reqs.get("BasicCreateTime");
					SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
					
					if(BasicCreateTime !=null){
						Date createTime = formate.parse(BasicCreateTime);
						childbirthBasicInfoVO.setCreatTime(createTime);
						childbirthBasicInfoVO.setUpdateTime(new Date());
						childbirthBasicInfoVO.setNormalSign("0");
					}
					if(BasicCreateTime==null||BasicCreateTime==""){
						childbirthBasicInfoVO.setCreatTime(new Date());
						childbirthBasicInfoVO.setUpdateTime(new Date());
						childbirthBasicInfoVO.setNormalSign("1");
					}
					Date date = formate.parse(birthDate);
					Date leave = formate.parse(leaveDate);
					childbirthBasicInfoVO.setId(id2);
					childbirthBasicInfoVO.setBirthDate(date);
					childbirthBasicInfoVO.setLeaveDate(leave);
					childbirthBasicInfoVO.setEditStatus("1");
					childbirthBasicInfoVO.setBirthArchivesId(birthArchivesId);
					BeanUtils.copyProperties(saveChildbirthBasic, childbirthBasicInfoVO);
					childbirthBasicInfoService.update(saveChildbirthBasic);
					
					
					//查询分娩信息通过基本信息的id
					ChildbirthInfoPO childbirthByBasicId = childbirthInfoService.getChildbirthByBasicId(id2);
					if(childbirthByBasicId==null){
						String Childbirthid = IdUtil.uuid();
						childbirthInfoVO.setId(Childbirthid);
						childbirthInfoVO.setBasicId(id2);
						ChildbirthInfoPO childbirthInfoPO= new ChildbirthInfoPO();
						BeanUtils.copyProperties(childbirthInfoPO, childbirthInfoVO);
						childbirthInfoService.create(childbirthInfoPO);
					}
					//获得分娩信息的id
					String childbirthid = childbirthByBasicId.getId();
					//获得分娩地点
					String childbirthPlace = childbirthInfoVO.getChildbirthPlace();
					String[] split = childbirthPlace.split(",");
					childbirthInfoVO.setChildbirthPlace(split[0]);
					
					childbirthInfoVO.setId(childbirthid);
					childbirthInfoVO.setBasicId(id2);
					BeanUtils.copyProperties(childbirthByBasicId, childbirthInfoVO);
					childbirthInfoService.update(childbirthByBasicId);
					
					
					//获取转诊信息通过分娩信息的id
					ChildbirthReferralInfoPO ChildbirthReferral = childbirthReferralInfoService.findByChildBirthInfoId(id2); 
					
					//获取转诊信息的id
						if(ChildbirthReferral !=null){
						String ReferralId = ChildbirthReferral.getId();
						
						
						String referral = childbirthReferralInfoVO.getReferral();
						//当转诊标识为1，确认转诊时
						if(referral.equals("1")){
							String idde =(String) reqs.get("department");
							String mechanism =(String) reqs.get("mechanism");
							
							//将转诊标识设置为分娩转诊
							birthArchivesByArchivesId.setReferralSign("2");
							
							birthArchivesByArchivesId.setInHospitalId(idde);
							birthArchivesByArchivesId.setDeltetSign("1");
							birthArchivesByArchivesId.setPregnantState("1");
							
							birthArchivesInfoService.update(birthArchivesByArchivesId);
							childbirthReferralInfoVO.setId(ReferralId);
							childbirthReferralInfoVO.setBasicId(id2);
						BeanUtils.copyProperties(ChildbirthReferral, childbirthReferralInfoVO);
						childbirthReferralInfoService.update(ChildbirthReferral);
						}
					
					//当没有转诊时
							if(referral.equals("0")){
								
								BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
								birthArchivesInfoPO.setReferralSign("0");
								birthArchivesInfoPO.setDeltetSign("1");
								birthArchivesInfoPO.setPregnantState("1");
								birthArchivesInfoService.update(birthArchivesInfoPO);
							}
					}
						if(ChildbirthReferral ==null){
							String ReferralId = IdUtil.uuid();
							
							String referral = childbirthReferralInfoVO.getReferral();
							//当转诊标识为1，确认转诊时
							if(referral.equals("1")){
								String idde =(String) reqs.get("department");
								String mechanism =(String) reqs.get("mechanism");
								
								//将转诊标识设置为分娩转诊
								birthArchivesByArchivesId.setReferralSign("2");
								birthArchivesByArchivesId.setPredictDate(new Date());
								birthArchivesByArchivesId.setInHospitalId(idde);
								birthArchivesByArchivesId.setDeltetSign("1");
								
								birthArchivesByArchivesId.setPregnantState("1");
								
								
								birthArchivesInfoService.update(birthArchivesByArchivesId);
							ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
							childbirthReferralInfoVO.setId(ReferralId);
							childbirthReferralInfoVO.setBasicId(id2);
							BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
							childbirthReferralInfoService.create(childbirthReferralInfoPO);
							}
						
						//当没有转诊时
								if(referral.equals("0")){
									
									BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
									birthArchivesInfoPO.setReferralSign("0");
									birthArchivesByArchivesId.setDeltetSign("1");
									
									birthArchivesByArchivesId.setPregnantState("1");
									
									
									birthArchivesInfoService.update(birthArchivesByArchivesId);
									
									
								}
						}
					//获取分娩婴儿信息 通过分娩信息id
					List<ChildbirthBabyInfoPO> babyInfo= childbirthBabyInfoService.getBabyInfoByChildbirthId(childbirthid);
					if(babyInfo.size() !=0){
						

						String acrid0 =(String) reqs.get("acrid0");
						String acrid1 =(String) reqs.get("acrid1");
						String acrid2 =(String) reqs.get("acrid2");
						String acrid3 =(String) reqs.get("acrid3");
						String acrid4 =(String) reqs.get("acrid4");
						String acrid5 =(String) reqs.get("acrid5");
						String acrid6 =(String) reqs.get("acrid6");

						String babyName0 =(String) reqs.get("babyName");
						String babyName1 =(String) reqs.get("babyName1");
						String babyName2 =(String) reqs.get("babyName2");
						String babyName3 =(String) reqs.get("babyName3");
						String babyName4 =(String) reqs.get("babyName4");
						String babyName5 =(String) reqs.get("babyName5");
						String babyName6 =(String) reqs.get("babyName6");
						
						for(int i=0;i<babyInfo.size();i++){
							ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);

							
							
							//获得婴儿的id
							String childbirthBabyId= childbirthBabyInfoPO.getId();
							
							
							//获得婴儿的名字
							String babyName = childbirthBabyInfoPO.getBabyName();
							
							if(childbirthBabyId.equals(acrid0)){
								
								
								//修改第一个婴儿信息
								String deliveryType0 =(String) reqs.get("deliveryType");
								
								if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition =(String) reqs.get("fetusPosition");
								String deliveryHour =(String) reqs.get("deliveryHour");
								String deliveryMinute =(String) reqs.get("deliveryMinute");
								String inducelabour =(String) reqs.get("inducelabour");
								String cesareanIdicatio =(String) reqs.get("cesareanIdicatio");
								String babySex =(String) reqs.get("babySex");
								String health =(String) reqs.get("health");
								String fetalAnomaly =(String) reqs.get("fetalAnomaly");
								String abnormalPosition =(String) reqs.get("abnormalPosition");
								String abnormalName =(String) reqs.get("abnormalName");
								String oneMinScore =(String) reqs.get("oneMinScore");
								String fiveMinScore =(String) reqs.get("fiveMinScore");
								String bornWeight =(String) reqs.get("bornWeight");
								//String vaccine =(String) reqs.get("vaccine");
								String fetusDie =(String) reqs.get("fetusDie");
								String midwife =(String) reqs.get("midwife");
								
								childbirthBabyInfoVO.setFetusPosition(fetusPosition);
								childbirthBabyInfoVO.setBabyName(babyName0);
								childbirthBabyInfoVO.setAbnormalName(abnormalName);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
								childbirthBabyInfoVO.setBabySex(babySex);
								childbirthBabyInfoVO.setBodyLenght(bornWeight);
								childbirthBabyInfoVO.setBornWeight(bornWeight);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
								childbirthBabyInfoVO.setDeliveryType(deliveryType0);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
								childbirthBabyInfoVO.setFetusDie(fetusDie);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
								childbirthBabyInfoVO.setHealth(health);
								childbirthBabyInfoVO.setId(id3);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour);
								childbirthBabyInfoVO.setMidwife(midwife);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore);
								//childbirthBabyInfoVO.setVaccine(vaccine);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
							
							
							
							if(childbirthBabyId.equals(acrid1)){
								
								
								//修改第一个婴儿信息
								String deliveryType1 =(String) reqs.get("deliveryType1");
								
								if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition =(String) reqs.get("fetusPosition1");
								String deliveryHour =(String) reqs.get("deliveryHour1");
								String deliveryMinute =(String) reqs.get("deliveryMinute1");
								String inducelabour =(String) reqs.get("inducelabour1");
								String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
								String babySex =(String) reqs.get("babySex1");
								String health =(String) reqs.get("health1");
								String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
								String abnormalPosition =(String) reqs.get("abnormalPosition1");
								String abnormalName =(String) reqs.get("abnormalName1");
								String oneMinScore =(String) reqs.get("oneMinScore1");
								String fiveMinScore =(String) reqs.get("fiveMinScore1");
								String bornWeight =(String) reqs.get("bornWeight1");
								String vaccine =(String) reqs.get("babyVaccine1");
								String fetusDie =(String) reqs.get("fetusDie1");
								String midwife =(String) reqs.get("midwife1");
								
								childbirthBabyInfoVO.setFetusPosition(fetusPosition);
								childbirthBabyInfoVO.setBabyName(babyName1);
								childbirthBabyInfoVO.setAbnormalName(abnormalName);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
								childbirthBabyInfoVO.setBabySex(babySex);
								childbirthBabyInfoVO.setBodyLenght(bornWeight);
								childbirthBabyInfoVO.setBornWeight(bornWeight);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
								childbirthBabyInfoVO.setDeliveryType(deliveryType1);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
								childbirthBabyInfoVO.setFetusDie(fetusDie);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
								childbirthBabyInfoVO.setHealth(health);
								childbirthBabyInfoVO.setId(acrid1);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour);
								childbirthBabyInfoVO.setMidwife(midwife);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore);
								childbirthBabyInfoVO.setVaccine(vaccine);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
							if(childbirthBabyId.equals(acrid2)){
								
								
								//修改第二个婴儿信息
								String deliveryType2 =(String) reqs.get("deliveryType2");
								
								if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition2 =(String) reqs.get("fetusPosition2");
								String deliveryHour2 =(String) reqs.get("deliveryHour2");
								String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
								String inducelabour2 =(String) reqs.get("inducelabour2");
								String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
								String babySex2 =(String) reqs.get("babySex2");
								String health2 =(String) reqs.get("health2");
								String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
								String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
								String abnormalName2 =(String) reqs.get("abnormalName2");
								String oneMinScore2 =(String) reqs.get("oneMinScore2");
								String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
								String bornWeight2 =(String) reqs.get("bornWeight2");
								String vaccine2 =(String) reqs.get("babyVaccine2");
								String fetusDie2 =(String) reqs.get("fetusDie2");
								String midwife2 =(String) reqs.get("midwife2");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
								childbirthBabyInfoVO.setBabyName(babyName2);
								childbirthBabyInfoVO.setAbnormalName(abnormalName2);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
								childbirthBabyInfoVO.setBabySex(babySex2);
								childbirthBabyInfoVO.setBodyLenght(bornWeight2);
								childbirthBabyInfoVO.setBornWeight(bornWeight2);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
								childbirthBabyInfoVO.setDeliveryType(deliveryType2);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
								childbirthBabyInfoVO.setFetusDie(fetusDie2);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
								childbirthBabyInfoVO.setHealth(health2);
								childbirthBabyInfoVO.setId(acrid2);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour2);
								childbirthBabyInfoVO.setMidwife(midwife2);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
								childbirthBabyInfoVO.setVaccine(vaccine2);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
						
										
										
										
										
								if(childbirthBabyId.equals(acrid3)){
								
								
								//修改第三个婴儿信息
								String deliveryType3 =(String) reqs.get("deliveryType3");
								
								if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition3 =(String) reqs.get("fetusPosition3");
								String deliveryHour3 =(String) reqs.get("deliveryHour3");
								String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
								String inducelabour3 =(String) reqs.get("inducelabour3");
								String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
								String babySex3 =(String) reqs.get("babySex3");
								String health3 =(String) reqs.get("health3");
								String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
								String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
								String abnormalName3 =(String) reqs.get("abnormalName3");
								String oneMinScore3 =(String) reqs.get("oneMinScore3");
								String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
								String bornWeight3 =(String) reqs.get("bornWeight3");
								String vaccine3 =(String) reqs.get("babyVaccine3");
								String fetusDie3 =(String) reqs.get("fetusDie3");
								String midwife3 =(String) reqs.get("midwife3");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
								childbirthBabyInfoVO.setBabyName(babyName3);
								childbirthBabyInfoVO.setAbnormalName(abnormalName3);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
								childbirthBabyInfoVO.setBabySex(babySex3);
								childbirthBabyInfoVO.setBodyLenght(bornWeight3);
								childbirthBabyInfoVO.setBornWeight(bornWeight3);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
								childbirthBabyInfoVO.setDeliveryType(deliveryType3);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
								childbirthBabyInfoVO.setFetusDie(fetusDie3);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
								childbirthBabyInfoVO.setHealth(health3);
								childbirthBabyInfoVO.setId(acrid3);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour3);
								childbirthBabyInfoVO.setMidwife(midwife3);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
								childbirthBabyInfoVO.setVaccine(vaccine3);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
								if(childbirthBabyId.equals(acrid4)){
									
									
									//修改第四个婴儿信息
									String deliveryType4 =(String) reqs.get("deliveryType4");
									
									if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
									
									String id3 = childbirthBabyInfoPO.getId();
									String fetusPosition4 =(String) reqs.get("fetusPosition4");
									String deliveryHour4 =(String) reqs.get("deliveryHour4");
									String inducelabour4 =(String) reqs.get("inducelabour4");
									String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
									String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
									String babySex4 =(String) reqs.get("babySex4");
									String health4 =(String) reqs.get("health4");
									String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
									String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
									String abnormalName4 =(String) reqs.get("abnormalName4");
									String oneMinScore4 =(String) reqs.get("oneMinScore4");
									String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
									String bornWeight4 =(String) reqs.get("bornWeight4");
									String vaccine4 =(String) reqs.get("babyVaccine4");
									String fetusDie4 =(String) reqs.get("fetusDie4");
									String midwife4 =(String) reqs.get("midwife4");
							
									childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
									childbirthBabyInfoVO.setBabyName(babyName4);
									childbirthBabyInfoVO.setAbnormalName(abnormalName4);
									childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
									childbirthBabyInfoVO.setBabySex(babySex4);
									childbirthBabyInfoVO.setBodyLenght(bornWeight4);
									childbirthBabyInfoVO.setBornWeight(bornWeight4);
									childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
									childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
									childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
									childbirthBabyInfoVO.setDeliveryType(deliveryType4);
									childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
									childbirthBabyInfoVO.setFetusDie(fetusDie4);
									childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
									childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
									childbirthBabyInfoVO.setHealth(health4);
									childbirthBabyInfoVO.setId(acrid4);
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
									childbirthBabyInfoVO.setInducelabour(inducelabour4);
									childbirthBabyInfoVO.setMidwife(midwife4);
									childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
									childbirthBabyInfoVO.setVaccine(vaccine4);
									BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
									childbirthBabyInfoService.update(childbirthBabyInfoPO);
									}
								}			
									if(childbirthBabyId.equals(acrid5)){
									
									
									//修改第五个婴儿信息
									String deliveryType5 =(String) reqs.get("deliveryType5");
									
									if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
									
									String id3 = childbirthBabyInfoPO.getId();
									String fetusPosition5 =(String) reqs.get("fetusPosition5");
									String deliveryHour5 =(String) reqs.get("deliveryHour5");
									String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
									String inducelabour5 =(String) reqs.get("inducelabour5");
									String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
									String babySex5 =(String) reqs.get("babySex5");
									String health5 =(String) reqs.get("health5");
									String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
									String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
									String abnormalName5 =(String) reqs.get("abnormalName5");
									String oneMinScore5 =(String) reqs.get("oneMinScore5");
									String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
									String bornWeight5 =(String) reqs.get("bornWeight5");
									String vaccine5 =(String) reqs.get("babyVaccine5");
									String fetusDie5 =(String) reqs.get("fetusDie5");
									String midwife5 =(String) reqs.get("midwife5");
							
									childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
									childbirthBabyInfoVO.setBabyName(babyName5);
									childbirthBabyInfoVO.setAbnormalName(abnormalName5);
									childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
									childbirthBabyInfoVO.setBabySex(babySex5);
									childbirthBabyInfoVO.setBodyLenght(bornWeight5);
									childbirthBabyInfoVO.setBornWeight(bornWeight5);
									childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
									childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
									childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
									childbirthBabyInfoVO.setDeliveryType(deliveryType5);
									childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
									childbirthBabyInfoVO.setFetusDie(fetusDie5);
									childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
									childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
									childbirthBabyInfoVO.setHealth(health5);
									childbirthBabyInfoVO.setId(acrid5);
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
									childbirthBabyInfoVO.setInducelabour(inducelabour5);
									childbirthBabyInfoVO.setMidwife(midwife5);
									childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
									childbirthBabyInfoVO.setVaccine(vaccine5);
									BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
									childbirthBabyInfoService.update(childbirthBabyInfoPO);
									}
								}
									
									if(childbirthBabyId.equals(acrid6)){
										
										
										//修改第七个婴儿信息
										String deliveryType6 =(String) reqs.get("deliveryType6");
										
										if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
										
										
										String fetusPosition6 =(String) reqs.get("fetusPosition6");
										String deliveryHour6 =(String) reqs.get("deliveryHour6");
										String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
										String inducelabour6 =(String) reqs.get("inducelabour6");
										String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
										String babySex6 =(String) reqs.get("babySex6");
										String health6 =(String) reqs.get("health6");
										String fetalAnomaly6=(String) reqs.get("fetalAnomaly6");
										String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
										String abnormalName6 =(String) reqs.get("abnormalName6");
										String oneMinScore6 =(String) reqs.get("oneMinScore6");
										String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
										String bornWeight6 =(String) reqs.get("bornWeight6");
										String vaccine6 =(String) reqs.get("babyVaccine6");
										String fetusDie6 =(String) reqs.get("fetusDie6");
										String midwife6 =(String) reqs.get("midwife6");
								
										childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
										childbirthBabyInfoVO.setBabyName(babyName6);
										childbirthBabyInfoVO.setAbnormalName(abnormalName6);
										childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
										childbirthBabyInfoVO.setBabySex(babySex6);
										childbirthBabyInfoVO.setBodyLenght(bornWeight6);
										childbirthBabyInfoVO.setBornWeight(bornWeight6);
										childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
										childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
										childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
										childbirthBabyInfoVO.setDeliveryType(deliveryType6);
										childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
										childbirthBabyInfoVO.setFetusDie(fetusDie6);
										childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
										childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
										childbirthBabyInfoVO.setHealth(health6);
										childbirthBabyInfoVO.setId(acrid6);
										childbirthBabyInfoVO.setChildbirthId(childbirthid);
										childbirthBabyInfoVO.setInducelabour(inducelabour6);
										childbirthBabyInfoVO.setMidwife(midwife6);
										childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
										childbirthBabyInfoVO.setVaccine(vaccine6);
										BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
										childbirthBabyInfoService.update(childbirthBabyInfoPO);
										}
									}
								}
						
						ChildbirthBabyInfoPO childbirthBaby=new ChildbirthBabyInfoPO();
						if(acrid0==null||acrid0==""){
							//修改第一个婴儿信息
							String deliveryType0 =(String) reqs.get("deliveryType");
							if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
							String id=IdUtil.uuid();
							childbirthBabyInfoVO.setId(id);	
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid1==null ||acrid1==""){
							//修改第一个婴儿信息
							String deliveryType1 =(String) reqs.get("deliveryType1");
							
							if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition =(String) reqs.get("fetusPosition1");
							String deliveryHour =(String) reqs.get("deliveryHour1");
							String deliveryMinute =(String) reqs.get("deliveryMinute1");
							String inducelabour =(String) reqs.get("inducelabour1");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
							String babySex =(String) reqs.get("babySex1");
							String health =(String) reqs.get("health1");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
							String abnormalPosition =(String) reqs.get("abnormalPosition1");
							String abnormalName =(String) reqs.get("abnormalName1");
							String oneMinScore =(String) reqs.get("oneMinScore1");
							String fiveMinScore =(String) reqs.get("fiveMinScore1");
							String bornWeight =(String) reqs.get("bornWeight1");
							String vaccine =(String) reqs.get("babyVaccine1");
							String fetusDie =(String) reqs.get("fetusDie1");
							String midwife =(String) reqs.get("midwife1");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName1);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType1);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid2==null||acrid2==""){
							//修改第二个婴儿信息
							String deliveryType2 =(String) reqs.get("deliveryType2");
							
							if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition2 =(String) reqs.get("fetusPosition2");
							String deliveryHour2 =(String) reqs.get("deliveryHour2");
							String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
							String inducelabour2 =(String) reqs.get("inducelabour2");
							String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
							String babySex2 =(String) reqs.get("babySex2");
							String health2 =(String) reqs.get("health2");
							String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
							String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
							String abnormalName2 =(String) reqs.get("abnormalName2");
							String oneMinScore2 =(String) reqs.get("oneMinScore2");
							String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
							String bornWeight2 =(String) reqs.get("bornWeight2");
							String vaccine2 =(String) reqs.get("babyVaccine2");
							String fetusDie2 =(String) reqs.get("fetusDie2");
							String midwife2 =(String) reqs.get("midwife2");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setBabyName(babyName2);
							childbirthBabyInfoVO.setAbnormalName(abnormalName2);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
							childbirthBabyInfoVO.setBabySex(babySex2);
							childbirthBabyInfoVO.setBodyLenght(bornWeight2);
							childbirthBabyInfoVO.setBornWeight(bornWeight2);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
							childbirthBabyInfoVO.setDeliveryType(deliveryType2);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
							childbirthBabyInfoVO.setFetusDie(fetusDie2);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
							childbirthBabyInfoVO.setHealth(health2);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour2);
							childbirthBabyInfoVO.setMidwife(midwife2);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
							childbirthBabyInfoVO.setVaccine(vaccine2);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						
						if(acrid3==null||acrid3==""){
							//修改第三个婴儿信息
							String deliveryType3 =(String) reqs.get("deliveryType3");
							
							if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition3 =(String) reqs.get("fetusPosition3");
							String deliveryHour3 =(String) reqs.get("deliveryHour3");
							String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
							String inducelabour3 =(String) reqs.get("inducelabour3");
							String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
							String babySex3 =(String) reqs.get("babySex3");
							String health3 =(String) reqs.get("health3");
							String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
							String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
							String abnormalName3 =(String) reqs.get("abnormalName3");
							String oneMinScore3 =(String) reqs.get("oneMinScore3");
							String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
							String bornWeight3 =(String) reqs.get("bornWeight3");
							String vaccine3 =(String) reqs.get("babyVaccine3");
							String fetusDie3 =(String) reqs.get("fetusDie3");
							String midwife3 =(String) reqs.get("midwife3");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setBabyName(babyName3);
							childbirthBabyInfoVO.setAbnormalName(abnormalName3);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
							childbirthBabyInfoVO.setBabySex(babySex3);
							childbirthBabyInfoVO.setBodyLenght(bornWeight3);
							childbirthBabyInfoVO.setBornWeight(bornWeight3);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
							childbirthBabyInfoVO.setDeliveryType(deliveryType3);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
							childbirthBabyInfoVO.setFetusDie(fetusDie3);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
							childbirthBabyInfoVO.setHealth(health3);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour3);
							childbirthBabyInfoVO.setMidwife(midwife3);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
							childbirthBabyInfoVO.setVaccine(vaccine3);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							
							}
						}
						if(acrid4==null||acrid4==""){
							//修改第四个婴儿信息
							String deliveryType4 =(String) reqs.get("deliveryType4");
							
							if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition4 =(String) reqs.get("fetusPosition4");
							String deliveryHour4 =(String) reqs.get("deliveryHour4");
							String inducelabour4 =(String) reqs.get("inducelabour4");
							String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
							String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
							String babySex4 =(String) reqs.get("babySex4");
							String health4 =(String) reqs.get("health4");
							String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
							String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
							String abnormalName4 =(String) reqs.get("abnormalName4");
							String oneMinScore4 =(String) reqs.get("oneMinScore4");
							String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
							String bornWeight4 =(String) reqs.get("bornWeight4");
							String vaccine4 =(String) reqs.get("babyVaccine4");
							String fetusDie4 =(String) reqs.get("fetusDie4");
							String midwife4 =(String) reqs.get("midwife4");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setBabyName(babyName4);
							childbirthBabyInfoVO.setAbnormalName(abnormalName4);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
							childbirthBabyInfoVO.setBabySex(babySex4);
							childbirthBabyInfoVO.setBodyLenght(bornWeight4);
							childbirthBabyInfoVO.setBornWeight(bornWeight4);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
							childbirthBabyInfoVO.setDeliveryType(deliveryType4);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
							childbirthBabyInfoVO.setFetusDie(fetusDie4);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
							childbirthBabyInfoVO.setHealth(health4);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour4);
							childbirthBabyInfoVO.setMidwife(midwife4);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
							childbirthBabyInfoVO.setVaccine(vaccine4);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid5==null||acrid5==""){
							//修改第五个婴儿信息
							String deliveryType5 =(String) reqs.get("deliveryType5");
							
							if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition5 =(String) reqs.get("fetusPosition5");
							String deliveryHour5 =(String) reqs.get("deliveryHour5");
							String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
							String inducelabour5 =(String) reqs.get("inducelabour5");
							String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
							String babySex5 =(String) reqs.get("babySex5");
							String health5 =(String) reqs.get("health5");
							String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
							String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
							String abnormalName5 =(String) reqs.get("abnormalName5");
							String oneMinScore5 =(String) reqs.get("oneMinScore5");
							String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
							String bornWeight5 =(String) reqs.get("bornWeight5");
							String vaccine5 =(String) reqs.get("babyVaccine5");
							String fetusDie5 =(String) reqs.get("fetusDie5");
							String midwife5 =(String) reqs.get("midwife5");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setBabyName(babyName5);
							childbirthBabyInfoVO.setAbnormalName(abnormalName5);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
							childbirthBabyInfoVO.setBabySex(babySex5);
							childbirthBabyInfoVO.setBodyLenght(bornWeight5);
							childbirthBabyInfoVO.setBornWeight(bornWeight5);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
							childbirthBabyInfoVO.setDeliveryType(deliveryType5);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
							childbirthBabyInfoVO.setFetusDie(fetusDie5);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
							childbirthBabyInfoVO.setHealth(health5);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour5);
							childbirthBabyInfoVO.setMidwife(midwife5);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
							childbirthBabyInfoVO.setVaccine(vaccine5);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
						if(acrid6==null||acrid6==""){
							//修改第五个婴儿信息
							String deliveryType6 =(String) reqs.get("deliveryType6");
							
							if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition6 =(String) reqs.get("fetusPosition6");
							String deliveryHour6 =(String) reqs.get("deliveryHour6");
							String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
							String inducelabour6 =(String) reqs.get("inducelabour6");
							String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
							String babySex6 =(String) reqs.get("babySex6");
							String health6 =(String) reqs.get("health6");
							String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
							String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
							String abnormalName6 =(String) reqs.get("abnormalName6");
							String oneMinScore6 =(String) reqs.get("oneMinScore6");
							String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
							String bornWeight6=(String) reqs.get("bornWeight6");
							String vaccine6 =(String) reqs.get("babyVaccine6");
							String fetusDie6 =(String) reqs.get("fetusDie6");
							String midwife6 =(String) reqs.get("midwife6");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setBabyName(babyName6);
							childbirthBabyInfoVO.setAbnormalName(abnormalName6);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
							childbirthBabyInfoVO.setBabySex(babySex6);
							childbirthBabyInfoVO.setBodyLenght(bornWeight6);
							childbirthBabyInfoVO.setBornWeight(bornWeight6);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
							childbirthBabyInfoVO.setDeliveryType(deliveryType6);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
							childbirthBabyInfoVO.setFetusDie(fetusDie6);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
							childbirthBabyInfoVO.setHealth(health6);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour6);
							childbirthBabyInfoVO.setMidwife(midwife6);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
							childbirthBabyInfoVO.setVaccine(vaccine6);
							BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBaby);
							}
						}
					}
					
					if(babyInfo.size() ==0){
						String acrid0 =(String) reqs.get("acrid0");
						String acrid1 =(String) reqs.get("acrid1");
						String acrid2 =(String) reqs.get("acrid2");
						String acrid3 =(String) reqs.get("acrid3");
						String acrid4 =(String) reqs.get("acrid4");
						String acrid5 =(String) reqs.get("acrid5");
						String acrid6 =(String) reqs.get("acrid6");
						
						
						//获得婴儿的名字
						String babyName0 =(String) reqs.get("babyName");
						String babyName1 =(String) reqs.get("babyName1");
						String babyName2 =(String) reqs.get("babyName2");
						String babyName3 =(String) reqs.get("babyName3");
						String babyName4 =(String) reqs.get("babyName4");
						String babyName5 =(String) reqs.get("babyName5");
						String babyName6 =(String) reqs.get("babyName6");
						
						ChildbirthBabyInfoPO childbirthBabyInfoPO= new ChildbirthBabyInfoPO();
						
						if(acrid0==null||acrid0==""){
							//修改第一个婴儿信息
							String deliveryType0 =(String) reqs.get("deliveryType");
							
							if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
							String id=IdUtil.uuid();
							childbirthBabyInfoVO.setId(id);	
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid1==null ||acrid1==""){
							//修改第一个婴儿信息
							String deliveryType1 =(String) reqs.get("deliveryType1");
							
							if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition =(String) reqs.get("fetusPosition1");
							String deliveryHour =(String) reqs.get("deliveryHour1");
							String deliveryMinute =(String) reqs.get("deliveryMinute1");
							String inducelabour =(String) reqs.get("inducelabour1");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
							String babySex =(String) reqs.get("babySex1");
							String health =(String) reqs.get("health1");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
							String abnormalPosition =(String) reqs.get("abnormalPosition1");
							String abnormalName =(String) reqs.get("abnormalName1");
							String oneMinScore =(String) reqs.get("oneMinScore1");
							String fiveMinScore =(String) reqs.get("fiveMinScore1");
							String bornWeight =(String) reqs.get("bornWeight1");
							String vaccine =(String) reqs.get("babyVaccine1");
							String fetusDie =(String) reqs.get("fetusDie1");
							String midwife =(String) reqs.get("midwife1");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName1);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType1);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid2==null||acrid2==""){
							//修改第二个婴儿信息
							String deliveryType2 =(String) reqs.get("deliveryType2");
							
							if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition2 =(String) reqs.get("fetusPosition2");
							String deliveryHour2 =(String) reqs.get("deliveryHour2");
							String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
							String inducelabour2 =(String) reqs.get("inducelabour2");
							String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
							String babySex2 =(String) reqs.get("babySex2");
							String health2 =(String) reqs.get("health2");
							String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
							String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
							String abnormalName2 =(String) reqs.get("abnormalName2");
							String oneMinScore2 =(String) reqs.get("oneMinScore2");
							String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
							String bornWeight2 =(String) reqs.get("bornWeight2");
							String vaccine2 =(String) reqs.get("babyVaccine2");
							String fetusDie2 =(String) reqs.get("fetusDie2");
							String midwife2 =(String) reqs.get("midwife2");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setBabyName(babyName2);
							childbirthBabyInfoVO.setAbnormalName(abnormalName2);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
							childbirthBabyInfoVO.setBabySex(babySex2);
							childbirthBabyInfoVO.setBodyLenght(bornWeight2);
							childbirthBabyInfoVO.setBornWeight(bornWeight2);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
							childbirthBabyInfoVO.setDeliveryType(deliveryType2);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
							childbirthBabyInfoVO.setFetusDie(fetusDie2);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
							childbirthBabyInfoVO.setHealth(health2);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour2);
							childbirthBabyInfoVO.setMidwife(midwife2);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
							childbirthBabyInfoVO.setVaccine(vaccine2);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						
						if(acrid3==null||acrid3==""){
							//修改第三个婴儿信息
							String deliveryType3 =(String) reqs.get("deliveryType3");
							
							if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition3 =(String) reqs.get("fetusPosition3");
							String deliveryHour3 =(String) reqs.get("deliveryHour3");
							String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
							String inducelabour3 =(String) reqs.get("inducelabour3");
							String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
							String babySex3 =(String) reqs.get("babySex3");
							String health3 =(String) reqs.get("health3");
							String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
							String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
							String abnormalName3 =(String) reqs.get("abnormalName3");
							String oneMinScore3 =(String) reqs.get("oneMinScore3");
							String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
							String bornWeight3 =(String) reqs.get("bornWeight3");
							String vaccine3 =(String) reqs.get("babyVaccine3");
							String fetusDie3 =(String) reqs.get("fetusDie3");
							String midwife3 =(String) reqs.get("midwife3");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setBabyName(babyName3);
							childbirthBabyInfoVO.setAbnormalName(abnormalName3);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
							childbirthBabyInfoVO.setBabySex(babySex3);
							childbirthBabyInfoVO.setBodyLenght(bornWeight3);
							childbirthBabyInfoVO.setBornWeight(bornWeight3);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
							childbirthBabyInfoVO.setDeliveryType(deliveryType3);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
							childbirthBabyInfoVO.setFetusDie(fetusDie3);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
							childbirthBabyInfoVO.setHealth(health3);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour3);
							childbirthBabyInfoVO.setMidwife(midwife3);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
							childbirthBabyInfoVO.setVaccine(vaccine3);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							
							}
						}
						if(acrid4==null||acrid4==""){
							//修改第四个婴儿信息
							String deliveryType4 =(String) reqs.get("deliveryType4");
							
							if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition4 =(String) reqs.get("fetusPosition4");
							String deliveryHour4 =(String) reqs.get("deliveryHour4");
							String inducelabour4 =(String) reqs.get("inducelabour4");
							String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
							String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
							String babySex4 =(String) reqs.get("babySex4");
							String health4 =(String) reqs.get("health4");
							String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
							String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
							String abnormalName4 =(String) reqs.get("abnormalName4");
							String oneMinScore4 =(String) reqs.get("oneMinScore4");
							String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
							String bornWeight4 =(String) reqs.get("bornWeight4");
							String vaccine4 =(String) reqs.get("babyVaccine4");
							String fetusDie4 =(String) reqs.get("fetusDie4");
							String midwife4 =(String) reqs.get("midwife4");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setBabyName(babyName4);
							childbirthBabyInfoVO.setAbnormalName(abnormalName4);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
							childbirthBabyInfoVO.setBabySex(babySex4);
							childbirthBabyInfoVO.setBodyLenght(bornWeight4);
							childbirthBabyInfoVO.setBornWeight(bornWeight4);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
							childbirthBabyInfoVO.setDeliveryType(deliveryType4);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
							childbirthBabyInfoVO.setFetusDie(fetusDie4);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
							childbirthBabyInfoVO.setHealth(health4);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour4);
							childbirthBabyInfoVO.setMidwife(midwife4);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
							childbirthBabyInfoVO.setVaccine(vaccine4);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid5==null||acrid5==""){
							//修改第五个婴儿信息
							String deliveryType5 =(String) reqs.get("deliveryType5");
							
							if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition5 =(String) reqs.get("fetusPosition5");
							String deliveryHour5 =(String) reqs.get("deliveryHour5");
							String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
							String inducelabour5 =(String) reqs.get("inducelabour5");
							String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
							String babySex5 =(String) reqs.get("babySex5");
							String health5 =(String) reqs.get("health5");
							String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
							String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
							String abnormalName5 =(String) reqs.get("abnormalName5");
							String oneMinScore5 =(String) reqs.get("oneMinScore5");
							String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
							String bornWeight5 =(String) reqs.get("bornWeight5");
							String vaccine5 =(String) reqs.get("babyVaccine5");
							String fetusDie5 =(String) reqs.get("fetusDie5");
							String midwife5 =(String) reqs.get("midwife5");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setBabyName(babyName5);
							childbirthBabyInfoVO.setAbnormalName(abnormalName5);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
							childbirthBabyInfoVO.setBabySex(babySex5);
							childbirthBabyInfoVO.setBodyLenght(bornWeight5);
							childbirthBabyInfoVO.setBornWeight(bornWeight5);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
							childbirthBabyInfoVO.setDeliveryType(deliveryType5);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
							childbirthBabyInfoVO.setFetusDie(fetusDie5);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
							childbirthBabyInfoVO.setHealth(health5);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour5);
							childbirthBabyInfoVO.setMidwife(midwife5);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
							childbirthBabyInfoVO.setVaccine(vaccine5);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}
						if(acrid6==null||acrid6==""){
							//修改第五个婴儿信息
							String deliveryType6 =(String) reqs.get("deliveryType6");
							
							if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
							
							String id3 = IdUtil.uuid();
							String fetusPosition6 =(String) reqs.get("fetusPosition6");
							String deliveryHour6 =(String) reqs.get("deliveryHour6");
							String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
							String inducelabour6 =(String) reqs.get("inducelabour6");
							String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
							String babySex6 =(String) reqs.get("babySex6");
							String health6 =(String) reqs.get("health6");
							String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
							String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
							String abnormalName6 =(String) reqs.get("abnormalName6");
							String oneMinScore6 =(String) reqs.get("oneMinScore6");
							String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
							String bornWeight6=(String) reqs.get("bornWeight6");
							String vaccine6 =(String) reqs.get("babyVaccine6");
							String fetusDie6 =(String) reqs.get("fetusDie6");
							String midwife6 =(String) reqs.get("midwife6");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setBabyName(babyName6);
							childbirthBabyInfoVO.setAbnormalName(abnormalName6);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
							childbirthBabyInfoVO.setBabySex(babySex6);
							childbirthBabyInfoVO.setBodyLenght(bornWeight6);
							childbirthBabyInfoVO.setBornWeight(bornWeight6);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
							childbirthBabyInfoVO.setDeliveryType(deliveryType6);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
							childbirthBabyInfoVO.setFetusDie(fetusDie6);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
							childbirthBabyInfoVO.setHealth(health6);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour6);
							childbirthBabyInfoVO.setMidwife(midwife6);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
							childbirthBabyInfoVO.setVaccine(vaccine6);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.create(childbirthBabyInfoPO);
							}
						}	
						
						
					}
					
					
					//ModelAndView model = new ModelAndView("prenatal/prenatal_list");
					return model;
				}
				//获取基本信息的id
				String id2 = childbirthBasic.getId();
				
		
				String birthDate =(String) reqs.get("birthDate");
				String leaveDate =(String) reqs.get("leaveDate");
				String BasicCreateTime =(String) reqs.get("BasicCreateTime");
				SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
				
				if(BasicCreateTime !=null){
					Date createTime = formate.parse(BasicCreateTime);
					childbirthBasicInfoVO.setCreatTime(createTime);
					childbirthBasicInfoVO.setUpdateTime(new Date());
					childbirthBasicInfoVO.setNormalSign("0");
				}
				if(BasicCreateTime==null||BasicCreateTime==""){
					childbirthBasicInfoVO.setCreatTime(new Date());
					childbirthBasicInfoVO.setUpdateTime(new Date());
					childbirthBasicInfoVO.setNormalSign("1");
				}
				Date date = formate.parse(birthDate);
				Date leave = formate.parse(leaveDate);
				childbirthBasicInfoVO.setId(id2);
				childbirthBasicInfoVO.setBirthDate(date);
				childbirthBasicInfoVO.setLeaveDate(leave);
				childbirthBasicInfoVO.setEditStatus("1");
				childbirthBasicInfoVO.setBirthArchivesId(birthArchivesId);
				BeanUtils.copyProperties(childbirthBasic, childbirthBasicInfoVO);
				childbirthBasicInfoService.update(childbirthBasic);
				
				
				//查询分娩信息通过基本信息的id
				ChildbirthInfoPO childbirthByBasicId = childbirthInfoService.getChildbirthByBasicId(id2);
				//获得分娩信息的id
				String childbirthid = childbirthByBasicId.getId();
				childbirthInfoVO.setId(childbirthid);
				childbirthInfoVO.setBasicId(id2);
				
				//获得分娩地点
				String childbirthPlace = childbirthInfoVO.getChildbirthPlace();
				String[] split = childbirthPlace.split(",");
				childbirthInfoVO.setChildbirthPlace(split[0]);
				
				BeanUtils.copyProperties(childbirthByBasicId, childbirthInfoVO);
				childbirthInfoService.update(childbirthByBasicId);
				
				
				//获取转诊信息通过分娩信息的id
				ChildbirthReferralInfoPO ChildbirthReferral = childbirthReferralInfoService.findByChildBirthInfoId(id2); 
				
				//获取转诊信息的id
					if(ChildbirthReferral !=null){
					String ReferralId = ChildbirthReferral.getId();
					
					
					String referral = childbirthReferralInfoVO.getReferral();
					//当转诊标识为1，确认转诊时
					if(referral.equals("1")){
						String idde =(String) reqs.get("department");
						String mechanism =(String) reqs.get("mechanism");
						
						//将转诊标识设置为分娩转诊
						birthArchivesByArchivesId.setReferralSign("2");
						
						birthArchivesByArchivesId.setInHospitalId(idde);
						birthArchivesByArchivesId.setDeltetSign("1");
						birthArchivesByArchivesId.setPregnantState("1");
						
						birthArchivesInfoService.update(birthArchivesByArchivesId);
						childbirthReferralInfoVO.setId(ReferralId);
						childbirthReferralInfoVO.setBasicId(id2);
					BeanUtils.copyProperties(ChildbirthReferral, childbirthReferralInfoVO);
					childbirthReferralInfoService.update(ChildbirthReferral);
					}
				
				//当没有转诊时
						if(referral.equals("0")){
							
							BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
							birthArchivesInfoPO.setReferralSign("0");
							birthArchivesInfoPO.setDeltetSign("1");
							birthArchivesInfoPO.setPregnantState("1");
							birthArchivesInfoService.update(birthArchivesInfoPO);
						}
				}
					if(ChildbirthReferral ==null){
						String ReferralId = IdUtil.uuid();
						
						String referral = childbirthReferralInfoVO.getReferral();
						//当转诊标识为1，确认转诊时
						if(referral.equals("1")){
							String idde =(String) reqs.get("department");
							String mechanism =(String) reqs.get("mechanism");
							
							//将转诊标识设置为分娩转诊
							birthArchivesByArchivesId.setReferralSign("2");
							birthArchivesByArchivesId.setPredictDate(new Date());
							birthArchivesByArchivesId.setInHospitalId(idde);
							birthArchivesByArchivesId.setDeltetSign("1");
							
							birthArchivesByArchivesId.setPregnantState("1");
							
							
							birthArchivesInfoService.update(birthArchivesByArchivesId);
						ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
						childbirthReferralInfoVO.setId(ReferralId);
						childbirthReferralInfoVO.setBasicId(id2);
						BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
						childbirthReferralInfoService.create(childbirthReferralInfoPO);
						}
					
					//当没有转诊时
							if(referral.equals("0")){
								
								BirthArchivesInfoPO birthArchivesInfoPO = birthArchivesInfoService.findbirth(chid);
								birthArchivesInfoPO.setReferralSign("0");
								birthArchivesByArchivesId.setDeltetSign("1");
								
								birthArchivesByArchivesId.setPregnantState("1");
								
								
								birthArchivesInfoService.update(birthArchivesByArchivesId);
								
								
							}
					}
				//获取分娩婴儿信息 通过分娩信息id
				List<ChildbirthBabyInfoPO> babyInfo= childbirthBabyInfoService.getBabyInfoByChildbirthId(childbirthid);
				if(babyInfo.size() !=0){

					String acrid0 =(String) reqs.get("acrid0");
					String acrid1 =(String) reqs.get("acrid1");
					String acrid2 =(String) reqs.get("acrid2");
					String acrid3 =(String) reqs.get("acrid3");
					String acrid4 =(String) reqs.get("acrid4");
					String acrid5 =(String) reqs.get("acrid5");
					String acrid6 =(String) reqs.get("acrid6");
					
					
					String babyName0 =(String) reqs.get("babyName");
					String babyName1 =(String) reqs.get("babyName1");
					String babyName2 =(String) reqs.get("babyName2");
					String babyName3 =(String) reqs.get("babyName3");
					String babyName4 =(String) reqs.get("babyName4");
					String babyName5 =(String) reqs.get("babyName5");
					String babyName6 =(String) reqs.get("babyName6");
					
					for(int i=0;i<babyInfo.size();i++){
						ChildbirthBabyInfoPO childbirthBabyInfoPO = babyInfo.get(i);
						
						
						
						//获得婴儿的id
						String childbirthBabyId= childbirthBabyInfoPO.getId();
						
						//获得婴儿的名字
						String babyName = childbirthBabyInfoPO.getBabyName();
						
						if(childbirthBabyId.equals(acrid0)){
							
							
							//修改第一个婴儿信息
							String deliveryType0 =(String) reqs.get("deliveryType");
							
							if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition =(String) reqs.get("fetusPosition");
							String deliveryHour =(String) reqs.get("deliveryHour");
							String deliveryMinute =(String) reqs.get("deliveryMinute");
							String inducelabour =(String) reqs.get("inducelabour");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio");
							String babySex =(String) reqs.get("babySex");
							String health =(String) reqs.get("health");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly");
							String abnormalPosition =(String) reqs.get("abnormalPosition");
							String abnormalName =(String) reqs.get("abnormalName");
							String oneMinScore =(String) reqs.get("oneMinScore");
							String fiveMinScore =(String) reqs.get("fiveMinScore");
							String bornWeight =(String) reqs.get("bornWeight");
							//String vaccine =(String) reqs.get("vaccine");
							String fetusDie =(String) reqs.get("fetusDie");
							String midwife =(String) reqs.get("midwife");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName0);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType0);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(id3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							//childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}



						if(childbirthBabyId.equals(acrid1)){
							
							
							//修改第一个婴儿信息
							String deliveryType1 =(String) reqs.get("deliveryType1");
							
							if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition =(String) reqs.get("fetusPosition1");
							String deliveryHour =(String) reqs.get("deliveryHour1");
							String deliveryMinute =(String) reqs.get("deliveryMinute1");
							String inducelabour =(String) reqs.get("inducelabour1");
							String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
							String babySex =(String) reqs.get("babySex1");
							String health =(String) reqs.get("health1");
							String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
							String abnormalPosition =(String) reqs.get("abnormalPosition1");
							String abnormalName =(String) reqs.get("abnormalName1");
							String oneMinScore =(String) reqs.get("oneMinScore1");
							String fiveMinScore =(String) reqs.get("fiveMinScore1");
							String bornWeight =(String) reqs.get("bornWeight1");
							String vaccine =(String) reqs.get("babyVaccine1");
							String fetusDie =(String) reqs.get("fetusDie1");
							String midwife =(String) reqs.get("midwife1");
							
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setBabyName(babyName1);
							childbirthBabyInfoVO.setAbnormalName(abnormalName);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
							childbirthBabyInfoVO.setBabySex(babySex);
							childbirthBabyInfoVO.setBodyLenght(bornWeight);
							childbirthBabyInfoVO.setBornWeight(bornWeight);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
							childbirthBabyInfoVO.setDeliveryType(deliveryType1);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
							childbirthBabyInfoVO.setFetusDie(fetusDie);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
							childbirthBabyInfoVO.setHealth(health);
							childbirthBabyInfoVO.setId(acrid1);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour);
							childbirthBabyInfoVO.setMidwife(midwife);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore);
							childbirthBabyInfoVO.setVaccine(vaccine);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
						if(childbirthBabyId.equals(acrid2)){
							
							
							//修改第二个婴儿信息
							String deliveryType2 =(String) reqs.get("deliveryType2");
							
							if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition2 =(String) reqs.get("fetusPosition2");
							String deliveryHour2 =(String) reqs.get("deliveryHour2");
							String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
							String inducelabour2 =(String) reqs.get("inducelabour2");
							String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
							String babySex2 =(String) reqs.get("babySex2");
							String health2 =(String) reqs.get("health2");
							String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
							String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
							String abnormalName2 =(String) reqs.get("abnormalName2");
							String oneMinScore2 =(String) reqs.get("oneMinScore2");
							String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
							String bornWeight2 =(String) reqs.get("bornWeight2");
							String vaccine2 =(String) reqs.get("babyVaccine2");
							String fetusDie2 =(String) reqs.get("fetusDie2");
							String midwife2 =(String) reqs.get("midwife2");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setBabyName(babyName2);
							childbirthBabyInfoVO.setAbnormalName(abnormalName2);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
							childbirthBabyInfoVO.setBabySex(babySex2);
							childbirthBabyInfoVO.setBodyLenght(bornWeight2);
							childbirthBabyInfoVO.setBornWeight(bornWeight2);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
							childbirthBabyInfoVO.setDeliveryType(deliveryType2);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
							childbirthBabyInfoVO.setFetusDie(fetusDie2);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
							childbirthBabyInfoVO.setHealth(health2);
							childbirthBabyInfoVO.setId(acrid2);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour2);
							childbirthBabyInfoVO.setMidwife(midwife2);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
							childbirthBabyInfoVO.setVaccine(vaccine2);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
					
									
									
									
									
							if(childbirthBabyId.equals(acrid3)){
							
							
							//修改第三个婴儿信息
							String deliveryType3 =(String) reqs.get("deliveryType3");
							
							if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
							
							String id3 = childbirthBabyInfoPO.getId();
							String fetusPosition3 =(String) reqs.get("fetusPosition3");
							String deliveryHour3 =(String) reqs.get("deliveryHour3");
							String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
							String inducelabour3 =(String) reqs.get("inducelabour3");
							String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
							String babySex3 =(String) reqs.get("babySex3");
							String health3 =(String) reqs.get("health3");
							String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
							String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
							String abnormalName3 =(String) reqs.get("abnormalName3");
							String oneMinScore3 =(String) reqs.get("oneMinScore3");
							String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
							String bornWeight3 =(String) reqs.get("bornWeight3");
							String vaccine3 =(String) reqs.get("babyVaccine3");
							String fetusDie3 =(String) reqs.get("fetusDie3");
							String midwife3 =(String) reqs.get("midwife3");
					
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setBabyName(babyName3);
							childbirthBabyInfoVO.setAbnormalName(abnormalName3);
							childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
							childbirthBabyInfoVO.setBabySex(babySex3);
							childbirthBabyInfoVO.setBodyLenght(bornWeight3);
							childbirthBabyInfoVO.setBornWeight(bornWeight3);
							childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
							childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
							childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
							childbirthBabyInfoVO.setDeliveryType(deliveryType3);
							childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
							childbirthBabyInfoVO.setFetusDie(fetusDie3);
							childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
							childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
							childbirthBabyInfoVO.setHealth(health3);
							childbirthBabyInfoVO.setId(acrid3);
							childbirthBabyInfoVO.setChildbirthId(childbirthid);
							childbirthBabyInfoVO.setInducelabour(inducelabour3);
							childbirthBabyInfoVO.setMidwife(midwife3);
							childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
							childbirthBabyInfoVO.setVaccine(vaccine3);
							BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
							childbirthBabyInfoService.update(childbirthBabyInfoPO);
							}
						}
							if(childbirthBabyId.equals(acrid4)){
								
								
								//修改第四个婴儿信息
								String deliveryType4 =(String) reqs.get("deliveryType4");
								
								if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition4 =(String) reqs.get("fetusPosition4");
								String deliveryHour4 =(String) reqs.get("deliveryHour4");
								String inducelabour4 =(String) reqs.get("inducelabour4");
								String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
								String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
								String babySex4 =(String) reqs.get("babySex4");
								String health4 =(String) reqs.get("health4");
								String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
								String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
								String abnormalName4 =(String) reqs.get("abnormalName4");
								String oneMinScore4 =(String) reqs.get("oneMinScore4");
								String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
								String bornWeight4 =(String) reqs.get("bornWeight4");
								String vaccine4 =(String) reqs.get("babyVaccine4");
								String fetusDie4 =(String) reqs.get("fetusDie4");
								String midwife4 =(String) reqs.get("midwife4");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
								childbirthBabyInfoVO.setBabyName(babyName4);
								childbirthBabyInfoVO.setAbnormalName(abnormalName4);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
								childbirthBabyInfoVO.setBabySex(babySex4);
								childbirthBabyInfoVO.setBodyLenght(bornWeight4);
								childbirthBabyInfoVO.setBornWeight(bornWeight4);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
								childbirthBabyInfoVO.setDeliveryType(deliveryType4);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
								childbirthBabyInfoVO.setFetusDie(fetusDie4);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
								childbirthBabyInfoVO.setHealth(health4);
								childbirthBabyInfoVO.setId(acrid4);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour4);
								childbirthBabyInfoVO.setMidwife(midwife4);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
								childbirthBabyInfoVO.setVaccine(vaccine4);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}			
								if(childbirthBabyId.equals(acrid5)){
								
								
								//修改第五个婴儿信息
								String deliveryType5 =(String) reqs.get("deliveryType5");
								
								if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
								
								String id3 = childbirthBabyInfoPO.getId();
								String fetusPosition5 =(String) reqs.get("fetusPosition5");
								String deliveryHour5 =(String) reqs.get("deliveryHour5");
								String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
								String inducelabour5 =(String) reqs.get("inducelabour5");
								String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
								String babySex5 =(String) reqs.get("babySex5");
								String health5 =(String) reqs.get("health5");
								String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
								String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
								String abnormalName5 =(String) reqs.get("abnormalName5");
								String oneMinScore5 =(String) reqs.get("oneMinScore5");
								String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
								String bornWeight5 =(String) reqs.get("bornWeight5");
								String vaccine5 =(String) reqs.get("babyVaccine5");
								String fetusDie5 =(String) reqs.get("fetusDie5");
								String midwife5 =(String) reqs.get("midwife5");
						
								childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
								childbirthBabyInfoVO.setBabyName(babyName5);
								childbirthBabyInfoVO.setAbnormalName(abnormalName5);
								childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
								childbirthBabyInfoVO.setBabySex(babySex5);
								childbirthBabyInfoVO.setBodyLenght(bornWeight5);
								childbirthBabyInfoVO.setBornWeight(bornWeight5);
								childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
								childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
								childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
								childbirthBabyInfoVO.setDeliveryType(deliveryType5);
								childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
								childbirthBabyInfoVO.setFetusDie(fetusDie5);
								childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
								childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
								childbirthBabyInfoVO.setHealth(health5);
								childbirthBabyInfoVO.setId(acrid5);
								childbirthBabyInfoVO.setChildbirthId(childbirthid);
								childbirthBabyInfoVO.setInducelabour(inducelabour5);
								childbirthBabyInfoVO.setMidwife(midwife5);
								childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
								childbirthBabyInfoVO.setVaccine(vaccine5);
								BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
								childbirthBabyInfoService.update(childbirthBabyInfoPO);
								}
							}
								if(childbirthBabyId.equals(acrid6)){
									
									
									//修改第五个婴儿信息
									String deliveryType6 =(String) reqs.get("deliveryType6");
									
									if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
									
									String id3 = childbirthBabyInfoPO.getId();
									String fetusPosition6 =(String) reqs.get("fetusPosition6");
									String deliveryHour6 =(String) reqs.get("deliveryHour6");
									String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
									String inducelabour6 =(String) reqs.get("inducelabour6");
									String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
									String babySex6 =(String) reqs.get("babySex6");
									String health6 =(String) reqs.get("health6");
									String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
									String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
									String abnormalName6 =(String) reqs.get("abnormalName6");
									String oneMinScore6 =(String) reqs.get("oneMinScore6");
									String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
									String bornWeight6 =(String) reqs.get("bornWeight6");
									String vaccine6 =(String) reqs.get("babyVaccine6");
									String fetusDie6 =(String) reqs.get("fetusDie6");
									String midwife6 =(String) reqs.get("midwife6");
							
									childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
									childbirthBabyInfoVO.setBabyName(babyName6);
									childbirthBabyInfoVO.setAbnormalName(abnormalName6);
									childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
									childbirthBabyInfoVO.setBabySex(babySex6);
									childbirthBabyInfoVO.setBodyLenght(bornWeight6);
									childbirthBabyInfoVO.setBornWeight(bornWeight6);
									childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
									childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
									childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
									childbirthBabyInfoVO.setDeliveryType(deliveryType6);
									childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
									childbirthBabyInfoVO.setFetusDie(fetusDie6);
									childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
									childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
									childbirthBabyInfoVO.setHealth(health6);
									childbirthBabyInfoVO.setId(acrid6);
									childbirthBabyInfoVO.setChildbirthId(childbirthid);
									childbirthBabyInfoVO.setInducelabour(inducelabour6);
									childbirthBabyInfoVO.setMidwife(midwife6);
									childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
									childbirthBabyInfoVO.setVaccine(vaccine6);
									BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
									childbirthBabyInfoService.update(childbirthBabyInfoPO);
									}
								}
											
								
							}
					ChildbirthBabyInfoPO childbirthBaby=new ChildbirthBabyInfoPO();
					if(acrid0==null||acrid0==""){
						//修改第一个婴儿信息
						String deliveryType0 =(String) reqs.get("deliveryType");
						if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
						String id=IdUtil.uuid();
						childbirthBabyInfoVO.setId(id);	
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid1==null ||acrid1==""){
						//修改第一个婴儿信息
						String deliveryType1 =(String) reqs.get("deliveryType1");
						
						if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition =(String) reqs.get("fetusPosition1");
						String deliveryHour =(String) reqs.get("deliveryHour1");
						String deliveryMinute =(String) reqs.get("deliveryMinute1");
						String inducelabour =(String) reqs.get("inducelabour1");
						String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
						String babySex =(String) reqs.get("babySex1");
						String health =(String) reqs.get("health1");
						String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
						String abnormalPosition =(String) reqs.get("abnormalPosition1");
						String abnormalName =(String) reqs.get("abnormalName1");
						String oneMinScore =(String) reqs.get("oneMinScore1");
						String fiveMinScore =(String) reqs.get("fiveMinScore1");
						String bornWeight =(String) reqs.get("bornWeight1");
						String vaccine =(String) reqs.get("babyVaccine1");
						String fetusDie =(String) reqs.get("fetusDie1");
						String midwife =(String) reqs.get("midwife1");
						
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setBabyName(babyName1);
						childbirthBabyInfoVO.setAbnormalName(abnormalName);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
						childbirthBabyInfoVO.setBabySex(babySex);
						childbirthBabyInfoVO.setBodyLenght(bornWeight);
						childbirthBabyInfoVO.setBornWeight(bornWeight);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
						childbirthBabyInfoVO.setDeliveryType(deliveryType1);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
						childbirthBabyInfoVO.setFetusDie(fetusDie);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
						childbirthBabyInfoVO.setHealth(health);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour);
						childbirthBabyInfoVO.setMidwife(midwife);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore);
						childbirthBabyInfoVO.setVaccine(vaccine);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid2==null||acrid2==""){
						//修改第二个婴儿信息
						String deliveryType2 =(String) reqs.get("deliveryType2");
						
						if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition2 =(String) reqs.get("fetusPosition2");
						String deliveryHour2 =(String) reqs.get("deliveryHour2");
						String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
						String inducelabour2 =(String) reqs.get("inducelabour2");
						String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
						String babySex2 =(String) reqs.get("babySex2");
						String health2 =(String) reqs.get("health2");
						String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
						String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
						String abnormalName2 =(String) reqs.get("abnormalName2");
						String oneMinScore2 =(String) reqs.get("oneMinScore2");
						String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
						String bornWeight2 =(String) reqs.get("bornWeight2");
						String vaccine2 =(String) reqs.get("babyVaccine2");
						String fetusDie2 =(String) reqs.get("fetusDie2");
						String midwife2 =(String) reqs.get("midwife2");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setBabyName(babyName2);
						childbirthBabyInfoVO.setAbnormalName(abnormalName2);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
						childbirthBabyInfoVO.setBabySex(babySex2);
						childbirthBabyInfoVO.setBodyLenght(bornWeight2);
						childbirthBabyInfoVO.setBornWeight(bornWeight2);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
						childbirthBabyInfoVO.setDeliveryType(deliveryType2);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
						childbirthBabyInfoVO.setFetusDie(fetusDie2);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
						childbirthBabyInfoVO.setHealth(health2);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour2);
						childbirthBabyInfoVO.setMidwife(midwife2);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
						childbirthBabyInfoVO.setVaccine(vaccine2);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					
					if(acrid3==null||acrid3==""){
						//修改第三个婴儿信息
						String deliveryType3 =(String) reqs.get("deliveryType3");
						
						if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition3 =(String) reqs.get("fetusPosition3");
						String deliveryHour3 =(String) reqs.get("deliveryHour3");
						String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
						String inducelabour3 =(String) reqs.get("inducelabour3");
						String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
						String babySex3 =(String) reqs.get("babySex3");
						String health3 =(String) reqs.get("health3");
						String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
						String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
						String abnormalName3 =(String) reqs.get("abnormalName3");
						String oneMinScore3 =(String) reqs.get("oneMinScore3");
						String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
						String bornWeight3 =(String) reqs.get("bornWeight3");
						String vaccine3 =(String) reqs.get("babyVaccine3");
						String fetusDie3 =(String) reqs.get("fetusDie3");
						String midwife3 =(String) reqs.get("midwife3");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setBabyName(babyName3);
						childbirthBabyInfoVO.setAbnormalName(abnormalName3);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
						childbirthBabyInfoVO.setBabySex(babySex3);
						childbirthBabyInfoVO.setBodyLenght(bornWeight3);
						childbirthBabyInfoVO.setBornWeight(bornWeight3);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
						childbirthBabyInfoVO.setDeliveryType(deliveryType3);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
						childbirthBabyInfoVO.setFetusDie(fetusDie3);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
						childbirthBabyInfoVO.setHealth(health3);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour3);
						childbirthBabyInfoVO.setMidwife(midwife3);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
						childbirthBabyInfoVO.setVaccine(vaccine3);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						
						}
					}
					if(acrid4==null||acrid4==""){
						//修改第四个婴儿信息
						String deliveryType4 =(String) reqs.get("deliveryType4");
						
						if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition4 =(String) reqs.get("fetusPosition4");
						String deliveryHour4 =(String) reqs.get("deliveryHour4");
						String inducelabour4 =(String) reqs.get("inducelabour4");
						String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
						String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
						String babySex4 =(String) reqs.get("babySex4");
						String health4 =(String) reqs.get("health4");
						String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
						String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
						String abnormalName4 =(String) reqs.get("abnormalName4");
						String oneMinScore4 =(String) reqs.get("oneMinScore4");
						String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
						String bornWeight4 =(String) reqs.get("bornWeight4");
						String vaccine4 =(String) reqs.get("babyVaccine4");
						String fetusDie4 =(String) reqs.get("fetusDie4");
						String midwife4 =(String) reqs.get("midwife4");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setBabyName(babyName4);
						childbirthBabyInfoVO.setAbnormalName(abnormalName4);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
						childbirthBabyInfoVO.setBabySex(babySex4);
						childbirthBabyInfoVO.setBodyLenght(bornWeight4);
						childbirthBabyInfoVO.setBornWeight(bornWeight4);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
						childbirthBabyInfoVO.setDeliveryType(deliveryType4);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
						childbirthBabyInfoVO.setFetusDie(fetusDie4);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
						childbirthBabyInfoVO.setHealth(health4);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour4);
						childbirthBabyInfoVO.setMidwife(midwife4);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
						childbirthBabyInfoVO.setVaccine(vaccine4);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid5==null||acrid5==""){
						//修改第五个婴儿信息
						String deliveryType5 =(String) reqs.get("deliveryType5");
						
						if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition5 =(String) reqs.get("fetusPosition5");
						String deliveryHour5 =(String) reqs.get("deliveryHour5");
						String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
						String inducelabour5 =(String) reqs.get("inducelabour5");
						String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
						String babySex5 =(String) reqs.get("babySex5");
						String health5 =(String) reqs.get("health5");
						String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
						String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
						String abnormalName5 =(String) reqs.get("abnormalName5");
						String oneMinScore5 =(String) reqs.get("oneMinScore5");
						String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
						String bornWeight5 =(String) reqs.get("bornWeight5");
						String vaccine5 =(String) reqs.get("babyVaccine5");
						String fetusDie5 =(String) reqs.get("fetusDie5");
						String midwife5 =(String) reqs.get("midwife5");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setBabyName(babyName5);
						childbirthBabyInfoVO.setAbnormalName(abnormalName5);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
						childbirthBabyInfoVO.setBabySex(babySex5);
						childbirthBabyInfoVO.setBodyLenght(bornWeight5);
						childbirthBabyInfoVO.setBornWeight(bornWeight5);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
						childbirthBabyInfoVO.setDeliveryType(deliveryType5);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
						childbirthBabyInfoVO.setFetusDie(fetusDie5);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
						childbirthBabyInfoVO.setHealth(health5);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour5);
						childbirthBabyInfoVO.setMidwife(midwife5);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
						childbirthBabyInfoVO.setVaccine(vaccine5);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					if(acrid6==null||acrid6==""){
						//修改第五个婴儿信息
						String deliveryType6 =(String) reqs.get("deliveryType6");
						
						if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition6 =(String) reqs.get("fetusPosition6");
						String deliveryHour6 =(String) reqs.get("deliveryHour6");
						String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
						String inducelabour6 =(String) reqs.get("inducelabour6");
						String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
						String babySex6 =(String) reqs.get("babySex6");
						String health6 =(String) reqs.get("health6");
						String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
						String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
						String abnormalName6 =(String) reqs.get("abnormalName6");
						String oneMinScore6 =(String) reqs.get("oneMinScore6");
						String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
						String bornWeight6=(String) reqs.get("bornWeight6");
						String vaccine6 =(String) reqs.get("babyVaccine6");
						String fetusDie6 =(String) reqs.get("fetusDie6");
						String midwife6 =(String) reqs.get("midwife6");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setBabyName(babyName6);
						childbirthBabyInfoVO.setAbnormalName(abnormalName6);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
						childbirthBabyInfoVO.setBabySex(babySex6);
						childbirthBabyInfoVO.setBodyLenght(bornWeight6);
						childbirthBabyInfoVO.setBornWeight(bornWeight6);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
						childbirthBabyInfoVO.setDeliveryType(deliveryType6);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
						childbirthBabyInfoVO.setFetusDie(fetusDie6);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
						childbirthBabyInfoVO.setHealth(health6);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour6);
						childbirthBabyInfoVO.setMidwife(midwife6);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
						childbirthBabyInfoVO.setVaccine(vaccine6);
						BeanUtils.copyProperties(childbirthBaby, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBaby);
						}
					}
					
				}
				
				if(babyInfo.size() ==0){
					String acrid0 =(String) reqs.get("acrid0");
					String acrid1 =(String) reqs.get("acrid1");
					String acrid2 =(String) reqs.get("acrid2");
					String acrid3 =(String) reqs.get("acrid3");
					String acrid4 =(String) reqs.get("acrid4");
					String acrid5 =(String) reqs.get("acrid5");
					String acrid6 =(String) reqs.get("acrid6");
					
					
					//获得婴儿的名字
					String babyName0 =(String) reqs.get("babyName");
					String babyName1 =(String) reqs.get("babyName1");
					String babyName2 =(String) reqs.get("babyName2");
					String babyName3 =(String) reqs.get("babyName3");
					String babyName4 =(String) reqs.get("babyName4");
					String babyName5 =(String) reqs.get("babyName5");
					String babyName6 =(String) reqs.get("babyName6");
					
					ChildbirthBabyInfoPO childbirthBabyInfoPO= new ChildbirthBabyInfoPO();
					
					if(acrid0==null||acrid0==""){
						//修改第一个婴儿信息
						String deliveryType0 =(String) reqs.get("deliveryType");
						
						if(deliveryType0 !=null&&deliveryType0 !="" &&babyName0!=null &&babyName0!="" ){
						String id=IdUtil.uuid();
						childbirthBabyInfoVO.setId(id);	
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid1==null ||acrid1==""){
						//修改第一个婴儿信息
						String deliveryType1 =(String) reqs.get("deliveryType1");
						
						if(deliveryType1 !=null&&deliveryType1 !="" &&babyName1!=null &&babyName1!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition =(String) reqs.get("fetusPosition1");
						String deliveryHour =(String) reqs.get("deliveryHour1");
						String deliveryMinute =(String) reqs.get("deliveryMinute1");
						String inducelabour =(String) reqs.get("inducelabour1");
						String cesareanIdicatio =(String) reqs.get("cesareanIdicatio1");
						String babySex =(String) reqs.get("babySex1");
						String health =(String) reqs.get("health1");
						String fetalAnomaly =(String) reqs.get("fetalAnomaly1");
						String abnormalPosition =(String) reqs.get("abnormalPosition1");
						String abnormalName =(String) reqs.get("abnormalName1");
						String oneMinScore =(String) reqs.get("oneMinScore1");
						String fiveMinScore =(String) reqs.get("fiveMinScore1");
						String bornWeight =(String) reqs.get("bornWeight1");
						String vaccine =(String) reqs.get("babyVaccine1");
						String fetusDie =(String) reqs.get("fetusDie1");
						String midwife =(String) reqs.get("midwife1");
						
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setBabyName(babyName1);
						childbirthBabyInfoVO.setAbnormalName(abnormalName);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition);
						childbirthBabyInfoVO.setBabySex(babySex);
						childbirthBabyInfoVO.setBodyLenght(bornWeight);
						childbirthBabyInfoVO.setBornWeight(bornWeight);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute);
						childbirthBabyInfoVO.setDeliveryType(deliveryType1);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly);
						childbirthBabyInfoVO.setFetusDie(fetusDie);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore);
						childbirthBabyInfoVO.setHealth(health);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour);
						childbirthBabyInfoVO.setMidwife(midwife);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore);
						childbirthBabyInfoVO.setVaccine(vaccine);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid2==null||acrid2==""){
						//修改第二个婴儿信息
						String deliveryType2 =(String) reqs.get("deliveryType2");
						
						if(deliveryType2 !=null&&deliveryType2 !="" &&babyName2!=null &&babyName2!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition2 =(String) reqs.get("fetusPosition2");
						String deliveryHour2 =(String) reqs.get("deliveryHour2");
						String deliveryMinute2 =(String) reqs.get("deliveryMinute2");
						String inducelabour2 =(String) reqs.get("inducelabour2");
						String cesareanIdicatio2 =(String) reqs.get("cesareanIdicatio2");
						String babySex2 =(String) reqs.get("babySex2");
						String health2 =(String) reqs.get("health2");
						String fetalAnomaly2 =(String) reqs.get("fetalAnomaly2");
						String abnormalPosition2 =(String) reqs.get("abnormalPosition2");
						String abnormalName2 =(String) reqs.get("abnormalName2");
						String oneMinScore2 =(String) reqs.get("oneMinScore2");
						String fiveMinScore2 =(String) reqs.get("fiveMinScore2");
						String bornWeight2 =(String) reqs.get("bornWeight2");
						String vaccine2 =(String) reqs.get("babyVaccine2");
						String fetusDie2 =(String) reqs.get("fetusDie2");
						String midwife2 =(String) reqs.get("midwife2");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setBabyName(babyName2);
						childbirthBabyInfoVO.setAbnormalName(abnormalName2);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition2);
						childbirthBabyInfoVO.setBabySex(babySex2);
						childbirthBabyInfoVO.setBodyLenght(bornWeight2);
						childbirthBabyInfoVO.setBornWeight(bornWeight2);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio2);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour2);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute2);
						childbirthBabyInfoVO.setDeliveryType(deliveryType2);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly2);
						childbirthBabyInfoVO.setFetusDie(fetusDie2);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition2);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore2);
						childbirthBabyInfoVO.setHealth(health2);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour2);
						childbirthBabyInfoVO.setMidwife(midwife2);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore2);
						childbirthBabyInfoVO.setVaccine(vaccine2);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					
					if(acrid3==null||acrid3==""){
						//修改第三个婴儿信息
						String deliveryType3 =(String) reqs.get("deliveryType3");
						
						if(deliveryType3 !=null&&deliveryType3 !="" &&babyName3!=null &&babyName3!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition3 =(String) reqs.get("fetusPosition3");
						String deliveryHour3 =(String) reqs.get("deliveryHour3");
						String deliveryMinute3 =(String) reqs.get("deliveryMinute3");
						String inducelabour3 =(String) reqs.get("inducelabour3");
						String cesareanIdicatio3 =(String) reqs.get("cesareanIdicatio3");
						String babySex3 =(String) reqs.get("babySex3");
						String health3 =(String) reqs.get("health3");
						String fetalAnomaly3 =(String) reqs.get("fetalAnomaly3");
						String abnormalPosition3 =(String) reqs.get("abnormalPosition3");
						String abnormalName3 =(String) reqs.get("abnormalName3");
						String oneMinScore3 =(String) reqs.get("oneMinScore3");
						String fiveMinScore3 =(String) reqs.get("fiveMinScore3");
						String bornWeight3 =(String) reqs.get("bornWeight3");
						String vaccine3 =(String) reqs.get("babyVaccine3");
						String fetusDie3 =(String) reqs.get("fetusDie3");
						String midwife3 =(String) reqs.get("midwife3");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setBabyName(babyName3);
						childbirthBabyInfoVO.setAbnormalName(abnormalName3);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition3);
						childbirthBabyInfoVO.setBabySex(babySex3);
						childbirthBabyInfoVO.setBodyLenght(bornWeight3);
						childbirthBabyInfoVO.setBornWeight(bornWeight3);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio3);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour3);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute3);
						childbirthBabyInfoVO.setDeliveryType(deliveryType3);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly3);
						childbirthBabyInfoVO.setFetusDie(fetusDie3);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition3);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore3);
						childbirthBabyInfoVO.setHealth(health3);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour3);
						childbirthBabyInfoVO.setMidwife(midwife3);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore3);
						childbirthBabyInfoVO.setVaccine(vaccine3);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						
						}
					}
					if(acrid4==null||acrid4==""){
						//修改第四个婴儿信息
						String deliveryType4 =(String) reqs.get("deliveryType4");
						
						if(deliveryType4 !=null&&deliveryType4 !="" &&babyName4!=null &&babyName4!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition4 =(String) reqs.get("fetusPosition4");
						String deliveryHour4 =(String) reqs.get("deliveryHour4");
						String inducelabour4 =(String) reqs.get("inducelabour4");
						String deliveryMinute4 =(String) reqs.get("deliveryMinute4");
						String cesareanIdicatio4 =(String) reqs.get("cesareanIdicatio4");
						String babySex4 =(String) reqs.get("babySex4");
						String health4 =(String) reqs.get("health4");
						String fetalAnomaly4 =(String) reqs.get("fetalAnomaly4");
						String abnormalPosition4 =(String) reqs.get("abnormalPosition4");
						String abnormalName4 =(String) reqs.get("abnormalName4");
						String oneMinScore4 =(String) reqs.get("oneMinScore4");
						String fiveMinScore4 =(String) reqs.get("fiveMinScore4");
						String bornWeight4 =(String) reqs.get("bornWeight4");
						String vaccine4 =(String) reqs.get("babyVaccine4");
						String fetusDie4 =(String) reqs.get("fetusDie4");
						String midwife4 =(String) reqs.get("midwife4");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setBabyName(babyName4);
						childbirthBabyInfoVO.setAbnormalName(abnormalName4);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition4);
						childbirthBabyInfoVO.setBabySex(babySex4);
						childbirthBabyInfoVO.setBodyLenght(bornWeight4);
						childbirthBabyInfoVO.setBornWeight(bornWeight4);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio4);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour4);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute4);
						childbirthBabyInfoVO.setDeliveryType(deliveryType4);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly4);
						childbirthBabyInfoVO.setFetusDie(fetusDie4);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition4);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore4);
						childbirthBabyInfoVO.setHealth(health4);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour4);
						childbirthBabyInfoVO.setMidwife(midwife4);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore4);
						childbirthBabyInfoVO.setVaccine(vaccine4);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid5==null||acrid5==""){
						//修改第五个婴儿信息
						String deliveryType5 =(String) reqs.get("deliveryType5");
						
						if(deliveryType5 !=null&&deliveryType5 !="" &&babyName5!=null &&babyName5!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition5 =(String) reqs.get("fetusPosition5");
						String deliveryHour5 =(String) reqs.get("deliveryHour5");
						String deliveryMinute5 =(String) reqs.get("deliveryMinute5");
						String inducelabour5 =(String) reqs.get("inducelabour5");
						String cesareanIdicatio5 =(String) reqs.get("cesareanIdicatio5");
						String babySex5 =(String) reqs.get("babySex5");
						String health5 =(String) reqs.get("health5");
						String fetalAnomaly5 =(String) reqs.get("fetalAnomaly5");
						String abnormalPosition5 =(String) reqs.get("abnormalPosition5");
						String abnormalName5 =(String) reqs.get("abnormalName5");
						String oneMinScore5 =(String) reqs.get("oneMinScore5");
						String fiveMinScore5 =(String) reqs.get("fiveMinScore5");
						String bornWeight5 =(String) reqs.get("bornWeight5");
						String vaccine5 =(String) reqs.get("babyVaccine5");
						String fetusDie5 =(String) reqs.get("fetusDie5");
						String midwife5 =(String) reqs.get("midwife5");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setBabyName(babyName5);
						childbirthBabyInfoVO.setAbnormalName(abnormalName5);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition5);
						childbirthBabyInfoVO.setBabySex(babySex5);
						childbirthBabyInfoVO.setBodyLenght(bornWeight5);
						childbirthBabyInfoVO.setBornWeight(bornWeight5);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio5);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour5);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute5);
						childbirthBabyInfoVO.setDeliveryType(deliveryType5);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly5);
						childbirthBabyInfoVO.setFetusDie(fetusDie5);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition5);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore5);
						childbirthBabyInfoVO.setHealth(health5);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour5);
						childbirthBabyInfoVO.setMidwife(midwife5);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore5);
						childbirthBabyInfoVO.setVaccine(vaccine5);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}
					if(acrid6==null||acrid6==""){
						//修改第五个婴儿信息
						String deliveryType6 =(String) reqs.get("deliveryType6");
						
						if(deliveryType6 !=null&&deliveryType6 !="" &&babyName6!=null &&babyName6!="" ){
						
						String id3 = IdUtil.uuid();
						String fetusPosition6 =(String) reqs.get("fetusPosition6");
						String deliveryHour6 =(String) reqs.get("deliveryHour6");
						String deliveryMinute6 =(String) reqs.get("deliveryMinute6");
						String inducelabour6 =(String) reqs.get("inducelabour6");
						String cesareanIdicatio6 =(String) reqs.get("cesareanIdicatio6");
						String babySex6 =(String) reqs.get("babySex6");
						String health6 =(String) reqs.get("health6");
						String fetalAnomaly6 =(String) reqs.get("fetalAnomaly6");
						String abnormalPosition6 =(String) reqs.get("abnormalPosition6");
						String abnormalName6 =(String) reqs.get("abnormalName6");
						String oneMinScore6 =(String) reqs.get("oneMinScore6");
						String fiveMinScore6 =(String) reqs.get("fiveMinScore6");
						String bornWeight6=(String) reqs.get("bornWeight6");
						String vaccine6 =(String) reqs.get("babyVaccine6");
						String fetusDie6 =(String) reqs.get("fetusDie6");
						String midwife6 =(String) reqs.get("midwife6");
				
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setBabyName(babyName6);
						childbirthBabyInfoVO.setAbnormalName(abnormalName6);
						childbirthBabyInfoVO.setAbnormalPosition(abnormalPosition6);
						childbirthBabyInfoVO.setBabySex(babySex6);
						childbirthBabyInfoVO.setBodyLenght(bornWeight6);
						childbirthBabyInfoVO.setBornWeight(bornWeight6);
						childbirthBabyInfoVO.setCesareanIdicatio(cesareanIdicatio6);
						childbirthBabyInfoVO.setDeliveryHour(deliveryHour6);
						childbirthBabyInfoVO.setDeliveryMinute(deliveryMinute6);
						childbirthBabyInfoVO.setDeliveryType(deliveryType6);
						childbirthBabyInfoVO.setFetalAnomaly(fetalAnomaly6);
						childbirthBabyInfoVO.setFetusDie(fetusDie6);
						childbirthBabyInfoVO.setFetusPosition(fetusPosition6);
						childbirthBabyInfoVO.setFiveMinScore(fiveMinScore6);
						childbirthBabyInfoVO.setHealth(health6);
						childbirthBabyInfoVO.setId(id3);
						childbirthBabyInfoVO.setChildbirthId(childbirthid);
						childbirthBabyInfoVO.setInducelabour(inducelabour6);
						childbirthBabyInfoVO.setMidwife(midwife6);
						childbirthBabyInfoVO.setOneMinScore(oneMinScore6);
						childbirthBabyInfoVO.setVaccine(vaccine6);
						BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
						childbirthBabyInfoService.create(childbirthBabyInfoPO);
						}
					}	
					
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return model;
	}
	
	
	

}