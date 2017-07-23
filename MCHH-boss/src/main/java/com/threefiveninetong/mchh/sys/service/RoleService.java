package com.threefiveninetong.mchh.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.core.base.BaseService;
import com.threefiveninetong.mchh.sys.dao.RoleDao;
import com.threefiveninetong.mchh.sys.po.RolePO;
import com.threefiveninetong.mchh.sys.vo.RoleVO;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.Page;

/**
 * 角色业务接口实现类
 * 
 * @author zhouzhao
 * @date 2013-7-26上午09:56:30
 * @description
 */
@Service
public class RoleService extends BaseService<RolePO, RoleVO> {

    @Resource
    RoleDao roleDao;

    public void listRoleForPage(Map<String, Object> conds, Page<RolePO> page) {
        page.setEntityOrField(true);
        conds.put("page", page);
        List<RolePO> list = roleDao.listRoleForPage(conds);
        page.setList(list);
    }

    public RoleVO addOrUpdateRoleActoin(RoleVO roleVO) {
        RolePO rolePO = vo2po(roleVO);
        if (roleVO != null && !StringUtils.isEmpty(roleVO.getId())) {
            roleDao.update(rolePO);
        } else {
            rolePO.setId(IdUtil.uuid());
            roleDao.add(rolePO);
        }
        return roleVO;
    }

    public void deleteRole(String[] roleIds) {
        roleDao.deleteRoleResources(roleIds);
        roleDao.delete(roleIds);
    }

    public void updateRoleGrant(String roleId, String[] resourcesIds) {
        roleDao.deleteRoleResources(new String[] { roleId });
        List<Map<String, Object>> roleResList = new ArrayList<Map<String, Object>>();
        if (resourcesIds != null && resourcesIds.length > 0) {
            for (String r : resourcesIds) {
                if (r.equals(""))
                    break;
                Map<String, Object> role_res = new HashMap<String, Object>();
                role_res.put("roleId", roleId);
                role_res.put("resourcesId", r);
                roleResList.add(role_res);
            }
        }
        roleDao.batchRoleGrean(roleResList);
    }

    public List<RoleVO> listOperatorAssignRole(String operatorId) {
        List<RolePO> list = roleDao.listOperatorAssignRole(operatorId);
        return pl2vl(list);
    }

    public List<RoleVO> listOperatorNotAssignRole(String operatorId) {
        List<RolePO> list = roleDao.listOperatorNotAssignRole(operatorId);
        return pl2vl(list);
    }

    public int getResCountByRoleIds(String[] roleIds) {
        for (String roleId : roleIds) {
            int count = roleDao.getResCountByRoleId(roleId);
            if (count != 0)
                return count;
        }
        return 0;
    }

    public int getOpeCountByRoleIds(String[] roleIds) {
        for (String roleId : roleIds) {
            int count = roleDao.getOpeCountByRoleId(roleId);
            if (count != 0)
                return count;
        }
        return 0;
    }

    /**
     * 2016.9.5
     * wangxd
     * 获取角色用于转诊科室下拉列表的回显
     * @return
     */
	public List<RolePO> getAll() {
		return roleDao.getAll();
	}

	/**
	 * 通过科室id获取科室
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public RolePO getRoleById(String id) {
		return roleDao.getRoleById(id);
	}
}
