package com.threefiveninetong.mchh.core.view;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.json.JsonStringWriter;
import org.springframework.web.servlet.view.json.JsonWriterConfiguratorTemplateRegistry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonView implements JsonStringWriter{
	private static Logger log=LoggerFactory.getLogger(FastJsonView.class);
	@Override
	public void convertAndWrite(@SuppressWarnings("rawtypes") Map map,
			JsonWriterConfiguratorTemplateRegistry reg, Writer writer,
			BindingResult result) throws IOException {
		SerializerFeature[] features = {SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames };
		SerializerFeature[] sf={SerializerFeature.PrettyFormat,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.QuoteFieldNames};
		Object obj=map.get("data");
		log.info(JSON.toJSONString(obj,sf));
		writer.write(JSON.toJSONString(obj,features));
	}

}
