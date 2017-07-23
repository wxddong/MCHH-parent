/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: DistrictAndCountyInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:34 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.threefiveninetong.mchh.config.po.CityInfoPO;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.MarriageRegistrationDataPO;
import com.threefiveninetong.mchh.config.vo.CityInfoVO;
import com.threefiveninetong.mchh.config.po.ProvinceInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.vo.DistrictAndCountyInfoVO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.ProvinceInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: DistrictAndCountyInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:34 
 */
@Controller
@RequestMapping("/config/districtAndCountyInfo")
public class DistrictAndCountyInfoController {

	private static final Logger log =Logger.getLogger(DistrictAndCountyInfoController.class);
	@Resource
	private  DistrictAndCountyInfoService  districtAndCountyInfoService;
	
	@Resource
	private  ProvinceInfoService  provinceInfoService;
	
	@Resource
	private  TownshipInfoService  townshipInfoService;
	
	@Resource
	private  VillageInfoService  villageInfoService;
	
	//系统添加辖区人数页面
		@RequestMapping(value = "/addxiaquview", method = RequestMethod.GET)
		public ModelAndView addxiaquView(Map<String, Object> reqs) {
			List<DistrictAndCountyInfoPO> findAll= districtAndCountyInfoService.findAll();
			reqs.put("findAll", findAll);
			ModelAndView modelAndView = new ModelAndView(
					
					"config/basedate_xiaqu_list", reqs);
			return modelAndView;
		}
		//辖区人数页面添加
		@RequestMapping(value = "/addview", method = RequestMethod.GET)
		public ModelAndView addActivityView(@RequestParam Map<String, Object> reqs) {
			List<DistrictAndCountyInfoPO> findAll= districtAndCountyInfoService.findAll();
			reqs.put("list", findAll);
			ModelAndView modelAndView = new ModelAndView(
					
					
					"config/basedate_xiaqu_add", reqs);
			return modelAndView;
		}
		
		
	/**
	 * 通过市id获取市下的所有县
	 * @param cityId
	 * @return
	 * @author yanwk
	 */
    @ResponseBody
	@RequestMapping(value="/countyByCityId",method=RequestMethod.GET)
	public Model getDistrictandcountyByCityId(@RequestParam(value="parentId")String cityId){
		
		log.debug("request data:listDistrictandcountyInfo");
		
		Model model = new Model();
		List<DistrictAndCountyInfoPO> list = null;
		
		try {
			DistrictAndCountyInfoPO districtAndCountyInfoPO = new DistrictAndCountyInfoPO();
			DistrictAndCountyInfoVO districtAndCountyInfoVO = new DistrictAndCountyInfoVO();
			BeanUtils.copyProperties(districtAndCountyInfoPO, districtAndCountyInfoVO);
			list = districtAndCountyInfoService.getDistrictandcountyByCityId(cityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		return model;
	}
	
	/**
	 * 获取全部的县以及所有的省用来下拉列表的显示
	 * wangxd 2016.08.24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Model getAllDistrictAndCounty(Map<String,Object> map){
		
		log.debug("request data:listProvinceInfo");
		Model model = new Model();
		List<ProvinceInfoPO> provinceList = provinceInfoService.findAll();
		List<String> list = districtAndCountyInfoService.findAllSortNum();
		model.set("list", list);
		model.set("provinceList", provinceList);
		return model;
	}
	
	

    /**
	 * DISTRICT_AND_COUNTY_INFO 列表视图
	 * wangxd 2016.08.24
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDistrictAndCountyInfoView() {
		log.debug("request page: /config/districtAndCountyInfo_list");
		return "config/districtAndCountyInfo_list";
	}
	/**
	 * DISTRICT_AND_COUNTY_INFO 列表数据
	 * wangxd 2016.08.24
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listDistrictAndCountyInfoActoin(@RequestParam Map<String, Object> reqs, Page<DistrictAndCountyInfoPO> page) {
		log.debug("request data: listDistrictAndCountyInfo");
		Model model = new Model();
		try {
			districtAndCountyInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**辖区添加
	 * 2016.8.25 wangbj
	 * @param districtAndCountyInfoPO
	 * @return
	 */
	@RequestMapping(value = "/addxiaqu", method = RequestMethod.POST)
	public Model addXiaqu(@RequestParam Map<String, Object> reqs,HttpServletRequest request) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			
			String name = (String)reqs.get("name");
			String populationNum = (String)reqs.get("populationNum");
			String statisticnow = (String)reqs.get("statisticnow");
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date datenow =  format.parse(statisticnow);
			String statisticfur = (String)reqs.get("statisticfur");
			Date datefur =  format.parse(statisticfur);
			String isvalid = (String)reqs.get("isvalid");
			DistrictAndCountyInfoPO districtAndCountyInfoPO = new DistrictAndCountyInfoPO();
			districtAndCountyInfoPO.setIsvalid(isvalid);
			districtAndCountyInfoPO.setName(name);
			districtAndCountyInfoPO.setStatisticfur(datefur);
			districtAndCountyInfoPO.setStatisticnow(datenow);
			districtAndCountyInfoPO.setPopulationNum(populationNum);
			districtAndCountyInfoService.addCounty(districtAndCountyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 添加和修改省前 验证是否有重复的县
	 * wangxd
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findByName",method = RequestMethod.GET)
	public Model beforeAddOrUpdate(@RequestParam(value="name") String name){
		Model model = new Model();
		DistrictAndCountyInfoPO countyPO = districtAndCountyInfoService.getByName(name);
		if(countyPO==null){
			model.set("countyPO", null);
		}else{
			model.set("countyPO", countyPO);
		}
		return model;
	}
	
	/**
	 * 2016.8.25 wangxd
	 * @param districtAndCountyInfoPO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addDistrictAndCountyInfoActoin(DistrictAndCountyInfoPO districtAndCountyInfoPO,
												@RequestParam(value="sortNum")String sortNum) {
		String replace = sortNum.replace(" ", "");
		int sortNumInt = Integer.parseInt(replace);
		Model model = new Model();
		model.set("msg", "true");
		try {
			districtAndCountyInfoPO.setSortNum(sortNumInt);
			districtAndCountyInfoService.addCounty(districtAndCountyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
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
			DistrictAndCountyInfoPO find = districtAndCountyInfoService.find(id);
			Date statisticnow = find.getStatisticnow();
			Date statisticfur = find.getStatisticfur();
			   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			   String dateString = formatter.format(statisticnow);
			   String date = formatter.format(statisticfur);
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			   java.util.Date timeDate= dateFormat.parse(dateString);
			   @SuppressWarnings("unused")
			   Date dateTime = new java.sql.Date(timeDate.getTime());
			   java.util.Date time= dateFormat.parse(date);
			   @SuppressWarnings("unused")
			   Date Time = new java.sql.Date(time.getTime());
			   find.setStatisticnow(dateTime);
			   find.setStatisticfur(Time);
			reqs.put("DistrictAndCountyInfoPO", find);
			modelAndView = new ModelAndView(
					"config/basedate_xiaqu_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	/**
	 * DISTRICT_AND_COUNTY_INFO 修改辖区
	 * wangbj
	 * @param marriageRegistrationDataVO
	 * @return
	 */
	
	@RequestMapping(value = "/updateDISTRICT", method = RequestMethod.POST)
	public String updateMarriageRegistrationData(@RequestParam Map<String, Object> reqs) {
		try {
		String id =(String) reqs.get("id");
		String name = (String)reqs.get("name");
		String populationNum = (String)reqs.get("populationNum");
		String statisticnow = (String)reqs.get("statisticnow");
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		Date datenow =  format.parse(statisticnow);
		String statisticfur = (String)reqs.get("statisticfur");
		Date datefur =  format.parse(statisticfur);
		String isvalid = (String)reqs.get("isvalid");
		DistrictAndCountyInfoPO districtAndCountyInfoPO =districtAndCountyInfoService.find(id);
		districtAndCountyInfoPO.setIsvalid(isvalid);
		districtAndCountyInfoPO.setName(name);
		districtAndCountyInfoPO.setStatisticfur(datefur);
		districtAndCountyInfoPO.setStatisticnow(datenow);
		districtAndCountyInfoPO.setPopulationNum(populationNum);
		districtAndCountyInfoPO.setCreatTime(new Date());
		
		districtAndCountyInfoService.update(districtAndCountyInfoPO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/config/districtAndCountyInfo/addxiaquview";
	}

	/**
	 * DISTRICT_AND_COUNTY_INFO 修改
	 * 
	 * @param districtAndCountyInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateDistrictAndCountyInfoActoin(DistrictAndCountyInfoPO districtAndCountyInfoPO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			districtAndCountyInfoService.update(districtAndCountyInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 区（县）删除前验证
	 * wangxd 2016.8.26
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeDel", method = RequestMethod.GET)
	public Model beforeDelAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeCount = districtAndCountyInfoService.getTownCountByCountyIds(ids.split(","));
			if (opeCount != 0) {
			
				//model.set(Model.SUCCESS, false); 会弹出操作失败的对话框
				
				//页面根据msg的内容，自定义有内容的对话框
				model.set("msg", "hasTown");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * DISTRICT_AND_COUNTY_INFO 删除
	 * wangxd 2016.8.26
	 * @param districtAndCountyInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delDistrictAndCountyInfoAction(@RequestParam("countyIds") String districtAndCountyInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			districtAndCountyInfoService.delDistrictAndCountyInfo(districtAndCountyInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	/**
	 * DISTRICT_AND_COUNTY_INFO 删除
	 * wangxd 2016.8.26
	 * @param districtAndCountyInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delxiaqu", method = RequestMethod.POST, produces = "application/json")
	public Model delxiaqu(@RequestParam("ids") String ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			districtAndCountyInfoService.delDistrictAndCountyInfo(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}