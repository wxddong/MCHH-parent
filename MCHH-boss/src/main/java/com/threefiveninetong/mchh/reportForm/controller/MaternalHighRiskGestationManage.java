package com.threefiveninetong.mchh.reportForm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.reportForm.po.MaternalHighRiskGestationManagePO;
import com.threefiveninetong.mchh.reportForm.service.MaternalHighRiskGestationManageService;
import com.threefiveninetong.mchh.util.Page;

@Controller
@RequestMapping(value="/maternalhighriskgestationmanage")
public class MaternalHighRiskGestationManage {
	
	@Resource
	private MaternalHighRiskGestationManageService maternalHighRiskGestationManageService;

	/**
	 * 高危妊娠管理统计报表
	 * wangxd 2016.9.24
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMaternalHighRiskGestationManageView() {
		return "/reportForm/maternalhighriskgestationmanage_list";
	}
	/**
	 * 高危妊娠管理统计报表
	 * wangxd 2016.9.24
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
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
}
