package com.threefiveninetong.mchh.maternalhealthcarestatistics.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.maternalhealthcarestatistics.po.MaternalHealthCareStatisticsPO;
import com.threefiveninetong.mchh.maternalhealthcarestatistics.service.MaternalHealthCareStatisticsService;
import com.threefiveninetong.mchh.util.Page;

@Controller
@RequestMapping("/maternalhealthcarestatistics")
public class MaternalHealthCareStatisticsController {

		@Resource
		private MaternalHealthCareStatisticsService maternalHealthCareStatisticsService;
		

		@RequestMapping(value="/list",method=RequestMethod.GET)
		public String toHighRiskMaternalManageView(Map<String,Object> map){
			return "maternalhealthcarestatistics/maternalhealthcarestatistics_list";
		}
		
		@ResponseBody
		@RequestMapping(value="/list",method=RequestMethod.POST)
		public Model HighRiskMaternalManageList(@RequestParam Map<String, Object> reqs, Page<MaternalHealthCareStatisticsPO> page){
			//根据前台传进的是否结案来给sql传入查询条件
			String ifClose = (String) reqs.get("ifClose");
			String statue = (String) reqs.get("statue");
			if("0".equals(ifClose)){
				//已结案
				reqs.put("isClose", 2);
			}else if("1".equals(ifClose)){
				//未结案
				reqs.put("noClose", 2);
				
				if("n".equals(statue)){
					reqs.remove("statue");
					reqs.put("statueAll",2);
				}
				
			}else{
				reqs.remove("ifClose");
			}
			//如果选择已结案，把结案原因带入sql语句
			String closeReason = (String) reqs.get("closeReason");
			if("n".equals(closeReason)){
				reqs.remove("closeReason");
			}
			if("n".equals(statue)){
				reqs.remove("statue");
			}
			
			//根据医疗机构作为查询条件传入sql
			String countyMechanism = (String) reqs.get("countyMechanism");
			String townMechanism =  (String) reqs.get("townMechanism");
			String villageMechanism =  (String) reqs.get("villageMechanism");
			if(villageMechanism!=null && villageMechanism!=""){
				reqs.put("departmentId", villageMechanism);
			}else if(townMechanism!=null && townMechanism!=""){
				reqs.put("departmentId", townMechanism);
			}else if(countyMechanism!=null && countyMechanism!=""){
				reqs.put("departmentId", countyMechanism);
			}
			
			Model model = new Model();
			try {
				maternalHealthCareStatisticsService.listForPage(reqs, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			return model;
		}
} 