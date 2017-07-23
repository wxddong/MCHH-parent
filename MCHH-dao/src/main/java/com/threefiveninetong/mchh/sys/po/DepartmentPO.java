package com.threefiveninetong.mchh.sys.po;

/**
 * 
 * @author xuyh
 * @date 2013-7-16上午11:19:37
 * @description 部门持久化对象
 */
public class DepartmentPO {
	private String id;
	private String name;// 名称
	private String remark;// 备注
	private String parentId;// 父部门id
	private String level;//地区级别
	private String regionId;//地区ID
	private String state;// 适应视图的状态
	
	public String getReginName() {
		return reginName;
	}

	public void setReginName(String reginName) {
		this.reginName = reginName;
	}

	private String reginName;

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
