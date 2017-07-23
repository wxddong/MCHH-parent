/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthBabyInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childbirth.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 20:03:49 
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

import com.threefiveninetong.mchh.childbirth.po.ChildbirthBabyInfoPO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthBabyInfoVO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBabyInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildbirthBabyInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 20:03:49 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childbirth/childbirthbabyinfo")
public class ChildbirthBabyInfoController {

	private static final Logger log =Logger.getLogger(ChildbirthBabyInfoController.class);
	@Resource
	private  ChildbirthBabyInfoService  childbirthBabyInfoService;

    /**
	 * CHILDBIRTH_BABY_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildbirthBabyInfoView() {
		log.debug("request page: /sysset/childbirthBabyInfo/childbirthBabyInfo_list");
		return "sysset/childbirthBabyInfo/childbirthBabyInfo_list";
	}
	/**
	 * CHILDBIRTH_BABY_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildbirthBabyInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildbirthBabyInfoPO> page) {
		log.debug("request data: listChildbirthBabyInfo");
		Model model = new Model();
		try {
			childbirthBabyInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDBIRTH_BABY_INFO 添加
	 * 
	 * @param childbirthBabyInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildbirthBabyInfoActoin(ChildbirthBabyInfoVO childbirthBabyInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthBabyInfoPO childbirthBabyInfoPO = new ChildbirthBabyInfoPO();
			BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
			childbirthBabyInfoService.create(childbirthBabyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_BABY_INFO 修改
	 * 
	 * @param childbirthBabyInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildbirthBabyInfoActoin(ChildbirthBabyInfoVO childbirthBabyInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthBabyInfoPO childbirthBabyInfoPO = new ChildbirthBabyInfoPO();
			BeanUtils.copyProperties(childbirthBabyInfoPO, childbirthBabyInfoVO);
			childbirthBabyInfoService.update(childbirthBabyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_BABY_INFO 删除
	 * 
	 * @param childbirthBabyInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildbirthBabyInfoAction(@RequestParam("childbirthBabyInfoIds") String childbirthBabyInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childbirthBabyInfoService.deletes(childbirthBabyInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}