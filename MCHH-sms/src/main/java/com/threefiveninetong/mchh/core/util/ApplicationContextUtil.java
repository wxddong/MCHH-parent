package com.threefiveninetong.mchh.core.util;


import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtil.applicationContext = applicationContext;
	}

	@PreDestroy
	public void destroy() {
		applicationContext = null;
	}

	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}


	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}


	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean(requiredType);
	}
}
