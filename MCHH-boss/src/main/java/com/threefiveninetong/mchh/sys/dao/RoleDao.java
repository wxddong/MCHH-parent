package com.threefiveninetong.mchh.sys.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.sys.po.RolePO;





/**
 * 角色DAO
 * @author xuyh
 * @date 2013-7-26上午10:15:44
 * @description
 */
public interface RoleDao{

	/**
	 * 分页查询
	 * @param conds
	 */
	public List<RolePO> listRoleForPage(Map<String,Object> conds);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(RolePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(RolePO po);
	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable[] id);
	/**
	 * 删除roleId指定的角色与资源的关系 
	 * @param roleId
	 */
	public void deleteRoleResources(Serializable[] roleId);

	/**
	 * 批量插件角色资源关系 
	 * @param roleResList
	 */
	public void batchRoleGrean(List<Map<String, Object>> roleResList);

	/**
	 * 获取已分配的角色列表
	 * @param operatorId
	 * @return
	 */
	public List<RolePO> listOperatorAssignRole(String operatorId);

	/**
	 * 获取未分配的角色列表
	 * @param operatorId
	 * @return
	 */
	public List<RolePO> listOperatorNotAssignRole(String operatorId);

	/**
	 * 根据角色id获取该角色下关联的资源数目
	 * @param roleId
	 * @return
	 */
	public int getResCountByRoleId(String roleId);

	/**
	 * 根据角色id获取该角色关联的人员目
	 * @param roleId
	 * @return
	 */
	public int getOpeCountByRoleId(String roleId);

	 /**
     * 2016.9.5
     * wangxd
     * 获取角色用于转诊科室下拉列表的回显
     * @return
     */
	public List<RolePO> getAll();

	/**
	 * 通过id获取科室信息
	 * @param id
	 * @return
	 * @author yanwk
	 */
	public RolePO getRoleById(String id);


}