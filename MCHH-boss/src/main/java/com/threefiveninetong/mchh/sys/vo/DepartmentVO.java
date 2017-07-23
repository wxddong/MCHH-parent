package com.threefiveninetong.mchh.sys.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xuyh
 * @date 2013-7-16上午11:19:37
 * @description 部门视图对象
 */
public class DepartmentVO {
	private String id;
	private String name;// 名称
	private String remark;// 备注
	private String parentId;// 父部门id
	private String level;//地区级别
	private String regionId;//地区ID
	private String state;// 适应视图的状态
	private List<DepartmentVO> children;// 子部门列表
	private String reginName;


	public String getReginName() {
		return reginName;
	}

	public void setReginName(String reginName) {
		this.reginName = reginName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<DepartmentVO> getChildren() {
		if (children == null)
			this.children = new ArrayList<DepartmentVO>();
		return children;
	}

	public void setChildren(List<DepartmentVO> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

}
