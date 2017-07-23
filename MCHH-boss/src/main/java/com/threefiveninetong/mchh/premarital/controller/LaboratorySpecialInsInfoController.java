/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: LaboratorySpecialInsInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
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

import com.threefiveninetong.mchh.premarital.po.LaboratorySpecialInsInfoPO;
import com.threefiveninetong.mchh.premarital.vo.LaboratorySpecialInsInfoVO;
import com.threefiveninetong.mchh.premarital.service.LaboratorySpecialInsInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: LaboratorySpecialInsInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/premarital/laboratoryspecialinsinfo")
public class LaboratorySpecialInsInfoController {

	private static final Logger log =Logger.getLogger(LaboratorySpecialInsInfoController.class);
	@Resource
	private  LaboratorySpecialInsInfoService  laboratorySpecialInsInfoService;

    /**
	 * LABORATORY_SPECIAL_INS_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listLaboratorySpecialInsInfoView() {
		log.debug("request page: /sysset/laboratorySpecialInsInfo/laboratorySpecialInsInfo_list");
		return "sysset/laboratorySpecialInsInfo/laboratorySpecialInsInfo_list";
	}
	/**
	 * LABORATORY_SPECIAL_INS_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listLaboratorySpecialInsInfoActoin(@RequestParam Map<String, Object> reqs, Page<LaboratorySpecialInsInfoPO> page) {
		log.debug("request data: listLaboratorySpecialInsInfo");
		Model model = new Model();
		try {
			laboratorySpecialInsInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * LABORATORY_SPECIAL_INS_INFO 添加
	 * 
	 * @param laboratorySpecialInsInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addLaboratorySpecialInsInfoActoin(LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.create(laboratorySpecialInsInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * LABORATORY_SPECIAL_INS_INFO 修改
	 * 
	 * @param laboratorySpecialInsInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateLaboratorySpecialInsInfoActoin(LaboratorySpecialInsInfoVO laboratorySpecialInsInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			LaboratorySpecialInsInfoPO laboratorySpecialInsInfoPO = new LaboratorySpecialInsInfoPO();
			BeanUtils.copyProperties(laboratorySpecialInsInfoPO, laboratorySpecialInsInfoVO);
			laboratorySpecialInsInfoService.update(laboratorySpecialInsInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * LABORATORY_SPECIAL_INS_INFO 删除
	 * 
	 * @param laboratorySpecialInsInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delLaboratorySpecialInsInfoAction(@RequestParam("laboratorySpecialInsInfoIds") String laboratorySpecialInsInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			laboratorySpecialInsInfoService.deletes(laboratorySpecialInsInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}