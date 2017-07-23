package com.threefiveninetong.mchh.core.conver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
		dateFormat.setLenient(false);
		try {
			if (null != source && !"".equals(source)) {
				
				return dateFormat.parse(source);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
