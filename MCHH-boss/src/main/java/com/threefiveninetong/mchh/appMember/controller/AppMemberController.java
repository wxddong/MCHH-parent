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
package com.threefiveninetong.mchh.appMember.controller;



import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.util.CryptUtil;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.Encoding;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.SystemException;

/**
 * @ClassName: ArchivesInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-22 18:21:41 
 */
@Controller
@RequestMapping("/member")
public class AppMemberController {

	private static final Logger log =Logger.getLogger(AppMemberController.class);
	
	@Resource
	private AppMemberService appMemberService;
	
	@Resource
	AppAffiliatedHospitalInfoService appAffiliatedHospitalInfoService;
	
	/**
	 * 会员信息列表
	 * @return
	 */
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList() {
		
		return "member/memberList";
	}
	
	/**
	 * 加载会员信息列表内容
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/memberList", method = RequestMethod.POST)
	public Model memberList(@RequestParam Map<String, Object> reqs, Page<AppMemberPO> page) {
		
		Model model = new Model();
		try {
			String txtEnd = String.valueOf(reqs.get("txtEnd"));
			reqs.put("txtEnd", DateUtil.addDay(txtEnd, 1));// 将截止日期增加一天，增加查询的精确度
			appMemberService.getAll(reqs, page);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		model.setPage(page);
		return model;
	}
	
	/**
	 * 修改会员状态
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public Model updateStatus(@RequestParam("mbId") String mbId) {
		
		Model model = new Model();
		try {
			//根据会员id获取会员信息
			AppMemberPO appMember = appMemberService.find(mbId);
			appMember.setId(mbId);
			Date now = new Date();
			appMember.setUpdateTime(now);
			if (appMember != null) {
				//会员状态
				String status = appMember.getStatus();
				if ("0".equals(status)) {
					appMember.setStatus("1");
				}
				if ("1".equals(status)) {
					appMember.setStatus("0");
				}
				appMemberService.updateStatus(appMember);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}

	/**
	 * 重置密码为123456
	 * @param mbId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	public Model resetPwd(@RequestParam("mbId") String mbId) {
		
		Model model = new Model();
		try {
			//根据会员id获取会员信息
			AppMemberPO appMember = appMemberService.find(mbId);
			if (appMember != null) {
				appMember.setId(mbId);
				//修改时间
				Date now = new Date();
				appMember.setUpdateTime(now);
				String newPwd = "123456";
				try{
					appMember.setPwd(CryptUtil.MD5.encrypt(newPwd, Encoding.UTF_8));
				}catch(Exception e){
					log.error("会员修改密码加密时异常", e);
					throw new SystemException("-1000", null,"会员修改密码加密时抛异常!",e);
				}
				appMemberService.update(appMember);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}

	/**
	 * 停用前验证
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeChange", method = RequestMethod.GET)
	public Model beforeChange(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeMember = appMemberService.getAppMemberBymemberIds(ids.split(","));
			if (opeMember != 0) {
				model.set("msg", "hasCounty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	
	/**
	 * 停用
	 * @param cityInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST, produces = "application/json")
	public Model change(@RequestParam("memberIds") String memberIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			appMemberService.changeStatus(memberIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
}