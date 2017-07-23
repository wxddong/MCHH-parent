package com.threefiveninetong.mchh.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.core.vo.Menu;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.service.OperatorService;
import com.threefiveninetong.mchh.sys.service.SysService;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.sys.vo.ResourcesVO;
import com.threefiveninetong.mchh.util.StringUtil;


/**
 * 系统主控制类
 * <ul>
 * <li>/ ： 系统根路径</li>
 * <li>/login ：系统登录</li>
 * <li>/logout ：注销登录</li>
 * <li>/menu ：系统菜单</li>
 * <li>/profile/pwd/update ：密码更新</li>
 * <li>/profile/pwd/update ：密码更新</li>
 * <li>/profile/pwd/update ：密码更新</li>
 * </ul>
 * 
 * @author xuyh
 * @date 2013-7-16
 */
@Controller
public class SysController {

	private final static Logger logger = LoggerFactory.getLogger(SysController.class);
	@Resource
	private SysService sysService;

	@Resource
	private OperatorService operatorService;

	/**
	 * 主界面视图
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainView() {
		return "sys/main";
	}

	/**
	 * 登录视图
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView() {
		return "sys/login";
	}

	/**
	 * 登录处理
	 * 
	 * @param loginName
	 * @param password
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Model loginAction(String loginName, String password, HttpSession session) {
		logger.info("username:" + loginName + ", password:" + password);
		// TODO 防止重复登录
		Model model = new Model();
		OperatorVO operator = sysService.getOperator(loginName, password);
		
		if (null == operator) {
			// 操作员不存在
			model.set("success",false);
		} else {
			int flag = operator.getFlag();
			if (flag==0) {
				model.set("success", false);
				// 操作员已停用
			} else {
				OperatorVO operator1 = operatorService.getOperatorAndDeptName(operator);
				operator.setDepartment(operator1.getDepartment());
				session.setAttribute(Constant.SESSION_KEY_OPERATOR, operator);
				// 将操作员配置信息PROFILE放到session中
				// TODO 分析用户的配置信息
				Map<String, String> profile = new HashMap<String, String>();
				profile.put("pagesize", "25");
				profile.put("maxpanel", "0");
				profile.put("loginName", operator.getLoginName());
				session.setAttribute(Constant.SESSION_KEY_PROFILE, profile);
				// 将func编号缓存到会话中
				String operatorId = operator.getId();
				String[] resIds = sysService.getOperatorResourcesIds(operatorId);
				session.setAttribute(Constant.SESSION_KEY_RESIDS, resIds);
				String[] resUris = sysService.getOperatorResourcesUris(operatorId);
				session.setAttribute(Constant.SESSION_KEY_RESURIS, resUris);
				session.setMaxInactiveInterval(-1);
				// 登陆成功后，更新操作员最后登录时间
				operator.setLastLogin(new Date());
				// 更新操作员登录时间
				operatorService.updateOperator(operator);
			}
		}
		return model;
	}

	/**
	 * 注销登录视图（直接跳转）
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutView(HttpServletRequest request) {
		HttpSession session = request.getSession();
		request.setAttribute(Constant.SESSION_KEY_OPERATOR, session.getAttribute(Constant.SESSION_KEY_OPERATOR));
		session.removeAttribute(Constant.SESSION_KEY_OPERATOR);
		return "redirect:/login";
	}

	/**
	 * 获取菜单
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/menu")
	public Model menu(HttpSession session) {
		Model model = new Model();
		OperatorVO operator = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		
		String operatorId = operator.getId();
		List<ResourcesVO> menu = sysService.getOperatorMenu(operatorId);
		List<Menu<ResourcesVO>> menu2 = new ArrayList<Menu<ResourcesVO>>();
		rl2tl(menu, menu2, null, null, 1);
		// 组织为前台需要的格式
		model.setMenu(menu2);
		return model;
	}

	

	/**
	 * 更新当前登录管理员密码
	 * FIXME 
	 * @param reqs
	 * @return
	 */
	@RequestMapping(value = "/profile/pwd/update", method = RequestMethod.POST)
	public Model updatePwdAction(@RequestParam Map<String, String> reqs, HttpSession session) {
		Model model = new Model();
		OperatorVO opr = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		Map<String, Object> conds = new HashMap<String, Object>();
		conds.put("id", opr.getId());
		OperatorVO operator = operatorService.getOperator(conds);
		if (!"1".equals(opr.getId())&&!operator.getPassword().toString().equals(reqs.get("oldPassword"))) {
			model.addError("error.cmc.sys.pwdmod.msg");
			return model;
		} else {
			operator.setPassword(reqs.get("newPassword"));
			operator.setLastPwd(new Date());
			operatorService.updateOperator(operator);
		}
		return model;
	}

	/**
	 * 获取操作员当前的配置
	 * TODO 如记录的用户分页大小、是否最大化、皮肤等
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/profile/get")
	public Model getProfileAction(HttpSession session) {
		Model model = new Model();
		Map<String, String> operator = (Map<String, String>) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String confStr = operator.get("CONF");
		Map<String, String> profile = new HashMap<String, String>();
		profile.put("pagesize", "25");
		profile.put("maxpanel", "0");

		if (confStr != null && !confStr.equals("")) {
			String[] confs = confStr.split(";");
			String temp[] = new String[2];
			for (String conf : confs) {
				temp = conf.split(":");
				profile.put(temp[0], temp[1]);
			}
		}
		model.setRow(profile);
		return model;
	}

	/**
	 * 更新操作员配置
	 * TODO 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/profile/mod", method = RequestMethod.POST)
	public Model modProfileAction(@RequestParam Map<String, String> reqs, HttpSession session) {
		String pagesize = reqs.get("pagesize");
		String maxpanel = reqs.get("maxpanel");
		if (!pagesize.matches("\\d{1,3}")) {
			pagesize = "25";
		}
		if (!maxpanel.matches("[0,1]")) {
			maxpanel = "0";
		}
		OperatorVO opr = (OperatorVO) session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		String conf = "pagesize:" + pagesize + ";maxpanel:" + maxpanel;
		// opr.put("CONF", conf);
		// operatorService.updateOperator(opr);
		// 刷新session中的操作员配置信息
		Map<String, String> profile = (Map<String, String>) session.getAttribute(Constant.SESSION_KEY_PROFILE);
		if (profile == null) {
			profile = new HashMap<String, String>();
			session.setAttribute(Constant.SESSION_KEY_PROFILE, profile);
		}
		profile.put("pagesize", pagesize);
		profile.put("maxpanel", maxpanel);

		return Model.emptyModel();
	}
	
	/**
	 * 将资源转为树形结构
	 * 
	 * @param rl
	 *            所有资源数据
	 * @param ml
	 *            树结构数据
	 * @param parentId
	 *            父结构
	 * @param evel
	 *            层级 共1 2 3级，1为模块，2为菜单，3为链接或按钮
	 * @return
	 */
	private List<Menu<ResourcesVO>> rl2tl(List<ResourcesVO> rl, List<Menu<ResourcesVO>> ml, Menu<ResourcesVO> parent,
			String parentId, int evel) {
		if (evel > 3) {
			return ml;
		}
		if (StringUtils.isEmpty(parentId)) {
			for (ResourcesVO r : rl) {
				if (StringUtils.isEmpty(r.getParentId())) {
					Menu<ResourcesVO> m = new Menu<ResourcesVO>();
					m.setMenuid(r.getId());
					m.setMenuname(r.getName());
					m.setIcon("icon-sys");
					m.setUrl(r.getUri());
					ml.add(m);
					rl2tl(rl, ml, m, r.getId(), evel + 1);
				}
			}
		} else {
			Menu<ResourcesVO> p = parent;
			for (ResourcesVO r : rl) {
				if (parentId.equals(r.getParentId())) {
					Menu<ResourcesVO> m = new Menu<ResourcesVO>();
					m.setMenuid(r.getId());
					m.setMenuname(r.getName());
					m.setIcon("icon-nav");
					m.setUrl(r.getUri());
					p.getMenus().add(m);
					rl2tl(rl, ml, m, r.getId(), evel + 1);
				}
			}
		}
		return ml;
	}
}
