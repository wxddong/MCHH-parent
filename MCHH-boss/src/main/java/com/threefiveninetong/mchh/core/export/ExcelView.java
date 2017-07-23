/**
 * 
 */
package com.threefiveninetong.mchh.core.export;

import java.util.List;

/**
 * @author xuyh
 * @date 2013-12-28下午04:44:47
 * @description
 */
public class ExcelView {
	private String name ;
	private List<ExcelCell> columns;
	private String dao ;
	private String method;
	private List<?> data;
	/**
	 * excel模板相对路径
	 */
	private String filePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ExcelCell> getColumns() {
		return columns;
	}
	public void setColumns(List<ExcelCell> columns) {
		this.columns = columns;
	}
	public String getDao() {
		return dao;
	}
	public void setDao(String dao) {
		this.dao = dao;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "ExcelView [columns=" + columns + ", dao=" + dao + ", data=" + data + ",filePath="+filePath+", method=" + method + ", name="
				+ name + "]";
	}
	
	
}
