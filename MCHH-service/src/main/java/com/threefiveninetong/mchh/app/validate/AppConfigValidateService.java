package com.threefiveninetong.mchh.app.validate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appConfig.po.AppChannelPO;
import com.threefiveninetong.mchh.appConfig.service.AppChannelService;
import com.threefiveninetong.mchh.appStatis.po.AppActivationPO;
import com.threefiveninetong.mchh.appStatis.po.AppIosPushDevicetokenPO;
import com.threefiveninetong.mchh.appStatis.service.AppActivationService;
import com.threefiveninetong.mchh.appStatis.service.AppIosPushDevicetokenService;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@Service
public class AppConfigValidateService {
	
	//统一配置逻辑处理日志
	public static Logger loggerConfig = LoggerFactory.getLogger("fileConfig");
	
	@Resource
	private AppChannelService channelService;
	
	@Resource
	private AppActivationService appActivationService;
	
	@Resource
	private AppIosPushDevicetokenService appIosPushDevicetokenService;
	
	/**
	 * 统一配置校验
	 * @param advertImagesFile
	 * @param uploadServerUrl
	 * @param terminalNo
	 * @return
	 */
	public Map<String,Object> validateUniformConfigInfo(String terminalNo,String advertImagesFile,String uploadServerUrl) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			String[] terminalArr = terminalNo.split(";");
	        String versionCode = terminalArr[4];// 版本号
	        String channelNO = terminalArr[1];// 渠道号
	        String equipmentNo = terminalArr[0];// 设备号
	        String equipmentSysVersion = terminalArr[2];// 设备系统版本号
	        String equipmentModel = terminalArr[3];// 设备型号
	        
	        //验证常量信息
			if (StringUtil.isNullOrBlank(advertImagesFile) || StringUtil.isNullOrBlank(uploadServerUrl)) {
	    		respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
	    		respMap.put("message", "系统图片数据异常!");
				return respMap;
			}
			
	        //验证渠道号是否存在
	        AppChannelPO channelInfo = this.channelService.findBychannelNO(channelNO);
	        if (null == channelInfo) {
	        	respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
	        	respMap.put("message", "渠道参数错误!");
	            return respMap;
	        }
	        respMap.put("channelNO", channelNO);
	        respMap.put("versionCode", versionCode);
	        
	        // 查询激活量，不存在：保存，存在：更新
	        respMap = this.addOrUpdateActivationOpt(respMap, versionCode, channelNO, equipmentNo, equipmentSysVersion, equipmentModel);
		} catch (Exception e) {
			loggerConfig.error("统一配置验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"统一配置验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 访问量统计表操作
	 * @param respMap
	 * @param versionCode
	 * @param channelNO
	 * @param equipmentNo
	 * @param equipmentSysVersion
	 * @param equipmentModel
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> addOrUpdateActivationOpt(Map<String,Object> respMap,String versionCode,
			String channelNO,String equipmentNo,String equipmentSysVersion,String equipmentModel) throws Exception {
		if (null == respMap) {
			respMap = MapUtil.getResultSuccess();
		}
		if (StringUtil.isNullOrBlank(equipmentNo)) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
			respMap.put("message", "设备号不能为空!");
			return respMap;
		}
		
		// 查询激活量，不存在：保存，存在：更新
        boolean isUpdate = true;// 是否更新
		AppActivationPO activationPO = appActivationService.findByEquipmentNo(equipmentNo);
        if (null == activationPO) {
            isUpdate = false;// 不更新
            activationPO = new AppActivationPO();
            activationPO.setId(IdUtil.uuid());// id
            activationPO.setEquipmentNo(equipmentNo);// 设备号
            activationPO.setVisitcountType("1");// 1：激活
            activationPO.setCreateTime(new Date());// 创建时间
        }
        activationPO.setChannelCode(channelNO);// 渠道号
        activationPO.setEquipmentModel(equipmentModel);// 设备型号
        activationPO.setEquipmentSysVersion(equipmentSysVersion);// 设备系统版本号
        activationPO.setVersion(versionCode);// 版本号
        
        if (isUpdate) {
        	// 数据库里有激活记录，做更新
        	appActivationService.update(activationPO);
        } else {
        	// 数据库里没有激活记录，做保存
        	appActivationService.create(activationPO);
        }
        respMap.put("activationId", activationPO.getId());
        return respMap;
	}
	
	/**
	 * 校验采集iphone的deviceToken信息
	 * @param terminalNo
	 * @return
	 */
	public Map<String,Object> validateDeviceTokenInfo(String terminalNo) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			String[] terminalArr = terminalNo.split(";");
	        String versionCode = terminalArr[4];// 版本号
	        String channelNO = terminalArr[1];// 渠道号
	        String equipmentNo = terminalArr[0];// 设备号
	        String equipmentSysVersion = terminalArr[2];// 设备系统版本号
	        String equipmentModel = terminalArr[3];// 设备型号
	        
	        respMap.put("equipmentNo", equipmentNo);
	        // 查询激活量，不存在：保存，存在：更新
	        respMap = this.addOrUpdateActivationOpt(respMap, versionCode, channelNO, equipmentNo, equipmentSysVersion, equipmentModel);
	        
	        //查询该设备是否已经存在deviceToken
	        List<AppIosPushDevicetokenPO> list = this.appIosPushDevicetokenService.findDevicetokenListByEquipmentNo(equipmentNo);
	        if (!CollectionUtil.isNullOrEmpty(list)) {
	        	//更新
	        	respMap.put("sign", "0");
	        	respMap.put("devicetokenInfo", list.get(0));
	        } else {
	        	//插入
	        	respMap.put("sign", "1");
	        }
		} catch (Exception e) {
			loggerConfig.error("采集iphone的deviceToken信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"采集iphone的deviceToken信息异常!",e);
		}
		return respMap;
	}
}
