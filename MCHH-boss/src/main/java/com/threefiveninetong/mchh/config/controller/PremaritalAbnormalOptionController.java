/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalAbnormalOptionController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;
import com.threefiveninetong.mchh.config.vo.PremaritalAbnormalOptionVO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: PremaritalAbnormalOptionController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Controller
@RequestMapping("/com/config/preoption")
public class PremaritalAbnormalOptionController {

	private static final Logger log =Logger.getLogger(PremaritalAbnormalOptionController.class);
	@Resource
	private  PremaritalAbnormalOptionService  premaritalAbnormalOptionService;

    /**
	 * PREMARITAL_ABNORMAL_OPTION 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPremaritalAbnormalOptionView() {
		log.debug("request page: /sysset/premaritalAbnormalOption/premaritalAbnormalOption_list");
		return "sysset/premaritalAbnormalOption/premaritalAbnormalOption_list";
	}
	
	
	
	 /**
		 * 系统添加特殊疾病页面
		 * @return
		 */
			@RequestMapping(value = "/addspecialIllview", method = RequestMethod.GET)
			public ModelAndView addxiaquView(Map<String, Object> reqs) {
				List<PremaritalAbnormalOptionPO> findAll = premaritalAbnormalOptionService.findAll();
				reqs.put("findAll", findAll);
				ModelAndView modelAndView = new ModelAndView(
						
						"config/special_ill_list", reqs);
				return modelAndView;
			}
			
			
			
			
	/**
	 * PREMARITAL_ABNORMAL_OPTION 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPremaritalAbnormalOptionActoin(@RequestParam Map<String, Object> reqs, Page<PremaritalAbnormalOptionPO> page) {
		log.debug("request data: listPremaritalAbnormalOption");
		Model model = new Model();
		try {
			premaritalAbnormalOptionService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	
	/**
	 * PREMARITAL_ABNORMAL_OPTION 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findByname", method = RequestMethod.GET)
	public Model findPremaritalAbnormalOptionActoinByname(@RequestParam Map<String, Object> reqs) {
		log.debug("request data: listPremaritalAbnormalOption");
		Model model = new Model();
		try {
			String name =(String) reqs.get("name");
			String type =(String) reqs.get("type");
			Map<String,Object> map1 = new HashMap<String,Object>();
			map1.put("name", name);
			map1.put("type", type);
//			String id =(String) reqs.get("id");
//			if(id!=null &&id!=""){
//				PremaritalAbnormalOptionPO find = premaritalAbnormalOptionService.find(id);
//				String name2 = find.getName();
//				if(name.equals(name2)&&type.equals(find.getType())){
//					model.set("premaritalAbnormalOptionVO", find);
//				}
//				if(!name.equals(name2)){
//					PremaritalAbnormalOptionPO premaritalAbnormalOptionVOByname = premaritalAbnormalOptionService.getPremaritalAbnormalOptionVOByname(map1);
//					if(premaritalAbnormalOptionVOByname !=null){
//						model.set("premaritalAbnormalOptionVO", premaritalAbnormalOptionVOByname);
//					}
//					if(premaritalAbnormalOptionVOByname==null){
//						model.set("premaritalAbnormalOptionVO", null);
//					}
//				}
//			}
//			if(id==null||id==""){
				PremaritalAbnormalOptionPO premaritalAbnormalOptionVOByname = premaritalAbnormalOptionService.getPremaritalAbnormalOptionVOByname(map1);
				if(premaritalAbnormalOptionVOByname !=null){
					model.set("premaritalAbnormalOptionVO", premaritalAbnormalOptionVOByname);
				}
				if(premaritalAbnormalOptionVOByname==null){
					model.set("premaritalAbnormalOptionVO", null);
//				}
//				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	/**
	 * PREMARITAL_ABNORMAL_OPTION 添加
	 * 
	 * @param premaritalAbnormalOptionVO
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPremaritalAbnormalOptionActoin(PremaritalAbnormalOptionVO premaritalAbnormalOptionVO,HttpServletRequest request) {
		try {
			
			String type = request.getParameter("type1");
			premaritalAbnormalOptionVO.setType(type);
			
			String uuid = IdUtil.uuid();
			PremaritalAbnormalOptionPO premaritalAbnormalOptionPO = new PremaritalAbnormalOptionPO();
			premaritalAbnormalOptionVO.setId(uuid);
			premaritalAbnormalOptionVO.setCreatTime(new Date());
			premaritalAbnormalOptionVO.setUpdateTime(new Date());
			BeanUtils.copyProperties(premaritalAbnormalOptionPO, premaritalAbnormalOptionVO);
			premaritalAbnormalOptionService.create(premaritalAbnormalOptionPO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/com/config/preoption/addspecialIllview";
		
	}
	/**
	 * 获取特殊疾病的类型
	 * wangxd 2016.08.24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Model getAllTownShip(Map<String,Object> map){
		
		log.debug("request data:listProvinceInfo");
		Model model = new Model();
		String  id= (String)map.get("id");
		PremaritalAbnormalOptionPO find = premaritalAbnormalOptionService.find(id);
		
		model.set("PremaritalAbnormalOptionPO", find);
		return model;
	}
	
	
	
	/**
	 *修改高危项管理页面
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			PremaritalAbnormalOptionPO premaritalAbnormalOptionPO = premaritalAbnormalOptionService.find(id);
			reqs.put("premaritalAbnormalOptionPO", premaritalAbnormalOptionPO);
			modelAndView = new ModelAndView(
					"config/special_ill_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	
	
	
	
	/**
	 * PREMARITAL_ABNORMAL_OPTION 修改
	 * 
	 * @param premaritalAbnormalOptionVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePremaritalAbnormalOptionActoin(PremaritalAbnormalOptionVO premaritalAbnormalOptionVO) {
		
		try {
			String id = premaritalAbnormalOptionVO.getId();
			String name = premaritalAbnormalOptionVO.getName();
			String type = premaritalAbnormalOptionVO.getType();
			PremaritalAbnormalOptionPO find = premaritalAbnormalOptionService.find(id);
			
			
			find.setName(name);
			find.setType(type);
			premaritalAbnormalOptionService.update(find);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "redirect:/com/config/preoption/addspecialIllview";
	}

	/**
	 * PREMARITAL_ABNORMAL_OPTION 删除
	 * 
	 * @param premaritalAbnormalOptionIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPremaritalAbnormalOptionAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			premaritalAbnormalOptionService.deletes(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}