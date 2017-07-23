package com.threefiveninetong.mchh.core.util;

import java.util.ResourceBundle;

/**
 * 
 * 属性文件解析类
 * 
 * @version
 */
public class PropertyUtil {
	
	private PropertyUtil(){}
	static ResourceBundle bundleWebService = null;
	static{
		bundleWebService = ResourceBundle.getBundle("config");
	}
	public static ResourceBundle getProperty(){
		if(bundleWebService==null)
			bundleWebService=ResourceBundle.getBundle("config");
		return bundleWebService;
	}
	
}
