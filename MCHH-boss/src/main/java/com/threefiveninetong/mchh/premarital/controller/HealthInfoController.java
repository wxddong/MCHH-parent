/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HealthInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:32 
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

import com.threefiveninetong.mchh.premarital.po.HealthInfoPO;
import com.threefiveninetong.mchh.premarital.vo.HealthInfoVO;
import com.threefiveninetong.mchh.premarital.service.HealthInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: HealthInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:32 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/premarital/healthinfo")
public class HealthInfoController {

	private static final Logger log =Logger.getLogger(HealthInfoController.class);
	@Resource
	private  HealthInfoService  healthInfoService;

    /**
	 * HEALTH_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHealthInfoView() {
		log.debug("request page: /sysset/healthInfo/healthInfo_list");
		return "sysset/healthInfo/healthInfo_list";
	}
	/**
	 * HEALTH_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listHealthInfoActoin(@RequestParam Map<String, Object> reqs, Page<HealthInfoPO> page) {
		log.debug("request data: listHealthInfo");
		Model model = new Model();
		try {
			healthInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * HEALTH_INFO 添加
	 * 
	 * @param healthInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addHealthInfoActoin(HealthInfoVO healthInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.create(healthInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * HEALTH_INFO 修改
	 * 
	 * @param healthInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateHealthInfoActoin(HealthInfoVO healthInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			HealthInfoPO healthInfoPO = new HealthInfoPO();
			BeanUtils.copyProperties(healthInfoPO, healthInfoVO);
			healthInfoService.update(healthInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * HEALTH_INFO 删除
	 * 
	 * @param healthInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delHealthInfoAction(@RequestParam("healthInfoIds") String healthInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			healthInfoService.deletes(healthInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}