/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: VillageInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import javax.annotation.Resource;

import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.vo.TownshipInfoVO;
import com.threefiveninetong.mchh.config.vo.VillageInfoVO;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: VillageInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Controller
@RequestMapping("/config/villageInfo")
public class VillageInfoController {

	private static final Logger log =Logger.getLogger(VillageInfoController.class);
	@Resource
	private  VillageInfoService  villageInfoService;
	
	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	/**
	 * 通过乡镇id获取乡镇下的所有村
	 * @param townshipId
	 * @return
	 * @author yanwk
	 */
    @ResponseBody
	@RequestMapping(value="/villageByTownshipId",method=RequestMethod.GET)
	public Model getVillageByTownshipId(@RequestParam(value="parentId")String townshipId){
		
		log.debug("request data:listVillageInfo");
		
		Model model = new Model();
		List<VillageInfoPO> list = null;
		
		try {
			VillageInfoPO villageInfoPO = new VillageInfoPO();
			VillageInfoVO villageInfoVO = new VillageInfoVO();
			BeanUtils.copyProperties(villageInfoPO, villageInfoVO);
			list = villageInfoService.getTownshipByCountyId(townshipId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		return model;
	}

    /**
	 * VILLAGE_INFO 列表视图
	 * wangxd 2016.8.24
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listVillageInfoView() {
		log.debug("request page: /sysset/villageInfo/villageInfo_list");
		return "/config/villageInfo_list";
	}
	/**
	 * VILLAGE_INFO 列表数据
	 * wangxd 2016.8.24
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listVillageInfoActoin(@RequestParam Map<String, Object> reqs, Page<VillageInfoPO> page) {
		log.debug("request data: listVillageInfo");
		Model model = new Model();
		try {
			villageInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	/**
	 * 获取全部的街道以及所有的省用来下拉列表的显示
	 * wangxd 2016.08.24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Model getAllTownShip(Map<String,Object> map){
		
		log.debug("request data:listProvinceInfo");
		Model model = new Model();
		List<String> list =villageInfoService.findAllSortNum();
		List<ProvinceInfoPO> provinceList = provinceInfoService.findAll();
		model.set("provinceList", provinceList);
		model.set("list", list);
		return model;
	}
	
	/**
	 * 添加和修改省前 验证是否有重复的村
	 * wangxd
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findByName",method = RequestMethod.GET)
	public Model beforeAddOrUpdate(@RequestParam(value="name") String name){
		Model model = new Model();
		VillageInfoPO villageInfoPO = villageInfoService.getByName(name);
		if(villageInfoPO==null){
			model.set("villageInfoPO", null);
		}else{
			model.set("villageInfoPO", villageInfoPO);
		}
		return model;
	}

	/**
	 * VILLAGE_INFO 添加
	 * wangxd 2016.8.26
	 * @param villageInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addVillageInfoActoin(VillageInfoPO villageInfoPO,
										@RequestParam(value="sortNum")String sortNum) {
		String replace = sortNum.replace(" ", "");
		int sortNumInt = Integer.parseInt(replace);
		Model model = new Model();
		model.set("msg", "true");
		try {
			villageInfoPO.setSortNum(sortNumInt);
			villageInfoService.addVillageInfo(villageInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * VILLAGE_INFO 修改
	 * wangxd 2016.8.26
	 * @param villageInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateVillageInfoActoin(VillageInfoPO villageInfoPO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			villageInfoService.updateVillageInfo(villageInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * 
	 * @param roleIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delVillageInfoAction(@RequestParam("villageIds") String villageIds) {
		Model model = new Model();
		
		try {
			villageInfoService.delVillageInfo(villageIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

}