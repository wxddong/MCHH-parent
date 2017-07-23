/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskTermController.java   
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

import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.vo.HighRiskTermVO;
import com.threefiveninetong.mchh.prenatal.service.HighRiskTermService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: HighRiskTermController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:37 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/highriskterm")
public class HighRiskTermController {

	private static final Logger log =Logger.getLogger(HighRiskTermController.class);
	@Resource
	private  HighRiskTermService  highRiskTermService;

    /**
	 * HIGH_RISK_TERM 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHighRiskTermView() {
		log.debug("request page: /sysset/highRiskTerm/highRiskTerm_list");
		return "sysset/highRiskTerm/highRiskTerm_list";
	}
	/**
	 * HIGH_RISK_TERM 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listHighRiskTermActoin(@RequestParam Map<String, Object> reqs, Page<HighRiskTermPO> page) {
		log.debug("request data: listHighRiskTerm");
		Model model = new Model();
		try {
			highRiskTermService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * HIGH_RISK_TERM 添加
	 * 
	 * @param highRiskTermVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addHighRiskTermActoin(HighRiskTermVO highRiskTermVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			HighRiskTermPO highRiskTermPO = new HighRiskTermPO();
			BeanUtils.copyProperties(highRiskTermPO, highRiskTermVO);
			highRiskTermService.create(highRiskTermPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * HIGH_RISK_TERM 修改
	 * 
	 * @param highRiskTermVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateHighRiskTermActoin(HighRiskTermVO highRiskTermVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			HighRiskTermPO highRiskTermPO = new HighRiskTermPO();
			BeanUtils.copyProperties(highRiskTermPO, highRiskTermVO);
			highRiskTermService.update(highRiskTermPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * HIGH_RISK_TERM 删除
	 * 
	 * @param highRiskTermIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delHighRiskTermAction(@RequestParam("highRiskTermIds") String highRiskTermIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			highRiskTermService.deletes(highRiskTermIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}