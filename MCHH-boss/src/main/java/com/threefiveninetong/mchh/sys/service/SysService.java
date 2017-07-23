package com.threefiveninetong.mchh.sys.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.OperatorDao;
import com.threefiveninetong.mchh.sys.dao.ResourcesDao;
import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.po.ResourcesPO;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;
import com.threefiveninetong.mchh.sys.vo.ResourcesVO;

/**
 * 系统业务接口实现类
 * 
 * @author zhouzhao
 * @date 2013-7-26上午09:57:16
 * @description
 */
@Service
public class SysService extends BaseService<ResourcesPO, ResourcesVO>{

	private final static String ADMIN_ID = "1";

	@Resource
	OperatorDao operatorDao;
	@Resource
	ResourcesDao resourcesDao;

	public OperatorVO getOperator(String loginName, String password) {
		Map<String, Object> conds = new HashMap<String, Object>();
		conds.put("loginName", loginName);
		conds.put("password", password);
		OperatorPO operatorPO = operatorDao.getOperator(conds);
		OperatorVO operatorVO = new OperatorVO();
		if (operatorPO != null) {
			BeanUtils.copyProperties(operatorPO, operatorVO);
			return operatorVO;
		} else {
			return null;
		}
	}

	public List<ResourcesVO> getOperatorMenu(String operatorId) {
		List<ResourcesPO> resourcesList;
		if (ADMIN_ID.equals(operatorId)) {// 如果是超级管理员
			Map<String, Object> conds = new HashMap<String, Object>();
			conds.put("typeRange", new int[] { 1, 2 });
			conds.put("menu", 1);
			conds.put("clubType", 0);
			resourcesList = resourcesDao.listAdminResources(conds);
		} else {// 普通操作员
			Map<String, Object> conds = new HashMap<String, Object>();
			conds.put("typeRange", new int[] { 1, 2 });
			conds.put("operatorId", operatorId);
			conds.put("menu", 1);
			resourcesList = resourcesDao.listOperatorResources(conds);
		}
		return pl2vl(resourcesList);
	}

	public String[] getOperatorResourcesIds(String operatorId) {
		Set<String> resIds = new HashSet<String>();
		List<ResourcesPO> resList = listResources(operatorId);
		for (int i = 0; i < resList.size(); i++) {
			ResourcesPO res = resList.get(i);
			resIds.add(res.getId());
		}
		return resIds.toArray(new String[0]);
	}

	public String[] getOperatorResourcesUris(String operatorId) {
		Set<String> resUris = new HashSet<String>();
		List<ResourcesPO> resList = listResources(operatorId);
		for (int i = 0; i < resList.size(); i++) {
			ResourcesPO res = resList.get(i);
			String uri = res.getUri();
			if (uri.contains(",")) {
				String[] uris = uri.split(",");
				for (String u : uris)
					resUris.add(u);
			} else {
				resUris.add(res.getUri());
			}
		}
		return resUris.toArray(new String[0]);
	}

	private List<ResourcesPO> listResources(String operatorId) {
		List<ResourcesPO> funclist;
		if (ADMIN_ID == operatorId) {
			Map<String, Object> conds = new HashMap<String, Object>();
			conds.put("typeRange", new int[] { 2, 3 });
			funclist = resourcesDao.listAdminResources(conds);
		} else {
			// 加载不需要授权的功能ID
			Map<String, Object> conds = new HashMap<String, Object>();
			conds.put("grantFlag", 0);
			conds.put("typeRange", new int[] { 2, 3 });
			funclist = resourcesDao.listOperatorResources(conds);

			// 查询操作员关联的资源
			conds = new HashMap<String, Object>();
			conds.put("grantFlag", 1);
			conds.put("operatorId", operatorId);
			conds.put("typeRange", new int[] { 2, 3 });
			funclist.addAll(resourcesDao.listOperatorResources(conds));
		}
		return funclist;
	}
}
