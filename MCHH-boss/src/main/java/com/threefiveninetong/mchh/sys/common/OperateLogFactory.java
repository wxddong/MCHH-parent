package com.threefiveninetong.mchh.sys.common;

import javax.servlet.http.HttpServletRequest;
/**
 * 获取操作日志记录类工厂接口
 * @author xuyh
 * @date 2013-7-26上午10:18:35
 * @description
 */
public interface OperateLogFactory {

	/**
	 * 获取操作日志记录类对象
	 * @param uri			记录日志路径
	 * @param method		请求方式：POST/GET
	 * @param request		HttpServletRequest 对象
	 * @return
	 */
	OperateLog newLog(String uri, String method, HttpServletRequest request);

}
