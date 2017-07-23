/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHighRiskInfoController.java   
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

import com.threefiveninetong.mchh.childCare.po.ChildrenHighRiskInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenHighRiskInfoVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenHighRiskInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenHighRiskInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:33 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenhighriskinfo")
public class ChildrenHighRiskInfoController {

	private static final Logger log =Logger.getLogger(ChildrenHighRiskInfoController.class);
	@Resource
	private  ChildrenHighRiskInfoService  childrenHighRiskInfoService;

    /**
	 * CHILDREN_HIGH_RISK_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenHighRiskInfoView() {
		log.debug("request page: /sysset/childrenHighRiskInfo/childrenHighRiskInfo_list");
		return "sysset/childrenHighRiskInfo/childrenHighRiskInfo_list";
	}
	/**
	 * CHILDREN_HIGH_RISK_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenHighRiskInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenHighRiskInfoPO> page) {
		log.debug("request data: listChildrenHighRiskInfo");
		Model model = new Model();
		try {
			childrenHighRiskInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_HIGH_RISK_INFO 添加
	 * 
	 * @param childrenHighRiskInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenHighRiskInfoActoin(ChildrenHighRiskInfoVO childrenHighRiskInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenHighRiskInfoPO childrenHighRiskInfoPO = new ChildrenHighRiskInfoPO();
			BeanUtils.copyProperties(childrenHighRiskInfoPO, childrenHighRiskInfoVO);
			childrenHighRiskInfoService.create(childrenHighRiskInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_HIGH_RISK_INFO 修改
	 * 
	 * @param childrenHighRiskInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenHighRiskInfoActoin(ChildrenHighRiskInfoVO childrenHighRiskInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenHighRiskInfoPO childrenHighRiskInfoPO = new ChildrenHighRiskInfoPO();
			BeanUtils.copyProperties(childrenHighRiskInfoPO, childrenHighRiskInfoVO);
			childrenHighRiskInfoService.update(childrenHighRiskInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_HIGH_RISK_INFO 删除
	 * 
	 * @param childrenHighRiskInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenHighRiskInfoAction(@RequestParam("childrenHighRiskInfoIds") String childrenHighRiskInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenHighRiskInfoService.deletes(childrenHighRiskInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}