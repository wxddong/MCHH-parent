/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ObstetricExaInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
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

import com.threefiveninetong.mchh.prenatal.po.ObstetricExaInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.ObstetricExaInfoVO;
import com.threefiveninetong.mchh.prenatal.service.ObstetricExaInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ObstetricExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/obstetricexainfo")
public class ObstetricExaInfoController {

	private static final Logger log =Logger.getLogger(ObstetricExaInfoController.class);
	@Resource
	private  ObstetricExaInfoService  obstetricExaInfoService;

    /**
	 * OBSTETRIC_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listObstetricExaInfoView() {
		log.debug("request page: /sysset/obstetricExaInfo/obstetricExaInfo_list");
		return "sysset/obstetricExaInfo/obstetricExaInfo_list";
	}
	/**
	 * OBSTETRIC_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listObstetricExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<ObstetricExaInfoPO> page) {
		log.debug("request data: listObstetricExaInfo");
		Model model = new Model();
		try {
			obstetricExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * OBSTETRIC_EXA_INFO 添加
	 * 
	 * @param obstetricExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addObstetricExaInfoActoin(ObstetricExaInfoVO obstetricExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ObstetricExaInfoPO obstetricExaInfoPO = new ObstetricExaInfoPO();
			BeanUtils.copyProperties(obstetricExaInfoPO, obstetricExaInfoVO);
			obstetricExaInfoService.create(obstetricExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * OBSTETRIC_EXA_INFO 修改
	 * 
	 * @param obstetricExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateObstetricExaInfoActoin(ObstetricExaInfoVO obstetricExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ObstetricExaInfoPO obstetricExaInfoPO = new ObstetricExaInfoPO();
			BeanUtils.copyProperties(obstetricExaInfoPO, obstetricExaInfoVO);
			obstetricExaInfoService.update(obstetricExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * OBSTETRIC_EXA_INFO 删除
	 * 
	 * @param obstetricExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delObstetricExaInfoAction(@RequestParam("obstetricExaInfoIds") String obstetricExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			obstetricExaInfoService.deletes(obstetricExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}