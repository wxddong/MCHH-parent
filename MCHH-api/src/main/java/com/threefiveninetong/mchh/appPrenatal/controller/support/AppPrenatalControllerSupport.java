package com.threefiveninetong.mchh.appPrenatal.controller.support;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.threefiveninetong.mchh.app.service.AppPrenatalHandleService;
import com.threefiveninetong.mchh.appConfig.po.AppBannerInfoPO;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalBasicInfoPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalFetalMovementRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalLectureRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalSelfRecordSpecialPO;
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalWeightRecordPO;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalBasicInfoAddReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalBasicInfoUpdateReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalFetalMovementRecordAddReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalLectureRecordAddReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSearchBasicInfoReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSearchFetalMovementRecordReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSearchFirstPageInfoReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSearchLectureRecordReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSearchSelfRecordReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSearchWeightRecordReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalSelfRecordSaveReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.req.PrenatalWeightRecordAddReqVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalBasicInfoAddRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchBasicInfoRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchFetalMovementRecordRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchLectureRecordRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchSelfRecordRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchWeightRecordRespVo;
import com.threefiveninetong.mchh.common.CommonAssembleSupport;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.StringUtil;

@Component
public class AppPrenatalControllerSupport {
	
	@Resource
	private AppPrenatalHandleService appPrenatalHandleService;
	
	/**
	 * 查询孕产期首页信息
	 * @param request
	 * @return
	 */
	public PrenatalSearchFirstPageInfoRespVo searchPrenatalFirstPageInfo(PrenatalSearchFirstPageInfoReqVo request) {
		PrenatalSearchFirstPageInfoRespVo respInfo = new PrenatalSearchFirstPageInfoRespVo();
		Map<String,Object> respMap = appPrenatalHandleService.searchPrenatalFirstPageInfo(request.getMemberId());
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
				AppPrenatalWeightRecordPO weightInfo = (AppPrenatalWeightRecordPO) respMap.get("weightInfo");
				if (null != weightInfo) {
					respInfo.setWeight(StringUtil.valueOf(weightInfo.getWeight()));
				}
				
				//组装上一次胎动信息
				AppPrenatalFetalMovementRecordPO fetalMovementRecordInfo = (AppPrenatalFetalMovementRecordPO) respMap.get("fetalMovementRecordInfo");
				if (null != fetalMovementRecordInfo) {
					respInfo.setMoveNum(StringUtil.valueOf(fetalMovementRecordInfo.getMoveNum()));
				}
				
				//组装基本信息
				AppPrenatalBasicInfoPO basicInfo = (AppPrenatalBasicInfoPO) respMap.get("basicInfo");
				if (null != basicInfo) {
					if (null != basicInfo.getLastMenses()) {
						respInfo.setLastMenses(StringUtil.valueOf(basicInfo.getLastMenses().getTime()));
						//计算当前孕周
						StringBuffer sb = new StringBuffer();
						Date date = new Date();
						long ln = (date.getTime() - basicInfo.getLastMenses().getTime());
						if (ln > 0) {
							long week = ln/(7*24*60*60*1000);
							long day;
							if (week > 0) {
								sb.append(week);
								day = (ln - week*7*24*60*60*1000)/24*60*60*1000;
							} else {
								day = ln/(24*60*60*1000);
							}
							sb.append("."+day);
						} else {
							sb.append("");
						}
						respInfo.setGestationalWeeks(sb.toString());
					}
					respInfo.setPrenatalBasicId(basicInfo.getId());
					if (null != basicInfo.getPredictDate()) {
						respInfo.setPredictDate(StringUtil.valueOf(basicInfo.getPredictDate().getTime()));
					}
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 添加孕产期基础信息
	 * @param request
	 * @return
	 */
	public PrenatalBasicInfoAddRespVo addPrenatalBasicInfo(PrenatalBasicInfoAddReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.addPrenatalBasicInfo(BeanUtil.beanToMap(request)), PrenatalBasicInfoAddRespVo.class);
	}
	
	/**
	 * 修改孕产期基础信息
	 * @param request
	 * @return
	 */
	public BaseVo updatePrenatalBasicInfo(PrenatalBasicInfoUpdateReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.updatePrenatalBasicInfo(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询孕产期基础信息
	 * @param request
	 * @return
	 */
	public PrenatalSearchBasicInfoRespVo searchPrenatalBasicInfo(PrenatalSearchBasicInfoReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.searchPrenatalBasicInfo(request.getMemberId()), PrenatalSearchBasicInfoRespVo.class);
	}
	
	/**
	 * 添加孕产期体重记录
	 * @param request
	 * @return
	 */
	public BaseVo addPrenatalWeightRecord(PrenatalWeightRecordAddReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.addPrenatalWeightRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 添加孕产期胎动记录
	 * @param request
	 * @return
	 */
	public BaseVo addPrenatalFetalMovementRecord(PrenatalFetalMovementRecordAddReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.addPrenatalFetalMovementRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 添加孕产期孕妇学校听课记录
	 * @param request
	 * @return
	 */
	public BaseVo addPrenatalLectureRecord(PrenatalLectureRecordAddReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.addPrenatalLectureRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询孕产期其他信息
	 * @param request
	 * @return
	 */
	public PrenatalSearchSelfRecordRespVo searchPrenatalSelfRecord(PrenatalSearchSelfRecordReqVo request) {
		PrenatalSearchSelfRecordRespVo respInfo = new PrenatalSearchSelfRecordRespVo();
		Map<String,Object> respMap = appPrenatalHandleService.searchPrenatalSelfRecord(BeanUtil.beanToMap(request));
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				//孕产期自我记录表
				AppPrenatalSelfRecordPO selfRecordInfo = (AppPrenatalSelfRecordPO) respMap.get("selfRecordInfo");
				if (null != selfRecordInfo) {
					if (null != selfRecordInfo.getLastMenses())
						respInfo.setLastMenses(StringUtil.valueOf(selfRecordInfo.getLastMenses().getTime()));
					if (null != selfRecordInfo.getPredictDate()) 
						respInfo.setPredictDate(StringUtil.valueOf(selfRecordInfo.getPredictDate().getTime()));
					if (null != selfRecordInfo.getFirstMoveDate()) 
						respInfo.setFirstMoveDate(StringUtil.valueOf(selfRecordInfo.getFirstMoveDate().getTime()));
					if (null != selfRecordInfo.getBExaDate()) 
						respInfo.setbExaDate(StringUtil.valueOf(selfRecordInfo.getBExaDate().getTime()));
					if (!StringUtil.isNullOrBlank(selfRecordInfo.getTestMoveSign()))
						respInfo.setTestMoveSign(selfRecordInfo.getTestMoveSign());
					if (!StringUtil.isNullOrBlank(selfRecordInfo.getGrowthRange()))
						respInfo.setGrowthRange(selfRecordInfo.getGrowthRange());
					if (!StringUtil.isNullOrBlank(selfRecordInfo.getRiskSign()))
						respInfo.setRiskSign(selfRecordInfo.getRiskSign());
					if (!StringUtil.isNullOrBlank(selfRecordInfo.getRiskRemark()))
						respInfo.setRiskRemark(selfRecordInfo.getRiskRemark());
					//点亮记录
					respInfo.setSpecialList(CommonAssembleSupport.assembleSearchPrenatalSelfRecord((List<AppPrenatalSelfRecordSpecialPO>) respMap.get("lightList")));
				}
				
			}
		}	
		return respInfo;
	}
	
	/**
	 * 保存孕产期其他信息记录
	 * @param request
	 * @return
	 */
	public BaseVo savePrenatalSelfRecord(PrenatalSelfRecordSaveReqVo request) {
		return BeanUtil.mapToBean(this.appPrenatalHandleService.savePrenatalSelfRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询孕产期妈妈的体重记录
	 * @param request
	 * @return
	 */
	public PrenatalSearchWeightRecordRespVo searchPrenatalWeightRecord(PrenatalSearchWeightRecordReqVo request) {
		PrenatalSearchWeightRecordRespVo respInfo = new PrenatalSearchWeightRecordRespVo();
		Map<String,Object> respMap = appPrenatalHandleService.searchPrenatalWeightRecord(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setPrenatalWeightList(CommonAssembleSupport.assembleSearchPrenatalWeightRecord((List<AppPrenatalWeightRecordPO>)respMap.get("weightList")));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询孕产期胎动记录
	 * @param request
	 * @return
	 */
	public PrenatalSearchFetalMovementRecordRespVo searchPrenatalFetalMovementRecord(PrenatalSearchFetalMovementRecordReqVo request) {
		PrenatalSearchFetalMovementRecordRespVo respInfo = new PrenatalSearchFetalMovementRecordRespVo();
		Map<String,Object> respMap = appPrenatalHandleService.searchPrenatalFetalMovementRecord(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setFetalMovementList(CommonAssembleSupport.assembleSearchPrenatalFetalMovementRecord((List<AppPrenatalFetalMovementRecordPO>)respMap.get("fetalMovementList")));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询孕产期妈妈听课记录
	 * @param request
	 * @return
	 */
	public PrenatalSearchLectureRecordRespVo searchPrenatalLectureRecord(PrenatalSearchLectureRecordReqVo request) {
		PrenatalSearchLectureRecordRespVo respInfo = new PrenatalSearchLectureRecordRespVo();
		Map<String,Object> respMap = appPrenatalHandleService.searchPrenatalLectureRecord(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setLectureRecordList(CommonAssembleSupport.assembleSearchPrenatalLectureRecord((List<AppPrenatalLectureRecordPO>)respMap.get("lectureList")));
			}
		}	
		return respInfo;
	}
}
