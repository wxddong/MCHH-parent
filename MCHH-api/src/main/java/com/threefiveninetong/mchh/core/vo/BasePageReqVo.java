package com.threefiveninetong.mchh.core.vo;

import org.hibernate.validator.constraints.Range;

/** 
 * @ClassName: BasePageReqVo 
 * @Description: TODO 分页基础请求对象
 * @author: jixf
 * @date: 2016年1月10日 下午2:15:34  
 */
public class BasePageReqVo extends BaseReqVo {
	
	/**
	 * @Fields page : 显示页数
	 */
	private int page = 1;
	/**
	 * @Fields rows : 每页显示记录数
	 */
	@Range(min=5,max=50)
	private int rows = 20;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
}
