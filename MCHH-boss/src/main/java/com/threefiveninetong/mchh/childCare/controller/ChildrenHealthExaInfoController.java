/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenHealthExaInfoController.java   
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

import com.threefiveninetong.mchh.childCare.po.ChildrenHealthExaInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenHealthExaInfoVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenHealthExaInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenHealthExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:31 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenhealthexainfo")
public class ChildrenHealthExaInfoController {

	private static final Logger log =Logger.getLogger(ChildrenHealthExaInfoController.class);
	@Resource
	private  ChildrenHealthExaInfoService  childrenHealthExaInfoService;

    /**
	 * CHILDREN_HEALTH_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenHealthExaInfoView() {
		log.debug("request page: /sysset/childrenHealthExaInfo/childrenHealthExaInfo_list");
		return "sysset/childrenHealthExaInfo/childrenHealthExaInfo_list";
	}
	/**
	 * CHILDREN_HEALTH_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenHealthExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenHealthExaInfoPO> page) {
		log.debug("request data: listChildrenHealthExaInfo");
		Model model = new Model();
		try {
			childrenHealthExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_HEALTH_EXA_INFO 添加
	 * 
	 * @param childrenHealthExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenHealthExaInfoActoin(ChildrenHealthExaInfoVO childrenHealthExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenHealthExaInfoPO childrenHealthExaInfoPO = new ChildrenHealthExaInfoPO();
			BeanUtils.copyProperties(childrenHealthExaInfoPO, childrenHealthExaInfoVO);
			childrenHealthExaInfoService.create(childrenHealthExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_HEALTH_EXA_INFO 修改
	 * 
	 * @param childrenHealthExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenHealthExaInfoActoin(ChildrenHealthExaInfoVO childrenHealthExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenHealthExaInfoPO childrenHealthExaInfoPO = new ChildrenHealthExaInfoPO();
			BeanUtils.copyProperties(childrenHealthExaInfoPO, childrenHealthExaInfoVO);
			childrenHealthExaInfoService.update(childrenHealthExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_HEALTH_EXA_INFO 删除
	 * 
	 * @param childrenHealthExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenHealthExaInfoAction(@RequestParam("childrenHealthExaInfoIds") String childrenHealthExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenHealthExaInfoService.deletes(childrenHealthExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}