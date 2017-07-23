package com.threefiveninetong.mchh.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.common.OperateLog;
import com.threefiveninetong.mchh.sys.common.OperateLogFactory;





/**
 * 日志拦截器
 * 
 * @author xuyh
 * @date 2013-7-26上午10:20:41
 * @description
 */
public class OperateLogInterceptor extends HandlerInterceptorAdapter {

	private final static Logger logger = LoggerFactory.getLogger(OperateLogInterceptor.class);

	private OperateLogFactory operateLogFactory;

	public void setOperateLogFactory(OperateLogFactory operateLogFactory) {
		this.operateLogFactory = operateLogFactory;
	}

	// 如果没有视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// TODO 这里最好的做法是指定需要记录日志的模块(URI)
		// 1.可以配置注解到Controller的方法
		// 2.可以配置单独的配置文件
		// 3.可以配置到数据库专门的配置表

		// 记录完整URL
		// Request中的请求数据
		// Model中的响应结果
		// 记录请求方的IP
		try {
			if (request.getAttribute(Constant.SESSION_KEY_OPERATOR) != null||(modelAndView!= null)||(request.getRequestURI()!=null&&request.getRequestURI().toString().contains("login"))) {
				String operateuri = request.getRequestURI().toString();
				String uri = operateuri.substring(request.getContextPath().length());
				if (uri!=null&&uri.length()>1&&uri.charAt(0) == '/')
					uri = uri.substring(1);
				String method = request.getMethod().toUpperCase();
				OperateLog operateLog = operateLogFactory.newLog(uri, method, request);

				if (operateLog != null) {
					if (modelAndView != null && modelAndView.getModel() instanceof Model) {
						Model model = (Model) modelAndView.getModel();
						if ("true".equals(model.get("success").toString())) {
							operateLog.doLog("", true);
						} else {
							operateLog.doLog("操作失败", false);
						}
					} else {
						operateLog.doLog("", true);
					}
				}
			} else {
				logger.debug("a modelAndView return:" + modelAndView);
			}
		} catch (Exception e) {
			logger.error("OperateLogInterceptor error.", e);
		}

	}

}
