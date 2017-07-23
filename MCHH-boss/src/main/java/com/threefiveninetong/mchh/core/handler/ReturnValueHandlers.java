package com.threefiveninetong.mchh.core.handler;


import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
//的特定返回值进行处理
public class ReturnValueHandlers implements HandlerMethodReturnValueHandler{
  //则用来处理具体的返回类型
	@Override
	public void handleReturnValue(Object returnvalue, MethodParameter returntype, ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
			throws Exception {
		mavContainer.setViewName("common/success");
	}
 //方法用来确定此实现类是否支持对应返回类型
	@Override
	public boolean supportsReturnType(MethodParameter returntype) {
		/*Class<?> type=returntype.getParameterType();
		if(OrgnizationVO.class.equals(type)){
			return true;
		}*/
		return false;
	}

}
