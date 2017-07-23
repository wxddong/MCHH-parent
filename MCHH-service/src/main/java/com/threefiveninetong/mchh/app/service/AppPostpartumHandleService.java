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

import com.threefiveninetong.mchh.app.validate.AppPostpartumValidateService;
import com.threefiveninetong.mchh.appConfig.service.AppBannerInfoService;
import com.threefiveninetong.mchh.appConfig.service.AppExpertGuidanceService;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMbrMessageInfoService;
import com.threefiveninetong.mchh.appPostpartum.po.AppBabyBasicInfoPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyDentitionRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingBabyGrowRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEarlyStageDetailsPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEarlyStageRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingEightMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFiveYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingFourYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingMomWeightRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingOneYearSixRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingSixYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingThreeMonthRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingThreeYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingTwoYearSixRecordPO;
import com.threefiveninetong.mchh.appPostpartum.po.AppParentingVaccineRecordPO;
import com.threefiveninetong.mchh.appPostpartum.service.AppBabyBasicInfoService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingBabyDentitionRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingBabyGrowRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingEarlyStageDetailsService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingEarlyStageRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingEightMonthRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingFiveYearRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingFourYearRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingMomWeightRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingOneMonthRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingOneYearRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingOneYearSixRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingSixMonthRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingSixYearRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingThreeMonthRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingThreeYearRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingTwoYearRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingTwoYearSixRecordService;
import com.threefiveninetong.mchh.appPostpartum.service.AppParentingVaccineRecordService;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.ClosedStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.MsgSource;
import com.threefiveninetong.mchh.util.DictionaryForApi.PostpartumAge;
import com.threefiveninetong.mchh.util.DictionaryForApi.StageStatus;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppPostpartumHandleService {
	
	//育儿期逻辑处理日志
	public static Logger loggerPostpartum = LoggerFactory.getLogger("filePostpartum");
	
	@Value("${sys.uploadServer.url}")
    private String uploadServerUrl;//图片服务器
	
	@Value("${sys.upload.path.advertImages.file}")
    private String advertImagesFile;//广告图片
	
	@Resource
	private AppPostpartumValidateService appPostpartumValidateService;
	
	@Resource
	private AppBannerInfoService appBannerInfoService;
	
	@Resource
	private AppExpertGuidanceService appExpertGuidanceService;
	
	@Resource
	private AppMbrMessageInfoService appMbrMessageInfoService;
	
	@Resource
	private AppBabyBasicInfoService appBabyBasicInfoService;
	
	@Resource
	private AppParentingMomWeightRecordService appParentingMomWeightRecordService;
	
	@Resource
	private AppParentingBabyGrowRecordService appParentingBabyGrowRecordService;
	
	@Resource
	private AppParentingBabyDentitionRecordService appParentingBabyDentitionRecordService;
	
	@Resource
	private AppParentingVaccineRecordService appParentingVaccineRecordService;
	
	@Resource
	private AppParentingEarlyStageRecordService appParentingEarlyStageRecordService;
	
	@Resource
	private AppParentingEarlyStageDetailsService appParentingEarlyStageDetailsService;
	
	@Resource
	private AppParentingOneMonthRecordService appParentingOneMonthRecordService;
	
	@Resource
	private AppParentingThreeMonthRecordService appParentingThreeMonthRecordService;
	
	@Resource
	private AppParentingSixMonthRecordService appParentingSixMonthRecordService;
	
	@Resource
	private AppParentingEightMonthRecordService appParentingEightMonthRecordService;
	
	@Resource
	private AppParentingOneYearRecordService appParentingOneYearRecordService;
	
	@Resource
	private AppParentingOneYearSixRecordService appParentingOneYearSixRecordService;
	
	@Resource
	private AppParentingTwoYearRecordService appParentingTwoYearRecordService;
	
	@Resource
	private AppParentingTwoYearSixRecordService appParentingTwoYearSixRecordService;
	
	@Resource
	private AppParentingThreeYearRecordService appParentingThreeYearRecordService;
	
	@Resource
	private AppParentingFourYearRecordService appParentingFourYearRecordService;
	
	@Resource
	private AppParentingFiveYearRecordService appParentingFiveYearRecordService;
	
	@Resource
	private AppParentingSixYearRecordService appParentingSixYearRecordService;
	
	/**
	 * 查询育儿期首页信息
	 * @param request
	 * @return
	 */
	public Map<String,Object> searchPostpartumFirstPageInfo(String mbrId,String babyInfoId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPostpartumValidateService.validateSearchPostpartumFirstPageInfo(mbrId,babyInfoId, uploadServerUrl, advertImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//图片地址
			respMap.put("serverUrl", uploadServerUrl + "/" + advertImagesFile + "/");
			
			//滚动图--四条
			respMap.put("bannerlist", this.appBannerInfoService.findAppBannerListForType(StageStatus.育儿期.getValue()));
			
			//政策信息--全部
			respMap.put("expertGuidanceList", this.appExpertGuidanceService.findAppExpertGuidanceListByClassification(StageStatus.育儿期.getValue()));
			
			//会员登录情况
			if (!StringUtil.isNullOrBlank(babyInfoId) && !StringUtil.isNullOrBlank(mbrId)) {
				//育儿期基本信息
				respMap.put("basicInfo", (AppBabyBasicInfoPO) respMap.get("babyInfo"));
				
				//育儿期妈妈体重信息
				respMap.put("momWeightInfo", this.appParentingMomWeightRecordService.findAppParentingMomWeightRecordInfoByMbrId(mbrId));
				
				//育儿期最新一条医院通知
				respMap.put("msgInfo", this.appMbrMessageInfoService.findAppMbrMessageListByCondition(StringUtil.valueOf(respMap.get("hospitalId")),mbrId, MsgSource.医院通知.getValue(), StageStatus.育儿期.getValue()));
			}
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期首页信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期首页信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加育儿期宝宝基础信息--单个增加
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public String addPostpartumBabyBasicInfo(String mbrId,Map<String,Object> reqMap) {
		try {
			AppBabyBasicInfoPO babyInfo = new AppBabyBasicInfoPO();
			babyInfo.setId(IdUtil.uuid());
		    babyInfo.setMbrId(mbrId);
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthday")))) 
				babyInfo.setBirthday(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("birthday"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("name")))) 
				babyInfo.setName(StringUtil.valueOf(reqMap.get("name")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sex")))) 
				babyInfo.setSex(StringUtil.valueOf(reqMap.get("sex")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthTime")))) 
				babyInfo.setBirthTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("birthTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("height")))) 
				babyInfo.setLength(StringUtil.valueOf(reqMap.get("height")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("weight")))) 
				babyInfo.setWeight(StringUtil.valueOf(reqMap.get("weight")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthGesWeeks")))) 
				babyInfo.setBirthGesWeeks(StringUtil.valueOf(reqMap.get("birthGesWeeks")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthPlace")))) 
				babyInfo.setBirthPlace(StringUtil.valueOf(reqMap.get("birthPlace")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("deliveryMec")))) 
				babyInfo.setDeliveryMec(StringUtil.valueOf(reqMap.get("deliveryMec")));
			babyInfo.setStatus(ClosedStatus.未结案.getValue());
			babyInfo.setCreateTime(new Date());
			this.appBabyBasicInfoService.create(babyInfo);
			return babyInfo.getId();
		} catch (Exception e) {
			loggerPostpartum.error("添加育儿期宝宝基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加育儿期宝宝基础信息异常!",e);
		}
	}
	
	/**
	 * 查询育儿期基础信息
	 * @param mbrId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPostpartumBabyBasicInfo(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPostpartumValidateService.commonValidateMbrStatus(MapUtil.getResultSuccess(), mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			//会员信息
			AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
			String parId = StringUtil.valueOf(mbrInfo.getParId());
			if (StringUtil.isNullOrBlank(parId) || null == this.appBabyBasicInfoService.find(parId)) {
				respMap.put("status", "0");
			} else {
				respMap.put("status", "1");
				respMap.put("parId", parId);
			}
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期基础信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期基础信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期宝宝信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPostpartumBabyList(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appPostpartumValidateService.commonValidateMbrStatus(MapUtil.getResultSuccess(), mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			//宝宝信息
			respMap.put("babyList", this.appBabyBasicInfoService.findAppBabyBasicListByMbrId(mbrId, ClosedStatus.未结案.getValue()));
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期宝宝信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期宝宝信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 修改育儿期宝宝信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> updatePostpartumBabyBasicInfo(String mbrId,Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//宝宝ID
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			//验证过程--用户需要处于育儿期
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			AppBabyBasicInfoPO basicInfo =  (AppBabyBasicInfoPO) respMap.get("babyInfo");
			//修改宝宝信息
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthday")))) 
				basicInfo.setBirthday(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("birthday"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("name")))) 
				basicInfo.setName(StringUtil.valueOf(reqMap.get("name")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sex")))) 
				basicInfo.setSex(StringUtil.valueOf(reqMap.get("sex")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthTime")))) 
				basicInfo.setBirthTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("birthTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("height")))) 
				basicInfo.setLength(StringUtil.valueOf(reqMap.get("height")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("weight")))) 
				basicInfo.setWeight(StringUtil.valueOf(reqMap.get("weight")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthGesWeeks")))) 
				basicInfo.setBirthGesWeeks(StringUtil.valueOf(reqMap.get("birthGesWeeks")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthPlace")))) 
				basicInfo.setBirthPlace(StringUtil.valueOf(reqMap.get("birthPlace")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("deliveryMec")))) 
				basicInfo.setDeliveryMec(StringUtil.valueOf(reqMap.get("deliveryMec")));
			basicInfo.setUpdateTime(new Date());
			this.appBabyBasicInfoService.update(basicInfo);
		} catch (Exception e) {
			loggerPostpartum.error("修改育儿期宝宝信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改育儿期宝宝信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加育儿期妈妈体重记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPostpartumMomWeightRecord(Map<String,Object> request) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(request.get("memberId"));
			String babyInfoId = StringUtil.valueOf(request.get("babyInfoId"));
			respMap =  this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加妈妈体重信息
			AppParentingMomWeightRecordPO momWeightInfo = new AppParentingMomWeightRecordPO();
			momWeightInfo.setId(IdUtil.uuid());
			momWeightInfo.setMbrId(mbrId);
			momWeightInfo.setPreBmi(StringUtil.valueOf(request.get("prenatalBmi")));
			momWeightInfo.setWeight(StringUtil.valueOf(request.get("weight")));
			momWeightInfo.setHeight(StringUtil.valueOf(request.get("height")));
			momWeightInfo.setBmi(StringUtil.valueOf(request.get("bmi")));
			momWeightInfo.setCreateTime(new Date());
			this.appParentingMomWeightRecordService.create(momWeightInfo);
		} catch (Exception e) {
			loggerPostpartum.error("添加育儿期妈妈体重记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加育儿期妈妈体重记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加育儿期宝宝生长记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPostpartumBabyGrowRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			respMap =  this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, true);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//添加育儿期宝宝生长记录
			AppParentingBabyGrowRecordPO babyGrowInfo = new AppParentingBabyGrowRecordPO();
			babyGrowInfo.setId(IdUtil.uuid());
			babyGrowInfo.setParId(babyInfoId);
			babyGrowInfo.setHeight(StringUtil.valueOf(reqMap.get("height")));
			babyGrowInfo.setWeight(StringUtil.valueOf(reqMap.get("weight")));
			babyGrowInfo.setCreateTime(new Date());
			appParentingBabyGrowRecordService.create(babyGrowInfo);
		} catch (Exception e) {
			loggerPostpartum.error("添加育儿期宝宝生长记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加育儿期宝宝生长记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期宝宝生长记录
	 * @param request
	 * @return   
	 */
	@Transactional
	public Map<String,Object> searchPostpartumBabyGrowRecord(String mbrId,String babyInfoId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期宝宝生长记录
			respMap.put("babyGrowList", appParentingBabyGrowRecordService.findAppParentingBabyGrowRecordListByParId(babyInfoId));
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期宝宝生长记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期宝宝生长记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期宝宝牙齿生长记录
	 * @param reqList
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumBabyDentitionRecord(String mbrId,String babyInfoId,List<Map<String,Object>> reqList) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//保存数据
			if (CollectionUtil.isNullOrEmpty(reqList)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "宝宝牙齿生长记录数据不能为空!");
				return respMap;
			}
			
			//宝宝牙齿ID
			String babyToochGrowId = null;
			//新增或修改  默认true-修改
			boolean bn;
			AppParentingBabyDentitionRecordPO  babyInfo = null;
			for (Map<String,Object> reqMap : reqList) {
				babyToochGrowId = StringUtil.valueOf(reqMap.get("babyToochGrowId"));
				bn = true;
				if (StringUtil.isNullOrBlank(babyToochGrowId)) {
					bn = false;
					//新增牙齿信息
					babyInfo = new AppParentingBabyDentitionRecordPO();
					babyInfo.setId(IdUtil.uuid());
					babyInfo.setParId(babyInfoId);
					babyInfo.setCreateTime(new Date());
				}
				else {
					bn = true;
					//修改牙齿信息
//					babyInfo = this.appParentingBabyDentitionRecordService.findAppParentingBabyDentitionRecordInfoByParIdAndPos(babyInfoId, StringUtil.valueOf(reqMap.get("position")));
					babyInfo = this.appParentingBabyDentitionRecordService.find(babyToochGrowId);
					if (null == babyInfo) {
						respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
						respMap.put("message", "育儿期宝宝牙齿信息不存在!");
						return respMap;
					}
					babyInfo.setUpdateTime(new Date());
				}
				
				if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("position"))))
					babyInfo.setPosition(StringUtil.valueOf(reqMap.get("position")));
				if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("toothingDate")))) 
					babyInfo.setToothingDate(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("toothingDate"))));
				
				if (bn) {
					appParentingBabyDentitionRecordService.update(babyInfo);
				} else {
					appParentingBabyDentitionRecordService.create(babyInfo);
				}
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期宝宝牙齿生长记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期宝宝牙齿生长记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期宝宝牙齿生长记录
	 * @param babyInfoId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPostpartumBabyDentitionRecord(String mbrId,String babyInfoId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期宝宝牙齿生长记录
			respMap.put("babyToochGrowList", appParentingBabyDentitionRecordService.findAppParentingBabyDentitionRecordListByParId(babyInfoId));
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期宝宝牙齿生长记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期宝宝牙齿生长记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 添加育儿期宝宝疫苗接种记录
	 * @param babyInfoId
	 * @param vaccineList
	 * @return
	 */
	@Transactional
	public Map<String,Object> addPostpartumVaccineRecord(String mbrId,String babyInfoId,List<String> vaccineList) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			if (CollectionUtil.isNullOrEmpty(vaccineList)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "育儿期宝宝疫苗接种记录数据不能为空!");
				return respMap;
			}
			
			//添加育儿期宝宝疫苗接种记录
			AppParentingVaccineRecordPO vaccine = null;
			for (String str : vaccineList) {
				vaccine = new AppParentingVaccineRecordPO();
				vaccine.setId(IdUtil.uuid());
				vaccine.setParId(babyInfoId);
				vaccine.setVaccineType(str);
				vaccine.setCreateTime(new Date());
				appParentingVaccineRecordService.create(vaccine);
			}
		} catch (Exception e) {
			loggerPostpartum.error("添加育儿期宝宝疫苗接种记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"添加育儿期宝宝疫苗接种记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期宝宝疫苗接种记录
	 * @param request
	 * @return
	 */
	public Map<String,Object> searchPostpartumVaccineRecord(String mbrId,String babyInfoId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期宝宝牙齿生长记录
			respMap.put("vaccineList", appParentingVaccineRecordService.findAppParentingVaccineRecordListByParId(babyInfoId));
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期宝宝牙齿生长记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期宝宝牙齿生长记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期新生儿早期记录
	 * @param 
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumEarlyStageRecord(String mbrId,String babyInfoId,String diseaseScreening,String hearingScreening,Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//育儿期新生儿早期记录新增或修改标示 默认true-修改
			boolean bn = true;
			AppParentingEarlyStageRecordPO earlyStage = appParentingEarlyStageRecordService.findAppParentingEarlyStageRecordInfoByParId(babyInfoId);
			if (null == earlyStage) {
				bn = false;
				earlyStage = new AppParentingEarlyStageRecordPO();
				earlyStage.setId(IdUtil.uuid());
				earlyStage.setParId(babyInfoId);
				earlyStage.setCreateTime(new Date());
			} else {
				if (!earlyStage.getDiseaseScreening().equals(diseaseScreening) || !earlyStage.getHearingScreening().equals(hearingScreening)) {
					bn = true;
					earlyStage.setUpdateTime(new Date());
				}
			}
			
			earlyStage.setDiseaseScreening(diseaseScreening);
			earlyStage.setHearingScreening(hearingScreening);
			if (!bn) {
				appParentingEarlyStageRecordService.create(earlyStage);
			} else {
				appParentingEarlyStageRecordService.update(earlyStage);
			}
			
			//新生儿早期记录详情表
			AppParentingEarlyStageDetailsPO earlyStageDeatail = new AppParentingEarlyStageDetailsPO();
			earlyStageDeatail.setId(IdUtil.uuid());
			earlyStageDeatail.setEarlyId(earlyStage.getId());
			earlyStageDeatail.setCreateTime(new Date());
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("birthDays")))) 
				earlyStageDeatail.setBirthDays(StringUtil.valueOf(reqMap.get("birthDays")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("feedingMode"))))
				earlyStageDeatail.setFeedingMode(StringUtil.valueOf(reqMap.get("feedingMode")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("milkNum"))))
				earlyStageDeatail.setMilkNum(StringUtil.valueOf(reqMap.get("milkNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("urineNum")))) 
				earlyStageDeatail.setUrineNum(StringUtil.valueOf(reqMap.get("urineNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("shitNum")))) 
				earlyStageDeatail.setShitNum(StringUtil.valueOf(reqMap.get("shitNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("weight"))))
				earlyStageDeatail.setWeight(StringUtil.valueOf(reqMap.get("weight")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("jaundice")))) 
				earlyStageDeatail.setJaundice(StringUtil.valueOf(reqMap.get("jaundice")));
			appParentingEarlyStageDetailsService.create(earlyStageDeatail);
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期新生儿早期记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期新生儿早期记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期新生儿早期记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPostpartumEarlyStageRecord(String mbrId,String babyInfoId,String type) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期新生儿早期记录
			AppParentingEarlyStageRecordPO earlyStageInfo = appParentingEarlyStageRecordService.findAppParentingEarlyStageRecordInfoByParId(babyInfoId);
			respMap.put("earlyStageInfo", earlyStageInfo);
			
			if (type.equals("1")) {
				if (null != earlyStageInfo && !StringUtil.isNullOrBlank(earlyStageInfo.getId())) 
					respMap.put("earlyStageDetailsList", appParentingEarlyStageDetailsService.findAppParentingEarlyStageDetailsListByEarlyId(earlyStageInfo.getId()));
			}
			
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期新生儿早期记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期新生儿早期记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期妈妈的体重记录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPostpartumWeightRecord(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期妈妈的体重记录
			respMap.put("momWeightList", this.appParentingMomWeightRecordService.findAppParentingMomWeightRecordListByMbrId(mbrId));
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期妈妈的体重记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期妈妈的体重记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期一月龄记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumOneMonthRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期一月龄记录
			AppParentingOneMonthRecordPO oneMonthInfo = appParentingOneMonthRecordService.findAppParentingOneMonthRecordInfoByParId(babyInfoId);
			
			//保存育儿期一月龄记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == oneMonthInfo) {
				bn = false;
				oneMonthInfo = new AppParentingOneMonthRecordPO();
				oneMonthInfo.setId(IdUtil.uuid());
				oneMonthInfo.setParId(babyInfoId);
				oneMonthInfo.setCreateTime(new Date());
			} else {
				bn = true;
				oneMonthInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("umbilicalTime")))) 
				oneMonthInfo.setUmbilicalTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("umbilicalTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("jaundiceFadeTime"))))
				oneMonthInfo.setJaundiceFadeTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("jaundiceFadeTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("feedingMode")))) 
				oneMonthInfo.setFeedingMode(StringUtil.valueOf(reqMap.get("feedingMode")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("feedingSituation")))) 
				oneMonthInfo.setFeedingSituation(StringUtil.valueOf(reqMap.get("feedingSituation")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("frightCry")))) 
				oneMonthInfo.setFrightCry(StringUtil.valueOf(reqMap.get("frightCry")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("crying"))))
				oneMonthInfo.setCrying(StringUtil.valueOf(reqMap.get("crying")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("vSupplement")))) 
				oneMonthInfo.setVSupplement(StringUtil.valueOf(reqMap.get("vSupplement")));
			
			if (bn) {
				appParentingOneMonthRecordService.update(oneMonthInfo);
			} else {
				appParentingOneMonthRecordService.create(oneMonthInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期一月龄记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期一月龄记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期三月龄记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumThreeMonthRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期三月龄记录
			AppParentingThreeMonthRecordPO threeMonthInfo = appParentingThreeMonthRecordService.findAppParentingThreeMonthRecordInfoByParId(babyInfoId);
			
			//保存育儿期三月龄记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == threeMonthInfo) {
				bn = false;
				threeMonthInfo = new AppParentingThreeMonthRecordPO();
				threeMonthInfo.setId(IdUtil.uuid());
				threeMonthInfo.setParId(babyInfoId);
				threeMonthInfo.setCreateTime(new Date());
			} else {
				bn = true;
				threeMonthInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("outdoorsDuration")))) 
				threeMonthInfo.setOutdoorsDuration(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("outdoorsDuration"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("feedingMode")))) 
				threeMonthInfo.setFeedingMode(StringUtil.valueOf(reqMap.get("feedingMode")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("feedingSituation")))) 
				threeMonthInfo.setFeedingSituation(StringUtil.valueOf(reqMap.get("feedingSituation")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("talkBaby"))))
				threeMonthInfo.setTalkBaby(StringUtil.valueOf(reqMap.get("talkBaby")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("vSupplement")))) 
				threeMonthInfo.setVSupplement(StringUtil.valueOf(reqMap.get("vSupplement")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("loudReaction")))) 
				threeMonthInfo.setLoudReaction(StringUtil.valueOf(reqMap.get("loudReaction")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("teasingSmile")))) 
				threeMonthInfo.setTeasingSmile(StringUtil.valueOf(reqMap.get("teasingSmile")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("gazeTracking")))) 
				threeMonthInfo.setGazeTracking(StringUtil.valueOf(reqMap.get("gazeTracking")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("riseProne")))) 
				threeMonthInfo.setRiseProne(StringUtil.valueOf(reqMap.get("riseProne")));
			
			if (bn) {
				appParentingThreeMonthRecordService.update(threeMonthInfo);
			} else {
				appParentingThreeMonthRecordService.create(threeMonthInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期三月龄记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期三月龄记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期六月龄记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumSixMonthRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期六月龄记录
			AppParentingSixMonthRecordPO sixMonthInfo = appParentingSixMonthRecordService.findAppParentingSixMonthRecordInfoByParId(babyInfoId);
			
			//保存育儿期六月龄记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == sixMonthInfo) {
				bn = false;
				sixMonthInfo = new AppParentingSixMonthRecordPO();
				sixMonthInfo.setId(IdUtil.uuid());
				sixMonthInfo.setParId(babyInfoId);
				sixMonthInfo.setCreateTime(new Date());
			} else {
				bn = true;
				sixMonthInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("addFoodTime")))) 
				sixMonthInfo.setAddFoodTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("addFoodTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("turnOverTime")))) 
				sixMonthInfo.setTurnOverTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("turnOverTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("toysNum")))) 
				sixMonthInfo.setToysNum(StringUtil.valueOf(reqMap.get("toysNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("babyPlay"))))
				sixMonthInfo.setBabyPlay(StringUtil.valueOf(reqMap.get("babyPlay")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("soundLaugh")))) 
				sixMonthInfo.setSoundLaugh(StringUtil.valueOf(reqMap.get("soundLaugh")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("handGrab")))) 
				sixMonthInfo.setHandGrab(StringUtil.valueOf(reqMap.get("handGrab")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("clenchFist")))) 
				sixMonthInfo.setClenchFist(StringUtil.valueOf(reqMap.get("clenchFist")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sit")))) 
				sixMonthInfo.setSit(StringUtil.valueOf(reqMap.get("sit")));
			
			if (bn) {
				appParentingSixMonthRecordService.update(sixMonthInfo);
			} else {
				appParentingSixMonthRecordService.create(sixMonthInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期六月龄记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期六月龄记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期八月龄记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumEightMonthRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期八月龄记录
			AppParentingEightMonthRecordPO eightMonthInfo = appParentingEightMonthRecordService.findAppParentingEightMonthRecordInfoByParId(babyInfoId);
			
			//保存育儿期八月龄记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == eightMonthInfo) {
				bn = false;
				eightMonthInfo = new AppParentingEightMonthRecordPO();
				eightMonthInfo.setId(IdUtil.uuid());
				eightMonthInfo.setParId(babyInfoId);
				eightMonthInfo.setCreateTime(new Date());
			} else {
				bn = true;
				eightMonthInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("addMeatTime")))) 
				eightMonthInfo.setAddMeatTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("addMeatTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("addEggTime")))) 
				eightMonthInfo.setAddEggTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("addEggTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("firstToothTime")))) 
				eightMonthInfo.setFirstToothTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("firstToothTime"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("hideAndSeek")))) 
				eightMonthInfo.setHideAndSeek(StringUtil.valueOf(reqMap.get("hideAndSeek")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("soundAnswer"))))
				eightMonthInfo.setSoundAnswer(StringUtil.valueOf(reqMap.get("soundAnswer")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("distinguishPeople")))) 
				eightMonthInfo.setDistinguishPeople(StringUtil.valueOf(reqMap.get("distinguishPeople")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("bothHandsToys")))) 
				eightMonthInfo.setBothHandsToys(StringUtil.valueOf(reqMap.get("bothHandsToys")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sitAlone")))) 
				eightMonthInfo.setSitAlone(StringUtil.valueOf(reqMap.get("sitAlone")));
			
			if (bn) {
				appParentingEightMonthRecordService.update(eightMonthInfo);
			} else {
				appParentingEightMonthRecordService.create(eightMonthInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期八月龄记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期八月龄记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期一岁记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumOneYearRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期一岁记录
			AppParentingOneYearRecordPO oneYearInfo = appParentingOneYearRecordService.findAppParentingOneYearRecordInfoByParId(babyInfoId);
			
			//保存育儿期一岁记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == oneYearInfo) {
				bn = false;
				oneYearInfo = new AppParentingOneYearRecordPO();
				oneYearInfo.setId(IdUtil.uuid());
				oneYearInfo.setParId(babyInfoId);
				oneYearInfo.setCreateTime(new Date());
			} else {
				bn = true;
				oneYearInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("mealNum")))) 
				oneYearInfo.setMealNum(StringUtil.valueOf(reqMap.get("mealNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("toothNum"))))
				oneYearInfo.setToothNum(StringUtil.valueOf(reqMap.get("toothNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("mealSituation")))) 
				oneYearInfo.setMealSituation(StringUtil.valueOf(reqMap.get("mealSituation")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("breastMilk")))) 
				oneYearInfo.setBreastMilk(StringUtil.valueOf(reqMap.get("breastMilk")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("nameReaction")))) 
				oneYearInfo.setNameReaction(StringUtil.valueOf(reqMap.get("nameReaction")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("imitate")))) 
				oneYearInfo.setImitate(StringUtil.valueOf(reqMap.get("imitate")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("pinchThing")))) 
				oneYearInfo.setPinchThing(StringUtil.valueOf(reqMap.get("pinchThing")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("standingUp")))) 
				oneYearInfo.setStandingUp(StringUtil.valueOf(reqMap.get("standingUp")));
			
			if (bn) {
				appParentingOneYearRecordService.update(oneYearInfo);
			} else {
				appParentingOneYearRecordService.create(oneYearInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期一岁记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期一岁记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期一岁六个月记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumOneYearSixRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期一岁六个月记录
			AppParentingOneYearSixRecordPO oneYearSixInfo = appParentingOneYearSixRecordService.findAppParentingOneYearSixRecordInfoByParId(babyInfoId);
			
			//保存育儿期一岁六个月记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == oneYearSixInfo) {
				bn = false;
				oneYearSixInfo = new AppParentingOneYearSixRecordPO();
				oneYearSixInfo.setId(IdUtil.uuid());
				oneYearSixInfo.setParId(babyInfoId);
				oneYearSixInfo.setCreateTime(new Date());
			} else {
				bn = true;
				oneYearSixInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("ownWalkTime")))) 
				oneYearSixInfo.setOwnWalkTime(DateUtil.getDateByTime(StringUtil.valueOf(reqMap.get("mealNum"))));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("ownSpoon"))))
				oneYearSixInfo.setOwnSpoon(StringUtil.valueOf(reqMap.get("ownSpoon")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("ownGalss")))) 
				oneYearSixInfo.setOwnGalss(StringUtil.valueOf(reqMap.get("ownGalss")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("oftenPlay")))) 
				oneYearSixInfo.setOftenPlay(StringUtil.valueOf(reqMap.get("oftenPlay")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("consciousCall")))) 
				oneYearSixInfo.setConsciousCall(StringUtil.valueOf(reqMap.get("consciousCall")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("requirementFinger")))) 
				oneYearSixInfo.setRequirementFinger(StringUtil.valueOf(reqMap.get("requirementFinger")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("eyeContact")))) 
				oneYearSixInfo.setEyeContact(StringUtil.valueOf(reqMap.get("eyeContact")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("ownWalk")))) 
				oneYearSixInfo.setOwnWalk(StringUtil.valueOf(reqMap.get("ownWalk")));
			
			if (bn) {
				appParentingOneYearSixRecordService.update(oneYearSixInfo);
			} else {
				appParentingOneYearSixRecordService.create(oneYearSixInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期一岁六个月记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期一岁六个月记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期两岁记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumTwoYearRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期两岁记录
			AppParentingTwoYearRecordPO twoYearInfo = appParentingTwoYearRecordService.findAppParentingTwoYearRecordInfoByParId(babyInfoId);
			
			//保存育儿期两岁记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == twoYearInfo) {
				bn = false;
				twoYearInfo = new AppParentingTwoYearRecordPO();
				twoYearInfo.setId(IdUtil.uuid());
				twoYearInfo.setParId(babyInfoId);
				twoYearInfo.setCreateTime(new Date());
			} else {
				bn = true;
				twoYearInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("milkAmount"))))
				twoYearInfo.setMilkAmount(StringUtil.valueOf(reqMap.get("milkAmount")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("meatAmount")))) 
				twoYearInfo.setMeatAmount(StringUtil.valueOf(reqMap.get("meatAmount")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("gargle")))) 
				twoYearInfo.setGargle(StringUtil.valueOf(reqMap.get("gargle")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("eatVegetables")))) 
				twoYearInfo.setEatVegetables(StringUtil.valueOf(reqMap.get("eatVegetables")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("teachWobiDraw")))) 
				twoYearInfo.setTeachWobiDraw(StringUtil.valueOf(reqMap.get("teachWobiDraw")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sayThreeGoods")))) 
				twoYearInfo.setSayThreeGoods(StringUtil.valueOf(reqMap.get("sayThreeGoods")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("doSimpleThings")))) 
				twoYearInfo.setDoSimpleThings(StringUtil.valueOf(reqMap.get("doSimpleThings")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("spoonMeal")))) 
				twoYearInfo.setSpoonMeal(StringUtil.valueOf(reqMap.get("spoonMeal")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("holdClimbStairs")))) 
				twoYearInfo.setHoldClimbStairs(StringUtil.valueOf(reqMap.get("holdClimbStairs")));
			
			if (bn) {
				appParentingTwoYearRecordService.update(twoYearInfo);
			} else {
				appParentingTwoYearRecordService.create(twoYearInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期两岁记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期两岁记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期两岁六个月记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumTwoYearSixRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期两岁六个月记录
			AppParentingTwoYearSixRecordPO twoYearsixInfo = appParentingTwoYearSixRecordService.findAppParentingTwoYearSixRecordInfoByParId(babyInfoId);
			
			//保存育儿期两岁六个月记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == twoYearsixInfo) {
				bn = false;
				twoYearsixInfo = new AppParentingTwoYearSixRecordPO();
				twoYearsixInfo.setId(IdUtil.uuid());
				twoYearsixInfo.setParId(babyInfoId);
				twoYearsixInfo.setCreateTime(new Date());
			} else {
				bn = true;
				twoYearsixInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("bodyPartsNum"))))
				twoYearsixInfo.setBodyPartsNum(StringUtil.valueOf(reqMap.get("bodyPartsNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("teethNum")))) 
				twoYearsixInfo.setTeethNum(StringUtil.valueOf(reqMap.get("teethNum")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("picky")))) 
				twoYearsixInfo.setPicky(StringUtil.valueOf(reqMap.get("picky")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("doNotLike")))) 
				twoYearsixInfo.setDoNotLike(StringUtil.valueOf(reqMap.get("doNotLike")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("lookPicture")))) 
				twoYearsixInfo.setLookPicture(StringUtil.valueOf(reqMap.get("lookPicture")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sayPhrase")))) 
				twoYearsixInfo.setSayPhrase(StringUtil.valueOf(reqMap.get("sayPhrase")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("singleInterest")))) 
				twoYearsixInfo.setSingleInterest(StringUtil.valueOf(reqMap.get("singleInterest")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("signalToilet")))) 
				twoYearsixInfo.setSignalToilet(StringUtil.valueOf(reqMap.get("signalToilet")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("run")))) 
				twoYearsixInfo.setRun(StringUtil.valueOf(reqMap.get("run")));
			
			if (bn) {
				appParentingTwoYearSixRecordService.update(twoYearsixInfo);
			} else {
				appParentingTwoYearSixRecordService.create(twoYearsixInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期两岁六个月记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期两岁六个月记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期三岁记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumThreeYearRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期三岁记录
			AppParentingThreeYearRecordPO threeYearInfo = appParentingThreeYearRecordService.findAppParentingThreeYearRecordInfoByParId(babyInfoId);
			
			//保存育儿期三岁记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == threeYearInfo) {
				bn = false;
				threeYearInfo = new AppParentingThreeYearRecordPO();
				threeYearInfo.setId(IdUtil.uuid());
				threeYearInfo.setParId(babyInfoId);
				threeYearInfo.setCreateTime(new Date());
			} else {
				bn = true;
				threeYearInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("kindergarten"))))
				threeYearInfo.setKindergarten(StringUtil.valueOf(reqMap.get("kindergarten")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("chewingHabit")))) 
				threeYearInfo.setChewingHabit(StringUtil.valueOf(reqMap.get("chewingHabit")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("sleepBrushTooth")))) 
				threeYearInfo.setSleepBrushTeeth(StringUtil.valueOf(reqMap.get("sleepBrushTooth")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("mealWashHand")))) 
				threeYearInfo.setMealWashHand(StringUtil.valueOf(reqMap.get("mealWashHand")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("squinting")))) 
				threeYearInfo.setSquinting(StringUtil.valueOf(reqMap.get("squinting")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("ownName")))) 
				threeYearInfo.setOwnName(StringUtil.valueOf(reqMap.get("ownName")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("pretendPlay")))) 
				threeYearInfo.setPretendPlay(StringUtil.valueOf(reqMap.get("pretendPlay")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("imitateDrawCircle")))) 
				threeYearInfo.setImitateDrawCircle(StringUtil.valueOf(reqMap.get("imitateDrawCircle")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("doubleJump")))) 
				threeYearInfo.setDoubleJump(StringUtil.valueOf(reqMap.get("doubleJump")));
			
			if (bn) {
				appParentingThreeYearRecordService.update(threeYearInfo);
			} else {
				appParentingThreeYearRecordService.create(threeYearInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期三岁记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期三岁记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期四岁记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumFourYearRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期四岁记录
			AppParentingFourYearRecordPO fourYearInfo = appParentingFourYearRecordService.findAppParentingFourYearRecordInfoByParId(babyInfoId);
			
			//保存育儿期四岁记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == fourYearInfo) {
				bn = false;
				fourYearInfo = new AppParentingFourYearRecordPO();
				fourYearInfo.setId(IdUtil.uuid());
				fourYearInfo.setParId(babyInfoId);
				fourYearInfo.setCreateTime(new Date());
			} else {
				bn = true;
				fourYearInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("kindergarten"))))
				fourYearInfo.setKindergarten(StringUtil.valueOf(reqMap.get("kindergarten")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("cutSomething")))) 
				fourYearInfo.setCutSomething(StringUtil.valueOf(reqMap.get("cutSomething")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("independentToilet")))) 
				fourYearInfo.setIndependentToilet(StringUtil.valueOf(reqMap.get("independentToilet")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("tellingStories")))) 
				fourYearInfo.setTellingStories(StringUtil.valueOf(reqMap.get("tellingStories")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("outdoorActivityTime")))) 
				fourYearInfo.setOutdoorActivityTime(StringUtil.valueOf(reqMap.get("outdoorActivityTime")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("watchVideoTime")))) 
				fourYearInfo.setWatchVideoTime(StringUtil.valueOf(reqMap.get("watchVideoTime")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("saidAdjectiveSentence")))) 
				fourYearInfo.setSaidAdjectiveSentence(StringUtil.valueOf(reqMap.get("saidAdjectiveSentence")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("requirementWait")))) 
				fourYearInfo.setRequirementWait(StringUtil.valueOf(reqMap.get("requirementWait")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("independentDress")))) 
				fourYearInfo.setIndependentDress(StringUtil.valueOf(reqMap.get("independentDress")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("singleFootStand")))) 
				fourYearInfo.setSingleFootStand(StringUtil.valueOf(reqMap.get("singleFootStand")));
			
			if (bn) {	
				appParentingFourYearRecordService.update(fourYearInfo);
			} else {
				appParentingFourYearRecordService.create(fourYearInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期四岁记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期四岁记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期五岁记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumFiveYearRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期五岁记录
			AppParentingFiveYearRecordPO fiveYearInfo = appParentingFiveYearRecordService.findAppParentingFiveYearRecordInfoByParId(babyInfoId);
			
			//保存育儿期五岁记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == fiveYearInfo) {
				bn = false;
				fiveYearInfo = new AppParentingFiveYearRecordPO();
				fiveYearInfo.setId(IdUtil.uuid());
				fiveYearInfo.setParId(babyInfoId);
				fiveYearInfo.setCreateTime(new Date());
			} else {
				bn = true;
				fiveYearInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("holdPenDraw"))))
				fiveYearInfo.setHoldPenDraw(StringUtil.valueOf(reqMap.get("holdPenDraw")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("distinguishColour")))) 
				fiveYearInfo.setDistinguishColour(StringUtil.valueOf(reqMap.get("distinguishColour")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("habitCollectiveLife")))) 
				fiveYearInfo.setHabitCollectiveLife(StringUtil.valueOf(reqMap.get("habitCollectiveLife")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("ownDisrobe")))) 
				fiveYearInfo.setOwnDisrobe(StringUtil.valueOf(reqMap.get("ownDisrobe")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("briefThings")))) 
				fiveYearInfo.setBriefThings(StringUtil.valueOf(reqMap.get("briefThings")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("knowSex")))) 
				fiveYearInfo.setKnowSex(StringUtil.valueOf(reqMap.get("knowSex")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("useChopsticks")))) 
				fiveYearInfo.setUseChopsticks(StringUtil.valueOf(reqMap.get("useChopsticks")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("singleFootJump")))) 
				fiveYearInfo.setSingleFootJump(StringUtil.valueOf(reqMap.get("singleFootJump")));
			
			if (bn) {	
				appParentingFiveYearRecordService.update(fiveYearInfo);
			} else {
				appParentingFiveYearRecordService.create(fiveYearInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期五岁记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期五岁记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 保存育儿期六岁记录
	 * @param reqMap
	 * @return
	 */
	@Transactional
	public Map<String,Object> savePostpartumSixYearRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String babyInfoId = StringUtil.valueOf(reqMap.get("babyInfoId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询育儿期六岁记录
			AppParentingSixYearRecordPO sixYearInfo = appParentingSixYearRecordService.findAppParentingSixYearRecordInfoByParId(babyInfoId);
			
			//保存育儿期六岁记录
			//新增或修改标示  默认true-修改
			boolean bn = true;
			if (null == sixYearInfo) {
				bn = false;
				sixYearInfo = new AppParentingSixYearRecordPO();
				sixYearInfo.setId(IdUtil.uuid());
				sixYearInfo.setParId(babyInfoId);
				sixYearInfo.setCreateTime(new Date());
			} else {
				bn = true;
				sixYearInfo.setUpdateTime(new Date());
			}
			
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("simpleHousework"))))
				sixYearInfo.setSimpleHousework(StringUtil.valueOf(reqMap.get("simpleHousework")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("shareFood")))) 
				sixYearInfo.setShareFood(StringUtil.valueOf(reqMap.get("shareFood")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("complyGameRule")))) 
				sixYearInfo.setComplyGameRule(StringUtil.valueOf(reqMap.get("complyGameRule")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("writeOwnName")))) 
				sixYearInfo.setWriteOwnName(StringUtil.valueOf(reqMap.get("writeOwnName")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("expressIdeas")))) 
				sixYearInfo.setExpressIdeas(StringUtil.valueOf(reqMap.get("expressIdeas")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("playCosplayGame")))) 
				sixYearInfo.setPlayCosplayGame(StringUtil.valueOf(reqMap.get("playCosplayGame")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("drawSquare")))) 
				sixYearInfo.setDrawSquare(StringUtil.valueOf(reqMap.get("drawSquare")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("run")))) 
				sixYearInfo.setRun(StringUtil.valueOf(reqMap.get("run")));
			
			if (bn) {	
				appParentingSixYearRecordService.update(sixYearInfo);
			} else {
				appParentingSixYearRecordService.create(sixYearInfo);
			}
		} catch (Exception e) {
			loggerPostpartum.error("保存育儿期六岁记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"保存育儿期六岁记录异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询育儿期年龄记录信息
	 * @param mbrId
	 * @param babyInfoId
	 * @param age
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchPostpartumRecordForAge(String mbrId,String babyInfoId,PostpartumAge age) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			this.appPostpartumValidateService.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//按照年龄查询记录信息
			switch (age) {
			case 一个月:
				respMap.put("oneMonthInfo", appParentingOneMonthRecordService.findAppParentingOneMonthRecordInfoByParId(babyInfoId));
				break;
			case 三个月:
				respMap.put("threeMonthInfo", appParentingThreeMonthRecordService.findAppParentingThreeMonthRecordInfoByParId(babyInfoId));
				break;
			case 六个月:
				respMap.put("sixMonthInfo", appParentingSixMonthRecordService.findAppParentingSixMonthRecordInfoByParId(babyInfoId));
				break;
			case 八个月:
				respMap.put("eightMonthInfo", appParentingEightMonthRecordService.findAppParentingEightMonthRecordInfoByParId(babyInfoId));
				break;
			case 一岁:
				respMap.put("oneYearInfo", appParentingOneYearRecordService.findAppParentingOneYearRecordInfoByParId(babyInfoId));
				break;
			case 一岁半:
				respMap.put("oneYearSixInfo", appParentingOneYearSixRecordService.findAppParentingOneYearSixRecordInfoByParId(babyInfoId));
				break;
			case 两岁:
				respMap.put("twoYearInfo", appParentingTwoYearRecordService.findAppParentingTwoYearRecordInfoByParId(babyInfoId));
				break;
			case 两岁半:
				respMap.put("twoYearSixInfo", appParentingTwoYearSixRecordService.findAppParentingTwoYearSixRecordInfoByParId(babyInfoId));
				break;
			case 三岁:
				respMap.put("threeYearInfo", appParentingThreeYearRecordService.findAppParentingThreeYearRecordInfoByParId(babyInfoId));
				break;
			case 四岁:
				respMap.put("fourYearInfo", appParentingFourYearRecordService.findAppParentingFourYearRecordInfoByParId(babyInfoId));
				break;
			case 五岁:
				respMap.put("fiveYearInfo", appParentingFiveYearRecordService.findAppParentingFiveYearRecordInfoByParId(babyInfoId));
				break;
			case 六岁:
				respMap.put("sixYearInfo", appParentingSixYearRecordService.findAppParentingSixYearRecordInfoByParId(babyInfoId));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期"+age.name()+"记录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期"+age.name()+"记录异常!",e);
		}
		return respMap;
	}
}
