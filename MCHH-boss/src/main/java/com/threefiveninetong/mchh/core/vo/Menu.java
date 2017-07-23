/**
 * 
 */
package com.threefiveninetong.mchh.core.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 对应easyui的菜单视图数据结构
 * 
 * @author xuyh
 * @date 2013-7-22下午03:23:06
 * @description
 */
public class Menu<T> {
	private String menuid;// 菜单id
	private String icon;// 菜单图标
	private String menuname;// 菜单名称
	private String url;// 菜单url
	private List<Menu<T>> menus;// 子菜单

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu<T>> getMenus() {
		if (menus == null)
			this.menus = new ArrayList<Menu<T>>();
		return menus;
	}

	public void setMenus(List<Menu<T>> menus) {
		this.menus = menus;
	}

}
