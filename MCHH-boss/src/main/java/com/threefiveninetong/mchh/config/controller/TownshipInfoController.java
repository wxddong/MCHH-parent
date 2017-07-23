/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: TownshipInfoController.java   
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

import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.vo.CityInfoVO;
import com.threefiveninetong.mchh.config.vo.TownshipInfoVO;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: TownshipInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Controller
@RequestMapping("/config/townshipinfo")
public class TownshipInfoController {

	private static final Logger log =Logger.getLogger(TownshipInfoController.class);
	@Resource
	private  TownshipInfoService  townshipInfoService;
	
	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	/**
	 * 通过县id获取县下的所有乡镇
	 * @param cityId
	 * @return
	 * @author yanwk
	 */
    @ResponseBody
	@RequestMapping(value="/townshipByCountyId",method=RequestMethod.GET)
	public Model getTownshipByCountyId(@RequestParam(value="parentId")String countyId){
		
		log.debug("request data:listTownshipInfo");
		
		Model model = new Model();
		List<TownshipInfoPO> list = null;
		
		try {
			TownshipInfoPO townshipInfoPO = new TownshipInfoPO();
			TownshipInfoVO townshipInfoVO = new TownshipInfoVO();
			BeanUtils.copyProperties(townshipInfoPO, townshipInfoVO);
			list = townshipInfoService.getTownshipByCountyId(countyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		return model;
	}
	
    /**
	 * TOWNSHIP_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listTownshipInfoView() {
		log.debug("request page: /sysset/townshipInfo/townshipInfo_list");
		return "/config/townshipInfo_list";
	}
	/**
	 * TOWNSHIP_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listTownshipInfoActoin(@RequestParam Map<String, Object> reqs, Page<TownshipInfoPO> page) {
		log.debug("request data: listTownshipInfo");
		Model model = new Model();
		try {
			townshipInfoService.listForPage(reqs, page);
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
		List<ProvinceInfoPO> provinceList = provinceInfoService.findAll();
		List<String> list = townshipInfoService.findAllSortNum();
		model.set("list", list);
		model.set("provinceList", provinceList);
		return model;
	}
	
	/**
	 * 添加和修改省前 验证是否有重复的镇
	 * wangxd
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findByName",method = RequestMethod.GET)
	public Model beforeAddOrUpdate(@RequestParam(value="name") String name){
		Model model = new Model();
		TownshipInfoPO townshipInfoPO = townshipInfoService.getByName(name);
		if(townshipInfoPO==null){
			model.set("townshipInfoPO", null);
		}else{
			model.set("townshipInfoPO", townshipInfoPO);
		}
		return model;
	}


	/**
	 * TOWNSHIP_INFO 添加
	 * wangxd 2016.8.26
	 * @param townshipInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addTownshipInfoActoin(TownshipInfoPO townshipInfoPO,
							@RequestParam(value="sortNum")String sortNum) {
		String replace = sortNum.replace(" ", "");
		int sortNumInt = Integer.parseInt(replace);
		Model model = new Model();
		model.set("msg", "true");
		try {
			townshipInfoPO.setSortNum(sortNumInt);
			townshipInfoService.addTownshipInfo(townshipInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * TOWNSHIP_INFO 修改
	 * wangxd 2016.8.26
	 * @param townshipInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateTownshipInfoActoin(TownshipInfoPO townshipInfoPO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			townshipInfoService.updateTownshipInfo(townshipInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
		
	}
	
	/**
	 * 街道（乡）删除前验证
	 * wangxd 2016.8.26
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeDel", method = RequestMethod.GET)
	public Model beforeDelAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			//查询街道（乡）是否含有村
			int opeCount = townshipInfoService.getVillageCountByTownIds(ids.split(","));
			if (opeCount != 0) {
			
				//model.set(Model.SUCCESS, false); 会弹出操作失败的对话框
				
				//页面根据msg的内容，自定义有内容的对话框
				model.set("msg", "hasVillage");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * TOWNSHIP_INFO 删除
	 * wangxd 2016.8.26
	 * @param townshipInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delTownshipInfoAction(@RequestParam("townIds") String townshipInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			townshipInfoService. delTownshipInfo(townshipInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}