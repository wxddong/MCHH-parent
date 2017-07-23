/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildbirthReferralInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childbirth.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
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

import com.threefiveninetong.mchh.childbirth.po.ChildbirthReferralInfoPO;
import com.threefiveninetong.mchh.childbirth.vo.ChildbirthReferralInfoVO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthReferralInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildbirthReferralInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childbirth/childbirthreferralinfo")
public class ChildbirthReferralInfoController {

	private static final Logger log =Logger.getLogger(ChildbirthReferralInfoController.class);
	@Resource
	private  ChildbirthReferralInfoService  childbirthReferralInfoService;

    /**
	 * CHILDBIRTH_REFERRAL_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildbirthReferralInfoView() {
		log.debug("request page: /sysset/childbirthReferralInfo/childbirthReferralInfo_list");
		return "sysset/childbirthReferralInfo/childbirthReferralInfo_list";
	}
	/**
	 * CHILDBIRTH_REFERRAL_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildbirthReferralInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildbirthReferralInfoPO> page) {
		log.debug("request data: listChildbirthReferralInfo");
		Model model = new Model();
		try {
			childbirthReferralInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDBIRTH_REFERRAL_INFO 添加
	 * 
	 * @param childbirthReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildbirthReferralInfoActoin(ChildbirthReferralInfoVO childbirthReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
			BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
			childbirthReferralInfoService.create(childbirthReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_REFERRAL_INFO 修改
	 * 
	 * @param childbirthReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildbirthReferralInfoActoin(ChildbirthReferralInfoVO childbirthReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildbirthReferralInfoPO childbirthReferralInfoPO = new ChildbirthReferralInfoPO();
			BeanUtils.copyProperties(childbirthReferralInfoPO, childbirthReferralInfoVO);
			childbirthReferralInfoService.update(childbirthReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDBIRTH_REFERRAL_INFO 删除
	 * 
	 * @param childbirthReferralInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildbirthReferralInfoAction(@RequestParam("childbirthReferralInfoIds") String childbirthReferralInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childbirthReferralInfoService.deletes(childbirthReferralInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}