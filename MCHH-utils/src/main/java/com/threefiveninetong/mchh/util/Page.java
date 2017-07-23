package com.threefiveninetong.mchh.util;

import java.util.List;

public class Page<T> {

	private int rows = 10;
	private int total = 0;
	private int page = 1;
	private List<T> list;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private int totalPage;      //总页数  
    private int currentResult;  //当前记录起始索引  
    private boolean entityOrField;  //true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性  
    public int getTotalPage() {  
        if(total%rows==0)  
            totalPage = total/rows;  
        else  
            totalPage = total/rows+1;  
        return totalPage;  
    }  
    public void setTotalPage(int totalPage) {  
        this.totalPage = totalPage;  
    }  
    public int getCurrentResult() {  
        currentResult = (getPage()-1)*getRows();  
        if(currentResult<0)  
            currentResult = 0;  
        return currentResult;  
    }  
    public void setCurrentResult(int currentResult) {  
        this.currentResult = currentResult;  
    }  
    public boolean isEntityOrField() {  
        return entityOrField;  
    }  
    public void setEntityOrField(boolean entityOrField) {  
        this.entityOrField = entityOrField;  
    }  
}
