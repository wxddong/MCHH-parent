package com.threefiveninetong.mchh.sys.po;

/**
 * 
 * @author xuyh
 * @date 2013-7-16上午11:19:37
 * @description 角色持久化对象
 */
public class RolePO {
	private String id;
	private String name;// 角色名
	private int flag;// 是否可用
	private String remark;// 备注

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
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
