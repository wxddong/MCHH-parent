/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalExaInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.threefiveninetong.mchh.premarital.po.HealthInfoPO;
import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;
import com.threefiveninetong.mchh.premarital.po.PhysiqueExaInfoPO;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.premarital.po.PremaritalReferralInfoPO;
import com.threefiveninetong.mchh.premarital.vo.HealthInfoVO;
import com.threefiveninetong.mchh.premarital.vo.InspectionResultVO;
import com.threefiveninetong.mchh.premarital.vo.PhysiqueExaInfoVO;
import com.threefiveninetong.mchh.premarital.vo.PremaritalExaInfoVO;
import com.threefiveninetong.mchh.premarital.vo.PremaritalReferralInfoVO;
import com.threefiveninetong.mchh.premarital.po.LaboratorySpecialInsInfoPO;
import com.threefiveninetong.mchh.premarital.service.LaboratorySpecialInsInfoService;
import com.threefiveninetong.mchh.premarital.vo.LaboratorySpecialInsInfoVO;
import com.threefiveninetong.mchh.premarital.service.HealthInfoService;
import com.threefiveninetong.mchh.premarital.service.InspectionResultService;
import com.threefiveninetong.mchh.premarital.service.PhysiqueExaInfoService;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.service.DepartmentService;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.vo.DepartmentVO;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.premarital.service.PremaritalExaInfoService;
import com.threefiveninetong.mchh.premarital.service.PremaritalReferralInfoService;
import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.ArchivesInfoService;
import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.service.CityInfoService;
import com.threefiveninetong.mchh.config.service.DirectiveOpinionTemplateService;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.config.vo.CityInfoVO;
import com.threefiveninetong.mchh.config.vo.ProvinceInfoVO;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PremaritalExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
@Controller
@RequestMapping("/premaritalexainfo")
public class PremaritalExaInfoController {

	private static final Logger log =Logger.getLogger(PremaritalExaInfoController.class);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private  PremaritalExaInfoService  premaritalExaInfoService;
	
	@Resource
	private  HealthInfoService  healthInfoService;
	
	@Resource
	private  PhysiqueExaInfoService  physiqueExaInfoService;
	
	@Resource
	private  LaboratorySpecialInsInfoService  laboratorySpecialInsInfoService;
	
	@Resource
	private  InspectionResultService  inspectionResultService;
	
	@Resource
	private  ArchivesInfoService  archivesInfoService;
	
	@Resource
	private OperatorService operatorService;
	
	@Resource
	private DepartmentService departmentService;

	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	@Resource
	private PremaritalReferralInfoService premaritalReferralInfoService;
	
	@Resource
	private  CityInfoService  cityInfoService;

	@Resource
	private  DistrictAndCountyInfoService  districtAndCountyInfoService;
	
	@Resource
	private  TownshipInfoService  townshipInfoService;
	
	@Resource
	private  VillageInfoService  villageInfoService;
	
	@Resource
	private  PremaritalAbnormalOptionService  premaritalAbnormalOptionService;
	
	private Object premaritals;

	private Object createTime;
	
	
	@ResponseBody
	@RequestMapping(value="/countyDep", method = RequestMethod.GET)
	public Model countyDep(){
		
		log.debug("request data:listProvinceInfo");
		
		Model model = new Model();
		List<DepartmentPO> list = null;
		try {
			DepartmentPO departmentPO = new DepartmentPO();
			DepartmentVO departmentVO = new DepartmentVO();
			BeanUtils.copyProperties(departmentPO, departmentVO);
			list = departmentService.findXianHospital();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/townDep",method=RequestMethod.GET)
	public Model townDep(@RequestParam(value="parentId")String countyDepId){
		
		log.debug("request data:listCityInfo");
		
		Model model = new Model();
		List<DepartmentPO> list = null;
		
		try {
			DepartmentPO departmentPO = new DepartmentPO();
			DepartmentVO departmentVO = new DepartmentVO();
			BeanUtils.copyProperties(departmentPO, departmentVO);
			list = departmentService.getDep(countyDepId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/villageDep",method=RequestMethod.GET)
	public Model villageDep(@RequestParam(value="parentId")String townDepId){
		
		log.debug("request data:listCityInfo");
		
		Model model = new Model();
		List<DepartmentPO> list = null;
		
		try {
			DepartmentPO departmentPO = new DepartmentPO();
			DepartmentVO departmentVO = new DepartmentVO();
			BeanUtils.copyProperties(departmentPO, departmentVO);
			list = departmentService.getDep(townDepId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		return model;
	}
	
	/**
	 * 新建档案跳转页面
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/new_archives", method = RequestMethod.GET)
	public ModelAndView newArchives(HttpSession session){
		
		log.debug("request page:/premarital/new_archives");
		
		ModelAndView mav = new ModelAndView();
		
		String time = DateUtil.dateToString(new Date(), DateStyle.YYYYMMDD);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		mav.setViewName("/premarital/new_archives");
		mav.addObject("time", time);
		mav.addObject("operator",operator2);
		return mav;
	}
	
	/**
	 * 综合管理页面
	 * @return
	 */
	@RequestMapping(value = "/countList", method = RequestMethod.GET)
	public String countList() {
		
		return "premarital/premarital_countList";
	}
	
	/**
	 * 综合管理页面内容
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/countList", method = RequestMethod.POST)
	public Model countList(@RequestParam Map<String, Object> reqs, Page<PremaritalExaInfoPO> page) {
		//log.debug("request data: listPremaritalExaInfo");
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			premaritalExaInfoService.getAll(reqs, page);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.setPage(page);
		return model;
	}

    /**
	 * PREMARITAL_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPremaritalExaInfoView() {
		log.debug("request page: /premaritalExaInfo/premarital_list");
		return "inspect/premarital_list";
	}
	
	/**
	 * 不进入男性婚检报告页面
	 * @return
	 */
	@RequestMapping(value = "/noPresentation", method = RequestMethod.GET)
	public String noPresentation() {
		log.debug("request page: /premaritalExaInfo/premarital_manList");
		return "inspect/premarital_manList";
	}
	
	/**
	 * 不进入女性婚检报告页面
	 * @return
	 */
	@RequestMapping(value = "/noPresentationWoman", method = RequestMethod.GET)
	public String noPresentationWoman() {
		log.debug("request page: /premaritalExaInfo/premarital_list");
		return "inspect/premarital_list";
	}
	
	@RequestMapping(value = "/toList", method = RequestMethod.GET)
	public String listPremaritalExaInfoView2() {
		//log.debug("request page: /sysset/premaritalExaInfo/premarital_list");
		return "inspect/cityInfo_list3";
	}
	
	/**
	 * PREMARITAL_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPremaritalExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<PremaritalExaInfoPO> page) {
		log.debug("request data: listPremaritalExaInfo");
		Model model = new Model();
		try {
			premaritalExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	

	/**
	 * 保存女性婚检
	 * PREMARITAL_EXA_INFO 添加
	 * 
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addPremaritalExaInfoActoin(PremaritalExaInfoVO premaritalExaInfoVO,
											HealthInfoVO healthInfoVO,
											PremaritalReferralInfoVO premaritalReferralInfoVO,
											PhysiqueExaInfoVO physiqueExaInfoVO,
											LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
											InspectionResultVO inspectionResultVO,
											@RequestParam("createTime")String ct,
											@RequestParam("archivesCode")String archivesCode,
											@RequestParam("sex")String sex,
											@RequestParam("realName")String realName,
											@RequestParam("premaritalId")String premaritalId,
											@RequestParam("appointmentDate")String appointmentDate,
											@RequestParam("referralDate")String referralDate,
											@RequestParam("issuedByDate")String issuedByDate,
											@RequestParam("resultId")String resultId,
											HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//model.set("msg", "true");
		try {
			//检查医生ID
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			
			
			String doctId = operator.getId();
			String admin = archivesInfoService.getAdminId();
			String admId = archivesInfoService.getAdmId();
			mav.addObject("doctId",doctId);
			mav.addObject("adminId",admin);
			mav.addObject("admId",admId);
			
			premaritalExaInfoVO.setDoctorId(operator.getId());
			//创建时间
			Date createTime = DateUtil.stringToDate(ct);
			premaritalExaInfoVO.setCreatTime(createTime);
			//最后修改时间
			premaritalExaInfoVO.setUpdateTime(createTime);
			//档案ID
			ArchivesInfoPO archivesInfoPO = archivesInfoService.findArchivesByArchivesCode(archivesCode);
			//premaritalExaInfoVO.setArchivesId(archivesInfoPO.getId());
			//档案id
			String archivesId = archivesInfoPO.getId();
			//获取婚检信息
			//PremaritalExaInfoPO premarital = premaritalExaInfoService.getPremaritalByArchivesId(archivesId);
			//婚检id
			//String id = premarital.getId();
			
			premaritalExaInfoVO.setId(premaritalId);
			
			//婚检状态
			premaritalExaInfoVO.setPremaritalStatus("0");
			premaritalExaInfoVO.setEditStatus("0");
			
			//添加婚检
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			//添加健康状况数据
			healthInfoVO.setId(IdUtil.uuid());
			healthInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.create(healthInfoPO);
			
			//添加体格检查数据
			physiqueExaInfoVO.setId(IdUtil.uuid());
			physiqueExaInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.create(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setId(IdUtil.uuid());
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.create(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			Date issueDate = DateUtil.stringToDate(issuedByDate);
			inspectionResultVO.setIssuedByDate(issueDate);
			if (resultId != null && !"".equals(resultId)) {
				inspectionResultVO.setId(resultId);
			}
			if (resultId == null || "".equals(resultId)) {
				inspectionResultVO.setId(IdUtil.uuid());
			}
			
			inspectionResultVO.setMarriageTaId(premaritalExaInfoVO.getId());
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.create(inspectionResultPO);
			
			//保存转诊信息
			Date appointDate = DateUtil.stringToDate(appointmentDate);
			premaritalReferralInfoVO.setAppointmentDate(appointDate);
			
			Date referDate = DateUtil.stringToDate(referralDate);
			premaritalReferralInfoVO.setReferralDate(referDate);
			
			premaritalReferralInfoVO.setId(IdUtil.uuid());
			premaritalReferralInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.create(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		mav.setViewName("/inspect/premarital_list");
		return mav;
	}
	
	/**
	 * 女性婚检完成
	 * PREMARITAL_EXA_INFO 添加
	 * 
	 * @param premaritalExaInfoVO
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "/finishAdd", method = RequestMethod.POST)
	public Model finishAdd(PremaritalExaInfoVO premaritalExaInfoVO,
											HealthInfoVO healthInfoVO,
											PremaritalReferralInfoVO premaritalReferralInfoVO,
											PhysiqueExaInfoVO physiqueExaInfoVO,
											LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
											InspectionResultVO inspectionResultVO,
											@RequestParam("createTime")String ct,
											@RequestParam("archivesCode")String archivesCode,
											@RequestParam("sex")String sex,
											@RequestParam("realName")String realName,
											@RequestParam("referralDate")String referralDate,
											@RequestParam("appointmentDate")String appointmentDate,
											@RequestParam("issuedByDate")String issuedByDate,
											@RequestParam("resultId")String resultId,
											HttpSession session) {
		Model model = new Model();
		//model.set("msg", "true");
		try {
			//检查医生ID
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			premaritalExaInfoVO.setDoctorId(operator.getId());
			
			//末次月经
			//Date lastMenstrual = DateUtil.stringToDate(lastMenstrualPeriod);
			
			//转诊日期
			Date refer = DateUtil.stringToDate(referralDate);
			
			//预约复诊日期
			Date appointment = DateUtil.stringToDate(appointmentDate);
			
			//出具日期
			Date issued = DateUtil.stringToDate(issuedByDate);
			
			//创建时间
			Date createTime = DateUtil.stringToDate(ct);
			premaritalExaInfoVO.setCreatTime(createTime);
			//最后修改时间
			premaritalExaInfoVO.setUpdateTime(createTime);
			//档案ID
			ArchivesInfoPO archivesInfoPO = archivesInfoService.findArchivesByArchivesCode(archivesCode);
			//premaritalExaInfoVO.setArchivesId(archivesInfoPO.getId());
			//档案id
			String archivesId = archivesInfoPO.getId();
			//获取婚检信息
			PremaritalExaInfoPO premarital = premaritalExaInfoService.getPremaritalByArchivesId(archivesId);
			//婚检id
			String id = premarital.getId();
			
			premaritalExaInfoVO.setId(id);
			
			//婚检状态
			premaritalExaInfoVO.setPremaritalStatus("1");
			premaritalExaInfoVO.setEditStatus("1");
			
			//添加婚检
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			//添加健康状况数据
			healthInfoVO.setId(IdUtil.uuid());
			healthInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.create(healthInfoPO);
			
			//添加体格检查数据
			physiqueExaInfoVO.setId(IdUtil.uuid());
			physiqueExaInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.create(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setId(IdUtil.uuid());
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.create(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			if (resultId != null && !"".equals(resultId)) {
				inspectionResultVO.setId(resultId);
			}
			if (resultId == null || "".equals(resultId)) {
				inspectionResultVO.setId(IdUtil.uuid());
			}
			
			//inspectionResultVO.setId(resultId);
			inspectionResultVO.setMarriageTaId(premaritalExaInfoVO.getId());
			inspectionResultVO.setIssuedByDate(issued);
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.create(inspectionResultPO);
			
			//保存转诊信息
			premaritalReferralInfoVO.setId(IdUtil.uuid());
			premaritalReferralInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			premaritalReferralInfoVO.setReferralDate(refer);
			premaritalReferralInfoVO.setAppointmentDate(appointment);
			
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.create(premaritalReferralInfoPO);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		//mav.setViewName("/premarital/presentation_woman");
		return model;
	}
	
	/**
	 * 保存男性婚检
	 * PREMARITAL_EXA_INFO 添加
	 * 
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveManAdd", method = RequestMethod.POST)
	public ModelAndView saveManAdd(PremaritalExaInfoVO premaritalExaInfoVO,
											HealthInfoVO healthInfoVO,
											PremaritalReferralInfoVO premaritalReferralInfoVO,
											PhysiqueExaInfoVO physiqueExaInfoVO,
											LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
											InspectionResultVO inspectionResultVO,
											@RequestParam("createTime")String ct,
											@RequestParam("archivesCode")String archivesCode,
											@RequestParam("manSex")String manSex,
											@RequestParam("realName")String realName,
											@RequestParam("appointmentDate")String appointmentDate,
											@RequestParam("referralDate")String referralDate,
											@RequestParam("issuedByDate")String issuedByDate,
											@RequestParam("resultId")String resultId,
											HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//model.set("msg", "true");
		try {
			//检查医生ID
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			
			String doctId = operator.getId();
			String admin = archivesInfoService.getAdminId();
			String admId = archivesInfoService.getAdmId();
			mav.addObject("doctId",doctId);
			mav.addObject("adminId",admin);
			mav.addObject("admId",admId);
			
			premaritalExaInfoVO.setDoctorId(operator.getId());
			//创建时间
			Date createTime = DateUtil.stringToDate(ct);
			premaritalExaInfoVO.setCreatTime(createTime);
			//最后修改时间
			premaritalExaInfoVO.setUpdateTime(createTime);
			//档案ID
			ArchivesInfoPO archivesInfoPO = archivesInfoService.getArchivesByArchivesCode(archivesCode);
			String archId = archivesInfoPO.getId();
			PremaritalExaInfoPO premarital = premaritalExaInfoService.findPremaritalByArchivesId(archId);
			String premaritalId = premarital.getId();
			
			//婚检ID
			premaritalExaInfoVO.setId(premaritalId);
			
			premaritalExaInfoVO.setSex(manSex);
			
			//档案ID
			premaritalExaInfoVO.setArchivesId(archId);
			
			//获取检查医生ID
			//OperatorPO operatorPO = operatorService.getOperatorByRealName(realName);
			//premaritalExaInfoVO.setDoctorId(operatorPO.getId());
			//婚检状态
			premaritalExaInfoVO.setPremaritalStatus("0");
			premaritalExaInfoVO.setEditStatus("0");
			
			//添加婚检
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			//添加健康状况数据
			healthInfoVO.setId(IdUtil.uuid());
			healthInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.create(healthInfoPO);
			
			//添加体格检查数据
			physiqueExaInfoVO.setId(IdUtil.uuid());
			physiqueExaInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.create(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setId(IdUtil.uuid());
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.create(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			Date issueDate = DateUtil.stringToDate(issuedByDate);
			inspectionResultVO.setIssuedByDate(issueDate);
			//inspectionResultVO.setId(resultId);
			if (resultId != null && !"".equals(resultId)) {
				inspectionResultVO.setId(resultId);
			}
			if (resultId == null || "".equals(resultId)) {
				inspectionResultVO.setId(IdUtil.uuid());
			}
			
			inspectionResultVO.setMarriageTaId(premaritalExaInfoVO.getId());
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.create(inspectionResultPO);
			
			//保存转诊信息
			Date appointDate = DateUtil.stringToDate(appointmentDate);
			premaritalReferralInfoVO.setAppointmentDate(appointDate);
			Date referDate = DateUtil.stringToDate(referralDate);
			premaritalReferralInfoVO.setReferralDate(referDate);
			premaritalReferralInfoVO.setId(IdUtil.uuid());
			premaritalReferralInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.create(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		mav.setViewName("/inspect/premarital_manList");
		return mav;
	}
	
	/**
	 * 完成男性婚检
	 * PREMARITAL_EXA_INFO 添加
	 * 
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/finishManAdd", method = RequestMethod.POST)
	public Model finishManAddPremaritalExaInfoActoin(PremaritalExaInfoVO premaritalExaInfoVO,
											HealthInfoVO healthInfoVO,
											PremaritalReferralInfoVO premaritalReferralInfoVO,
											PhysiqueExaInfoVO physiqueExaInfoVO,
											LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
											InspectionResultVO inspectionResultVO,
											@RequestParam("createTime")String ct,
											@RequestParam("archivesCode")String archivesCode,
											@RequestParam("referralDate")String referralDate,
											@RequestParam("appointmentDate")String appointmentDate,
											@RequestParam("issuedByDate")String issuedByDate,
											@RequestParam("manSex")String manSex,
											@RequestParam("realName")String realName,
											@RequestParam("resultId")String resultId,
											HttpSession session) {
		Model model = new Model();
		//model.set("msg", "true");
		try {
			//检查医生ID
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			premaritalExaInfoVO.setDoctorId(operator.getId());
			//创建时间
			Date createTime = DateUtil.stringToDate(ct);
			premaritalExaInfoVO.setCreatTime(createTime);
			//最后修改时间
			premaritalExaInfoVO.setUpdateTime(createTime);
			
			//转诊日期
			Date refer = DateUtil.stringToDate(referralDate);
			
			//预约复诊日期
			Date appointment = DateUtil.stringToDate(appointmentDate);
			
			//出具日期
			Date issued = DateUtil.stringToDate(issuedByDate);
			
			//档案ID
			ArchivesInfoPO archivesInfoPO = archivesInfoService.getArchivesByArchivesCode(archivesCode);
			premaritalExaInfoVO.setArchivesId(archivesInfoPO.getId());
			//婚检--性别
			premaritalExaInfoVO.setSex(manSex);
			//获取检查医生ID
			//OperatorPO operatorPO = operatorService.getOperatorByRealName(realName);
			//premaritalExaInfoVO.setDoctorId(operatorPO.getId());
			//婚检状态
			premaritalExaInfoVO.setPremaritalStatus("1");
			//编辑状态
			premaritalExaInfoVO.setEditStatus("1");
			
			String archId = archivesInfoPO.getId();
			
			PremaritalExaInfoPO premarital = premaritalExaInfoService.findPremaritalByArchivesId(archId);
			String premaritalId = premarital.getId();
			
			//婚检ID
			premaritalExaInfoVO.setId(premaritalId);
			//添加婚检
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			//添加健康状况数据
			healthInfoVO.setId(IdUtil.uuid());
			healthInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.create(healthInfoPO);
			
			//添加体格检查数据
			physiqueExaInfoVO.setId(IdUtil.uuid());
			physiqueExaInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.create(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setId(IdUtil.uuid());
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.create(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			//inspectionResultVO.setId(resultId);
			if (resultId != null && !"".equals(resultId)) {
				inspectionResultVO.setId(resultId);
			}
			if (resultId == null || "".equals(resultId)) {
				inspectionResultVO.setId(IdUtil.uuid());
			}
			
			inspectionResultVO.setMarriageTaId(premaritalExaInfoVO.getId());
			
			inspectionResultVO.setIssuedByDate(issued);
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.create(inspectionResultPO);
			
			//保存转诊信息
			premaritalReferralInfoVO.setId(IdUtil.uuid());
			premaritalReferralInfoVO.setMarriageTaId(premaritalExaInfoVO.getId());
			premaritalReferralInfoVO.setReferralDate(refer);
			premaritalReferralInfoVO.setAppointmentDate(appointment);
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.create(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		//mav.setViewName("/inspect/premarital_manList");
		return model;
	}

	/**
	 * PREMARITAL_EXA_INFO 修改
	 * 
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePremaritalExaInfoActoin(PremaritalExaInfoVO premaritalExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 保存女性婚检修改
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(PremaritalExaInfoVO premaritalExaInfoVO,
						HealthInfoVO healthInfoVO,
						PremaritalReferralInfoVO premaritalReferralInfoVO,
						PhysiqueExaInfoVO physiqueExaInfoVO,
						LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
						InspectionResultVO inspectionResultVO,
						@RequestParam("premaritalId")String premaritalId,
						@RequestParam("archivesId")String archivesId,
						@RequestParam("createTime")String createTime,
						@RequestParam("sex")String sex,
						@RequestParam("referralDate")String referralDate,
						@RequestParam("appointmentDate")String appointmentDate,
						@RequestParam("issuedByDate")String issuedByDate,
						@RequestParam("realName")String realName) {
		ModelAndView mav = new ModelAndView();
		try {
			
			//获取检查医生ID
			OperatorPO operatorPO = operatorService.getOperatorByRealName(realName);
			
			String doctId = operatorPO.getId();
			String admin = archivesInfoService.getAdminId();
			String admId = archivesInfoService.getAdmId();
			mav.addObject("doctId",doctId);
			mav.addObject("adminId",admin);
			mav.addObject("admId",admId);
			
			premaritalExaInfoVO.setDoctorId(operatorPO.getId());
			//婚检id
			premaritalExaInfoVO.setId(premaritalId);
			//修改时间
			Date updateTime = new Date();
			premaritalExaInfoVO.setUpdateTime(updateTime);
			//修改婚检状态
			premaritalExaInfoVO.setPremaritalStatus("0");
			//修改编辑状态
			premaritalExaInfoVO.setEditStatus("0");
			
			premaritalExaInfoVO.setSex(sex);
			
			premaritalExaInfoVO.setArchivesId(archivesId);
			//创建时间
			Date creatTime = DateUtil.stringToDate(createTime);
			premaritalExaInfoVO.setCreatTime(creatTime);
			
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			healthInfoVO.setMarriageTaId(premaritalId);
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.edit(healthInfoPO);
			
			physiqueExaInfoVO.setMarriageTaId(premaritalId);
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.edit(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalId);
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.edit(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			Date issueDate = DateUtil.stringToDate(issuedByDate);
			inspectionResultVO.setIssuedByDate(issueDate);
			inspectionResultVO.setMarriageTaId(premaritalId);
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.edit(inspectionResultPO);
			
			//保存转诊信息
			Date appointDate = DateUtil.stringToDate(appointmentDate);
			premaritalReferralInfoVO.setAppointmentDate(appointDate);
			
			Date referDate = DateUtil.stringToDate(referralDate);
			premaritalReferralInfoVO.setReferralDate(referDate);
			
			premaritalReferralInfoVO.setMarriageTaId(premaritalId);
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.edit(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		mav.setViewName("/inspect/premarital_list");
		return mav;
	}
	
	/**
	 * 保存男性婚检修改
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveManEdit", method = RequestMethod.POST)
	public ModelAndView saveManEdit(PremaritalExaInfoVO premaritalExaInfoVO,
						HealthInfoVO healthInfoVO,
						PremaritalReferralInfoVO premaritalReferralInfoVO,
						PhysiqueExaInfoVO physiqueExaInfoVO,
						LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
						InspectionResultVO inspectionResultVO,
						@RequestParam("premaritalId")String premaritalId,
						@RequestParam("archivesId")String archivesId,
						@RequestParam("createTime")String createTime,
						@RequestParam("manSex")String manSex,
						@RequestParam("referralDate")String referralDate,
						@RequestParam("appointmentDate")String appointmentDate,
						@RequestParam("issuedByDate")String issuedByDate,
						@RequestParam("realName")String realName) {
		ModelAndView mav = new ModelAndView();
		try {
			
			//获取检查医生ID
			OperatorPO operatorPO = operatorService.getOperatorByRealName(realName);
			
			String doctId = operatorPO.getId();
			String admin = archivesInfoService.getAdminId();
			String admId = archivesInfoService.getAdmId();
			mav.addObject("doctId",doctId);
			mav.addObject("adminId",admin);
			mav.addObject("admId",admId);
			
			premaritalExaInfoVO.setDoctorId(operatorPO.getId());
			//婚检id
			premaritalExaInfoVO.setId(premaritalId);
			//修改时间
			Date updateTime = new Date();
			premaritalExaInfoVO.setUpdateTime(updateTime);
			//修改婚检状态
			premaritalExaInfoVO.setPremaritalStatus("0");
			//修改编辑状态
			premaritalExaInfoVO.setEditStatus("0");
			//创建时间
			Date creatTime = DateUtil.stringToDate(createTime);
			premaritalExaInfoVO.setCreatTime(creatTime);
			
			//档案id
			premaritalExaInfoVO.setArchivesId(archivesId);
			
			//
			premaritalExaInfoVO.setSex(manSex);
			
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			healthInfoVO.setMarriageTaId(premaritalId);
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.edit(healthInfoPO);
			
			physiqueExaInfoVO.setMarriageTaId(premaritalId);
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.edit(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalId);
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.edit(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			Date issueDate = DateUtil.stringToDate(issuedByDate);
			inspectionResultVO.setIssuedByDate(issueDate);
			
			inspectionResultVO.setMarriageTaId(premaritalId);
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.edit(inspectionResultPO);
			
			//保存转诊信息
			Date appointDate = DateUtil.stringToDate(appointmentDate);
			premaritalReferralInfoVO.setAppointmentDate(appointDate);
			
			Date referDate = DateUtil.stringToDate(referralDate);
			premaritalReferralInfoVO.setReferralDate(referDate);
			
			premaritalReferralInfoVO.setMarriageTaId(premaritalId);
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.edit(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		mav.setViewName("/inspect/premarital_manList");
		return mav;
	}
	
	/**
	 * 完成女性婚检修改
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/finishEdit", method = RequestMethod.POST)
	public Model finishEdit(PremaritalExaInfoVO premaritalExaInfoVO,
						HealthInfoVO healthInfoVO,
						PremaritalReferralInfoVO premaritalReferralInfoVO,
						PhysiqueExaInfoVO physiqueExaInfoVO,
						LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
						InspectionResultVO inspectionResultVO,
						@RequestParam("premaritalId")String premaritalId,
						@RequestParam("archivesId")String archivesId,
						@RequestParam("createTime")String createTime,
						@RequestParam("referralDate")String referralDate,
						@RequestParam("appointmentDate")String appointmentDate,
						@RequestParam("issuedByDate")String issuedByDate,
						@RequestParam("sex")String sex,
						@RequestParam("realName")String realName) {
		Model model = new Model();
		try {
			
			//获取检查医生ID
			OperatorPO operatorPO = operatorService.getOperatorByRealName(realName);
			premaritalExaInfoVO.setDoctorId(operatorPO.getId());
			//婚检id
			premaritalExaInfoVO.setId(premaritalId);
			//修改时间
			Date updateTime = new Date();
			premaritalExaInfoVO.setUpdateTime(updateTime);
			//修改婚检状态
			premaritalExaInfoVO.setPremaritalStatus("1");
			//修改编辑状态
			premaritalExaInfoVO.setEditStatus("1");
			
			//转诊日期
			Date refer = DateUtil.stringToDate(referralDate);
			
			//预约复诊日期
			Date appointment = DateUtil.stringToDate(appointmentDate);
			
			//出具日期
			Date issued = DateUtil.stringToDate(issuedByDate);
			
			//创建时间
			Date creatTime = DateUtil.stringToDate(createTime);
			premaritalExaInfoVO.setCreatTime(creatTime);
			
			//档案id
			premaritalExaInfoVO.setArchivesId(archivesId);
			
			//性别
			premaritalExaInfoVO.setSex(sex);
			
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			healthInfoVO.setMarriageTaId(premaritalId);
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.edit(healthInfoPO);
			
			physiqueExaInfoVO.setMarriageTaId(premaritalId);
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.edit(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalId);
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.edit(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			inspectionResultVO.setMarriageTaId(premaritalId);
			inspectionResultVO.setIssuedByDate(issued);
			
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.edit(inspectionResultPO);
			
			//保存转诊信息
			premaritalReferralInfoVO.setMarriageTaId(premaritalId);
			premaritalReferralInfoVO.setReferralDate(refer);
			premaritalReferralInfoVO.setAppointmentDate(appointment);
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.edit(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		//mav.setViewName("/inspect/premarital_list");
		return model;
	}
	
	/**
	 * 完成男性婚检修改
	 * @param premaritalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/finishManEdit", method = RequestMethod.POST)
	public Model finishManEdit(PremaritalExaInfoVO premaritalExaInfoVO,
						HealthInfoVO healthInfoVO,
						PremaritalReferralInfoVO premaritalReferralInfoVO,
						PhysiqueExaInfoVO physiqueExaInfoVO,
						LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO,
						InspectionResultVO inspectionResultVO,
						@RequestParam("premaritalId")String premaritalId,
						@RequestParam("archivesId")String archivesId,
						@RequestParam("createTime")String createTime,
						@RequestParam("referralDate")String referralDate,
						@RequestParam("appointmentDate")String appointmentDate,
						@RequestParam("issuedByDate")String issuedByDate,
						@RequestParam("manSex")String manSex,
						@RequestParam("realName")String realName) {
		Model model = new Model();
		try {
			
			//获取检查医生ID
			OperatorPO operatorPO = operatorService.getOperatorByRealName(realName);
			premaritalExaInfoVO.setDoctorId(operatorPO.getId());
			//婚检id
			premaritalExaInfoVO.setId(premaritalId);
			//修改时间
			Date updateTime = new Date();
			premaritalExaInfoVO.setUpdateTime(updateTime);
			//修改婚检状态
			premaritalExaInfoVO.setPremaritalStatus("1");
			//修改编辑状态
			premaritalExaInfoVO.setEditStatus("1");
			
			//转诊日期
			Date refer = DateUtil.stringToDate(referralDate);
			
			//预约复诊日期
			Date appointment = DateUtil.stringToDate(appointmentDate);
			
			//出具日期
			Date issued = DateUtil.stringToDate(issuedByDate);
			
			//创建时间
			Date creatTime = DateUtil.stringToDate(createTime);
			premaritalExaInfoVO.setCreatTime(creatTime);
			
			//档案id
			premaritalExaInfoVO.setArchivesId(archivesId);
			
			//性别
			premaritalExaInfoVO.setSex(manSex);
			
			PremaritalExaInfoPO premaritalExaInfoPO = new PremaritalExaInfoPO();
			BeanUtils.copyProperties(premaritalExaInfoPO, premaritalExaInfoVO);
			premaritalExaInfoService.update(premaritalExaInfoPO);
			
			healthInfoVO.setMarriageTaId(premaritalId);
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.edit(healthInfoPO);
			
			physiqueExaInfoVO.setMarriageTaId(premaritalId);
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.edit(physiqueExaInfoPO);
			
			//实验室及特殊检查
			laboratorySpecialInsInfoVO.setMarriageTaId(premaritalId);
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.edit(laboratorySpecialInsInfoPO);
			
			//保存检查结果
			inspectionResultVO.setMarriageTaId(premaritalId);
			inspectionResultVO.setIssuedByDate(issued);
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.edit(inspectionResultPO);
			
			//保存转诊信息
			premaritalReferralInfoVO.setMarriageTaId(premaritalId);
			premaritalReferralInfoVO.setReferralDate(refer);
			premaritalReferralInfoVO.setAppointmentDate(appointment);
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.edit(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		//mav.setViewName("/inspect/premarital_list");
		return model;
	}

	/**
	 * PREMARITAL_EXA_INFO 删除
	 * 
	 * @param premaritalExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPremaritalExaInfoAction(@RequestParam("premaritalExaInfoIds") String premaritalExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			premaritalExaInfoService.deletes(premaritalExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	@Resource
	private  DirectiveOpinionTemplateService  directiveOpinionTemplateService;
	
	/**
	 * 进入女性婚检页面
	 * @return
	 */
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public ModelAndView premaritalListAction(@RequestParam Map<String, Object> reqs,
											 @RequestParam("premaritalId") String premaritalId,
											 HttpSession session) {
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		//出生日期
		String birthday = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYYMMDD);
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		String time = DateUtil.dateToString(new Date(), DateStyle.YYYYMMDD);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		//家庭省
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(homeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String homeCityId = archivesInfoPO.getHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(homeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(homeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String homeTownshipId = archivesInfoPO.getHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(homeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(homeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//户口省
		String accProvinceId = archivesInfoPO.getAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(accProvinceId);
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//户口市
		String accCityId = archivesInfoPO.getAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(accCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//户口县
		String accCountyId = archivesInfoPO.getAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(accCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//户口乡
		String accTownshipId = archivesInfoPO.getAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(accTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//户口村
		String accVillageId = archivesInfoPO.getAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(accVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		//当前医院
		String val = operator2.getDepartment();
		//当前医院级别
		String  level = departmentService.queryQyByName(val) ;
		
		//获取指导意见
		DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.getWoman();
		
		reqs.put("directiveOpinionTemplatePO", directiveOpinionTemplatePO);
		
		mav.setViewName("/inspect/premarital_woman");
		reqs.put("premaritalId", premaritalId);
		reqs.put("time", time);
		reqs.put("birthday", birthday);
		reqs.put("operator",operator2);
		//reqs.put("list",list);
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 女性详情页
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> reqs) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		//出生日期
		String birthday = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD);
		
		//家庭省
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(homeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String homeCityId = archivesInfoPO.getHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(homeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(homeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String homeTownshipId = archivesInfoPO.getHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(homeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(homeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//户口省
		String accProvinceId = archivesInfoPO.getAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(accProvinceId);
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//户口市
		String accCityId = archivesInfoPO.getAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(accCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//户口县
		String accCountyId = archivesInfoPO.getAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(accCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//户口乡
		String accTownshipId = archivesInfoPO.getAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(accTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//户口村
		String accVillageId = archivesInfoPO.getAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(accVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		
		if (operatorPO != null) {
			reqs.put("operatorPO", operatorPO);
		}
		
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		
		if (department != null) {
			reqs.put("department", department);
		}
		
		reqs.put("birthday", birthday);
		reqs.put("creatTime", creatTime);
		
		mav.setViewName("/inspect/premarital_detail");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 男性详情页
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/manDetail", method = RequestMethod.GET)
	public ModelAndView manDetail(@RequestParam Map<String, Object> reqs) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		//出生日期
		String manBirthday = DateUtil.dateToString(archivesInfoPO.getManBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD);
		
		//省
		String manAccProvinceId = archivesInfoPO.getManAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(manAccProvinceId);
		
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//市
		String manAccCityId = archivesInfoPO.getManAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(manAccCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//县
		String manAccCountyId = archivesInfoPO.getManAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(manAccCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//乡
		String manAccTownshipId = archivesInfoPO.getManAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(manAccTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//村
		String manAccVillageId = archivesInfoPO.getManAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(manAccVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//家庭省
		String manHomeProvinceId = archivesInfoPO.getManHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(manHomeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String manHomeCityId = archivesInfoPO.getManHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(manHomeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String manHomeCountyId = archivesInfoPO.getManHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(manHomeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String manHomeTownshipId = archivesInfoPO.getManHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(manHomeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String manHomeVillageId = archivesInfoPO.getManHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(manHomeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		
		if (operatorPO != null) {
			reqs.put("operatorPO", operatorPO);
		}
		
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		
		if (department != null) {
			reqs.put("department", department);
		}
		
		reqs.put("manBirthday", manBirthday);
		reqs.put("creatTime", creatTime);
		
		mav.setViewName("/inspect/premarital_manDetail");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 女性修改
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
	public ModelAndView toUpdate(HttpServletRequest request,@RequestParam Map<String, Object> reqs) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		//省
		String accProvinceId = archivesInfoPO.getAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(accProvinceId);
		
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//市
		String accCityId = archivesInfoPO.getAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(accCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//县
		String accCountyId = archivesInfoPO.getAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(accCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//乡
		String accTownshipId = archivesInfoPO.getAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(accTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//村
		String accVillageId = archivesInfoPO.getAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(accVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//家庭省
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(homeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String homeCityId = archivesInfoPO.getHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(homeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(homeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String homeTownshipId = archivesInfoPO.getHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(homeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(homeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		//出生日期
		String birthday = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD);
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		
		if (operatorPO != null) {
			reqs.put("operatorPO", operatorPO);
		}
		
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		
		if (department != null) {
			reqs.put("department", department);
		}
		
		reqs.put("birthday", birthday);
		reqs.put("creatTime", creatTime);
		
		mav.setViewName("/inspect/archives_womanUpdate");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 男性修改
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/toManUpdate", method = RequestMethod.GET)
	public ModelAndView toManUpdate(HttpServletRequest request,@RequestParam Map<String, Object> reqs) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		//省
		String manAccProvinceId = archivesInfoPO.getManAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(manAccProvinceId);
		
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//市
		String manAccCityId = archivesInfoPO.getManAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(manAccCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//县
		String manAccCountyId = archivesInfoPO.getManAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(manAccCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//乡
		String manAccTownshipId = archivesInfoPO.getManAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(manAccTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//村
		String manAccVillageId = archivesInfoPO.getManAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(manAccVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//家庭省
		String manHomeProvinceId = archivesInfoPO.getManHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(manHomeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String manHomeCityId = archivesInfoPO.getManHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(manHomeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String manHomeCountyId = archivesInfoPO.getManHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(manHomeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String manHomeTownshipId = archivesInfoPO.getManHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(manHomeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String manHomeVillageId = archivesInfoPO.getManHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(manHomeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		//出生日期
		String manBirthday = DateUtil.dateToString(archivesInfoPO.getManBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD);
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		
		if (operatorPO != null) {
			reqs.put("operatorPO", operatorPO);
		}
		
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		
		if (department != null) {
			reqs.put("department", department);
		}
		
		reqs.put("manBirthday", manBirthday);
		reqs.put("creatTime", creatTime);
		
		mav.setViewName("/premarital/archives_manUpdate");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 女性婚检证明
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/womanProve", method = RequestMethod.GET)
	public ModelAndView womanProve(HttpServletRequest request,@RequestParam Map<String, Object> reqs) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		//出生日期
		String birthday = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYY_MM_DD_CN);
		
		//家庭省
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(homeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String homeCityId = archivesInfoPO.getHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(homeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(homeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String homeTownshipId = archivesInfoPO.getHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(homeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(homeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//获取婚检id
		String archId = archivesInfoPO.getId();
		PremaritalExaInfoPO premaritalExaInfo = premaritalExaInfoService.findWomanPremaritalByArchivesId(archId);
		String premaritalId = premaritalExaInfo.getId();
		
		//根据婚检id获取健康状况
		HealthInfoPO health = healthInfoService.getHealthByPremaritalId(premaritalId);
		if (health != null) {
			reqs.put("health", health);
		}
		
		//根据婚检id获取检查结果信息
		InspectionResultPO inspection = inspectionResultService.getInspectionByPremaritalId(premaritalId);
		if (inspection != null) {
			reqs.put("inspection", inspection);
		}
		
		reqs.put("birthday", birthday);
		reqs.put("creatTime", creatTime);
		
		mav.setViewName("/premarital/prove_woman");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 男性婚检证明
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/manProve", method = RequestMethod.GET)
	public ModelAndView manProve(HttpServletRequest request,@RequestParam Map<String, Object> reqs) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		//家庭省
		String manHomeProvinceId = archivesInfoPO.getManHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(manHomeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String manHomeCityId = archivesInfoPO.getManHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(manHomeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String manHomeCountyId = archivesInfoPO.getManHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(manHomeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String manHomeTownshipId = archivesInfoPO.getManHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(manHomeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String manHomeVillageId = archivesInfoPO.getManHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(manHomeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		//出生日期
		String manBirthday = DateUtil.dateToString(archivesInfoPO.getManBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYY_MM_DD_CN);
		
		//获取婚检id
		String archId = archivesInfoPO.getId();
		PremaritalExaInfoPO premaritalExaInfo = premaritalExaInfoService.findPremaritalByArchivesId(archId);
		String premaritalId = premaritalExaInfo.getId();
		
		//根据婚检id获取健康状况
		HealthInfoPO health = healthInfoService.getHealthByPremaritalId(premaritalId);
		if (health != null) {
			reqs.put("health", health);
		}
		
		//根据婚检id获取检查结果信息
		InspectionResultPO inspection = inspectionResultService.getInspectionByPremaritalId(premaritalId);
		if (inspection != null) {
			reqs.put("inspection", inspection);
		}
		
		
		reqs.put("manBirthday", manBirthday);
		reqs.put("creatTime", creatTime);
		
		mav.setViewName("/premarital/prove_man");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 进入女性婚检修改页面
	 * @param reqs
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/toEditWomanPremarital", method = RequestMethod.GET)
	public ModelAndView toEditWomanPremarital(HttpServletRequest request,
											  @RequestParam Map<String, Object> reqs,
											  @RequestParam("premaritalId") String premaritalId) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		
			reqs.put("archivesInfo", archivesInfoPO);
		
		//家庭省
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(homeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String homeCityId = archivesInfoPO.getHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(homeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(homeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String homeTownshipId = archivesInfoPO.getHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(homeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(homeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//户口省
		String accProvinceId = archivesInfoPO.getAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(accProvinceId);
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//户口市
		String accCityId = archivesInfoPO.getAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(accCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//户口县
		String accCountyId = archivesInfoPO.getAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(accCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//户口乡
		String accTownshipId = archivesInfoPO.getAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(accTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//户口村
		String accVillageId = archivesInfoPO.getAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(accVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		
		
			reqs.put("operatorPO", operatorPO);
		
		
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		
		
			reqs.put("department", department);
		
				
		//出生日期
		String birthday = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		//String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD_CN);
		
		//档案id
		String archivesId = archivesInfoPO.getId();
		
		//根据档案id获取婚检信息
		//PremaritalExaInfoPO premarital = premaritalExaInfoService.getPremaritalByArchivesId(archivesId);
		
		PremaritalExaInfoPO premarital = premaritalExaInfoService.getById(premaritalId);
		//建档日期
		String creatTime = DateUtil.dateToString(premarital.getCreatTime(), DateStyle.YYYYMMDD);
		
		//修改婚检状态为未婚检，编辑状态为保存
		premarital.setEditStatus("0");
		premarital.setPremaritalStatus("0");
		
		
		premaritalExaInfoService.update(premarital);
		
		
			reqs.put("premarital", premarital);
		
		
		//获取当前婚检id
		//String premaritalId = premarital.getId();
		
		//根据婚检id获取健康状况信息
		HealthInfoPO health = healthInfoService.getHealthByPremaritalId(premaritalId);
		
		//既往病史
		String medicalHistorys = health.getMedicalHistory();
		if (medicalHistorys != null) {
			String[] medicalHistory = medicalHistorys.split(",");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < medicalHistory.length; i++) {
				list.add(medicalHistory[i]);
			}
			mav.addObject("list", list);
		}
		
		//与遗传有关的家族
		String geneticHistorys = health.getGeneticHistory();
		if (geneticHistorys != null) {
			String[] geneticHistory = geneticHistorys.split(",");
			
			List<String> list1 = new ArrayList<>();
			
			for (int i = 0; i < geneticHistory.length; i++) {
				list1.add(geneticHistory[i]);
			}
			mav.addObject("list1", list1);
		}
		
		//与患者的关系
		String patientRelationships = health.getPatientRelationship();
		if (patientRelationships != null) {
			String[] patientRelationship = patientRelationships.split(",");
			List<String> list11 = new ArrayList<>();
			
			for (int i = 0; i < patientRelationship.length; i++) {
				list11.add(patientRelationship[i]);
			}
			mav.addObject("list11", list11);
		}
		
		//末次月经
		String lastMenstrualPeriod = health.getLastMenstrualPeriod();
		
		
			reqs.put("health", health);
		
		
		//根据婚检id获取体格检查信息
		PhysiqueExaInfoPO physique = physiqueExaInfoService.getPhysiqueByPremaritalId(premaritalId);
		
		
			reqs.put("physique", physique);
		
		
		//根据婚检id获取实验室检查信息
		LaboratorySpecialInsInfoPO laboratory = laboratorySpecialInsInfoService.getLaboratoryByPremaritalId(premaritalId);
		
		//阴道分泌物
		String vaginalDischarges = laboratory.getVaginalDischarge();
		if (vaginalDischarges != null) {
			String[] vaginalDischarge = vaginalDischarges.split(",");
			
			List<String> list2 = new ArrayList<>();
			
			for (int i = 0; i < vaginalDischarge.length; i++) {
				list2.add(vaginalDischarge[i]);
			}
			mav.addObject("list2", list2);
		}
		
		
			reqs.put("laboratory", laboratory);
		
		
		//根据婚检id获取检查结果信息
		InspectionResultPO inspection = inspectionResultService.getInspectionByPremaritalId(premaritalId);
		
		//出具《婚前医学检查证明》日期
		Date issued = inspection.getIssuedByDate();
		if (issued != null) {
			String issuedByDate = DateUtil.dateToString(issued, DateStyle.YYYYMMDD);
			
			reqs.put("issuedByDate", issuedByDate);
		}
				
		
			reqs.put("inspection", inspection);
		
		String maritalConsultation = inspection.getMaritalConsultation();
		
		//根据婚检id获取转诊信息
		PremaritalReferralInfoPO preReferral = premaritalReferralInfoService.getPreReferralByPremaritalId(premaritalId);
		
		//转诊日期
		Date referral = preReferral.getReferralDate();
		if (referral != null) {
			String referralDate = DateUtil.dateToString(referral, DateStyle.YYYYMMDD);
			reqs.put("referralDate", referralDate);
			
		}
		
		//预约复诊日期
		Date appointment = preReferral.getAppointmentDate();
		if (appointment != null) {
			String appointmentDate = DateUtil.dateToString(appointment, DateStyle.YYYYMMDD);
			reqs.put("appointmentDate", appointmentDate);
		}
		
		
			reqs.put("preReferral", preReferral);
		
		
		reqs.put("birthday", birthday);
		reqs.put("creatTime", creatTime);
		
		reqs.put("lastMenstrualPeriod", lastMenstrualPeriod);
		reqs.put("maritalConsultation", maritalConsultation);
		
		mav.setViewName("/premarital/premarital_womanEdit");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 进入男性婚检修改页面
	 * @param reqs
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/toEditManPremarital", method = RequestMethod.GET)
	public ModelAndView toEditManPremarital(HttpServletRequest request,@RequestParam Map<String, Object> reqs) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		//省
		String manAccProvinceId = archivesInfoPO.getManAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(manAccProvinceId);
		
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//市
		String manAccCityId = archivesInfoPO.getManAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(manAccCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//县
		String manAccCountyId = archivesInfoPO.getManAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(manAccCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//乡
		String manAccTownshipId = archivesInfoPO.getManAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(manAccTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//村
		String manAccVillageId = archivesInfoPO.getManAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(manAccVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//家庭省
		String manHomeProvinceId = archivesInfoPO.getManHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(manHomeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String manHomeCityId = archivesInfoPO.getManHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(manHomeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String manHomeCountyId = archivesInfoPO.getManHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(manHomeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String manHomeTownshipId = archivesInfoPO.getManHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(manHomeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String manHomeVillageId = archivesInfoPO.getManHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(manHomeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//建档医生
		String doctorId = archivesInfoPO.getDoctorId();
		
		OperatorPO operatorPO = operatorService.getRealName(doctorId);
		
		if (operatorPO != null) {
			reqs.put("operatorPO", operatorPO);
		}
		
		//建档医院
		String depId = operatorPO.getDepId();
		
		DepartmentPO department = departmentService.getDepartmentById(depId);
		
		if (department != null) {
			reqs.put("department", department);
		}
			
		//出生日期
		String manBirthday = DateUtil.dateToString(archivesInfoPO.getManBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		//String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD_CN);
		
		//档案id
		String archivesId = archivesInfoPO.getId();
		
		//根据档案id获取婚检信息
		PremaritalExaInfoPO premarital = premaritalExaInfoService.findPremaritalByArchivesId(archivesId);
		
		//建档日期
		String creatTime = DateUtil.dateToString(premarital.getCreatTime(), DateStyle.YYYYMMDD);
		
		//修改婚检状态为未婚检，编辑状态为保存
		premarital.setEditStatus("0");
		premarital.setPremaritalStatus("0");
		
		
		premaritalExaInfoService.update(premarital);
		
		if (premarital != null) {
			reqs.put("premarital", premarital);
		}
		
		//获取当前婚检id
		String premaritalId = premarital.getId();
		
		//根据婚检id获取健康状况信息
		HealthInfoPO health = healthInfoService.getHealthByPremaritalId(premaritalId);
		
		//既往病史
		String medicalHistorys = health.getMedicalHistory();
		if (medicalHistorys != null) {
			String[] medicalHistory = medicalHistorys.split(",");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < medicalHistory.length; i++) {
				list.add(medicalHistory[i]);
			}
			mav.addObject("list", list);
		}
		
		//与遗传有关的家族
		String geneticHistorys = health.getGeneticHistory();
		if (geneticHistorys != null) {
			String[] geneticHistory = geneticHistorys.split(",");
			
			List<String> list1 = new ArrayList<>();
			
			for (int i = 0; i < geneticHistory.length; i++) {
				list1.add(geneticHistory[i]);
			}
			mav.addObject("list1", list1);
		}
		
		//与患者的关系
		String patientRelationships = health.getPatientRelationship();
		if (patientRelationships != null) {
			String[] patientRelationship = patientRelationships.split(",");
			List<String> list11 = new ArrayList<>();
			
			for (int i = 0; i < patientRelationship.length; i++) {
				list11.add(patientRelationship[i]);
			}
			mav.addObject("list11", list11);
		}
		
		if (health != null) {
			reqs.put("health", health);
		}
		
		//根据婚检id获取体格检查信息
		PhysiqueExaInfoPO physique = physiqueExaInfoService.getPhysiqueByPremaritalId(premaritalId);
		
		if (physique != null) {
			reqs.put("physique", physique);
		}
		
		//根据婚检id获取实验室检查信息
		LaboratorySpecialInsInfoPO laboratory = laboratorySpecialInsInfoService.getLaboratoryByPremaritalId(premaritalId);
		
		
		
		if (laboratory != null) {
			reqs.put("laboratory", laboratory);
		}
		
		//根据婚检id获取检查结果信息
		InspectionResultPO inspection = inspectionResultService.getInspectionByPremaritalId(premaritalId);
		
		//出具《婚前医学检查证明》日期
		Date issued = inspection.getIssuedByDate();
		if (issued != null) {
			String issuedByDate = DateUtil.dateToString(issued, DateStyle.YYYYMMDD);
			reqs.put("issuedByDate", issuedByDate);
		}
				
		if (inspection != null) {
			reqs.put("inspection", inspection);
		}
		
		
		String maritalConsultation = inspection.getMaritalConsultation();
		
		//根据婚检id获取转诊信息
		PremaritalReferralInfoPO preReferral = premaritalReferralInfoService.getPreReferralByPremaritalId(premaritalId);
		
		//转诊日期
		Date referral = preReferral.getReferralDate();
		if (referral != null) {
			String referralDate = DateUtil.dateToString(referral, DateStyle.YYYYMMDD);
			reqs.put("referralDate", referralDate);
		}
		
		//预约复诊日期
		Date appointment = preReferral.getAppointmentDate();
		if (appointment != null) {
			String appointmentDate = DateUtil.dateToString(appointment, DateStyle.YYYYMMDD);
			
			reqs.put("appointmentDate", appointmentDate);
			
		}
		
		if (preReferral != null) {
			reqs.put("preReferral", preReferral);
		}
		
		reqs.put("manBirthday", manBirthday);
		reqs.put("creatTime", creatTime);
		
		reqs.put("maritalConsultation", maritalConsultation);
		
		mav.setViewName("/premarital/premarital_manEdit");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 女性婚检报告
	 * @param reqs
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/womanPresentation", method = RequestMethod.GET)
	public ModelAndView womanPresentation(@RequestParam Map<String, Object> reqs,
										  @RequestParam("premaritalId") String premaritalId,
										  HttpSession session) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		String admId = archivesInfoService.getAdmId();
		
		String adminId = archivesInfoService.getAdminId();
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		//出生日期
		String birthday = DateUtil.dateToString(archivesInfoPO.getBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD);
		
		//当前医生
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String currentId = operator.getId();
		
		//家庭省
		String homeProvinceId = archivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(homeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String homeCityId = archivesInfoPO.getHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(homeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String homeCountyId = archivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(homeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String homeTownshipId = archivesInfoPO.getHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(homeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String homeVillageId = archivesInfoPO.getHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(homeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//户口省
		String accProvinceId = archivesInfoPO.getAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(accProvinceId);
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//户口市
		String accCityId = archivesInfoPO.getAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(accCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//户口县
		String accCountyId = archivesInfoPO.getAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(accCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//户口乡
		String accTownshipId = archivesInfoPO.getAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(accTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//户口村
		String accVillageId = archivesInfoPO.getAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(accVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
				
		//档案id
		String archivesId = archivesInfoPO.getId();
		
		//根据档案id获取婚检信息
		PremaritalExaInfoPO premarital = premaritalExaInfoService.findWomanPremaritalByArchivesId(archivesId);
		
		if (premarital != null) {
			reqs.put("premarital", premarital);
		}
		
		//获取当前婚检id
		//String premaritalId = premarital.getId();
		
		//根据婚检id获取健康状况信息
		HealthInfoPO health = healthInfoService.getHealthByPremaritalId(premaritalId);
		
		if (health != null) {
			reqs.put("health", health);
		}
		
		//既往病史
		String medicalHistorys = health.getMedicalHistory();
		if (medicalHistorys != null) {
			String[] medicalHistory = medicalHistorys.split(",");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < medicalHistory.length; i++) {
				list.add(medicalHistory[i]);
			}
			mav.addObject("list", list);
		}
		
		//与遗传有关的家族
		String geneticHistorys = health.getGeneticHistory();
		if (geneticHistorys != null) {
			String[] geneticHistory = geneticHistorys.split(",");
			
			List<String> list1 = new ArrayList<>();
			
			for (int i = 0; i < geneticHistory.length; i++) {
				list1.add(geneticHistory[i]);
			}
			mav.addObject("list1", list1);
		}
		
		//根据婚检id获取体格检查信息
		PhysiqueExaInfoPO physique = physiqueExaInfoService.getPhysiqueByPremaritalId(premaritalId);
		
		if (physique != null) {
			reqs.put("physique", physique);
		}
		
		//根据婚检id获取实验室检查信息
		LaboratorySpecialInsInfoPO laboratory = laboratorySpecialInsInfoService.getLaboratoryByPremaritalId(premaritalId);
		
		if (laboratory != null) {
			reqs.put("laboratory", laboratory);
		}
		
		//根据婚检id获取检查结果信息
		InspectionResultPO inspection = inspectionResultService.getInspectionByPremaritalId(premaritalId);
		
		//出具《婚前医学检查证明》日期
		Date issued = inspection.getIssuedByDate();
		if (issued != null) {
			String issuedByDate = DateUtil.dateToString(issued, DateStyle.YYYYMMDD);
			
			reqs.put("issuedByDate", issuedByDate);
		}
				
		if (inspection != null) {
			reqs.put("inspection", inspection);
		}
		
		//根据婚检id获取转诊信息
		PremaritalReferralInfoPO preReferral = premaritalReferralInfoService.getPreReferralByPremaritalId(premaritalId);
		
		//转诊日期
		Date referral = preReferral.getReferralDate();
		if (referral != null) {
			String referralDate = DateUtil.dateToString(referral, DateStyle.YYYYMMDD);
			reqs.put("referralDate", referralDate);
			
		}
		
		//预约复诊日期
		Date appointment = preReferral.getAppointmentDate();
		if (appointment != null) {
			String appointmentDate = DateUtil.dateToString(appointment, DateStyle.YYYYMMDD);
			reqs.put("appointmentDate", appointmentDate);
		}
		
		if (preReferral != null) {
			reqs.put("preReferral", preReferral);
		}
		
		reqs.put("birthday", birthday);
		reqs.put("creatTime", creatTime);
		reqs.put("admId", admId);
		reqs.put("adminId", adminId);
		reqs.put("premaritalId", premaritalId);
		reqs.put("currentId", currentId);
		
		mav.setViewName("/premarital/presentation_woman");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 男性婚检报告
	 * @param reqs
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manPresentation", method = RequestMethod.GET)
	public ModelAndView manPresentation(@RequestParam Map<String, Object> reqs,
										HttpSession session) {
		//log.debug("request page: /acty/activity/activity_update");
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		String admId = archivesInfoService.getAdmId();
		String adminId = archivesInfoService.getAdminId();
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		//当前医生
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String currentId = operator.getId();
		
		//出生日期
		String manBirthday = DateUtil.dateToString(archivesInfoPO.getManBirthday(), DateStyle.YYYYMMDD);
		//建档日期
		String creatTime = DateUtil.dateToString(archivesInfoPO.getCreatTime(), DateStyle.YYYYMMDD);
		
		//档案id
		String archivesId = archivesInfoPO.getId();
		
		//省
		String manAccProvinceId = archivesInfoPO.getManAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(manAccProvinceId);
		
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//市
		String manAccCityId = archivesInfoPO.getManAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(manAccCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//县
		String manAccCountyId = archivesInfoPO.getManAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(manAccCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//乡
		String manAccTownshipId = archivesInfoPO.getManAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(manAccTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//村
		String manAccVillageId = archivesInfoPO.getManAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(manAccVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//家庭省
		String manHomeProvinceId = archivesInfoPO.getManHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(manHomeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String manHomeCityId = archivesInfoPO.getManHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(manHomeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String manHomeCountyId = archivesInfoPO.getManHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(manHomeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String manHomeTownshipId = archivesInfoPO.getManHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(manHomeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String manHomeVillageId = archivesInfoPO.getManHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(manHomeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		//根据档案id获取婚检信息
		PremaritalExaInfoPO premarital = premaritalExaInfoService.findPremaritalByArchivesId(archivesId);
		
		if (premarital != null) {
			reqs.put("premarital", premarital);
		}
		
		//获取当前婚检id
		String premaritalId = premarital.getId();
		
		//根据婚检id获取健康状况信息
		HealthInfoPO health = healthInfoService.getHealthByPremaritalId(premaritalId);
		
		if (health != null) {
			reqs.put("health", health);
		}
		
		//既往病史
		String medicalHistorys = health.getMedicalHistory();
		if (medicalHistorys != null) {
			String[] medicalHistory = medicalHistorys.split(",");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < medicalHistory.length; i++) {
				list.add(medicalHistory[i]);
			}
			mav.addObject("list", list);
		}
		
		//与遗传有关的家族
		String geneticHistorys = health.getGeneticHistory();
		if (geneticHistorys != null) {
			String[] geneticHistory = geneticHistorys.split(",");
			
			List<String> list1 = new ArrayList<>();
			
			for (int i = 0; i < geneticHistory.length; i++) {
				list1.add(geneticHistory[i]);
			}
			mav.addObject("list1", list1);
		}
		
		//根据婚检id获取体格检查信息
		PhysiqueExaInfoPO physique = physiqueExaInfoService.getPhysiqueByPremaritalId(premaritalId);
		
		if (physique != null) {
			reqs.put("physique", physique);
		}
		
		//根据婚检id获取实验室检查信息
		LaboratorySpecialInsInfoPO laboratory = laboratorySpecialInsInfoService.getLaboratoryByPremaritalId(premaritalId);
		
		if (laboratory != null) {
			reqs.put("laboratory", laboratory);
		}
		
		//根据婚检id获取检查结果信息
		InspectionResultPO inspection = inspectionResultService.getInspectionByPremaritalId(premaritalId);
		
		//出具《婚前医学检查证明》日期
		Date issued= inspection.getIssuedByDate();
		if (issued != null) {
			String issuedByDate = DateUtil.dateToString(issued, DateStyle.YYYYMMDD);
			reqs.put("issuedByDate", issuedByDate);
		}
		//String issuedByDate = DateUtil.dateToString(inspection.getIssuedByDate(), DateStyle.YYYYMMDD);
				
		if (inspection != null) {
			reqs.put("inspection", inspection);
		}
		
		//根据婚检id获取转诊信息
		PremaritalReferralInfoPO preReferral = premaritalReferralInfoService.getPreReferralByPremaritalId(premaritalId);
		
		//转诊日期
		Date referral = preReferral.getReferralDate();
		if (referral != null) {
			String referralDate = DateUtil.dateToString(referral, DateStyle.YYYYMMDD);
			reqs.put("referralDate", referralDate);
			
		}
		
		//预约复诊日期
		Date appointment = preReferral.getAppointmentDate();
		if (appointment != null) {
			String appointmentDate = DateUtil.dateToString(appointment, DateStyle.YYYYMMDD);
			reqs.put("appointmentDate", appointmentDate);
			
		}
		
		if (preReferral != null) {
			reqs.put("preReferral", preReferral);
		}
		
		reqs.put("manBirthday", manBirthday);
		reqs.put("creatTime", creatTime);
		reqs.put("admId", admId);
		reqs.put("adminId", adminId);
		reqs.put("currentId", currentId);
		
		mav.setViewName("/premarital/presentation_man");
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 进入男性婚检页面
	 * @return
	 */
	@RequestMapping(value = "/manAdd", method = RequestMethod.GET)
	public ModelAndView premaritalManListAction(@RequestParam Map<String, Object> reqs, 
											 HttpSession session) {
		ModelAndView mav = new ModelAndView();
		ArchivesInfoPO archivesInfoPO = archivesInfoService.find(reqs.get("id").toString());
		
		//出生日期
		String manBirthday = DateUtil.dateToString(archivesInfoPO.getManBirthday(), DateStyle.YYYYMMDD);
		
		if (archivesInfoPO != null) {
			reqs.put("archivesInfo", archivesInfoPO);
		}
		
		String time = DateUtil.dateToString(new Date(), DateStyle.YYYYMMDD);
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		//省
		String manAccProvinceId = archivesInfoPO.getManAccProvinceId();
		ProvinceInfoPO provinceInfo = provinceInfoService.find(manAccProvinceId);
		
		if (provinceInfo != null) {
			reqs.put("provinceInfo", provinceInfo);
		}
		
		//市
		String manAccCityId = archivesInfoPO.getManAccCityId();
		CityInfoPO cityInfo = cityInfoService.find(manAccCityId);
		if (cityInfo != null) {
			reqs.put("cityInfo", cityInfo);
		}
		
		//县
		String manAccCountyId = archivesInfoPO.getManAccCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo = districtAndCountyInfoService.find(manAccCountyId);
		if (districtAndCountyInfo != null) {
			reqs.put("districtAndCountyInfo", districtAndCountyInfo);
		}
		
		//乡
		String manAccTownshipId = archivesInfoPO.getManAccTownshipId();
		TownshipInfoPO townshipInfo = townshipInfoService.find(manAccTownshipId);
		if (townshipInfo != null) {
			reqs.put("townshipInfo", townshipInfo);
		}
		
		//村
		String manAccVillageId = archivesInfoPO.getManAccVillageId();
		VillageInfoPO villageInfo = villageInfoService.find(manAccVillageId);
		if (villageInfo != null) {
			reqs.put("villageInfo", villageInfo);
		}
		
		//家庭省
		String manHomeProvinceId = archivesInfoPO.getManHomeProvinceId();
		ProvinceInfoPO provinceInfo1 = provinceInfoService.find(manHomeProvinceId);
		if (provinceInfo1 != null) {
			reqs.put("provinceInfo1", provinceInfo1);
		}
		
		//家庭市
		String manHomeCityId = archivesInfoPO.getManHomeCityId();
		CityInfoPO cityInfo1 = cityInfoService.find(manHomeCityId);
		if (cityInfo1 != null) {
			reqs.put("cityInfo1", cityInfo1);
		}
		
		//家庭县
		String manHomeCountyId = archivesInfoPO.getManHomeCountyId();
		DistrictAndCountyInfoPO districtAndCountyInfo1 = districtAndCountyInfoService.find(manHomeCountyId);
		if (districtAndCountyInfo1 != null) {
			reqs.put("districtAndCountyInfo1", districtAndCountyInfo1);
		}
		
		//家庭乡
		String manHomeTownshipId = archivesInfoPO.getManHomeTownshipId();
		TownshipInfoPO townshipInfo1 = townshipInfoService.find(manHomeTownshipId);
		if (townshipInfo1 != null) {
			reqs.put("townshipInfo1", townshipInfo1);
		}
		
		//家庭村
		String manHomeVillageId = archivesInfoPO.getManHomeVillageId();
		VillageInfoPO villageInfo1 = villageInfoService.find(manHomeVillageId);
		if (villageInfo1 != null) {
			reqs.put("villageInfo1", villageInfo1);
		}
		
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		//当前医院
		String val = operator2.getDepartment();
		//当前医院级别
		String  level = departmentService.queryQyByName(val) ;
		
		//获取指导意见
		DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.getMan();
		
		reqs.put("directiveOpinionTemplatePO", directiveOpinionTemplatePO);
		
		mav.setViewName("/inspect/premarital_man");
		reqs.put("time", time);
		reqs.put("manBirthday", manBirthday);
		reqs.put("operator",operator2);
		mav.addObject("archivesInfoDetail",reqs);
		return mav;
	}
	
	/**
	 * 转诊机构
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/hospital", method = RequestMethod.GET)
	public Model hospitalAction(HttpSession session) {
		Model mav = new Model();
		
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		//当前医院
		String val = operator2.getDepartment();
		//当前医院级别
		String  level = departmentService.queryQyByName(val) ;
		
		List<DepartmentPO> list  = null ;
		list = departmentService.getAllDepartment();
			/*if ("2".equals(level)) {
				list = departmentService.findXiangHospital();
			}else if ("1".equals(level)) {
				list = departmentService.findXianHospital();
			}*/
			/*else if (level.equals("0")) {
				list = departmentService.findXianHospital();
			}*/
		
		mav.set("list", list);;
		return mav;
	}
	
	/**
	 * 预约医生
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public Model doctor(HttpSession session) {
		Model mav = new Model();
		
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		//当前部门id
		String depId = operator.getDepId();
		//
		List<OperatorPO> list = operatorService.findDoctor(depId);
		
		mav.set("list", list);;
		return mav;
	}
	
	/**
	 * 获取指定传染病
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/excTerm", method = RequestMethod.GET)
	public Model excTerm1() {
		Model mav = new Model();
		//获取指定传染病
		List<PremaritalAbnormalOptionPO> list0 = premaritalAbnormalOptionService.getExcTerm1();
		mav.set("list0", list0);
		
		//严重遗传病
		List<PremaritalAbnormalOptionPO> list1 = premaritalAbnormalOptionService.getExcTerm2();
		mav.set("list1", list1);
		
		//精神病
		List<PremaritalAbnormalOptionPO> list2 = premaritalAbnormalOptionService.getExcTerm3();
		mav.set("list2", list2);
		
		//男性生殖系统疾病
		List<PremaritalAbnormalOptionPO> list3 = premaritalAbnormalOptionService.getExcTerm4();
		mav.set("list3", list3);
		
		//女性生殖系统疾病
		List<PremaritalAbnormalOptionPO> list4 = premaritalAbnormalOptionService.getExcTerm5();
		mav.set("list4", list4);
		
		//内科疾病
		List<PremaritalAbnormalOptionPO> list5 = premaritalAbnormalOptionService.getExcTerm6();
		mav.set("list5", list5);
				
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/doctor")
	public Model doctorAction(@RequestParam("parentId")String val) {
		Model model = new Model();
		
		List<OperatorPO> list  = departmentService.findDoctorName(val);
		
		if (list != null) {
			
			model.set("list", list);
		}
		
		return model;
	}
}