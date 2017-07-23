package com.threefiveninetong.mchh.appPostpartum.controller.support;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.app.service.AppPostpartumHandleService;
import com.threefiveninetong.mchh.app.validate.AppPostpartumValidateService;
import com.threefiveninetong.mchh.appConfig.po.AppBannerInfoPO;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
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
import com.threefiveninetong.mchh.appPostpartum.vo.req.BabyVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyBasicInfoAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyBasicInfoUpdateReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyDentitionRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyGrowRecordAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumEarlyStageRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumEightMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumFiveYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumFourYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumMomWeightRecordAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumOneMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumOneYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumOneYearSixRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyBasicInfoReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyDentitionRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyGrowRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyListReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchEarlyStageRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchEightMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchFirstPageInfoReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchFiveYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchFourYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchOneMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchOneYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchOneYearSixRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchSixMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchSixYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchThreeMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchThreeYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchTwoYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchTwoYearSixRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchVaccineRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchWeightRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSixMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSixYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumThreeMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumThreeYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumTwoYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumTwoYearSixRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumVaccineRecordAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumBabyBasicInfoAddRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyBasicInfoRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyDentitionRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyGrowRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyListRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchEarlyStageRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchEightMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFiveYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFourYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneYearSixRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchSixMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchSixYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchThreeMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchThreeYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchTwoYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchTwoYearSixRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchVaccineRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchWeightRecordRespVo;
import com.threefiveninetong.mchh.common.CommonAssembleSupport;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.PostpartumAge;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;

@Component
public class AppPostpartumControllerSupport {
	
	@Resource
	private AppPostpartumHandleService appPostpartumHandleService;
	
	@Resource
	private AppPostpartumValidateService appPostpartumValidateService;
	
	/**
	 * 添加育儿期宝宝基础信息
	 * @param request
	 * @return
	 */
	@Transactional
	public PostpartumBabyBasicInfoAddRespVo addPostpartumBabyBasicInfo(PostpartumBabyBasicInfoAddReqVo request) {
		PostpartumBabyBasicInfoAddRespVo respInfo = new PostpartumBabyBasicInfoAddRespVo();
		
		//验证过程
		String mbrId = StringUtil.valueOf(request.getMemberId());
		Map<String,Object> respMap =  this.appPostpartumValidateService.commonValidateMbrStatus(MapUtil.getResultSuccess(), mbrId);
		if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			respInfo.setStatusCode(StringUtil.valueOf(respMap.get("statusCode")));
			return respInfo;
		}
		
		//添加数据
		if (CollectionUtil.isNullOrEmpty(request.getBabyList())) {
			respInfo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
			respInfo.setMessage("儿童数据不能为空!");
			return respInfo;
		}
		
		//宝宝ID
		String babyInfoId = "";
		for (BabyVo baby : request.getBabyList()) {
			babyInfoId = this.appPostpartumHandleService.addPostpartumBabyBasicInfo(mbrId, BeanUtil.beanToMap(baby));
			if (!StringUtil.isNullOrBlank(babyInfoId)) {
				baby.setBabyInfoId(babyInfoId);
			}
		}
		
		respInfo.setBabyList(request.getBabyList());
		return respInfo;
	}
	
	/**
	 * 查询育儿期基础信息
	 * @param request
	 * @return
	 */
	public PostpartumSearchBabyBasicInfoRespVo searchPostpartumBabyBasicInfo(PostpartumSearchBabyBasicInfoReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.searchPostpartumBabyBasicInfo(request.getMemberId()), PostpartumSearchBabyBasicInfoRespVo.class);
	}	
	
	/**
	 * 查询育儿期宝宝信息
	 * @param request
	 * @return
	 */
	public PostpartumSearchBabyListRespVo searchPostpartumBabyList(PostpartumSearchBabyListReqVo request) {
		PostpartumSearchBabyListRespVo respInfo = new PostpartumSearchBabyListRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumBabyList(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setBabyList(CommonAssembleSupport.assembleSearchPostpartumBabyList((List<AppBabyBasicInfoPO>)respMap.get("babyList")));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 修改育儿期宝宝信息
	 * @param request
	 * @return
	 */
	public BaseVo updatePostpartumBabyBasicInfo(PostpartumBabyBasicInfoUpdateReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.updatePostpartumBabyBasicInfo(request.getMemberId(),BeanUtil.beanToMap(request.getBabyInfo())), BaseVo.class);
	}
	
	/**
	 * 查询育儿期首页信息
	 * @param request
	 * @return
	 */
	public PostpartumSearchFirstPageInfoRespVo searchPostpartumFirstPageInfo(PostpartumSearchFirstPageInfoReqVo request) {
		PostpartumSearchFirstPageInfoRespVo respInfo = new PostpartumSearchFirstPageInfoRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumFirstPageInfo(request.getMemberId(),request.getBabyInfoId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				
				//组装专家健康指导意见
				respInfo.setExpertGuidanceList(CommonAssembleSupport.assembleExpertGuidanceVo((List<AppExpertGuidancePO>)respMap.get("expertGuidanceList"),StringUtil.valueOf(respMap.get("serverUrl"))));
				
				//组装最新通知信息
				respInfo.setBannerImageList(CommonAssembleSupport.assembleBannerImageInfoVo((List<AppBannerInfoPO>)respMap.get("bannerlist"), StringUtil.valueOf(respMap.get("serverUrl"))));
				
				//组装最新通知信息
				AppMbrMessageInfoPO msgInfo = (AppMbrMessageInfoPO) respMap.get("msgInfo");
				if (null != msgInfo) {
					respInfo.setTitle(StringUtil.valueOf(msgInfo.getTitle()));
					respInfo.setContent(StringUtil.valueOf(msgInfo.getContent()));
					if (null != msgInfo.getReceiveTime()) {
						respInfo.setReceiveTime(StringUtil.valueOf(msgInfo.getReceiveTime().getTime()));
					}
				}
				
				AppParentingMomWeightRecordPO weightInfo = (AppParentingMomWeightRecordPO) respMap.get("momWeightInfo");
				if (null != weightInfo) {
					//组装妈妈上一次体重信息
					respInfo.setMomWeight(StringUtil.valueOf(weightInfo.getWeight()));
					//孕前BMI信息
					respInfo.setPrenatalBmi(StringUtil.valueOf(weightInfo.getPreBmi()));
				}
				
				//组装基本信息
				AppBabyBasicInfoPO basicInfo = (AppBabyBasicInfoPO) respMap.get("basicInfo");
				if (null != basicInfo) {
					respInfo.setBabyHeight(StringUtil.valueOf(basicInfo.getLength()));
					respInfo.setBabyWeight(StringUtil.valueOf(basicInfo.getWeight()));
					//计算出生天数
					respInfo.setBirthDays(StringUtil.valueOf((System.currentTimeMillis() - basicInfo.getBirthday().getTime())/(24*60*60*1000)));
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 添加育儿期妈妈体重记录
	 * @param request
	 * @return
	 */
	public BaseVo addPostpartumMomWeightRecord(PostpartumMomWeightRecordAddReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.addPostpartumMomWeightRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 添加育儿期宝宝生长记录
	 * @param request
	 * @return
	 */
	public BaseVo addPostpartumBabyGrowRecord(PostpartumBabyGrowRecordAddReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.addPostpartumBabyGrowRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询育儿期宝宝生长记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchBabyGrowRecordRespVo searchPostpartumBabyGrowRecord(PostpartumSearchBabyGrowRecordReqVo request) {
		PostpartumSearchBabyGrowRecordRespVo respInfo = new PostpartumSearchBabyGrowRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumBabyGrowRecord(request.getMemberId(),request.getBabyInfoId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setBabyGrowList(CommonAssembleSupport.assembleSearchPostpartumBabyGrowRecord((List<AppParentingBabyGrowRecordPO>)respMap.get("babyGrowList")));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 保存育儿期宝宝牙齿生长记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumBabyDentitionRecord(PostpartumBabyDentitionRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumBabyDentitionRecord(request.getMemberId(),request.getBabyInfoId(), CommonAssembleSupport.commonListToMapTools(request.getBabyToochGrowList())), BaseVo.class);
	}
	
	/**
	 * 查询育儿期宝宝牙齿生长记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchBabyDentitionRecordRespVo searchPostpartumBabyDentitionRecord(PostpartumSearchBabyDentitionRecordReqVo request) {
		PostpartumSearchBabyDentitionRecordRespVo respInfo = new PostpartumSearchBabyDentitionRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumBabyDentitionRecord(request.getMemberId(),request.getBabyInfoId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setBabyToochGrowList(CommonAssembleSupport.assembleSearchPostpartumBabyDentitionRecord((List<AppParentingBabyDentitionRecordPO>)respMap.get("babyToochGrowList")));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 添加育儿期宝宝疫苗接种记录
	 * @param request
	 * @return
	 */
	public BaseVo addPostpartumVaccineRecord(PostpartumVaccineRecordAddReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.addPostpartumVaccineRecord(request.getMemberId(),request.getBabyInfoId(), request.getVaccineList()), BaseVo.class);
	}
	
	/**
	 * 查询育儿期宝宝疫苗接种记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchVaccineRecordRespVo searchPostpartumVaccineRecord(PostpartumSearchVaccineRecordReqVo request) {
		PostpartumSearchVaccineRecordRespVo respInfo = new PostpartumSearchVaccineRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumVaccineRecord(request.getMemberId(),request.getBabyInfoId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setVaccineList((CommonAssembleSupport.assembleSearchPostpartumVaccineRecord((List<AppParentingVaccineRecordPO>)respMap.get("vaccineList"))));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 保存育儿期新生儿早期记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumEarlyStageRecord(PostpartumEarlyStageRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumEarlyStageRecord(request.getMemberId(),request.getBabyInfoId(), request.getDiseaseScreening(), request.getHearingScreening(), BeanUtil.beanToMap(request.getEarlyStageDetails())), BaseVo.class);
	}
	
	/**
	 * 查询育儿期新生儿早期记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchEarlyStageRecordRespVo searchPostpartumEarlyStageRecord(PostpartumSearchEarlyStageRecordReqVo request) {
		PostpartumSearchEarlyStageRecordRespVo respInfo = new PostpartumSearchEarlyStageRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumEarlyStageRecord(request.getMemberId(),request.getBabyInfoId(),request.getType());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				AppParentingEarlyStageRecordPO earlyStageInfo = (AppParentingEarlyStageRecordPO) respMap.get("earlyStageInfo");
				if (null != earlyStageInfo) {
					respInfo.setDiseaseScreening(StringUtil.valueOf(earlyStageInfo.getDiseaseScreening()));
					respInfo.setHearingScreening(StringUtil.valueOf(earlyStageInfo.getHearingScreening()));
					respInfo.setEarlyStageDetailsList(CommonAssembleSupport.assembleSearchPostpartumEarlyStageRecord((List<AppParentingEarlyStageDetailsPO>)respMap.get("earlyStageDetailsList")));
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 保存育儿期一月龄记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumOneMonthRecord(PostpartumOneMonthRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumOneMonthRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期三月龄记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumThreeMonthRecord(PostpartumThreeMonthRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumThreeMonthRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期六月龄记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumSixMonthRecord(PostpartumSixMonthRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumSixMonthRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期八月龄记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumEightMonthRecord(PostpartumEightMonthRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumEightMonthRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期一岁记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumOneYearRecord(PostpartumOneYearRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumOneYearRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期一岁六月龄记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumOneYearSixRecord(PostpartumOneYearSixRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumOneYearSixRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期两岁记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumTwoYearRecord(PostpartumTwoYearRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumTwoYearRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期两岁半记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumTwoYearSixRecord(PostpartumTwoYearSixRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumTwoYearSixRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期三岁记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumThreeYearRecord(PostpartumThreeYearRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumThreeYearRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期四岁记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumFourYearRecord(PostpartumFourYearRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumFourYearRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期五岁记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumFiveYearRecord(PostpartumFiveYearRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumFiveYearRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存育儿期六岁记录
	 * @param request
	 * @return
	 */
	public BaseVo savePostpartumSixYearRecord(PostpartumSixYearRecordSaveReqVo request) {
		return BeanUtil.mapToBean(appPostpartumHandleService.savePostpartumSixYearRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询育儿期一月龄记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchOneMonthRecordRespVo searchPostpartumOneMonthRecord(PostpartumSearchOneMonthRecordReqVo request) {
		PostpartumSearchOneMonthRecordRespVo respInfo = new PostpartumSearchOneMonthRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.一个月);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumOneMonthRecord(respInfo, (AppParentingOneMonthRecordPO)respMap.get("oneMonthInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期三月龄记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchThreeMonthRecordRespVo searchPostpartumThreeMonthRecord(PostpartumSearchThreeMonthRecordReqVo request) {
		PostpartumSearchThreeMonthRecordRespVo respInfo = new PostpartumSearchThreeMonthRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.三个月);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumThreeMonthRecord(respInfo, (AppParentingThreeMonthRecordPO)respMap.get("threeMonthInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期六月龄记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchSixMonthRecordRespVo searchPostpartumSixMonthRecord(PostpartumSearchSixMonthRecordReqVo request) {
		PostpartumSearchSixMonthRecordRespVo respInfo = new PostpartumSearchSixMonthRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.六个月);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumSixMonthRecord(respInfo, (AppParentingSixMonthRecordPO)respMap.get("sixMonthInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期八月龄记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchEightMonthRecordRespVo searchPostpartumEightMonthRecord(PostpartumSearchEightMonthRecordReqVo request) {
		PostpartumSearchEightMonthRecordRespVo respInfo = new PostpartumSearchEightMonthRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.八个月);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumEightMonthRecord(respInfo, (AppParentingEightMonthRecordPO)respMap.get("eightMonthInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期一岁记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchOneYearRecordRespVo searchPostpartumOneYearRecord(PostpartumSearchOneYearRecordReqVo request) {
		PostpartumSearchOneYearRecordRespVo respInfo = new PostpartumSearchOneYearRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.一岁);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumOneYearRecord(respInfo, (AppParentingOneYearRecordPO)respMap.get("oneYearInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期一岁六月记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchOneYearSixRecordRespVo searchPostpartumOneYearSixRecord(PostpartumSearchOneYearSixRecordReqVo request) {
		PostpartumSearchOneYearSixRecordRespVo respInfo = new PostpartumSearchOneYearSixRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.一岁半);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumOneYearSixRecord(respInfo, (AppParentingOneYearSixRecordPO)respMap.get("oneYearSixInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期两岁记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchTwoYearRecordRespVo searchPostpartumTwoYearRecord(PostpartumSearchTwoYearRecordReqVo request) {
		PostpartumSearchTwoYearRecordRespVo respInfo = new PostpartumSearchTwoYearRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.两岁);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumTwoYearRecord(respInfo, (AppParentingTwoYearRecordPO)respMap.get("twoYearInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期两岁六月记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchTwoYearSixRecordRespVo searchPostpartumTwoYearSixRecord(PostpartumSearchTwoYearSixRecordReqVo request) {
		PostpartumSearchTwoYearSixRecordRespVo respInfo = new PostpartumSearchTwoYearSixRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.两岁半);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumTwoYearSixRecord(respInfo, (AppParentingTwoYearSixRecordPO)respMap.get("twoYearSixInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期三岁记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchThreeYearRecordRespVo searchPostpartumThreeYearRecord(PostpartumSearchThreeYearRecordReqVo request) {
		PostpartumSearchThreeYearRecordRespVo respInfo = new PostpartumSearchThreeYearRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.三岁);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumThreeYearRecord(respInfo, (AppParentingThreeYearRecordPO)respMap.get("threeYearInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期四岁记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchFourYearRecordRespVo searchPostpartumFourYearRecord(PostpartumSearchFourYearRecordReqVo request) {
		PostpartumSearchFourYearRecordRespVo respInfo = new PostpartumSearchFourYearRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.四岁);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumFourYearRecord(respInfo, (AppParentingFourYearRecordPO)respMap.get("fourYearInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期五岁记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchFiveYearRecordRespVo searchPostpartumFiveYearRecord(PostpartumSearchFiveYearRecordReqVo request) {
		PostpartumSearchFiveYearRecordRespVo respInfo = new PostpartumSearchFiveYearRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.五岁);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumFiveYearRecord(respInfo, (AppParentingFiveYearRecordPO)respMap.get("fiveYearInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期六岁记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchSixYearRecordRespVo searchPostpartumSixYearRecord(PostpartumSearchSixYearRecordReqVo request) {
		PostpartumSearchSixYearRecordRespVo respInfo = new PostpartumSearchSixYearRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumRecordForAge(request.getMemberId(), request.getBabyInfoId(), PostpartumAge.六岁);
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				CommonAssembleSupport.assembleSearchPostpartumSixYearRecord(respInfo, (AppParentingSixYearRecordPO)respMap.get("sixYearInfo"));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询育儿期妈妈的体重记录
	 * @param request
	 * @return
	 */
	public PostpartumSearchWeightRecordRespVo searchPostpartumWeightRecord(PostpartumSearchWeightRecordReqVo request) {
		PostpartumSearchWeightRecordRespVo respInfo = new PostpartumSearchWeightRecordRespVo();
		Map<String,Object> respMap = appPostpartumHandleService.searchPostpartumWeightRecord(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setParentingWeightList(CommonAssembleSupport.assembleSearchPostpartumWeightRecord((List<AppParentingMomWeightRecordPO>)respMap.get("momWeightList")));
			}
		}	
		return respInfo;
	}
}
