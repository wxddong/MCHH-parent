package com.threefiveninetong.mchh.sys.po;

import java.io.Serializable;

/**
 * 
 * @author codegen 2013-09-23 10:32:57
 */
public class CodeCategoryPO implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;

	/** 分类编号 **/ 
	private String id;
	
    /** 分类名称 **/ 
	private String categoryName;
	
    /** 备注 **/ 
	private String remark;

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