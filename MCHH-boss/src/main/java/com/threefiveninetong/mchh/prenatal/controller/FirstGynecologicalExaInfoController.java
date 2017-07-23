/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstGynecologicalExaInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
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

import com.threefiveninetong.mchh.prenatal.po.FirstGynecologicalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.FirstGynecologicalExaInfoVO;
import com.threefiveninetong.mchh.prenatal.service.FirstGynecologicalExaInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: FirstGynecologicalExaInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/firstgynecologicalexainfo")
public class FirstGynecologicalExaInfoController {

	private static final Logger log =Logger.getLogger(FirstGynecologicalExaInfoController.class);
	@Resource
	private  FirstGynecologicalExaInfoService  firstGynecologicalExaInfoService;

    /**
	 * FIRST_GYNECOLOGICAL_EXA_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listFirstGynecologicalExaInfoView() {
		log.debug("request page: /sysset/firstGynecologicalExaInfo/firstGynecologicalExaInfo_list");
		return "sysset/firstGynecologicalExaInfo/firstGynecologicalExaInfo_list";
	}
	/**
	 * FIRST_GYNECOLOGICAL_EXA_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listFirstGynecologicalExaInfoActoin(@RequestParam Map<String, Object> reqs, Page<FirstGynecologicalExaInfoPO> page) {
		log.debug("request data: listFirstGynecologicalExaInfo");
		Model model = new Model();
		try {
			firstGynecologicalExaInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * FIRST_GYNECOLOGICAL_EXA_INFO 添加
	 * 
	 * @param firstGynecologicalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addFirstGynecologicalExaInfoActoin(FirstGynecologicalExaInfoVO firstGynecologicalExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = new FirstGynecologicalExaInfoPO();
			BeanUtils.copyProperties(firstGynecologicalExaInfoPO, firstGynecologicalExaInfoVO);
			firstGynecologicalExaInfoService.create(firstGynecologicalExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * FIRST_GYNECOLOGICAL_EXA_INFO 修改
	 * 
	 * @param firstGynecologicalExaInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateFirstGynecologicalExaInfoActoin(FirstGynecologicalExaInfoVO firstGynecologicalExaInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			FirstGynecologicalExaInfoPO firstGynecologicalExaInfoPO = new FirstGynecologicalExaInfoPO();
			BeanUtils.copyProperties(firstGynecologicalExaInfoPO, firstGynecologicalExaInfoVO);
			firstGynecologicalExaInfoService.update(firstGynecologicalExaInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * FIRST_GYNECOLOGICAL_EXA_INFO 删除
	 * 
	 * @param firstGynecologicalExaInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delFirstGynecologicalExaInfoAction(@RequestParam("firstGynecologicalExaInfoIds") String firstGynecologicalExaInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			firstGynecologicalExaInfoService.deletes(firstGynecologicalExaInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}