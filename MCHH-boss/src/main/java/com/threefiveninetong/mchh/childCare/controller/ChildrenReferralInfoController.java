/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenReferralInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 10:17:32 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.childCare.po.ChildrenReferralInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenReferralInfoVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenReferralInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenReferralInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:32 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenreferralinfo")
public class ChildrenReferralInfoController {

	private static final Logger log =Logger.getLogger(ChildrenReferralInfoController.class);
	@Resource
	private  ChildrenReferralInfoService  childrenReferralInfoService;

    /**
	 * CHILDREN_REFERRAL_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenReferralInfoView() {
		log.debug("request page: /sysset/childrenReferralInfo/childrenReferralInfo_list");
		return "sysset/childrenReferralInfo/childrenReferralInfo_list";
	}
	/**
	 * CHILDREN_REFERRAL_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenReferralInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenReferralInfoPO> page) {
		log.debug("request data: listChildrenReferralInfo");
		Model model = new Model();
		try {
			childrenReferralInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_REFERRAL_INFO 添加
	 * 
	 * @param childrenReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenReferralInfoActoin(ChildrenReferralInfoVO childrenReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenReferralInfoPO childrenReferralInfoPO = new ChildrenReferralInfoPO();
			BeanUtils.copyProperties(childrenReferralInfoPO, childrenReferralInfoVO);
			childrenReferralInfoService.create(childrenReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_REFERRAL_INFO 修改
	 * 
	 * @param childrenReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenReferralInfoActoin(ChildrenReferralInfoVO childrenReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenReferralInfoPO childrenReferralInfoPO = new ChildrenReferralInfoPO();
			BeanUtils.copyProperties(childrenReferralInfoPO, childrenReferralInfoVO);
			childrenReferralInfoService.update(childrenReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_REFERRAL_INFO 删除
	 * 
	 * @param childrenReferralInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenReferralInfoAction(@RequestParam("childrenReferralInfoIds") String childrenReferralInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenReferralInfoService.deletes(childrenReferralInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}