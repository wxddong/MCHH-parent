/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskTermController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 10:17:33 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskTermPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenHighRiskTermVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenHighRiskTermService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenHighRiskTermController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:33 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenhighriskterm")
public class ChildrenHighRiskTermController {

	private static final Logger log =Logger.getLogger(ChildrenHighRiskTermController.class);
	@Resource
	private  ChildrenHighRiskTermService  childrenHighRiskTermService;

    /**
	 * CHILDREN_HIGH_RISK_TERM 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenHighRiskTermView() {
		log.debug("request page: /sysset/childrenHighRiskTerm/childrenHighRiskTerm_list");
		return "sysset/childrenHighRiskTerm/childrenHighRiskTerm_list";
	}
	/**
	 * CHILDREN_HIGH_RISK_TERM 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenHighRiskTermActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenHighRiskTermPO> page) {
		log.debug("request data: listChildrenHighRiskTerm");
		Model model = new Model();
		try {
			childrenHighRiskTermService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_HIGH_RISK_TERM 添加
	 * 
	 * @param childrenHighRiskTermVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenHighRiskTermActoin(ChildrenHighRiskTermVO childrenHighRiskTermVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenHighRiskTermPO childrenHighRiskTermPO = new ChildrenHighRiskTermPO();
			BeanUtils.copyProperties(childrenHighRiskTermPO, childrenHighRiskTermVO);
			childrenHighRiskTermService.create(childrenHighRiskTermPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_HIGH_RISK_TERM 修改
	 * 
	 * @param childrenHighRiskTermVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenHighRiskTermActoin(ChildrenHighRiskTermVO childrenHighRiskTermVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenHighRiskTermPO childrenHighRiskTermPO = new ChildrenHighRiskTermPO();
			BeanUtils.copyProperties(childrenHighRiskTermPO, childrenHighRiskTermVO);
			childrenHighRiskTermService.update(childrenHighRiskTermPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_HIGH_RISK_TERM 删除
	 * 
	 * @param childrenHighRiskTermIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenHighRiskTermAction(@RequestParam("childrenHighRiskTermIds") String childrenHighRiskTermIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenHighRiskTermService.deletes(childrenHighRiskTermIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}