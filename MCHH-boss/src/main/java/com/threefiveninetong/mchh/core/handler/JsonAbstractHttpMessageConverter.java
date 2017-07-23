package com.threefiveninetong.mchh.core.handler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
//来对requestbody 或responsebody中的数据进行解析
public class JsonAbstractHttpMessageConverter extends AbstractHttpMessageConverter<Object>{
	 public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
		private static final Logger logger=LoggerFactory.getLogger(JsonAbstractHttpMessageConverter.class);
		// fastjson特性参数  
	    private SerializerFeature[] serializerFeature;  
	  
	    public SerializerFeature[] getSerializerFeature() {  
	        return serializerFeature;  
	    }  
	  
	    public void setSerializerFeature(SerializerFeature[] serializerFeature) {  
	        this.serializerFeature = serializerFeature;  
	    }  
	  
		//限定页面文本传送类型 只有数据是改类型 的 才会进行拦截
		//application/json
		public JsonAbstractHttpMessageConverter(){
			super(new MediaType("application","json"));
		}
		@Override
		protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputmessage) throws IOException,
				HttpMessageNotReadableException {
			Charset charset;
			MediaType mediaType=inputmessage.getHeaders().getContentType();
			if(mediaType!=null&&mediaType.getCharSet()!=null){
				charset=mediaType.getCharSet();
			}else{
				charset=Charset.forName("UTF-8");
			}
			
			String input=FileCopyUtils.copyToString(new InputStreamReader(inputmessage.getBody(),charset));
			String result=URLDecoder.decode(input, "UTF-8");
	        return JSON.parseObject(result, clazz);
		}

		@Override
		protected boolean supports(Class<?> clazz) {
			return true;
		}

		@Override
		protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException,
				HttpMessageNotWritableException {
			SerializerFeature[] sf={SerializerFeature.PrettyFormat,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.QuoteFieldNames};
			String logjsonString = JSON.toJSONString(o,sf);
			String jsonString=null;
			if (null==serializerFeature){
				SerializerFeature[] serializerFeature={SerializerFeature.WriteMapNullValue, SerializerFeature.QuoteFieldNames};
				jsonString= JSON.toJSONString(o,serializerFeature);	
			}else{
				jsonString= JSON.toJSONString(o,serializerFeature);	
			}
	        OutputStream out = outputMessage.getBody();  
	        logger.info("返回参数:"+logjsonString);
	        out.write(jsonString.getBytes(DEFAULT_CHARSET));  
	        out.flush();  
		}

}
