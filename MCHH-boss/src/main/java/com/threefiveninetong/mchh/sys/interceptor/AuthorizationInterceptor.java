package com.threefiveninetong.mchh.sys.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.threefiveninetong.mchh.sys.common.Constant;
import com.threefiveninetong.mchh.sys.common.Resources;




/**
 * 鉴权拦截器
 * @author xuyh
 * @date 2013-7-26上午10:20:24
 * @description
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
	
	private final static String GET = "GET";
	private final static String POST = "POST";
	
	private Resources resources;
	
	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		if(contextPath.length() > 0)
			uri = uri.substring(contextPath.length());

		//注意防止"app//xxx"的非法路径绕过检查
		if(uri.indexOf("//") != -1){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        	return false;
		}
		
		//放过公用资源部分
		if(uri.startsWith(Constant.URI_STATIC_PREFIX)){
			return true;
		}
		//会话超时
		HttpSession session = request.getSession();
		Object o = session.getAttribute(Constant.SESSION_KEY_OPERATOR);
		if(Constant.URI_LOGIN.equals(uri)){
			return true; //登录界面放过
		}
		
		if(resources.isProtectedUri(uri) || "/".equals(uri)){
			//会话超时
			if(null == o){
				String method = request.getMethod();
				//这里简要认为POST请求是数据请求， GET请求是视图类请求
				if(GET.equalsIgnoreCase(method)){
					response.sendRedirect(contextPath + Constant.URI_LOGIN);
					return false;
				}else if(POST.equalsIgnoreCase(method)){
					//如果会话丢失，应该返回一个需要登录的标记
					//理论上解应该按照映射到的方法的具体返回类型来返回对应类型的消息
//					Model model = new Model();
//					model.addError("error.cmc.nosession");
//					ObjectMapper m = new ObjectMapper();
//					m.writeValue(response.getOutputStream(), model);
					
				}else{
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		        	return false;
				}
			}else if("/".equals(uri)){
				return true; //主界面放过
			}
			
			
			String[] resourcesIds = resources.getEnableMenuIdsByUri(uri);//该uri对应全站中受权限保护的资源id
			String[] resourcesIds0 = (String[])session.getAttribute(Constant.SESSION_KEY_RESIDS);//该操作员的uri
			if(resourcesIds.length == 0) return true;
			if(null == resourcesIds0) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return false;
			}
			for(String resId : resourcesIds){
				for(String resId0 : resourcesIds0){
					if(resId.equals(resId0)){
						return true;
					}
				}
			}
			//无授权访问受保护URI
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
			
		}
		
		return true;
	}
	
	
	
}
