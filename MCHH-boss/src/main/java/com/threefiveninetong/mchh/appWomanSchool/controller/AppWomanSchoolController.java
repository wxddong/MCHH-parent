/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ArchivesInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.archives.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-22 18:21:41 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appWomanSchool.controller;



import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appHospital.po.AppCharacteristicServiceInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppSchoolCurriculumInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppCharacteristicServiceInfoService;
import com.threefiveninetong.mchh.appHospital.service.AppSchoolCurriculumInfoService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Controller
@RequestMapping("/womanSchool")
public class AppWomanSchoolController {

	private static final Logger log =Logger.getLogger(AppWomanSchoolController.class);
	
	@Resource
	private AppSchoolCurriculumInfoService appSchoolCurriculumInfoService;
	
	/**
	 * 孕妇学校列表
	 * @return
	 */
	@RequestMapping(value = "/womanSchoolList", method = RequestMethod.GET)
	public String womanSchoolList() {
		
		return "womanSchool/womanSchoolList";
	}
	
	/**
	 * 孕妇学校列表内容
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/womanSchoolList", method = RequestMethod.POST)
	public Model womanSchoolList(@RequestParam Map<String, Object> reqs, Page<AppSchoolCurriculumInfoPO> page) {
		
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			String txtEnd1 = String.valueOf(reqs.get("txtEnd1"));
			reqs.put("txtEnd1", DateUtil.addDay(txtEnd1, 1));// 将截止日期增加一天，增加查询的精确度
			appSchoolCurriculumInfoService.getAll(reqs, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		model.setPage(page);
		return model;
	}
	
}