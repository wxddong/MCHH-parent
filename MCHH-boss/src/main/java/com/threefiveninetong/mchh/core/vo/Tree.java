/**
 * 
 */
package com.threefiveninetong.mchh.core.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 对应easyui的tree视图json数据结构
 * 
 * @author xuyh
 * @date 2013-7-18上午10:09:23
 * @description
 */
public class Tree<T> {

	private String id;// 节点的唯一标识。
	private String text;// 显示在节点上的文本。
	private boolean checked;// 节点是否被选择。
	private List<Tree<T>> children;// 节点的自定义属性。
	private T attributes;// 自定义属性
	private Tree<T> parent;// 父节点

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Tree<T>> getChildren() {
		if (children == null)
			this.children = new ArrayList<Tree<T>>();
		return children;
	}

	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}

	public T getAttributes() {
		return attributes;
	}

	public void setAttributes(T attributes) {
		this.attributes = attributes;
	}

	public Tree<T> getParent() {
		return parent;
	}

	public void setParent(Tree<T> parent) {
		this.parent = parent;
	}

}
