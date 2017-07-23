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

import com.threefiveninetong.mchh.app.validate.AppPrenatalValidateService;
import com.threefiveninetong.mchh.appConfig.service.AppBannerInfoService;
import com.threefiveninetong.mchh.appConfig.service.AppExpertGuidanceService;
import com.threefiveninetong.mchh.appMember.service.AppMbrMessageInfoService;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalBasicInfoPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalFetalMovementRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalLectureRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordSpecialPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalWeightRecordPO;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalBasicInfoService;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalFetalMovementRecordService;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalLectureRecordService;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalSelfRecordService;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalSelfRecordSpecialService;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalWeightRecordService;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.ClosedStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.LightStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.MsgSource;
import com.threefiveninetong.mchh.util.DictionaryForApi.StageStatus;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppPrenatalHandleService {
	
	//孕产期逻辑处理日志
	public static Logger loggerPrenatal = LoggerFactory.getLogger("filePrenatal");
	
	@Value("${sys.uploadServer.url}")
    private String uploadServerUrl;//图片服务器
	
	@Value("${sys.upload.path.advertImages.file}")
    private String advertImagesFile;//广告图片
	
	@Resource
	private AppPrenatalValidateService appPrenatalValidateService;
	
	@Resource
	private AppBannerInfoService appBannerInfoService;
	
	@Resource
	private AppExpertGuidanceService appExpertGuidanceService;
	
	@Resource
	private AppPrenatalBasicInfoService appPrenatalBasicInfoService;
	
	@Resource
	private AppPrenatalWeightRecordService appPrenatalWeightRecordService;
	
	@Resource
	private AppPrenatalFetalMovementRecordService appPrenatalFetalMovementRecordService;
	
	@Resource
	private AppMbrMessageInfoService appMbrMessageInfoService;
	
	@Resource
	private AppPrenatalLectureRecordService appPrenatalLectureRecordService;
	
	@Resource
	private AppPrenatalSelfRecordService appPrenatalSelfRecordService;
	
	@Resource
	private AppPrenatalSelfRecordSpecialService appPrenatalSelfRecordSpecialService;
	 
	/**
	 * 查询孕产期首页信息
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPrenatalFirstPageInfo(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPrenatalValidateService.validateSearchPrenatalFirstPageInfo(mbrId, uploadServerUrl, advertImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//图片地址
			respMap.put("serverUrl", uploadServerUrl + "/" + advertImagesFile + "/");
			
			//滚动图--四条
			respMap.put("bannerlist", this.appBannerInfoService.findAppBannerListForType(StageStatus.孕产期.getValue()));
			
			//政策信息--全部
			respMap.put("expertGuidanceList", this.appExpertGuidanceService.findAppExpertGuidanceListByClassification(StageStatus.孕产期.getValue()));
			
			//会员登录情况
			if (!StringUtil.isNullOrBlank(mbrId)) {
				//孕产期基本信息
				respMap.put("basicInfo", this.appPrenatalBasicInfoService.findAppPrenatalBasicInfoByMbrId(mbrId, ClosedStatus.未结案.getValue()));
				
				//孕产期体重信息
				respMap.put("weightInfo", this.appPrenatalWeightRecordService.findAppPrenatalWeightRecordInfoByMbrId(mbrId));
				
				//孕产期胎动信息
				respMap.put("fetalMovementRecordInfo", this.appPrenatalFetalMovementRecordService.findAppPrenatalFetalMovementRecordInfoByMbrId(mbrId));
				
				//孕产期最新一条医院通知
				respMap.put("msgInfo", this.appMbrMessageInfoService.findAppMbrMessageListByCondition(StringUtil.valueOf(respMap.get("hospitalId")),mbrId, MsgSource.医院通知.getValue(), StageStatus.孕产期.getValue()));
			}
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期首页信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期首页信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加孕产期基础信息
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPrenatalBasicInfo(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPrenatalValidateService.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加孕产期基础信息
			AppPrenatalBasicInfoPO basicInfo = new AppPrenatalBasicInfoPO();
			basicInfo.setId(IdUtil.uuid());
			basicInfo.setMbrId(mbrId);
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("lastMenses"))))
				basicInfo.setLastMenses(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("lastMenses"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("predictDate"))))
				basicInfo.setPredictDate(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("predictDate"))));
			basicInfo.setStatus(ClosedStatus.未结案.getValue());
			basicInfo.setCreateTime(new Date());
			appPrenatalBasicInfoService.create(basicInfo);
			respMap.put("prenatalBasicId", basicInfo.getId());
		} catch (Exception e) {
			loggerPrenatal.error("添加孕产期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加孕产期基础信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 修改孕产期基础信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> updatePrenatalBasicInfo(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			String prenatalBasicId = StringUtil.valueOf(reqMap.get("prenatalBasicId"));
			respMap =  this.appPrenatalValidateService.validateUpdatePrenatalBasicInfo(mbrId,prenatalBasicId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//修改备孕期基础信息
			AppPrenatalBasicInfoPO basicInfo = (AppPrenatalBasicInfoPO) respMap.get("basicInfo");
			basicInfo.setUpdateTime(new Date());
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("lastMenses"))))
				basicInfo.setLastMenses(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("lastMenses"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("predictDate")))) 
				basicInfo.setPredictDate(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("predictDate"))));
			this.appPrenatalBasicInfoService.update(basicInfo);
		} catch (Exception e) {
			loggerPrenatal.error("修改孕产期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改孕产期基础信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询孕产期基础信息
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPrenatalBasicInfo(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPrenatalValidateService.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询孕产期基础信息-- 有数据则进入首页（1），没有数据进入基础信息配置页面（0）
			AppPrenatalBasicInfoPO basicInfo = this.appPrenatalBasicInfoService.findAppPrenatalBasicInfoByMbrId(mbrId, ClosedStatus.未结案.getValue());
			if (null == basicInfo) {
				respMap.put("status", 0);
			} else {
				respMap.put("status", 1);
			}
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期基础信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加孕产期体重记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPrenatalWeightRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加孕产期体重记录
			AppPrenatalWeightRecordPO weightInfo = new AppPrenatalWeightRecordPO();
			weightInfo.setId(IdUtil.uuid());
			weightInfo.setMbrId(mbrId);
			weightInfo.setWeight(StringUtil.valueOf(reqMap.get("weight")));
			weightInfo.setPrenatalBmi(StringUtil.valueOf(reqMap.get("prenatalBmi")));
			weightInfo.setWeightGain(StringUtil.valueOf(reqMap.get("weightGain")));
			weightInfo.setCreateTime(new Date());
			this.appPrenatalWeightRecordService.create(weightInfo);
		} catch (Exception e) {
			loggerPrenatal.error("添加孕产期体重记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加孕产期体重记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加孕产期胎动记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPrenatalFetalMovementRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加孕产期胎动记录
			AppPrenatalFetalMovementRecordPO fetalMovementRecordInfo = new AppPrenatalFetalMovementRecordPO();
			fetalMovementRecordInfo.setId(IdUtil.uuid());
			fetalMovementRecordInfo.setMbrId(mbrId);
			fetalMovementRecordInfo.setMoveNum(StringUtil.valueOf(reqMap.get("moveNum")));
			fetalMovementRecordInfo.setCreateTime(new Date());
			this.appPrenatalFetalMovementRecordService.create(fetalMovementRecordInfo);
		} catch (Exception e) {
			loggerPrenatal.error("添加孕产期胎动记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加孕产期胎动记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加孕产期孕妇学校听课记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPrenatalLectureRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加孕产期孕妇学校听课记录
			AppPrenatalLectureRecordPO lectureInfo = new AppPrenatalLectureRecordPO();
			lectureInfo.setId(IdUtil.uuid());
			lectureInfo.setMbrId(mbrId);
			lectureInfo.setSubjects(StringUtil.valueOf(reqMap.get("subjects")));
			lectureInfo.setContent(StringUtil.valueOf(reqMap.get("content")));
			lectureInfo.setLectureTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("lectureTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("remark")))) 
				lectureInfo.setRemark(StringUtil.valueOf(reqMap.get("remark")));
			lectureInfo.setCreateTime(new Date());
			appPrenatalLectureRecordService.create(lectureInfo);
		} catch (Exception e) {
			loggerPrenatal.error("添加孕产期孕妇学校听课记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加孕产期孕妇学校听课记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询孕产期其他信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPrenatalSelfRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//孕产期自我记录表
			AppPrenatalSelfRecordPO selfRecordInfo = appPrenatalSelfRecordService.findAppPrenatalSelfRecordInfoByMbrId(mbrId, StringUtil.valueOf(reqMap.get("period")));
			respMap.put("selfRecordInfo", selfRecordInfo);
			if (null != selfRecordInfo) {
				//孕产自我记录特殊情况表
				respMap.put("lightList", this.appPrenatalSelfRecordSpecialService.findAppPrenatalSelfRecordSpecialListByFatId(selfRecordInfo.getId(), LightStatus.点亮.getValue()));
			}
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期其他信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期其他信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存孕产期其他信息记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePrenatalSelfRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//孕产期自我记录表
			AppPrenatalSelfRecordPO selfRecordInfo = appPrenatalSelfRecordService.findAppPrenatalSelfRecordInfoByMbrId(mbrId, StringUtil.valueOf(reqMap.get("period")));
			//新增或修改标示 默认true -- 修改
			boolean bn = true;
			if (null == selfRecordInfo) {
				bn = false;
				//新增
				selfRecordInfo = new AppPrenatalSelfRecordPO();
				selfRecordInfo.setId(IdUtil.uuid());
				selfRecordInfo.setMbrId(mbrId);
				selfRecordInfo.setCreateTime(new Date());
			} else {
				//修改
				bn = true;
				selfRecordInfo.setUpdateTime(new Date());
			}
			
			selfRecordInfo.setPeriod(StringUtil.valueOf(reqMap.get("period")));
			if(!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("lastMenses"))))
				selfRecordInfo.setLastMenses(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("lastMenses"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("predictDate")))) 
				selfRecordInfo.setPredictDate(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("predictDate"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("firstMoveDate")))) 
				selfRecordInfo.setFirstMoveDate(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("firstMoveDate"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("bExaDate")))) 
				selfRecordInfo.setBExaDate(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("bExaDate"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("testMoveSign")))) 
				selfRecordInfo.setTestMoveSign(StringUtil.valueOf(reqMap.get("testMoveSign")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("growthRange")))) 
				selfRecordInfo.setGrowthRange(StringUtil.valueOf(reqMap.get("growthRange")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("riskSign")))) 
				selfRecordInfo.setRiskSign(StringUtil.valueOf(reqMap.get("riskSign")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("riskRemark"))))
				selfRecordInfo.setRiskRemark(StringUtil.valueOf(reqMap.get("riskRemark")));
			
			List<String> symptonList = (List<String>) reqMap.get("specialList");
			if (bn) {
				appPrenatalSelfRecordService.update(selfRecordInfo);
				//将所有已点亮记录熄灭
				appPrenatalSelfRecordSpecialService.updateSign(selfRecordInfo.getId());
			} else {
				appPrenatalSelfRecordService.create(selfRecordInfo);
			}
			
			if (!CollectionUtil.isNullOrEmpty(symptonList)) {
				AppPrenatalSelfRecordSpecialPO srs = null;
				for (String str : symptonList) {
					srs = new AppPrenatalSelfRecordSpecialPO();
					srs.setId(IdUtil.uuid());
					srs.setFatId(selfRecordInfo.getId());
					srs.setSymptom(str);
					srs.setSign(LightStatus.点亮.getValue());
					srs.setCreateTime(new Date());
					appPrenatalSelfRecordSpecialService.create(srs);
				}
			}
		} catch (Exception e) {
			loggerPrenatal.error("保存孕产期其他信息记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存孕产期其他信息记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询孕产期妈妈的体重记录
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPrenatalWeightRecord(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询孕产期妈妈的体重记录
			respMap.put("weightList", this.appPrenatalWeightRecordService.findAppPrenatalWeightRecordListByMbrId(mbrId));
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期妈妈的体重记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期妈妈的体重记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询孕产期胎动记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPrenatalFetalMovementRecord(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询孕产期胎动记录
			respMap.put("fetalMovementList", this.appPrenatalFetalMovementRecordService.findAppPrenatalFetalMovementRecordListByMbrId(mbrId));
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期胎动记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期胎动记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询孕产期妈妈听课记录
	 * @param mbrId
	 * @return
	 */
	public Map<String,Object> searchPrenatalLectureRecord(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPrenatalValidateService.commonValidatePrenatal(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询孕产期妈妈听课记录
			respMap.put("lectureList", this.appPrenatalLectureRecordService.findAppPrenatalLectureRecordListByMbrId(mbrId));
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期妈妈听课记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期妈妈听课记录异常!",e);
		}
		return respMap;
	}
}
