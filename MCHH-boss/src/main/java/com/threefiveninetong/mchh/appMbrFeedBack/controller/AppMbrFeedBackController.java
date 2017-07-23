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
package com.threefiveninetong.mchh.appMbrFeedBack.controller;



import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMbrFeedbackPO;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMbrFeedbackService;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;
import com.threefiveninetong.mchh.childCare.po.ChildrenArchivesInfoPO;
import com.threefiveninetong.mchh.childCare.vo.ChildrenArchivesInfoVO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.premarital.po.PremaritalExaInfoPO;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: ArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Controller
@RequestMapping("/feedBack")
public class AppMbrFeedBackController {

	private static final Logger log =Logger.getLogger(AppMbrFeedBackController.class);
	
	@Resource
	private AppMbrFeedbackService appMbrFeedbackService;
	
	/**
	 * 意见反馈列表
	 * @return
	 */
	@RequestMapping(value = "/feedBackList", method = RequestMethod.GET)
	public String feedBackList() {
		
		return "feedBack/feedBackList";
	}
	
	/**
	 * 加载意见反馈列表内容
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/feedBackList", method = RequestMethod.POST)
	public Model feedBackList(@RequestParam Map<String, Object> reqs, Page<AppMbrFeedbackPO> page) {
		
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			appMbrFeedbackService.getAll(reqs, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		model.setPage(page);
		return model;
	}

	/**
	 * 修改意见反馈状态
	 * @param childrenArchivesInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public Model updateStatus(@RequestParam("mbrId") String mbrId) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			appMbrFeedbackService.updateStatus(mbrId);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 处理意见反馈
	 */
	@ResponseBody
	@RequestMapping(value = "/opnFeedBack", method = RequestMethod.POST)
	public ModelAndView opnFeedBack(HttpSession session,
									@RequestParam("opnRemark") String opnRemark,
									@RequestParam("feedId") String feedId){
		ModelAndView mav = new ModelAndView();
		try {
			//根据id查询意见反馈信息
			AppMbrFeedbackPO feedBack = appMbrFeedbackService.findById(feedId);
			//处理人
			OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
			String doctId = operator.getId();
			
			feedBack.setId(feedId);
			feedBack.setOpnName(doctId);//处理人
			feedBack.setStatus("1");//状态更新为已处理
			feedBack.setOpnRemark(opnRemark);//处理内容
			Date now = new Date();
			feedBack.setOpnTime(now);//处理时间
			
			//处理意见反馈
			appMbrFeedbackService.updateFeedBack(feedBack);
			
		} catch (Exception e) {
			e.printStackTrace();
			//model.set("msg", "false");
		}
		mav.setViewName("/feedBack/feedBackList");
		
		return mav;
	}
}