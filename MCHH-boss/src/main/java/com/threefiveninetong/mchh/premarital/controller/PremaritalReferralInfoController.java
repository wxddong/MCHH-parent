/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalReferralInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
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

import com.threefiveninetong.mchh.premarital.po.PremaritalReferralInfoPO;
import com.threefiveninetong.mchh.premarital.vo.PremaritalReferralInfoVO;
import com.threefiveninetong.mchh.premarital.service.PremaritalReferralInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PremaritalReferralInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/premarital/premaritalreferralinfo")
public class PremaritalReferralInfoController {

	private static final Logger log =Logger.getLogger(PremaritalReferralInfoController.class);
	@Resource
	private  PremaritalReferralInfoService  premaritalReferralInfoService;

    /**
	 * PREMARITAL_REFERRAL_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPremaritalReferralInfoView() {
		log.debug("request page: /sysset/premaritalReferralInfo/premaritalReferralInfo_list");
		return "sysset/premaritalReferralInfo/premaritalReferralInfo_list";
	}
	/**
	 * PREMARITAL_REFERRAL_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPremaritalReferralInfoActoin(@RequestParam Map<String, Object> reqs, Page<PremaritalReferralInfoPO> page) {
		log.debug("request data: listPremaritalReferralInfo");
		Model model = new Model();
		try {
			premaritalReferralInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * PREMARITAL_REFERRAL_INFO 添加
	 * 
	 * @param premaritalReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPremaritalReferralInfoActoin(PremaritalReferralInfoVO premaritalReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.create(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PREMARITAL_REFERRAL_INFO 修改
	 * 
	 * @param premaritalReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePremaritalReferralInfoActoin(PremaritalReferralInfoVO premaritalReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PremaritalReferralInfoPO premaritalReferralInfoPO = new PremaritalReferralInfoPO();
			BeanUtils.copyProperties(premaritalReferralInfoPO, premaritalReferralInfoVO);
			premaritalReferralInfoService.update(premaritalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PREMARITAL_REFERRAL_INFO 删除
	 * 
	 * @param premaritalReferralInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPremaritalReferralInfoAction(@RequestParam("premaritalReferralInfoIds") String premaritalReferralInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			premaritalReferralInfoService.deletes(premaritalReferralInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}