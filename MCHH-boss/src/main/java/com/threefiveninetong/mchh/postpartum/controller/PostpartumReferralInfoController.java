/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumReferralInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-29 17:49:18 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.postpartum.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.postpartum.po.PostpartumReferralInfoPO;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumReferralInfoVO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumReferralInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PostpartumReferralInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-29 17:49:18 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/postpartum/postpartumreferralinfo")
public class PostpartumReferralInfoController {

	private static final Logger log =Logger.getLogger(PostpartumReferralInfoController.class);
	@Resource
	private  PostpartumReferralInfoService  postpartumReferralInfoService;

    /**
	 * POSTPARTUM_REFERRAL_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPostpartumReferralInfoView() {
		log.debug("request page: /sysset/postpartumReferralInfo/postpartumReferralInfo_list");
		return "sysset/postpartumReferralInfo/postpartumReferralInfo_list";
	}
	/**
	 * POSTPARTUM_REFERRAL_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPostpartumReferralInfoActoin(@RequestParam Map<String, Object> reqs, Page<PostpartumReferralInfoPO> page) {
		log.debug("request data: listPostpartumReferralInfo");
		Model model = new Model();
		try {
			postpartumReferralInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * POSTPARTUM_REFERRAL_INFO 添加
	 * 
	 * @param postpartumReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPostpartumReferralInfoActoin(PostpartumReferralInfoVO postpartumReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PostpartumReferralInfoPO postpartumReferralInfoPO = new PostpartumReferralInfoPO();
			BeanUtils.copyProperties(postpartumReferralInfoPO, postpartumReferralInfoVO);
			postpartumReferralInfoService.create(postpartumReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POSTPARTUM_REFERRAL_INFO 修改
	 * 
	 * @param postpartumReferralInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePostpartumReferralInfoActoin(PostpartumReferralInfoVO postpartumReferralInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PostpartumReferralInfoPO postpartumReferralInfoPO = new PostpartumReferralInfoPO();
			BeanUtils.copyProperties(postpartumReferralInfoPO, postpartumReferralInfoVO);
			postpartumReferralInfoService.update(postpartumReferralInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POSTPARTUM_REFERRAL_INFO 删除
	 * 
	 * @param postpartumReferralInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPostpartumReferralInfoAction(@RequestParam("postpartumReferralInfoIds") String postpartumReferralInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			postpartumReferralInfoService.deletes(postpartumReferralInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}