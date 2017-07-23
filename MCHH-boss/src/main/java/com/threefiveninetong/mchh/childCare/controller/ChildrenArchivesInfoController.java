/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenArchivesInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 10:17:29 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.childCare.po.ChildrenArchivesInfoPO;
import com.threefiveninetong.mchh.childCare.po.ChildrenHealthExaInfoPO;
import com.threefiveninetong.mchh.childCare.service.ChildrenArchivesInfoService;
import com.threefiveninetong.mchh.childCare.service.ChildrenHealthExaInfoService;
import com.threefiveninetong.mchh.childCare.vo.ChildrenArchivesInfoVO;
import com.threefiveninetong.mchh.childbirth.po.SelectChildBaby;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBabyInfoService;
import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.service.CityInfoService;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.prenatal.service.PrenatalExaInfoService;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.service.DepartmentService;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ChildrenArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:29 
 */
@Controller
@RequestMapping("/childrenarchives")
public class ChildrenArchivesInfoController {

	private static final Logger log =Logger.getLogger(ChildrenArchivesInfoController.class);
	@Resource
	private  ChildrenArchivesInfoService  childrenArchivesInfoService;
	
	@Resource
	private OperatorService operatorService; 
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private ChildbirthBabyInfoService childbirthBabyService;
	
	@Resource
	private PrenatalExaInfoService prenatalExaInfoService;
	
	@Resource
	private ProvinceInfoService provinceService;
	
	@Resource
	private CityInfoService cityService;
	
	@Resource
	private DistrictAndCountyInfoService districtAndCountyInfoService;
	
	@Resource
	private TownshipInfoService townshipInfoService;
	
	@Resource
	private VillageInfoService villageInfoService;
	
	@Resource
	private ChildrenHealthExaInfoService childrenHealthExaInfoService;
	
	@RequestMapping(value="/joinCheck",method=RequestMethod.GET)
	public ModelAndView joinCheck(@RequestParam("archivesId")String archivesId,
								  HttpSession session,
								  @RequestParam("sign")String sign){
		ModelAndView mv = new ModelAndView();
		//sign 0 ：不正常  1：正常 
		mv.addObject("sign", sign);
		
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		mv.addObject("operator", operator2);
		
		ChildrenArchivesInfoPO childrenArchivesInfoPO = childrenArchivesInfoService.find(archivesId);
		mv.addObject("archives", childrenArchivesInfoPO);
		
		//助产机构
		String institutions = childrenArchivesInfoPO.getInstitutions();
		DepartmentPO department = new DepartmentPO();
		if(institutions.length() > 1){
			department = departmentService.getDepartmentById(institutions);
			mv.addObject("department", department);
		}else if(institutions.length() == 1){
			department.setName("其他");
			department.setId("1");
			mv.addObject("department", department);
		}
		
		//家庭住址
		String homeProvinceId = childrenArchivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO homeProvince = provinceService.find(homeProvinceId);
		mv.addObject("homeProvince", homeProvince);
		String homeCityId = childrenArchivesInfoPO.getHomeCityId();
		CityInfoPO homeCity = cityService.find(homeCityId);
		mv.addObject("homeCity", homeCity);
		String homeCountyId = childrenArchivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO homeCounty = districtAndCountyInfoService.find(homeCountyId);
		mv.addObject("homeCounty", homeCounty);
		String homeTownshipId = childrenArchivesInfoPO.getHomeTownshipId();
		TownshipInfoPO homeTown = townshipInfoService.find(homeTownshipId);
		mv.addObject("homeTown", homeTown);
		String homeVillageId = childrenArchivesInfoPO.getHomeVillageId();
		VillageInfoPO homeVillage = villageInfoService.find(homeVillageId);
		mv.addObject("homeVillage", homeVillage);
		
		//出生情况
		String birthCondition = childrenArchivesInfoPO.getBirthCondition();
		List<String> birthConditions = new ArrayList<>();
		if(birthCondition.length() > 1){
			String[] split = birthCondition.split(",");
			Collections.addAll(birthConditions, split);
		}else if(birthCondition.length() == 1){
			birthConditions.add(birthCondition);
		}
		mv.addObject("birthConditions", birthConditions);
		
		//母亲妊娠期异常
		String pregnancySickness = childrenArchivesInfoPO.getPregnancySickness();
		List<String> pregns = new ArrayList<>();
		if(pregnancySickness.length() > 1){
			String[] split = pregnancySickness.split(",");
			Collections.addAll(pregns, split);
		}else if(pregnancySickness.length() == 1){
			pregns.add(pregnancySickness);
		}
		mv.addObject("pregns", pregns);
		
		//婴儿年龄显示用
		Date birthday = childrenArchivesInfoPO.getBirthday();
		String babyAge = "";
		if(birthday != null){
			babyAge = DateUtils.getBabyAgeUseShow(birthday);
		}
		mv.addObject("babyAge", babyAge);
		
		List<ChildrenHealthExaInfoPO> childExaList = childrenHealthExaInfoService.getAllExaByArchivesId(archivesId);
		if(childExaList.size() == 0){
			mv.setViewName("/childCare/childrenFamliExa");
		}
		
		return mv;
	}
	
	/**
	 * 删除档案信息（数据库中删除状态改为1）
	 * @param archivesId
	 * @return
	 * @author ywk
	 */
	@RequestMapping(value="/delArchives",method=RequestMethod.GET)
	public ModelAndView delArchives(@RequestParam("archivesId")String archivesId){
		ModelAndView mv = new ModelAndView();
		childrenArchivesInfoService.delArchives(archivesId);
		
		mv.setViewName("redirect:/childrenarchives/list");
		return mv;
	}
	
	/**
	 * 编辑档案信息的保存
	 * @param childrenArchivesInfoPO
	 * @param creat
	 * @param discharge
	 * @return
	 * @author ywk
	 */
	@RequestMapping(value="/saveArchives",method=RequestMethod.POST)
	public ModelAndView saveArchives(ChildrenArchivesInfoPO childrenArchivesInfoPO,
									 @RequestParam("creatTime")String creat,
									 /*@RequestParam("birthday")String birth,*/
									 @RequestParam("dischargeDate")String discharge
									 /*@RequestParam("momBirthday")String momBirth,
									 @RequestParam("dadBirthday")String dadBirth*/){
		ModelAndView mv = new ModelAndView();
		//Date birthday = null;
		Date dischargeDate = null;
		//Date momBirthday = null;
		//Date dadBirthday = null;
		/*if(birth != null && birth != ""){
			birthday = DateUtil.stringToDate(birth);
		}*/
		if(discharge != null && discharge != ""){
			dischargeDate = DateUtil.stringToDate(discharge);
		}
		/*if(momBirth != null && momBirth != ""){
			momBirthday = DateUtil.stringToDate(momBirth);
		}
		if(dadBirth != null && dadBirth != ""){
			dadBirthday = DateUtil.stringToDate(dadBirth);
		}*/
		/*childrenArchivesInfoPO.setBirthday(birthday);*/
		childrenArchivesInfoPO.setDischargeDate(dischargeDate);
		/*childrenArchivesInfoPO.setMomBirthday(momBirthday);
		childrenArchivesInfoPO.setDadBirthday(dadBirthday);*/
		Date date = new Date();
		if(creat != null && creat != ""){
			Date create = DateUtil.stringToDate(creat);
			date.setYear(create.getYear());
			date.setMonth(create.getMonth());
			date.setDate(create.getDate());
			childrenArchivesInfoPO.setCreatTime(date);
		}else{
			childrenArchivesInfoPO.setCreatTime(childrenArchivesInfoService.find(childrenArchivesInfoPO.getId()).getCreatTime());
		}
		childrenArchivesInfoService.saveUpdateArchives(childrenArchivesInfoPO);
		mv.setViewName("redirect:/childrenarchives/list");
		return mv;
	}

	/**
	 * 查询档案信息并通过sign来判断进入详情页还是修改页面
	 * @param id
	 * @param sign
	 * @return
	 * @author ywk
	 */
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public ModelAndView archivesDetail(@RequestParam("id")String id,@RequestParam("sign")String sign){
		ModelAndView mv = new ModelAndView();
		
		ChildrenArchivesInfoPO childrenArchivesInfoPO = childrenArchivesInfoService.find(id);
		String doctorId = childrenArchivesInfoPO.getDoctorId();
		OperatorPO operator = operatorService.getOperatorById(doctorId);
		
		//家庭住址
		String homeProvinceId = childrenArchivesInfoPO.getHomeProvinceId();
		ProvinceInfoPO homeProvince = provinceService.find(homeProvinceId);
		mv.addObject("homeProvince", homeProvince);
		String homeCityId = childrenArchivesInfoPO.getHomeCityId();
		CityInfoPO homeCity = cityService.find(homeCityId);
		mv.addObject("homeCity", homeCity);
		String homeCountyId = childrenArchivesInfoPO.getHomeCountyId();
		DistrictAndCountyInfoPO homeCounty = districtAndCountyInfoService.find(homeCountyId);
		mv.addObject("homeCounty", homeCounty);
		String homeTownshipId = childrenArchivesInfoPO.getHomeTownshipId();
		TownshipInfoPO homeTown = townshipInfoService.find(homeTownshipId);
		mv.addObject("homeTown", homeTown);
		String homeVillageId = childrenArchivesInfoPO.getHomeVillageId();
		VillageInfoPO homeVillage = villageInfoService.find(homeVillageId);
		mv.addObject("homeVillage", homeVillage);
		
		//户口地址
		String accProvinceId = childrenArchivesInfoPO.getAccProvinceId();
		ProvinceInfoPO accProvince = provinceService.find(accProvinceId);
		mv.addObject("accProvince", accProvince);
		String accCityId = childrenArchivesInfoPO.getAccCityId();
		CityInfoPO accCity = cityService.find(accCityId);
		mv.addObject("accCity", accCity);
		String accCountyId = childrenArchivesInfoPO.getAccCountyId();
		DistrictAndCountyInfoPO accCounty = districtAndCountyInfoService.find(accCountyId);
		mv.addObject("accCounty", accCounty);
		String accTownshipId = childrenArchivesInfoPO.getAccTownshipId();
		TownshipInfoPO accTown = townshipInfoService.find(accTownshipId);
		mv.addObject("accTown", accTown);
		String accVillageId = childrenArchivesInfoPO.getAccVillageId();
		VillageInfoPO accVillage = villageInfoService.find(accVillageId);
		mv.addObject("accVillage", accVillage);
		
		//出生情况
		String birthCondition = childrenArchivesInfoPO.getBirthCondition();
		List<String> birthConditions = new ArrayList<>();
		if(birthCondition.length() > 1){
			String[] split = birthCondition.split(",");
			Collections.addAll(birthConditions, split);
		}else if(birthCondition.length() == 1){
			birthConditions.add(birthCondition);
		}
		mv.addObject("birthConditions", birthConditions);
		
		//母亲妊娠期异常
		String pregnancySickness = childrenArchivesInfoPO.getPregnancySickness();
		List<String> pregns = new ArrayList<>();
		if(pregnancySickness.length() > 1){
			String[] split = pregnancySickness.split(",");
			Collections.addAll(pregns, split);
		}else if(pregnancySickness.length() == 1){
			pregns.add(pregnancySickness);
		}
		mv.addObject("pregns", pregns);
		
		//助产机构
		String institutions = childrenArchivesInfoPO.getInstitutions();
		DepartmentPO department = new DepartmentPO();
		if(institutions.length() > 1){
			department = departmentService.getDepartmentById(institutions);
			mv.addObject("department", department);
		}else if(institutions.length() == 1){
			department.setName("其他");
			department.setId("1");
			mv.addObject("department", department);
		}
		
		//妈妈健康状况
		String momHealth = childrenArchivesInfoPO.getMomHealth();
		List<String> momHealths = new ArrayList<>();
		if(momHealth.length() > 1){
			String[] split = momHealth.split(",");
			Collections.addAll(momHealths, split);
		}else if(momHealth.length() == 1){
			momHealths.add(momHealth);
		}
		mv.addObject("momHealths", momHealths);
		
		List<DepartmentPO> list = departmentService.getAllDepartment();
		
		mv.addObject("list", list);
		
		//妈妈家族史
		String momFamHistory = childrenArchivesInfoPO.getMomFamHistory();
		List<String> momFamHistorys = new ArrayList<>();
		if(momFamHistory.length() > 1){
			String[] split = momFamHistory.split(",");
			Collections.addAll(momFamHistorys, split);
		}else if(momFamHistory.length() == 1){
			momFamHistorys.add(momFamHistory);
		}
		mv.addObject("momFamHistorys", momFamHistorys);
		
		//爸爸健康状况
		String babHealth = childrenArchivesInfoPO.getBabHealth();
		List<String> babHealths = new ArrayList<>();
		if(babHealth.length() > 1){
			String[] split = babHealth.split(",");
			Collections.addAll(babHealths, split);
		}else if(babHealth.length() == 1){
			babHealths.add(babHealth);
		}
		mv.addObject("babHealths", babHealths);
		
		//爸爸家族史
		String babFamHistory = childrenArchivesInfoPO.getBabFamHistory();
		List<String> babFamHistorys = new ArrayList<>();
		if(babFamHistory.length() > 1){
			String[] split = babFamHistory.split(",");
			Collections.addAll(babFamHistorys, split);
		}else if(babFamHistory.length() == 1){
			babFamHistorys.add(babFamHistory);
		}
		mv.addObject("babFamHistorys", babFamHistorys);
		
		//妈妈年龄
		Date momBirthday = childrenArchivesInfoPO.getMomBirthday();
		if(momBirthday != null){
			int momAge = new Date().getYear() - momBirthday.getYear();
			mv.addObject("momAge", momAge);
		}
		//爸爸年龄
		Date dadBirthday = childrenArchivesInfoPO.getDadBirthday();
		if(dadBirthday != null){
			int dadAge = new Date().getYear() - dadBirthday.getYear();
			mv.addObject("dadAge", dadAge);
		}
		
		//婴儿年龄
		Date birthday = childrenArchivesInfoPO.getBirthday();
		String babyAge = "";
		if(birthday != null){
			babyAge = DateUtils.getBabyAgeUseShow(birthday);
		}
		mv.addObject("babyAge", babyAge);
		mv.addObject("operator", operator);
		mv.addObject("archives", childrenArchivesInfoPO);
		if("0".equals(sign)){
			mv.setViewName("/childCare/archives_deatil");
		}
		if("1".equals(sign)){
			mv.setViewName("/childCare/archives_update");
		}
		return mv;
	}
	
	/**
	 * 儿童建档返回档案信息
	 * @param childrenArchivesInfoPO
	 * @param session
	 * @param birth
	 * @param discharge
	 * @param momBirth
	 * @param dadBirth
	 * @param grantSign
	 * @return
	 * @author ywk
	 */
	@ResponseBody
	@RequestMapping(value="/buildArchives",method=RequestMethod.POST)
	public Model buildArchives(ChildrenArchivesInfoPO childrenArchivesInfoPO,
							   HttpSession session,
							   @RequestParam("birthday")String birth,
							   @RequestParam("dischargeDate")String discharge,
							   @RequestParam("momBirthday")String momBirth,
							   @RequestParam("dadBirthday")String dadBirth,
							   @RequestParam("grantSign")String grantSign){
		Model model = new Model();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		Date birthday = null;
		Date dischargeDate = null;
		Date momBirthday = null;
		Date dadBirthday = null;
		if(birth != null && birth != ""){
			birthday = DateUtil.stringToDate(birth);
		}
		if(discharge != null && discharge != ""){
			dischargeDate = DateUtil.stringToDate(discharge);
		}
		if(momBirth != null && momBirth != ""){
			momBirthday = DateUtil.stringToDate(momBirth);
		}
		if(dadBirth != null && dadBirth != ""){
			dadBirthday = DateUtil.stringToDate(dadBirth);
		}
		childrenArchivesInfoPO.setBirthday(birthday);
		childrenArchivesInfoPO.setDischargeDate(dischargeDate);
		childrenArchivesInfoPO.setMomBirthday(momBirthday);
		childrenArchivesInfoPO.setDadBirthday(dadBirthday);
		childrenArchivesInfoPO.setDoctorId(operator.getId());
		childrenArchivesInfoPO.setHospitalId(operator.getDepId());
		ChildrenArchivesInfoPO childrenArchives = childrenArchivesInfoService.bulidArchives(childrenArchivesInfoPO,grantSign);
		model.set("childrenArchives", childrenArchives);
		return model;
	}
	
	/**
	 * 查询妈妈信息
	 * @param reqs
	 * @param page
	 * @return
	 * @author ywk
	 */
	@ResponseBody
	@RequestMapping(value="/selectChildBirth",method=RequestMethod.POST)
	public Model selectChildBirth(@RequestParam Map<String, Object> reqs, Page<SelectChildBaby> page){
		log.debug("request data: selectChildBirth");
		Model model = new Model();
		try {
			childbirthBabyService.selectChildBirth(reqs,page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * 去儿童建档页
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value="/buildChidlArchives",method=RequestMethod.GET)
	public ModelAndView joinChildrenView(HttpSession session){
		ModelAndView mv = new ModelAndView();
		
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		
		List<DepartmentPO> list = departmentService.getAllDepartment();
		
		mv.addObject("list", list);
		mv.addObject("operator", operator2);
		mv.setViewName("/childCare/children_archives");
		return mv;
	}
	
    /**
	 * CHILDREN_ARCHIVES_INFO 列表视图
	 * @return
	 * @author ywk
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listChildrenArchivesInfoView(HttpSession session) {
		log.debug("request page: /sysset/childrenArchivesInfo/childrenArchivesInfo_list");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/prenatal/prenatal_list");
		String adminId = prenatalExaInfoService.getAdminId();
		String doctorAdminId = prenatalExaInfoService.getDoctorAdminId();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		mv.addObject("adminId", adminId);
		mv.addObject("doctorAdminId", doctorAdminId);
		mv.addObject("doctorId", operator.getId());
		mv.addObject("depId", operator.getDepId());
		
		mv.setViewName("/childCare/children_list");
		return mv;
	}
	/**
	 * CHILDREN_ARCHIVES_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenArchivesInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenArchivesInfoPO> page) {
		log.debug("request data: listChildrenArchivesInfo");
		Model model = new Model();
		try {
			childrenArchivesInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_ARCHIVES_INFO 添加
	 * 
	 * @param childrenArchivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenArchivesInfoActoin(ChildrenArchivesInfoVO childrenArchivesInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenArchivesInfoPO childrenArchivesInfoPO = new ChildrenArchivesInfoPO();
			BeanUtils.copyProperties(childrenArchivesInfoPO, childrenArchivesInfoVO);
			childrenArchivesInfoService.create(childrenArchivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_ARCHIVES_INFO 修改
	 * 
	 * @param childrenArchivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenArchivesInfoActoin(ChildrenArchivesInfoVO childrenArchivesInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenArchivesInfoPO childrenArchivesInfoPO = new ChildrenArchivesInfoPO();
			BeanUtils.copyProperties(childrenArchivesInfoPO, childrenArchivesInfoVO);
			childrenArchivesInfoService.update(childrenArchivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_ARCHIVES_INFO 删除
	 * 
	 * @param childrenArchivesInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenArchivesInfoAction(@RequestParam("childrenArchivesInfoIds") String childrenArchivesInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenArchivesInfoService.deletes(childrenArchivesInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}