package com.threefiveninetong.mchh.sys.common;

public class Constant {
	
	/**
	 * 会话操作员登录信息对象的key名称
	 */
	public final static String SESSION_KEY_OPERATOR = "OPERATOR";
	public final static String SESSION_KEY_RESIDS = "RESOURCESIDS";
	public final static String SESSION_KEY_RESURIS = "RESOURCESURI";
	public final static String SESSION_KEY_PROFILE = "PROFILE";
	public final static String reqHeader = "boss";
	
	
	/**
	 * 登录URI路径
	 */
	public final static String URI_LOGIN = "/login";
	
	/**
	 * 静态资源路径前缀 
	 */
	public final static String URI_STATIC_PREFIX = "/static/";
	
	
	//TODO: 统一错误信息的命名规范
	
	/**
	 * 错误信息：登录输入错误
	 */
	public final static String ERROR_LOGIN_INPUTWORNG = "error.boss.login.inputwrong";
	
	/**
	 * 错误信息：登录操作员处非有效状态
	 */
	public final static String ERROR_LOGIN_FLAGINVALID = "error.boss.login.flaginvalid";
}
