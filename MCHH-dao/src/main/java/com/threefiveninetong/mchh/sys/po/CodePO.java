package com.threefiveninetong.mchh.sys.po;

import java.io.Serializable;

/**
 * 
 * @author codegen 2013-09-23 16:15:07
 */
public class CodePO implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;
	/** 编码编号 **/
	private String id;

	/** 编码分类编号 **/
	private String categoryId;

	/** 代码健 **/
	private String codeKey;

	/** 代码值 **/
	private String codeValue;

	/** 顺序 **/
	private double onum;

	/** 备注 **/
	private String remark;

	/**
	 * 构造
	 */
	public CodePO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public double getOnum() {
		return onum;
	}

	public void setOnum(double onum) {
		this.onum = onum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}