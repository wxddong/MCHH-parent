package com.threefiveninetong.mchh.appConfig.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appConfig.controller.support.AppConfigControllerSupport;
import com.threefiveninetong.mchh.appConfig.vo.req.DeviceTokenInfoReqVo;
import com.threefiveninetong.mchh.appConfig.vo.resp.LatestVersionInfoRespInfo;
import com.threefiveninetong.mchh.appConfig.vo.resp.UniformConfigInfoRespVo;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.DictionaryForApi;

@Controller
@RequestMapping("/api/")
public class AppConfigController {
	
	@Resource
	private AppConfigControllerSupport appConfigControllerSupport;
	
	/**
	 * 获取统一配置信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getUniformConfigInfo", method = RequestMethod.POST)
	public UniformConfigInfoRespVo getUniformConfigInfo(BaseReqVo request) {
		return appConfigControllerSupport.getUniformConfigInfo(request);
	}
	
	/**
	 * 获取最新版本信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getLatestVersionInfo", method = RequestMethod.POST)
	public LatestVersionInfoRespInfo getLatestVersionInfo(BaseReqVo request) {
		return appConfigControllerSupport.getLatestVersionInfo(request);
	}
	
	/**
	 * 获取iphone的deviceToken信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDeviceTokenInfo", method = RequestMethod.POST)
	public BaseVo getDeviceTokenInfo(@Valid DeviceTokenInfoReqVo request,BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appConfigControllerSupport.getDeviceTokenInfo(request);
	}
}
