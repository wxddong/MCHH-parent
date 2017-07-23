/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: InspectionResultController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.premarital.po.InspectionResultPO;
import com.threefiveninetong.mchh.premarital.vo.InspectionResultVO;
import com.threefiveninetong.mchh.premarital.service.InspectionResultService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: InspectionResultController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/premarital/inspectionresult")
public class InspectionResultController {

	private static final Logger log =Logger.getLogger(InspectionResultController.class);
	@Resource
	private  InspectionResultService  inspectionResultService;

    /**
	 * INSPECTION_RESULT 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listInspectionResultView() {
		log.debug("request page: /sysset/inspectionResult/inspectionResult_list");
		return "sysset/inspectionResult/inspectionResult_list";
	}
	/**
	 * INSPECTION_RESULT 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listInspectionResultActoin(@RequestParam Map<String, Object> reqs, Page<InspectionResultPO> page) {
		log.debug("request data: listInspectionResult");
		Model model = new Model();
		try {
			inspectionResultService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * INSPECTION_RESULT 添加
	 * 
	 * @param inspectionResultVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addInspectionResultActoin(InspectionResultVO inspectionResultVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.create(inspectionResultPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * INSPECTION_RESULT 修改
	 * 
	 * @param inspectionResultVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateInspectionResultActoin(InspectionResultVO inspectionResultVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			InspectionResultPO inspectionResultPO = new InspectionResultPO();
			BeanUtils.copyProperties(inspectionResultPO, inspectionResultVO);
			inspectionResultService.update(inspectionResultPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * INSPECTION_RESULT 删除
	 * 
	 * @param inspectionResultIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delInspectionResultAction(@RequestParam("inspectionResultIds") String inspectionResultIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			inspectionResultService.deletes(inspectionResultIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}