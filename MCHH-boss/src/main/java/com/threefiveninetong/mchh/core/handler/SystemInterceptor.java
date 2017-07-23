package com.threefiveninetong.mchh.core.handler;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

	public class SystemInterceptor  implements HandlerInterceptor{

	private static final Logger logger=LoggerFactory.getLogger(SystemInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*	HandlerMethod handlerMethod = (HandlerMethod) handler;
			StringBuffer sb = new StringBuffer();
			Enumeration enu = request.getParameterNames();*/
			/*sb.append("请求类名:");
			sb.append(handlerMethod.getBeanType());
			sb.append(" 请求方法名:");
			sb.append(handlerMethod.getMethod().getName());
			sb.append(" 方法请求参数:");*/
//			Map<String,String> map=new HashMap<String, String>();
			/*while (enu.hasMoreElements()) {
				String elem = (String) enu.nextElement();
				sb.append(elem).append("--->value:").append(
						request.getParameter(elem)).append("---->");
				map.put(elem, request.getParameter(elem));
			}*/
			
			/*while (enu.hasMoreElements()) {
				String elem = (String) enu.nextElement();
				sb.append(elem).append(request.getParameter(elem).trim());
//				map.put(elem, request.getParameter(elem));
			}*/
		/*	String str=sb.toString();
			String data =null;
			if(str.indexOf("?>")>0){
				data=str.substring(str.indexOf("?>")+2).trim();
			}else{
				data=str;
			}*/
//			request.setAttribute("value", data);
//			logger.info(sb.toString());
			/*this.customerService.checkSigniture(map);
			if(!this.customerService.check()){
//				  request.getRequestURI().endsWith("customer/error.json");  
//				  response.sendRedirect(request.getContextPath() +"/customer/error");
				  RequestDispatcher rd = request.getRequestDispatcher("/customer/error");
		            rd.forward(request, response);
//					super.postHandle(request, response, handler, null);
				String url=request.getRequestURI();
				if(url.endsWith("xml")){
					BaseVO vo=new BaseVO();
					vo.setMessage("222");
					vo.setStatusCode("-11");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(XMLJaxbUtil.convertToXml(vo));
				}else{
					BaseVO vo=new BaseVO();
					vo.setMessage("222");
					vo.setStatusCode("-11");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(JSON.toJSONString(vo));
				}
				return false;
			}
			return true;*/
			
			if(request.getRequestURI().indexOf("static")==-1){
				HandlerMethod handlerMethod = (HandlerMethod) handler;
				StringBuffer sb=new StringBuffer();
				Enumeration enu= request.getParameterNames();
				sb.append("请求类名:");
				sb.append(handlerMethod.getBeanType());
				sb.append(" 请求方法名:");
				sb.append(handlerMethod.getMethod().getName());
				sb.append(" 方法请求参数:");
				while (enu.hasMoreElements()) {
					String elem = (String) enu.nextElement();
					sb.append(elem).append("--->value:").append(request.getParameter(elem)).append("---->");
				}
				logger.info(sb.toString());
				}
			return true;
		}

	
}
