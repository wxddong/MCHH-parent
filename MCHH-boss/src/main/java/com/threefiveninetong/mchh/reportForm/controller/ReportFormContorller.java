package com.threefiveninetong.mchh.reportForm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.archives.service.ArchivesInfoService;
import com.threefiveninetong.mchh.archives.service.BirthArchivesInfoService;
import com.threefiveninetong.mchh.config.controller.MarriageRegistrationDataController;
import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.service.DistrictAndCountyInfoService;
import com.threefiveninetong.mchh.config.service.MarriageRegistrationDataService;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;
import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.premarital.service.InspectionResultService;
import com.threefiveninetong.mchh.premarital.service.PremaritalExaInfoService;
import com.threefiveninetong.mchh.reportForm.po.ChildrenHealthcareConditionPO;
import com.threefiveninetong.mchh.reportForm.po.MaternalHealthcareConditionPO;
import com.threefiveninetong.mchh.reportForm.po.MaternalHighRiskGestationManagePO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalCheckPO;
import com.threefiveninetong.mchh.reportForm.po.PremaritalHealthCarePO;
import com.threefiveninetong.mchh.reportForm.po.TownShipHealthCenterStatisticsPO;
import com.threefiveninetong.mchh.reportForm.service.MaternalHighRiskGestationManageService;
import com.threefiveninetong.mchh.reportForm.service.ReportFormService;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;
import com.threefiveninetong.mchh.sys.po.MaternalReportsPO;
import com.threefiveninetong.mchh.sys.service.DepartmentService;
import com.threefiveninetong.mchh.util.Page;
@Controller
@RequestMapping("/report")
public class ReportFormContorller {
	
	
		private static final Logger log =Logger.getLogger(MarriageRegistrationDataController.class);
		
		@Resource
		private ReportFormService reportFormService;
		@Resource
		private  MarriageRegistrationDataService  marriageRegistrationDataService;
		
		@Resource
		private DistrictAndCountyInfoService districtAndCountyInfoService;
		
		@Resource
		private  PremaritalExaInfoService  premaritalExaInfoService;
		
		@Resource
		private  InspectionResultService  inspectionResultService;
		
		@Resource
		private ArchivesInfoService archivesInfoService;
		
		
		@Resource
		private  BirthArchivesInfoService  birthArchivesInfoService;
		
		@Resource
		private DepartmentService departmentService;
		
		@Resource
		private MaternalHighRiskGestationManageService maternalHighRiskGestationManageService;
		
		@Resource
		private PremaritalAbnormalOptionService premaritalAbnormalOptionService;
		
		/**
		 * 孕产妇保健报表
		 * @return
		 */
		@RequestMapping(value = "/materalList", method = RequestMethod.GET)
		public ModelAndView materalList(@RequestParam Map<String, Object> reqs) {
			
			ModelAndView mav = new ModelAndView();
			//获取所有部门
			DepartmentPO departmentPO = departmentService.allDepartment();
			
			String depId = departmentPO.getId();
			
			MaternalReportsPO maternalReportsPO = new MaternalReportsPO();
			
			maternalReportsPO.setHospitalId(depId);
			
			//产妇数合计
			Integer total = birthArchivesInfoService.getTotal();
			
			maternalReportsPO.setTotal(total);
			
			//非农业户籍人数
			Integer noAgriculture = birthArchivesInfoService.getNoAgriculture();
			
			maternalReportsPO.setNoAgriculture(noAgriculture);
			
			//农业户籍人数
			Integer agriculture = birthArchivesInfoService.getAgriculture();
			
			maternalReportsPO.setAgriculture(agriculture);
			
			//产妇建卡人数
			
			//产妇建卡百分比
			
			if (maternalReportsPO != null) {
				reqs.put("maternalReportsPO", maternalReportsPO);
			}
			
			mav.setViewName("/reportForm/maternal_reports");
			
			mav.addObject("maternal",reqs);
			
			return mav;
			
		}
		
		
	   

		/**
		 * 镇平县乡镇卫生院基本卫生服务绩效核算统计表    列表视图
		 * @return
		 */
		@RequestMapping(value = "/listTownShipReport", method = RequestMethod.GET)
		public ModelAndView listTownShipHealthCenterStatisticsView(Map<String, Object> reqs) {
			ModelAndView modelAndView = new ModelAndView(
					
					"reportForm/townshiphealthcenterstatistics", reqs);
			return modelAndView;
		}
		/**
		 * 镇平县乡镇卫生院基本卫生服务绩效核算统计表   列表数据
		 * @param reqs
		 * @param page
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/listTownShipReport", method = RequestMethod.POST)
		public Model listTownShipHealthCenterStatisticsAction(@RequestParam Map<String, Object> conds, Page<TownShipHealthCenterStatisticsPO> page) {
			Model model = new Model();
			try {
				maternalHighRiskGestationManageService.listForPage3(conds, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			return model;
		}
		
		

		/**
		 *七岁以下儿童保健和健康情况年报表    列表视图
		 * @return
		 */
		@RequestMapping(value = "/listChildrenReport", method = RequestMethod.GET)
		public ModelAndView listChildrenb7Agesview(Map<String, Object> reqs) {
			ModelAndView modelAndView = new ModelAndView(
					
					"reportForm/childrenhealthcarecondition", reqs);
			return modelAndView;
		}
		/**
		 * 七岁以下儿童保健和健康情况年报表   列表数据
		 * @param reqs
		 * @param page
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/listChildrenReport", method = RequestMethod.POST)
		public Model listChildrenb7AgesAction(@RequestParam Map<String, Object> conds, Page<ChildrenHealthcareConditionPO> page) {
			Model model = new Model();
			try {
				maternalHighRiskGestationManageService.listForPage2(conds, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			return model;
		}
		
		
		
		/**
		 * 高危妊娠管理统计报表
		 * @return
		 */
		@RequestMapping(value = "/maternalhighriskgestationmanagelist", method = RequestMethod.GET)
		public String listMaternalHighRiskGestationManageView() {
			return "/reportForm/maternalhighriskgestationmanage_list";
		}
		/**
		 * 高危妊娠管理统计报表
		 * @param reqs
		 * @param page
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/maternalhighriskgestationmanagelist", method = RequestMethod.POST)
		public Model listMaternalHighRiskGestationManageActoin(@RequestParam Map<String, Object> reqs, Page<MaternalHighRiskGestationManagePO> page) {
			Model model = new Model();
			try {
				maternalHighRiskGestationManageService.listForPage(reqs, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			return model;
		}
		
		
		
		
		/**
		 *孕产妇保健和健康情况报表   列表视图
		 * @return
		 */
		@RequestMapping(value = "/listMaternalReport", method = RequestMethod.GET)
		public ModelAndView listMaternalReport(Map<String, Object> reqs) {
			log.debug("request page: /sysset/marriageRegistrationData/marriageRegistrationData_list");
			ModelAndView modelAndView = new ModelAndView("reportForm/maternalhealthcarecondition", reqs);
																	 
			return modelAndView;
		}
		
		/**
		 *孕产妇保健和健康情况报表   列表数据
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/listMaternalReport", method = RequestMethod.POST)
		public Model listMaternalReportor(@RequestParam Map<String, Object> conds, Page<MaternalHealthcareConditionPO> page) {
			log.debug("request data: listMarriageRegistrationData");
			Model model = new Model();;
			try {
				reportFormService.listForPage3(conds, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			//获得地区id
//			String id =(String) reqs.get("id");
			
			//查询某地区所有产妇
//			List<ArchivesInfoPO> findAll = archivesInfoService.findAllByCountyId(id);
			//查询各地所有的档案
//			List<ArchivesInfoPO> all = archivesInfoService.findAll();
			//得到地区的生育建档的个数
//			double size0 = findAll.size();
//			double size1 = all.size();
			
//			double birthnow=(size0/size1)*100;
//			res.put("birthnow", birthnow);
//			res.put("size", size1);
			
			//查询所有户口
			
//			List<ArchivesInfoPO> ArchivesInfoPO= new ArrayList<ArchivesInfoPO>();
//			List<ArchivesInfoPO> ArchivesInfoPO2= new ArrayList<ArchivesInfoPO>();
//			for(int i=0;i<findAll.size();i++){
//				ArchivesInfoPO archivesInfoPO = findAll.get(i);
//				String accountType = archivesInfoPO.getAccountType();
				//查询所有农业户口
//				if(accountType=="0"){
//					ArchivesInfoPO.add(archivesInfoPO);
				//查询所有非农业户口	
//				}if(accountType=="1"){
//					ArchivesInfoPO2.add(archivesInfoPO);
//					
//				}
//			}
			//农业户口人数
//			double chives=ArchivesInfoPO.size();
			//非农业户口人数
//			double chives2=ArchivesInfoPO2.size();
//			res.put("chives", chives);
//			res.put("chives2", chives2);
		
		
			return model;
		}
		
	
		
		
		/**
		 *婚前医学检查疾病统计表    列表视图
		 * @return
		 */
		@RequestMapping(value = "/listCheck", method = RequestMethod.GET)
		public ModelAndView listMarryCheckIll(Map<String,Object> map) {
			ModelAndView modelAndView = new ModelAndView("reportForm/premaritalcheck");
			String type = null;
			//查询指定传染病  用于回显下拉列表
			type = "0";
			List<PremaritalAbnormalOptionPO> list1 = premaritalAbnormalOptionService.getByType(type);		
			//查询严重遗传病  用于回显下拉列表
			type = "1";
			List<PremaritalAbnormalOptionPO> list2 = premaritalAbnormalOptionService.getByType(type);
			//查询精神病  用于回显下拉列表
			type = "2";
			List<PremaritalAbnormalOptionPO> list3 = premaritalAbnormalOptionService.getByType(type);
			//查询男性生殖系统疾病  用于回显下拉列表
			type = "3";
			List<PremaritalAbnormalOptionPO> list4 = premaritalAbnormalOptionService.getByType(type);
			//查询女性生殖系统疾病  用于回显下拉列表
			type = "4";
			List<PremaritalAbnormalOptionPO> list5 = premaritalAbnormalOptionService.getByType(type);
			//查询内科疾病 用于回显下拉列表
			type = "5";
			List<PremaritalAbnormalOptionPO> list6 = premaritalAbnormalOptionService.getByType(type);
			
			modelAndView.addObject("list1", list1);
			modelAndView.addObject("list2", list2);
			modelAndView.addObject("list3", list3);
			modelAndView.addObject("list4", list4);
			modelAndView.addObject("list5", list5);
			modelAndView.addObject("list6", list6);
			
			return modelAndView;
		}
		/**
		 * 婚前医学检查疾病统计表列表数据
		 * @param reqs
		 * @param page
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/listCheck", method = RequestMethod.POST)
		public Model listMarriageCheckIll(@RequestParam Map<String, Object> conds, Page<PremaritalCheckPO> page) {
			Model model = new Model();
			try {
				reportFormService.listForPage2(conds, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			return model;
		}
		
		 /**
		 * 婚前保健情况报表    列表视图
		 * @return
		 */
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView listMarriageRegistrationDataView(Map<String, Object> reqs) {
			ModelAndView modelAndView = new ModelAndView("reportForm/premaritalhealthcare", reqs);
			return modelAndView;
		}
		/**
		 * 婚前保健情况报表  列表数据
		 * @param reqs
		 * @param page
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/list", method = RequestMethod.POST)
		public Model listMarriageRegistrationDataActoin(@RequestParam Map<String, Object> reqs, Page<PremaritalHealthCarePO> page) {
			Model model = new Model();
			try {
				reportFormService.listForPage(reqs, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.setPage(page);
			return model;
		}
		
		
}
