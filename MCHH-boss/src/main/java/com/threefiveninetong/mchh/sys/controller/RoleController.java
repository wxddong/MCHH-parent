package com.threefiveninetong.mchh.sys.controller;

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
import com.threefiveninetong.mchh.sys.po.RolePO;
import com.threefiveninetong.mchh.sys.service.RoleService;
import com.threefiveninetong.mchh.sys.vo.RoleVO;
import com.threefiveninetong.mchh.util.Page;


/**
 * 角色控制类
 * <ul>
 * <li>/list： 角色列表</li>
 * <li>/add ：角色添加</li>
 * <li>/update ：角色更新</li>
 * <li>/beforeDel ：角色删除前验证</li>
 * <li>/del：角色删除</li>
 * <li>/grant/update ：修改角色权限</li>
 * </ul>
 * 
 * @author xuyh
 * @date 2013-7-16
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

	@Resource
	private RoleService roleService;

	/**
	 * 角色列表视图
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listRoleView() {
		return "sys/role/role_list";
	}

	/**
	 * 角色列表数据
	 * @param reqs
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Model listRoleActoin(@RequestParam Map<String, Object> reqs, Page<RolePO> page) {
		Model model = new Model();
		roleService.listRoleForPage(reqs, page);
		model.setPage(page);
		return model;
	}

	/**
	 * 角色添加或修改
	 * 
	 * @param department
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Model addRoleActoin(RoleVO roleVO) {
		Model model = new Model();
		try {
			model.setRow(roleService.addOrUpdateRoleActoin(roleVO));
		} catch(DuplicateKeyException e){
			model.setMessage("操作失败,该科室名已存在!");
			model.set(Model.SUCCESS, false);
		}catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 角色添加或修改
	 * 
	 * @param department
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Model updateRoleActoin(RoleVO roleVO) {
		Model model = new Model();
		try {
			model.setRow(roleService.addOrUpdateRoleActoin(roleVO));
		}catch(DuplicateKeyException e){
			model.setMessage("操作失败,该科室名已存在!");
			model.set(Model.SUCCESS, false);
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 角色删除前验证
	 * 
	 * @param departmentIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/beforeDel", method = RequestMethod.GET, produces = "application/json")
	public Model beforeDelAction(@RequestParam("ids") String ids) {
		Model model = new Model();
		try {
			int opeCount = roleService.getOpeCountByRoleIds(ids.split(","));
			if (opeCount != 0) {
				model.set("msg", "hasOpe");
				return model;
			}
			int resCount = roleService.getResCountByRoleIds(ids.split(","));
			if (resCount != 0)
				model.set("msg", "hasRes");
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 角色删除
	 * 
	 * @param departmentIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public Model delRoleAction(@RequestParam("roleIds") String roleIds) {
		Model model = new Model();
		
		try {
			roleService.deleteRole(roleIds.split(","));
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

	/**
	 * 修改角色权限
	 * 
	 * @param roleId
	 * @param funcIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/grant/update", method = RequestMethod.POST)
	public Model updateGrantActoin(@RequestParam String roleId, @RequestParam("resourcesIds") String[] resourcesIds) {
		Model model = new Model();
		
		try {
			roleService.updateRoleGrant(roleId, resourcesIds);
		} catch (Exception e) {
			e.printStackTrace();
			model.set(Model.SUCCESS, false);
		}
		return model;
	}

}
