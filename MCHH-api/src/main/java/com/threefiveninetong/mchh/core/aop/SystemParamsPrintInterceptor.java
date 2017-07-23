package com.threefiveninetong.mchh.core.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.threefiveninetong.mchh.util.StringUtil;

public class SystemParamsPrintInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger=LoggerFactory.getLogger(SystemParamsPrintInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			StringBuffer sb = new StringBuffer();
			Enumeration<String> enu = request.getParameterNames();
			sb.append("请求类名:");
			sb.append(handlerMethod.getBeanType());
			sb.append(" 请求方法名:");
			sb.append(handlerMethod.getMethod().getName());
			sb.append(" 方法请求参数:");
			while (enu.hasMoreElements()) {
				String elem = StringUtil.valueOf(enu.nextElement());
				sb.append(elem).append("--->value:").append(
						request.getParameter(elem)).append("---->");
			}
			logger.info(sb.toString());
			return super.preHandle(request, response, handler);
		}

	
}
