/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PhysiqueExaInfoController.java   
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

import com.threefiveninetong.mchh.premarital.po.PhysiqueExaInfoPO;
import com.threefiveninetong.mchh.premarital.vo.PhysiqueExaInfoVO;
import com.threefiveninetong.mchh.premarital.service.PhysiqueExaInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PhysiqueExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/premarital/physiqueexainfo")
public class PhysiqueExaInfoController {

	private static final Logger log =Logger.getLogger(PhysiqueExaInfoController.class);
	@Resource
	private  PhysiqueExaInfoService  physiqueExaInfoService;

    /**
	 * PHYSIQUE_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPhysiqueExaInfoView() {
		log.debug("request page: /sysset/physiqueExaInfo/physiqueExaInfo_list");
		return "sysset/physiqueExaInfo/physiqueExaInfo_list";
	}
	/**
	 * PHYSIQUE_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPhysiqueExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<PhysiqueExaInfoPO> page) {
		log.debug("request data: listPhysiqueExaInfo");
		Model model = new Model();
		try {
			physiqueExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * PHYSIQUE_EXA_INFO 添加
	 * 
	 * @param physiqueExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPhysiqueExaInfoActoin(PhysiqueExaInfoVO physiqueExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.create(physiqueExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PHYSIQUE_EXA_INFO 修改
	 * 
	 * @param physiqueExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePhysiqueExaInfoActoin(PhysiqueExaInfoVO physiqueExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PhysiqueExaInfoPO physiqueExaInfoPO = new PhysiqueExaInfoPO();
			BeanUtils.copyProperties(physiqueExaInfoPO, physiqueExaInfoVO);
			physiqueExaInfoService.update(physiqueExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PHYSIQUE_EXA_INFO 删除
	 * 
	 * @param physiqueExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPhysiqueExaInfoAction(@RequestParam("physiqueExaInfoIds") String physiqueExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			physiqueExaInfoService.deletes(physiqueExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}