package com.threefiveninetong.mchh.achievements.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.achievements.po.BasicPublicHealthFeedbackStatisticsPO;
import com.threefiveninetong.mchh.achievements.po.CountyAchievementsPO;
import com.threefiveninetong.mchh.achievements.po.DoctorAchievementsPO;
import com.threefiveninetong.mchh.achievements.service.AchievementsService;
import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.config.po.TownshipInfoPO;
import com.threefiveninetong.mchh.config.po.VillageInfoPO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.TownshipInfoService;
import com.threefiveninetong.mchh.config.service.VillageInfoService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.util.Page;

@Controller
@RequestMapping(value="/achievements")
public class AchievementsController {
	
	@Resource
	private AchievementsService achievementsService;
	@Resource
	private  DistrictAndCountyInfoService  districtAndCountyInfoService;
	@Resource
	private  TownshipInfoService  townshipInfoService;
	@Resource
	private  VillageInfoService  villageInfoService;
	
	/**
	 * 基本公共卫生服务妇幼项目督导反馈统计表 列表页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/basicPublicHealthList",method=RequestMethod.GET)
	public String basicPublicFealthFeedbackStatisticsView(Map<String,Object> map){
		return "achievements/basicpublichealthfeedbackstatistics_list";
	}
	
	/**
	 * 基本公共卫生服务妇幼项目督导反馈统计表 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/basicPublicHealthList",method=RequestMethod.POST)
	public Model basicPublicFealthFeedbackStatisticsAction(@RequestParam Map<String, Object> reqs, Page<BasicPublicHealthFeedbackStatisticsPO> page){
		
		Model model = new Model();
		try {
			achievementsService.basicPublicHealthListForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	/**
	 * 前往医生统计的列表
	 * wangxd 2016.9.22
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/doctorList",method=RequestMethod.GET)
	public String toDoctorAchievementsView(Map<String,Object> map){
		return "achievements/doctorachievements_list";
	}
	
	/**
	 * 医生绩效统计带条件的分页查询
	 * wangxd 2016.9.22
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/doctorList",method=RequestMethod.POST)
	public Model DoctorAchievementsList(@RequestParam Map<String, Object> reqs, Page<DoctorAchievementsPO> page){
		
		//根据医疗机构作为查询条件传入sql
		String countyMechanism = (String) reqs.get("countyMechanism");
		String townMechanism =  (String) reqs.get("townMechanism");
		String villageMechanism =  (String) reqs.get("villageMechanism");
		if(villageMechanism!=null && villageMechanism!=""){
			String home = "AND a.HOME_VILLAGE_ID='"+villageMechanism+"'";
			reqs.put("home", home);
		}else if(townMechanism!=null && townMechanism!=""){
			String home = "AND a.HOME_TOWNSHIP_ID='"+townMechanism+"'";
			reqs.put("home", home);
		}else if(countyMechanism!=null && countyMechanism!=""){
			String home = "AND a.HOME_COUNTY_ID='"+countyMechanism+"'";
			reqs.put("home", home);
		}
		
		Model model = new Model();
		try {
			achievementsService.doctorListForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * 前往县级绩效统计统计的列表
	 * wangxd 2016.9.22
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/countyList",method=RequestMethod.GET)
	public String toCountyAchievementsView(Map<String,Object> map){
		return "achievements/countyachievements_list";
	}
	
	/**
	 * 县级绩效统计带条件的分页查询
	 * wangxd 2016.9.22
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/countyList",method=RequestMethod.POST)
	public Model CountyAchievementsList(@RequestParam Map<String, Object> reqs, Page<CountyAchievementsPO> page){
		

		//根据医疗机构作为查询条件传入sql
		String countyMechanism = (String) reqs.get("countyMechanism");
		String townMechanism =  (String) reqs.get("townMechanism");
		String villageMechanism =  (String) reqs.get("villageMechanism");
		if(villageMechanism!=null && villageMechanism!=""){
			String home = "AND a.HOME_VILLAGE_ID='"+villageMechanism+"'";
			reqs.put("home", home);
		}else if(townMechanism!=null && townMechanism!=""){
			String home = "AND a.HOME_TOWNSHIP_ID='"+townMechanism+"'";
			reqs.put("home", home);
		}else if(countyMechanism!=null && countyMechanism!=""){
			String home = "AND a.HOME_COUNTY_ID='"+countyMechanism+"'";
			reqs.put("home", home);
		}
		
		
		Model model = new Model();
		try {
			achievementsService.countyListForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/county", method = RequestMethod.GET)
	public Model getCounties(){
		
		Model model = new Model();
		List<DistrictAndCountyInfoPO> list = null;
		try {
			 list = districtAndCountyInfoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/town", method = RequestMethod.GET)
	public Model getTowns(@RequestParam(value="parentId")String parentId){
		
		Model model = new Model();
		List<TownshipInfoPO> list = null;
		try {
			 list = townshipInfoService.findAlls(parentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/village", method = RequestMethod.GET)
	public Model getVillages(@RequestParam(value="parentId")String parentId){
		
		Model model = new Model();
		List<VillageInfoPO> list = null;
		try {
			 list = villageInfoService.findAlls(parentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setList(list);
		
		return model;
	}
	
	
}
