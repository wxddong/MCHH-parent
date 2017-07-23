package com.threefiveninetong.mchh.util;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Me
 * 
 */
public class SysUtil {



	/**
	 * ajax返回值
	 * 
	 * @param response
	 * @param content
	 */
	public static void render(HttpServletResponse response, String content) {
		try {
			response.setContentType("text/html;charset=UTF-8 ");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断字符串是否为null或者空字符串，如果是那么也返回空字符串
	 * @param string
	 * @return
	 */
	public static String ifNull(Object string){
		String value = "";
		if(string != null){
			value = string.toString();
		}
		return value;
	}
	
	/**
	 * 如果对象的String类型的属性值是null，将其替换为""
	 * 
	 * 注意: spring等框架可能会对采用字节码增强技术，这时候内存中实际使用的类可能是你声明对象实例时类的子类。
	 * 这时候此方法就答不到期望的效果。
	 * 
	 * @param obj
	 */
	public static void NullFieldToEmptyString(Object obj) {
		
		if (obj == null) {
			return;
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			Class<?> type = field.getType();
			System.out.println("*****fieldName:"+field.getName()+"---"+type.getName());
			if (type == String.class) {
				field.setAccessible(true);
				try {
					field.set(obj, "");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 将double类型的num转成int类型的，有小数点的情况下+1
	 * @param num
	 * @return
	 */
	public static int changeDecimal(Double num){
		int result = 0;
		if(num != null){
		String round = Math.round(num) +"";
		String[] split = round.split(".");
		if(split.length>0){
				result = Integer.parseInt(split[0]+1);
		}else{
			result = Integer.parseInt(round+"");
		}
		}
		return result;
	}
}