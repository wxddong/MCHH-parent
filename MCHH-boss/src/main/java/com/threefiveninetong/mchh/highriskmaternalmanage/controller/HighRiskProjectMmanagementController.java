package com.threefiveninetong.mchh.highriskmaternalmanage.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.archives.po.BirthArchivesInfoPO;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.childbirth.po.ChildbirthBasicInfoPO;
import com.threefiveninetong.mchh.childbirth.service.ChildbirthBasicInfoService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.highriskmaternalmanage.po.HighRiskProjectMmanagementPO;
import com.threefiveninetong.mchh.highriskmaternalmanage.service.HighRiskProjectMmanagementService;
import com.threefiveninetong.mchh.util.DateUtils;
import com.threefiveninetong.mchh.util.Page;

@Controller
@RequestMapping("/highriskprojectmanagement")
public class HighRiskProjectMmanagementController {
	
	@Resource
	private HighRiskProjectMmanagementService highRiskProjectMmanagementService;
	@Resource
	private  BirthArchivesInfoService  birthArchivesInfoService;
	@Resource
	private  ChildbirthBasicInfoService  childbirthBasicInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String toHighRiskMaternalManageView(Map<String,Object> map,
											   @RequestParam(value="birthArchiveId")String birthArchiveId,
											   @RequestParam(value="archivesId")String archivesId){
		//将查询的结果放进了map集合里
		 Map<String,Object> message = highRiskProjectMmanagementService.getMessageByPreExaId(birthArchiveId); 
		 //取出女方和男方的生日，计算出年龄
		 Date birthday = (Date) message.get("birthday"); 
		 if(birthday!=null){
			 int age = DateUtils.getAgeByBirthday(birthday);
			 message.put("age", age);
		 }
		
		 Date manBirthday = (Date) message.get("manBirthday");
		 if(manBirthday!=null){
			 int manAge = DateUtils.getAgeByBirthday(manBirthday);
			 message.put("manAge", manAge);
		 }
		 //查出结案原因    0：正常结案  1：流产  2：引产  3：失访  4：其他  5：自动结案
		 String closeReason = (String) message.get("closeReason");
		 Date lastMenses = (Date) message.get("lastMenses");
		 //计算孕周
		 //未结案时  
		 if(closeReason==null){
			 //没有结案  按末次月经距离今天的时间
			 int weeks = DateUtils.getWeekByLastMenses(lastMenses);
			 message.put("weeks", weeks);
		 }
		 if(closeReason!=null){
			//正常结案时  
			 if("0".equals(closeReason)){
				 ChildbirthBasicInfoPO childbirthBasic = childbirthBasicInfoService.getChildbirthBasicByBirthArchivesId(birthArchiveId);
				 if(childbirthBasic!=null){
					 String weeks = childbirthBasic.getGestationalWeek();
					 message.put("weeks", weeks);
				 }else{
					 //如果没有分娩信息按结案日期算
					 Date closeDate = (Date) message.get("closeDate");
					 if(closeDate!=null){
						 int weeks = DateUtils.getWeekByDate(closeDate, lastMenses);
						 message.put("weeks", weeks);
					 }
					
				 }
				 
			 }
			 //自动结案
			 else if("5".equals(closeReason)){
				 //自动结案按预产期算（40周）
				 message.put("weeks", 40);
			 }
			 //流产 引产  失访 其他
			 else{
				 Date closeDate = (Date) message.get("closeDate");
				 if(closeDate!=null){
					 int weeks = DateUtils.getWeekByDate(closeDate, lastMenses);
					 message.put("weeks", weeks);
				 }
			 }
		 }
		 
		 //根据生育档案id查询生育档案的信息，在页面上获取孕检信息，已结案的显示检查记录按钮，
		 BirthArchivesInfoPO birthArchives = birthArchivesInfoService.find(birthArchiveId);
		 map.put("birthArchives", birthArchives);
		 map.put("message", message);
		 map.put("archivesId", archivesId);
		 map.put("birthArchiveId", birthArchiveId);
		 return "highriskmaternalmanage/highriskprojectmanagement_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Model HighRiskMaternalManageList(@RequestParam Map<String, Object> reqs, Page<HighRiskProjectMmanagementPO> page){
		Model model = new Model();
		try {
			highRiskProjectMmanagementService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}

}
