package com.threefiveninetong.mchh.sys.po;

import java.util.List;



/**
 * 
 * @author xuyh
 * @date 2013-7-16上午11:19:37
 * @description 资源持久化对象
 */
public class ResourcesPO {
	private String id;
	private String name;// 资源名称
	private String uri;// 资源uri
	private int type;// 类型
	private int menu;//是否为菜单,0不是1是
	private int grantFlag;// 是否受权限控制
	private String parentId;// 父id
	private int flag;// 可用标识
	private int onum;// 顺序
	private String remark;// 备注
	private int logFlag;// 是否记录日志
	private String logUri;// 日志url
	private int logMethod;// 日志方法:0 GET,1 POST
	private List<ResourcesPO> list;
	private int checked;// 在关联查询角色对应的资源有没有选中时用，该属性不与数据库中具体字段对应
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public int getGrantFlag() {
		return grantFlag;
	}
	public void setGrantFlag(int grantFlag) {
		this.grantFlag = grantFlag;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getLogFlag() {
		return logFlag;
	}
	public void setLogFlag(int logFlag) {
		this.logFlag = logFlag;
	}
	public String getLogUri() {
		return logUri;
	}
	public void setLogUri(String logUri) {
		this.logUri = logUri;
	}
	public int getLogMethod() {
		return logMethod;
	}
	public void setLogMethod(int logMethod) {
		this.logMethod = logMethod;
	}
	public List<ResourcesPO> getList() {
		return list;
	}
	public void setList(List<ResourcesPO> list) {
		this.list = list;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	
}
