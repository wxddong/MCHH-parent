package com.threefiveninetong.mchh.appConfig.controller.support;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.threefiveninetong.mchh.app.service.AppConfigHandleService;
import com.threefiveninetong.mchh.appConfig.po.AppVersionPO;
import com.threefiveninetong.mchh.appConfig.vo.req.DeviceTokenInfoReqVo;
import com.threefiveninetong.mchh.appConfig.vo.resp.LatestVersionInfoRespInfo;
import com.threefiveninetong.mchh.appConfig.vo.resp.UniformConfigInfoRespVo;
import com.threefiveninetong.mchh.common.CommonAssembleSupport;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.StringUtil;

@Component
public class AppConfigControllerSupport {
	
	@Resource
	private AppConfigHandleService appConfigHandleService;
	
	/**
	 * 获取统一配置信息
	 * @param request
	 * @return
	 */
	public UniformConfigInfoRespVo getUniformConfigInfo(BaseReqVo request) {
		UniformConfigInfoRespVo respInfo = new UniformConfigInfoRespVo();
		Map<String,Object> respMap = this.appConfigHandleService.getUniformConfigInfo(StringUtil.valueOf(request.getTerminalNo()));
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				//最新版本信息
				AppVersionPO versionInfo = (AppVersionPO) respMap.get("versionInfo");
				
				//版本信息
				respInfo.setVersionInfo(CommonAssembleSupport.assembleVersionVo(versionInfo));
				
				//广告图片地址
				respInfo.setImageUrl(StringUtil.valueOf(respMap.get("imageUrl")));
				
				//是否需要强制升级
				String forcedUpdateSign = (String) respMap.get("forcedUpdateSign");
				if (!StringUtil.isNullOrBlank(forcedUpdateSign)) {
					respInfo.setForcedUpdateSign(forcedUpdateSign);
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 获取最新版本信息
	 * @param request
	 * @return
	 */
	public LatestVersionInfoRespInfo getLatestVersionInfo(BaseReqVo request) {
		LatestVersionInfoRespInfo respInfo = new LatestVersionInfoRespInfo();
		Map<String,Object> respMap = this.appConfigHandleService.getLatestVersionInfo(request.getTerminalNo());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				AppVersionPO versionPO = (AppVersionPO) respMap.get("versionPO");
				//组装版本信息
				respInfo.setVersionInfo(CommonAssembleSupport.assembleVersionVo(versionPO));
			}
		}	
		return respInfo;
	}
	
	/**
	 * 获取iphone的deviceToken信息
	 * @param request
	 * @return
	 */
	public BaseVo getDeviceTokenInfo(DeviceTokenInfoReqVo request) {
		return BeanUtil.mapToBean(this.appConfigHandleService.getDeviceTokenInfo(request.getTerminalNo(), request.getDeviceToken()), BaseVo.class);
	}
}
