package com.threefiveninetong.mchh.core.handler;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateFormate implements Converter<String, Date>{

	@Override
	public Date convert(String source){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		try {
			if(null!=source&&!"".equals(source)){
				return sdf.parse(source.trim());
			}
		} catch (ParseException e) {
			    sdf=new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				try {
					if(null!=source&&!"".equals(source)){
						return sdf.parse(source.trim());
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		}
		return null;
	}

//	
//	public static void main(String[] args) {
//		
//		System.out.println(new StringToDateFormate().convert("2014-03-05 15:13:14"));
//		System.out.println(new StringToDateFormate().convert("2014-03-05 "));
//		
//	}
//	
	
}
