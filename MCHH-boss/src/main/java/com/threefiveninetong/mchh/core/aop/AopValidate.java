package com.threefiveninetong.mchh.core.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.threefiveninetong.mchh.util.JsonValidate;
import com.threefiveninetong.mchh.util.ValidateFailUrl;



public class AopValidate {
	@Resource
	private HttpServletRequest request;
	 private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	//private final static String el = "@annotation(org.springframework.web.bind.annotation.RequestMapping)";
	 public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		    Object retVal=null;
		    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		    Method method = methodSignature.getMethod();
		    //获取方法参数的注解
		    Annotation[][] argAnnotations = method.getParameterAnnotations();
		    //获取方法上注解
		    Annotation[] methodAnnotations=method.getAnnotations();
		  
		    //获取方法属性别名
		    String[] argNames = methodSignature.getParameterNames();
		    //获取属性参数
		    
		    Object[] args = joinPoint.getArgs();
		    for (int i = 0; i < args.length; i++) {
//		      if (hasRequestBodyAndValidAnnotations(argAnnotations[i])) {
		    	  if(request.getRequestURL().toString().endsWith(".json")){
		    		  Object ret = validateAnnotationsArg(args[i], argNames[i],method);
				        if(ret != null){
				        	request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
				        	return ret;
				        }
		    	  }else{
				        Object ret = validateArg(args[i], argNames[i],methodAnnotations);
				        if(ret != null&&!"".equals(ret.toString().trim())){
				        	request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
				        	return new ModelAndView((String)ret);
				        }else if (null==ret){
				        	request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
				        	return new ModelAndView(request.getServletPath());
				        }
				      
		    	  }
//		      }
//		      if (hasValidAnnotations(argAnnotations[i])) {
//		        Object ret = validateArg(args[i], argNames[i],methodAnnotations);
//		        if(ret != null){
//		        	return new ModelAndView((String)ret);
//		        }
//		      }
		    }
		    	retVal=joinPoint.proceed(args);
			return retVal;
		  }
		 //判断是否是json数据请求
		  private boolean hasRequestBodyAndValidAnnotations(Annotation[] annotations) {
		    boolean hasRequestBody = false;
		    boolean jsonValidate=false;
		    for (Annotation annotation : annotations) {
		      if (RequestBody.class.isInstance(annotation))
		        hasRequestBody = true;
		      if(JsonValidate.class.isInstance(annotation))
		    	  jsonValidate=true;
		     if(hasRequestBody&&jsonValidate){
		    	 return true;
		     }
		    }
		    return false;
		  }
		//判断是否是普通数据请求验证
		  private boolean hasValidAnnotations(Annotation[] annotations) {
			boolean hasValid = false;
		    for (Annotation annotation : annotations) {
		      if (Valid.class.isInstance(annotation))
		        hasValid = true;
		    }
		    return hasValid;
		  }

		  private Object validateAnnotationsArg(Object arg, String argName,Method method) {
			    BindingResult result = getBindingResult(arg, argName);
			    validator.validate(arg, result);
			    if (result.hasErrors()) {
			    	StringBuffer sb=new StringBuffer();
			    	for (FieldError fieldError : result.getFieldErrors()) {
			    		sb.append(fieldError.getDefaultMessage());
			    		sb.append("+");
					}
			    	Class<?> cla=method.getReturnType();
					try {
					  	Object obj;
						obj = cla.newInstance();
						if (obj instanceof ModelAndView){
							ModelMap model = new ModelMap();
							model.clear();
							model.addAttribute("msg",sb.toString());
							model.addAttribute("success",false);
							ModelAndView m=(ModelAndView)obj;
							m.addAllObjects(model);
						}else{
							setter(obj, "Attribute", sb.toString(),String.class);
							setter(obj, "StatusCode","-100",String.class);//所有验证异常错误码为-100
						}
						return obj;
					} catch (Exception e) {
						e.printStackTrace();
					}
			    }
			    return null;
			  }
		  
		  private String validateArg(Object arg, String argName,Annotation[] methodAnnotations) {
			    BindingResult result = getBindingResult(arg, argName);
			    validator.validate(arg, result);
			    if (result.hasErrors()) {
			    	if(null!=methodAnnotations){
			    		for(Annotation anotation:methodAnnotations){
			    			if(ValidateFailUrl.class.isInstance(anotation)){
				    			ValidateFailUrl url=(ValidateFailUrl)anotation;
				    			return url.url();
				    		}
			    		}
			    	}
			    	return null;
			    }
			    return "";
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
		  
		  
		  private BindingResult getBindingResult(Object target, String targetName) {
		    return new BeanPropertyBindingResult(target, targetName);
		  }
		 
}
