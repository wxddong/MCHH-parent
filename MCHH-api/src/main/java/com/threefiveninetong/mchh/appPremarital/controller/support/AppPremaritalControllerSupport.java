package com.threefiveninetong.mchh.appPremarital.controller.support;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.threefiveninetong.mchh.app.service.AppPremaritalHandleService;
import com.threefiveninetong.mchh.appConfig.po.AppBannerInfoPO;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationBasicInfoPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationOtherInfoPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationTemperatureRecordPO;
import com.threefiveninetong.mchh.appPremarital.po.AppPreparationWeightRecordPO;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalBasicAddReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalBasicSearchInfoReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalBasicUpdateReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalOtherInfoSaveReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalSearchFirstPageInfoReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalSearchOtherInfoReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalSearchTemperatureRecordReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalSearchWeightRecordReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalTemperatureRecordAddReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.req.PremaritalWeightRecordAddReqVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalBasicAddRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalBasicSearchInfoRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchOtherInfoRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchTemperatureRecordRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchWeightRecordRespVo;
import com.threefiveninetong.mchh.common.CommonAssembleSupport;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.StringUtil;

@Component
public class AppPremaritalControllerSupport {
	
	@Resource
	private AppPremaritalHandleService appPremaritalHandleService;
	
	/**
	 * 查询备孕期首页信息
	 * @param request
	 * @return
	 */
	public PremaritalSearchFirstPageInfoRespVo searchPremaritalFirstPageInfo(PremaritalSearchFirstPageInfoReqVo request) {
		PremaritalSearchFirstPageInfoRespVo respInfo = new PremaritalSearchFirstPageInfoRespVo();
		Map<String,Object> respMap = appPremaritalHandleService.searchPremaritalFirstPageInfo(request.getMemberId());
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
				
				//组装上一次体重信息
				AppPreparationWeightRecordPO weightInfo = (AppPreparationWeightRecordPO) respMap.get("weightInfo");
				if (null != weightInfo) {
					respInfo.setWeight(StringUtil.valueOf(weightInfo.getWeight()));
				}
				
				//组装上一次体温信息
				AppPreparationTemperatureRecordPO temperatureInfo = (AppPreparationTemperatureRecordPO) respMap.get("temperatureInfo");
				if (null != temperatureInfo) {
					respInfo.setTemperature(StringUtil.valueOf(temperatureInfo.getTemperature()));
				}
				
				//组装基本信息
				AppPreparationBasicInfoPO basicInfo = (AppPreparationBasicInfoPO) respMap.get("basicInfo");
				if (null != basicInfo) {
					respInfo.setPremaritalBasicId(basicInfo.getId());
					if (null != basicInfo.getLastMenses()) {
						respInfo.setLastMenses(StringUtil.valueOf(basicInfo.getLastMenses().getTime()));
					}
					respInfo.setPeriod(StringUtil.valueOf(basicInfo.getPeriod()));
					respInfo.setMenstrualCycle(StringUtil.valueOf(basicInfo.getMenstrualCycle()));
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 添加备孕期基础信息
	 * @param request
	 * @return
	 */
	public PremaritalBasicAddRespVo addPremaritalBasicInfo(PremaritalBasicAddReqVo request) {
		return BeanUtil.mapToBean(appPremaritalHandleService.addPremaritalBasicInfo(BeanUtil.beanToMap(request)), PremaritalBasicAddRespVo.class);
	}
	
	/**
	 * 修改备孕期基础信息
	 * @param request
	 * @return
	 */
	public BaseVo updatePremaritalBasicInfo(PremaritalBasicUpdateReqVo request) {
		return BeanUtil.mapToBean(appPremaritalHandleService.updatePremaritalBasicInfo(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询备孕期基础信息
	 * @param request
	 * @return
	 */
	public PremaritalBasicSearchInfoRespVo searchPremaritalBasicInfo(PremaritalBasicSearchInfoReqVo request) {
		return BeanUtil.mapToBean(appPremaritalHandleService.searchPremaritalBasicInfo(request.getMemberId()), PremaritalBasicSearchInfoRespVo.class);
	}
	
	/**
	 * 添加备孕期体重记录
	 * @param request
	 * @return
	 */
	public BaseVo addPremaritalWeightRecord(PremaritalWeightRecordAddReqVo request) {
		return BeanUtil.mapToBean(appPremaritalHandleService.addPremaritalWeightRecord(BeanUtil.beanToMap(request)), PremaritalBasicSearchInfoRespVo.class);
	}
	
	/**
	 * 查询备孕期体温记录
	 * @param request
	 * @return
	 */
	public PremaritalSearchTemperatureRecordRespVo searchPremaritalTemperatureRecord(PremaritalSearchTemperatureRecordReqVo request) {
		PremaritalSearchTemperatureRecordRespVo respInfo = new PremaritalSearchTemperatureRecordRespVo();
		Map<String,Object> respMap = appPremaritalHandleService.searchPremaritalTemperatureRecord(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				//封装30条体温信息
				respInfo.setTemperatureList(CommonAssembleSupport.assembleSearchPremaritalTemperatureRecord((List<AppPreparationTemperatureRecordPO>) respMap.get("temperatureRecordlist")));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 添加备孕期体温记录
	 * @param request
	 * @return
	 */
	public BaseVo addPremaritalTemperatureRecord(PremaritalTemperatureRecordAddReqVo request) {
		return BeanUtil.mapToBean(appPremaritalHandleService.addPremaritalTemperatureRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 保存备孕期其他信息
	 * @param request
	 * @return
	 */
	public BaseVo savePremaritalOtherInfo(PremaritalOtherInfoSaveReqVo request) {
		return BeanUtil.mapToBean(appPremaritalHandleService.savePremaritalOtherInfo(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询备孕期其他信息
	 * @param request
	 * @return
	 */
	public PremaritalSearchOtherInfoRespVo searchPremaritalOtherInfo(PremaritalSearchOtherInfoReqVo request) {
		PremaritalSearchOtherInfoRespVo respInfo = new PremaritalSearchOtherInfoRespVo();
		Map<String,Object> respMap = appPremaritalHandleService.searchPremaritalOtherInfo(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				AppPreparationOtherInfoPO otherInfo = (AppPreparationOtherInfoPO) respMap.get("otherInfo");
				if (null == otherInfo) {
					respInfo.setStatusCode(DictionaryForApi.RESP_CODE_SPECIAL);
				} else {
					respInfo.setDadAge(StringUtil.valueOf(otherInfo.getDadAge()));
					respInfo.setMomAge(StringUtil.valueOf(otherInfo.getMomAge()));
					respInfo.setPlanTime(StringUtil.valueOf(otherInfo.getPlanTime().getTime()));
					respInfo.setDadHealthy(StringUtil.valueOf(otherInfo.getDadHealthy()));
					respInfo.setMomHealthy(StringUtil.valueOf(otherInfo.getMomHealthy()));
					respInfo.setDadHealthyRemark(StringUtil.valueOf(otherInfo.getDadHealthyRemark()));
					respInfo.setMomHealthyRemark(StringUtil.valueOf(otherInfo.getMomHealthyRemark()));
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询备孕期妈妈的体重记录
	 * @param request
	 * @return
	 */
	public PremaritalSearchWeightRecordRespVo searchPremaritalWeightRecord(PremaritalSearchWeightRecordReqVo request) {
		PremaritalSearchWeightRecordRespVo respInfo = new PremaritalSearchWeightRecordRespVo();
		Map<String,Object> respMap = appPremaritalHandleService.searchPremaritalWeightRecord(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setPreparationWeightList(CommonAssembleSupport.assembleSearchPremaritalWeightRecord((List<AppPreparationWeightRecordPO>)respMap.get("weightList")));
			}
		}	
		return respInfo;
	}
}
