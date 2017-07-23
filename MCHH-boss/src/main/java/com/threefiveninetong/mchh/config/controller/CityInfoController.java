/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: CityInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.service.CityInfoService;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.vo.CityInfoVO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: CityInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
@Controller
@RequestMapping("/config/cityInfo")
public class CityInfoController {

	private static final Logger log =Logger.getLogger(CityInfoController.class);
	@Resource
	private  CityInfoService  cityInfoService;
	
	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	
	/**
	 * 获取全部的市区以及所有的省用来下拉列表的显示
	 * wangxd 2016.08.24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Model getAllProvince(Map<String,Object> map){
		
		log.debug("request data:listProvinceInfo");
		Model model = new Model();
		List<ProvinceInfoPO> provinceList = provinceInfoService.findAll();
		List<String> list = cityInfoService.findAllSortNum();
		model.set("list", list);
		model.set("provinceList", provinceList);
		return model;
	}

	/**
	 * 通过省份id获取省份的所有城市
	 * @param provinceId
	 * @return
	 * @author yanwk
	 */
    @ResponseBody
	@RequestMapping(value="/cityByProvinceId",method=RequestMethod.GET)
	public Model getCityByProvinceId(@RequestParam(value="parentId")String provinceId){
		
		log.debug("request data:listCityInfo");
		
		Model model = new Model();
		List<CityInfoPO> list = null;
		
		try {
			CityInfoPO cityInfoPO = new CityInfoPO();
			CityInfoVO cityInfoVO = new CityInfoVO();
			BeanUtils.copyProperties(cityInfoPO, cityInfoVO);
			list = cityInfoService.getCityByProvinceId(provinceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		return model;
	}
	
    /**
	 * CITY_INFO 列表视图
	 * wangxd 2016.8.23
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCityInfoView() {
		log.debug("request page: /config/cityInfo_list");
		return "/config/cityInfo_list";
	}
	/**
	 * CITY_INFO 列表数据
	 * wangxd 2016.8.23
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listCityInfoActoin(@RequestParam Map<String, Object> reqs, Page<CityInfoPO> page) {
		log.debug("request data: listCityInfo");
		Model model = new Model();
		try {
			cityInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * 添加和修改省前 验证是否有重复的市
	 * wangxd
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findByName",method = RequestMethod.GET)
	public Model beforeAddOrUpdate(@RequestParam(value="name") String name){
		Model model = new Model();
		CityInfoPO cityInfoPO = cityInfoService.getByName(name);
		if(cityInfoPO==null){
			model.set("cityInfoPO", null);
		}else{
			model.set("cityInfoPO", cityInfoPO);
		}
		return model;
	}

	/**
	 * CITY_INFO 添加
	 * wangxd 2016.8.24
	 * @param cityInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addCityInfoActoin(CityInfoPO cityInfoPO,
									@RequestParam(value="sortNum")String sortNum) {
		String replace = sortNum.replace(" ", "");
		int sortNumInt = Integer.parseInt(replace);
		Model model = new Model();
		model.set("msg", "true");
		try {
			cityInfoPO.setSortNum(sortNumInt);
			cityInfoService.addCityInfo(cityInfoPO);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * CITY_INFO 修改
	 * wangxd 2016.8.24
	 * @param cityInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateCityInfoActoin(CityInfoPO cityInfoPO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			cityInfoService.update(cityInfoPO);
		} catch (Exception e) {
			System.out.println("出异常了");
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 市（区）删除前验证
	 * wangxd 2016.8.26
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeDel", method = RequestMethod.GET)
	public Model beforeDelAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeCount = cityInfoService.getCountyCountBycityIds(ids.split(","));
			if (opeCount != 0) {
			
				//model.set(Model.SUCCESS, false); 会弹出操作失败的对话框
				
				//页面根据msg的内容，自定义有内容的对话框
				model.set("msg", "hasCounty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}


	/**
	 * CITY_INFO 删除
	 * wangxd 2016.8.26
	 * @param cityInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delCityInfoAction(@RequestParam("cityIds") String cityInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			cityInfoService.delCityInfo(cityInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}