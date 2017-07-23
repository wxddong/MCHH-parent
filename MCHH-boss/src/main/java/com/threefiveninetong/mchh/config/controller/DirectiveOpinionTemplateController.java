/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DirectiveOpinionTemplateController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Templates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;
import com.threefiveninetong.mchh.config.po.MarriageRegistrationDataPO;
import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.vo.DirectiveOpinionTemplateVO;
import com.threefiveninetong.mchh.config.service.DirectiveOpinionTemplateService;
import com.threefiveninetong.mchh.config.service.HighRiskPregnancyScoreService;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.prenatal.service.HighRiskInfoService;
import com.threefiveninetong.mchh.prenatal.service.HighRiskTermService;

/**
 * @ClassName: DirectiveOpinionTemplateController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@Controller
@RequestMapping("/directive")
public class DirectiveOpinionTemplateController {

	private static final Logger log =Logger.getLogger(DirectiveOpinionTemplateController.class);
	@Resource
	private  DirectiveOpinionTemplateService  directiveOpinionTemplateService;
	@Resource
	private  PremaritalAbnormalOptionService  premaritalAbnormalOptionService;
	
	
	@Resource
	private  HighRiskPregnancyScoreService  highRiskPregnancyScoreService;
	
	@Resource
	private HighRiskInfoService highRiskInfoService;
	
	@Resource
	private HighRiskTermService highRiskTermService;
	
	
	/**
	 * 通过孕周返回保健指导意见
	 * @param week
	 * @param day
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/getDirectveByWeek",method=RequestMethod.GET)
	public Model getDirectiveByWeek(@RequestParam("week")String week,@RequestParam("day")String day){
		Model model = new Model();
		
		DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
		String modumarType = "3";
		directiveOpinionTemplatePO.setModularType(modumarType);
		directiveOpinionTemplatePO.setUseSign("1");
		String tgd = "";
		week = week.trim();
		day = day.trim();
		DirectiveOpinionTemplatePO directive = null;
		int w;
		int d;
		try {
			w = Integer.parseInt(week);
			d = Integer.parseInt(day);
			boolean flag = d<=6 && d >=0; 
			if(w <= 13 && w >= 6 && flag){
				tgd = "0";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}else if(w >= 14 && w <= 19 && flag){
				tgd = "1";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}else if(w >= 20 && w <= 23 && flag){
				tgd = "2";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}else if(w >= 24 && w <= 27 && flag){
				tgd = "3";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}else if(w >= 28 && w <= 31 && flag){
				tgd = "4";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}else if(w >= 32 && w <= 36 && flag){
				tgd = "5";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}else if(w >= 37 && w <= 41 && flag){
				tgd = "6";
				directiveOpinionTemplatePO.setTgd(tgd);
				directive = directiveOpinionTemplateService.getDirectByWeek(directiveOpinionTemplatePO);
			}
		} catch (NumberFormatException e) {
			model.set("msg", false);
		}
		
		model.set("directive", directive);
		return model;
	}
	
    /**
	 * DIRECTIVE_OPINION_TEMPLATE 列表视图
	 * 婚前指导
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listDirectiveOpinionTemplateView(Map<String, Object> reqs) {
		log.debug("request page: /sysset/directiveOpinionTemplate/directiveOpinionTemplate_list");
		List<DirectiveOpinionTemplatePO> findAll = directiveOpinionTemplateService.findAll();
		List<PremaritalAbnormalOptionPO> find = premaritalAbnormalOptionService.findAllToDerective();
		
		reqs.put("findAll", findAll);
		reqs.put("find", find);
		
		ModelAndView modelAndView = new ModelAndView(
				
				"config/directive_list", reqs);
		return modelAndView;
	}
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 列表视图
	 * 孕产保健指导
	 * @return
	 */
	@RequestMapping(value = "/listMaternal", method = RequestMethod.GET)
	public ModelAndView listDirectiveOpinionTemplateViewMaternal(Map<String, Object> reqs) {
		log.debug("request page: /sysset/directiveOpinionTemplate/directiveOpinionTemplate_list");
		List<DirectiveOpinionTemplatePO> findAll = directiveOpinionTemplateService.findAll();
		List<PremaritalAbnormalOptionPO> find = premaritalAbnormalOptionService.findAll();
		reqs.put("findAll", findAll);
		reqs.put("find", find);
		ModelAndView modelAndView = new ModelAndView(
				
				"config/maternal_list", reqs);
		return modelAndView;
	}
	
	
	  /**
		 * DIRECTIVE_OPINION_TEMPLATE 列表视图
		 * 高危妊娠指导
		 * @return
		 */
		@RequestMapping(value = "/listPregancy", method = RequestMethod.GET)
		public ModelAndView listDirectiveOpinionTemplateViewPregancy(Map<String, Object> reqs) {
			log.debug("request page: /sysset/directiveOpinionTemplate/directiveOpinionTemplate_list");
			List<DirectiveOpinionTemplatePO> findAll = directiveOpinionTemplateService.findAll();
			List<PremaritalAbnormalOptionPO> find = premaritalAbnormalOptionService.findAll();
			List<HighRiskPregnancyScorePO> HighRiskAll = highRiskPregnancyScoreService.findAll();
			reqs.put("findAll", findAll);
			reqs.put("find", find);
			reqs.put("HighRiskAll", HighRiskAll);
			ModelAndView modelAndView = new ModelAndView(
					
					"config/pregnancy_list", reqs);
			return modelAndView;
		}
		
		/**
		 * DIRECTIVE_OPINION_TEMPLATE 列表视图
		 * 儿童保健指导
		 * @return
		 * @author wangbj
		 */
		@RequestMapping(value = "/listBabyView", method = RequestMethod.GET)
		public ModelAndView listDirectiveOpinionTemplateViewBaby(Map<String, Object> reqs) {
			log.debug("request page: /sysset/directiveOpinionTemplate/directiveOpinionTemplate_list");
			List<DirectiveOpinionTemplatePO> findAll = directiveOpinionTemplateService.findAll();
			List<PremaritalAbnormalOptionPO> find = premaritalAbnormalOptionService.findAll();
			List<HighRiskPregnancyScorePO> HighRiskAll = highRiskPregnancyScoreService.findAll();
			reqs.put("findAll", findAll);
			reqs.put("find", find);
			reqs.put("HighRiskAll", HighRiskAll);
			ModelAndView modelAndView = new ModelAndView(
					
					"config/babyderictive_list", reqs);
			return modelAndView;
		}
		
		
		/**
		 * DIRECTIVE_OPINION_TEMPLATE 列表视图
		 * 高危儿童保健指导
		 * @return
		 * @author wangbj
		 */
		@RequestMapping(value = "/listBabyHightRiskView", method = RequestMethod.GET)
		public ModelAndView listDirectiveOpinionTemplateViewBabyHightRisk(Map<String, Object> reqs) {
			log.debug("request page: /sysset/directiveOpinionTemplate/directiveOpinionTemplate_list");
			List<DirectiveOpinionTemplatePO> findAll = directiveOpinionTemplateService.findAll();
			List<PremaritalAbnormalOptionPO> find = premaritalAbnormalOptionService.findAll();
			List<HighRiskPregnancyScorePO> HighRiskAll = highRiskPregnancyScoreService.findAllBaby();
			reqs.put("findAll", findAll);
			reqs.put("find", find);
			reqs.put("HighRiskAll", HighRiskAll);
			ModelAndView modelAndView = new ModelAndView(
					
					"config/babyHightRiskDerictive_list", reqs);
			return modelAndView;
		}
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 列表数据
	 * 婚前保健指导
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listDirectiveOpinionTemplateActoin(@RequestParam Map<String, Object> reqs, Page<DirectiveOpinionTemplatePO> page) {
		log.debug("request data: listDirectiveOpinionTemplate");
		Model model = new Model();
		try {
			directiveOpinionTemplateService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 列表数据
	 * 婚前保健指导
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addByTgd", method = RequestMethod.GET)
	public Model addByTgdDirectiveOpinionTemplateActoin(@RequestParam Map<String, Object> reqs) {
		log.debug("request data: listDirectiveOpinionTemplate");
		Model model = new Model();
		try {
			String modularType=(String)reqs.get("modularType");
			String tgd=(String)reqs.get("tgd");
			String id=(String)reqs.get("id");
			if(id!=null&&id!=""){
				DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.find(id);
				String modularType2 = directiveOpinionTemplatePO.getModularType();
				String tgd2 = directiveOpinionTemplatePO.getTgd();
				if(tgd2.equals(tgd)){
					model.set("DirectiveOpinionTemplatePO", null);
				}
				if(!tgd2.equals(tgd)){
					List<DirectiveOpinionTemplatePO> findByTgd = directiveOpinionTemplateService.findByTgd(reqs);
					if(findByTgd.size()!=0){
						model.set("DirectiveOpinionTemplatePO", findByTgd);
					}
					if(findByTgd.size()==0){
						model.set("DirectiveOpinionTemplatePO", null);
					}
				}
			}
			if(id==null){
				List<DirectiveOpinionTemplatePO> findByTgd = directiveOpinionTemplateService.findByTgd(reqs);
				if(findByTgd.size()!=0){
					model.set("DirectiveOpinionTemplatePO", findByTgd);
				}
				if(findByTgd.size()==0){
					model.set("DirectiveOpinionTemplatePO", null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 列表数据
	 * 孕产保健指导
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listMaternal", method = RequestMethod.POST)
	public Model listDirectiveOpinionTemplateActoinMaternal(@RequestParam Map<String, Object> reqs, Page<DirectiveOpinionTemplatePO> page) {
		log.debug("request data: listDirectiveOpinionTemplate");
		Model model = new Model();
		try {
			directiveOpinionTemplateService.listForPageMaternal(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 列表数据
	 * 高危妊娠保健指导
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listPregancy", method = RequestMethod.POST)
	public Model listDirectiveOpinionTemplateActoinPregancy(@RequestParam Map<String, Object> reqs, Page<DirectiveOpinionTemplatePO> page) {
		log.debug("request data: listDirectiveOpinionTemplate");
		Model modelll = new Model();
		try {
			
			directiveOpinionTemplateService.listForPagePregancy(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelll.setPage(page);
		return modelll;
	}
	
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 列表数据
	 * 儿童保健指导
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listBaby", method = RequestMethod.POST)
	public Model listDirectiveOpinionTemplateActoinBaby(@RequestParam Map<String, Object> reqs, Page<DirectiveOpinionTemplatePO> page) {
		log.debug("request data: listDirectiveOpinionTemplate");
		Model modelll = new Model();
		try {
			
			directiveOpinionTemplateService.listForPageBaby(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelll.setPage(page);
		return modelll;
	}
	
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE列表数据
	 * 高危儿童保健指导
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listBabyHightRisk", method = RequestMethod.POST)
	public Model listDirectiveOpinionTemplateActoinBabyHightRisk(@RequestParam Map<String, Object> reqs, Page<DirectiveOpinionTemplatePO> page) {
		log.debug("request data: listDirectiveOpinionTemplate");
		Model modelll = new Model();
		try {
			
			directiveOpinionTemplateService.listForPageBabyHightRisk(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelll.setPage(page);
		return modelll;
	}

	/**
	 * DIRECTIVE_OPINION_TEMPLATE 添加
	 * 
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addDirectiveOpinionTemplateActoin(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		ModelAndView model = new ModelAndView("redirect:/directive/list");
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			String uuid = IdUtil.uuid();
			directiveOpinionTemplateVO.setId(uuid);
			directiveOpinionTemplateVO.setCreatTime(new Date());
			directiveOpinionTemplateVO.setUpdateTime(new Date());
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.create(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "redirect:/directive/list";
		return model;
	}
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 添加
	 * 添加孕产保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/addMaternal", method = RequestMethod.POST)
	public ModelAndView addDirectiveOpinionTemplateMaternal(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		ModelAndView modelview = new ModelAndView("config/maternal_list");
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			String uuid = IdUtil.uuid();
			directiveOpinionTemplateVO.setId(uuid);
			directiveOpinionTemplateVO.setCreatTime(new Date());
			directiveOpinionTemplateVO.setUpdateTime(new Date());
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.create(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			 
			
		}
		
		return modelview;
	}
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 添加
	 * 添加高位保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPregancy", method = RequestMethod.POST)
	public ModelAndView addDirectiveOpinionTemplatePregancy(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		ModelAndView model = new ModelAndView("redirect:/directive/listPregancy");
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			String uuid = IdUtil.uuid();
			directiveOpinionTemplateVO.setId(uuid);
			directiveOpinionTemplateVO.setCreatTime(new Date());
			directiveOpinionTemplateVO.setUpdateTime(new Date());
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.create(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "redirect:/directive/list";
		return model;
	}
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 添加
	 * 添加儿童保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 * @author wangbj
	 */
	@ResponseBody
	@RequestMapping(value = "/addBaby", method = RequestMethod.POST)
	public ModelAndView addDirectiveOpinionTemplateBaby(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		ModelAndView model = new ModelAndView("redirect:/directive/listBabyView");
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			String uuid = IdUtil.uuid();
			directiveOpinionTemplateVO.setId(uuid);
			directiveOpinionTemplateVO.setCreatTime(new Date());
			directiveOpinionTemplateVO.setUpdateTime(new Date());
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.create(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "redirect:/directive/list";
		return model;
	}
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 添加
	 * 添加儿童保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 * @author wangbj
	 */
	@ResponseBody
	@RequestMapping(value = "/addBabyHightRidk", method = RequestMethod.POST)
	public ModelAndView addDirectiveOpinionTemplateBabyHightRidk(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		ModelAndView model = new ModelAndView("redirect:/directive/listBabyHightRiskView");
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			String uuid = IdUtil.uuid();
			directiveOpinionTemplateVO.setId(uuid);
			directiveOpinionTemplateVO.setCreatTime(new Date());
			directiveOpinionTemplateVO.setUpdateTime(new Date());
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.create(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "redirect:/directive/list";
		return model;
	}
	
	
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 婚前指导修改
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			DirectiveOpinionTemplatePO find = directiveOpinionTemplateService.find(id);
			List<PremaritalAbnormalOptionPO> findall = premaritalAbnormalOptionService.findAll();
			
			reqs.put("DirectiveOpinionTemplatePO", find);
			reqs.put("findall", findall);
			modelAndView = new ModelAndView(
					"config/directive_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 孕产保健指导修改
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	@RequestMapping(value = "/updateMaternal", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoinMaternal(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			DirectiveOpinionTemplatePO find = directiveOpinionTemplateService.find(id);
			reqs.put("DirectiveOpinionTemplatePO", find);
			modelAndView = new ModelAndView(
					"config/maternal_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 高危妊娠指导修改
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	@RequestMapping(value = "/updatePregancy", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoinPregancy(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			DirectiveOpinionTemplatePO find = directiveOpinionTemplateService.find(id);
			List<HighRiskPregnancyScorePO> HighRiskAll = highRiskPregnancyScoreService.findAll();
			reqs.put("HighRiskAll", HighRiskAll);
			reqs.put("DirectiveOpinionTemplatePO", find);
			modelAndView = new ModelAndView(
					"config/pregancy_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	
	
	
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 高危妊娠指导修改
	 * @param marriageRegistrationDataVO
	 * @return
	 * @author wangbj
	 */
	@RequestMapping(value = "/updateBabyView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoinBaby(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			DirectiveOpinionTemplatePO find = directiveOpinionTemplateService.find(id);
			List<HighRiskPregnancyScorePO> HighRiskAll = highRiskPregnancyScoreService.findAll();
			reqs.put("HighRiskAll", HighRiskAll);
			reqs.put("DirectiveOpinionTemplatePO", find);
			modelAndView = new ModelAndView(
					"config/babyderective_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改
	 * 高危妊娠指导修改
	 * @param marriageRegistrationDataVO
	 * @return
	 * @author wangbj
	 */
	@RequestMapping(value = "/updateBabyHightRiskView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoinBabyHightRisk(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			DirectiveOpinionTemplatePO find = directiveOpinionTemplateService.find(id);
			List<HighRiskPregnancyScorePO> HighRiskAll = highRiskPregnancyScoreService.findAllBaby();
			reqs.put("HighRiskAll", HighRiskAll);
			reqs.put("DirectiveOpinionTemplatePO", find);
			modelAndView = new ModelAndView(
					"config/babyHightRisk_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 修改
	 * 婚前保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDirectiveOpinionTemplateActoin(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.update(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/directive/list";
	}
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 修改
	 * 孕产保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/updateMater", method = RequestMethod.POST)
	public String updateDirectiveOpinionTemplateActoinMater(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.update(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/directive/listMaternal";
	}
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 修改
	 * 高危妊娠指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/updatepre", method = RequestMethod.POST)
	public String updateDirectiveOpinionTemplateActoinPre(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.update(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/directive/listPregancy";
	}
	
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 修改
	 * 儿童保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/updateBaby", method = RequestMethod.POST)
	public String updateDirectiveOpinionTemplateActoinBaby(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.update(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/directive/listBabyView";
	}
	
	
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 修改
	 * 高危儿童保健指导
	 * @param directiveOpinionTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/updateBabyHightRisk", method = RequestMethod.POST)
	public String updateDirectiveOpinionTemplateActoinBabyHightRisk(DirectiveOpinionTemplateVO directiveOpinionTemplateVO) {
		
		try {
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			BeanUtils.copyProperties(directiveOpinionTemplatePO, directiveOpinionTemplateVO);
			directiveOpinionTemplateService.update(directiveOpinionTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/directive/listBabyHightRiskView";
	}
	/**
	 * DIRECTIVE_OPINION_TEMPLATE 删除
	 * 
	 * @param directiveOpinionTemplateIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delDirectiveOpinionTemplateAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			directiveOpinionTemplateService.deletes(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}