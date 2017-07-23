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
package com.threefiveninetong.mchh.appOperation.controller;



import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMbrOperationRecordPO;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMbrOperationRecordService;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Controller
@RequestMapping("/operation")
public class AppOperationController {

	private static final Logger log =Logger.getLogger(AppOperationController.class);
	
	@Resource
	private AppMbrOperationRecordService appMbrOperationRecordService;
	
	/**
	 * 操作日志列表
	 * @return
	 */
	@RequestMapping(value = "/operationList", method = RequestMethod.GET)
	public String operationList() {
		
		return "operation/operationList";
	}
	
	/**
	 * 操作日志列表内容
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/operationList", method = RequestMethod.POST)
	public Model operationList(@RequestParam Map<String, Object> reqs, Page<AppMbrOperationRecordPO> page) {
		
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			appMbrOperationRecordService.getAll(reqs, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		model.setPage(page);
		return model;
	}

}