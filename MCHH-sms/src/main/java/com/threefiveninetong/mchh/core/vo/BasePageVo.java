package com.threefiveninetong.mchh.core.vo;

import java.util.List;

/** 
 * @ClassName: BasePageVo 
 * @Description: TODO 基础分页vo
 * @author: jixf
 * @date: 2016年1月10日 上午10:34:10  
 */
public class BasePageVo<T> extends BaseVo {
	
	/**
	 * @Fields rows : 每页显示记录数
	 */
	private int rows = 5;
	
	/**
	 * @Fields total : 总记录数
	 */
	private int total = 0;
	/**
	 *  @Fields page : 显示页数
	 */
	private int page = 1;

	/**
	 * @Fields list : 分页结果集合
	 */
	private List<T> list;
	public BasePageVo(){}
	public BasePageVo(int page,int rows,int total,List<T> list) {
		super();
		this.rows = rows;
		this.total = total;
		this.page = page;
		this.list = list;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalPage() {
		return total/rows+(total%rows==0?0:1);
	}
}
