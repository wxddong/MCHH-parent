/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPhysiqueExaInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 10:17:31 
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

import com.threefiveninetong.mchh.childCare.po.ChildrenPhysiqueExaInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenPhysiqueExaInfoVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenPhysiqueExaInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenPhysiqueExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:31 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenphysiqueexainfo")
public class ChildrenPhysiqueExaInfoController {

	private static final Logger log =Logger.getLogger(ChildrenPhysiqueExaInfoController.class);
	@Resource
	private  ChildrenPhysiqueExaInfoService  childrenPhysiqueExaInfoService;

    /**
	 * CHILDREN_PHYSIQUE_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenPhysiqueExaInfoView() {
		log.debug("request page: /sysset/childrenPhysiqueExaInfo/childrenPhysiqueExaInfo_list");
		return "sysset/childrenPhysiqueExaInfo/childrenPhysiqueExaInfo_list";
	}
	/**
	 * CHILDREN_PHYSIQUE_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenPhysiqueExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenPhysiqueExaInfoPO> page) {
		log.debug("request data: listChildrenPhysiqueExaInfo");
		Model model = new Model();
		try {
			childrenPhysiqueExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_PHYSIQUE_EXA_INFO 添加
	 * 
	 * @param childrenPhysiqueExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenPhysiqueExaInfoActoin(ChildrenPhysiqueExaInfoVO childrenPhysiqueExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenPhysiqueExaInfoPO childrenPhysiqueExaInfoPO = new ChildrenPhysiqueExaInfoPO();
			BeanUtils.copyProperties(childrenPhysiqueExaInfoPO, childrenPhysiqueExaInfoVO);
			childrenPhysiqueExaInfoService.create(childrenPhysiqueExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_PHYSIQUE_EXA_INFO 修改
	 * 
	 * @param childrenPhysiqueExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenPhysiqueExaInfoActoin(ChildrenPhysiqueExaInfoVO childrenPhysiqueExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenPhysiqueExaInfoPO childrenPhysiqueExaInfoPO = new ChildrenPhysiqueExaInfoPO();
			BeanUtils.copyProperties(childrenPhysiqueExaInfoPO, childrenPhysiqueExaInfoVO);
			childrenPhysiqueExaInfoService.update(childrenPhysiqueExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_PHYSIQUE_EXA_INFO 删除
	 * 
	 * @param childrenPhysiqueExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenPhysiqueExaInfoAction(@RequestParam("childrenPhysiqueExaInfoIds") String childrenPhysiqueExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenPhysiqueExaInfoService.deletes(childrenPhysiqueExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}