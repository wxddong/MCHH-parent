/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: CheckCodeService.java 
 * @Prject: MyUniversity-service
 * @Package: cn.com.devsource.myuniversity.config.service 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-01-08 10:14:25 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.sms.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;
import com.threefiveninetong.mchh.util.JsonUtil;


/**
 * @ClassName: SmsService
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-09-18 10:14:25
 */

@Service
public class SmsService{

    private static final Logger log = LoggerFactory	.getLogger(SmsService.class);
//
//    @Resource
//    Environment env;
//    
    @Value("${sms.sendUrl}")
	private String url;
	
	@Value("${token.key}")
    private String key;

    /**
     * 发送短信
     * @param telephoneList
     * @param content
     * @return
     */
    public boolean sendSms(String telephoneList,String content,String smsType) {   	
//    	String url =env.getProperty("sms.sendUrl");
//    	String key =env.getProperty("token.key");

         Map<String, Object> params = new HashMap<String, Object>();
         params.put("telephoneList", telephoneList);
         params.put("content", content);
         params.put("smsType", smsType);
         params.put("sign", APISignUtils.getSign(params, key));
         
         try {
			String result=HttpUtil.doPost(url, params);			
			Map resultMap= JsonUtil.toMap(result);	
			if(resultMap.get("statusCode").equals("0000")){
				return true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

        return false;
    }
}