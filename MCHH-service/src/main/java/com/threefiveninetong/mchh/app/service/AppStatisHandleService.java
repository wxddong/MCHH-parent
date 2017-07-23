package com.threefiveninetong.mchh.app.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.app.validate.AppStatisValidateService;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppStatisHandleService {
	
	//统计逻辑处理日志
	public static Logger loggerStatis = LoggerFactory.getLogger("fileStatis");
	
	@Resource
	private AppStatisValidateService appStatisValidateService;
}
