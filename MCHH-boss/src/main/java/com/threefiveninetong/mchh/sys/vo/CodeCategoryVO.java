package com.threefiveninetong.mchh.sys.vo;

/**
 * 
 * @author codegen 2013-09-23 10:32:57
 */
public class CodeCategoryVO {

	/** 分类编号 **/
	private String id;

	/** 分类名称 **/
	private String categoryName;

	/** 备注 **/
	private String remark;

	/**
	 * 构造
	 */
	public CodeCategoryVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}