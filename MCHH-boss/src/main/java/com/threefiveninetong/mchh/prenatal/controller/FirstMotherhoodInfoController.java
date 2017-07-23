/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: FirstMotherhoodInfoController.java   
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

import com.threefiveninetong.mchh.prenatal.po.FirstMotherhoodInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.FirstMotherhoodInfoVO;
import com.threefiveninetong.mchh.prenatal.service.FirstMotherhoodInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: FirstMotherhoodInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/firstmotherhoodinfo")
public class FirstMotherhoodInfoController {

	private static final Logger log =Logger.getLogger(FirstMotherhoodInfoController.class);
	@Resource
	private  FirstMotherhoodInfoService  firstMotherhoodInfoService;

    /**
	 * FIRST_MOTHERHOOD_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listFirstMotherhoodInfoView() {
		log.debug("request page: /sysset/firstMotherhoodInfo/firstMotherhoodInfo_list");
		return "sysset/firstMotherhoodInfo/firstMotherhoodInfo_list";
	}
	/**
	 * FIRST_MOTHERHOOD_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listFirstMotherhoodInfoActoin(@RequestParam Map<String, Object> reqs, Page<FirstMotherhoodInfoPO> page) {
		log.debug("request data: listFirstMotherhoodInfo");
		Model model = new Model();
		try {
			firstMotherhoodInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * FIRST_MOTHERHOOD_INFO 添加
	 * 
	 * @param firstMotherhoodInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addFirstMotherhoodInfoActoin(FirstMotherhoodInfoVO firstMotherhoodInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
			BeanUtils.copyProperties(firstMotherhoodInfoPO, firstMotherhoodInfoVO);
			firstMotherhoodInfoService.create(firstMotherhoodInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * FIRST_MOTHERHOOD_INFO 修改
	 * 
	 * @param firstMotherhoodInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateFirstMotherhoodInfoActoin(FirstMotherhoodInfoVO firstMotherhoodInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			FirstMotherhoodInfoPO firstMotherhoodInfoPO = new FirstMotherhoodInfoPO();
			BeanUtils.copyProperties(firstMotherhoodInfoPO, firstMotherhoodInfoVO);
			firstMotherhoodInfoService.update(firstMotherhoodInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * FIRST_MOTHERHOOD_INFO 删除
	 * 
	 * @param firstMotherhoodInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delFirstMotherhoodInfoAction(@RequestParam("firstMotherhoodInfoIds") String firstMotherhoodInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			firstMotherhoodInfoService.deletes(firstMotherhoodInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}