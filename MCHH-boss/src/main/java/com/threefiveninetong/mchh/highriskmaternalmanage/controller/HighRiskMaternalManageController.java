package com.threefiveninetong.mchh.highriskmaternalmanage.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskMaternalManagePO;
import com.threefiveninetong.mchh.highriskmaternalmanage.service.HighRiskMaternalManageService;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.Page;

@Controller
@RequestMapping("/highriskmaternalmanage")
public class HighRiskMaternalManageController {
	
	@Resource
	private HighRiskMaternalManageService highRiskMaternalManageService;
	@Resource
	private OperatorService operatorService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toHighRiskMaternalManageView(HttpSession session,Map<String,Object> map){
		//本院本日新增人数、转入人数、转出人数、本院共计人数、辖区内共计人数
		//从session中获取用户的信息 
		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String depId = operator.getDepId();
		map.put("thisHospitalId", depId);
		//本院今日新增人数
		int increaseNumToday = highRiskMaternalManageService.getIncreaseNumToday(depId);
		map.put("increaseNumToday", increaseNumToday);
		//转入人数
		int inNumToday = highRiskMaternalManageService.getInNumToday(depId);
		map.put("inNumToday", inNumToday);
		//转出人数
		int outNumToday = highRiskMaternalManageService.getOutNumToday(depId);
		map.put("outNumToday", outNumToday);
		//本院共计人数
		int totalNum = highRiskMaternalManageService.getTotalNum(depId);
		map.put("totalNum", totalNum);
		//辖区内总人数
		String allPeopleNum = highRiskMaternalManageService.getAllPeopleNum(depId);
		map.put("allPeopleNum", allPeopleNum);
		
		return "highriskmaternalmanage/highriskmaternalmanage_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Model HighRiskMaternalManageList(@RequestParam Map<String, Object> reqs,
										 	Map<String,Object> map,
										 	Page<HighRiskMaternalManagePO> page,HttpSession session){
		
		//将转诊状态作为查询条件传入到sql
		//获取本医院的ID(根据当前登录医生获取)
		//从session中获取用户的信息 
//		OperatorVO operator = (OperatorVO)session.getAttribute(Constant.SESSION_KEY_OPERATOR);
//		OperatorVO operator2 = operatorService.getOperatorAndDeptName(operator);
//		String thisHospitalId = operator2.getDepId();
		
		//将转诊状态作为查询条件传入到sql
		String thisHospitalId = (String) reqs.get("thisHospitalId");
		
		String  referralStatue = (String) reqs.get("referralStatue");
		if("n".equals(referralStatue)){
			reqs.remove(referralStatue);
		}
		if("in".equals(referralStatue)){
			//如果是转入的话，转入医院的id为本院id,
			reqs.put("inHosital", "inHosital");
			reqs.put("thisHospitalId", thisHospitalId);
		}
		if("this".equals(referralStatue)){
			//如果是本院的话，生育档案的建档医院的id等于当前医院的id
			reqs.put("thisHosital", "thisHosital");
			reqs.put("thisHospitalId", thisHospitalId);
		}
		if("out".equals(referralStatue)){
			//如果是转出的话，生育档案的转入医院id等于当前医院的id
			reqs.put("outHosital", "outHosital");
			reqs.put("thisHospitalId", thisHospitalId);
		}
		
		//将转归作为查询条件传给sql
		String lapseTo = (String) reqs.get("lapseTo");
		if("n".equals(lapseTo)){
			reqs.remove("lapseTo");
		}
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
		
		//将高危因素作为查询条件传入到sql
		String highRisk = (String) reqs.get("highRisk");
		if("n".equals(highRisk)){
			reqs.remove("highRisk");
		}else if("m".equals(highRisk)){
			reqs.remove("highRisk");
			reqs.put("m", "m");
		}
		//将得分作为查询条件传入sql
		String score = (String) reqs.get("score");
		if("0".equals(score)){
			reqs.put("zero", "zero");
		}
		if("5".equals(score)){
			reqs.put("five","five");
		}
		if("10to15".equals(score)){
			reqs.put("tenToFiveteen", "tenToFiveteen");
		}
		if("G20".equals(score)){
			reqs.put("G20", "G20");
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
			highRiskMaternalManageService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

}
