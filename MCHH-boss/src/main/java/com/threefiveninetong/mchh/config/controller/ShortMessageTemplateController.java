/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ShortMessageTemplateController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.ShortMessageTemplatePO;
import com.threefiveninetong.mchh.config.vo.ShortMessageTemplateVO;
import com.threefiveninetong.mchh.config.service.ShortMessageTemplateService;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ShortMessageTemplateController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Controller
@RequestMapping("/shortmessage")
public class ShortMessageTemplateController {

	private static final Logger log =Logger.getLogger(ShortMessageTemplateController.class);
	@Resource
	private  ShortMessageTemplateService  shortMessageTemplateService;

    /**
	 * SHORT_MESSAGE_TEMPLATE 列表视图
	 * @return
	 * 预约检查短信页面
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listShortMessageTemplateView(HttpServletRequest request,HttpServletResponse response) {
		log.debug("request page: /sysset/shortMessageTemplate/shortMessageTemplate_list");
		List<ShortMessageTemplatePO> findAll = shortMessageTemplateService.findAll();
		request.setAttribute("findAll", findAll);
		return "config/shortMassage_list";
	}
	
	
	 /**
		 * SHORT_MESSAGE_TEMPLATE 列表视图
		 * @return
		 * 高危检查短信页面
		 */
		@RequestMapping(value = "/listHight", method = RequestMethod.GET)
		public String listShortMessageTemplate(HttpServletRequest request,HttpServletResponse response) {
			log.debug("request page: /sysset/shortMessageTemplate/shortMessageTemplate_list");
			List<ShortMessageTemplatePO> findAll = shortMessageTemplateService.findAllHight();
			request.setAttribute("findAll", findAll);
			return "config/hightCheck_list";
		}
	/**
	 * SHORT_MESSAGE_TEMPLATE 列表数据
	 * 预约检查短信
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listShortMessageTemplateActoin(@RequestParam Map<String, Object> reqs, Page<ShortMessageTemplatePO> page) {
		log.debug("request data: listShortMessageTemplate");
		Model model = new Model();
		try {
			shortMessageTemplateService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	
	/**
	 * SHORT_MESSAGE_TEMPLATE 列表数据
	 * 高危检查短信
	 * 
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listHight", method = RequestMethod.POST)
	public Model listShortMessageTemplateHightActoin(@RequestParam Map<String, Object> reqs, Page<ShortMessageTemplatePO> page) {
		log.debug("request data: listShortMessageTemplate");
		Model model = new Model();
		try {
			shortMessageTemplateService.listForPageHight(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}


	/**
	 * SHORT_MESSAGE_TEMPLATE 添加
	 * 
	 * @param shortMessageTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addShortMessageTemplateActoin(ShortMessageTemplateVO shortMessageTemplateVO) {
		try {
			String id = IdUtil.uuid();
			shortMessageTemplateVO.setId(id);
			shortMessageTemplateVO.setCreatTime(new Date());
			shortMessageTemplateVO.setUpdateTime(new Date());
			ShortMessageTemplatePO shortMessageTemplatePO = new ShortMessageTemplatePO();
			BeanUtils.copyProperties(shortMessageTemplatePO, shortMessageTemplateVO);
			shortMessageTemplateService.create(shortMessageTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/shortmessage/list";
	}
	
	
	
	/**
	 * SHORT_MESSAGE_TEMPLATE 添加
	 * 
	 * @param shortMessageTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/addHight", method = RequestMethod.POST)
	public String addShortMessageTemplateHightActoin(ShortMessageTemplateVO shortMessageTemplateVO) {
		try {
			String id = IdUtil.uuid();
			shortMessageTemplateVO.setId(id);
			shortMessageTemplateVO.setCreatTime(new Date());
			shortMessageTemplateVO.setUpdateTime(new Date());
			ShortMessageTemplatePO shortMessageTemplatePO = new ShortMessageTemplatePO();
			BeanUtils.copyProperties(shortMessageTemplatePO, shortMessageTemplateVO);
			shortMessageTemplateService.create(shortMessageTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/shortmessage/listHight";
	}
	/**
	 * SHORT_MESSAGE_TEMPLATE 修改页面
	 * 预约检查短信
	 * @param shortMessageTemplateVO
	 * @return
	 */
	
	
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public ModelAndView updateShortMessageTemplateActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			ShortMessageTemplatePO find = shortMessageTemplateService.find(id);
			reqs.put("ShortMessageTemplatePO", find);
			modelAndView = new ModelAndView(
					"config/shortMassage_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	
	
	
	
	/**
	 * SHORT_MESSAGE_TEMPLATE 修改页面
	 * 高危检查短信
	 * @param shortMessageTemplateVO
	 * @return
	 */
	
	
	@RequestMapping(value = "/updateViewHight", method = RequestMethod.GET)
	public ModelAndView updateShortMessageTemplateHightActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			ShortMessageTemplatePO find = shortMessageTemplateService.find(id);
			reqs.put("ShortMessageTemplatePO", find);
			modelAndView = new ModelAndView(
					"config/hightCheck_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	/**
	 * SHORT_MESSAGE_TEMPLATE 修改
	 * 预约检查短信
	 * @param shortMessageTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShortMessageTemplateActoin(ShortMessageTemplateVO shortMessageTemplateVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ShortMessageTemplatePO shortMessageTemplatePO = new ShortMessageTemplatePO();
			
			BeanUtils.copyProperties(shortMessageTemplatePO, shortMessageTemplateVO);
			shortMessageTemplateService.update(shortMessageTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return "redirect:/shortmessage/list";
	}

	
	
	
	/**
	 * SHORT_MESSAGE_TEMPLATE 修改
	 * 高危检查短信
	 * @param shortMessageTemplateVO
	 * @return
	 */
	@RequestMapping(value = "/updateHight", method = RequestMethod.POST)
	public String updateShortMessageTemplateHightActoin(ShortMessageTemplateVO shortMessageTemplateVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ShortMessageTemplatePO shortMessageTemplatePO = new ShortMessageTemplatePO();
			
			BeanUtils.copyProperties(shortMessageTemplatePO, shortMessageTemplateVO);
			shortMessageTemplateService.update(shortMessageTemplatePO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return "redirect:/shortmessage/listHight";
	}

	/**
	 * SHORT_MESSAGE_TEMPLATE 删除
	 * 
	 * @param shortMessageTemplateIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delShortMessageTemplateAction(@RequestParam("ids") String Ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			shortMessageTemplateService.deletes(Ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}