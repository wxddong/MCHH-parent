/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PopulationDataController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.PopulationDataPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.vo.PopulationDataVO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.PopulationDataService;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: PopulationDataController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
@Controller
@RequestMapping("/populationdata")
public class PopulationDataController {

	private static final Logger log =Logger.getLogger(PopulationDataController.class);
	@Resource
	private  PopulationDataService  populationDataService;
	
	@Resource
	private  DistrictAndCountyInfoService  districtAndCountyInfoService;
	
	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	@Resource
	private  TownshipInfoService  townshipInfoService;
	
	@Resource
	private  VillageInfoService  villageInfoService;

    /**
	 * POPULATION_DATA 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPopulationDataView() {
		log.debug("request page: /sysset/populationData/populationData_list");
		return "sysset/populationData/populationData_list";
	}
	
	//系统添加辖区人数页面
	@RequestMapping(value = "/addxiaquview", method = RequestMethod.GET)
	public ModelAndView addxiaquView(Map<String, Object> reqs) {
		List<DistrictAndCountyInfoPO> findAll= districtAndCountyInfoService.findAll();
		reqs.put("findAll", findAll);
		ModelAndView modelAndView = new ModelAndView(
				
				"config/basedate_xiaqu_list", reqs);
		return modelAndView;
	}
	/**
	 * POPULATION_DATA 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listPopulationDataActoin(@RequestParam Map<String, Object> reqs, Page<PopulationDataPO> page) {
		log.debug("request data: listPopulationData");
		Model model = new Model();
		try {
			populationDataService.DistictlistForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	/**
	 * POPULATION_DATA 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/Distictlist", method = RequestMethod.POST)
	public Model listPopulationData(@RequestParam Map<String, Object> reqs, Page<PopulationDataPO> page) {
		log.debug("request data: listPopulationData");
		Model model = new Model();
		try {
			populationDataService.DistictlistForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
			
			
	/**
	 * POPULATION_DATA 添加
	 * 
	 * @param populationDataVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addPopulationDataActoin(PopulationDataVO populationDataVO) {
		ModelAndView model = new ModelAndView("redirect:/populationdata/addxiaquview");
		try {
			String id= IdUtil.uuid();
			populationDataVO.setId(id);
			//获取县区的id
			String countyId = populationDataVO.getCountyId();
			if(countyId !=null && countyId!=""){
			//查询县区的名字
			DistrictAndCountyInfoPO district = districtAndCountyInfoService.find(countyId);
			String disName = district.getName();
			}
			//获取乡的id
			String towId = populationDataVO.getTowId();
			
			//查询乡的名字
			if(towId !=null && towId !=""){
			TownshipInfoPO town = townshipInfoService.find(towId);
			String townName = town.getName();
			}
			//查询村的id
			String villageId = populationDataVO.getVillageId();
			
			//查询村的名字
			if(villageId !=null && villageId!=""){
			VillageInfoPO village = villageInfoService.find(villageId);
			String villageName = village.getName();
				
			}
			
			
			PopulationDataPO populationDataPO = new PopulationDataPO();
			BeanUtils.copyProperties(populationDataPO, populationDataVO);
			populationDataService.create(populationDataPO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "redirect: /populationdata/addxiaquview";
		return model;
	}
	
	
	/**
	 * MARRIAGE_REGISTRATION_DATA 修改辖区页面
	 * 
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			//查询人口数
			 PopulationDataPO find = populationDataService.find(id);
			 
			 //查询所以的县
			 List<DistrictAndCountyInfoPO> district = districtAndCountyInfoService.findAll();
			 
			 
			 
			if(find !=null ){
			
			Date statisticnow = find.getStatisticalDate();
			Date statisticfur = find.getStatisticalDateEnd();
			   
			   if(statisticnow !=null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			   String dateString = formatter.format(statisticnow);
			   java.util.Date timeDate= dateFormat.parse(dateString);
			   @SuppressWarnings("unused")
			   Date dateTime = new java.sql.Date(timeDate.getTime());
			   find.setStatisticalDate(dateTime);
			   }
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			   if(statisticfur !=null){
			   String date = formatter.format(statisticfur);
			   java.util.Date time= dateFormat.parse(date);
			   @SuppressWarnings("unused")
			   Date Time = new java.sql.Date(time.getTime());
			   find.setStatisticalDateEnd(Time);
			   }
			   //拆分地区名字
			   String countyId = find.getCountyId();
			   String[] split = countyId.split(",");
			   if(split !=null){
			   if(split.length==1){
				   DistrictAndCountyInfoPO findByName = districtAndCountyInfoService.findByName(split[0]);
				   String DistricId = findByName.getId();
				   reqs.put("country", split[0]);
				   reqs.put("DistricId", DistricId);
			   }
			   if(split.length==2){
				   DistrictAndCountyInfoPO findByName = districtAndCountyInfoService.findByName(split[0]);
				   String DistricId = findByName.getId();
				   TownshipInfoPO town = townshipInfoService.findByName(split[1]);
				   String townId = town.getId();
				   reqs.put("country", split[0]);
				   reqs.put("DistricId", DistricId);
				   reqs.put("tow", split[1]);
				   reqs.put("townId", townId);
			   }
			   if(split.length==3){
				   DistrictAndCountyInfoPO findByName = districtAndCountyInfoService.findByName(split[0]);
				   String DistricId = findByName.getId();
				   TownshipInfoPO town = townshipInfoService.findByName(split[1]);
				   String townId = town.getId();
				   VillageInfoPO village = villageInfoService.findByName(split[2]);
				   String villageId = village.getId();
				   reqs.put("country", split[0]);
				   reqs.put("DistricId", DistricId);
				   reqs.put("tow", split[1]);
				   reqs.put("townId", townId);
				   reqs.put("vill", split[2]);
				   reqs.put("villageId", villageId);
				   
				   
			   }
			   }
			   
			   
			   
			reqs.put("district", district);
			reqs.put("find", find);
			
			}
			modelAndView = new ModelAndView(
					"config/basedate_xiaqu_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}


	/**
	 * POPULATION_DATA 修改
	 * 
	 * @param populationDataVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePopulationDataActoin(PopulationDataVO populationDataVO) {
		ModelAndView model = new ModelAndView("redirect:/populationdata/addxiaquview");
		try {
			PopulationDataPO populationDataPO = new PopulationDataPO();
			BeanUtils.copyProperties(populationDataPO, populationDataVO);
			populationDataService.update(populationDataPO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	
	/**
	 * 获取全县下面全部的乡用来下拉列表的显示
	 * wangbj 2016.08.24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectTOW", method = RequestMethod.GET)
	public Model getAllTow(@RequestParam Map<String,Object> map){
		
		log.debug("request data:listProvinceInfo");
		String countyId = (String)map.get("countyId");
		Model model = new Model();
		List<TownshipInfoPO> findAllByCountyId = townshipInfoService.findAllByCountyId(countyId);
		model.setList(findAllByCountyId);
		return model;
	}
	
	/**
	 * 获取全乡下面全部的村用来下拉列表的显示
	 * wangbj 2016.08.24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectVillage", method = RequestMethod.GET)
	public Model getAllVillage(@ RequestParam Map<String,Object> map){
		
		log.debug("request data:listProvinceInfo");
		String towId=(String)map.get("towId");
		Model model = new Model();
		List<VillageInfoPO> findAllByVillage = villageInfoService.findAllByVillage(towId);
		model.setList(findAllByVillage);
		return model;
	}
	

	/**
	 * POPULATION_DATA 删除
	 * 
	 * @param populationDataIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delPopulationDataAction(@RequestParam("populationDataIds") String populationDataIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			populationDataService.deletes(populationDataIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * POPULATION_DATA 删除
	 * 
	 * @param populationDataIds
	 * @return
	 * wangbj
	 */
	@ResponseBody
	@RequestMapping(value = "/delPopulation", method = RequestMethod.POST, produces = "application/json")
	public Model delPopulationData(@RequestParam("ids") String ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			populationDataService.deletes(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}