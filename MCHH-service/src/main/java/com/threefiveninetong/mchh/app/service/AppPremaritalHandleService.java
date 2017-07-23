package com.threefiveninetong.mchh.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.app.validate.AppPremaritalValidateService;
import com.threefiveninetong.mchh.appConfig.po.AppBannerInfoPO;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.appConfig.service.AppBannerInfoService;
import com.threefiveninetong.mchh.appConfig.service.AppExpertGuidanceService;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appMember.service.AppMbrMessageInfoService;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationBasicInfoPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationOtherInfoPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationTemperatureRecordPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationWeightRecordPO;
import com.threefiveninetong.mchh.appPremarital.service.AppPreparationBasicInfoService;
import com.threefiveninetong.mchh.appPremarital.service.AppPreparationOtherInfoService;
import com.threefiveninetong.mchh.appPremarital.service.AppPreparationTemperatureRecordService;
import com.threefiveninetong.mchh.appPremarital.service.AppPreparationWeightRecordService;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.ClosedStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.MsgSource;
import com.threefiveninetong.mchh.util.DictionaryForApi.StageStatus;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppPremaritalHandleService {
	
	//备孕期逻辑处理日志
	public static Logger loggerPremarital = LoggerFactory.getLogger("filePremarital");
	
	@Value("${sys.uploadServer.url}")
    private String uploadServerUrl;//图片服务器
	
	@Value("${sys.upload.path.advertImages.file}")
    private String advertImagesFile;//广告图片
	
	@Resource
	private AppPremaritalValidateService appPremaritalValidateService;
	
	@Resource
	private AppBannerInfoService appBannerInfoService;
	
	@Resource
	private AppExpertGuidanceService appExpertGuidanceService;
	
	@Resource
	private AppPreparationBasicInfoService appPreparationBasicInfoService;
	
	@Resource
	private AppPreparationWeightRecordService appPreparationWeightRecordService;
	
	@Resource
	private AppPreparationTemperatureRecordService appPreparationTemperatureRecordService;
	
	@Resource
	private AppMbrMessageInfoService appMbrMessageInfoService;
	
	@Resource
	private AppPreparationOtherInfoService appPreparationOtherInfoService;
	
	/**
	 * 查询备孕期首页信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPremaritalFirstPageInfo(String memberId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap = this.appPremaritalValidateService.validateSearchPremaritalFirstPageInfo(memberId, uploadServerUrl, advertImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//图片地址
			respMap.put("serverUrl", uploadServerUrl + "/" + advertImagesFile + "/");
			
			//滚动图--四条
			List<AppBannerInfoPO> bannerlist = this.appBannerInfoService.findAppBannerListForType(StageStatus.备孕期.getValue());
			respMap.put("bannerlist", bannerlist);
			
			//政策信息--全部
			List<AppExpertGuidancePO> expertGuidanceList = this.appExpertGuidanceService.findAppExpertGuidanceListByClassification(StageStatus.备孕期.getValue());
			respMap.put("expertGuidanceList", expertGuidanceList);
			
			//会员登录情况
			if (!StringUtil.isNullOrBlank(memberId)) {
				//备孕期基本信息
				AppPreparationBasicInfoPO basicInfo = this.appPreparationBasicInfoService.findAppPreparationBasicInfoByMbrId(memberId);
				respMap.put("basicInfo", basicInfo);
				
				//备孕期体重信息
				AppPreparationWeightRecordPO weightInfo = this.appPreparationWeightRecordService.findAppPreparationWeightRecordInfoByMbrId(memberId);
				respMap.put("weightInfo", weightInfo);
				
				//备孕期体温信息
				AppPreparationTemperatureRecordPO temperatureInfo = this.appPreparationTemperatureRecordService.findAppPreparationTemperatureRecordInfoByMbrId(memberId);
				respMap.put("temperatureInfo", temperatureInfo);
				
				//最新一条医院通知
				AppMbrMessageInfoPO msgInfo = this.appMbrMessageInfoService.findAppMbrMessageListByCondition(StringUtil.valueOf(respMap.get("hospitalId")),memberId, MsgSource.医院通知.getValue(), StageStatus.备孕期.getValue());
				respMap.put("msgInfo", msgInfo);
			}
		} catch (Exception e) {	
			loggerPremarital.error("查询备孕期首页信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询备孕期首页信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加备孕期基础信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPremaritalBasicInfo(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPremaritalValidateService.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加数据
			AppPreparationBasicInfoPO basicInfo = new AppPreparationBasicInfoPO();
			basicInfo.setId(IdUtil.uuid());
			basicInfo.setMbrId(mbrId);
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("lastMenses")))) 
				basicInfo.setLastMenses(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("lastMenses"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("period")))) 
				basicInfo.setPeriod(StringUtil.valueOf(reqMap.get("period")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("menstrualCycle")))) 
				basicInfo.setMenstrualCycle(StringUtil.valueOf(reqMap.get("menstrualCycle")));
			basicInfo.setCreateTime(new Date());
			basicInfo.setStatus(ClosedStatus.未结案.getValue());
			this.appPreparationBasicInfoService.create(basicInfo);
			respMap.put("premaritalBasicId", basicInfo.getId());
		} catch (Exception e) {
			loggerPremarital.error("添加备孕期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加备孕期基础信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 修改备孕期基础信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> updatePremaritalBasicInfo(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			String premaritalBasicId = StringUtil.valueOf(reqMap.get("premaritalBasicId"));
			respMap =  this.appPremaritalValidateService.validateUpdatePremaritalBasicInfo(mbrId,premaritalBasicId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//修改备孕期基础信息
			AppPreparationBasicInfoPO basicInfo = (AppPreparationBasicInfoPO) respMap.get("basicInfo");
			basicInfo.setUpdateTime(new Date());
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("lastMenses")))) 
				basicInfo.setLastMenses(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("lastMenses"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("period")))) 
				basicInfo.setPeriod(StringUtil.valueOf(reqMap.get("period")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("menstrualCycle")))) 
				basicInfo.setMenstrualCycle(StringUtil.valueOf(reqMap.get("menstrualCycle")));
			this.appPreparationBasicInfoService.update(basicInfo);
		} catch (Exception e) {
			loggerPremarital.error("修改备孕期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改备孕期基础信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询备孕期基础信息
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPremaritalBasicInfo(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPremaritalValidateService.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询备孕期基础信息 -- 有数据则进入首页（1），没有数据进入基础信息配置页面（0）
			AppPreparationBasicInfoPO basicInfo = this.appPreparationBasicInfoService.findAppPreparationBasicInfoByMbrId(mbrId);
			if (null == basicInfo) {
				respMap.put("status", "0");
			} else {
				respMap.put("status", "1");
			}
		} catch (Exception e) {
			loggerPremarital.error("查询备孕期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询备孕期基础信息异常!",e);
		}
		return respMap;
	}
	
	
	/**
	 * 添加备孕期体重记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPremaritalWeightRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPremaritalValidateService.commonValidatePremarital(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加备孕期体重记录
			AppPreparationWeightRecordPO weightInfo = new AppPreparationWeightRecordPO();
			weightInfo.setId(IdUtil.uuid());
			weightInfo.setMbrId(mbrId);
			weightInfo.setWeight(StringUtil.valueOf(reqMap.get("weight")));
			weightInfo.setHeight(StringUtil.valueOf(reqMap.get("height")));
			weightInfo.setBmi(StringUtil.valueOf(reqMap.get("bmi")));
			weightInfo.setCreateTime(new Date());
			this.appPreparationWeightRecordService.create(weightInfo);
		} catch (Exception e) {
			loggerPremarital.error("添加备孕期体重记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加备孕期体重记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询备孕期体温记录
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPremaritalTemperatureRecord(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPremaritalValidateService.commonValidatePremarital(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询备孕期体温信息列表
			respMap.put("temperatureRecordlist", this.appPreparationTemperatureRecordService.findAppPreparationTemperatureRecordListByMbrId(mbrId));
		} catch (Exception e) {
			loggerPremarital.error("查询备孕期体温记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询备孕期体温记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加备孕期体温记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPremaritalTemperatureRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPremaritalValidateService.commonValidatePremarital(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加备孕期体温记录
			AppPreparationTemperatureRecordPO temInfo = new AppPreparationTemperatureRecordPO();
			temInfo.setId(IdUtil.uuid());
			temInfo.setMbrId(mbrId);
			temInfo.setTemperature(StringUtil.valueOf(reqMap.get("temperature")));
			temInfo.setPeriodSign(StringUtil.valueOf(reqMap.get("periodSign")));
			temInfo.setCreateTime(new Date());
			appPreparationTemperatureRecordService.create(temInfo);
		} catch (Exception e) {
			loggerPremarital.error("添加备孕期体温记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加备孕期体温记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存备孕期其他信息
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePremaritalOtherInfo(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPremaritalValidateService.commonValidatePremarital(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			AppPreparationOtherInfoPO otherInfo = appPreparationOtherInfoService.findAppPreparationOtherInfoByMbrId(mbrId);
			//修改、新增标示，默认为true-修改
			boolean bn = true;
			if (null == otherInfo) {
				bn = false;
				//插入备孕期其他信息
				otherInfo = new AppPreparationOtherInfoPO();
				otherInfo.setId(IdUtil.uuid());
				otherInfo.setMbrId(mbrId);
				otherInfo.setCreateTime(new Date());
			} else {
				bn = true;
				otherInfo.setUpdateTime(new Date());
			}
			
			//公用信息
			otherInfo.setDadAge(StringUtil.valueOf(reqMap.get("dadAge")));
			otherInfo.setMomAge(StringUtil.valueOf(reqMap.get("momAge")));
			otherInfo.setPlanTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("planTime"))));
			otherInfo.setDadHealthy(StringUtil.valueOf(reqMap.get("dadHealthy")));
			otherInfo.setMomHealthy(StringUtil.valueOf(reqMap.get("momHealthy")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("dadHealthyRemark")))) 
				otherInfo.setDadHealthyRemark(StringUtil.valueOf(reqMap.get("dadHealthyRemark")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("momHealthyRemark")))) 
				otherInfo.setMomHealthyRemark(StringUtil.valueOf(reqMap.get("momHealthyRemark")));
			
			if (bn) {
				//修改备孕期其他信息
				appPreparationOtherInfoService.update(otherInfo);
			} else {
				//新增备孕期其他信息
				appPreparationOtherInfoService.create(otherInfo);
			}
		} catch (Exception e) {
			loggerPremarital.error("保存备孕期其他信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存备孕期其他信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询备孕期其他信息
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPremaritalOtherInfo(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPremaritalValidateService.commonValidatePremarital(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询备孕期其他信息
			respMap.put("otherInfo", appPreparationOtherInfoService.findAppPreparationOtherInfoByMbrId(mbrId));
		} catch (Exception e) {
			loggerPremarital.error("查询备孕期其他信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询备孕期其他信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询备孕期妈妈的体重记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPremaritalWeightRecord(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPremaritalValidateService.commonValidatePremarital(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询备孕期妈妈的体重记录
			respMap.put("weightList", this.appPreparationWeightRecordService.findAppPreparationWeightRecordListByMbrId(mbrId));
		} catch (Exception e) {
			loggerPremarital.error("查询备孕期妈妈的体重记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询备孕期妈妈的体重记录异常!",e);
		}
		return respMap;
	}
}
