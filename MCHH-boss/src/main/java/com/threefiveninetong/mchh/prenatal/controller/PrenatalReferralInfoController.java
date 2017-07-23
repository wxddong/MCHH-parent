/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PrenatalReferralInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:17 
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

import com.threefiveninetong.mchh.prenatal.po.PrenatalReferralInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.PrenatalReferralInfoVO;
import com.threefiveninetong.mchh.prenatal.service.PrenatalReferralInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PrenatalReferralInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:17 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/prenatalreferralinfo")
public class PrenatalReferralInfoController {

	private static final Logger log =Logger.getLogger(PrenatalReferralInfoController.class);
	@Resource
	private  PrenatalReferralInfoService  prenatalReferralInfoService;

    /**
	 * PRENATAL_REFERRAL_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPrenatalReferralInfoView() {
		log.debug("request page: /sysset/prenatalReferralInfo/prenatalReferralInfo_list");
		return "sysset/prenatalReferralInfo/prenatalReferralInfo_list";
	}
	/**
	 * PRENATAL_REFERRAL_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPrenatalReferralInfoActoin(@RequestParam Map<String, Object> reqs, Page<PrenatalReferralInfoPO> page) {
		log.debug("request data: listPrenatalReferralInfo");
		Model model = new Model();
		try {
			prenatalReferralInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * PRENATAL_REFERRAL_INFO 添加
	 * 
	 * @param prenatalReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPrenatalReferralInfoActoin(PrenatalReferralInfoVO prenatalReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalReferralInfoService.create(prenatalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PRENATAL_REFERRAL_INFO 修改
	 * 
	 * @param prenatalReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePrenatalReferralInfoActoin(PrenatalReferralInfoVO prenatalReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PrenatalReferralInfoPO prenatalReferralInfoPO = new PrenatalReferralInfoPO();
			BeanUtils.copyProperties(prenatalReferralInfoPO, prenatalReferralInfoVO);
			prenatalReferralInfoService.update(prenatalReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PRENATAL_REFERRAL_INFO 删除
	 * 
	 * @param prenatalReferralInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPrenatalReferralInfoAction(@RequestParam("prenatalReferralInfoIds") String prenatalReferralInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			prenatalReferralInfoService.deletes(prenatalReferralInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}