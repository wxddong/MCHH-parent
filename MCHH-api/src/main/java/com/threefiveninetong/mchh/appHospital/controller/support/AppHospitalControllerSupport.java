package com.threefiveninetong.mchh.appHospital.controller.support;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.threefiveninetong.mchh.app.service.AppHospitalHandleService;
import com.threefiveninetong.mchh.appHospital.po.AppCharacteristicServiceInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppSchoolCurriculumInfoPO;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalAffiliatedReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchCharacteristicServiceInfoReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchFirstPageInfoReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchInfoReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchMessageReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchReportReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchSchoolCurriculumInfo2ReqVo;
import com.threefiveninetong.mchh.appHospital.vo.req.HospitalSearchSchoolCurriculumInfoReqVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchCharacteristicServiceInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchSchoolCurriculumInfo2RespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchSchoolCurriculumInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.InspectionReportVo;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appMember.vo.resp.MbrMessageVo;
import com.threefiveninetong.mchh.common.CommonAssembleSupport;
import com.threefiveninetong.mchh.core.vo.BasePageVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

@Component
public class AppHospitalControllerSupport {
	
	@Resource
	private AppHospitalHandleService appHospitalHandleService;
	
	/**
	 * 会员关联医院
	 * @param request
	 * @return
	 */
	public BaseVo affiliatedHospital(HospitalAffiliatedReqVo request) {
		return BeanUtil.mapToBean(appHospitalHandleService.affiliatedHospital(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询医院首页展示信息
	 * @param request
	 * @return
	 */
	public HospitalSearchFirstPageInfoRespVo searchHospitalFirstPageInfo(HospitalSearchFirstPageInfoReqVo request) {
		HospitalSearchFirstPageInfoRespVo respInfo = new HospitalSearchFirstPageInfoRespVo();
		Map<String,Object> respMap = appHospitalHandleService.searchHospitalFirstPageInfo(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				//医院基本信息
				AppHospitalInfoPO hospitalInfo = (AppHospitalInfoPO) respMap.get("hospitalInfo");
				respInfo.setHospitalId(hospitalInfo.getId());
				respInfo.setHospitalName(hospitalInfo.getHospitalName());
				respInfo.setTelephone(hospitalInfo.getTelephone());
				respInfo.setBigImageUrl(StringUtil.valueOf(respMap.get("serverUrl")) + hospitalInfo.getBigImageUrl());
				respInfo.setBrief(hospitalInfo.getBrief());
				
				//通知信息
				AppMbrMessageInfoPO msgInfo = (AppMbrMessageInfoPO) respMap.get("msgInfo");
				if (null != msgInfo) {
					respInfo.setTitle(msgInfo.getTitle());
					respInfo.setContent(msgInfo.getContent());
					respInfo.setReceiveTime(StringUtil.valueOf(msgInfo.getReceiveTime().getTime()));
				}
				
				//检查报告信息
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询医院特色服务信息
	 * @param request
	 * @return
	 */
	public HospitalSearchCharacteristicServiceInfoRespVo searchCharacteristicServiceInfo(HospitalSearchCharacteristicServiceInfoReqVo request) {
		HospitalSearchCharacteristicServiceInfoRespVo respInfo = new HospitalSearchCharacteristicServiceInfoRespVo();
		Map<String,Object> respMap = appHospitalHandleService.searchCharacteristicServiceInfo(request.getHospitalId(),request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setCharacteristicServiceList(CommonAssembleSupport.assembleSearchCharacteristicServiceInfo((List<AppCharacteristicServiceInfoPO>)respMap.get("characteristicServiceList"), StringUtil.valueOf(respMap.get("serverUrl"))));
			}
		}
		return respInfo;
	}
	
	/**
	 * 查询医院孕妇学校课程时间信息
	 * @param request
	 * @return
	 */
	public HospitalSearchSchoolCurriculumInfoRespVo searchHospitalSchoolCurriculumInfo(HospitalSearchSchoolCurriculumInfoReqVo request) {
		HospitalSearchSchoolCurriculumInfoRespVo respInfo = new HospitalSearchSchoolCurriculumInfoRespVo();
		Map<String,Object> respMap = appHospitalHandleService.searchHospitalSchoolCurriculumInfo(request.getHospitalId(),request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setCurriculumList((List<String>)respMap.get("curriculumList"));
			}
		}
		return respInfo;
	}
	
	/**
	 * 查询医院孕妇学校课程信息
	 * @param request
	 * @return
	 */
	public HospitalSearchSchoolCurriculumInfo2RespVo searchHospitalSchoolCurriculumInfo2(HospitalSearchSchoolCurriculumInfo2ReqVo request) {
		HospitalSearchSchoolCurriculumInfo2RespVo respInfo = new HospitalSearchSchoolCurriculumInfo2RespVo();
		Map<String,Object> respMap = appHospitalHandleService.searchHospitalSchoolCurriculumInfo2(request.getHospitalId(),request.getMemberId(),request.getDate());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				respInfo.setCurriculumList(CommonAssembleSupport.assembleSearchHospitalSchoolCurriculumInfo2((List<AppSchoolCurriculumInfoPO>)respMap.get("curriculumList")));
			}
		}
		return respInfo;
	}
	
	/**
	 * 查询医院详情信息
	 * @param request
	 * @return
	 */
	public HospitalSearchInfoRespVo searchHospitalInfo(HospitalSearchInfoReqVo request) {
		HospitalSearchInfoRespVo respInfo = new HospitalSearchInfoRespVo();
		Map<String,Object> respMap = appHospitalHandleService.searchHospitalInfo(request.getHospitalId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				AppHospitalInfoPO hospitalInfo = (AppHospitalInfoPO) respMap.get("hospitalInfo");
				if (null != hospitalInfo) {
					respInfo.setBigImageUrl(StringUtil.valueOf(respMap.get("serverUrl")) + hospitalInfo.getBigImageUrl());
					respInfo.setHospitalId(hospitalInfo.getId());
					respInfo.setHospitalName(hospitalInfo.getHospitalName());
					respInfo.setTelephone(hospitalInfo.getTelephone());
					respInfo.setBrief(hospitalInfo.getBrief());
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 查询会员的医院通知
	 * @param request
	 * @return
	 */
	public BasePageVo<MbrMessageVo> searchHospitalMessage(HospitalSearchMessageReqVo request) {
		BasePageVo<MbrMessageVo> respInfo = new BasePageVo<MbrMessageVo>();
		Map<String,Object> respMap = appHospitalHandleService.searchHospitalMessage(request.getHospitalId(),request.getMemberId(),request.getRows(),request.getPage());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				Page<AppMbrMessageInfoPO> page = (Page<AppMbrMessageInfoPO>)respMap.get("page");
				respInfo = new BasePageVo<MbrMessageVo>(page.getPage(), page.getRows(), page.getTotal(),CommonAssembleSupport.assembleSearchHospitalMessage(page.getList()));
			}
		}		
		return respInfo;
	}
	
	/**
	 * 查询会员的医院检查报告
	 * @param request
	 * @return
	 */
	public BasePageVo<InspectionReportVo> searchHospitalReport(HospitalSearchReportReqVo request) {
		return null;
	}
}
