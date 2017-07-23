package com.threefiveninetong.mchh.appPrenatal.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appPrenatal.controller.support.AppPrenatalControllerSupport;
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
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.DictionaryForApi;
/**
 * 孕产期
 * @author zhanght
 */
@Controller
@RequestMapping("/api/")
public class AppPrenatalController {
	
	@Resource
	private AppPrenatalControllerSupport appPrenatalControllerSupport;
	
	/**
	 * 查询孕产期首页信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPrenatalFirstPageInfo", method = RequestMethod.POST)
	public PrenatalSearchFirstPageInfoRespVo searchPrenatalFirstPageInfo(@Valid PrenatalSearchFirstPageInfoReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalSearchFirstPageInfoRespVo vo = new PrenatalSearchFirstPageInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.searchPrenatalFirstPageInfo(request);
	}
	
	/**
	 * 添加孕产期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPrenatalBasicInfo", method = RequestMethod.POST)
	public PrenatalBasicInfoAddRespVo addPrenatalBasicInfo(@Valid PrenatalBasicInfoAddReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalBasicInfoAddRespVo vo = new PrenatalBasicInfoAddRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.addPrenatalBasicInfo(request);
	}
	
	/**
	 * 修改孕产期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePrenatalBasicInfo", method = RequestMethod.POST)
	public BaseVo updatePrenatalBasicInfo(@Valid PrenatalBasicInfoUpdateReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.updatePrenatalBasicInfo(request);
	}
	
	/**
	 * 查询孕产期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPrenatalBasicInfo", method = RequestMethod.POST)
	public PrenatalSearchBasicInfoRespVo searchPrenatalBasicInfo(@Valid PrenatalSearchBasicInfoReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalSearchBasicInfoRespVo vo = new PrenatalSearchBasicInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.searchPrenatalBasicInfo(request);
	}
	
	/**
	 * 添加孕产期体重记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPrenatalWeightRecord", method = RequestMethod.POST)
	public BaseVo addPrenatalWeightRecord(@Valid PrenatalWeightRecordAddReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.addPrenatalWeightRecord(request);
	}
	
	/**
	 * 添加孕产期胎动记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPrenatalFetalMovementRecord", method = RequestMethod.POST)
	public BaseVo addPrenatalFetalMovementRecord(@Valid PrenatalFetalMovementRecordAddReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.addPrenatalFetalMovementRecord(request);
	}
	
	/**
	 * 添加孕产期孕妇学校听课记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPrenatalLectureRecord", method = RequestMethod.POST)
	public BaseVo addPrenatalLectureRecord(@Valid PrenatalLectureRecordAddReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.addPrenatalLectureRecord(request);
	}
	
	/**
	 * 查询孕产期其他信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPrenatalSelfRecord", method = RequestMethod.POST)
	public PrenatalSearchSelfRecordRespVo searchPrenatalSelfRecord(@Valid PrenatalSearchSelfRecordReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalSearchSelfRecordRespVo vo = new PrenatalSearchSelfRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.searchPrenatalSelfRecord(request);
	}
	
	/**
	 * 保存孕产期其他信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePrenatalSelfRecord", method = RequestMethod.POST)
	public BaseVo savePrenatalSelfRecord(@Valid PrenatalSelfRecordSaveReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.savePrenatalSelfRecord(request);
	}
	
	/**
	 * 查询孕产期妈妈的体重记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPrenatalWeightRecord", method = RequestMethod.POST)
	public PrenatalSearchWeightRecordRespVo searchPrenatalWeightRecord(@Valid PrenatalSearchWeightRecordReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalSearchWeightRecordRespVo vo = new PrenatalSearchWeightRecordRespVo(	);
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.searchPrenatalWeightRecord(request);
	}
	
	/**
	 * 查询孕产期胎动记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPrenatalFetalMovementRecord", method = RequestMethod.POST)
	public PrenatalSearchFetalMovementRecordRespVo searchPrenatalFetalMovementRecord(@Valid PrenatalSearchFetalMovementRecordReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalSearchFetalMovementRecordRespVo vo = new PrenatalSearchFetalMovementRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.searchPrenatalFetalMovementRecord(request);
	}
	
	/**
	 * 查询孕产期妈妈听课记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPrenatalLectureRecord", method = RequestMethod.POST)
	public PrenatalSearchLectureRecordRespVo searchPrenatalLectureRecord(@Valid PrenatalSearchLectureRecordReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			PrenatalSearchLectureRecordRespVo vo = new PrenatalSearchLectureRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPrenatalControllerSupport.searchPrenatalLectureRecord(request);
	}
}
