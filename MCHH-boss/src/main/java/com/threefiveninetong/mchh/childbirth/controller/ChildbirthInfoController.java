/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childbirth.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 20:03:48 
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

import com.threefiveninetong.mchh.childbirth.po.ChildbirthInfoPO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthInfoVO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildbirthInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 20:03:48 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childbirth/childbirthinfo")
public class ChildbirthInfoController {

	private static final Logger log =Logger.getLogger(ChildbirthInfoController.class);
	@Resource
	private  ChildbirthInfoService  childbirthInfoService;

    /**
	 * CHILDBIRTH_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildbirthInfoView() {
		log.debug("request page: /sysset/childbirthInfo/childbirthInfo_list");
		return "sysset/childbirthInfo/childbirthInfo_list";
	}
	/**
	 * CHILDBIRTH_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildbirthInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildbirthInfoPO> page) {
		log.debug("request data: listChildbirthInfo");
		Model model = new Model();
		try {
			childbirthInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDBIRTH_INFO 添加
	 * 
	 * @param childbirthInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildbirthInfoActoin(ChildbirthInfoVO childbirthInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthInfoPO childbirthInfoPO = new ChildbirthInfoPO();
			BeanUtils.copyProperties(childbirthInfoPO, childbirthInfoVO);
			childbirthInfoService.create(childbirthInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_INFO 修改
	 * 
	 * @param childbirthInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildbirthInfoActoin(ChildbirthInfoVO childbirthInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthInfoPO childbirthInfoPO = new ChildbirthInfoPO();
			BeanUtils.copyProperties(childbirthInfoPO, childbirthInfoVO);
			childbirthInfoService.update(childbirthInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_INFO 删除
	 * 
	 * @param childbirthInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildbirthInfoAction(@RequestParam("childbirthInfoIds") String childbirthInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childbirthInfoService.deletes(childbirthInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}