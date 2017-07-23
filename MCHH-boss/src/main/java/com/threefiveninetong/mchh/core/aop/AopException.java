package com.threefiveninetong.mchh.core.aop;



import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.core.base.BaseVO;
import com.threefiveninetong.mchh.util.ExceptionUrl;
import com.threefiveninetong.mchh.util.SystemException;


//拦截异常
public class AopException implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(AopException.class);
	private ReloadableResourceBundleMessageSource messageSource;

	public void setMessageSource(
			ReloadableResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String messageFial;
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Class<?> cla = handlerMethod.getMethod().getReturnType();
		Annotation[] methodAnnotations = handlerMethod.getMethod()
				.getAnnotations();
		Object obj = null;
		String key = null;
		Map<String, Object> model = new HashMap<String, Object>();
		if (ex instanceof SystemException) {
			SystemException sysex = (SystemException) ex;
			if (sysex.getValues() != null
					&& sysex.getKey() != null && !"".equals(sysex.getKey())) {
				key = sysex.getKey();
				messageFial = messageSource.getMessage(sysex.getKey(), sysex
						.getValues(), null);
			} else if (sysex.getMessage() != null
					&& !"".equals(sysex.getMessage())) {
				messageFial = sysex.getMessage();
			} else if (sysex.getKey() != null && !"".equals(sysex.getKey())) {
				key = sysex.getKey();
				messageFial = messageSource.getMessage(sysex.getKey(), sysex
						.getValues(), null);
			} else {
				messageFial = "系统异常";
			}
		} else {
			messageFial = "系统异常";
		}
		logger.error(ex.getMessage(),ex);
		ex.printStackTrace();
		if (validateJson(methodAnnotations)) {
			try {
				if (cla.newInstance() instanceof ModelAndView) {
					BaseVO vo=new BaseVO();
					vo.setMessage(messageFial);
					vo.setStatusCode(key);
					model.put("data", vo);
				}else{
					obj = cla.newInstance();
					setter(obj, "Message", messageFial, String.class);
					setter(obj, "StatusCode", key, String.class);// 所有验证异常错误码为-200
					model.put("data", obj);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			/*
			 * model.put("data", messageFial); String
			 * url=this.validateArg(methodAnnotations); return new
			 * ModelAndView(url,model);
			 */
			try {
				if (cla.newInstance() instanceof ModelAndView) {
					BaseVO vo=new BaseVO();
					vo.setMessage(messageFial);
					vo.setStatusCode(key);
					model.put("data", vo);
				}else{
					obj = cla.newInstance();
					setter(obj, "Message", messageFial, String.class);
					setter(obj, "StatusCode", key, String.class);// 所有验证异常错误码为-200
					model.put("data", obj);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("jsonView", model);

	}

	public static void setter(Object obj, String att, Object value,
			Class<?> type) {
		try {
			Method method = obj.getClass().getMethod("set" + att, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean validateJson(Annotation[] methodAnnotations) {
		if (null != methodAnnotations) {
			for (Annotation anotation : methodAnnotations) {
				if (ResponseBody.class.isInstance(anotation)) {
					return true;
				}
			}
		}
		return false;
	}

	private String validateArg(Annotation[] methodAnnotations) {
		if (null != methodAnnotations) {
			for (Annotation anotation : methodAnnotations) {
				if (ExceptionUrl.class.isInstance(anotation)) {
					ExceptionUrl url = (ExceptionUrl) anotation;
					return url.url();
				}
			}
		}
		return null;
	}
}
