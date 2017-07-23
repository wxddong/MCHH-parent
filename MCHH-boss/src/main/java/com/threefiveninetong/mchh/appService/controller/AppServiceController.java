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
package com.threefiveninetong.mchh.appService.controller;



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

import com.threefiveninetong.mchh.appHospital.po.AppCharacteristicServiceInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appHospital.service.AppCharacteristicServiceInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.premarital.po.HealthInfoPO;
import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;
import com.threefiveninetong.mchh.premarital.po.LaboratorySpecialInsInfoPO;
import com.threefiveninetong.mchh.premarital.po.PhysiqueExaInfoPO;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.premarital.po.PremaritalReferralInfoPO;
import com.threefiveninetong.mchh.premarital.vo.HealthInfoVO;
import com.threefiveninetong.mchh.premarital.vo.InspectionResultVO;
import com.threefiveninetong.mchh.premarital.vo.LaboratorySpecialInsInfoVO;
import com.threefiveninetong.mchh.premarital.vo.PhysiqueExaInfoVO;
import com.threefiveninetong.mchh.premarital.vo.PremaritalExaInfoVO;
import com.threefiveninetong.mchh.premarital.vo.PremaritalReferralInfoVO;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.CryptUtil;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Encoding;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.SystemException;

/**
 * @ClassName: ArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Controller
@RequestMapping("/service")
public class AppServiceController {

	private static final Logger log =Logger.getLogger(AppServiceController.class);
	
	@Resource
	private AppCharacteristicServiceInfoService appCharacteristicServiceInfoService;
	
	/**
	 * 特色服务列表
	 * @return
	 */
	@RequestMapping(value = "/serviceList", method = RequestMethod.GET)
	public String serviceList() {
		
		return "service/serviceList";
	}
	
	/**
	 * 特色服务列表内容
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/serviceList", method = RequestMethod.POST)
	public Model serviceList(@RequestParam Map<String, Object> reqs, Page<AppCharacteristicServiceInfoPO> page) {
		
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			appCharacteristicServiceInfoService.getAll(reqs, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		model.setPage(page);
		return model;
	}
	
	/**
	 * 新建特色服务
	 * @param premaritalExaInfoVO
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("name")String name,
							 @RequestParam("status")String status,
							 @RequestParam("content")String content,
							 HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//model.set("msg", "true");
		try {
			//检查医生ID
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			//医院id
			String depId = operator.getDepId();
			
			AppCharacteristicServiceInfoPO appCharacteristicServiceInfoPO = new AppCharacteristicServiceInfoPO();
			
			appCharacteristicServiceInfoPO.setId(IdUtil.uuid());//id
			appCharacteristicServiceInfoPO.setHospitalId(depId);//医院信息id
			appCharacteristicServiceInfoPO.setName(name);//项目名称
			appCharacteristicServiceInfoPO.setContent(content);//内容介绍
			appCharacteristicServiceInfoPO.setStatus(status);//状态为有效
			
			Date now = new Date();
			appCharacteristicServiceInfoPO.setCreateTime(now);
			appCharacteristicServiceInfoPO.setUpdateTime(now);
			
			appCharacteristicServiceInfoService.create(appCharacteristicServiceInfoPO);
			
		} catch (Exception e) {
			e.printStackTrace();
			//mav.set("msg", "false");
		}
		mav.setViewName("/service/serviceList");
		return mav;
	}

	/**
	 * 修改特色服务
	 * @param resultId
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateService", method = RequestMethod.POST)
	public ModelAndView updateService(@RequestParam("name")String name,
									  @RequestParam("status")String status,
									  @RequestParam("content")String content,
									  @RequestParam("serviceId")String serviceId,
												   HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			AppCharacteristicServiceInfoPO appCharacteristicServiceInfoPO = appCharacteristicServiceInfoService.find(serviceId);
			appCharacteristicServiceInfoPO.setName(name);//项目名称
			appCharacteristicServiceInfoPO.setContent(content);//内容介绍
			appCharacteristicServiceInfoPO.setStatus(status);//状态为有效
			
			Date now = new Date();
			appCharacteristicServiceInfoPO.setUpdateTime(now);//修改时间
			
			appCharacteristicServiceInfoService.update(appCharacteristicServiceInfoPO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("/service/serviceList");
		return mav;
	}
	
	/**
	 * 删除前验证
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeChange", method = RequestMethod.GET)
	public Model beforeChange(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeService = appCharacteristicServiceInfoService.getAppServiceByserviceIds(ids.split(","));
			if (opeService != 0) {
				model.set("msg", "hasCounty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	
	/**
	 * 删除
	 * @param cityInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST, produces = "application/json")
	public Model change(@RequestParam("serviceIds") String serviceIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			appCharacteristicServiceInfoService.changeStatus(serviceIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
}