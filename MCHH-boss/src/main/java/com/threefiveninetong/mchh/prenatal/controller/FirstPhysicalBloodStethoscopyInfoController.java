/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstPhysicalBloodStethoscopyInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:37 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.prenatal.po.FirstPhysicalBloodStethoscopyInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.FirstPhysicalBloodStethoscopyInfoVO;
import com.threefiveninetong.mchh.prenatal.service.FirstPhysicalBloodStethoscopyInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: FirstPhysicalBloodStethoscopyInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/firstphysicalbloodstethoscopyinfo")
public class FirstPhysicalBloodStethoscopyInfoController {

	private static final Logger log =Logger.getLogger(FirstPhysicalBloodStethoscopyInfoController.class);
	@Resource
	private  FirstPhysicalBloodStethoscopyInfoService  firstPhysicalBloodStethoscopyInfoService;

    /**
	 * FIRST_PHYSICAL_BLOOD_STETHOSCOPY_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listFirstPhysicalBloodStethoscopyInfoView() {
		log.debug("request page: /sysset/firstPhysicalBloodStethoscopyInfo/firstPhysicalBloodStethoscopyInfo_list");
		return "sysset/firstPhysicalBloodStethoscopyInfo/firstPhysicalBloodStethoscopyInfo_list";
	}
	/**
	 * FIRST_PHYSICAL_BLOOD_STETHOSCOPY_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listFirstPhysicalBloodStethoscopyInfoActoin(@RequestParam Map<String, Object> reqs, Page<FirstPhysicalBloodStethoscopyInfoPO> page) {
		log.debug("request data: listFirstPhysicalBloodStethoscopyInfo");
		Model model = new Model();
		try {
			firstPhysicalBloodStethoscopyInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * FIRST_PHYSICAL_BLOOD_STETHOSCOPY_INFO 添加
	 * 
	 * @param firstPhysicalBloodStethoscopyInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addFirstPhysicalBloodStethoscopyInfoActoin(FirstPhysicalBloodStethoscopyInfoVO firstPhysicalBloodStethoscopyInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO = new FirstPhysicalBloodStethoscopyInfoPO();
			BeanUtils.copyProperties(firstPhysicalBloodStethoscopyInfoPO, firstPhysicalBloodStethoscopyInfoVO);
			firstPhysicalBloodStethoscopyInfoService.create(firstPhysicalBloodStethoscopyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * FIRST_PHYSICAL_BLOOD_STETHOSCOPY_INFO 修改
	 * 
	 * @param firstPhysicalBloodStethoscopyInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateFirstPhysicalBloodStethoscopyInfoActoin(FirstPhysicalBloodStethoscopyInfoVO firstPhysicalBloodStethoscopyInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			FirstPhysicalBloodStethoscopyInfoPO firstPhysicalBloodStethoscopyInfoPO = new FirstPhysicalBloodStethoscopyInfoPO();
			BeanUtils.copyProperties(firstPhysicalBloodStethoscopyInfoPO, firstPhysicalBloodStethoscopyInfoVO);
			firstPhysicalBloodStethoscopyInfoService.update(firstPhysicalBloodStethoscopyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * FIRST_PHYSICAL_BLOOD_STETHOSCOPY_INFO 删除
	 * 
	 * @param firstPhysicalBloodStethoscopyInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delFirstPhysicalBloodStethoscopyInfoAction(@RequestParam("firstPhysicalBloodStethoscopyInfoIds") String firstPhysicalBloodStethoscopyInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			firstPhysicalBloodStethoscopyInfoService.deletes(firstPhysicalBloodStethoscopyInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}