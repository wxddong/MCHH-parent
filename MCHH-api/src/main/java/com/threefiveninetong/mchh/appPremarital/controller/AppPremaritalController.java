package com.threefiveninetong.mchh.appPremarital.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appPremarital.controller.support.AppPremaritalControllerSupport;
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
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.DictionaryForApi;
/**
 * 备孕期
 * @author zhanght
 */
@Controller
@RequestMapping("/api/")
public class AppPremaritalController {
	
	@Resource
	private AppPremaritalControllerSupport appPremaritalControllerSupport;
	
	/**
	 * 查询备孕期首页信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPremaritalFirstPageInfo", method = RequestMethod.POST)
	public PremaritalSearchFirstPageInfoRespVo searchPremaritalFirstPageInfo(PremaritalSearchFirstPageInfoReqVo request) {
		return appPremaritalControllerSupport.searchPremaritalFirstPageInfo(request);
	}
	
	/**
	 * 添加备孕期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPremaritalBasicInfo", method = RequestMethod.POST)
	public PremaritalBasicAddRespVo addPremaritalBasicInfo(@Valid PremaritalBasicAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PremaritalBasicAddRespVo vo = new PremaritalBasicAddRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.addPremaritalBasicInfo(request);
	}
	
	/**
	 * 修改备孕期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePremaritalBasicInfo", method = RequestMethod.POST)
	public BaseVo updatePremaritalBasicInfo(@Valid PremaritalBasicUpdateReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.updatePremaritalBasicInfo(request);
	}
	
	/**
	 * 查询备孕期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPremaritalBasicInfo", method = RequestMethod.POST)
	public PremaritalBasicSearchInfoRespVo searchPremaritalBasicInfo(@Valid PremaritalBasicSearchInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PremaritalBasicSearchInfoRespVo vo = new PremaritalBasicSearchInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.searchPremaritalBasicInfo(request);
	}
	
	/**
	 * 添加备孕期体重记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPremaritalWeightRecord", method = RequestMethod.POST)
	public BaseVo addPremaritalWeightRecord(@Valid PremaritalWeightRecordAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.addPremaritalWeightRecord(request);
	}
	
	/**
	 * 查询备孕期体温记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPremaritalTemperatureRecord", method = RequestMethod.POST)
	public PremaritalSearchTemperatureRecordRespVo searchPremaritalTemperatureRecord(@Valid PremaritalSearchTemperatureRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PremaritalSearchTemperatureRecordRespVo vo = new PremaritalSearchTemperatureRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.searchPremaritalTemperatureRecord(request);
	}
	
	/**
	 * 添加备孕期体温记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPremaritalTemperatureRecord", method = RequestMethod.POST)
	public BaseVo addPremaritalTemperatureRecord(@Valid PremaritalTemperatureRecordAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.addPremaritalTemperatureRecord(request);
	}
	
	/**
	 * 保存备孕期其他信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePremaritalOtherInfo", method = RequestMethod.POST)
	public BaseVo savePremaritalOtherInfo(@Valid PremaritalOtherInfoSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.savePremaritalOtherInfo(request);
	}
	
	/**
	 * 查询备孕期其他信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPremaritalOtherInfo", method = RequestMethod.POST)
	public PremaritalSearchOtherInfoRespVo searchPremaritalOtherInfo(@Valid PremaritalSearchOtherInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PremaritalSearchOtherInfoRespVo vo = new PremaritalSearchOtherInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.searchPremaritalOtherInfo(request);
	}
	
	/**
	 * 查询备孕期妈妈的体重记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPremaritalWeightRecord", method = RequestMethod.POST)
	public PremaritalSearchWeightRecordRespVo searchPremaritalWeightRecord(@Valid PremaritalSearchWeightRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PremaritalSearchWeightRecordRespVo vo = new PremaritalSearchWeightRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPremaritalControllerSupport.searchPremaritalWeightRecord(request);
	}
}
