package com.threefiveninetong.mchh.core.page;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.core.vo.Menu;
import com.threefiveninetong.mchh.core.vo.Tree;
import com.threefiveninetong.mchh.util.Page;





/**
 * 
 * 前端交互使用的模型对象
 * 
 * @author xuyh
 * 
 */
public class Model extends HashMap<String, Object> {

	// 特定一些key值

	private static final long serialVersionUID = -3579786474085763801L;

	/**
	 * 页面模型，提供给Grid组件使用
	 */
	public static final String PAGE = "page";
	/**
	 * 页面模型，提供给TreeGrid组件使用
	 */
	public static final String TREEPAGE = "treepage";

	/**
	 * 业务错误
	 */
	public static final String ERROR = "error";

	/**
	 * 处理成功
	 */
	public static final String SUCCESS = "success";

	/**
	 * 单行数据记录
	 */
	public static final String ROW = "row";

	/**
	 * 列表数据记录
	 */
	public static final String LIST = "list";

	public static final String MESSAGE = "message";
	public static final String STATUS_CODE = "statusCode";

	/**
	 * 默认的数据型视图名
	 */
	public static final String DEFAULT_DATA_VIEWNAME = "common/data";

	public Model() {
		set(SUCCESS, true);
	}

	/**
	 * 设置分页模型数据
	 * 
	 * @param <T>
	 * @param page
	 */
	public <T> void setPage(Page<T> page) {
		this.put(PAGE, page);
	}

	/**
	 * 设置分页模型数据
	 * 
	 * @param <T>
	 * @param page
	 */
	public <T> void setTreePage(List<T> list) {
		Map<String, Object> tree = new HashMap<String, Object>();
		tree.put("total", list.size());
		tree.put("rows", list);
		this.put(TREEPAGE, tree);
	}

	/**
	 * 设置树形数据
	 * 
	 * @param <T>
	 * @param page
	 */
	public <T> void setTree(Tree<T> tree) {
		this.put("id", tree.getId());
		this.put("text", tree.getText());
		this.put("children", tree.getChildren());
		this.put("checked", tree.getChecked());
	}

	/**
	 * @param menu2
	 */
	public <T> void setMenu(List<Menu<T>> menu) {
		this.put("menus", menu);
	}

	/**
	 * 设置列表模型数据
	 * 
	 * @param <T>
	 * @param list
	 */
	public <T> void setList(List<T> list) {
		set(LIST, list);
	}

	/**
	 * 设置单行模型数据
	 * 
	 * @param <T>
	 * @param row
	 */
	public <T> void setRow(T row) {
		set(ROW, row);
	}

	/**
	 * 添加一个错误信息
	 * 
	 * @param message
	 */
	public void addError(String message) {
		// if(getModelMap().containsAttribute(ERROR)){
		// List list = (List)getModelMap().get(ERROR);
		// list.add(message);
		// }else{
		// List list = new ArrayList();
		// list.add(message);
		// set(ERROR, list);
		// }
		set(SUCCESS, false);
	}

	// /**
	// * 模型中是否有某属性值
	// * @param attributeName
	// * @return
	// */
	// public boolean has(String attributeName){
	// return getModelMap().containsAttribute(attributeName);
	// }
	//	

	public void setMessage(String message) {
		set(MESSAGE, message);
	}

	public void setStatusCode(String statusCode) {
		set(STATUS_CODE, statusCode);
	}

	/**
	 * 设置属性
	 * 
	 * @param attributeName
	 * @param o
	 */
	public void set(String attributeName, Object o) {
		put(attributeName, o);
	}

	// /**
	// * 从模型中取出某属性的值
	// * @param attributeName
	// * @return
	// */
	// public Object get(String attributeName){
	// return getModelMap().get(attributeName);
	// }
	//	
	/**
	 * 返回一个空的模型对象，不可设值
	 * 
	 * @return
	 */
	public static Model emptyModel() {
		// TODO 需要返回一个空的对象，该对象不可修改
		// 参考 Conllections.emptyMap();
		return new Model();
	}
}
