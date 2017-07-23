package com.threefiveninetong.mchh.sys.dao;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.sys.po.CodeCategoryPO;




/**
 *  
 * @author codegen 2013-09-23 10:32:57 
 */
public interface CodeCategoryDao{

	/**
	 * 分页查询
	 * @param conds
	 */
	public List<CodeCategoryPO> listCodeCategoryForPage(Map<String,Object> conds);
	
	/**
	 * 查询一个操作员
	 * @param conds
	 */
	public CodeCategoryPO getCodeCategory(Map<String,Object> conds);
	
	/**
	 * 创建 
	 * @param po 
	 */
	public void add(CodeCategoryPO po);

	/**
	 * 修改 
	 * @param po 
	 */
	public void update(CodeCategoryPO po);
	/**
	 * 删除 
	 * @param id 
	 */
	public void delete(Serializable[] id);

	/**
	 * 删除代码类别下的代码数据
	 * @param codeCategoryIds
	 */
	public void deleteCode(String[] codeCategoryIds);

	/**
	 * 根据具体条件查询字典类别信息
	 * @param conds
	 * @return
	 */
	public List<Map<String, Object>> queryCategoryForList(Map<String, Object> conds);

}