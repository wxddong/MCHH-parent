/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.controller;


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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.ArchivesInfoService;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBasicInfoService;
import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.service.DirectiveOpinionTemplateService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.postpartum.dto.HistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.dto.PostHistoryCheckVO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaDetailedInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumExaOtherInfoPO;
import com.threefiveninetong.mchh.postpartum.po.PostpartumReferralInfoPO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaDetailedInfoService;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaInfoService;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaOtherInfoService;
import com.threefiveninetong.mchh.postpartum.service.PostpartumReferralInfoService;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumExaDetailedInfoVO;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumExaInfoVO;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumExaOtherInfoVO;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumReferralInfoVO;
import com.threefiveninetong.mchh.prenatal.service.PrenatalExaInfoService;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.RolePO;
import com.threefiveninetong.mchh.sys.service.DepartmentService;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.service.RoleService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * 
 * @ClassName: PostpartumExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
@Controller
@RequestMapping("/postpartum/postpartumexainfo")
public class PostpartumExaInfoController {

	private static final Logger log =Logger.getLogger(PostpartumExaInfoController.class);
	@Resource
	private  PostpartumExaInfoService  postpartumExaInfoService;
	@Resource
	private OperatorService operatorService;
	@Resource
	private ArchivesInfoService archivesInfoService;
	@Resource
	private BirthArchivesInfoService birthArchivesInfoService;
	@Resource
	private  ChildbirthBasicInfoService  childbirthBasicInfoService;
	@Resource
	private  PostpartumExaDetailedInfoService  postpartumExaDetailedInfoService;
	@Resource
	private  PostpartumExaOtherInfoService  postpartumExaOtherInfoService;
	@Resource
	private  PostpartumReferralInfoService  postpartumReferralInfoService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private RoleService roleService;
	@Resource
	private  PrenatalExaInfoService  prenatalExaInfoService;
	@Resource
	private DirectiveOpinionTemplateService directiveOpinionTemplateService;
	
	/**
	 * 前往编辑页面，根据页面携带的产后检查的id查询出茶后检查信息，携带导编辑页面用来回显
	 * @param map
	 * @param postpartumExaId
	 * @return 
	 */
	@RequestMapping(value="/toPostExaEdit")
	public String toEditUI(Map<String,Object> map,
						   HttpSession session,
						   @RequestParam(value="postpartumExaId")String postpartumExaId,
						   @RequestParam(value="archiveId")String archiveId){
		
		//从session中获取用户的信息 
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		map.put("operator", operator2);
		//从session中获取当前医院的名称，根据部门名称确定部门等级（0是县医院，1乡医院，2是村医院），然后查询上级部门的医院显示在下拉列表中
//		String department = operator2.getDepartment();
//		String level = departmentService.queryQyByName(department);
//		List<DepartmentPO> hospitals = null;
//		if("2".equals(level)){
//			//level位2时证明是村医院，需要转的机构为乡医院
//			hospitals = departmentService.findXiangHospital();
//		}else if("1".equals(level)){
//			//level位1时证明是乡医院，需要转的机构为县医院
//			hospitals = departmentService.findXianHospital();
//		}
		List<DepartmentPO> hospitals = departmentService.getAllDepartment();
		map.put("hospitals", hospitals);
		
		//查询角色列表用于转诊科室下拉列表的回显
		List<RolePO> roleList = roleService.getAll();
		map.put("roleList", roleList);
		
		//根据档案id获取建档人的信息（档案表）
		ArchivesInfoPO archives = archivesInfoService.find(archiveId);
		map.put("archives", archives);
		Date birthday = archives.getBirthday();
		//根据出生日期计算年龄
		//女方年龄
		if(birthday!=null){
			int womenAge = DateUtils.getAgeByBirthday(birthday);
			map.put("womenAge", womenAge);
		}

		Date manBirthday = archives.getManBirthday();
		if(manBirthday!=null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			map.put("manAge", manAge);
		}
		//男方年龄	
		map.put("archiveId", archiveId);
		//根据档案id获取选出最近的生育档案
		BirthArchivesInfoPO birthArchives=birthArchivesInfoService.getBirthArchivesByArchivesId(archiveId);
		map.put("birthArchives", birthArchives);
		//获取生育档案表中的id
		String birthArchivesId = birthArchives.getId();
		//将生育id放在域对象中
		map.put("birthArchivesId", birthArchivesId);
		
		//根据生育档案表查询是否有产前随访记录若没有则视为该孕妇没有完成孕产登记，隐藏结案按钮
		int countPrenatalByBirthId = prenatalExaInfoService.countPrenatalByBirthId(birthArchivesId);
		map.put("prenatalCount", countPrenatalByBirthId);
		
		ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
		map.put("childbirthBasic", childbirthBasic);
		
		Date expectedDate = birthArchives.getPredictDate();
		map.put("expectedDate", expectedDate);
		
		
		//根据产后检查的id获取产后检查记录，用于编辑页面的回显
		//1.查询产后检查主表（条件为产后检查id）
		PostpartumExaInfoPO postpartumExa = postpartumExaInfoService.findPostpartumExa(postpartumExaId);
		map.put("postpartumExa", postpartumExa);
		
		//2.查询产后检查详情表(根据产后检查的id查询)
		PostpartumExaDetailedInfoPO postpartumExaDetailed = postpartumExaDetailedInfoService.getPostpartumExaDetailByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaDetailed", postpartumExaDetailed);
		
		//3.查询产后检查其他项信息表(根据产后检查的id查询)
		PostpartumExaOtherInfoPO postpartumExaOther = postpartumExaOtherInfoService.getPostpartumExaOtherByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaOther", postpartumExaOther);
		
		//4.查询产后访视转诊信息表(根据产后检查的id查询)
		PostpartumReferralInfoPO postpartumReferral = postpartumReferralInfoService.getPostpartumReferralByPostpartumExaId(postpartumExaId);
		map.put("postpartumReferral", postpartumReferral);
		//获取检查的数据是否是正常数据 1位正常数据 0为非正常数据即造假数据
		String normalSign = postpartumExa.getNormalSign();
		map.put("ifFalse", normalSign);
		
		if("0".equals(postpartumExa.getType())){
			if("0".equals(postpartumExa.getEditStatus())){
				//如果是出院后三到七天访视 并且是保存状态 进入3-7天保存的编辑页面
				return "postpartum/PostpartumExa3to7Save_edit";
			}
			//如果是出院后三到七天访视 并且是完成状态 进入3-7天完成的编辑页面
			return "postpartum/PostpartumExa3to7_edit";
		}
		if("1".equals(postpartumExa.getType()) && "0".equals(postpartumExa.getEditStatus())){
			//如果是产后三到42天访视 并且是保存状态 进入42天保存的编辑页面
			return "postpartum/PostpartumExa42Save_edit";
		}
		//如果是产后三到42天访视 并且是完成状态 进入42天完成的编辑页面
		return "postpartum/PostpartumExa42_edit";
	}
	
	/**
	 * 添加完成前往出院3-7天或产后42天健康检查记录表
	 * @param archiveId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/postExaRecord")
	public String toExaRecord(@RequestParam(value="archiveId")String archiveId,
							  @RequestParam(value="postpartumExaId")String postpartumExaId,
			  				  Map<String,Object> map){
		
		//根据档案id获取建档人的信息（档案表）
		ArchivesInfoPO archives = archivesInfoService.find(archiveId);
		map.put("archives", archives);
		
		//根据档案id获取选出最近的生育档案
		BirthArchivesInfoPO birthArchives=birthArchivesInfoService.getBirthArchivesByArchivesId(archiveId);
		//获取生育档案表中的id
		String birthArchivesId = birthArchives.getId();
		
		
		//添加完成后有是否要打印页面，从添加完成传过来的postpartumExaId为‘toQuery’,需要查询刚刚添加完成的检查表相关信息
		PostpartumExaInfoPO postpartumExa = null;
		if("toQuery".equals(postpartumExaId)){
			//产后检查id查询检查信息，携带到预览页面(从四张表中查询，封装进四个对象中)
			//1.查询产后检查主表（条件为生育档案id，时间最晚的，edit_status为1）
			postpartumExa = postpartumExaInfoService.findLatestPostpartumExa(birthArchivesId);
			postpartumExaId = postpartumExa.getId();
		}else{
			//产后检查id查询检查信息，携带到预览页面(从四张表中查询，封装进四个对象中)
			//1.查询产后检查主表（条件为产后检查id）
			postpartumExa = postpartumExaInfoService.findPostpartumExa(postpartumExaId);
		}
		
		map.put("postpartumExa", postpartumExa);
		map.put("postpartumExaId", postpartumExaId);
		//2.查询产后检查详情表(根据产后检查的id查询)
		PostpartumExaDetailedInfoPO postpartumExaDetailed = postpartumExaDetailedInfoService.getPostpartumExaDetailByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaDetailed", postpartumExaDetailed);
		
		//3.查询产后检查其他项信息表(根据产后检查的id查询)
		PostpartumExaOtherInfoPO postpartumExaOther = postpartumExaOtherInfoService.getPostpartumExaOtherByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaOther", postpartumExaOther);
		
		//4.查询产后访视转诊信息表(根据产后检查的id查询)
		PostpartumReferralInfoPO postpartumReferral = postpartumReferralInfoService.getPostpartumReferralByPostpartumExaId(postpartumExaId);
		map.put("postpartumReferral", postpartumReferral);
		//根据转诊机构获取机构的名称
		String mechanismId = postpartumReferral.getMechanism();
		String mechanismName = postpartumExaInfoService.getMechanismById(mechanismId);
		map.put("mechanismName", mechanismName);
		
		if("0".equals(postpartumExa.getType())){
			return "postpartum/3to7ExaRecord";
		}
		
		return "postpartum/42ExaRecord";
	}
	
	/**
	 * 前往出院3-7天或产后42天健康检查印反馈单的页面
	 * wangxd 2016.9.10
	 * @param archivesCode
	 * @param name
	 * @param womenAge
	 * @param birthDate
	 * @param birthArchivesId
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/ExaFeedBack")
	public String toExaFeedBack(@RequestParam(value="archiveId")String archiveId,
								  @RequestParam(value="postpartumExaId")String postpartumExaId,
								  Map<String,Object> map){

		//根据档案id获取建档人的信息（档案表）
		ArchivesInfoPO archives = archivesInfoService.find(archiveId);
		map.put("archives", archives);
		map.put("postpartumExaId", postpartumExaId);
		Date birthday = archives.getBirthday();
		//根据出生日期计算年龄
		//女方年龄
		int womenAge = DateUtils.getAgeByBirthday(birthday);
		map.put("womenAge", womenAge);
		
		//根据档案id获取选出最近的生育档案
		BirthArchivesInfoPO birthArchives=birthArchivesInfoService.getBirthArchivesByArchivesId(archiveId);
		map.put("birthArchives", birthArchives);
		map.put("postpartumExaId", postpartumExaId);
		//获取生育档案表中的id
		String birthArchivesId = birthArchives.getId();
		//将生育id放在域对象中
		map.put("birthArchivesId", birthArchivesId);
		//根基生育id获取分娩的基本信息（分娩基本信息表），获取后由于可能没有分娩信息，所以要判断为空的情况
		ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
		map.put("childbirthBasic", childbirthBasic);
		
		//根据生育id查询最新完成的产后42天的检查信息，携带到预览页面(从四张表中查询，封装进四个对象中)
		//1.查询产后检查主表（条件为产后检查id）
		PostpartumExaInfoPO postpartumExa = postpartumExaInfoService.findPostpartumExa(postpartumExaId);
		map.put("postpartumExa", postpartumExa);
		
		//2.查询产后检查详情表(根据产后检查的id查询)
		PostpartumExaDetailedInfoPO postpartumExaDetailed = postpartumExaDetailedInfoService.getPostpartumExaDetailByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaDetailed", postpartumExaDetailed);
		
		//3.查询产后检查其他项信息表(根据产后检查的id查询)
		PostpartumExaOtherInfoPO postpartumExaOther = postpartumExaOtherInfoService.getPostpartumExaOtherByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaOther", postpartumExaOther);
		
		//4.查询产后访视转诊信息表(根据产后检查的id查询)
		PostpartumReferralInfoPO postpartumReferral = postpartumReferralInfoService.getPostpartumReferralByPostpartumExaId(postpartumExaId);
		map.put("postpartumReferral", postpartumReferral);
		//根据转诊机构获取机构的名称
		String mechanismId = postpartumReferral.getMechanism();
		String mechanismName = postpartumExaInfoService.getMechanismById(mechanismId);
		map.put("mechanismName", mechanismName);
		
		if("0".equals(postpartumExa.getType())){
			return "postpartum/3to7ExaFeedBack";
		}
		return "postpartum/42ExaFeedBack";

	}
	
	/**
	 * 出院3-7天/或产后42天健康检查详情页面（从历史检查记录列表进入的，根据产后检查记录的checkId和edit_status查询）
	 * @param session
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/postExaDetails")
	public String toExaDetails(HttpSession session,Map<String,Object> map,
												   @RequestParam(value="archiveId")String archiveId,
												   @RequestParam(value="postpartumExaId")String postpartumExaId){
		//从session中获取用户的信息 
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		map.put("currentDoctorId", operator.getId());
		map.put("operator", operator2);
		
		//根据档案id获取建档人的信息（档案表）
		ArchivesInfoPO archives = archivesInfoService.find(archiveId);
		map.put("archives", archives);
		Date birthday = archives.getBirthday();
		//根据出生日期计算年龄
		//女方年龄
		if(birthday!=null){
			int womenAge = DateUtils.getAgeByBirthday(birthday);
			map.put("womenAge", womenAge);
		}
		
		//男方年龄
		Date manBirthday = archives.getManBirthday();
		if(manBirthday!=null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			map.put("manAge", manAge);
		}
		
		map.put("archiveId", archiveId);
		map.put("postpartumExaId", postpartumExaId);
		
		//根据档案id获取选出最近的生育档案
		BirthArchivesInfoPO birthArchives=birthArchivesInfoService.getBirthArchivesByArchivesId(archiveId);
		map.put("birthArchives", birthArchives);
		//获取生育档案表中的id
		String birthArchivesId = birthArchives.getId();
		//将生育id放在域对象中
		map.put("birthArchivesId", birthArchivesId);
		//根基生育id获取分娩的基本信息（分娩基本信息表），获取后由于可能没有分娩信息，所以要判断为空的情况
		ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
		map.put("childbirthBasic", childbirthBasic);
		
		//获取预产期
		Date expectedDate = birthArchives.getPredictDate();
		map.put("expectedDate", expectedDate);
		
		
		
		//查询产后检查信息的主表，判断type是0还是1如果是0则进入到3-7天产检详情页面，如果是1进入到产后42天健康检查页面
		//1.查询产后检查主表（条件为产后检查id）
		PostpartumExaInfoPO postpartumExa = postpartumExaInfoService.findPostpartumExa(postpartumExaId);
		map.put("postpartumExa", postpartumExa);
		map.put("checkDoctorId", postpartumExa.getDoctorId());
		
		//2.查询产后检查详情表(根据产后检查的id查询)
		PostpartumExaDetailedInfoPO postpartumExaDetailed = postpartumExaDetailedInfoService.getPostpartumExaDetailByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaDetailed", postpartumExaDetailed);
		
		//3.查询产后检查其他项信息表(根据产后检查的id查询)
		PostpartumExaOtherInfoPO postpartumExaOther = postpartumExaOtherInfoService.getPostpartumExaOtherByPostpartumExaId(postpartumExaId);
		map.put("postpartumExaOther", postpartumExaOther);
		
		//4.查询产后访视转诊信息表(根据产后检查的id查询)
		PostpartumReferralInfoPO postpartumReferral = postpartumReferralInfoService.getPostpartumReferralByPostpartumExaId(postpartumExaId);
		map.put("postpartumReferral", postpartumReferral);
		
		//获取医生超级管理员的id(是医生产超级管理员的可以进行编辑)
		String doctorAdminId = postpartumExaInfoService.getDoctorAdminId();
		map.put("doctorAdminId", doctorAdminId);
		
		if("0".equals(postpartumExa.getType())){
			return "postpartum/3to7ExaDetails";
		}
		return "postpartum/42ExaDetails";
	}
	
	
	

	/**
	 * 结案
	 * wangxd  2016.9.10
	 * @param birthArchivesId
	 * @param closeCaseReason
	 * @return
	 */
	@RequestMapping(value="/closeCase",method=RequestMethod.POST)
	public String closeCase(@RequestParam(value="birthArchivesId")String birthArchivesId,
			 			    @RequestParam(value="closeCaseReason")String closeCaseReason){
		Map map =new HashMap();
		map.put("birthArchivesId", birthArchivesId);
		map.put("closeCaseReason", closeCaseReason);
		birthArchivesInfoService.toCloseCase(map);
		return "redirect:/prenatal/list";
	}
	
	/**
	 * POSTPARTUM_EXA_INFO 从历史检查记录进入录入页面，（补全检查信息）
	 * 2016.10.25
	 * @return
	 */
	@RequestMapping(value = "/falseList", method = RequestMethod.GET)
	public String falseListPostpartumExaInfoView(@RequestParam(value="archiveId")String archiveId,
												 @RequestParam(value="go",required=false)String go,
												 HttpSession session,Map<String,Object> map) {
		log.debug("request page: /postpartum/PostpartumExa_list");
		
		//从session中获取用户的信息 
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		map.put("operator", operator2);
		//从session中获取当前医院的名称，根据部门名称确定部门等级（0是县医院，1乡医院，2是村医院），然后查询上级部门的医院显示在下拉列表中
//		String department = operator2.getDepartment();
//		String level = departmentService.queryQyByName(department);
//		List<DepartmentPO> hospitals = null;
//		if("2".equals(level)){
			//level位2时证明是村医院，需要转的机构为乡医院
//			hospitals = departmentService.findXiangHospital();
//		}else if("1".equals(level)){
			//level位1时证明是乡医院，需要转的机构为县医院
//			hospitals = departmentService.findXianHospital();
//		}
		
		//获取3~7天 以及 42天 保健指导用于带到添加页面
		DirectiveOpinionTemplatePO DirectiveOpinionTemplate3To7 = directiveOpinionTemplateService.get3To7Guidance();
		DirectiveOpinionTemplatePO DirectiveOpinionTemplate42 = directiveOpinionTemplateService.get42Guidance();
		
		List<DepartmentPO> hospitals = departmentService.getAllDepartment();
		map.put("hospitals", hospitals);
		
		//查询角色列表用于转诊科室下拉列表的回显
		List<RolePO> roleList = roleService.getAll();
		map.put("roleList", roleList);
		
		
		//根据档案id获取建档人的信息（档案表）
		ArchivesInfoPO archives = archivesInfoService.find(archiveId);
		Date birthday = archives.getBirthday();
		//根据出生日期计算年龄
		//女方年龄
		int womenAge = DateUtils.getAgeByBirthday(birthday);
		//男方年龄
		Date manBirthday = archives.getManBirthday();
		if(manBirthday!=null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			map.put("manAge", manAge);
		}
		map.put("womenAge", womenAge);
		map.put("archives", archives);
		map.put("archiveId", archiveId);
		//根据档案id获取选出最近的生育档案
		BirthArchivesInfoPO birthArchives=birthArchivesInfoService.getBirthArchivesByArchivesId(archiveId);
		map.put("birthArchives", birthArchives);
		//获取生育档案表中的id
		String birthArchivesId = birthArchives.getId();
		//将生育id放在域对象中
		map.put("birthArchivesId", birthArchivesId);
		
		//根据生育档案表查询是否有产前随访记录若没有则视为该孕妇没有完成孕产登记，隐藏结案按钮
		int countPrenatalByBirthId = prenatalExaInfoService.countPrenatalByBirthId(birthArchivesId);
		map.put("prenatalCount", countPrenatalByBirthId);
		
		//根基生育id获取分娩的基本信息（分娩基本信息表），获取后由于可能没有分娩信息，所以要判断为空的情况
		ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
		map.put("childbirthBasic", childbirthBasic);
		
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
		map.put("historyChecks", historyChecks);
		
		//获取出院3-7天和产后检查对应的历史检查记录
		List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostpartumHistoryChecks(birthArchivesId);
		map.put("postpartumHistoryChecks", postpartumHistoryChecks);
		
		
		//根据分娩时间（分娩时间从分娩信息表中获取）计算是否为产后42天
		if(childbirthBasic!=null){
			//根据出院时间确定产妇是否为出院3-7天
			Date leaveDate = childbirthBasic.getLeaveDate();
			//计算出院时间距离今天的天数
			Long outDate = null;
			if(leaveDate!=null){
				outDate = DateUtils.subtractDate(leaveDate,new Date());
				map.put("outDate", outDate);
			}
			
			Date BirthDate = childbirthBasic.getBirthDate();
			//计算分娩时间距离今天的天数
			Long bornDate= null;
			if(BirthDate!=null){
				bornDate = DateUtils.subtractDate(BirthDate,new Date());
				map.put("bornDate", bornDate);
				//根据分娩日期计算分娩日期后42天的日期,用于下次预约时间的回显
				Date newDate = DateUtils.getNewDate(BirthDate,42);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		  		String nextFollowingDate = sdf.format(newDate);
				map.put("nextFollowingDate", nextFollowingDate);
			}
		}
		
		//可做假记录（检查日期可以编辑）
		map.put("ifFalse", "0");
		if("42".equals(go)){
			if(DirectiveOpinionTemplate42 != null){
				map.put("guidance", DirectiveOpinionTemplate42.getContent());
			}
			return "postpartum/PostpartumExa42_add";
		}
		if(DirectiveOpinionTemplate3To7 != null){
			map.put("guidance", DirectiveOpinionTemplate3To7.getContent());
		}
		return "postpartum/PostpartumExa3to7_add";
	}
	
	/**
	 * POSTPARTUM_EXA_INFO 从孕产妇管理列表跳转到产后访视页面（判断是3-7天产后访视还是42天健康检查）
	 * wangxd 2016.8.30
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPostpartumExaInfoView(@RequestParam(value="archiveId")String archiveId,
											@RequestParam(value="go",required=false)String go,
											HttpSession session,Map<String,Object> map,
											RedirectAttributes redirectAttributes) {
		log.debug("request page: /postpartum/PostpartumExa_list");
		//不做假记录（检查日期不可编辑）
		map.put("ifFalse", "1");
		//从session中获取用户的信息 
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
		map.put("operator", operator2);
		//从session中获取当前医院的名称，根据部门名称确定部门等级（0是县医院，1乡医院，2是村医院），然后查询上级部门的医院显示在下拉列表中
//		String department = operator2.getDepartment();
//		String level = departmentService.queryQyByName(department);
//		List<DepartmentPO> hospitals = null;
//		if("2".equals(level)){
			//level位2时证明是村医院，需要转的机构为乡医院
//			hospitals = departmentService.findXiangHospital();
//		}else if("1".equals(level)){
			//level位1时证明是乡医院，需要转的机构为县医院
//			hospitals = departmentService.findXianHospital();
//		}
		
		List<DepartmentPO> hospitals = departmentService.getAllDepartment();
		map.put("hospitals", hospitals);
		
		//查询角色列表用于转诊科室下拉列表的回显
		List<RolePO> roleList = roleService.getAll();
		map.put("roleList", roleList);
		
		//获取3~7天 以及 42天 保健指导用于带到添加页面
		DirectiveOpinionTemplatePO DirectiveOpinionTemplate3To7 = directiveOpinionTemplateService.get3To7Guidance();
		DirectiveOpinionTemplatePO DirectiveOpinionTemplate42 = directiveOpinionTemplateService.get42Guidance();
		
		//根据档案id获取建档人的信息（档案表）
		ArchivesInfoPO archives = archivesInfoService.find(archiveId);
		Date birthday = archives.getBirthday();
		//根据出生日期计算年龄
		//女方年龄
		int womenAge = DateUtils.getAgeByBirthday(birthday);
		//男方年龄
		Date manBirthday = archives.getManBirthday();
		if(manBirthday!=null){
			int manAge = DateUtils.getAgeByBirthday(manBirthday);
			map.put("manAge", manAge);
		}
		map.put("womenAge", womenAge);
		map.put("archives", archives);
		map.put("archiveId", archiveId);
		//根据档案id获取选出最近的生育档案
		BirthArchivesInfoPO birthArchives=birthArchivesInfoService.getBirthArchivesByArchivesId(archiveId);
		map.put("birthArchives", birthArchives);
		//获取生育档案表中的id
		String birthArchivesId = birthArchives.getId();
		//将生育id放在域对象中
		map.put("birthArchivesId", birthArchivesId);
		
		//根据生育档案表查询是否有产前随访记录若没有则视为该孕妇没有完成孕产登记，隐藏结案按钮
		int countPrenatalByBirthId = prenatalExaInfoService.countPrenatalByBirthId(birthArchivesId);
		map.put("prenatalCount", countPrenatalByBirthId);
		
		//根基生育id获取分娩的基本信息（分娩基本信息表），获取后由于可能没有分娩信息，所以要判断为空的情况
		ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchivesId);
		map.put("childbirthBasic", childbirthBasic);
		
		
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
		map.put("historyChecks", historyChecks);
		
		//获取出院3-7天和产后检查对应的历史检查记录
		List<PostHistoryCheckVO> postpartumHistoryChecks = postpartumExaInfoService.getPostpartumHistoryChecks(birthArchivesId);
		map.put("postpartumHistoryChecks", postpartumHistoryChecks);
		
		
		//如果没有分娩信息的时候，直接进入3-7天产后访视的页面(此时应该将生育档案的孕检状态改为已分娩)，此时3-7天访视和42天健康检查都可以访问
		if(childbirthBasic==null){
			if("42".equals(go)){
				if(DirectiveOpinionTemplate42 != null){
					map.put("guidance", DirectiveOpinionTemplate42.getContent());
				}
				return "postpartum/PostpartumExa42_add";
			}
			//因为建立档案后直接做产后检查，在其他医院已经分娩，将档案时默认是无，所以进来时应该将孕检状态改为已分娩（否则孕产妇管理列表将不会显示进入产检的按钮）
			//postpartumExaInfoService.updateState(birthArchivesId);
			if(DirectiveOpinionTemplate3To7 != null){
				map.put("guidance", DirectiveOpinionTemplate3To7.getContent());
			}
			return "postpartum/PostpartumExa3to7_add";
		}
		
		
		//根据出院时间确定产妇是否为出院3-7天
		Date leaveDate = childbirthBasic.getLeaveDate();
		//计算出院时间距离今天的天数
		Long outDate = null;
		if(leaveDate!=null){
			outDate = DateUtils.subtractDate(leaveDate,new Date());
			map.put("outDate", outDate);
		}
		
		//根据分娩时间（分娩时间从分娩信息表中获取）计算是否为产后42天
		Date BirthDate = childbirthBasic.getBirthDate();
		//计算分娩时间距离今天的天数
		Long bornDate= null;
		if(BirthDate!=null){
			bornDate = DateUtils.subtractDate(BirthDate,new Date());
			map.put("bornDate", bornDate);
			//根据分娩日期计算分娩日期后42天的日期,用于下次预约时间的回显
			Date newDate = DateUtils.getNewDate(BirthDate,42);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	  		String nextFollowingDate = sdf.format(newDate);
			map.put("nextFollowingDate", nextFollowingDate);
		}
		
		//要跳转到3-7天访视
		if("3".equals(go)){
			if(DirectiveOpinionTemplate3To7 != null){
				map.put("guidance", DirectiveOpinionTemplate3To7.getContent());
			}
			return "postpartum/PostpartumExa3to7_add";
		}
		
		//日期大于42天的时候进入42天健康检查
		if(bornDate>42){
			if(DirectiveOpinionTemplate42 != null){
				map.put("guidance", DirectiveOpinionTemplate42.getContent());
			}
			return "postpartum/PostpartumExa42_add";
		}
		
		//从前面已经判断为不是分娩后42天，如果出院时间不到三天则不会进入访视页面，返回到孕产妇管理页面
		if(outDate<3){
			//此处是否弹框提示出院不到三天，也不到分娩42天，不能进行产后访视
			redirectAttributes.addFlashAttribute("message", "出院不满3天，不能进行访视");
			return "redirect:/prenatal/list";
		}
		if(DirectiveOpinionTemplate3To7 != null){
			map.put("guidance", DirectiveOpinionTemplate3To7.getContent());
		}
		return "postpartum/PostpartumExa3to7_add";
	}
	/**
	 * POSTPARTUM_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list1", method = RequestMethod.POST)
	public Model listPostpartumExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<PostpartumExaInfoPO> page) {
		log.debug("request data: listPostpartumExaInfo");
		Model model = new Model();
		try {
			postpartumExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * POSTPARTUM_EXA_INFO 添加
	 * wangxd 2016.8.31
	 * @param postpartumExaInfoVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPostpartumExaInfoActoin(PostpartumExaInfoVO postpartumExaInfoVO,
											@RequestParam(value="birthArchivesId")String birthArchivesId,
											@RequestParam(value="save")String save,
											@RequestParam(value="nextFollowingDate")String nextFollowingDate,
											@RequestParam(value="days")String days,
											HttpSession session,
											PostpartumExaDetailedInfoVO postpartumExaDetailedInfoVO,
											PostpartumExaOtherInfoVO postpartumExaOtherInfoVO,
											PostpartumReferralInfoVO postpartumReferralInfoVO,
											HttpServletRequest request) {
		
		Model model = new Model();
		model.set("msg", "true");
		
		//获取创建时间参数
		String checkDate = request.getParameter("falseCheckDate");
		Date creat = DateUtil.stringToDate(checkDate);
		Date creatTime = new Date();
		if(checkDate!=null&&checkDate!=""){
			creatTime.setYear(creat.getYear());
			creatTime.setMonth(creat.getMonth());
			creatTime.setDate(creat.getDate());
		}
		postpartumExaInfoVO.setCreatTime(creatTime);
		//获取是否结案
		String closeCase = request.getParameter("closeCase");
		//获取检查医生id用来赋值给产后检查表
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String doctorId = operator.getId();
		try {
			PostpartumExaInfoPO postpartumExaInfoPO = new PostpartumExaInfoPO();
			BeanUtils.copyProperties(postpartumExaInfoPO, postpartumExaInfoVO);
			
			PostpartumExaDetailedInfoPO postpartumExaDetailedInfoPO = new PostpartumExaDetailedInfoPO();
			BeanUtils.copyProperties(postpartumExaDetailedInfoPO,postpartumExaDetailedInfoVO);
			
			PostpartumExaOtherInfoPO postpartumExaOtherInfoPO = new PostpartumExaOtherInfoPO();
			BeanUtils.copyProperties(postpartumExaOtherInfoPO,postpartumExaOtherInfoVO);
			
			PostpartumReferralInfoPO postpartumReferralInfoPO = new PostpartumReferralInfoPO();
			BeanUtils.copyProperties(postpartumReferralInfoPO,postpartumReferralInfoVO);
			
			//生成产后检查表的id
			String postpartumExaInfoId = IdUtil.uuid();
			
			postpartumExaInfoPO.setId(postpartumExaInfoId);
			postpartumExaInfoPO.setBirthArchivesId(birthArchivesId);
			postpartumExaInfoPO.setDoctorId(doctorId);
			//根据sava参数确定编辑状态，是保存还是完成，保存编辑状态为0，完成编辑状态为1
			if("0".equals(save)){
				postpartumExaInfoPO.setEditStatus("0");
			}else{
				postpartumExaInfoPO.setEditStatus("1");
			}
			//根据days参数确定是出院3-7天访视还是42天健康检查
			if("3".equals(days)){
				postpartumExaInfoPO.setType("0");
			}else{
				postpartumExaInfoPO.setType("1");
			}
			
			//为产后一般检查细节表生成id  后赋值产后检查表id用来关联
			postpartumExaDetailedInfoPO.setId(IdUtil.uuid());
			postpartumExaDetailedInfoPO.setPosChecklistId(postpartumExaInfoId);
			 
			//为其他检查项表生成id 后赋值产后检查表用来关联
			postpartumExaOtherInfoPO.setId(IdUtil.uuid());
			postpartumExaOtherInfoPO.setPosChecklistId(postpartumExaInfoId);
			
			//为转诊表生成id 后赋值产后检查表的id用来关联
			postpartumReferralInfoPO.setId(IdUtil.uuid());
			postpartumReferralInfoPO.setPosId(postpartumExaInfoId);
			//将接受的日期字符串转化为日期类型赋值给转诊信息表
			if(nextFollowingDate!=null){
				Date Date = DateUtil.stringToDate(nextFollowingDate);
				postpartumReferralInfoPO.setNextFollowingDate(Date);
			}
			
			//获取检查医院的id
			String depId = operator.getDepId();
			
			//保存以及修改操作
			postpartumExaInfoService.save(postpartumExaInfoPO,
										  postpartumExaDetailedInfoPO,
										  postpartumExaOtherInfoPO,
										  postpartumReferralInfoPO,
										  birthArchivesId,
										  closeCase,
										  save,depId);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		
		//当是保存操作的时候跳转到孕产妇管理列表，完成操作的时候是ajax提交form表单请求，自动不跳转页面
		return  "redirect:/prenatal/list";
	}

	/**
	 * 3-7天访视/42天健康检查编辑后的修改(只是根据产后检查id进行修改即可)
	 * wangxd 2016.9.14
	 * @param postpartumExaInfoVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePostpartumExaInfoActoin(PostpartumExaInfoVO postpartumExaInfoVO,
												HttpSession session,
												@RequestParam(value="save")String save,
												@RequestParam(value="nextFollowingDate")String nextFollowingDate,
												@RequestParam(value="birthArchivesId")String birthArchivesId,
												PostpartumExaDetailedInfoVO postpartumExaDetailedInfoVO,
												PostpartumExaOtherInfoVO postpartumExaOtherInfoVO,
												PostpartumReferralInfoVO postpartumReferralInfoVO,
												@RequestParam(value="postpartumExaId")String postpartumExaId,
												HttpServletRequest request) {
		Model model = new Model();
		model.set("msg", "true");
		//获取创建时间参数
		String checkDate = request.getParameter("falseCheckDate");
		Date creat = DateUtil.stringToDate(checkDate);
		Date creatTime = new Date();
		if(checkDate!=null&&checkDate!=""){
			creatTime.setYear(creat.getYear());
			creatTime.setMonth(creat.getMonth());
			creatTime.setDate(creat.getDate());
		}
		postpartumExaInfoVO.setCreatTime(creatTime);
		//获取是否结案
		String closeCase = request.getParameter("closeCase");
		//获取检查医生id用来赋值给产后检查表
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String depId = operator.getDepId();
		try {
			
			PostpartumExaInfoPO postpartumExaInfoPO = new PostpartumExaInfoPO();
			BeanUtils.copyProperties(postpartumExaInfoPO, postpartumExaInfoVO);
			
			PostpartumExaDetailedInfoPO postpartumExaDetailedInfoPO = new PostpartumExaDetailedInfoPO();
			BeanUtils.copyProperties(postpartumExaDetailedInfoPO,postpartumExaDetailedInfoVO);
			
			PostpartumExaOtherInfoPO postpartumExaOtherInfoPO = new PostpartumExaOtherInfoPO();
			BeanUtils.copyProperties(postpartumExaOtherInfoPO,postpartumExaOtherInfoVO);
			
			PostpartumReferralInfoPO postpartumReferralInfoPO = new PostpartumReferralInfoPO();
			BeanUtils.copyProperties(postpartumReferralInfoPO,postpartumReferralInfoVO);
			
			if("0".equals(save)){
				postpartumExaInfoPO.setEditStatus("0");
			}
			if("1".equals(save)){
				postpartumExaInfoPO.setEditStatus("1");
			}
			//将接受的日期字符串转化为日期类型赋值给转诊信息表
			if(nextFollowingDate!=null && nextFollowingDate!="" ){
				Date Date = DateUtil.stringToDate(nextFollowingDate);
				postpartumReferralInfoPO.setNextFollowingDate(Date);
			}
			
			postpartumExaInfoPO.setId(postpartumExaId);
			postpartumExaDetailedInfoPO.setPosChecklistId(postpartumExaId);
			postpartumExaOtherInfoPO.setPosChecklistId(postpartumExaId);
			postpartumReferralInfoPO.setPosId(postpartumExaId);
			
			postpartumExaInfoService.update(postpartumExaInfoPO,postpartumExaDetailedInfoPO,postpartumExaOtherInfoPO,postpartumReferralInfoPO,depId,birthArchivesId,closeCase,save);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return "redirect:/prenatal/list";
	}

	/**
	 * POSTPARTUM_EXA_INFO 删除
	 * 
	 * @param postpartumExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPostpartumExaInfoAction(@RequestParam("postpartumExaInfoIds") String postpartumExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			postpartumExaInfoService.deletes(postpartumExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}