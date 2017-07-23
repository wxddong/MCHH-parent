package com.threefiveninetong.mchh.sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.service.RoleService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.util.Page;


/**
 * 操作员控制类
 * <ul>
 * <li>/list： 操作员列表</li>
 * <li>/add ：操作员添加</li>
 * <li>/update ：操作员修改</li>
 * <li>/del：操作员删除</li>
 * <li>/granted：获取操作员当前的授权情况</li>
 * <li>/assginRole：为操作员分配角色</li>
 * </ul>
 * 
 * @author xuyh
 * @date 2013-7-16
 */
@Controller
@RequestMapping("/sys/operator")
public class OperatorController {
	private static final Logger log = LoggerFactory.getLogger(OperatorController.class);

	@Resource
	private OperatorService operatorService;
	@Resource
	private RoleService roleService;

	/**
	 * 操作员列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listOperatorView() {
		log.debug("request page: /sys/operator/list");
		return "sys/operator/operator_list";
	}

	/**
	 * 操作员列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listOperatorActoin(@RequestParam Map<String, Object> reqs, Page<OperatorPO> page) {
		log.debug("request data: listOperator");
		Model model = new Model();
		operatorService.listOperatorForPage(reqs, page);
		model.setPage(page);
		return model;
	}

	/**
	 * 操作员添加
	 * 
	 * @param operatorVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addOperatorActoin(OperatorVO operatorVO) {
		Model model = new Model();
		try {
			model.setRow(operatorService.addOrUpdateOperatorActoin(operatorVO));
		}catch(DuplicateKeyException e){
			model.setMessage("操作失败,该登录名已存在!");
			model.set(Model.SUCCESS, false);
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 操作员修改
	 * 
	 * @param operatorVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateOperatorActoin(OperatorVO operatorVO) {
		Model model = new Model();
		try {
			model.setRow(operatorService.addOrUpdateOperatorActoin(operatorVO));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}
	/**
	 * 操作员修改
	 * @param operatorVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPass", method = RequestMethod.POST)
	public Model updateOperatorActoin(@RequestParam Map<String, Object> reqs) {
		Model model = new Model();
		try {
			String id = reqs.get("id").toString();
			String newPassword = reqs.get("newPasword").toString();
			Map<String, Object> conds = new HashMap<String, Object>();
			conds.put("id", id);
			OperatorVO operator = operatorService.getOperator(conds);
			operator.setPassword(newPassword);
			model.setRow(operatorService.addOrUpdateOperatorActoin(operator));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 操作员删除
	 * 
	 * @param operatorIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delOperatorAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			operatorService.deleteOperator(ids.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 获取操作员当前的授权情况
	 * 
	 * @param reqs
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/granted", method = RequestMethod.POST)
	public Model listRole(@RequestParam String operatorId) {
		Model model = new Model();
		model.set("nolist", roleService.listOperatorNotAssignRole(operatorId));
		model.set("list", roleService.listOperatorAssignRole(operatorId));
		return model;
	}

	/**
	 * 为操作员分配角色
	 * @param operatorId
	 * @param roleIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/assginRole", method = RequestMethod.POST)
	public Model assignOperatorRoleActoin(@RequestParam("operatorId") String operatorId,
			@RequestParam("roleIds") String roleIds) {
		Model model = new Model();
		
		try {
			operatorService.assignOperatorRole(operatorId, roleIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

}
