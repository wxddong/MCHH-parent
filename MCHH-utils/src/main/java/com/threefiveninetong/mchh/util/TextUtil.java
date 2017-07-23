package com.threefiveninetong.mchh.util;


public class TextUtil {
	//图片地址
		//public static String imageBaseUrl ="http://127.0.0.1:8080/";
		public static String imageBaseUrl ="http://192.168.1.121:2222/";
		//特殊字符 _图片替换
		public static String special="ǒǒǒǒ/";
	/**
	 * 百度编辑器IMG内容替换，将返回的内容保存到数据库
	 * @param str
	 */
	public static String ueditorReplace(String str){
		if(!StringUtil.isNullOrBlank(str)){
			return str.replaceAll(imageBaseUrl, special);
		}
		return str;
	}
	
	/**
	 * 百度编辑器IMG还原，将返回给客户端及后台显示
	 * @param str
	 */
	public static String ueditorReduction(String str){
		if(!StringUtil.isNullOrBlank(str)){
			return str.replaceAll(special,imageBaseUrl);
		}
		return str;
	}
}
