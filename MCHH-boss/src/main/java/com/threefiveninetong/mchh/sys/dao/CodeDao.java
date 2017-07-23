package com.threefiveninetong.mchh.sys.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.sys.po.CodePO;






/**
 *  
 * @author codegen 2013-09-23 16:15:07 
 */
public interface CodeDao{

	/**
	 * 分页查询
	 * @param conds
	 */
	public List<CodePO> listCodeForPage(Map<String,Object> conds);
	
	/**
	 * 查询一个操作员
	 * @param conds
	 */
	public CodePO getCode(Map<String,Object> conds);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(CodePO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(CodePO po);
	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable[] id);

	/**
	 * 根据具体条件查询字典信息
	 * @param cond
	 */
	public List<Map<String, Object>> queryForList(Map<String, Object> cond);

}