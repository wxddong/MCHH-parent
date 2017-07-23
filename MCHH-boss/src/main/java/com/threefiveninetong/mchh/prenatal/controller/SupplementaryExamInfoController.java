/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SupplementaryExamInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.prenatal.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
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

import com.threefiveninetong.mchh.prenatal.po.SupplementaryExamInfoPO;
import com.threefiveninetong.mchh.prenatal.vo.SupplementaryExamInfoVO;
import com.threefiveninetong.mchh.prenatal.service.SupplementaryExamInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: SupplementaryExamInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/prenatal/supplementaryexaminfo")
public class SupplementaryExamInfoController {

	private static final Logger log =Logger.getLogger(SupplementaryExamInfoController.class);
	@Resource
	private  SupplementaryExamInfoService  supplementaryExamInfoService;

    /**
	 * SUPPLEMENTARY_EXAM_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listSupplementaryExamInfoView() {
		log.debug("request page: /sysset/supplementaryExamInfo/supplementaryExamInfo_list");
		return "sysset/supplementaryExamInfo/supplementaryExamInfo_list";
	}
	/**
	 * SUPPLEMENTARY_EXAM_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listSupplementaryExamInfoActoin(@RequestParam Map<String, Object> reqs, Page<SupplementaryExamInfoPO> page) {
		log.debug("request data: listSupplementaryExamInfo");
		Model model = new Model();
		try {
			supplementaryExamInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * SUPPLEMENTARY_EXAM_INFO 添加
	 * 
	 * @param supplementaryExamInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addSupplementaryExamInfoActoin(SupplementaryExamInfoVO supplementaryExamInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			supplementaryExamInfoService.create(supplementaryExamInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * SUPPLEMENTARY_EXAM_INFO 修改
	 * 
	 * @param supplementaryExamInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateSupplementaryExamInfoActoin(SupplementaryExamInfoVO supplementaryExamInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			SupplementaryExamInfoPO supplementaryExamInfoPO = new SupplementaryExamInfoPO();
			BeanUtils.copyProperties(supplementaryExamInfoPO, supplementaryExamInfoVO);
			supplementaryExamInfoService.update(supplementaryExamInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * SUPPLEMENTARY_EXAM_INFO 删除
	 * 
	 * @param supplementaryExamInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delSupplementaryExamInfoAction(@RequestParam("supplementaryExamInfoIds") String supplementaryExamInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			supplementaryExamInfoService.deletes(supplementaryExamInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}