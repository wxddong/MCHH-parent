package com.threefiveninetong.mchh.core.handler;

import java.io.IOException;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.threefiveninetong.mchh.util.JsonUtil;

/** 
 * @ClassName: JsonHttpMessageConverter 
 * @Description: TODO json日志
 * @author: jixf
 * @date: 2016年2月29日 下午4:30:47  
 */
public class JsonHttpMessageConverter extends MappingJackson2HttpMessageConverter {
	
	Logger logger = LoggerFactory.getLogger(JsonHttpMessageConverter.class);
	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		super.writeInternal(object, type, outputMessage);
		//添加json出参日志,默认使用jsckson格式化为空则使用fastjson格式化
		String jsonValue = objectMapper != null?objectMapper.writeValueAsString(object):JsonUtil.toJSONString(object);
		logger.info("输出参数:"+jsonValue);
	}

}
