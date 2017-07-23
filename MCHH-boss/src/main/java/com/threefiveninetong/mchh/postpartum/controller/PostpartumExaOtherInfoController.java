/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaOtherInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-31 13:47:42 
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

import com.threefiveninetong.mchh.postpartum.po.PostpartumExaOtherInfoPO;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumExaOtherInfoVO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaOtherInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PostpartumExaOtherInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-31 13:47:42 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/postpartum/postpartumexaotherinfo")
public class PostpartumExaOtherInfoController {

	private static final Logger log =Logger.getLogger(PostpartumExaOtherInfoController.class);
	@Resource
	private  PostpartumExaOtherInfoService  postpartumExaOtherInfoService;

    /**
	 * POSTPARTUM_EXA_OTHER_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPostpartumExaOtherInfoView() {
		log.debug("request page: /sysset/postpartumExaOtherInfo/postpartumExaOtherInfo_list");
		return "sysset/postpartumExaOtherInfo/postpartumExaOtherInfo_list";
	}
	/**
	 * POSTPARTUM_EXA_OTHER_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPostpartumExaOtherInfoActoin(@RequestParam Map<String, Object> reqs, Page<PostpartumExaOtherInfoPO> page) {
		log.debug("request data: listPostpartumExaOtherInfo");
		Model model = new Model();
		try {
			postpartumExaOtherInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * POSTPARTUM_EXA_OTHER_INFO 添加
	 * 
	 * @param postpartumExaOtherInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPostpartumExaOtherInfoActoin(PostpartumExaOtherInfoVO postpartumExaOtherInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PostpartumExaOtherInfoPO postpartumExaOtherInfoPO = new PostpartumExaOtherInfoPO();
			BeanUtils.copyProperties(postpartumExaOtherInfoPO, postpartumExaOtherInfoVO);
			postpartumExaOtherInfoService.create(postpartumExaOtherInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POSTPARTUM_EXA_OTHER_INFO 修改
	 * 
	 * @param postpartumExaOtherInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePostpartumExaOtherInfoActoin(PostpartumExaOtherInfoVO postpartumExaOtherInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PostpartumExaOtherInfoPO postpartumExaOtherInfoPO = new PostpartumExaOtherInfoPO();
			BeanUtils.copyProperties(postpartumExaOtherInfoPO, postpartumExaOtherInfoVO);
			postpartumExaOtherInfoService.update(postpartumExaOtherInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POSTPARTUM_EXA_OTHER_INFO 删除
	 * 
	 * @param postpartumExaOtherInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPostpartumExaOtherInfoAction(@RequestParam("postpartumExaOtherInfoIds") String postpartumExaOtherInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			postpartumExaOtherInfoService.deletes(postpartumExaOtherInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}