/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: HighRiskPregnancyScoreController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.config.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:36 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;
import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.service.DirectiveOpinionTemplateService;
import com.threefiveninetong.mchh.config.service.HighRiskPregnancyScoreService;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;
import com.threefiveninetong.mchh.config.vo.HighRiskPregnancyScoreVO;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.prenatal.po.HighRiskInfoPO;
import com.threefiveninetong.mchh.prenatal.po.HighRiskTermPO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.prenatal.service.HighRiskInfoService;
import com.threefiveninetong.mchh.prenatal.service.HighRiskTermService;
import com.threefiveninetong.mchh.prenatal.service.PrenatalExaInfoService;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * @ClassName: HighRiskPregnancyScoreController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:36 
 */
@Controller
@RequestMapping("/com/config/highrisk")
public class HighRiskPregnancyScoreController {

	private static final Logger log =Logger.getLogger(HighRiskPregnancyScoreController.class);
	@Resource
	private  HighRiskPregnancyScoreService  highRiskPregnancyScoreService;
	
	

	@Resource
	private BirthArchivesInfoService birthArchivesInfoService;
	
	@Resource
	private PrenatalExaInfoService prenatalExaInfoService;
	
	@Resource
	private HighRiskInfoService highRiskInfoService;
	
	@Resource
	private HighRiskTermService highRiskTermService;
	
	@Resource
	private DirectiveOpinionTemplateService directiveOpinionTemplateService;
	/**
	 * 第一次产检编辑页面专案管理
	 * @param session
	 * @return 
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/firstEditRedioHighRisk",method=RequestMethod.GET)
	public Model firstEditRedioHighRisk(@RequestParam("prenatalId")String prenatalId,HttpSession session){
		Model model = new Model();
		log.debug("firstEditRedioHighRisk(第一次产检编辑页面专案管理点击)....");
		//获取本次的产检信息
		PrenatalExaInfoPO thisPrenatal = prenatalExaInfoService.find(prenatalId);
		//获取 上次产检的高危项
		String thisEvaluate = "";
		if(thisPrenatal != null){
			
			thisEvaluate = thisPrenatal.getEvaluate();
		}
		List<HighRiskTermPO> thisTerms = new ArrayList<>();
		if("1".endsWith(thisEvaluate)){
			HighRiskInfoPO thisHighRisk = highRiskInfoService.getHighRiskByPrenatalId(prenatalId);
			if(thisHighRisk!= null){
				
				thisTerms = highRiskTermService.getThisHighRiskTermByHighRiskId(thisHighRisk.getId());
			}
//			String directiveStr = "";
//			if(thisTerms.size() > 0){
//				for (HighRiskTermPO highRiskTermPO : thisTerms) {
//					DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
//					directiveOpinionTemplatePO.setModularType("4");
//					directiveOpinionTemplatePO.setTgd(highRiskTermPO.getTermId());
//					directiveOpinionTemplatePO.setUseSign("1");
//					DirectiveOpinionTemplatePO directive = directiveOpinionTemplateService.getHighRiskGude(directiveOpinionTemplatePO);
//					if(directive != null){
//						
//						directiveStr += " "+directive.getContent()+"\n";
//					}
//				}
//			}
//			model.set("directiveStr", directiveStr);
		}
		model.set("thisTerms", thisTerms);
		
		String evaluateRemark = (String) session.getAttribute("evaluateRemark");
		if(evaluateRemark != null && evaluateRemark != ""){
			String[] split = evaluateRemark.split(",");
			List<HighRiskPregnancyScorePO> list = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(split[i]);
				list.add(highRiskPregnancyScorePO);
			}
			model.set("list", list);
		}
		log.debug("firstEditRedioHighRisk(第一次产检编辑页面专案管理点击结束)....");
		return model;
	}
	
	/**
	 * 2-N次产前检查编辑专案管理前台拼串
	 * @param prenatalId
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/2ToNEditRedioHighRisk",method=RequestMethod.GET)
	public Model editRedioHighRisk2ToN(@RequestParam("prenatalId")String prenatalId,HttpSession session){
		Model model = new Model();
		
		//获取本次的产检信息
		PrenatalExaInfoPO thisPrenatal = prenatalExaInfoService.find(prenatalId);
		//获取上次的产检信息
		PrenatalExaInfoPO newestPrenatal = prenatalExaInfoService.getNewestPrenatal(thisPrenatal.getBirthArchivesId());
		//获取 上次产检的高危项
		//String lastEvaluateRemark = newestPrenatal.getEvaluateRemark();
		//String thisEvaluateRemark = thisPrenatal.getEvaluateRemark();
		
		
		HighRiskInfoPO thisHighRisk = highRiskInfoService.getHighRiskByPrenatalId(prenatalId);
		if(thisHighRisk != null){
			List<HighRiskTermPO> thisTerms = highRiskTermService.getThisHighRiskTermByHighRiskId(thisHighRisk.getId());
			model.set("thisTerms", thisTerms);
		}
		
		String evaluateRemark = (String) session.getAttribute("evaluateRemark");
		//if(lastEvaluateRemark != null && lastEvaluateRemark != ""){
			//evaluateRemark = evaluateRemark+","+lastEvaluateRemark;
			//获取和产检对应的高危专案表
		HighRiskInfoPO highRiskInfoPO = null;
		if(newestPrenatal != null){
			highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(newestPrenatal.getId());
		}
		//通过高危专案id获取所对应的所有高危项
		if(highRiskInfoPO!=null){
			
			List<HighRiskTermPO> terms = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
			//String directiveStr = "";
			if(terms.size()>0){
				model.set("terms", terms);
//				if(thisTerms.size() > 0){
				/*for (HighRiskTermPO highRiskTermPO : terms) {
					DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
					directiveOpinionTemplatePO.setModularType("4");
					directiveOpinionTemplatePO.setTgd(highRiskTermPO.getTermId());
					directiveOpinionTemplatePO.setUseSign("1");
					DirectiveOpinionTemplatePO directive = directiveOpinionTemplateService.getHighRiskGude(directiveOpinionTemplatePO);
					if(directive != null){
						
						directiveStr += " "+directive.getContent()+"\n";
					}
				}
			}
			model.set("directiveStr", directiveStr);*/
			}	
			}
		
		if(evaluateRemark != null && evaluateRemark != ""){
			String[] split = evaluateRemark.split(",");
			List<HighRiskPregnancyScorePO> list = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(split[i]);
				list.add(highRiskPregnancyScorePO);
			}
			model.set("list", list);
		}
		
		return model;
	}
	/**
	 * 2-N次产前检查专案管理前台拼串
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/2ToNCheckRedioHighRisk",method=RequestMethod.GET)
	public Model checkRedioHighRisk2ToN(@RequestParam("birthArchivesId")String birthArchivesId,HttpSession session,@RequestParam("go")String go){
		Model model = new Model();
		
		//获取最新的产检信息
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthArchivesId);
		//获取上一次产检的高危项
		String evaluate = "";
		if(prenatalExaInfoPO != null){
			evaluate = prenatalExaInfoPO.getEvaluate();
		}
		String evaluateRemark = "";
		if("1".equals(go)){
			evaluateRemark = (String) session.getAttribute("evaluateRemark");
		}
		String directiveStr = "";
		if("1".equals(evaluate)){
			
			//evaluateRemark = evaluateRemark+","+lastEvaluateRemark;
			//获取和产检对应的高危专案表
			HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
			//通过高危专案id获取所对应的所有高危项
			List<HighRiskTermPO> terms = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
			
			if(terms.size()>0){
				model.set("terms", terms);
				if("0".equals(go)){
					for (HighRiskTermPO highRiskTermPO : terms) {
						DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
						directiveOpinionTemplatePO.setModularType("4");
						directiveOpinionTemplatePO.setTgd(highRiskTermPO.getTermId());
						directiveOpinionTemplatePO.setUseSign("1");
						DirectiveOpinionTemplatePO directive = directiveOpinionTemplateService.getHighRiskGude(directiveOpinionTemplatePO);
						if(directive != null){
							
							directiveStr += " "+directive.getContent()+"\n";
						}
					}
				}
			
			}
			
		}
		if(evaluateRemark != null  && evaluateRemark != ""){
			String[] split = evaluateRemark.split(",");
			List<HighRiskPregnancyScorePO> list = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(split[i]);
				list.add(highRiskPregnancyScorePO);
			}
			if("1".equals(go)){
				for (HighRiskPregnancyScorePO highRiskTermPO : list) {
					DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
					directiveOpinionTemplatePO.setModularType("4");
					directiveOpinionTemplatePO.setTgd(highRiskTermPO.getId());
					directiveOpinionTemplatePO.setUseSign("1");
					DirectiveOpinionTemplatePO directive = directiveOpinionTemplateService.getHighRiskGude(directiveOpinionTemplatePO);
					if(directive != null){
						
						directiveStr += " "+directive.getContent()+"\n";
					}
				}
			}
			model.set("list", list);
		}
		model.set("directiveStr", directiveStr);
		return model;
	}
	
	/**
	 * 专案管理前台拼串
	 * @param session
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/checkRedioHighRisk",method=RequestMethod.GET)
	public Model checkRedioHighRisk(HttpSession session){
		Model model = new Model();
		
		String evaluateRemark = (String) session.getAttribute("evaluateRemark");
		List<HighRiskPregnancyScorePO> list = new ArrayList<>();
		if(evaluateRemark != null){
			
			String[] split = evaluateRemark.split(",");
			for (int i = 0; i < split.length; i++) {
				HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(split[i]);
				list.add(highRiskPregnancyScorePO);
			}
		}
		model.set("list", list);
		return model;
	}
	
	/**
     * 通过前台高危弹出框选择复选框返回选择的选项并在异常选项后显示所选
     * @param s
     * @return
     */
	@ResponseBody
	@RequestMapping(value="/addHighriskToJsp",method=RequestMethod.POST)
	public Model addHighriskToJsp(@RequestParam("s")String s,HttpSession session){
		Model model = new Model();
		session.setAttribute("evaluateRemark", s);
		String[] ss = s.split(",");
		
		String str = "";
		String directiveStr = "";
		for (int i = 0; i < ss.length; i++) {
			HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(ss[i]);
			String score = highRiskPregnancyScorePO.getScore();
			if(("5").equals(score)){
				str += highRiskPregnancyScorePO.getName() +":5分 ;";
			}
			if(("10").equals(score)){
				str += highRiskPregnancyScorePO.getName() +":10分;";
			}
			if(("20").equals(score)){
				str += highRiskPregnancyScorePO.getName() +":20分;";
			}
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = new DirectiveOpinionTemplatePO();
			directiveOpinionTemplatePO.setModularType("4");
			directiveOpinionTemplatePO.setTgd(highRiskPregnancyScorePO.getId());
			directiveOpinionTemplatePO.setUseSign("1");
			DirectiveOpinionTemplatePO directive = directiveOpinionTemplateService.getHighRiskGude(directiveOpinionTemplatePO);
			if(directive != null){
				
				directiveStr += " "+directive.getContent()+"\n";
			}
		}
		model.set("directiveStr", directiveStr);
		model.set("str", str);
		
		return model;
	}
	/**
	 * 获取所有高危项并返回给前台页面
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/allEditHighrisk",method=RequestMethod.GET)
	public Model getAllEditHighrisk(@RequestParam("prenatalId")String prenatalId){
		
		Model model = new Model();
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.find(prenatalId);
		//获取本次的产检信息
		PrenatalExaInfoPO thisPrenatal = prenatalExaInfoService.find(prenatalId);
		//获取上次的产检信息
		PrenatalExaInfoPO newestPrenatal = prenatalExaInfoService.getNewestPrenatal(thisPrenatal.getBirthArchivesId());
		//获取 上次产检的高危项
		//String lastEvaluateRemark = newestPrenatal.getEvaluateRemark();
		//String thisEvaluateRemark = thisPrenatal.getEvaluateRemark();
		HighRiskInfoPO thisHighRisk = highRiskInfoService.getHighRiskByPrenatalId(prenatalId);
		
		//String evaluateRemark = prenatalExaInfoPO.getEvaluateRemark();
		List<HighRiskPregnancyScorePO> lastEval = new ArrayList<>();
		if(thisHighRisk != null){
			
			List<HighRiskTermPO> list = highRiskTermService.getThisHighRiskTermByHighRiskId(thisHighRisk.getId());
			for (HighRiskTermPO highRiskTermPO : list) {
				HighRiskPregnancyScorePO find = highRiskPregnancyScoreService.find(highRiskTermPO.getTermId());
				lastEval.add(find);
			}
		}
		/*if(evaluateRemark != null && evaluateRemark != ""){
			String[] split = evaluateRemark.split(",");
			for (int i = 0; i < split.length; i++) {
				HighRiskPregnancyScorePO find = highRiskPregnancyScoreService.find(split[i]);
				lastEval.add(find);
			}
		}*/
		List<HighRiskPregnancyScorePO> list = highRiskPregnancyScoreService.selectAll();
		if(lastEval.size() > 0){
			for (HighRiskPregnancyScorePO highRiskPregnancyScorePO : list) {
				for (HighRiskPregnancyScorePO highRisk : lastEval) {
					if(highRisk.getId().equals(highRiskPregnancyScorePO.getId())){
						highRiskPregnancyScorePO.setSelected("1");
					}
				}
			}
		}
		model.set("lastEval", lastEval);
		model.set("list", list);
		return model;
	}
	
	/**
	 * 获取所有高危项并返回给前台页面
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/allSecondHighrisk",method=RequestMethod.GET)
	public Model getAllSecondHighrisk(@RequestParam("birthArchivesId")String birthArchivesId){
		
		Model model = new Model();
		List<HighRiskPregnancyScorePO> list = highRiskPregnancyScoreService.selectAll();
		//获取最新的产检信息
		PrenatalExaInfoPO prenatalExaInfoPO = prenatalExaInfoService.getNewestPrenatal(birthArchivesId);
		List<HighRiskTermPO> lastEval = new ArrayList<>();
		List<HighRiskPregnancyScorePO> thisHigh = new ArrayList<>();
		//String evaluate = prenatalExaInfoPO.getEvaluate();
		if(prenatalExaInfoPO != null){
			HighRiskInfoPO highRiskInfoPO = highRiskInfoService.getHighRiskByPrenatalId(prenatalExaInfoPO.getId());
			if(highRiskInfoPO != null){
				//获取上次产检所有未矫正的信息
				 lastEval = highRiskTermService.getAllTermByhighRiskId(highRiskInfoPO.getId());
				if(lastEval.size()>0){
					for (HighRiskPregnancyScorePO highRiskPregnancyScorePO : list) {
						for (HighRiskTermPO highRisk : lastEval) {
							if(highRisk.getTermId().equals(highRiskPregnancyScorePO.getId())){
								highRiskPregnancyScorePO.setSelected("1");
							}
						}
					}
				}
			}
		}
		
		//model.set("lastEval", lastEval);
		model.set("list", list);
		return model;
	}
	
	/**
	 * 获取所有高危项并返回给前台页面
	 * @return
	 * @author yanwk
	 */
	@ResponseBody
	@RequestMapping(value="/allHighrisk",method=RequestMethod.GET)
	public Model getAllHighrisk(){
		
		Model model = new Model();
		
		List<HighRiskPregnancyScorePO> list = highRiskPregnancyScoreService.selectAll();
		
		model.set("list", list);
		return model;
	}
	
	
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 列表视图
	 * @return
	 * @author yanwk
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHighRiskPregnancyScoreView() {
		log.debug("request page: /sysset/highRiskPregnancyScore/highRiskPregnancyScore_list");
		return "sysset/highRiskPregnancyScore/highRiskPregnancyScore_list";
	}
	
	
	//系统添加高危列表页面
			@RequestMapping(value = "/addhighrisk", method = RequestMethod.GET)
			public ModelAndView addhighrisk(Map<String, Object> reqs) {
				List<HighRiskPregnancyScorePO> findAll = highRiskPregnancyScoreService.findAll();
				
				reqs.put("findAll", findAll);
				
				ModelAndView modelAndView = new ModelAndView(
						
						"config/highrisk_list", reqs);
				return modelAndView;
			}
			
			
			//系统添加高危列表页面
			@RequestMapping(value = "/addhighriskBaby", method = RequestMethod.GET)
			public ModelAndView addhighriskBaby(Map<String, Object> reqs) {
				List<HighRiskPregnancyScorePO> findAll = highRiskPregnancyScoreService.findAll();
				
				reqs.put("findAll", findAll);
				
				ModelAndView modelAndView = new ModelAndView(
						
						"config/highriskBaby_list", reqs);
				return modelAndView;
			}
			
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listHighRiskPregnancyScoreActoin(@RequestParam Map<String, Object> reqs, Page<HighRiskPregnancyScorePO> page) {
		log.debug("request data: listHighRiskPregnancyScore");
		Model model = new Model();
		try {
			highRiskPregnancyScoreService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	
	
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 列表数据
	 * @param reqs
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByname", method = RequestMethod.GET)
	public Model getHighRiskPregnancyScorByname(@RequestParam Map<String, Object> reqs) {
		log.debug("request data: listPremaritalAbnormalOption");
		Model model = new Model();
		try {
			String name =(String) reqs.get("name");
			String id =(String) reqs.get("id");
			if(id!=null &&id!=""){
				HighRiskPregnancyScorePO find = highRiskPregnancyScoreService.find(id);
				String name2 = find.getName();
				if(name.equals(name2)){
					model.set("HighRiskPregnancyScorePO", null);
				}
				if(!name.equals(name2)){
					HighRiskPregnancyScorePO HighRiskPregnancyScorePO = highRiskPregnancyScoreService.getHighRiskPregnancyScorePOByname(name);
					if(HighRiskPregnancyScorePO !=null){
						model.set("HighRiskPregnancyScorePO", HighRiskPregnancyScorePO);
					}
					if(HighRiskPregnancyScorePO==null){
						model.set("HighRiskPregnancyScorePO", null);
					}
				}
				
			}
			if(id==null||id==""){
				HighRiskPregnancyScorePO HighRiskPregnancyScorePO = highRiskPregnancyScoreService.getHighRiskPregnancyScorePOByname(name);
				if(HighRiskPregnancyScorePO !=null){
					model.set("HighRiskPregnancyScorePO", HighRiskPregnancyScorePO);
				}
				if(HighRiskPregnancyScorePO==null){
					model.set("HighRiskPregnancyScorePO", null);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 列表数据
	 * @param reqs
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findByname", method = RequestMethod.GET)
	public Model findHighRiskPregnancyScorePOByname(@RequestParam Map<String, Object> reqs) {
		log.debug("request data: listPremaritalAbnormalOption");
		Model model = new Model();
		try {
			String name =(String) reqs.get("name");
			String type =(String) reqs.get("type");
			String id =(String) reqs.get("id");
			if(id!=null &&id!=""){
				HighRiskPregnancyScorePO find = highRiskPregnancyScoreService.find(id);
				String name2 = find.getName();
				if(name.equals(name2)){
					model.set("HighRiskPregnancyScorePO", null);
				}
				
				if(!name.equals(name2)){
					HighRiskPregnancyScorePO HighRiskPregnancyScorePO = highRiskPregnancyScoreService.findHighRiskPregnancyScorePOByname(name);
					if(HighRiskPregnancyScorePO !=null){
						model.set("HighRiskPregnancyScorePO", HighRiskPregnancyScorePO);
					}
					if(HighRiskPregnancyScorePO==null){
						model.set("HighRiskPregnancyScorePO", null);
					}
				}
			}
			if(id==null||id==""){
				HighRiskPregnancyScorePO HighRiskPregnancyScorePO = highRiskPregnancyScoreService.findHighRiskPregnancyScorePOByname(name);
				if(HighRiskPregnancyScorePO !=null){
					model.set("HighRiskPregnancyScorePO", HighRiskPregnancyScorePO);
				}
				if(HighRiskPregnancyScorePO==null){
					model.set("HighRiskPregnancyScorePO", null);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 * @author wangbj
	 */
	@ResponseBody
	@RequestMapping(value = "/listForBaby", method = RequestMethod.POST)
	public Model listHighRiskPregnancyScoreActoinForBaby(@RequestParam Map<String, Object> reqs, Page<HighRiskPregnancyScorePO> page) {
		log.debug("request data: listHighRiskPregnancyScore");
		Model model = new Model();
		try {
			highRiskPregnancyScoreService.listForPageBaby(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * 高危添加页面
	 * 
	 * @param highRiskPregnancyScoreVO
	 * @return
	 */
			@RequestMapping(value = "/addview", method = RequestMethod.GET)
			public ModelAndView addActivityView(@RequestParam Map<String, Object> reqs) {
				List<HighRiskPregnancyScorePO> findAll = highRiskPregnancyScoreService.findAll();
				reqs.put("list", findAll);
				ModelAndView modelAndView = new ModelAndView(
						
						
						"config/highrisk_add", reqs);
				return modelAndView;
			}

	/**
	 * HIGH_RISK_PREGNANCY_SCORE 添加
	 * 
	 * @param highRiskPregnancyScoreVO
	 * @return
	 */
	
	@RequestMapping(value = "/addrisk", method = RequestMethod.POST)
	public String addHighRiskPregnancyScoreActoin(@RequestParam Map<String, Object> reqs,HttpServletRequest request) {
		try {
			String name=(String)reqs.get("name");
			String remark=(String)reqs.get("remark");
			String score=(String)reqs.get("score");
			String status=(String)reqs.get("status");
			String type=(String)reqs.get("type");
			String uuid = IdUtil.uuid();
			HighRiskPregnancyScorePO highRiskPregnancyScorePO = new HighRiskPregnancyScorePO();
			highRiskPregnancyScorePO.setId(uuid);
			highRiskPregnancyScorePO.setName(name);
			highRiskPregnancyScorePO.setScore(score);
			highRiskPregnancyScorePO.setStatus(status);
			highRiskPregnancyScorePO.setRemark(remark);
			highRiskPregnancyScorePO.setType(type);
			highRiskPregnancyScorePO.setCreatTime(new Date());
			highRiskPregnancyScorePO.setUpdateTime(new Date());
			highRiskPregnancyScoreService.create(highRiskPregnancyScorePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "config/highrisk_list";
	}
	
	
	
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 添加
	 * 添加高危婴儿
	 * @param highRiskPregnancyScoreVO
	 * @return
	 */
	
	@RequestMapping(value = "/addriskBaby", method = RequestMethod.POST)
	public String addHighRiskPregnancyScoreActoinBaby(@RequestParam Map<String, Object> reqs,HttpServletRequest request) {
		try {
			String name=(String)reqs.get("name");
			String remark=(String)reqs.get("remark");
			String score=(String)reqs.get("score");
			String status=(String)reqs.get("status");
			String type=(String)reqs.get("type");
			String uuid = IdUtil.uuid();
			HighRiskPregnancyScorePO highRiskPregnancyScorePO = new HighRiskPregnancyScorePO();
			highRiskPregnancyScorePO.setId(uuid);
			highRiskPregnancyScorePO.setName(name);
			highRiskPregnancyScorePO.setScore(score);
			highRiskPregnancyScorePO.setStatus(status);
			highRiskPregnancyScorePO.setRemark(remark);
			highRiskPregnancyScorePO.setType(type);
			highRiskPregnancyScorePO.setCreatTime(new Date());
			highRiskPregnancyScorePO.setUpdateTime(new Date());
			highRiskPregnancyScoreService.create(highRiskPregnancyScorePO);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "config/highriskBaby_list";
	}
	
	
	
	/**
	 *修改高危项管理页面
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoin(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			HighRiskPregnancyScorePO find = highRiskPregnancyScoreService.find(id);
			reqs.put("find", find);
			modelAndView = new ModelAndView(
					"config/highrisk_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	
	
	
	/**
	 *修改高危项管理页面
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/updateBabyView", method = RequestMethod.GET)
	public ModelAndView updateMarriageRegistrationDataActoinBaby(HttpServletRequest request,Map<String, Object> reqs) {
		ModelAndView modelAndView =null;
		try {
			String id=request.getParameter("id");
			request.setAttribute("id", id);
			HighRiskPregnancyScorePO find = highRiskPregnancyScoreService.find(id);
			reqs.put("find", find);
			modelAndView = new ModelAndView(
					"config/highriskBaby_update", reqs);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return modelAndView;
	}
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 修改
	 * 
	 * @param highRiskPregnancyScoreVO
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateHighRiskPregnancyScoreActoin(@RequestParam Map<String, Object> reqs,HighRiskPregnancyScoreVO highRiskPregnancyScoreVO ) {
		try {
			
			String id=(String)reqs.get("id");
			
			HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(id);
			
			BeanUtils.copyProperties(highRiskPregnancyScorePO, highRiskPregnancyScoreVO);
			highRiskPregnancyScoreService.update(highRiskPregnancyScorePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "config/highrisk_list";
	}
	
	
	
	/**
	 * HIGH_RISK_PREGNANCY_SCORE 修改
	 * 
	 * @param highRiskPregnancyScoreVO
	 * @return
	 */
	@RequestMapping(value = "/updatebaby", method = RequestMethod.POST)
	public String updateHighRiskPregnancyScoreActoinbaby(@RequestParam Map<String, Object> reqs,HighRiskPregnancyScoreVO highRiskPregnancyScoreVO ) {
		try {
			
			String id=(String)reqs.get("id");
			
			HighRiskPregnancyScorePO highRiskPregnancyScorePO = highRiskPregnancyScoreService.find(id);
			
			BeanUtils.copyProperties(highRiskPregnancyScorePO, highRiskPregnancyScoreVO);
			highRiskPregnancyScoreService.update(highRiskPregnancyScorePO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "config/highriskBaby_list";
	}

	/**
	 * HIGH_RISK_PREGNANCY_SCORE 删除
	 * 
	 * @param highRiskPregnancyScoreIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delHighRiskPregnancyScoreAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			highRiskPregnancyScoreService.deletes(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}