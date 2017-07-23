/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskInfoController.java   
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

import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.HighRiskInfoVO;
import com.threefiveninetong.mchh.prenatal.service.HighRiskInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: HighRiskInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/highriskinfo")
public class HighRiskInfoController {

	private static final Logger log =Logger.getLogger(HighRiskInfoController.class);
	@Resource
	private  HighRiskInfoService  highRiskInfoService;

    /**
	 * HIGH_RISK_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHighRiskInfoView() {
		log.debug("request page: /sysset/highRiskInfo/highRiskInfo_list");
		return "sysset/highRiskInfo/highRiskInfo_list";
	}
	/**
	 * HIGH_RISK_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listHighRiskInfoActoin(@RequestParam Map<String, Object> reqs, Page<HighRiskInfoPO> page) {
		log.debug("request data: listHighRiskInfo");
		Model model = new Model();
		try {
			highRiskInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * HIGH_RISK_INFO 添加
	 * 
	 * @param highRiskInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addHighRiskInfoActoin(HighRiskInfoVO highRiskInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			BeanUtils.copyProperties(highRiskInfoPO, highRiskInfoVO);
			highRiskInfoService.create(highRiskInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * HIGH_RISK_INFO 修改
	 * 
	 * @param highRiskInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateHighRiskInfoActoin(HighRiskInfoVO highRiskInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			HighRiskInfoPO highRiskInfoPO = new HighRiskInfoPO();
			BeanUtils.copyProperties(highRiskInfoPO, highRiskInfoVO);
			highRiskInfoService.update(highRiskInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * HIGH_RISK_INFO 删除
	 * 
	 * @param highRiskInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delHighRiskInfoAction(@RequestParam("highRiskInfoIds") String highRiskInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			highRiskInfoService.deletes(highRiskInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}