package com.threefiveninetong.mchh.app.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.app.validate.AppConfigValidateService;
import com.threefiveninetong.mchh.appConfig.po.AppAdvertisingPO;
import com.threefiveninetong.mchh.appConfig.po.AppVersionForcedUpdatePO;
import com.threefiveninetong.mchh.appConfig.po.AppVersionPO;
import com.threefiveninetong.mchh.appConfig.service.AppAdvertisingService;
import com.threefiveninetong.mchh.appConfig.service.AppVersionForcedUpdateService;
import com.threefiveninetong.mchh.appConfig.service.AppVersionService;
import com.threefiveninetong.mchh.appStatis.po.AppIosPushDevicetokenPO;
import com.threefiveninetong.mchh.appStatis.service.AppIosPushDevicetokenService;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppConfigHandleService {
	
	//统一配置逻辑处理日志
	public static Logger loggerConfig = LoggerFactory.getLogger("fileConfig");
	
	@Value("${sys.uploadServer.url}")
    private String uploadServerUrl;//图片服务器
	
	@Value("${sys.upload.path.advertImages.file}")
    private String advertImagesFile;//广告图片
	
	@Resource
	private AppConfigValidateService appConfigValidateService;
	
	@Resource
	private AppConfigValidateService appConfigValiadteService;
	
	@Resource
	private AppVersionService appVersionService;
	
	@Resource
	private AppAdvertisingService appAdvertisingService;
	
	@Resource
	private AppVersionForcedUpdateService appVersionForcedUpdateService;
	
	@Resource
	private AppIosPushDevicetokenService appIosPushDevicetokenService;
	
	/**
	 * 获取统一配置信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> getUniformConfigInfo(String terminalNo) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        try {
        	//校验过程
            respMap = this.appConfigValiadteService.validateUniformConfigInfo(terminalNo, advertImagesFile, uploadServerUrl);
            if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
            	return respMap;
            }
        	
            //获取版本信息
            String channelNO = StringUtil.valueOf(respMap.get("channelNO"));
            AppVersionPO versionPO = appVersionService.findNewestByEquType(channelNO);
            if (null != versionPO) {
            	respMap.put("versionInfo", versionPO);// 版本信息
            }
            
            //获取启动广告地址
            AppAdvertisingPO advertisingPO = appAdvertisingService.findStartUp();
            if (null != advertisingPO) {	
            	if (!StringUtil.isNullOrBlank(advertisingPO.getImageUrl())) {
            		respMap.put("imageUrl",uploadServerUrl + "/" + advertImagesFile + "/" + advertisingPO.getImageUrl());
            	}
            }
            
            //获取强制更新信息
            String versionCode = StringUtil.valueOf(respMap.get("versionCode"));
            AppVersionForcedUpdatePO sysForcedUpdatePO = appVersionForcedUpdateService.findByCode(versionCode, channelNO);
            if (null != sysForcedUpdatePO) {
            	respMap.put("forcedUpdateSign", "1");
            } else {
            	respMap.put("forcedUpdateSign", "0");
            }
        } catch (Exception e) {
        	loggerConfig.error("统一配置异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"统一配置异常!",e);
        }
        return respMap;
	}
	
	/**
	 * 获取最新版本信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> getLatestVersionInfo(String terminalNo) {
		Map<String, Object> resultMap = MapUtil.getResultSuccess();
		try {
			String[] terminalArr = terminalNo.split(";");
	        String channelNO = terminalArr[1];// 渠道号
	        AppVersionPO versionPO = appVersionService.findNewestByEquType(channelNO);
			resultMap.put("versionPO", versionPO);
		} catch (Exception e) {
        	loggerConfig.error("获取最新版本信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"获取最新版本信息异常!",e);
        } 
		return resultMap;
	}
	
	/**
	 * 采集iphone的deviceToken信息
	 * @param request
	 * @return
	 */
	public Map<String,Object> getDeviceTokenInfo(String terminalNo, String deviceToken) {
		Map<String, Object> respMap = MapUtil.getResultSuccess();
		try {
	        //验证过程
	        respMap = this.appConfigValiadteService.validateDeviceTokenInfo(terminalNo);
            if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
            	return respMap;
            }
	        
            //录入统计ID校验
            String activationId = StringUtil.valueOf(respMap.get("activationId"));
            if (StringUtil.isNullOrBlank(activationId)) {
            	respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
            	respMap.put("message", "录入IOS的deviceToken信息异常!");
        		return respMap;
            }
            
            //录入IOS的deviceToken信息
            String sign = StringUtil.valueOf(respMap.get("sign"));
            if (sign.equals("0")) {
            	//更新
            	AppIosPushDevicetokenPO iosDeviceInfo = (AppIosPushDevicetokenPO) respMap.get("devicetokenInfo");
            	iosDeviceInfo.setActivationId(activationId);
            	iosDeviceInfo.setUpdateTime(new Date());
            	appIosPushDevicetokenService.update(iosDeviceInfo);
            } else if (sign.equals("1")) {
            	//插入
            	AppIosPushDevicetokenPO iosDeviceInfo = new AppIosPushDevicetokenPO();
                iosDeviceInfo.setId(IdUtil.uuid());
                iosDeviceInfo.setEquipmentNo(StringUtil.valueOf(respMap.get("equipmentNo")));
                iosDeviceInfo.setDevicetoken(deviceToken);
                iosDeviceInfo.setCreateTime(new Date());
                iosDeviceInfo.setActivationId(activationId);
                appIosPushDevicetokenService.create(iosDeviceInfo);
            }
		} catch (Exception e) {
        	loggerConfig.error("采集iphone的deviceToken信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"采集iphone的deviceToken信息异常!",e);
        } 
		return respMap;
	}
}
