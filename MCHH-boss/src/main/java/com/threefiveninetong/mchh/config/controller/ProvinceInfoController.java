/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ProvinceInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.vo.ProvinceInfoVO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.vo.DepartmentVO;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ProvinceInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Controller
@RequestMapping("/config/provinceInfo")
public class ProvinceInfoController {

	private static final Logger log =Logger.getLogger(ProvinceInfoController.class);
	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	/**
	 * 获取全部的省份
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Model getAllProvince(){
		
		log.debug("request data:listProvinceInfo");
		
		Model model = new Model();
		List<ProvinceInfoPO> list = null;
		try {
			ProvinceInfoPO provinceInfoPO = new ProvinceInfoPO();
			ProvinceInfoVO provinceInfoVO = new ProvinceInfoVO();
			BeanUtils.copyProperties(provinceInfoPO, provinceInfoVO);
			list = provinceInfoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		
		return model;
	}
	
	/**
	 * 获取全部的省份
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/allSortNum", method = RequestMethod.GET)
	public Model getAllProvinceSortNum(){
		
		log.debug("request data:listProvinceInfo");
		
		Model model = new Model();
		List<String> list = null;
		try {
			ProvinceInfoPO provinceInfoPO = new ProvinceInfoPO();
			ProvinceInfoVO provinceInfoVO = new ProvinceInfoVO();
			BeanUtils.copyProperties(provinceInfoPO, provinceInfoVO);
			list = provinceInfoService.findAllSortNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		
		return model;
	}
	

    /**
	 * PROVINCE_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listProvinceInfoView() {
		log.debug("request page: /sysset/provinceInfo/provinceInfo_list");
		return "/config/provinceInfo_list";
	}
	/**
	 * PROVINCE_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listProvinceInfoActoin(@RequestParam Map<String, Object> reqs, Page<ProvinceInfoPO> page) {
		log.debug("request data: listProvinceInfo");
		Model model = new Model();
		try {
			provinceInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * 添加和修改省前 验证是否有重复的省
	 * wangxd
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findByName",method = RequestMethod.GET)
	public Model beforeAddOrUpdate(@RequestParam(value="name") String name){
		Model model = new Model();
		ProvinceInfoPO provinceInfoPO = provinceInfoService.getByName(name);
		if(provinceInfoPO==null){
			model.set("provinceInfoPO", null);
		}else{
			model.set("provinceInfoPO", provinceInfoPO);
		}
		return model;
	}

	/**
	 * PROVINCE_INFO 添加
	 * wangxd 2016.8.23
	 * @param provinceInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addProvinceInfoActoin(ProvinceInfoVO provinceInfoVO,
										@RequestParam(value="sortNum")String sortNum) {
		String replace = sortNum.replace(" ", "");
		int sortNumInt = Integer.parseInt(replace);
		Model model = new Model();
		model.set("msg", "true");
		try {
			ProvinceInfoPO provinceInfoPO = new ProvinceInfoPO();
			BeanUtils.copyProperties(provinceInfoPO, provinceInfoVO);
			provinceInfoPO.setSortNum(sortNumInt);
			model.setRow(provinceInfoService.addProvinceInfo(provinceInfoPO));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * PROVINCE_INFO 修改
	 * wangxd 2016.8.23
	 * @param provinceInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateProvinceInfoActoin(ProvinceInfoVO provinceInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			ProvinceInfoPO provinceInfoPO = new ProvinceInfoPO();
			BeanUtils.copyProperties(provinceInfoPO, provinceInfoVO);
			provinceInfoService.update(provinceInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 省（直辖市）删除前验证
	 * wangxd 2016.8.26
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeDel", method = RequestMethod.GET)
	public Model beforeDelAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeCount = provinceInfoService.getCityCountByProvinceIds(ids.split(","));
			if (opeCount != 0) {
			
				//model.set(Model.SUCCESS, false); 会弹出操作失败的对话框
				
				//页面根据msg的内容，自定义有内容的对话框
				model.set("msg", "hasCity");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}


	/**
	 * PROVINCE_INFO 删除
	 * wangxd 2016.8.26
	 * @param provinceInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delProvinceInfoAction(@RequestParam("provinceIds") String provinceInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			provinceInfoService.delProvinceInfo(provinceInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}