package com.threefiveninetong.mchh.util;

import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

public class TimeUtil {
	/**
	 *  日期格式 yyyyMMddHHmmss
	 */
	public static final String YYYYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public static final String YYYYMMDDHHMMSSSSS="yyyyMMddHHmmss";
	
	public static String dateToString(String pattern){
		FastDateFormat fdf=FastDateFormat.getInstance(pattern);
		try {
			String id=fdf.format(new Date());
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
