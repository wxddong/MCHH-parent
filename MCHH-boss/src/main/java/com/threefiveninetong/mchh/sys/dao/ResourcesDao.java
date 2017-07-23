package com.threefiveninetong.mchh.sys.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.sys.po.ResourcesPO;




/**
 * 资源DAO
 * @author xuyh
 * @date 2013-7-26上午10:15:23
 * @description
 */
public interface ResourcesDao{

	/**
	 * 根据资源数据条件查询符合的资源列表
	 * @param conds
	 */
	public List<ResourcesPO> listResources(Map<String,Object> conds);
	
	/**
	 * 查询管理员关联的资源
	 * @param conds
	 */
	public List<ResourcesPO> listAdminResources(Map<String,Object> conds);
	/**
	 * 查询操作员关联的资源
	 * @param conds
	 */
	public List<ResourcesPO> listOperatorResources(Map<String,Object> conds);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(ResourcesPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(ResourcesPO po);
	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable[] id);

	/**
	 * 根据角色id查询所有的资源数据及其是否已经包含
	 * @param conds
	 * @return
	 */
	public List<ResourcesPO> listResourcesGrant(Map<String, Object> conds);

	/**
	 * 根据资源id删除与角色之间的关系
	 * @param strings
	 */
	public void deleteRoleRes(String[] resourcesId);

}