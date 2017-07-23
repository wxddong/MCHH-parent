/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBasicInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childbirth.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:05 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childbirth.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthBasicInfoVO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBasicInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildbirthBasicInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:05 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childbirth/childbirthbasicinfo")
public class ChildbirthBasicInfoController {

	private static final Logger log =Logger.getLogger(ChildbirthBasicInfoController.class);
	@Resource
	private  ChildbirthBasicInfoService  childbirthBasicInfoService;

    /**
	 * CHILDBIRTH_BASIC_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildbirthBasicInfoView() {
		log.debug("request page: /sysset/childbirthBasicInfo/childbirthBasicInfo_list");
		return "sysset/childbirthBasicInfo/childbirthBasicInfo_list";
	}
	/**
	 * CHILDBIRTH_BASIC_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildbirthBasicInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildbirthBasicInfoPO> page) {
		log.debug("request data: listChildbirthBasicInfo");
		Model model = new Model();
		try {
			childbirthBasicInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDBIRTH_BASIC_INFO 添加
	 * 
	 * @param childbirthBasicInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildbirthBasicInfoActoin(ChildbirthBasicInfoVO childbirthBasicInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthBasicInfoPO childbirthBasicInfoPO = new ChildbirthBasicInfoPO();
			BeanUtils.copyProperties(childbirthBasicInfoPO, childbirthBasicInfoVO);
			childbirthBasicInfoService.create(childbirthBasicInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_BASIC_INFO 修改
	 * 
	 * @param childbirthBasicInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildbirthBasicInfoActoin(ChildbirthBasicInfoVO childbirthBasicInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthBasicInfoPO childbirthBasicInfoPO = new ChildbirthBasicInfoPO();
			BeanUtils.copyProperties(childbirthBasicInfoPO, childbirthBasicInfoVO);
			childbirthBasicInfoService.update(childbirthBasicInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_BASIC_INFO 删除
	 * 
	 * @param childbirthBasicInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildbirthBasicInfoAction(@RequestParam("childbirthBasicInfoIds") String childbirthBasicInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childbirthBasicInfoService.deletes(childbirthBasicInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}