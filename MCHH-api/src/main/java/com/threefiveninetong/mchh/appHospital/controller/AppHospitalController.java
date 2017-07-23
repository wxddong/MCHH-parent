package com.threefiveninetong.mchh.appHospital.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appHospital.controller.support.AppHospitalControllerSupport;
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
import com.threefiveninetong.mchh.appMember.vo.resp.MbrMessageVo;
import com.threefiveninetong.mchh.core.vo.BasePageVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.DictionaryForApi;
/**
 * 医院
 * @author zhanght
 */
@Controller
@RequestMapping("/api/")
public class AppHospitalController {
	
	@Resource
	private AppHospitalControllerSupport appHospitalControllerSupport;
	
	/**
	 * 会员关联医院
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/affiliatedHospital", method = RequestMethod.POST)
	public BaseVo affiliatedHospital(@Valid HospitalAffiliatedReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.affiliatedHospital(request);
	}
	
	/**
	 * 查询医院首页展示信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalFirstPageInfo", method = RequestMethod.POST)
	public HospitalSearchFirstPageInfoRespVo searchHospitalFirstPageInfo(@Valid HospitalSearchFirstPageInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			HospitalSearchFirstPageInfoRespVo vo = new HospitalSearchFirstPageInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchHospitalFirstPageInfo(request);
	}
	
	/**
	 * 查询医院特色服务信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalCharacteristicServiceInfo", method = RequestMethod.POST)
	public HospitalSearchCharacteristicServiceInfoRespVo searchCharacteristicServiceInfo(@Valid HospitalSearchCharacteristicServiceInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			HospitalSearchCharacteristicServiceInfoRespVo vo = new HospitalSearchCharacteristicServiceInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchCharacteristicServiceInfo(request);
	}
	
	/**
	 * 查询医院孕妇学校课程时间列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalSchoolCurriculumInfo", method = RequestMethod.POST)
	public HospitalSearchSchoolCurriculumInfoRespVo searchHospitalSchoolCurriculumInfo(@Valid HospitalSearchSchoolCurriculumInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			HospitalSearchSchoolCurriculumInfoRespVo vo = new HospitalSearchSchoolCurriculumInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchHospitalSchoolCurriculumInfo(request);
	}
	
	/**
	 * 查询医院孕妇学校课程信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalSchoolCurriculumInfo2", method = RequestMethod.POST)
	public HospitalSearchSchoolCurriculumInfo2RespVo searchHospitalSchoolCurriculumInfo2(@Valid HospitalSearchSchoolCurriculumInfo2ReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			HospitalSearchSchoolCurriculumInfo2RespVo vo = new HospitalSearchSchoolCurriculumInfo2RespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchHospitalSchoolCurriculumInfo2(request);
	}
	
	/**
	 * 查询医院详情信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalInfo", method = RequestMethod.POST)
	public HospitalSearchInfoRespVo searchHospitalInfo(@Valid HospitalSearchInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			HospitalSearchInfoRespVo vo = new HospitalSearchInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchHospitalInfo(request);
	}
	
	/**
	 * 查询会员的医院通知
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalMessage", method = RequestMethod.POST)
	public BasePageVo<MbrMessageVo> searchHospitalMessage(@Valid HospitalSearchMessageReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BasePageVo<MbrMessageVo> vo = new BasePageVo<MbrMessageVo>();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchHospitalMessage(request);
	}
	
	/**
	 * 查询会员的医院检查报告
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchHospitalReport", method = RequestMethod.POST)
	public BasePageVo<InspectionReportVo> searchHospitalReport(@Valid HospitalSearchReportReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BasePageVo<InspectionReportVo> vo = new BasePageVo<InspectionReportVo>();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appHospitalControllerSupport.searchHospitalReport(request);
	}
}
