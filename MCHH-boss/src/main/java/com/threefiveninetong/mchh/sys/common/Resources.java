/**
 * 
 */
package com.threefiveninetong.mchh.sys.common;

import com.threefiveninetong.mchh.sys.po.ResourcesPO;


/**
 * 权限拦截器辅助接口
 * @author xuyh
 * @date 2013-7-22上午09:39:12
 * @description
 */
public interface Resources {
	/**
	 * 获取指定URI对应的功能编号（正常状态的功能）
	 * @param uri
	 * @return
	 */
	public String[] getEnableMenuIdsByUri(String uri);
	
	/**
	 * 检查URI是否被权限保护
	 * @param uri
	 * @return
	 */
	public boolean isProtectedUri(String uri);
	
	/**
	 * 根据uri获取对应的功能模块对象
	 * @param uri
	 * @return
	 */
	public ResourcesPO getResourcesByUri(String uri,String method);
}
