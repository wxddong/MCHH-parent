package com.threefiveninetong.mchh.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Lazy(value=false)
public class ApplicationContextHolder implements ApplicationContextAware {
	private static Logger log = LoggerFactory
			.getLogger(ApplicationContextHolder.class);

	private static ApplicationContext applicationContext;


	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		synchronized (ApplicationContextHolder.class) {
			if (applicationContext != null) {
				throw new IllegalStateException(
						"ApplicationContextHolder already holded 'applicationContext'.");
			}
			applicationContext = context;
			log.info("holded applicationContext,displayName:"
					+ applicationContext.getDisplayName());
		}
		
	}

	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException(
					"'applicationContext' property is null,ApplicationContextHolder not yet init.");
		return applicationContext;
	}

	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object getBean(Class clazz) {
	        return getApplicationContext().getBean(clazz);
	    }

	public static void cleanHolder() {
		applicationContext = null;
	}
	
}