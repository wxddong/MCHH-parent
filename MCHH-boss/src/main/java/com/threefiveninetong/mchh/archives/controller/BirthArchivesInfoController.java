/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: BirthArchivesInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.archives.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:42 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.archives.controller;


import javax.annotation.Resource;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.vo.BirthArchivesInfoVO;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: BirthArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:42 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/archives/birtharchivesinfo")
public class BirthArchivesInfoController {

	private static final Logger log =Logger.getLogger(BirthArchivesInfoController.class);
	@Resource
	private  BirthArchivesInfoService  birthArchivesInfoService;

    /**
	 * BIRTH_ARCHIVES_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listBirthArchivesInfoView() {
		log.debug("request page: /sysset/birthArchivesInfo/birthArchivesInfo_list");
		return "sysset/birthArchivesInfo/birthArchivesInfo_list";
	}
	/**
	 * BIRTH_ARCHIVES_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listBirthArchivesInfoActoin(@RequestParam Map<String, Object> reqs, Page<BirthArchivesInfoPO> page) {
		log.debug("request data: listBirthArchivesInfo");
		Model model = new Model();
		try {
			birthArchivesInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * BIRTH_ARCHIVES_INFO 添加
	 * 
	 * @param birthArchivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addBirthArchivesInfoActoin(BirthArchivesInfoVO birthArchivesInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
			BeanUtils.copyProperties(birthArchivesInfoPO, birthArchivesInfoVO);
			birthArchivesInfoService.create(birthArchivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * BIRTH_ARCHIVES_INFO 修改
	 * 
	 * @param birthArchivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateBirthArchivesInfoActoin(BirthArchivesInfoVO birthArchivesInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			BirthArchivesInfoPO birthArchivesInfoPO = new BirthArchivesInfoPO();
			BeanUtils.copyProperties(birthArchivesInfoPO, birthArchivesInfoVO);
			birthArchivesInfoService.update(birthArchivesInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * BIRTH_ARCHIVES_INFO 删除
	 * 
	 * @param birthArchivesInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delBirthArchivesInfoAction(@RequestParam("birthArchivesInfoIds") String birthArchivesInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			birthArchivesInfoService.deletes(birthArchivesInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}