package com.threefiveninetong.mchh.core.redis;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;



public class JsonRedisSerializer {
	 public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	 @SuppressWarnings("unused")
	private static Logger log=LoggerFactory.getLogger(JsonRedisSerializer.class);
    private SerializerFeature[] serializerFeature;  
    public SerializerFeature[] getSerializerFeature() {  
        return serializerFeature;  
    }  
  
    public void setSerializerFeature(SerializerFeature[] serializerFeature) {  
        this.serializerFeature = serializerFeature;  
    }  
	
    public String SerializeToString(Object obj){
    	return JSON.toJSONString(obj, serializerFeature);
    }
    
    public <T> T SerializeToObject(String message,Class<T> cla){
    		return JSON.parseObject(message, cla);
    }
}
