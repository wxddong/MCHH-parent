/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenLastStatusInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-07 10:17:30 
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

import com.threefiveninetong.mchh.childCare.po.ChildrenLastStatusInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenLastStatusInfoVO;
import com.threefiveninetong.mchh.childCare.service.ChildrenLastStatusInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: ChildrenLastStatusInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-07 10:17:30 
 */
@Controller
@RequestMapping("/com/threefiveninetong/mchh/childCare/childrenlaststatusinfo")
public class ChildrenLastStatusInfoController {

	private static final Logger log =Logger.getLogger(ChildrenLastStatusInfoController.class);
	@Resource
	private  ChildrenLastStatusInfoService  childrenLastStatusInfoService;

    /**
	 * CHILDREN_LAST_STATUS_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listChildrenLastStatusInfoView() {
		log.debug("request page: /sysset/childrenLastStatusInfo/childrenLastStatusInfo_list");
		return "sysset/childrenLastStatusInfo/childrenLastStatusInfo_list";
	}
	/**
	 * CHILDREN_LAST_STATUS_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listChildrenLastStatusInfoActoin(@RequestParam Map<String, Object> reqs, Page<ChildrenLastStatusInfoPO> page) {
		log.debug("request data: listChildrenLastStatusInfo");
		Model model = new Model();
		try {
			childrenLastStatusInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

	/**
	 * CHILDREN_LAST_STATUS_INFO 添加
	 * 
	 * @param childrenLastStatusInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addChildrenLastStatusInfoActoin(ChildrenLastStatusInfoVO childrenLastStatusInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenLastStatusInfoPO childrenLastStatusInfoPO = new ChildrenLastStatusInfoPO();
			BeanUtils.copyProperties(childrenLastStatusInfoPO, childrenLastStatusInfoVO);
			childrenLastStatusInfoService.create(childrenLastStatusInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_LAST_STATUS_INFO 修改
	 * 
	 * @param childrenLastStatusInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateChildrenLastStatusInfoActoin(ChildrenLastStatusInfoVO childrenLastStatusInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ChildrenLastStatusInfoPO childrenLastStatusInfoPO = new ChildrenLastStatusInfoPO();
			BeanUtils.copyProperties(childrenLastStatusInfoPO, childrenLastStatusInfoVO);
			childrenLastStatusInfoService.update(childrenLastStatusInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CHILDREN_LAST_STATUS_INFO 删除
	 * 
	 * @param childrenLastStatusInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delChildrenLastStatusInfoAction(@RequestParam("childrenLastStatusInfoIds") String childrenLastStatusInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			childrenLastStatusInfoService.deletes(childrenLastStatusInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}