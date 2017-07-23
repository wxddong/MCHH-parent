package com.threefiveninetong.mchh.sys.controller;



import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.common.Reloadable;
import com.threefiveninetong.mchh.sys.po.CodeCategoryPO;
import com.threefiveninetong.mchh.sys.po.CodePO;
import com.threefiveninetong.mchh.sys.service.CodeDictService;
import com.threefiveninetong.mchh.sys.vo.CodeCategoryVO;
import com.threefiveninetong.mchh.sys.vo.CodeVO;
import com.threefiveninetong.mchh.util.Page;







@Controller
@RequestMapping("/sys/codedict")
public class CodeDictController {

	private static final Logger log =LoggerFactory.getLogger(CodeDictController.class);
	@Resource
	private  CodeDictService  codeDictService;
	@Resource
	private  Reloadable codeDict;
	/**
	 * 字典类别列表视图
	 * @return
	 */
	@RequestMapping(value = "/category/list", method = RequestMethod.GET)
	public String listCategoryView() {
		log.debug("request page: /sys/codedict/category_list");
		return "sys/codedict/category_list";
	}
	/**
	 * 字典类别列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/category/list", method = RequestMethod.POST)
	public Model listCategoryActoin(@RequestParam Map<String, Object> reqs, Page<CodeCategoryPO> page) {
		log.debug("request data: listCategory");
		Model model = new Model();
		codeDictService.listCategoryForPage(reqs, page);
		model.setPage(page);
		return model;
	}

	/**
	 * 字典类别添加
	 * 
	 * @param codedictVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public Model addCategoryActoin(CodeCategoryVO codedictVO) {
		Model model = new Model();
		try {
			model.setRow(codeDictService.addOrUpdateCategory(codedictVO));
			((Reloadable)codeDict).reload();
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 字典类别修改
	 * 
	 * @param codedictVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/category/update", method = RequestMethod.POST)
	public Model updateCategoryActoin(CodeCategoryVO codedictVO) {
		Model model = new Model();
		try {
			model.setRow(codeDictService.addOrUpdateCategory(codedictVO));
			((Reloadable)codeDict).reload();
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 字典类别删除
	 * 
	 * @param codedictIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/category/del", method = RequestMethod.POST, produces = "application/json")
	public Model delCategoryAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			codeDictService.deleteCategory(ids.split(","));
			((Reloadable)codeDict).reload();
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	/**
	 * 字典信息列表视图
	 * @return
	 */
	@RequestMapping(value = "/code/list", method = RequestMethod.GET)
	public ModelAndView listCodeView(String categoryId,HttpServletResponse resp) {
		log.debug("request page: /sys/codedict/list");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/codedict/code_list");
		mav.addObject("categoryId", categoryId);
		return mav;
	}
	/**
	 * 字典类别列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/code/list", method = RequestMethod.POST)
	public Model listCodeActoin(@RequestParam Map<String, Object> reqs, Page<CodePO> page) {
		log.debug("request data: listCategory");
		Model model = new Model();
		codeDictService.listCodeForPage(reqs, page);
		model.setPage(page);
		return model;
	}
	
	/**
	 * 字典类别添加
	 * 
	 * @param codedictVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/code/add", method = RequestMethod.POST)
	public Model addCodeActoin(CodeVO codeVO) {
		Model model = new Model();
		try {
			model.setRow(codeDictService.addOrUpdateCode(codeVO));
			((Reloadable)codeDict).reload();
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	
	/**
	 * 字典类别修改
	 * 
	 * @param codedictVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/code/update", method = RequestMethod.POST)
	public Model updateCodeActoin(CodeVO codeVO) {
		Model model = new Model();
		try {
			model.setRow(codeDictService.addOrUpdateCode(codeVO));
			((Reloadable)codeDict).reload();
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	
	/**
	 * 字典类别删除
	 * 
	 * @param codedictIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/code/del", method = RequestMethod.POST, produces = "application/json")
	public Model delCodeAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			codeDictService.deleteCode(ids.split(","));
			((Reloadable)codeDict).reload();
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	
}