/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: MarriageRegistrationDataController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.MarriageRegistrationDataPO;
import com.threefiveninetong.mchh.config.vo.MarriageRegistrationDataVO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.MarriageRegistrationDataService;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.service.DepartmentService;

/**
 * @ClassName: MarriageRegistrationDataController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Controller
@RequestMapping("/marriager")
public class MarriageRegistrationDataController {

	private static final Logger log =Logger.getLogger(MarriageRegistrationDataController.class);
	@Resource
	private  MarriageRegistrationDataService  marriageRegistrationDataService;
	
	@Resource
	private DistrictAndCountyInfoService districtAndCountyInfoService;
	
	
    /**
	 * MARRIAGE_REGISTRATION_DATA 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMarriageRegistrationDataView() {
		log.debug("request page: /sysset/marriageRegistrationData/marriageRegistrationData_list");
		return "sysset/marriageRegistrationData/marriageRegistrationData_list";
	}
	/**
	 * MARRIAGE_REGISTRATION_DATA 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listMarriageRegistrationDataActoin(@RequestParam Map<String, Object> reqs, Page<MarriageRegistrationDataPO> page) {
		log.debug("request data: listMarriageRegistrationData");
		Model model = new Model();
		try {
			marriageRegistrationDataService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	

	//系统添加结婚登记页面
	@RequestMapping(value = "/addcontrollerview", method = RequestMethod.GET)
	public ModelAndView addView(Map<String, Object> reqs) {
		
		List<DistrictAndCountyInfoPO> findAll= districtAndCountyInfoService.findAll();
		reqs.put("findAll", findAll);
		ModelAndView modelAndView = new ModelAndView(
				
				"config/basedate_marry_list", reqs);
		return modelAndView;
	}
	
	/**
	 * MARRIAGE_REGISTRATION_DATA 添加
	 * 
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMarriageRegistrationDataActoin(@RequestParam Map<String, Object> reqs,HttpServletRequest request) {
		try {
			request.setAttribute("msg", "true");
			String id = IdUtil.uuid();
			String id2 =(String) reqs.get("countyId");
			DistrictAndCountyInfoPO findByName = districtAndCountyInfoService.find(id2);
			String name = findByName.getName();
			String marryNum = (String)reqs.get("marryNum");
			String sources=(String)reqs.get("sources");
			String statisticnow=(String)reqs.get("statisticnow");
			String statisticfur=(String)reqs.get("statisticfur");
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date datenow =  format.parse(statisticnow);
			Date datefur =  format.parse(statisticfur);
			String isvalid=(String)reqs.get("isvalid");
			MarriageRegistrationDataPO marriageRegistrationDataPO=new MarriageRegistrationDataPO();
			marriageRegistrationDataPO.setIsvalid(isvalid);
			marriageRegistrationDataPO.setStatisticnow(datenow);
			marriageRegistrationDataPO.setStatisticfur(datefur);
			marriageRegistrationDataPO.setSources(sources);
			marriageRegistrationDataPO.setName(name);
			marriageRegistrationDataPO.setId(id);
			marriageRegistrationDataPO.setCountyId(id2);
			marriageRegistrationDataPO.setMarryNum(marryNum);
			marriageRegistrationDataPO.setUpdateTime(new Date());
			marriageRegistrationDataPO.setCreatTime(new Date());
			marriageRegistrationDataService.create(marriageRegistrationDataPO);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "false");
		}
		return "redirect:/marriager/addcontrollerview";
		
	}
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			MarriageRegistrationDataPO MarriageRegistrationDataPO=marriageRegistrationDataService.find(id);
			
			List<DistrictAndCountyInfoPO> findAll= districtAndCountyInfoService.findAll();
			reqs.put("findAll", findAll);
			
			Date statisticnow = MarriageRegistrationDataPO.getStatisticnow();
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 if(statisticnow !=null){
			  
			   String dateString = formatter.format(statisticnow);
			   java.util.Date timeDate= dateFormat.parse(dateString);
			   Date dateTime = new java.sql.Date(timeDate.getTime());
			   MarriageRegistrationDataPO.setStatisticnow(dateTime);
			}
			  
			Date statisticfur = MarriageRegistrationDataPO.getStatisticfur();
			if(statisticfur !=null){
			   String date = formatter.format(statisticfur);
			   java.util.Date time= dateFormat.parse(date);
			   Date Time = new java.sql.Date(time.getTime());
			  MarriageRegistrationDataPO.setStatisticfur(Time);
			}
			reqs.put("MarriageRegistrationDataPO", MarriageRegistrationDataPO);
			modelAndView = new ModelAndView(
					"config/basedate_marry_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	
	
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMarriageRegistrationData(@RequestParam Map<String, Object> reqs) {
		try {
		String id =(String) reqs.get("id");
		String countyId =(String) reqs.get("countyId");
		String marryNum = (String)reqs.get("marryNum");
		String sources=(String)reqs.get("sources");
		String statisticnow=(String)reqs.get("statisticnow");
		String statisticfur=(String)reqs.get("statisticfur");
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		Date datenow =  format.parse(statisticnow);
		Date datefur =  format.parse(statisticfur);
		String isvalid=(String)reqs.get("isvalid");
		MarriageRegistrationDataPO marriageRegistrationDataPO=new MarriageRegistrationDataPO();
		marriageRegistrationDataPO.setIsvalid(isvalid);
		marriageRegistrationDataPO.setStatisticnow(datenow);
		marriageRegistrationDataPO.setStatisticfur(datefur);
		marriageRegistrationDataPO.setSources(sources);
		marriageRegistrationDataPO.setCountyId(countyId);
		marriageRegistrationDataPO.setId(id);
		marriageRegistrationDataPO.setMarryNum(marryNum);
		marriageRegistrationDataPO.setUpdateTime(new Date());
		marriageRegistrationDataPO.setCreatTime(new Date());
		
			marriageRegistrationDataService.update(marriageRegistrationDataPO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/marriager/addcontrollerview";
	}
	/**
	 * MARRIAGE_REGISTRATION_DATA 删除
	 * 
	 * @param marriageRegistrationDataIds
	 * @return
	 */
	 
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delMarriageRegistrationDataAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			marriageRegistrationDataService.deletes(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	
	
	


}