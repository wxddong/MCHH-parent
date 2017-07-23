/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PostpartumExaDetailedInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.postpartum.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:39 
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

import com.threefiveninetong.mchh.postpartum.po.PostpartumExaDetailedInfoPO;
import com.threefiveninetong.mchh.postpartum.vo.PostpartumExaDetailedInfoVO;
import com.threefiveninetong.mchh.postpartum.service.PostpartumExaDetailedInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PostpartumExaDetailedInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:39 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/postpartum/postpartumexadetailedinfo")
public class PostpartumExaDetailedInfoController {

	private static final Logger log =Logger.getLogger(PostpartumExaDetailedInfoController.class);
	@Resource
	private  PostpartumExaDetailedInfoService  postpartumExaDetailedInfoService;

    /**
	 * POSTPARTUM_EXA_DETAILED_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPostpartumExaDetailedInfoView() {
		log.debug("request page: /sysset/postpartumExaDetailedInfo/postpartumExaDetailedInfo_list");
		return "sysset/postpartumExaDetailedInfo/postpartumExaDetailedInfo_list";
	}
	/**
	 * POSTPARTUM_EXA_DETAILED_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPostpartumExaDetailedInfoActoin(@RequestParam Map<String, Object> reqs, Page<PostpartumExaDetailedInfoPO> page) {
		log.debug("request data: listPostpartumExaDetailedInfo");
		Model model = new Model();
		try {
			postpartumExaDetailedInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * POSTPARTUM_EXA_DETAILED_INFO 添加
	 * 
	 * @param postpartumExaDetailedInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addPostpartumExaDetailedInfoActoin(PostpartumExaDetailedInfoVO postpartumExaDetailedInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PostpartumExaDetailedInfoPO postpartumExaDetailedInfoPO = new PostpartumExaDetailedInfoPO();
			BeanUtils.copyProperties(postpartumExaDetailedInfoPO, postpartumExaDetailedInfoVO);
			postpartumExaDetailedInfoService.create(postpartumExaDetailedInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POSTPARTUM_EXA_DETAILED_INFO 修改
	 * 
	 * @param postpartumExaDetailedInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updatePostpartumExaDetailedInfoActoin(PostpartumExaDetailedInfoVO postpartumExaDetailedInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			PostpartumExaDetailedInfoPO postpartumExaDetailedInfoPO = new PostpartumExaDetailedInfoPO();
			BeanUtils.copyProperties(postpartumExaDetailedInfoPO, postpartumExaDetailedInfoVO);
			postpartumExaDetailedInfoService.update(postpartumExaDetailedInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POSTPARTUM_EXA_DETAILED_INFO 删除
	 * 
	 * @param postpartumExaDetailedInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPostpartumExaDetailedInfoAction(@RequestParam("postpartumExaDetailedInfoIds") String postpartumExaDetailedInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			postpartumExaDetailedInfoService.deletes(postpartumExaDetailedInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}