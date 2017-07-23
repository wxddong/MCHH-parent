/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SpecialDiseaseInfoController.java   
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.controller 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-10-20 17:23:54 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.controller;


import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.premarital.po.SpecialDiseaseInfoPO;
import com.threefiveninetong.mchh.premarital.vo.SpecialDiseaseInfoVO;
import com.threefiveninetong.mchh.prenatal.po.PrenatalExaInfoPO;
import com.threefiveninetong.mchh.premarital.service.SpecialDiseaseInfoService;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.config.po.DirectiveOpinionTemplatePO;
import com.threefiveninetong.mchh.config.po.HighRiskPregnancyScorePO;
import com.threefiveninetong.mchh.config.po.PremaritalAbnormalOptionPO;
import com.threefiveninetong.mchh.config.service.DirectiveOpinionTemplateService;
import com.threefiveninetong.mchh.config.service.PremaritalAbnormalOptionService;
import com.threefiveninetong.mchh.core.page.Model;

/**
 * @ClassName: SpecialDiseaseInfoController 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-10-20 17:23:54 
 */
@Controller
@RequestMapping("/specialdiseaseinfo")
public class SpecialDiseaseInfoController {

	private static final Logger log =Logger.getLogger(SpecialDiseaseInfoController.class);
	@Resource
	private  SpecialDiseaseInfoService  specialDiseaseInfoService;
	
	@Resource
	private  PremaritalAbnormalOptionService  premaritalAbnormalOptionService;
	
	@Resource
	private  DirectiveOpinionTemplateService  directiveOpinionTemplateService;

    /**
	 * SPECIAL_DISEASE_INFO 列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listSpecialDiseaseInfoView() {
		log.debug("request page: /sysset/specialDiseaseInfo/specialDiseaseInfo_list");
		return "sysset/specialDiseaseInfo/specialDiseaseInfo_list";
	}
	/**
	 * SPECIAL_DISEASE_INFO 列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listSpecialDiseaseInfoActoin(@RequestParam Map<String, Object> reqs, Page<SpecialDiseaseInfoPO> page) {
		log.debug("request data: listSpecialDiseaseInfo");
		Model model = new Model();
		try {
			specialDiseaseInfoService.listForPage(reqs, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.setPage(page);
		return model;
	}
	
	/**
	 * 根据检查结果id获取特殊疾病信息
	 * @param prenatalId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	public Model getSpecialById(@RequestParam("resultId")String resultId){
		
		Model model = new Model();
		SpecialDiseaseInfoPO specialDiseaseInfo = specialDiseaseInfoService.getSpecialById(resultId);
		List<PremaritalAbnormalOptionPO> listselect = new ArrayList<>();
		
		if (specialDiseaseInfo != null) {
			//指定传染病
			String infectiousDis = specialDiseaseInfo.getInfectiousDis();
			if (infectiousDis != null && infectiousDis != "") {
				String[] split1 = infectiousDis.split(",");
				for (int i = 0; i < split1.length; i++) {
					String infectious = split1[i];
					PremaritalAbnormalOptionPO find = premaritalAbnormalOptionService.find(infectious);
					listselect.add(find);
				}
			}
			
			//严重遗传病
			String geneticDis = specialDiseaseInfo.getGeneticDis();
			if (geneticDis != null && geneticDis != "") {
				String[] split2 = geneticDis.split(",");
				for (int i = 0; i < split2.length; i++) {
					String genetic = split2[i];
					PremaritalAbnormalOptionPO find1 = premaritalAbnormalOptionService.find(genetic);
					listselect.add(find1);
				}
			}
			
			//精神病
			String mentalDis = specialDiseaseInfo.getMentalDis();
			if (mentalDis != null && mentalDis != "") {
				String[] split3 = mentalDis.split(",");
				for (int i = 0; i < split3.length; i++) {
					String mental = split3[i];
					PremaritalAbnormalOptionPO find2 = premaritalAbnormalOptionService.find(mental);
					listselect.add(find2);
				}
			}
			
			//生殖系统疾病
			String reproductiveDis = specialDiseaseInfo.getReproductiveDis();
			if (reproductiveDis != null && reproductiveDis != "") {
				String[] split4 = reproductiveDis.split(",");
				for (int i = 0; i < split4.length; i++) {
					String repro = split4[i];
					PremaritalAbnormalOptionPO find3 = premaritalAbnormalOptionService.find(repro);
					listselect.add(find3);
				}
			}
			
			//内科疾病
			String medicalDis = specialDiseaseInfo.getMedicalDis();
			if (medicalDis != null && medicalDis != "") {
				String[] split5 = medicalDis.split(",");
				for (int i = 0; i < split5.length; i++) {
					String medical = split5[i];
					PremaritalAbnormalOptionPO find4 = premaritalAbnormalOptionService.find(medical);
					listselect.add(find4);
				}
			}
			
		}
		

		//查询出特殊疾病的所有项
		List<PremaritalAbnormalOptionPO> list = premaritalAbnormalOptionService.findAll();
		if (listselect.size() > 0) {
			for (PremaritalAbnormalOptionPO premaritalAbnormalOption : list) {
				for (PremaritalAbnormalOptionPO premaritalAbnormal : listselect) {
					if (premaritalAbnormal.getId().equals(premaritalAbnormalOption.getId())) {
						premaritalAbnormalOption.setSelected("1");
					}
				}
			}
		}
		
		model.set("list", list);
		model.set("resultId", resultId);
		return model;
	}

	/**
	 * 保存选中的女性特殊疾病项
	 * SPECIAL_DISEASE_INFO 添加
	 * 
	 * @param specialDiseaseInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addSpecialDiseaseInfoActoin(SpecialDiseaseInfoVO specialDiseaseInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			specialDiseaseInfoVO.setId(IdUtil.uuid());
			specialDiseaseInfoVO.setResultId(IdUtil.uuid());
			SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
			BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
			specialDiseaseInfoService.create(specialDiseaseInfoPO);
			//获取检查结果id
			String resultId = specialDiseaseInfoVO.getResultId();
			//获取女性婚前检查指导意见
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.getWoman();
			String content = directiveOpinionTemplatePO.getContent();
			//获取指定传染病
			String infectiousDis = specialDiseaseInfoVO.getInfectiousDis();
			String ill = "";
			String direct = content + "\n";
			if (infectiousDis != null) {
				String[] infects = infectiousDis.split(",");
				
				for (int i = 0; i < infects.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(infects[i]);
					String infect = premaritalAbnormalOption.getName();
					ill += infect + ";";
					
					//获取特殊疾病id
					String infectId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(infectId);
					if (directiveOpinionTemplate != null) {
						
						String infectContent = directiveOpinionTemplate.getContent();
						direct += infectContent + "\n";
						
					}
				}
				
			}
			
			//严重遗传病
			String geneticDis = specialDiseaseInfoVO.getGeneticDis();
			if (geneticDis != null) {
				String[] genes = geneticDis.split(",");
				
				for (int i = 0; i < genes.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(genes[i]);
					String gene = premaritalAbnormalOption.getName();
					ill += gene + ";";
					//获取特殊疾病id
					String geneId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(geneId);
					if (directiveOpinionTemplate != null) {
						
						String geneContent = directiveOpinionTemplate.getContent();
						direct += geneContent + "\n";
					}
				}
				
			}
			
			//精神病
			String mentalDis = specialDiseaseInfoVO.getMentalDis();
			if (mentalDis != null) {
				String[] mentals = mentalDis.split(",");
				
				for (int i = 0; i < mentals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(mentals[i]);
					String mental = premaritalAbnormalOption.getName();
					ill += mental + ";";
					//获取特殊疾病id
					String mentalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(mentalId);
					if (directiveOpinionTemplate != null) {
						
						String mentalContent = directiveOpinionTemplate.getContent();
						direct += mentalContent + "\n";
					}
				}
				
			}
			
			//生殖系统疾病
			String reproductiveDis = specialDiseaseInfoVO.getReproductiveDis();
			if (reproductiveDis != null) {
				String[] repros = reproductiveDis.split(",");
				
				for (int i = 0; i < repros.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(repros[i]);
					String repro = premaritalAbnormalOption.getName();
					ill += repro + ";";
					//获取特殊疾病id
					String reproId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(reproId);
					if (directiveOpinionTemplate != null) {
						
						String reproContent = directiveOpinionTemplate.getContent();
						direct += reproContent + "\n";
					}
				}
				
			}
			
			//内科疾病
			String medicalDis = specialDiseaseInfoVO.getMedicalDis();
			if (medicalDis != null) {
				String[] medicals = medicalDis.split(",");
				
				for (int i = 0; i < medicals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(medicals[i]);
					String medical = premaritalAbnormalOption.getName();
					ill += medical + ";";
					//获取特殊疾病id
					String medicalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(medicalId);
					if (directiveOpinionTemplate != null) {
						
						String medicalContent = directiveOpinionTemplate.getContent();
						direct += medicalContent + "\n";
					}
				}
				
			}
			
			model.set("ill", ill);
			model.set("direct", direct);
			model.set("resultId", resultId);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 保存选中的男性特殊疾病项
	 * SPECIAL_DISEASE_INFO 添加
	 * 
	 * @param specialDiseaseInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manAdd", method = RequestMethod.POST)
	public Model manAddSpecialDiseaseInfoActoin(SpecialDiseaseInfoVO specialDiseaseInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			specialDiseaseInfoVO.setId(IdUtil.uuid());
			specialDiseaseInfoVO.setResultId(IdUtil.uuid());
			SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
			BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
			specialDiseaseInfoService.create(specialDiseaseInfoPO);
			//获取检查结果id
			String resultId = specialDiseaseInfoVO.getResultId();
			//获取女性婚前检查指导意见
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.getMan();
			String content = directiveOpinionTemplatePO.getContent();
			//获取指定传染病
			String infectiousDis = specialDiseaseInfoVO.getInfectiousDis();
			String ill = "";
			String direct = content + "\n";
			if (infectiousDis != null) {
				String[] infects = infectiousDis.split(",");
				
				for (int i = 0; i < infects.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(infects[i]);
					String infect = premaritalAbnormalOption.getName();
					ill += infect + ";";
					
					//获取特殊疾病id
					String infectId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(infectId);
					if (directiveOpinionTemplate != null) {
						
						String infectContent = directiveOpinionTemplate.getContent();
						direct += infectContent + "\n";
						
					}
				}
				
			}
			
			//严重遗传病
			String geneticDis = specialDiseaseInfoVO.getGeneticDis();
			if (geneticDis != null) {
				String[] genes = geneticDis.split(",");
				
				for (int i = 0; i < genes.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(genes[i]);
					String gene = premaritalAbnormalOption.getName();
					ill += gene + ";";
					//获取特殊疾病id
					String geneId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(geneId);
					if (directiveOpinionTemplate != null) {
						
						String geneContent = directiveOpinionTemplate.getContent();
						direct += geneContent + "\n";
					}
				}
				
			}
			
			//精神病
			String mentalDis = specialDiseaseInfoVO.getMentalDis();
			if (mentalDis != null) {
				String[] mentals = mentalDis.split(",");
				
				for (int i = 0; i < mentals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(mentals[i]);
					String mental = premaritalAbnormalOption.getName();
					ill += mental + ";";
					//获取特殊疾病id
					String mentalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(mentalId);
					if (directiveOpinionTemplate != null) {
						
						String mentalContent = directiveOpinionTemplate.getContent();
						direct += mentalContent + "\n";
					}
				}
				
			}
			
			//生殖系统疾病
			String reproductiveDis = specialDiseaseInfoVO.getReproductiveDis();
			if (reproductiveDis != null) {
				String[] repros = reproductiveDis.split(",");
				
				for (int i = 0; i < repros.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(repros[i]);
					String repro = premaritalAbnormalOption.getName();
					ill += repro + ";";
					//获取特殊疾病id
					String reproId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(reproId);
					if (directiveOpinionTemplate != null) {
						
						String reproContent = directiveOpinionTemplate.getContent();
						direct += reproContent + "\n";
					}
				}
				
			}
			
			//内科疾病
			String medicalDis = specialDiseaseInfoVO.getMedicalDis();
			if (medicalDis != null) {
				String[] medicals = medicalDis.split(",");
				
				for (int i = 0; i < medicals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(medicals[i]);
					String medical = premaritalAbnormalOption.getName();
					ill += medical + ";";
					//获取特殊疾病id
					String medicalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(medicalId);
					if (directiveOpinionTemplate != null) {
						
						String medicalContent = directiveOpinionTemplate.getContent();
						direct += medicalContent + "\n";
					}
				}
				
			}
			
			model.set("ill", ill);
			model.set("direct", direct);
			model.set("resultId", resultId);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * SPECIAL_DISEASE_INFO 修改
	 * 
	 * @param specialDiseaseInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateSpecialDiseaseInfoActoin(SpecialDiseaseInfoVO specialDiseaseInfoVO) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
			BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
			specialDiseaseInfoService.update(specialDiseaseInfoPO);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 保存女性特殊疾病项的修改
	 * @param specialDiseaseInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateSpecial", method = RequestMethod.POST)
	public Model updateSpecial(SpecialDiseaseInfoVO specialDiseaseInfoVO,
							   @RequestParam(value = "resultId")String resultId) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			SpecialDiseaseInfoPO specialDiseaseInfo = specialDiseaseInfoService.getSpecialById(resultId);
			if (specialDiseaseInfo != null) {
				specialDiseaseInfoVO.setResultId(resultId);
				SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
				BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
				specialDiseaseInfoService.updateByResultId(specialDiseaseInfoPO);
			}else{
				specialDiseaseInfoVO.setId(IdUtil.uuid());
				specialDiseaseInfoVO.setResultId(resultId);
				SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
				BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
				specialDiseaseInfoService.create(specialDiseaseInfoPO);
			}
			
			//获取女性婚前检查指导意见
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.getWoman();
			String content = directiveOpinionTemplatePO.getContent();
			
			String direct = content + "\n";
			
			String ill = "";
			//获取指定传染病
			String infectiousDis = specialDiseaseInfoVO.getInfectiousDis();
			if (infectiousDis != null) {
				String[] infects = infectiousDis.split(",");
				
				for (int i = 0; i < infects.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(infects[i]);
					String infect = premaritalAbnormalOption.getName();
					ill += infect + ";";
					
					//获取特殊疾病id
					String infectId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(infectId);
					if (directiveOpinionTemplate != null) {
						
						String infectContent = directiveOpinionTemplate.getContent();
						direct += infectContent + "\n";
						
					}
				}
				
			}
			
			//严重遗传病
			String geneticDis = specialDiseaseInfoVO.getGeneticDis();
			if (geneticDis != null) {
				String[] genes = geneticDis.split(",");
				
				for (int i = 0; i < genes.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(genes[i]);
					String gene = premaritalAbnormalOption.getName();
					ill += gene + ";";
					
					//获取特殊疾病id
					String geneId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(geneId);
					if (directiveOpinionTemplate != null) {
						
						String geneContent = directiveOpinionTemplate.getContent();
						direct += geneContent + "\n";
					}
				}
				
			}
			
			//精神病
			String mentalDis = specialDiseaseInfoVO.getMentalDis();
			if (mentalDis != null) {
				String[] mentals = mentalDis.split(",");
				
				for (int i = 0; i < mentals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(mentals[i]);
					String mental = premaritalAbnormalOption.getName();
					ill += mental + ";";
					
					//获取特殊疾病id
					String mentalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(mentalId);
					if (directiveOpinionTemplate != null) {
						
						String mentalContent = directiveOpinionTemplate.getContent();
						direct += mentalContent + "\n";
					}
				}
				
			}
			
			//生殖系统疾病
			String reproductiveDis = specialDiseaseInfoVO.getReproductiveDis();
			if (reproductiveDis != null) {
				String[] repros = reproductiveDis.split(",");
				
				for (int i = 0; i < repros.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(repros[i]);
					String repro = premaritalAbnormalOption.getName();
					ill += repro + ";";
					
					//获取特殊疾病id
					String reproId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(reproId);
					if (directiveOpinionTemplate != null) {
						
						String reproContent = directiveOpinionTemplate.getContent();
						direct += reproContent + "\n";
					}
				}
				
			}
			
			//内科疾病
			String medicalDis = specialDiseaseInfoVO.getMedicalDis();
			if (medicalDis != null) {
				String[] medicals = medicalDis.split(",");
				
				for (int i = 0; i < medicals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(medicals[i]);
					String medical = premaritalAbnormalOption.getName();
					ill += medical + ";";
					
					//获取特殊疾病id
					String medicalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(medicalId);
					if (directiveOpinionTemplate != null) {
						
						String medicalContent = directiveOpinionTemplate.getContent();
						direct += medicalContent + "\n";
					}
				}
				
			}
			
			model.set("ill", ill);
			model.set("direct", direct);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}
	
	/**
	 * 保存男性特殊疾病项的修改
	 * @param specialDiseaseInfoVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateManSpecial", method = RequestMethod.POST)
	public Model updateManSpecial(SpecialDiseaseInfoVO specialDiseaseInfoVO,
							   @RequestParam(value = "resultId")String resultId) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			SpecialDiseaseInfoPO specialDiseaseInfo = specialDiseaseInfoService.getSpecialById(resultId);
			if (specialDiseaseInfo != null) {
				specialDiseaseInfoVO.setResultId(resultId);
				SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
				BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
				specialDiseaseInfoService.updateByResultId(specialDiseaseInfoPO);
			}else{
				specialDiseaseInfoVO.setId(IdUtil.uuid());
				specialDiseaseInfoVO.setResultId(resultId);
				SpecialDiseaseInfoPO specialDiseaseInfoPO = new SpecialDiseaseInfoPO();
				BeanUtils.copyProperties(specialDiseaseInfoPO, specialDiseaseInfoVO);
				specialDiseaseInfoService.create(specialDiseaseInfoPO);
			}
			
			//获取女性婚前检查指导意见
			DirectiveOpinionTemplatePO directiveOpinionTemplatePO = directiveOpinionTemplateService.getMan();
			String content = directiveOpinionTemplatePO.getContent();
			
			String direct = content + "\n";
			
			String ill = "";
			//获取指定传染病
			String infectiousDis = specialDiseaseInfoVO.getInfectiousDis();
			if (infectiousDis != null) {
				String[] infects = infectiousDis.split(",");
				
				for (int i = 0; i < infects.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(infects[i]);
					String infect = premaritalAbnormalOption.getName();
					ill += infect + ";";
					
					//获取特殊疾病id
					String infectId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(infectId);
					if (directiveOpinionTemplate != null) {
						
						String infectContent = directiveOpinionTemplate.getContent();
						direct += infectContent + "\n";
						
					}
				}
				
			}
			
			//严重遗传病
			String geneticDis = specialDiseaseInfoVO.getGeneticDis();
			if (geneticDis != null) {
				String[] genes = geneticDis.split(",");
				
				for (int i = 0; i < genes.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(genes[i]);
					String gene = premaritalAbnormalOption.getName();
					ill += gene + ";";
					
					//获取特殊疾病id
					String geneId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(geneId);
					if (directiveOpinionTemplate != null) {
						
						String geneContent = directiveOpinionTemplate.getContent();
						direct += geneContent + "\n";
					}
				}
				
			}
			
			//精神病
			String mentalDis = specialDiseaseInfoVO.getMentalDis();
			if (mentalDis != null) {
				String[] mentals = mentalDis.split(",");
				
				for (int i = 0; i < mentals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(mentals[i]);
					String mental = premaritalAbnormalOption.getName();
					ill += mental + ";";
					
					//获取特殊疾病id
					String mentalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(mentalId);
					if (directiveOpinionTemplate != null) {
						
						String mentalContent = directiveOpinionTemplate.getContent();
						direct += mentalContent + "\n";
					}
				}
				
			}
			
			//生殖系统疾病
			String reproductiveDis = specialDiseaseInfoVO.getReproductiveDis();
			if (reproductiveDis != null) {
				String[] repros = reproductiveDis.split(",");
				
				for (int i = 0; i < repros.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(repros[i]);
					String repro = premaritalAbnormalOption.getName();
					ill += repro + ";";
					
					//获取特殊疾病id
					String reproId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(reproId);
					if (directiveOpinionTemplate != null) {
						
						String reproContent = directiveOpinionTemplate.getContent();
						direct += reproContent + "\n";
					}
				}
				
			}
			
			//内科疾病
			String medicalDis = specialDiseaseInfoVO.getMedicalDis();
			if (medicalDis != null) {
				String[] medicals = medicalDis.split(",");
				
				for (int i = 0; i < medicals.length; i++) {
					PremaritalAbnormalOptionPO premaritalAbnormalOption = premaritalAbnormalOptionService.find(medicals[i]);
					String medical = premaritalAbnormalOption.getName();
					ill += medical + ";";
					
					//获取特殊疾病id
					String medicalId = premaritalAbnormalOption.getId();
					DirectiveOpinionTemplatePO directiveOpinionTemplate = directiveOpinionTemplateService.getDirectByTgd(medicalId);
					if (directiveOpinionTemplate != null) {
						
						String medicalContent = directiveOpinionTemplate.getContent();
						direct += medicalContent + "\n";
					}
				}
				
			}
			
			model.set("ill", ill);
			model.set("direct", direct);
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}

	/**
	 * SPECIAL_DISEASE_INFO 删除
	 * 
	 * @param specialDiseaseInfoIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delSpecialDiseaseInfoAction(@RequestParam("specialDiseaseInfoIds") String specialDiseaseInfoIds) {
		Model model = new Model();
		model.set("msg", "true");
		try {
			specialDiseaseInfoService.deletes(specialDiseaseInfoIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set("msg", "false");
		}
		return model;
	}


}