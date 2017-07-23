package com.threefiveninetong.mchh.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

public final class JsonUtil {

	public static <T> T toBean(String jsonStr, Class<T> beanClass) {
		return JSON.parseObject(jsonStr, beanClass);
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(String jsonStr, Class<T> componentType) {
		return (T[]) JSON.parseArray(jsonStr, componentType).toArray();
	}

	public static <T> List<T> toList(String jsonStr, Class<T> componentType) {
		return JSON.parseArray(jsonStr, componentType);
	}

	public static Map<String, Object> toMap(String jsonStr) {
		return JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {
		});
	}

	public static String toJson(Object beanObj) {
		return JSON.toJSONString(beanObj);
	}

	public static String toJsonDateNET(Date date) {
		return date != null ? "\\/Date(" + date.getTime() + "+0800)\\/" : null;
	}

	public static String toJsonDateNET(String date) {
		return toJsonDateNET(DateUtil.stringToDate(date));
	}
	
	public static JSONArray toJsonArray(String request) {
		JSONArray array = JSON.parseArray(request);
    	//array.parseArray(request);
    	return array;
	}
	public static <T> String toJSONString(T t){
		return JSON.toJSONString(t);
	}
}
