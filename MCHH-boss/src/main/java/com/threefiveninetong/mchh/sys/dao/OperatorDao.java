package com.threefiveninetong.mchh.sys.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.threefiveninetong.mchh.sys.po.OperatorPO;
import com.threefiveninetong.mchh.sys.vo.OperatorVO;

/**
 * 操作员DAO
 * @author xuyh
 * @date 2013-7-26上午10:15:10
 * @description
 */
public interface OperatorDao{

	/**
	 * 分页查询
	 * @param conds
	 */
	public List<OperatorPO> listOperatorForPage(Map<String,Object> conds);
	
	/**
	 * 查询一个操作员
	 * @param conds
	 */
	public OperatorPO getOperator(Map<String,Object> conds);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(OperatorPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(OperatorPO po);
	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable[] id);

	/**
	 * 删除操作员id指定的操作员与角色的关系数据
	 * @param operatorId
	 */
	public void deleteOperatorRole(String[] operatorIds);

	/**
	 * 批量插入操作员与角色关系数据
	 * @param list
	 */
	public void batchOperatorRole(List<Map<String, Object>> list);
	
	public List<OperatorPO> findAll();
	
	/**
	 * 通过MbrId(平台ID)查询业务员信息
	 * @param memberId
	 * @return
	 */
	public OperatorPO findSalesmanByMbrId(Serializable memberId);

	public OperatorPO getOperatorAndDeptName(String loginName);

	/**
	 * 根据检查医生获取检查信息
	 * @param realName
	 * @return
	 */
	public OperatorPO getOperatorByRealName(String realName);
	
	//根据转诊机构获取预约医生
	public List<OperatorPO> findDoctorName(String val);

	public OperatorPO getRealName(String doctorId);

	/**
	 * 根据医生id获取医生信息
	 * @param doctorId
	 * @return
	 * @author yanwk
	 */
	public OperatorPO getOperatorById(String doctorId);

	public List<OperatorPO> findDoctor(String depId);
}