/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPsychologicalBehaviorInfoController.java   
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

import com.threefiveninetong.mchh.childCare.po.ChildrenPsychologicalBehaviorInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenPsychologicalBehaviorInfoVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenPsychologicalBehaviorInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenPsychologicalBehaviorInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:33 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenpsychologicalbehaviorinfo")
public class ChildrenPsychologicalBehaviorInfoController {

	private static final Logger log =Logger.getLogger(ChildrenPsychologicalBehaviorInfoController.class);
	@Resource
	private  ChildrenPsychologicalBehaviorInfoService  childrenPsychologicalBehaviorInfoService;

    /**
	 * CHILDREN_PSYCHOLOGICAL_BEHAVIOR_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenPsychologicalBehaviorInfoView() {
		log.debug("request page: /sysset/childrenPsychologicalBehaviorInfo/childrenPsychologicalBehaviorInfo_list");
		return "sysset/childrenPsychologicalBehaviorInfo/childrenPsychologicalBehaviorInfo_list";
	}
	/**
	 * CHILDREN_PSYCHOLOGICAL_BEHAVIOR_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenPsychologicalBehaviorInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenPsychologicalBehaviorInfoPO> page) {
		log.debug("request data: listChildrenPsychologicalBehaviorInfo");
		Model model = new Model();
		try {
			childrenPsychologicalBehaviorInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_PSYCHOLOGICAL_BEHAVIOR_INFO 添加
	 * 
	 * @param childrenPsychologicalBehaviorInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenPsychologicalBehaviorInfoActoin(ChildrenPsychologicalBehaviorInfoVO childrenPsychologicalBehaviorInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenPsychologicalBehaviorInfoPO childrenPsychologicalBehaviorInfoPO = new ChildrenPsychologicalBehaviorInfoPO();
			BeanUtils.copyProperties(childrenPsychologicalBehaviorInfoPO, childrenPsychologicalBehaviorInfoVO);
			childrenPsychologicalBehaviorInfoService.create(childrenPsychologicalBehaviorInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_PSYCHOLOGICAL_BEHAVIOR_INFO 修改
	 * 
	 * @param childrenPsychologicalBehaviorInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenPsychologicalBehaviorInfoActoin(ChildrenPsychologicalBehaviorInfoVO childrenPsychologicalBehaviorInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenPsychologicalBehaviorInfoPO childrenPsychologicalBehaviorInfoPO = new ChildrenPsychologicalBehaviorInfoPO();
			BeanUtils.copyProperties(childrenPsychologicalBehaviorInfoPO, childrenPsychologicalBehaviorInfoVO);
			childrenPsychologicalBehaviorInfoService.update(childrenPsychologicalBehaviorInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_PSYCHOLOGICAL_BEHAVIOR_INFO 删除
	 * 
	 * @param childrenPsychologicalBehaviorInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenPsychologicalBehaviorInfoAction(@RequestParam("childrenPsychologicalBehaviorInfoIds") String childrenPsychologicalBehaviorInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenPsychologicalBehaviorInfoService.deletes(childrenPsychologicalBehaviorInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}