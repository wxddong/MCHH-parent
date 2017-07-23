package com.threefiveninetong.mchh.sys.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.config.po.DistrictAndCountyInfoPO;
import com.threefiveninetong.mchh.sys.po.DepartmentPO;







/**
 * 部门DAO
 * @author xuyh
 * @date 2013-7-26上午10:14:27
 * @description
 */
public interface DepartmentDao{
	
	/**
	 * 查询
	 * @param conds
	 */
	public List<DepartmentPO> listDepartment(Map<String,Object> conds);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(DepartmentPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(DepartmentPO po);
	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable[] id);

	/**
	 * 根据部门id获取它下面的人员数
	 * @param depId
	 * @return
	 */
	public int getOpeCountByDepId(String depId);

	/**
	 * 根据部门id获得该部门下子部门数
	 * @param depId
	 * @return
	 */
	public int getchdCountByDepId(String depId);

	/**
	 * 
	 * @return
	 */
	public String queryQyByName( String val);
	

	/*查询县名称*/
	public List<String> queryCountyName();

	//查询乡名称
	public List<String> queryXiangName();

	//查询村名称
	public List<DepartmentPO> queryCunName();

	//乡医院
	public List<DepartmentPO> findXiangHospital();

	//县医院
	public List<DepartmentPO> findXianHospital();

	public DepartmentPO getDepartmentById(String depId);

	public List<DepartmentPO> getDep(String parentId);

	/**
	 * 所有部门
	 * @return
	 */
	public DepartmentPO allDepartment();

	public List<DistrictAndCountyInfoPO> queryXianName();

	public List<DepartmentPO> getAllDepartment();

	/**
	 * 根据上级部门名称查询出部门信息
	 */
	public DepartmentPO getDepByName(String val);


}